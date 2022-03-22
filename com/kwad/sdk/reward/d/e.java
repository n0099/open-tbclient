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
/* loaded from: classes7.dex */
public class e extends d implements View.OnClickListener {
    public ViewGroup a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f40782b;

    /* renamed from: c  reason: collision with root package name */
    public KSCornerImageView f40783c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f40784d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f40785e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f40786f;

    /* renamed from: g  reason: collision with root package name */
    public KSCornerImageView f40787g;

    /* renamed from: h  reason: collision with root package name */
    public View f40788h;
    public b i;
    public boolean j;

    /* loaded from: classes7.dex */
    public static class a {
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f40789b;

        /* renamed from: c  reason: collision with root package name */
        public String f40790c;

        /* renamed from: d  reason: collision with root package name */
        public String f40791d;

        /* renamed from: e  reason: collision with root package name */
        public SpannableString f40792e;

        @Nullable
        public static a a(AdTemplate adTemplate) {
            if (adTemplate == null) {
                return null;
            }
            AdInfo j = com.kwad.sdk.core.response.a.d.j(adTemplate);
            a aVar = new a();
            aVar.f40791d = com.kwad.sdk.core.config.b.aG();
            aVar.f40789b = com.kwad.sdk.core.response.a.a.aC(j);
            aVar.a = com.kwad.sdk.core.response.a.a.aD(j);
            aVar.f40790c = com.kwad.sdk.core.response.a.a.aE(j);
            aVar.f40792e = com.kwad.sdk.core.response.a.a.a(j, com.kwad.sdk.core.config.b.aJ());
            return aVar;
        }

        public String a(boolean z) {
            return this.a;
        }

        public CharSequence b(boolean z) {
            SpannableString spannableString;
            return (z || (spannableString = this.f40792e) == null) ? this.f40789b : spannableString;
        }
    }

    public e(ViewGroup viewGroup, boolean z, b bVar) {
        this.a = viewGroup;
        this.j = z;
        this.i = bVar;
        b();
    }

    private void b() {
        this.f40782b = (ViewGroup) this.a.findViewById(R.id.obfuscated_res_0x7f091102);
        this.f40783c = (KSCornerImageView) this.a.findViewById(R.id.obfuscated_res_0x7f0910ff);
        this.f40784d = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f091101);
        this.f40785e = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0910f2);
        this.f40786f = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0910f0);
        this.f40787g = (KSCornerImageView) this.a.findViewById(R.id.obfuscated_res_0x7f091100);
        this.f40788h = this.a.findViewById(R.id.obfuscated_res_0x7f09112f);
        this.f40786f.setOnClickListener(this);
        this.f40783c.setOnClickListener(this);
        this.f40788h.setOnClickListener(this);
        Context context = this.a.getContext();
        if (af.e(context)) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.width = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07037d);
            this.a.setLayoutParams(layoutParams2);
        }
    }

    @Override // com.kwad.sdk.reward.d.d
    public ViewGroup a() {
        return this.f40782b;
    }

    @Override // com.kwad.sdk.reward.d.d
    public void a(AdTemplate adTemplate) {
        super.a(adTemplate);
        a a2 = a.a(adTemplate);
        if (a2 == null) {
            return;
        }
        this.f40783c.setVisibility(this.j ? 8 : 0);
        KSImageLoader.loadImage(this.f40783c, a2.f40790c, adTemplate);
        String aF = com.kwad.sdk.core.config.b.aF();
        if (!at.a(aF)) {
            KSImageLoader.loadImage(this.f40787g, aF, adTemplate);
        }
        this.f40784d.setText(a2.a(this.j));
        this.f40785e.setText(a2.b(this.j));
        this.f40786f.setText(a2.f40791d);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.i == null) {
            return;
        }
        if (view.equals(this.f40786f)) {
            this.i.c();
        } else if (view.equals(this.f40783c)) {
            this.i.a();
        } else if (view.equals(this.f40788h)) {
            this.i.b();
        }
    }
}
