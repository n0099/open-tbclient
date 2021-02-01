package com.bytedance.sdk.openadsdk.i.a;

import android.os.Environment;
import android.text.TextUtils;
import android.util.LruCache;
import android.widget.ImageView;
import com.baidubce.services.bos.BosClientConfiguration;
import com.bytedance.sdk.openadsdk.b.d;
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
import org.apache.http.HttpHost;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static String f7188a;

    /* renamed from: b  reason: collision with root package name */
    private static String f7189b;
    private static volatile a g;
    private WeakHashMap<String, String> c = new WeakHashMap<>();
    private final LruCache<String, C1019a> f = new LruCache<String, C1019a>(BosClientConfiguration.DEFAULT_STREAM_BUFFER_SIZE) { // from class: com.bytedance.sdk.openadsdk.i.a.a.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        /* renamed from: a */
        public int sizeOf(String str, C1019a c1019a) {
            int length = c1019a.f7191a != null ? 0 + c1019a.f7191a.length : 0;
            return length == 0 ? super.sizeOf(str, c1019a) : length;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        /* renamed from: a */
        public void entryRemoved(boolean z, String str, C1019a c1019a, C1019a c1019a2) {
            super.entryRemoved(z, str, c1019a, c1019a2);
            if (z && c1019a != null) {
                c1019a.f7191a = null;
            }
        }
    };
    private final com.bytedance.sdk.openadsdk.b.a d = new d();
    private final com.bytedance.sdk.openadsdk.b.a e = new d(20971520, true);

    public static a a() {
        if (g == null) {
            synchronized (a.class) {
                if (g == null) {
                    g = new a();
                }
            }
        }
        return g;
    }

    private a() {
    }

    public synchronized void a(String str, byte[] bArr) {
        u.f("splashLoadAd", " put GifLoader.mIsSpalsh " + b.f7193b);
        if (b.f7193b) {
            c(str, bArr);
        } else {
            b(str, bArr);
        }
    }

    public synchronized void b(String str, byte[] bArr) {
        FileOutputStream fileOutputStream;
        u.f("splashLoadAd", " GifCache put 将图片素材保存到本地 key " + str);
        if (!TextUtils.isEmpty(str) && bArr != null) {
            if (!a(bArr)) {
                this.f.put(str, new C1019a(bArr));
            }
            File file = new File(c(), str);
            if (!file.exists() || !file.isFile() || file.length() <= 0) {
                u.f("splashLoadAd", " GifCache put 将图片素材保存到本地 target " + file.getPath());
                File file2 = new File(file + ".tmp");
                file2.delete();
                try {
                    file2.createNewFile();
                    fileOutputStream = new FileOutputStream(file2);
                } catch (Throwable th) {
                    fileOutputStream = null;
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
                    this.d.a(file);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e) {
                        }
                    }
                } catch (Throwable th2) {
                    file2.delete();
                    file.delete();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e2) {
                        }
                    }
                }
            }
        }
    }

    public synchronized void c(String str, byte[] bArr) {
        FileOutputStream fileOutputStream;
        u.f("splashLoadAd", " GifCache put 将图片素材保存到本地 key " + str);
        if (!TextUtils.isEmpty(str) && bArr != null) {
            if (!a(bArr)) {
                this.f.put(str, new C1019a(bArr));
            }
            u.f("splashLoadAd", " GifCache put 保存到本地图片的素材路径 getCacheDir() " + b());
            File file = new File(b(), str);
            if (file.exists() && file.isFile() && file.length() > 0) {
                u.f("splashLoadAd", " GifCache put 本地的gif素材以及存在 key " + str);
            } else {
                File file2 = new File(file + ".tmp");
                file2.delete();
                try {
                    file2.createNewFile();
                    fileOutputStream = new FileOutputStream(file2);
                } catch (Throwable th) {
                    fileOutputStream = null;
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
                    if (this.e != null) {
                        this.e.a(file);
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e) {
                        }
                    }
                } catch (Throwable th2) {
                    file2.delete();
                    file.delete();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e2) {
                        }
                    }
                }
            }
        }
    }

    private boolean a(byte[] bArr) {
        return bArr != null && bArr.length >= 3 && bArr[0] == 71 && bArr[1] == 73 && bArr[2] == 70;
    }

    public synchronized File a(String str, boolean z) {
        File file;
        File file2 = null;
        synchronized (this) {
            if (!TextUtils.isEmpty(str)) {
                if (z) {
                    file = new File(b(), str);
                } else {
                    file = new File(c(), str);
                }
                if (file.exists()) {
                    if (file.length() > 0) {
                        file2 = file;
                    }
                }
            }
        }
        return file2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [256=4, 253=5, 254=5] */
    public synchronized C1019a a(String str) {
        C1019a c1019a;
        FileInputStream fileInputStream;
        if (TextUtils.isEmpty(str)) {
            c1019a = null;
        } else {
            c1019a = this.f.get(str);
            if (c1019a == null) {
                File file = new File(c(), str);
                if (file.exists()) {
                    try {
                        fileInputStream = new FileInputStream(file);
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream = null;
                    }
                    try {
                        ByteBuffer allocate = ByteBuffer.allocate(Long.valueOf(file.length()).intValue());
                        fileInputStream.getChannel().read(allocate);
                        c1019a = new C1019a(allocate.array());
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e) {
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        u.c("GifCache", "gifCache get error ", th);
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e2) {
                            }
                        }
                        c1019a = null;
                        return c1019a;
                    }
                }
                c1019a = null;
            }
        }
        return c1019a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [305=5, 306=5, 308=4] */
    public synchronized C1019a b(String str) {
        C1019a c1019a;
        FileInputStream fileInputStream;
        u.f("splashLoadAd", " GifCache get  key " + str);
        if (TextUtils.isEmpty(str)) {
            c1019a = null;
        } else {
            c1019a = this.f.get(str);
            if (c1019a == null) {
                u.f("splashLoadAd", " GifCache 从缓存文件中获取图片素材，图片路径为" + b() + " key " + str);
                File file = new File(b(), str);
                try {
                    l.b(file);
                } catch (Throwable th) {
                }
                if (file.exists()) {
                    try {
                        fileInputStream = new FileInputStream(file);
                        try {
                            ByteBuffer allocate = ByteBuffer.allocate(Long.valueOf(file.length()).intValue());
                            fileInputStream.getChannel().read(allocate);
                            c1019a = new C1019a(allocate.array());
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e) {
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            u.c("GifCache", "gifCache get error ", th);
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e2) {
                                }
                            }
                            u.f("splashLoadAd", " GifCache 缓存文件中不存在该图片素材  key " + str);
                            c1019a = null;
                            return c1019a;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        fileInputStream = null;
                    }
                }
                u.f("splashLoadAd", " GifCache 缓存文件中不存在该图片素材  key " + str);
                c1019a = null;
            }
        }
        return c1019a;
    }

    public synchronized String a(String str, int i, int i2, ImageView.ScaleType scaleType) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            str2 = null;
        } else {
            if (str.startsWith("https")) {
                str = str.replaceFirst("https", HttpHost.DEFAULT_SCHEME_NAME);
            }
            str2 = this.c.get(str);
            if (TextUtils.isEmpty(str2)) {
                str2 = j.a(str);
                this.c.put(str, str2);
            }
        }
        return str2;
    }

    private static String c() {
        if (TextUtils.isEmpty(f7188a)) {
            f7188a = c("diskGif");
        }
        return f7188a;
    }

    private static String c(String str) {
        String absolutePath;
        boolean z = true;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (p.h().C() == 1) {
            File file = new File(com.bytedance.sdk.adnet.a.b(p.a()), str);
            file.mkdirs();
            return file.getAbsolutePath();
        }
        if (!"mounted".equals(Environment.getExternalStorageState()) && Environment.isExternalStorageRemovable()) {
            z = false;
        }
        File file2 = null;
        if (!z) {
            absolutePath = "";
        } else {
            try {
                u.f("splashLoadAd", "当存在外部存储并且开屏支持外部存储");
                file2 = new File(p.a().getExternalCacheDir(), str);
                file2.mkdirs();
                absolutePath = file2.getAbsolutePath();
            } catch (Throwable th) {
                return "";
            }
        }
        if (file2 == null) {
            try {
                File file3 = new File(com.bytedance.sdk.adnet.a.b(p.a()), str);
                file3.mkdirs();
                return file3.getAbsolutePath();
            } catch (Throwable th2) {
                return absolutePath;
            }
        }
        return absolutePath;
    }

    public static String b() {
        if (TextUtils.isEmpty(f7189b)) {
            f7189b = c("splash_image");
        }
        return f7189b;
    }

    /* renamed from: com.bytedance.sdk.openadsdk.i.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1019a {

        /* renamed from: a  reason: collision with root package name */
        byte[] f7191a;

        public C1019a(byte[] bArr) {
            this.f7191a = bArr;
        }
    }
}
