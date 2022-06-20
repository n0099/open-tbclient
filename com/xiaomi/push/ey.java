package com.xiaomi.push;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.mipush.sdk.MiPushClient;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes8.dex */
public final class ey {
    public static /* synthetic */ Interceptable $ic;
    public static final ey a;

    /* renamed from: a  reason: collision with other field name */
    public static final /* synthetic */ ey[] f325a;
    public static final ey b;
    public static final ey c;
    public static final ey d;
    public static final ey e;
    public static final ey f;
    public static final ey g;
    public static final ey h;
    public static final ey i;
    public static final ey j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public final String f326a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56375284, "Lcom/xiaomi/push/ey;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56375284, "Lcom/xiaomi/push/ey;");
                return;
            }
        }
        a = new ey("COMMAND_REGISTER", 0, MiPushClient.COMMAND_REGISTER);
        b = new ey("COMMAND_UNREGISTER", 1, MiPushClient.COMMAND_UNREGISTER);
        c = new ey("COMMAND_SET_ALIAS", 2, MiPushClient.COMMAND_SET_ALIAS);
        d = new ey("COMMAND_UNSET_ALIAS", 3, MiPushClient.COMMAND_UNSET_ALIAS);
        e = new ey("COMMAND_SET_ACCOUNT", 4, MiPushClient.COMMAND_SET_ACCOUNT);
        f = new ey("COMMAND_UNSET_ACCOUNT", 5, MiPushClient.COMMAND_UNSET_ACCOUNT);
        g = new ey("COMMAND_SUBSCRIBE_TOPIC", 6, MiPushClient.COMMAND_SUBSCRIBE_TOPIC);
        h = new ey("COMMAND_UNSUBSCRIBE_TOPIC", 7, MiPushClient.COMMAND_UNSUBSCRIBE_TOPIC);
        i = new ey("COMMAND_SET_ACCEPT_TIME", 8, MiPushClient.COMMAND_SET_ACCEPT_TIME);
        ey eyVar = new ey("COMMAND_CHK_VDEVID", 9, "check-vdeviceid");
        j = eyVar;
        f325a = new ey[]{a, b, c, d, e, f, g, h, i, eyVar};
    }

    public ey(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str3 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f326a = str2;
    }

    public static int a(String str) {
        InterceptResult invokeL;
        ey[] values;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            int i2 = -1;
            if (TextUtils.isEmpty(str)) {
                return -1;
            }
            for (ey eyVar : values()) {
                if (eyVar.f326a.equals(str)) {
                    i2 = en.a(eyVar);
                }
            }
            return i2;
        }
        return invokeL.intValue;
    }

    public static ey valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (ey) Enum.valueOf(ey.class, str) : (ey) invokeL.objValue;
    }

    public static ey[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (ey[]) f325a.clone() : (ey[]) invokeV.objValue;
    }
}
