package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.cloudsdk.assets.DrawableUtils;
import com.baidu.cloudsdk.common.util.Validator;
import com.baidu.cloudsdk.social.share.SocialShare;
import com.baidu.cloudsdk.social.share.SocialShareConfig;
/* renamed from: ay  reason: default package */
/* loaded from: classes.dex */
public abstract class ay extends LinearLayout {
    protected static final int BOTTOM_HEIGHT = 130;
    protected static final int CANCEL_BUTTON_HEIGHT = 88;
    protected static final int CANCEL_BUTTON_LEFT_MARGIN = 40;
    protected static final String CANCEL_BUTTON_TAG = "cancel";
    protected static final String CANCEL_BUTTON_TEXT = "cancel";
    protected static final int CANCEL_BUTTON_TEXT_SIZE = 30;
    public SocialShareConfig mConfig;
    public boolean mIsNightMode;
    public bo mMenuTheme;
    public View.OnClickListener mOnClickListener;
    protected SocialShare.Theme mTheme;

    public ay(Context context, SocialShare.Theme theme, View.OnClickListener onClickListener) {
        super(context);
        Validator.notNull(context, "context");
        Validator.notNull(theme, "theme");
        Validator.notNull(onClickListener, "listener");
        this.mTheme = theme;
        this.mMenuTheme = bo.a(theme);
        this.mIsNightMode = theme == SocialShare.Theme.NIGHT;
        this.mOnClickListener = onClickListener;
        this.mConfig = SocialShareConfig.getInstance(context);
        setOrientation(1);
        setBackgroundDrawable(DrawableUtils.getDrawable(context, this.mConfig.getAssetFileName(this.mMenuTheme.a())));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 1;
        addView(getSocialMediaListView(context), layoutParams);
        setupCancelBar(context);
    }

    protected Drawable getCancelBarBackgroundDrawable(Context context) {
        String assetFileName = this.mConfig.getAssetFileName(this.mMenuTheme.b());
        if (TextUtils.isEmpty(assetFileName)) {
            return null;
        }
        return DrawableUtils.getDrawable(context, assetFileName);
    }

    protected abstract View getSocialMediaListView(Context context);

    protected void setupCancelBar(Context context) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setBackgroundDrawable(getCancelBarBackgroundDrawable(context));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, DrawableUtils.fix720px(context, BOTTOM_HEIGHT));
        layoutParams.gravity = 17;
        addView(relativeLayout, layoutParams);
        Drawable drawable = DrawableUtils.getDrawable(context, this.mConfig.getAssetFileName(this.mMenuTheme.c()));
        Drawable drawable2 = DrawableUtils.getDrawable(context, this.mConfig.getAssetFileName(this.mMenuTheme.d()));
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, drawable2);
        stateListDrawable.addState(new int[0], drawable);
        Button button = new Button(context);
        button.setBackgroundDrawable(stateListDrawable);
        button.setText(this.mConfig.getString("cancel"));
        button.setTextSize(0, DrawableUtils.fix720px(context, 30));
        button.setTextColor(this.mMenuTheme.i());
        button.setTag("cancel");
        button.setOnClickListener(this.mOnClickListener);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, DrawableUtils.fix720px(context, CANCEL_BUTTON_HEIGHT));
        int fix720px = DrawableUtils.fix720px(context, CANCEL_BUTTON_LEFT_MARGIN);
        layoutParams2.rightMargin = fix720px;
        layoutParams2.leftMargin = fix720px;
        layoutParams2.addRule(14);
        layoutParams2.addRule(15, -1);
        relativeLayout.addView(button, layoutParams2);
    }
}
