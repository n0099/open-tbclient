package com.kwad.components.ad.reward.k;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.components.ad.widget.KsAppTagsView;
import com.kwad.components.core.widget.KSCornerButton;
import com.kwad.components.core.widget.KsConvertButton;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.core.imageloader.KSImageLoader;
/* loaded from: classes10.dex */
public class p extends v implements View.OnClickListener {
    public KsLogoView bq;
    public TextView li;
    public ImageView ll;
    public TextView nH;
    @Nullable
    public KsAppTagsView uu;
    public KSCornerButton vX;
    public KsConvertButton vY;
    public View vZ;
    @Nullable
    public TextView wa;
    public a wb;
    @LayoutRes
    public int wc = R.layout.obfuscated_res_0x7f0d04d1;
    public boolean wd = true;

    /* loaded from: classes10.dex */
    public interface a {
        void hs();

        void ht();

        void hu();

        void hv();
    }

    private void T(int i) {
        KSCornerButton kSCornerButton = this.vX;
        if (kSCornerButton == null || this.vY == null) {
            return;
        }
        if (i == 1) {
            kSCornerButton.getCornerConf().bx(true);
            this.vY.getCornerConf().bx(true);
            this.vZ.setVisibility(0);
        } else if (i == 2) {
            kSCornerButton.getCornerConf().bt(true).bw(true).bv(false).bu(false);
            this.vY.getCornerConf().bt(false).bw(false).bv(true).bu(true);
            this.vZ.setVisibility(8);
        }
        this.vX.postInvalidate();
        this.vY.postInvalidate();
    }

    public final void a(a aVar) {
        this.wb = aVar;
    }

    @Override // com.kwad.components.ad.reward.k.d
    public final void a(u uVar) {
        super.a(uVar);
        a(com.kwad.components.ad.reward.model.a.a(uVar, this.wd));
    }

    public void a(com.kwad.components.ad.reward.model.a aVar) {
        TextView textView;
        int i;
        int i2;
        if (aVar == null || this.vX == null) {
            return;
        }
        T(aVar.gD());
        this.bq.T(aVar.gA());
        this.li.setText(aVar.getTitle());
        this.nH.setText(aVar.fO());
        TextView textView2 = this.wa;
        if (textView2 != null) {
            textView2.setText(aVar.fO());
            if (TextUtils.isEmpty(aVar.fO())) {
                i2 = 8;
            } else if (aVar.gC()) {
                i2 = 8;
                i = 0;
                this.nH.setVisibility(i2);
                textView = this.wa;
            } else {
                i2 = 0;
            }
            i = 8;
            this.nH.setVisibility(i2);
            textView = this.wa;
        } else {
            textView = this.nH;
            i = TextUtils.isEmpty(aVar.fO()) ? 8 : 0;
        }
        textView.setVisibility(i);
        KsAppTagsView ksAppTagsView = this.uu;
        if (ksAppTagsView != null) {
            ksAppTagsView.c(aVar.gB(), this.wc);
            this.uu.setVisibility(aVar.gC() ? 8 : 0);
        }
        this.vY.a(aVar.getApkDownloadHelper(), aVar.gA());
        KSImageLoader.loadAppIcon(this.ll, aVar.eL(), aVar.gA(), 12);
    }

    public final void e(ViewGroup viewGroup) {
        super.a(viewGroup, jb(), jc());
        g(this.pV);
        ViewGroup viewGroup2 = this.pV;
        if (viewGroup2 != null) {
            viewGroup2.setOnClickListener(this);
            this.vX.setOnClickListener(this);
            this.vY.setOnClickListener(this);
        }
    }

    public void g(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        this.bq = (KsLogoView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0913d9);
        this.ll = (ImageView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0913d6);
        this.li = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0913db);
        this.uu = (KsAppTagsView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0913dc);
        this.nH = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0913d4);
        this.wa = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0913d5);
        this.vX = (KSCornerButton) viewGroup.findViewById(R.id.obfuscated_res_0x7f0913d8);
        this.vY = (KsConvertButton) viewGroup.findViewById(R.id.obfuscated_res_0x7f0913d1);
        this.vZ = viewGroup.findViewById(R.id.obfuscated_res_0x7f0913da);
    }

    public int jb() {
        return R.id.obfuscated_res_0x7f0913d3;
    }

    public int jc() {
        return R.id.obfuscated_res_0x7f0913d2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        a aVar;
        if (view2.equals(this.vX)) {
            a aVar2 = this.wb;
            if (aVar2 != null) {
                aVar2.ht();
            }
        } else if (view2.equals(this.vY)) {
            a aVar3 = this.wb;
            if (aVar3 != null) {
                aVar3.hu();
            }
        } else if (!view2.equals(this.pV) || (aVar = this.wb) == null) {
        } else {
            aVar.hv();
        }
    }

    public final void show() {
        ViewGroup viewGroup = this.pV;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
            a aVar = this.wb;
            if (aVar != null) {
                aVar.hs();
            }
        }
    }
}
