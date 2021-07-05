package com.kwad.sdk.collector;

import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;
import androidx.annotation.WorkerThread;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static String f34286a = "/*";

    /* renamed from: b  reason: collision with root package name */
    public static String f34287b = "*";

    /* renamed from: c  reason: collision with root package name */
    public static long f34288c = 86400000;

    /* renamed from: d  reason: collision with root package name */
    public static long f34289d = 60000;

    /* renamed from: e  reason: collision with root package name */
    public static Map<String, Set<String>> f34290e;

    /* renamed from: f  reason: collision with root package name */
    public static Map<String, String> f34291f;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1320781002, "Lcom/kwad/sdk/collector/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1320781002, "Lcom/kwad/sdk/collector/b;");
                return;
            }
        }
        f34290e = new HashMap();
        f34291f = new HashMap();
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f34289d : invokeV.longValue;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (str == null) {
                return null;
            }
            return f34291f.get(str);
        }
        return (String) invokeL.objValue;
    }

    public static void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65540, null, j) == null) {
            f34288c = j;
        }
    }

    public static void a(AppStatusRules appStatusRules) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, appStatusRules) == null) || appStatusRules == null) {
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
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, this, new Object[]{appRunningInfo, Long.valueOf(j), list, Long.valueOf(j2)}) == null) || j <= 0 || f34288c + j <= j2) {
            return;
        }
        AppStatusHelper.AppRunningInfo cloneNewOne = appRunningInfo.cloneNewOne();
        cloneNewOne.setLastRunningTime(j);
        list.add(cloneNewOne);
    }

    @WorkerThread
    public static void a(File file) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65543, null, file) != null) || file == null || !file.exists()) {
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
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65544, null, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        Set<String> hashSet = f34290e.containsKey(str) ? f34290e.get(str) : new HashSet<>();
        hashSet.add(str2);
        f34290e.put(str, hashSet);
    }

    @WorkerThread
    public static void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65545, null) == null) || f34290e.size() > 0) {
            return;
        }
        try {
            a(new File(Environment.getExternalStorageDirectory(), d.f37024b));
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    public static void b(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65546, null, j) == null) {
            f34289d = j;
        }
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, null) == null) {
            f34290e.clear();
        }
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? f34290e.size() == 0 : invokeV.booleanValue;
    }

    @RequiresPermission(StorageUtils.EXTERNAL_STORAGE_PERMISSION)
    public List<AppStatusHelper.AppRunningInfo> a(AppStatusHelper.PackageNameFilter packageNameFilter) {
        InterceptResult invokeL;
        Iterator<Map.Entry<String, Set<String>>> it;
        Map<String, AppStatusHelper.AppRunningInfo> map;
        String[] list;
        int i2;
        String str;
        String[] strArr;
        int i3;
        String str2;
        String str3;
        File file;
        String[] list2;
        int i4;
        int i5;
        File file2;
        String[] strArr2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, packageNameFilter)) == null) {
            Set<Map.Entry<String, Set<String>>> entrySet = f34290e.entrySet();
            File file3 = new File(Environment.getExternalStorageDirectory(), "/Android/data/");
            Map<String, AppStatusHelper.AppRunningInfo> createByPackages = packageNameFilter.createByPackages(f34290e.keySet());
            ArrayList arrayList = new ArrayList();
            com.kwad.sdk.core.d.a.a("FAnalyser", "targetSuffixMap size: " + f34290e.size() + ", packageRunningInfoSet size: " + createByPackages.size());
            long currentTimeMillis = System.currentTimeMillis();
            Iterator<Map.Entry<String, Set<String>>> it2 = entrySet.iterator();
            while (it2.hasNext()) {
                Map.Entry<String, Set<String>> next = it2.next();
                String key = next.getKey();
                Set<String> value = next.getValue();
                AppStatusHelper.AppRunningInfo appRunningInfo = createByPackages.get(key);
                if (appRunningInfo != null) {
                    for (String str4 : value) {
                        int i6 = 0;
                        if (str4.endsWith(f34286a)) {
                            File file4 = new File(file3, str4.replace(f34286a, ""));
                            if (file4.exists() && file4.isDirectory() && (list2 = file4.list()) != null) {
                                int length = list2.length;
                                int i7 = 0;
                                while (i7 < length) {
                                    File file5 = new File(file4, list2[i7]);
                                    if (file5.exists()) {
                                        i4 = i7;
                                        i5 = length;
                                        file2 = file4;
                                        strArr2 = list2;
                                        a(appRunningInfo, file5.lastModified(), arrayList, currentTimeMillis);
                                    } else {
                                        i4 = i7;
                                        i5 = length;
                                        file2 = file4;
                                        strArr2 = list2;
                                    }
                                    i7 = i4 + 1;
                                    length = i5;
                                    file4 = file2;
                                    list2 = strArr2;
                                }
                            }
                        } else if (str4.endsWith(f34287b)) {
                            String str5 = "/";
                            File file6 = new File(file3, str4.substring(0, str4.lastIndexOf("/")));
                            String replace = str4.replace(f34287b, "");
                            if (file6.exists() && file6.isDirectory() && (list = file6.list()) != null) {
                                String absolutePath = file6.getAbsolutePath();
                                int length2 = list.length;
                                while (i6 < length2) {
                                    Iterator<Map.Entry<String, Set<String>>> it3 = it2;
                                    String str6 = list[i6];
                                    Map<String, AppStatusHelper.AppRunningInfo> map2 = createByPackages;
                                    if ((absolutePath + str5 + str6).contains(replace)) {
                                        File file7 = new File(file6, str6);
                                        if (file7.exists()) {
                                            long lastModified = file7.lastModified();
                                            i2 = length2;
                                            str = absolutePath;
                                            strArr = list;
                                            i3 = i6;
                                            str2 = replace;
                                            str3 = str5;
                                            file = file6;
                                            a(appRunningInfo, lastModified, arrayList, currentTimeMillis);
                                            i6 = i3 + 1;
                                            length2 = i2;
                                            absolutePath = str;
                                            createByPackages = map2;
                                            replace = str2;
                                            file6 = file;
                                            list = strArr;
                                            str5 = str3;
                                            it2 = it3;
                                        }
                                    }
                                    i2 = length2;
                                    str = absolutePath;
                                    strArr = list;
                                    i3 = i6;
                                    str2 = replace;
                                    str3 = str5;
                                    file = file6;
                                    i6 = i3 + 1;
                                    length2 = i2;
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
        return (List) invokeL.objValue;
    }

    public List<AppStatusHelper.AppRunningInfo> a(List<AppStatusHelper.AppRunningInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) ? (list == null || list.isEmpty()) ? list : new ArrayList(new LinkedHashSet(list)) : (List) invokeL.objValue;
    }
}
