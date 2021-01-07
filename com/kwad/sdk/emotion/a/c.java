package com.kwad.sdk.emotion.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.kwad.sdk.emotion.b.d;
import com.kwad.sdk.emotion.model.EmotionCode;
import com.kwad.sdk.emotion.model.EmotionInfo;
import com.kwad.sdk.emotion.model.EmotionPackage;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final HashMap<String, SoftReference<Bitmap>> f10029a = new HashMap<>(168);

    /* renamed from: b  reason: collision with root package name */
    private static final g f10030b = new com.kwad.sdk.emotion.a.a() { // from class: com.kwad.sdk.emotion.a.c.1
    };
    private static volatile c c;
    private final Map<String, a> d = new ConcurrentHashMap();
    private final Map<String, EmotionInfo> e = new ConcurrentHashMap();
    private final Map<String, b> f = new ConcurrentHashMap();
    private com.kwad.sdk.emotion.b.d g = new com.kwad.sdk.emotion.b.d();
    private com.kwad.sdk.emotion.c h;
    private AtomicInteger i;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class a {

        /* renamed from: b  reason: collision with root package name */
        private EmotionInfo f10033b;
        private String c;
        private boolean d;

        a(EmotionInfo emotionInfo) {
            this.f10033b = emotionInfo;
            this.c = emotionInfo.id;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(EmotionInfo emotionInfo) {
            if (c.f10029a.get(emotionInfo.id) == null || !this.d) {
                return;
            }
            c.this.a(emotionInfo, this);
        }

        @Nullable
        Bitmap a() {
            SoftReference softReference = (SoftReference) c.f10029a.get(this.c);
            Bitmap bitmap = softReference != null ? (Bitmap) softReference.get() : null;
            if (bitmap == null || bitmap.isRecycled()) {
                Bitmap a2 = com.kwad.sdk.emotion.b.d.a(this.f10033b.id, false);
                c.f10029a.put(this.c, new SoftReference(a2));
                return a2;
            }
            return bitmap;
        }

        @SuppressLint({"CheckResult"})
        void a(final b bVar) {
            Bitmap a2 = com.kwad.sdk.emotion.b.d.a(this.f10033b.id, false);
            if (a2 != null) {
                c.f10029a.put(this.f10033b.id, new SoftReference(a2));
                a(this.f10033b);
                bVar.b();
            } else {
                c.this.g.a(this.f10033b, false, new d.a() { // from class: com.kwad.sdk.emotion.a.c.a.1
                    @Override // com.kwad.sdk.emotion.b.d.a
                    public void a() {
                        bVar.e();
                    }

                    @Override // com.kwad.sdk.emotion.b.d.a
                    public void a(String str) {
                        c.f10029a.put(a.this.f10033b.id, new SoftReference(BitmapFactory.decodeFile(str)));
                        a.this.a(a.this.f10033b);
                        bVar.b();
                    }
                });
            }
            if (!com.kwad.sdk.emotion.b.b.a().b(this.f10033b.id, true)) {
                c.this.g.a(this.f10033b, true, new d.a() { // from class: com.kwad.sdk.emotion.a.c.a.2
                    @Override // com.kwad.sdk.emotion.b.d.a
                    public void a() {
                        bVar.e();
                    }

                    @Override // com.kwad.sdk.emotion.b.d.a
                    public void a(String str) {
                        a.this.d = true;
                        a.this.a(a.this.f10033b);
                        bVar.c();
                    }
                });
                return;
            }
            this.d = true;
            a(this.f10033b);
            bVar.c();
        }
    }

    private c() {
    }

    public static c a() {
        if (c == null) {
            synchronized (c.class) {
                if (c == null) {
                    c = new c();
                }
            }
        }
        return c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(EmotionInfo emotionInfo, a aVar) {
        this.e.put(emotionInfo.id, emotionInfo);
        for (EmotionCode emotionCode : emotionInfo.emotionCodes) {
            for (String str : emotionCode.codes) {
                this.d.put(str, aVar);
            }
        }
    }

    private void a(EmotionPackage emotionPackage) {
        if (emotionPackage != null) {
            b bVar = new b(emotionPackage, this.h, new Runnable() { // from class: com.kwad.sdk.emotion.a.c.2
                @Override // java.lang.Runnable
                public void run() {
                    c.this.i.decrementAndGet();
                }
            });
            this.f.put(emotionPackage.id, bVar);
            if (emotionPackage.emotions != null) {
                for (EmotionInfo emotionInfo : emotionPackage.emotions) {
                    new a(emotionInfo).a(bVar);
                }
            }
        }
    }

    public Bitmap a(Context context, String str, int i) {
        a aVar = this.d.get(str);
        Bitmap a2 = aVar != null ? aVar.a() : null;
        return a2 != null ? a2 : BitmapFactory.decodeResource(context.getResources(), i);
    }

    public String a(String str) {
        return this.d.get(str).c;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void a(f fVar, com.kwad.sdk.emotion.c cVar) {
        if (fVar == null) {
            return;
        }
        List<EmotionPackage> a2 = fVar.a();
        this.i = new AtomicInteger(a2.size());
        this.h = cVar;
        for (EmotionPackage emotionPackage : a2) {
            a(emotionPackage);
        }
    }

    public Bitmap b(String str) {
        return com.kwad.sdk.emotion.b.d.a(a(str), true);
    }

    public boolean c(String str) {
        return this.d.containsKey(str);
    }
}
