package com.bytedance.sdk.openadsdk.i;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.utils.j;
import com.bytedance.sdk.openadsdk.utils.u;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.WeakHashMap;
/* loaded from: classes6.dex */
public class a extends d.c.c.b.b.a {

    /* renamed from: b  reason: collision with root package name */
    public static String f29436b;

    /* renamed from: c  reason: collision with root package name */
    public WeakHashMap<String, String> f29437c = new WeakHashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.b.a f29438d = new com.bytedance.sdk.openadsdk.b.d();

    public static a a() {
        return new a();
    }

    @Override // d.c.c.b.b.a, d.c.c.b.b.d.h
    public Bitmap b(String str) {
        FileInputStream fileInputStream;
        Bitmap b2 = super.b(str);
        if (b2 == null) {
            File file = new File(b(), str);
            if (file.exists()) {
                FileInputStream fileInputStream2 = null;
                try {
                    try {
                        fileInputStream = new FileInputStream(file);
                    } catch (IOException unused) {
                    }
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    b2 = BitmapFactory.decodeFileDescriptor(fileInputStream.getFD(), null, null);
                    if (b2 != null) {
                        super.a(str, b2, new byte[0]);
                    }
                    fileInputStream.close();
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream2 = fileInputStream;
                    try {
                        u.c("DiskImageCache", "diskImageCache getBitmap error ", th);
                        if (fileInputStream2 != null) {
                            fileInputStream2.close();
                        }
                        return b2;
                    } catch (Throwable th3) {
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException unused2) {
                            }
                        }
                        throw th3;
                    }
                }
            }
        }
        return b2;
    }

    @Override // d.c.c.b.b.a, d.c.c.b.b.d.h
    public void a(String str, Bitmap bitmap, byte[] bArr) {
        if (bitmap == null) {
            return;
        }
        super.a(str, bitmap, bArr);
        File file = new File(b(), str);
        if (file.exists() && file.isFile() && file.length() > 0) {
            return;
        }
        File file2 = new File(file + ".tmp");
        file2.delete();
        FileOutputStream fileOutputStream = null;
        try {
            try {
                file2.createNewFile();
                FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                try {
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream2);
                    fileOutputStream2.flush();
                    if (file2.exists() && file2.length() > 0) {
                        file2.renameTo(file);
                    }
                    this.f29438d.a(file);
                    fileOutputStream2.close();
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    try {
                        u.c("DiskImageCache", "diskImageCache putBitmap error ", th);
                        file2.delete();
                        file.delete();
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                    } catch (Throwable th2) {
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused) {
                            }
                        }
                        throw th2;
                    }
                }
            } catch (IOException unused2) {
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static String b() {
        if (TextUtils.isEmpty(f29436b)) {
            File file = new File(d.c.c.b.a.h(p.a()), "diskImage");
            file.mkdirs();
            f29436b = file.getAbsolutePath();
        }
        return f29436b;
    }

    @Override // d.c.c.b.b.a, d.c.c.b.b.d.h
    public String a(String str, int i, int i2, ImageView.ScaleType scaleType) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String str2 = this.f29437c.get(str);
        if (TextUtils.isEmpty(str2)) {
            String a2 = j.a(str);
            this.f29437c.put(str, a2);
            return a2;
        }
        return str2;
    }
}
