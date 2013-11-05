package defpackage;

import android.content.Context;
import android.text.ClipboardManager;
import android.widget.Toast;
import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.social.share.ShareContent;
import com.baidu.cloudsdk.social.share.SocialShareConfig;
import com.baidu.cloudsdk.social.share.handler.ISocialShareHandler;
/* renamed from: ag  reason: default package */
/* loaded from: classes.dex */
public class ag implements ISocialShareHandler {

    /* renamed from: a  reason: collision with root package name */
    private Context f266a;

    public ag(Context context) {
        this.f266a = context;
    }

    @Override // com.baidu.cloudsdk.social.share.handler.ISocialShareHandler
    public void share(ShareContent shareContent, IBaiduListener iBaiduListener, boolean z) {
        ((ClipboardManager) this.f266a.getSystemService("clipboard")).setText(shareContent.getLinkUrl());
        Toast.makeText(this.f266a, SocialShareConfig.getInstance(this.f266a).getString("copy_link_success"), 1).show();
    }
}
