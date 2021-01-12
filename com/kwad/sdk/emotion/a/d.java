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
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static volatile d f9738a;
    private static com.kwad.sdk.emotion.model.a e;
    private static com.kwad.sdk.emotion.model.b f;
    private int d;

    /* renamed from: b  reason: collision with root package name */
    private boolean f9739b = false;
    private final Map<Integer, f> c = new ConcurrentHashMap();
    private String g = "0";

    private d() {
    }

    public static d a() {
        if (f9738a == null) {
            synchronized (d.class) {
                if (f9738a == null) {
                    f9738a = new d();
                }
            }
        }
        return f9738a;
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
        this.c.clear();
        this.d = 0;
        for (EmotionPackage emotionPackage : list) {
            this.d++;
            f fVar = this.c.get(Integer.valueOf(emotionPackage.type));
            if (fVar != null) {
                fVar.a(emotionPackage.id, emotionPackage);
            } else {
                f fVar2 = new f();
                fVar2.a(emotionPackage.id, emotionPackage);
                this.c.put(Integer.valueOf(emotionPackage.type), fVar2);
            }
        }
        return this.c;
    }

    @SuppressLint({"CheckResult"})
    public void a(final com.kwad.sdk.emotion.b bVar) {
        e.a(new e.a() { // from class: com.kwad.sdk.emotion.a.d.2
            @Override // com.kwad.sdk.emotion.a.e.a
            public void a(int i, String str) {
                d.this.f9739b = false;
                if (bVar != null) {
                    bVar.a(null);
                }
            }

            @Override // com.kwad.sdk.emotion.a.e.a
            public void a(EmotionResponse emotionResponse) {
                d.this.f9739b = true;
                d.this.a(d.this.a(emotionResponse));
                if (bVar != null) {
                    bVar.a();
                }
            }
        });
    }

    public void a(@NonNull com.kwad.sdk.emotion.model.a aVar, @NonNull com.kwad.sdk.emotion.model.b bVar) {
        z.a(bVar.a());
        z.a(aVar.b());
        e = aVar;
        f = bVar;
        com.kwad.sdk.emotion.b.e.a(e.b());
        com.kwad.sdk.core.d.a.a("EmotionManager", "sConfig.getSaveDir()" + e.b());
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
        com.kwad.sdk.emotion.b.b.a().a(e.b());
        if (this.f9739b) {
            c.a().a(this.c.get(1), f.b());
        } else {
            f.b().a(null, new IllegalStateException("not available: invoke `#fetchEmotionInfo()` or check `#isAvailable()`"));
        }
    }
}
