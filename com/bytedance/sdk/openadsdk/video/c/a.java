package com.bytedance.sdk.openadsdk.video.c;

import android.content.Context;
import android.view.Surface;
import android.view.SurfaceHolder;
/* loaded from: classes6.dex */
public abstract class a {

    /* renamed from: b  reason: collision with root package name */
    public Surface f30337b;

    /* renamed from: c  reason: collision with root package name */
    public SurfaceHolder f30338c;

    /* renamed from: g  reason: collision with root package name */
    public Context f30342g;

    /* renamed from: d  reason: collision with root package name */
    public boolean f30339d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f30340e = false;

    /* renamed from: f  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.video.b.a f30341f = null;

    /* renamed from: a  reason: collision with root package name */
    public InterfaceC0322a f30336a = null;

    /* renamed from: com.bytedance.sdk.openadsdk.video.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0322a {
    }

    public abstract void a();

    public abstract void a(int i2);

    public void a(Surface surface) {
        this.f30337b = surface;
    }

    public abstract void b();

    public void b(boolean z) {
        this.f30340e = z;
    }

    public abstract int c();

    public abstract long d();

    public void a(SurfaceHolder surfaceHolder) {
        this.f30338c = surfaceHolder;
    }

    public void a(boolean z) {
        this.f30339d = z;
    }

    public void a(com.bytedance.sdk.openadsdk.video.b.a aVar) {
        this.f30341f = aVar;
    }

    public void a(Context context) {
        this.f30342g = context;
    }

    public void a(InterfaceC0322a interfaceC0322a) {
        this.f30336a = interfaceC0322a;
    }
}
