package com.kwad.sdk.mvp;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import com.kwad.sdk.api.core.ResContext;
import com.kwad.sdk.core.e.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes8.dex */
public class Presenter {
    public Object ajn;
    public View mRootView;
    public final List ajm = new ArrayList();
    public PresenterState ajo = PresenterState.INIT;

    /* loaded from: classes8.dex */
    public enum PresenterState {
        INIT(0) { // from class: com.kwad.sdk.mvp.Presenter.PresenterState.1
            @Override // com.kwad.sdk.mvp.Presenter.PresenterState
            public final void performCallState(Presenter presenter) {
            }
        },
        CREATE(1) { // from class: com.kwad.sdk.mvp.Presenter.PresenterState.2
            @Override // com.kwad.sdk.mvp.Presenter.PresenterState
            public final void performCallState(Presenter presenter) {
                for (Presenter presenter2 : presenter.ajm) {
                    try {
                        presenter2.B(presenter.mRootView);
                    } catch (Exception e) {
                        com.kwad.sdk.service.a.gatherException(e);
                        b.printStackTrace(e);
                    }
                }
            }
        },
        BIND(2) { // from class: com.kwad.sdk.mvp.Presenter.PresenterState.3
            @Override // com.kwad.sdk.mvp.Presenter.PresenterState
            public final void performCallState(Presenter presenter) {
                for (Presenter presenter2 : presenter.ajm) {
                    try {
                        presenter2.e(presenter.ajn);
                    } catch (Exception e) {
                        com.kwad.sdk.service.a.gatherException(e);
                        b.printStackTrace(e);
                    }
                }
            }
        },
        UNBIND(3) { // from class: com.kwad.sdk.mvp.Presenter.PresenterState.4
            @Override // com.kwad.sdk.mvp.Presenter.PresenterState
            public final void performCallState(Presenter presenter) {
                for (Presenter presenter2 : presenter.ajm) {
                    try {
                        presenter2.bt();
                    } catch (Exception e) {
                        com.kwad.sdk.service.a.gatherException(e);
                        b.printStackTrace(e);
                    }
                }
            }
        },
        DESTROY(4) { // from class: com.kwad.sdk.mvp.Presenter.PresenterState.5
            @Override // com.kwad.sdk.mvp.Presenter.PresenterState
            public final void performCallState(Presenter presenter) {
                for (Presenter presenter2 : presenter.ajm) {
                    try {
                        presenter2.destroy();
                    } catch (Exception e) {
                        com.kwad.sdk.service.a.gatherException(e);
                        b.printStackTrace(e);
                    }
                }
            }
        };
        
        public int mIndex;

        PresenterState(int i) {
            this.mIndex = i;
        }

        public int index() {
            return this.mIndex;
        }

        public abstract void performCallState(Presenter presenter);
    }

    private boolean xP() {
        return this.ajo.index() >= PresenterState.CREATE.index();
    }

    public final void B(View view2) {
        this.ajo = PresenterState.CREATE;
        this.mRootView = view2;
        onCreate();
        this.ajo.performCallState(this);
    }

    public final void a(Presenter presenter) {
        this.ajm.add(presenter);
        if (!xP() || presenter.xP()) {
            return;
        }
        B(this.mRootView);
    }

    public void aq() {
    }

    public final void bt() {
        this.ajo = PresenterState.UNBIND;
        onUnbind();
        this.ajo.performCallState(this);
    }

    public final void destroy() {
        if (this.ajo == PresenterState.BIND) {
            bt();
        }
        this.ajo = PresenterState.DESTROY;
        onDestroy();
        this.ajo.performCallState(this);
    }

    public final void e(Object obj) {
        if (this.ajo != PresenterState.INIT) {
            PresenterState presenterState = PresenterState.DESTROY;
        }
        if (this.ajo == PresenterState.BIND) {
            bt();
        }
        this.ajo = PresenterState.BIND;
        this.ajn = obj;
        aq();
        this.ajo.performCallState(this);
    }

    public final View findViewById(int i) {
        return this.mRootView.findViewById(i);
    }

    public final Activity getActivity() {
        Context context = getContext();
        HashSet hashSet = new HashSet();
        do {
            hashSet.add(context);
            if (!(context instanceof ContextWrapper)) {
                return null;
            }
            if (context instanceof Activity) {
                return (Activity) context;
            }
            if (context instanceof ResContext) {
                Context delegatedContext = ((ResContext) context).getDelegatedContext();
                if (delegatedContext instanceof Activity) {
                    return (Activity) delegatedContext;
                }
            }
            context = ((ContextWrapper) context).getBaseContext();
        } while (!hashSet.contains(context));
        return null;
    }

    public final Context getContext() {
        View view2 = this.mRootView;
        if (view2 == null) {
            return null;
        }
        return view2.getContext();
    }

    public final View getRootView() {
        return this.mRootView;
    }

    public void onCreate() {
    }

    public void onDestroy() {
    }

    public void onUnbind() {
    }

    public final List xQ() {
        return this.ajm;
    }

    public final Object xR() {
        return this.ajn;
    }
}
