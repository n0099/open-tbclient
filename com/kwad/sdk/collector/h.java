package com.kwad.sdk.collector;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.collector.AppStatusRules;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(AppStatusRules.Strategy strategy) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, strategy)) == null) {
            String name = strategy.getName() == null ? "defaultStrategy" : strategy.getName();
            return "appstatus_strategy_pref_" + name;
        }
        return (String) invokeL.objValue;
    }

    public static List<AppStatusRules.Strategy> a(@Nullable AppStatusRules appStatusRules) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, appStatusRules)) == null) ? appStatusRules == null ? new ArrayList() : appStatusRules.obtainNamedStrategyList() : (List) invokeL.objValue;
    }

    public static void a(Context context, AppStatusRules.Strategy strategy, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{context, strategy, Long.valueOf(j)}) == null) || context == null || strategy == null) {
            return;
        }
        context.getSharedPreferences("ksadsdk_pref", 0).edit().putLong(a(strategy), j).apply();
    }

    public static boolean a(Context context, @NonNull AppStatusRules.Strategy strategy) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, strategy)) == null) {
            if (context == null) {
                return false;
            }
            long j = context.getSharedPreferences("ksadsdk_pref", 0).getLong(a(strategy), -1L);
            if (j < 0) {
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis();
            long minLaunchIntervalWithMS = strategy.getMinLaunchIntervalWithMS();
            return minLaunchIntervalWithMS <= 0 || j + minLaunchIntervalWithMS < currentTimeMillis;
        }
        return invokeLL.booleanValue;
    }

    @NonNull
    public static AppStatusRules.Strategy b(@Nullable AppStatusRules appStatusRules) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, appStatusRules)) == null) ? appStatusRules == null ? AppStatusRules.Strategy.LOCAL_DEFAULT : appStatusRules.obtainDefaultStrategy() : (AppStatusRules.Strategy) invokeL.objValue;
    }
}
