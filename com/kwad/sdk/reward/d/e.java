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
    public ViewGroup f57248b;

    /* renamed from: c  reason: collision with root package name */
    public KSCornerImageView f57249c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f57250d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f57251e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f57252f;

    /* renamed from: g  reason: collision with root package name */
    public KSCornerImageView f57253g;

    /* renamed from: h  reason: collision with root package name */
    public View f57254h;

    /* renamed from: i  reason: collision with root package name */
    public b f57255i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f57256j;

    /* loaded from: classes3.dex */
    public static class a {
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f57257b;

        /* renamed from: c  reason: collision with root package name */
        public String f57258c;

        /* renamed from: d  reason: collision with root package name */
        public String f57259d;

        /* renamed from: e  reason: collision with root package name */
        public SpannableString f57260e;

        @Nullable
        public static a a(AdTemplate adTemplate) {
            if (adTemplate == null) {
                return null;
            }
            AdInfo j2 = com.kwad.sdk.core.response.a.d.j(adTemplate);
            a aVar = new a();
            aVar.f57259d = com.kwad.sdk.core.config.b.aG();
            aVar.f57257b = com.kwad.sdk.core.response.a.a.aC(j2);
            aVar.a = com.kwad.sdk.core.response.a.a.aD(j2);
            aVar.f57258c = com.kwad.sdk.core.response.a.a.aE(j2);
            aVar.f57260e = com.kwad.sdk.core.response.a.a.a(j2, com.kwad.sdk.core.config.b.aJ());
            return aVar;
        }

        public String a(boolean z) {
            return this.a;
        }

        public CharSequence b(boolean z) {
            SpannableString spannableString;
            return (z || (spannableString = this.f57260e) == null) ? this.f57257b : spannableString;
        }
    }

    public e(ViewGroup viewGroup, boolean z, b bVar) {
        this.a = viewGroup;
        this.f57256j = z;
        this.f57255i = bVar;
        b();
    }

    private void b() {
        this.f57248b = (ViewGroup) this.a.findViewById(R.id.ksad_reward_follow_root);
        this.f57249c = (KSCornerImageView) this.a.findViewById(R.id.ksad_reward_follow_icon);
        this.f57250d = (TextView) this.a.findViewById(R.id.ksad_reward_follow_name);
        this.f57251e = (TextView) this.a.findViewById(R.id.ksad_reward_follow_desc);
        this.f57252f = (TextView) this.a.findViewById(R.id.ksad_reward_follow_btn_follow);
        this.f57253g = (KSCornerImageView) this.a.findViewById(R.id.ksad_reward_follow_kwai_logo);
        this.f57254h = this.a.findViewById(R.id.ksad_reward_text_aera);
        this.f57252f.setOnClickListener(this);
        this.f57249c.setOnClickListener(this);
        this.f57254h.setOnClickListener(this);
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
        return this.f57248b;
    }

    @Override // com.kwad.sdk.reward.d.d
    public void a(AdTemplate adTemplate) {
        super.a(adTemplate);
        a a2 = a.a(adTemplate);
        if (a2 == null) {
            return;
        }
        this.f57249c.setVisibility(this.f57256j ? 8 : 0);
        KSImageLoader.loadImage(this.f57249c, a2.f57258c, adTemplate);
        String aF = com.kwad.sdk.core.config.b.aF();
        if (!at.a(aF)) {
            KSImageLoader.loadImage(this.f57253g, aF, adTemplate);
        }
        this.f57250d.setText(a2.a(this.f57256j));
        this.f57251e.setText(a2.b(this.f57256j));
        this.f57252f.setText(a2.f57259d);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f57255i == null) {
            return;
        }
        if (view.equals(this.f57252f)) {
            this.f57255i.c();
        } else if (view.equals(this.f57249c)) {
            this.f57255i.a();
        } else if (view.equals(this.f57254h)) {
            this.f57255i.b();
        }
    }
}
