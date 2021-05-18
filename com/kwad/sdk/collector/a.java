package com.kwad.sdk.collector;

import androidx.annotation.NonNull;
import com.kwad.sdk.collector.AppStatusRules;
import com.kwad.sdk.utils.InstalledAppInfoManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public AppRunningInfo f31922a;

    /* renamed from: b  reason: collision with root package name */
    public Set<String> f31923b;

    /* renamed from: c  reason: collision with root package name */
    public AppStatusRules.Strategy f31924c;

    public a(AppRunningInfo appRunningInfo, Set<String> set, AppStatusRules.Strategy strategy) {
        this.f31922a = appRunningInfo;
        this.f31923b = set;
        this.f31924c = strategy;
    }

    public static List<a> a(@NonNull AppStatusRules.Strategy strategy, @NonNull Map<String, InstalledAppInfoManager.AppPackageInfo> map) {
        InstalledAppInfoManager.AppPackageInfo appPackageInfo;
        ArrayList arrayList = new ArrayList();
        ArrayList<AppStatusRules.Target> target = strategy.getTarget();
        if (target != null && target.size() != 0) {
            for (AppStatusRules.Target target2 : target) {
                if (target2.getPaths() != null && target2.getPaths().size() != 0 && (appPackageInfo = map.get(target2.getPackageName())) != null) {
                    arrayList.add(new a(AppRunningInfo.createInstance(appPackageInfo, strategy), new HashSet(target2.getPaths()), strategy));
                }
            }
        }
        return arrayList;
    }

    public AppRunningInfo a() {
        return this.f31922a;
    }

    public Set<String> b() {
        return this.f31923b;
    }

    public String c() {
        AppRunningInfo appRunningInfo = this.f31922a;
        if (appRunningInfo == null) {
            return null;
        }
        return appRunningInfo.getPackageName();
    }
}
