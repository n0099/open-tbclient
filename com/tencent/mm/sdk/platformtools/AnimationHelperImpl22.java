package com.tencent.mm.sdk.platformtools;

import android.view.View;
import android.view.animation.Animation;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
/* loaded from: classes.dex */
class AnimationHelperImpl22 implements BackwardSupportUtil.AnimationHelper.IHelper {
    @Override // com.tencent.mm.sdk.platformtools.BackwardSupportUtil.AnimationHelper.IHelper
    public void cancelAnimation(View view, Animation animation) {
        animation.cancel();
    }
}
