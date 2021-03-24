package com.bytedance.sdk.openadsdk.video.c;

import android.content.Context;
import android.view.Surface;
import android.view.SurfaceHolder;
/* loaded from: classes6.dex */
public abstract class a {

    /* renamed from: b  reason: collision with root package name */
    public Surface f30481b;

    /* renamed from: c  reason: collision with root package name */
    public SurfaceHolder f30482c;

    /* renamed from: g  reason: collision with root package name */
    public Context f30486g;

    /* renamed from: d  reason: collision with root package name */
    public boolean f30483d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f30484e = false;

    /* renamed from: f  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.video.b.a f30485f = null;

    /* renamed from: a  reason: collision with root package name */
    public InterfaceC0337a f30480a = null;

    /* renamed from: com.bytedance.sdk.openadsdk.video.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0337a {
    }

    public abstract void a();

    public abstract void a(int i);

    public void a(Surface surface) {
        this.f30481b = surface;
    }

    public abstract void b();

    public void b(boolean z) {
        this.f30484e = z;
    }

    public abstract int c();

    public abstract long d();

    public void a(SurfaceHolder surfaceHolder) {
        this.f30482c = surfaceHolder;
    }

    public void a(boolean z) {
        this.f30483d = z;
    }

    public void a(com.bytedance.sdk.openadsdk.video.b.a aVar) {
        this.f30485f = aVar;
    }

    public void a(Context context) {
        this.f30486g = context;
    }

    public void a(InterfaceC0337a interfaceC0337a) {
        this.f30480a = interfaceC0337a;
    }
}
