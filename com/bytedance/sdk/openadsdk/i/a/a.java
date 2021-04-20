package com.bytedance.sdk.openadsdk.i.a;

import android.os.Environment;
import android.text.TextUtils;
import android.util.LruCache;
import android.widget.ImageView;
import com.baidu.clientupdate.download.DownloadManager;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.utils.j;
import com.bytedance.sdk.openadsdk.utils.l;
import com.bytedance.sdk.openadsdk.utils.u;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.WeakHashMap;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static String f29124a;

    /* renamed from: b  reason: collision with root package name */
    public static String f29125b;

    /* renamed from: g  reason: collision with root package name */
    public static volatile a f29126g;

    /* renamed from: c  reason: collision with root package name */
    public WeakHashMap<String, String> f29127c = new WeakHashMap<>();

    /* renamed from: f  reason: collision with root package name */
    public final LruCache<String, C0323a> f29130f = new LruCache<String, C0323a>(5242880) { // from class: com.bytedance.sdk.openadsdk.i.a.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.util.LruCache
        /* renamed from: a */
        public int sizeOf(String str, C0323a c0323a) {
            byte[] bArr = c0323a.f29132a;
            int length = bArr != null ? 0 + bArr.length : 0;
            return length == 0 ? super.sizeOf(str, c0323a) : length;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.util.LruCache
        /* renamed from: a */
        public void entryRemoved(boolean z, String str, C0323a c0323a, C0323a c0323a2) {
            super.entryRemoved(z, str, c0323a, c0323a2);
            if (!z || c0323a == null) {
                return;
            }
            c0323a.f29132a = null;
        }
    };

    /* renamed from: d  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.b.a f29128d = new com.bytedance.sdk.openadsdk.b.d();

    /* renamed from: e  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.b.a f29129e = new com.bytedance.sdk.openadsdk.b.d(DownloadManager.MIN_LEFT_SIZE, true);

    /* renamed from: com.bytedance.sdk.openadsdk.i.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0323a {

        /* renamed from: a  reason: collision with root package name */
        public byte[] f29132a;

        public C0323a(byte[] bArr) {
            this.f29132a = bArr;
        }
    }

    public static a a() {
        if (f29126g == null) {
            synchronized (a.class) {
                if (f29126g == null) {
                    f29126g = new a();
                }
            }
        }
        return f29126g;
    }

    public synchronized void b(String str, byte[] bArr) {
        FileOutputStream fileOutputStream;
        u.f("splashLoadAd", " GifCache put 将图片素材保存到本地 key " + str);
        if (!TextUtils.isEmpty(str) && bArr != null) {
            if (!a(bArr)) {
                this.f29130f.put(str, new C0323a(bArr));
            }
            File file = new File(c(), str);
            if (file.exists() && file.isFile() && file.length() > 0) {
                return;
            }
            u.f("splashLoadAd", " GifCache put 将图片素材保存到本地 target " + file.getPath());
            File file2 = new File(file + ".tmp");
            file2.delete();
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    file2.createNewFile();
                    fileOutputStream = new FileOutputStream(file2);
                } catch (IOException unused) {
                }
                try {
                    fileOutputStream.write(bArr);
                    fileOutputStream.flush();
                    if (file2.exists() && file2.length() > 0) {
                        if (file.exists()) {
                            file.delete();
                        }
                        file2.renameTo(file);
                    }
                    this.f29128d.a(file);
                    fileOutputStream.close();
                } catch (Throwable unused2) {
                    fileOutputStream2 = fileOutputStream;
                    file2.delete();
                    file.delete();
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                }
            } catch (Throwable unused3) {
            }
        }
    }

    public synchronized void c(String str, byte[] bArr) {
        FileOutputStream fileOutputStream;
        u.f("splashLoadAd", " GifCache put 将图片素材保存到本地 key " + str);
        if (!TextUtils.isEmpty(str) && bArr != null) {
            if (!a(bArr)) {
                this.f29130f.put(str, new C0323a(bArr));
            }
            u.f("splashLoadAd", " GifCache put 保存到本地图片的素材路径 getCacheDir() " + b());
            File file = new File(b(), str);
            if (file.exists() && file.isFile() && file.length() > 0) {
                u.f("splashLoadAd", " GifCache put 本地的gif素材以及存在 key " + str);
                return;
            }
            File file2 = new File(file + ".tmp");
            file2.delete();
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    file2.createNewFile();
                    fileOutputStream = new FileOutputStream(file2);
                } catch (IOException unused) {
                }
                try {
                    fileOutputStream.write(bArr);
                    fileOutputStream.flush();
                    u.f("splashLoadAd", " GifCache put 图片素材写入本地成功 " + str);
                    if (file2.exists() && file2.length() > 0) {
                        if (file.exists()) {
                            file.delete();
                        }
                        file2.renameTo(file);
                    }
                    if (this.f29129e != null) {
                        this.f29129e.a(file);
                    }
                    fileOutputStream.close();
                } catch (Throwable unused2) {
                    fileOutputStream2 = fileOutputStream;
                    file2.delete();
                    file.delete();
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                }
            } catch (Throwable unused3) {
            }
        }
    }

    public synchronized void a(String str, byte[] bArr) {
        u.f("splashLoadAd", " put GifLoader.mIsSpalsh " + b.f29134b);
        if (b.f29134b) {
            c(str, bArr);
        } else {
            b(str, bArr);
        }
    }

    private boolean a(byte[] bArr) {
        return bArr != null && bArr.length >= 3 && bArr[0] == 71 && bArr[1] == 73 && bArr[2] == 70;
    }

    public synchronized File a(String str, boolean z) {
        File file;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (z) {
            file = new File(b(), str);
        } else {
            file = new File(c(), str);
        }
        if (file.exists()) {
            if (file.length() > 0) {
                return file;
            }
        }
        return null;
    }

    public synchronized C0323a a(String str) {
        FileInputStream fileInputStream;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0323a c0323a = this.f29130f.get(str);
        if (c0323a != null) {
            return c0323a;
        }
        File file = new File(c(), str);
        if (file.exists()) {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    ByteBuffer allocate = ByteBuffer.allocate(Long.valueOf(file.length()).intValue());
                    fileInputStream.getChannel().read(allocate);
                    C0323a c0323a2 = new C0323a(allocate.array());
                    try {
                        fileInputStream.close();
                    } catch (IOException unused) {
                    }
                    return c0323a2;
                } catch (Throwable th) {
                    th = th;
                    u.c("GifCache", "gifCache get error ", th);
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = null;
            }
        }
        return null;
    }

    public synchronized C0323a b(String str) {
        FileInputStream fileInputStream;
        u.f("splashLoadAd", " GifCache get  key " + str);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0323a c0323a = this.f29130f.get(str);
        if (c0323a != null) {
            return c0323a;
        }
        u.f("splashLoadAd", " GifCache 从缓存文件中获取图片素材，图片路径为" + b() + " key " + str);
        File file = new File(b(), str);
        try {
            l.b(file);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (file.exists()) {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    ByteBuffer allocate = ByteBuffer.allocate(Long.valueOf(file.length()).intValue());
                    fileInputStream.getChannel().read(allocate);
                    C0323a c0323a2 = new C0323a(allocate.array());
                    try {
                        fileInputStream.close();
                    } catch (IOException unused) {
                    }
                    return c0323a2;
                } catch (Throwable th) {
                    th = th;
                    u.c("GifCache", "gifCache get error ", th);
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    u.f("splashLoadAd", " GifCache 缓存文件中不存在该图片素材  key " + str);
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = null;
            }
        }
        u.f("splashLoadAd", " GifCache 缓存文件中不存在该图片素材  key " + str);
        return null;
    }

    public static String c() {
        if (TextUtils.isEmpty(f29124a)) {
            f29124a = c("diskGif");
        }
        return f29124a;
    }

    public static String c(String str) {
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        boolean z = true;
        if (p.h().B() == 1) {
            File file = new File(d.c.c.b.a.h(p.a()), str);
            file.mkdirs();
            return file.getAbsolutePath();
        }
        if (!"mounted".equals(Environment.getExternalStorageState()) && Environment.isExternalStorageRemovable()) {
            z = false;
        }
        File file2 = null;
        if (z) {
            try {
                u.f("splashLoadAd", "当存在外部存储并且开屏支持外部存储");
                file2 = new File(p.a().getExternalCacheDir(), str);
                file2.mkdirs();
                str2 = file2.getAbsolutePath();
            } catch (Throwable unused) {
                return "";
            }
        }
        if (file2 == null) {
            File file3 = new File(d.c.c.b.a.h(p.a()), str);
            file3.mkdirs();
            return file3.getAbsolutePath();
        }
        return str2;
    }

    public synchronized String a(String str, int i, int i2, ImageView.ScaleType scaleType) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith("https")) {
            str = str.replaceFirst("https", "http");
        }
        String str2 = this.f29127c.get(str);
        if (TextUtils.isEmpty(str2)) {
            String a2 = j.a(str);
            this.f29127c.put(str, a2);
            return a2;
        }
        return str2;
    }

    public static String b() {
        if (TextUtils.isEmpty(f29125b)) {
            f29125b = c("splash_image");
        }
        return f29125b;
    }
}
