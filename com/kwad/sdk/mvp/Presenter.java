package com.kwad.sdk.mvp;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.kwad.sdk.api.core.ResContext;
import com.kwad.sdk.core.a.a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes6.dex */
public class Presenter {

    /* renamed from: b  reason: collision with root package name */
    public View f33328b;

    /* renamed from: c  reason: collision with root package name */
    public Object f33329c;

    /* renamed from: a  reason: collision with root package name */
    public final List<Presenter> f33327a = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public PresenterState f33330d = PresenterState.INIT;

    /* loaded from: classes6.dex */
    public enum PresenterState {
        INIT(0) { // from class: com.kwad.sdk.mvp.Presenter.PresenterState.1
            @Override // com.kwad.sdk.mvp.Presenter.PresenterState
            public void performCallState(Presenter presenter) {
            }
        },
        CREATE(1) { // from class: com.kwad.sdk.mvp.Presenter.PresenterState.2
            @Override // com.kwad.sdk.mvp.Presenter.PresenterState
            public void performCallState(Presenter presenter) {
                for (Presenter presenter2 : presenter.f33327a) {
                    try {
                        presenter2.a(presenter.f33328b);
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
                for (Presenter presenter2 : presenter.f33327a) {
                    try {
                        presenter2.a(presenter.f33329c);
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
                for (Presenter presenter2 : presenter.f33327a) {
                    try {
                        presenter2.f();
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
                for (Presenter presenter2 : presenter.f33327a) {
                    try {
                        presenter2.g();
                    } catch (Exception e2) {
                        a.a(e2);
                        com.kwad.sdk.core.d.a.a(e2);
                    }
                }
            }
        };
        
        public int mIndex;

        PresenterState(int i2) {
            this.mIndex = i2;
        }

        public int index() {
            return this.mIndex;
        }

        public abstract void performCallState(Presenter presenter);
    }

    public final <T extends View> T a(int i2) {
        return (T) this.f33328b.findViewById(i2);
    }

    public void a() {
    }

    @UiThread
    public final void a(View view) {
        this.f33330d = PresenterState.CREATE;
        this.f33328b = view;
        b();
        this.f33330d.performCallState(this);
    }

    public final void a(Presenter presenter) {
        this.f33327a.add(presenter);
        if (!h() || presenter.h()) {
            return;
        }
        a(this.f33328b);
    }

    @UiThread
    public final void a(@NonNull Object obj) {
        if (this.f33330d != PresenterState.INIT) {
            PresenterState presenterState = PresenterState.DESTROY;
        }
        if (this.f33330d == PresenterState.BIND) {
            f();
        }
        this.f33330d = PresenterState.BIND;
        this.f33329c = obj;
        a();
        this.f33330d.performCallState(this);
    }

    public void b() {
    }

    public void c() {
    }

    public void d() {
    }

    @UiThread
    public final void f() {
        this.f33330d = PresenterState.UNBIND;
        c();
        this.f33330d.performCallState(this);
    }

    @UiThread
    public final void g() {
        if (this.f33330d == PresenterState.BIND) {
            f();
        }
        this.f33330d = PresenterState.DESTROY;
        d();
        this.f33330d.performCallState(this);
    }

    public final boolean h() {
        return this.f33330d.index() >= PresenterState.CREATE.index();
    }

    public View i() {
        return this.f33328b;
    }

    @Nullable
    @UiThread
    public Activity j() {
        Context l = l();
        HashSet hashSet = new HashSet();
        do {
            hashSet.add(l);
            if (!(l instanceof ContextWrapper)) {
                return null;
            }
            if (l instanceof Activity) {
                return (Activity) l;
            }
            if (l instanceof ResContext) {
                Context delegatedContext = ((ResContext) l).getDelegatedContext();
                if (delegatedContext instanceof Activity) {
                    return (Activity) delegatedContext;
                }
            }
            l = ((ContextWrapper) l).getBaseContext();
        } while (!hashSet.contains(l));
        return null;
    }

    public Object k() {
        return this.f33329c;
    }

    public final Context l() {
        View view = this.f33328b;
        if (view == null) {
            return null;
        }
        return view.getContext();
    }
}
