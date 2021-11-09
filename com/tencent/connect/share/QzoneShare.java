package com.tencent.connect.share;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes2.dex */
public class QzoneShare extends BaseApi {
    public static /* synthetic */ Interceptable $ic = null;
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
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f69948a;

    /* renamed from: d  reason: collision with root package name */
    public boolean f69949d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f69950e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f69951f;
    public String mViaShareQzoneType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QzoneShare(Context context, QQToken qQToken) {
        super(qQToken);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, qQToken};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((QQToken) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mViaShareQzoneType = "";
        this.f69948a = true;
        this.f69949d = false;
        this.f69950e = false;
        this.f69951f = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0377  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x038f  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x03b8  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0400  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(Activity activity, Bundle bundle, IUiListener iUiListener) {
        int i2;
        String str;
        String str2;
        String appId;
        String openIdWithCache;
        Intent intent;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, this, activity, bundle, iUiListener) == null) {
            SLog.i("openSDK_LOG.QzoneShare", "doshareToQzone() --start");
            StringBuffer stringBuffer = new StringBuffer("mqqapi://share/to_qzone?src_type=app&version=1&file_type=news");
            ArrayList<String> stringArrayList = bundle.getStringArrayList("imageUrl");
            String string = bundle.getString("title");
            String string2 = bundle.getString("summary");
            String string3 = bundle.getString("targetUrl");
            String string4 = bundle.getString("audio_url");
            int i3 = bundle.getInt("req_type", 1);
            String string5 = bundle.getString("appName");
            String string6 = bundle.getString(QQShare.SHARE_TO_QQ_MINI_PROGRAM_APPID);
            String string7 = bundle.getString(QQShare.SHARE_TO_QQ_MINI_PROGRAM_PATH);
            String string8 = bundle.getString(QQShare.SHARE_TO_QQ_MINI_PROGRAM_TYPE);
            int i4 = bundle.getInt("cflag", 0);
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
                                i2 = i3;
                                try {
                                    jSONObject.put(str5, bundle2.get(str5));
                                    i3 = i2;
                                    string6 = str;
                                } catch (Exception e2) {
                                    e = e2;
                                    SLog.e("openSDK_LOG.QzoneShare", "ShareToQzone()  --error parse extmap", e);
                                    appId = this.f69919c.getAppId();
                                    openIdWithCache = this.f69919c.getOpenIdWithCache();
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
                                    stringBuffer.append("&req_type=" + Base64.encodeToString(l.i(String.valueOf(i2)), 2));
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
                                    stringBuffer.append("&cflag=" + Base64.encodeToString(l.i(String.valueOf(i4)), 2));
                                    SLog.v("openSDK_LOG.QzoneShare", "doshareToQzone, url: " + stringBuffer.toString());
                                    com.tencent.connect.a.a.a(f.a(), this.f69919c, "requireApi", "shareToNativeQQ");
                                    intent = new Intent("android.intent.action.VIEW");
                                    intent.setData(Uri.parse(stringBuffer.toString()));
                                    intent.putExtra("pkg_name", activity.getPackageName());
                                    if (l.g(activity, "4.6.0")) {
                                    }
                                    if (a(intent)) {
                                    }
                                    SLog.i(SLog.TAG, "doShareToQzone() --end");
                                }
                            } catch (Exception e3) {
                                e = e3;
                                i2 = i3;
                                SLog.e("openSDK_LOG.QzoneShare", "ShareToQzone()  --error parse extmap", e);
                                appId = this.f69919c.getAppId();
                                openIdWithCache = this.f69919c.getOpenIdWithCache();
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
                                stringBuffer.append("&req_type=" + Base64.encodeToString(l.i(String.valueOf(i2)), 2));
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
                                stringBuffer.append("&cflag=" + Base64.encodeToString(l.i(String.valueOf(i4)), 2));
                                SLog.v("openSDK_LOG.QzoneShare", "doshareToQzone, url: " + stringBuffer.toString());
                                com.tencent.connect.a.a.a(f.a(), this.f69919c, "requireApi", "shareToNativeQQ");
                                intent = new Intent("android.intent.action.VIEW");
                                intent.setData(Uri.parse(stringBuffer.toString()));
                                intent.putExtra("pkg_name", activity.getPackageName());
                                if (l.g(activity, "4.6.0")) {
                                }
                                if (a(intent)) {
                                }
                                SLog.i(SLog.TAG, "doShareToQzone() --end");
                            }
                        }
                        i2 = i3;
                        str = string6;
                        if (keySet.size() > 0) {
                            str4 = jSONObject.toString();
                        }
                    } catch (Exception e4) {
                        e = e4;
                        i2 = i3;
                        str = string6;
                    }
                } else {
                    i2 = i3;
                    str = string6;
                    str2 = string9;
                }
            } catch (Exception e5) {
                e = e5;
                i2 = i3;
                str = string6;
                str2 = string9;
            }
            appId = this.f69919c.getAppId();
            openIdWithCache = this.f69919c.getOpenIdWithCache();
            SLog.v("openSDK_LOG.QzoneShare", "openId:" + openIdWithCache);
            if (stringArrayList != null && stringArrayList.size() > 0) {
                str3 = stringArrayList.get(0);
                stringBuffer.append("&image_url=" + Base64.encodeToString(l.i(URLEncoder.encode(str3)), 2));
                if (!l.g(str3)) {
                    String a2 = l.a(appId, activity, str3, iUiListener);
                    if (!TextUtils.isEmpty(a2)) {
                        stringBuffer.append("&image_uri=" + Base64.encodeToString(l.i(URLEncoder.encode(a2)), 2));
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
            stringBuffer.append("&req_type=" + Base64.encodeToString(l.i(String.valueOf(i2)), 2));
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
            stringBuffer.append("&cflag=" + Base64.encodeToString(l.i(String.valueOf(i4)), 2));
            SLog.v("openSDK_LOG.QzoneShare", "doshareToQzone, url: " + stringBuffer.toString());
            com.tencent.connect.a.a.a(f.a(), this.f69919c, "requireApi", "shareToNativeQQ");
            intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(stringBuffer.toString()));
            intent.putExtra("pkg_name", activity.getPackageName());
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
                d.a().a(this.f69919c.getOpenId(), this.f69919c.getAppId(), Constants.VIA_SHARE_TO_QZONE, "11", "3", "0", this.mViaShareQzoneType, "0", "1", "0");
                d.a().a(0, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.f69919c.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "");
            } else {
                d.a().a(this.f69919c.getOpenId(), this.f69919c.getAppId(), Constants.VIA_SHARE_TO_QZONE, "11", "3", "1", this.mViaShareQzoneType, "0", "1", "0");
                d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.f69919c.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "hasActivityForIntent fail");
            }
            SLog.i(SLog.TAG, "doShareToQzone() --end");
        }
    }

    @Override // com.tencent.connect.common.BaseApi
    public void releaseResource() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x0357  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0397  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x03a1  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x02de  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void shareToQzone(Activity activity, Bundle bundle, IUiListener iUiListener) {
        String str;
        String str2;
        int i2;
        Bundle bundle2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, bundle, iUiListener) == null) {
            SLog.i("openSDK_LOG.QzoneShare", "shareToQzone() -- start");
            if (bundle == null) {
                iUiListener.onError(new UiError(-6, Constants.MSG_PARAM_NULL_ERROR, null));
                SLog.e("openSDK_LOG.QzoneShare", "shareToQzone() params is null");
                d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.f69919c.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, Constants.MSG_PARAM_NULL_ERROR);
                return;
            }
            String string = bundle.getString("title");
            String string2 = bundle.getString("summary");
            String string3 = bundle.getString("targetUrl");
            String string4 = bundle.getString(QQShare.SHARE_TO_QQ_MINI_PROGRAM_APPID);
            String string5 = bundle.getString(QQShare.SHARE_TO_QQ_MINI_PROGRAM_PATH);
            ArrayList<String> stringArrayList = bundle.getStringArrayList("imageUrl");
            String a2 = l.a(activity);
            if (a2 == null) {
                a2 = bundle.getString("appName");
                str = "appName";
            } else {
                str = "appName";
                if (a2.length() > 20) {
                    StringBuilder sb = new StringBuilder();
                    str2 = "summary";
                    sb.append(a2.substring(0, 20));
                    sb.append("...");
                    a2 = sb.toString();
                    i2 = bundle.getInt("req_type");
                    SLog.e("openSDK_LOG.QzoneShare", "shareToQzone() get SHARE_TO_QZONE_KEY_TYPE: " + i2);
                    if (i2 != 1) {
                        this.mViaShareQzoneType = "1";
                    } else if (i2 != 5) {
                        this.mViaShareQzoneType = "1";
                    } else {
                        this.mViaShareQzoneType = "2";
                    }
                    if (i2 != 1) {
                        SLog.e("openSDK_LOG.QzoneShare", "-->shareToQzone, SHARE_TO_QZONE_TYPE_IMAGE_TEXT needTitle = true");
                        this.f69948a = true;
                        this.f69949d = false;
                        this.f69950e = true;
                        this.f69951f = false;
                    } else if (i2 == 5) {
                        iUiListener.onError(new UiError(-5, Constants.MSG_SHARE_TYPE_ERROR, null));
                        SLog.e("openSDK_LOG.QzoneShare", "shareToQzone() error--end请选择支持的分享类型");
                        d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.f69919c.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQzone() 请选择支持的分享类型");
                        return;
                    } else if (i2 != 7) {
                        if (l.e(string) && l.e(string2)) {
                            if (stringArrayList != null && stringArrayList.size() != 0) {
                                this.f69948a = false;
                            } else {
                                string = "来自" + a2 + "的分享";
                                this.f69948a = true;
                            }
                        } else {
                            this.f69948a = true;
                        }
                        this.f69949d = false;
                        SLog.e("openSDK_LOG.QzoneShare", "-->shareToQzone, default needTitle = true, shareType = " + i2);
                        this.f69950e = true;
                        this.f69951f = false;
                    } else {
                        if (TextUtils.isEmpty(string4) || TextUtils.isEmpty(string5)) {
                            iUiListener.onError(new UiError(-5, Constants.MSG_PARAM_ERROR, "appid or path empty."));
                        }
                        this.f69950e = false;
                        this.f69951f = false;
                        this.f69948a = false;
                    }
                    if (l.a() && l.g(activity, "4.5.0")) {
                        iUiListener.onError(new UiError(-6, Constants.MSG_SHARE_NOSD_ERROR, null));
                        SLog.e("openSDK_LOG.QzoneShare", "shareToQzone() sdcard is null--end");
                        d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.f69919c.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, Constants.MSG_SHARE_NOSD_ERROR);
                        return;
                    }
                    if (this.f69948a) {
                        if (TextUtils.isEmpty(string3)) {
                            iUiListener.onError(new UiError(-5, Constants.MSG_PARAM_TARGETURL_NULL_ERROR, null));
                            SLog.e("openSDK_LOG.QzoneShare", "shareToQzone() targetUrl null error--end");
                            d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.f69919c.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, Constants.MSG_PARAM_TARGETURL_NULL_ERROR);
                            return;
                        } else if (!l.g(string3)) {
                            iUiListener.onError(new UiError(-5, Constants.MSG_PARAM_TARGETURL_ERROR, null));
                            SLog.e("openSDK_LOG.QzoneShare", "shareToQzone() targetUrl error--end");
                            d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.f69919c.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, Constants.MSG_PARAM_TARGETURL_ERROR);
                            return;
                        }
                    }
                    if (!this.f69949d) {
                        bundle2 = bundle;
                        bundle2.putString("title", "");
                        bundle2.putString(str2, "");
                    } else {
                        bundle2 = bundle;
                        String str4 = str2;
                        if (this.f69950e && l.e(string)) {
                            iUiListener.onError(new UiError(-6, Constants.MSG_PARAM_TITLE_NULL_ERROR, null));
                            SLog.e("openSDK_LOG.QzoneShare", "shareToQzone() title is null--end");
                            d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.f69919c.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQzone() title is null");
                            return;
                        }
                        if (l.e(string) || string.length() <= 200) {
                            str3 = null;
                        } else {
                            str3 = null;
                            bundle2.putString("title", l.a(string, 200, (String) null, (String) null));
                        }
                        if (!l.e(string2) && string2.length() > 600) {
                            bundle2.putString(str4, l.a(string2, 600, str3, str3));
                        }
                    }
                    if (!TextUtils.isEmpty(a2)) {
                        bundle2.putString(str, a2);
                    }
                    if (stringArrayList == null && (stringArrayList == null || stringArrayList.size() != 0)) {
                        int i3 = 0;
                        while (i3 < stringArrayList.size()) {
                            String str5 = stringArrayList.get(i3);
                            if (!l.g(str5) && !l.h(str5)) {
                                stringArrayList.remove(i3);
                                i3--;
                            }
                            i3++;
                        }
                        if (stringArrayList.size() == 0) {
                            iUiListener.onError(new UiError(-6, Constants.MSG_PARAM_IMAGE_URL_FORMAT_ERROR, null));
                            SLog.e("openSDK_LOG.QzoneShare", "shareToQzone() MSG_PARAM_IMAGE_URL_FORMAT_ERROR--end");
                            d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.f69919c.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQzone() 非法的图片地址!");
                            return;
                        }
                        bundle2.putStringArrayList("imageUrl", stringArrayList);
                    } else if (this.f69951f) {
                        iUiListener.onError(new UiError(-6, Constants.MSG_PARAM_IMAGE_ERROR, null));
                        SLog.e("openSDK_LOG.QzoneShare", "shareToQzone() imageUrl is null -- end");
                        d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.f69919c.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQzone() imageUrl is null");
                        return;
                    }
                    if (l.g(activity, "4.6.0")) {
                        SLog.i("openSDK_LOG.QzoneShare", "shareToQzone() qqver greater than 4.6.0");
                        b(activity, bundle, iUiListener);
                    } else if (i.c(activity, "4.2.0") >= 0 && i.c(activity, "4.6.0") < 0) {
                        SLog.w("openSDK_LOG.QzoneShare", "shareToQzone() qqver between 4.2.0 and 4.6.0, will use qqshare");
                        QQShare qQShare = new QQShare(activity, this.f69919c);
                        if (stringArrayList != null && stringArrayList.size() > 0) {
                            String str6 = stringArrayList.get(0);
                            if (i2 == 5 && !l.h(str6)) {
                                iUiListener.onError(new UiError(-6, Constants.MSG_PARAM_IMAGE_URL_MUST_BE_LOCAL, null));
                                SLog.e("openSDK_LOG.QzoneShare", "shareToQzone()手Q版本过低，纯图分享不支持网路图片");
                                d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.f69919c.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQzone()手Q版本过低，纯图分享不支持网路图片");
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
                        new TDialog(activity, "", a(""), null, this.f69919c).show();
                    }
                    SLog.i("openSDK_LOG.QzoneShare", "shareToQzone() --end");
                }
            }
            str2 = "summary";
            i2 = bundle.getInt("req_type");
            SLog.e("openSDK_LOG.QzoneShare", "shareToQzone() get SHARE_TO_QZONE_KEY_TYPE: " + i2);
            if (i2 != 1) {
            }
            if (i2 != 1) {
            }
            if (l.a()) {
            }
            if (this.f69948a) {
            }
            if (!this.f69949d) {
            }
            if (!TextUtils.isEmpty(a2)) {
            }
            if (stringArrayList == null) {
            }
            if (this.f69951f) {
            }
            if (l.g(activity, "4.6.0")) {
            }
            SLog.i("openSDK_LOG.QzoneShare", "shareToQzone() --end");
        }
    }
}
