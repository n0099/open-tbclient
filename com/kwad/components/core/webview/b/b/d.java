package com.kwad.components.core.webview.b.b;

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
import com.kwad.components.core.i.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.widget.KSFrameLayout;
/* loaded from: classes8.dex */
public class d extends e {
    public com.kwad.components.core.webview.b.b.b Ob;
    public String Od;
    public boolean Oe;
    public com.kwad.components.core.webview.b.d.c Of;
    public a Og;
    public com.kwad.components.core.webview.b.d.d Ok;
    public KSFrameLayout Om;
    public DialogInterface.OnDismissListener On;
    public boolean Oo = false;
    public AdTemplate mAdTemplate;
    public Presenter mPresenter;

    /* loaded from: classes8.dex */
    public interface a {
        boolean fG();
    }

    /* loaded from: classes8.dex */
    public static class b {
        public boolean Oe;
        public boolean Oo;
        public AdTemplate mAdTemplate;
        public String templateId;

        public final void aE(boolean z) {
            this.Oe = z;
        }

        public final void aF(boolean z) {
            this.Oo = true;
        }

        public final void aI(String str) {
            this.templateId = str;
        }

        public final AdTemplate getAdTemplate() {
            return this.mAdTemplate;
        }

        public final String getTemplateId() {
            return this.templateId;
        }

        public final boolean pP() {
            return this.Oe;
        }

        public final boolean pQ() {
            return this.Oo;
        }

        public final void setAdTemplate(AdTemplate adTemplate) {
            this.mAdTemplate = adTemplate;
        }
    }

    private Presenter ap() {
        Presenter presenter = new Presenter();
        this.mPresenter = presenter;
        presenter.a(in());
        return this.mPresenter;
    }

    public static d b(b bVar) {
        d dVar = new d();
        dVar.mAdTemplate = bVar.getAdTemplate();
        dVar.Od = bVar.getTemplateId();
        dVar.Oe = bVar.Oe;
        dVar.Oo = bVar.Oo;
        Bundle bundle = new Bundle();
        bundle.putString("templateId", bVar.getTemplateId());
        dVar.setArguments(bundle);
        return dVar;
    }

    private void v(View view2) {
        if (this.mPresenter == null) {
            Presenter ap = ap();
            this.mPresenter = ap;
            ap.B(view2);
            this.Ob = im();
        }
        io();
        this.mPresenter.e(this.Ob);
    }

    @Override // com.kwad.components.core.i.e
    public final View a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        getDialog().requestWindowFeature(1);
        if (this.Om == null) {
            this.Om = (KSFrameLayout) layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d04af, viewGroup, false);
        }
        return this.Om;
    }

    public final void a(com.kwad.components.core.webview.b.d.d dVar) {
        this.Ok = dVar;
    }

    public com.kwad.components.core.webview.b.b.b im() {
        return new com.kwad.components.core.webview.b.b.b();
    }

    public c in() {
        return new c();
    }

    public void io() {
        this.Ob.mActivity = getActivity2();
        com.kwad.components.core.webview.b.b.b bVar = this.Ob;
        bVar.Ne = this;
        bVar.Oc = this.Om;
        bVar.mAdTemplate = this.mAdTemplate;
        bVar.Od = this.Od;
        bVar.Oe = this.Oe;
        bVar.Og = this.Og;
        bVar.Of = this.Of;
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
        window.setAttributes(attributes);
        getDialog().setCanceledOnTouchOutside(false);
        window.getDecorView().setPadding(0, 0, 0, 0);
        window.setLayout(-1, -1);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        window.setSoftInputMode(16);
        if (this.Oo) {
            getDialog().setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.kwad.components.core.webview.b.b.d.1
                @Override // android.content.DialogInterface.OnKeyListener
                public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                    return i == 4 && keyEvent.getAction() == 0;
                }
            });
        }
        window.setFlags(1024, 1024);
        if (this.Oo) {
            getDialog().setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.kwad.components.core.webview.b.b.d.2
                @Override // android.content.DialogInterface.OnKeyListener
                public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                    return i == 4 && keyEvent.getAction() == 0;
                }
            });
        }
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.Od = getArguments().getString("templateId");
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Presenter presenter = this.mPresenter;
        if (presenter != null) {
            presenter.destroy();
            this.mPresenter = null;
        }
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        KSFrameLayout kSFrameLayout = this.Om;
        if (kSFrameLayout != null && (kSFrameLayout.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.Om.getParent()).removeView(this.Om);
            this.Om = null;
        }
        com.kwad.components.core.webview.b.d.d dVar = this.Ok;
        if (dVar != null) {
            dVar.pO();
        }
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        DialogInterface.OnDismissListener onDismissListener = this.On;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(dialogInterface);
        }
    }

    @Override // android.app.Fragment
    public void onViewCreated(@NonNull View view2, @Nullable Bundle bundle) {
        super.onViewCreated(view2, bundle);
        v(view2);
        com.kwad.components.core.webview.b.d.c cVar = this.Of;
        if (cVar != null) {
            cVar.fH();
        }
        com.kwad.components.core.webview.b.d.d dVar = this.Ok;
        if (dVar != null) {
            dVar.fH();
        }
    }
}
