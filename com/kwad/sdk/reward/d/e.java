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
/* loaded from: classes4.dex */
public class e extends d implements View.OnClickListener {
    public ViewGroup a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f57460b;

    /* renamed from: c  reason: collision with root package name */
    public KSCornerImageView f57461c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f57462d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f57463e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f57464f;

    /* renamed from: g  reason: collision with root package name */
    public KSCornerImageView f57465g;

    /* renamed from: h  reason: collision with root package name */
    public View f57466h;

    /* renamed from: i  reason: collision with root package name */
    public b f57467i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f57468j;

    /* loaded from: classes4.dex */
    public static class a {
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f57469b;

        /* renamed from: c  reason: collision with root package name */
        public String f57470c;

        /* renamed from: d  reason: collision with root package name */
        public String f57471d;

        /* renamed from: e  reason: collision with root package name */
        public SpannableString f57472e;

        @Nullable
        public static a a(AdTemplate adTemplate) {
            if (adTemplate == null) {
                return null;
            }
            AdInfo j2 = com.kwad.sdk.core.response.a.d.j(adTemplate);
            a aVar = new a();
            aVar.f57471d = com.kwad.sdk.core.config.b.aG();
            aVar.f57469b = com.kwad.sdk.core.response.a.a.aC(j2);
            aVar.a = com.kwad.sdk.core.response.a.a.aD(j2);
            aVar.f57470c = com.kwad.sdk.core.response.a.a.aE(j2);
            aVar.f57472e = com.kwad.sdk.core.response.a.a.a(j2, com.kwad.sdk.core.config.b.aJ());
            return aVar;
        }

        public String a(boolean z) {
            return this.a;
        }

        public CharSequence b(boolean z) {
            SpannableString spannableString;
            return (z || (spannableString = this.f57472e) == null) ? this.f57469b : spannableString;
        }
    }

    public e(ViewGroup viewGroup, boolean z, b bVar) {
        this.a = viewGroup;
        this.f57468j = z;
        this.f57467i = bVar;
        b();
    }

    private void b() {
        this.f57460b = (ViewGroup) this.a.findViewById(R.id.ksad_reward_follow_root);
        this.f57461c = (KSCornerImageView) this.a.findViewById(R.id.ksad_reward_follow_icon);
        this.f57462d = (TextView) this.a.findViewById(R.id.ksad_reward_follow_name);
        this.f57463e = (TextView) this.a.findViewById(R.id.ksad_reward_follow_desc);
        this.f57464f = (TextView) this.a.findViewById(R.id.ksad_reward_follow_btn_follow);
        this.f57465g = (KSCornerImageView) this.a.findViewById(R.id.ksad_reward_follow_kwai_logo);
        this.f57466h = this.a.findViewById(R.id.ksad_reward_text_aera);
        this.f57464f.setOnClickListener(this);
        this.f57461c.setOnClickListener(this);
        this.f57466h.setOnClickListener(this);
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
        return this.f57460b;
    }

    @Override // com.kwad.sdk.reward.d.d
    public void a(AdTemplate adTemplate) {
        super.a(adTemplate);
        a a2 = a.a(adTemplate);
        if (a2 == null) {
            return;
        }
        this.f57461c.setVisibility(this.f57468j ? 8 : 0);
        KSImageLoader.loadImage(this.f57461c, a2.f57470c, adTemplate);
        String aF = com.kwad.sdk.core.config.b.aF();
        if (!at.a(aF)) {
            KSImageLoader.loadImage(this.f57465g, aF, adTemplate);
        }
        this.f57462d.setText(a2.a(this.f57468j));
        this.f57463e.setText(a2.b(this.f57468j));
        this.f57464f.setText(a2.f57471d);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f57467i == null) {
            return;
        }
        if (view.equals(this.f57464f)) {
            this.f57467i.c();
        } else if (view.equals(this.f57461c)) {
            this.f57467i.a();
        } else if (view.equals(this.f57466h)) {
            this.f57467i.b();
        }
    }
}
