package com.kwad.sdk.contentalliance.profile.home;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.kwad.sdk.contentalliance.profile.home.model.ProfileResultData;
import com.kwad.sdk.contentalliance.profile.home.model.UserProfile;
import com.kwad.sdk.core.g.a.f;
import com.kwad.sdk.core.g.q;
import com.kwad.sdk.core.network.i;
import com.kwad.sdk.core.network.j;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    private a f8773b;
    private i<q, ProfileResultData> c;
    private f e;
    private long f;
    private boolean d = false;

    /* renamed from: a  reason: collision with root package name */
    private Handler f8772a = new Handler(Looper.getMainLooper());

    /* loaded from: classes3.dex */
    public interface a {
        @MainThread
        void a();

        @MainThread
        void a(int i, String str);

        @MainThread
        void a(UserProfile userProfile);

        @MainThread
        void b();
    }

    public b(f fVar, long j, a aVar) {
        this.e = fVar;
        this.f = j;
        this.f8773b = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str) {
        com.kwad.sdk.core.d.a.c("DataFetcherProfile", "onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
        b(i, str);
        this.d = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ProfileResultData profileResultData) {
        a(profileResultData.userProfile);
        d();
        this.d = false;
    }

    private void a(UserProfile userProfile) {
        if (this.f8773b != null) {
            this.f8773b.a(userProfile);
        }
    }

    private void b(int i, String str) {
        if (this.f8773b != null) {
            this.f8773b.a(i, str);
        }
    }

    private void c() {
        if (this.f8773b != null) {
            this.f8773b.a();
        }
    }

    private void d() {
        if (this.f8773b != null) {
            this.f8773b.b();
        }
    }

    public void a() {
        if (this.d) {
            return;
        }
        c();
        this.c = new i<q, ProfileResultData>() { // from class: com.kwad.sdk.contentalliance.profile.home.b.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.kwad.sdk.core.network.i
            @NonNull
            /* renamed from: a */
            public ProfileResultData b(String str) {
                JSONObject jSONObject = new JSONObject(str);
                ProfileResultData profileResultData = new ProfileResultData();
                profileResultData.parseJson(jSONObject);
                return profileResultData;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: c */
            public q b() {
                return new q(b.this.e, b.this.f);
            }
        };
        this.c.a(new j<q, ProfileResultData>() { // from class: com.kwad.sdk.contentalliance.profile.home.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull q qVar, final int i, final String str) {
                b.this.f8772a.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.profile.home.b.2.2
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.a(i, str);
                    }
                });
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull q qVar, @NonNull final ProfileResultData profileResultData) {
                b.this.f8772a.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.profile.home.b.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.a(profileResultData);
                    }
                });
            }
        });
    }

    public void b() {
        if (this.c != null) {
            this.c.e();
        }
        this.f8773b = null;
        this.f8772a.removeCallbacksAndMessages(null);
    }
}
