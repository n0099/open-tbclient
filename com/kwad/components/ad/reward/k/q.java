package com.kwad.components.ad.reward.k;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.IdRes;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.components.ad.widget.KsAppTagsView;
import com.kwad.components.core.widget.KSCornerButton;
import com.kwad.components.core.widget.KsConvertButton;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
/* loaded from: classes9.dex */
public final class q extends p {
    @IdRes
    public int we;
    public ImageView wf;
    @Nullable
    public com.kwad.components.ad.reward.model.a wg;
    public View wh;

    public q(@IdRes int i) {
        this.we = i;
        this.wc = R.layout.obfuscated_res_0x7f0d04bc;
        this.wd = false;
    }

    @Override // com.kwad.components.ad.reward.k.p
    public final void a(com.kwad.components.ad.reward.model.a aVar) {
        super.a(aVar);
        this.wg = aVar;
    }

    public final void a(AdInfo adInfo, boolean z) {
        ImageView imageView = this.wf;
        if (imageView == null || adInfo == null) {
            return;
        }
        imageView.setVisibility(0);
        com.kwad.components.ad.reward.presenter.b.a(this.wf, com.kwad.sdk.core.response.a.a.K(adInfo));
    }

    @Override // com.kwad.components.ad.reward.k.d
    public final void aa(boolean z) {
        super.aa(z);
        ViewGroup viewGroup = this.pV;
        if (viewGroup == null) {
            return;
        }
        Resources resources = viewGroup.getResources();
        ImageView imageView = this.ll;
        if (imageView != null && this.wg != null) {
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            int i = 18;
            if (layoutParams != null) {
                int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0704dd);
                if (!z) {
                    dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0704e0);
                    i = 14;
                }
                layoutParams.width = dimensionPixelSize;
                layoutParams.height = dimensionPixelSize;
                this.ll.setLayoutParams(layoutParams);
                KSImageLoader.loadAppIcon(this.ll, this.wg.eL(), this.wg.gA(), i);
            }
        }
        TextView textView = this.nH;
        if (textView != null && (textView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && this.wg != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.nH.getLayoutParams();
            int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0704e7);
            if (!this.wg.gC() && z) {
                dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0704e6);
            }
            marginLayoutParams.topMargin = dimensionPixelSize2;
            this.nH.setLayoutParams(marginLayoutParams);
        }
        View view2 = this.wh;
        if (view2 == null || !(view2.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) || this.wg == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.wh.getLayoutParams();
        int dimensionPixelSize3 = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0704e4);
        if (z) {
            dimensionPixelSize3 = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0704e3);
        }
        marginLayoutParams2.topMargin = dimensionPixelSize3;
        this.wh.setLayoutParams(marginLayoutParams2);
    }

    @Override // com.kwad.components.ad.reward.k.p
    public final void g(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        this.bq = (KsLogoView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0912fe);
        this.ll = (ImageView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0912fc);
        this.li = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0912fd);
        this.uu = (KsAppTagsView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091305);
        this.nH = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0912fb);
        this.vX = (KSCornerButton) viewGroup.findViewById(R.id.obfuscated_res_0x7f091300);
        this.vY = (KsConvertButton) viewGroup.findViewById(R.id.obfuscated_res_0x7f0912f7);
        this.vZ = viewGroup.findViewById(R.id.obfuscated_res_0x7f0912ff);
        this.wf = (ImageView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0912f6);
        this.wh = viewGroup.findViewById(R.id.obfuscated_res_0x7f0912f8);
    }

    @Override // com.kwad.components.ad.reward.k.p
    public final int jb() {
        return this.we;
    }

    @Override // com.kwad.components.ad.reward.k.p
    public final int jc() {
        return R.id.obfuscated_res_0x7f0912f9;
    }
}
