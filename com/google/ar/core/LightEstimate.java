package com.google.ar.core;

import com.google.ar.core.exceptions.FatalException;
/* loaded from: classes10.dex */
public class LightEstimate {
    public long a;

    public static native long nativeCreateLightEstimate(long j);

    public static native void nativeDestroyLightEstimate(long j);

    private native void nativeGetColorCorrection(long j, long j2, float[] fArr, int i);

    private native float nativeGetPixelIntensity(long j, long j2);

    private native int nativeGetState(long j, long j2);

    public LightEstimate() {
        this.a = 0L;
        this.a = 0L;
    }

    public void finalize() {
        long j = this.a;
        if (j != 0) {
            nativeDestroyLightEstimate(j);
        }
        super.finalize();
    }

    /* loaded from: classes10.dex */
    public enum State {
        NOT_VALID(0),
        VALID(1);
        
        public final int nativeCode;

        State(int i) {
            this.nativeCode = i;
        }

        public static State forNumber(int i) {
            State[] values;
            for (State state : values()) {
                if (state.nativeCode == i) {
                    return state;
                }
            }
            StringBuilder sb = new StringBuilder(66);
            sb.append("Unexpected value for native LightEstimate.State, value=");
            sb.append(i);
            throw new FatalException(sb.toString());
        }
    }
}
