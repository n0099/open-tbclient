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
import java.util.List;
/* loaded from: classes6.dex */
public class Presenter {

    /* renamed from: b  reason: collision with root package name */
    public View f36077b;

    /* renamed from: c  reason: collision with root package name */
    public Object f36078c;

    /* renamed from: a  reason: collision with root package name */
    public final List<Presenter> f36076a = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public PresenterState f36079d = PresenterState.INIT;

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
                for (Presenter presenter2 : presenter.f36076a) {
                    try {
                        presenter2.a(presenter.f36077b);
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
                for (Presenter presenter2 : presenter.f36076a) {
                    try {
                        presenter2.a(presenter.f36078c);
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
                for (Presenter presenter2 : presenter.f36076a) {
                    try {
                        presenter2.i();
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
                for (Presenter presenter2 : presenter.f36076a) {
                    try {
                        presenter2.j();
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

    public void a() {
    }

    @UiThread
    public final void a(View view) {
        this.f36079d = PresenterState.CREATE;
        this.f36077b = view;
        c();
        this.f36079d.performCallState(this);
    }

    public final void a(Presenter presenter) {
        this.f36076a.add(presenter);
        if (!k() || presenter.k()) {
            return;
        }
        a(this.f36077b);
    }

    @UiThread
    public final void a(@NonNull Object obj) {
        if (this.f36079d != PresenterState.INIT) {
            PresenterState presenterState = PresenterState.DESTROY;
        }
        if (this.f36079d == PresenterState.BIND) {
            i();
        }
        this.f36079d = PresenterState.BIND;
        this.f36078c = obj;
        a();
        this.f36079d.performCallState(this);
    }

    public final <T extends View> T b(int i) {
        return (T) this.f36077b.findViewById(i);
    }

    public void b_() {
    }

    public void c() {
    }

    public void d() {
    }

    @UiThread
    public final void i() {
        this.f36079d = PresenterState.UNBIND;
        b_();
        this.f36079d.performCallState(this);
    }

    @UiThread
    public final void j() {
        if (this.f36079d == PresenterState.BIND) {
            i();
        }
        this.f36079d = PresenterState.DESTROY;
        d();
        this.f36079d.performCallState(this);
    }

    public final boolean k() {
        return this.f36079d.index() >= PresenterState.CREATE.index();
    }

    public View l() {
        return this.f36077b;
    }

    @Nullable
    @UiThread
    public Activity m() {
        for (Context o = o(); o instanceof ContextWrapper; o = ((ContextWrapper) o).getBaseContext()) {
            if (o instanceof Activity) {
                return (Activity) o;
            }
            if (o instanceof ResContext) {
                Context delegatedContext = ((ResContext) o).getDelegatedContext();
                if (delegatedContext instanceof Activity) {
                    return (Activity) delegatedContext;
                }
            }
        }
        return null;
    }

    public Object n() {
        return this.f36078c;
    }

    public final Context o() {
        View view = this.f36077b;
        if (view == null) {
            return null;
        }
        return view.getContext();
    }
}
