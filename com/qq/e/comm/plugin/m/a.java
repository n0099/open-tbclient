package com.qq.e.comm.plugin.m;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
/* loaded from: classes4.dex */
public class a extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private InterfaceC1213a f12483a;

    /* renamed from: com.qq.e.comm.plugin.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1213a {
        void a();

        void a(int i);

        void b();

        void c();

        void d();
    }

    public a(@NonNull Context context) {
        super(context);
    }

    public void a(InterfaceC1213a interfaceC1213a) {
        this.f12483a = interfaceC1213a;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f12483a != null) {
            this.f12483a.a();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f12483a != null) {
            this.f12483a.b();
        }
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        if (this.f12483a != null) {
            this.f12483a.d();
        }
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        if (this.f12483a != null) {
            this.f12483a.c();
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.f12483a != null) {
            this.f12483a.a(i);
        }
    }
}
