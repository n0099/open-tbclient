package com.tencent.connect.share;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.content.FileProvider;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
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
import com.tencent.open.utils.c;
import com.tencent.open.utils.f;
import com.tencent.open.utils.i;
import com.tencent.open.utils.l;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class QQShare extends BaseApi {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int QQ_SHARE_SUMMARY_MAX_LENGTH = 512;
    public static final int QQ_SHARE_TITLE_MAX_LENGTH = 128;
    public static final String SHARE_TO_QQ_APP_NAME = "appName";
    public static final String SHARE_TO_QQ_ARK_INFO = "share_to_qq_ark_info";
    public static final String SHARE_TO_QQ_AUDIO_URL = "audio_url";
    public static final String SHARE_TO_QQ_EXT_INT = "cflag";
    public static final String SHARE_TO_QQ_EXT_STR = "share_qq_ext_str";
    public static final int SHARE_TO_QQ_FLAG_QZONE_AUTO_OPEN = 1;
    public static final int SHARE_TO_QQ_FLAG_QZONE_ITEM_HIDE = 2;
    public static final String SHARE_TO_QQ_IMAGE_LOCAL_URL = "imageLocalUrl";
    public static final String SHARE_TO_QQ_IMAGE_URL = "imageUrl";
    public static final String SHARE_TO_QQ_KEY_TYPE = "req_type";
    public static final int SHARE_TO_QQ_MINI_PROGRAM = 7;
    public static final String SHARE_TO_QQ_MINI_PROGRAM_APPID = "mini_program_appid";
    public static final String SHARE_TO_QQ_MINI_PROGRAM_PATH = "mini_program_path";
    public static final String SHARE_TO_QQ_MINI_PROGRAM_TYPE = "mini_program_type";
    public static final String SHARE_TO_QQ_SITE = "site";
    public static final String SHARE_TO_QQ_SUMMARY = "summary";
    public static final String SHARE_TO_QQ_TARGET_URL = "targetUrl";
    public static final String SHARE_TO_QQ_TITLE = "title";
    public static final int SHARE_TO_QQ_TYPE_AUDIO = 2;
    public static final int SHARE_TO_QQ_TYPE_DEFAULT = 1;
    public static final int SHARE_TO_QQ_TYPE_IMAGE = 5;
    public transient /* synthetic */ FieldHolder $fh;
    public String mViaShareQQType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQShare(Context context, QQToken qQToken) {
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
        this.mViaShareQQType = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Activity activity, Bundle bundle, IUiListener iUiListener) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, this, activity, bundle, iUiListener) == null) {
            SLog.i("openSDK_LOG.QQShare", "doShareToQQ() -- start");
            StringBuffer stringBuffer = new StringBuffer("mqqapi://share/to_fri?src_type=app&version=1&file_type=news");
            String string = bundle.getString("imageUrl");
            String string2 = bundle.getString("title");
            String string3 = bundle.getString("summary");
            String string4 = bundle.getString("targetUrl");
            String string5 = bundle.getString("audio_url");
            int i4 = bundle.getInt("req_type", 1);
            String string6 = bundle.getString(SHARE_TO_QQ_ARK_INFO);
            String string7 = bundle.getString(SHARE_TO_QQ_MINI_PROGRAM_APPID);
            String string8 = bundle.getString(SHARE_TO_QQ_MINI_PROGRAM_PATH);
            String string9 = bundle.getString(SHARE_TO_QQ_MINI_PROGRAM_TYPE);
            int i5 = bundle.getInt("cflag", 0);
            String string10 = bundle.getString("share_qq_ext_str");
            String a2 = l.a(activity);
            if (a2 == null) {
                a2 = bundle.getString("appName");
            }
            String str = a2;
            String string11 = bundle.getString("imageLocalUrl");
            ArrayList<String> stringArrayList = bundle.getStringArrayList("imageLocalUrlArray");
            String appId = this.f76562c.getAppId();
            String openIdWithCache = this.f76562c.getOpenIdWithCache();
            SLog.i("openSDK_LOG.QQShare", "doShareToQQ -- openid: " + openIdWithCache + ",appName=" + str);
            if (stringArrayList != null && stringArrayList.size() >= 2) {
                String str2 = stringArrayList.get(0);
                if (str2 == null) {
                    str2 = "";
                }
                stringBuffer.append("&file_data=" + Base64.encodeToString(l.i(str2), 2));
                String str3 = stringArrayList.get(1);
                if (i4 == 7 && !TextUtils.isEmpty(str3) && i.c(activity, "8.3.3") < 0) {
                    str3 = null;
                    SLog.e("openSDK_LOG.QQShare", "doShareToQQ() share to mini program set file uri empty");
                }
                if (!TextUtils.isEmpty(str3)) {
                    try {
                        File file = new File(str3);
                        String authorities = Tencent.getAuthorities(appId);
                        if (!TextUtils.isEmpty(authorities)) {
                            Uri uriForFile = FileProvider.getUriForFile(activity, authorities, file);
                            activity.grantUriPermission("com.tencent.mobileqq", uriForFile, 3);
                            stringBuffer.append("&file_uri=");
                            stringBuffer.append(Base64.encodeToString(l.i(uriForFile.toString()), 2));
                        }
                    } catch (Exception e2) {
                        SLog.e("openSDK_LOG.QQShare", "doShareToQQ() getUriForFile exception:", e2);
                    }
                }
            } else if (!TextUtils.isEmpty(string11)) {
                stringBuffer.append("&file_data=" + Base64.encodeToString(l.i(string11), 2));
            }
            if (!TextUtils.isEmpty(string)) {
                stringBuffer.append("&image_url=" + Base64.encodeToString(l.i(string), 2));
            }
            if (!TextUtils.isEmpty(string2)) {
                stringBuffer.append("&title=" + Base64.encodeToString(l.i(string2), 2));
            }
            if (!TextUtils.isEmpty(string3)) {
                stringBuffer.append("&description=" + Base64.encodeToString(l.i(string3), 2));
            }
            if (!TextUtils.isEmpty(appId)) {
                stringBuffer.append("&share_id=" + appId);
            }
            if (!TextUtils.isEmpty(string4)) {
                stringBuffer.append("&url=" + Base64.encodeToString(l.i(string4), 2));
            }
            if (!TextUtils.isEmpty(str)) {
                if (str.length() > 20) {
                    str = str.substring(0, 20) + "...";
                }
                stringBuffer.append("&app_name=" + Base64.encodeToString(l.i(str), 2));
            }
            if (!TextUtils.isEmpty(openIdWithCache)) {
                stringBuffer.append("&open_id=" + Base64.encodeToString(l.i(openIdWithCache), 2));
            }
            if (!TextUtils.isEmpty(string5)) {
                stringBuffer.append("&audioUrl=" + Base64.encodeToString(l.i(string5), 2));
            }
            stringBuffer.append("&req_type=" + Base64.encodeToString(l.i(String.valueOf(i4)), 2));
            if (!TextUtils.isEmpty(string7)) {
                stringBuffer.append("&mini_program_appid=" + Base64.encodeToString(l.i(String.valueOf(string7)), 2));
            }
            if (!TextUtils.isEmpty(string8)) {
                stringBuffer.append("&mini_program_path=" + Base64.encodeToString(l.i(String.valueOf(string8)), 2));
            }
            if (!TextUtils.isEmpty(string9)) {
                stringBuffer.append("&mini_program_type=" + Base64.encodeToString(l.i(String.valueOf(string9)), 2));
            }
            if (!TextUtils.isEmpty(string6)) {
                stringBuffer.append("&share_to_qq_ark_info=" + Base64.encodeToString(l.i(string6), 2));
            }
            if (!TextUtils.isEmpty(string10)) {
                stringBuffer.append("&share_qq_ext_str=" + Base64.encodeToString(l.i(string10), 2));
            }
            stringBuffer.append("&cflag=" + Base64.encodeToString(l.i(String.valueOf(i5)), 2));
            boolean c2 = l.c();
            stringBuffer.append("&third_sd=" + Base64.encodeToString(l.i(String.valueOf(c2)), 2));
            SLog.v("openSDK_LOG.QQShare", "doShareToQQ -- url: " + stringBuffer.toString());
            com.tencent.connect.a.a.a(f.a(), this.f76562c, "requireApi", "shareToNativeQQ");
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(stringBuffer.toString()));
            intent.putExtra(EmotionResourceInfo.JSON_KEY_PKG_NAME, activity.getPackageName());
            if (l.f(activity, "4.6.0")) {
                SLog.i("openSDK_LOG.QQShare", "doShareToQQ, qqver below 4.6.");
                if (a(intent)) {
                    UIListenerManager.getInstance().setListenerWithRequestcode(Constants.REQUEST_OLD_SHARE, iUiListener);
                    a(activity, intent, Constants.REQUEST_OLD_SHARE);
                }
                i3 = i5;
                i2 = 1;
            } else {
                SLog.i("openSDK_LOG.QQShare", "doShareToQQ, qqver greater than 4.6.");
                if (UIListenerManager.getInstance().setListnerWithAction("shareToQQ", iUiListener) != null) {
                    SLog.i("openSDK_LOG.QQShare", "doShareToQQ, last listener is not null, cancel it.");
                }
                if (a(intent)) {
                    i2 = 1;
                    a(activity, 10103, intent, true);
                } else {
                    i2 = 1;
                }
                i3 = i5;
            }
            String str4 = i3 == i2 ? "11" : "10";
            if (a(intent)) {
                d.a().a(this.f76562c.getOpenId(), this.f76562c.getAppId(), Constants.VIA_SHARE_TO_QQ, str4, "3", "0", this.mViaShareQQType, "0", "1", "0");
                d.a().a(0, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.f76562c.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "");
            } else {
                d.a().a(this.f76562c.getOpenId(), this.f76562c.getAppId(), Constants.VIA_SHARE_TO_QQ, str4, "3", "1", this.mViaShareQQType, "0", "1", "0");
                d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.f76562c.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "hasActivityForIntent fail");
            }
            SLog.i("openSDK_LOG.QQShare", "doShareToQQ() --end");
        }
    }

    @Override // com.tencent.connect.common.BaseApi
    public void releaseResource() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x02d4  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x02d6  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x02e6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01d6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void shareToQQ(Activity activity, Bundle bundle, IUiListener iUiListener) {
        int i2;
        Bundle bundle2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, bundle, iUiListener) == null) {
            SLog.i("openSDK_LOG.QQShare", "shareToQQ() -- start.");
            String string = bundle.getString("imageUrl");
            String string2 = bundle.getString("title");
            String string3 = bundle.getString("summary");
            String string4 = bundle.getString("targetUrl");
            String string5 = bundle.getString("imageLocalUrl");
            String string6 = bundle.getString(SHARE_TO_QQ_MINI_PROGRAM_APPID);
            String string7 = bundle.getString(SHARE_TO_QQ_MINI_PROGRAM_PATH);
            int i3 = bundle.getInt("req_type", 1);
            SLog.i("openSDK_LOG.QQShare", "shareToQQ -- type: " + i3);
            if (i3 == 1) {
                this.mViaShareQQType = "1";
            } else if (i3 == 2) {
                this.mViaShareQQType = "3";
            } else if (i3 == 5) {
                this.mViaShareQQType = "2";
            } else if (i3 == 7) {
                this.mViaShareQQType = "9";
            }
            if (!l.a() && l.f(activity, "4.5.0")) {
                iUiListener.onError(new UiError(-6, Constants.MSG_SHARE_NOSD_ERROR, null));
                SLog.e("openSDK_LOG.QQShare", "shareToQQ sdcard is null--end");
                d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.f76562c.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQQ sdcard is null");
                return;
            }
            if (i3 == 5) {
                if (l.f(activity, "4.3.0")) {
                    iUiListener.onError(new UiError(-6, Constants.MSG_PARAM_QQ_VERSION_ERROR, null));
                    SLog.e("openSDK_LOG.QQShare", "shareToQQ, version below 4.3 is not support.");
                    d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.f76562c.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQQ, version below 4.3 is not support.");
                    return;
                } else if (!l.h(string5)) {
                    iUiListener.onError(new UiError(-6, Constants.MSG_PARAM_IMAGE_URL_FORMAT_ERROR, null));
                    SLog.e("openSDK_LOG.QQShare", "shareToQQ -- error: 非法的图片地址!");
                    d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.f76562c.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, Constants.MSG_PARAM_IMAGE_URL_FORMAT_ERROR);
                    return;
                }
            }
            if (i3 != 5) {
                i2 = 7;
                if (i3 != 7) {
                    if (!TextUtils.isEmpty(string4) && (string4.startsWith("http://") || string4.startsWith("https://"))) {
                        if (TextUtils.isEmpty(string2)) {
                            iUiListener.onError(new UiError(-6, Constants.MSG_PARAM_TITLE_NULL_ERROR, null));
                            SLog.e("openSDK_LOG.QQShare", "shareToQQ, title is empty.");
                            d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.f76562c.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQQ, title is empty.");
                            return;
                        }
                    } else {
                        iUiListener.onError(new UiError(-6, Constants.MSG_PARAM_ERROR, null));
                        SLog.e("openSDK_LOG.QQShare", "shareToQQ, targetUrl is empty or illegal..");
                        d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.f76562c.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQQ, targetUrl is empty or illegal..");
                        return;
                    }
                }
                if (i3 == i2) {
                    if (!TextUtils.isEmpty(string6) && !TextUtils.isEmpty(string7) && !TextUtils.isEmpty(string4) && !TextUtils.isEmpty(this.f76562c.getAppId())) {
                        if (!(i.c(activity, "8.0.8") >= 0 || i.d(activity, com.baidu.down.utils.Constants.SDK_VER) >= 0 || i.a((Context) activity, Constants.PACKAGE_QQ_SPEED) != null)) {
                            iUiListener.onError(new UiError(-5, Constants.MSG_PARAM_QQ_VERSION_ERROR, "版本过低，不支持分享小程序"));
                            return;
                        } else if (TextUtils.isEmpty(string2) || TextUtils.isEmpty(string3)) {
                            iUiListener.onError(new UiError(-5, Constants.MSG_PARAM_ERROR, "title || summary empty."));
                            return;
                        }
                    } else {
                        iUiListener.onError(new UiError(-5, Constants.MSG_PARAM_ERROR, "appid || path || url empty."));
                        return;
                    }
                }
                if (TextUtils.isEmpty(string) && !string.startsWith("http://") && !string.startsWith("https://") && !new File(string).exists()) {
                    iUiListener.onError(new UiError(-6, Constants.MSG_PARAM_IMAGE_URL_FORMAT_ERROR, null));
                    SLog.e("openSDK_LOG.QQShare", "shareToQQ, image url is emprty or illegal.");
                    d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.f76562c.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQQ, image url is emprty or illegal.");
                    return;
                }
                if (!TextUtils.isEmpty(string2) || string2.length() <= 128) {
                    bundle2 = bundle;
                    str = null;
                } else {
                    str = null;
                    bundle2 = bundle;
                    bundle2.putString("title", l.a(string2, 128, (String) null, (String) null));
                }
                if (!TextUtils.isEmpty(string3) && string3.length() > 512) {
                    bundle2.putString("summary", l.a(string3, 512, str, str));
                }
                if (!l.a(activity, bundle2.getInt("cflag", 0) != 1)) {
                    SLog.i("openSDK_LOG.QQShare", "shareToQQ, support share");
                    b(activity, bundle, iUiListener);
                } else {
                    try {
                        SLog.w("openSDK_LOG.QQShare", "shareToQQ, don't support share, will show download dialog");
                        new TDialog(activity, "", a(""), null, this.f76562c).show();
                    } catch (RuntimeException e2) {
                        SLog.e("openSDK_LOG.QQShare", " shareToQQ, TDialog.show not in main thread", e2);
                        e2.printStackTrace();
                        iUiListener.onError(new UiError(-6, Constants.MSG_NOT_CALL_ON_MAIN_THREAD, null));
                    }
                }
                SLog.i("openSDK_LOG.QQShare", "shareToQQ() -- end.");
            }
            i2 = 7;
            if (i3 == i2) {
            }
            if (TextUtils.isEmpty(string)) {
            }
            if (TextUtils.isEmpty(string2)) {
            }
            bundle2 = bundle;
            str = null;
            if (!TextUtils.isEmpty(string3)) {
                bundle2.putString("summary", l.a(string3, 512, str, str));
            }
            if (!l.a(activity, bundle2.getInt("cflag", 0) != 1)) {
            }
            SLog.i("openSDK_LOG.QQShare", "shareToQQ() -- end.");
        }
    }

    private void b(Activity activity, Bundle bundle, IUiListener iUiListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, this, activity, bundle, iUiListener) == null) {
            SLog.i("openSDK_LOG.QQShare", "shareToMobileQQ() -- start.");
            String string = bundle.getString("imageUrl");
            String string2 = bundle.getString("title");
            String string3 = bundle.getString("summary");
            SLog.v("openSDK_LOG.QQShare", "shareToMobileQQ -- imageUrl: " + string);
            if (!TextUtils.isEmpty(string)) {
                if (l.g(string)) {
                    if (!l.f(activity, "4.3.0")) {
                        d(activity, bundle, iUiListener);
                    } else {
                        new c(activity).a(string, new com.tencent.open.utils.d(this, bundle, string2, string3, iUiListener, activity) { // from class: com.tencent.connect.share.QQShare.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ Bundle f76572a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ String f76573b;

                            /* renamed from: c  reason: collision with root package name */
                            public final /* synthetic */ String f76574c;

                            /* renamed from: d  reason: collision with root package name */
                            public final /* synthetic */ IUiListener f76575d;

                            /* renamed from: e  reason: collision with root package name */
                            public final /* synthetic */ Activity f76576e;

                            /* renamed from: f  reason: collision with root package name */
                            public final /* synthetic */ QQShare f76577f;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, bundle, string2, string3, iUiListener, activity};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f76577f = this;
                                this.f76572a = bundle;
                                this.f76573b = string2;
                                this.f76574c = string3;
                                this.f76575d = iUiListener;
                                this.f76576e = activity;
                            }

                            @Override // com.tencent.open.utils.d
                            public void a(int i2, String str) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                                    if (i2 == 0) {
                                        this.f76572a.putString("imageLocalUrl", str);
                                    } else if (TextUtils.isEmpty(this.f76573b) && TextUtils.isEmpty(this.f76574c)) {
                                        IUiListener iUiListener2 = this.f76575d;
                                        if (iUiListener2 != null) {
                                            iUiListener2.onError(new UiError(-6, Constants.MSG_SHARE_GETIMG_ERROR, null));
                                            SLog.e("openSDK_LOG.QQShare", "shareToMobileQQ -- error: 获取分享图片失败!");
                                        }
                                        d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.f76577f.f76562c.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, Constants.MSG_SHARE_GETIMG_ERROR);
                                        return;
                                    }
                                    this.f76577f.d(this.f76576e, this.f76572a, this.f76575d);
                                }
                            }

                            @Override // com.tencent.open.utils.d
                            public void a(int i2, ArrayList<String> arrayList) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeIL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, arrayList) == null) {
                                }
                            }
                        });
                    }
                } else {
                    bundle.putString("imageUrl", null);
                    if (l.f(activity, "4.3.0")) {
                        SLog.d("openSDK_LOG.QQShare", "shareToMobileQQ -- QQ Version is < 4.3.0 ");
                        d(activity, bundle, iUiListener);
                    } else {
                        boolean n = l.n(string);
                        boolean c2 = l.c();
                        SLog.d("openSDK_LOG.QQShare", "shareToMobileQQ -- QQ Version is > 4.3.0:isAppSpecificDir=" + n + ",hasSDPermission:" + c2);
                        a.a(activity, string, new com.tencent.open.utils.d(this, bundle, string2, string3, iUiListener, activity) { // from class: com.tencent.connect.share.QQShare.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ Bundle f76578a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ String f76579b;

                            /* renamed from: c  reason: collision with root package name */
                            public final /* synthetic */ String f76580c;

                            /* renamed from: d  reason: collision with root package name */
                            public final /* synthetic */ IUiListener f76581d;

                            /* renamed from: e  reason: collision with root package name */
                            public final /* synthetic */ Activity f76582e;

                            /* renamed from: f  reason: collision with root package name */
                            public final /* synthetic */ QQShare f76583f;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, bundle, string2, string3, iUiListener, activity};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f76583f = this;
                                this.f76578a = bundle;
                                this.f76579b = string2;
                                this.f76580c = string3;
                                this.f76581d = iUiListener;
                                this.f76582e = activity;
                            }

                            @Override // com.tencent.open.utils.d
                            public void a(int i2, String str) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                                    if (i2 == 0) {
                                        this.f76578a.putString("imageLocalUrl", str);
                                    } else if (TextUtils.isEmpty(this.f76579b) && TextUtils.isEmpty(this.f76580c)) {
                                        IUiListener iUiListener2 = this.f76581d;
                                        if (iUiListener2 != null) {
                                            iUiListener2.onError(new UiError(-6, Constants.MSG_SHARE_GETIMG_ERROR, null));
                                            SLog.e("openSDK_LOG.QQShare", "shareToMobileQQ -- error: 获取分享图片失败!");
                                        }
                                        d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.f76583f.f76562c.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, Constants.MSG_SHARE_GETIMG_ERROR);
                                        return;
                                    }
                                    this.f76583f.d(this.f76582e, this.f76578a, this.f76581d);
                                }
                            }

                            @Override // com.tencent.open.utils.d
                            public void a(int i2, ArrayList<String> arrayList) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeIL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, arrayList) == null) {
                                    if (i2 == 0) {
                                        this.f76578a.putStringArrayList("imageLocalUrlArray", arrayList);
                                    } else if (TextUtils.isEmpty(this.f76579b) && TextUtils.isEmpty(this.f76580c)) {
                                        IUiListener iUiListener2 = this.f76581d;
                                        if (iUiListener2 != null) {
                                            iUiListener2.onError(new UiError(-6, Constants.MSG_SHARE_GETIMG_ERROR, null));
                                            SLog.e("openSDK_LOG.QQShare", "shareToMobileQQ -- error: 获取分享图片失败!");
                                        }
                                        d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.f76583f.f76562c.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, Constants.MSG_SHARE_GETIMG_ERROR);
                                        return;
                                    }
                                    this.f76583f.d(this.f76582e, this.f76578a, this.f76581d);
                                }
                            }
                        });
                    }
                }
            } else if (bundle.getInt("req_type", 1) == 5) {
                c(activity, bundle, iUiListener);
            } else {
                d(activity, bundle, iUiListener);
            }
            SLog.i("openSDK_LOG.QQShare", "shareToMobileQQ() -- end");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x00d5, code lost:
        if (r2 != false) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void c(Activity activity, Bundle bundle, IUiListener iUiListener) {
        File a2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, this, activity, bundle, iUiListener) == null) {
            String string = bundle.getString("imageLocalUrl");
            String str2 = null;
            if (new File(string).length() >= 5242880) {
                if (iUiListener != null) {
                    iUiListener.onError(new UiError(-16, Constants.MSG_SHARE_IMAGE_TOO_LARGE_ERROR, null));
                }
                SLog.e("openSDK_LOG.QQShare", "doShareImageToQQ -- error: 图片太大，请压缩到5M内再分享!");
                return;
            }
            if (f.a("Images") != null) {
                str2 = a2.getAbsolutePath() + File.separator + Constants.QQ_SHARE_TEMP_DIR;
            } else {
                SLog.i("openSDK_LOG.QQShare", "doShareImageToQQ() getExternalFilesDir return null");
            }
            File file = new File(string);
            String absolutePath = file.getAbsolutePath();
            String name = file.getName();
            boolean n = l.n(absolutePath);
            SLog.i("openSDK_LOG.QQShare", "doShareImageToQQ() check file: isAppSpecificDir=" + n + ",hasSDPermission=" + l.c() + ",fileDir=" + absolutePath);
            ArrayList<String> arrayList = new ArrayList<>(2);
            if (!n && !TextUtils.isEmpty(str2)) {
                str = str2 + File.separator + name;
                boolean a3 = l.a(activity, absolutePath, str);
                SLog.i("openSDK_LOG.QQShare", "doShareImageToQQ() sd permission not denied. copy to app specific:" + str + ",isSuccess=" + a3);
            }
            str = absolutePath;
            arrayList.add(absolutePath);
            arrayList.add(str);
            SLog.i("openSDK_LOG.QQShare", "doShareImageToQQ() destFilePaths=[" + arrayList.get(0) + "," + arrayList.get(1) + PreferencesUtil.RIGHT_MOUNT);
            bundle.putStringArrayList("imageLocalUrlArray", arrayList);
            d(activity, bundle, iUiListener);
        }
    }
}
