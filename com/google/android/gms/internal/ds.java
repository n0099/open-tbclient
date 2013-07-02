package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.internal.dq;
import com.google.android.gms.internal.dr;
import com.google.android.gms.internal.p;
import com.google.android.gms.panorama.PanoramaClient;
/* loaded from: classes.dex */
public class ds extends p {

    /* loaded from: classes.dex */
    final class a extends p.b {
        public final ConnectionResult a;
        public final int b;
        public final Intent c;

        public a(PanoramaClient.a aVar, ConnectionResult connectionResult, int i, Intent intent) {
            super(aVar);
            this.a = connectionResult;
            this.b = i;
            this.c = intent;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.p.b
        public void a(PanoramaClient.a aVar) {
            if (aVar != null) {
                aVar.a(this.a, this.b, this.c);
            }
        }
    }

    /* loaded from: classes.dex */
    final class b extends dq.a {
        final /* synthetic */ ds a;
        private final PanoramaClient.a b;
        private final PanoramaClient.OnPanoramaInfoLoadedListener c;
        private final Uri d;

        @Override // com.google.android.gms.internal.dq
        public void a(int i, Bundle bundle, int i2, Intent intent) {
            if (this.d != null) {
                this.a.g().revokeUriPermission(this.d, 1);
            }
            ConnectionResult connectionResult = new ConnectionResult(i, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null);
            if (this.b != null) {
                this.a.a(new a(this.b, connectionResult, i2, intent));
            } else {
                this.a.a(new c(this.c, connectionResult, intent));
            }
        }
    }

    /* loaded from: classes.dex */
    final class c extends p.b {
        private final ConnectionResult b;
        private final Intent c;

        public c(PanoramaClient.OnPanoramaInfoLoadedListener onPanoramaInfoLoadedListener, ConnectionResult connectionResult, Intent intent) {
            super(onPanoramaInfoLoadedListener);
            this.b = connectionResult;
            this.c = intent;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.p.b
        public void a(PanoramaClient.OnPanoramaInfoLoadedListener onPanoramaInfoLoadedListener) {
            if (onPanoramaInfoLoadedListener != null) {
                onPanoramaInfoLoadedListener.a(this.b, this.c);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.gms.internal.p
    /* renamed from: a */
    public dr b(IBinder iBinder) {
        return dr.a.a(iBinder);
    }

    @Override // com.google.android.gms.internal.p
    protected void a(u uVar, p.d dVar) {
        uVar.a(dVar, 3136100, g().getPackageName(), new Bundle());
    }

    @Override // com.google.android.gms.internal.p
    protected String b() {
        return "com.google.android.gms.panorama.service.START";
    }

    @Override // com.google.android.gms.internal.p
    protected String c() {
        return "com.google.android.gms.panorama.internal.IPanoramaService";
    }
}
