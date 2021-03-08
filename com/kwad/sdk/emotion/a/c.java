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
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final HashMap<String, SoftReference<Bitmap>> f6442a = new HashMap<>(168);
    private static final g b = new com.kwad.sdk.emotion.a.a() { // from class: com.kwad.sdk.emotion.a.c.1
    };
    private static volatile c c;
    private final Map<String, a> d = new ConcurrentHashMap();
    private final Map<String, EmotionInfo> e = new ConcurrentHashMap();
    private final Map<String, b> f = new ConcurrentHashMap();
    private com.kwad.sdk.emotion.b.d g = new com.kwad.sdk.emotion.b.d();
    private com.kwad.sdk.emotion.c h;
    private AtomicInteger i;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        private EmotionInfo b;
        private String c;
        private boolean d;

        a(EmotionInfo emotionInfo) {
            this.b = emotionInfo;
            this.c = emotionInfo.id;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(EmotionInfo emotionInfo) {
            if (c.f6442a.get(emotionInfo.id) == null || !this.d) {
                return;
            }
            c.this.a(emotionInfo, this);
        }

        @Nullable
        Bitmap a() {
            SoftReference softReference = (SoftReference) c.f6442a.get(this.c);
            Bitmap bitmap = softReference != null ? (Bitmap) softReference.get() : null;
            if (bitmap == null || bitmap.isRecycled()) {
                Bitmap a2 = com.kwad.sdk.emotion.b.d.a(this.b.id, false);
                c.f6442a.put(this.c, new SoftReference(a2));
                return a2;
            }
            return bitmap;
        }

        @SuppressLint({"CheckResult"})
        void a(final b bVar) {
            Bitmap a2 = com.kwad.sdk.emotion.b.d.a(this.b.id, false);
            if (a2 != null) {
                c.f6442a.put(this.b.id, new SoftReference(a2));
                a(this.b);
                bVar.b();
            } else {
                c.this.g.a(this.b, false, new d.a() { // from class: com.kwad.sdk.emotion.a.c.a.1
                    @Override // com.kwad.sdk.emotion.b.d.a
                    public void a() {
                        bVar.e();
                    }

                    @Override // com.kwad.sdk.emotion.b.d.a
                    public void a(String str) {
                        c.f6442a.put(a.this.b.id, new SoftReference(BitmapFactory.decodeFile(str)));
                        a.this.a(a.this.b);
                        bVar.b();
                    }
                });
            }
            if (!com.kwad.sdk.emotion.b.b.a().b(this.b.id, true)) {
                c.this.g.a(this.b, true, new d.a() { // from class: com.kwad.sdk.emotion.a.c.a.2
                    @Override // com.kwad.sdk.emotion.b.d.a
                    public void a() {
                        bVar.e();
                    }

                    @Override // com.kwad.sdk.emotion.b.d.a
                    public void a(String str) {
                        a.this.d = true;
                        a.this.a(a.this.b);
                        bVar.c();
                    }
                });
                return;
            }
            this.d = true;
            a(this.b);
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
