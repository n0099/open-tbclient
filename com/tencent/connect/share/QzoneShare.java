package com.tencent.connect.share;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.tbadk.core.util.StringHelper;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.open.TDialog;
import com.tencent.open.a.d;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.f;
import com.tencent.open.utils.i;
import com.tencent.open.utils.l;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes8.dex */
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
    public static final int SHARE_TO_QZONE_TYPE_IMAGE = 5;
    public static final int SHARE_TO_QZONE_TYPE_IMAGE_TEXT = 1;
    public static final int SHARE_TO_QZONE_TYPE_MINI_PROGRAM = 7;
    public static final int SHARE_TO_QZONE_TYPE_NO_TYPE = 0;
    public boolean a;
    public boolean d;
    public boolean e;
    public boolean f;
    public String mViaShareQzoneType;

    @Override // com.tencent.connect.common.BaseApi
    public void releaseResource() {
    }

    public QzoneShare(Context context, QQToken qQToken) {
        super(qQToken);
        this.mViaShareQzoneType = "";
        this.a = true;
        this.d = false;
        this.e = false;
        this.f = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0373  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x038b  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x03b4  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x03fc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(Activity activity, Bundle bundle, IUiListener iUiListener) {
        int i;
        String str;
        String str2;
        String appId;
        String openIdWithCache;
        Intent intent;
        String str3;
        SLog.i("openSDK_LOG.QzoneShare", "doshareToQzone() --start");
        StringBuffer stringBuffer = new StringBuffer("mqqapi://share/to_qzone?src_type=app&version=1&file_type=news");
        ArrayList<String> stringArrayList = bundle.getStringArrayList("imageUrl");
        String string = bundle.getString("title");
        String string2 = bundle.getString("summary");
        String string3 = bundle.getString("targetUrl");
        String string4 = bundle.getString("audio_url");
        int i2 = bundle.getInt("req_type", 1);
        String string5 = bundle.getString("appName");
        String string6 = bundle.getString(QQShare.SHARE_TO_QQ_MINI_PROGRAM_APPID);
        String string7 = bundle.getString(QQShare.SHARE_TO_QQ_MINI_PROGRAM_PATH);
        String string8 = bundle.getString(QQShare.SHARE_TO_QQ_MINI_PROGRAM_TYPE);
        int i3 = bundle.getInt("cflag", 0);
        String string9 = bundle.getString("share_qq_ext_str");
        String str4 = "";
        try {
            Bundle bundle2 = bundle.getBundle("extMap");
            if (bundle2 != null) {
                Set<String> keySet = bundle2.keySet();
                str2 = string9;
                try {
                    JSONObject jSONObject = new JSONObject();
                    for (String str5 : keySet) {
                        str = string6;
                        try {
                            i = i2;
                            try {
                                jSONObject.put(str5, bundle2.get(str5));
                                i2 = i;
                                string6 = str;
                            } catch (Exception e) {
                                e = e;
                                SLog.e("openSDK_LOG.QzoneShare", "ShareToQzone()  --error parse extmap", e);
                                appId = this.c.getAppId();
                                openIdWithCache = this.c.getOpenIdWithCache();
                                SLog.v("openSDK_LOG.QzoneShare", "openId:" + openIdWithCache);
                                if (stringArrayList != null) {
                                    str3 = stringArrayList.get(0);
                                    stringBuffer.append("&image_url=" + Base64.encodeToString(l.i(URLEncoder.encode(str3)), 2));
                                    if (!l.g(str3)) {
                                    }
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
                                if (!l.e(openIdWithCache)) {
                                }
                                if (!l.e(string4)) {
                                }
                                stringBuffer.append("&req_type=" + Base64.encodeToString(l.i(String.valueOf(i)), 2));
                                if (!TextUtils.isEmpty(str)) {
                                }
                                if (!TextUtils.isEmpty(string7)) {
                                }
                                if (!TextUtils.isEmpty(string8)) {
                                }
                                if (!l.e(str2)) {
                                }
                                if (!TextUtils.isEmpty(str4)) {
                                }
                                stringBuffer.append("&cflag=" + Base64.encodeToString(l.i(String.valueOf(i3)), 2));
                                SLog.v("openSDK_LOG.QzoneShare", "doshareToQzone, url: " + stringBuffer.toString());
                                com.tencent.connect.a.a.a(f.a(), this.c, "requireApi", "shareToNativeQQ");
                                intent = new Intent("android.intent.action.VIEW");
                                intent.setData(Uri.parse(stringBuffer.toString()));
                                intent.putExtra(EmotionResourceInfo.JSON_KEY_PKG_NAME, activity.getPackageName());
                                if (l.g(activity, "4.6.0")) {
                                }
                                if (a(intent)) {
                                }
                                SLog.i(SLog.TAG, "doShareToQzone() --end");
                            }
                        } catch (Exception e2) {
                            e = e2;
                            i = i2;
                            SLog.e("openSDK_LOG.QzoneShare", "ShareToQzone()  --error parse extmap", e);
                            appId = this.c.getAppId();
                            openIdWithCache = this.c.getOpenIdWithCache();
                            SLog.v("openSDK_LOG.QzoneShare", "openId:" + openIdWithCache);
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
                            if (!l.e(openIdWithCache)) {
                            }
                            if (!l.e(string4)) {
                            }
                            stringBuffer.append("&req_type=" + Base64.encodeToString(l.i(String.valueOf(i)), 2));
                            if (!TextUtils.isEmpty(str)) {
                            }
                            if (!TextUtils.isEmpty(string7)) {
                            }
                            if (!TextUtils.isEmpty(string8)) {
                            }
                            if (!l.e(str2)) {
                            }
                            if (!TextUtils.isEmpty(str4)) {
                            }
                            stringBuffer.append("&cflag=" + Base64.encodeToString(l.i(String.valueOf(i3)), 2));
                            SLog.v("openSDK_LOG.QzoneShare", "doshareToQzone, url: " + stringBuffer.toString());
                            com.tencent.connect.a.a.a(f.a(), this.c, "requireApi", "shareToNativeQQ");
                            intent = new Intent("android.intent.action.VIEW");
                            intent.setData(Uri.parse(stringBuffer.toString()));
                            intent.putExtra(EmotionResourceInfo.JSON_KEY_PKG_NAME, activity.getPackageName());
                            if (l.g(activity, "4.6.0")) {
                            }
                            if (a(intent)) {
                            }
                            SLog.i(SLog.TAG, "doShareToQzone() --end");
                        }
                    }
                    i = i2;
                    str = string6;
                    if (keySet.size() > 0) {
                        str4 = jSONObject.toString();
                    }
                } catch (Exception e3) {
                    e = e3;
                    i = i2;
                    str = string6;
                }
            } else {
                i = i2;
                str = string6;
                str2 = string9;
            }
        } catch (Exception e4) {
            e = e4;
            i = i2;
            str = string6;
            str2 = string9;
        }
        appId = this.c.getAppId();
        openIdWithCache = this.c.getOpenIdWithCache();
        SLog.v("openSDK_LOG.QzoneShare", "openId:" + openIdWithCache);
        if (stringArrayList != null && stringArrayList.size() > 0) {
            str3 = stringArrayList.get(0);
            stringBuffer.append("&image_url=" + Base64.encodeToString(l.i(URLEncoder.encode(str3)), 2));
            if (!l.g(str3)) {
                String a = l.a(appId, activity, str3, iUiListener);
                if (!TextUtils.isEmpty(a)) {
                    stringBuffer.append("&image_uri=" + Base64.encodeToString(l.i(URLEncoder.encode(a)), 2));
                }
            }
        }
        if (!TextUtils.isEmpty(string)) {
            stringBuffer.append("&title=" + Base64.encodeToString(l.i(string), 2));
        }
        if (!TextUtils.isEmpty(string2)) {
            stringBuffer.append("&description=" + Base64.encodeToString(l.i(string2), 2));
        }
        if (!TextUtils.isEmpty(appId)) {
            stringBuffer.append("&share_id=" + appId);
        }
        if (!TextUtils.isEmpty(string3)) {
            stringBuffer.append("&url=" + Base64.encodeToString(l.i(string3), 2));
        }
        if (!TextUtils.isEmpty(string5)) {
            stringBuffer.append("&app_name=" + Base64.encodeToString(l.i(string5), 2));
        }
        if (!l.e(openIdWithCache)) {
            stringBuffer.append("&open_id=" + Base64.encodeToString(l.i(openIdWithCache), 2));
        }
        if (!l.e(string4)) {
            stringBuffer.append("&audioUrl=" + Base64.encodeToString(l.i(string4), 2));
        }
        stringBuffer.append("&req_type=" + Base64.encodeToString(l.i(String.valueOf(i)), 2));
        if (!TextUtils.isEmpty(str)) {
            stringBuffer.append("&mini_program_appid=" + Base64.encodeToString(l.i(String.valueOf(str)), 2));
        }
        if (!TextUtils.isEmpty(string7)) {
            stringBuffer.append("&mini_program_path=" + Base64.encodeToString(l.i(String.valueOf(string7)), 2));
        }
        if (!TextUtils.isEmpty(string8)) {
            stringBuffer.append("&mini_program_type=" + Base64.encodeToString(l.i(String.valueOf(string8)), 2));
        }
        if (!l.e(str2)) {
            stringBuffer.append("&share_qq_ext_str=" + Base64.encodeToString(l.i(str2), 2));
        }
        if (!TextUtils.isEmpty(str4)) {
            stringBuffer.append("&share_qzone_ext_str=" + Base64.encodeToString(l.i(str4), 2));
        }
        stringBuffer.append("&cflag=" + Base64.encodeToString(l.i(String.valueOf(i3)), 2));
        SLog.v("openSDK_LOG.QzoneShare", "doshareToQzone, url: " + stringBuffer.toString());
        com.tencent.connect.a.a.a(f.a(), this.c, "requireApi", "shareToNativeQQ");
        intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(stringBuffer.toString()));
        intent.putExtra(EmotionResourceInfo.JSON_KEY_PKG_NAME, activity.getPackageName());
        if (l.g(activity, "4.6.0")) {
            if (a(intent)) {
                UIListenerManager.getInstance().setListenerWithRequestcode(Constants.REQUEST_OLD_QZSHARE, iUiListener);
                a(activity, intent, Constants.REQUEST_OLD_QZSHARE);
            }
            SLog.i("openSDK_LOG.QzoneShare", "doShareToQzone() -- QQ Version is < 4.6.0");
        } else {
            SLog.i("openSDK_LOG.QzoneShare", "doShareToQzone() -- QQ Version is > 4.6.0");
            if (UIListenerManager.getInstance().setListnerWithAction("shareToQzone", iUiListener) != null) {
                SLog.i("openSDK_LOG.QzoneShare", "doShareToQzone() -- do listener onCancel()");
            }
            if (a(intent)) {
                a(activity, Constants.REQUEST_QZONE_SHARE, intent, false);
            }
        }
        if (a(intent)) {
            d.a().a(this.c.getOpenId(), this.c.getAppId(), Constants.VIA_SHARE_TO_QZONE, "11", "3", "0", this.mViaShareQzoneType, "0", "1", "0");
            d.a().a(0, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.c.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "");
        } else {
            d.a().a(this.c.getOpenId(), this.c.getAppId(), Constants.VIA_SHARE_TO_QZONE, "11", "3", "1", this.mViaShareQzoneType, "0", "1", "0");
            d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.c.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "hasActivityForIntent fail");
        }
        SLog.i(SLog.TAG, "doShareToQzone() --end");
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0353  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0393  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x039d  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x02da  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void shareToQzone(Activity activity, Bundle bundle, IUiListener iUiListener) {
        String str;
        String str2;
        int i;
        Bundle bundle2;
        String str3;
        SLog.i("openSDK_LOG.QzoneShare", "shareToQzone() -- start");
        if (bundle == null) {
            iUiListener.onError(new UiError(-6, Constants.MSG_PARAM_NULL_ERROR, null));
            SLog.e("openSDK_LOG.QzoneShare", "shareToQzone() params is null");
            d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.c.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, Constants.MSG_PARAM_NULL_ERROR);
            return;
        }
        String string = bundle.getString("title");
        String string2 = bundle.getString("summary");
        String string3 = bundle.getString("targetUrl");
        String string4 = bundle.getString(QQShare.SHARE_TO_QQ_MINI_PROGRAM_APPID);
        String string5 = bundle.getString(QQShare.SHARE_TO_QQ_MINI_PROGRAM_PATH);
        ArrayList<String> stringArrayList = bundle.getStringArrayList("imageUrl");
        String a = l.a(activity);
        if (a != null) {
            str = "appName";
            if (a.length() > 20) {
                StringBuilder sb = new StringBuilder();
                str2 = "summary";
                sb.append(a.substring(0, 20));
                sb.append(StringHelper.STRING_MORE);
                a = sb.toString();
                i = bundle.getInt("req_type");
                SLog.e("openSDK_LOG.QzoneShare", "shareToQzone() get SHARE_TO_QZONE_KEY_TYPE: " + i);
                if (i == 1) {
                    if (i != 5) {
                        this.mViaShareQzoneType = "1";
                    } else {
                        this.mViaShareQzoneType = "2";
                    }
                } else {
                    this.mViaShareQzoneType = "1";
                }
                if (i == 1) {
                    if (i != 5) {
                        if (i != 7) {
                            if (l.e(string) && l.e(string2)) {
                                if (stringArrayList != null && stringArrayList.size() != 0) {
                                    this.a = false;
                                } else {
                                    string = "来自" + a + "的分享";
                                    this.a = true;
                                }
                            } else {
                                this.a = true;
                            }
                            this.d = false;
                            SLog.e("openSDK_LOG.QzoneShare", "-->shareToQzone, default needTitle = true, shareType = " + i);
                            this.e = true;
                            this.f = false;
                        } else {
                            if (TextUtils.isEmpty(string4) || TextUtils.isEmpty(string5)) {
                                iUiListener.onError(new UiError(-5, Constants.MSG_PARAM_ERROR, "appid or path empty."));
                            }
                            this.e = false;
                            this.f = false;
                            this.a = false;
                        }
                    } else {
                        iUiListener.onError(new UiError(-5, Constants.MSG_SHARE_TYPE_ERROR, null));
                        SLog.e("openSDK_LOG.QzoneShare", "shareToQzone() error--end请选择支持的分享类型");
                        d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.c.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQzone() 请选择支持的分享类型");
                        return;
                    }
                } else {
                    SLog.e("openSDK_LOG.QzoneShare", "-->shareToQzone, SHARE_TO_QZONE_TYPE_IMAGE_TEXT needTitle = true");
                    this.a = true;
                    this.d = false;
                    this.e = true;
                    this.f = false;
                }
                if (l.a() && l.g(activity, "4.5.0")) {
                    iUiListener.onError(new UiError(-6, Constants.MSG_SHARE_NOSD_ERROR, null));
                    SLog.e("openSDK_LOG.QzoneShare", "shareToQzone() sdcard is null--end");
                    d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.c.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, Constants.MSG_SHARE_NOSD_ERROR);
                    return;
                }
                if (this.a) {
                    if (TextUtils.isEmpty(string3)) {
                        iUiListener.onError(new UiError(-5, Constants.MSG_PARAM_TARGETURL_NULL_ERROR, null));
                        SLog.e("openSDK_LOG.QzoneShare", "shareToQzone() targetUrl null error--end");
                        d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.c.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, Constants.MSG_PARAM_TARGETURL_NULL_ERROR);
                        return;
                    } else if (!l.g(string3)) {
                        iUiListener.onError(new UiError(-5, Constants.MSG_PARAM_TARGETURL_ERROR, null));
                        SLog.e("openSDK_LOG.QzoneShare", "shareToQzone() targetUrl error--end");
                        d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.c.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, Constants.MSG_PARAM_TARGETURL_ERROR);
                        return;
                    }
                }
                if (!this.d) {
                    bundle2 = bundle;
                    bundle2.putString("title", "");
                    bundle2.putString(str2, "");
                } else {
                    bundle2 = bundle;
                    String str4 = str2;
                    if (this.e && l.e(string)) {
                        iUiListener.onError(new UiError(-6, Constants.MSG_PARAM_TITLE_NULL_ERROR, null));
                        SLog.e("openSDK_LOG.QzoneShare", "shareToQzone() title is null--end");
                        d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.c.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQzone() title is null");
                        return;
                    }
                    if (!l.e(string) && string.length() > 200) {
                        str3 = null;
                        bundle2.putString("title", l.a(string, 200, (String) null, (String) null));
                    } else {
                        str3 = null;
                    }
                    if (!l.e(string2) && string2.length() > 600) {
                        bundle2.putString(str4, l.a(string2, 600, str3, str3));
                    }
                }
                if (!TextUtils.isEmpty(a)) {
                    bundle2.putString(str, a);
                }
                if (stringArrayList == null && (stringArrayList == null || stringArrayList.size() != 0)) {
                    int i2 = 0;
                    while (i2 < stringArrayList.size()) {
                        String str5 = stringArrayList.get(i2);
                        if (!l.g(str5) && !l.h(str5)) {
                            stringArrayList.remove(i2);
                            i2--;
                        }
                        i2++;
                    }
                    if (stringArrayList.size() == 0) {
                        iUiListener.onError(new UiError(-6, Constants.MSG_PARAM_IMAGE_URL_FORMAT_ERROR, null));
                        SLog.e("openSDK_LOG.QzoneShare", "shareToQzone() MSG_PARAM_IMAGE_URL_FORMAT_ERROR--end");
                        d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.c.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQzone() 非法的图片地址!");
                        return;
                    }
                    bundle2.putStringArrayList("imageUrl", stringArrayList);
                } else if (this.f) {
                    iUiListener.onError(new UiError(-6, Constants.MSG_PARAM_IMAGE_ERROR, null));
                    SLog.e("openSDK_LOG.QzoneShare", "shareToQzone() imageUrl is null -- end");
                    d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.c.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQzone() imageUrl is null");
                    return;
                }
                if (l.g(activity, "4.6.0")) {
                    SLog.i("openSDK_LOG.QzoneShare", "shareToQzone() qqver greater than 4.6.0");
                    b(activity, bundle, iUiListener);
                } else if (i.c(activity, "4.2.0") >= 0 && i.c(activity, "4.6.0") < 0) {
                    SLog.w("openSDK_LOG.QzoneShare", "shareToQzone() qqver between 4.2.0 and 4.6.0, will use qqshare");
                    QQShare qQShare = new QQShare(activity, this.c);
                    if (stringArrayList != null && stringArrayList.size() > 0) {
                        String str6 = stringArrayList.get(0);
                        if (i == 5 && !l.h(str6)) {
                            iUiListener.onError(new UiError(-6, Constants.MSG_PARAM_IMAGE_URL_MUST_BE_LOCAL, null));
                            SLog.e("openSDK_LOG.QzoneShare", "shareToQzone()手Q版本过低，纯图分享不支持网路图片");
                            d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.c.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQzone()手Q版本过低，纯图分享不支持网路图片");
                            return;
                        }
                        bundle2.putString("imageLocalUrl", str6);
                    }
                    if (!l.g(activity, "4.5.0")) {
                        bundle2.putInt("cflag", 1);
                    }
                    qQShare.shareToQQ(activity, bundle2, iUiListener);
                } else {
                    SLog.w("openSDK_LOG.QzoneShare", "shareToQzone() qqver below 4.2.0, will show download dialog");
                    new TDialog(activity, "", a(""), null, this.c).show();
                }
                SLog.i("openSDK_LOG.QzoneShare", "shareToQzone() --end");
            }
        } else {
            a = bundle.getString("appName");
            str = "appName";
        }
        str2 = "summary";
        i = bundle.getInt("req_type");
        SLog.e("openSDK_LOG.QzoneShare", "shareToQzone() get SHARE_TO_QZONE_KEY_TYPE: " + i);
        if (i == 1) {
        }
        if (i == 1) {
        }
        if (l.a()) {
        }
        if (this.a) {
        }
        if (!this.d) {
        }
        if (!TextUtils.isEmpty(a)) {
        }
        if (stringArrayList == null) {
        }
        if (this.f) {
        }
        if (l.g(activity, "4.6.0")) {
        }
        SLog.i("openSDK_LOG.QzoneShare", "shareToQzone() --end");
    }
}
