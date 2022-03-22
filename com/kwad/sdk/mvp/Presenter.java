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
/* loaded from: classes7.dex */
public class Presenter {

    /* renamed from: b  reason: collision with root package name */
    public View f40589b;

    /* renamed from: c  reason: collision with root package name */
    public Object f40590c;
    public final List<Presenter> a = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public PresenterState f40591d = PresenterState.INIT;

    /* loaded from: classes7.dex */
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
                        presenter2.c(presenter.f40589b);
                    } catch (Exception e2) {
                        a.a(e2);
                        com.kwad.sdk.core.d.a.a(e2);
                    }
                }
            }
        },
        BIND(2) { // from class: com.kwad.sdk.mvp.Presenter.PresenterState.3
            @Override // com.kwad.sdk.mvp.Presenter.PresenterState
            public void performCallState(Presenter presenter) {
                for (Presenter presenter2 : presenter.a) {
                    try {
                        presenter2.a(presenter.f40590c);
                    } catch (Exception e2) {
                        a.a(e2);
                        com.kwad.sdk.core.d.a.a(e2);
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
                    } catch (Exception e2) {
                        a.a(e2);
                        com.kwad.sdk.core.d.a.a(e2);
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
                    } catch (Exception e2) {
                        a.a(e2);
                        com.kwad.sdk.core.d.a.a(e2);
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
        return (T) this.f40589b.findViewById(i);
    }

    public void a() {
    }

    public final void a(Presenter presenter) {
        this.a.add(presenter);
        if (!l() || presenter.l()) {
            return;
        }
        c(this.f40589b);
    }

    @UiThread
    public final void a(@NonNull Object obj) {
        if (this.f40591d != PresenterState.INIT) {
            PresenterState presenterState = PresenterState.DESTROY;
        }
        if (this.f40591d == PresenterState.BIND) {
            j();
        }
        this.f40591d = PresenterState.BIND;
        this.f40590c = obj;
        a();
        this.f40591d.performCallState(this);
    }

    public void c() {
    }

    @UiThread
    public final void c(View view) {
        this.f40591d = PresenterState.CREATE;
        this.f40589b = view;
        c_();
        this.f40591d.performCallState(this);
    }

    public void c_() {
    }

    public void d_() {
    }

    @UiThread
    public final void j() {
        this.f40591d = PresenterState.UNBIND;
        c();
        this.f40591d.performCallState(this);
    }

    @UiThread
    public final void k() {
        if (this.f40591d == PresenterState.BIND) {
            j();
        }
        this.f40591d = PresenterState.DESTROY;
        d_();
        this.f40591d.performCallState(this);
    }

    public final boolean l() {
        return this.f40591d.index() >= PresenterState.CREATE.index();
    }

    public View m() {
        return this.f40589b;
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
        return this.f40590c;
    }

    public final Context q() {
        View view = this.f40589b;
        if (view == null) {
            return null;
        }
        return view.getContext();
    }
}
