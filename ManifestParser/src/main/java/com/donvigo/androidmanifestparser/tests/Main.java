package com.donvigo.androidmanifestparser.tests;

import java.util.Iterator;

import com.donvigo.androidmanifestparser.manifest.ActivityEntry;
import com.donvigo.androidmanifestparser.manifest.AndroidManifest;
import com.donvigo.androidmanifestparser.manifest.ApplicationEntry;

public class Main {

	public static void main(String[] args) {
		String filePath = args[0];
		System.out.println("Reading " + filePath);
		
		AndroidManifest manifest = AndroidManifest.getManifestFromXML(filePath);
		//AndroidManifest manifest = AndroidManifest.getManifestFromAPK(filePath);
		
		System.out.println("PackageName: " + manifest.getPackageName());
		
		if (manifest.getUsesSdk()!=null){
			System.out.println("MinSdkVersion: " + manifest.getUsesSdk().getMinSdkVersion());
			System.out.println("TargetSdkVersion: " + manifest.getUsesSdk().getTargetSdkVersion());
		}
		
		ApplicationEntry application = manifest.getApplication();
		
		System.out.println("Label: " + application.getLabel());
		
		System.out.println("Activities: " + application.getActivities());
		
		for (Iterator<ActivityEntry> iterator = application.getActivities().iterator(); iterator.hasNext();) {
			ActivityEntry entry = (ActivityEntry) iterator.next();
			System.out.println(entry.getName() + " - " + entry.getTheme());
		}
		
		ActivityEntry act = application.getActivity("com.donvigo.androidmanifestparser.MainActivity");
		System.out.println("Act is not null: " + act.getName());
		
		act = application.getActivity("com.donvigo.androidmanifestparser.ActivityNotExists");
		System.out.println("Act IS NULL");
		
	}
}
