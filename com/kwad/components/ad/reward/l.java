package com.kwad.components.ad.reward;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
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
import com.ksad.json.annotation.KsJson;
import com.kwad.components.ad.reward.k.s;
import com.kwad.components.ad.reward.widget.RewardTaskStepView;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.yy.mobile.framework.revenuesdk.baseapi.ErrorCode;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class l extends com.kwad.components.core.i.e {
    public static String ng = "进阶奖励还差 %s 步到手，\n确认放弃吗？";
    public static String nh = "再观看%ss可获得基础奖励，\n确认放弃吗？";
    public AdTemplate mAdTemplate;
    public a nf;

    /* loaded from: classes9.dex */
    public interface a extends com.kwad.components.core.webview.b.d.c {
        void fJ();

        void g(int i, int i2);
    }

    /* loaded from: classes9.dex */
    public static class b implements a {
        @Override // com.kwad.components.core.webview.b.d.c
        public void G(boolean z) {
        }

        @Override // com.kwad.components.core.webview.b.d.c
        public void fH() {
        }

        @Override // com.kwad.components.core.webview.b.d.c
        public void fI() {
        }

        @Override // com.kwad.components.ad.reward.l.a
        public void fJ() {
        }

        @Override // com.kwad.components.ad.reward.l.a
        public void g(int i, int i2) {
        }
    }

    @KsJson
    /* loaded from: classes9.dex */
    public static class c extends com.kwad.sdk.core.response.kwai.a {
        public String kY;
        public com.kwad.components.ad.reward.i.a.a mK;
        public com.kwad.components.ad.reward.i.kwai.a mL;
        public String nm;
        public String nn;
        public String no;
        public String np;
        public String nq;
        public int style;
        public String title;

        public static c M(String str) {
            c cVar = new c();
            cVar.style = 0;
            cVar.title = str;
            cVar.nm = "关闭广告";
            cVar.nn = "继续观看";
            return cVar;
        }

        public static c N(String str) {
            c cVar = new c();
            cVar.style = 0;
            cVar.title = str;
            cVar.nm = "奖励不要了";
            cVar.nn = "返回";
            return cVar;
        }

        public static c O(String str) {
            c cVar = new c();
            try {
                cVar.parseJson(new JSONObject(str));
            } catch (JSONException unused) {
            }
            return cVar;
        }

        private void P(String str) {
            this.nq = str;
        }

        public static c a(com.kwad.components.ad.reward.i.a.a aVar, AdTemplate adTemplate, String str) {
            c cVar = new c();
            cVar.style = 1;
            cVar.mK = aVar;
            cVar.no = str;
            cVar.kY = com.kwad.sdk.core.response.a.a.bn(com.kwad.sdk.core.response.a.d.bQ(adTemplate));
            return cVar;
        }

        public static c a(com.kwad.components.ad.reward.i.kwai.a aVar, AdTemplate adTemplate, String str) {
            c cVar = new c();
            cVar.style = 2;
            cVar.mL = aVar;
            cVar.no = str;
            cVar.kY = com.kwad.sdk.core.response.a.a.bn(com.kwad.sdk.core.response.a.d.bQ(adTemplate));
            return cVar;
        }

        public static c a(AdInfo adInfo, long j) {
            c cVar = new c();
            cVar.style = 5;
            AdProductInfo bN = com.kwad.sdk.core.response.a.a.bN(adInfo);
            cVar.np = com.kwad.sdk.core.response.a.a.ad(adInfo);
            String name = bN.getName();
            cVar.title = name;
            if (TextUtils.isEmpty(name)) {
                cVar.title = com.kwad.sdk.core.response.a.a.af(adInfo);
            }
            cVar.kY = bN.getIcon();
            cVar.P(j > 0 ? String.valueOf(j) : null);
            return cVar;
        }

        public static c a(AdTemplate adTemplate, long j) {
            AdMatrixInfo.MerchantLiveReservationInfo bA = com.kwad.sdk.core.response.a.b.bA(adTemplate);
            c cVar = new c();
            cVar.style = 8;
            cVar.kY = bA.userHeadUrl;
            cVar.title = String.format("再看%s秒，可获得奖励", Long.valueOf(j));
            cVar.np = bA.title;
            cVar.nm = "放弃奖励";
            cVar.nn = "继续观看";
            return cVar;
        }

        public static c b(AdInfo adInfo, long j) {
            c cVar = new c();
            cVar.style = 7;
            cVar.np = com.kwad.sdk.core.response.a.a.ad(adInfo);
            cVar.title = com.kwad.sdk.core.response.a.a.bl(adInfo);
            cVar.kY = com.kwad.sdk.core.response.a.a.bn(adInfo);
            cVar.P(j > 0 ? String.valueOf(j) : null);
            return cVar;
        }

        public static c f(long j) {
            c cVar = new c();
            cVar.style = 6;
            cVar.nm = "残忍离开";
            cVar.nn = "留下看看";
            cVar.P(j > 0 ? String.valueOf(j) : null);
            return cVar;
        }

        public static c g(AdInfo adInfo) {
            c cVar = new c();
            cVar.style = 4;
            AdProductInfo bN = com.kwad.sdk.core.response.a.a.bN(adInfo);
            cVar.title = com.kwad.sdk.core.response.a.a.ad(adInfo);
            cVar.kY = bN.getIcon();
            return cVar;
        }

        @Override // com.kwad.sdk.core.response.kwai.a
        public void afterParseJson(@Nullable JSONObject jSONObject) {
            super.afterParseJson(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("mLaunchAppTask");
            if (optJSONObject != null) {
                if (this.mK == null) {
                    this.mK = new com.kwad.components.ad.reward.i.a.a();
                }
                this.mK.parseJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("mLandPageOpenTask");
            if (optJSONObject2 != null) {
                if (this.mL == null) {
                    this.mL = new com.kwad.components.ad.reward.i.kwai.a();
                }
                this.mL.parseJson(optJSONObject2);
            }
        }

        @Override // com.kwad.sdk.core.response.kwai.a
        public void afterToJson(JSONObject jSONObject) {
            super.afterToJson(jSONObject);
            com.kwad.components.ad.reward.i.a.a aVar = this.mK;
            if (aVar != null) {
                com.kwad.sdk.utils.r.a(jSONObject, "mLaunchAppTask", aVar);
            }
            com.kwad.components.ad.reward.i.kwai.a aVar2 = this.mL;
            if (aVar2 != null) {
                com.kwad.sdk.utils.r.a(jSONObject, "mLandPageOpenTask", aVar2);
            }
        }

        public final String eL() {
            return this.kY;
        }

        public final String fK() {
            return TextUtils.isEmpty(this.nm) ? "关闭广告" : this.nm;
        }

        public final String fL() {
            return TextUtils.isEmpty(this.nn) ? "继续观看" : this.nn;
        }

        public final com.kwad.components.ad.reward.i.a.a fM() {
            return this.mK;
        }

        public final com.kwad.components.ad.reward.i.kwai.a fN() {
            return this.mL;
        }

        public final String fO() {
            return this.np;
        }

        public final String fP() {
            return TextUtils.isEmpty(this.nq) ? "" : String.format("再看%s秒，可获得优惠", this.nq);
        }

        public final int getStyle() {
            return this.style;
        }

        public final String getTitle() {
            return this.title;
        }
    }

    public static View a(final DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, c cVar, final a aVar) {
        View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d04d3, viewGroup, false);
        ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0913bd)).setText(cVar.getTitle());
        TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09123d);
        TextView textView2 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091240);
        textView.setText(cVar.fK());
        textView2.setText(cVar.fL());
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.l.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                dialogFragment.dismiss();
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.G(false);
                }
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.l.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                dialogFragment.dismiss();
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.fI();
                }
            }
        });
        return inflate;
    }

    public static View a(DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, c cVar, AdTemplate adTemplate, a aVar) {
        return a(cVar.fM(), dialogFragment, layoutInflater, viewGroup, cVar, adTemplate, aVar);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x005a: INVOKE  (r6v1 int A[REMOVE]) = (r6v0 com.kwad.components.ad.reward.i.a) type: VIRTUAL call: com.kwad.components.ad.reward.i.a.is():int)] */
    public static View a(com.kwad.components.ad.reward.i.a aVar, final DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, c cVar, AdTemplate adTemplate, final a aVar2) {
        View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d04bd, viewGroup, false);
        if (aVar instanceof com.kwad.components.ad.reward.i.a.a) {
            com.kwad.components.ad.reward.i.a.a.a((com.kwad.components.ad.reward.i.a.a) aVar, inflate.getContext(), adTemplate);
        }
        ((RewardTaskStepView) inflate.findViewById(R.id.obfuscated_res_0x7f091379)).a(aVar.ir(), cVar.no);
        KSImageLoader.loadAppIcon((ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f091378), cVar.eL(), adTemplate, 12);
        TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091376);
        TextView textView2 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091377);
        TextView textView3 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09137a);
        StringBuilder sb = new StringBuilder();
        sb.append(aVar.is());
        String sb2 = sb.toString();
        String str = cVar.no;
        boolean equals = "0".equals(str);
        String format = equals ? String.format(ng, sb2) : String.format(nh, str);
        int indexOf = equals ? format.indexOf(sb2) : format.indexOf(str);
        if (indexOf < 0) {
            textView3.setText(format);
        } else {
            int i = equals ? indexOf + 1 : str.length() > 1 ? indexOf + 3 : indexOf + 2;
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(inflate.getContext().getResources().getColor(R.color.obfuscated_res_0x7f06078d));
            SpannableString spannableString = new SpannableString(format);
            spannableString.setSpan(foregroundColorSpan, indexOf, i, 17);
            textView3.setText(spannableString);
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.l.7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                dialogFragment.dismiss();
                a aVar3 = aVar2;
                if (aVar3 != null) {
                    aVar3.G(false);
                }
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.l.8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                dialogFragment.dismiss();
                a aVar3 = aVar2;
                if (aVar3 != null) {
                    aVar3.fI();
                }
            }
        });
        return inflate;
    }

    private View a(final l lVar, LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, c cVar, final a aVar) {
        View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d04d4, viewGroup, false);
        ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09131a)).setText(g(inflate.getContext(), cVar.nq));
        TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091318);
        TextView textView2 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091317);
        textView.setText(cVar.fK());
        textView2.setText(cVar.fL());
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.l.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                lVar.dismiss();
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.G(false);
                }
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.l.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                lVar.dismiss();
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.fI();
                }
            }
        });
        return inflate;
    }

    public static c a(k kVar, @Nullable String str) {
        int playDuration;
        AdTemplate adTemplate = kVar.mAdTemplate;
        AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
        com.kwad.components.ad.reward.j.a aVar = kVar.eF;
        com.kwad.components.ad.reward.i.a.a aVar2 = kVar.mK;
        com.kwad.components.ad.reward.i.kwai.a aVar3 = kVar.mL;
        int i = kVar.mM;
        boolean e = com.kwad.sdk.core.response.a.d.e(adTemplate, com.kwad.components.ad.reward.kwai.b.j(com.kwad.sdk.core.response.a.d.bQ(adTemplate)));
        int i2 = 0;
        if (e || com.kwad.sdk.core.response.a.d.p(adTemplate)) {
            int Q = (int) com.kwad.sdk.core.response.a.a.Q(bQ);
            int B = com.kwad.sdk.core.response.a.a.B(bQ);
            if (Q > B) {
                Q = B;
            }
            if (aVar.getPlayDuration() < (Q * 1000) + ErrorCode.CLIENT_CANCEL_REQUEST && (playDuration = (int) (Q - ((((float) aVar.getPlayDuration()) / 1000.0f) + 0.5f))) >= 0) {
                i2 = playDuration;
            }
        }
        return (!e || aVar2 == null) ? (!com.kwad.sdk.core.response.a.d.p(adTemplate) || aVar3 == null) ? com.kwad.components.ad.reward.kwai.b.h(bQ) ? c.g(bQ) : (com.kwad.sdk.core.response.a.a.bF(bQ) && com.kwad.components.ad.reward.kwai.b.gf() == 1) ? c.a(bQ, i) : com.kwad.sdk.core.response.a.a.bk(bQ) ? c.N(str) : com.kwad.sdk.core.response.a.a.aK(adTemplate) ? c.a(adTemplate, i) : com.kwad.components.ad.reward.kwai.b.fZ() == 1 ? c.f(i) : com.kwad.components.ad.reward.kwai.b.fZ() == 2 ? c.b(bQ, i) : c.M(str) : c.a(aVar3, adTemplate, String.valueOf(i2)) : c.a(aVar2, adTemplate, String.valueOf(i2));
    }

    public static l a(Activity activity, AdTemplate adTemplate, c cVar, a aVar) {
        l lVar = new l();
        Bundle bundle = new Bundle();
        bundle.putString("key_params_json", cVar.toJson().toString());
        bundle.putString("key_template_json", adTemplate.toJson().toString());
        lVar.setArguments(bundle);
        lVar.a(aVar);
        lVar.show(activity.getFragmentManager(), "videoCloseDialog");
        return lVar;
    }

    private void a(a aVar) {
        this.nf = aVar;
    }

    public static View b(DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, c cVar, AdTemplate adTemplate, a aVar) {
        return a(cVar.fN(), dialogFragment, layoutInflater, viewGroup, cVar, adTemplate, aVar);
    }

    public static View c(final DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, c cVar, AdTemplate adTemplate, final a aVar) {
        View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d04b8, viewGroup, false);
        KSImageLoader.loadImage((KSCornerImageView) inflate.findViewById(R.id.obfuscated_res_0x7f091358), cVar.kY, adTemplate);
        ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091357)).setText(cVar.getTitle());
        inflate.findViewById(R.id.obfuscated_res_0x7f091354).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.l.9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                dialogFragment.dismiss();
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.fI();
                }
            }
        });
        inflate.findViewById(R.id.obfuscated_res_0x7f091356).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.l.10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                a aVar2 = a.this;
                if (aVar2 != null) {
                    aVar2.fJ();
                }
            }
        });
        inflate.findViewById(R.id.obfuscated_res_0x7f091355).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.l.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                dialogFragment.dismiss();
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.G(false);
                }
            }
        });
        return inflate;
    }

    public static SpannableString g(Context context, String str) {
        SpannableString spannableString = new SpannableString("再看" + str + "秒，即可获得奖励");
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(com.kwad.sdk.b.kwai.a.getColor(context, R.color.obfuscated_res_0x7f06078d));
        ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(com.kwad.sdk.b.kwai.a.getColor(context, R.color.obfuscated_res_0x7f06078d));
        StyleSpan styleSpan = new StyleSpan(1);
        int length = spannableString.length();
        spannableString.setSpan(foregroundColorSpan, 2, length - 7, 34);
        spannableString.setSpan(foregroundColorSpan2, length - 2, length, 34);
        spannableString.setSpan(styleSpan, 0, length, 34);
        return spannableString;
    }

    @Override // com.kwad.components.core.i.e
    @Nullable
    public final View a(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        View a2;
        getDialog().requestWindowFeature(1);
        Bundle arguments = getArguments();
        String string = arguments.getString("key_params_json");
        try {
            String string2 = arguments.getString("key_template_json");
            AdTemplate adTemplate = new AdTemplate();
            this.mAdTemplate = adTemplate;
            adTemplate.parseJson(new JSONObject(string2));
        } catch (Throwable unused) {
        }
        c O = c.O(string);
        switch (O.getStyle()) {
            case 1:
                a2 = a(this, layoutInflater, viewGroup, O, this.mAdTemplate, this.nf);
                break;
            case 2:
                a2 = b(this, layoutInflater, viewGroup, O, this.mAdTemplate, this.nf);
                break;
            case 3:
            default:
                a2 = a((DialogFragment) this, layoutInflater, viewGroup, O, this.nf);
                break;
            case 4:
                a2 = c(this, layoutInflater, viewGroup, O, this.mAdTemplate, this.nf);
                com.kwad.components.core.m.j.a(new com.kwad.components.core.widget.f(), (ViewGroup) a2);
                break;
            case 5:
                com.kwad.components.ad.reward.k.i iVar = new com.kwad.components.ad.reward.k.i(this, this.mAdTemplate, layoutInflater, viewGroup, this.nf);
                iVar.a(O);
                a2 = iVar.fR();
                break;
            case 6:
                a2 = a(this, layoutInflater, viewGroup, O, this.nf);
                break;
            case 7:
                s sVar = new s(this, this.mAdTemplate, layoutInflater, viewGroup, this.nf);
                sVar.a(O);
                a2 = sVar.fR();
                break;
            case 8:
                com.kwad.components.ad.reward.k.l lVar = new com.kwad.components.ad.reward.k.l(this, layoutInflater, viewGroup, this.nf);
                lVar.a(O);
                a2 = lVar.fR();
                break;
        }
        getDialog().setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.kwad.components.ad.reward.l.1
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return i == 4 && keyEvent.getAction() == 0;
            }
        });
        return a2;
    }

    public final boolean isShowing() {
        Dialog dialog = getDialog();
        if (dialog != null) {
            return dialog.isShowing();
        }
        return false;
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
        a aVar = this.nf;
        if (aVar != null) {
            aVar.fH();
        }
    }
}
