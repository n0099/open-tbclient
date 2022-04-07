package com.repackage;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.performance.speed.SpeedRuntimeProvider;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
/* loaded from: classes6.dex */
public class ks4 {
    public static /* synthetic */ Interceptable $ic = null;
    public static SharedPreferences a = null;
    public static boolean b = false;
    public static String c = null;
    public static int d = 0;
    public static String e = null;
    public static int f = 99;
    public static int g = -1;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755548315, "Lcom/repackage/ks4;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755548315, "Lcom/repackage/ks4;");
        }
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            h(TbadkCoreApplication.getInst());
            i();
            c("c14483", 0, g >= 1 ? 2 : 1);
        }
    }

    public static void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, context) == null) {
            if (g < 0) {
                g = context.getSharedPreferences("settings", 0).getInt("app_restart_times", 0);
            }
            h(context);
            d("c14429", 1, g < 1 ? 1 : 2);
        }
    }

    public static void c(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65539, null, str, i, i2) == null) {
            Set<String> stringSet = a.getStringSet(str, null);
            if (stringSet == null) {
                stringSet = new HashSet<>();
            }
            stringSet.add(String.format(Locale.CHINA, "%d_%d_%d", Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(System.currentTimeMillis())));
            SharedPreferences.Editor edit = a.edit();
            edit.putStringSet(str, stringSet);
            edit.commit();
        }
    }

    public static void d(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i, i2) == null) {
            String str2 = str + "_lastTime";
            long j = a.getLong(str2, 0L);
            long currentTimeMillis = System.currentTimeMillis();
            Set<String> stringSet = a.getStringSet(str, null);
            if (stringSet == null) {
                stringSet = new HashSet<>();
            }
            stringSet.add(String.format(Locale.CHINA, "%d_%d_%d_%d", Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(currentTimeMillis), Long.valueOf(currentTimeMillis - j)));
            SharedPreferences.Editor edit = a.edit();
            edit.putStringSet(str, stringSet);
            edit.putLong(str2, currentTimeMillis);
            edit.commit();
        }
    }

    @NonNull
    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (f != 99) {
                return StringUtils.isNull(e) ? "" : e;
            }
            String c2 = m55.c();
            return ni.isEmpty(c2) ? "" : c2;
        }
        return (String) invokeV.objValue;
    }

    public static int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            i();
            return g;
        }
        return invokeV.intValue;
    }

    public static String g(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, intent)) == null) {
            String dataString = intent.getDataString();
            if (dataString == null || !dataString.startsWith("custom")) {
                return dataString;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(dataString);
            sb.append(".action.");
            sb.append(intent.getAction());
            if (intent.getCategories() != null) {
                sb.append("categories.");
                for (String str : intent.getCategories()) {
                    sb.append(str);
                    sb.append(".");
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static void h(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65544, null, context) == null) && a == null) {
            a = context.getSharedPreferences("growth_funnel_sp", 0);
        }
    }

    public static void i() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65545, null) == null) || g >= 0) {
            return;
        }
        g = wt4.k().l("app_restart_times", 0);
    }

    public static void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            i();
            TiebaStatic.log(new StatisticItem("c14484").addParam("obj_source", g >= 1 ? 2 : 1).addParam(TiebaStatic.Params.OBJ_PARAM3, System.currentTimeMillis()));
        }
    }

    public static void k(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65547, null, j) == null) {
            i();
            TiebaStatic.log(new StatisticItem("c14429").addParam("obj_type", 2).addParam("obj_source", g < 1 ? 1 : 2).addParam(TiebaStatic.Params.OBJ_PARAM2, j));
        }
    }

    public static void l(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65548, null, str, z) == null) {
            i();
            TiebaStatic.log(new StatisticItem("c14430").addParam("obj_type", z ? 2 : 1).addParam("obj_source", g < 1 ? 1 : 2).addParam("obj_param1", PermissionUtil.isAgreePrivacyPolicy() ? 1 : 2).addParam(TiebaStatic.Params.OBJ_PARAM2, str));
        }
    }

    public static void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, null) == null) {
            TiebaStatic.log(new StatisticItem("c14579").addParam("obj_type", ms4.a().b()).addParam("obj_param1", ms4.a().d() ? 1 : 2).addParam("obj_source", 5));
        }
    }

    public static void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, null) == null) {
            TiebaStatic.log(new StatisticItem("c14579").addParam("obj_type", ms4.a().b()).addParam("obj_param1", ms4.a().d() ? 1 : 2).addParam("obj_source", 6));
        }
    }

    public static void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, str) == null) {
            StatisticItem addParam = new StatisticItem("c14579").addParam("obj_locate", str).addParam("obj_type", ms4.a().b()).addParam("obj_param1", ms4.a().d() ? 1 : 2).addParam("obj_source", 8);
            if (ms4.a().b() != 3) {
                addParam.addParam(TiebaStatic.Params.OBJ_PARAM2, e());
            }
            TiebaStatic.log(addParam);
        }
    }

    public static void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, str) == null) {
            StatisticItem addParam = new StatisticItem("c14579").addParam("obj_locate", str).addParam("obj_type", ms4.a().b()).addParam("obj_param1", ms4.a().d() ? 1 : 2).addParam("obj_source", 7);
            if (ms4.a().b() != 3) {
                addParam.addParam(TiebaStatic.Params.OBJ_PARAM2, e());
            }
            TiebaStatic.log(addParam);
        }
    }

    public static void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, null) == null) {
            i();
            h(TbadkCoreApplication.getInst());
            SharedPreferences.Editor edit = a.edit();
            r("c14429", edit);
            r("c14483", edit);
            r("c14482", edit);
            a = null;
        }
    }

    public static void r(String str, SharedPreferences.Editor editor) {
        Set<String> stringSet;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65554, null, str, editor) == null) || (stringSet = a.getStringSet(str, null)) == null) {
            return;
        }
        for (String str2 : stringSet) {
            String[] split = str2.split("_");
            if (split != null) {
                if (split.length == 3) {
                    TiebaStatic.log(new StatisticItem(str).addParam("obj_type", split[0]).addParam("obj_source", split[1]).addParam(TiebaStatic.Params.OBJ_PARAM3, split[2]));
                } else if (split.length == 4) {
                    TiebaStatic.log(new StatisticItem(str).addParam("obj_type", split[0]).addParam("obj_source", split[1]).addParam(TiebaStatic.Params.OBJ_PARAM3, split[2]).addParam(TiebaStatic.Params.OBJ_PARAM4, split[3]));
                }
            }
        }
        editor.remove(str).apply();
    }

    public static void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, null) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("start_type", f + "");
            hashMap.put("start_scheme", e());
            HashMap hashMap2 = new HashMap();
            hashMap2.put("uniqueKey", "kTBCUpdateLaunchTypeNotification");
            hashMap2.put("data", hashMap);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921542, hashMap2));
        }
    }

    public static void t(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65556, null, str, z) == null) {
            c = str;
            d = z ? 1 : 0;
        }
    }

    public static void u(Activity activity) {
        ActivityManager activityManager;
        ActivityManager.AppTask appTask;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65557, null, activity) == null) || activity == null || activity.getClass() == null || Build.VERSION.SDK_INT < 23 || (activityManager = (ActivityManager) activity.getSystemService("activity")) == null || (appTask = (ActivityManager.AppTask) ListUtils.getItem(activityManager.getAppTasks(), 0)) == null || appTask.getTaskInfo() == null || appTask.getTaskInfo().baseActivity == null || !activity.getClass().getName().equals(appTask.getTaskInfo().baseActivity.getClassName())) {
            return;
        }
        String g2 = g(appTask.getTaskInfo().baseIntent);
        t(g2, ni.isEmpty(g2));
        y();
    }

    public static void v(ActivityManager.AppTask appTask) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65558, null, appTask) == null) || appTask == null || appTask.getTaskInfo() == null || f < 99) {
            return;
        }
        if (appTask.getTaskInfo().baseIntent != null) {
            String g2 = g(appTask.getTaskInfo().baseIntent);
            t(g2, ni.isEmpty(g2));
            y();
        } else if (Build.VERSION.SDK_INT < 23 || appTask.getTaskInfo().baseActivity == null || !SpeedRuntimeProvider.MAIN_ACTIVITY_NAME.equals(appTask.getTaskInfo().baseActivity.getClassName()) || !SpeedRuntimeProvider.MAIN_ACTIVITY_NAME.equals(appTask.getTaskInfo().topActivity.getClassName())) {
        } else {
            t(null, ni.isEmpty(null));
            y();
        }
    }

    public static void w(Message message) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65559, null, message) == null) || message == null || f < 99) {
            return;
        }
        Object obj = message.obj;
        if (obj == null) {
            x("msg.obj=null", 100);
            return;
        }
        String name = obj.getClass().getName();
        Object d2 = yb.d(message.obj, "intent");
        boolean z = d2 instanceof Intent;
        String g2 = z ? g((Intent) d2) : "no intent";
        ComponentName component = z ? ((Intent) d2).getComponent() : null;
        if (name.contains("ReceiverData")) {
            d = 98;
            c = "CallReceiver_" + component + "_" + g2;
        } else if (name.contains("CreateServiceData")) {
            d = 98;
            c = "CallCreateService_" + component + "_" + g2;
        } else if (name.contains("BindServiceData")) {
            d = 98;
            c = "CallBindService_" + component + "_" + g2;
        } else if (component != null && SpeedRuntimeProvider.MAIN_ACTIVITY_NAME.equals(component.getClassName())) {
            t(g2, ni.isEmpty(g2));
        } else {
            d = 101;
            if (!ni.isEmpty(c) && c.length() >= 10000) {
                c = "tooLong_" + message.toString();
            } else {
                c += message.toString();
            }
        }
        y();
    }

    @Deprecated
    public static void x(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65560, null, str, i) == null) {
            int i2 = f;
            if (i2 == 99 || i2 == 100) {
                d = i;
                c = str;
                y();
            }
        }
    }

    public static void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65561, null) == null) {
            e = c;
            f = d;
            s();
        }
    }
}
