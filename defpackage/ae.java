package defpackage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.common.http.MultipartRequestParams;
import com.baidu.cloudsdk.social.core.MediaType;
import com.baidu.cloudsdk.social.core.SessionManager;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.cloudsdk.social.oauth.SocialOAuthActivity;
import com.baidu.cloudsdk.social.share.ShareContent;
import com.baidu.cloudsdk.social.share.handler.CloudBatchShareHandler;
import com.baidu.cloudsdk.social.share.ui.ShareDialog;
/* renamed from: ae  reason: default package */
/* loaded from: classes.dex */
public class ae extends CloudBatchShareHandler {

    /* renamed from: a  reason: collision with root package name */
    private MediaType f264a;

    public ae(Context context, String str, MediaType mediaType) {
        super(context, str, null);
        this.mClientId = str;
        this.f264a = mediaType;
    }

    private void a(ShareContent shareContent, SessionManager.Session session, IBaiduListener iBaiduListener) {
        MultipartRequestParams multipartRequestParams = new MultipartRequestParams();
        multipartRequestParams.put("access_token", session.getAccessToken());
        doShare(shareContent, multipartRequestParams, iBaiduListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.cloudsdk.social.share.handler.CloudBatchShareHandler
    public String getShareUploadUrl() {
        return "/api/2.0/share/upload";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.cloudsdk.social.share.handler.CloudBatchShareHandler
    public String getShareUrl() {
        return "/api/2.0/share";
    }

    @Override // com.baidu.cloudsdk.social.share.handler.CloudBatchShareHandler, com.baidu.cloudsdk.social.share.handler.ISocialShareHandler
    public void share(ShareContent shareContent, IBaiduListener iBaiduListener, boolean z) {
        SessionManager sessionManager = SessionManager.getInstance(this.mContext);
        SessionManager.Session session = sessionManager.get(this.f264a.toString());
        if (session != null && !session.isExpired()) {
            if (z) {
                new ShareDialog(this.mContext, shareContent, this.f264a, iBaiduListener).show();
                return;
            } else {
                a(shareContent, session, iBaiduListener);
                return;
            }
        }
        if (session != null) {
            sessionManager.remove(this.f264a.toString());
        }
        d dVar = new d(this, iBaiduListener, shareContent, z);
        Bundle bundle = new Bundle();
        bundle.putString(SocialConstants.PARAM_CLIENT_ID, this.mClientId);
        bundle.putString(SocialConstants.PARAM_MEDIA_TYPE, this.f264a.toString());
        Intent intent = new Intent(this.mContext, SocialOAuthActivity.class);
        intent.putExtras(bundle);
        SocialOAuthActivity.setListener(dVar);
        this.mContext.startActivity(intent);
    }
}
