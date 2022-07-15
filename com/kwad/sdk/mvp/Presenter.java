package com.kwad.sdk.mvp;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.kwad.sdk.api.core.ResContext;
import com.kwad.sdk.core.d.b;
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
            public final void performCallState(Presenter presenter) {
            }
        },
        CREATE(1) { // from class: com.kwad.sdk.mvp.Presenter.PresenterState.2
            @Override // com.kwad.sdk.mvp.Presenter.PresenterState
            public final void performCallState(Presenter presenter) {
                for (Presenter presenter2 : presenter.a) {
                    try {
                        presenter2.c(presenter.b);
                    } catch (Exception e) {
                        com.kwad.sdk.service.a.a(e);
                        b.a(e);
                    }
                }
            }
        },
        BIND(2) { // from class: com.kwad.sdk.mvp.Presenter.PresenterState.3
            @Override // com.kwad.sdk.mvp.Presenter.PresenterState
            public final void performCallState(Presenter presenter) {
                for (Presenter presenter2 : presenter.a) {
                    try {
                        presenter2.a(presenter.c);
                    } catch (Exception e) {
                        com.kwad.sdk.service.a.a(e);
                        b.a(e);
                    }
                }
            }
        },
        UNBIND(3) { // from class: com.kwad.sdk.mvp.Presenter.PresenterState.4
            @Override // com.kwad.sdk.mvp.Presenter.PresenterState
            public final void performCallState(Presenter presenter) {
                for (Presenter presenter2 : presenter.a) {
                    try {
                        presenter2.o();
                    } catch (Exception e) {
                        com.kwad.sdk.service.a.a(e);
                        b.a(e);
                    }
                }
            }
        },
        DESTROY(4) { // from class: com.kwad.sdk.mvp.Presenter.PresenterState.5
            @Override // com.kwad.sdk.mvp.Presenter.PresenterState
            public final void performCallState(Presenter presenter) {
                for (Presenter presenter2 : presenter.a) {
                    try {
                        presenter2.p();
                    } catch (Exception e) {
                        com.kwad.sdk.service.a.a(e);
                        b.a(e);
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

    private boolean d() {
        return this.d.index() >= PresenterState.CREATE.index();
    }

    public void a() {
    }

    public final void a(Presenter presenter) {
        this.a.add(presenter);
        if (!d() || presenter.d()) {
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
            o();
        }
        this.d = PresenterState.BIND;
        this.c = obj;
        a();
        this.d.performCallState(this);
    }

    public final <T extends View> T b(int i) {
        return (T) this.b.findViewById(i);
    }

    @UiThread
    public final void c(View view2) {
        this.d = PresenterState.CREATE;
        this.b = view2;
        i_();
        this.d.performCallState(this);
    }

    public void e_() {
    }

    public void i_() {
    }

    public void k_() {
    }

    @UiThread
    public final void o() {
        this.d = PresenterState.UNBIND;
        k_();
        this.d.performCallState(this);
    }

    @UiThread
    public final void p() {
        if (this.d == PresenterState.BIND) {
            o();
        }
        this.d = PresenterState.DESTROY;
        e_();
        this.d.performCallState(this);
    }

    public final View q() {
        return this.b;
    }

    public final List<Presenter> r() {
        return this.a;
    }

    @Nullable
    @UiThread
    public final Activity s() {
        Context u = u();
        HashSet hashSet = new HashSet();
        do {
            hashSet.add(u);
            if (!(u instanceof ContextWrapper)) {
                return null;
            }
            if (u instanceof Activity) {
                return (Activity) u;
            }
            if (u instanceof ResContext) {
                Context delegatedContext = ((ResContext) u).getDelegatedContext();
                if (delegatedContext instanceof Activity) {
                    return (Activity) delegatedContext;
                }
            }
            u = ((ContextWrapper) u).getBaseContext();
        } while (!hashSet.contains(u));
        return null;
    }

    public final Object t() {
        return this.c;
    }

    public final Context u() {
        View view2 = this.b;
        if (view2 == null) {
            return null;
        }
        return view2.getContext();
    }
}
