package com.ksad.lottie.e;

import com.baidu.mobstat.Config;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private final float f5354a;
    private final float b;

    public d() {
        this(1.0f, 1.0f);
    }

    public d(float f, float f2) {
        this.f5354a = f;
        this.b = f2;
    }

    public float a() {
        return this.f5354a;
    }

    public float b() {
        return this.b;
    }

    public String toString() {
        return a() + Config.EVENT_HEAT_X + b();
    }
}
