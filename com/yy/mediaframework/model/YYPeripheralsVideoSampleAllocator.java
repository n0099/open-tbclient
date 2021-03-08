package com.yy.mediaframework.model;

import android.annotation.SuppressLint;
import com.yy.mediaframework.utils.YMFLog;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentLinkedQueue;
@SuppressLint({"NewApi"})
/* loaded from: classes6.dex */
public class YYPeripheralsVideoSampleAllocator {
    private ConcurrentLinkedQueue<DecodeVideoSample> mFreeDeque = new ConcurrentLinkedQueue<>();
    private static volatile YYPeripheralsVideoSampleAllocator s_instance = null;
    private static Object mLock = new Object();

    static {
        instance();
    }

    public static YYPeripheralsVideoSampleAllocator instance() {
        if (s_instance == null) {
            synchronized (mLock) {
                if (s_instance == null) {
                    s_instance = new YYPeripheralsVideoSampleAllocator();
                }
            }
        }
        return s_instance;
    }

    private YYPeripheralsVideoSampleAllocator() {
        init(30);
    }

    public DecodeVideoSample alloc() {
        DecodeVideoSample decodeVideoSample;
        try {
            decodeVideoSample = this.mFreeDeque.poll();
        } catch (NoSuchElementException e) {
            YMFLog.info(this, "[Util    ]", "allocate sample buffer exception:" + e.toString());
            decodeVideoSample = null;
        }
        if (decodeVideoSample == null) {
            decodeVideoSample = newMediaSample();
            YMFLog.info(this, "[Util    ]", "alloc new sample size:" + this.mFreeDeque.size());
        }
        decodeVideoSample.addRef();
        return decodeVideoSample;
    }

    public void free(DecodeVideoSample decodeVideoSample) {
        YMFLog.debug(this, "[Util    ]", "free");
        resetSample(decodeVideoSample);
        this.mFreeDeque.add(decodeVideoSample);
        if (this.mFreeDeque.size() > 200) {
        }
    }

    private void resetSample(DecodeVideoSample decodeVideoSample) {
        decodeVideoSample.reset();
    }

    private DecodeVideoSample newMediaSample() {
        DecodeVideoSample decodeVideoSample = new DecodeVideoSample();
        resetSample(decodeVideoSample);
        return decodeVideoSample;
    }

    private void init(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.mFreeDeque.add(newMediaSample());
        }
    }
}
