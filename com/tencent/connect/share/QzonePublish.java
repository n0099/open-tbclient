package com.tencent.connect.share;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.open.TDialog;
import com.tencent.open.a.f;
import com.tencent.open.b.d;
import com.tencent.open.utils.e;
import com.tencent.open.utils.j;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class QzonePublish extends BaseApi {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String HULIAN_CALL_BACK = "hulian_call_back";
    public static final String HULIAN_EXTRA_SCENE = "hulian_extra_scene";
    public static final String PUBLISH_TO_QZONE_APP_NAME = "appName";
    public static final String PUBLISH_TO_QZONE_EXTMAP = "extMap";
    public static final String PUBLISH_TO_QZONE_IMAGE_URL = "imageUrl";
    public static final String PUBLISH_TO_QZONE_KEY_TYPE = "req_type";
    public static final String PUBLISH_TO_QZONE_SUMMARY = "summary";
    public static final int PUBLISH_TO_QZONE_TYPE_PUBLISHMOOD = 3;
    public static final int PUBLISH_TO_QZONE_TYPE_PUBLISHVIDEO = 4;
    public static final String PUBLISH_TO_QZONE_VIDEO_DURATION = "videoDuration";
    public static final String PUBLISH_TO_QZONE_VIDEO_PATH = "videoPath";
    public static final String PUBLISH_TO_QZONE_VIDEO_SIZE = "videoSize";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QzonePublish(Context context, QQToken qQToken) {
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00bf A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x02d2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(Activity activity, Bundle bundle, IUiListener iUiListener) {
        String str;
        String str2;
        String appId;
        String openId;
        Intent intent;
        int size;
        int i2;
        Bundle bundle2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, this, activity, bundle, iUiListener) == null) {
            String str3 = "";
            f.c("openSDK_LOG.QzonePublish", "doPublishToQzone() --start");
            StringBuffer stringBuffer = new StringBuffer("mqqapi://qzone/publish?src_type=app&version=1&file_type=news");
            ArrayList<String> stringArrayList = bundle.getStringArrayList("imageUrl");
            String string = bundle.getString("summary");
            int i3 = bundle.getInt("req_type", 3);
            String string2 = bundle.getString("appName");
            String string3 = bundle.getString(PUBLISH_TO_QZONE_VIDEO_PATH);
            int i4 = bundle.getInt(PUBLISH_TO_QZONE_VIDEO_DURATION);
            long j = bundle.getLong(PUBLISH_TO_QZONE_VIDEO_SIZE);
            try {
                bundle2 = bundle.getBundle("extMap");
            } catch (Exception e2) {
                e = e2;
                str = str3;
            }
            if (bundle2 != null) {
                Set<String> keySet = bundle2.keySet();
                JSONObject jSONObject = new JSONObject();
                for (String str4 : keySet) {
                    if (TextUtils.isEmpty(bundle2.getString(str4))) {
                        str = str3;
                    } else {
                        str = str3;
                        try {
                            jSONObject.put(str4, bundle2.getString(str4));
                        } catch (Exception e3) {
                            e = e3;
                            f.b("openSDK_LOG.QzonePublish", "publishToQzone()  --error parse extmap", e);
                            str2 = str;
                            appId = this.f41776b.getAppId();
                            openId = this.f41776b.getOpenId();
                            f.a("openSDK_LOG.QzonePublish", "openId:" + openId);
                            if (3 == i3) {
                            }
                            if (4 == i3) {
                            }
                            String str5 = str;
                            if (!TextUtils.isEmpty(string)) {
                            }
                            if (!TextUtils.isEmpty(appId)) {
                            }
                            if (!TextUtils.isEmpty(string2)) {
                            }
                            if (!j.e(openId)) {
                            }
                            if (!TextUtils.isEmpty(str2)) {
                            }
                            stringBuffer.append("&req_type=" + Base64.encodeToString(j.i(String.valueOf(i3)), 2));
                            f.a("openSDK_LOG.QzonePublish", "doPublishToQzone, url: " + stringBuffer.toString());
                            com.tencent.connect.a.a.a(e.a(), this.f41776b, "requireApi", "shareToNativeQQ");
                            intent = new Intent("android.intent.action.VIEW");
                            intent.setData(Uri.parse(stringBuffer.toString()));
                            intent.putExtra(EmotionResourceInfo.JSON_KEY_PKG_NAME, activity.getPackageName());
                            if (a(intent)) {
                            }
                            f.c("openSDK_LOG", "doPublishToQzone() --end");
                        }
                    }
                    str3 = str;
                }
                str = str3;
                if (jSONObject.length() > 0) {
                    str2 = jSONObject.toString();
                    appId = this.f41776b.getAppId();
                    openId = this.f41776b.getOpenId();
                    f.a("openSDK_LOG.QzonePublish", "openId:" + openId);
                    if (3 == i3 && stringArrayList != null) {
                        StringBuffer stringBuffer2 = new StringBuffer();
                        size = stringArrayList.size();
                        i2 = 0;
                        while (i2 < size) {
                            ArrayList<String> arrayList = stringArrayList;
                            stringBuffer2.append(URLEncoder.encode(stringArrayList.get(i2)));
                            if (i2 != size - 1) {
                                stringBuffer2.append(";");
                            }
                            i2++;
                            stringArrayList = arrayList;
                        }
                        stringBuffer.append("&image_url=" + Base64.encodeToString(j.i(stringBuffer2.toString()), 2));
                        str = "7";
                    }
                    if (4 == i3) {
                        stringBuffer.append("&videoPath=" + Base64.encodeToString(j.i(string3), 2));
                        stringBuffer.append("&videoDuration=" + Base64.encodeToString(j.i(String.valueOf(i4)), 2));
                        stringBuffer.append("&videoSize=" + Base64.encodeToString(j.i(String.valueOf(j)), 2));
                        str = "8";
                    }
                    String str52 = str;
                    if (!TextUtils.isEmpty(string)) {
                        stringBuffer.append("&description=" + Base64.encodeToString(j.i(string), 2));
                    }
                    if (!TextUtils.isEmpty(appId)) {
                        stringBuffer.append("&share_id=" + appId);
                    }
                    if (!TextUtils.isEmpty(string2)) {
                        stringBuffer.append("&app_name=" + Base64.encodeToString(j.i(string2), 2));
                    }
                    if (!j.e(openId)) {
                        stringBuffer.append("&open_id=" + Base64.encodeToString(j.i(openId), 2));
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        stringBuffer.append("&share_qzone_ext_str=" + Base64.encodeToString(j.i(str2), 2));
                    }
                    stringBuffer.append("&req_type=" + Base64.encodeToString(j.i(String.valueOf(i3)), 2));
                    f.a("openSDK_LOG.QzonePublish", "doPublishToQzone, url: " + stringBuffer.toString());
                    com.tencent.connect.a.a.a(e.a(), this.f41776b, "requireApi", "shareToNativeQQ");
                    intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse(stringBuffer.toString()));
                    intent.putExtra(EmotionResourceInfo.JSON_KEY_PKG_NAME, activity.getPackageName());
                    if (a(intent)) {
                        a(activity, 10104, intent, false);
                        d.a().a(0, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.f41776b.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "hasActivityForIntent success");
                        d.a().a(this.f41776b.getOpenId(), this.f41776b.getAppId(), Constants.VIA_SHARE_TO_QZONE, "11", "3", "1", str52, "0", "1", "0");
                    } else {
                        f.e("openSDK_LOG.QzonePublish", "doPublishToQzone() target activity not found");
                        d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.f41776b.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "hasActivityForIntent fail");
                        d.a().a(this.f41776b.getOpenId(), this.f41776b.getAppId(), Constants.VIA_SHARE_TO_QZONE, "11", "3", "1", str52, "0", "1", "0");
                    }
                    f.c("openSDK_LOG", "doPublishToQzone() --end");
                }
            } else {
                str = "";
            }
            str2 = str;
            appId = this.f41776b.getAppId();
            openId = this.f41776b.getOpenId();
            f.a("openSDK_LOG.QzonePublish", "openId:" + openId);
            if (3 == i3) {
                StringBuffer stringBuffer22 = new StringBuffer();
                size = stringArrayList.size();
                i2 = 0;
                while (i2 < size) {
                }
                stringBuffer.append("&image_url=" + Base64.encodeToString(j.i(stringBuffer22.toString()), 2));
                str = "7";
            }
            if (4 == i3) {
            }
            String str522 = str;
            if (!TextUtils.isEmpty(string)) {
            }
            if (!TextUtils.isEmpty(appId)) {
            }
            if (!TextUtils.isEmpty(string2)) {
            }
            if (!j.e(openId)) {
            }
            if (!TextUtils.isEmpty(str2)) {
            }
            stringBuffer.append("&req_type=" + Base64.encodeToString(j.i(String.valueOf(i3)), 2));
            f.a("openSDK_LOG.QzonePublish", "doPublishToQzone, url: " + stringBuffer.toString());
            com.tencent.connect.a.a.a(e.a(), this.f41776b, "requireApi", "shareToNativeQQ");
            intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(stringBuffer.toString()));
            intent.putExtra(EmotionResourceInfo.JSON_KEY_PKG_NAME, activity.getPackageName());
            if (a(intent)) {
            }
            f.c("openSDK_LOG", "doPublishToQzone() --end");
        }
    }

    public void publishToQzone(Activity activity, Bundle bundle, IUiListener iUiListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, activity, bundle, iUiListener) == null) {
            f.c("openSDK_LOG.QzonePublish", "publishToQzone() -- start");
            if (bundle == null) {
                iUiListener.onError(new UiError(-6, Constants.MSG_PARAM_NULL_ERROR, null));
                f.e("openSDK_LOG.QzonePublish", "-->publishToQzone, params is null");
                d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.f41776b.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, Constants.MSG_PARAM_NULL_ERROR);
            } else if (!j.e(activity)) {
                iUiListener.onError(new UiError(-15, Constants.MSG_PARAM_VERSION_TOO_LOW, null));
                f.e("openSDK_LOG.QzonePublish", "-->publishToQzone, this is not support below qq 5.9.5");
                d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.f41776b.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "publicToQzone, this is not support below qq 5.9.5");
                new TDialog(activity, "", a(""), null, this.f41776b).show();
            } else {
                String a2 = j.a(activity);
                int i2 = 0;
                if (a2 == null) {
                    a2 = bundle.getString("appName");
                } else if (a2.length() > 20) {
                    a2 = a2.substring(0, 20) + StringHelper.STRING_MORE;
                }
                if (!TextUtils.isEmpty(a2)) {
                    bundle.putString("appName", a2);
                }
                int i3 = bundle.getInt("req_type");
                if (i3 == 3) {
                    ArrayList<String> stringArrayList = bundle.getStringArrayList("imageUrl");
                    if (stringArrayList != null && stringArrayList.size() > 0) {
                        while (i2 < stringArrayList.size()) {
                            if (!j.h(stringArrayList.get(i2))) {
                                stringArrayList.remove(i2);
                                i2--;
                            }
                            i2++;
                        }
                        bundle.putStringArrayList("imageUrl", stringArrayList);
                    }
                    b(activity, bundle, iUiListener);
                    f.c("openSDK_LOG.QzonePublish", "publishToQzone() --end");
                } else if (i3 == 4) {
                    String string = bundle.getString(PUBLISH_TO_QZONE_VIDEO_PATH);
                    if (!j.h(string)) {
                        f.e("openSDK_LOG.QzonePublish", "publishToQzone() video url invalid");
                        iUiListener.onError(new UiError(-5, Constants.MSG_PUBLISH_VIDEO_ERROR, null));
                        return;
                    }
                    MediaPlayer mediaPlayer = new MediaPlayer();
                    mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener(this, string, bundle, activity, iUiListener) { // from class: com.tencent.connect.share.QzonePublish.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ String f41797a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ Bundle f41798b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ Activity f41799c;

                        /* renamed from: d  reason: collision with root package name */
                        public final /* synthetic */ IUiListener f41800d;

                        /* renamed from: e  reason: collision with root package name */
                        public final /* synthetic */ QzonePublish f41801e;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, string, bundle, activity, iUiListener};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i4 = newInitContext.flag;
                                if ((i4 & 1) != 0) {
                                    int i5 = i4 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f41801e = this;
                            this.f41797a = string;
                            this.f41798b = bundle;
                            this.f41799c = activity;
                            this.f41800d = iUiListener;
                        }

                        @Override // android.media.MediaPlayer.OnPreparedListener
                        public void onPrepared(MediaPlayer mediaPlayer2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, mediaPlayer2) == null) {
                                long length = new File(this.f41797a).length();
                                int duration = mediaPlayer2.getDuration();
                                this.f41798b.putString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH, this.f41797a);
                                this.f41798b.putInt(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION, duration);
                                this.f41798b.putLong(QzonePublish.PUBLISH_TO_QZONE_VIDEO_SIZE, length);
                                this.f41801e.b(this.f41799c, this.f41798b, this.f41800d);
                                f.c("openSDK_LOG.QzonePublish", "publishToQzone() --end");
                            }
                        }
                    });
                    mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener(this, iUiListener) { // from class: com.tencent.connect.share.QzonePublish.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ IUiListener f41802a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ QzonePublish f41803b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, iUiListener};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i4 = newInitContext.flag;
                                if ((i4 & 1) != 0) {
                                    int i5 = i4 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f41803b = this;
                            this.f41802a = iUiListener;
                        }

                        @Override // android.media.MediaPlayer.OnErrorListener
                        public boolean onError(MediaPlayer mediaPlayer2, int i4, int i5) {
                            InterceptResult invokeLII;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeLII = interceptable2.invokeLII(1048576, this, mediaPlayer2, i4, i5)) == null) {
                                f.e("openSDK_LOG.QzonePublish", "publishToQzone() mediaplayer onError()");
                                this.f41802a.onError(new UiError(-5, Constants.MSG_PUBLISH_VIDEO_ERROR, null));
                                return false;
                            }
                            return invokeLII.booleanValue;
                        }
                    });
                    try {
                        mediaPlayer.setDataSource(string);
                        mediaPlayer.prepareAsync();
                    } catch (Exception unused) {
                        f.e("openSDK_LOG.QzonePublish", "publishToQzone() exception(s) occurred when preparing mediaplayer");
                        iUiListener.onError(new UiError(-5, Constants.MSG_PUBLISH_VIDEO_ERROR, null));
                    }
                } else {
                    iUiListener.onError(new UiError(-5, Constants.MSG_SHARE_TYPE_ERROR, null));
                    f.e("openSDK_LOG.QzonePublish", "publishToQzone() error--end请选择支持的分享类型");
                    d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.f41776b.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "publishToQzone() 请选择支持的分享类型");
                }
            }
        }
    }
}
