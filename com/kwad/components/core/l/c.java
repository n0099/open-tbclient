package com.kwad.components.core.l;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import com.kwad.sdk.m.l;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.mvp.a;
import com.kwad.sdk.widget.KSFrameLayout;
/* loaded from: classes10.dex */
public abstract class c<T extends com.kwad.sdk.mvp.a> extends KSFrameLayout {
    public T Mo;
    public ViewGroup lC;
    public Presenter mPresenter;

    @LayoutRes
    public abstract int getLayoutId();

    public abstract void initData();

    public boolean kn() {
        return false;
    }

    public abstract void kp();

    public abstract T kr();

    @NonNull
    public abstract Presenter onCreatePresenter();

    public c(Context context) {
        this(context, null);
    }

    public c(Context context, AttributeSet attributeSet) {
        this(context, null, 0);
    }

    public c(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, 0);
        if (!kn()) {
            oz();
        }
    }

    private void initMVP() {
        this.Mo = kr();
        if (this.mPresenter == null) {
            Presenter onCreatePresenter = onCreatePresenter();
            this.mPresenter = onCreatePresenter;
            onCreatePresenter.G(this.lC);
        }
        this.mPresenter.k(this.Mo);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void ac() {
        super.ac();
        initMVP();
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void ad() {
        super.ad();
        T t = this.Mo;
        if (t != null) {
            t.release();
        }
        Presenter presenter = this.mPresenter;
        if (presenter != null) {
            presenter.destroy();
        }
    }

    public final void oz() {
        initData();
        this.lC = (ViewGroup) l.inflate(getContext(), getLayoutId(), this);
        kp();
    }
}
