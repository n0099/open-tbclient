package com.tencent.connect.emotion;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.widget.Toast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.i;
import com.tencent.open.utils.l;
import com.tencent.tauth.IUiListener;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class QQEmotion extends BaseApi {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public IUiListener f69929a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQEmotion(QQToken qQToken) {
        super(qQToken);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qQToken};
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

    private boolean a(Context context, ArrayList<Uri> arrayList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, context, arrayList)) == null) {
            if (arrayList == null || arrayList.size() == 0) {
                return false;
            }
            if (arrayList.size() > 9) {
                SLog.i("QQEMOTION", "isLegality -->illegal, file count > 9, count = " + arrayList.size());
                return false;
            }
            long j = 0;
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                String a2 = l.a(context, arrayList.get(i2));
                long j2 = l.j(a2);
                if (j2 > 1048576) {
                    SLog.i("QQEMOTION", "isLegality -->illegal, fileSize: " + j2 + "， path =" + a2);
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
        return invokeLL.booleanValue;
    }

    public void setEmotions(Activity activity, ArrayList<Uri> arrayList, IUiListener iUiListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, activity, arrayList, iUiListener) == null) {
            IUiListener iUiListener2 = this.f69929a;
            if (iUiListener2 != null) {
                iUiListener2.onCancel();
            }
            this.f69929a = iUiListener;
            if (!i.b(activity)) {
                Toast.makeText(activity.getApplicationContext(), "当前手机未安装QQ，请安装最新版QQ后再试。", 1).show();
            } else if (i.c(activity, "8.0.0") < 0) {
                Toast.makeText(activity.getApplicationContext(), "当前手机QQ版本过低，不支持设置表情功能。", 1).show();
            } else if (!a(activity.getApplicationContext(), arrayList)) {
                Toast.makeText(activity.getApplicationContext(), "图片不符合要求，不支持设置表情功能。", 1).show();
            } else {
                String a2 = l.a(activity);
                StringBuffer stringBuffer = new StringBuffer("mqqapi://profile/sdk_face_collection?");
                if (!TextUtils.isEmpty(a2)) {
                    if (a2.length() > 20) {
                        a2 = a2.substring(0, 20) + "...";
                    }
                    stringBuffer.append("&app_name=" + Base64.encodeToString(l.i(a2), 2));
                }
                String appId = this.f69920c.getAppId();
                String openId = this.f69920c.getOpenId();
                if (!TextUtils.isEmpty(appId)) {
                    stringBuffer.append("&share_id=" + appId);
                }
                if (!TextUtils.isEmpty(openId)) {
                    stringBuffer.append("&open_id=" + Base64.encodeToString(l.i(openId), 2));
                }
                stringBuffer.append("&sdk_version=" + Base64.encodeToString(l.i(Constants.SDK_VERSION), 2));
                String a3 = a(arrayList);
                if (!TextUtils.isEmpty(a3)) {
                    stringBuffer.append("&set_uri_list=" + a3);
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

    private String a(ArrayList<Uri> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, arrayList)) == null) {
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                sb.append(arrayList.get(i2));
                sb.append(";");
            }
            String sb2 = sb.toString();
            SLog.i("QQEMOTION", "-->getFilePathListJson listStr : " + sb2);
            return Base64.encodeToString(l.i(sb2), 2);
        }
        return (String) invokeL.objValue;
    }
}
