package com.yy.transvod.downloader.impl;

import com.baidu.tieba.h0c;
import java.util.TreeMap;
/* loaded from: classes10.dex */
public class MediaDownloaderImpl extends h0c {
    private native String nativeCheckVideoCachePath(String str);

    public static native void nativeClassInit();

    public static native long nativeGenerateDownloadTaskId();

    private native void nativeRelease();

    private native void nativeRemoveCache(String str, boolean z);

    private native void nativeSetNetState(int i);

    private native void nativeSetup(String str);

    private native void nativeStartDownloadMedia(String str, long j, long j2, long j3, int i, int i2, int i3, long j4, TreeMap<String, String> treeMap);

    private native void nativeStopDownloadMedia(long j, String str);
}
