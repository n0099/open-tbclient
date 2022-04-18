package com.kwad.sdk.reward.d;

import android.content.Context;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.af;
import com.kwad.sdk.utils.at;
import com.kwad.sdk.widget.KSCornerImageView;
/* loaded from: classes5.dex */
public class e extends d implements View.OnClickListener {
    public ViewGroup a;
    public ViewGroup b;
    public KSCornerImageView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public KSCornerImageView g;
    public View h;
    public b i;
    public boolean j;

    /* loaded from: classes5.dex */
    public static class a {
        public String a;
        public String b;
        public String c;
        public String d;
        public SpannableString e;

        @Nullable
        public static a a(AdTemplate adTemplate) {
            if (adTemplate == null) {
                return null;
            }
            AdInfo j = com.kwad.sdk.core.response.a.d.j(adTemplate);
            a aVar = new a();
            aVar.d = com.kwad.sdk.core.config.b.aG();
            aVar.b = com.kwad.sdk.core.response.a.a.aC(j);
            aVar.a = com.kwad.sdk.core.response.a.a.aD(j);
            aVar.c = com.kwad.sdk.core.response.a.a.aE(j);
            aVar.e = com.kwad.sdk.core.response.a.a.a(j, com.kwad.sdk.core.config.b.aJ());
            return aVar;
        }

        public String a(boolean z) {
            return this.a;
        }

        public CharSequence b(boolean z) {
            SpannableString spannableString;
            return (z || (spannableString = this.e) == null) ? this.b : spannableString;
        }
    }

    public e(ViewGroup viewGroup, boolean z, b bVar) {
        this.a = viewGroup;
        this.j = z;
        this.i = bVar;
        b();
    }

    private void b() {
        this.b = (ViewGroup) this.a.findViewById(R.id.obfuscated_res_0x7f0910fc);
        this.c = (KSCornerImageView) this.a.findViewById(R.id.obfuscated_res_0x7f0910f9);
        this.d = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0910fb);
        this.e = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0910ec);
        this.f = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0910ea);
        this.g = (KSCornerImageView) this.a.findViewById(R.id.obfuscated_res_0x7f0910fa);
        this.h = this.a.findViewById(R.id.obfuscated_res_0x7f091129);
        this.f.setOnClickListener(this);
        this.c.setOnClickListener(this);
        this.h.setOnClickListener(this);
        Context context = this.a.getContext();
        if (af.e(context)) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.width = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070387);
            this.a.setLayoutParams(layoutParams2);
        }
    }

    @Override // com.kwad.sdk.reward.d.d
    public ViewGroup a() {
        return this.b;
    }

    @Override // com.kwad.sdk.reward.d.d
    public void a(AdTemplate adTemplate) {
        super.a(adTemplate);
        a a2 = a.a(adTemplate);
        if (a2 == null) {
            return;
        }
        this.c.setVisibility(this.j ? 8 : 0);
        KSImageLoader.loadImage(this.c, a2.c, adTemplate);
        String aF = com.kwad.sdk.core.config.b.aF();
        if (!at.a(aF)) {
            KSImageLoader.loadImage(this.g, aF, adTemplate);
        }
        this.d.setText(a2.a(this.j));
        this.e.setText(a2.b(this.j));
        this.f.setText(a2.d);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (this.i == null) {
            return;
        }
        if (view2.equals(this.f)) {
            this.i.c();
        } else if (view2.equals(this.c)) {
            this.i.a();
        } else if (view2.equals(this.h)) {
            this.i.b();
        }
    }
}
