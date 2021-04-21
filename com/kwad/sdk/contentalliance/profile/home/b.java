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
/* loaded from: classes6.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public a f33240b;

    /* renamed from: c  reason: collision with root package name */
    public i<q, ProfileResultData> f33241c;

    /* renamed from: e  reason: collision with root package name */
    public f f33243e;

    /* renamed from: f  reason: collision with root package name */
    public long f33244f;

    /* renamed from: d  reason: collision with root package name */
    public boolean f33242d = false;

    /* renamed from: a  reason: collision with root package name */
    public Handler f33239a = new Handler(Looper.getMainLooper());

    /* loaded from: classes6.dex */
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
        this.f33243e = fVar;
        this.f33244f = j;
        this.f33240b = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str) {
        com.kwad.sdk.core.d.a.c("DataFetcherProfile", "onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
        b(i, str);
        this.f33242d = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ProfileResultData profileResultData) {
        a(profileResultData.userProfile);
        d();
        this.f33242d = false;
    }

    private void a(UserProfile userProfile) {
        a aVar = this.f33240b;
        if (aVar != null) {
            aVar.a(userProfile);
        }
    }

    private void b(int i, String str) {
        a aVar = this.f33240b;
        if (aVar != null) {
            aVar.a(i, str);
        }
    }

    private void c() {
        a aVar = this.f33240b;
        if (aVar != null) {
            aVar.a();
        }
    }

    private void d() {
        a aVar = this.f33240b;
        if (aVar != null) {
            aVar.b();
        }
    }

    public void a() {
        if (this.f33242d) {
            return;
        }
        c();
        i<q, ProfileResultData> iVar = new i<q, ProfileResultData>() { // from class: com.kwad.sdk.contentalliance.profile.home.b.1
            /* JADX DEBUG: Method merged with bridge method */
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
                return new q(b.this.f33243e, b.this.f33244f);
            }
        };
        this.f33241c = iVar;
        iVar.a(new j<q, ProfileResultData>() { // from class: com.kwad.sdk.contentalliance.profile.home.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull q qVar, final int i, final String str) {
                b.this.f33239a.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.profile.home.b.2.2
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.a(i, str);
                    }
                });
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull q qVar, @NonNull final ProfileResultData profileResultData) {
                b.this.f33239a.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.profile.home.b.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.a(profileResultData);
                    }
                });
            }
        });
    }

    public void b() {
        i<q, ProfileResultData> iVar = this.f33241c;
        if (iVar != null) {
            iVar.e();
        }
        this.f33240b = null;
        this.f33239a.removeCallbacksAndMessages(null);
    }
}
