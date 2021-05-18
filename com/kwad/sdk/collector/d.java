package com.kwad.sdk.collector;

import android.content.Context;
import android.os.Environment;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;
import com.kwad.sdk.collector.AppStatusRules;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import com.kwad.sdk.utils.AppStatusHelper;
import com.kwad.sdk.utils.InstalledAppInfoManager;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static Map<String, String> f31962a = new HashMap();

    @NonNull
    public static List<AppRunningInfo> a(Context context, AppStatusRules.Strategy strategy, Map<String, InstalledAppInfoManager.AppPackageInfo> map) {
        String[] list;
        int i2;
        String[] strArr;
        int i3;
        File file;
        String[] list2;
        String[] strArr2;
        String str;
        int i4;
        File file2;
        String str2;
        String str3;
        ArrayList arrayList = new ArrayList();
        boolean isNeedLaunch = strategy.isNeedLaunch();
        com.kwad.sdk.core.d.a.a("FAnalyser", "analysisByFile, strategy: " + strategy.getName() + ", needLaunch: " + isNeedLaunch);
        if (isNeedLaunch) {
            List<a> a2 = g.a(strategy, map);
            File file3 = new File(Environment.getExternalStorageDirectory(), "/Android/data/");
            long currentTimeMillis = System.currentTimeMillis();
            for (a aVar : a2) {
                String c2 = aVar.c();
                Set<String> b2 = aVar.b();
                AppRunningInfo a3 = aVar.a();
                if (a3 != null) {
                    for (String str4 : b2) {
                        int i5 = 0;
                        if (str4.endsWith(AppStatusRules.SUFFIX_ALL_CHILDREN)) {
                            File file4 = new File(file3, str4.replace(AppStatusRules.SUFFIX_ALL_CHILDREN, ""));
                            if (file4.exists() && file4.isDirectory() && (list = file4.list()) != null) {
                                int length = list.length;
                                while (i5 < length) {
                                    File file5 = new File(file4, list[i5]);
                                    if (file5.exists()) {
                                        i2 = i5;
                                        strArr = list;
                                        i3 = length;
                                        file = file4;
                                        a(a3, file5.lastModified(), arrayList, currentTimeMillis, strategy);
                                    } else {
                                        i2 = i5;
                                        strArr = list;
                                        i3 = length;
                                        file = file4;
                                    }
                                    i5 = i2 + 1;
                                    list = strArr;
                                    length = i3;
                                    file4 = file;
                                }
                            }
                        } else if (str4.endsWith(AppStatusRules.SUFFIX_ALL_FILE)) {
                            String str5 = "/";
                            File file6 = new File(file3, str4.substring(0, str4.lastIndexOf("/")));
                            String replace = str4.replace(AppStatusRules.SUFFIX_ALL_FILE, "");
                            if (file6.exists() && file6.isDirectory() && (list2 = file6.list()) != null) {
                                String absolutePath = file6.getAbsolutePath();
                                int length2 = list2.length;
                                while (i5 < length2) {
                                    int i6 = length2;
                                    String str6 = list2[i5];
                                    String[] strArr3 = list2;
                                    if ((absolutePath + str5 + str6).contains(replace)) {
                                        File file7 = new File(file6, str6);
                                        if (file7.exists()) {
                                            strArr2 = strArr3;
                                            str = absolutePath;
                                            i4 = i5;
                                            file2 = file6;
                                            str2 = replace;
                                            str3 = str5;
                                            a(a3, file7.lastModified(), arrayList, currentTimeMillis, strategy);
                                            i5 = i4 + 1;
                                            length2 = i6;
                                            file6 = file2;
                                            list2 = strArr2;
                                            absolutePath = str;
                                            replace = str2;
                                            str5 = str3;
                                        }
                                    }
                                    strArr2 = strArr3;
                                    str = absolutePath;
                                    i4 = i5;
                                    file2 = file6;
                                    str2 = replace;
                                    str3 = str5;
                                    i5 = i4 + 1;
                                    length2 = i6;
                                    file6 = file2;
                                    list2 = strArr2;
                                    absolutePath = str;
                                    replace = str2;
                                    str5 = str3;
                                }
                            }
                        } else if (str4.startsWith(c2)) {
                            File file8 = new File(file3, str4);
                            if (file8.exists()) {
                                a(a3, file8.lastModified(), arrayList, currentTimeMillis, strategy);
                            }
                        }
                    }
                }
            }
            List<AppRunningInfo> a4 = a(arrayList);
            com.kwad.sdk.core.d.a.a("FAnalyser", "strategy: " + strategy.getName());
            Iterator<AppRunningInfo> it = a4.iterator();
            while (it.hasNext()) {
                com.kwad.sdk.core.d.a.a("FAnalyser", "info: " + it.next().toString());
            }
            return a4;
        }
        return arrayList;
    }

    public static List<AppRunningInfo> a(List<AppRunningInfo> list) {
        return (list == null || list.isEmpty()) ? list : new ArrayList(new LinkedHashSet(list));
    }

    public static void a(AppRunningInfo appRunningInfo, long j, @NonNull List<AppRunningInfo> list, long j2, AppStatusRules.Strategy strategy) {
        long startTimeWithMS = strategy.getStartTimeWithMS();
        if (j <= 0 || startTimeWithMS + j <= j2) {
            return;
        }
        AppRunningInfo m43clone = appRunningInfo.m43clone();
        m43clone.setLastRunningTime(j);
        list.add(m43clone);
    }

    @RequiresPermission(StorageUtils.EXTERNAL_STORAGE_PERMISSION)
    public List<AppRunningInfo> a(Context context) {
        ArrayList arrayList = new ArrayList();
        AppStatusRules a2 = AppStatusHelper.a();
        Map<String, InstalledAppInfoManager.AppPackageInfo> b2 = InstalledAppInfoManager.b(context);
        for (AppStatusRules.Strategy strategy : g.a(a2)) {
            arrayList.addAll(a(context, strategy, b2));
            strategy.setNeedSaveLaunchTime(System.currentTimeMillis());
        }
        AppStatusRules.Strategy b3 = g.b(a2);
        arrayList.addAll(a(context, b3, b2));
        b3.setNeedSaveLaunchTime(System.currentTimeMillis());
        return arrayList;
    }
}
