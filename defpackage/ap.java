package defpackage;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.social.share.ShareContent;
import com.baidu.cloudsdk.social.share.SocialShare;
import com.baidu.cloudsdk.social.share.handler.ISocialShareHandler;
/* renamed from: ap  reason: default package */
/* loaded from: classes.dex */
public class ap implements ISocialShareHandler {

    /* renamed from: a  reason: collision with root package name */
    private static final String f361a = ap.class.getSimpleName();
    private Context b;
    private SocialShare.Theme c;
    private View d;

    public ap(Context context, SocialShare.Theme theme) {
        this.b = context;
        this.c = theme;
        try {
            if (this.d == null) {
                Activity activity = (Activity) context;
                if (activity.isFinishing()) {
                    return;
                }
                this.d = activity.getWindow().getDecorView();
            }
        } catch (ClassCastException e) {
            Log.e(f361a, "context not a activity");
        }
    }

    @Override // com.baidu.cloudsdk.social.share.handler.ISocialShareHandler
    public void share(ShareContent shareContent, IBaiduListener iBaiduListener, boolean z) {
        if (this.d == null && SocialShare.getInstance(this.b).getParentView() == null) {
            Log.e(f361a, "if you want to show weixin dialog , pls try to add before share SocialShare.getInstance(context).setParentView(getWindow().getDecorView())");
        } else {
            SocialShare.getInstance(this.b).show(this.d, shareContent, this.c, iBaiduListener, true);
        }
    }
}
