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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes7.dex */
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
    public static final int SHARE_TO_QZONE_TYPE_APP = 6;
    public static final int SHARE_TO_QZONE_TYPE_IMAGE = 5;
    public static final int SHARE_TO_QZONE_TYPE_IMAGE_TEXT = 1;
    public static final int SHARE_TO_QZONE_TYPE_NO_TYPE = 0;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public boolean f41804c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f41805d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f41806e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f41807f;
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
        this.f41804c = true;
        this.f41805d = false;
        this.f41806e = false;
        this.f41807f = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x031a  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0362  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(Activity activity, Bundle bundle, IUiListener iUiListener) {
        int i2;
        String appId;
        String openId;
        Intent intent;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, this, activity, bundle, iUiListener) == null) {
            f.c("openSDK_LOG.QzoneShare", "doshareToQzone() --start");
            StringBuffer stringBuffer = new StringBuffer("mqqapi://share/to_qzone?src_type=app&version=1&file_type=news");
            ArrayList<String> stringArrayList = bundle.getStringArrayList("imageUrl");
            String string = bundle.getString("title");
            String string2 = bundle.getString("summary");
            String string3 = bundle.getString("targetUrl");
            String string4 = bundle.getString("audio_url");
            int i3 = bundle.getInt("req_type", 1);
            String string5 = bundle.getString("appName");
            int i4 = bundle.getInt("cflag", 0);
            String string6 = bundle.getString("share_qq_ext_str");
            String str = "";
            try {
                Bundle bundle2 = bundle.getBundle("extMap");
                if (bundle2 != null) {
                    Set<String> keySet = bundle2.keySet();
                    JSONObject jSONObject = new JSONObject();
                    for (String str2 : keySet) {
                        i2 = i4;
                        try {
                            jSONObject.put(str2, bundle2.get(str2));
                            i4 = i2;
                        } catch (Exception e2) {
                            e = e2;
                            f.b("openSDK_LOG.QzoneShare", "ShareToQzone()  --error parse extmap", e);
                            appId = this.f41776b.getAppId();
                            openId = this.f41776b.getOpenId();
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
                            stringBuffer.append("&req_type=" + Base64.encodeToString(j.i(String.valueOf(i3)), 2));
                            if (!j.e(string6)) {
                            }
                            if (!TextUtils.isEmpty(str)) {
                            }
                            stringBuffer.append("&cflag=" + Base64.encodeToString(j.i(String.valueOf(i2)), 2));
                            f.a("openSDK_LOG.QzoneShare", "doshareToQzone, url: " + stringBuffer.toString());
                            com.tencent.connect.a.a.a(e.a(), this.f41776b, "requireApi", "shareToNativeQQ");
                            intent = new Intent("android.intent.action.VIEW");
                            intent.setData(Uri.parse(stringBuffer.toString()));
                            intent.putExtra(EmotionResourceInfo.JSON_KEY_PKG_NAME, activity.getPackageName());
                            if (!j.g(activity, "4.6.0")) {
                            }
                            if (!a(intent)) {
                            }
                            f.c("openSDK_LOG", "doShareToQzone() --end");
                        }
                    }
                    i2 = i4;
                    if (keySet.size() > 0) {
                        str = jSONObject.toString();
                    }
                } else {
                    i2 = i4;
                }
            } catch (Exception e3) {
                e = e3;
                i2 = i4;
            }
            appId = this.f41776b.getAppId();
            openId = this.f41776b.getOpenId();
            f.a("openSDK_LOG.QzoneShare", "openId:" + openId);
            if (stringArrayList != null) {
                StringBuffer stringBuffer2 = new StringBuffer();
                int size = stringArrayList.size() <= 9 ? stringArrayList.size() : 9;
                int i5 = 0;
                while (i5 < size) {
                    ArrayList<String> arrayList = stringArrayList;
                    stringBuffer2.append(URLEncoder.encode(stringArrayList.get(i5)));
                    if (i5 != size - 1) {
                        stringBuffer2.append(";");
                    }
                    i5++;
                    stringArrayList = arrayList;
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
            stringBuffer.append("&req_type=" + Base64.encodeToString(j.i(String.valueOf(i3)), 2));
            if (!j.e(string6)) {
                stringBuffer.append("&share_qq_ext_str=" + Base64.encodeToString(j.i(string6), 2));
            }
            if (!TextUtils.isEmpty(str)) {
                stringBuffer.append("&share_qzone_ext_str=" + Base64.encodeToString(j.i(str), 2));
            }
            stringBuffer.append("&cflag=" + Base64.encodeToString(j.i(String.valueOf(i2)), 2));
            f.a("openSDK_LOG.QzoneShare", "doshareToQzone, url: " + stringBuffer.toString());
            com.tencent.connect.a.a.a(e.a(), this.f41776b, "requireApi", "shareToNativeQQ");
            intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(stringBuffer.toString()));
            intent.putExtra(EmotionResourceInfo.JSON_KEY_PKG_NAME, activity.getPackageName());
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
                    a(activity, 10104, intent, false);
                }
            }
            if (!a(intent)) {
                d.a().a(this.f41776b.getOpenId(), this.f41776b.getAppId(), Constants.VIA_SHARE_TO_QZONE, "11", "3", "0", this.mViaShareQzoneType, "0", "1", "0");
                d.a().a(0, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.f41776b.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "");
            } else {
                d.a().a(this.f41776b.getOpenId(), this.f41776b.getAppId(), Constants.VIA_SHARE_TO_QZONE, "11", "3", "1", this.mViaShareQzoneType, "0", "1", "0");
                d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.f41776b.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "hasActivityForIntent fail");
            }
            f.c("openSDK_LOG", "doShareToQzone() --end");
        }
    }

    @Override // com.tencent.connect.common.BaseApi
    public void releaseResource() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x035d  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x039d  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x03ac  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x02e4  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x02eb A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void shareToQzone(Activity activity, Bundle bundle, IUiListener iUiListener) {
        String str;
        String str2;
        int i2;
        String str3;
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, bundle, iUiListener) == null) {
            f.c("openSDK_LOG.QzoneShare", "shareToQzone() -- start");
            if (bundle == null) {
                iUiListener.onError(new UiError(-6, Constants.MSG_PARAM_NULL_ERROR, null));
                f.e("openSDK_LOG.QzoneShare", "shareToQzone() params is null");
                d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.f41776b.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, Constants.MSG_PARAM_NULL_ERROR);
                return;
            }
            String string = bundle.getString("title");
            String string2 = bundle.getString("summary");
            String string3 = bundle.getString("targetUrl");
            ArrayList<String> stringArrayList = bundle.getStringArrayList("imageUrl");
            String a2 = j.a(activity);
            if (a2 == null) {
                a2 = bundle.getString("appName");
                str = string3;
            } else {
                str = string3;
                if (a2.length() > 20) {
                    StringBuilder sb = new StringBuilder();
                    str2 = "imageUrl";
                    sb.append(a2.substring(0, 20));
                    sb.append(StringHelper.STRING_MORE);
                    a2 = sb.toString();
                    i2 = bundle.getInt("req_type");
                    if (i2 != 1) {
                        this.mViaShareQzoneType = "1";
                    } else if (i2 == 5) {
                        this.mViaShareQzoneType = "2";
                    } else if (i2 != 6) {
                        this.mViaShareQzoneType = "1";
                    } else {
                        this.mViaShareQzoneType = "4";
                    }
                    if (i2 != 1) {
                        this.f41804c = true;
                        this.f41805d = false;
                        this.f41806e = true;
                        this.f41807f = false;
                    } else if (i2 == 5) {
                        iUiListener.onError(new UiError(-5, Constants.MSG_SHARE_TYPE_ERROR, null));
                        f.e("openSDK_LOG.QzoneShare", "shareToQzone() error--end请选择支持的分享类型");
                        d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.f41776b.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQzone() 请选择支持的分享类型");
                        return;
                    } else if (i2 != 6) {
                        if (j.e(string) && j.e(string2)) {
                            if (stringArrayList != null && stringArrayList.size() != 0) {
                                this.f41804c = false;
                            } else {
                                string = "来自" + a2 + "的分享";
                                this.f41804c = true;
                            }
                        } else {
                            this.f41804c = true;
                        }
                        this.f41805d = false;
                        this.f41806e = true;
                        this.f41807f = false;
                    } else if (j.g(activity, "5.0.0")) {
                        iUiListener.onError(new UiError(-15, Constants.MSG_PARAM_APPSHARE_TOO_LOW, null));
                        f.e("openSDK_LOG.QzoneShare", "-->shareToQzone, app share is not support below qq5.0.");
                        d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.f41776b.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQzone, app share is not support below qq5.0.");
                        return;
                    } else {
                        str3 = String.format("http://fusion.qq.com/cgi-bin/qzapps/unified_jump?appid=%1$s&from=%2$s&isOpenAppID=1", this.f41776b.getAppId(), "mqq");
                        bundle.putString("targetUrl", str3);
                        if (j.b() && j.g(activity, "4.5.0")) {
                            iUiListener.onError(new UiError(-6, Constants.MSG_SHARE_NOSD_ERROR, null));
                            f.e("openSDK_LOG.QzoneShare", "shareToQzone() sdcard is null--end");
                            d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.f41776b.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, Constants.MSG_SHARE_NOSD_ERROR);
                            return;
                        }
                        if (this.f41804c) {
                            if (TextUtils.isEmpty(str3)) {
                                iUiListener.onError(new UiError(-5, Constants.MSG_PARAM_TARGETURL_NULL_ERROR, null));
                                f.e("openSDK_LOG.QzoneShare", "shareToQzone() targetUrl null error--end");
                                d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.f41776b.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, Constants.MSG_PARAM_TARGETURL_NULL_ERROR);
                                return;
                            } else if (!j.g(str3)) {
                                iUiListener.onError(new UiError(-5, Constants.MSG_PARAM_TARGETURL_ERROR, null));
                                f.e("openSDK_LOG.QzoneShare", "shareToQzone() targetUrl error--end");
                                d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.f41776b.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, Constants.MSG_PARAM_TARGETURL_ERROR);
                                return;
                            }
                        }
                        if (this.f41805d) {
                            bundle.putString("title", "");
                            bundle.putString("summary", "");
                        } else if (this.f41806e && j.e(string)) {
                            iUiListener.onError(new UiError(-6, Constants.MSG_PARAM_TITLE_NULL_ERROR, null));
                            f.e("openSDK_LOG.QzoneShare", "shareToQzone() title is null--end");
                            d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.f41776b.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQzone() title is null");
                            return;
                        } else {
                            if (j.e(string) || string.length() <= 200) {
                                str4 = null;
                            } else {
                                str4 = null;
                                bundle.putString("title", j.a(string, 200, (String) null, (String) null));
                            }
                            if (!j.e(string2) && string2.length() > 600) {
                                bundle.putString("summary", j.a(string2, 600, str4, str4));
                            }
                        }
                        if (!TextUtils.isEmpty(a2)) {
                            bundle.putString("appName", a2);
                        }
                        if (stringArrayList == null && (stringArrayList == null || stringArrayList.size() != 0)) {
                            int i3 = 0;
                            while (i3 < stringArrayList.size()) {
                                String str5 = stringArrayList.get(i3);
                                if (!j.g(str5) && !j.h(str5)) {
                                    stringArrayList.remove(i3);
                                    i3--;
                                }
                                i3++;
                            }
                            if (stringArrayList.size() == 0) {
                                iUiListener.onError(new UiError(-6, Constants.MSG_PARAM_IMAGE_URL_FORMAT_ERROR, null));
                                f.e("openSDK_LOG.QzoneShare", "shareToQzone() MSG_PARAM_IMAGE_URL_FORMAT_ERROR--end");
                                d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.f41776b.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQzone() 非法的图片地址!");
                                return;
                            }
                            bundle.putStringArrayList(str2, stringArrayList);
                        } else if (this.f41807f) {
                            iUiListener.onError(new UiError(-6, Constants.MSG_PARAM_IMAGE_ERROR, null));
                            f.e("openSDK_LOG.QzoneShare", "shareToQzone() imageUrl is null -- end");
                            d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.f41776b.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQzone() imageUrl is null");
                            return;
                        }
                        if (!j.g(activity, "4.6.0")) {
                            f.c("openSDK_LOG.QzoneShare", "shareToQzone() qqver greater than 4.6.0");
                            a.a(activity, stringArrayList, new c(this, iUiListener, bundle, activity) { // from class: com.tencent.connect.share.QzoneShare.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ IUiListener f41808a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ Bundle f41809b;

                                /* renamed from: c  reason: collision with root package name */
                                public final /* synthetic */ Activity f41810c;

                                /* renamed from: d  reason: collision with root package name */
                                public final /* synthetic */ QzoneShare f41811d;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, iUiListener, bundle, activity};
                                        interceptable2.invokeUnInit(65536, newInitContext);
                                        int i4 = newInitContext.flag;
                                        if ((i4 & 1) != 0) {
                                            int i5 = i4 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable2.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.f41811d = this;
                                    this.f41808a = iUiListener;
                                    this.f41809b = bundle;
                                    this.f41810c = activity;
                                }

                                @Override // com.tencent.open.utils.c
                                public void a(int i4, String str6) {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i4, str6) == null) {
                                        this.f41808a.onError(new UiError(-6, Constants.MSG_PARAM_IMAGE_URL_FORMAT_ERROR, null));
                                    }
                                }

                                @Override // com.tencent.open.utils.c
                                public void a(int i4, ArrayList<String> arrayList) {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeIL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i4, arrayList) == null) {
                                        if (i4 == 0) {
                                            this.f41809b.putStringArrayList("imageUrl", arrayList);
                                        }
                                        this.f41811d.b(this.f41810c, this.f41809b, this.f41808a);
                                    }
                                }
                            });
                        } else if (h.c(activity, "4.2.0") >= 0 && h.c(activity, "4.6.0") < 0) {
                            f.d("openSDK_LOG.QzoneShare", "shareToQzone() qqver between 4.2.0 and 4.6.0, will use qqshare");
                            QQShare qQShare = new QQShare(activity, this.f41776b);
                            if (stringArrayList != null && stringArrayList.size() > 0) {
                                String str6 = stringArrayList.get(0);
                                if (i2 == 5 && !j.h(str6)) {
                                    iUiListener.onError(new UiError(-6, Constants.MSG_PARAM_IMAGE_URL_MUST_BE_LOCAL, null));
                                    f.e("openSDK_LOG.QzoneShare", "shareToQzone()手Q版本过低，纯图分享不支持网路图片");
                                    d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.f41776b.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQzone()手Q版本过低，纯图分享不支持网路图片");
                                    return;
                                }
                                bundle.putString("imageLocalUrl", str6);
                            }
                            if (!j.g(activity, "4.5.0")) {
                                bundle.putInt("cflag", 1);
                            }
                            qQShare.shareToQQ(activity, bundle, iUiListener);
                        } else {
                            f.d("openSDK_LOG.QzoneShare", "shareToQzone() qqver below 4.2.0, will show download dialog");
                            new TDialog(activity, "", a(""), null, this.f41776b).show();
                        }
                        f.c("openSDK_LOG.QzoneShare", "shareToQzone() --end");
                    }
                    str3 = str;
                    if (j.b()) {
                    }
                    if (this.f41804c) {
                    }
                    if (this.f41805d) {
                    }
                    if (!TextUtils.isEmpty(a2)) {
                    }
                    if (stringArrayList == null) {
                    }
                    if (this.f41807f) {
                    }
                    if (!j.g(activity, "4.6.0")) {
                    }
                    f.c("openSDK_LOG.QzoneShare", "shareToQzone() --end");
                }
            }
            str2 = "imageUrl";
            i2 = bundle.getInt("req_type");
            if (i2 != 1) {
            }
            if (i2 != 1) {
            }
            str3 = str;
            if (j.b()) {
            }
            if (this.f41804c) {
            }
            if (this.f41805d) {
            }
            if (!TextUtils.isEmpty(a2)) {
            }
            if (stringArrayList == null) {
            }
            if (this.f41807f) {
            }
            if (!j.g(activity, "4.6.0")) {
            }
            f.c("openSDK_LOG.QzoneShare", "shareToQzone() --end");
        }
    }
}
