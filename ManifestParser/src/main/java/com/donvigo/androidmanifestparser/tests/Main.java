package com.donvigo.androidmanifestparser.tests;

import java.util.Iterator;

import com.donvigo.androidmanifestparser.manifest.ActivityEntry;
import com.donvigo.androidmanifestparser.manifest.AndroidManifest;

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
		/*
		System.out.println("Label: " + manifest.getApplication().getLabel());
		
		System.out.println("Activities: " + manifest.getApplication().getActivities());
		
		for (Iterator<ActivityEntry> iterator = manifest.getApplication().getActivities().iterator(); iterator.hasNext();) {
			ActivityEntry entry = (ActivityEntry) iterator.next();
			System.out.println(entry.getName() + " - " + entry.getTheme());
			
		}
		*/
	}
}
