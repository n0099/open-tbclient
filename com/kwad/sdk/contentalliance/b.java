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
    public Presenter f31988a;

    /* renamed from: b  reason: collision with root package name */
    public T f31989b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f31990c;

    public b(Context context) {
        super(context);
        this.f31990c = (ViewGroup) FrameLayout.inflate(getContext(), getLayoutId(), this);
    }

    public void a() {
        Presenter presenter = this.f31988a;
        if (presenter != null) {
            presenter.g();
        }
        this.f31990c = null;
    }

    public abstract T b();

    @NonNull
    public abstract Presenter c();

    @LayoutRes
    public abstract int getLayoutId();

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f31989b = b();
        if (this.f31988a == null) {
            Presenter c2 = c();
            this.f31988a = c2;
            c2.a((View) this.f31990c);
        }
        this.f31988a.a(this.f31989b);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        T t = this.f31989b;
        if (t != null) {
            t.a();
        }
        a();
    }
}
