package com.bytedance.sdk.openadsdk.video.c;

import android.content.Context;
import android.view.Surface;
import android.view.SurfaceHolder;
/* loaded from: classes5.dex */
public abstract class a {

    /* renamed from: b  reason: collision with root package name */
    public Surface f30167b;

    /* renamed from: c  reason: collision with root package name */
    public SurfaceHolder f30168c;

    /* renamed from: g  reason: collision with root package name */
    public Context f30172g;

    /* renamed from: d  reason: collision with root package name */
    public boolean f30169d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f30170e = false;

    /* renamed from: f  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.video.b.a f30171f = null;

    /* renamed from: a  reason: collision with root package name */
    public InterfaceC0340a f30166a = null;

    /* renamed from: com.bytedance.sdk.openadsdk.video.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0340a {
    }

    public abstract void a();

    public abstract void a(int i);

    public void a(Surface surface) {
        this.f30167b = surface;
    }

    public abstract void b();

    public void b(boolean z) {
        this.f30170e = z;
    }

    public abstract int c();

    public abstract long d();

    public void a(SurfaceHolder surfaceHolder) {
        this.f30168c = surfaceHolder;
    }

    public void a(boolean z) {
        this.f30169d = z;
    }

    public void a(com.bytedance.sdk.openadsdk.video.b.a aVar) {
        this.f30171f = aVar;
    }

    public void a(Context context) {
        this.f30172g = context;
    }

    public void a(InterfaceC0340a interfaceC0340a) {
        this.f30166a = interfaceC0340a;
    }
}
