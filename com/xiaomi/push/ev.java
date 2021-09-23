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
/* loaded from: classes10.dex */
public final class ev {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final ev f77902a;

    /* renamed from: a  reason: collision with other field name */
    public static final /* synthetic */ ev[] f343a;

    /* renamed from: b  reason: collision with root package name */
    public static final ev f77903b;

    /* renamed from: c  reason: collision with root package name */
    public static final ev f77904c;

    /* renamed from: d  reason: collision with root package name */
    public static final ev f77905d;

    /* renamed from: e  reason: collision with root package name */
    public static final ev f77906e;

    /* renamed from: f  reason: collision with root package name */
    public static final ev f77907f;

    /* renamed from: g  reason: collision with root package name */
    public static final ev f77908g;

    /* renamed from: h  reason: collision with root package name */
    public static final ev f77909h;

    /* renamed from: i  reason: collision with root package name */
    public static final ev f77910i;

    /* renamed from: j  reason: collision with root package name */
    public static final ev f77911j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public final String f344a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56375377, "Lcom/xiaomi/push/ev;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56375377, "Lcom/xiaomi/push/ev;");
                return;
            }
        }
        f77902a = new ev("COMMAND_REGISTER", 0, "register");
        f77903b = new ev("COMMAND_UNREGISTER", 1, "unregister");
        f77904c = new ev("COMMAND_SET_ALIAS", 2, MiPushClient.COMMAND_SET_ALIAS);
        f77905d = new ev("COMMAND_UNSET_ALIAS", 3, MiPushClient.COMMAND_UNSET_ALIAS);
        f77906e = new ev("COMMAND_SET_ACCOUNT", 4, MiPushClient.COMMAND_SET_ACCOUNT);
        f77907f = new ev("COMMAND_UNSET_ACCOUNT", 5, MiPushClient.COMMAND_UNSET_ACCOUNT);
        f77908g = new ev("COMMAND_SUBSCRIBE_TOPIC", 6, MiPushClient.COMMAND_SUBSCRIBE_TOPIC);
        f77909h = new ev("COMMAND_UNSUBSCRIBE_TOPIC", 7, MiPushClient.COMMAND_UNSUBSCRIBE_TOPIC);
        f77910i = new ev("COMMAND_SET_ACCEPT_TIME", 8, MiPushClient.COMMAND_SET_ACCEPT_TIME);
        ev evVar = new ev("COMMAND_CHK_VDEVID", 9, "check-vdeviceid");
        f77911j = evVar;
        f343a = new ev[]{f77902a, f77903b, f77904c, f77905d, f77906e, f77907f, f77908g, f77909h, f77910i, evVar};
    }

    public ev(String str, int i2, String str2) {
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
        this.f344a = str2;
    }

    public static int a(String str) {
        InterceptResult invokeL;
        ev[] values;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            int i2 = -1;
            if (TextUtils.isEmpty(str)) {
                return -1;
            }
            for (ev evVar : values()) {
                if (evVar.f344a.equals(str)) {
                    i2 = ek.a(evVar);
                }
            }
            return i2;
        }
        return invokeL.intValue;
    }

    public static ev valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (ev) Enum.valueOf(ev.class, str) : (ev) invokeL.objValue;
    }

    public static ev[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (ev[]) f343a.clone() : (ev[]) invokeV.objValue;
    }
}
