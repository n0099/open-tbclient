package d.a.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.JsonReader;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import androidx.annotation.WorkerThread;
import com.baidu.spswitch.emotion.resource.EmotionResourceProvider;
import d.a.a.u.t;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, l<d.a.a.d>> f41135a = new HashMap();

    /* loaded from: classes.dex */
    public static class a implements h<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f41136a;

        public a(String str) {
            this.f41136a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.a.h
        /* renamed from: a */
        public void onResult(Throwable th) {
            e.f41135a.remove(this.f41136a);
        }
    }

    /* loaded from: classes.dex */
    public static class b implements Callable<k<d.a.a.d>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f41137e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f41138f;

        public b(Context context, String str) {
            this.f41137e = context;
            this.f41138f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public k<d.a.a.d> call() {
            return e.e(this.f41137e, this.f41138f);
        }
    }

    /* loaded from: classes.dex */
    public static class c implements Callable<k<d.a.a.d>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f41139e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f41140f;

        public c(Context context, int i) {
            this.f41139e = context;
            this.f41140f = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public k<d.a.a.d> call() {
            return e.l(this.f41139e, this.f41140f);
        }
    }

    /* loaded from: classes.dex */
    public static class d implements Callable<k<d.a.a.d>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ InputStream f41141e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f41142f;

        public d(InputStream inputStream, String str) {
            this.f41141e = inputStream;
            this.f41142f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public k<d.a.a.d> call() {
            return e.g(this.f41141e, this.f41142f);
        }
    }

    /* renamed from: d.a.a.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class CallableC0526e implements Callable<k<d.a.a.d>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JsonReader f41143e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f41144f;

        public CallableC0526e(JsonReader jsonReader, String str) {
            this.f41143e = jsonReader;
            this.f41144f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public k<d.a.a.d> call() {
            return e.j(this.f41143e, this.f41144f);
        }
    }

    /* loaded from: classes.dex */
    public static class f implements Callable<k<d.a.a.d>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.a.d f41145e;

        public f(d.a.a.d dVar) {
            this.f41145e = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public k<d.a.a.d> call() {
            Log.d("Gabe", "call\treturning from cache");
            return new k<>(this.f41145e);
        }
    }

    /* loaded from: classes.dex */
    public static class g implements h<d.a.a.d> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f41146a;

        public g(String str) {
            this.f41146a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.a.h
        /* renamed from: a */
        public void onResult(d.a.a.d dVar) {
            if (this.f41146a != null) {
                d.a.a.s.g.b().c(this.f41146a, dVar);
            }
            e.f41135a.remove(this.f41146a);
        }
    }

    public static l<d.a.a.d> b(@Nullable String str, Callable<k<d.a.a.d>> callable) {
        d.a.a.d a2 = d.a.a.s.g.b().a(str);
        if (a2 != null) {
            return new l<>(new f(a2));
        }
        if (f41135a.containsKey(str)) {
            return f41135a.get(str);
        }
        l<d.a.a.d> lVar = new l<>(callable);
        lVar.h(new g(str));
        lVar.g(new a(str));
        f41135a.put(str, lVar);
        return lVar;
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

    public static l<d.a.a.d> d(Context context, String str) {
        return b(str, new b(context.getApplicationContext(), str));
    }

    @WorkerThread
    public static k<d.a.a.d> e(Context context, String str) {
        try {
            String str2 = "asset_" + str;
            if (str.endsWith(".zip")) {
                return n(new ZipInputStream(context.getAssets().open(str)), str2);
            }
            return g(context.getAssets().open(str), str2);
        } catch (IOException e2) {
            return new k<>(e2);
        }
    }

    public static l<d.a.a.d> f(InputStream inputStream, @Nullable String str) {
        return b(str, new d(inputStream, str));
    }

    @WorkerThread
    public static k<d.a.a.d> g(InputStream inputStream, @Nullable String str) {
        return h(inputStream, str, true);
    }

    @WorkerThread
    public static k<d.a.a.d> h(InputStream inputStream, @Nullable String str, boolean z) {
        try {
            return j(new JsonReader(new InputStreamReader(inputStream)), str);
        } finally {
            if (z) {
                d.a.a.v.f.c(inputStream);
            }
        }
    }

    public static l<d.a.a.d> i(JsonReader jsonReader, @Nullable String str) {
        return b(str, new CallableC0526e(jsonReader, str));
    }

    @WorkerThread
    public static k<d.a.a.d> j(JsonReader jsonReader, @Nullable String str) {
        try {
            d.a.a.d a2 = t.a(jsonReader);
            d.a.a.s.g.b().c(str, a2);
            return new k<>(a2);
        } catch (Exception e2) {
            return new k<>(e2);
        }
    }

    public static l<d.a.a.d> k(Context context, @RawRes int i) {
        return b(p(i), new c(context.getApplicationContext(), i));
    }

    @WorkerThread
    public static k<d.a.a.d> l(Context context, @RawRes int i) {
        try {
            return g(context.getResources().openRawResource(i), p(i));
        } catch (Resources.NotFoundException e2) {
            return new k<>(e2);
        }
    }

    public static l<d.a.a.d> m(Context context, String str) {
        return d.a.a.t.b.b(context, str);
    }

    @WorkerThread
    public static k<d.a.a.d> n(ZipInputStream zipInputStream, @Nullable String str) {
        try {
            return o(zipInputStream, str);
        } finally {
            d.a.a.v.f.c(zipInputStream);
        }
    }

    @WorkerThread
    public static k<d.a.a.d> o(ZipInputStream zipInputStream, @Nullable String str) {
        HashMap hashMap = new HashMap();
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            d.a.a.d dVar = null;
            while (nextEntry != null) {
                if (nextEntry.getName().contains("__MACOSX")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().contains(".json")) {
                    dVar = h(zipInputStream, str, false).b();
                } else if (nextEntry.getName().contains(EmotionResourceProvider.EMOTION_RES_NAME_SUFFIX)) {
                    String[] split = nextEntry.getName().split("/");
                    hashMap.put(split[split.length - 1], BitmapFactory.decodeStream(zipInputStream));
                } else {
                    zipInputStream.closeEntry();
                }
                nextEntry = zipInputStream.getNextEntry();
            }
            if (dVar == null) {
                return new k<>(new IllegalArgumentException("Unable to parse composition"));
            }
            for (Map.Entry entry : hashMap.entrySet()) {
                d.a.a.g c2 = c(dVar, (String) entry.getKey());
                if (c2 != null) {
                    c2.e((Bitmap) entry.getValue());
                }
            }
            for (Map.Entry<String, d.a.a.g> entry2 : dVar.i().entrySet()) {
                if (entry2.getValue().a() == null) {
                    return new k<>(new IllegalStateException("There is no image for " + entry2.getValue().c()));
                }
            }
            d.a.a.s.g.b().c(str, dVar);
            return new k<>(dVar);
        } catch (IOException e2) {
            return new k<>(e2);
        }
    }

    public static String p(@RawRes int i) {
        return "rawRes_" + i;
    }
}
