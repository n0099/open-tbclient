package com.kwad.sdk.core.e;

import android.view.View;
import androidx.annotation.NonNull;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.reward.a;
/* loaded from: classes4.dex */
public abstract class a<T extends com.kwad.sdk.reward.a> extends com.kwad.sdk.h.a {
    public T mCallerContext;
    public Presenter mPresenter;
    public View mRootView;

    private void notifyOnCreate() {
        T t = this.mCallerContext;
        if (t == null) {
            return;
        }
        for (com.kwad.sdk.reward.a.a aVar : t.a) {
            aVar.a(this);
        }
    }

    private void notifyOnDestroy() {
        T t = this.mCallerContext;
        if (t == null) {
            return;
        }
        for (com.kwad.sdk.reward.a.a aVar : t.a) {
            aVar.d(this);
        }
    }

    private void notifyOnPause() {
        T t = this.mCallerContext;
        if (t == null) {
            return;
        }
        for (com.kwad.sdk.reward.a.a aVar : t.a) {
            aVar.c(this);
        }
    }

    private void notifyOnResume() {
        T t = this.mCallerContext;
        if (t == null) {
            return;
        }
        for (com.kwad.sdk.reward.a.a aVar : t.a) {
            aVar.b(this);
        }
    }

    public void onActivityCreated(@NonNull View view) {
        this.mRootView = view;
        this.mCallerContext = onCreateCallerContext();
        if (this.mPresenter == null) {
            Presenter onCreatePresenter = onCreatePresenter();
            this.mPresenter = onCreatePresenter;
            onCreatePresenter.c(this.mRootView);
        }
        this.mPresenter.a(this.mCallerContext);
        notifyOnCreate();
    }

    public abstract T onCreateCallerContext();

    public abstract Presenter onCreatePresenter();

    @Override // com.kwad.sdk.h.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        notifyOnDestroy();
        T t = this.mCallerContext;
        if (t != null) {
            t.a();
        }
        Presenter presenter = this.mPresenter;
        if (presenter != null) {
            presenter.k();
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        notifyOnPause();
    }

    @Override // com.kwad.sdk.h.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        super.onResume();
        notifyOnResume();
    }
}
