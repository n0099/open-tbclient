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
import com.vivo.push.model.InsideNotificationItem;
/* loaded from: classes4.dex */
public final class h implements BaseNotifyDataAdapter {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static int f60749e;

    /* renamed from: f  reason: collision with root package name */
    public static int f60750f;
    public transient /* synthetic */ FieldHolder $fh;
    public Resources a;

    /* renamed from: b  reason: collision with root package name */
    public String f60751b;

    /* renamed from: c  reason: collision with root package name */
    public String f60752c;

    /* renamed from: d  reason: collision with root package name */
    public String f60753d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(744178356, "Lcom/vivo/push/util/h;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(744178356, "Lcom/vivo/push/util/h;");
        }
    }

    public h() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static boolean a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) ? (i2 == -1 || i2 == 0) ? false : true : invokeI.booleanValue;
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (Build.VERSION.SDK_INT < 26) {
                return false;
            }
            if (TextUtils.isEmpty(str)) {
                p.d("DefaultNotifyDataAdapter", "systemVersion is not suit ");
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final int getDefaultNotifyIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (a(f60749e)) {
                return f60749e;
            }
            String str = this.f60753d;
            int a = !a(str) ? -1 : a(str, "_notifyicon");
            f60749e = a;
            if (a(a)) {
                return f60749e;
            }
            for (String str2 = this.f60752c; !TextUtils.isEmpty(str2); str2 = str2.substring(0, str2.length() - 1)) {
                Resources resources = this.a;
                int identifier = resources.getIdentifier("vivo_push_rom" + str2 + "_notifyicon", "drawable", this.f60751b);
                if (identifier > 0) {
                    return identifier;
                }
            }
            return this.a.getIdentifier("vivo_push_notifyicon", "drawable", this.f60751b);
        }
        return invokeV.intValue;
    }

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final int getDefaultSmallIconId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (a(f60750f)) {
                return f60750f;
            }
            String str = this.f60753d;
            int a = !a(str) ? -1 : a(str, "_icon");
            f60750f = a;
            if (a(a)) {
                return f60750f;
            }
            for (String str2 = this.f60752c; !TextUtils.isEmpty(str2); str2 = str2.substring(0, str2.length() - 1)) {
                Resources resources = this.a;
                int identifier = resources.getIdentifier("vivo_push_rom" + str2 + "_icon", "drawable", this.f60751b);
                if (identifier > 0) {
                    return identifier;
                }
            }
            return this.a.getIdentifier("vivo_push_icon", "drawable", this.f60751b);
        }
        return invokeV.intValue;
    }

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final int getNotifyMode(InsideNotificationItem insideNotificationItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, insideNotificationItem)) == null) ? Build.VERSION.SDK_INT >= 21 ? 2 : 1 : invokeL.intValue;
    }

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            this.f60751b = context.getPackageName();
            this.a = context.getResources();
            this.f60752c = j.a();
            this.f60753d = Build.VERSION.RELEASE;
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
                        p.c("DefaultNotifyDataAdapter", "get notify icon : ".concat(String.valueOf(str3)));
                        int identifier = this.a.getIdentifier(str3, "drawable", this.f60751b);
                        if (identifier > 0) {
                            p.c("DefaultNotifyDataAdapter", "find notify icon : ".concat(String.valueOf(str3)));
                            return identifier;
                        }
                    }
                } catch (Exception e2) {
                    p.a("DefaultNotifyDataAdapter", e2);
                }
            }
            return -1;
        }
        return invokeLL.intValue;
    }
}
