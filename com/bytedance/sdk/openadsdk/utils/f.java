package com.bytedance.sdk.openadsdk.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.annotation.Nullable;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
/* loaded from: classes6.dex */
public class f {
    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    @androidx.annotation.Nullable
    public static java.lang.String a(android.graphics.Bitmap r4) {
        /*
            r0 = 0
            if (r4 != 0) goto L4
        L3:
            return r0
        L4:
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L2a
            r1.<init>()     // Catch: java.lang.Throwable -> L2a
            android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.PNG     // Catch: java.lang.Throwable -> L49
            r3 = 100
            r4.compress(r2, r3, r1)     // Catch: java.lang.Throwable -> L49
            r1.flush()     // Catch: java.lang.Throwable -> L49
            r1.close()     // Catch: java.lang.Throwable -> L49
            byte[] r2 = r1.toByteArray()     // Catch: java.lang.Throwable -> L49
            r3 = 0
            java.lang.String r0 = android.util.Base64.encodeToString(r2, r3)     // Catch: java.lang.Throwable -> L49
            if (r1 == 0) goto L3
            r1.flush()     // Catch: java.lang.Throwable -> L28
            r1.close()     // Catch: java.lang.Throwable -> L28
            goto L3
        L28:
            r1 = move-exception
            goto L3
        L2a:
            r1 = move-exception
            r1 = r0
        L2c:
            if (r1 == 0) goto L3
            r1.flush()     // Catch: java.lang.Throwable -> L35
            r1.close()     // Catch: java.lang.Throwable -> L35
            goto L3
        L35:
            r1 = move-exception
            goto L3
        L37:
            r1 = move-exception
            r2 = r1
            r3 = r0
        L3a:
            if (r3 == 0) goto L42
            r3.flush()     // Catch: java.lang.Throwable -> L43
            r3.close()     // Catch: java.lang.Throwable -> L43
        L42:
            throw r2
        L43:
            r0 = move-exception
            goto L42
        L45:
            r0 = move-exception
            r2 = r0
            r3 = r1
            goto L3a
        L49:
            r2 = move-exception
            goto L2c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.utils.f.a(android.graphics.Bitmap):java.lang.String");
    }

    @Nullable
    public static Bitmap a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] decode = Base64.decode(str, 0);
            return BitmapFactory.decodeByteArray(decode, 0, decode.length);
        } catch (Throwable th) {
            return null;
        }
    }

    public static byte[] b(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bitmap.getByteCount());
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static Bitmap a(Bitmap bitmap, int i, int i2) {
        Bitmap bitmap2;
        if (bitmap == null) {
            return null;
        }
        if (!bitmap.isRecycled()) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            Log.i("BitmapUtils", width + " originWidth");
            Log.i("BitmapUtils", height + " originHeight");
            if (width >= i || height >= i2) {
                if (width > i) {
                    height = (int) Math.floor(height / ((width * 1.0d) / i));
                    bitmap2 = (i <= 0 || height <= 0 || bitmap.isRecycled()) ? bitmap : Bitmap.createScaledBitmap(bitmap, i, height, false);
                } else {
                    i = width;
                    bitmap2 = bitmap;
                }
                if (height <= i2) {
                    i2 = height;
                } else if (i > 0 && i2 > 0 && !bitmap2.isRecycled()) {
                    bitmap2 = Bitmap.createBitmap(bitmap2, 0, 0, i, i2);
                }
                Log.i("BitmapUtils", i + " width");
                Log.i("BitmapUtils", i2 + " height");
                return bitmap2;
            }
            return bitmap;
        }
        return bitmap;
    }

    public static Bitmap a(Bitmap bitmap, int i) {
        if (bitmap != null && bitmap.getRowBytes() * bitmap.getHeight() >= i) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            int i2 = 90;
            while (byteArrayOutputStream.toByteArray().length > i) {
                byteArrayOutputStream.reset();
                bitmap.compress(Bitmap.CompressFormat.PNG, i2, byteArrayOutputStream);
                i2 -= 10;
            }
            return BitmapFactory.decodeStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()), null, null);
        }
        return bitmap;
    }

    public static Bitmap b(Bitmap bitmap, int i, int i2) {
        if (bitmap == null) {
            return null;
        }
        if (i > 0 && i2 > 0) {
            try {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                if (i < width && i2 < height) {
                    Matrix matrix = new Matrix();
                    matrix.postScale(i / width, i2 / height);
                    return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
                }
                return bitmap;
            } catch (Throwable th) {
                u.a(th.getMessage());
                return null;
            }
        }
        return bitmap;
    }
}
