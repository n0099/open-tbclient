package com.ksad.lottie.e;

import com.baidu.mobstat.Config;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private final float f8007a;

    /* renamed from: b  reason: collision with root package name */
    private final float f8008b;

    public d() {
        this(1.0f, 1.0f);
    }

    public d(float f, float f2) {
        this.f8007a = f;
        this.f8008b = f2;
    }

    public float a() {
        return this.f8007a;
    }

    public float b() {
        return this.f8008b;
    }

    public String toString() {
        return a() + Config.EVENT_HEAT_X + b();
    }
}
