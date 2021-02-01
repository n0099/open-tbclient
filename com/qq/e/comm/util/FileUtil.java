package com.qq.e.comm.util;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
/* loaded from: classes15.dex */
public class FileUtil {
    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public static boolean copyTo(java.io.InputStream r7, java.io.File r8) {
        /*
            r1 = 1
            r3 = 0
            r0 = 0
            if (r7 == 0) goto L7
            if (r8 != 0) goto L8
        L7:
            return r0
        L8:
            java.io.File r2 = r8.getParentFile()     // Catch: java.lang.Throwable -> L64
            boolean r2 = r2.exists()     // Catch: java.lang.Throwable -> L64
            if (r2 != 0) goto L23
            java.io.File r2 = r8.getParentFile()     // Catch: java.lang.Throwable -> L64
            boolean r2 = r2.mkdirs()     // Catch: java.lang.Throwable -> L64
            if (r2 != 0) goto L23
            tryClose(r7)
            tryClose(r3)
            goto L7
        L23:
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L64
            r2.<init>(r8)     // Catch: java.lang.Throwable -> L64
            r3 = 4096(0x1000, float:5.74E-42)
            byte[] r3 = new byte[r3]     // Catch: java.lang.Throwable -> L37
        L2c:
            int r4 = r7.read(r3)     // Catch: java.lang.Throwable -> L37
            if (r4 <= 0) goto L53
            r5 = 0
            r2.write(r3, r5, r4)     // Catch: java.lang.Throwable -> L37
            goto L2c
        L37:
            r1 = move-exception
        L38:
            java.lang.String r3 = "Exception while copy from InputStream to File %s"
            r4 = 1
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> L6a
            r5 = 0
            java.lang.String r6 = r8.getAbsolutePath()     // Catch: java.lang.Throwable -> L6a
            r4[r5] = r6     // Catch: java.lang.Throwable -> L6a
            java.lang.String r3 = java.lang.String.format(r3, r4)     // Catch: java.lang.Throwable -> L6a
            com.qq.e.comm.util.GDTLogger.e(r3, r1)     // Catch: java.lang.Throwable -> L6a
            tryClose(r7)
            tryClose(r2)
            goto L7
        L53:
            tryClose(r7)
            tryClose(r2)
            r0 = r1
            goto L7
        L5b:
            r1 = move-exception
            r0 = r2
        L5d:
            tryClose(r7)
            tryClose(r0)
            throw r1
        L64:
            r1 = move-exception
            r2 = r3
            goto L38
        L67:
            r1 = move-exception
            r0 = r3
            goto L5d
        L6a:
            r1 = move-exception
            r0 = r2
            goto L5d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.util.FileUtil.copyTo(java.io.InputStream, java.io.File):boolean");
    }

    public static String getFileName(String str) {
        return Md5Util.encode(str);
    }

    public static String getTempFileName(String str) {
        return Md5Util.encode(str) + ".temp";
    }

    public static boolean renameTo(File file, File file2) {
        if (file == null || file2 == null || !file.exists()) {
            return false;
        }
        if (file.renameTo(file2)) {
            return true;
        }
        return copyTo(null, file2);
    }

    public static void tryClose(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception e) {
            }
        }
    }

    public static void tryClose(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (Exception e) {
            }
        }
    }
}
