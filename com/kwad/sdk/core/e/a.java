package com.kwad.sdk.core.e;

import android.view.View;
import androidx.annotation.NonNull;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.reward.a;
/* loaded from: classes6.dex */
public abstract class a<T extends com.kwad.sdk.reward.a> extends com.kwad.sdk.b.a {
    public T mCallerContext;
    public Presenter mPresenter;
    public View mRootView;

    private void notifyOnCreate() {
        T t = this.mCallerContext;
        if (t == null) {
            return;
        }
        for (com.kwad.sdk.reward.a.a aVar : t.f36601a) {
            aVar.a();
        }
    }

    private void notifyOnDestroy() {
        T t = this.mCallerContext;
        if (t == null) {
            return;
        }
        for (com.kwad.sdk.reward.a.a aVar : t.f36601a) {
            aVar.d();
        }
    }

    private void notifyOnPause() {
        T t = this.mCallerContext;
        if (t == null) {
            return;
        }
        for (com.kwad.sdk.reward.a.a aVar : t.f36601a) {
            aVar.c();
        }
    }

    private void notifyOnResume() {
        T t = this.mCallerContext;
        if (t == null) {
            return;
        }
        for (com.kwad.sdk.reward.a.a aVar : t.f36601a) {
            aVar.b();
        }
    }

    public void onActivityCreated(@NonNull View view) {
        this.mRootView = view;
        this.mCallerContext = onCreateCallerContext();
        if (this.mPresenter == null) {
            Presenter onCreatePresenter = onCreatePresenter();
            this.mPresenter = onCreatePresenter;
            onCreatePresenter.a(this.mRootView);
        }
        this.mPresenter.a(this.mCallerContext);
        notifyOnCreate();
    }

    public abstract T onCreateCallerContext();

    public abstract Presenter onCreatePresenter();

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        notifyOnDestroy();
        T t = this.mCallerContext;
        if (t != null) {
            t.a();
        }
        Presenter presenter = this.mPresenter;
        if (presenter != null) {
            presenter.j();
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        notifyOnPause();
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        notifyOnResume();
    }
}
