package com.googlecode.mp4parser.h264.model;

import java.util.Arrays;
/* loaded from: classes5.dex */
public class ScalingMatrix {
    public ScalingList[] ScalingList4x4;
    public ScalingList[] ScalingList8x8;

    public String toString() {
        return "ScalingMatrix{ScalingList4x4=" + (this.ScalingList4x4 == null ? null : Arrays.asList(this.ScalingList4x4)) + "\n, ScalingList8x8=" + (this.ScalingList8x8 != null ? Arrays.asList(this.ScalingList8x8) : null) + "\n}";
    }
}
