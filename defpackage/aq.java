package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import com.baidu.cloudsdk.BaiduException;
import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.common.imgloader.ImageManager;
import com.baidu.cloudsdk.social.core.MediaType;
import com.baidu.cloudsdk.social.core.util.Weixin;
import com.baidu.cloudsdk.social.share.ShareContent;
import com.baidu.cloudsdk.social.share.SocialShareConfig;
import com.baidu.cloudsdk.social.share.handler.ISocialShareHandler;
import com.baidu.cloudsdk.social.share.handler.SocialShareStatisticsManager;
import com.baidu.cloudsdk.social.share.handler.WXMediaMessage;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
/* renamed from: aq  reason: default package */
/* loaded from: classes.dex */
public class aq implements ISocialShareHandler {
    private static final String a = aq.class.getSimpleName();
    private static Map b = new HashMap();
    private static Map c = new HashMap();
    private Context d;
    private String e;
    private boolean f;
    private Weixin g;
    private String h;

    public aq(Context context, String str, boolean z) {
        this.d = context;
        this.e = str;
        this.f = z;
        this.g = new Weixin(context, str);
        this.g.registerApp();
        this.h = b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(Bitmap bitmap, int i) {
        return (bitmap.getHeight() * i) / bitmap.getWidth();
    }

    public static IBaiduListener a(String str) {
        WeakReference weakReference = (WeakReference) b.get(str);
        if (weakReference != null) {
            b.remove(str);
            return (IBaiduListener) weakReference.get();
        }
        return null;
    }

    private void a(Bitmap bitmap, String str, String str2, String str3) {
        a(str, str2, str3, Bitmap.createScaledBitmap(bitmap, 150, a(bitmap, 150), true));
    }

    private void a(Uri uri, String str, String str2, String str3) {
        ImageManager.getInstance().loadImage(this.d, uri, new i(this, uri, str, str2, str3));
    }

    private void a(Bundle bundle) {
        Log.d(a, "sendMessage to weixin");
        Weixin.addBaseRequestParams(bundle, this.h, this.f);
        if (this.g.sendRequest(bundle)) {
            return;
        }
        Log.e(a, "sendMessage error");
        IBaiduListener a2 = a(this.h);
        b(this.h);
        a2.onError(new BaiduException("failed to start weixin app"));
    }

    private void a(ShareContent shareContent) {
        String title = shareContent.getTitle();
        String content = shareContent.getContent();
        String linkUrl = shareContent.getLinkUrl();
        Uri imageUri = shareContent.getImageUri();
        Bitmap imageData = shareContent.getImageData();
        if (imageData != null) {
            a(imageData, title, content, linkUrl);
        } else if (imageUri != null) {
            a(imageUri, title, content, linkUrl);
        } else {
            a(title, content, linkUrl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ShareContent shareContent, IBaiduListener iBaiduListener) {
        SocialShareConfig socialShareConfig = SocialShareConfig.getInstance(this.d);
        if (!this.g.isAppInstalled()) {
            Toast.makeText(this.d, socialShareConfig.getString("weixin_not_installed"), 1).show();
            if (iBaiduListener != null) {
                iBaiduListener.onError(new BaiduException("weixin not installed yet"));
            }
        } else if (!this.f || this.g.isTimelineSupported()) {
            a(this.h, iBaiduListener);
            a(this.h, shareContent);
            a(shareContent);
        } else {
            Toast.makeText(this.d, socialShareConfig.getString("weixin_timeline_not_supported"), 1).show();
            if (iBaiduListener != null) {
                iBaiduListener.onError(new BaiduException("this version of weixin has no support for timeline related api"));
            }
        }
    }

    private static void a(String str, IBaiduListener iBaiduListener) {
        b.put(str, new WeakReference(iBaiduListener));
    }

    private static void a(String str, ShareContent shareContent) {
        c.put(str, new WeakReference(shareContent));
    }

    private void a(String str, String str2, String str3) {
        a(str, str2, str3, (Bitmap) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, String str3, Bitmap bitmap) {
        WXMediaMessage wXMediaMessage = new WXMediaMessage(str, str2, new WXMediaMessage.WXWebpageObject(str3));
        wXMediaMessage.a(bitmap);
        a(wXMediaMessage.a());
    }

    public static ShareContent b(String str) {
        WeakReference weakReference = (WeakReference) c.get(str);
        if (weakReference != null) {
            c.remove(str);
            return (ShareContent) weakReference.get();
        }
        return null;
    }

    private String b() {
        return String.valueOf(System.currentTimeMillis());
    }

    @Override // com.baidu.cloudsdk.social.share.handler.ISocialShareHandler
    public void share(ShareContent shareContent, IBaiduListener iBaiduListener, boolean z) {
        MediaType mediaType = MediaType.WEIXIN;
        if (this.f) {
            mediaType = MediaType.WEIXIN_TIMELINE;
        }
        SocialShareStatisticsManager.getInstance(this.d).getBackUrl(shareContent.getLinkUrl(), mediaType.toString(), new k(this, shareContent, iBaiduListener));
    }
}
