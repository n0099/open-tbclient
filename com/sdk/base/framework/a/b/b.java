package com.sdk.base.framework.a.b;
/* loaded from: classes14.dex */
public final class b {
    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public static java.io.File a(java.net.HttpURLConnection r14, com.sdk.base.framework.a.b.c r15, java.lang.String r16, boolean r17, java.lang.String r18) {
        /*
            if (r14 == 0) goto L8
            boolean r2 = android.text.TextUtils.isEmpty(r16)
            if (r2 == 0) goto La
        L8:
            r2 = 0
        L9:
            return r2
        La:
            java.io.File r9 = new java.io.File
            r0 = r16
            r9.<init>(r0)
            boolean r2 = r9.exists()
            if (r2 != 0) goto L2a
            java.io.File r2 = r9.getParentFile()
            boolean r3 = r2.exists()
            if (r3 != 0) goto L27
            boolean r2 = r2.mkdirs()
            if (r2 == 0) goto L2a
        L27:
            r9.createNewFile()
        L2a:
            r6 = 0
            r8 = 0
            r3 = 0
            if (r17 == 0) goto L62
            long r6 = r9.length()     // Catch: java.lang.Throwable -> L6a
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L6a
            r4 = 1
            r0 = r16
            r2.<init>(r0, r4)     // Catch: java.lang.Throwable -> L6a
        L3c:
            int r4 = r14.getContentLength()     // Catch: java.lang.Throwable -> L6a
            long r4 = (long) r4     // Catch: java.lang.Throwable -> L6a
            long r4 = r4 + r6
            java.io.BufferedInputStream r11 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L6a
            java.io.InputStream r10 = r14.getInputStream()     // Catch: java.lang.Throwable -> L6a
            r11.<init>(r10)     // Catch: java.lang.Throwable -> L6a
            java.io.BufferedOutputStream r10 = new java.io.BufferedOutputStream     // Catch: java.lang.Throwable -> L126
            r10.<init>(r2)     // Catch: java.lang.Throwable -> L126
            if (r15 == 0) goto Lb7
            r8 = 1
            r3 = r15
            boolean r2 = r3.a(r4, r6, r8)     // Catch: java.lang.Throwable -> L12a
            if (r2 != 0) goto Lb7
            r11.close()     // Catch: java.lang.Throwable -> L106
        L5d:
            r10.close()     // Catch: java.lang.Throwable -> L109
        L60:
            r2 = r9
            goto L9
        L62:
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L6a
            r0 = r16
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L6a
            goto L3c
        L6a:
            r2 = move-exception
            r4 = r8
        L6c:
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L123
            if (r4 == 0) goto L74
            r4.close()     // Catch: java.lang.Throwable -> L112
        L74:
            if (r3 == 0) goto L79
            r3.close()     // Catch: java.lang.Throwable -> L115
        L79:
            boolean r2 = r9.exists()
            if (r2 == 0) goto L103
            boolean r2 = android.text.TextUtils.isEmpty(r18)
            if (r2 != 0) goto L103
            java.io.File r2 = new java.io.File
            java.lang.String r3 = r9.getParent()
            r0 = r18
            r2.<init>(r3, r0)
        L90:
            boolean r3 = r2.exists()
            if (r3 == 0) goto Lfa
            java.io.File r2 = new java.io.File
            java.lang.String r3 = r9.getParent()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            long r6 = java.lang.System.currentTimeMillis()
            java.lang.StringBuilder r4 = r4.append(r6)
            r0 = r18
            java.lang.StringBuilder r4 = r4.append(r0)
            java.lang.String r4 = r4.toString()
            r2.<init>(r3, r4)
            goto L90
        Lb7:
            r2 = 4096(0x1000, float:5.74E-42)
            byte[] r2 = new byte[r2]     // Catch: java.lang.Throwable -> L12a
        Lbb:
            int r3 = r11.read(r2)     // Catch: java.lang.Throwable -> L12a
            r8 = -1
            if (r3 == r8) goto Ldb
            r8 = 0
            r10.write(r2, r8, r3)     // Catch: java.lang.Throwable -> L12a
            long r12 = (long) r3     // Catch: java.lang.Throwable -> L12a
            long r6 = r6 + r12
            if (r15 == 0) goto Lbb
            r8 = 0
            r3 = r15
            boolean r3 = r3.a(r4, r6, r8)     // Catch: java.lang.Throwable -> L12a
            if (r3 != 0) goto Lbb
            r11.close()     // Catch: java.lang.Throwable -> L10c
        Ld5:
            r10.close()     // Catch: java.lang.Throwable -> L10e
        Ld8:
            r2 = r9
            goto L9
        Ldb:
            r10.flush()     // Catch: java.lang.Throwable -> L12a
            if (r15 == 0) goto Le5
            r8 = 1
            r3 = r15
            r3.a(r4, r6, r8)     // Catch: java.lang.Throwable -> L12a
        Le5:
            r11.close()     // Catch: java.lang.Throwable -> L110
        Le8:
            r10.close()     // Catch: java.lang.Throwable -> Lec
            goto L79
        Lec:
            r2 = move-exception
            goto L79
        Lee:
            r2 = move-exception
        Lef:
            if (r8 == 0) goto Lf4
            r8.close()     // Catch: java.lang.Throwable -> L118
        Lf4:
            if (r3 == 0) goto Lf9
            r3.close()     // Catch: java.lang.Throwable -> L11a
        Lf9:
            throw r2
        Lfa:
            boolean r3 = r9.renameTo(r2)
            if (r3 != 0) goto L9
            r2 = r9
            goto L9
        L103:
            r2 = r9
            goto L9
        L106:
            r2 = move-exception
            goto L5d
        L109:
            r2 = move-exception
            goto L60
        L10c:
            r2 = move-exception
            goto Ld5
        L10e:
            r2 = move-exception
            goto Ld8
        L110:
            r2 = move-exception
            goto Le8
        L112:
            r2 = move-exception
            goto L74
        L115:
            r2 = move-exception
            goto L79
        L118:
            r4 = move-exception
            goto Lf4
        L11a:
            r3 = move-exception
            goto Lf9
        L11c:
            r2 = move-exception
            r8 = r11
            goto Lef
        L11f:
            r2 = move-exception
            r3 = r10
            r8 = r11
            goto Lef
        L123:
            r2 = move-exception
            r8 = r4
            goto Lef
        L126:
            r2 = move-exception
            r4 = r11
            goto L6c
        L12a:
            r2 = move-exception
            r3 = r10
            r4 = r11
            goto L6c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sdk.base.framework.a.b.b.a(java.net.HttpURLConnection, com.sdk.base.framework.a.b.c, java.lang.String, boolean, java.lang.String):java.io.File");
    }
}
