package com;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.social.share.ShareContent;
import com.baidu.cloudsdk.social.share.SocialShare;
import com.baidu.cloudsdk.social.share.handler.ISocialShareHandler;
/* loaded from: classes.dex */
public class m implements ISocialShareHandler {
    private static final String a = m.class.getSimpleName();
    private Context b;
    private SocialShare.Theme cS;
    private View d;

    public m(Context context, SocialShare.Theme theme) {
        this.b = context;
        this.cS = theme;
        try {
            if (this.d == null) {
                Activity activity = (Activity) context;
                if (activity.isFinishing()) {
                    return;
                }
                this.d = activity.getWindow().getDecorView();
            }
        } catch (ClassCastException e) {
            Log.e(a, "context not a activity");
        }
    }

    @Override // com.baidu.cloudsdk.social.share.handler.ISocialShareHandler
    public void share(ShareContent shareContent, IBaiduListener iBaiduListener, boolean z) {
        if (this.d == null && SocialShare.getInstance(this.b).getParentView() == null) {
            Log.e(a, "if you want to show weixin dialog , pls try to add before share SocialShare.getInstance(context).setParentView(getWindow().getDecorView())");
        } else {
            SocialShare.getInstance(this.b).show(this.d, shareContent, this.cS, iBaiduListener, true);
        }
    }
}
