package com.sina.weibo.sdk.web.param;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.swan.gamecenter.appmanager.install.InstallAntiBlockingActivity;
import com.sina.weibo.sdk.api.BaseMediaObject;
import com.sina.weibo.sdk.api.ImageObject;
import com.sina.weibo.sdk.api.TextObject;
import com.sina.weibo.sdk.api.WebpageObject;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.net.WeiboParameters;
import com.sina.weibo.sdk.network.IRequestService;
import com.sina.weibo.sdk.network.impl.RequestParam;
import com.sina.weibo.sdk.network.impl.RequestService;
import com.sina.weibo.sdk.network.target.SimpleTarget;
import com.sina.weibo.sdk.utils.Base64;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.Utility;
import com.sina.weibo.sdk.utils.WbSdkVersion;
import com.sina.weibo.sdk.web.WebPicUploadResult;
import com.sina.weibo.sdk.web.WebRequestType;
import com.sina.weibo.sdk.web.param.BaseWebViewRequestParam;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
/* loaded from: classes7.dex */
public class ShareWebViewRequestParam extends BaseWebViewRequestParam {
    public static final String SHARE_URL = "https://service.weibo.com/share/mobilesdk.php";
    public static final String UPLOAD_PIC_URL = "https://service.weibo.com/share/mobilesdk_uppic.php";
    public String hashKey;
    public byte[] mBase64ImgData;
    public String mShareContent;
    public WeiboMultiMessage multiMessage;
    public String packageName;
    public String picId;
    public String token;

    public ShareWebViewRequestParam() {
    }

    private void getBaseUrl() {
        StringBuilder sb = new StringBuilder();
        TextObject textObject = this.multiMessage.textObject;
        if (textObject instanceof TextObject) {
            sb.append(textObject.text + " ");
        }
        BaseMediaObject baseMediaObject = this.multiMessage.mediaObject;
        if (baseMediaObject != null && (baseMediaObject instanceof WebpageObject) && !TextUtils.isEmpty(baseMediaObject.actionUrl)) {
            sb.append(this.multiMessage.mediaObject.actionUrl);
        }
        ImageObject imageObject = this.multiMessage.imageObject;
        if (imageObject instanceof ImageObject) {
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
                    } catch (IOException unused) {
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        fileInputStream.read(bArr2);
                        this.mBase64ImgData = Base64.encodebyte(bArr2);
                        try {
                            fileInputStream.close();
                            return;
                        } catch (Exception unused2) {
                            return;
                        }
                    } catch (IOException unused3) {
                        fileInputStream2 = fileInputStream;
                        if (fileInputStream2 != null) {
                            fileInputStream2.close();
                        }
                        if (bArr != null) {
                            return;
                        }
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream2 = fileInputStream;
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (Exception unused4) {
                            }
                        }
                        throw th;
                    }
                }
            }
        } catch (SecurityException | Exception unused5) {
        }
        if (bArr != null || bArr.length <= 0) {
            return;
        }
        this.mBase64ImgData = Base64.encodebyte(bArr);
    }

    @Override // com.sina.weibo.sdk.web.param.BaseWebViewRequestParam
    public void childFillBundle(Bundle bundle) {
        WeiboMultiMessage weiboMultiMessage = this.multiMessage;
        if (weiboMultiMessage != null) {
            weiboMultiMessage.toBundle(bundle);
        }
        bundle.putString("token", this.token);
        bundle.putString(InstallAntiBlockingActivity.PARAM_PACKAGE_NAME, this.packageName);
        bundle.putString("hashKey", this.hashKey);
    }

    @Override // com.sina.weibo.sdk.web.param.BaseWebViewRequestParam
    public void doExtraTask(final BaseWebViewRequestParam.ExtraTaskCallback extraTaskCallback) {
        super.doExtraTask(extraTaskCallback);
        LogUtil.i("Share", "ShareWebViewRequestParam.doExtraTask()");
        new WeiboParameters(getBaseData().getAuthInfo().getAppKey());
        String str = new String(this.mBase64ImgData);
        IRequestService requestService = RequestService.getInstance();
        RequestParam.Builder builder = new RequestParam.Builder(this.context);
        builder.setShortUrl(UPLOAD_PIC_URL);
        builder.addPostParam("img", str);
        builder.addPostParam("appKey", getBaseData().getAuthInfo().getAppKey());
        requestService.asyncRequest(builder.build(), new SimpleTarget() { // from class: com.sina.weibo.sdk.web.param.ShareWebViewRequestParam.1
            @Override // com.sina.weibo.sdk.network.target.Target
            public void onFailure(Exception exc) {
                LogUtil.i("Share", "ShareWebViewRequestParam.doExtraTask().onFailure(),e =" + exc.getMessage());
                BaseWebViewRequestParam.ExtraTaskCallback extraTaskCallback2 = extraTaskCallback;
                if (extraTaskCallback2 != null) {
                    extraTaskCallback2.onException("upload pic fail");
                }
            }

            @Override // com.sina.weibo.sdk.network.target.SimpleTarget
            public void onSuccess(String str2) {
                LogUtil.i("Share", "ShareWebViewRequestParam.doExtraTask().onSuccess(),response = " + str2);
                WebPicUploadResult parse = WebPicUploadResult.parse(str2);
                if (parse != null && parse.getCode() == 1 && !TextUtils.isEmpty(parse.getPicId())) {
                    ShareWebViewRequestParam.this.picId = parse.getPicId();
                    BaseWebViewRequestParam.ExtraTaskCallback extraTaskCallback2 = extraTaskCallback;
                    if (extraTaskCallback2 != null) {
                        extraTaskCallback2.onComplete(ShareWebViewRequestParam.this.picId);
                        return;
                    }
                    return;
                }
                BaseWebViewRequestParam.ExtraTaskCallback extraTaskCallback3 = extraTaskCallback;
                if (extraTaskCallback3 != null) {
                    extraTaskCallback3.onException("upload pic fail");
                }
            }
        });
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
        Context context = this.context;
        if (context != null) {
            String aid = Utility.getAid(context, appKey);
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
    public boolean hasExtraTask() {
        byte[] bArr = this.mBase64ImgData;
        if (bArr == null || bArr.length <= 0) {
            return super.hasExtraTask();
        }
        return true;
    }

    public void setHashKey(String str) {
        this.hashKey = str;
    }

    public void setMultiMessage(WeiboMultiMessage weiboMultiMessage) {
        this.multiMessage = weiboMultiMessage;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setToken(String str) {
        this.token = str;
    }

    @Override // com.sina.weibo.sdk.web.param.BaseWebViewRequestParam
    public void transformChildBundle(Bundle bundle) {
        WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
        this.multiMessage = weiboMultiMessage;
        weiboMultiMessage.toObject(bundle);
        this.token = bundle.getString("token");
        this.packageName = bundle.getString(InstallAntiBlockingActivity.PARAM_PACKAGE_NAME);
        this.hashKey = bundle.getString("hashKey");
        getBaseUrl();
    }

    @Override // com.sina.weibo.sdk.web.param.BaseWebViewRequestParam
    public void updateRequestUrl(String str) {
        this.picId = str;
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
}
