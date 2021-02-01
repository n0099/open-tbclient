package com.yy.mediaframework.model;

import android.annotation.SuppressLint;
import java.util.concurrent.ConcurrentLinkedQueue;
@SuppressLint({"NewApi"})
/* loaded from: classes4.dex */
public class YYMediaSampleAlloc {
    private ConcurrentLinkedQueue<YYMediaSample> mFreeDeque = new ConcurrentLinkedQueue<>();
    private static volatile YYMediaSampleAlloc s_instance = null;
    private static Object mLock = new Object();

    static {
        instance();
    }

    public static YYMediaSampleAlloc instance() {
        if (s_instance == null) {
            synchronized (mLock) {
                if (s_instance == null) {
                    s_instance = new YYMediaSampleAlloc();
                }
            }
        }
        return s_instance;
    }

    private YYMediaSampleAlloc() {
    }

    public YYMediaSample alloc() {
        return newMediaSample();
    }

    private YYMediaSample newMediaSample() {
        YYMediaSample yYMediaSample = new YYMediaSample();
        resetSample(yYMediaSample);
        return yYMediaSample;
    }

    private void resetSample(YYMediaSample yYMediaSample) {
        yYMediaSample.reset();
    }

    public void free(YYMediaSample yYMediaSample) {
    }

    private void init(int i) {
    }
}
