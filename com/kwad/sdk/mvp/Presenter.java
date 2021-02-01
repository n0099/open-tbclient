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
/* loaded from: classes3.dex */
public class Presenter {

    /* renamed from: b  reason: collision with root package name */
    private View f10485b;
    private Object c;

    /* renamed from: a  reason: collision with root package name */
    private final List<Presenter> f10484a = new ArrayList();
    private PresenterState d = PresenterState.INIT;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public enum PresenterState {
        INIT(0) { // from class: com.kwad.sdk.mvp.Presenter.PresenterState.1
            @Override // com.kwad.sdk.mvp.Presenter.PresenterState
            public void performCallState(Presenter presenter) {
            }
        },
        CREATE(1) { // from class: com.kwad.sdk.mvp.Presenter.PresenterState.2
            @Override // com.kwad.sdk.mvp.Presenter.PresenterState
            public void performCallState(Presenter presenter) {
                for (Presenter presenter2 : presenter.f10484a) {
                    try {
                        presenter2.a(presenter.f10485b);
                    } catch (Exception e) {
                        a.a(e);
                        com.kwad.sdk.core.d.a.a(e);
                    }
                }
            }
        },
        BIND(2) { // from class: com.kwad.sdk.mvp.Presenter.PresenterState.3
            @Override // com.kwad.sdk.mvp.Presenter.PresenterState
            void performCallState(Presenter presenter) {
                for (Presenter presenter2 : presenter.f10484a) {
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
            void performCallState(Presenter presenter) {
                for (Presenter presenter2 : presenter.f10484a) {
                    try {
                        presenter2.i();
                    } catch (Exception e) {
                        a.a(e);
                        com.kwad.sdk.core.d.a.a(e);
                    }
                }
            }
        },
        DESTROY(4) { // from class: com.kwad.sdk.mvp.Presenter.PresenterState.5
            @Override // com.kwad.sdk.mvp.Presenter.PresenterState
            void performCallState(Presenter presenter) {
                for (Presenter presenter2 : presenter.f10484a) {
                    try {
                        presenter2.j();
                    } catch (Exception e) {
                        a.a(e);
                        com.kwad.sdk.core.d.a.a(e);
                    }
                }
            }
        };
        
        private int mIndex;

        PresenterState(int i) {
            this.mIndex = i;
        }

        public int index() {
            return this.mIndex;
        }

        abstract void performCallState(Presenter presenter);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
    }

    @UiThread
    public final void a(View view) {
        this.d = PresenterState.CREATE;
        this.f10485b = view;
        c();
        this.d.performCallState(this);
    }

    public final void a(Presenter presenter) {
        this.f10484a.add(presenter);
        if (!k() || presenter.k()) {
            return;
        }
        a(this.f10485b);
    }

    @UiThread
    public final void a(@NonNull Object obj) {
        if (this.d == PresenterState.INIT || this.d == PresenterState.DESTROY) {
        }
        if (this.d == PresenterState.BIND) {
            i();
        }
        this.d = PresenterState.BIND;
        this.c = obj;
        a();
        this.d.performCallState(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <T extends View> T b(int i) {
        return (T) this.f10485b.findViewById(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b_() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() {
    }

    @UiThread
    public final void i() {
        this.d = PresenterState.UNBIND;
        b_();
        this.d.performCallState(this);
    }

    @UiThread
    public final void j() {
        if (this.d == PresenterState.BIND) {
            i();
        }
        this.d = PresenterState.DESTROY;
        d();
        this.d.performCallState(this);
    }

    public final boolean k() {
        return this.d.index() >= PresenterState.CREATE.index();
    }

    public View l() {
        return this.f10485b;
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
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Context o() {
        if (this.f10485b == null) {
            return null;
        }
        return this.f10485b.getContext();
    }
}
