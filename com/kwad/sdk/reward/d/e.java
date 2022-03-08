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
/* loaded from: classes8.dex */
public class e extends d implements View.OnClickListener {
    public ViewGroup a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f55810b;

    /* renamed from: c  reason: collision with root package name */
    public KSCornerImageView f55811c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f55812d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f55813e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f55814f;

    /* renamed from: g  reason: collision with root package name */
    public KSCornerImageView f55815g;

    /* renamed from: h  reason: collision with root package name */
    public View f55816h;

    /* renamed from: i  reason: collision with root package name */
    public b f55817i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f55818j;

    /* loaded from: classes8.dex */
    public static class a {
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f55819b;

        /* renamed from: c  reason: collision with root package name */
        public String f55820c;

        /* renamed from: d  reason: collision with root package name */
        public String f55821d;

        /* renamed from: e  reason: collision with root package name */
        public SpannableString f55822e;

        @Nullable
        public static a a(AdTemplate adTemplate) {
            if (adTemplate == null) {
                return null;
            }
            AdInfo j2 = com.kwad.sdk.core.response.a.d.j(adTemplate);
            a aVar = new a();
            aVar.f55821d = com.kwad.sdk.core.config.b.aG();
            aVar.f55819b = com.kwad.sdk.core.response.a.a.aC(j2);
            aVar.a = com.kwad.sdk.core.response.a.a.aD(j2);
            aVar.f55820c = com.kwad.sdk.core.response.a.a.aE(j2);
            aVar.f55822e = com.kwad.sdk.core.response.a.a.a(j2, com.kwad.sdk.core.config.b.aJ());
            return aVar;
        }

        public String a(boolean z) {
            return this.a;
        }

        public CharSequence b(boolean z) {
            SpannableString spannableString;
            return (z || (spannableString = this.f55822e) == null) ? this.f55819b : spannableString;
        }
    }

    public e(ViewGroup viewGroup, boolean z, b bVar) {
        this.a = viewGroup;
        this.f55818j = z;
        this.f55817i = bVar;
        b();
    }

    private void b() {
        this.f55810b = (ViewGroup) this.a.findViewById(R.id.ksad_reward_follow_root);
        this.f55811c = (KSCornerImageView) this.a.findViewById(R.id.ksad_reward_follow_icon);
        this.f55812d = (TextView) this.a.findViewById(R.id.ksad_reward_follow_name);
        this.f55813e = (TextView) this.a.findViewById(R.id.ksad_reward_follow_desc);
        this.f55814f = (TextView) this.a.findViewById(R.id.ksad_reward_follow_btn_follow);
        this.f55815g = (KSCornerImageView) this.a.findViewById(R.id.ksad_reward_follow_kwai_logo);
        this.f55816h = this.a.findViewById(R.id.ksad_reward_text_aera);
        this.f55814f.setOnClickListener(this);
        this.f55811c.setOnClickListener(this);
        this.f55816h.setOnClickListener(this);
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
        return this.f55810b;
    }

    @Override // com.kwad.sdk.reward.d.d
    public void a(AdTemplate adTemplate) {
        super.a(adTemplate);
        a a2 = a.a(adTemplate);
        if (a2 == null) {
            return;
        }
        this.f55811c.setVisibility(this.f55818j ? 8 : 0);
        KSImageLoader.loadImage(this.f55811c, a2.f55820c, adTemplate);
        String aF = com.kwad.sdk.core.config.b.aF();
        if (!at.a(aF)) {
            KSImageLoader.loadImage(this.f55815g, aF, adTemplate);
        }
        this.f55812d.setText(a2.a(this.f55818j));
        this.f55813e.setText(a2.b(this.f55818j));
        this.f55814f.setText(a2.f55821d);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f55817i == null) {
            return;
        }
        if (view.equals(this.f55814f)) {
            this.f55817i.c();
        } else if (view.equals(this.f55811c)) {
            this.f55817i.a();
        } else if (view.equals(this.f55816h)) {
            this.f55817i.b();
        }
    }
}
