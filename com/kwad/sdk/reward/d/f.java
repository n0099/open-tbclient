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
/* loaded from: classes7.dex */
public class f extends d implements View.OnClickListener {
    public ViewGroup a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f40793b;

    /* renamed from: c  reason: collision with root package name */
    public KSCornerImageView f40794c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f40795d;

    /* renamed from: e  reason: collision with root package name */
    public KSCornerImageView f40796e;

    /* renamed from: f  reason: collision with root package name */
    public b f40797f;

    /* loaded from: classes7.dex */
    public static class a {
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f40798b;

        @Nullable
        public static a a(AdTemplate adTemplate) {
            if (adTemplate == null) {
                return null;
            }
            AdInfo j = com.kwad.sdk.core.response.a.d.j(adTemplate);
            a aVar = new a();
            aVar.f40798b = com.kwad.sdk.core.config.b.aD();
            aVar.a = com.kwad.sdk.core.response.a.a.aE(j);
            return aVar;
        }
    }

    public f(ViewGroup viewGroup, b bVar) {
        this.a = viewGroup;
        this.f40797f = bVar;
        b();
    }

    private void b() {
        this.f40794c = (KSCornerImageView) this.a.findViewById(R.id.obfuscated_res_0x7f091105);
        this.f40795d = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f091103);
        this.f40796e = (KSCornerImageView) this.a.findViewById(R.id.obfuscated_res_0x7f091106);
        this.f40793b = (ViewGroup) this.a.findViewById(R.id.obfuscated_res_0x7f091107);
        this.f40795d.setOnClickListener(this);
        this.f40794c.setOnClickListener(this);
        this.f40793b.setOnClickListener(this);
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
        return this.f40793b;
    }

    @Override // com.kwad.sdk.reward.d.d
    public void a(AdTemplate adTemplate) {
        super.a(adTemplate);
        a a2 = a.a(adTemplate);
        if (a2 == null) {
            return;
        }
        this.f40795d.setText(a2.f40798b);
        KSImageLoader.loadImage(this.f40794c, a2.a, adTemplate);
        String aF = com.kwad.sdk.core.config.b.aF();
        if (at.a(aF)) {
            return;
        }
        KSImageLoader.loadImage(this.f40796e, aF, adTemplate);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f40797f == null) {
            return;
        }
        if (view.equals(this.f40795d)) {
            this.f40797f.c();
        } else if (view.equals(this.f40794c)) {
            this.f40797f.a();
        } else if (view.equals(this.f40793b)) {
            this.f40797f.b();
        }
    }
}
