package com.kwad.sdk.emotion.a;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import com.kwad.sdk.emotion.a.e;
import com.kwad.sdk.emotion.model.EmotionPackage;
import com.kwad.sdk.emotion.model.EmotionResponse;
import com.kwad.sdk.utils.z;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes7.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static volatile d f35415a;

    /* renamed from: e  reason: collision with root package name */
    public static com.kwad.sdk.emotion.model.a f35416e;

    /* renamed from: f  reason: collision with root package name */
    public static com.kwad.sdk.emotion.model.b f35417f;

    /* renamed from: d  reason: collision with root package name */
    public int f35420d;

    /* renamed from: b  reason: collision with root package name */
    public boolean f35418b = false;

    /* renamed from: c  reason: collision with root package name */
    public final Map<Integer, f> f35419c = new ConcurrentHashMap();

    /* renamed from: g  reason: collision with root package name */
    public String f35421g = "0";

    public static d a() {
        if (f35415a == null) {
            synchronized (d.class) {
                if (f35415a == null) {
                    f35415a = new d();
                }
            }
        }
        return f35415a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<EmotionPackage> a(EmotionResponse emotionResponse) {
        if (emotionResponse == null) {
            return new ArrayList();
        }
        com.kwad.sdk.core.d.a.a("EmotionManager", "load form network: size=" + emotionResponse.mEmotionPackageList.size());
        return emotionResponse.mEmotionPackageList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<Integer, f> a(List<EmotionPackage> list) {
        com.kwad.sdk.core.d.a.a("EmotionManager", "load form network: size=" + list.size());
        this.f35419c.clear();
        this.f35420d = 0;
        for (EmotionPackage emotionPackage : list) {
            this.f35420d++;
            f fVar = this.f35419c.get(Integer.valueOf(emotionPackage.type));
            if (fVar != null) {
                fVar.a(emotionPackage.id, emotionPackage);
            } else {
                f fVar2 = new f();
                fVar2.a(emotionPackage.id, emotionPackage);
                this.f35419c.put(Integer.valueOf(emotionPackage.type), fVar2);
            }
        }
        return this.f35419c;
    }

    @SuppressLint({"CheckResult"})
    public void a(final com.kwad.sdk.emotion.b bVar) {
        e.a(new e.a() { // from class: com.kwad.sdk.emotion.a.d.2
            @Override // com.kwad.sdk.emotion.a.e.a
            public void a(int i2, String str) {
                d.this.f35418b = false;
                com.kwad.sdk.emotion.b bVar2 = bVar;
                if (bVar2 != null) {
                    bVar2.a(null);
                }
            }

            @Override // com.kwad.sdk.emotion.a.e.a
            public void a(EmotionResponse emotionResponse) {
                d.this.f35418b = true;
                d dVar = d.this;
                dVar.a(dVar.a(emotionResponse));
                com.kwad.sdk.emotion.b bVar2 = bVar;
                if (bVar2 != null) {
                    bVar2.a();
                }
            }
        });
    }

    public void a(@NonNull com.kwad.sdk.emotion.model.a aVar, @NonNull com.kwad.sdk.emotion.model.b bVar) {
        z.a(bVar.a());
        z.a(aVar.b());
        f35416e = aVar;
        f35417f = bVar;
        com.kwad.sdk.emotion.b.e.a(aVar.b());
        com.kwad.sdk.core.d.a.a("EmotionManager", "sConfig.getSaveDir()" + f35416e.b());
        a(new com.kwad.sdk.emotion.b() { // from class: com.kwad.sdk.emotion.a.d.1
            @Override // com.kwad.sdk.emotion.b
            public void a() {
                d.this.b();
                com.kwad.sdk.core.d.a.a("EmotionManager", "fetchEmotionInfo");
            }

            @Override // com.kwad.sdk.emotion.b
            public void a(Throwable th) {
                com.kwad.sdk.core.d.a.a("EmotionManager", "fetchEmotionInfo e", th);
            }
        });
    }

    public void b() {
        com.kwad.sdk.emotion.b.b.a().a(f35416e.b());
        if (this.f35418b) {
            c.a().a(this.f35419c.get(1), f35417f.b());
        } else {
            f35417f.b().a(null, new IllegalStateException("not available: invoke `#fetchEmotionInfo()` or check `#isAvailable()`"));
        }
    }
}
