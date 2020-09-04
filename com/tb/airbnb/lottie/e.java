package com.tb.airbnb.lottie;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.Nullable;
import android.support.annotation.RawRes;
import android.support.annotation.WorkerThread;
import android.util.JsonReader;
import android.util.Log;
import com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider;
import com.tb.airbnb.lottie.c.t;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
/* loaded from: classes7.dex */
public class e {
    private static final Map<String, l<d>> Bb = new HashMap();

    public static l<d> bg(Context context, String str) {
        return com.tb.airbnb.lottie.network.b.bj(context, str);
    }

    public static l<d> bh(Context context, final String str) {
        final Context applicationContext = context.getApplicationContext();
        return b(str, new Callable<k<d>>() { // from class: com.tb.airbnb.lottie.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: eda */
            public k<d> call() {
                return e.bi(applicationContext, str);
            }
        });
    }

    @WorkerThread
    public static k<d> bi(Context context, String str) {
        k<d> j;
        try {
            String str2 = "asset_" + str;
            if (str.endsWith(".zip")) {
                j = c(new ZipInputStream(context.getAssets().open(str)), str2);
            } else {
                j = j(context.getAssets().open(str), str2);
            }
            return j;
        } catch (IOException e) {
            return new k<>(e);
        }
    }

    public static l<d> F(Context context, @RawRes final int i) {
        final Context applicationContext = context.getApplicationContext();
        return b(U(i), new Callable<k<d>>() { // from class: com.tb.airbnb.lottie.e.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: eda */
            public k<d> call() {
                return e.G(applicationContext, i);
            }
        });
    }

    @WorkerThread
    public static k<d> G(Context context, @RawRes int i) {
        try {
            return j(context.getResources().openRawResource(i), U(i));
        } catch (Resources.NotFoundException e) {
            return new k<>(e);
        }
    }

    private static String U(@RawRes int i) {
        return "rawRes_" + i;
    }

    public static l<d> i(final InputStream inputStream, @Nullable final String str) {
        return b(str, new Callable<k<d>>() { // from class: com.tb.airbnb.lottie.e.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: eda */
            public k<d> call() {
                return e.j(inputStream, str);
            }
        });
    }

    @WorkerThread
    public static k<d> j(InputStream inputStream, @Nullable String str) {
        return b(inputStream, str, true);
    }

    @WorkerThread
    private static k<d> b(InputStream inputStream, @Nullable String str, boolean z) {
        try {
            return d(new JsonReader(new InputStreamReader(inputStream)), str);
        } finally {
            if (z) {
                com.tb.airbnb.lottie.d.f.closeQuietly(inputStream);
            }
        }
    }

    public static l<d> c(final JsonReader jsonReader, @Nullable final String str) {
        return b(str, new Callable<k<d>>() { // from class: com.tb.airbnb.lottie.e.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: eda */
            public k<d> call() {
                return e.d(jsonReader, str);
            }
        });
    }

    @WorkerThread
    public static k<d> d(JsonReader jsonReader, @Nullable String str) {
        try {
            d g = t.g(jsonReader);
            com.tb.airbnb.lottie.model.g.edn().a(str, g);
            return new k<>(g);
        } catch (Exception e) {
            return new k<>(e);
        }
    }

    @WorkerThread
    public static k<d> c(ZipInputStream zipInputStream, @Nullable String str) {
        try {
            return d(zipInputStream, str);
        } finally {
            com.tb.airbnb.lottie.d.f.closeQuietly(zipInputStream);
        }
    }

    @WorkerThread
    private static k<d> d(ZipInputStream zipInputStream, @Nullable String str) {
        d dVar;
        String[] split;
        HashMap hashMap = new HashMap();
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            d dVar2 = null;
            while (nextEntry != null) {
                if (nextEntry.getName().contains("__MACOSX")) {
                    zipInputStream.closeEntry();
                    dVar = dVar2;
                } else if (nextEntry.getName().contains(".json")) {
                    dVar = b(zipInputStream, str, false).getValue();
                } else if (nextEntry.getName().contains(ComboPraiseProvider.RES_NAME_PRAISE_NUMBER_SUFFIX)) {
                    hashMap.put(nextEntry.getName().split("/")[split.length - 1], BitmapFactory.decodeStream(zipInputStream));
                    dVar = dVar2;
                } else {
                    zipInputStream.closeEntry();
                    dVar = dVar2;
                }
                nextEntry = zipInputStream.getNextEntry();
                dVar2 = dVar;
            }
            if (dVar2 == null) {
                return new k<>(new IllegalArgumentException("Unable to parse composition"));
            }
            for (Map.Entry entry : hashMap.entrySet()) {
                g a = a(dVar2, (String) entry.getKey());
                if (a != null) {
                    a.setBitmap((Bitmap) entry.getValue());
                }
            }
            for (Map.Entry<String, g> entry2 : dVar2.iB().entrySet()) {
                if (entry2.getValue().getBitmap() == null) {
                    return new k<>(new IllegalStateException("There is no image for " + entry2.getValue().getFileName()));
                }
            }
            com.tb.airbnb.lottie.model.g.edn().a(str, dVar2);
            return new k<>(dVar2);
        } catch (IOException e) {
            return new k<>(e);
        }
    }

    @Nullable
    private static g a(d dVar, String str) {
        for (g gVar : dVar.iB().values()) {
            if (gVar.getFileName().equals(str)) {
                return gVar;
            }
        }
        return null;
    }

    private static l<d> b(@Nullable final String str, Callable<k<d>> callable) {
        final d VF = com.tb.airbnb.lottie.model.g.edn().VF(str);
        if (VF != null) {
            return new l<>(new Callable<k<d>>() { // from class: com.tb.airbnb.lottie.e.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                /* renamed from: eda */
                public k<d> call() {
                    Log.d("Gabe", "call\treturning from cache");
                    return new k<>(d.this);
                }
            });
        }
        if (Bb.containsKey(str)) {
            return Bb.get(str);
        }
        l<d> lVar = new l<>(callable);
        lVar.a(new h<d>() { // from class: com.tb.airbnb.lottie.e.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.tb.airbnb.lottie.h
            public void onResult(d dVar) {
                if (str != null) {
                    com.tb.airbnb.lottie.model.g.edn().a(str, dVar);
                }
                e.Bb.remove(str);
            }
        });
        lVar.c(new h<Throwable>() { // from class: com.tb.airbnb.lottie.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.tb.airbnb.lottie.h
            public void onResult(Throwable th) {
                e.Bb.remove(str);
            }
        });
        Bb.put(str, lVar);
        return lVar;
    }
}
