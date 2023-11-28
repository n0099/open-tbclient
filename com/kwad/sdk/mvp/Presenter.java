package com.kwad.sdk.mvp;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.kwad.sdk.m.l;
import com.kwad.sdk.service.c;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes10.dex */
public class Presenter {
    public Object aId;
    public View mRootView;
    public final List<Presenter> aIc = new CopyOnWriteArrayList();
    public PresenterState aIe = PresenterState.INIT;

    public void aj() {
    }

    public void onCreate() {
    }

    public void onDestroy() {
    }

    public void onUnbind() {
    }

    private boolean HS() {
        if (this.aIe.index() >= PresenterState.CREATE.index()) {
            return true;
        }
        return false;
    }

    private boolean isBound() {
        if (this.aIe == PresenterState.BIND) {
            return true;
        }
        return false;
    }

    public final List<Presenter> HT() {
        return this.aIc;
    }

    public final Object HU() {
        return this.aId;
    }

    @UiThread
    public final void destroy() {
        if (this.aIe == PresenterState.BIND) {
            lP();
        }
        this.aIe = PresenterState.DESTROY;
        onDestroy();
        this.aIe.performCallState(this);
    }

    @Nullable
    @UiThread
    public final Activity getActivity() {
        return l.m186do(getContext());
    }

    @NonNull
    public final Context getContext() {
        return this.mRootView.getContext();
    }

    public final View getRootView() {
        return this.mRootView;
    }

    @UiThread
    public final void lP() {
        this.aIe = PresenterState.UNBIND;
        onUnbind();
        this.aIe.performCallState(this);
    }

    /* loaded from: classes10.dex */
    public enum PresenterState {
        INIT(0) { // from class: com.kwad.sdk.mvp.Presenter.PresenterState.1
            @Override // com.kwad.sdk.mvp.Presenter.PresenterState
            public final void performCallState(Presenter presenter) {
            }
        },
        CREATE(1) { // from class: com.kwad.sdk.mvp.Presenter.PresenterState.2
            @Override // com.kwad.sdk.mvp.Presenter.PresenterState
            public final void performCallState(Presenter presenter) {
                for (Presenter presenter2 : presenter.aIc) {
                    try {
                        presenter2.G(presenter.mRootView);
                    } catch (Exception e) {
                        c.gatherException(e);
                        com.kwad.sdk.core.e.c.printStackTrace(e);
                    }
                }
            }
        },
        BIND(2) { // from class: com.kwad.sdk.mvp.Presenter.PresenterState.3
            @Override // com.kwad.sdk.mvp.Presenter.PresenterState
            public final void performCallState(Presenter presenter) {
                for (Presenter presenter2 : presenter.aIc) {
                    try {
                        presenter2.k(presenter.aId);
                    } catch (Throwable th) {
                        c.gatherException(th);
                        com.kwad.sdk.core.e.c.printStackTrace(th);
                    }
                }
            }
        },
        UNBIND(3) { // from class: com.kwad.sdk.mvp.Presenter.PresenterState.4
            @Override // com.kwad.sdk.mvp.Presenter.PresenterState
            public final void performCallState(Presenter presenter) {
                for (Presenter presenter2 : presenter.aIc) {
                    try {
                        presenter2.lP();
                    } catch (Exception e) {
                        c.gatherException(e);
                        com.kwad.sdk.core.e.c.printStackTrace(e);
                    }
                }
            }
        },
        DESTROY(4) { // from class: com.kwad.sdk.mvp.Presenter.PresenterState.5
            @Override // com.kwad.sdk.mvp.Presenter.PresenterState
            public final void performCallState(Presenter presenter) {
                for (Presenter presenter2 : presenter.aIc) {
                    try {
                        presenter2.destroy();
                    } catch (Exception e) {
                        c.gatherException(e);
                        com.kwad.sdk.core.e.c.printStackTrace(e);
                    }
                }
            }
        };
        
        public int mIndex;

        public abstract void performCallState(Presenter presenter);

        PresenterState(int i) {
            this.mIndex = i;
        }

        public int index() {
            return this.mIndex;
        }
    }

    private void b(Presenter presenter) {
        Object obj;
        View view2;
        if (this.aIe.index() < PresenterState.UNBIND.index() && presenter.aIe.index() < PresenterState.UNBIND.index()) {
            if (HS() && !presenter.HS() && (view2 = this.mRootView) != null) {
                presenter.G(view2);
            }
            if (isBound() && presenter.HS() && !presenter.isBound() && (obj = this.aId) != null) {
                presenter.k(obj);
            }
        }
    }

    @UiThread
    public final void G(View view2) {
        this.aIe = PresenterState.CREATE;
        this.mRootView = view2;
        onCreate();
        this.aIe.performCallState(this);
    }

    public final void a(Presenter presenter) {
        this.aIc.add(presenter);
        if (HS() && !presenter.HS()) {
            G(this.mRootView);
        }
    }

    public final <T extends View> T findViewById(int i) {
        return (T) this.mRootView.findViewById(i);
    }

    @UiThread
    public final void k(@NonNull Object obj) {
        if (this.aIe != PresenterState.INIT) {
            PresenterState presenterState = PresenterState.DESTROY;
        }
        if (this.aIe == PresenterState.BIND) {
            lP();
        }
        this.aIe = PresenterState.BIND;
        this.aId = obj;
        aj();
        this.aIe.performCallState(this);
    }

    public final void a(Presenter presenter, boolean z) {
        this.aIc.add(presenter);
        try {
            b(presenter);
        } catch (Throwable th) {
            c.gatherException(th);
            com.kwad.sdk.core.e.c.printStackTrace(th);
        }
    }
}
