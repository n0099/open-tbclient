package com.ss.android.socialbase.appdownloader.f.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.annotation.NonNull;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.heytap.mcssdk.PushManager;
import java.io.File;
import java.io.FileInputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class e {
    public static String a(int i) {
        return (i >>> 24) == 1 ? "android:" : "";
    }

    public static PackageInfo a(@NonNull Context context, @NonNull File file, int i) {
        int i2;
        if (com.ss.android.socialbase.downloader.i.a.a(LaunchTaskConstants.OTHER_PROCESS) && (i2 = Build.VERSION.SDK_INT) >= 21 && i2 < 26) {
            try {
                return a(file);
            } catch (Throwable th) {
                a("getPackageInfo::unzip_getpackagearchiveinfo", th.getMessage());
                return b(context, file, i);
            }
        }
        return b(context, file, i);
    }

    public static PackageInfo b(@NonNull Context context, @NonNull File file, int i) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            a("unzip_getpackagearchiveinfo", "packageManager == null");
            return null;
        }
        try {
            return packageManager.getPackageArchiveInfo(file.getPath(), i);
        } catch (Throwable th) {
            a("unzip_getpackagearchiveinfo", "pm.getPackageArchiveInfo failed: " + th.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:116:0x0144 */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x006a, code lost:
        r13 = r1.getInputStream(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x006e, code lost:
        r4 = r1;
        r5 = r2;
        r1 = null;
        r13 = r13;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r2v10, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static PackageInfo a(@NonNull File file) {
        ZipInputStream zipInputStream;
        FileInputStream fileInputStream;
        ZipFile zipFile;
        ZipInputStream zipInputStream2;
        ZipFile zipFile2;
        ZipEntry zipEntry;
        FileInputStream fileInputStream2;
        ZipInputStream zipInputStream3;
        ZipFile zipFile3;
        ZipInputStream zipInputStream4;
        int b;
        long j;
        a aVar = null;
        aVar = null;
        String str = null;
        aVar = null;
        aVar = null;
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                FileInputStream fileInputStream3 = new FileInputStream(file);
                try {
                    ZipInputStream zipInputStream5 = new ZipInputStream(fileInputStream3);
                    while (true) {
                        ZipEntry nextEntry = zipInputStream5.getNextEntry();
                        if (nextEntry != null) {
                            if (nextEntry.isDirectory()) {
                                try {
                                    zipInputStream5.closeEntry();
                                } catch (Throwable unused) {
                                }
                            } else if (!"AndroidManifest.xml".equals(nextEntry.getName())) {
                                zipInputStream5.closeEntry();
                            } else {
                                zipFile3 = null;
                                zipEntry = nextEntry;
                                fileInputStream = fileInputStream3;
                                zipInputStream4 = zipInputStream5;
                                zipInputStream3 = zipInputStream5;
                                break;
                            }
                        } else {
                            zipFile3 = null;
                            zipEntry = nextEntry;
                            fileInputStream = fileInputStream3;
                            zipInputStream4 = zipInputStream5;
                            zipInputStream3 = null;
                            break;
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    zipFile = null;
                    fileInputStream = fileInputStream3;
                    zipInputStream = null;
                    try {
                        throw new c("throwable: " + th.getMessage() + th.toString());
                    } catch (Throwable th2) {
                        if (aVar != null) {
                            try {
                                aVar.a();
                            } catch (Throwable unused2) {
                            }
                        }
                        if (zipInputStream != null) {
                            try {
                                zipInputStream.close();
                            } catch (Throwable unused3) {
                            }
                        }
                        if (zipFile != null) {
                            try {
                                zipFile.close();
                            } catch (Throwable unused4) {
                            }
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable unused5) {
                            }
                        }
                        throw th2;
                    }
                }
            } else {
                ZipFile zipFile4 = new ZipFile(file);
                try {
                    Enumeration<? extends ZipEntry> entries = zipFile4.entries();
                    ZipEntry zipEntry2 = null;
                    while (true) {
                        if (entries.hasMoreElements()) {
                            zipEntry2 = entries.nextElement();
                            if (!zipEntry2.isDirectory() && "AndroidManifest.xml".equals(zipEntry2.getName())) {
                                break;
                            }
                        } else {
                            zipInputStream2 = null;
                            zipFile2 = zipFile4;
                            zipEntry = zipEntry2;
                            fileInputStream2 = null;
                            break;
                        }
                    }
                    fileInputStream = fileInputStream2;
                    zipInputStream4 = fileInputStream2;
                    zipFile3 = zipFile2;
                    zipInputStream3 = zipInputStream2;
                } catch (Throwable th3) {
                    th = th3;
                    fileInputStream = null;
                    zipFile = zipFile4;
                    zipInputStream = null;
                    throw new c("throwable: " + th.getMessage() + th.toString());
                }
            }
            if (zipEntry != null) {
                try {
                    if ("AndroidManifest.xml".equals(zipEntry.getName())) {
                        a aVar2 = new a();
                        try {
                            aVar2.a(zipInputStream3);
                            do {
                                b = aVar2.b();
                                if (b == 1) {
                                    throw new c("已达到END_DOCUMENT");
                                }
                            } while (b != 2);
                            int e = aVar2.e();
                            String str2 = null;
                            String str3 = null;
                            for (int i = 0; i != e; i++) {
                                if (PushManager.APP_VERSION_NAME.equals(aVar2.a(i))) {
                                    str2 = a(aVar2, i);
                                } else if (PushManager.APP_VERSION_CODE.equals(aVar2.a(i))) {
                                    str = a(aVar2, i);
                                } else if ("package".equals(aVar2.a(i))) {
                                    str3 = a(aVar2, i);
                                }
                            }
                            try {
                                j = Long.parseLong(str);
                            } catch (c unused6) {
                                j = -1;
                            }
                            if (j != -1) {
                                PackageInfo packageInfo = new PackageInfo();
                                packageInfo.versionName = str2;
                                packageInfo.versionCode = (int) j;
                                packageInfo.packageName = str3;
                                if (zipInputStream4 != null) {
                                    try {
                                        zipInputStream4.closeEntry();
                                    } catch (Throwable unused7) {
                                    }
                                }
                                try {
                                    aVar2.a();
                                } catch (Throwable unused8) {
                                }
                                if (zipInputStream3 != null) {
                                    try {
                                        zipInputStream3.close();
                                    } catch (Throwable unused9) {
                                    }
                                }
                                if (zipFile3 != null) {
                                    try {
                                        zipFile3.close();
                                    } catch (Throwable unused10) {
                                    }
                                }
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (Throwable unused11) {
                                    }
                                }
                                return packageInfo;
                            }
                            throw new c("versionCode获取失败: " + str);
                        } catch (Throwable th4) {
                            zipInputStream = zipInputStream3;
                            th = th4;
                            aVar = aVar2;
                            zipFile = zipFile3;
                            throw new c("throwable: " + th.getMessage() + th.toString());
                        }
                    }
                } catch (Throwable th5) {
                    zipInputStream = zipInputStream3;
                    th = th5;
                    zipFile = zipFile3;
                }
            }
            throw new c("没有找到AndroidManifest.xml entry");
        } catch (Throwable th6) {
            th = th6;
            zipInputStream = aVar;
            fileInputStream = zipInputStream;
            zipFile = fileInputStream;
        }
    }

    public static String a(Context context, PackageInfo packageInfo, String str) {
        ApplicationInfo applicationInfo;
        if (packageInfo != null && (applicationInfo = packageInfo.applicationInfo) != null) {
            applicationInfo.sourceDir = str;
            applicationInfo.publicSourceDir = str;
            try {
                return applicationInfo.loadLabel(context.getPackageManager()).toString();
            } catch (OutOfMemoryError e) {
                a("getPackageInfo::fail_load_label", e.getMessage());
                return null;
            }
        }
        return null;
    }

    public static String a(a aVar, int i) {
        int b = aVar.b(i);
        int c = aVar.c(i);
        if (b == 3) {
            return aVar.d(i);
        }
        if (b == 2) {
            return String.format("?%s%08X", a(c), Integer.valueOf(c));
        }
        if (b >= 16 && b <= 31) {
            return String.valueOf(c);
        }
        return String.format("<0x%X, type 0x%02X>", Integer.valueOf(c), Integer.valueOf(b));
    }

    public static void a(@NonNull String str, @NonNull String str2) {
        com.ss.android.socialbase.downloader.d.b g = com.ss.android.socialbase.downloader.downloader.c.g();
        if (g == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("message", str2);
        } catch (JSONException unused) {
        }
        g.a(str, jSONObject, null, null);
    }
}
