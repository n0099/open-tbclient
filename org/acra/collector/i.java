package org.acra.collector;

import org.acra.collector.MediaCodecListCollector;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public /* synthetic */ class i {
    static final /* synthetic */ int[] a = new int[MediaCodecListCollector.CodecType.values().length];

    static {
        try {
            a[MediaCodecListCollector.CodecType.AVC.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            a[MediaCodecListCollector.CodecType.H263.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            a[MediaCodecListCollector.CodecType.MPEG4.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            a[MediaCodecListCollector.CodecType.AAC.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
    }
}
