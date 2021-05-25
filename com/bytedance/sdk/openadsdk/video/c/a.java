package com.bytedance.sdk.openadsdk.video.c;

import android.content.Context;
import android.view.Surface;
import android.view.SurfaceHolder;
/* loaded from: classes6.dex */
public abstract class a {

    /* renamed from: b  reason: collision with root package name */
    public Surface f30266b;

    /* renamed from: c  reason: collision with root package name */
    public SurfaceHolder f30267c;

    /* renamed from: g  reason: collision with root package name */
    public Context f30271g;

    /* renamed from: d  reason: collision with root package name */
    public boolean f30268d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f30269e = false;

    /* renamed from: f  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.video.b.a f30270f = null;

    /* renamed from: a  reason: collision with root package name */
    public InterfaceC0323a f30265a = null;

    /* renamed from: com.bytedance.sdk.openadsdk.video.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0323a {
    }

    public abstract void a();

    public abstract void a(int i2);

    public void a(Surface surface) {
        this.f30266b = surface;
    }

    public abstract void b();

    public void b(boolean z) {
        this.f30269e = z;
    }

    public abstract int c();

    public abstract long d();

    public void a(SurfaceHolder surfaceHolder) {
        this.f30267c = surfaceHolder;
    }

    public void a(boolean z) {
        this.f30268d = z;
    }

    public void a(com.bytedance.sdk.openadsdk.video.b.a aVar) {
        this.f30270f = aVar;
    }

    public void a(Context context) {
        this.f30271g = context;
    }

    public void a(InterfaceC0323a interfaceC0323a) {
        this.f30265a = interfaceC0323a;
    }
}
