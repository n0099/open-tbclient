package com.kwad.sdk.reward;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.w;
import com.kwad.sdk.widget.KSCornerImageView;
import com.kwad.sdk.widget.KsPriceView;
import com.kwad.sdk.widget.KsStyledTextButton;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class l extends com.kwad.sdk.h.e {
    public static l a;

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f57534b;

    /* renamed from: c  reason: collision with root package name */
    public a f57535c;

    /* loaded from: classes4.dex */
    public interface a {
        void a();

        void b();

        void c();

        void d();
    }

    /* loaded from: classes4.dex */
    public static class b implements a {
        public l a;

        /* renamed from: b  reason: collision with root package name */
        public a f57536b;

        public b(@Nullable l lVar, @Nullable a aVar) {
            this.f57536b = aVar;
            this.a = lVar;
        }

        @Override // com.kwad.sdk.reward.l.a
        public void a() {
            a aVar = this.f57536b;
            if (aVar != null) {
                aVar.a();
            }
        }

        @Override // com.kwad.sdk.reward.l.a
        public void b() {
            e();
            a aVar = this.f57536b;
            if (aVar != null) {
                aVar.b();
            }
        }

        @Override // com.kwad.sdk.reward.l.a
        public void c() {
            a aVar = this.f57536b;
            if (aVar != null) {
                aVar.c();
            }
        }

        @Override // com.kwad.sdk.reward.l.a
        public void d() {
            e();
            a aVar = this.f57536b;
            if (aVar != null) {
                aVar.d();
            }
        }

        public void e() {
            l lVar = this.a;
            if (lVar != null) {
                lVar.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class c extends com.kwad.sdk.reward.d.d implements View.OnClickListener {
        public ViewGroup a;

        /* renamed from: b  reason: collision with root package name */
        public a f57537b;

        /* renamed from: c  reason: collision with root package name */
        public ViewGroup f57538c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f57539d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f57540e;

        /* renamed from: f  reason: collision with root package name */
        public KSCornerImageView f57541f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f57542g;

        /* renamed from: h  reason: collision with root package name */
        public KsStyledTextButton f57543h;

        /* renamed from: i  reason: collision with root package name */
        public View f57544i;

        /* renamed from: j  reason: collision with root package name */
        public AdTemplate f57545j;

        public c(ViewGroup viewGroup, AdTemplate adTemplate) {
            this.a = viewGroup;
            this.f57545j = adTemplate;
            b();
        }

        private void a(e eVar) {
            this.f57539d.setText(eVar.b());
            SpannableString g2 = eVar.g();
            if (g2 != null) {
                this.f57540e.setText(g2);
            }
            this.f57542g.setText(eVar.c());
            this.f57543h.setText(eVar.d());
            KSImageLoader.loadImage(this.f57541f, eVar.a(), this.f57545j);
        }

        private void b() {
            this.f57538c = (ViewGroup) this.a.findViewById(R.id.ksad_reward_follow_end_root);
            this.f57539d = (TextView) this.a.findViewById(R.id.ksad_reward_follow_end_title);
            this.f57540e = (TextView) this.a.findViewById(R.id.ksad_reward_follow_end_fans);
            this.f57541f = (KSCornerImageView) this.a.findViewById(R.id.ksad_reward_follow_end_icon);
            this.f57542g = (TextView) this.a.findViewById(R.id.ksad_reward_follow_end_desc);
            this.f57543h = (KsStyledTextButton) this.a.findViewById(R.id.ksad_reward_follow_end_btn_follow);
            this.f57544i = this.a.findViewById(R.id.ksad_reward_follow_end_btn_close);
            this.f57543h.setOnClickListener(this);
            this.f57544i.setOnClickListener(this);
            this.f57541f.setOnClickListener(this);
            this.f57539d.setOnClickListener(this);
            this.f57540e.setOnClickListener(this);
            this.f57542g.setOnClickListener(this);
        }

        @Override // com.kwad.sdk.reward.d.d
        public ViewGroup a() {
            return this.f57538c;
        }

        @Override // com.kwad.sdk.reward.d.d
        public void a(AdTemplate adTemplate) {
            super.a(adTemplate);
            a(e.a(adTemplate));
        }

        public void a(a aVar) {
            this.f57537b = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f57537b == null) {
                return;
            }
            if (view.equals(this.f57544i)) {
                this.f57537b.b();
            } else if (view.equals(this.f57543h)) {
                this.f57537b.c();
            } else if (view.equals(this.f57542g) || view.equals(this.f57539d) || view.equals(this.f57540e)) {
                this.f57537b.d();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class d extends com.kwad.sdk.reward.d.d implements View.OnClickListener {
        public ViewGroup a;

        /* renamed from: b  reason: collision with root package name */
        public a f57546b;

        /* renamed from: c  reason: collision with root package name */
        public ViewGroup f57547c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f57548d;

        /* renamed from: e  reason: collision with root package name */
        public KSCornerImageView f57549e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f57550f;

        /* renamed from: g  reason: collision with root package name */
        public KsPriceView f57551g;

        /* renamed from: h  reason: collision with root package name */
        public KsStyledTextButton f57552h;

        /* renamed from: i  reason: collision with root package name */
        public View f57553i;

        public d(ViewGroup viewGroup) {
            this.a = viewGroup;
            b();
        }

        private void a(e eVar, AdTemplate adTemplate) {
            this.f57552h.setText(eVar.d());
            this.f57548d.setText(eVar.b());
            this.f57550f.setText(eVar.c());
            this.f57551g.a(eVar.e(), eVar.f());
            KSImageLoader.loadImage(this.f57549e, eVar.a(), adTemplate);
        }

        private void b() {
            this.f57547c = (ViewGroup) this.a.findViewById(R.id.ksad_reward_order_end_card_root);
            this.f57548d = (TextView) this.a.findViewById(R.id.ksad_reward_order_end_title);
            this.f57549e = (KSCornerImageView) this.a.findViewById(R.id.ksad_reward_order_end_icon);
            this.f57550f = (TextView) this.a.findViewById(R.id.ksad_reward_order_end_desc);
            this.f57551g = (KsPriceView) this.a.findViewById(R.id.ksad_reward_order_end_price);
            this.f57552h = (KsStyledTextButton) this.a.findViewById(R.id.ksad_reward_order_end_btn_buy);
            this.f57553i = this.a.findViewById(R.id.ksad_reward_order_end_btn_close);
            this.f57552h.setOnClickListener(this);
            this.f57553i.setOnClickListener(this);
            this.f57550f.setOnClickListener(this);
            this.f57551g.setOnClickListener(this);
            this.f57548d.setOnClickListener(this);
        }

        @Override // com.kwad.sdk.reward.d.d
        public ViewGroup a() {
            return this.f57547c;
        }

        @Override // com.kwad.sdk.reward.d.d
        public void a(AdTemplate adTemplate) {
            super.a(adTemplate);
            a(e.b(adTemplate), adTemplate);
        }

        public void a(a aVar) {
            this.f57546b = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f57546b == null) {
                return;
            }
            if (view.equals(this.f57553i)) {
                this.f57546b.b();
            } else if (view.equals(this.f57552h)) {
                this.f57546b.c();
            } else if (view.equals(this.f57550f) || view.equals(this.f57548d) || view.equals(this.f57551g)) {
                this.f57546b.d();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class e {
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f57554b;

        /* renamed from: c  reason: collision with root package name */
        public String f57555c;

        /* renamed from: d  reason: collision with root package name */
        public String f57556d;

        /* renamed from: e  reason: collision with root package name */
        public String f57557e;

        /* renamed from: f  reason: collision with root package name */
        public String f57558f;

        /* renamed from: g  reason: collision with root package name */
        public SpannableString f57559g;

        @Nullable
        public static e a(AdTemplate adTemplate) {
            if (adTemplate == null) {
                return null;
            }
            AdInfo j2 = com.kwad.sdk.core.response.a.d.j(adTemplate);
            e eVar = new e();
            eVar.f57554b = com.kwad.sdk.core.response.a.a.aD(j2);
            eVar.a = com.kwad.sdk.core.response.a.a.aE(j2);
            eVar.f57559g = com.kwad.sdk.core.response.a.a.a(j2, com.kwad.sdk.core.config.b.aJ());
            eVar.f57555c = com.kwad.sdk.core.response.a.a.aC(j2);
            eVar.f57556d = com.kwad.sdk.core.response.a.a.aA(j2) ? com.kwad.sdk.core.config.b.aD() : com.kwad.sdk.core.config.b.aG();
            return eVar;
        }

        @Nullable
        public static e b(AdTemplate adTemplate) {
            if (adTemplate == null) {
                return null;
            }
            AdInfo j2 = com.kwad.sdk.core.response.a.d.j(adTemplate);
            AdProductInfo aK = com.kwad.sdk.core.response.a.a.aK(j2);
            e eVar = new e();
            eVar.f57554b = aK.getName();
            eVar.a = aK.getIcon();
            eVar.f57555c = com.kwad.sdk.core.response.a.a.s(j2);
            eVar.f57556d = com.kwad.sdk.core.config.b.aE();
            eVar.f57557e = aK.getPrice();
            eVar.f57558f = aK.getOriginPrice();
            return eVar;
        }

        public String a() {
            return this.a;
        }

        public String b() {
            return this.f57554b;
        }

        public String c() {
            return this.f57555c;
        }

        public String d() {
            return this.f57556d;
        }

        public String e() {
            return this.f57557e;
        }

        public String f() {
            return this.f57558f;
        }

        public SpannableString g() {
            return this.f57559g;
        }
    }

    public static int a(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return -1;
        }
        AdInfo j2 = com.kwad.sdk.core.response.a.d.j(adTemplate);
        if (com.kwad.sdk.core.response.a.a.aH(j2)) {
            return 0;
        }
        return com.kwad.sdk.core.response.a.a.aI(j2) ? 1 : -1;
    }

    public static void a(Activity activity, AdTemplate adTemplate, b bVar) {
        if (adTemplate == null || activity == null || activity.isFinishing()) {
            return;
        }
        a = new l();
        Bundle bundle = new Bundle();
        bundle.putString("key_template_json", adTemplate.toJson().toString());
        bVar.a = a;
        a.setArguments(bundle);
        a.a(bVar);
        try {
            a.show(activity.getFragmentManager(), "videoEndDialog");
        } catch (Exception unused) {
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v5, resolved type: com.kwad.sdk.reward.l$d */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.sdk.h.e
    @Nullable
    public View a(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate;
        com.kwad.sdk.widget.c cVar;
        c cVar2;
        getDialog().requestWindowFeature(1);
        try {
            String string = getArguments().getString("key_template_json");
            AdTemplate adTemplate = new AdTemplate();
            this.f57534b = adTemplate;
            adTemplate.parseJson(new JSONObject(string));
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.b(th);
        }
        if (a(this.f57534b) != 0) {
            inflate = layoutInflater.inflate(R.layout.ksad_reward_order_end_dialog, viewGroup, false);
            d dVar = new d((ViewGroup) inflate);
            dVar.a(new b(this, this.f57535c));
            cVar = new com.kwad.sdk.widget.c(com.kwad.sdk.core.config.b.aL());
            cVar2 = dVar;
        } else {
            inflate = layoutInflater.inflate(R.layout.ksad_reward_follow_end_dialog, viewGroup, false);
            c cVar3 = new c((ViewGroup) inflate, this.f57534b);
            cVar3.a(new b(this, this.f57535c));
            cVar = new com.kwad.sdk.widget.c(com.kwad.sdk.core.config.b.aJ());
            cVar2 = cVar3;
        }
        cVar2.a(this.f57534b);
        w.a(cVar, cVar2.a());
        getDialog().setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.kwad.sdk.reward.l.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
                return i2 == 4 && keyEvent.getAction() == 0;
            }
        });
        return inflate;
    }

    public void a(a aVar) {
        this.f57535c = aVar;
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        Window window = getDialog().getWindow();
        if (window == null) {
            return;
        }
        getDialog().setCanceledOnTouchOutside(false);
        window.setLayout(-1, -1);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        a aVar = this.f57535c;
        if (aVar != null) {
            aVar.a();
        }
    }
}
