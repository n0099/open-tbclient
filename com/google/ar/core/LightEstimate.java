package com.google.ar.core;

import com.google.ar.core.exceptions.FatalException;
/* loaded from: classes6.dex */
public class LightEstimate {

    /* renamed from: a  reason: collision with root package name */
    public long f30940a;

    /* loaded from: classes6.dex */
    public enum State {
        NOT_VALID(0),
        VALID(1);
        
        public final int nativeCode;

        State(int i2) {
            this.nativeCode = i2;
        }

        public static State forNumber(int i2) {
            State[] values;
            for (State state : values()) {
                if (state.nativeCode == i2) {
                    return state;
                }
            }
            StringBuilder sb = new StringBuilder(66);
            sb.append("Unexpected value for native LightEstimate.State, value=");
            sb.append(i2);
            throw new FatalException(sb.toString());
        }
    }

    public LightEstimate() {
        this.f30940a = 0L;
        this.f30940a = 0L;
    }

    public static native long nativeCreateLightEstimate(long j);

    public static native void nativeDestroyLightEstimate(long j);

    private native void nativeGetColorCorrection(long j, long j2, float[] fArr, int i2);

    private native float nativeGetPixelIntensity(long j, long j2);

    private native int nativeGetState(long j, long j2);

    public void finalize() {
        long j = this.f30940a;
        if (j != 0) {
            nativeDestroyLightEstimate(j);
        }
        super.finalize();
    }
}
