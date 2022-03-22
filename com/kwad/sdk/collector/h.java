package com.kwad.sdk.collector;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.collector.AppStatusRules;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class h {
    public static String a(AppStatusRules.Strategy strategy) {
        String name = strategy.getName() == null ? "defaultStrategy" : strategy.getName();
        return "appstatus_strategy_pref_" + name;
    }

    public static List<AppStatusRules.Strategy> a(@Nullable AppStatusRules appStatusRules) {
        return appStatusRules == null ? new ArrayList() : appStatusRules.obtainNamedStrategyList();
    }

    public static void a(Context context, AppStatusRules.Strategy strategy, long j) {
        if (context == null || strategy == null) {
            return;
        }
        context.getSharedPreferences("ksadsdk_pref", 0).edit().putLong(a(strategy), j).apply();
    }

    public static boolean a(Context context, @NonNull AppStatusRules.Strategy strategy) {
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

    @NonNull
    public static AppStatusRules.Strategy b(@Nullable AppStatusRules appStatusRules) {
        return appStatusRules == null ? AppStatusRules.Strategy.LOCAL_DEFAULT : appStatusRules.obtainDefaultStrategy();
    }
}
