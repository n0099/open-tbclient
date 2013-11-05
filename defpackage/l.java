package defpackage;

import android.content.Context;
import android.view.View;
import com.baidu.cloudsdk.assets.DrawableUtils;
import com.baidu.cloudsdk.social.share.SocialShare;
import com.baidu.cloudsdk.social.share.ui.SocialMediaGridView;
/* renamed from: l  reason: default package */
/* loaded from: classes.dex */
class l extends ay {
    public l(Context context, SocialShare.Theme theme, View.OnClickListener onClickListener) {
        super(context, theme, onClickListener);
    }

    @Override // defpackage.ay
    protected View getSocialMediaListView(Context context) {
        SocialMediaGridView.GridViewParams gridViewParams = new SocialMediaGridView.GridViewParams();
        gridViewParams.mFixedHeight = DrawableUtils.fix720px(context, 130);
        gridViewParams.mItemTextColor = this.mMenuTheme.h();
        gridViewParams.mPageIndicatorLayoutHeight = DrawableUtils.fix720px(context, 29);
        gridViewParams.mCurrentPageIcon = this.mMenuTheme.f();
        gridViewParams.mNonCurrentPageIcon = this.mMenuTheme.e();
        return new SocialMediaGridView(context, gridViewParams, this.mTheme == SocialShare.Theme.NIGHT, this.mOnClickListener);
    }
}
