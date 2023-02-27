package com.kwad.components.core.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.widget.a;
import com.kwad.components.core.widget.c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.KSFrameLayout;
/* loaded from: classes8.dex */
public abstract class b<T extends AdTemplate> extends KSFrameLayout implements DialogInterface.OnDismissListener, DialogInterface.OnShowListener, com.kwad.sdk.core.h.b {
    public com.kwad.components.core.widget.kwai.b aM;
    public InterfaceC0612b lp;
    public AdInfo mAdInfo;
    @NonNull
    public T mAdTemplate;
    @NonNull
    public Context mContext;

    /* loaded from: classes8.dex */
    public static class a implements InterfaceC0612b {
        @Override // com.kwad.components.core.widget.b.InterfaceC0612b
        public void onAdClicked() {
        }

        @Override // com.kwad.components.core.widget.b.InterfaceC0612b
        public void onAdShow() {
        }

        @Override // com.kwad.components.core.widget.b.InterfaceC0612b
        public final void onDislikeClicked() {
        }

        @Override // com.kwad.components.core.widget.b.InterfaceC0612b
        public final void onDownloadTipsDialogDismiss() {
        }

        @Override // com.kwad.components.core.widget.b.InterfaceC0612b
        public final void onDownloadTipsDialogShow() {
        }
    }

    /* renamed from: com.kwad.components.core.widget.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0612b {
        void onAdClicked();

        void onAdShow();

        void onDislikeClicked();

        void onDownloadTipsDialogDismiss();

        void onDownloadTipsDialogShow();
    }

    public b(@NonNull Context context) {
        this(context, null);
    }

    public b(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, null, 0);
    }

    public b(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, 0);
        this.mContext = context;
        initView();
    }

    private void a(ViewGroup viewGroup) {
        if (!com.kwad.sdk.core.config.d.sm() && com.kwad.sdk.core.config.d.sl() >= 0.0f) {
            c(viewGroup);
            com.kwad.components.core.widget.a aVar = new com.kwad.components.core.widget.a(viewGroup.getContext(), viewGroup);
            viewGroup.addView(aVar);
            aVar.setViewCallback(new a.InterfaceC0611a() { // from class: com.kwad.components.core.widget.b.1
                @Override // com.kwad.components.core.widget.a.InterfaceC0611a
                public final void em() {
                    b.this.br();
                }
            });
            aVar.pW();
            return;
        }
        c b = b(viewGroup);
        if (b == null) {
            b = new c(viewGroup.getContext(), viewGroup);
            viewGroup.addView(b);
        }
        b.setViewCallback(new c.a() { // from class: com.kwad.components.core.widget.b.2
            @Override // com.kwad.components.core.widget.c.a
            public final void em() {
                b.this.br();
            }
        });
        b.setNeedCheckingShow(true);
    }

    public static c b(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof c) {
                return (c) childAt;
            }
        }
        return null;
    }

    public static void c(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof com.kwad.components.core.widget.a) {
                viewGroup.removeView(childAt);
            }
        }
    }

    private void initView() {
        FrameLayout.inflate(this.mContext, getLayoutId(), this);
        setRatio(getHWRatio());
        bg();
        this.aM = new com.kwad.components.core.widget.kwai.b(this, 70);
        a(this);
    }

    public void aR() {
    }

    @Override // com.kwad.sdk.core.h.b
    public void aS() {
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void am() {
        super.am();
        this.aM.a(this);
        this.aM.qi();
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void an() {
        super.an();
        this.aM.b(this);
        this.aM.qj();
        bj();
    }

    public final void aq(int i) {
        com.kwad.sdk.core.report.a.a(this.mAdTemplate, i, getTouchCoords());
        InterfaceC0612b interfaceC0612b = this.lp;
        if (interfaceC0612b != null) {
            interfaceC0612b.onAdClicked();
        }
    }

    public abstract void bg();

    public void bj() {
    }

    public void br() {
        InterfaceC0612b interfaceC0612b;
        if (!this.mAdTemplate.mPvReported && (interfaceC0612b = this.lp) != null) {
            interfaceC0612b.onAdShow();
        }
        com.kwad.components.core.m.c.ox().a(this.mAdTemplate, null, null);
    }

    public void c(@NonNull T t) {
        this.mAdTemplate = t;
        this.mAdInfo = com.kwad.sdk.core.response.a.d.bQ(t);
    }

    public final void dx() {
        InterfaceC0612b interfaceC0612b = this.lp;
        if (interfaceC0612b != null) {
            interfaceC0612b.onAdClicked();
        }
    }

    public float getHWRatio() {
        return 0.0f;
    }

    public abstract int getLayoutId();

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        InterfaceC0612b interfaceC0612b = this.lp;
        if (interfaceC0612b != null) {
            interfaceC0612b.onDownloadTipsDialogDismiss();
        }
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
        InterfaceC0612b interfaceC0612b = this.lp;
        if (interfaceC0612b != null) {
            interfaceC0612b.onDownloadTipsDialogShow();
        }
    }

    public final void pX() {
        com.kwad.sdk.core.report.a.ap(this.mAdTemplate);
        InterfaceC0612b interfaceC0612b = this.lp;
        if (interfaceC0612b != null) {
            interfaceC0612b.onDislikeClicked();
        }
    }

    public void setInnerAdInteractionListener(InterfaceC0612b interfaceC0612b) {
        this.lp = interfaceC0612b;
    }

    public void setMargin(int i) {
        setPadding(i, i, i, i);
        setBackgroundColor(-1);
    }
}
