package com.sina.weibo.sdk.web.param;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.api.ImageObject;
import com.sina.weibo.sdk.api.TextObject;
import com.sina.weibo.sdk.api.WebpageObject;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.net.AsyncWeiboRunner;
import com.sina.weibo.sdk.net.RequestListener;
import com.sina.weibo.sdk.net.WeiboParameters;
import com.sina.weibo.sdk.utils.Base64;
import com.sina.weibo.sdk.utils.Utility;
import com.sina.weibo.sdk.utils.WbSdkVersion;
import com.sina.weibo.sdk.web.WebPicUploadResult;
import com.sina.weibo.sdk.web.WebRequestType;
import com.sina.weibo.sdk.web.param.BaseWebViewRequestParam;
import com.tencent.open.SocialConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
/* loaded from: classes2.dex */
public class ShareWebViewRequestParam extends BaseWebViewRequestParam {
    private static final String SHARE_URL = "http://service.weibo.com/share/mobilesdk.php";
    private static final String UPLOAD_PIC_URL = "http://service.weibo.com/share/mobilesdk_uppic.php";
    private String hashKey;
    private byte[] mBase64ImgData;
    private String mShareContent;
    private WeiboMultiMessage multiMessage;
    private String packageName;
    private String picId;
    private String token;

    public ShareWebViewRequestParam() {
    }

    public ShareWebViewRequestParam(Context context) {
        this.context = context;
    }

    public ShareWebViewRequestParam(AuthInfo authInfo, WebRequestType webRequestType, String str, String str2, String str3, Context context) {
        this(authInfo, webRequestType, str, 0, str2, str3, context);
    }

    public ShareWebViewRequestParam(AuthInfo authInfo, WebRequestType webRequestType, String str, int i, String str2, String str3, Context context) {
        super(authInfo, webRequestType, str, i, str2, str3, context);
    }

    @Override // com.sina.weibo.sdk.web.param.BaseWebViewRequestParam
    public boolean hasExtraTask() {
        if (this.mBase64ImgData == null || this.mBase64ImgData.length <= 0) {
            return super.hasExtraTask();
        }
        return true;
    }

    @Override // com.sina.weibo.sdk.web.param.BaseWebViewRequestParam
    public void doExtraTask(final BaseWebViewRequestParam.ExtraTaskCallback extraTaskCallback) {
        super.doExtraTask(extraTaskCallback);
        WeiboParameters weiboParameters = new WeiboParameters(getBaseData().getAuthInfo().getAppKey());
        weiboParameters.put(SocialConstants.PARAM_IMG_URL, new String(this.mBase64ImgData));
        new AsyncWeiboRunner(this.context).requestAsync(UPLOAD_PIC_URL, weiboParameters, "POST", new RequestListener() { // from class: com.sina.weibo.sdk.web.param.ShareWebViewRequestParam.1
            @Override // com.sina.weibo.sdk.net.RequestListener
            public void onWeiboException(WeiboException weiboException) {
                if (extraTaskCallback != null) {
                    extraTaskCallback.onException("upload pic fail");
                }
            }

            @Override // com.sina.weibo.sdk.net.RequestListener
            public void onComplete(String str) {
                WebPicUploadResult parse = WebPicUploadResult.parse(str);
                if (parse != null && parse.getCode() == 1 && !TextUtils.isEmpty(parse.getPicId())) {
                    ShareWebViewRequestParam.this.picId = parse.getPicId();
                    if (extraTaskCallback != null) {
                        extraTaskCallback.onComplete(ShareWebViewRequestParam.this.picId);
                    }
                } else if (extraTaskCallback != null) {
                    extraTaskCallback.onException("upload pic fail");
                }
            }
        });
    }

    @Override // com.sina.weibo.sdk.web.param.BaseWebViewRequestParam
    protected void childFillBundle(Bundle bundle) {
        if (this.multiMessage != null) {
            this.multiMessage.toBundle(bundle);
        }
        bundle.putString(Constants.EXTRA_KEY_TOKEN, this.token);
        bundle.putString("packageName", this.packageName);
        bundle.putString("hashKey", this.hashKey);
    }

    @Override // com.sina.weibo.sdk.web.param.BaseWebViewRequestParam
    protected void transformChildBundle(Bundle bundle) {
        this.multiMessage = new WeiboMultiMessage();
        this.multiMessage.toObject(bundle);
        this.token = bundle.getString(Constants.EXTRA_KEY_TOKEN);
        this.packageName = bundle.getString("packageName");
        this.hashKey = bundle.getString("hashKey");
        getBaseUrl();
    }

    @Override // com.sina.weibo.sdk.web.param.BaseWebViewRequestParam
    public String getRequestUrl() {
        String appKey = getBaseData().getAuthInfo().getAppKey();
        Uri.Builder buildUpon = Uri.parse(SHARE_URL).buildUpon();
        buildUpon.appendQueryParameter("title", this.mShareContent);
        buildUpon.appendQueryParameter("version", WbSdkVersion.WEIBO_SDK_VERSION_CODE);
        if (!TextUtils.isEmpty(appKey)) {
            buildUpon.appendQueryParameter("source", appKey);
        }
        if (!TextUtils.isEmpty(this.token)) {
            buildUpon.appendQueryParameter("access_token", this.token);
        }
        if (this.context != null) {
            String aid = Utility.getAid(this.context, appKey);
            if (!TextUtils.isEmpty(aid)) {
                buildUpon.appendQueryParameter("aid", aid);
            }
        }
        if (!TextUtils.isEmpty(this.packageName)) {
            buildUpon.appendQueryParameter("packagename", this.packageName);
        }
        if (!TextUtils.isEmpty(this.hashKey)) {
            buildUpon.appendQueryParameter("key_hash", this.hashKey);
        }
        if (!TextUtils.isEmpty(this.picId)) {
            buildUpon.appendQueryParameter("picinfo", this.picId);
        }
        buildUpon.appendQueryParameter("luicode", "10000360");
        buildUpon.appendQueryParameter("lfid", "OP_" + appKey);
        return buildUpon.build().toString();
    }

    @Override // com.sina.weibo.sdk.web.param.BaseWebViewRequestParam
    public void updateRequestUrl(String str) {
        this.picId = str;
    }

    public void setMultiMessage(WeiboMultiMessage weiboMultiMessage) {
        this.multiMessage = weiboMultiMessage;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public void setHashKey(String str) {
        this.hashKey = str;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    private void getBaseUrl() {
        StringBuilder sb = new StringBuilder();
        if (this.multiMessage.textObject instanceof TextObject) {
            sb.append(this.multiMessage.textObject.text + " ");
        }
        if (this.multiMessage.mediaObject != null && (this.multiMessage.mediaObject instanceof WebpageObject) && !TextUtils.isEmpty(this.multiMessage.mediaObject.actionUrl)) {
            sb.append(this.multiMessage.mediaObject.actionUrl);
        }
        if (this.multiMessage.imageObject instanceof ImageObject) {
            ImageObject imageObject = this.multiMessage.imageObject;
            handleMblogPic(imageObject.imagePath, imageObject.imageData);
        }
        this.mShareContent = sb.toString();
    }

    private void handleMblogPic(String str, byte[] bArr) {
        FileInputStream fileInputStream;
        try {
            if (!TextUtils.isEmpty(str)) {
                File file = new File(str);
                if (file.exists() && file.canRead() && file.length() > 0) {
                    byte[] bArr2 = new byte[(int) file.length()];
                    FileInputStream fileInputStream2 = null;
                    try {
                        fileInputStream = new FileInputStream(file);
                    } catch (IOException e) {
                        fileInputStream = null;
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        fileInputStream.read(bArr2);
                        this.mBase64ImgData = Base64.encodebyte(bArr2);
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                                return;
                            } catch (Exception e2) {
                                return;
                            }
                        }
                        return;
                    } catch (IOException e3) {
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e4) {
                            }
                        }
                        if (bArr == null) {
                        }
                        return;
                    } catch (Throwable th2) {
                        fileInputStream2 = fileInputStream;
                        th = th2;
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (Exception e5) {
                            }
                        }
                        throw th;
                    }
                }
            }
        } catch (SecurityException e6) {
        }
        if (bArr == null && bArr.length > 0) {
            this.mBase64ImgData = Base64.encodebyte(bArr);
        }
    }
}
