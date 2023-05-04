package com.kwad.components.ad.reward.widget.tailframe;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.baidu.tieba.R;
import com.kwad.components.ad.reward.k;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.KSFrameLayout;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class TailFrameView extends KSFrameLayout {
    public k nM;
    public com.kwad.components.ad.reward.widget.tailframe.a xe;

    /* loaded from: classes8.dex */
    public static class a extends com.kwad.components.ad.reward.widget.tailframe.a implements com.kwad.sdk.widget.c {
        public a() {
            super(R.layout.obfuscated_res_0x7f0d04bf);
        }

        @Override // com.kwad.components.ad.reward.widget.tailframe.a
        public final void a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, com.kwad.components.ad.reward.widget.tailframe.b bVar) {
            super.a(adTemplate, jSONObject, bVar);
            KSImageLoader.loadImage(this.wV, com.kwad.sdk.core.response.a.a.K(this.mAdInfo), this.mAdTemplate);
        }
    }

    /* loaded from: classes8.dex */
    public static class b extends com.kwad.components.ad.reward.widget.tailframe.a implements com.kwad.sdk.widget.c {
        public ImageView xf;
        public ImageView xg;
        public ImageView xh;

        public b() {
            super(R.layout.obfuscated_res_0x7f0d04c0);
        }

        private void jm() {
            KSImageLoader.loadImage(this.xf, com.kwad.sdk.core.response.a.a.K(this.mAdInfo), this.mAdTemplate);
            KSImageLoader.loadImage(this.xg, com.kwad.sdk.core.response.a.a.K(this.mAdInfo), this.mAdTemplate);
            KSImageLoader.loadImage(this.xh, com.kwad.sdk.core.response.a.a.K(this.mAdInfo), this.mAdTemplate);
        }

        @Override // com.kwad.components.ad.reward.widget.tailframe.a
        public final void E(Context context) {
            super.E(context);
            this.xf = (ImageView) this.wU.findViewById(R.id.obfuscated_res_0x7f0913b0);
            this.xg = (ImageView) this.wU.findViewById(R.id.obfuscated_res_0x7f0913b1);
            this.xh = (ImageView) this.wU.findViewById(R.id.obfuscated_res_0x7f0913b2);
        }

        @Override // com.kwad.components.ad.reward.widget.tailframe.a
        public final void a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, com.kwad.components.ad.reward.widget.tailframe.b bVar) {
            super.a(adTemplate, jSONObject, bVar);
            jm();
        }
    }

    /* loaded from: classes8.dex */
    public static class c extends com.kwad.components.ad.reward.widget.tailframe.a implements com.kwad.sdk.widget.c {
        public View xi;

        public c() {
            super(R.layout.obfuscated_res_0x7f0d04c1);
        }

        private void jm() {
            AdInfo.AdMaterialInfo.MaterialFeature au = com.kwad.sdk.core.response.a.a.au(this.mAdInfo);
            int i = au.width;
            int i2 = au.height;
            int screenWidth = com.kwad.sdk.b.kwai.a.getScreenWidth(this.wU.getContext());
            ViewGroup.LayoutParams layoutParams = this.wV.getLayoutParams();
            layoutParams.width = screenWidth;
            layoutParams.height = (int) (screenWidth * (i2 / i));
            KSImageLoader.loadImage(this.wV, au.coverUrl, this.mAdTemplate);
        }

        @Override // com.kwad.components.ad.reward.widget.tailframe.a
        public final void E(Context context) {
            super.E(context);
            this.xi = this.wU.findViewById(R.id.obfuscated_res_0x7f09273d);
        }

        @Override // com.kwad.components.ad.reward.widget.tailframe.a
        public final void a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, com.kwad.components.ad.reward.widget.tailframe.b bVar) {
            super.a(adTemplate, jSONObject, bVar);
            if (com.kwad.sdk.core.response.a.d.p(this.mAdTemplate)) {
                this.xi.setVisibility(8);
                this.bq.setVisibility(8);
                View view2 = this.wU;
                view2.setBackgroundColor(ContextCompat.getColor(view2.getContext(), R.color.obfuscated_res_0x7f06062b));
            }
            jm();
        }
    }

    /* loaded from: classes8.dex */
    public static class d extends com.kwad.components.ad.reward.widget.tailframe.a {
        public d() {
            super(R.layout.obfuscated_res_0x7f0d04c2);
        }

        @Override // com.kwad.components.ad.reward.widget.tailframe.a
        public final void a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, com.kwad.components.ad.reward.widget.tailframe.b bVar) {
            super.a(adTemplate, jSONObject, bVar);
            if (com.kwad.sdk.core.response.a.d.p(this.mAdTemplate)) {
                View view2 = this.wU;
                view2.setBackgroundColor(ContextCompat.getColor(view2.getContext(), R.color.obfuscated_res_0x7f06062b));
                this.wV.setVisibility(8);
                this.bq.setVisibility(8);
            }
            KSImageLoader.loadImage(this.wV, com.kwad.sdk.core.response.a.a.K(this.mAdInfo), this.mAdTemplate);
        }
    }

    public TailFrameView(@NonNull Context context) {
        super(context);
    }

    public TailFrameView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TailFrameView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public TailFrameView(@NonNull Context context, View view2) {
        super(context, view2);
    }

    private void d(boolean z, boolean z2) {
        if (this.xe != null) {
            return;
        }
        this.xe = z ? z2 ? new d() : new c() : z2 ? new b() : new a();
    }

    public final void a(Context context, boolean z, boolean z2) {
        d(z, z2);
        this.xe.E(context);
        this.xe.d(z, z2);
        addView(this.xe.ji(), -1, -1);
    }

    public final void a(com.kwad.components.ad.reward.widget.tailframe.b bVar) {
        this.xe.setCallerContext(this.nM);
        com.kwad.components.ad.reward.widget.tailframe.a aVar = this.xe;
        k kVar = this.nM;
        aVar.a(kVar.mAdTemplate, kVar.mReportExtData, bVar);
    }

    public final void destroy() {
        com.kwad.components.ad.reward.widget.tailframe.a aVar = this.xe;
        if (aVar != null) {
            aVar.destroy();
        }
    }

    public final void iP() {
        this.xe.iP();
    }

    public void setCallerContext(k kVar) {
        this.nM = kVar;
    }
}
