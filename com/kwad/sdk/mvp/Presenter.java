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
/* loaded from: classes7.dex */
public class Presenter {

    /* renamed from: b  reason: collision with root package name */
    public View f36886b;

    /* renamed from: c  reason: collision with root package name */
    public Object f36887c;

    /* renamed from: a  reason: collision with root package name */
    public final List<Presenter> f36885a = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public PresenterState f36888d = PresenterState.INIT;

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
                for (Presenter presenter2 : presenter.f36885a) {
                    try {
                        presenter2.a(presenter.f36886b);
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
                for (Presenter presenter2 : presenter.f36885a) {
                    try {
                        presenter2.a(presenter.f36887c);
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
                for (Presenter presenter2 : presenter.f36885a) {
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
                for (Presenter presenter2 : presenter.f36885a) {
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

        PresenterState(int i2) {
            this.mIndex = i2;
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
        this.f36888d = PresenterState.CREATE;
        this.f36886b = view;
        c();
        this.f36888d.performCallState(this);
    }

    public final void a(Presenter presenter) {
        this.f36885a.add(presenter);
        if (!k() || presenter.k()) {
            return;
        }
        a(this.f36886b);
    }

    @UiThread
    public final void a(@NonNull Object obj) {
        if (this.f36888d != PresenterState.INIT) {
            PresenterState presenterState = PresenterState.DESTROY;
        }
        if (this.f36888d == PresenterState.BIND) {
            i();
        }
        this.f36888d = PresenterState.BIND;
        this.f36887c = obj;
        a();
        this.f36888d.performCallState(this);
    }

    public final <T extends View> T b(int i2) {
        return (T) this.f36886b.findViewById(i2);
    }

    public void b_() {
    }

    public void c() {
    }

    public void d() {
    }

    @UiThread
    public final void i() {
        this.f36888d = PresenterState.UNBIND;
        b_();
        this.f36888d.performCallState(this);
    }

    @UiThread
    public final void j() {
        if (this.f36888d == PresenterState.BIND) {
            i();
        }
        this.f36888d = PresenterState.DESTROY;
        d();
        this.f36888d.performCallState(this);
    }

    public final boolean k() {
        return this.f36888d.index() >= PresenterState.CREATE.index();
    }

    public View l() {
        return this.f36886b;
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
        return this.f36887c;
    }

    public final Context o() {
        View view = this.f36886b;
        if (view == null) {
            return null;
        }
        return view.getContext();
    }
}
