package com;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.baidu.cloudsdk.BaiduException;
import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.common.imgloader.AsyncImageLoader;
import com.baidu.cloudsdk.common.imgloader.ImageManager;
import com.baidu.cloudsdk.common.util.Utils;
import com.baidu.cloudsdk.social.core.MediaType;
import com.baidu.cloudsdk.social.core.util.MobileQQ;
import com.baidu.cloudsdk.social.core.util.RequestCodeManager;
import com.baidu.cloudsdk.social.share.ShareContent;
import com.baidu.cloudsdk.social.share.SocialShareConfig;
import com.baidu.cloudsdk.social.share.handler.SocialShareStatisticsManager;
import com.baidu.tbadk.core.atomData.VrPlayerActivityConfig;
import com.davemorrissey.labs.subscaleview.decoder.SkiaImageDecoder;
/* loaded from: classes.dex */
public class f extends c {
    private String a;
    private String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements AsyncImageLoader.IAsyncImageLoaderListener {
        private Uri kt;

        public a(Uri uri) {
            this.kt = uri;
        }

        @Override // com.baidu.cloudsdk.common.imgloader.AsyncImageLoader.IAsyncImageLoaderListener
        public void onComplete(Bitmap bitmap) {
            if (bitmap != null && !bitmap.isRecycled()) {
                f.this.mShareContent.setImageUri(Uri.parse(ImageManager.getInstance().getCachedFilePath(this.kt)));
            }
            f.this.c();
        }
    }

    public f(Context context, IBaiduListener iBaiduListener, int i, String str, String str2) {
        super(context, iBaiduListener, i, MediaType.QZONE.toString());
        this.a = str;
        this.b = str2;
    }

    private void a(ShareContent shareContent, IBaiduListener iBaiduListener) {
        Uri imageUri = shareContent.getImageUri();
        if (Utils.isUrl(imageUri)) {
            ImageManager.getInstance().loadImage(this.mContext, imageUri, new a(imageUri));
        } else {
            c();
        }
    }

    private String b(ShareContent shareContent) {
        String title = shareContent.getTitle();
        String content = shareContent.getContent();
        String linkUrl = shareContent.getLinkUrl();
        Uri imageUri = shareContent.getImageUri();
        StringBuilder sb = new StringBuilder("mqqapi://share/to_qzone?src_type=app&version=1&file_type=news");
        if (shareContent.getQZoneRequestType() != 5) {
            if (!TextUtils.isEmpty(title)) {
                if (title.length() > 40) {
                    title = title.substring(0, 40);
                }
                sb.append("&title=").append(Utils.base64Encode(title));
            }
            if (!TextUtils.isEmpty(content)) {
                sb.append("&description=").append(Utils.base64Encode(content.length() > 80 ? content.substring(0, 80) : content));
            }
            if (!TextUtils.isEmpty(linkUrl)) {
                sb.append("&url=").append(Utils.base64Encode(linkUrl));
            }
        }
        if (imageUri != null) {
            String realPathFromUri = Utils.getRealPathFromUri((Activity) this.mContext, imageUri);
            if (realPathFromUri.startsWith("file")) {
                realPathFromUri = realPathFromUri.replace(SkiaImageDecoder.FILE_PREFIX, "");
                Log.d("QZoneSharehandler", "path= " + realPathFromUri);
            }
            if (!TextUtils.isEmpty(realPathFromUri)) {
                sb.append("&image_url=").append(Utils.base64Encode(Uri.encode(realPathFromUri)));
            }
        }
        if (!TextUtils.isEmpty(this.b)) {
            String str = this.b;
            if (str.length() > 20) {
                str = str.substring(0, 20) + "...";
            }
            sb.append("&app_name=").append(Utils.base64Encode(str));
        }
        sb.append("&share_id=").append(this.a);
        sb.append("&req_type=").append(Utils.base64Encode(String.valueOf(shareContent.getQQRequestType())));
        return sb.toString();
    }

    private void b(ShareContent shareContent, IBaiduListener iBaiduListener) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(c(shareContent)));
        intent.putExtra("from", "baidusocialshare");
        if (SocialShareConfig.getInstance(this.mContext).getInt("default_bdbrowser") == 1) {
            intent.setClassName("com.baidu.browser.apps", "com.baidu.browser.framework.BdBrowserActivity");
        }
        try {
            ((Activity) this.mContext).startActivityForResult(intent, this.mRequestCode);
        } catch (Exception e) {
            onStartLocalShareFailed("no_valid_mobileqq_tip", iBaiduListener);
        }
    }

    private boolean b() {
        try {
            String[] split = this.mContext.getPackageManager().getPackageInfo(MobileQQ.PACKAGE_NAME, 0).versionName.split("\\.");
            int parseInt = Integer.parseInt(split[0]);
            return parseInt > 4 || (parseInt == 4 && Integer.parseInt(split[1]) >= 6);
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    public static IBaiduListener bg() {
        int latestRequestCode = RequestCodeManager.getLatestRequestCode(MediaType.QZONE.toString());
        if (latestRequestCode != 0) {
            return a(latestRequestCode);
        }
        return null;
    }

    private String c(ShareContent shareContent) {
        String title = shareContent.getTitle();
        if (!TextUtils.isEmpty(title) && title.length() > 40) {
            title = title.substring(0, 40) + "...";
        }
        String content = shareContent.getContent();
        if (!TextUtils.isEmpty(content) && content.length() > 80) {
            content = content.substring(0, 80) + "...";
        }
        Uri imageUri = shareContent.getImageUri();
        Bundle bundle = new Bundle();
        bundle.putString(VrPlayerActivityConfig.TITLE, title);
        bundle.putString("summary", content);
        bundle.putString("targetUrl", shareContent.getLinkUrl());
        if (imageUri != null) {
            if (Utils.isUrl(imageUri)) {
                bundle.putString("imageUrl", imageUri.toString());
            } else {
                bundle.putString("imageLocalUrl", imageUri.toString());
            }
        }
        bundle.putString("appName", this.b);
        bundle.putString("site", this.b);
        bundle.putString("action", "shareToQQ");
        bundle.putString("appId", this.a);
        bundle.putInt("type", shareContent.getQZoneRequestType());
        bundle.putString("sdkp", "a");
        bundle.putString("sdkv", "2.0");
        bundle.putString("status_os", Build.VERSION.RELEASE);
        bundle.putString("status_machine", Build.MODEL);
        return "http://openmobile.qq.com/api/check2?page=qzshare.html&loginpage=loginindex.html&logintype=qzone&" + Utils.getQueryString(bundle).replace("+", "%20");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.mShareContent.getQQRequestType() == 5 && this.mShareContent.getImageUri() == null) {
            this.mListener.onError(new BaiduException("QQRequestType is image but no ImageUri set"));
            return;
        }
        String b = b(this.mShareContent);
        Bundle bundle = new Bundle();
        bundle.putString("scheme", b);
        bundle.putString("appid", this.a);
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(b));
        intent.putExtra(MobileQQ.KEY_REQUEST_CODE, this.mRequestCode);
        intent.putExtra("key_action", "action_share_qq");
        intent.putExtra(MobileQQ.KEY_PARAMS, bundle);
        try {
            ((Activity) this.mContext).startActivityForResult(intent, this.mRequestCode);
        } catch (Exception e) {
            b(this.mShareContent, this.mListener);
        }
    }

    @Override // com.c
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i != this.mRequestCode || this.mShareContent == null) {
            return;
        }
        SocialShareStatisticsManager.getInstance(this.mContext).statistics(MediaType.QZONE, this.mShareContent);
    }

    @Override // com.c, com.baidu.cloudsdk.social.share.handler.ISocialShareHandler
    public void share(ShareContent shareContent, IBaiduListener iBaiduListener, boolean z) {
        this.mListener = iBaiduListener;
        this.mShareContent = shareContent;
        try {
            if (b()) {
                a(shareContent, iBaiduListener);
            } else if (shareContent.getQQRequestType() != 5) {
                b(shareContent, iBaiduListener);
            } else {
                Toast.makeText(this.mContext, SocialShareConfig.getInstance(this.mContext).getString("qq_share_not_support_image"), 0).show();
                iBaiduListener.onError(new BaiduException("only mobile QQ 4.5 support image share"));
            }
        } catch (ActivityNotFoundException e) {
            iBaiduListener.onError(new BaiduException("no mobile qq or browser app installed"));
        } catch (Exception e2) {
            iBaiduListener.onError(new BaiduException(e2));
        }
    }
}
