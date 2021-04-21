package com.kwad.sdk.core.g;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.g.h;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.TrendFeedResultData;
import com.kwad.sdk.core.response.model.TrendInfo;
import com.kwad.sdk.core.response.model.TrendListResultData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public static final Handler f34197a = new Handler(Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f34198b = false;

    /* loaded from: classes6.dex */
    public interface a {
        @WorkerThread
        void a(int i, String str);

        @WorkerThread
        void a(@NonNull TrendFeedResultData trendFeedResultData);
    }

    /* loaded from: classes6.dex */
    public interface b {
        @WorkerThread
        void a(int i, String str);

        @WorkerThread
        void a(@NonNull TrendListResultData trendListResultData);
    }

    /* loaded from: classes6.dex */
    public interface c {
        @MainThread
        void a(int i, String str);

        @MainThread
        void a(@NonNull List<AdTemplate> list);
    }

    /* loaded from: classes6.dex */
    public interface d {
        @MainThread
        void a(int i, String str);

        @MainThread
        void a(@NonNull List<TrendInfo> list);
    }

    public static void a(final h.a aVar, @NonNull final TrendInfo trendInfo, @NonNull final a aVar2) {
        new com.kwad.sdk.core.network.i<m, TrendFeedResultData>() { // from class: com.kwad.sdk.core.g.o.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.i
            @NonNull
            /* renamed from: a */
            public TrendFeedResultData b(String str) {
                JSONObject jSONObject = new JSONObject(str);
                TrendFeedResultData trendFeedResultData = new TrendFeedResultData(h.a.this.f34169a.get(0).f34035a, trendInfo);
                trendFeedResultData.parseJson(jSONObject);
                return trendFeedResultData;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: c */
            public m b() {
                return new m(h.a.this, trendInfo.trendId);
            }
        }.a(new com.kwad.sdk.core.network.j<m, TrendFeedResultData>() { // from class: com.kwad.sdk.core.g.o.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull m mVar, int i, String str) {
                a.this.a(i, str);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull m mVar, @NonNull TrendFeedResultData trendFeedResultData) {
                a.this.a(trendFeedResultData);
            }
        });
    }

    public static void a(h.a aVar, @NonNull TrendInfo trendInfo, @NonNull final c cVar) {
        a(aVar, trendInfo, new a() { // from class: com.kwad.sdk.core.g.o.4
            @Override // com.kwad.sdk.core.g.o.a
            public void a(final int i, final String str) {
                o.f34197a.post(new Runnable() { // from class: com.kwad.sdk.core.g.o.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.kwad.sdk.core.d.a.d("TrendRequestManager", "loadFeedByTrendId onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                        c.this.a(i, str);
                    }
                });
            }

            @Override // com.kwad.sdk.core.g.o.a
            public void a(@NonNull final TrendFeedResultData trendFeedResultData) {
                if (trendFeedResultData.result != 1) {
                    int i = com.kwad.sdk.core.network.f.f34255c.k;
                    a(i, com.kwad.sdk.core.network.f.f34255c.l + "(无视频资源)");
                } else if (!trendFeedResultData.adTemplateList.isEmpty()) {
                    o.f34197a.post(new Runnable() { // from class: com.kwad.sdk.core.g.o.4.2
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.a(trendFeedResultData.adTemplateList);
                        }
                    });
                } else {
                    int i2 = com.kwad.sdk.core.network.f.f34255c.k;
                    a(i2, com.kwad.sdk.core.network.f.f34255c.l + "(无视频资源)");
                }
            }
        });
    }

    public static void a(final boolean z, @NonNull final b bVar) {
        new com.kwad.sdk.core.network.i<n, TrendListResultData>() { // from class: com.kwad.sdk.core.g.o.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.i
            @NonNull
            /* renamed from: a */
            public TrendListResultData b(String str) {
                JSONObject jSONObject = new JSONObject(str);
                TrendListResultData trendListResultData = new TrendListResultData();
                trendListResultData.parseJson(jSONObject);
                return trendListResultData;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: c */
            public n b() {
                return new n(z);
            }
        }.a(new com.kwad.sdk.core.network.j<n, TrendListResultData>() { // from class: com.kwad.sdk.core.g.o.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull n nVar, int i, String str) {
                b.this.a(i, str);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull n nVar, @NonNull TrendListResultData trendListResultData) {
                b.this.a(trendListResultData);
            }
        });
    }

    public static void a(boolean z, @NonNull final d dVar) {
        if (f34198b) {
            return;
        }
        f34198b = true;
        a(z, new b() { // from class: com.kwad.sdk.core.g.o.1
            @Override // com.kwad.sdk.core.g.o.b
            public void a(final int i, final String str) {
                boolean unused = o.f34198b = false;
                o.f34197a.post(new Runnable() { // from class: com.kwad.sdk.core.g.o.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.kwad.sdk.core.d.a.d("TrendRequestManager", "loadTrendList onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                        d.this.a(i, str);
                    }
                });
            }

            @Override // com.kwad.sdk.core.g.o.b
            public void a(@NonNull TrendListResultData trendListResultData) {
                if (trendListResultData.result != 1) {
                    int i = com.kwad.sdk.core.network.f.f34255c.k;
                    a(i, com.kwad.sdk.core.network.f.f34255c.l + "(无视频资源)");
                    return;
                }
                final ArrayList arrayList = new ArrayList();
                for (TrendInfo trendInfo : trendListResultData.trends) {
                    if (trendInfo != null) {
                        arrayList.add(trendInfo);
                    }
                }
                if (arrayList.isEmpty()) {
                    int i2 = com.kwad.sdk.core.network.f.f34255c.k;
                    a(i2, com.kwad.sdk.core.network.f.f34255c.l + "(无热点资源)");
                } else {
                    o.f34197a.post(new Runnable() { // from class: com.kwad.sdk.core.g.o.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.a(arrayList);
                        }
                    });
                }
                boolean unused = o.f34198b = false;
            }
        });
    }
}
