package com.tencent.open.im;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.auth.c;
import com.tencent.connect.common.BaseApi;
import com.tencent.open.TDialog;
import com.tencent.open.utils.l;
/* loaded from: classes3.dex */
public class IM extends BaseApi {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CHAT_TYPE_AIO = "thirdparty2c";
    public static final String CHAT_TYPE_AUDIO_CHAT = "audio_chat";
    public static final String CHAT_TYPE_VIDEO_CHAT = "video_chat";
    public static final int IM_LENGTH_SHORT = -3;
    public static final int IM_SHOULD_DOWNLOAD = -2;
    public static final int IM_SUCCESS = 0;
    public static final int IM_UIN_EMPTY = -1;
    public static final int IM_UIN_NOT_DIGIT = -4;
    public static final int IM_UNKNOWN_TYPE = -5;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IM(Context context, c cVar, QQToken qQToken) {
        super(cVar, qQToken);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, cVar, qQToken};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((c) objArr2[0], (QQToken) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public int startIMConversation(Activity activity, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, activity, str, str2, str3)) == null) {
            if (str != null) {
                if (str.equals(CHAT_TYPE_AIO) || str.equals(CHAT_TYPE_AUDIO_CHAT) || str.equals(CHAT_TYPE_VIDEO_CHAT)) {
                    if (!str.equals(CHAT_TYPE_AUDIO_CHAT)) {
                        str.equals(CHAT_TYPE_VIDEO_CHAT);
                    }
                    if (TextUtils.isEmpty(str2)) {
                        return -1;
                    }
                    if (str2.length() < 5) {
                        return -3;
                    }
                    for (int i2 = 0; i2 < str2.length(); i2++) {
                        if (!Character.isDigit(str2.charAt(i2))) {
                            return -4;
                        }
                    }
                    if (l.d(activity)) {
                        Intent intent = new Intent("android.intent.action.VIEW");
                        intent.setData(Uri.parse(String.format("mqqapi://im/chat?chat_type=%1$s&uin=%2$s&version=1&src_type=app&open_id=%3$s&app_id=%4$s&app_pkg_name=%5$s", str, str2, l.l(this.f62219c.getOpenId()), l.l(this.f62219c.getAppId()), l.l(str3))));
                        intent.putExtra(EmotionResourceInfo.JSON_KEY_PKG_NAME, str3);
                        activity.startActivity(intent);
                        return 0;
                    }
                    try {
                        new TDialog(activity, "", a(""), null, this.f62219c).show();
                        return -2;
                    } catch (RuntimeException e2) {
                        e2.printStackTrace();
                        return -2;
                    }
                }
                return -5;
            }
            return -5;
        }
        return invokeLLLL.intValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IM(Context context, QQToken qQToken) {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IM(QQToken qQToken) {
        super(qQToken);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qQToken};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((QQToken) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }
}
