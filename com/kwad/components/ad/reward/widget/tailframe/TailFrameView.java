package com.kwad.components.ad.reward.widget.tailframe;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.components.ad.reward.g;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.KSFrameLayout;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class TailFrameView extends KSFrameLayout {
    public com.kwad.components.ad.reward.widget.tailframe.a BL;
    public g qn;

    /* loaded from: classes10.dex */
    public static class a extends com.kwad.components.ad.reward.widget.tailframe.a implements com.kwad.sdk.widget.c {
        public a() {
            super(R.layout.obfuscated_res_0x7f0d052d);
        }

        @Override // com.kwad.components.ad.reward.widget.tailframe.a
        public final void a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, com.kwad.components.ad.reward.widget.tailframe.b bVar) {
            super.a(adTemplate, jSONObject, bVar);
            KSImageLoader.loadImage(this.BC, com.kwad.sdk.core.response.b.a.X(this.mAdInfo), this.mAdTemplate);
        }
    }

    /* loaded from: classes10.dex */
    public static class b extends com.kwad.components.ad.reward.widget.tailframe.a implements com.kwad.sdk.widget.c {
        public ImageView BM;
        public ImageView BN;
        public ImageView BO;

        public b() {
            super(R.layout.obfuscated_res_0x7f0d052e);
        }

        private void kl() {
            KSImageLoader.loadImage(this.BM, com.kwad.sdk.core.response.b.a.X(this.mAdInfo), this.mAdTemplate);
            KSImageLoader.loadImage(this.BN, com.kwad.sdk.core.response.b.a.X(this.mAdInfo), this.mAdTemplate);
            KSImageLoader.loadImage(this.BO, com.kwad.sdk.core.response.b.a.X(this.mAdInfo), this.mAdTemplate);
        }

        @Override // com.kwad.components.ad.reward.widget.tailframe.a
        public final void B(Context context) {
            super.B(context);
            this.BM = (ImageView) this.BB.findViewById(R.id.obfuscated_res_0x7f09150e);
            this.BN = (ImageView) this.BB.findViewById(R.id.obfuscated_res_0x7f09150f);
            this.BO = (ImageView) this.BB.findViewById(R.id.obfuscated_res_0x7f091510);
        }

        @Override // com.kwad.components.ad.reward.widget.tailframe.a
        public final void a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, com.kwad.components.ad.reward.widget.tailframe.b bVar) {
            super.a(adTemplate, jSONObject, bVar);
            kl();
        }
    }

    /* loaded from: classes10.dex */
    public static class c extends com.kwad.components.ad.reward.widget.tailframe.a implements com.kwad.sdk.widget.c {
        public View BP;

        public c() {
            super(R.layout.obfuscated_res_0x7f0d052f);
        }

        private void kl() {
            AdInfo.AdMaterialInfo.MaterialFeature aX = com.kwad.sdk.core.response.b.a.aX(this.mAdInfo);
            int i = aX.width;
            int i2 = aX.height;
            int screenWidth = com.kwad.sdk.d.a.a.getScreenWidth(this.BB.getContext());
            ViewGroup.LayoutParams layoutParams = this.BC.getLayoutParams();
            layoutParams.width = screenWidth;
            layoutParams.height = (int) (screenWidth * (i2 / i));
            KSImageLoader.loadImage(this.BC, aX.coverUrl, this.mAdTemplate);
        }

        @Override // com.kwad.components.ad.reward.widget.tailframe.a
        public final void B(Context context) {
            super.B(context);
            this.BP = this.BB.findViewById(R.id.obfuscated_res_0x7f0929b0);
        }

        @Override // com.kwad.components.ad.reward.widget.tailframe.a
        public final void a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, com.kwad.components.ad.reward.widget.tailframe.b bVar) {
            super.a(adTemplate, jSONObject, bVar);
            if (e.F(this.mAdTemplate)) {
                this.BP.setVisibility(8);
                this.mLogoView.setVisibility(8);
                this.BB.setBackground(null);
            }
            kl();
        }
    }

    /* loaded from: classes10.dex */
    public static class d extends com.kwad.components.ad.reward.widget.tailframe.a {
        public d() {
            super(R.layout.obfuscated_res_0x7f0d0530);
        }

        @Override // com.kwad.components.ad.reward.widget.tailframe.a
        public final void a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, com.kwad.components.ad.reward.widget.tailframe.b bVar) {
            super.a(adTemplate, jSONObject, bVar);
            if (e.F(this.mAdTemplate)) {
                this.BB.setBackground(null);
                this.BC.setVisibility(8);
                this.mLogoView.setVisibility(8);
            }
            KSImageLoader.loadImage(this.BC, com.kwad.sdk.core.response.b.a.X(this.mAdInfo), this.mAdTemplate);
        }
    }

    public TailFrameView(@NonNull Context context) {
        super(context);
    }

    public final void a(com.kwad.components.ad.reward.widget.tailframe.b bVar) {
        this.BL.setCallerContext(this.qn);
        com.kwad.components.ad.reward.widget.tailframe.a aVar = this.BL;
        g gVar = this.qn;
        aVar.a(gVar.mAdTemplate, gVar.mReportExtData, bVar);
    }

    public void setCallerContext(g gVar) {
        this.qn = gVar;
    }

    public TailFrameView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void f(boolean z, boolean z2) {
        if (this.BL != null) {
            return;
        }
        if (z) {
            if (z2) {
                this.BL = new d();
            } else {
                this.BL = new c();
            }
        } else if (z2) {
            this.BL = new b();
        } else {
            this.BL = new a();
        }
    }

    public TailFrameView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void a(Context context, boolean z, boolean z2) {
        f(z, z2);
        this.BL.B(context);
        this.BL.f(z, z2);
        addView(this.BL.kh(), -1, -1);
    }

    public TailFrameView(@NonNull Context context, View view2) {
        super(context, view2);
    }

    public final void destroy() {
        com.kwad.components.ad.reward.widget.tailframe.a aVar = this.BL;
        if (aVar != null) {
            aVar.destroy();
        }
    }

    public final void jO() {
        this.BL.jO();
    }
}
