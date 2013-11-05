package defpackage;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.cloudsdk.BaiduException;
import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.common.imgloader.ImageManager;
import com.baidu.cloudsdk.common.util.Utils;
import com.baidu.cloudsdk.social.core.MediaType;
import com.baidu.cloudsdk.social.core.util.MobileQQ;
import com.baidu.cloudsdk.social.core.util.RequestCodeManager;
import com.baidu.cloudsdk.social.share.ShareContent;
import com.baidu.cloudsdk.social.share.handler.SocialShareStatisticsManager;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
/* renamed from: ak  reason: default package */
/* loaded from: classes.dex */
public class ak extends ai {

    /* renamed from: a  reason: collision with root package name */
    private Activity f268a;
    private String b;
    private String c;

    public ak(Activity activity, IBaiduListener iBaiduListener, int i, String str, String str2) {
        super(activity, iBaiduListener, i, MediaType.QQFRIEND.toString());
        this.b = str;
        this.c = str2;
        this.f268a = activity;
    }

    public static IBaiduListener a() {
        int latestRequestCode = RequestCodeManager.getLatestRequestCode(MediaType.QQFRIEND.toString());
        if (latestRequestCode != 0) {
            return a(latestRequestCode);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(Bitmap bitmap) {
        FileOutputStream fileOutputStream;
        String str = ImageManager.DEFAULT_STORAGE_PATH + "/" + Utils.md5(this.mShareContent.getImageUri().toString());
        File file = new File(str);
        if (!file.exists()) {
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.exists()) {
                parentFile.mkdirs();
            }
            FileOutputStream fileOutputStream2 = null;
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (Exception e) {
                fileOutputStream = null;
            } catch (Throwable th) {
                th = th;
            }
            try {
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                fileOutputStream.flush();
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e2) {
                    }
                }
            } catch (Exception e3) {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e4) {
                    }
                }
                return str;
            } catch (Throwable th2) {
                fileOutputStream2 = fileOutputStream;
                th = th2;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e5) {
                    }
                }
                throw th;
            }
        }
        return str;
    }

    private String a(ShareContent shareContent) {
        String title = shareContent.getTitle();
        String content = shareContent.getContent();
        String linkUrl = shareContent.getLinkUrl();
        Uri imageUri = shareContent.getImageUri();
        StringBuilder sb = new StringBuilder("mqqapi://share/to_fri?src_type=app&version=1&file_type=news");
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
        if (imageUri != null) {
            sb.append("&file_data=").append(Utils.base64Encode(Utils.getRealPathFromUri((Activity) this.mContext, imageUri)));
        }
        if (!TextUtils.isEmpty(this.c)) {
            String str = this.c;
            if (str.length() > 20) {
                str = str.substring(0, 20) + "...";
            }
            sb.append("&app_name=").append(Utils.base64Encode(str));
        }
        sb.append("&share_id=").append(this.b);
        return sb.toString();
    }

    private void a(ShareContent shareContent, IBaiduListener iBaiduListener) {
        Uri imageUri = shareContent.getImageUri();
        if (Utils.isUrl(imageUri)) {
            ImageManager.getInstance().loadImage(this.mContext, imageUri, new g(this));
        } else {
            c();
        }
    }

    private String b(ShareContent shareContent) {
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
        bundle.putString("title", title);
        bundle.putString("summary", content);
        bundle.putString("targetUrl", shareContent.getLinkUrl());
        if (imageUri != null) {
            if (Utils.isUrl(imageUri)) {
                bundle.putString("imageUrl", imageUri.toString());
            } else {
                bundle.putString("imageLocalUrl", imageUri.toString());
            }
        }
        bundle.putString("appName", this.c);
        bundle.putString("site", this.c);
        bundle.putString("action", "shareToQQ");
        bundle.putString("appId", this.b);
        bundle.putString("sdkp", "a");
        bundle.putString("sdkv", "1.6");
        bundle.putString("status_os", Build.VERSION.RELEASE);
        bundle.putString("status_machine", Build.MODEL);
        return "http://openmobile.qq.com/api/check?page=shareindex.html&style=9&" + Utils.getQueryString(bundle).replace("\\+", "%20");
    }

    private void b(ShareContent shareContent, IBaiduListener iBaiduListener) {
        try {
            this.f268a.startActivityForResult(new Intent("android.intent.action.VIEW", Uri.parse(b(shareContent))), this.mRequestCode);
        } catch (Exception e) {
            onStartLocalShareFailed("no_valid_mobileqq_tip", iBaiduListener);
        }
    }

    private boolean b() {
        try {
            String[] split = this.mContext.getPackageManager().getPackageInfo(MobileQQ.PACKAGE_NAME, 0).versionName.split("\\.");
            int parseInt = Integer.parseInt(split[0]);
            return parseInt > 4 || (parseInt == 4 && Integer.parseInt(split[1]) >= 1);
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        String a2 = a(this.mShareContent);
        Bundle bundle = new Bundle();
        bundle.putString("scheme", a2);
        bundle.putString("appid", this.b);
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(a2));
        intent.putExtra(MobileQQ.KEY_REQUEST_CODE, this.mRequestCode);
        intent.putExtra(MobileQQ.KEY_ACTION, "action_share_qq");
        intent.putExtra(MobileQQ.KEY_PARAMS, bundle);
        try {
            this.f268a.startActivityForResult(intent, this.mRequestCode);
        } catch (Exception e) {
            b(this.mShareContent, this.mListener);
        }
    }

    @Override // defpackage.ai
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == this.mRequestCode) {
            if (i2 == -1) {
                if (this.mListener != null) {
                    this.mListener.onComplete();
                }
            } else if (i2 == 0 && this.mListener != null) {
                this.mListener.onCancel();
            }
            SocialShareStatisticsManager.getInstance(this.mContext).statistics(MediaType.QQFRIEND, this.mShareContent);
        }
    }

    @Override // defpackage.ai, com.baidu.cloudsdk.social.share.handler.ISocialShareHandler
    public void share(ShareContent shareContent, IBaiduListener iBaiduListener, boolean z) {
        this.mListener = iBaiduListener;
        this.mShareContent = shareContent;
        try {
            if (b()) {
                a(shareContent, iBaiduListener);
            } else {
                b(shareContent, iBaiduListener);
            }
        } catch (ActivityNotFoundException e) {
            iBaiduListener.onError(new BaiduException("no mobile qq or browser app installed"));
        } catch (Exception e2) {
            iBaiduListener.onError(new BaiduException(e2));
        }
    }
}
