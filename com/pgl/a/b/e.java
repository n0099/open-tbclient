package com.pgl.a.b;

import android.content.Context;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static List<String> f11388a = new ArrayList();

    private static File a(Context context) {
        if (context == null || context.getFilesDir() == null) {
            return null;
        }
        File file = new File(context.getFilesDir(), "libso");
        if (file.exists()) {
            return file;
        }
        b.a(file.getAbsolutePath());
        return file;
    }

    public static synchronized boolean a(Context context, String str) {
        boolean z = true;
        synchronized (e.class) {
            if (!f11388a.contains(str)) {
                try {
                    System.loadLibrary(str);
                    f11388a.add(str);
                } catch (UnsatisfiedLinkError e) {
                    File bz = bz(context, str);
                    if (bz == null) {
                        z = false;
                    } else {
                        if (bz.exists()) {
                            bz.delete();
                        }
                        if (f(context, str, bz) != null) {
                            z = false;
                        } else {
                            try {
                                System.load(bz.getAbsolutePath());
                                f11388a.add(str);
                            } catch (Throwable th) {
                                z = false;
                            }
                        }
                    }
                } catch (Throwable th2) {
                    z = false;
                }
            }
        }
        return z;
    }

    private static File bz(Context context, String str) {
        String mapLibraryName = System.mapLibraryName(str);
        File a2 = a(context);
        if (a2 != null) {
            return new File(a2, mapLibraryName);
        }
        return null;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    private static java.lang.String f(android.content.Context r7, java.lang.String r8, java.io.File r9) {
        /*
            r1 = 0
            android.content.pm.ApplicationInfo r0 = r7.getApplicationInfo()     // Catch: java.lang.Throwable -> Lf1
            java.util.zip.ZipFile r4 = new java.util.zip.ZipFile     // Catch: java.lang.Throwable -> Lf1
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> Lf1
            java.lang.String r0 = r0.sourceDir     // Catch: java.lang.Throwable -> Lf1
            r2.<init>(r0)     // Catch: java.lang.Throwable -> Lf1
            r0 = 1
            r4.<init>(r2, r0)     // Catch: java.lang.Throwable -> Lf1
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lf6
            r0.<init>()     // Catch: java.lang.Throwable -> Lf6
            java.lang.String r2 = "lib/"
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch: java.lang.Throwable -> Lf6
            java.lang.String r2 = android.os.Build.CPU_ABI     // Catch: java.lang.Throwable -> Lf6
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch: java.lang.Throwable -> Lf6
            java.lang.String r2 = "/"
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch: java.lang.Throwable -> Lf6
            java.lang.String r2 = java.lang.System.mapLibraryName(r8)     // Catch: java.lang.Throwable -> Lf6
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch: java.lang.Throwable -> Lf6
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> Lf6
            java.util.zip.ZipEntry r0 = r4.getEntry(r0)     // Catch: java.lang.Throwable -> Lf6
            if (r0 != 0) goto L9c
            java.lang.String r0 = android.os.Build.CPU_ABI     // Catch: java.lang.Throwable -> Lf6
            r2 = 45
            int r0 = r0.indexOf(r2)     // Catch: java.lang.Throwable -> Lf6
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lf6
            r2.<init>()     // Catch: java.lang.Throwable -> Lf6
            java.lang.String r3 = "lib/"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> Lf6
            java.lang.String r3 = android.os.Build.CPU_ABI     // Catch: java.lang.Throwable -> Lf6
            r5 = 0
            if (r0 <= 0) goto L95
        L56:
            java.lang.String r0 = r3.substring(r5, r0)     // Catch: java.lang.Throwable -> Lf6
            java.lang.StringBuilder r0 = r2.append(r0)     // Catch: java.lang.Throwable -> Lf6
            java.lang.String r2 = "/"
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch: java.lang.Throwable -> Lf6
            java.lang.String r2 = java.lang.System.mapLibraryName(r8)     // Catch: java.lang.Throwable -> Lf6
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch: java.lang.Throwable -> Lf6
            java.lang.String r2 = r0.toString()     // Catch: java.lang.Throwable -> Lf6
            java.util.zip.ZipEntry r0 = r4.getEntry(r2)     // Catch: java.lang.Throwable -> Lf6
            if (r0 != 0) goto L9c
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lf6
            r0.<init>()     // Catch: java.lang.Throwable -> Lf6
            java.lang.String r3 = "Library entry not found:"
            java.lang.StringBuilder r0 = r0.append(r3)     // Catch: java.lang.Throwable -> Lf6
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch: java.lang.Throwable -> Lf6
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> Lf6
            com.pgl.a.b.b.a(r1)
            com.pgl.a.b.b.a(r1)
            com.pgl.a.b.b.b(r4)
        L94:
            return r0
        L95:
            java.lang.String r0 = android.os.Build.CPU_ABI     // Catch: java.lang.Throwable -> Lf6
            int r0 = r0.length()     // Catch: java.lang.Throwable -> Lf6
            goto L56
        L9c:
            r9.createNewFile()     // Catch: java.lang.Throwable -> Lf6
            java.io.InputStream r3 = r4.getInputStream(r0)     // Catch: java.lang.Throwable -> Lf6
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> Lfa
            r2.<init>(r9)     // Catch: java.lang.Throwable -> Lfa
            r0 = 16384(0x4000, float:2.2959E-41)
            byte[] r0 = new byte[r0]     // Catch: java.lang.Throwable -> Lb7
        Lac:
            int r5 = r3.read(r0)     // Catch: java.lang.Throwable -> Lb7
            if (r5 <= 0) goto Lc6
            r6 = 0
            r2.write(r0, r6, r5)     // Catch: java.lang.Throwable -> Lb7
            goto Lac
        Lb7:
            r0 = move-exception
        Lb8:
            java.lang.String r0 = r0.getMessage()     // Catch: java.lang.Throwable -> Lef
            com.pgl.a.b.b.a(r2)
            com.pgl.a.b.b.a(r3)
            com.pgl.a.b.b.b(r4)
            goto L94
        Lc6:
            java.lang.String r0 = r9.getAbsolutePath()     // Catch: java.lang.Throwable -> Lb7
            r5 = 493(0x1ed, float:6.91E-43)
            com.pgl.a.b.b.a(r0, r5)     // Catch: java.lang.Throwable -> Lb7
            com.pgl.a.b.b.a(r2)
            com.pgl.a.b.b.a(r3)
            com.pgl.a.b.b.b(r4)
            r0 = r1
            goto L94
        Lda:
            r0 = move-exception
            r2 = r1
            r3 = r1
            r4 = r1
        Lde:
            com.pgl.a.b.b.a(r2)
            com.pgl.a.b.b.a(r3)
            com.pgl.a.b.b.b(r4)
            throw r0
        Le8:
            r0 = move-exception
            r2 = r1
            r3 = r1
            goto Lde
        Lec:
            r0 = move-exception
            r2 = r1
            goto Lde
        Lef:
            r0 = move-exception
            goto Lde
        Lf1:
            r0 = move-exception
            r2 = r1
            r3 = r1
            r4 = r1
            goto Lb8
        Lf6:
            r0 = move-exception
            r2 = r1
            r3 = r1
            goto Lb8
        Lfa:
            r0 = move-exception
            r2 = r1
            goto Lb8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pgl.a.b.e.f(android.content.Context, java.lang.String, java.io.File):java.lang.String");
    }
}
