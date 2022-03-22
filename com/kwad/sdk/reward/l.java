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
/* loaded from: classes7.dex */
public class l extends com.kwad.sdk.h.e {
    public static l a;

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f40851b;

    /* renamed from: c  reason: collision with root package name */
    public a f40852c;

    /* loaded from: classes7.dex */
    public interface a {
        void a();

        void b();

        void c();

        void d();
    }

    /* loaded from: classes7.dex */
    public static class b implements a {
        public l a;

        /* renamed from: b  reason: collision with root package name */
        public a f40853b;

        public b(@Nullable l lVar, @Nullable a aVar) {
            this.f40853b = aVar;
            this.a = lVar;
        }

        @Override // com.kwad.sdk.reward.l.a
        public void a() {
            a aVar = this.f40853b;
            if (aVar != null) {
                aVar.a();
            }
        }

        @Override // com.kwad.sdk.reward.l.a
        public void b() {
            e();
            a aVar = this.f40853b;
            if (aVar != null) {
                aVar.b();
            }
        }

        @Override // com.kwad.sdk.reward.l.a
        public void c() {
            a aVar = this.f40853b;
            if (aVar != null) {
                aVar.c();
            }
        }

        @Override // com.kwad.sdk.reward.l.a
        public void d() {
            e();
            a aVar = this.f40853b;
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

    /* loaded from: classes7.dex */
    public static class c extends com.kwad.sdk.reward.d.d implements View.OnClickListener {
        public ViewGroup a;

        /* renamed from: b  reason: collision with root package name */
        public a f40854b;

        /* renamed from: c  reason: collision with root package name */
        public ViewGroup f40855c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f40856d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f40857e;

        /* renamed from: f  reason: collision with root package name */
        public KSCornerImageView f40858f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f40859g;

        /* renamed from: h  reason: collision with root package name */
        public KsStyledTextButton f40860h;
        public View i;
        public AdTemplate j;

        public c(ViewGroup viewGroup, AdTemplate adTemplate) {
            this.a = viewGroup;
            this.j = adTemplate;
            b();
        }

        private void a(e eVar) {
            this.f40856d.setText(eVar.b());
            SpannableString g2 = eVar.g();
            if (g2 != null) {
                this.f40857e.setText(g2);
            }
            this.f40859g.setText(eVar.c());
            this.f40860h.setText(eVar.d());
            KSImageLoader.loadImage(this.f40858f, eVar.a(), this.j);
        }

        private void b() {
            this.f40855c = (ViewGroup) this.a.findViewById(R.id.obfuscated_res_0x7f0910fd);
            this.f40856d = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0910fe);
            this.f40857e = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0910fb);
            this.f40858f = (KSCornerImageView) this.a.findViewById(R.id.obfuscated_res_0x7f0910fc);
            this.f40859g = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0910fa);
            this.f40860h = (KsStyledTextButton) this.a.findViewById(R.id.obfuscated_res_0x7f0910f9);
            this.i = this.a.findViewById(R.id.obfuscated_res_0x7f0910f8);
            this.f40860h.setOnClickListener(this);
            this.i.setOnClickListener(this);
            this.f40858f.setOnClickListener(this);
            this.f40856d.setOnClickListener(this);
            this.f40857e.setOnClickListener(this);
            this.f40859g.setOnClickListener(this);
        }

        @Override // com.kwad.sdk.reward.d.d
        public ViewGroup a() {
            return this.f40855c;
        }

        @Override // com.kwad.sdk.reward.d.d
        public void a(AdTemplate adTemplate) {
            super.a(adTemplate);
            a(e.a(adTemplate));
        }

        public void a(a aVar) {
            this.f40854b = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f40854b == null) {
                return;
            }
            if (view.equals(this.i)) {
                this.f40854b.b();
            } else if (view.equals(this.f40860h)) {
                this.f40854b.c();
            } else if (view.equals(this.f40859g) || view.equals(this.f40856d) || view.equals(this.f40857e)) {
                this.f40854b.d();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class d extends com.kwad.sdk.reward.d.d implements View.OnClickListener {
        public ViewGroup a;

        /* renamed from: b  reason: collision with root package name */
        public a f40861b;

        /* renamed from: c  reason: collision with root package name */
        public ViewGroup f40862c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f40863d;

        /* renamed from: e  reason: collision with root package name */
        public KSCornerImageView f40864e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f40865f;

        /* renamed from: g  reason: collision with root package name */
        public KsPriceView f40866g;

        /* renamed from: h  reason: collision with root package name */
        public KsStyledTextButton f40867h;
        public View i;

        public d(ViewGroup viewGroup) {
            this.a = viewGroup;
            b();
        }

        private void a(e eVar, AdTemplate adTemplate) {
            this.f40867h.setText(eVar.d());
            this.f40863d.setText(eVar.b());
            this.f40865f.setText(eVar.c());
            this.f40866g.a(eVar.e(), eVar.f());
            KSImageLoader.loadImage(this.f40864e, eVar.a(), adTemplate);
        }

        private void b() {
            this.f40862c = (ViewGroup) this.a.findViewById(R.id.obfuscated_res_0x7f09111a);
            this.f40863d = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f09111e);
            this.f40864e = (KSCornerImageView) this.a.findViewById(R.id.obfuscated_res_0x7f09111c);
            this.f40865f = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f09111b);
            this.f40866g = (KsPriceView) this.a.findViewById(R.id.obfuscated_res_0x7f09111d);
            this.f40867h = (KsStyledTextButton) this.a.findViewById(R.id.obfuscated_res_0x7f091117);
            this.i = this.a.findViewById(R.id.obfuscated_res_0x7f091118);
            this.f40867h.setOnClickListener(this);
            this.i.setOnClickListener(this);
            this.f40865f.setOnClickListener(this);
            this.f40866g.setOnClickListener(this);
            this.f40863d.setOnClickListener(this);
        }

        @Override // com.kwad.sdk.reward.d.d
        public ViewGroup a() {
            return this.f40862c;
        }

        @Override // com.kwad.sdk.reward.d.d
        public void a(AdTemplate adTemplate) {
            super.a(adTemplate);
            a(e.b(adTemplate), adTemplate);
        }

        public void a(a aVar) {
            this.f40861b = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f40861b == null) {
                return;
            }
            if (view.equals(this.i)) {
                this.f40861b.b();
            } else if (view.equals(this.f40867h)) {
                this.f40861b.c();
            } else if (view.equals(this.f40865f) || view.equals(this.f40863d) || view.equals(this.f40866g)) {
                this.f40861b.d();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class e {
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f40868b;

        /* renamed from: c  reason: collision with root package name */
        public String f40869c;

        /* renamed from: d  reason: collision with root package name */
        public String f40870d;

        /* renamed from: e  reason: collision with root package name */
        public String f40871e;

        /* renamed from: f  reason: collision with root package name */
        public String f40872f;

        /* renamed from: g  reason: collision with root package name */
        public SpannableString f40873g;

        @Nullable
        public static e a(AdTemplate adTemplate) {
            if (adTemplate == null) {
                return null;
            }
            AdInfo j = com.kwad.sdk.core.response.a.d.j(adTemplate);
            e eVar = new e();
            eVar.f40868b = com.kwad.sdk.core.response.a.a.aD(j);
            eVar.a = com.kwad.sdk.core.response.a.a.aE(j);
            eVar.f40873g = com.kwad.sdk.core.response.a.a.a(j, com.kwad.sdk.core.config.b.aJ());
            eVar.f40869c = com.kwad.sdk.core.response.a.a.aC(j);
            eVar.f40870d = com.kwad.sdk.core.response.a.a.aA(j) ? com.kwad.sdk.core.config.b.aD() : com.kwad.sdk.core.config.b.aG();
            return eVar;
        }

        @Nullable
        public static e b(AdTemplate adTemplate) {
            if (adTemplate == null) {
                return null;
            }
            AdInfo j = com.kwad.sdk.core.response.a.d.j(adTemplate);
            AdProductInfo aK = com.kwad.sdk.core.response.a.a.aK(j);
            e eVar = new e();
            eVar.f40868b = aK.getName();
            eVar.a = aK.getIcon();
            eVar.f40869c = com.kwad.sdk.core.response.a.a.s(j);
            eVar.f40870d = com.kwad.sdk.core.config.b.aE();
            eVar.f40871e = aK.getPrice();
            eVar.f40872f = aK.getOriginPrice();
            return eVar;
        }

        public String a() {
            return this.a;
        }

        public String b() {
            return this.f40868b;
        }

        public String c() {
            return this.f40869c;
        }

        public String d() {
            return this.f40870d;
        }

        public String e() {
            return this.f40871e;
        }

        public String f() {
            return this.f40872f;
        }

        public SpannableString g() {
            return this.f40873g;
        }
    }

    public static int a(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return -1;
        }
        AdInfo j = com.kwad.sdk.core.response.a.d.j(adTemplate);
        if (com.kwad.sdk.core.response.a.a.aH(j)) {
            return 0;
        }
        return com.kwad.sdk.core.response.a.a.aI(j) ? 1 : -1;
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
            this.f40851b = adTemplate;
            adTemplate.parseJson(new JSONObject(string));
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.b(th);
        }
        if (a(this.f40851b) != 0) {
            inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d046d, viewGroup, false);
            d dVar = new d((ViewGroup) inflate);
            dVar.a(new b(this, this.f40852c));
            cVar = new com.kwad.sdk.widget.c(com.kwad.sdk.core.config.b.aL());
            cVar2 = dVar;
        } else {
            inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0468, viewGroup, false);
            c cVar3 = new c((ViewGroup) inflate, this.f40851b);
            cVar3.a(new b(this, this.f40852c));
            cVar = new com.kwad.sdk.widget.c(com.kwad.sdk.core.config.b.aJ());
            cVar2 = cVar3;
        }
        cVar2.a(this.f40851b);
        w.a(cVar, cVar2.a());
        getDialog().setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.kwad.sdk.reward.l.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return i == 4 && keyEvent.getAction() == 0;
            }
        });
        return inflate;
    }

    public void a(a aVar) {
        this.f40852c = aVar;
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
        a aVar = this.f40852c;
        if (aVar != null) {
            aVar.a();
        }
    }
}
