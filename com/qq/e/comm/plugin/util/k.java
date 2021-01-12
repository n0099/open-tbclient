package com.qq.e.comm.plugin.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.util.GDTLogger;
import java.io.File;
import java.io.FileInputStream;
/* loaded from: classes3.dex */
public class k {
    public static int a(BitmapFactory.Options options, ImageView imageView) {
        int i = options.outWidth;
        int i2 = options.outHeight;
        int a2 = a(imageView);
        int b2 = b(imageView);
        if (i > a2 || i2 > b2) {
            return Math.max(Math.round((i * 1.0f) / a2), Math.round((i2 * 1.0f) / b2));
        }
        return 1;
    }

    public static int a(ImageView imageView) {
        Context appContext = GDTADManager.getInstance().getAppContext();
        int i = 0;
        if (imageView != null) {
            i = imageView.getWidth();
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            if (layoutParams != null && i <= 0) {
                i = layoutParams.width;
            }
        }
        return i <= 0 ? ak.b(appContext) : i;
    }

    public static Bitmap a(File file, ImageView imageView) {
        return a(file.getAbsolutePath(), imageView);
    }

    public static Bitmap a(String str, ImageView imageView) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        BitmapFactory.decodeFile(str, options);
        options.inSampleSize = a(options, imageView);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(str, options);
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x0100 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(File file) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        boolean z = false;
        if (file == null) {
            GDTLogger.e("image file is null");
        } else if (!file.exists()) {
            GDTLogger.e(file.getAbsolutePath() + " not exist");
        } else if (file.length() < 6) {
            GDTLogger.e(file.getAbsolutePath() + " size too short, len = " + file.length());
        } else {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    try {
                        byte[] bArr = new byte[6];
                        int read = fileInputStream.read(bArr);
                        if (read < 6) {
                            GDTLogger.e(file.getAbsolutePath() + " only read " + read + " bytes!");
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Exception e) {
                                    GDTLogger.e(e.getMessage());
                                }
                            }
                        } else {
                            if (bArr[0] == 71 && bArr[1] == 73 && bArr[2] == 70 && bArr[3] == 56 && ((bArr[4] == 55 || bArr[4] == 57) && bArr[5] == 97)) {
                                z = true;
                            }
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Exception e2) {
                                    GDTLogger.e(e2.getMessage());
                                }
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                        GDTLogger.e(e.getMessage());
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e4) {
                                GDTLogger.e(e4.getMessage());
                            }
                        }
                        return z;
                    }
                } catch (Throwable th) {
                    th = th;
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (Exception e5) {
                            GDTLogger.e(e5.getMessage());
                        }
                    }
                    throw th;
                }
            } catch (Exception e6) {
                e = e6;
                fileInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                if (fileInputStream2 != null) {
                }
                throw th;
            }
        }
        return z;
    }

    public static int b(ImageView imageView) {
        Context appContext = GDTADManager.getInstance().getAppContext();
        int i = 0;
        if (imageView != null) {
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            i = imageView.getHeight();
            if (i <= 0 && layoutParams != null) {
                i = layoutParams.height;
            }
        }
        return i <= 0 ? ak.c(appContext) : i;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public static android.graphics.Movie b(java.io.File r12) {
        /*
            r11 = 0
            r1 = 0
            long r4 = java.lang.System.currentTimeMillis()
            boolean r0 = a(r12)
            if (r0 == 0) goto Lc5
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L132
            r3.<init>(r12)     // Catch: java.lang.Throwable -> L132
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L137
            r2 = 1024(0x400, float:1.435E-42)
            r0.<init>(r2)     // Catch: java.lang.Throwable -> L137
            r2 = 1024(0x400, float:1.435E-42)
            byte[] r2 = new byte[r2]     // Catch: java.lang.Throwable -> L27
        L1c:
            int r6 = r3.read(r2)     // Catch: java.lang.Throwable -> L27
            if (r6 <= 0) goto Lc6
            r7 = 0
            r0.write(r2, r7, r6)     // Catch: java.lang.Throwable -> L27
            goto L1c
        L27:
            r2 = move-exception
        L28:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L12e
            r6.<init>()     // Catch: java.lang.Throwable -> L12e
            java.lang.String r7 = "decode movie failed: "
            java.lang.StringBuilder r6 = r6.append(r7)     // Catch: java.lang.Throwable -> L12e
            java.lang.String r2 = r2.getMessage()     // Catch: java.lang.Throwable -> L12e
            java.lang.StringBuilder r2 = r6.append(r2)     // Catch: java.lang.Throwable -> L12e
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L12e
            com.qq.e.comm.util.GDTLogger.e(r2)     // Catch: java.lang.Throwable -> L12e
            if (r3 == 0) goto L48
            r3.close()     // Catch: java.lang.Exception -> Lf4
        L48:
            if (r0 == 0) goto L13b
            r0.close()     // Catch: java.lang.Exception -> Lfe
            r0 = r1
        L4e:
            if (r0 == 0) goto L13e
            long r2 = java.lang.System.currentTimeMillis()
            long r6 = r12.length()
            float r6 = (float) r6
            r7 = 1149239296(0x44800000, float:1024.0)
            float r6 = r6 / r7
            int r7 = r0.width()
            int r8 = r0.height()
            java.lang.String r9 = "![%.2fKB, %d*%d, len=%dms, cost=%dms](%s)"
            r10 = 6
            java.lang.Object[] r10 = new java.lang.Object[r10]
            java.lang.Float r6 = java.lang.Float.valueOf(r6)
            r10[r11] = r6
            r6 = 1
            java.lang.Integer r11 = java.lang.Integer.valueOf(r7)
            r10[r6] = r11
            r6 = 2
            java.lang.Integer r11 = java.lang.Integer.valueOf(r8)
            r10[r6] = r11
            r6 = 3
            int r11 = r0.duration()
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            r10[r6] = r11
            r6 = 4
            long r2 = r2 - r4
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r10[r6] = r2
            r2 = 5
            java.io.File r3 = r12.getAbsoluteFile()
            r10[r2] = r3
            java.lang.String r2 = java.lang.String.format(r9, r10)
            com.qq.e.comm.util.GDTLogger.d(r2)
            if (r7 == 0) goto La3
            if (r8 != 0) goto L13e
        La3:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "invalid gif width or height, w = "
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.StringBuilder r0 = r0.append(r7)
            java.lang.String r2 = ", h = "
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.StringBuilder r0 = r0.append(r8)
            java.lang.String r0 = r0.toString()
            com.qq.e.comm.util.GDTLogger.e(r0)
        Lc5:
            return r1
        Lc6:
            r0.flush()     // Catch: java.lang.Throwable -> L27
            byte[] r2 = r0.toByteArray()     // Catch: java.lang.Throwable -> L27
            r6 = 0
            int r7 = r2.length     // Catch: java.lang.Throwable -> L27
            android.graphics.Movie r2 = android.graphics.Movie.decodeByteArray(r2, r6, r7)     // Catch: java.lang.Throwable -> L27
            if (r3 == 0) goto Ld8
            r3.close()     // Catch: java.lang.Exception -> Leb
        Ld8:
            if (r0 == 0) goto L140
            r0.close()     // Catch: java.lang.Exception -> Le0
            r0 = r2
            goto L4e
        Le0:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.qq.e.comm.util.GDTLogger.e(r0)
            r0 = r2
            goto L4e
        Leb:
            r3 = move-exception
            java.lang.String r3 = r3.getMessage()
            com.qq.e.comm.util.GDTLogger.e(r3)
            goto Ld8
        Lf4:
            r2 = move-exception
            java.lang.String r2 = r2.getMessage()
            com.qq.e.comm.util.GDTLogger.e(r2)
            goto L48
        Lfe:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.qq.e.comm.util.GDTLogger.e(r0)
            r0 = r1
            goto L4e
        L109:
            r0 = move-exception
            r2 = r1
            r3 = r1
            r4 = r0
        L10d:
            if (r3 == 0) goto L112
            r3.close()     // Catch: java.lang.Exception -> L118
        L112:
            if (r2 == 0) goto L117
            r2.close()     // Catch: java.lang.Exception -> L121
        L117:
            throw r4
        L118:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.qq.e.comm.util.GDTLogger.e(r0)
            goto L112
        L121:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.qq.e.comm.util.GDTLogger.e(r0)
            goto L117
        L12a:
            r0 = move-exception
            r2 = r1
            r4 = r0
            goto L10d
        L12e:
            r1 = move-exception
            r2 = r0
            r4 = r1
            goto L10d
        L132:
            r2 = move-exception
            r0 = r1
            r3 = r1
            goto L28
        L137:
            r2 = move-exception
            r0 = r1
            goto L28
        L13b:
            r0 = r1
            goto L4e
        L13e:
            r1 = r0
            goto Lc5
        L140:
            r0 = r2
            goto L4e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.util.k.b(java.io.File):android.graphics.Movie");
    }
}
