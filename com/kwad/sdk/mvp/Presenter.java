package com.kwad.sdk.mvp;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.kwad.sdk.api.core.ResContext;
import com.kwad.sdk.core.kwai.a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes5.dex */
public class Presenter {
    public View b;
    public Object c;
    public final List<Presenter> a = new ArrayList();
    public PresenterState d = PresenterState.INIT;

    /* loaded from: classes5.dex */
    public enum PresenterState {
        INIT(0) { // from class: com.kwad.sdk.mvp.Presenter.PresenterState.1
            @Override // com.kwad.sdk.mvp.Presenter.PresenterState
            public void performCallState(Presenter presenter) {
            }
        },
        CREATE(1) { // from class: com.kwad.sdk.mvp.Presenter.PresenterState.2
            @Override // com.kwad.sdk.mvp.Presenter.PresenterState
            public void performCallState(Presenter presenter) {
                for (Presenter presenter2 : presenter.a) {
                    try {
                        presenter2.c(presenter.b);
                    } catch (Exception e) {
                        a.a(e);
                        com.kwad.sdk.core.d.a.a(e);
                    }
                }
            }
        },
        BIND(2) { // from class: com.kwad.sdk.mvp.Presenter.PresenterState.3
            @Override // com.kwad.sdk.mvp.Presenter.PresenterState
            public void performCallState(Presenter presenter) {
                for (Presenter presenter2 : presenter.a) {
                    try {
                        presenter2.a(presenter.c);
                    } catch (Exception e) {
                        a.a(e);
                        com.kwad.sdk.core.d.a.a(e);
                    }
                }
            }
        },
        UNBIND(3) { // from class: com.kwad.sdk.mvp.Presenter.PresenterState.4
            @Override // com.kwad.sdk.mvp.Presenter.PresenterState
            public void performCallState(Presenter presenter) {
                for (Presenter presenter2 : presenter.a) {
                    try {
                        presenter2.j();
                    } catch (Exception e) {
                        a.a(e);
                        com.kwad.sdk.core.d.a.a(e);
                    }
                }
            }
        },
        DESTROY(4) { // from class: com.kwad.sdk.mvp.Presenter.PresenterState.5
            @Override // com.kwad.sdk.mvp.Presenter.PresenterState
            public void performCallState(Presenter presenter) {
                for (Presenter presenter2 : presenter.a) {
                    try {
                        presenter2.k();
                    } catch (Exception e) {
                        a.a(e);
                        com.kwad.sdk.core.d.a.a(e);
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

    public final <T extends View> T a(int i) {
        return (T) this.b.findViewById(i);
    }

    public void a() {
    }

    public final void a(Presenter presenter) {
        this.a.add(presenter);
        if (!l() || presenter.l()) {
            return;
        }
        c(this.b);
    }

    @UiThread
    public final void a(@NonNull Object obj) {
        if (this.d != PresenterState.INIT) {
            PresenterState presenterState = PresenterState.DESTROY;
        }
        if (this.d == PresenterState.BIND) {
            j();
        }
        this.d = PresenterState.BIND;
        this.c = obj;
        a();
        this.d.performCallState(this);
    }

    public void c() {
    }

    @UiThread
    public final void c(View view2) {
        this.d = PresenterState.CREATE;
        this.b = view2;
        c_();
        this.d.performCallState(this);
    }

    public void c_() {
    }

    public void d_() {
    }

    @UiThread
    public final void j() {
        this.d = PresenterState.UNBIND;
        c();
        this.d.performCallState(this);
    }

    @UiThread
    public final void k() {
        if (this.d == PresenterState.BIND) {
            j();
        }
        this.d = PresenterState.DESTROY;
        d_();
        this.d.performCallState(this);
    }

    public final boolean l() {
        return this.d.index() >= PresenterState.CREATE.index();
    }

    public View m() {
        return this.b;
    }

    public List<Presenter> n() {
        return this.a;
    }

    @Nullable
    @UiThread
    public Activity o() {
        Context q = q();
        HashSet hashSet = new HashSet();
        do {
            hashSet.add(q);
            if (!(q instanceof ContextWrapper)) {
                return null;
            }
            if (q instanceof Activity) {
                return (Activity) q;
            }
            if (q instanceof ResContext) {
                Context delegatedContext = ((ResContext) q).getDelegatedContext();
                if (delegatedContext instanceof Activity) {
                    return (Activity) delegatedContext;
                }
            }
            q = ((ContextWrapper) q).getBaseContext();
        } while (!hashSet.contains(q));
        return null;
    }

    public Object p() {
        return this.c;
    }

    public final Context q() {
        View view2 = this.b;
        if (view2 == null) {
            return null;
        }
        return view2.getContext();
    }
}
