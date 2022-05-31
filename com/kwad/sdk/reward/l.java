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
/* loaded from: classes5.dex */
public class l extends com.kwad.sdk.h.e {
    public static l a;
    public AdTemplate b;
    public a c;

    /* loaded from: classes5.dex */
    public interface a {
        void a();

        void b();

        void c();

        void d();
    }

    /* loaded from: classes5.dex */
    public static class b implements a {
        public l a;
        public a b;

        public b(@Nullable l lVar, @Nullable a aVar) {
            this.b = aVar;
            this.a = lVar;
        }

        @Override // com.kwad.sdk.reward.l.a
        public void a() {
            a aVar = this.b;
            if (aVar != null) {
                aVar.a();
            }
        }

        @Override // com.kwad.sdk.reward.l.a
        public void b() {
            e();
            a aVar = this.b;
            if (aVar != null) {
                aVar.b();
            }
        }

        @Override // com.kwad.sdk.reward.l.a
        public void c() {
            a aVar = this.b;
            if (aVar != null) {
                aVar.c();
            }
        }

        @Override // com.kwad.sdk.reward.l.a
        public void d() {
            e();
            a aVar = this.b;
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

    /* loaded from: classes5.dex */
    public static class c extends com.kwad.sdk.reward.d.d implements View.OnClickListener {
        public ViewGroup a;
        public a b;
        public ViewGroup c;
        public TextView d;
        public TextView e;
        public KSCornerImageView f;
        public TextView g;
        public KsStyledTextButton h;
        public View i;
        public AdTemplate j;

        public c(ViewGroup viewGroup, AdTemplate adTemplate) {
            this.a = viewGroup;
            this.j = adTemplate;
            b();
        }

        private void a(e eVar) {
            this.d.setText(eVar.b());
            SpannableString g = eVar.g();
            if (g != null) {
                this.e.setText(g);
            }
            this.g.setText(eVar.c());
            this.h.setText(eVar.d());
            KSImageLoader.loadImage(this.f, eVar.a(), this.j);
        }

        private void b() {
            this.c = (ViewGroup) this.a.findViewById(R.id.obfuscated_res_0x7f0910c5);
            this.d = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0910c6);
            this.e = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0910c3);
            this.f = (KSCornerImageView) this.a.findViewById(R.id.obfuscated_res_0x7f0910c4);
            this.g = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0910c2);
            this.h = (KsStyledTextButton) this.a.findViewById(R.id.obfuscated_res_0x7f0910c1);
            this.i = this.a.findViewById(R.id.obfuscated_res_0x7f0910c0);
            this.h.setOnClickListener(this);
            this.i.setOnClickListener(this);
            this.f.setOnClickListener(this);
            this.d.setOnClickListener(this);
            this.e.setOnClickListener(this);
            this.g.setOnClickListener(this);
        }

        @Override // com.kwad.sdk.reward.d.d
        public ViewGroup a() {
            return this.c;
        }

        @Override // com.kwad.sdk.reward.d.d
        public void a(AdTemplate adTemplate) {
            super.a(adTemplate);
            a(e.a(adTemplate));
        }

        public void a(a aVar) {
            this.b = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (this.b == null) {
                return;
            }
            if (view2.equals(this.i)) {
                this.b.b();
            } else if (view2.equals(this.h)) {
                this.b.c();
            } else if (view2.equals(this.g) || view2.equals(this.d) || view2.equals(this.e)) {
                this.b.d();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class d extends com.kwad.sdk.reward.d.d implements View.OnClickListener {
        public ViewGroup a;
        public a b;
        public ViewGroup c;
        public TextView d;
        public KSCornerImageView e;
        public TextView f;
        public KsPriceView g;
        public KsStyledTextButton h;
        public View i;

        public d(ViewGroup viewGroup) {
            this.a = viewGroup;
            b();
        }

        private void a(e eVar, AdTemplate adTemplate) {
            this.h.setText(eVar.d());
            this.d.setText(eVar.b());
            this.f.setText(eVar.c());
            this.g.a(eVar.e(), eVar.f());
            KSImageLoader.loadImage(this.e, eVar.a(), adTemplate);
        }

        private void b() {
            this.c = (ViewGroup) this.a.findViewById(R.id.obfuscated_res_0x7f0910e5);
            this.d = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0910e9);
            this.e = (KSCornerImageView) this.a.findViewById(R.id.obfuscated_res_0x7f0910e7);
            this.f = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0910e6);
            this.g = (KsPriceView) this.a.findViewById(R.id.obfuscated_res_0x7f0910e8);
            this.h = (KsStyledTextButton) this.a.findViewById(R.id.obfuscated_res_0x7f0910e2);
            this.i = this.a.findViewById(R.id.obfuscated_res_0x7f0910e3);
            this.h.setOnClickListener(this);
            this.i.setOnClickListener(this);
            this.f.setOnClickListener(this);
            this.g.setOnClickListener(this);
            this.d.setOnClickListener(this);
        }

        @Override // com.kwad.sdk.reward.d.d
        public ViewGroup a() {
            return this.c;
        }

        @Override // com.kwad.sdk.reward.d.d
        public void a(AdTemplate adTemplate) {
            super.a(adTemplate);
            a(e.b(adTemplate), adTemplate);
        }

        public void a(a aVar) {
            this.b = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (this.b == null) {
                return;
            }
            if (view2.equals(this.i)) {
                this.b.b();
            } else if (view2.equals(this.h)) {
                this.b.c();
            } else if (view2.equals(this.f) || view2.equals(this.d) || view2.equals(this.g)) {
                this.b.d();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class e {
        public String a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public SpannableString g;

        @Nullable
        public static e a(AdTemplate adTemplate) {
            if (adTemplate == null) {
                return null;
            }
            AdInfo j = com.kwad.sdk.core.response.a.d.j(adTemplate);
            e eVar = new e();
            eVar.b = com.kwad.sdk.core.response.a.a.aD(j);
            eVar.a = com.kwad.sdk.core.response.a.a.aE(j);
            eVar.g = com.kwad.sdk.core.response.a.a.a(j, com.kwad.sdk.core.config.b.aJ());
            eVar.c = com.kwad.sdk.core.response.a.a.aC(j);
            eVar.d = com.kwad.sdk.core.response.a.a.aA(j) ? com.kwad.sdk.core.config.b.aD() : com.kwad.sdk.core.config.b.aG();
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
            eVar.b = aK.getName();
            eVar.a = aK.getIcon();
            eVar.c = com.kwad.sdk.core.response.a.a.s(j);
            eVar.d = com.kwad.sdk.core.config.b.aE();
            eVar.e = aK.getPrice();
            eVar.f = aK.getOriginPrice();
            return eVar;
        }

        public String a() {
            return this.a;
        }

        public String b() {
            return this.b;
        }

        public String c() {
            return this.c;
        }

        public String d() {
            return this.d;
        }

        public String e() {
            return this.e;
        }

        public String f() {
            return this.f;
        }

        public SpannableString g() {
            return this.g;
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
            this.b = adTemplate;
            adTemplate.parseJson(new JSONObject(string));
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.b(th);
        }
        if (a(this.b) != 0) {
            inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0452, viewGroup, false);
            d dVar = new d((ViewGroup) inflate);
            dVar.a(new b(this, this.c));
            cVar = new com.kwad.sdk.widget.c(com.kwad.sdk.core.config.b.aL());
            cVar2 = dVar;
        } else {
            inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d044d, viewGroup, false);
            c cVar3 = new c((ViewGroup) inflate, this.b);
            cVar3.a(new b(this, this.c));
            cVar = new com.kwad.sdk.widget.c(com.kwad.sdk.core.config.b.aJ());
            cVar2 = cVar3;
        }
        cVar2.a(this.b);
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
        this.c = aVar;
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
        a aVar = this.c;
        if (aVar != null) {
            aVar.a();
        }
    }
}
