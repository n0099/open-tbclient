package com.qq.e.comm.plugin.m;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
/* loaded from: classes15.dex */
public class a extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private InterfaceC1202a f12185a;

    /* renamed from: com.qq.e.comm.plugin.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public interface InterfaceC1202a {
        void a();

        void a(int i);

        void b();

        void c();

        void d();
    }

    public a(@NonNull Context context) {
        super(context);
    }

    public void a(InterfaceC1202a interfaceC1202a) {
        this.f12185a = interfaceC1202a;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f12185a != null) {
            this.f12185a.a();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f12185a != null) {
            this.f12185a.b();
        }
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        if (this.f12185a != null) {
            this.f12185a.d();
        }
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        if (this.f12185a != null) {
            this.f12185a.c();
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.f12185a != null) {
            this.f12185a.a(i);
        }
    }
}
