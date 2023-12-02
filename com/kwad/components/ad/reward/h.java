package com.kwad.components.ad.reward;

import android.app.Activity;
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
import com.kwad.components.ad.reward.widget.RewardTaskStepView;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.t;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class h extends com.kwad.components.core.proxy.g {
    public static String pP = "进阶奖励还差 %s 步到手，\n确认放弃吗？";
    public static String pQ = "再观看%ss可获得基础奖励，\n确认放弃吗？";
    public AdTemplate mAdTemplate;
    public a pO;

    /* loaded from: classes10.dex */
    public interface a extends com.kwad.components.core.webview.tachikoma.e.c {
        void fW();

        void i(int i, int i2);
    }

    /* loaded from: classes10.dex */
    public static class b implements a {
        @Override // com.kwad.components.core.webview.tachikoma.e.c
        public void F(boolean z) {
        }

        @Override // com.kwad.components.core.webview.tachikoma.e.c
        public void fP() {
        }

        @Override // com.kwad.components.ad.reward.h.a
        public void fW() {
        }

        @Override // com.kwad.components.core.webview.tachikoma.e.c
        public void fX() {
        }

        @Override // com.kwad.components.core.webview.tachikoma.e.c
        public void fY() {
        }

        @Override // com.kwad.components.ad.reward.h.a
        public void i(int i, int i2) {
        }
    }

    @KsJson
    /* loaded from: classes10.dex */
    public static class c extends com.kwad.sdk.core.response.a.a {
        public String pV;
        public String pW;
        public String pX;
        public String pY;
        public String pZ;
        public com.kwad.components.ad.reward.l.b.a pp;
        public com.kwad.components.ad.reward.l.a.a pq;
        public String qa;
        public String qb;
        public String qc;
        public int style;
        public String title;

        public final String fZ() {
            if (TextUtils.isEmpty(this.pV)) {
                return "关闭广告";
            }
            return this.pV;
        }

        public final String ga() {
            if (TextUtils.isEmpty(this.pW)) {
                return "继续观看";
            }
            return this.pW;
        }

        public final com.kwad.components.ad.reward.l.b.a gb() {
            return this.pp;
        }

        public final com.kwad.components.ad.reward.l.a.a gc() {
            return this.pq;
        }

        public final String gd() {
            return this.pZ;
        }

        public final String ge() {
            return this.qa;
        }

        public final int getStyle() {
            return this.style;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String gf() {
            return this.qb;
        }

        public final String gg() {
            if (TextUtils.isEmpty(this.qc)) {
                return "";
            }
            return String.format("再看%s秒，可获得优惠", this.qc);
        }

        private void A(String str) {
            this.qc = str;
        }

        public static c h(AdInfo adInfo) {
            c cVar = new c();
            cVar.style = 4;
            AdProductInfo cM = com.kwad.sdk.core.response.b.a.cM(adInfo);
            cVar.title = com.kwad.sdk.core.response.b.a.au(adInfo);
            cVar.pZ = cM.getIcon();
            return cVar;
        }

        public static c j(long j) {
            c cVar = new c();
            cVar.style = 6;
            cVar.pV = "残忍离开";
            cVar.pW = "留下看看";
            if (j > 0) {
                cVar.A(String.valueOf(j));
            } else {
                cVar.A(null);
            }
            return cVar;
        }

        public static c y(String str) {
            c cVar = new c();
            cVar.style = 0;
            cVar.title = str;
            cVar.pV = "关闭广告";
            cVar.pW = "继续观看";
            return cVar;
        }

        public static c z(String str) {
            c cVar = new c();
            try {
                cVar.parseJson(new JSONObject(str));
            } catch (JSONException unused) {
            }
            return cVar;
        }

        @Override // com.kwad.sdk.core.response.a.a
        public void afterToJson(JSONObject jSONObject) {
            super.afterToJson(jSONObject);
            com.kwad.components.ad.reward.l.b.a aVar = this.pp;
            if (aVar != null) {
                t.a(jSONObject, "mLaunchAppTask", aVar);
            }
            com.kwad.components.ad.reward.l.a.a aVar2 = this.pq;
            if (aVar2 != null) {
                t.a(jSONObject, "mLandPageOpenTask", aVar2);
            }
        }

        public static c a(com.kwad.components.ad.reward.l.a.a aVar, AdTemplate adTemplate, String str) {
            c cVar = new c();
            cVar.style = 2;
            cVar.pq = aVar;
            cVar.pY = str;
            cVar.pZ = com.kwad.sdk.core.response.b.a.cf(com.kwad.sdk.core.response.b.e.dP(adTemplate));
            return cVar;
        }

        public static c a(com.kwad.components.ad.reward.l.b.a aVar, AdTemplate adTemplate, String str) {
            c cVar = new c();
            cVar.style = 1;
            cVar.pp = aVar;
            cVar.pY = str;
            cVar.pZ = com.kwad.sdk.core.response.b.a.cf(com.kwad.sdk.core.response.b.e.dP(adTemplate));
            return cVar;
        }

        public static c a(AdInfo adInfo, long j) {
            c cVar = new c();
            cVar.style = 5;
            AdProductInfo cM = com.kwad.sdk.core.response.b.a.cM(adInfo);
            cVar.qa = com.kwad.sdk.core.response.b.a.au(adInfo);
            String name = cM.getName();
            cVar.title = name;
            if (TextUtils.isEmpty(name)) {
                cVar.title = com.kwad.sdk.core.response.b.a.ax(adInfo);
            }
            cVar.pZ = cM.getIcon();
            if (j > 0) {
                cVar.A(String.valueOf(j));
            } else {
                cVar.A(null);
            }
            return cVar;
        }

        public static c b(AdTemplate adTemplate, long j) {
            AdInfo dP = com.kwad.sdk.core.response.b.e.dP(adTemplate);
            c cVar = new c();
            cVar.style = 8;
            cVar.pZ = com.kwad.sdk.core.response.b.a.cf(dP);
            cVar.title = String.format("再看%s秒，可获得奖励", Long.valueOf(j));
            cVar.qa = com.kwad.sdk.core.response.b.a.cc(dP);
            cVar.qb = com.kwad.sdk.core.response.b.a.au(dP);
            cVar.pV = "放弃奖励";
            cVar.pW = "继续观看";
            cVar.pX = com.kwad.sdk.core.response.b.a.aE(com.kwad.sdk.core.response.b.e.dP(adTemplate));
            return cVar;
        }

        public static c c(AdTemplate adTemplate, long j) {
            AdMatrixInfo.MerchantLiveReservationInfo da = com.kwad.sdk.core.response.b.b.da(adTemplate);
            c cVar = new c();
            cVar.style = 8;
            cVar.pZ = da.userHeadUrl;
            cVar.title = String.format("再看%s秒，可获得奖励", Long.valueOf(j));
            cVar.qa = da.title;
            cVar.pV = "放弃奖励";
            cVar.pW = "继续观看";
            cVar.pX = com.kwad.sdk.core.response.b.a.aE(com.kwad.sdk.core.response.b.e.dP(adTemplate));
            return cVar;
        }

        public static c i(String str, int i) {
            c cVar = new c();
            cVar.style = 6;
            cVar.title = str;
            cVar.pV = "残忍离开";
            cVar.pW = "留下看看";
            if (i > 0) {
                cVar.qc = String.valueOf(i);
            }
            return cVar;
        }

        @Override // com.kwad.sdk.core.response.a.a
        public void afterParseJson(@Nullable JSONObject jSONObject) {
            super.afterParseJson(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("mLaunchAppTask");
            if (optJSONObject != null) {
                if (this.pp == null) {
                    this.pp = new com.kwad.components.ad.reward.l.b.a();
                }
                this.pp.parseJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("mLandPageOpenTask");
            if (optJSONObject2 != null) {
                if (this.pq == null) {
                    this.pq = new com.kwad.components.ad.reward.l.a.a();
                }
                this.pq.parseJson(optJSONObject2);
            }
        }
    }

    public static View a(final DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, c cVar, final a aVar) {
        View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0524, viewGroup, false);
        ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0914d9)).setText(cVar.getTitle());
        TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09132d);
        TextView textView2 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09133d);
        textView.setText(cVar.fZ());
        textView2.setText(cVar.ga());
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.h.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                dialogFragment.dismiss();
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.F(false);
                }
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.h.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                dialogFragment.dismiss();
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.fY();
                }
            }
        });
        return inflate;
    }

    public static View a(DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, c cVar, AdTemplate adTemplate, a aVar) {
        return a(cVar.gb(), dialogFragment, layoutInflater, viewGroup, cVar, adTemplate, aVar);
    }

    public static View b(DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, c cVar, AdTemplate adTemplate, a aVar) {
        return a(cVar.gc(), dialogFragment, layoutInflater, viewGroup, cVar, adTemplate, aVar);
    }

    private View a(final h hVar, LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, c cVar, final a aVar) {
        View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0525, viewGroup, false);
        ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091423)).setText(e(inflate.getContext(), cVar.qc));
        TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091421);
        TextView textView2 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091420);
        textView.setText(cVar.fZ());
        textView2.setText(cVar.ga());
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.h.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                hVar.dismiss();
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.F(false);
                }
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.h.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                hVar.dismiss();
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.fY();
                }
            }
        });
        return inflate;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x005a: INVOKE  (r6v1 int A[REMOVE]) = (r6v0 com.kwad.components.ad.reward.l.a) type: VIRTUAL call: com.kwad.components.ad.reward.l.a.jp():int)] */
    public static View a(com.kwad.components.ad.reward.l.a aVar, final DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, c cVar, AdTemplate adTemplate, final a aVar2) {
        String format;
        int indexOf;
        int i;
        View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d050b, viewGroup, false);
        if (aVar instanceof com.kwad.components.ad.reward.l.b.a) {
            com.kwad.components.ad.reward.l.b.a.a((com.kwad.components.ad.reward.l.b.a) aVar, inflate.getContext(), adTemplate);
        }
        ((RewardTaskStepView) inflate.findViewById(R.id.obfuscated_res_0x7f09147f)).a(aVar.jo(), cVar.pY);
        KSImageLoader.loadAppIcon((ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f09147e), cVar.gd(), adTemplate, 12);
        TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09147c);
        TextView textView2 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09147d);
        TextView textView3 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091480);
        StringBuilder sb = new StringBuilder();
        sb.append(aVar.jp());
        String sb2 = sb.toString();
        String str = cVar.pY;
        boolean equals = "0".equals(str);
        if (equals) {
            format = String.format(pP, sb2);
        } else {
            format = String.format(pQ, str);
        }
        if (equals) {
            indexOf = format.indexOf(sb2);
        } else {
            indexOf = format.indexOf(str);
        }
        if (indexOf < 0) {
            textView3.setText(format);
        } else {
            if (equals) {
                i = indexOf + 1;
            } else if (str.length() > 1) {
                i = indexOf + 3;
            } else {
                i = indexOf + 2;
            }
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(inflate.getContext().getResources().getColor(R.color.obfuscated_res_0x7f0607a6));
            SpannableString spannableString = new SpannableString(format);
            spannableString.setSpan(foregroundColorSpan, indexOf, i, 17);
            textView3.setText(spannableString);
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.h.7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                dialogFragment.dismiss();
                a aVar3 = aVar2;
                if (aVar3 != null) {
                    aVar3.F(false);
                }
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.h.8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                dialogFragment.dismiss();
                a aVar3 = aVar2;
                if (aVar3 != null) {
                    aVar3.fY();
                }
            }
        });
        return inflate;
    }

    public static c a(g gVar, @Nullable String str) {
        int i;
        AdTemplate adTemplate = gVar.mAdTemplate;
        AdInfo dP = com.kwad.sdk.core.response.b.e.dP(adTemplate);
        com.kwad.components.ad.reward.l.b.a aVar = gVar.pp;
        com.kwad.components.ad.reward.l.a.a aVar2 = gVar.pq;
        int i2 = gVar.pr;
        boolean i3 = com.kwad.sdk.core.response.b.e.i(adTemplate, com.kwad.components.ad.reward.a.b.k(com.kwad.sdk.core.response.b.e.dP(adTemplate)));
        int i4 = 0;
        if (i3 || com.kwad.sdk.core.response.b.e.F(adTemplate)) {
            int ad = (int) com.kwad.sdk.core.response.b.a.ad(dP);
            int L = com.kwad.sdk.core.response.b.a.L(dP);
            if (ad > L) {
                ad = L;
            }
            long playDuration = gVar.oI.getPlayDuration();
            if (playDuration < (ad * 1000) - 800 && (i = (int) (ad - ((((float) playDuration) / 1000.0f) + 0.5f))) >= 0) {
                i4 = i;
            }
        }
        if (i3 && aVar != null) {
            return c.a(aVar, adTemplate, String.valueOf(i4));
        }
        if (com.kwad.sdk.core.response.b.e.F(adTemplate) && aVar2 != null) {
            return c.a(aVar2, adTemplate, String.valueOf(i4));
        }
        if (com.kwad.components.ad.reward.a.b.i(dP)) {
            return c.h(dP);
        }
        if (com.kwad.sdk.core.response.b.a.cb(dP) == 1 && com.kwad.components.ad.reward.a.b.gx() == 1) {
            return c.a(dP, i2);
        }
        if (adTemplate.isNativeRewardPreview) {
            return c.i(str, i2);
        }
        if (com.kwad.sdk.core.response.b.a.cJ(dP)) {
            return c.b(adTemplate, i2);
        }
        if (com.kwad.sdk.core.response.b.a.ca(adTemplate)) {
            return c.c(adTemplate, i2);
        }
        if (com.kwad.components.ad.reward.a.b.gr() == 1) {
            return c.j(i2);
        }
        return c.y(str);
    }

    public static h a(Activity activity, AdTemplate adTemplate, c cVar, a aVar) {
        h hVar = new h();
        Bundle bundle = new Bundle();
        bundle.putString("key_params_json", cVar.toJson().toString());
        bundle.putString("key_template_json", adTemplate.toJson().toString());
        hVar.setArguments(bundle);
        hVar.a(aVar);
        hVar.show(activity.getFragmentManager(), "videoCloseDialog");
        return hVar;
    }

    private void a(a aVar) {
        this.pO = aVar;
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
        a aVar = this.pO;
        if (aVar != null) {
            aVar.fP();
        }
    }

    public static View c(final DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, c cVar, AdTemplate adTemplate, final a aVar) {
        View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0506, viewGroup, false);
        KSImageLoader.loadImage((KSCornerImageView) inflate.findViewById(R.id.obfuscated_res_0x7f091461), cVar.pZ, adTemplate);
        ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091460)).setText(cVar.getTitle());
        inflate.findViewById(R.id.obfuscated_res_0x7f09145d).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.h.9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                dialogFragment.dismiss();
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.fY();
                }
            }
        });
        inflate.findViewById(R.id.obfuscated_res_0x7f09145f).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.h.10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                a aVar2 = a.this;
                if (aVar2 != null) {
                    aVar2.fW();
                }
            }
        });
        inflate.findViewById(R.id.obfuscated_res_0x7f09145e).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.h.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                dialogFragment.dismiss();
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.F(false);
                }
            }
        });
        return inflate;
    }

    public static SpannableString e(Context context, String str) {
        SpannableString spannableString = new SpannableString("再看" + str + "秒，即可获得奖励");
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(com.kwad.sdk.d.a.a.getColor(context, R.color.obfuscated_res_0x7f0607a6));
        ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(com.kwad.sdk.d.a.a.getColor(context, R.color.obfuscated_res_0x7f0607a6));
        StyleSpan styleSpan = new StyleSpan(1);
        int length = spannableString.length();
        spannableString.setSpan(foregroundColorSpan, 2, length - 7, 34);
        spannableString.setSpan(foregroundColorSpan2, length - 2, length, 34);
        spannableString.setSpan(styleSpan, 0, length, 34);
        return spannableString;
    }

    public static c h(String str, int i) {
        return c.i(str, i);
    }

    @Override // com.kwad.components.core.proxy.g
    @Nullable
    public final View a(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        View a2;
        Bundle arguments = getArguments();
        String string = arguments.getString("key_params_json");
        try {
            String string2 = arguments.getString("key_template_json");
            AdTemplate adTemplate = new AdTemplate();
            this.mAdTemplate = adTemplate;
            adTemplate.parseJson(new JSONObject(string2));
        } catch (Throwable unused) {
        }
        c z = c.z(string);
        int style = z.getStyle();
        if (style != 1) {
            if (style != 2) {
                if (style != 4) {
                    if (style != 5) {
                        if (style != 6) {
                            if (style != 8) {
                                a2 = a((DialogFragment) this, layoutInflater, viewGroup, z, this.pO);
                            } else {
                                com.kwad.components.ad.reward.n.m mVar = new com.kwad.components.ad.reward.n.m(this, this.mAdTemplate, layoutInflater, viewGroup, this.pO);
                                mVar.a(z);
                                a2 = mVar.gD();
                            }
                        } else {
                            a2 = a(this, layoutInflater, viewGroup, z, this.pO);
                        }
                    } else {
                        com.kwad.components.ad.reward.n.j jVar = new com.kwad.components.ad.reward.n.j(this, this.mAdTemplate, layoutInflater, viewGroup, this.pO);
                        jVar.a(z);
                        a2 = jVar.gD();
                    }
                } else {
                    a2 = c(this, layoutInflater, viewGroup, z, this.mAdTemplate, this.pO);
                    com.kwad.components.core.s.i.a(new com.kwad.components.core.widget.e(), (ViewGroup) a2);
                }
            } else {
                a2 = b(this, layoutInflater, viewGroup, z, this.mAdTemplate, this.pO);
            }
        } else {
            a2 = a(this, layoutInflater, viewGroup, z, this.mAdTemplate, this.pO);
        }
        getDialog().setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.kwad.components.ad.reward.h.1
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (i == 4 && keyEvent.getAction() == 0) {
                    return true;
                }
                return false;
            }
        });
        return a2;
    }
}
