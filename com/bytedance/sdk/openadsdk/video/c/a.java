package com.bytedance.sdk.openadsdk.video.c;

import android.content.Context;
import android.view.Surface;
import android.view.SurfaceHolder;
/* loaded from: classes6.dex */
public abstract class a {

    /* renamed from: b  reason: collision with root package name */
    public Surface f30369b;

    /* renamed from: c  reason: collision with root package name */
    public SurfaceHolder f30370c;

    /* renamed from: g  reason: collision with root package name */
    public Context f30374g;

    /* renamed from: d  reason: collision with root package name */
    public boolean f30371d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f30372e = false;

    /* renamed from: f  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.video.b.a f30373f = null;

    /* renamed from: a  reason: collision with root package name */
    public InterfaceC0325a f30368a = null;

    /* renamed from: com.bytedance.sdk.openadsdk.video.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0325a {
    }

    public abstract void a();

    public abstract void a(int i2);

    public void a(Surface surface) {
        this.f30369b = surface;
    }

    public abstract void b();

    public void b(boolean z) {
        this.f30372e = z;
    }

    public abstract int c();

    public abstract long d();

    public void a(SurfaceHolder surfaceHolder) {
        this.f30370c = surfaceHolder;
    }

    public void a(boolean z) {
        this.f30371d = z;
    }

    public void a(com.bytedance.sdk.openadsdk.video.b.a aVar) {
        this.f30373f = aVar;
    }

    public void a(Context context) {
        this.f30374g = context;
    }

    public void a(InterfaceC0325a interfaceC0325a) {
        this.f30368a = interfaceC0325a;
    }
}
