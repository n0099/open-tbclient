package com.bytedance.sdk.openadsdk.video.c;

import android.content.Context;
import android.view.Surface;
import android.view.SurfaceHolder;
/* loaded from: classes5.dex */
public abstract class a {

    /* renamed from: b  reason: collision with root package name */
    public Surface f31092b;

    /* renamed from: c  reason: collision with root package name */
    public SurfaceHolder f31093c;

    /* renamed from: g  reason: collision with root package name */
    public Context f31097g;

    /* renamed from: d  reason: collision with root package name */
    public boolean f31094d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f31095e = false;

    /* renamed from: f  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.video.b.a f31096f = null;

    /* renamed from: a  reason: collision with root package name */
    public InterfaceC0335a f31091a = null;

    /* renamed from: com.bytedance.sdk.openadsdk.video.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0335a {
    }

    public abstract void a();

    public abstract void a(int i2);

    public void a(Surface surface) {
        this.f31092b = surface;
    }

    public abstract void b();

    public void b(boolean z) {
        this.f31095e = z;
    }

    public abstract int c();

    public abstract long d();

    public void a(SurfaceHolder surfaceHolder) {
        this.f31093c = surfaceHolder;
    }

    public void a(boolean z) {
        this.f31094d = z;
    }

    public void a(com.bytedance.sdk.openadsdk.video.b.a aVar) {
        this.f31096f = aVar;
    }

    public void a(Context context) {
        this.f31097g = context;
    }

    public void a(InterfaceC0335a interfaceC0335a) {
        this.f31091a = interfaceC0335a;
    }
}
