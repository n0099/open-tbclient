package com.kwad.sdk.contentalliance.profile.home;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.lib.desigin.CustomActionBarBehavior;
/* loaded from: classes3.dex */
public class ProfileHomeTitleBarBehavior extends CustomActionBarBehavior {
    private ImageView mLeftBackNormal;
    private ImageView mLeftBackShadow;
    private TextView mTitleTv;

    public ProfileHomeTitleBarBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.kwad.sdk.lib.desigin.CustomActionBarBehavior
    protected void initView(RelativeLayout relativeLayout) {
        if (this.mLeftBackNormal == null) {
            this.mLeftBackNormal = (ImageView) relativeLayout.findViewById(R.id.ksad_profile_left_back_normal);
        }
        if (this.mLeftBackShadow == null) {
            this.mLeftBackShadow = (ImageView) relativeLayout.findViewById(R.id.ksad_profile_left_back_shadow);
        }
        if (this.mTitleTv == null) {
            this.mTitleTv = (TextView) relativeLayout.findViewById(R.id.ksad_profile_title);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.lib.desigin.CustomActionBarBehavior
    public void onActionBarHeightChanged(RelativeLayout relativeLayout, float f) {
        super.onActionBarHeightChanged(relativeLayout, f);
        float transRatio = transRatio(0.13f, 1.0f, f);
        this.mLeftBackShadow.setAlpha(1.0f - transRatio);
        this.mLeftBackNormal.setAlpha(transRatio);
        this.mTitleTv.setAlpha(transRatio(0.58f, 1.0f, f));
    }
}
