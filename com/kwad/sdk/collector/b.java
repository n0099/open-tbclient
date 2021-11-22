package com.kwad.sdk.collector;

import android.os.Environment;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.collector.AppStatusRules;
import com.kwad.sdk.collector.model.jni.RulesTargetNative;
import com.kwad.sdk.utils.InstalledAppInfoManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class a implements com.kwad.sdk.collector.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static String a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
                int lastIndexOf = str.lastIndexOf("/");
                if (lastIndexOf < 0 || lastIndexOf >= str.length() - 1) {
                    return null;
                }
                return str.substring(lastIndexOf + 1);
            }
            return (String) invokeL.objValue;
        }

        public static void a(long j, String str, File file, ArrayList<com.kwad.sdk.collector.model.e> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{Long.valueOf(j), str, file, arrayList}) == null) {
                if ((file.exists() && file.isFile()) && file.length() <= j) {
                    arrayList.add(new com.kwad.sdk.collector.model.a.d(str, file.getAbsolutePath()));
                }
            }
        }

        public static void a(com.kwad.sdk.collector.model.a.b bVar, long j, @NonNull List<com.kwad.sdk.collector.model.b> list, long j2, AppStatusRules.Strategy strategy) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{bVar, Long.valueOf(j), list, Long.valueOf(j2), strategy}) == null) {
                long startTimeWithMS = strategy.getStartTimeWithMS();
                if (j <= 0 || startTimeWithMS + j <= j2) {
                    return;
                }
                com.kwad.sdk.collector.model.a.b clone = bVar.clone();
                clone.c(j);
                list.add(clone);
            }
        }

        @Override // com.kwad.sdk.collector.a
        public List<com.kwad.sdk.collector.model.b> a(AppStatusRules.Strategy strategy, Map<String, InstalledAppInfoManager.AppPackageInfo> map) {
            InterceptResult invokeLL;
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
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, strategy, map)) == null) {
                ArrayList arrayList = new ArrayList();
                ArrayList<com.kwad.sdk.collector.model.a> arrayList2 = new ArrayList();
                com.kwad.sdk.collector.model.c.a(strategy, map, arrayList2);
                File file3 = new File(Environment.getExternalStorageDirectory(), "/Android/data/");
                long currentTimeMillis = System.currentTimeMillis();
                for (com.kwad.sdk.collector.model.a aVar : arrayList2) {
                    if (!(aVar instanceof com.kwad.sdk.collector.model.a.a)) {
                        return arrayList;
                    }
                    com.kwad.sdk.collector.model.a.a aVar2 = (com.kwad.sdk.collector.model.a.a) aVar;
                    String a2 = aVar2.a();
                    Set<String> b2 = aVar2.b();
                    com.kwad.sdk.collector.model.a.b c2 = aVar2.c();
                    if (c2 != null) {
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
                                            a(c2, file5.lastModified(), arrayList, currentTimeMillis, strategy);
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
                                                a(c2, file7.lastModified(), arrayList, currentTimeMillis, strategy);
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
                            } else if (str4.startsWith(a2)) {
                                File file8 = new File(file3, str4);
                                if (file8.exists()) {
                                    a(c2, file8.lastModified(), arrayList, currentTimeMillis, strategy);
                                }
                            }
                        }
                    }
                }
                com.kwad.sdk.core.d.a.a("AppStatusAnalyserJava", "strategy: " + strategy.getName());
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    com.kwad.sdk.core.d.a.a("AppStatusAnalyserJava", "info: " + ((com.kwad.sdk.collector.model.b) it.next()).toString());
                }
                return arrayList;
            }
            return (List) invokeLL.objValue;
        }

        @Override // com.kwad.sdk.collector.a
        public List<com.kwad.sdk.collector.model.e> a(List<com.kwad.sdk.collector.model.d> list, long j, String str) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{list, Long.valueOf(j), str})) == null) {
                ArrayList arrayList = new ArrayList();
                for (com.kwad.sdk.collector.model.d dVar : list) {
                    if (!(dVar instanceof com.kwad.sdk.collector.model.a.c)) {
                        return arrayList;
                    }
                    com.kwad.sdk.collector.model.a.c cVar = (com.kwad.sdk.collector.model.a.c) dVar;
                    List<String> b2 = cVar.b();
                    if (b2 != null) {
                        String a2 = cVar.a();
                        if (new File(str, a2).exists()) {
                            for (String str2 : b2) {
                                String a3 = a(str2);
                                int i2 = 0;
                                if (str2.endsWith(AppStatusRules.SUFFIX_ALL_CHILDREN)) {
                                    File[] listFiles = new File(str, str2.replace(AppStatusRules.SUFFIX_ALL_CHILDREN, "")).listFiles();
                                    if (listFiles != null && listFiles.length > 0) {
                                        int length = listFiles.length;
                                        while (i2 < length) {
                                            File file = listFiles[i2];
                                            if (file.isFile()) {
                                                a(j, a2, file, arrayList);
                                            }
                                            i2++;
                                        }
                                    }
                                } else if (str2.endsWith(AppStatusRules.SUFFIX_ALL_FILE)) {
                                    File[] listFiles2 = new File(str, str2.substring(0, str2.lastIndexOf("/"))).listFiles();
                                    String replace = str2.replace(AppStatusRules.SUFFIX_ALL_FILE, "");
                                    int length2 = listFiles2.length;
                                    while (i2 < length2) {
                                        File file2 = listFiles2[i2];
                                        if (file2.isFile() && file2.getAbsolutePath().contains(replace)) {
                                            a(j, a2, file2, arrayList);
                                        }
                                        i2++;
                                    }
                                } else if (a3 == null || !a3.startsWith(AppStatusRules.SUFFIX_ALL_FILE)) {
                                    a(j, a2, new File(str, str2), arrayList);
                                }
                            }
                        }
                    }
                }
                return null;
            }
            return (List) invokeCommon.objValue;
        }
    }

    /* renamed from: com.kwad.sdk.collector.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1933b implements com.kwad.sdk.collector.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1933b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.kwad.sdk.collector.a
        public List<com.kwad.sdk.collector.model.b> a(AppStatusRules.Strategy strategy, Map<String, InstalledAppInfoManager.AppPackageInfo> map) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, strategy, map)) == null) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                com.kwad.sdk.collector.model.c.a(strategy, map, arrayList2);
                File file = new File(Environment.getExternalStorageDirectory(), "/Android/data/");
                int size = arrayList2.size();
                long[] jArr = new long[size];
                for (int i2 = 0; i2 < size; i2++) {
                    com.kwad.sdk.collector.model.a aVar = (com.kwad.sdk.collector.model.a) arrayList2.get(i2);
                    if (!(aVar instanceof com.kwad.sdk.collector.model.jni.a)) {
                        return arrayList;
                    }
                    jArr[i2] = ((com.kwad.sdk.collector.model.jni.a) aVar).getNativePtr();
                }
                long[] analysis = AppStatusNative.analysis(jArr, file.getAbsolutePath() + "/");
                com.kwad.sdk.core.d.a.a("AppStatusAnalyserNative", "analysisByFile: runningInfoPtrs: " + analysis);
                for (long j : analysis) {
                    arrayList.add(new com.kwad.sdk.collector.model.jni.b(j));
                }
                com.kwad.sdk.core.d.a.a("AppStatusAnalyserNative", "analysisByFile: info size: " + arrayList.size());
                return arrayList;
            }
            return (List) invokeLL.objValue;
        }

        @Override // com.kwad.sdk.collector.a
        public List<com.kwad.sdk.collector.model.e> a(List<com.kwad.sdk.collector.model.d> list, long j, String str) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{list, Long.valueOf(j), str})) == null) {
                int size = list.size();
                long[] jArr = new long[list.size()];
                for (int i2 = 0; i2 < size; i2++) {
                    com.kwad.sdk.collector.model.d dVar = list.get(i2);
                    if (dVar instanceof RulesTargetNative) {
                        jArr[i2] = ((RulesTargetNative) dVar).getNativePtr();
                    }
                }
                long[] nativeGetUploadEntry = AppStatusNative.nativeGetUploadEntry(jArr, j, str);
                ArrayList arrayList = new ArrayList();
                for (long j2 : nativeGetUploadEntry) {
                    arrayList.add(new com.kwad.sdk.collector.model.jni.c(j2));
                }
                return arrayList;
            }
            return (List) invokeCommon.objValue;
        }
    }

    public static com.kwad.sdk.collector.a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? com.kwad.sdk.core.config.c.ac() ? new C1933b() : new a() : (com.kwad.sdk.collector.a) invokeV.objValue;
    }
}
