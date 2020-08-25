package com.google.ar.core;

import com.google.ar.core.exceptions.FatalException;
/* loaded from: classes11.dex */
public class LightEstimate {
    long nBU;

    private static native long nativeCreateLightEstimate(long j);

    private static native void nativeDestroyLightEstimate(long j);

    private native void nativeGetColorCorrection(long j, long j2, float[] fArr, int i);

    private native float nativeGetPixelIntensity(long j, long j2);

    private native int nativeGetState(long j, long j2);

    /* loaded from: classes11.dex */
    public enum State {
        NOT_VALID(0),
        VALID(1);
        
        final int nativeCode;

        State(int i) {
            this.nativeCode = i;
        }

        static State forNumber(int i) {
            State[] values;
            for (State state : values()) {
                if (state.nativeCode == i) {
                    return state;
                }
            }
            throw new FatalException(new StringBuilder(66).append("Unexpected value for native LightEstimate.State, value=").append(i).toString());
        }
    }

    protected void finalize() throws Throwable {
        if (this.nBU != 0) {
            nativeDestroyLightEstimate(this.nBU);
        }
        super.finalize();
    }
}
