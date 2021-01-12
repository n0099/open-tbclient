package com.kwad.sdk.contentalliance.tube.profile;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Keep;
import com.kwad.sdk.R;
import com.kwad.sdk.lib.desigin.CustomActionBarBehavior;
/* loaded from: classes4.dex */
public class TubeProfileTitleBarBehavior extends CustomActionBarBehavior {
    private ImageView mLeftBackNormal;
    private ImageView mLeftBackShadow;
    private TextView mTitleTv;

    public TubeProfileTitleBarBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.kwad.sdk.lib.desigin.CustomActionBarBehavior
    protected void initView(RelativeLayout relativeLayout) {
        if (this.mLeftBackNormal == null) {
            this.mLeftBackNormal = (ImageView) relativeLayout.findViewById(R.id.ksad_tube_detail_back_button);
        }
        if (this.mLeftBackShadow == null) {
            this.mLeftBackShadow = (ImageView) relativeLayout.findViewById(R.id.ksad_tube_detail_back_button_shadow);
        }
        if (this.mTitleTv == null) {
            this.mTitleTv = (TextView) relativeLayout.findViewById(R.id.ksad_tube_title);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.lib.desigin.CustomActionBarBehavior
    @Keep
    public void onActionBarHeightChanged(RelativeLayout relativeLayout, float f) {
        super.onActionBarHeightChanged(relativeLayout, f);
        float transRatio = transRatio(0.13f, 1.0f, f);
        this.mLeftBackShadow.setAlpha(1.0f - transRatio);
        this.mLeftBackNormal.setAlpha(transRatio);
        this.mTitleTv.setAlpha(transRatio(0.58f, 1.0f, f));
    }
}
