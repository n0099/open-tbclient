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
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final HashMap<String, SoftReference<Bitmap>> f35027a = new HashMap<>(168);

    /* renamed from: b  reason: collision with root package name */
    public static final g f35028b = new com.kwad.sdk.emotion.a.a() { // from class: com.kwad.sdk.emotion.a.c.1
    };

    /* renamed from: c  reason: collision with root package name */
    public static volatile c f35029c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, a> f35030d = new ConcurrentHashMap();

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, EmotionInfo> f35031e = new ConcurrentHashMap();

    /* renamed from: f  reason: collision with root package name */
    public final Map<String, b> f35032f = new ConcurrentHashMap();

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.emotion.b.d f35033g = new com.kwad.sdk.emotion.b.d();

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.emotion.c f35034h;
    public AtomicInteger i;

    /* loaded from: classes6.dex */
    public class a {

        /* renamed from: b  reason: collision with root package name */
        public EmotionInfo f35037b;

        /* renamed from: c  reason: collision with root package name */
        public String f35038c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f35039d;

        public a(EmotionInfo emotionInfo) {
            this.f35037b = emotionInfo;
            this.f35038c = emotionInfo.id;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(EmotionInfo emotionInfo) {
            if (c.f35027a.get(emotionInfo.id) == null || !this.f35039d) {
                return;
            }
            c.this.a(emotionInfo, this);
        }

        @Nullable
        public Bitmap a() {
            SoftReference softReference = (SoftReference) c.f35027a.get(this.f35038c);
            Bitmap bitmap = softReference != null ? (Bitmap) softReference.get() : null;
            if (bitmap == null || bitmap.isRecycled()) {
                Bitmap a2 = com.kwad.sdk.emotion.b.d.a(this.f35037b.id, false);
                c.f35027a.put(this.f35038c, new SoftReference(a2));
                return a2;
            }
            return bitmap;
        }

        @SuppressLint({"CheckResult"})
        public void a(final b bVar) {
            Bitmap a2 = com.kwad.sdk.emotion.b.d.a(this.f35037b.id, false);
            if (a2 != null) {
                c.f35027a.put(this.f35037b.id, new SoftReference(a2));
                a(this.f35037b);
                bVar.b();
            } else {
                c.this.f35033g.a(this.f35037b, false, new d.a() { // from class: com.kwad.sdk.emotion.a.c.a.1
                    @Override // com.kwad.sdk.emotion.b.d.a
                    public void a() {
                        bVar.e();
                    }

                    @Override // com.kwad.sdk.emotion.b.d.a
                    public void a(String str) {
                        c.f35027a.put(a.this.f35037b.id, new SoftReference(BitmapFactory.decodeFile(str)));
                        a aVar = a.this;
                        aVar.a(aVar.f35037b);
                        bVar.b();
                    }
                });
            }
            if (!com.kwad.sdk.emotion.b.b.a().b(this.f35037b.id, true)) {
                c.this.f35033g.a(this.f35037b, true, new d.a() { // from class: com.kwad.sdk.emotion.a.c.a.2
                    @Override // com.kwad.sdk.emotion.b.d.a
                    public void a() {
                        bVar.e();
                    }

                    @Override // com.kwad.sdk.emotion.b.d.a
                    public void a(String str) {
                        a.this.f35039d = true;
                        a aVar = a.this;
                        aVar.a(aVar.f35037b);
                        bVar.c();
                    }
                });
                return;
            }
            this.f35039d = true;
            a(this.f35037b);
            bVar.c();
        }
    }

    public static c a() {
        if (f35029c == null) {
            synchronized (c.class) {
                if (f35029c == null) {
                    f35029c = new c();
                }
            }
        }
        return f35029c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(EmotionInfo emotionInfo, a aVar) {
        this.f35031e.put(emotionInfo.id, emotionInfo);
        for (EmotionCode emotionCode : emotionInfo.emotionCodes) {
            for (String str : emotionCode.codes) {
                this.f35030d.put(str, aVar);
            }
        }
    }

    private void a(EmotionPackage emotionPackage) {
        if (emotionPackage != null) {
            b bVar = new b(emotionPackage, this.f35034h, new Runnable() { // from class: com.kwad.sdk.emotion.a.c.2
                @Override // java.lang.Runnable
                public void run() {
                    c.this.i.decrementAndGet();
                }
            });
            this.f35032f.put(emotionPackage.id, bVar);
            List<EmotionInfo> list = emotionPackage.emotions;
            if (list != null) {
                for (EmotionInfo emotionInfo : list) {
                    new a(emotionInfo).a(bVar);
                }
            }
        }
    }

    public Bitmap a(Context context, String str, int i) {
        a aVar = this.f35030d.get(str);
        Bitmap a2 = aVar != null ? aVar.a() : null;
        return a2 != null ? a2 : BitmapFactory.decodeResource(context.getResources(), i);
    }

    public String a(String str) {
        return this.f35030d.get(str).f35038c;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void a(f fVar, com.kwad.sdk.emotion.c cVar) {
        if (fVar == null) {
            return;
        }
        List<EmotionPackage> a2 = fVar.a();
        this.i = new AtomicInteger(a2.size());
        this.f35034h = cVar;
        for (EmotionPackage emotionPackage : a2) {
            a(emotionPackage);
        }
    }

    public Bitmap b(String str) {
        return com.kwad.sdk.emotion.b.d.a(a(str), true);
    }

    public boolean c(String str) {
        return this.f35030d.containsKey(str);
    }
}
