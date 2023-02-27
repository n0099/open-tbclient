package com.kwad.components.core.g;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.mvp.a;
/* loaded from: classes8.dex */
public abstract class c<T extends com.kwad.sdk.mvp.a> extends FrameLayout {
    public T EH;
    public ViewGroup iB;
    public Presenter mPresenter;

    public c(Context context) {
        super(context);
    }

    private void onActivityDestroy() {
        Presenter presenter = this.mPresenter;
        if (presenter != null) {
            presenter.destroy();
        }
        this.iB = null;
    }

    @LayoutRes
    public abstract int getLayoutId();

    public abstract ViewGroup jt();

    public abstract T jv();

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.EH = jv();
        if (this.mPresenter == null) {
            this.mPresenter = onCreatePresenter();
            if (this.iB == null) {
                this.iB = jt();
            }
            this.mPresenter.B(this.iB);
        }
        this.mPresenter.e(this.EH);
    }

    @NonNull
    public abstract Presenter onCreatePresenter();

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        T t = this.EH;
        if (t != null) {
            t.release();
        }
        onActivityDestroy();
    }
}
