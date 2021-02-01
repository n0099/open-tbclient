package com.kwad.sdk.core.e;

import android.view.View;
import androidx.annotation.NonNull;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.reward.a;
/* loaded from: classes3.dex */
public abstract class a<T extends com.kwad.sdk.reward.a> extends com.kwad.sdk.b.a {
    protected T mCallerContext;
    protected Presenter mPresenter;
    protected View mRootView;

    private void notifyOnCreate() {
        if (this.mCallerContext == null) {
            return;
        }
        for (com.kwad.sdk.reward.a.a aVar : this.mCallerContext.f10526a) {
            aVar.a();
        }
    }

    private void notifyOnDestroy() {
        if (this.mCallerContext == null) {
            return;
        }
        for (com.kwad.sdk.reward.a.a aVar : this.mCallerContext.f10526a) {
            aVar.d();
        }
    }

    private void notifyOnPause() {
        if (this.mCallerContext == null) {
            return;
        }
        for (com.kwad.sdk.reward.a.a aVar : this.mCallerContext.f10526a) {
            aVar.c();
        }
    }

    private void notifyOnResume() {
        if (this.mCallerContext == null) {
            return;
        }
        for (com.kwad.sdk.reward.a.a aVar : this.mCallerContext.f10526a) {
            aVar.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onActivityCreated(@NonNull View view) {
        this.mRootView = view;
        this.mCallerContext = onCreateCallerContext();
        if (this.mPresenter == null) {
            this.mPresenter = onCreatePresenter();
            this.mPresenter.a(this.mRootView);
        }
        this.mPresenter.a(this.mCallerContext);
        notifyOnCreate();
    }

    protected abstract T onCreateCallerContext();

    protected abstract Presenter onCreatePresenter();

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        notifyOnDestroy();
        if (this.mCallerContext != null) {
            this.mCallerContext.a();
        }
        if (this.mPresenter != null) {
            this.mPresenter.j();
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
