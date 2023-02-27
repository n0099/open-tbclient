package com.tencent.connect.emotion;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.widget.Toast;
import com.baidu.tbadk.core.util.StringHelper;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.i;
import com.tencent.open.utils.l;
import com.tencent.tauth.IUiListener;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class QQEmotion extends BaseApi {
    public IUiListener a;

    public QQEmotion(QQToken qQToken) {
        super(qQToken);
    }

    private String a(ArrayList<Uri> arrayList) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arrayList.size(); i++) {
            sb.append(arrayList.get(i));
            sb.append(ParamableElem.DIVIDE_PARAM);
        }
        String sb2 = sb.toString();
        SLog.i("QQEMOTION", "-->getFilePathListJson listStr : " + sb2);
        return Base64.encodeToString(l.i(sb2), 2);
    }

    private boolean a(Context context, ArrayList<Uri> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return false;
        }
        if (arrayList.size() > 9) {
            SLog.i("QQEMOTION", "isLegality -->illegal, file count > 9, count = " + arrayList.size());
            return false;
        }
        long j = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            String a = l.a(context, arrayList.get(i));
            long j2 = l.j(a);
            if (j2 > 1048576) {
                SLog.i("QQEMOTION", "isLegality -->illegal, fileSize: " + j2 + "， path =" + a);
                return false;
            }
            j += j2;
        }
        if (j > 3145728) {
            SLog.i("QQEMOTION", "isLegality -->illegal, totalSize: " + j);
            return false;
        }
        SLog.i("QQEMOTION", "isLegality -->legal, totalSize: " + j);
        return true;
    }

    public void setEmotions(Activity activity, ArrayList<Uri> arrayList, IUiListener iUiListener) {
        IUiListener iUiListener2 = this.a;
        if (iUiListener2 != null) {
            iUiListener2.onCancel();
        }
        this.a = iUiListener;
        if (!i.b(activity)) {
            Toast.makeText(activity.getApplicationContext(), "当前手机未安装QQ，请安装最新版QQ后再试。", 1).show();
        } else if (i.c(activity, "8.0.0") < 0) {
            Toast.makeText(activity.getApplicationContext(), "当前手机QQ版本过低，不支持设置表情功能。", 1).show();
        } else if (!a(activity.getApplicationContext(), arrayList)) {
            Toast.makeText(activity.getApplicationContext(), "图片不符合要求，不支持设置表情功能。", 1).show();
        } else {
            String a = l.a(activity);
            StringBuffer stringBuffer = new StringBuffer("mqqapi://profile/sdk_face_collection?");
            if (!TextUtils.isEmpty(a)) {
                if (a.length() > 20) {
                    a = a.substring(0, 20) + StringHelper.STRING_MORE;
                }
                stringBuffer.append("&app_name=" + Base64.encodeToString(l.i(a), 2));
            }
            String appId = this.c.getAppId();
            String openId = this.c.getOpenId();
            if (!TextUtils.isEmpty(appId)) {
                stringBuffer.append("&share_id=" + appId);
            }
            if (!TextUtils.isEmpty(openId)) {
                stringBuffer.append("&open_id=" + Base64.encodeToString(l.i(openId), 2));
            }
            stringBuffer.append("&sdk_version=" + Base64.encodeToString(l.i(Constants.SDK_VERSION), 2));
            String a2 = a(arrayList);
            if (!TextUtils.isEmpty(a2)) {
                stringBuffer.append("&set_uri_list=" + a2);
            }
            SLog.v("QQEMOTION", "-->set avatar, url: " + stringBuffer.toString());
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(stringBuffer.toString()));
            intent.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList);
            if (a(intent)) {
                UIListenerManager.getInstance().setListenerWithRequestcode(Constants.REQUEST_EDIT_EMOTION, iUiListener);
                a(activity, Constants.REQUEST_EDIT_EMOTION, intent, false);
            }
        }
    }
}
