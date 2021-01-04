package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.os.Environment;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class l {
    public static File a(Context context, boolean z, String str, String str2) {
        String a2 = a(context);
        if (z) {
            str = "/" + aa.a(context) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str;
        }
        String str3 = a2 + str;
        File file = new File(str3);
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(str3, str2);
    }

    public static File b(Context context, boolean z, String str, String str2) {
        String b2 = b(context);
        if (z) {
            str = "/" + aa.a(context) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str;
        }
        String str3 = b2 + str;
        File file = new File(str3);
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(str3, str2);
    }

    private static String a(Context context) {
        if (context == null) {
            return null;
        }
        File externalCacheDir = "mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable() ? context.getExternalCacheDir() : null;
        if (externalCacheDir == null) {
            externalCacheDir = context.getCacheDir();
        }
        if (externalCacheDir != null) {
            return externalCacheDir.getPath();
        }
        return null;
    }

    private static String b(Context context) {
        File cacheDir;
        if (context == null || (cacheDir = context.getCacheDir()) == null) {
            return null;
        }
        return cacheDir.getPath();
    }

    public static List<File> a(File file) {
        LinkedList linkedList = new LinkedList();
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            List<File> asList = Arrays.asList(listFiles);
            Collections.sort(asList, new a());
            return asList;
        }
        return linkedList;
    }

    public static void b(File file) throws IOException {
        if (file.exists()) {
            u.f("splashLoadAd", "当文件存在更新文件的修改时间");
            long currentTimeMillis = System.currentTimeMillis();
            if (!file.setLastModified(currentTimeMillis)) {
                e(file);
                if (file.lastModified() < currentTimeMillis) {
                    u.d("Files", "Last modified date " + new Date(file.lastModified()) + " is not set for file " + file.getAbsolutePath());
                }
            }
        }
    }

    public static void c(File file) {
        if (file != null && file.exists()) {
            if (file.isFile()) {
                try {
                    file.delete();
                    return;
                } catch (Throwable th) {
                    return;
                }
            }
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    if (file2.isDirectory()) {
                        c(file2);
                    } else {
                        try {
                            file2.delete();
                        } catch (Throwable th2) {
                        }
                    }
                }
            }
            try {
                file.delete();
            } catch (Throwable th3) {
            }
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [212=4] */
    private static void e(java.io.File r8) throws java.io.IOException {
        /*
            r6 = 1
            long r2 = r8.length()
            r0 = 0
            int r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r0 != 0) goto L10
            f(r8)
        Lf:
            return
        L10:
            r1 = 0
            java.io.RandomAccessFile r0 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> L2f
            java.lang.String r4 = "rwd"
            r0.<init>(r8, r4)     // Catch: java.lang.Throwable -> L2f
            long r4 = r2 - r6
            r0.seek(r4)     // Catch: java.lang.Throwable -> L44
            byte r1 = r0.readByte()     // Catch: java.lang.Throwable -> L44
            long r2 = r2 - r6
            r0.seek(r2)     // Catch: java.lang.Throwable -> L44
            r0.write(r1)     // Catch: java.lang.Throwable -> L44
            if (r0 == 0) goto Lf
            r0.close()
            goto Lf
        L2f:
            r0 = move-exception
            r0 = r1
        L31:
            if (r0 == 0) goto Lf
            r0.close()
            goto Lf
        L37:
            r0 = move-exception
            r2 = r0
            r3 = r1
        L3a:
            if (r3 == 0) goto L3f
            r3.close()
        L3f:
            throw r2
        L40:
            r1 = move-exception
            r2 = r1
            r3 = r0
            goto L3a
        L44:
            r1 = move-exception
            goto L31
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.utils.l.e(java.io.File):void");
    }

    private static void f(File file) throws IOException {
        if (!file.delete() || !file.createNewFile()) {
            throw new IOException("Error recreate zero-size file " + file);
        }
    }

    /* loaded from: classes4.dex */
    private static final class a implements Comparator<File> {
        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(File file, File file2) {
            return a(file.lastModified(), file2.lastModified());
        }

        private int a(long j, long j2) {
            if (j < j2) {
                return -1;
            }
            return j == j2 ? 0 : 1;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [251=5, 253=4] */
    public static byte[] d(java.io.File r8) {
        /*
            r1 = 0
            if (r8 == 0) goto L4a
            boolean r0 = r8.isFile()
            if (r0 == 0) goto L4a
            boolean r0 = r8.exists()
            if (r0 == 0) goto L4a
            boolean r0 = r8.canRead()
            if (r0 == 0) goto L4a
            long r2 = r8.length()
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L4a
            long r2 = r8.length()     // Catch: java.lang.Throwable -> L4c
            java.lang.Long r3 = java.lang.Long.valueOf(r2)     // Catch: java.lang.Throwable -> L4c
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L4c
            r2.<init>(r8)     // Catch: java.lang.Throwable -> L4c
            int r0 = r3.intValue()     // Catch: java.lang.Throwable -> L66
            byte[] r0 = new byte[r0]     // Catch: java.lang.Throwable -> L66
            int r4 = r2.read(r0)     // Catch: java.lang.Throwable -> L66
            long r4 = (long) r4     // Catch: java.lang.Throwable -> L66
            long r6 = r3.longValue()     // Catch: java.lang.Throwable -> L66
            int r3 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r3 != 0) goto L45
            if (r2 == 0) goto L44
            r2.close()     // Catch: java.lang.Throwable -> L5e
        L44:
            return r0
        L45:
            if (r2 == 0) goto L4a
            r2.close()     // Catch: java.lang.Throwable -> L60
        L4a:
            r0 = r1
            goto L44
        L4c:
            r0 = move-exception
            r0 = r1
        L4e:
            if (r0 == 0) goto L4a
            r0.close()     // Catch: java.lang.Throwable -> L54
            goto L4a
        L54:
            r0 = move-exception
            goto L4a
        L56:
            r0 = move-exception
            r2 = r1
        L58:
            if (r2 == 0) goto L5d
            r2.close()     // Catch: java.lang.Throwable -> L62
        L5d:
            throw r0
        L5e:
            r1 = move-exception
            goto L44
        L60:
            r0 = move-exception
            goto L4a
        L62:
            r1 = move-exception
            goto L5d
        L64:
            r0 = move-exception
            goto L58
        L66:
            r0 = move-exception
            r0 = r2
            goto L4e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.utils.l.d(java.io.File):byte[]");
    }
}
