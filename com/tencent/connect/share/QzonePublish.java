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
import com.tencent.open.a.d;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.f;
import com.tencent.open.utils.l;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes6.dex */
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
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ce A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0316  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0360  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(Activity activity, Bundle bundle, IUiListener iUiListener) {
        String str;
        String str2;
        String str3;
        String appId;
        String openId;
        String str4;
        String str5;
        String str6;
        String str7;
        Intent intent;
        Bundle bundle2;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, this, activity, bundle, iUiListener) == null) {
            SLog.i("openSDK_LOG.QzonePublish", "doPublishToQzone() --start");
            StringBuffer stringBuffer = new StringBuffer("mqqapi://qzone/publish?src_type=app&version=1&file_type=news");
            ArrayList<String> stringArrayList = bundle.getStringArrayList("imageUrl");
            String string = bundle.getString("summary");
            int i2 = bundle.getInt("req_type", 3);
            String string2 = bundle.getString("appName");
            String string3 = bundle.getString(PUBLISH_TO_QZONE_VIDEO_PATH);
            int i3 = bundle.getInt(PUBLISH_TO_QZONE_VIDEO_DURATION);
            long j = bundle.getLong(PUBLISH_TO_QZONE_VIDEO_SIZE);
            try {
                bundle2 = bundle.getBundle("extMap");
            } catch (Exception e2) {
                e = e2;
                str = "";
            }
            if (bundle2 != null) {
                Set<String> keySet = bundle2.keySet();
                str = "";
                try {
                    jSONObject = new JSONObject();
                    Iterator<String> it = keySet.iterator();
                    while (it.hasNext()) {
                        Iterator<String> it2 = it;
                        String next = it.next();
                        if (TextUtils.isEmpty(bundle2.getString(next))) {
                            str2 = string2;
                        } else {
                            str2 = string2;
                            try {
                                jSONObject.put(next, bundle2.getString(next));
                            } catch (Exception e3) {
                                e = e3;
                                SLog.e("openSDK_LOG.QzonePublish", "publishToQzone()  --error parse extmap", e);
                                str3 = str;
                                appId = this.f39004c.getAppId();
                                openId = this.f39004c.getOpenId();
                                SLog.v("openSDK_LOG.QzonePublish", "openId:" + openId);
                                if (3 == i2) {
                                }
                                str4 = str3;
                                str5 = "openSDK_LOG.QzonePublish";
                                str6 = openId;
                                str7 = str;
                                if (4 == i2) {
                                }
                                String str8 = str7;
                                if (!TextUtils.isEmpty(string)) {
                                }
                                if (!TextUtils.isEmpty(appId)) {
                                }
                                if (!TextUtils.isEmpty(str2)) {
                                }
                                if (!l.e(str6)) {
                                }
                                if (!TextUtils.isEmpty(str4)) {
                                }
                                stringBuffer.append("&req_type=" + Base64.encodeToString(l.i(String.valueOf(i2)), 2));
                                String str9 = str5;
                                SLog.v(str9, "doPublishToQzone, url: " + stringBuffer.toString());
                                com.tencent.connect.a.a.a(f.a(), this.f39004c, "requireApi", "shareToNativeQQ");
                                intent = new Intent("android.intent.action.VIEW");
                                intent.setData(Uri.parse(stringBuffer.toString()));
                                intent.putExtra(EmotionResourceInfo.JSON_KEY_PKG_NAME, activity.getPackageName());
                                if (!a(intent)) {
                                }
                                SLog.i(SLog.TAG, "doPublishToQzone() --end");
                            }
                        }
                        it = it2;
                        string2 = str2;
                    }
                    str2 = string2;
                } catch (Exception e4) {
                    e = e4;
                    str2 = string2;
                    SLog.e("openSDK_LOG.QzonePublish", "publishToQzone()  --error parse extmap", e);
                    str3 = str;
                    appId = this.f39004c.getAppId();
                    openId = this.f39004c.getOpenId();
                    SLog.v("openSDK_LOG.QzonePublish", "openId:" + openId);
                    if (3 == i2) {
                    }
                    str4 = str3;
                    str5 = "openSDK_LOG.QzonePublish";
                    str6 = openId;
                    str7 = str;
                    if (4 == i2) {
                    }
                    String str82 = str7;
                    if (!TextUtils.isEmpty(string)) {
                    }
                    if (!TextUtils.isEmpty(appId)) {
                    }
                    if (!TextUtils.isEmpty(str2)) {
                    }
                    if (!l.e(str6)) {
                    }
                    if (!TextUtils.isEmpty(str4)) {
                    }
                    stringBuffer.append("&req_type=" + Base64.encodeToString(l.i(String.valueOf(i2)), 2));
                    String str92 = str5;
                    SLog.v(str92, "doPublishToQzone, url: " + stringBuffer.toString());
                    com.tencent.connect.a.a.a(f.a(), this.f39004c, "requireApi", "shareToNativeQQ");
                    intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse(stringBuffer.toString()));
                    intent.putExtra(EmotionResourceInfo.JSON_KEY_PKG_NAME, activity.getPackageName());
                    if (!a(intent)) {
                    }
                    SLog.i(SLog.TAG, "doPublishToQzone() --end");
                }
                if (jSONObject.length() > 0) {
                    str3 = jSONObject.toString();
                    appId = this.f39004c.getAppId();
                    openId = this.f39004c.getOpenId();
                    SLog.v("openSDK_LOG.QzonePublish", "openId:" + openId);
                    if (3 == i2 || stringArrayList == null) {
                        str4 = str3;
                        str5 = "openSDK_LOG.QzonePublish";
                        str6 = openId;
                        str7 = str;
                    } else {
                        StringBuffer stringBuffer2 = new StringBuffer();
                        StringBuffer stringBuffer3 = new StringBuffer();
                        str5 = "openSDK_LOG.QzonePublish";
                        int size = stringArrayList.size();
                        str4 = str3;
                        int i4 = 0;
                        while (i4 < size) {
                            String str10 = openId;
                            stringBuffer2.append(URLEncoder.encode(stringArrayList.get(i4)));
                            String a2 = l.a(appId, activity, stringArrayList.get(i4), iUiListener);
                            if (!TextUtils.isEmpty(a2)) {
                                stringBuffer3.append(URLEncoder.encode(a2));
                            }
                            if (i4 != size - 1) {
                                stringBuffer2.append(";");
                                stringBuffer3.append(";");
                            }
                            i4++;
                            openId = str10;
                        }
                        str6 = openId;
                        stringBuffer.append("&image_url=" + Base64.encodeToString(l.i(stringBuffer2.toString()), 2));
                        if (!TextUtils.isEmpty(stringBuffer3.toString())) {
                            stringBuffer.append("&image_uri=" + Base64.encodeToString(l.i(stringBuffer3.toString()), 2));
                        }
                        str7 = "7";
                    }
                    if (4 == i2) {
                        stringBuffer.append("&videoPath=" + Base64.encodeToString(l.i(string3), 2));
                        String a3 = l.a(appId, activity, string3, iUiListener);
                        if (!TextUtils.isEmpty(a3)) {
                            stringBuffer.append("&videoUri=" + Base64.encodeToString(l.i(a3), 2));
                        }
                        stringBuffer.append("&videoDuration=" + Base64.encodeToString(l.i(String.valueOf(i3)), 2));
                        stringBuffer.append("&videoSize=" + Base64.encodeToString(l.i(String.valueOf(j)), 2));
                        str7 = "8";
                    }
                    String str822 = str7;
                    if (!TextUtils.isEmpty(string)) {
                        stringBuffer.append("&description=" + Base64.encodeToString(l.i(string), 2));
                    }
                    if (!TextUtils.isEmpty(appId)) {
                        stringBuffer.append("&share_id=" + appId);
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        stringBuffer.append("&app_name=" + Base64.encodeToString(l.i(str2), 2));
                    }
                    if (!l.e(str6)) {
                        stringBuffer.append("&open_id=" + Base64.encodeToString(l.i(str6), 2));
                    }
                    if (!TextUtils.isEmpty(str4)) {
                        stringBuffer.append("&share_qzone_ext_str=" + Base64.encodeToString(l.i(str4), 2));
                    }
                    stringBuffer.append("&req_type=" + Base64.encodeToString(l.i(String.valueOf(i2)), 2));
                    String str922 = str5;
                    SLog.v(str922, "doPublishToQzone, url: " + stringBuffer.toString());
                    com.tencent.connect.a.a.a(f.a(), this.f39004c, "requireApi", "shareToNativeQQ");
                    intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse(stringBuffer.toString()));
                    intent.putExtra(EmotionResourceInfo.JSON_KEY_PKG_NAME, activity.getPackageName());
                    if (!a(intent)) {
                        a(activity, Constants.REQUEST_QZONE_SHARE, intent, false);
                        d.a().a(0, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.f39004c.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "hasActivityForIntent success");
                        d.a().a(this.f39004c.getOpenId(), this.f39004c.getAppId(), Constants.VIA_SHARE_TO_QZONE, "11", "3", "1", str822, "0", "1", "0");
                    } else {
                        SLog.e(str922, "doPublishToQzone() target activity not found");
                        d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.f39004c.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "hasActivityForIntent fail");
                        d.a().a(this.f39004c.getOpenId(), this.f39004c.getAppId(), Constants.VIA_SHARE_TO_QZONE, "11", "3", "1", str822, "0", "1", "0");
                    }
                    SLog.i(SLog.TAG, "doPublishToQzone() --end");
                }
            } else {
                str = "";
                str2 = string2;
            }
            str3 = str;
            appId = this.f39004c.getAppId();
            openId = this.f39004c.getOpenId();
            SLog.v("openSDK_LOG.QzonePublish", "openId:" + openId);
            if (3 == i2) {
            }
            str4 = str3;
            str5 = "openSDK_LOG.QzonePublish";
            str6 = openId;
            str7 = str;
            if (4 == i2) {
            }
            String str8222 = str7;
            if (!TextUtils.isEmpty(string)) {
            }
            if (!TextUtils.isEmpty(appId)) {
            }
            if (!TextUtils.isEmpty(str2)) {
            }
            if (!l.e(str6)) {
            }
            if (!TextUtils.isEmpty(str4)) {
            }
            stringBuffer.append("&req_type=" + Base64.encodeToString(l.i(String.valueOf(i2)), 2));
            String str9222 = str5;
            SLog.v(str9222, "doPublishToQzone, url: " + stringBuffer.toString());
            com.tencent.connect.a.a.a(f.a(), this.f39004c, "requireApi", "shareToNativeQQ");
            intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(stringBuffer.toString()));
            intent.putExtra(EmotionResourceInfo.JSON_KEY_PKG_NAME, activity.getPackageName());
            if (!a(intent)) {
            }
            SLog.i(SLog.TAG, "doPublishToQzone() --end");
        }
    }

    public void publishToQzone(Activity activity, Bundle bundle, IUiListener iUiListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, activity, bundle, iUiListener) == null) {
            SLog.i("openSDK_LOG.QzonePublish", "publishToQzone() -- start");
            if (bundle == null) {
                iUiListener.onError(new UiError(-6, Constants.MSG_PARAM_NULL_ERROR, null));
                SLog.e("openSDK_LOG.QzonePublish", "-->publishToQzone, params is null");
                d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.f39004c.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, Constants.MSG_PARAM_NULL_ERROR);
            } else if (!l.f(activity)) {
                iUiListener.onError(new UiError(-15, Constants.MSG_PARAM_VERSION_TOO_LOW, null));
                SLog.e("openSDK_LOG.QzonePublish", "-->publishToQzone, this is not support below qq 5.9.5");
                d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.f39004c.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "publicToQzone, this is not support below qq 5.9.5");
                new TDialog(activity, "", a(""), null, this.f39004c).show();
            } else {
                String a2 = l.a(activity);
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
                            if (!l.h(stringArrayList.get(i2))) {
                                stringArrayList.remove(i2);
                                i2--;
                            }
                            i2++;
                        }
                        bundle.putStringArrayList("imageUrl", stringArrayList);
                    }
                    b(activity, bundle, iUiListener);
                    SLog.i("openSDK_LOG.QzonePublish", "publishToQzone() --end");
                } else if (i3 == 4) {
                    String string = bundle.getString(PUBLISH_TO_QZONE_VIDEO_PATH);
                    if (!l.h(string)) {
                        SLog.e("openSDK_LOG.QzonePublish", "publishToQzone() video url invalid");
                        iUiListener.onError(new UiError(-5, Constants.MSG_PUBLISH_VIDEO_ERROR, null));
                        return;
                    }
                    MediaPlayer mediaPlayer = new MediaPlayer();
                    mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener(this, string, bundle, activity, iUiListener) { // from class: com.tencent.connect.share.QzonePublish.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ String f39026a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ Bundle f39027b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ Activity f39028c;

                        /* renamed from: d  reason: collision with root package name */
                        public final /* synthetic */ IUiListener f39029d;

                        /* renamed from: e  reason: collision with root package name */
                        public final /* synthetic */ QzonePublish f39030e;

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
                            this.f39030e = this;
                            this.f39026a = string;
                            this.f39027b = bundle;
                            this.f39028c = activity;
                            this.f39029d = iUiListener;
                        }

                        @Override // android.media.MediaPlayer.OnPreparedListener
                        public void onPrepared(MediaPlayer mediaPlayer2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, mediaPlayer2) == null) {
                                long length = new File(this.f39026a).length();
                                int duration = mediaPlayer2.getDuration();
                                this.f39027b.putString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH, this.f39026a);
                                this.f39027b.putInt(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION, duration);
                                this.f39027b.putLong(QzonePublish.PUBLISH_TO_QZONE_VIDEO_SIZE, length);
                                this.f39030e.b(this.f39028c, this.f39027b, this.f39029d);
                                SLog.i("openSDK_LOG.QzonePublish", "publishToQzone() --end");
                            }
                        }
                    });
                    mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener(this, iUiListener) { // from class: com.tencent.connect.share.QzonePublish.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ IUiListener f39031a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ QzonePublish f39032b;

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
                            this.f39032b = this;
                            this.f39031a = iUiListener;
                        }

                        @Override // android.media.MediaPlayer.OnErrorListener
                        public boolean onError(MediaPlayer mediaPlayer2, int i4, int i5) {
                            InterceptResult invokeLII;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeLII = interceptable2.invokeLII(1048576, this, mediaPlayer2, i4, i5)) == null) {
                                SLog.e("openSDK_LOG.QzonePublish", "publishToQzone() mediaplayer onError()");
                                this.f39031a.onError(new UiError(-5, Constants.MSG_PUBLISH_VIDEO_ERROR, null));
                                return false;
                            }
                            return invokeLII.booleanValue;
                        }
                    });
                    try {
                        mediaPlayer.setDataSource(string);
                        mediaPlayer.prepareAsync();
                    } catch (Exception unused) {
                        SLog.e("openSDK_LOG.QzonePublish", "publishToQzone() exception(s) occurred when preparing mediaplayer");
                        iUiListener.onError(new UiError(-5, Constants.MSG_PUBLISH_VIDEO_ERROR, null));
                    }
                } else {
                    iUiListener.onError(new UiError(-5, Constants.MSG_SHARE_TYPE_ERROR, null));
                    SLog.e("openSDK_LOG.QzonePublish", "publishToQzone() error--end请选择支持的分享类型");
                    d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.f39004c.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "publishToQzone() 请选择支持的分享类型");
                }
            }
        }
    }
}
