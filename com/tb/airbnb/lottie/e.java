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
/* loaded from: classes6.dex */
public class e {
    private static final Map<String, l<d>> zR = new HashMap();

    public static l<d> ba(Context context, String str) {
        return com.tb.airbnb.lottie.network.b.bd(context, str);
    }

    public static l<d> bb(Context context, final String str) {
        final Context applicationContext = context.getApplicationContext();
        return b(str, new Callable<k<d>>() { // from class: com.tb.airbnb.lottie.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: dBa */
            public k<d> call() {
                return e.bc(applicationContext, str);
            }
        });
    }

    @WorkerThread
    public static k<d> bc(Context context, String str) {
        k<d> i;
        try {
            String str2 = "asset_" + str;
            if (str.endsWith(".zip")) {
                i = c(new ZipInputStream(context.getAssets().open(str)), str2);
            } else {
                i = i(context.getAssets().open(str), str2);
            }
            return i;
        } catch (IOException e) {
            return new k<>(e);
        }
    }

    public static l<d> D(Context context, @RawRes final int i) {
        final Context applicationContext = context.getApplicationContext();
        return b(M(i), new Callable<k<d>>() { // from class: com.tb.airbnb.lottie.e.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: dBa */
            public k<d> call() {
                return e.E(applicationContext, i);
            }
        });
    }

    @WorkerThread
    public static k<d> E(Context context, @RawRes int i) {
        try {
            return i(context.getResources().openRawResource(i), M(i));
        } catch (Resources.NotFoundException e) {
            return new k<>(e);
        }
    }

    private static String M(@RawRes int i) {
        return "rawRes_" + i;
    }

    public static l<d> h(final InputStream inputStream, @Nullable final String str) {
        return b(str, new Callable<k<d>>() { // from class: com.tb.airbnb.lottie.e.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: dBa */
            public k<d> call() {
                return e.i(inputStream, str);
            }
        });
    }

    @WorkerThread
    public static k<d> i(InputStream inputStream, @Nullable String str) {
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
            /* renamed from: dBa */
            public k<d> call() {
                return e.d(jsonReader, str);
            }
        });
    }

    @WorkerThread
    public static k<d> d(JsonReader jsonReader, @Nullable String str) {
        try {
            d g = t.g(jsonReader);
            com.tb.airbnb.lottie.model.g.dBn().a(str, g);
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
            for (Map.Entry<String, g> entry2 : dVar2.gK().entrySet()) {
                if (entry2.getValue().getBitmap() == null) {
                    return new k<>(new IllegalStateException("There is no image for " + entry2.getValue().getFileName()));
                }
            }
            com.tb.airbnb.lottie.model.g.dBn().a(str, dVar2);
            return new k<>(dVar2);
        } catch (IOException e) {
            return new k<>(e);
        }
    }

    @Nullable
    private static g a(d dVar, String str) {
        for (g gVar : dVar.gK().values()) {
            if (gVar.getFileName().equals(str)) {
                return gVar;
            }
        }
        return null;
    }

    private static l<d> b(@Nullable final String str, Callable<k<d>> callable) {
        final d Pm = com.tb.airbnb.lottie.model.g.dBn().Pm(str);
        if (Pm != null) {
            return new l<>(new Callable<k<d>>() { // from class: com.tb.airbnb.lottie.e.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                /* renamed from: dBa */
                public k<d> call() {
                    Log.d("Gabe", "call\treturning from cache");
                    return new k<>(d.this);
                }
            });
        }
        if (zR.containsKey(str)) {
            return zR.get(str);
        }
        l<d> lVar = new l<>(callable);
        lVar.a(new h<d>() { // from class: com.tb.airbnb.lottie.e.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.tb.airbnb.lottie.h
            public void onResult(d dVar) {
                if (str != null) {
                    com.tb.airbnb.lottie.model.g.dBn().a(str, dVar);
                }
                e.zR.remove(str);
            }
        });
        lVar.c(new h<Throwable>() { // from class: com.tb.airbnb.lottie.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.tb.airbnb.lottie.h
            public void onResult(Throwable th) {
                e.zR.remove(str);
            }
        });
        zR.put(str, lVar);
        return lVar;
    }
}
