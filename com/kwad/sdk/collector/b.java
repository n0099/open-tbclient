package com.kwad.sdk.collector;

import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.collector.AppStatusRules;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
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
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static String f31877a = "/*";

    /* renamed from: b  reason: collision with root package name */
    public static String f31878b = "*";

    /* renamed from: c  reason: collision with root package name */
    public static long f31879c = 86400000;

    /* renamed from: d  reason: collision with root package name */
    public static long f31880d = 60000;

    /* renamed from: e  reason: collision with root package name */
    public static Map<String, Set<String>> f31881e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    public static Map<String, String> f31882f = new HashMap();

    public static long a() {
        return f31880d;
    }

    public static String a(String str) {
        if (str == null) {
            return null;
        }
        return f31882f.get(str);
    }

    public static void a(long j) {
        f31879c = j;
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
        if (j <= 0 || f31879c + j <= j2) {
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
        Set<String> hashSet = f31881e.containsKey(str) ? f31881e.get(str) : new HashSet<>();
        hashSet.add(str2);
        f31881e.put(str, hashSet);
    }

    @WorkerThread
    public static void b() {
        if (f31881e.size() > 0) {
            return;
        }
        try {
            a(new File(Environment.getExternalStorageDirectory(), d.f34512b));
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    public static void b(long j) {
        f31880d = j;
    }

    public static void c() {
        f31881e.clear();
    }

    public static boolean d() {
        return f31881e.size() == 0;
    }

    @RequiresPermission(StorageUtils.EXTERNAL_STORAGE_PERMISSION)
    public List<AppStatusHelper.AppRunningInfo> a(AppStatusHelper.PackageNameFilter packageNameFilter) {
        Iterator<Map.Entry<String, Set<String>>> it;
        Map<String, AppStatusHelper.AppRunningInfo> map;
        String[] list;
        int i;
        String str;
        String[] strArr;
        int i2;
        String str2;
        String str3;
        File file;
        String[] list2;
        int i3;
        int i4;
        File file2;
        String[] strArr2;
        Set<Map.Entry<String, Set<String>>> entrySet = f31881e.entrySet();
        File file3 = new File(Environment.getExternalStorageDirectory(), "/Android/data/");
        Map<String, AppStatusHelper.AppRunningInfo> createByPackages = packageNameFilter.createByPackages(f31881e.keySet());
        ArrayList arrayList = new ArrayList();
        com.kwad.sdk.core.d.a.a("FAnalyser", "targetSuffixMap size: " + f31881e.size() + ", packageRunningInfoSet size: " + createByPackages.size());
        long currentTimeMillis = System.currentTimeMillis();
        Iterator<Map.Entry<String, Set<String>>> it2 = entrySet.iterator();
        while (it2.hasNext()) {
            Map.Entry<String, Set<String>> next = it2.next();
            String key = next.getKey();
            Set<String> value = next.getValue();
            AppStatusHelper.AppRunningInfo appRunningInfo = createByPackages.get(key);
            if (appRunningInfo != null) {
                for (String str4 : value) {
                    int i5 = 0;
                    if (str4.endsWith(f31877a)) {
                        File file4 = new File(file3, str4.replace(f31877a, ""));
                        if (file4.exists() && file4.isDirectory() && (list2 = file4.list()) != null) {
                            int length = list2.length;
                            int i6 = 0;
                            while (i6 < length) {
                                File file5 = new File(file4, list2[i6]);
                                if (file5.exists()) {
                                    i3 = i6;
                                    i4 = length;
                                    file2 = file4;
                                    strArr2 = list2;
                                    a(appRunningInfo, file5.lastModified(), arrayList, currentTimeMillis);
                                } else {
                                    i3 = i6;
                                    i4 = length;
                                    file2 = file4;
                                    strArr2 = list2;
                                }
                                i6 = i3 + 1;
                                length = i4;
                                file4 = file2;
                                list2 = strArr2;
                            }
                        }
                    } else if (str4.endsWith(f31878b)) {
                        String str5 = "/";
                        File file6 = new File(file3, str4.substring(0, str4.lastIndexOf("/")));
                        String replace = str4.replace(f31878b, "");
                        if (file6.exists() && file6.isDirectory() && (list = file6.list()) != null) {
                            String absolutePath = file6.getAbsolutePath();
                            int length2 = list.length;
                            while (i5 < length2) {
                                Iterator<Map.Entry<String, Set<String>>> it3 = it2;
                                String str6 = list[i5];
                                Map<String, AppStatusHelper.AppRunningInfo> map2 = createByPackages;
                                if ((absolutePath + str5 + str6).contains(replace)) {
                                    File file7 = new File(file6, str6);
                                    if (file7.exists()) {
                                        long lastModified = file7.lastModified();
                                        i = length2;
                                        str = absolutePath;
                                        strArr = list;
                                        i2 = i5;
                                        str2 = replace;
                                        str3 = str5;
                                        file = file6;
                                        a(appRunningInfo, lastModified, arrayList, currentTimeMillis);
                                        i5 = i2 + 1;
                                        length2 = i;
                                        absolutePath = str;
                                        createByPackages = map2;
                                        replace = str2;
                                        file6 = file;
                                        list = strArr;
                                        str5 = str3;
                                        it2 = it3;
                                    }
                                }
                                i = length2;
                                str = absolutePath;
                                strArr = list;
                                i2 = i5;
                                str2 = replace;
                                str3 = str5;
                                file = file6;
                                i5 = i2 + 1;
                                length2 = i;
                                absolutePath = str;
                                createByPackages = map2;
                                replace = str2;
                                file6 = file;
                                list = strArr;
                                str5 = str3;
                                it2 = it3;
                            }
                        }
                    } else {
                        it = it2;
                        map = createByPackages;
                        if (str4.startsWith(key)) {
                            File file8 = new File(file3, str4);
                            if (file8.exists()) {
                                a(appRunningInfo, file8.lastModified(), arrayList, currentTimeMillis);
                            }
                        }
                        it2 = it;
                        createByPackages = map;
                    }
                    it = it2;
                    map = createByPackages;
                    it2 = it;
                    createByPackages = map;
                }
            }
        }
        return arrayList;
    }

    public List<AppStatusHelper.AppRunningInfo> a(List<AppStatusHelper.AppRunningInfo> list) {
        return (list == null || list.isEmpty()) ? list : new ArrayList(new LinkedHashSet(list));
    }
}
