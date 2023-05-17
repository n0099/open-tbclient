package com.kwad.components.core.g;

import android.view.View;
import androidx.annotation.NonNull;
import com.kwad.components.core.g.a;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes9.dex */
public abstract class b<T extends a> extends com.kwad.components.core.i.a {
    public T mCallerContext;
    public Presenter mPresenter;
    public View mRootView;

    private void notifyOnCreate() {
        T t = this.mCallerContext;
        if (t == null) {
            return;
        }
        for (com.kwad.components.core.g.kwai.a aVar : t.EF) {
            aVar.iK();
        }
    }

    private void notifyOnDestroy() {
        T t = this.mCallerContext;
        if (t == null) {
            return;
        }
        for (com.kwad.components.core.g.kwai.a aVar : t.EF) {
            aVar.iN();
        }
    }

    private void notifyOnPause() {
        T t = this.mCallerContext;
        if (t == null) {
            return;
        }
        for (com.kwad.components.core.g.kwai.a aVar : t.EF) {
            aVar.iM();
        }
    }

    private void notifyOnResume() {
        T t = this.mCallerContext;
        if (t == null) {
            return;
        }
        for (com.kwad.components.core.g.kwai.a aVar : t.EF) {
            aVar.iL();
        }
    }

    public void onActivityCreated(@NonNull View view2) {
        this.mRootView = view2;
        this.mCallerContext = onCreateCallerContext();
        if (this.mPresenter == null) {
            Presenter onCreatePresenter = onCreatePresenter();
            this.mPresenter = onCreatePresenter;
            onCreatePresenter.B(this.mRootView);
        }
        this.mPresenter.e(this.mCallerContext);
        notifyOnCreate();
    }

    public abstract T onCreateCallerContext();

    public abstract Presenter onCreatePresenter();

    @Override // com.kwad.components.core.i.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
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

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        notifyOnPause();
    }

    @Override // com.kwad.components.core.i.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        super.onResume();
        notifyOnResume();
    }
}
