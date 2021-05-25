package d.a.f0.a.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.LruCache;
import com.baidu.mobads.container.util.cache.CacheEngine;
import com.baidu.mobads.container.util.filedownloader.MaterialLoader;
import com.baidu.sdk.container.filedownloader.MaterialLoader;
import d.a.f0.a.c.d;
import d.a.f0.a.k.i;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: g  reason: collision with root package name */
    public static volatile a f39760g = null;

    /* renamed from: h  reason: collision with root package name */
    public static int f39761h = 30000000;

    /* renamed from: i  reason: collision with root package name */
    public static int f39762i = 50000000;

    /* renamed from: a  reason: collision with root package name */
    public final LruCache<String, d.a.f0.a.c.c<?>> f39763a = new LruCache<>(6);

    /* renamed from: b  reason: collision with root package name */
    public final d.a.f0.a.c.d f39764b;

    /* renamed from: c  reason: collision with root package name */
    public final d.a.f0.a.c.d f39765c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, d.a.f0.a.c.d> f39766d;

    /* renamed from: e  reason: collision with root package name */
    public final String f39767e;

    /* renamed from: f  reason: collision with root package name */
    public final String f39768f;

    /* renamed from: d.a.f0.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0526a implements d<Bitmap> {
        public C0526a(a aVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.f0.a.c.a.d
        /* renamed from: a */
        public Bitmap parseFromBytes(byte[] bArr) {
            if (bArr == null) {
                return null;
            }
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                options.inPurgeable = true;
                options.inInputShareable = true;
                return BitmapFactory.decodeStream(new ByteArrayInputStream(bArr), null, options);
            } catch (OutOfMemoryError unused) {
                d.a.f0.a.k.b.i().h(CacheEngine.TAG, "图片请求失败，OOM");
                return null;
            } catch (Throwable unused2) {
                d.a.f0.a.k.b.i().h(CacheEngine.TAG, "图片请求失败，解析异常");
                return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.f0.a.c.a.d
        /* renamed from: b */
        public <D> Bitmap rawGet(D d2) {
            if (d2 instanceof Bitmap) {
                return (Bitmap) d2;
            }
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.e {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f39769a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f39770b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.f0.a.c.d f39771c;

        public b(a aVar, String str, c cVar, d.a.f0.a.c.d dVar) {
            this.f39769a = str;
            this.f39770b = cVar;
            this.f39771c = dVar;
        }

        @Override // d.a.f0.a.c.d.e
        public void a(String str, d.a.f0.a.c.c<File> cVar) {
        }

        @Override // d.a.f0.a.c.d.e
        public void b(String str, d.a.f0.a.c.c<File> cVar) {
            if (this.f39769a.equals(str)) {
                this.f39770b.onCacheFailed();
                this.f39771c.q(this);
            }
        }

        @Override // d.a.f0.a.c.d.e
        public void c(String str, d.a.f0.a.c.c<File> cVar) {
            if (this.f39769a.equals(str)) {
                this.f39770b.onCacheComplete();
                this.f39771c.q(this);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
        void onCacheComplete();

        void onCacheFailed();
    }

    /* loaded from: classes2.dex */
    public interface d<T> {
        T parseFromBytes(byte[] bArr);

        <D> T rawGet(D d2);
    }

    public a(Context context) {
        String d2 = i.d(context);
        this.f39767e = d2 + MaterialLoader.IMAGE_CACHE_PATH;
        this.f39768f = d2 + MaterialLoader.VIDEO_CACHE_PATH;
        this.f39764b = d.a.f0.a.c.d.o(this.f39767e, f39761h);
        this.f39765c = d.a.f0.a.c.d.o(this.f39768f, f39762i);
        this.f39766d = new ConcurrentHashMap();
    }

    public static String a(String str) {
        return Pattern.compile("[^a-zA-Z0-9]").matcher(str).replaceAll("").trim();
    }

    public static a e(Context context) {
        if (f39760g == null) {
            synchronized (a.class) {
                if (f39760g == null && context != null) {
                    f39760g = new a(context.getApplicationContext());
                }
            }
        }
        return f39760g;
    }

    public final String b(String str, d.a.f0.a.c.d dVar) {
        String a2 = a(str);
        return dVar.k() + a2;
    }

    public final d.a.f0.a.c.d c(MaterialLoader.MaterialCacheType materialCacheType) {
        if (materialCacheType == MaterialLoader.MaterialCacheType.VIDEO) {
            return this.f39765c;
        }
        return this.f39764b;
    }

    public String d(String str, MaterialLoader.MaterialCacheType materialCacheType) {
        String a2 = a(str);
        if (f(str, materialCacheType)) {
            return c(materialCacheType).k() + a2;
        }
        return null;
    }

    public boolean f(String str, MaterialLoader.MaterialCacheType materialCacheType) {
        boolean z = g(a(str), materialCacheType) != null;
        d.a.f0.a.c.d c2 = c(materialCacheType);
        return (z || c2.f39778e) ? z : new File(b(str, c2)).exists();
    }

    public d.a.f0.a.c.c<?> g(String str, MaterialLoader.MaterialCacheType materialCacheType) {
        d.a.f0.a.c.c<?> i2;
        return (materialCacheType != MaterialLoader.MaterialCacheType.PICTURE || (i2 = i(str)) == null) ? h(str, materialCacheType) : i2;
    }

    public final d.a.f0.a.c.c<File> h(String str, MaterialLoader.MaterialCacheType materialCacheType) {
        return c(materialCacheType).j(str);
    }

    public final d.a.f0.a.c.c<?> i(String str) {
        return this.f39763a.get(str);
    }

    public Bitmap j(String str) {
        return (Bitmap) k(str, MaterialLoader.MaterialCacheType.PICTURE, new C0526a(this));
    }

    public final <T> T k(String str, MaterialLoader.MaterialCacheType materialCacheType, d<T> dVar) {
        d.a.f0.a.c.c<?> g2 = g(a(str), materialCacheType);
        if (g2 != null) {
            if (File.class.equals(g2.c())) {
                return dVar.parseFromBytes(g2.b());
            }
            if (Byte.TYPE.equals(g2.c())) {
                return null;
            }
            return dVar.rawGet(g2.a());
        }
        if (!c(materialCacheType).f39778e) {
            File file = new File(b(str, c(materialCacheType)));
            if (file.exists()) {
                return dVar.parseFromBytes(new d.a.f0.a.c.c(file).b());
            }
        }
        return null;
    }

    public void l(String str, Bitmap bitmap, boolean z) {
        m(str, new d.a.f0.a.c.c<>(bitmap), this.f39764b, z, null);
    }

    public final void m(String str, d.a.f0.a.c.c<?> cVar, d.a.f0.a.c.d dVar, boolean z, c cVar2) {
        try {
            String a2 = a(str);
            if (z) {
                this.f39763a.put(a2, cVar);
            }
            File file = new File(dVar.k() + a2);
            if (cVar2 != null) {
                dVar.f(new b(this, a2, cVar2, dVar));
            }
            dVar.u(cVar.b(), new d.a.f0.a.c.c<>(file));
        } catch (Throwable th) {
            d.a.f0.a.k.b.i().c("Failed to cache resource.", th);
        }
    }

    public void n(String str, byte[] bArr, MaterialLoader.MaterialCacheType materialCacheType, boolean z, c cVar) {
        d.a.f0.a.c.c<?> cVar2 = new d.a.f0.a.c.c<>(bArr);
        d.a.f0.a.c.d dVar = this.f39764b;
        if (materialCacheType == MaterialLoader.MaterialCacheType.VIDEO) {
            dVar = this.f39765c;
        }
        m(str, cVar2, dVar, z, cVar);
    }

    public void o(String str, byte[] bArr, String str2, int i2, boolean z, c cVar) {
        d.a.f0.a.c.c<?> cVar2 = new d.a.f0.a.c.c<>(bArr);
        d.a.f0.a.c.d dVar = this.f39766d.get(str2);
        if (dVar == null) {
            dVar = d.a.f0.a.c.d.o(str2, i2);
            this.f39766d.put(str2, dVar);
        } else if (dVar.l() != i2) {
            dVar.trimToSize(i2);
        }
        m(str, cVar2, dVar, z, cVar);
    }
}
