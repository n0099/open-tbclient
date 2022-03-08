package com.kwad.sdk.reward.d;

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
public class f extends d implements View.OnClickListener {
    public ViewGroup a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f55823b;

    /* renamed from: c  reason: collision with root package name */
    public KSCornerImageView f55824c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f55825d;

    /* renamed from: e  reason: collision with root package name */
    public KSCornerImageView f55826e;

    /* renamed from: f  reason: collision with root package name */
    public b f55827f;

    /* loaded from: classes8.dex */
    public static class a {
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f55828b;

        @Nullable
        public static a a(AdTemplate adTemplate) {
            if (adTemplate == null) {
                return null;
            }
            AdInfo j2 = com.kwad.sdk.core.response.a.d.j(adTemplate);
            a aVar = new a();
            aVar.f55828b = com.kwad.sdk.core.config.b.aD();
            aVar.a = com.kwad.sdk.core.response.a.a.aE(j2);
            return aVar;
        }
    }

    public f(ViewGroup viewGroup, b bVar) {
        this.a = viewGroup;
        this.f55827f = bVar;
        b();
    }

    private void b() {
        this.f55824c = (KSCornerImageView) this.a.findViewById(R.id.ksad_reward_followed_icon);
        this.f55825d = (TextView) this.a.findViewById(R.id.ksad_reward_followed_btn_follow);
        this.f55826e = (KSCornerImageView) this.a.findViewById(R.id.ksad_reward_followed_kwai_logo);
        this.f55823b = (ViewGroup) this.a.findViewById(R.id.ksad_reward_followed_root);
        this.f55825d.setOnClickListener(this);
        this.f55824c.setOnClickListener(this);
        this.f55823b.setOnClickListener(this);
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
        return this.f55823b;
    }

    @Override // com.kwad.sdk.reward.d.d
    public void a(AdTemplate adTemplate) {
        super.a(adTemplate);
        a a2 = a.a(adTemplate);
        if (a2 == null) {
            return;
        }
        this.f55825d.setText(a2.f55828b);
        KSImageLoader.loadImage(this.f55824c, a2.a, adTemplate);
        String aF = com.kwad.sdk.core.config.b.aF();
        if (at.a(aF)) {
            return;
        }
        KSImageLoader.loadImage(this.f55826e, aF, adTemplate);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f55827f == null) {
            return;
        }
        if (view.equals(this.f55825d)) {
            this.f55827f.c();
        } else if (view.equals(this.f55824c)) {
            this.f55827f.a();
        } else if (view.equals(this.f55823b)) {
            this.f55827f.b();
        }
    }
}
