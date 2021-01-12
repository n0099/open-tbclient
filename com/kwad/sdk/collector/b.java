package com.kwad.sdk.collector;

import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.collector.AppStatusRules;
import com.kwad.sdk.d;
import com.kwad.sdk.utils.AppStatusHelper;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static String f8261a = "/*";

    /* renamed from: b  reason: collision with root package name */
    private static String f8262b = "*";
    private static long c = 86400000;
    private static long d = AppStatusRules.DEFAULT_GRANULARITY;
    private static Map<String, Set<String>> e = new HashMap();
    private static Map<String, String> f = new HashMap();

    public static long a() {
        return d;
    }

    public static String a(String str) {
        if (str == null) {
            return null;
        }
        return f.get(str);
    }

    public static void a(long j) {
        c = j;
    }

    public static void a(AppStatusRules appStatusRules) {
        if (appStatusRules == null) {
            return;
        }
        ArrayList<AppStatusRules.Target> targetList = appStatusRules.getTargetList();
        if (targetList == null) {
            com.kwad.sdk.core.d.a.d("FAnalyser", "loadTargetSuffix target is null");
            return;
        }
        for (AppStatusRules.Target target : targetList) {
            String packageName = target.getPackageName();
            for (String str : target.getPaths()) {
                a(packageName, str);
            }
        }
    }

    private void a(AppStatusHelper.AppRunningInfo appRunningInfo, long j, @NonNull List<AppStatusHelper.AppRunningInfo> list, long j2) {
        if (j <= 0 || c + j <= j2) {
            return;
        }
        AppStatusHelper.AppRunningInfo cloneNewOne = appRunningInfo.cloneNewOne();
        cloneNewOne.setLastRunningTime(j);
        list.add(cloneNewOne);
    }

    @WorkerThread
    public static void a(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    com.kwad.sdk.core.d.a.a("FAnalyser", "loadTargetSuffixFromFile load success");
                    return;
                }
                String[] split = readLine.split(",");
                if (split.length >= 2) {
                    String trim = split[0].trim();
                    String trim2 = split[1].trim();
                    if (!TextUtils.isEmpty(trim) && !TextUtils.isEmpty(trim2)) {
                        a(trim, trim2);
                    }
                }
            }
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }

    public static void a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        Set<String> hashSet = e.containsKey(str) ? e.get(str) : new HashSet<>();
        hashSet.add(str2);
        e.put(str, hashSet);
    }

    @WorkerThread
    public static void b() {
        if (e.size() > 0) {
            return;
        }
        try {
            a(new File(Environment.getExternalStorageDirectory(), d.f9670b));
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    public static void b(long j) {
        d = j;
    }

    public static void c() {
        e.clear();
    }

    public static boolean d() {
        return e.size() == 0;
    }

    @RequiresPermission("android.permission.WRITE_EXTERNAL_STORAGE")
    public List<AppStatusHelper.AppRunningInfo> a(AppStatusHelper.PackageNameFilter packageNameFilter) {
        String[] list;
        String[] list2;
        Set<Map.Entry<String, Set<String>>> entrySet = e.entrySet();
        File file = new File(Environment.getExternalStorageDirectory(), "/Android/data/");
        Map<String, AppStatusHelper.AppRunningInfo> createByPackages = packageNameFilter.createByPackages(e.keySet());
        ArrayList arrayList = new ArrayList();
        com.kwad.sdk.core.d.a.a("FAnalyser", "targetSuffixMap size: " + e.size() + ", packageRunningInfoSet size: " + createByPackages.size());
        long currentTimeMillis = System.currentTimeMillis();
        for (Map.Entry<String, Set<String>> entry : entrySet) {
            String key = entry.getKey();
            Set<String> value = entry.getValue();
            AppStatusHelper.AppRunningInfo appRunningInfo = createByPackages.get(key);
            if (appRunningInfo != null) {
                for (String str : value) {
                    if (str.endsWith(f8261a)) {
                        File file2 = new File(file, str.replace(f8261a, ""));
                        if (file2.exists() && file2.isDirectory() && (list = file2.list()) != null) {
                            int length = list.length;
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 < length) {
                                    File file3 = new File(file2, list[i2]);
                                    if (file3.exists()) {
                                        a(appRunningInfo, file3.lastModified(), arrayList, currentTimeMillis);
                                    }
                                    i = i2 + 1;
                                }
                            }
                        }
                    } else if (str.endsWith(f8262b)) {
                        File file4 = new File(file, str.substring(0, str.lastIndexOf("/")));
                        String replace = str.replace(f8262b, "");
                        if (file4.exists() && file4.isDirectory() && (list2 = file4.list()) != null) {
                            String absolutePath = file4.getAbsolutePath();
                            int length2 = list2.length;
                            int i3 = 0;
                            while (true) {
                                int i4 = i3;
                                if (i4 < length2) {
                                    String str2 = list2[i4];
                                    if ((absolutePath + "/" + str2).contains(replace)) {
                                        File file5 = new File(file4, str2);
                                        if (file5.exists()) {
                                            a(appRunningInfo, file5.lastModified(), arrayList, currentTimeMillis);
                                        }
                                    }
                                    i3 = i4 + 1;
                                }
                            }
                        }
                    } else if (str.startsWith(key)) {
                        File file6 = new File(file, str);
                        if (file6.exists()) {
                            a(appRunningInfo, file6.lastModified(), arrayList, currentTimeMillis);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public List<AppStatusHelper.AppRunningInfo> a(List<AppStatusHelper.AppRunningInfo> list) {
        return (list == null || list.isEmpty()) ? list : new ArrayList(new LinkedHashSet(list));
    }
}
