package com.github.a.a;

import android.content.Context;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class b implements d {
    private static Context sApplicationContext;
    private static b sInstance = null;
    private static int sBlockThreshold = 2000;

    public static void init(Context context, b bVar, int i) {
        sApplicationContext = context;
        sInstance = bVar;
        sBlockThreshold = i;
    }

    public static b get() {
        if (sInstance == null) {
            throw new RuntimeException("BlockCanaryContext null");
        }
        return sInstance;
    }

    public Context provideContext() {
        return sApplicationContext;
    }

    public String provideQualifier() {
        return "unknown";
    }

    public String provideUid() {
        return "uid";
    }

    public String provideNetworkType() {
        return "unknown";
    }

    public int provideMonitorDuration() {
        return -1;
    }

    public int provideBlockThreshold() {
        return sBlockThreshold;
    }

    public int provideDumpInterval() {
        return provideBlockThreshold();
    }

    public String providePath() {
        return "/blockcanary/";
    }

    public boolean displayNotification() {
        return true;
    }

    public boolean zip(File[] fileArr, File file) {
        return false;
    }

    public void upload(File file) {
        throw new UnsupportedOperationException();
    }

    public List<String> concernPackages() {
        return null;
    }

    public boolean filterNonConcernStack() {
        return false;
    }

    public List<String> provideWhiteList() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("org.chromium");
        return linkedList;
    }

    public boolean deleteFilesInWhiteList() {
        return true;
    }

    @Override // com.github.a.a.d
    public void onBlock(Context context, com.github.a.a.a.a aVar) {
    }

    public boolean stopWhenDebugging() {
        return true;
    }
}
