package com.kwad.components.core.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.widget.a;
import com.kwad.components.core.widget.c;
import com.kwad.components.model.FeedType;
import com.kwad.sdk.core.report.j;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.m.l;
import com.kwad.sdk.utils.bm;
import com.kwad.sdk.widget.KSFrameLayout;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public abstract class b<T extends AdResultData, R extends AdTemplate> extends KSFrameLayout implements DialogInterface.OnDismissListener, DialogInterface.OnShowListener, com.kwad.sdk.core.h.c {
    public a aaZ;
    public long aba;
    public com.kwad.components.core.widget.a.b bQ;
    public com.kwad.sdk.core.h.b bT;
    public AdInfo mAdInfo;
    @NonNull
    public T mAdResultData;
    @NonNull
    public R mAdTemplate;
    @NonNull
    public Context mContext;
    public bm mTimerHelper;
    public boolean mr;

    /* loaded from: classes10.dex */
    public interface a {
        void onAdClicked();

        void onAdShow();

        void onDislikeClicked();

        void onDownloadTipsDialogDismiss();

        void onDownloadTipsDialogShow();
    }

    public void aM() {
    }

    public void aN() {
    }

    public abstract void bc();

    public void bf() {
    }

    public float getHWRatio() {
        return 0.0f;
    }

    public abstract int getLayoutId();

    public b(@NonNull Context context) {
        this(context, null);
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

    public final void aH(int i) {
        com.kwad.sdk.core.report.a.a(this.mAdTemplate, i, getTouchCoords());
        a aVar = this.aaZ;
        if (aVar != null) {
            aVar.onAdClicked();
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        a aVar = this.aaZ;
        if (aVar != null) {
            aVar.onDownloadTipsDialogDismiss();
        }
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
        a aVar = this.aaZ;
        if (aVar != null) {
            aVar.onDownloadTipsDialogShow();
        }
    }

    public void setInnerAdInteractionListener(a aVar) {
        this.aaZ = aVar;
    }

    public void setMargin(int i) {
        setPadding(i, i, i, i);
        setBackgroundColor(-1);
    }

    public void setPageExitListener(com.kwad.sdk.core.h.b bVar) {
        this.bT = bVar;
    }

    public b(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        initView();
    }

    private void a(ViewGroup viewGroup) {
        if (!com.kwad.sdk.core.config.d.Bd() && com.kwad.sdk.core.config.d.Bc() >= 0.0f) {
            c(viewGroup);
            com.kwad.components.core.widget.a aVar = new com.kwad.components.core.widget.a(viewGroup.getContext(), viewGroup);
            viewGroup.addView(aVar);
            aVar.setViewCallback(new a.InterfaceC0673a() { // from class: com.kwad.components.core.widget.b.1
                @Override // com.kwad.components.core.widget.a.InterfaceC0673a
                public final void ac() {
                }

                @Override // com.kwad.components.core.widget.a.InterfaceC0673a
                public final void k(View view2) {
                    if (!b.this.mAdTemplate.mPvReported) {
                        b bVar = b.this;
                        if (bVar.aaZ != null) {
                            bVar.mr = true;
                            bVar.bv();
                            b.this.getTimerHelper().startTiming();
                        }
                    }
                    b bVar2 = b.this;
                    if (!bVar2.mr) {
                        bVar2.getTimerHelper().startTiming();
                    }
                    b.this.mr = true;
                }

                @Override // com.kwad.components.core.widget.a.InterfaceC0673a
                public final void ad() {
                    if (b.this.mAdTemplate.mPvReported) {
                        b bVar = b.this;
                        if (bVar.mr) {
                            long LO = bVar.getTimerHelper().LO();
                            b.this.aba += LO;
                            com.kwad.sdk.core.report.a.a(b.this.mAdTemplate, LO, (JSONObject) null);
                            b.this.mr = false;
                        }
                    }
                }

                @Override // com.kwad.components.core.widget.a.InterfaceC0673a
                public final void eo() {
                    if (b.this.mAdTemplate.mPvReported) {
                        b bVar = b.this;
                        if (bVar.mr) {
                            long LO = bVar.getTimerHelper().LO();
                            b.this.aba += LO;
                            com.kwad.sdk.core.report.a.a(b.this.mAdTemplate, LO, (JSONObject) null);
                            b.this.mr = false;
                        }
                    }
                }
            });
            aVar.sY();
            return;
        }
        c b = b(viewGroup);
        if (b == null) {
            b = new c(viewGroup.getContext(), viewGroup);
            viewGroup.addView(b);
        }
        b.setViewCallback(new c.a() { // from class: com.kwad.components.core.widget.b.2
            @Override // com.kwad.components.core.widget.c.a
            public final void ep() {
                b.this.bv();
            }
        });
        b.setNeedCheckingShow(true);
    }

    private void initView() {
        l.inflate(this.mContext, getLayoutId(), this);
        setRatio(getHWRatio());
        bc();
        this.bQ = new com.kwad.components.core.widget.a.b(this, 70);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void ac() {
        super.ac();
        this.bQ.a(this);
        this.bQ.a(this.bT);
        this.bQ.tm();
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void ad() {
        super.ad();
        this.bQ.tn();
        this.bQ.b(this);
        bf();
    }

    public long getStayTime() {
        return this.aba + getTimerHelper().getTime();
    }

    public bm getTimerHelper() {
        if (this.mTimerHelper == null) {
            this.mTimerHelper = new bm();
        }
        return this.mTimerHelper;
    }

    public final void sZ() {
        a aVar = this.aaZ;
        if (aVar != null) {
            aVar.onAdClicked();
        }
    }

    public final void ta() {
        com.kwad.sdk.core.report.a.bH(this.mAdTemplate);
        a aVar = this.aaZ;
        if (aVar != null) {
            aVar.onDislikeClicked();
        }
    }

    public void b(@NonNull T t) {
        this.mAdResultData = t;
        R r = (R) com.kwad.sdk.core.response.b.c.m(t);
        this.mAdTemplate = r;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.dP(r);
        a((ViewGroup) this);
    }

    public final void c(@NonNull j jVar) {
        jVar.d(getTouchCoords());
        com.kwad.sdk.core.report.a.a(this.mAdTemplate, jVar, (JSONObject) null);
        a aVar = this.aaZ;
        if (aVar != null) {
            aVar.onAdClicked();
        }
    }

    public void bv() {
        a aVar;
        if (!this.mAdTemplate.mPvReported && (aVar = this.aaZ) != null) {
            aVar.onAdShow();
        }
        j jVar = new j();
        y.a aVar2 = new y.a();
        FeedType fromInt = FeedType.fromInt(this.mAdTemplate.type);
        if (fromInt == FeedType.FEED_TYPE_TEXT_NEW) {
            fromInt = FeedType.FEED_TYPE_TEXT_BELOW;
        }
        aVar2.templateId = String.valueOf(fromInt.getType());
        jVar.a(aVar2);
        jVar.x(getHeight(), getWidth());
        com.kwad.components.core.s.b.qL().a(this.mAdTemplate, null, jVar);
    }
}
