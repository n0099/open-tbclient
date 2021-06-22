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
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static String f29385a;

    /* renamed from: b  reason: collision with root package name */
    public static String f29386b;

    /* renamed from: g  reason: collision with root package name */
    public static volatile a f29387g;

    /* renamed from: c  reason: collision with root package name */
    public WeakHashMap<String, String> f29388c = new WeakHashMap<>();

    /* renamed from: f  reason: collision with root package name */
    public final LruCache<String, C0311a> f29391f = new LruCache<String, C0311a>(5242880) { // from class: com.bytedance.sdk.openadsdk.i.a.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.util.LruCache
        /* renamed from: a */
        public int sizeOf(String str, C0311a c0311a) {
            byte[] bArr = c0311a.f29393a;
            int length = bArr != null ? 0 + bArr.length : 0;
            return length == 0 ? super.sizeOf(str, c0311a) : length;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.util.LruCache
        /* renamed from: a */
        public void entryRemoved(boolean z, String str, C0311a c0311a, C0311a c0311a2) {
            super.entryRemoved(z, str, c0311a, c0311a2);
            if (!z || c0311a == null) {
                return;
            }
            c0311a.f29393a = null;
        }
    };

    /* renamed from: d  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.b.a f29389d = new com.bytedance.sdk.openadsdk.b.d();

    /* renamed from: e  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.b.a f29390e = new com.bytedance.sdk.openadsdk.b.d(DownloadManager.MIN_LEFT_SIZE, true);

    /* renamed from: com.bytedance.sdk.openadsdk.i.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0311a {

        /* renamed from: a  reason: collision with root package name */
        public byte[] f29393a;

        public C0311a(byte[] bArr) {
            this.f29393a = bArr;
        }
    }

    public static a a() {
        if (f29387g == null) {
            synchronized (a.class) {
                if (f29387g == null) {
                    f29387g = new a();
                }
            }
        }
        return f29387g;
    }

    public synchronized void b(String str, byte[] bArr) {
        FileOutputStream fileOutputStream;
        u.f("splashLoadAd", " GifCache put 将图片素材保存到本地 key " + str);
        if (!TextUtils.isEmpty(str) && bArr != null) {
            if (!a(bArr)) {
                this.f29391f.put(str, new C0311a(bArr));
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
                    this.f29389d.a(file);
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
                this.f29391f.put(str, new C0311a(bArr));
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
                    if (this.f29390e != null) {
                        this.f29390e.a(file);
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
        u.f("splashLoadAd", " put GifLoader.mIsSpalsh " + b.f29395b);
        if (b.f29395b) {
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

    public synchronized C0311a a(String str) {
        FileInputStream fileInputStream;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0311a c0311a = this.f29391f.get(str);
        if (c0311a != null) {
            return c0311a;
        }
        File file = new File(c(), str);
        if (file.exists()) {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    ByteBuffer allocate = ByteBuffer.allocate(Long.valueOf(file.length()).intValue());
                    fileInputStream.getChannel().read(allocate);
                    C0311a c0311a2 = new C0311a(allocate.array());
                    try {
                        fileInputStream.close();
                    } catch (IOException unused) {
                    }
                    return c0311a2;
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

    public synchronized C0311a b(String str) {
        FileInputStream fileInputStream;
        u.f("splashLoadAd", " GifCache get  key " + str);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C0311a c0311a = this.f29391f.get(str);
        if (c0311a != null) {
            return c0311a;
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
                    C0311a c0311a2 = new C0311a(allocate.array());
                    try {
                        fileInputStream.close();
                    } catch (IOException unused) {
                    }
                    return c0311a2;
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
        if (TextUtils.isEmpty(f29385a)) {
            f29385a = c("diskGif");
        }
        return f29385a;
    }

    public static String c(String str) {
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        boolean z = true;
        if (p.h().B() == 1) {
            File file = new File(d.b.c.b.a.h(p.a()), str);
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
            File file3 = new File(d.b.c.b.a.h(p.a()), str);
            file3.mkdirs();
            return file3.getAbsolutePath();
        }
        return str2;
    }

    public synchronized String a(String str, int i2, int i3, ImageView.ScaleType scaleType) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith("https")) {
            str = str.replaceFirst("https", "http");
        }
        String str2 = this.f29388c.get(str);
        if (TextUtils.isEmpty(str2)) {
            String a2 = j.a(str);
            this.f29388c.put(str, a2);
            return a2;
        }
        return str2;
    }

    public static String b() {
        if (TextUtils.isEmpty(f29386b)) {
            f29386b = c("splash_image");
        }
        return f29386b;
    }
}
