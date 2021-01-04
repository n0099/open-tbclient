package com.ss.android.socialbase.appdownloader.f.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.annotation.NonNull;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class e {
    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [161=4] */
    public static android.content.pm.PackageInfo a(@androidx.annotation.NonNull java.io.File r14) {
        /*
            r10 = -1
            r3 = 0
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L1aa
            r1 = 24
            if (r0 < r1) goto L97
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L1aa
            r2.<init>(r14)     // Catch: java.lang.Throwable -> L1aa
            java.util.zip.ZipInputStream r0 = new java.util.zip.ZipInputStream     // Catch: java.lang.Throwable -> L1b1
            r0.<init>(r2)     // Catch: java.lang.Throwable -> L1b1
        L13:
            java.util.zip.ZipEntry r1 = r0.getNextEntry()     // Catch: java.lang.Throwable -> L1b1
            if (r1 == 0) goto L1c4
            boolean r4 = r1.isDirectory()     // Catch: java.lang.Throwable -> L1b1
            if (r4 == 0) goto L25
            r0.closeEntry()     // Catch: java.lang.Throwable -> L23
            goto L13
        L23:
            r1 = move-exception
            goto L13
        L25:
            java.lang.String r4 = "AndroidManifest.xml"
            java.lang.String r5 = r1.getName()     // Catch: java.lang.Throwable -> L1b1
            boolean r4 = r4.equals(r5)     // Catch: java.lang.Throwable -> L1b1
            if (r4 != 0) goto L38
            r0.closeEntry()     // Catch: java.lang.Throwable -> L36
            goto L13
        L36:
            r1 = move-exception
            goto L13
        L38:
            r4 = r3
            r12 = r0
            r5 = r2
            r6 = r0
            r7 = r1
        L3d:
            if (r7 == 0) goto L4c
            java.lang.String r0 = "AndroidManifest.xml"
            java.lang.String r1 = r7.getName()     // Catch: java.lang.Throwable -> L55
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Throwable -> L55
            if (r0 != 0) goto Lca
        L4c:
            com.ss.android.socialbase.appdownloader.f.a.c r0 = new com.ss.android.socialbase.appdownloader.f.a.c     // Catch: java.lang.Throwable -> L55
            java.lang.String r1 = "没有找到AndroidManifest.xml entry"
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L55
            throw r0     // Catch: java.lang.Throwable -> L55
        L55:
            r0 = move-exception
            r1 = r4
            r2 = r5
            r7 = r3
        L59:
            com.ss.android.socialbase.appdownloader.f.a.c r3 = new com.ss.android.socialbase.appdownloader.f.a.c     // Catch: java.lang.Throwable -> L7f
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7f
            r4.<init>()     // Catch: java.lang.Throwable -> L7f
            java.lang.String r5 = "throwable: "
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Throwable -> L7f
            java.lang.String r5 = r0.getMessage()     // Catch: java.lang.Throwable -> L7f
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Throwable -> L7f
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L7f
            java.lang.StringBuilder r0 = r4.append(r0)     // Catch: java.lang.Throwable -> L7f
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L7f
            r3.<init>(r0)     // Catch: java.lang.Throwable -> L7f
            throw r3     // Catch: java.lang.Throwable -> L7f
        L7f:
            r0 = move-exception
            r4 = r1
            r5 = r2
        L82:
            if (r7 == 0) goto L87
            r7.a()     // Catch: java.lang.Throwable -> L185
        L87:
            if (r6 == 0) goto L8c
            r6.close()     // Catch: java.lang.Throwable -> L188
        L8c:
            if (r4 == 0) goto L91
            r4.close()     // Catch: java.lang.Throwable -> L18b
        L91:
            if (r5 == 0) goto L96
            r5.close()     // Catch: java.lang.Throwable -> L18e
        L96:
            throw r0
        L97:
            java.util.zip.ZipFile r1 = new java.util.zip.ZipFile     // Catch: java.lang.Throwable -> L1aa
            r1.<init>(r14)     // Catch: java.lang.Throwable -> L1aa
            java.util.Enumeration r2 = r1.entries()     // Catch: java.lang.Throwable -> L1b7
            r0 = r3
        La1:
            boolean r4 = r2.hasMoreElements()     // Catch: java.lang.Throwable -> L1b7
            if (r4 == 0) goto L1bd
            java.lang.Object r0 = r2.nextElement()     // Catch: java.lang.Throwable -> L1b7
            java.util.zip.ZipEntry r0 = (java.util.zip.ZipEntry) r0     // Catch: java.lang.Throwable -> L1b7
            boolean r4 = r0.isDirectory()     // Catch: java.lang.Throwable -> L1b7
            if (r4 != 0) goto La1
            java.lang.String r4 = "AndroidManifest.xml"
            java.lang.String r5 = r0.getName()     // Catch: java.lang.Throwable -> L1b7
            boolean r4 = r4.equals(r5)     // Catch: java.lang.Throwable -> L1b7
            if (r4 == 0) goto La1
            java.io.InputStream r6 = r1.getInputStream(r0)     // Catch: java.lang.Throwable -> L1b7
            r4 = r1
            r12 = r3
            r5 = r3
            r7 = r0
            goto L3d
        Lca:
            com.ss.android.socialbase.appdownloader.f.a.a r7 = new com.ss.android.socialbase.appdownloader.f.a.a     // Catch: java.lang.Throwable -> L55
            r7.<init>()     // Catch: java.lang.Throwable -> L55
            r7.a(r6)     // Catch: java.lang.Throwable -> Le2
        Ld2:
            int r0 = r7.b()     // Catch: java.lang.Throwable -> Le2
            r1 = 1
            if (r0 != r1) goto Le7
            com.ss.android.socialbase.appdownloader.f.a.c r0 = new com.ss.android.socialbase.appdownloader.f.a.c     // Catch: java.lang.Throwable -> Le2
            java.lang.String r1 = "已达到END_DOCUMENT"
            r0.<init>(r1)     // Catch: java.lang.Throwable -> Le2
            throw r0     // Catch: java.lang.Throwable -> Le2
        Le2:
            r0 = move-exception
            r1 = r4
            r2 = r5
            goto L59
        Le7:
            r1 = 2
            if (r0 != r1) goto Ld2
            int r9 = r7.e()     // Catch: java.lang.Throwable -> Le2
            r8 = 0
            r0 = r3
            r1 = r3
            r2 = r3
        Lf2:
            if (r8 == r9) goto L12d
            java.lang.String r3 = "versionName"
            java.lang.String r13 = r7.a(r8)     // Catch: java.lang.Throwable -> Le2
            boolean r3 = r3.equals(r13)     // Catch: java.lang.Throwable -> Le2
            if (r3 == 0) goto L109
            java.lang.String r2 = a(r7, r8)     // Catch: java.lang.Throwable -> Le2
        L105:
            int r3 = r8 + 1
            r8 = r3
            goto Lf2
        L109:
            java.lang.String r3 = "versionCode"
            java.lang.String r13 = r7.a(r8)     // Catch: java.lang.Throwable -> Le2
            boolean r3 = r3.equals(r13)     // Catch: java.lang.Throwable -> Le2
            if (r3 == 0) goto L11b
            java.lang.String r1 = a(r7, r8)     // Catch: java.lang.Throwable -> Le2
            goto L105
        L11b:
            java.lang.String r3 = "package"
            java.lang.String r13 = r7.a(r8)     // Catch: java.lang.Throwable -> Le2
            boolean r3 = r3.equals(r13)     // Catch: java.lang.Throwable -> Le2
            if (r3 == 0) goto L105
            java.lang.String r0 = a(r7, r8)     // Catch: java.lang.Throwable -> Le2
            goto L105
        L12d:
            long r8 = java.lang.Long.parseLong(r1)     // Catch: java.lang.Throwable -> Le2 java.lang.Throwable -> L14f com.ss.android.socialbase.appdownloader.f.a.c -> L152
        L131:
            int r3 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r3 != 0) goto L155
            com.ss.android.socialbase.appdownloader.f.a.c r0 = new com.ss.android.socialbase.appdownloader.f.a.c     // Catch: java.lang.Throwable -> Le2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Le2
            r2.<init>()     // Catch: java.lang.Throwable -> Le2
            java.lang.String r3 = "versionCode获取失败: "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> Le2
            java.lang.StringBuilder r1 = r2.append(r1)     // Catch: java.lang.Throwable -> Le2
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> Le2
            r0.<init>(r1)     // Catch: java.lang.Throwable -> Le2
            throw r0     // Catch: java.lang.Throwable -> Le2
        L14f:
            r0 = move-exception
            goto L82
        L152:
            r3 = move-exception
            r8 = r10
            goto L131
        L155:
            android.content.pm.PackageInfo r1 = new android.content.pm.PackageInfo     // Catch: java.lang.Throwable -> Le2
            r1.<init>()     // Catch: java.lang.Throwable -> Le2
            r1.versionName = r2     // Catch: java.lang.Throwable -> Le2
            int r2 = (int) r8     // Catch: java.lang.Throwable -> Le2
            r1.versionCode = r2     // Catch: java.lang.Throwable -> Le2
            r1.packageName = r0     // Catch: java.lang.Throwable -> Le2
            if (r12 == 0) goto L166
            r12.closeEntry()     // Catch: java.lang.Throwable -> L17b
        L166:
            if (r7 == 0) goto L16b
            r7.a()     // Catch: java.lang.Throwable -> L17d
        L16b:
            if (r6 == 0) goto L170
            r6.close()     // Catch: java.lang.Throwable -> L17f
        L170:
            if (r4 == 0) goto L175
            r4.close()     // Catch: java.lang.Throwable -> L181
        L175:
            if (r5 == 0) goto L17a
            r5.close()     // Catch: java.lang.Throwable -> L183
        L17a:
            return r1
        L17b:
            r0 = move-exception
            goto L166
        L17d:
            r0 = move-exception
            goto L16b
        L17f:
            r0 = move-exception
            goto L170
        L181:
            r0 = move-exception
            goto L175
        L183:
            r0 = move-exception
            goto L17a
        L185:
            r1 = move-exception
            goto L87
        L188:
            r1 = move-exception
            goto L8c
        L18b:
            r1 = move-exception
            goto L91
        L18e:
            r1 = move-exception
            goto L96
        L191:
            r0 = move-exception
            r4 = r3
            r5 = r3
            r6 = r3
            r7 = r3
            goto L82
        L198:
            r0 = move-exception
            r4 = r3
            r5 = r2
            r6 = r3
            r7 = r3
            goto L82
        L19f:
            r0 = move-exception
            r4 = r1
            r5 = r3
            r6 = r3
            r7 = r3
            goto L82
        L1a6:
            r0 = move-exception
            r7 = r3
            goto L82
        L1aa:
            r0 = move-exception
            r1 = r3
            r2 = r3
            r6 = r3
            r7 = r3
            goto L59
        L1b1:
            r0 = move-exception
            r1 = r3
            r6 = r3
            r7 = r3
            goto L59
        L1b7:
            r0 = move-exception
            r2 = r3
            r6 = r3
            r7 = r3
            goto L59
        L1bd:
            r4 = r1
            r12 = r3
            r5 = r3
            r6 = r3
            r7 = r0
            goto L3d
        L1c4:
            r4 = r3
            r12 = r0
            r5 = r2
            r6 = r3
            r7 = r1
            goto L3d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.f.a.e.a(java.io.File):android.content.pm.PackageInfo");
    }

    public static PackageInfo a(@NonNull Context context, @NonNull File file, int i) {
        PackageInfo packageInfo = null;
        if (com.ss.android.socialbase.downloader.k.a.eJs().a("getpackageinfo_by_reflect", 0) == 1 && (packageInfo = l(context, file.getAbsolutePath(), i)) == null) {
            a("getPackageInfo::reflect", "packageInfo is null");
        }
        if (packageInfo == null) {
            if (com.ss.android.socialbase.downloader.m.a.a(268435456) && Build.VERSION.SDK_INT >= 21 && Build.VERSION.SDK_INT < 26) {
                try {
                    return a(file);
                } catch (Throwable th) {
                    a("getPackageInfo::unzip_getpackagearchiveinfo", th.getMessage());
                    return b(context, file, i);
                }
            }
            return b(context, file, i);
        }
        return packageInfo;
    }

    private static PackageInfo b(@NonNull Context context, @NonNull File file, int i) {
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

    private static void a(@NonNull String str, @NonNull String str2) {
        com.ss.android.socialbase.downloader.h.c eHq = com.ss.android.socialbase.downloader.downloader.b.eHq();
        if (eHq != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("message", str2);
            } catch (JSONException e) {
            }
            eHq.a(str, jSONObject);
        }
    }

    private static String a(int i) {
        return (i >>> 24) == 1 ? "android:" : "";
    }

    private static String a(a aVar, int i) {
        int b2 = aVar.b(i);
        int c = aVar.c(i);
        if (b2 == 3) {
            return aVar.Sh(i);
        }
        if (b2 == 2) {
            return String.format("?%s%08X", a(c), Integer.valueOf(c));
        }
        if (b2 >= 16 && b2 <= 31) {
            return String.valueOf(c);
        }
        return String.format("<0x%X, type 0x%02X>", Integer.valueOf(c), Integer.valueOf(b2));
    }

    public static PackageInfo l(Context context, String str, int i) {
        PackageInfo packageInfo;
        try {
            Object a2 = f.a(str);
            Object a3 = f.a(a2, str, 0);
            if (a3 == null) {
                return null;
            }
            if (i != 0) {
                if ((i & 786432) == 0) {
                    i |= 786432;
                }
                packageInfo = f.b(a2, a3, i);
            } else {
                packageInfo = null;
            }
            if (packageInfo == null) {
                return h(a3, i);
            }
            return packageInfo;
        } catch (Exception e) {
            a("getPackageInfo::reflect exception", e.getMessage());
            return null;
        }
    }

    private static PackageInfo h(Object obj, int i) throws Exception {
        ArrayList arrayList;
        PackageInfo packageInfo = new PackageInfo();
        String str = (String) f.a(obj, "packageName");
        if (str != null) {
            packageInfo.packageName = str;
        }
        String str2 = (String) f.a(obj, "mVersionName");
        if (str2 != null) {
            packageInfo.versionName = str2;
        }
        packageInfo.versionCode = ((Integer) f.a(obj, "mVersionCode")).intValue();
        if ((i & 4096) != 0 && (arrayList = (ArrayList) f.a(obj, "requestedPermissions")) != null) {
            packageInfo.requestedPermissions = (String[]) arrayList.toArray(new String[0]);
        }
        packageInfo.applicationInfo = (ApplicationInfo) f.a(obj, "applicationInfo");
        return packageInfo;
    }
}
