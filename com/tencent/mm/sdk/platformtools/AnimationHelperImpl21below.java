package com.tencent.mm.sdk.platformtools;

import android.view.View;
import android.view.animation.Animation;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
/* loaded from: classes.dex */
class AnimationHelperImpl21below implements BackwardSupportUtil.AnimationHelper.IHelper {
    @Override // com.tencent.mm.sdk.platformtools.BackwardSupportUtil.AnimationHelper.IHelper
    public void cancelAnimation(View view, Animation animation) {
        if (view != null) {
            view.setAnimation(null);
        }
    }
}
