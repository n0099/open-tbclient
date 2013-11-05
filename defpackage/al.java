package defpackage;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.net.Uri;
import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.social.core.MediaType;
/* renamed from: al  reason: default package */
/* loaded from: classes.dex */
public class al extends am {
    public al(Activity activity, IBaiduListener iBaiduListener, int i) {
        super(activity, iBaiduListener, i, MediaType.SMS.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.am
    public void doShare(Uri uri) {
        try {
            this.mActivity.startActivityForResult(getSmsIntent(uri), this.mRequestCode);
        } catch (ActivityNotFoundException e) {
            onStartLocalShareFailed("no_valid_sms_app", this.mListener);
        }
    }
}
