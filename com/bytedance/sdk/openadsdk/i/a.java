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
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class a extends com.bytedance.sdk.adnet.b.a {

    /* renamed from: b  reason: collision with root package name */
    private static String f7485b;
    private WeakHashMap<String, String> c = new WeakHashMap<>();
    private final com.bytedance.sdk.openadsdk.b.a d = new com.bytedance.sdk.openadsdk.b.d();

    public static a a() {
        return new a();
    }

    private a() {
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, MOVE_EXCEPTION, INVOKE, MOVE_EXCEPTION] complete} */
    @Override // com.bytedance.sdk.adnet.b.a, com.bytedance.sdk.adnet.b.d.b
    public Bitmap a(String str) {
        FileInputStream fileInputStream;
        Bitmap a2 = super.a(str);
        if (a2 == null) {
            File file = new File(b(), str);
            if (file.exists()) {
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        a2 = BitmapFactory.decodeFileDescriptor(fileInputStream.getFD(), null, null);
                        if (a2 != null) {
                            super.a(str, a2);
                        }
                    } catch (Throwable th) {
                        th = th;
                        try {
                            u.c("DiskImageCache", "diskImageCache getBitmap error ", th);
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e) {
                                }
                            }
                            return a2;
                        } finally {
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e2) {
                                }
                            }
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = null;
                }
            }
        }
        return a2;
    }

    @Override // com.bytedance.sdk.adnet.b.a, com.bytedance.sdk.adnet.b.d.b
    public void a(String str, Bitmap bitmap) {
        FileOutputStream fileOutputStream;
        if (bitmap != null) {
            super.a(str, bitmap);
            File file = new File(b(), str);
            if (!file.exists() || !file.isFile() || file.length() <= 0) {
                File file2 = new File(file + ".tmp");
                file2.delete();
                try {
                    file2.createNewFile();
                    fileOutputStream = new FileOutputStream(file2);
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = null;
                }
                try {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                    fileOutputStream.flush();
                    if (file2.exists() && file2.length() > 0) {
                        file2.renameTo(file);
                    }
                    this.d.a(file);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e) {
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        u.c("DiskImageCache", "diskImageCache putBitmap error ", th);
                        file2.delete();
                        file.delete();
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e2) {
                            }
                        }
                    } catch (Throwable th3) {
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e3) {
                            }
                        }
                        throw th3;
                    }
                }
            }
        }
    }

    @Override // com.bytedance.sdk.adnet.b.a, com.bytedance.sdk.adnet.b.d.b
    public String a(String str, int i, int i2, ImageView.ScaleType scaleType) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String str2 = this.c.get(str);
        if (TextUtils.isEmpty(str2)) {
            String a2 = j.a(str);
            this.c.put(str, a2);
            return a2;
        }
        return str2;
    }

    private static String b() {
        if (TextUtils.isEmpty(f7485b)) {
            File file = new File(com.bytedance.sdk.adnet.a.b(p.a()), "diskImage");
            file.mkdirs();
            f7485b = file.getAbsolutePath();
        }
        return f7485b;
    }
}
