package com.bytedance.sdk.openadsdk.video.c;

import android.content.Context;
import android.view.Surface;
import android.view.SurfaceHolder;
/* loaded from: classes5.dex */
public abstract class a {

    /* renamed from: b  reason: collision with root package name */
    public Surface f30175b;

    /* renamed from: c  reason: collision with root package name */
    public SurfaceHolder f30176c;

    /* renamed from: g  reason: collision with root package name */
    public Context f30180g;

    /* renamed from: d  reason: collision with root package name */
    public boolean f30177d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f30178e = false;

    /* renamed from: f  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.video.b.a f30179f = null;

    /* renamed from: a  reason: collision with root package name */
    public InterfaceC0342a f30174a = null;

    /* renamed from: com.bytedance.sdk.openadsdk.video.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0342a {
    }

    public abstract void a();

    public abstract void a(int i);

    public void a(Surface surface) {
        this.f30175b = surface;
    }

    public abstract void b();

    public void b(boolean z) {
        this.f30178e = z;
    }

    public abstract int c();

    public abstract long d();

    public void a(SurfaceHolder surfaceHolder) {
        this.f30176c = surfaceHolder;
    }

    public void a(boolean z) {
        this.f30177d = z;
    }

    public void a(com.bytedance.sdk.openadsdk.video.b.a aVar) {
        this.f30179f = aVar;
    }

    public void a(Context context) {
        this.f30180g = context;
    }

    public void a(InterfaceC0342a interfaceC0342a) {
        this.f30174a = interfaceC0342a;
    }
}
