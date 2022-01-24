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
    public AdTemplate f57367b;

    /* renamed from: c  reason: collision with root package name */
    public a f57368c;

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
        public a f57369b;

        public b(@Nullable l lVar, @Nullable a aVar) {
            this.f57369b = aVar;
            this.a = lVar;
        }

        @Override // com.kwad.sdk.reward.l.a
        public void a() {
            a aVar = this.f57369b;
            if (aVar != null) {
                aVar.a();
            }
        }

        @Override // com.kwad.sdk.reward.l.a
        public void b() {
            e();
            a aVar = this.f57369b;
            if (aVar != null) {
                aVar.b();
            }
        }

        @Override // com.kwad.sdk.reward.l.a
        public void c() {
            a aVar = this.f57369b;
            if (aVar != null) {
                aVar.c();
            }
        }

        @Override // com.kwad.sdk.reward.l.a
        public void d() {
            e();
            a aVar = this.f57369b;
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
        public a f57370b;

        /* renamed from: c  reason: collision with root package name */
        public ViewGroup f57371c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f57372d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f57373e;

        /* renamed from: f  reason: collision with root package name */
        public KSCornerImageView f57374f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f57375g;

        /* renamed from: h  reason: collision with root package name */
        public KsStyledTextButton f57376h;

        /* renamed from: i  reason: collision with root package name */
        public View f57377i;

        /* renamed from: j  reason: collision with root package name */
        public AdTemplate f57378j;

        public c(ViewGroup viewGroup, AdTemplate adTemplate) {
            this.a = viewGroup;
            this.f57378j = adTemplate;
            b();
        }

        private void a(e eVar) {
            this.f57372d.setText(eVar.b());
            SpannableString g2 = eVar.g();
            if (g2 != null) {
                this.f57373e.setText(g2);
            }
            this.f57375g.setText(eVar.c());
            this.f57376h.setText(eVar.d());
            KSImageLoader.loadImage(this.f57374f, eVar.a(), this.f57378j);
        }

        private void b() {
            this.f57371c = (ViewGroup) this.a.findViewById(R.id.ksad_reward_follow_end_root);
            this.f57372d = (TextView) this.a.findViewById(R.id.ksad_reward_follow_end_title);
            this.f57373e = (TextView) this.a.findViewById(R.id.ksad_reward_follow_end_fans);
            this.f57374f = (KSCornerImageView) this.a.findViewById(R.id.ksad_reward_follow_end_icon);
            this.f57375g = (TextView) this.a.findViewById(R.id.ksad_reward_follow_end_desc);
            this.f57376h = (KsStyledTextButton) this.a.findViewById(R.id.ksad_reward_follow_end_btn_follow);
            this.f57377i = this.a.findViewById(R.id.ksad_reward_follow_end_btn_close);
            this.f57376h.setOnClickListener(this);
            this.f57377i.setOnClickListener(this);
            this.f57374f.setOnClickListener(this);
            this.f57372d.setOnClickListener(this);
            this.f57373e.setOnClickListener(this);
            this.f57375g.setOnClickListener(this);
        }

        @Override // com.kwad.sdk.reward.d.d
        public ViewGroup a() {
            return this.f57371c;
        }

        @Override // com.kwad.sdk.reward.d.d
        public void a(AdTemplate adTemplate) {
            super.a(adTemplate);
            a(e.a(adTemplate));
        }

        public void a(a aVar) {
            this.f57370b = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f57370b == null) {
                return;
            }
            if (view.equals(this.f57377i)) {
                this.f57370b.b();
            } else if (view.equals(this.f57376h)) {
                this.f57370b.c();
            } else if (view.equals(this.f57375g) || view.equals(this.f57372d) || view.equals(this.f57373e)) {
                this.f57370b.d();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class d extends com.kwad.sdk.reward.d.d implements View.OnClickListener {
        public ViewGroup a;

        /* renamed from: b  reason: collision with root package name */
        public a f57379b;

        /* renamed from: c  reason: collision with root package name */
        public ViewGroup f57380c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f57381d;

        /* renamed from: e  reason: collision with root package name */
        public KSCornerImageView f57382e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f57383f;

        /* renamed from: g  reason: collision with root package name */
        public KsPriceView f57384g;

        /* renamed from: h  reason: collision with root package name */
        public KsStyledTextButton f57385h;

        /* renamed from: i  reason: collision with root package name */
        public View f57386i;

        public d(ViewGroup viewGroup) {
            this.a = viewGroup;
            b();
        }

        private void a(e eVar, AdTemplate adTemplate) {
            this.f57385h.setText(eVar.d());
            this.f57381d.setText(eVar.b());
            this.f57383f.setText(eVar.c());
            this.f57384g.a(eVar.e(), eVar.f());
            KSImageLoader.loadImage(this.f57382e, eVar.a(), adTemplate);
        }

        private void b() {
            this.f57380c = (ViewGroup) this.a.findViewById(R.id.ksad_reward_order_end_card_root);
            this.f57381d = (TextView) this.a.findViewById(R.id.ksad_reward_order_end_title);
            this.f57382e = (KSCornerImageView) this.a.findViewById(R.id.ksad_reward_order_end_icon);
            this.f57383f = (TextView) this.a.findViewById(R.id.ksad_reward_order_end_desc);
            this.f57384g = (KsPriceView) this.a.findViewById(R.id.ksad_reward_order_end_price);
            this.f57385h = (KsStyledTextButton) this.a.findViewById(R.id.ksad_reward_order_end_btn_buy);
            this.f57386i = this.a.findViewById(R.id.ksad_reward_order_end_btn_close);
            this.f57385h.setOnClickListener(this);
            this.f57386i.setOnClickListener(this);
            this.f57383f.setOnClickListener(this);
            this.f57384g.setOnClickListener(this);
            this.f57381d.setOnClickListener(this);
        }

        @Override // com.kwad.sdk.reward.d.d
        public ViewGroup a() {
            return this.f57380c;
        }

        @Override // com.kwad.sdk.reward.d.d
        public void a(AdTemplate adTemplate) {
            super.a(adTemplate);
            a(e.b(adTemplate), adTemplate);
        }

        public void a(a aVar) {
            this.f57379b = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f57379b == null) {
                return;
            }
            if (view.equals(this.f57386i)) {
                this.f57379b.b();
            } else if (view.equals(this.f57385h)) {
                this.f57379b.c();
            } else if (view.equals(this.f57383f) || view.equals(this.f57381d) || view.equals(this.f57384g)) {
                this.f57379b.d();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class e {
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f57387b;

        /* renamed from: c  reason: collision with root package name */
        public String f57388c;

        /* renamed from: d  reason: collision with root package name */
        public String f57389d;

        /* renamed from: e  reason: collision with root package name */
        public String f57390e;

        /* renamed from: f  reason: collision with root package name */
        public String f57391f;

        /* renamed from: g  reason: collision with root package name */
        public SpannableString f57392g;

        @Nullable
        public static e a(AdTemplate adTemplate) {
            if (adTemplate == null) {
                return null;
            }
            AdInfo j2 = com.kwad.sdk.core.response.a.d.j(adTemplate);
            e eVar = new e();
            eVar.f57387b = com.kwad.sdk.core.response.a.a.aD(j2);
            eVar.a = com.kwad.sdk.core.response.a.a.aE(j2);
            eVar.f57392g = com.kwad.sdk.core.response.a.a.a(j2, com.kwad.sdk.core.config.b.aJ());
            eVar.f57388c = com.kwad.sdk.core.response.a.a.aC(j2);
            eVar.f57389d = com.kwad.sdk.core.response.a.a.aA(j2) ? com.kwad.sdk.core.config.b.aD() : com.kwad.sdk.core.config.b.aG();
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
            eVar.f57387b = aK.getName();
            eVar.a = aK.getIcon();
            eVar.f57388c = com.kwad.sdk.core.response.a.a.s(j2);
            eVar.f57389d = com.kwad.sdk.core.config.b.aE();
            eVar.f57390e = aK.getPrice();
            eVar.f57391f = aK.getOriginPrice();
            return eVar;
        }

        public String a() {
            return this.a;
        }

        public String b() {
            return this.f57387b;
        }

        public String c() {
            return this.f57388c;
        }

        public String d() {
            return this.f57389d;
        }

        public String e() {
            return this.f57390e;
        }

        public String f() {
            return this.f57391f;
        }

        public SpannableString g() {
            return this.f57392g;
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
            this.f57367b = adTemplate;
            adTemplate.parseJson(new JSONObject(string));
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.b(th);
        }
        if (a(this.f57367b) != 0) {
            inflate = layoutInflater.inflate(R.layout.ksad_reward_order_end_dialog, viewGroup, false);
            d dVar = new d((ViewGroup) inflate);
            dVar.a(new b(this, this.f57368c));
            cVar = new com.kwad.sdk.widget.c(com.kwad.sdk.core.config.b.aL());
            cVar2 = dVar;
        } else {
            inflate = layoutInflater.inflate(R.layout.ksad_reward_follow_end_dialog, viewGroup, false);
            c cVar3 = new c((ViewGroup) inflate, this.f57367b);
            cVar3.a(new b(this, this.f57368c));
            cVar = new com.kwad.sdk.widget.c(com.kwad.sdk.core.config.b.aJ());
            cVar2 = cVar3;
        }
        cVar2.a(this.f57367b);
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
        this.f57368c = aVar;
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
        a aVar = this.f57368c;
        if (aVar != null) {
            aVar.a();
        }
    }
}
