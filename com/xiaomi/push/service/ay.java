package com.xiaomi.push.service;

import android.app.Notification;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
/* loaded from: classes8.dex */
public class ay {
    public static /* synthetic */ Interceptable $ic;
    public static final a a;

    /* renamed from: a  reason: collision with other field name */
    public static String f917a;

    /* renamed from: a  reason: collision with other field name */
    public static final String[] f918a;
    public static final a b;
    public static final a c;
    public static final a d;
    public static final a e;
    public static final a f;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Object a;
        public Object b;
        public Object c;

        public a(Object obj, Object obj2, Object obj3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {obj, obj2, obj3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = obj;
            this.b = obj2;
            this.c = obj3;
        }

        public /* synthetic */ a(Object obj, Object obj2, Object obj3, az azVar) {
            this(obj, obj2, obj3);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1071162798, "Lcom/xiaomi/push/service/ay;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1071162798, "Lcom/xiaomi/push/service/ay;");
                return;
            }
        }
        f918a = new String[]{"com.mi.globalbrowser", "com.android.browser"};
        f917a = null;
        a = new a("setSound", "canSound", "canSound", null);
        b = new a("setVibrate", "canVibrate", "canVibrate", null);
        c = new a("setLights", "canLights", "canLights", null);
        d = new a("setShowOnKeyguard", "canShowOnKeyguard", "canShowOnKeyguard", null);
        e = new a("setFloat", "canFloat", "canShowFloat", null);
        f = new a("setShowBadge", "canShowBadge", "canShowBadge", null);
    }

    public static int a(ContentResolver contentResolver) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, contentResolver)) == null) {
            try {
                return Settings.Global.getInt(contentResolver, "user_aggregate", 0);
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.m89a("get user aggregate failed, " + e2);
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public static int a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) ? com.xiaomi.push.h.b(context, str) : invokeLL.intValue;
    }

    public static int a(Context context, String str, String str2, a aVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65539, null, context, str, str2, aVar)) == null) {
            if (aVar != null) {
                try {
                    Bundle a2 = a(context, (String) aVar.b, str, str2, (Bundle) null);
                    if (a2 == null || !a2.containsKey((String) aVar.c)) {
                        return -1;
                    }
                    return a2.getBoolean((String) aVar.c) ? 1 : 0;
                } catch (Exception unused) {
                    return -1;
                }
            }
            return -1;
        }
        return invokeLLLL.intValue;
    }

    public static Bundle a(Context context, String str, String str2, String str3, Bundle bundle) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str, str2, str3, bundle)) == null) {
            if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                throw new IllegalArgumentException("call notification provider failed!");
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString("package", str2);
            if (!TextUtils.isEmpty(str3)) {
                bundle2.putString("channel_id", str3);
            }
            if (bundle != null) {
                bundle2.putAll(bundle);
            }
            return context.getContentResolver().call(Uri.parse("content://statusbar.notification"), str, (String) null, bundle2);
        }
        return (Bundle) invokeLLLLL.objValue;
    }

    public static Object a(Notification notification, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, notification, str)) == null) {
            Bundle bundle = notification.extras;
            if (bundle != null) {
                try {
                    return bundle.get(str);
                } catch (Exception unused) {
                    return null;
                }
            }
            return null;
        }
        return invokeLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Object a(Object obj, String str, Object obj2) {
        InterceptResult invokeLLL;
        Object obj3;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLL = interceptable.invokeLLL(65542, null, obj, str, obj2)) != null) {
            return invokeLLL.objValue;
        }
        Object obj4 = null;
        try {
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m89a("get value error " + e2);
        }
        if (obj instanceof Notification) {
            obj3 = a((Notification) obj, str);
        } else if (obj instanceof Map) {
            obj3 = ((Map) obj).get(str);
        } else if (!(obj instanceof Bundle)) {
            com.xiaomi.channel.commonutils.logger.b.m89a("not support get value from classType:" + obj);
            return obj4 != null ? obj2 : obj4;
        } else {
            obj3 = ((Bundle) obj).get(str);
        }
        obj4 = obj3;
        if (obj4 != null) {
        }
    }

    public static String a(Notification notification) {
        InterceptResult invokeL;
        CharSequence charSequence;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, notification)) == null) {
            Bundle bundle = notification.extras;
            if (bundle != null) {
                charSequence = bundle.getCharSequence(NotificationCompat.EXTRA_TITLE);
                if (TextUtils.isEmpty(charSequence)) {
                    charSequence = notification.extras.getCharSequence(NotificationCompat.EXTRA_TITLE_BIG);
                }
                if (TextUtils.isEmpty(charSequence)) {
                    charSequence = notification.extras.getCharSequence("mipush.customTitle");
                }
            } else {
                charSequence = null;
            }
            return charSequence != null ? charSequence.toString() : "";
        }
        return (String) invokeL.objValue;
    }

    public static String a(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, obj)) == null) ? (String) a(obj, "msg_busi_type", "") : (String) invokeL.objValue;
    }

    public static void a(Notification notification, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65545, null, notification, i) == null) {
            try {
                if (notification.extras != null) {
                    notification.extras.putInt("miui.messageCount", i);
                }
                Object a2 = com.xiaomi.push.bk.a(notification, "extraNotification");
                if (a2 != null) {
                    com.xiaomi.push.bk.a(a2, "setMessageCount", Integer.valueOf(i));
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void a(Notification notification, int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(65546, null, notification, i, i2) == null) || notification == null) {
            return;
        }
        if (notification.extras == null) {
            notification.extras = new Bundle();
        }
        notification.extras.putInt("is_priority", i);
        notification.extras.putInt("mipush_class", i2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m632a(Notification notification, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, notification, str) == null) {
            try {
                if (notification.extras != null) {
                    notification.extras.putString("target_package", str);
                }
                Object a2 = com.xiaomi.push.bk.a(notification, "extraNotification");
                if (a2 != null) {
                    com.xiaomi.push.bk.a(a2, "setTargetPkg", str);
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void a(Notification notification, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65548, null, notification, z) == null) {
            try {
                if (notification.extras != null) {
                    notification.extras.putBoolean("miui.enableFloat", z);
                }
                Object a2 = com.xiaomi.push.bk.a(notification, "extraNotification");
                if (a2 != null) {
                    com.xiaomi.push.bk.a(a2, "setEnableFloat", Boolean.valueOf(z));
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void a(Context context, String str, Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65549, null, context, str, intent) == null) || intent == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(str);
        }
        arrayList.addAll(Arrays.asList(f918a));
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            String str2 = (String) arrayList.get(i);
            if (!TextUtils.isEmpty(str2)) {
                Intent intent2 = new Intent(intent);
                intent2.setPackage(str2);
                try {
                    if (context.getPackageManager().resolveActivity(intent2, 65536) != null) {
                        intent.setPackage(str2);
                        break;
                    }
                    continue;
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.m89a("can't match url intent. " + e2);
                }
            }
        }
        intent.setPackage(intent.getPackage());
    }

    public static void a(Map map, Bundle bundle, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65550, null, map, bundle, str) == null) {
            if (map == null || bundle == null || TextUtils.isEmpty(str)) {
                com.xiaomi.channel.commonutils.logger.b.m89a("cp map to b fail:" + str);
            } else if (TextUtils.isEmpty((String) map.get(str))) {
                bundle.remove(str);
            } else {
                bundle.putString(str, (String) map.get(str));
            }
        }
    }

    public static boolean a(Notification.Builder builder, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65551, null, builder, z)) == null) {
            if (Build.VERSION.SDK_INT >= 26) {
                builder.setGroupAlertBehavior(z ? 2 : 1);
                return true;
            }
            com.xiaomi.channel.commonutils.logger.b.b("not support setGroupAlertBehavior");
            return false;
        }
        return invokeLZ.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m633a(ContentResolver contentResolver) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, contentResolver)) == null) {
            int a2 = a(contentResolver);
            return a2 == 1 || a2 == 2;
        }
        return invokeL.booleanValue;
    }

    public static boolean a(Context context, String str, String str2, a aVar, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65553, null, new Object[]{context, str, str2, aVar, Boolean.valueOf(z)})) == null) {
            if (aVar != null) {
                try {
                    Bundle bundle = new Bundle();
                    bundle.putBoolean((String) aVar.c, z);
                    a(context, (String) aVar.a, str, str2, bundle);
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean a(Map map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65554, null, map)) == null) ? Boolean.parseBoolean((String) a(map, "not_suppress", "true")) : invokeL.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static Notification.Action[] m634a(Notification notification) {
        InterceptResult invokeL;
        Parcelable[] parcelableArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, notification)) == null) {
            Notification.Action[] actionArr = notification.actions;
            if (actionArr != null) {
                return actionArr;
            }
            Bundle bundle = notification.extras;
            if (bundle == null || (parcelableArray = bundle.getParcelableArray("mipush.customActions")) == null) {
                return null;
            }
            return (Notification.Action[]) Arrays.copyOf(parcelableArray, parcelableArray.length, Notification.Action[].class);
        }
        return (Notification.Action[]) invokeL.objValue;
    }

    public static String b(Notification notification) {
        InterceptResult invokeL;
        CharSequence charSequence;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, notification)) == null) {
            Bundle bundle = notification.extras;
            if (bundle != null) {
                charSequence = bundle.getCharSequence(NotificationCompat.EXTRA_TEXT);
                if (TextUtils.isEmpty(charSequence) && Build.VERSION.SDK_INT >= 21) {
                    charSequence = notification.extras.getCharSequence(NotificationCompat.EXTRA_BIG_TEXT);
                }
                if (TextUtils.isEmpty(charSequence)) {
                    charSequence = notification.extras.getCharSequence("mipush.customContent");
                }
            } else {
                charSequence = null;
            }
            return charSequence != null ? charSequence.toString() : "";
        }
        return (String) invokeL.objValue;
    }

    public static void b(Notification notification, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65557, null, notification, z) == null) {
            try {
                if (notification.extras != null) {
                    notification.extras.putBoolean("miui.enableKeyguard", z);
                }
                Object a2 = com.xiaomi.push.bk.a(notification, "extraNotification");
                if (a2 != null) {
                    com.xiaomi.push.bk.a(a2, "setEnableKeyguard", Boolean.valueOf(z));
                }
            } catch (Exception unused) {
            }
        }
    }

    public static String c(Notification notification) {
        InterceptResult invokeL;
        Object a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, notification)) == null) {
            try {
                r0 = notification.extras != null ? notification.extras.getString("target_package") : null;
                return (!TextUtils.isEmpty(r0) || (a2 = com.xiaomi.push.bk.a(notification, "extraNotification")) == null) ? r0 : (String) com.xiaomi.push.bk.a(a2, "getTargetPkg", new Object[0]);
            } catch (Exception unused) {
                return r0;
            }
        }
        return (String) invokeL.objValue;
    }
}
