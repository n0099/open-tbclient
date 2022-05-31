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
/* loaded from: classes5.dex */
public class f extends d implements View.OnClickListener {
    public ViewGroup a;
    public ViewGroup b;
    public KSCornerImageView c;
    public TextView d;
    public KSCornerImageView e;
    public b f;

    /* loaded from: classes5.dex */
    public static class a {
        public String a;
        public String b;

        @Nullable
        public static a a(AdTemplate adTemplate) {
            if (adTemplate == null) {
                return null;
            }
            AdInfo j = com.kwad.sdk.core.response.a.d.j(adTemplate);
            a aVar = new a();
            aVar.b = com.kwad.sdk.core.config.b.aD();
            aVar.a = com.kwad.sdk.core.response.a.a.aE(j);
            return aVar;
        }
    }

    public f(ViewGroup viewGroup, b bVar) {
        this.a = viewGroup;
        this.f = bVar;
        b();
    }

    private void b() {
        this.c = (KSCornerImageView) this.a.findViewById(R.id.obfuscated_res_0x7f0910d0);
        this.d = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0910cb);
        this.e = (KSCornerImageView) this.a.findViewById(R.id.obfuscated_res_0x7f0910d1);
        this.b = (ViewGroup) this.a.findViewById(R.id.obfuscated_res_0x7f0910d2);
        this.d.setOnClickListener(this);
        this.c.setOnClickListener(this);
        this.b.setOnClickListener(this);
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
        return this.b;
    }

    @Override // com.kwad.sdk.reward.d.d
    public void a(AdTemplate adTemplate) {
        super.a(adTemplate);
        a a2 = a.a(adTemplate);
        if (a2 == null) {
            return;
        }
        this.d.setText(a2.b);
        KSImageLoader.loadImage(this.c, a2.a, adTemplate);
        String aF = com.kwad.sdk.core.config.b.aF();
        if (at.a(aF)) {
            return;
        }
        KSImageLoader.loadImage(this.e, aF, adTemplate);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (this.f == null) {
            return;
        }
        if (view2.equals(this.d)) {
            this.f.c();
        } else if (view2.equals(this.c)) {
            this.f.a();
        } else if (view2.equals(this.b)) {
            this.f.b();
        }
    }
}
