package com.kwad.sdk.contentalliance;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.e.b;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes6.dex */
public abstract class b<T extends com.kwad.sdk.core.e.b> extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public Presenter f32743a;

    /* renamed from: b  reason: collision with root package name */
    public T f32744b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f32745c;

    public b(Context context) {
        super(context);
        this.f32745c = (ViewGroup) FrameLayout.inflate(getContext(), getLayoutId(), this);
    }

    public void a() {
        Presenter presenter = this.f32743a;
        if (presenter != null) {
            presenter.g();
        }
        this.f32745c = null;
    }

    public abstract T b();

    @NonNull
    public abstract Presenter c();

    @LayoutRes
    public abstract int getLayoutId();

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f32744b = b();
        if (this.f32743a == null) {
            Presenter c2 = c();
            this.f32743a = c2;
            c2.a((View) this.f32745c);
        }
        this.f32743a.a(this.f32744b);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        T t = this.f32744b;
        if (t != null) {
            t.a();
        }
        a();
    }
}
