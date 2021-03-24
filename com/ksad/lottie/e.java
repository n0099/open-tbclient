package com.ksad.lottie;

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
import com.ksad.lottie.c.t;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
/* loaded from: classes6.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, k<d>> f31372a = new HashMap();

    @Nullable
    public static g a(d dVar, String str) {
        for (g gVar : dVar.j().values()) {
            if (gVar.b().equals(str)) {
                return gVar;
            }
        }
        return null;
    }

    @WorkerThread
    public static j<d> a(InputStream inputStream, @Nullable String str) {
        return a(inputStream, str, true);
    }

    @WorkerThread
    public static j<d> a(InputStream inputStream, @Nullable String str, boolean z) {
        try {
            return b(new JsonReader(new InputStreamReader(inputStream)), str);
        } finally {
            if (z) {
                com.ksad.lottie.d.f.a(inputStream);
            }
        }
    }

    @WorkerThread
    public static j<d> a(ZipInputStream zipInputStream, @Nullable String str) {
        try {
            return b(zipInputStream, str);
        } finally {
            com.ksad.lottie.d.f.a(zipInputStream);
        }
    }

    public static k<d> a(Context context, @RawRes final int i) {
        final Context applicationContext = context.getApplicationContext();
        return a(a(i), new Callable<j<d>>() { // from class: com.ksad.lottie.e.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public j<d> call() {
                return e.b(applicationContext, i);
            }
        });
    }

    public static k<d> a(Context context, String str) {
        return com.ksad.lottie.network.b.a(context, str);
    }

    public static k<d> a(final JsonReader jsonReader, @Nullable final String str) {
        return a(str, new Callable<j<d>>() { // from class: com.ksad.lottie.e.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public j<d> call() {
                return e.b(jsonReader, str);
            }
        });
    }

    public static k<d> a(@Nullable final String str, Callable<j<d>> callable) {
        final d a2 = com.ksad.lottie.model.e.a().a(str);
        if (a2 != null) {
            return new k<>(new Callable<j<d>>() { // from class: com.ksad.lottie.e.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                /* renamed from: a */
                public j<d> call() {
                    Log.d("Gabe", "call\treturning from cache");
                    return new j<>(d.this);
                }
            });
        }
        if (f31372a.containsKey(str)) {
            return f31372a.get(str);
        }
        k<d> kVar = new k<>(callable);
        kVar.a(new h<d>() { // from class: com.ksad.lottie.e.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.ksad.lottie.h
            public void a(d dVar) {
                if (str != null) {
                    com.ksad.lottie.model.e.a().a(str, dVar);
                }
                e.f31372a.remove(str);
            }
        });
        kVar.c(new h<Throwable>() { // from class: com.ksad.lottie.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.ksad.lottie.h
            public void a(Throwable th) {
                e.f31372a.remove(str);
            }
        });
        f31372a.put(str, kVar);
        return kVar;
    }

    public static String a(@RawRes int i) {
        return "rawRes_" + i;
    }

    @WorkerThread
    public static j<d> b(Context context, @RawRes int i) {
        try {
            return a(context.getResources().openRawResource(i), a(i));
        } catch (Resources.NotFoundException e2) {
            return new j<>(e2);
        }
    }

    @WorkerThread
    public static j<d> b(JsonReader jsonReader, @Nullable String str) {
        try {
            d a2 = t.a(jsonReader);
            com.ksad.lottie.model.e.a().a(str, a2);
            return new j<>(a2);
        } catch (Exception e2) {
            return new j<>(e2);
        }
    }

    @WorkerThread
    public static j<d> b(ZipInputStream zipInputStream, @Nullable String str) {
        HashMap hashMap = new HashMap();
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            d dVar = null;
            while (nextEntry != null) {
                if (!nextEntry.getName().contains("__MACOSX")) {
                    if (nextEntry.getName().contains(".json")) {
                        dVar = a(zipInputStream, str, false).a();
                    } else if (nextEntry.getName().contains(EmotionResourceProvider.EMOTION_RES_NAME_SUFFIX)) {
                        String[] split = nextEntry.getName().split("/");
                        hashMap.put(split[split.length - 1], BitmapFactory.decodeStream(zipInputStream));
                    }
                    nextEntry = zipInputStream.getNextEntry();
                }
                zipInputStream.closeEntry();
                nextEntry = zipInputStream.getNextEntry();
            }
            if (dVar == null) {
                return new j<>(new IllegalArgumentException("Unable to parse composition"));
            }
            for (Map.Entry entry : hashMap.entrySet()) {
                g a2 = a(dVar, (String) entry.getKey());
                if (a2 != null) {
                    a2.a((Bitmap) entry.getValue());
                }
            }
            for (Map.Entry<String, g> entry2 : dVar.j().entrySet()) {
                if (entry2.getValue().c() == null) {
                    return new j<>(new IllegalStateException("There is no image for " + entry2.getValue().b()));
                }
            }
            com.ksad.lottie.model.e.a().a(str, dVar);
            return new j<>(dVar);
        } catch (IOException e2) {
            return new j<>(e2);
        }
    }

    public static k<d> b(Context context, final String str) {
        final Context applicationContext = context.getApplicationContext();
        return a(str, new Callable<j<d>>() { // from class: com.ksad.lottie.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public j<d> call() {
                return e.c(applicationContext, str);
            }
        });
    }

    @WorkerThread
    public static j<d> c(Context context, String str) {
        try {
            String str2 = "asset_" + str;
            return str.endsWith(".zip") ? a(new ZipInputStream(context.getAssets().open(str)), str2) : a(context.getAssets().open(str), str2);
        } catch (IOException e2) {
            return new j<>(e2);
        }
    }
}
