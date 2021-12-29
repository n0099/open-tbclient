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
/* loaded from: classes3.dex */
public class l extends com.kwad.sdk.h.e {
    public static l a;

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f59574b;

    /* renamed from: c  reason: collision with root package name */
    public a f59575c;

    /* loaded from: classes3.dex */
    public interface a {
        void a();

        void b();

        void c();

        void d();
    }

    /* loaded from: classes3.dex */
    public static class b implements a {
        public l a;

        /* renamed from: b  reason: collision with root package name */
        public a f59576b;

        public b(@Nullable l lVar, @Nullable a aVar) {
            this.f59576b = aVar;
            this.a = lVar;
        }

        @Override // com.kwad.sdk.reward.l.a
        public void a() {
            a aVar = this.f59576b;
            if (aVar != null) {
                aVar.a();
            }
        }

        @Override // com.kwad.sdk.reward.l.a
        public void b() {
            e();
            a aVar = this.f59576b;
            if (aVar != null) {
                aVar.b();
            }
        }

        @Override // com.kwad.sdk.reward.l.a
        public void c() {
            a aVar = this.f59576b;
            if (aVar != null) {
                aVar.c();
            }
        }

        @Override // com.kwad.sdk.reward.l.a
        public void d() {
            e();
            a aVar = this.f59576b;
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

    /* loaded from: classes3.dex */
    public static class c extends com.kwad.sdk.reward.d.d implements View.OnClickListener {
        public ViewGroup a;

        /* renamed from: b  reason: collision with root package name */
        public a f59577b;

        /* renamed from: c  reason: collision with root package name */
        public ViewGroup f59578c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f59579d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f59580e;

        /* renamed from: f  reason: collision with root package name */
        public KSCornerImageView f59581f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f59582g;

        /* renamed from: h  reason: collision with root package name */
        public KsStyledTextButton f59583h;

        /* renamed from: i  reason: collision with root package name */
        public View f59584i;

        /* renamed from: j  reason: collision with root package name */
        public AdTemplate f59585j;

        public c(ViewGroup viewGroup, AdTemplate adTemplate) {
            this.a = viewGroup;
            this.f59585j = adTemplate;
            b();
        }

        private void a(e eVar) {
            this.f59579d.setText(eVar.b());
            SpannableString g2 = eVar.g();
            if (g2 != null) {
                this.f59580e.setText(g2);
            }
            this.f59582g.setText(eVar.c());
            this.f59583h.setText(eVar.d());
            KSImageLoader.loadImage(this.f59581f, eVar.a(), this.f59585j);
        }

        private void b() {
            this.f59578c = (ViewGroup) this.a.findViewById(R.id.ksad_reward_follow_end_root);
            this.f59579d = (TextView) this.a.findViewById(R.id.ksad_reward_follow_end_title);
            this.f59580e = (TextView) this.a.findViewById(R.id.ksad_reward_follow_end_fans);
            this.f59581f = (KSCornerImageView) this.a.findViewById(R.id.ksad_reward_follow_end_icon);
            this.f59582g = (TextView) this.a.findViewById(R.id.ksad_reward_follow_end_desc);
            this.f59583h = (KsStyledTextButton) this.a.findViewById(R.id.ksad_reward_follow_end_btn_follow);
            this.f59584i = this.a.findViewById(R.id.ksad_reward_follow_end_btn_close);
            this.f59583h.setOnClickListener(this);
            this.f59584i.setOnClickListener(this);
            this.f59581f.setOnClickListener(this);
            this.f59579d.setOnClickListener(this);
            this.f59580e.setOnClickListener(this);
            this.f59582g.setOnClickListener(this);
        }

        @Override // com.kwad.sdk.reward.d.d
        public ViewGroup a() {
            return this.f59578c;
        }

        @Override // com.kwad.sdk.reward.d.d
        public void a(AdTemplate adTemplate) {
            super.a(adTemplate);
            a(e.a(adTemplate));
        }

        public void a(a aVar) {
            this.f59577b = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f59577b == null) {
                return;
            }
            if (view.equals(this.f59584i)) {
                this.f59577b.b();
            } else if (view.equals(this.f59583h)) {
                this.f59577b.c();
            } else if (view.equals(this.f59582g) || view.equals(this.f59579d) || view.equals(this.f59580e)) {
                this.f59577b.d();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class d extends com.kwad.sdk.reward.d.d implements View.OnClickListener {
        public ViewGroup a;

        /* renamed from: b  reason: collision with root package name */
        public a f59586b;

        /* renamed from: c  reason: collision with root package name */
        public ViewGroup f59587c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f59588d;

        /* renamed from: e  reason: collision with root package name */
        public KSCornerImageView f59589e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f59590f;

        /* renamed from: g  reason: collision with root package name */
        public KsPriceView f59591g;

        /* renamed from: h  reason: collision with root package name */
        public KsStyledTextButton f59592h;

        /* renamed from: i  reason: collision with root package name */
        public View f59593i;

        public d(ViewGroup viewGroup) {
            this.a = viewGroup;
            b();
        }

        private void a(e eVar, AdTemplate adTemplate) {
            this.f59592h.setText(eVar.d());
            this.f59588d.setText(eVar.b());
            this.f59590f.setText(eVar.c());
            this.f59591g.a(eVar.e(), eVar.f());
            KSImageLoader.loadImage(this.f59589e, eVar.a(), adTemplate);
        }

        private void b() {
            this.f59587c = (ViewGroup) this.a.findViewById(R.id.ksad_reward_order_end_card_root);
            this.f59588d = (TextView) this.a.findViewById(R.id.ksad_reward_order_end_title);
            this.f59589e = (KSCornerImageView) this.a.findViewById(R.id.ksad_reward_order_end_icon);
            this.f59590f = (TextView) this.a.findViewById(R.id.ksad_reward_order_end_desc);
            this.f59591g = (KsPriceView) this.a.findViewById(R.id.ksad_reward_order_end_price);
            this.f59592h = (KsStyledTextButton) this.a.findViewById(R.id.ksad_reward_order_end_btn_buy);
            this.f59593i = this.a.findViewById(R.id.ksad_reward_order_end_btn_close);
            this.f59592h.setOnClickListener(this);
            this.f59593i.setOnClickListener(this);
            this.f59590f.setOnClickListener(this);
            this.f59591g.setOnClickListener(this);
            this.f59588d.setOnClickListener(this);
        }

        @Override // com.kwad.sdk.reward.d.d
        public ViewGroup a() {
            return this.f59587c;
        }

        @Override // com.kwad.sdk.reward.d.d
        public void a(AdTemplate adTemplate) {
            super.a(adTemplate);
            a(e.b(adTemplate), adTemplate);
        }

        public void a(a aVar) {
            this.f59586b = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f59586b == null) {
                return;
            }
            if (view.equals(this.f59593i)) {
                this.f59586b.b();
            } else if (view.equals(this.f59592h)) {
                this.f59586b.c();
            } else if (view.equals(this.f59590f) || view.equals(this.f59588d) || view.equals(this.f59591g)) {
                this.f59586b.d();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class e {
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f59594b;

        /* renamed from: c  reason: collision with root package name */
        public String f59595c;

        /* renamed from: d  reason: collision with root package name */
        public String f59596d;

        /* renamed from: e  reason: collision with root package name */
        public String f59597e;

        /* renamed from: f  reason: collision with root package name */
        public String f59598f;

        /* renamed from: g  reason: collision with root package name */
        public SpannableString f59599g;

        @Nullable
        public static e a(AdTemplate adTemplate) {
            if (adTemplate == null) {
                return null;
            }
            AdInfo j2 = com.kwad.sdk.core.response.a.d.j(adTemplate);
            e eVar = new e();
            eVar.f59594b = com.kwad.sdk.core.response.a.a.aD(j2);
            eVar.a = com.kwad.sdk.core.response.a.a.aE(j2);
            eVar.f59599g = com.kwad.sdk.core.response.a.a.a(j2, com.kwad.sdk.core.config.b.aJ());
            eVar.f59595c = com.kwad.sdk.core.response.a.a.aC(j2);
            eVar.f59596d = com.kwad.sdk.core.response.a.a.aA(j2) ? com.kwad.sdk.core.config.b.aD() : com.kwad.sdk.core.config.b.aG();
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
            eVar.f59594b = aK.getName();
            eVar.a = aK.getIcon();
            eVar.f59595c = com.kwad.sdk.core.response.a.a.s(j2);
            eVar.f59596d = com.kwad.sdk.core.config.b.aE();
            eVar.f59597e = aK.getPrice();
            eVar.f59598f = aK.getOriginPrice();
            return eVar;
        }

        public String a() {
            return this.a;
        }

        public String b() {
            return this.f59594b;
        }

        public String c() {
            return this.f59595c;
        }

        public String d() {
            return this.f59596d;
        }

        public String e() {
            return this.f59597e;
        }

        public String f() {
            return this.f59598f;
        }

        public SpannableString g() {
            return this.f59599g;
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
            this.f59574b = adTemplate;
            adTemplate.parseJson(new JSONObject(string));
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.b(th);
        }
        if (a(this.f59574b) != 0) {
            inflate = layoutInflater.inflate(R.layout.ksad_reward_order_end_dialog, viewGroup, false);
            d dVar = new d((ViewGroup) inflate);
            dVar.a(new b(this, this.f59575c));
            cVar = new com.kwad.sdk.widget.c(com.kwad.sdk.core.config.b.aL());
            cVar2 = dVar;
        } else {
            inflate = layoutInflater.inflate(R.layout.ksad_reward_follow_end_dialog, viewGroup, false);
            c cVar3 = new c((ViewGroup) inflate, this.f59574b);
            cVar3.a(new b(this, this.f59575c));
            cVar = new com.kwad.sdk.widget.c(com.kwad.sdk.core.config.b.aJ());
            cVar2 = cVar3;
        }
        cVar2.a(this.f59574b);
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
        this.f59575c = aVar;
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
        a aVar = this.f59575c;
        if (aVar != null) {
            aVar.a();
        }
    }
}
