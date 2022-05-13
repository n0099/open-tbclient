package com.kwad.sdk.collector;

import android.os.Environment;
import androidx.annotation.NonNull;
import com.kwad.sdk.collector.AppStatusRules;
import com.kwad.sdk.collector.model.jni.AnalyseTaskNative;
import com.kwad.sdk.collector.model.jni.AppRunningInfoNative;
import com.kwad.sdk.collector.model.jni.RulesTargetNative;
import com.kwad.sdk.collector.model.jni.UploadEntryNative;
import com.kwad.sdk.utils.InstalledAppInfoManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes5.dex */
public class b {

    /* loaded from: classes5.dex */
    public static class a implements com.kwad.sdk.collector.a {
        public static String a(String str) {
            int lastIndexOf = str.lastIndexOf("/");
            if (lastIndexOf < 0 || lastIndexOf >= str.length() - 1) {
                return null;
            }
            return str.substring(lastIndexOf + 1);
        }

        public static void a(long j, String str, File file, ArrayList<com.kwad.sdk.collector.model.e> arrayList) {
            if ((file.exists() && file.isFile()) && file.length() <= j) {
                arrayList.add(new com.kwad.sdk.collector.model.kwai.d(str, file.getAbsolutePath()));
            }
        }

        public static void a(com.kwad.sdk.collector.model.kwai.b bVar, long j, @NonNull List<com.kwad.sdk.collector.model.b> list, long j2, AppStatusRules.Strategy strategy) {
            long startTimeWithMS = strategy.getStartTimeWithMS();
            if (j <= 0 || startTimeWithMS + j <= j2) {
                return;
            }
            com.kwad.sdk.collector.model.kwai.b clone = bVar.clone();
            clone.c(j);
            list.add(clone);
        }

        @Override // com.kwad.sdk.collector.a
        public List<com.kwad.sdk.collector.model.b> a(AppStatusRules.Strategy strategy, Map<String, InstalledAppInfoManager.AppPackageInfo> map) {
            String[] list;
            int i;
            String[] strArr;
            int i2;
            File file;
            String[] list2;
            String[] strArr2;
            String str;
            int i3;
            File file2;
            String str2;
            String str3;
            ArrayList arrayList = new ArrayList();
            ArrayList<com.kwad.sdk.collector.model.a> arrayList2 = new ArrayList();
            com.kwad.sdk.collector.model.c.a(strategy, map, arrayList2);
            File file3 = new File(Environment.getExternalStorageDirectory(), "/Android/data/");
            long currentTimeMillis = System.currentTimeMillis();
            for (com.kwad.sdk.collector.model.a aVar : arrayList2) {
                if (!(aVar instanceof com.kwad.sdk.collector.model.kwai.a)) {
                    return arrayList;
                }
                com.kwad.sdk.collector.model.kwai.a aVar2 = (com.kwad.sdk.collector.model.kwai.a) aVar;
                String a = aVar2.a();
                Set<String> b = aVar2.b();
                com.kwad.sdk.collector.model.kwai.b c = aVar2.c();
                if (c != null) {
                    for (String str4 : b) {
                        int i4 = 0;
                        if (str4.endsWith(AppStatusRules.SUFFIX_ALL_CHILDREN)) {
                            File file4 = new File(file3, str4.replace(AppStatusRules.SUFFIX_ALL_CHILDREN, ""));
                            if (file4.exists() && file4.isDirectory() && (list = file4.list()) != null) {
                                int length = list.length;
                                while (i4 < length) {
                                    File file5 = new File(file4, list[i4]);
                                    if (file5.exists()) {
                                        i = i4;
                                        strArr = list;
                                        i2 = length;
                                        file = file4;
                                        a(c, file5.lastModified(), arrayList, currentTimeMillis, strategy);
                                    } else {
                                        i = i4;
                                        strArr = list;
                                        i2 = length;
                                        file = file4;
                                    }
                                    i4 = i + 1;
                                    list = strArr;
                                    length = i2;
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
                                while (i4 < length2) {
                                    int i5 = length2;
                                    String str6 = list2[i4];
                                    String[] strArr3 = list2;
                                    if ((absolutePath + str5 + str6).contains(replace)) {
                                        File file7 = new File(file6, str6);
                                        if (file7.exists()) {
                                            strArr2 = strArr3;
                                            str = absolutePath;
                                            i3 = i4;
                                            file2 = file6;
                                            str2 = replace;
                                            str3 = str5;
                                            a(c, file7.lastModified(), arrayList, currentTimeMillis, strategy);
                                            i4 = i3 + 1;
                                            length2 = i5;
                                            file6 = file2;
                                            list2 = strArr2;
                                            absolutePath = str;
                                            replace = str2;
                                            str5 = str3;
                                        }
                                    }
                                    strArr2 = strArr3;
                                    str = absolutePath;
                                    i3 = i4;
                                    file2 = file6;
                                    str2 = replace;
                                    str3 = str5;
                                    i4 = i3 + 1;
                                    length2 = i5;
                                    file6 = file2;
                                    list2 = strArr2;
                                    absolutePath = str;
                                    replace = str2;
                                    str5 = str3;
                                }
                            }
                        } else if (str4.startsWith(a)) {
                            File file8 = new File(file3, str4);
                            if (file8.exists()) {
                                a(c, file8.lastModified(), arrayList, currentTimeMillis, strategy);
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

        @Override // com.kwad.sdk.collector.a
        public List<com.kwad.sdk.collector.model.e> a(List<com.kwad.sdk.collector.model.d> list, long j, String str) {
            ArrayList arrayList = new ArrayList();
            for (com.kwad.sdk.collector.model.d dVar : list) {
                if (!(dVar instanceof com.kwad.sdk.collector.model.kwai.c)) {
                    return arrayList;
                }
                com.kwad.sdk.collector.model.kwai.c cVar = (com.kwad.sdk.collector.model.kwai.c) dVar;
                List<String> b = cVar.b();
                if (b != null) {
                    String a = cVar.a();
                    if (new File(str, a).exists()) {
                        for (String str2 : b) {
                            String a2 = a(str2);
                            int i = 0;
                            if (str2.endsWith(AppStatusRules.SUFFIX_ALL_CHILDREN)) {
                                File[] listFiles = new File(str, str2.replace(AppStatusRules.SUFFIX_ALL_CHILDREN, "")).listFiles();
                                if (listFiles != null && listFiles.length > 0) {
                                    int length = listFiles.length;
                                    while (i < length) {
                                        File file = listFiles[i];
                                        if (file.isFile()) {
                                            a(j, a, file, arrayList);
                                        }
                                        i++;
                                    }
                                }
                            } else if (str2.endsWith(AppStatusRules.SUFFIX_ALL_FILE)) {
                                File[] listFiles2 = new File(str, str2.substring(0, str2.lastIndexOf("/"))).listFiles();
                                String replace = str2.replace(AppStatusRules.SUFFIX_ALL_FILE, "");
                                int length2 = listFiles2.length;
                                while (i < length2) {
                                    File file2 = listFiles2[i];
                                    if (file2.isFile() && file2.getAbsolutePath().contains(replace)) {
                                        a(j, a, file2, arrayList);
                                    }
                                    i++;
                                }
                            } else if (a2 == null || !a2.startsWith(AppStatusRules.SUFFIX_ALL_FILE)) {
                                a(j, a, new File(str, str2), arrayList);
                            }
                        }
                    }
                }
            }
            return null;
        }
    }

    /* renamed from: com.kwad.sdk.collector.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0288b implements com.kwad.sdk.collector.a {
        @Override // com.kwad.sdk.collector.a
        public List<com.kwad.sdk.collector.model.b> a(AppStatusRules.Strategy strategy, Map<String, InstalledAppInfoManager.AppPackageInfo> map) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            com.kwad.sdk.collector.model.c.a(strategy, map, arrayList2);
            File file = new File(Environment.getExternalStorageDirectory(), "/Android/data/");
            int size = arrayList2.size();
            long[] jArr = new long[size];
            for (int i = 0; i < size; i++) {
                com.kwad.sdk.collector.model.a aVar = (com.kwad.sdk.collector.model.a) arrayList2.get(i);
                if (!(aVar instanceof AnalyseTaskNative)) {
                    return arrayList;
                }
                jArr[i] = ((AnalyseTaskNative) aVar).getNativePtr();
            }
            long[] analysis = AppStatusNative.analysis(jArr, file.getAbsolutePath() + "/");
            com.kwad.sdk.core.d.a.a("AppStatusAnalyserNative", "analysisByFile: runningInfoPtrs: " + analysis);
            for (long j : analysis) {
                arrayList.add(new AppRunningInfoNative(j));
            }
            com.kwad.sdk.core.d.a.a("AppStatusAnalyserNative", "analysisByFile: info size: " + arrayList.size());
            return arrayList;
        }

        @Override // com.kwad.sdk.collector.a
        public List<com.kwad.sdk.collector.model.e> a(List<com.kwad.sdk.collector.model.d> list, long j, String str) {
            int size = list.size();
            long[] jArr = new long[list.size()];
            for (int i = 0; i < size; i++) {
                com.kwad.sdk.collector.model.d dVar = list.get(i);
                if (dVar instanceof RulesTargetNative) {
                    jArr[i] = ((RulesTargetNative) dVar).getNativePtr();
                }
            }
            long[] nativeGetUploadEntry = AppStatusNative.nativeGetUploadEntry(jArr, j, str);
            ArrayList arrayList = new ArrayList();
            for (long j2 : nativeGetUploadEntry) {
                arrayList.add(new UploadEntryNative(j2));
            }
            return arrayList;
        }
    }

    public static com.kwad.sdk.collector.a a() {
        return com.kwad.sdk.core.config.b.ai() ? new C0288b() : new a();
    }
}
