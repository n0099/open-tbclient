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
import com.baidu.tieba.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.w;
import com.kwad.sdk.widget.KSCornerImageView;
import com.kwad.sdk.widget.KsPriceView;
import com.kwad.sdk.widget.KsStyledTextButton;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class l extends com.kwad.sdk.h.e {
    public static l a;

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f55884b;

    /* renamed from: c  reason: collision with root package name */
    public a f55885c;

    /* loaded from: classes8.dex */
    public interface a {
        void a();

        void b();

        void c();

        void d();
    }

    /* loaded from: classes8.dex */
    public static class b implements a {
        public l a;

        /* renamed from: b  reason: collision with root package name */
        public a f55886b;

        public b(@Nullable l lVar, @Nullable a aVar) {
            this.f55886b = aVar;
            this.a = lVar;
        }

        @Override // com.kwad.sdk.reward.l.a
        public void a() {
            a aVar = this.f55886b;
            if (aVar != null) {
                aVar.a();
            }
        }

        @Override // com.kwad.sdk.reward.l.a
        public void b() {
            e();
            a aVar = this.f55886b;
            if (aVar != null) {
                aVar.b();
            }
        }

        @Override // com.kwad.sdk.reward.l.a
        public void c() {
            a aVar = this.f55886b;
            if (aVar != null) {
                aVar.c();
            }
        }

        @Override // com.kwad.sdk.reward.l.a
        public void d() {
            e();
            a aVar = this.f55886b;
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

    /* loaded from: classes8.dex */
    public static class c extends com.kwad.sdk.reward.d.d implements View.OnClickListener {
        public ViewGroup a;

        /* renamed from: b  reason: collision with root package name */
        public a f55887b;

        /* renamed from: c  reason: collision with root package name */
        public ViewGroup f55888c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f55889d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f55890e;

        /* renamed from: f  reason: collision with root package name */
        public KSCornerImageView f55891f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f55892g;

        /* renamed from: h  reason: collision with root package name */
        public KsStyledTextButton f55893h;

        /* renamed from: i  reason: collision with root package name */
        public View f55894i;

        /* renamed from: j  reason: collision with root package name */
        public AdTemplate f55895j;

        public c(ViewGroup viewGroup, AdTemplate adTemplate) {
            this.a = viewGroup;
            this.f55895j = adTemplate;
            b();
        }

        private void a(e eVar) {
            this.f55889d.setText(eVar.b());
            SpannableString g2 = eVar.g();
            if (g2 != null) {
                this.f55890e.setText(g2);
            }
            this.f55892g.setText(eVar.c());
            this.f55893h.setText(eVar.d());
            KSImageLoader.loadImage(this.f55891f, eVar.a(), this.f55895j);
        }

        private void b() {
            this.f55888c = (ViewGroup) this.a.findViewById(R.id.ksad_reward_follow_end_root);
            this.f55889d = (TextView) this.a.findViewById(R.id.ksad_reward_follow_end_title);
            this.f55890e = (TextView) this.a.findViewById(R.id.ksad_reward_follow_end_fans);
            this.f55891f = (KSCornerImageView) this.a.findViewById(R.id.ksad_reward_follow_end_icon);
            this.f55892g = (TextView) this.a.findViewById(R.id.ksad_reward_follow_end_desc);
            this.f55893h = (KsStyledTextButton) this.a.findViewById(R.id.ksad_reward_follow_end_btn_follow);
            this.f55894i = this.a.findViewById(R.id.ksad_reward_follow_end_btn_close);
            this.f55893h.setOnClickListener(this);
            this.f55894i.setOnClickListener(this);
            this.f55891f.setOnClickListener(this);
            this.f55889d.setOnClickListener(this);
            this.f55890e.setOnClickListener(this);
            this.f55892g.setOnClickListener(this);
        }

        @Override // com.kwad.sdk.reward.d.d
        public ViewGroup a() {
            return this.f55888c;
        }

        @Override // com.kwad.sdk.reward.d.d
        public void a(AdTemplate adTemplate) {
            super.a(adTemplate);
            a(e.a(adTemplate));
        }

        public void a(a aVar) {
            this.f55887b = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f55887b == null) {
                return;
            }
            if (view.equals(this.f55894i)) {
                this.f55887b.b();
            } else if (view.equals(this.f55893h)) {
                this.f55887b.c();
            } else if (view.equals(this.f55892g) || view.equals(this.f55889d) || view.equals(this.f55890e)) {
                this.f55887b.d();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class d extends com.kwad.sdk.reward.d.d implements View.OnClickListener {
        public ViewGroup a;

        /* renamed from: b  reason: collision with root package name */
        public a f55896b;

        /* renamed from: c  reason: collision with root package name */
        public ViewGroup f55897c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f55898d;

        /* renamed from: e  reason: collision with root package name */
        public KSCornerImageView f55899e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f55900f;

        /* renamed from: g  reason: collision with root package name */
        public KsPriceView f55901g;

        /* renamed from: h  reason: collision with root package name */
        public KsStyledTextButton f55902h;

        /* renamed from: i  reason: collision with root package name */
        public View f55903i;

        public d(ViewGroup viewGroup) {
            this.a = viewGroup;
            b();
        }

        private void a(e eVar, AdTemplate adTemplate) {
            this.f55902h.setText(eVar.d());
            this.f55898d.setText(eVar.b());
            this.f55900f.setText(eVar.c());
            this.f55901g.a(eVar.e(), eVar.f());
            KSImageLoader.loadImage(this.f55899e, eVar.a(), adTemplate);
        }

        private void b() {
            this.f55897c = (ViewGroup) this.a.findViewById(R.id.ksad_reward_order_end_card_root);
            this.f55898d = (TextView) this.a.findViewById(R.id.ksad_reward_order_end_title);
            this.f55899e = (KSCornerImageView) this.a.findViewById(R.id.ksad_reward_order_end_icon);
            this.f55900f = (TextView) this.a.findViewById(R.id.ksad_reward_order_end_desc);
            this.f55901g = (KsPriceView) this.a.findViewById(R.id.ksad_reward_order_end_price);
            this.f55902h = (KsStyledTextButton) this.a.findViewById(R.id.ksad_reward_order_end_btn_buy);
            this.f55903i = this.a.findViewById(R.id.ksad_reward_order_end_btn_close);
            this.f55902h.setOnClickListener(this);
            this.f55903i.setOnClickListener(this);
            this.f55900f.setOnClickListener(this);
            this.f55901g.setOnClickListener(this);
            this.f55898d.setOnClickListener(this);
        }

        @Override // com.kwad.sdk.reward.d.d
        public ViewGroup a() {
            return this.f55897c;
        }

        @Override // com.kwad.sdk.reward.d.d
        public void a(AdTemplate adTemplate) {
            super.a(adTemplate);
            a(e.b(adTemplate), adTemplate);
        }

        public void a(a aVar) {
            this.f55896b = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f55896b == null) {
                return;
            }
            if (view.equals(this.f55903i)) {
                this.f55896b.b();
            } else if (view.equals(this.f55902h)) {
                this.f55896b.c();
            } else if (view.equals(this.f55900f) || view.equals(this.f55898d) || view.equals(this.f55901g)) {
                this.f55896b.d();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class e {
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f55904b;

        /* renamed from: c  reason: collision with root package name */
        public String f55905c;

        /* renamed from: d  reason: collision with root package name */
        public String f55906d;

        /* renamed from: e  reason: collision with root package name */
        public String f55907e;

        /* renamed from: f  reason: collision with root package name */
        public String f55908f;

        /* renamed from: g  reason: collision with root package name */
        public SpannableString f55909g;

        @Nullable
        public static e a(AdTemplate adTemplate) {
            if (adTemplate == null) {
                return null;
            }
            AdInfo j2 = com.kwad.sdk.core.response.a.d.j(adTemplate);
            e eVar = new e();
            eVar.f55904b = com.kwad.sdk.core.response.a.a.aD(j2);
            eVar.a = com.kwad.sdk.core.response.a.a.aE(j2);
            eVar.f55909g = com.kwad.sdk.core.response.a.a.a(j2, com.kwad.sdk.core.config.b.aJ());
            eVar.f55905c = com.kwad.sdk.core.response.a.a.aC(j2);
            eVar.f55906d = com.kwad.sdk.core.response.a.a.aA(j2) ? com.kwad.sdk.core.config.b.aD() : com.kwad.sdk.core.config.b.aG();
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
            eVar.f55904b = aK.getName();
            eVar.a = aK.getIcon();
            eVar.f55905c = com.kwad.sdk.core.response.a.a.s(j2);
            eVar.f55906d = com.kwad.sdk.core.config.b.aE();
            eVar.f55907e = aK.getPrice();
            eVar.f55908f = aK.getOriginPrice();
            return eVar;
        }

        public String a() {
            return this.a;
        }

        public String b() {
            return this.f55904b;
        }

        public String c() {
            return this.f55905c;
        }

        public String d() {
            return this.f55906d;
        }

        public String e() {
            return this.f55907e;
        }

        public String f() {
            return this.f55908f;
        }

        public SpannableString g() {
            return this.f55909g;
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
            this.f55884b = adTemplate;
            adTemplate.parseJson(new JSONObject(string));
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.b(th);
        }
        if (a(this.f55884b) != 0) {
            inflate = layoutInflater.inflate(R.layout.ksad_reward_order_end_dialog, viewGroup, false);
            d dVar = new d((ViewGroup) inflate);
            dVar.a(new b(this, this.f55885c));
            cVar = new com.kwad.sdk.widget.c(com.kwad.sdk.core.config.b.aL());
            cVar2 = dVar;
        } else {
            inflate = layoutInflater.inflate(R.layout.ksad_reward_follow_end_dialog, viewGroup, false);
            c cVar3 = new c((ViewGroup) inflate, this.f55884b);
            cVar3.a(new b(this, this.f55885c));
            cVar = new com.kwad.sdk.widget.c(com.kwad.sdk.core.config.b.aJ());
            cVar2 = cVar3;
        }
        cVar2.a(this.f55884b);
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
        this.f55885c = aVar;
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
        a aVar = this.f55885c;
        if (aVar != null) {
            aVar.a();
        }
    }
}
