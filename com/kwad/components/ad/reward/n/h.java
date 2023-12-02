package com.kwad.components.ad.reward.n;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.components.ad.widget.KsAppTagsView;
import com.kwad.components.core.widget.KsConvertButton;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.core.imageloader.KSImageLoader;
/* loaded from: classes10.dex */
public class h extends s implements View.OnClickListener {
    @Nullable
    public KsLogoView mLogoView;
    @Nullable
    public TextView yA;
    @Nullable
    public TextView yB;
    public a yC;
    @LayoutRes
    public int yD = R.layout.obfuscated_res_0x7f0d04fc;
    public boolean yE = true;
    public ImageView yd;
    @Nullable
    public KsAppTagsView yh;
    public KsConvertButton yy;
    public TextView yz;

    /* loaded from: classes10.dex */
    public interface a {
        void hX();

        void hY();

        void hZ();

        void ia();

        void ib();

        void ic();
    }

    public static int jS() {
        return R.id.obfuscated_res_0x7f091330;
    }

    public int hW() {
        return R.id.obfuscated_res_0x7f091331;
    }

    public final void show() {
        ViewGroup viewGroup = this.sy;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
    }

    private void S(int i) {
        KsConvertButton ksConvertButton = this.yy;
        if (ksConvertButton == null) {
            return;
        }
        if (i == 1) {
            ksConvertButton.getCornerConf().setAllCorner(true);
        } else if (i == 2) {
            ksConvertButton.getCornerConf().cc(false).cf(false).ce(true).cd(true);
        }
        this.yy.postInvalidate();
    }

    public final void a(a aVar) {
        this.yC = aVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x008f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(com.kwad.components.ad.reward.model.a aVar) {
        TextView textView;
        int i;
        KsAppTagsView ksAppTagsView;
        KsConvertButton ksConvertButton;
        int i2;
        TextView textView2;
        if (aVar == null) {
            return;
        }
        S(aVar.ha());
        KsLogoView ksLogoView = this.mLogoView;
        if (ksLogoView != null) {
            ksLogoView.aD(aVar.gW());
        }
        this.yz.setText(aVar.getTitle());
        TextView textView3 = this.yA;
        if (textView3 != null) {
            textView3.setText(aVar.ge());
        }
        TextView textView4 = this.yB;
        int i3 = 0;
        if (textView4 != null) {
            textView4.setText(aVar.ge());
            if (TextUtils.isEmpty(aVar.ge())) {
                i2 = 8;
            } else if (aVar.gZ()) {
                i2 = 8;
                i = 0;
                textView2 = this.yA;
                if (textView2 != null) {
                    textView2.setVisibility(i2);
                }
                textView = this.yB;
            } else {
                i2 = 0;
            }
            i = 8;
            textView2 = this.yA;
            if (textView2 != null) {
            }
            textView = this.yB;
        } else {
            textView = this.yA;
            if (textView != null) {
                if (TextUtils.isEmpty(aVar.ge())) {
                    i = 8;
                } else {
                    i = 0;
                }
            }
            ksAppTagsView = this.yh;
            if (ksAppTagsView != null) {
                ksAppTagsView.a(aVar.gY(), this.yD);
                KsAppTagsView ksAppTagsView2 = this.yh;
                if (aVar.gZ()) {
                    i3 = 8;
                }
                ksAppTagsView2.setVisibility(i3);
            }
            ksConvertButton = this.yy;
            if (ksConvertButton != null) {
                ksConvertButton.a(aVar.gX(), aVar.gW());
            }
            KSImageLoader.loadAppIcon(this.yd, aVar.gd(), aVar.gW(), 12);
        }
        textView.setVisibility(i);
        ksAppTagsView = this.yh;
        if (ksAppTagsView != null) {
        }
        ksConvertButton = this.yy;
        if (ksConvertButton != null) {
        }
        KSImageLoader.loadAppIcon(this.yd, aVar.gd(), aVar.gW(), 12);
    }

    private void g(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        this.mLogoView = (KsLogoView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091336);
        this.yd = (ImageView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091334);
        this.yz = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091337);
        this.yh = (KsAppTagsView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091338);
        this.yA = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091332);
        this.yB = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091333);
        this.yy = (KsConvertButton) viewGroup.findViewById(R.id.obfuscated_res_0x7f09132e);
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final void a(r rVar) {
        super.a(rVar);
        a(com.kwad.components.ad.reward.model.a.a(rVar, this.yE));
    }

    public final void f(ViewGroup viewGroup) {
        super.a(viewGroup, hW(), jS());
        g(this.sy);
        ViewGroup viewGroup2 = this.sy;
        if (viewGroup2 != null) {
            viewGroup2.setOnClickListener(this);
            this.yy.setOnClickListener(this);
            this.yd.setOnClickListener(this);
            this.yz.setOnClickListener(this);
            TextView textView = this.yA;
            if (textView != null) {
                textView.setOnClickListener(this);
            }
            TextView textView2 = this.yB;
            if (textView2 != null) {
                textView2.setOnClickListener(this);
            }
            KsAppTagsView ksAppTagsView = this.yh;
            if (ksAppTagsView != null) {
                ksAppTagsView.setOnClickListener(this);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        a aVar;
        if (view2.equals(this.yy)) {
            a aVar2 = this.yC;
            if (aVar2 != null) {
                aVar2.hX();
            }
        } else if (view2.equals(this.yd)) {
            a aVar3 = this.yC;
            if (aVar3 != null) {
                aVar3.hY();
            }
        } else if (view2.equals(this.yz)) {
            a aVar4 = this.yC;
            if (aVar4 != null) {
                aVar4.hZ();
            }
        } else if (!view2.equals(this.yA) && !view2.equals(this.yB)) {
            if (view2.equals(this.yh)) {
                a aVar5 = this.yC;
                if (aVar5 != null) {
                    aVar5.ib();
                }
            } else if (view2.equals(this.sy) && (aVar = this.yC) != null) {
                aVar.ic();
            }
        } else {
            a aVar6 = this.yC;
            if (aVar6 != null) {
                aVar6.ia();
            }
        }
    }
}
