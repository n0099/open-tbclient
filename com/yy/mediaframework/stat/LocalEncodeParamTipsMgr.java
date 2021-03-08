package com.yy.mediaframework.stat;

import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class LocalEncodeParamTipsMgr {
    private volatile LocalEncodeParamTipsMgr singleton;
    private WeakReference<IEncodeParamListener> mParamListenerRef = new WeakReference<>(null);
    private String mBasicParam = "";
    private AtomicBoolean mHasBFrame = new AtomicBoolean(false);
    private int mCodeRateKbps = 0;

    public void setParamListener(IEncodeParamListener iEncodeParamListener) {
        this.mParamListenerRef = new WeakReference<>(iEncodeParamListener);
    }

    public void setHasBFrame(boolean z) {
        if (this.mHasBFrame.getAndSet(z) != z) {
            notifyParamChanged();
        }
    }

    public void setCodeRate(int i) {
        boolean z = false;
        synchronized (this) {
            if (this.mCodeRateKbps != i) {
                this.mCodeRateKbps = i;
                z = true;
            }
        }
        if (z) {
            notifyParamChanged();
        }
    }

    public void setEncoderParam(String str) {
        synchronized (this) {
            this.mBasicParam = str;
            this.mHasBFrame.set(false);
            this.mCodeRateKbps = 0;
        }
        notifyParamChanged();
    }

    public void setNoEncoder() {
        synchronized (this) {
            this.mBasicParam = "no encode";
            this.mHasBFrame.set(false);
            this.mCodeRateKbps = 0;
        }
    }

    public String getParam() {
        StringBuilder sb = new StringBuilder();
        synchronized (this) {
            sb.append(this.mBasicParam);
            if (this.mHasBFrame.get()) {
                sb.append(":haveBFrame:true");
            }
            if (this.mCodeRateKbps != 0) {
                sb.append(":realCodeRate:").append(this.mCodeRateKbps).append("kbps");
            }
        }
        return sb.toString();
    }

    private void notifyParamChanged() {
        IEncodeParamListener iEncodeParamListener = this.mParamListenerRef.get();
        if (iEncodeParamListener != null) {
            iEncodeParamListener.encodeParamChanged(getParam());
        }
    }
}
