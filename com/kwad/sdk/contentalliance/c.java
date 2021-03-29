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
public abstract class c<T extends com.kwad.sdk.core.e.b> extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public Presenter f31917a;

    /* renamed from: b  reason: collision with root package name */
    public T f31918b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f31919c;

    public c(Context context) {
        super(context);
        this.f31919c = (ViewGroup) FrameLayout.inflate(getContext(), getLayoutId(), this);
    }

    public void a() {
        Presenter presenter = this.f31917a;
        if (presenter != null) {
            presenter.j();
        }
        this.f31919c = null;
    }

    public abstract T b();

    @NonNull
    public abstract Presenter c();

    @LayoutRes
    public abstract int getLayoutId();

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f31918b = b();
        if (this.f31917a == null) {
            Presenter c2 = c();
            this.f31917a = c2;
            c2.a((View) this.f31919c);
        }
        this.f31917a.a(this.f31918b);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        T t = this.f31918b;
        if (t != null) {
            t.a();
        }
        a();
    }
}
