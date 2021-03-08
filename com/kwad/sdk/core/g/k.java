package com.kwad.sdk.core.g;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.PhotoShareInfo;
import com.kwad.sdk.live.a.b;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    private static final Handler f6155a = new Handler(Looper.getMainLooper());

    /* loaded from: classes3.dex */
    public interface a {
        @MainThread
        void a(int i, String str);

        @MainThread
        void a(@NonNull PhotoShareInfo photoShareInfo);
    }

    public void a(final long j, @NonNull final a aVar) {
        new com.kwad.sdk.core.network.i<j, PhotoShareInfo>() { // from class: com.kwad.sdk.core.g.k.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.kwad.sdk.core.network.i
            @NonNull
            /* renamed from: a */
            public PhotoShareInfo b(String str) {
                PhotoShareInfo photoShareInfo = new PhotoShareInfo();
                photoShareInfo.parseJson(new JSONObject(str));
                return photoShareInfo;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: c */
            public j b() {
                return new j(j);
            }
        }.a(new com.kwad.sdk.core.network.j<j, PhotoShareInfo>() { // from class: com.kwad.sdk.core.g.k.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull j jVar, final int i, final String str) {
                k.f6155a.post(new Runnable() { // from class: com.kwad.sdk.core.g.k.2.2
                    @Override // java.lang.Runnable
                    public void run() {
                        com.kwad.sdk.core.d.a.d("PhotoShareUrlRequestManager", "load onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                        aVar.a(i, str);
                    }
                });
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull j jVar, @NonNull final PhotoShareInfo photoShareInfo) {
                k.f6155a.post(new Runnable() { // from class: com.kwad.sdk.core.g.k.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        aVar.a(photoShareInfo);
                    }
                });
            }
        });
    }

    public void a(final b.a aVar, @NonNull final a aVar2) {
        new com.kwad.sdk.core.network.i<com.kwad.sdk.live.a.b, PhotoShareInfo>() { // from class: com.kwad.sdk.core.g.k.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.kwad.sdk.core.network.i
            @NonNull
            /* renamed from: a */
            public PhotoShareInfo b(String str) {
                PhotoShareInfo photoShareInfo = new PhotoShareInfo();
                photoShareInfo.parseJson(new JSONObject(str));
                return photoShareInfo;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: c */
            public com.kwad.sdk.live.a.b b() {
                return new com.kwad.sdk.live.a.b(aVar);
            }
        }.a(new com.kwad.sdk.core.network.j<com.kwad.sdk.live.a.b, PhotoShareInfo>() { // from class: com.kwad.sdk.core.g.k.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull com.kwad.sdk.live.a.b bVar, final int i, final String str) {
                k.f6155a.post(new Runnable() { // from class: com.kwad.sdk.core.g.k.4.2
                    @Override // java.lang.Runnable
                    public void run() {
                        com.kwad.sdk.core.d.a.d("PhotoShareUrlRequestManager", "load onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                        aVar2.a(i, str);
                    }
                });
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull com.kwad.sdk.live.a.b bVar, @NonNull final PhotoShareInfo photoShareInfo) {
                k.f6155a.post(new Runnable() { // from class: com.kwad.sdk.core.g.k.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        aVar2.a(photoShareInfo);
                    }
                });
            }
        });
    }
}
