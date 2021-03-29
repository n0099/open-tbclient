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

    public QzonePublish(Context context, QQToken qQToken) {
        super(qQToken);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00bb A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x02ce  */
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
        int i;
        Bundle bundle2;
        String str3 = "";
        f.c("openSDK_LOG.QzonePublish", "doPublishToQzone() --start");
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
                        appId = this.f39098b.getAppId();
                        openId = this.f39098b.getOpenId();
                        f.a("openSDK_LOG.QzonePublish", "openId:" + openId);
                        if (3 == i2) {
                        }
                        if (4 == i2) {
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
                        stringBuffer.append("&req_type=" + Base64.encodeToString(j.i(String.valueOf(i2)), 2));
                        f.a("openSDK_LOG.QzonePublish", "doPublishToQzone, url: " + stringBuffer.toString());
                        com.tencent.connect.a.a.a(e.a(), this.f39098b, "requireApi", "shareToNativeQQ");
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
                appId = this.f39098b.getAppId();
                openId = this.f39098b.getOpenId();
                f.a("openSDK_LOG.QzonePublish", "openId:" + openId);
                if (3 == i2 && stringArrayList != null) {
                    StringBuffer stringBuffer2 = new StringBuffer();
                    size = stringArrayList.size();
                    i = 0;
                    while (i < size) {
                        ArrayList<String> arrayList = stringArrayList;
                        stringBuffer2.append(URLEncoder.encode(stringArrayList.get(i)));
                        if (i != size - 1) {
                            stringBuffer2.append(";");
                        }
                        i++;
                        stringArrayList = arrayList;
                    }
                    stringBuffer.append("&image_url=" + Base64.encodeToString(j.i(stringBuffer2.toString()), 2));
                    str = "7";
                }
                if (4 == i2) {
                    stringBuffer.append("&videoPath=" + Base64.encodeToString(j.i(string3), 2));
                    stringBuffer.append("&videoDuration=" + Base64.encodeToString(j.i(String.valueOf(i3)), 2));
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
                stringBuffer.append("&req_type=" + Base64.encodeToString(j.i(String.valueOf(i2)), 2));
                f.a("openSDK_LOG.QzonePublish", "doPublishToQzone, url: " + stringBuffer.toString());
                com.tencent.connect.a.a.a(e.a(), this.f39098b, "requireApi", "shareToNativeQQ");
                intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(stringBuffer.toString()));
                intent.putExtra(EmotionResourceInfo.JSON_KEY_PKG_NAME, activity.getPackageName());
                if (a(intent)) {
                    a(activity, 10104, intent, false);
                    d.a().a(0, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.f39098b.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "hasActivityForIntent success");
                    d.a().a(this.f39098b.getOpenId(), this.f39098b.getAppId(), Constants.VIA_SHARE_TO_QZONE, Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, "3", "1", str52, "0", "1", "0");
                } else {
                    f.e("openSDK_LOG.QzonePublish", "doPublishToQzone() target activity not found");
                    d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.f39098b.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "hasActivityForIntent fail");
                    d.a().a(this.f39098b.getOpenId(), this.f39098b.getAppId(), Constants.VIA_SHARE_TO_QZONE, Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, "3", "1", str52, "0", "1", "0");
                }
                f.c("openSDK_LOG", "doPublishToQzone() --end");
            }
        } else {
            str = "";
        }
        str2 = str;
        appId = this.f39098b.getAppId();
        openId = this.f39098b.getOpenId();
        f.a("openSDK_LOG.QzonePublish", "openId:" + openId);
        if (3 == i2) {
            StringBuffer stringBuffer22 = new StringBuffer();
            size = stringArrayList.size();
            i = 0;
            while (i < size) {
            }
            stringBuffer.append("&image_url=" + Base64.encodeToString(j.i(stringBuffer22.toString()), 2));
            str = "7";
        }
        if (4 == i2) {
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
        stringBuffer.append("&req_type=" + Base64.encodeToString(j.i(String.valueOf(i2)), 2));
        f.a("openSDK_LOG.QzonePublish", "doPublishToQzone, url: " + stringBuffer.toString());
        com.tencent.connect.a.a.a(e.a(), this.f39098b, "requireApi", "shareToNativeQQ");
        intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(stringBuffer.toString()));
        intent.putExtra(EmotionResourceInfo.JSON_KEY_PKG_NAME, activity.getPackageName());
        if (a(intent)) {
        }
        f.c("openSDK_LOG", "doPublishToQzone() --end");
    }

    public void publishToQzone(final Activity activity, final Bundle bundle, final IUiListener iUiListener) {
        f.c("openSDK_LOG.QzonePublish", "publishToQzone() -- start");
        if (bundle == null) {
            iUiListener.onError(new UiError(-6, Constants.MSG_PARAM_NULL_ERROR, null));
            f.e("openSDK_LOG.QzonePublish", "-->publishToQzone, params is null");
            d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.f39098b.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, Constants.MSG_PARAM_NULL_ERROR);
        } else if (!j.e(activity)) {
            iUiListener.onError(new UiError(-15, Constants.MSG_PARAM_VERSION_TOO_LOW, null));
            f.e("openSDK_LOG.QzonePublish", "-->publishToQzone, this is not support below qq 5.9.5");
            d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.f39098b.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "publicToQzone, this is not support below qq 5.9.5");
            new TDialog(activity, "", a(""), null, this.f39098b).show();
        } else {
            String a2 = j.a(activity);
            int i = 0;
            if (a2 == null) {
                a2 = bundle.getString("appName");
            } else if (a2.length() > 20) {
                a2 = a2.substring(0, 20) + StringHelper.STRING_MORE;
            }
            if (!TextUtils.isEmpty(a2)) {
                bundle.putString("appName", a2);
            }
            int i2 = bundle.getInt("req_type");
            if (i2 == 3) {
                ArrayList<String> stringArrayList = bundle.getStringArrayList("imageUrl");
                if (stringArrayList != null && stringArrayList.size() > 0) {
                    while (i < stringArrayList.size()) {
                        if (!j.h(stringArrayList.get(i))) {
                            stringArrayList.remove(i);
                            i--;
                        }
                        i++;
                    }
                    bundle.putStringArrayList("imageUrl", stringArrayList);
                }
                b(activity, bundle, iUiListener);
                f.c("openSDK_LOG.QzonePublish", "publishToQzone() --end");
            } else if (i2 == 4) {
                final String string = bundle.getString(PUBLISH_TO_QZONE_VIDEO_PATH);
                if (!j.h(string)) {
                    f.e("openSDK_LOG.QzonePublish", "publishToQzone() video url invalid");
                    iUiListener.onError(new UiError(-5, Constants.MSG_PUBLISH_VIDEO_ERROR, null));
                    return;
                }
                MediaPlayer mediaPlayer = new MediaPlayer();
                mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.tencent.connect.share.QzonePublish.1
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer2) {
                        long length = new File(string).length();
                        int duration = mediaPlayer2.getDuration();
                        bundle.putString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH, string);
                        bundle.putInt(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION, duration);
                        bundle.putLong(QzonePublish.PUBLISH_TO_QZONE_VIDEO_SIZE, length);
                        QzonePublish.this.b(activity, bundle, iUiListener);
                        f.c("openSDK_LOG.QzonePublish", "publishToQzone() --end");
                    }
                });
                mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.tencent.connect.share.QzonePublish.2
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer2, int i3, int i4) {
                        f.e("openSDK_LOG.QzonePublish", "publishToQzone() mediaplayer onError()");
                        iUiListener.onError(new UiError(-5, Constants.MSG_PUBLISH_VIDEO_ERROR, null));
                        return false;
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
                d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.f39098b.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "publishToQzone() 请选择支持的分享类型");
            }
        }
    }
}
