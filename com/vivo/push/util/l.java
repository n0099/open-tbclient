package com.vivo.push.util;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sina.weibo.sdk.utils.ResourceManager;
import com.vivo.push.model.InsideNotificationItem;
/* loaded from: classes8.dex */
public final class l implements BaseNotifyDataAdapter {
    public static /* synthetic */ Interceptable $ic;
    public static int e;
    public static int f;
    public transient /* synthetic */ FieldHolder $fh;
    public Resources a;
    public String b;
    public String c;
    public String d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(744178480, "Lcom/vivo/push/util/l;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(744178480, "Lcom/vivo/push/util/l;");
        }
    }

    public static boolean a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) ? (i == -1 || i == 0) ? false : true : invokeI.booleanValue;
    }

    public l() {
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

    private int a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, str, str2)) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                String[] split = str.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
                if (split != null && split.length > 0) {
                    str = split[0];
                }
                try {
                    for (int parseInt = Integer.parseInt(str); parseInt > 0; parseInt--) {
                        String str3 = "vivo_push_ard" + parseInt + str2;
                        u.c("DefaultNotifyDataAdapter", "get notify icon : ".concat(String.valueOf(str3)));
                        int identifier = this.a.getIdentifier(str3, ResourceManager.DRAWABLE, this.b);
                        if (identifier > 0) {
                            u.c("DefaultNotifyDataAdapter", "find notify icon : ".concat(String.valueOf(str3)));
                            return identifier;
                        }
                    }
                } catch (Exception e2) {
                    u.a("DefaultNotifyDataAdapter", e2);
                }
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (Build.VERSION.SDK_INT < 26) {
                return false;
            }
            if (TextUtils.isEmpty(str)) {
                u.d("DefaultNotifyDataAdapter", "systemVersion is not suit ");
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final int getNotifyMode(InsideNotificationItem insideNotificationItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, insideNotificationItem)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return 2;
            }
            return 1;
        }
        return invokeL.intValue;
    }

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            this.b = context.getPackageName();
            this.a = context.getResources();
            this.c = n.a();
            this.d = Build.VERSION.RELEASE;
        }
    }

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final int getDefaultNotifyIcon() {
        InterceptResult invokeV;
        int a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (a(e)) {
                return e;
            }
            String str = this.d;
            if (!a(str)) {
                a = -1;
            } else {
                a = a(str, "_notifyicon");
            }
            e = a;
            if (a(a)) {
                return e;
            }
            for (String str2 = this.c; !TextUtils.isEmpty(str2); str2 = str2.substring(0, str2.length() - 1)) {
                Resources resources = this.a;
                int identifier = resources.getIdentifier("vivo_push_rom" + str2 + "_notifyicon", ResourceManager.DRAWABLE, this.b);
                if (identifier > 0) {
                    return identifier;
                }
            }
            return this.a.getIdentifier("vivo_push_notifyicon", ResourceManager.DRAWABLE, this.b);
        }
        return invokeV.intValue;
    }

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final int getDefaultSmallIconId() {
        InterceptResult invokeV;
        int a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (a(f)) {
                return f;
            }
            String str = this.d;
            if (!a(str)) {
                a = -1;
            } else {
                a = a(str, "_icon");
            }
            f = a;
            if (a(a)) {
                return f;
            }
            for (String str2 = this.c; !TextUtils.isEmpty(str2); str2 = str2.substring(0, str2.length() - 1)) {
                Resources resources = this.a;
                int identifier = resources.getIdentifier("vivo_push_rom" + str2 + "_icon", ResourceManager.DRAWABLE, this.b);
                if (identifier > 0) {
                    return identifier;
                }
            }
            return this.a.getIdentifier("vivo_push_icon", ResourceManager.DRAWABLE, this.b);
        }
        return invokeV.intValue;
    }
}
