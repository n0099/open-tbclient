package com.kwad.components.core.webview.tachikoma.c;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.components.core.proxy.g;
import com.kwad.components.core.webview.tachikoma.k;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.components.j;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.widget.KSFrameLayout;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes10.dex */
public class e extends g {
    public com.kwad.components.core.webview.tachikoma.e.c So;
    public StyleTemplate Sq;
    public com.kwad.components.core.webview.tachikoma.c.b aal;
    public j aan;
    public k aao;
    public boolean aap;
    public a aaq;
    public com.kwad.components.core.webview.tachikoma.e.d aat;
    public d aaw;
    public KSFrameLayout aax;
    public List<DialogInterface.OnDismissListener> aay = new CopyOnWriteArrayList();
    public boolean aaz = false;
    public AdResultData mAdResultData;
    public Presenter mPresenter;
    public String xm;

    /* loaded from: classes10.dex */
    public interface a {
        boolean fR();
    }

    /* loaded from: classes10.dex */
    public static class b {
        public StyleTemplate aaB;
        public k aaC;
        public j aan;
        public boolean aap;
        public boolean aaz;
        public AdResultData mAdResultData;
        public String templateId;

        public final String getTemplateId() {
            return this.templateId;
        }

        public final AdResultData hi() {
            return this.mAdResultData;
        }

        public final boolean kc() {
            return this.aap;
        }

        public final boolean sN() {
            return this.aaz;
        }

        public final void a(k kVar) {
            this.aaC = kVar;
        }

        public final void aN(String str) {
            this.templateId = str;
        }

        public final void aV(boolean z) {
            this.aap = false;
        }

        public final void aW(boolean z) {
            this.aaz = true;
        }

        public final void a(StyleTemplate styleTemplate) {
            this.aaB = styleTemplate;
        }

        public final void c(j jVar) {
            this.aan = jVar;
        }

        public final void d(AdResultData adResultData) {
            this.mAdResultData = adResultData;
        }
    }

    private Presenter af() {
        Presenter presenter = new Presenter();
        this.mPresenter = presenter;
        if (this.aal.aao != null) {
            presenter.a(sM());
        } else {
            presenter.a(jj());
        }
        return this.mPresenter;
    }

    private d sM() {
        if (this.aaw == null) {
            this.aaw = new d();
        }
        return this.aaw;
    }

    public com.kwad.components.core.webview.tachikoma.c.b ji() {
        return new com.kwad.components.core.webview.tachikoma.c.b();
    }

    public c jj() {
        return new c();
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Presenter presenter = this.mPresenter;
        if (presenter != null) {
            presenter.destroy();
            this.mPresenter = null;
        }
        com.kwad.components.core.webview.tachikoma.c.b bVar = this.aal;
        if (bVar != null) {
            bVar.release();
            this.aal = null;
        }
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        KSFrameLayout kSFrameLayout = this.aax;
        if (kSFrameLayout != null && (kSFrameLayout.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.aax.getParent()).removeView(this.aax);
            this.aax = null;
        }
        com.kwad.components.core.webview.tachikoma.e.d dVar = this.aat;
        if (dVar != null) {
            dVar.fX();
        }
    }

    public static boolean b(Activity activity) {
        if (activity == null || (activity.getWindow().getAttributes().flags & 1024) != 1024) {
            return false;
        }
        return true;
    }

    private void z(View view2) {
        if (this.aal == null) {
            this.aal = ji();
        }
        jk();
        if (this.mPresenter == null) {
            Presenter af = af();
            this.mPresenter = af;
            af.G(view2);
        }
        this.mPresenter.k(this.aal);
    }

    public final void d(DialogInterface.OnDismissListener onDismissListener) {
        if (onDismissListener != null) {
            this.aay.add(onDismissListener);
        }
    }

    public final void e(DialogInterface.OnDismissListener onDismissListener) {
        this.aay.remove(onDismissListener);
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.xm = getArguments().getString("templateId");
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        com.kwad.components.core.webview.tachikoma.e.c cVar = this.So;
        if (cVar != null) {
            cVar.fX();
        }
        for (DialogInterface.OnDismissListener onDismissListener : this.aay) {
            if (onDismissListener != null) {
                onDismissListener.onDismiss(dialogInterface);
            }
        }
        j jVar = this.aan;
        if (jVar != null) {
            jVar.callbackDialogDismiss();
        }
    }

    public static e b(b bVar) {
        e eVar = new e();
        eVar.mAdResultData = bVar.hi();
        eVar.xm = bVar.getTemplateId();
        eVar.aap = bVar.aap;
        eVar.aaz = bVar.aaz;
        eVar.Sq = bVar.aaB;
        eVar.aan = bVar.aan;
        eVar.aao = bVar.aaC;
        Bundle bundle = new Bundle();
        bundle.putString("templateId", bVar.getTemplateId());
        eVar.setArguments(bundle);
        return eVar;
    }

    @Override // com.kwad.components.core.proxy.g
    public final View a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        if (this.aax == null) {
            this.aax = (KSFrameLayout) layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0531, viewGroup, false);
        }
        return this.aax;
    }

    @Override // android.app.Fragment
    public void onViewCreated(@NonNull View view2, @Nullable Bundle bundle) {
        super.onViewCreated(view2, bundle);
        z(view2);
        com.kwad.components.core.webview.tachikoma.e.c cVar = this.So;
        if (cVar != null) {
            cVar.fP();
        }
        com.kwad.components.core.webview.tachikoma.e.d dVar = this.aat;
        if (dVar != null) {
            dVar.fP();
        }
    }

    public final void a(com.kwad.components.core.webview.tachikoma.e.d dVar) {
        this.aat = dVar;
    }

    public void jk() {
        this.aal.d(this.mAdResultData);
        this.aal.mActivity = getActivity();
        com.kwad.components.core.webview.tachikoma.c.b bVar = this.aal;
        bVar.Yv = this;
        bVar.aam = this.aax;
        bVar.xm = this.xm;
        bVar.Sq = this.Sq;
        bVar.aap = this.aap;
        bVar.aan = this.aan;
        bVar.aao = this.aao;
        bVar.aaq = this.aaq;
        bVar.So = this.So;
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        Window window;
        try {
            super.onActivityCreated(bundle);
        } catch (Throwable unused) {
        }
        if (getDialog() == null || (window = getDialog().getWindow()) == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = 0.0f;
        attributes.width = -1;
        attributes.height = -1;
        window.setAttributes(attributes);
        getDialog().setCanceledOnTouchOutside(false);
        window.getDecorView().setPadding(0, 0, 0, 0);
        window.setLayout(-1, -1);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        window.setSoftInputMode(16);
        if (b(getDialog().getOwnerActivity())) {
            window.setFlags(1024, 1024);
        }
        getDialog().setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.kwad.components.core.webview.tachikoma.c.e.1
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (i == 4 && keyEvent.getAction() == 0) {
                    e eVar = e.this;
                    if (eVar.aaz) {
                        return true;
                    }
                    if (eVar.aaw != null) {
                        return e.this.aaw.onBackPressed();
                    }
                    return false;
                }
                return false;
            }
        });
    }
}
