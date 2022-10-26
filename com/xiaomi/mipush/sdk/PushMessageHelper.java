package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.hw;
import com.xiaomi.push.im;
import java.util.List;
/* loaded from: classes8.dex */
public class PushMessageHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ERROR_MESSAGE = "error_message";
    public static final String ERROR_TYPE = "error_type";
    public static final String ERROR_TYPE_NEED_PERMISSION = "error_lack_of_permission";
    public static final String KEY_COMMAND = "key_command";
    public static final String KEY_MESSAGE = "key_message";
    public static final int MESSAGE_COMMAND = 3;
    public static final int MESSAGE_ERROR = 5;
    public static final int MESSAGE_QUIT = 4;
    public static final int MESSAGE_RAW = 1;
    public static final int MESSAGE_SENDMESSAGE = 2;
    public static final String MESSAGE_TYPE = "message_type";
    public static final int PUSH_MODE_BROADCAST = 2;
    public static final int PUSH_MODE_CALLBACK = 1;
    public static int pushMode;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1738568876, "Lcom/xiaomi/mipush/sdk/PushMessageHelper;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1738568876, "Lcom/xiaomi/mipush/sdk/PushMessageHelper;");
        }
    }

    public PushMessageHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static MiPushCommandMessage generateCommandMessage(String str, List list, long j, String str2, String str3, List list2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{str, list, Long.valueOf(j), str2, str3, list2})) == null) {
            MiPushCommandMessage miPushCommandMessage = new MiPushCommandMessage();
            miPushCommandMessage.setCommand(str);
            miPushCommandMessage.setCommandArguments(list);
            miPushCommandMessage.setResultCode(j);
            miPushCommandMessage.setReason(str2);
            miPushCommandMessage.setCategory(str3);
            miPushCommandMessage.setAutoMarkPkgs(list2);
            return miPushCommandMessage;
        }
        return (MiPushCommandMessage) invokeCommon.objValue;
    }

    public static MiPushMessage generateMessage(im imVar, hw hwVar, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65539, null, imVar, hwVar, z)) == null) {
            MiPushMessage miPushMessage = new MiPushMessage();
            miPushMessage.setMessageId(imVar.m503a());
            if (!TextUtils.isEmpty(imVar.d())) {
                miPushMessage.setMessageType(1);
                miPushMessage.setAlias(imVar.d());
            } else if (!TextUtils.isEmpty(imVar.c())) {
                miPushMessage.setMessageType(2);
                miPushMessage.setTopic(imVar.c());
            } else if (TextUtils.isEmpty(imVar.f())) {
                miPushMessage.setMessageType(0);
            } else {
                miPushMessage.setMessageType(3);
                miPushMessage.setUserAccount(imVar.f());
            }
            miPushMessage.setCategory(imVar.e());
            if (imVar.a() != null) {
                miPushMessage.setContent(imVar.a().c());
            }
            if (hwVar != null) {
                if (TextUtils.isEmpty(miPushMessage.getMessageId())) {
                    miPushMessage.setMessageId(hwVar.m431a());
                }
                if (TextUtils.isEmpty(miPushMessage.getTopic())) {
                    miPushMessage.setTopic(hwVar.m436b());
                }
                miPushMessage.setDescription(hwVar.d());
                miPushMessage.setTitle(hwVar.m439c());
                miPushMessage.setNotifyType(hwVar.a());
                miPushMessage.setNotifyId(hwVar.c());
                miPushMessage.setPassThrough(hwVar.b());
                miPushMessage.setExtra(hwVar.m432a());
            }
            miPushMessage.setNotified(z);
            return miPushMessage;
        }
        return (MiPushMessage) invokeLLZ.objValue;
    }

    public static hw generateMessage(MiPushMessage miPushMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, miPushMessage)) == null) {
            hw hwVar = new hw();
            hwVar.a(miPushMessage.getMessageId());
            hwVar.b(miPushMessage.getTopic());
            hwVar.d(miPushMessage.getDescription());
            hwVar.c(miPushMessage.getTitle());
            hwVar.c(miPushMessage.getNotifyId());
            hwVar.a(miPushMessage.getNotifyType());
            hwVar.b(miPushMessage.getPassThrough());
            hwVar.a(miPushMessage.getExtra());
            return hwVar;
        }
        return (hw) invokeL.objValue;
    }

    public static int getPushMode(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            if (pushMode == 0) {
                setPushMode(isUseCallbackPushMode(context) ? 1 : 2);
            }
            return pushMode;
        }
        return invokeL.intValue;
    }

    public static boolean isIntentAvailable(Context context, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, context, intent)) == null) {
            try {
                List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 32);
                if (queryBroadcastReceivers != null) {
                    if (!queryBroadcastReceivers.isEmpty()) {
                        return true;
                    }
                }
                return false;
            } catch (Exception unused) {
                return true;
            }
        }
        return invokeLL.booleanValue;
    }

    public static boolean isUseCallbackPushMode(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
            intent.setClassName(context.getPackageName(), "com.xiaomi.mipush.sdk.PushServiceReceiver");
            return isIntentAvailable(context, intent);
        }
        return invokeL.booleanValue;
    }

    public static void sendCommandMessageBroadcast(Context context, MiPushCommandMessage miPushCommandMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, context, miPushCommandMessage) == null) {
            Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
            intent.setPackage(context.getPackageName());
            intent.putExtra(MESSAGE_TYPE, 3);
            intent.putExtra(KEY_COMMAND, miPushCommandMessage);
            new PushServiceReceiver().onReceive(context, intent);
        }
    }

    public static void sendQuitMessageBroadcast(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, context) == null) {
            Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
            intent.setPackage(context.getPackageName());
            intent.putExtra(MESSAGE_TYPE, 4);
            new PushServiceReceiver().onReceive(context, intent);
        }
    }

    public static void setPushMode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65546, null, i) == null) {
            pushMode = i;
        }
    }
}
