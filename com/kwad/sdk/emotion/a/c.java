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
    public static final HashMap<String, SoftReference<Bitmap>> f34932a = new HashMap<>(168);

    /* renamed from: b  reason: collision with root package name */
    public static final g f34933b = new com.kwad.sdk.emotion.a.a() { // from class: com.kwad.sdk.emotion.a.c.1
    };

    /* renamed from: c  reason: collision with root package name */
    public static volatile c f34934c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, a> f34935d = new ConcurrentHashMap();

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, EmotionInfo> f34936e = new ConcurrentHashMap();

    /* renamed from: f  reason: collision with root package name */
    public final Map<String, b> f34937f = new ConcurrentHashMap();

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.emotion.b.d f34938g = new com.kwad.sdk.emotion.b.d();

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.emotion.c f34939h;
    public AtomicInteger i;

    /* loaded from: classes6.dex */
    public class a {

        /* renamed from: b  reason: collision with root package name */
        public EmotionInfo f34942b;

        /* renamed from: c  reason: collision with root package name */
        public String f34943c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f34944d;

        public a(EmotionInfo emotionInfo) {
            this.f34942b = emotionInfo;
            this.f34943c = emotionInfo.id;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(EmotionInfo emotionInfo) {
            if (c.f34932a.get(emotionInfo.id) == null || !this.f34944d) {
                return;
            }
            c.this.a(emotionInfo, this);
        }

        @Nullable
        public Bitmap a() {
            SoftReference softReference = (SoftReference) c.f34932a.get(this.f34943c);
            Bitmap bitmap = softReference != null ? (Bitmap) softReference.get() : null;
            if (bitmap == null || bitmap.isRecycled()) {
                Bitmap a2 = com.kwad.sdk.emotion.b.d.a(this.f34942b.id, false);
                c.f34932a.put(this.f34943c, new SoftReference(a2));
                return a2;
            }
            return bitmap;
        }

        @SuppressLint({"CheckResult"})
        public void a(final b bVar) {
            Bitmap a2 = com.kwad.sdk.emotion.b.d.a(this.f34942b.id, false);
            if (a2 != null) {
                c.f34932a.put(this.f34942b.id, new SoftReference(a2));
                a(this.f34942b);
                bVar.b();
            } else {
                c.this.f34938g.a(this.f34942b, false, new d.a() { // from class: com.kwad.sdk.emotion.a.c.a.1
                    @Override // com.kwad.sdk.emotion.b.d.a
                    public void a() {
                        bVar.e();
                    }

                    @Override // com.kwad.sdk.emotion.b.d.a
                    public void a(String str) {
                        c.f34932a.put(a.this.f34942b.id, new SoftReference(BitmapFactory.decodeFile(str)));
                        a aVar = a.this;
                        aVar.a(aVar.f34942b);
                        bVar.b();
                    }
                });
            }
            if (!com.kwad.sdk.emotion.b.b.a().b(this.f34942b.id, true)) {
                c.this.f34938g.a(this.f34942b, true, new d.a() { // from class: com.kwad.sdk.emotion.a.c.a.2
                    @Override // com.kwad.sdk.emotion.b.d.a
                    public void a() {
                        bVar.e();
                    }

                    @Override // com.kwad.sdk.emotion.b.d.a
                    public void a(String str) {
                        a.this.f34944d = true;
                        a aVar = a.this;
                        aVar.a(aVar.f34942b);
                        bVar.c();
                    }
                });
                return;
            }
            this.f34944d = true;
            a(this.f34942b);
            bVar.c();
        }
    }

    public static c a() {
        if (f34934c == null) {
            synchronized (c.class) {
                if (f34934c == null) {
                    f34934c = new c();
                }
            }
        }
        return f34934c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(EmotionInfo emotionInfo, a aVar) {
        this.f34936e.put(emotionInfo.id, emotionInfo);
        for (EmotionCode emotionCode : emotionInfo.emotionCodes) {
            for (String str : emotionCode.codes) {
                this.f34935d.put(str, aVar);
            }
        }
    }

    private void a(EmotionPackage emotionPackage) {
        if (emotionPackage != null) {
            b bVar = new b(emotionPackage, this.f34939h, new Runnable() { // from class: com.kwad.sdk.emotion.a.c.2
                @Override // java.lang.Runnable
                public void run() {
                    c.this.i.decrementAndGet();
                }
            });
            this.f34937f.put(emotionPackage.id, bVar);
            List<EmotionInfo> list = emotionPackage.emotions;
            if (list != null) {
                for (EmotionInfo emotionInfo : list) {
                    new a(emotionInfo).a(bVar);
                }
            }
        }
    }

    public Bitmap a(Context context, String str, int i) {
        a aVar = this.f34935d.get(str);
        Bitmap a2 = aVar != null ? aVar.a() : null;
        return a2 != null ? a2 : BitmapFactory.decodeResource(context.getResources(), i);
    }

    public String a(String str) {
        return this.f34935d.get(str).f34943c;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void a(f fVar, com.kwad.sdk.emotion.c cVar) {
        if (fVar == null) {
            return;
        }
        List<EmotionPackage> a2 = fVar.a();
        this.i = new AtomicInteger(a2.size());
        this.f34939h = cVar;
        for (EmotionPackage emotionPackage : a2) {
            a(emotionPackage);
        }
    }

    public Bitmap b(String str) {
        return com.kwad.sdk.emotion.b.d.a(a(str), true);
    }

    public boolean c(String str) {
        return this.f34935d.containsKey(str);
    }
}
