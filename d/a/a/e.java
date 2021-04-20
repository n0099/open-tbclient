package d.a.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import androidx.annotation.WorkerThread;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.baidu.spswitch.emotion.resource.EmotionResourceProvider;
import d.a.a.w.t;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import okio.Okio;
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, m<d.a.a.d>> f41423a = new HashMap();

    /* loaded from: classes.dex */
    public class a implements d.a.a.h<d.a.a.d> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f41424a;

        public a(String str) {
            this.f41424a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.a.h
        /* renamed from: a */
        public void onResult(d.a.a.d dVar) {
            e.f41423a.remove(this.f41424a);
        }
    }

    /* loaded from: classes.dex */
    public class b implements d.a.a.h<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f41425a;

        public b(String str) {
            this.f41425a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.a.h
        /* renamed from: a */
        public void onResult(Throwable th) {
            e.f41423a.remove(this.f41425a);
        }
    }

    /* loaded from: classes.dex */
    public class c implements Callable<l<d.a.a.d>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f41426e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f41427f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f41428g;

        public c(Context context, String str, String str2) {
            this.f41426e = context;
            this.f41427f = str;
            this.f41428g = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public l<d.a.a.d> call() {
            return d.a.a.v.b.e(this.f41426e, this.f41427f, this.f41428g);
        }
    }

    /* loaded from: classes.dex */
    public class d implements Callable<l<d.a.a.d>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f41429e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f41430f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f41431g;

        public d(Context context, String str, String str2) {
            this.f41429e = context;
            this.f41430f = str;
            this.f41431g = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public l<d.a.a.d> call() {
            return e.g(this.f41429e, this.f41430f, this.f41431g);
        }
    }

    /* renamed from: d.a.a.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class CallableC0540e implements Callable<l<d.a.a.d>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WeakReference f41432e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f41433f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f41434g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f41435h;

        public CallableC0540e(WeakReference weakReference, Context context, int i, String str) {
            this.f41432e = weakReference;
            this.f41433f = context;
            this.f41434g = i;
            this.f41435h = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public l<d.a.a.d> call() {
            Context context = (Context) this.f41432e.get();
            if (context == null) {
                context = this.f41433f;
            }
            return e.p(context, this.f41434g, this.f41435h);
        }
    }

    /* loaded from: classes.dex */
    public class f implements Callable<l<d.a.a.d>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ InputStream f41436e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f41437f;

        public f(InputStream inputStream, String str) {
            this.f41436e = inputStream;
            this.f41437f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public l<d.a.a.d> call() {
            return e.i(this.f41436e, this.f41437f);
        }
    }

    /* loaded from: classes.dex */
    public class g implements Callable<l<d.a.a.d>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ZipInputStream f41438e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f41439f;

        public g(ZipInputStream zipInputStream, String str) {
            this.f41438e = zipInputStream;
            this.f41439f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public l<d.a.a.d> call() {
            return e.t(this.f41438e, this.f41439f);
        }
    }

    /* loaded from: classes.dex */
    public class h implements Callable<l<d.a.a.d>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.a.d f41440e;

        public h(d.a.a.d dVar) {
            this.f41440e = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public l<d.a.a.d> call() {
            return new l<>(this.f41440e);
        }
    }

    public static m<d.a.a.d> b(@Nullable String str, Callable<l<d.a.a.d>> callable) {
        d.a.a.d a2 = str == null ? null : d.a.a.u.f.b().a(str);
        if (a2 != null) {
            return new m<>(new h(a2));
        }
        if (str != null && f41423a.containsKey(str)) {
            return f41423a.get(str);
        }
        m<d.a.a.d> mVar = new m<>(callable);
        if (str != null) {
            mVar.f(new a(str));
            mVar.e(new b(str));
            f41423a.put(str, mVar);
        }
        return mVar;
    }

    @Nullable
    public static d.a.a.g c(d.a.a.d dVar, String str) {
        for (d.a.a.g gVar : dVar.i().values()) {
            if (gVar.c().equals(str)) {
                return gVar;
            }
        }
        return null;
    }

    public static m<d.a.a.d> d(Context context, String str) {
        return e(context, str, "asset_" + str);
    }

    public static m<d.a.a.d> e(Context context, String str, @Nullable String str2) {
        return b(str2, new d(context.getApplicationContext(), str, str2));
    }

    @WorkerThread
    public static l<d.a.a.d> f(Context context, String str) {
        return g(context, str, "asset_" + str);
    }

    @WorkerThread
    public static l<d.a.a.d> g(Context context, String str, @Nullable String str2) {
        try {
            if (str.endsWith(".zip")) {
                return t(new ZipInputStream(context.getAssets().open(str)), str2);
            }
            return i(context.getAssets().open(str), str2);
        } catch (IOException e2) {
            return new l<>(e2);
        }
    }

    public static m<d.a.a.d> h(InputStream inputStream, @Nullable String str) {
        return b(str, new f(inputStream, str));
    }

    @WorkerThread
    public static l<d.a.a.d> i(InputStream inputStream, @Nullable String str) {
        return j(inputStream, str, true);
    }

    @WorkerThread
    public static l<d.a.a.d> j(InputStream inputStream, @Nullable String str, boolean z) {
        try {
            return k(JsonReader.A(Okio.buffer(Okio.source(inputStream))), str);
        } finally {
            if (z) {
                d.a.a.x.h.c(inputStream);
            }
        }
    }

    @WorkerThread
    public static l<d.a.a.d> k(JsonReader jsonReader, @Nullable String str) {
        return l(jsonReader, str, true);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    public static l<d.a.a.d> l(JsonReader jsonReader, @Nullable String str, boolean z) {
        try {
            try {
                d.a.a.d a2 = t.a(jsonReader);
                if (str != null) {
                    d.a.a.u.f.b().c(str, a2);
                }
                l<d.a.a.d> lVar = new l<>(a2);
                if (z) {
                    d.a.a.x.h.c(jsonReader);
                }
                return lVar;
            } catch (Exception e2) {
                l<d.a.a.d> lVar2 = new l<>(e2);
                if (z) {
                    d.a.a.x.h.c(jsonReader);
                }
                return lVar2;
            }
        } catch (Throwable th) {
            if (z) {
                d.a.a.x.h.c(jsonReader);
            }
            throw th;
        }
    }

    public static m<d.a.a.d> m(Context context, @RawRes int i) {
        return n(context, i, w(context, i));
    }

    public static m<d.a.a.d> n(Context context, @RawRes int i, @Nullable String str) {
        return b(str, new CallableC0540e(new WeakReference(context), context.getApplicationContext(), i, str));
    }

    @WorkerThread
    public static l<d.a.a.d> o(Context context, @RawRes int i) {
        return p(context, i, w(context, i));
    }

    @WorkerThread
    public static l<d.a.a.d> p(Context context, @RawRes int i, @Nullable String str) {
        try {
            return i(context.getResources().openRawResource(i), str);
        } catch (Resources.NotFoundException e2) {
            return new l<>(e2);
        }
    }

    public static m<d.a.a.d> q(Context context, String str) {
        return r(context, str, "url_" + str);
    }

    public static m<d.a.a.d> r(Context context, String str, @Nullable String str2) {
        return b(str2, new c(context, str, str2));
    }

    public static m<d.a.a.d> s(ZipInputStream zipInputStream, @Nullable String str) {
        return b(str, new g(zipInputStream, str));
    }

    @WorkerThread
    public static l<d.a.a.d> t(ZipInputStream zipInputStream, @Nullable String str) {
        try {
            return u(zipInputStream, str);
        } finally {
            d.a.a.x.h.c(zipInputStream);
        }
    }

    @WorkerThread
    public static l<d.a.a.d> u(ZipInputStream zipInputStream, @Nullable String str) {
        String[] split;
        HashMap hashMap = new HashMap();
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            d.a.a.d dVar = null;
            while (nextEntry != null) {
                String name = nextEntry.getName();
                if (name.contains("__MACOSX")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().contains(".json")) {
                    dVar = l(JsonReader.A(Okio.buffer(Okio.source(zipInputStream))), null, false).b();
                } else {
                    if (!name.contains(EmotionResourceProvider.EMOTION_RES_NAME_SUFFIX) && !name.contains(".webp")) {
                        zipInputStream.closeEntry();
                    }
                    hashMap.put(name.split("/")[split.length - 1], BitmapFactory.decodeStream(zipInputStream));
                }
                nextEntry = zipInputStream.getNextEntry();
            }
            if (dVar == null) {
                return new l<>(new IllegalArgumentException("Unable to parse composition"));
            }
            for (Map.Entry entry : hashMap.entrySet()) {
                d.a.a.g c2 = c(dVar, (String) entry.getKey());
                if (c2 != null) {
                    c2.g(d.a.a.x.h.l((Bitmap) entry.getValue(), c2.f(), c2.d()));
                }
            }
            for (Map.Entry<String, d.a.a.g> entry2 : dVar.i().entrySet()) {
                if (entry2.getValue().a() == null) {
                    return new l<>(new IllegalStateException("There is no image for " + entry2.getValue().c()));
                }
            }
            if (str != null) {
                d.a.a.u.f.b().c(str, dVar);
            }
            return new l<>(dVar);
        } catch (IOException e2) {
            return new l<>(e2);
        }
    }

    public static boolean v(Context context) {
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    public static String w(Context context, @RawRes int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("rawRes");
        sb.append(v(context) ? "_night_" : "_day_");
        sb.append(i);
        return sb.toString();
    }
}
