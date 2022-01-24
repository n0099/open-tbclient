package com.kwad.sdk.reward.d;

import android.content.Context;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.af;
import com.kwad.sdk.utils.at;
import com.kwad.sdk.widget.KSCornerImageView;
/* loaded from: classes3.dex */
public class e extends d implements View.OnClickListener {
    public ViewGroup a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f57293b;

    /* renamed from: c  reason: collision with root package name */
    public KSCornerImageView f57294c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f57295d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f57296e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f57297f;

    /* renamed from: g  reason: collision with root package name */
    public KSCornerImageView f57298g;

    /* renamed from: h  reason: collision with root package name */
    public View f57299h;

    /* renamed from: i  reason: collision with root package name */
    public b f57300i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f57301j;

    /* loaded from: classes3.dex */
    public static class a {
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f57302b;

        /* renamed from: c  reason: collision with root package name */
        public String f57303c;

        /* renamed from: d  reason: collision with root package name */
        public String f57304d;

        /* renamed from: e  reason: collision with root package name */
        public SpannableString f57305e;

        @Nullable
        public static a a(AdTemplate adTemplate) {
            if (adTemplate == null) {
                return null;
            }
            AdInfo j2 = com.kwad.sdk.core.response.a.d.j(adTemplate);
            a aVar = new a();
            aVar.f57304d = com.kwad.sdk.core.config.b.aG();
            aVar.f57302b = com.kwad.sdk.core.response.a.a.aC(j2);
            aVar.a = com.kwad.sdk.core.response.a.a.aD(j2);
            aVar.f57303c = com.kwad.sdk.core.response.a.a.aE(j2);
            aVar.f57305e = com.kwad.sdk.core.response.a.a.a(j2, com.kwad.sdk.core.config.b.aJ());
            return aVar;
        }

        public String a(boolean z) {
            return this.a;
        }

        public CharSequence b(boolean z) {
            SpannableString spannableString;
            return (z || (spannableString = this.f57305e) == null) ? this.f57302b : spannableString;
        }
    }

    public e(ViewGroup viewGroup, boolean z, b bVar) {
        this.a = viewGroup;
        this.f57301j = z;
        this.f57300i = bVar;
        b();
    }

    private void b() {
        this.f57293b = (ViewGroup) this.a.findViewById(R.id.ksad_reward_follow_root);
        this.f57294c = (KSCornerImageView) this.a.findViewById(R.id.ksad_reward_follow_icon);
        this.f57295d = (TextView) this.a.findViewById(R.id.ksad_reward_follow_name);
        this.f57296e = (TextView) this.a.findViewById(R.id.ksad_reward_follow_desc);
        this.f57297f = (TextView) this.a.findViewById(R.id.ksad_reward_follow_btn_follow);
        this.f57298g = (KSCornerImageView) this.a.findViewById(R.id.ksad_reward_follow_kwai_logo);
        this.f57299h = this.a.findViewById(R.id.ksad_reward_text_aera);
        this.f57297f.setOnClickListener(this);
        this.f57294c.setOnClickListener(this);
        this.f57299h.setOnClickListener(this);
        Context context = this.a.getContext();
        if (af.e(context)) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.width = context.getResources().getDimensionPixelSize(R.dimen.ksad_reward_follow_card_width_horizontal);
            this.a.setLayoutParams(layoutParams2);
        }
    }

    @Override // com.kwad.sdk.reward.d.d
    public ViewGroup a() {
        return this.f57293b;
    }

    @Override // com.kwad.sdk.reward.d.d
    public void a(AdTemplate adTemplate) {
        super.a(adTemplate);
        a a2 = a.a(adTemplate);
        if (a2 == null) {
            return;
        }
        this.f57294c.setVisibility(this.f57301j ? 8 : 0);
        KSImageLoader.loadImage(this.f57294c, a2.f57303c, adTemplate);
        String aF = com.kwad.sdk.core.config.b.aF();
        if (!at.a(aF)) {
            KSImageLoader.loadImage(this.f57298g, aF, adTemplate);
        }
        this.f57295d.setText(a2.a(this.f57301j));
        this.f57296e.setText(a2.b(this.f57301j));
        this.f57297f.setText(a2.f57304d);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f57300i == null) {
            return;
        }
        if (view.equals(this.f57297f)) {
            this.f57300i.c();
        } else if (view.equals(this.f57294c)) {
            this.f57300i.a();
        } else if (view.equals(this.f57299h)) {
            this.f57300i.b();
        }
    }
}
