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
/* loaded from: classes20.dex */
public class f {
    private static final Map<String, m<e>> Ci = new HashMap();

    public static m<e> bv(Context context, String str) {
        return com.tb.airbnb.lottie.network.b.by(context, str);
    }

    public static m<e> bw(Context context, final String str) {
        final Context applicationContext = context.getApplicationContext();
        return b(str, new Callable<l<e>>() { // from class: com.tb.airbnb.lottie.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: eAU */
            public l<e> call() {
                return f.bx(applicationContext, str);
            }
        });
    }

    @WorkerThread
    public static l<e> bx(Context context, String str) {
        l<e> j;
        try {
            String str2 = "asset_" + str;
            if (str.endsWith(".zip")) {
                j = c(new ZipInputStream(context.getAssets().open(str)), str2);
            } else {
                j = j(context.getAssets().open(str), str2);
            }
            return j;
        } catch (IOException e) {
            return new l<>(e);
        }
    }

    public static m<e> V(Context context, @RawRes final int i) {
        final Context applicationContext = context.getApplicationContext();
        return b(X(i), new Callable<l<e>>() { // from class: com.tb.airbnb.lottie.f.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: eAU */
            public l<e> call() {
                return f.W(applicationContext, i);
            }
        });
    }

    @WorkerThread
    public static l<e> W(Context context, @RawRes int i) {
        try {
            return j(context.getResources().openRawResource(i), X(i));
        } catch (Resources.NotFoundException e) {
            return new l<>(e);
        }
    }

    private static String X(@RawRes int i) {
        return "rawRes_" + i;
    }

    public static m<e> i(final InputStream inputStream, @Nullable final String str) {
        return b(str, new Callable<l<e>>() { // from class: com.tb.airbnb.lottie.f.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: eAU */
            public l<e> call() {
                return f.j(inputStream, str);
            }
        });
    }

    @WorkerThread
    public static l<e> j(InputStream inputStream, @Nullable String str) {
        return b(inputStream, str, true);
    }

    @WorkerThread
    private static l<e> b(InputStream inputStream, @Nullable String str, boolean z) {
        try {
            return d(new JsonReader(new InputStreamReader(inputStream)), str);
        } finally {
            if (z) {
                com.tb.airbnb.lottie.d.f.closeQuietly(inputStream);
            }
        }
    }

    public static m<e> c(final JsonReader jsonReader, @Nullable final String str) {
        return b(str, new Callable<l<e>>() { // from class: com.tb.airbnb.lottie.f.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: eAU */
            public l<e> call() {
                return f.d(jsonReader, str);
            }
        });
    }

    @WorkerThread
    public static l<e> d(JsonReader jsonReader, @Nullable String str) {
        try {
            e g = t.g(jsonReader);
            com.tb.airbnb.lottie.model.g.eBh().a(str, g);
            return new l<>(g);
        } catch (Exception e) {
            return new l<>(e);
        }
    }

    @WorkerThread
    public static l<e> c(ZipInputStream zipInputStream, @Nullable String str) {
        try {
            return d(zipInputStream, str);
        } finally {
            com.tb.airbnb.lottie.d.f.closeQuietly(zipInputStream);
        }
    }

    @WorkerThread
    private static l<e> d(ZipInputStream zipInputStream, @Nullable String str) {
        e eVar;
        String[] split;
        HashMap hashMap = new HashMap();
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            e eVar2 = null;
            while (nextEntry != null) {
                if (nextEntry.getName().contains("__MACOSX")) {
                    zipInputStream.closeEntry();
                    eVar = eVar2;
                } else if (nextEntry.getName().contains(".json")) {
                    eVar = b(zipInputStream, str, false).getValue();
                } else if (nextEntry.getName().contains(ComboPraiseProvider.RES_NAME_PRAISE_NUMBER_SUFFIX)) {
                    hashMap.put(nextEntry.getName().split("/")[split.length - 1], BitmapFactory.decodeStream(zipInputStream));
                    eVar = eVar2;
                } else {
                    zipInputStream.closeEntry();
                    eVar = eVar2;
                }
                nextEntry = zipInputStream.getNextEntry();
                eVar2 = eVar;
            }
            if (eVar2 == null) {
                return new l<>(new IllegalArgumentException("Unable to parse composition"));
            }
            for (Map.Entry entry : hashMap.entrySet()) {
                h a2 = a(eVar2, (String) entry.getKey());
                if (a2 != null) {
                    a2.setBitmap((Bitmap) entry.getValue());
                }
            }
            for (Map.Entry<String, h> entry2 : eVar2.iC().entrySet()) {
                if (entry2.getValue().getBitmap() == null) {
                    return new l<>(new IllegalStateException("There is no image for " + entry2.getValue().getFileName()));
                }
            }
            com.tb.airbnb.lottie.model.g.eBh().a(str, eVar2);
            return new l<>(eVar2);
        } catch (IOException e) {
            return new l<>(e);
        }
    }

    @Nullable
    private static h a(e eVar, String str) {
        for (h hVar : eVar.iC().values()) {
            if (hVar.getFileName().equals(str)) {
                return hVar;
            }
        }
        return null;
    }

    private static m<e> b(@Nullable final String str, Callable<l<e>> callable) {
        final e ZU = com.tb.airbnb.lottie.model.g.eBh().ZU(str);
        if (ZU != null) {
            return new m<>(new Callable<l<e>>() { // from class: com.tb.airbnb.lottie.f.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                /* renamed from: eAU */
                public l<e> call() {
                    Log.d("Gabe", "call\treturning from cache");
                    return new l<>(e.this);
                }
            });
        }
        if (Ci.containsKey(str)) {
            return Ci.get(str);
        }
        m<e> mVar = new m<>(callable);
        mVar.a(new i<e>() { // from class: com.tb.airbnb.lottie.f.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.tb.airbnb.lottie.i
            public void onResult(e eVar) {
                if (str != null) {
                    com.tb.airbnb.lottie.model.g.eBh().a(str, eVar);
                }
                f.Ci.remove(str);
            }
        });
        mVar.c(new i<Throwable>() { // from class: com.tb.airbnb.lottie.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.tb.airbnb.lottie.i
            public void onResult(Throwable th) {
                f.Ci.remove(str);
            }
        });
        Ci.put(str, mVar);
        return mVar;
    }
}
