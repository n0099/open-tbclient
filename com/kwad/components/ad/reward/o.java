package com.kwad.components.ad.reward;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.components.ad.reward.k.u;
import com.kwad.components.ad.widget.KsPriceView;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.components.core.widget.KsStyledTextButton;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class o extends com.kwad.components.core.i.e {
    public static o nu;
    public AdTemplate mAdTemplate;
    public b nv;
    public e nw;

    /* loaded from: classes8.dex */
    public interface a extends com.kwad.components.core.webview.b.d.c {
        void M(int i);

        void fQ();
    }

    /* loaded from: classes8.dex */
    public static class b implements a {
        public o ny;
        public a nz;

        public b(@Nullable o oVar, @Nullable a aVar) {
            this.nz = aVar;
            this.ny = oVar;
        }

        private void cY() {
            o oVar = this.ny;
            if (oVar != null) {
                oVar.dismiss();
            }
        }

        @Override // com.kwad.components.core.webview.b.d.c
        public void G(boolean z) {
            cY();
            a aVar = this.nz;
            if (aVar != null) {
                aVar.G(z);
            }
        }

        @Override // com.kwad.components.ad.reward.o.a
        public void M(int i) {
            a aVar = this.nz;
            if (aVar != null) {
                aVar.M(i);
            }
        }

        public final void destroy() {
            this.ny = null;
        }

        @Override // com.kwad.components.core.webview.b.d.c
        public final void fH() {
            a aVar = this.nz;
            if (aVar != null) {
                aVar.fH();
            }
        }

        @Override // com.kwad.components.core.webview.b.d.c
        public final void fI() {
        }

        @Override // com.kwad.components.ad.reward.o.a
        public void fQ() {
            a aVar = this.nz;
            if (aVar != null) {
                aVar.fQ();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class c extends e implements View.OnClickListener {
        public View kP;
        public TextView nA;
        public TextView nB;
        public ImageView nC;
        public TextView nD;
        public TextView nE;
        public a nF;

        public c(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super((byte) 0);
            this.nL = (ViewGroup) layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0476, viewGroup, false);
            initView();
        }

        private void a(com.kwad.components.ad.reward.model.a aVar) {
            this.nD.setText(aVar.gJ());
            this.eQ.setText(aVar.getTitle());
            String gE = aVar.gE();
            if (!TextUtils.isEmpty(gE)) {
                String format = String.format("当前已经有%s预约", gE);
                int color = this.nL.getResources().getColor(R.color.obfuscated_res_0x7f060621);
                int indexOf = format.indexOf(gE);
                SpannableString spannableString = new SpannableString(format);
                spannableString.setSpan(new ForegroundColorSpan(color), indexOf, gE.length() + indexOf, 17);
                this.nE.setText(spannableString);
            }
            this.nA.setText(aVar.gF());
            this.nB.setText(aVar.gG());
            KSImageLoader.loadCircleIcon(this.nC, aVar.eL(), this.nC.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c88));
        }

        private void initView() {
            ViewGroup viewGroup = this.nL;
            if (viewGroup == null) {
                return;
            }
            this.kP = viewGroup.findViewById(R.id.obfuscated_res_0x7f091263);
            this.nA = (TextView) this.nL.findViewById(R.id.obfuscated_res_0x7f091264);
            this.nB = (TextView) this.nL.findViewById(R.id.obfuscated_res_0x7f091265);
            this.nC = (ImageView) this.nL.findViewById(R.id.obfuscated_res_0x7f091266);
            this.nD = (TextView) this.nL.findViewById(R.id.obfuscated_res_0x7f091268);
            this.eQ = (TextView) this.nL.findViewById(R.id.obfuscated_res_0x7f09126a);
            this.nE = (TextView) this.nL.findViewById(R.id.obfuscated_res_0x7f091269);
            this.kP.setOnClickListener(this);
            this.nB.setOnClickListener(this);
            this.nA.setOnClickListener(this);
            this.nC.setOnClickListener(this);
            this.nD.setOnClickListener(this);
            this.eQ.setOnClickListener(this);
            this.nE.setOnClickListener(this);
        }

        @Override // com.kwad.components.ad.reward.k.d
        public final void a(u uVar) {
            super.a(uVar);
            AdTemplate adTemplate = uVar.getAdTemplate();
            if (adTemplate != null) {
                a(com.kwad.components.ad.reward.model.a.x(adTemplate));
            }
        }

        public final void a(a aVar) {
            this.nF = aVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            if (this.nF == null) {
                return;
            }
            if (view2.equals(this.nB)) {
                this.nF.M(38);
            } else if (view2.equals(this.nA)) {
                this.nF.M(37);
            } else if (view2.equals(this.kP)) {
                this.nF.G(false);
            } else if (view2.equals(this.nC) || view2.equals(this.eQ) || view2.equals(this.nD) || view2.equals(this.nE)) {
                this.nF.fQ();
            }
        }

        @Override // com.kwad.components.ad.reward.o.e
        public final void s(AdTemplate adTemplate) {
            super.s(adTemplate);
            com.kwad.sdk.core.report.a.c(adTemplate, 19, (JSONObject) null);
        }
    }

    /* loaded from: classes8.dex */
    public static class d extends e implements View.OnClickListener {
        public ViewGroup es;
        public a nF;
        public KSCornerImageView nG;
        public TextView nH;
        public KsPriceView nI;
        public KsStyledTextButton nJ;
        public View nK;

        public d(ViewGroup viewGroup) {
            super((byte) 0);
            this.es = viewGroup;
            initView();
        }

        private void a(com.kwad.components.ad.reward.model.a aVar, AdTemplate adTemplate) {
            this.nJ.setText(aVar.gx());
            this.eQ.setText(aVar.getTitle());
            this.nH.setText(aVar.fO());
            this.nI.f(aVar.getPrice(), aVar.getOriginPrice());
            KSImageLoader.loadImage(this.nG, aVar.eL(), adTemplate);
        }

        private void initView() {
            this.nL = (ViewGroup) this.es.findViewById(R.id.obfuscated_res_0x7f091313);
            this.eQ = (TextView) this.es.findViewById(R.id.obfuscated_res_0x7f091317);
            this.nG = (KSCornerImageView) this.es.findViewById(R.id.obfuscated_res_0x7f091315);
            this.nH = (TextView) this.es.findViewById(R.id.obfuscated_res_0x7f091314);
            this.nI = (KsPriceView) this.es.findViewById(R.id.obfuscated_res_0x7f091316);
            this.nJ = (KsStyledTextButton) this.es.findViewById(R.id.obfuscated_res_0x7f091310);
            this.nK = this.es.findViewById(R.id.obfuscated_res_0x7f091311);
            this.nJ.setOnClickListener(this);
            this.nK.setOnClickListener(this);
            this.nH.setOnClickListener(this);
            this.nI.setOnClickListener(this);
            this.eQ.setOnClickListener(this);
        }

        @Override // com.kwad.components.ad.reward.k.d
        public final void a(u uVar) {
            super.a(uVar);
            a(com.kwad.components.ad.reward.model.a.v(uVar.getAdTemplate()), uVar.getAdTemplate());
        }

        public final void a(a aVar) {
            this.nF = aVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            if (this.nF == null) {
                return;
            }
            if (view2.equals(this.nK)) {
                this.nF.G(false);
            } else if (view2.equals(this.nJ)) {
                this.nF.M(15);
            } else if (view2.equals(this.nH) || view2.equals(this.eQ) || view2.equals(this.nI)) {
                this.nF.fQ();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static abstract class e extends com.kwad.components.ad.reward.k.d {
        public TextView eQ;
        public ViewGroup nL;

        public e() {
        }

        public /* synthetic */ e(byte b) {
            this();
        }

        @Override // com.kwad.components.ad.reward.k.d
        public final ViewGroup fR() {
            return this.nL;
        }

        public void s(AdTemplate adTemplate) {
        }
    }

    public static void a(Activity activity, AdTemplate adTemplate, b bVar) {
        if (adTemplate == null || activity == null || activity.isFinishing()) {
            return;
        }
        nu = new o();
        Bundle bundle = new Bundle();
        bundle.putString("key_template_json", adTemplate.toJson().toString());
        bVar.ny = nu;
        nu.setArguments(bundle);
        nu.a(bVar);
        try {
            nu.show(activity.getFragmentManager(), "videoEndDialog");
        } catch (Exception unused) {
        }
    }

    private void a(b bVar) {
        this.nv = bVar;
    }

    public static int r(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return -1;
        }
        if (com.kwad.components.ad.reward.kwai.b.h(com.kwad.sdk.core.response.a.d.bQ(adTemplate))) {
            return 1;
        }
        return com.kwad.sdk.core.response.a.a.aK(adTemplate) ? 2 : -1;
    }

    @Override // com.kwad.components.core.i.e
    @Nullable
    public final View a(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        com.kwad.components.core.widget.f fVar;
        View fR;
        getDialog().requestWindowFeature(1);
        try {
            String string = getArguments().getString("key_template_json");
            AdTemplate adTemplate = new AdTemplate();
            this.mAdTemplate = adTemplate;
            adTemplate.parseJson(new JSONObject(string));
        } catch (Throwable th) {
            com.kwad.sdk.core.e.b.printStackTraceOnly(th);
        }
        if (r(this.mAdTemplate) != 2) {
            fR = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0496, viewGroup, false);
            d dVar = new d((ViewGroup) fR);
            dVar.a(new b(this, this.nv));
            this.nw = dVar;
            fVar = new com.kwad.components.core.widget.f();
        } else {
            c cVar = new c(layoutInflater, viewGroup);
            cVar.a(new b(this, this.nv));
            this.nw = cVar;
            fVar = null;
            fR = cVar.fR();
        }
        this.nw.b(u.D(this.mAdTemplate));
        com.kwad.components.core.m.j.a(fVar, this.nw.fR());
        getDialog().setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.kwad.components.ad.reward.o.1
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return i == 4 && keyEvent.getAction() == 0;
            }
        });
        return fR;
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public final void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        Window window = getDialog().getWindow();
        if (window == null) {
            return;
        }
        getDialog().setCanceledOnTouchOutside(false);
        window.setLayout(-1, -1);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        b bVar = this.nv;
        if (bVar != null) {
            bVar.fH();
        }
        e eVar = this.nw;
        if (eVar != null) {
            eVar.s(this.mAdTemplate);
        }
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        nu = null;
        b bVar = this.nv;
        if (bVar != null) {
            bVar.destroy();
        }
    }
}
