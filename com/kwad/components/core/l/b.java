package com.kwad.components.core.l;

import androidx.annotation.CallSuper;
import com.kwad.components.core.l.a;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes10.dex */
public abstract class b<T extends a> extends com.kwad.components.core.proxy.c {
    public T mCallerContext;
    public Presenter mPresenter;

    public abstract T onCreateCallerContext();

    public abstract Presenter onCreatePresenter();

    private void notifyOnCreate() {
        T t = this.mCallerContext;
        if (t == null) {
            return;
        }
        for (com.kwad.components.core.l.a.a aVar : t.Mm) {
            aVar.fN();
        }
    }

    private void notifyOnDestroy() {
        T t = this.mCallerContext;
        if (t == null) {
            return;
        }
        for (com.kwad.components.core.l.a.a aVar : t.Mm) {
            aVar.fO();
        }
    }

    private void notifyOnPause() {
        T t = this.mCallerContext;
        if (t == null) {
            return;
        }
        for (com.kwad.components.core.l.a.a aVar : t.Mm) {
            aVar.d(this);
        }
    }

    private void notifyOnResume() {
        T t = this.mCallerContext;
        if (t == null) {
            return;
        }
        for (com.kwad.components.core.l.a.a aVar : t.Mm) {
            aVar.c(this);
        }
    }

    public void initMVP() {
        this.mCallerContext = onCreateCallerContext();
        if (this.mPresenter == null) {
            Presenter onCreatePresenter = onCreatePresenter();
            this.mPresenter = onCreatePresenter;
            onCreatePresenter.G(this.mRootView);
        }
        this.mPresenter.k(this.mCallerContext);
    }

    @Override // com.kwad.components.core.proxy.c
    @CallSuper
    public void onActivityCreate() {
        super.onActivityCreate();
        initMVP();
        notifyOnCreate();
    }

    @Override // com.kwad.components.core.proxy.c, com.kwad.sdk.api.proxy.IActivityProxy
    @CallSuper
    public void onDestroy() {
        super.onDestroy();
        notifyOnDestroy();
        T t = this.mCallerContext;
        if (t != null) {
            t.release();
        }
        Presenter presenter = this.mPresenter;
        if (presenter != null) {
            presenter.destroy();
        }
    }

    @Override // com.kwad.components.core.proxy.c, com.kwad.sdk.api.proxy.IActivityProxy
    @CallSuper
    public void onPause() {
        super.onPause();
        notifyOnPause();
    }

    @Override // com.kwad.components.core.proxy.c, com.kwad.sdk.api.proxy.IActivityProxy
    @CallSuper
    public void onResume() {
        super.onResume();
        notifyOnResume();
    }
}
