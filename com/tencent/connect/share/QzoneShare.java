package com.tencent.connect.share;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.open.TDialog;
import com.tencent.open.a.f;
import com.tencent.open.b.d;
import com.tencent.open.utils.c;
import com.tencent.open.utils.e;
import com.tencent.open.utils.h;
import com.tencent.open.utils.j;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public class QzoneShare extends BaseApi {
    public static final String SHARE_TO_QQ_APP_NAME = "appName";
    public static final String SHARE_TO_QQ_AUDIO_URL = "audio_url";
    public static final String SHARE_TO_QQ_EXT_INT = "cflag";
    public static final String SHARE_TO_QQ_EXT_STR = "share_qq_ext_str";
    public static final String SHARE_TO_QQ_IMAGE_LOCAL_URL = "imageLocalUrl";
    public static final String SHARE_TO_QQ_IMAGE_URL = "imageUrl";
    public static final String SHARE_TO_QQ_SITE = "site";
    public static final String SHARE_TO_QQ_SUMMARY = "summary";
    public static final String SHARE_TO_QQ_TARGET_URL = "targetUrl";
    public static final String SHARE_TO_QQ_TITLE = "title";
    public static final String SHARE_TO_QZONE_EXTMAP = "extMap";
    public static final String SHARE_TO_QZONE_KEY_TYPE = "req_type";
    public static final int SHARE_TO_QZONE_TYPE_APP = 6;
    public static final int SHARE_TO_QZONE_TYPE_IMAGE = 5;
    public static final int SHARE_TO_QZONE_TYPE_IMAGE_TEXT = 1;
    public static final int SHARE_TO_QZONE_TYPE_NO_TYPE = 0;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    public String mViaShareQzoneType;

    public QzoneShare(Context context, QQToken qQToken) {
        super(qQToken);
        this.mViaShareQzoneType = "";
        this.c = true;
        this.d = false;
        this.e = false;
        this.f = false;
    }

    public void shareToQzone(final Activity activity, final Bundle bundle, final IUiListener iUiListener) {
        String str;
        String str2;
        f.c("openSDK_LOG.QzoneShare", "shareToQzone() -- start");
        if (bundle == null) {
            iUiListener.onError(new UiError(-6, Constants.MSG_PARAM_NULL_ERROR, null));
            f.e("openSDK_LOG.QzoneShare", "shareToQzone() params is null");
            d.a().a(1, "SHARE_CHECK_SDK", "1000", this.b.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, Constants.MSG_PARAM_NULL_ERROR);
            return;
        }
        String string = bundle.getString("title");
        String string2 = bundle.getString("summary");
        String string3 = bundle.getString("targetUrl");
        ArrayList<String> stringArrayList = bundle.getStringArrayList("imageUrl");
        String a2 = j.a(activity);
        if (a2 == null) {
            a2 = bundle.getString("appName");
        } else if (a2.length() > 20) {
            a2 = a2.substring(0, 20) + StringHelper.STRING_MORE;
        }
        int i = bundle.getInt("req_type");
        switch (i) {
            case 1:
                this.mViaShareQzoneType = "1";
                break;
            case 2:
            case 3:
            case 4:
            default:
                this.mViaShareQzoneType = "1";
                break;
            case 5:
                this.mViaShareQzoneType = "2";
                break;
            case 6:
                this.mViaShareQzoneType = "4";
                break;
        }
        switch (i) {
            case 1:
                this.c = true;
                this.d = false;
                this.e = true;
                this.f = false;
                str = string;
                str2 = string3;
                break;
            case 2:
            case 3:
            case 4:
            default:
                if (j.e(string) && j.e(string2)) {
                    if (stringArrayList != null && stringArrayList.size() != 0) {
                        this.c = false;
                    } else {
                        string = "来自" + a2 + "的分享";
                        this.c = true;
                    }
                } else {
                    this.c = true;
                }
                this.d = false;
                this.e = true;
                this.f = false;
                str = string;
                str2 = string3;
                break;
            case 5:
                iUiListener.onError(new UiError(-5, Constants.MSG_SHARE_TYPE_ERROR, null));
                f.e("openSDK_LOG.QzoneShare", "shareToQzone() error--end请选择支持的分享类型");
                d.a().a(1, "SHARE_CHECK_SDK", "1000", this.b.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQzone() 请选择支持的分享类型");
                return;
            case 6:
                if (j.g(activity, "5.0.0")) {
                    iUiListener.onError(new UiError(-15, Constants.MSG_PARAM_APPSHARE_TOO_LOW, null));
                    f.e("openSDK_LOG.QzoneShare", "-->shareToQzone, app share is not support below qq5.0.");
                    d.a().a(1, "SHARE_CHECK_SDK", "1000", this.b.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQzone, app share is not support below qq5.0.");
                    return;
                }
                String format = String.format("http://fusion.qq.com/cgi-bin/qzapps/unified_jump?appid=%1$s&from=%2$s&isOpenAppID=1", this.b.getAppId(), "mqq");
                bundle.putString("targetUrl", format);
                str = string;
                str2 = format;
                break;
        }
        if (!j.b() && j.g(activity, "4.5.0")) {
            iUiListener.onError(new UiError(-6, Constants.MSG_SHARE_NOSD_ERROR, null));
            f.e("openSDK_LOG.QzoneShare", "shareToQzone() sdcard is null--end");
            d.a().a(1, "SHARE_CHECK_SDK", "1000", this.b.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, Constants.MSG_SHARE_NOSD_ERROR);
            return;
        }
        if (this.c) {
            if (TextUtils.isEmpty(str2)) {
                iUiListener.onError(new UiError(-5, Constants.MSG_PARAM_TARGETURL_NULL_ERROR, null));
                f.e("openSDK_LOG.QzoneShare", "shareToQzone() targetUrl null error--end");
                d.a().a(1, "SHARE_CHECK_SDK", "1000", this.b.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, Constants.MSG_PARAM_TARGETURL_NULL_ERROR);
                return;
            } else if (!j.g(str2)) {
                iUiListener.onError(new UiError(-5, Constants.MSG_PARAM_TARGETURL_ERROR, null));
                f.e("openSDK_LOG.QzoneShare", "shareToQzone() targetUrl error--end");
                d.a().a(1, "SHARE_CHECK_SDK", "1000", this.b.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, Constants.MSG_PARAM_TARGETURL_ERROR);
                return;
            }
        }
        if (this.d) {
            bundle.putString("title", "");
            bundle.putString("summary", "");
        } else if (this.e && j.e(str)) {
            iUiListener.onError(new UiError(-6, Constants.MSG_PARAM_TITLE_NULL_ERROR, null));
            f.e("openSDK_LOG.QzoneShare", "shareToQzone() title is null--end");
            d.a().a(1, "SHARE_CHECK_SDK", "1000", this.b.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQzone() title is null");
            return;
        } else {
            if (!j.e(str) && str.length() > 200) {
                bundle.putString("title", j.a(str, 200, (String) null, (String) null));
            }
            if (!j.e(string2) && string2.length() > 600) {
                bundle.putString("summary", j.a(string2, 600, (String) null, (String) null));
            }
        }
        if (!TextUtils.isEmpty(a2)) {
            bundle.putString("appName", a2);
        }
        if (stringArrayList == null || (stringArrayList != null && stringArrayList.size() == 0)) {
            if (this.f) {
                iUiListener.onError(new UiError(-6, Constants.MSG_PARAM_IMAGE_ERROR, null));
                f.e("openSDK_LOG.QzoneShare", "shareToQzone() imageUrl is null -- end");
                d.a().a(1, "SHARE_CHECK_SDK", "1000", this.b.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQzone() imageUrl is null");
                return;
            }
        } else {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < stringArrayList.size()) {
                    String str3 = stringArrayList.get(i3);
                    if (!j.g(str3) && !j.h(str3)) {
                        stringArrayList.remove(i3);
                        i3--;
                    }
                    i2 = i3 + 1;
                } else if (stringArrayList.size() == 0) {
                    iUiListener.onError(new UiError(-6, Constants.MSG_PARAM_IMAGE_URL_FORMAT_ERROR, null));
                    f.e("openSDK_LOG.QzoneShare", "shareToQzone() MSG_PARAM_IMAGE_URL_FORMAT_ERROR--end");
                    d.a().a(1, "SHARE_CHECK_SDK", "1000", this.b.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQzone() 非法的图片地址!");
                    return;
                } else {
                    bundle.putStringArrayList("imageUrl", stringArrayList);
                }
            }
        }
        if (!j.g(activity, "4.6.0")) {
            f.c("openSDK_LOG.QzoneShare", "shareToQzone() qqver greater than 4.6.0");
            a.a(activity, stringArrayList, new c() { // from class: com.tencent.connect.share.QzoneShare.1
                @Override // com.tencent.open.utils.c
                public void a(int i4, String str4) {
                    iUiListener.onError(new UiError(-6, Constants.MSG_PARAM_IMAGE_URL_FORMAT_ERROR, null));
                }

                @Override // com.tencent.open.utils.c
                public void a(int i4, ArrayList<String> arrayList) {
                    if (i4 == 0) {
                        bundle.putStringArrayList("imageUrl", arrayList);
                    }
                    QzoneShare.this.b(activity, bundle, iUiListener);
                }
            });
        } else if (h.c(activity, "4.2.0") >= 0 && h.c(activity, "4.6.0") < 0) {
            f.d("openSDK_LOG.QzoneShare", "shareToQzone() qqver between 4.2.0 and 4.6.0, will use qqshare");
            QQShare qQShare = new QQShare(activity, this.b);
            if (stringArrayList != null && stringArrayList.size() > 0) {
                String str4 = stringArrayList.get(0);
                if (i == 5 && !j.h(str4)) {
                    iUiListener.onError(new UiError(-6, Constants.MSG_PARAM_IMAGE_URL_MUST_BE_LOCAL, null));
                    f.e("openSDK_LOG.QzoneShare", "shareToQzone()手Q版本过低，纯图分享不支持网路图片");
                    d.a().a(1, "SHARE_CHECK_SDK", "1000", this.b.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQzone()手Q版本过低，纯图分享不支持网路图片");
                    return;
                }
                bundle.putString("imageLocalUrl", str4);
            }
            if (!j.g(activity, "4.5.0")) {
                bundle.putInt("cflag", 1);
            }
            qQShare.shareToQQ(activity, bundle, iUiListener);
        } else {
            f.d("openSDK_LOG.QzoneShare", "shareToQzone() qqver below 4.2.0, will show download dialog");
            new TDialog(activity, "", a(""), null, this.b).show();
        }
        f.c("openSDK_LOG.QzoneShare", "shareToQzone() --end");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x032c  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0359  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x03bb  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x03f0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(Activity activity, Bundle bundle, IUiListener iUiListener) {
        String appId;
        String openId;
        Intent intent;
        Bundle bundle2;
        String str;
        f.c("openSDK_LOG.QzoneShare", "doshareToQzone() --start");
        StringBuffer stringBuffer = new StringBuffer("mqqapi://share/to_qzone?src_type=app&version=1&file_type=news");
        ArrayList<String> stringArrayList = bundle.getStringArrayList("imageUrl");
        String string = bundle.getString("title");
        String string2 = bundle.getString("summary");
        String string3 = bundle.getString("targetUrl");
        String string4 = bundle.getString("audio_url");
        int i = bundle.getInt("req_type", 1);
        String string5 = bundle.getString("appName");
        int i2 = bundle.getInt("cflag", 0);
        String string6 = bundle.getString("share_qq_ext_str");
        String str2 = "";
        try {
            bundle2 = bundle.getBundle("extMap");
        } catch (Exception e) {
            f.b("openSDK_LOG.QzoneShare", "ShareToQzone()  --error parse extmap", e);
        }
        if (bundle2 != null) {
            Set<String> keySet = bundle2.keySet();
            JSONObject jSONObject = new JSONObject();
            for (String str3 : keySet) {
                jSONObject.put(str3, bundle2.get(str3));
            }
            if (keySet.size() > 0) {
                str = jSONObject.toString();
                str2 = str;
                appId = this.b.getAppId();
                openId = this.b.getOpenId();
                f.a("openSDK_LOG.QzoneShare", "openId:" + openId);
                if (stringArrayList != null) {
                    StringBuffer stringBuffer2 = new StringBuffer();
                    int size = stringArrayList.size() > 9 ? 9 : stringArrayList.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        stringBuffer2.append(URLEncoder.encode(stringArrayList.get(i3)));
                        if (i3 != size - 1) {
                            stringBuffer2.append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
                        }
                    }
                    stringBuffer.append("&image_url=" + Base64.encodeToString(j.i(stringBuffer2.toString()), 2));
                }
                if (!TextUtils.isEmpty(string)) {
                    stringBuffer.append("&title=" + Base64.encodeToString(j.i(string), 2));
                }
                if (!TextUtils.isEmpty(string2)) {
                    stringBuffer.append("&description=" + Base64.encodeToString(j.i(string2), 2));
                }
                if (!TextUtils.isEmpty(appId)) {
                    stringBuffer.append("&share_id=" + appId);
                }
                if (!TextUtils.isEmpty(string3)) {
                    stringBuffer.append("&url=" + Base64.encodeToString(j.i(string3), 2));
                }
                if (!TextUtils.isEmpty(string5)) {
                    stringBuffer.append("&app_name=" + Base64.encodeToString(j.i(string5), 2));
                }
                if (!j.e(openId)) {
                    stringBuffer.append("&open_id=" + Base64.encodeToString(j.i(openId), 2));
                }
                if (!j.e(string4)) {
                    stringBuffer.append("&audioUrl=" + Base64.encodeToString(j.i(string4), 2));
                }
                stringBuffer.append("&req_type=" + Base64.encodeToString(j.i(String.valueOf(i)), 2));
                if (!j.e(string6)) {
                    stringBuffer.append("&share_qq_ext_str=" + Base64.encodeToString(j.i(string6), 2));
                }
                if (!TextUtils.isEmpty(str2)) {
                    stringBuffer.append("&share_qzone_ext_str=" + Base64.encodeToString(j.i(str2), 2));
                }
                stringBuffer.append("&cflag=" + Base64.encodeToString(j.i(String.valueOf(i2)), 2));
                f.a("openSDK_LOG.QzoneShare", "doshareToQzone, url: " + stringBuffer.toString());
                com.tencent.connect.a.a.a(e.a(), this.b, "requireApi", "shareToNativeQQ");
                intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(stringBuffer.toString()));
                intent.putExtra("pkg_name", activity.getPackageName());
                if (!j.g(activity, "4.6.0")) {
                    if (a(intent)) {
                        UIListenerManager.getInstance().setListenerWithRequestcode(Constants.REQUEST_OLD_QZSHARE, iUiListener);
                        a(activity, intent, Constants.REQUEST_OLD_QZSHARE);
                    }
                    f.c("openSDK_LOG.QzoneShare", "doShareToQzone() -- QQ Version is < 4.6.0");
                } else {
                    f.c("openSDK_LOG.QzoneShare", "doShareToQzone() -- QQ Version is > 4.6.0");
                    if (UIListenerManager.getInstance().setListnerWithAction("shareToQzone", iUiListener) != null) {
                        f.c("openSDK_LOG.QzoneShare", "doShareToQzone() -- do listener onCancel()");
                    }
                    if (a(intent)) {
                        a(activity, Constants.REQUEST_QZONE_SHARE, intent, false);
                    }
                }
                if (!a(intent)) {
                    d.a().a(this.b.getOpenId(), this.b.getAppId(), Constants.VIA_SHARE_TO_QZONE, "11", "3", "0", this.mViaShareQzoneType, "0", "1", "0");
                    d.a().a(0, "SHARE_CHECK_SDK", "1000", this.b.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "");
                } else {
                    d.a().a(this.b.getOpenId(), this.b.getAppId(), Constants.VIA_SHARE_TO_QZONE, "11", "3", "1", this.mViaShareQzoneType, "0", "1", "0");
                    d.a().a(1, "SHARE_CHECK_SDK", "1000", this.b.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "hasActivityForIntent fail");
                }
                f.c("openSDK_LOG", "doShareToQzone() --end");
            }
        }
        str = "";
        str2 = str;
        appId = this.b.getAppId();
        openId = this.b.getOpenId();
        f.a("openSDK_LOG.QzoneShare", "openId:" + openId);
        if (stringArrayList != null) {
        }
        if (!TextUtils.isEmpty(string)) {
        }
        if (!TextUtils.isEmpty(string2)) {
        }
        if (!TextUtils.isEmpty(appId)) {
        }
        if (!TextUtils.isEmpty(string3)) {
        }
        if (!TextUtils.isEmpty(string5)) {
        }
        if (!j.e(openId)) {
        }
        if (!j.e(string4)) {
        }
        stringBuffer.append("&req_type=" + Base64.encodeToString(j.i(String.valueOf(i)), 2));
        if (!j.e(string6)) {
        }
        if (!TextUtils.isEmpty(str2)) {
        }
        stringBuffer.append("&cflag=" + Base64.encodeToString(j.i(String.valueOf(i2)), 2));
        f.a("openSDK_LOG.QzoneShare", "doshareToQzone, url: " + stringBuffer.toString());
        com.tencent.connect.a.a.a(e.a(), this.b, "requireApi", "shareToNativeQQ");
        intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(stringBuffer.toString()));
        intent.putExtra("pkg_name", activity.getPackageName());
        if (!j.g(activity, "4.6.0")) {
        }
        if (!a(intent)) {
        }
        f.c("openSDK_LOG", "doShareToQzone() --end");
    }

    @Override // com.tencent.connect.common.BaseApi
    public void releaseResource() {
    }
}
