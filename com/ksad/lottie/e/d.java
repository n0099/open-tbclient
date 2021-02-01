package com.ksad.lottie.e;

import com.baidu.mobstat.Config;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private final float f8009a;

    /* renamed from: b  reason: collision with root package name */
    private final float f8010b;

    public d() {
        this(1.0f, 1.0f);
    }

    public d(float f, float f2) {
        this.f8009a = f;
        this.f8010b = f2;
    }

    public float a() {
        return this.f8009a;
    }

    public float b() {
        return this.f8010b;
    }

    public String toString() {
        return a() + Config.EVENT_HEAT_X + b();
    }
}
