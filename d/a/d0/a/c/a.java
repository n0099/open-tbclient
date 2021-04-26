package d.a.d0.a.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.LruCache;
import com.baidu.mobads.container.util.cache.CacheEngine;
import com.baidu.mobads.container.util.filedownloader.MaterialLoader;
import com.baidu.sdk.container.filedownloader.MaterialLoader;
import d.a.d0.a.c.d;
import d.a.d0.a.k.i;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: g  reason: collision with root package name */
    public static volatile a f40529g = null;

    /* renamed from: h  reason: collision with root package name */
    public static int f40530h = 30000000;

    /* renamed from: i  reason: collision with root package name */
    public static int f40531i = 50000000;

    /* renamed from: a  reason: collision with root package name */
    public final LruCache<String, d.a.d0.a.c.c<?>> f40532a = new LruCache<>(6);

    /* renamed from: b  reason: collision with root package name */
    public final d.a.d0.a.c.d f40533b;

    /* renamed from: c  reason: collision with root package name */
    public final d.a.d0.a.c.d f40534c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, d.a.d0.a.c.d> f40535d;

    /* renamed from: e  reason: collision with root package name */
    public final String f40536e;

    /* renamed from: f  reason: collision with root package name */
    public final String f40537f;

    /* renamed from: d.a.d0.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0533a implements d<Bitmap> {
        public C0533a(a aVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.d0.a.c.a.d
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
                d.a.d0.a.k.b.i().h(CacheEngine.TAG, "图片请求失败，OOM");
                return null;
            } catch (Throwable unused2) {
                d.a.d0.a.k.b.i().h(CacheEngine.TAG, "图片请求失败，解析异常");
                return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.d0.a.c.a.d
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
        public final /* synthetic */ String f40538a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f40539b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.d0.a.c.d f40540c;

        public b(a aVar, String str, c cVar, d.a.d0.a.c.d dVar) {
            this.f40538a = str;
            this.f40539b = cVar;
            this.f40540c = dVar;
        }

        @Override // d.a.d0.a.c.d.e
        public void a(String str, d.a.d0.a.c.c<File> cVar) {
        }

        @Override // d.a.d0.a.c.d.e
        public void b(String str, d.a.d0.a.c.c<File> cVar) {
            if (this.f40538a.equals(str)) {
                this.f40539b.onCacheFailed();
                this.f40540c.q(this);
            }
        }

        @Override // d.a.d0.a.c.d.e
        public void c(String str, d.a.d0.a.c.c<File> cVar) {
            if (this.f40538a.equals(str)) {
                this.f40539b.onCacheComplete();
                this.f40540c.q(this);
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
        this.f40536e = d2 + MaterialLoader.IMAGE_CACHE_PATH;
        this.f40537f = d2 + MaterialLoader.VIDEO_CACHE_PATH;
        this.f40533b = d.a.d0.a.c.d.o(this.f40536e, f40530h);
        this.f40534c = d.a.d0.a.c.d.o(this.f40537f, f40531i);
        this.f40535d = new ConcurrentHashMap();
    }

    public static String a(String str) {
        return Pattern.compile("[^a-zA-Z0-9]").matcher(str).replaceAll("").trim();
    }

    public static a e(Context context) {
        if (f40529g == null) {
            synchronized (a.class) {
                if (f40529g == null && context != null) {
                    f40529g = new a(context.getApplicationContext());
                }
            }
        }
        return f40529g;
    }

    public final String b(String str, d.a.d0.a.c.d dVar) {
        String a2 = a(str);
        return dVar.k() + a2;
    }

    public final d.a.d0.a.c.d c(MaterialLoader.MaterialCacheType materialCacheType) {
        if (materialCacheType == MaterialLoader.MaterialCacheType.VIDEO) {
            return this.f40534c;
        }
        return this.f40533b;
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
        d.a.d0.a.c.d c2 = c(materialCacheType);
        return (z || c2.f40547e) ? z : new File(b(str, c2)).exists();
    }

    public d.a.d0.a.c.c<?> g(String str, MaterialLoader.MaterialCacheType materialCacheType) {
        d.a.d0.a.c.c<?> i2;
        return (materialCacheType != MaterialLoader.MaterialCacheType.PICTURE || (i2 = i(str)) == null) ? h(str, materialCacheType) : i2;
    }

    public final d.a.d0.a.c.c<File> h(String str, MaterialLoader.MaterialCacheType materialCacheType) {
        return c(materialCacheType).j(str);
    }

    public final d.a.d0.a.c.c<?> i(String str) {
        return this.f40532a.get(str);
    }

    public Bitmap j(String str) {
        return (Bitmap) k(str, MaterialLoader.MaterialCacheType.PICTURE, new C0533a(this));
    }

    public final <T> T k(String str, MaterialLoader.MaterialCacheType materialCacheType, d<T> dVar) {
        d.a.d0.a.c.c<?> g2 = g(a(str), materialCacheType);
        if (g2 != null) {
            if (File.class.equals(g2.c())) {
                return dVar.parseFromBytes(g2.b());
            }
            if (Byte.TYPE.equals(g2.c())) {
                return null;
            }
            return dVar.rawGet(g2.a());
        }
        if (!c(materialCacheType).f40547e) {
            File file = new File(b(str, c(materialCacheType)));
            if (file.exists()) {
                return dVar.parseFromBytes(new d.a.d0.a.c.c(file).b());
            }
        }
        return null;
    }

    public void l(String str, Bitmap bitmap, boolean z) {
        m(str, new d.a.d0.a.c.c<>(bitmap), this.f40533b, z, null);
    }

    public final void m(String str, d.a.d0.a.c.c<?> cVar, d.a.d0.a.c.d dVar, boolean z, c cVar2) {
        try {
            String a2 = a(str);
            if (z) {
                this.f40532a.put(a2, cVar);
            }
            File file = new File(dVar.k() + a2);
            if (cVar2 != null) {
                dVar.f(new b(this, a2, cVar2, dVar));
            }
            dVar.u(cVar.b(), new d.a.d0.a.c.c<>(file));
        } catch (Throwable th) {
            d.a.d0.a.k.b.i().c("Failed to cache resource.", th);
        }
    }

    public void n(String str, byte[] bArr, MaterialLoader.MaterialCacheType materialCacheType, boolean z, c cVar) {
        d.a.d0.a.c.c<?> cVar2 = new d.a.d0.a.c.c<>(bArr);
        d.a.d0.a.c.d dVar = this.f40533b;
        if (materialCacheType == MaterialLoader.MaterialCacheType.VIDEO) {
            dVar = this.f40534c;
        }
        m(str, cVar2, dVar, z, cVar);
    }

    public void o(String str, byte[] bArr, String str2, int i2, boolean z, c cVar) {
        d.a.d0.a.c.c<?> cVar2 = new d.a.d0.a.c.c<>(bArr);
        d.a.d0.a.c.d dVar = this.f40535d.get(str2);
        if (dVar == null) {
            dVar = d.a.d0.a.c.d.o(str2, i2);
            this.f40535d.put(str2, dVar);
        } else if (dVar.l() != i2) {
            dVar.trimToSize(i2);
        }
        m(str, cVar2, dVar, z, cVar);
    }
}
