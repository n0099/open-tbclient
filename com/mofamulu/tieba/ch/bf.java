package com.mofamulu.tieba.ch;
/* loaded from: classes.dex */
public class bf {
    public static boolean a(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static boolean b(String str) {
        return (str == null || str.length() == 0) ? false : true;
    }

    public static int a(String str, int i) {
        try {
            return Integer.parseInt(str);
        } catch (Throwable th) {
            return i;
        }
    }

    public static String a(String str, String str2, String str3) {
        String str4 = null;
        if (str == null) {
            return null;
        }
        if (str2 == null || str2.length() == 0) {
            return str;
        }
        String[] a = a(str, str2);
        if (a.length != 0) {
            str4 = a[0];
            for (int i = 0; i < a.length - 1; i++) {
                str4 = String.valueOf(c(str4)) + str3 + a[i + 1];
            }
        }
        return c(str4);
    }

    public static String[] a(String str, String str2) {
        int i;
        int i2 = 1;
        if (str == null) {
            return new String[0];
        }
        String lowerCase = str.toLowerCase();
        String lowerCase2 = str2.toLowerCase();
        int length = lowerCase2.length();
        if (lowerCase.compareTo("") == 0) {
            i = 0;
        } else if (lowerCase.indexOf(lowerCase2) != -1) {
            int indexOf = lowerCase.indexOf(lowerCase2);
            int i3 = 0;
            int i4 = 1;
            while (lowerCase.indexOf(lowerCase2, indexOf + length) != -1) {
                indexOf = lowerCase.indexOf(lowerCase2, indexOf + length);
                i3 = i4;
                i4++;
            }
            i = i3 + 2;
        } else {
            i = 1;
        }
        String[] strArr = new String[i];
        if (lowerCase.compareTo("") != 0) {
            if (lowerCase.indexOf(lowerCase2) != -1) {
                int indexOf2 = lowerCase.indexOf(lowerCase2);
                strArr[0] = str.substring(0, indexOf2);
                while (lowerCase.indexOf(lowerCase2, indexOf2 + length) != -1) {
                    strArr[i2] = str.substring(indexOf2 + length, lowerCase.indexOf(lowerCase2, indexOf2 + length));
                    indexOf2 = lowerCase.indexOf(lowerCase2, indexOf2 + length);
                    i2++;
                }
                strArr[i2] = str.substring(indexOf2 + length, lowerCase.length());
                return strArr;
            }
            strArr[0] = str.substring(0, lowerCase.length());
            return strArr;
        }
        return strArr;
    }

    public static String c(String str) {
        if (str == null) {
            return "";
        }
        return str;
    }

    public static String b(String str, String str2, String str3) {
        String str4 = null;
        if (str == null) {
            return null;
        }
        if (str2 == null || str2.length() == 0) {
            return str;
        }
        String[] b = b(str, str2);
        if (b.length != 0) {
            str4 = b[0];
            for (int i = 0; i < b.length - 1; i++) {
                str4 = String.valueOf(c(str4)) + str3 + b[i + 1];
            }
        }
        return c(str4);
    }

    public static String[] b(String str, String str2) {
        int i;
        int i2 = 1;
        if (str == null) {
            return new String[0];
        }
        int length = str2.length();
        if (str.compareTo("") == 0) {
            i = 0;
        } else if (str.indexOf(str2) != -1) {
            int indexOf = str.indexOf(str2);
            int i3 = 0;
            int i4 = 1;
            while (str.indexOf(str2, indexOf + length) != -1) {
                indexOf = str.indexOf(str2, indexOf + length);
                i3 = i4;
                i4++;
            }
            i = i3 + 2;
        } else {
            i = 1;
        }
        String[] strArr = new String[i];
        if (str.compareTo("") != 0) {
            if (str.indexOf(str2) != -1) {
                int indexOf2 = str.indexOf(str2);
                strArr[0] = str.substring(0, indexOf2);
                while (str.indexOf(str2, indexOf2 + length) != -1) {
                    strArr[i2] = str.substring(indexOf2 + length, str.indexOf(str2, indexOf2 + length));
                    indexOf2 = str.indexOf(str2, indexOf2 + length);
                    i2++;
                }
                strArr[i2] = str.substring(indexOf2 + length, str.length());
                return strArr;
            }
            strArr[0] = str.substring(0, str.length());
            return strArr;
        }
        return strArr;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public static java.lang.String a(java.io.InputStream r7, java.lang.String r8) {
        /*
            r0 = 0
            java.lang.StringBuffer r2 = new java.lang.StringBuffer
            r1 = 8192(0x2000, float:1.148E-41)
            r2.<init>(r1)
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L42
            r1.<init>(r7, r8)     // Catch: java.lang.Throwable -> L42
            r3 = 4096(0x1000, float:5.74E-42)
            char[] r3 = new char[r3]     // Catch: java.lang.Throwable -> L2d
        L11:
            r4 = 0
            r5 = 4096(0x1000, float:5.74E-42)
            int r4 = r1.read(r3, r4, r5)     // Catch: java.lang.Throwable -> L2d
            r5 = -1
            if (r4 != r5) goto L26
            java.lang.String r0 = r2.toString()     // Catch: java.lang.Throwable -> L2d
            com.mofamulu.tieba.ch.ac.a(r1)
            com.mofamulu.tieba.ch.ac.a(r7)
        L25:
            return r0
        L26:
            if (r4 <= 0) goto L11
            r5 = 0
            r2.append(r3, r5, r4)     // Catch: java.lang.Throwable -> L2d
            goto L11
        L2d:
            r2 = move-exception
        L2e:
            com.mofamulu.tieba.ch.ac.a(r1)
            com.mofamulu.tieba.ch.ac.a(r7)
            goto L25
        L35:
            r1 = move-exception
            r6 = r1
            r1 = r0
            r0 = r6
        L39:
            com.mofamulu.tieba.ch.ac.a(r1)
            com.mofamulu.tieba.ch.ac.a(r7)
            throw r0
        L40:
            r0 = move-exception
            goto L39
        L42:
            r1 = move-exception
            r1 = r0
            goto L2e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mofamulu.tieba.ch.bf.a(java.io.InputStream, java.lang.String):java.lang.String");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public static byte[] a(java.io.InputStream r6) {
        /*
            r0 = 0
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L3b
            r1.<init>()     // Catch: java.lang.Throwable -> L3b
            r2 = 4096(0x1000, float:5.74E-42)
            byte[] r2 = new byte[r2]     // Catch: java.lang.Throwable -> L26
        La:
            r3 = 0
            r4 = 4096(0x1000, float:5.74E-42)
            int r3 = r6.read(r2, r3, r4)     // Catch: java.lang.Throwable -> L26
            r4 = -1
            if (r3 != r4) goto L1f
            byte[] r0 = r1.toByteArray()     // Catch: java.lang.Throwable -> L26
            com.mofamulu.tieba.ch.ac.a(r1)
            com.mofamulu.tieba.ch.ac.a(r6)
        L1e:
            return r0
        L1f:
            if (r3 <= 0) goto La
            r4 = 0
            r1.write(r2, r4, r3)     // Catch: java.lang.Throwable -> L26
            goto La
        L26:
            r2 = move-exception
        L27:
            com.mofamulu.tieba.ch.ac.a(r1)
            com.mofamulu.tieba.ch.ac.a(r6)
            goto L1e
        L2e:
            r1 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
        L32:
            com.mofamulu.tieba.ch.ac.a(r1)
            com.mofamulu.tieba.ch.ac.a(r6)
            throw r0
        L39:
            r0 = move-exception
            goto L32
        L3b:
            r1 = move-exception
            r1 = r0
            goto L27
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mofamulu.tieba.ch.bf.a(java.io.InputStream):byte[]");
    }
}
