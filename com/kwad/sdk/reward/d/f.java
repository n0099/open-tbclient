package com.kwad.sdk.reward.d;

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
public class f extends d implements View.OnClickListener {
    public ViewGroup a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f57306b;

    /* renamed from: c  reason: collision with root package name */
    public KSCornerImageView f57307c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f57308d;

    /* renamed from: e  reason: collision with root package name */
    public KSCornerImageView f57309e;

    /* renamed from: f  reason: collision with root package name */
    public b f57310f;

    /* loaded from: classes3.dex */
    public static class a {
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f57311b;

        @Nullable
        public static a a(AdTemplate adTemplate) {
            if (adTemplate == null) {
                return null;
            }
            AdInfo j2 = com.kwad.sdk.core.response.a.d.j(adTemplate);
            a aVar = new a();
            aVar.f57311b = com.kwad.sdk.core.config.b.aD();
            aVar.a = com.kwad.sdk.core.response.a.a.aE(j2);
            return aVar;
        }
    }

    public f(ViewGroup viewGroup, b bVar) {
        this.a = viewGroup;
        this.f57310f = bVar;
        b();
    }

    private void b() {
        this.f57307c = (KSCornerImageView) this.a.findViewById(R.id.ksad_reward_followed_icon);
        this.f57308d = (TextView) this.a.findViewById(R.id.ksad_reward_followed_btn_follow);
        this.f57309e = (KSCornerImageView) this.a.findViewById(R.id.ksad_reward_followed_kwai_logo);
        this.f57306b = (ViewGroup) this.a.findViewById(R.id.ksad_reward_followed_root);
        this.f57308d.setOnClickListener(this);
        this.f57307c.setOnClickListener(this);
        this.f57306b.setOnClickListener(this);
        if (af.e(this.a.getContext())) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            this.a.setLayoutParams((FrameLayout.LayoutParams) layoutParams);
        }
    }

    @Override // com.kwad.sdk.reward.d.d
    public ViewGroup a() {
        return this.f57306b;
    }

    @Override // com.kwad.sdk.reward.d.d
    public void a(AdTemplate adTemplate) {
        super.a(adTemplate);
        a a2 = a.a(adTemplate);
        if (a2 == null) {
            return;
        }
        this.f57308d.setText(a2.f57311b);
        KSImageLoader.loadImage(this.f57307c, a2.a, adTemplate);
        String aF = com.kwad.sdk.core.config.b.aF();
        if (at.a(aF)) {
            return;
        }
        KSImageLoader.loadImage(this.f57309e, aF, adTemplate);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f57310f == null) {
            return;
        }
        if (view.equals(this.f57308d)) {
            this.f57310f.c();
        } else if (view.equals(this.f57307c)) {
            this.f57310f.a();
        } else if (view.equals(this.f57306b)) {
            this.f57310f.b();
        }
    }
}
