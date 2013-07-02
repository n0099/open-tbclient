package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.internal.dx;
import com.google.android.gms.internal.p;
import com.google.android.gms.internal.t;
import com.google.android.gms.plus.PlusClient;
import com.google.android.gms.plus.model.moments.MomentBuffer;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.io.IOException;
/* loaded from: classes.dex */
public class dy extends p {
    private final String f;
    private final String g;
    private final String h;
    private Person i;
    private final String[] j;
    private final String[] k;

    /* loaded from: classes.dex */
    final class a extends dv {
        final /* synthetic */ dy a;
        private final PlusClient.OnMomentsLoadedListener b;

        @Override // com.google.android.gms.internal.dv, com.google.android.gms.internal.dw
        public void a(com.google.android.gms.internal.k kVar, String str, String str2) {
            if (kVar.c() != null) {
                kVar.c().getParcelable("pendingIntent");
            }
            this.a.a(new b(this.b, new ConnectionResult(kVar.b(), null), kVar, str, str2));
        }
    }

    /* loaded from: classes.dex */
    final class b extends p.c {
        private final ConnectionResult b;
        private final String c;
        private final String g;

        public b(PlusClient.OnMomentsLoadedListener onMomentsLoadedListener, ConnectionResult connectionResult, com.google.android.gms.internal.k kVar, String str, String str2) {
            super(onMomentsLoadedListener, kVar);
            this.b = connectionResult;
            this.c = str;
            this.g = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.p.b
        public void a(PlusClient.OnMomentsLoadedListener onMomentsLoadedListener) {
            if (onMomentsLoadedListener != null) {
                onMomentsLoadedListener.a(this.b, new MomentBuffer(this.d), this.c, this.g);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class c extends dv {
        private final PlusClient.a b;

        public c(PlusClient.a aVar) {
            this.b = aVar;
        }

        @Override // com.google.android.gms.internal.dv, com.google.android.gms.internal.dw
        public void a(int i, Bundle bundle, ParcelFileDescriptor parcelFileDescriptor) {
            dy.this.a(new d(this.b, new ConnectionResult(i, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null), parcelFileDescriptor));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class d extends p.b {
        private final ConnectionResult b;
        private final ParcelFileDescriptor c;

        public d(PlusClient.a aVar, ConnectionResult connectionResult, ParcelFileDescriptor parcelFileDescriptor) {
            super(aVar);
            this.b = connectionResult;
            this.c = parcelFileDescriptor;
        }

        @Override // com.google.android.gms.internal.p.b
        public void a() {
            super.a();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.gms.internal.p.b
        public void a(PlusClient.a aVar) {
            if (aVar != null) {
                aVar.a(this.b, this.c);
                return;
            }
            try {
                this.c.close();
            } catch (IOException e) {
                Log.e("PlusClientImpl", "failed close", e);
            }
        }
    }

    /* loaded from: classes.dex */
    final class e extends dv {
        final /* synthetic */ dy a;
        private final PlusClient.OnPeopleLoadedListener b;

        @Override // com.google.android.gms.internal.dv, com.google.android.gms.internal.dw
        public void a(com.google.android.gms.internal.k kVar, String str) {
            if (kVar.c() != null) {
                kVar.c().getParcelable("pendingIntent");
            }
            this.a.a(new f(this.b, new ConnectionResult(kVar.b(), null), kVar, str));
        }
    }

    /* loaded from: classes.dex */
    final class f extends p.c {
        private final ConnectionResult b;
        private final String c;

        public f(PlusClient.OnPeopleLoadedListener onPeopleLoadedListener, ConnectionResult connectionResult, com.google.android.gms.internal.k kVar, String str) {
            super(onPeopleLoadedListener, kVar);
            this.b = connectionResult;
            this.c = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.p.b
        public void a(PlusClient.OnPeopleLoadedListener onPeopleLoadedListener) {
            if (onPeopleLoadedListener != null) {
                onPeopleLoadedListener.a(this.b, new PersonBuffer(this.d), this.c);
            }
        }
    }

    /* loaded from: classes.dex */
    final class g extends dv {
        final /* synthetic */ dy a;
        private final PlusClient.OnPersonLoadedListener b;

        @Override // com.google.android.gms.internal.dv, com.google.android.gms.internal.dw
        public void a(int i, Bundle bundle, at atVar) {
            ConnectionResult connectionResult = new ConnectionResult(i, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null);
            if (atVar == null) {
                this.a.a(new h(this.b, connectionResult, null));
            } else {
                this.a.a(new h(this.b, connectionResult, (eq) atVar.a(eq.a)));
            }
        }
    }

    /* loaded from: classes.dex */
    final class h extends p.b {
        private final ConnectionResult b;
        private final Person c;

        public h(PlusClient.OnPersonLoadedListener onPersonLoadedListener, ConnectionResult connectionResult, Person person) {
            super(onPersonLoadedListener);
            this.b = connectionResult;
            this.c = person;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.p.b
        public void a(PlusClient.OnPersonLoadedListener onPersonLoadedListener) {
            if (onPersonLoadedListener != null) {
                onPersonLoadedListener.a(this.b, this.c);
            }
        }
    }

    /* loaded from: classes.dex */
    public final class i extends t.a {
        private p.d b;

        public i(p.d dVar) {
            this.b = dVar;
        }

        @Override // com.google.android.gms.internal.t
        public void a(int i, IBinder iBinder, Bundle bundle) {
            if (i == 0 && bundle != null && bundle.containsKey("loaded_person")) {
                dy.this.i = eq.a(bundle.getByteArray("loaded_person"));
            }
            this.b.a(i, iBinder, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class j extends dv {
        private final PlusClient.b b;

        public j(PlusClient.b bVar) {
            this.b = bVar;
        }

        @Override // com.google.android.gms.internal.dv, com.google.android.gms.internal.dw
        public void a(int i, Bundle bundle, Bundle bundle2) {
            dy.this.a(new k(this.b, new ConnectionResult(i, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null), bundle2 != null ? new du(bundle2) : null));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class k extends p.b {
        public final ConnectionResult a;
        public final du b;

        public k(PlusClient.b bVar, ConnectionResult connectionResult, du duVar) {
            super(bVar);
            this.a = connectionResult;
            this.b = duVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.p.b
        public void a(PlusClient.b bVar) {
            if (bVar != null) {
                bVar.a(this.a, this.b);
            }
        }
    }

    /* loaded from: classes.dex */
    final class l extends dv {
        final /* synthetic */ dy a;
        private final PlusClient.OnAccessRevokedListener b;

        @Override // com.google.android.gms.internal.dv, com.google.android.gms.internal.dw
        public void a(int i, Bundle bundle) {
            this.a.a(new m(this.b, new ConnectionResult(i, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null)));
        }
    }

    /* loaded from: classes.dex */
    final class m extends p.b {
        private final ConnectionResult b;

        public m(PlusClient.OnAccessRevokedListener onAccessRevokedListener, ConnectionResult connectionResult) {
            super(onAccessRevokedListener);
            this.b = connectionResult;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.p.b
        public void a(PlusClient.OnAccessRevokedListener onAccessRevokedListener) {
            dy.this.a();
            if (onAccessRevokedListener != null) {
                onAccessRevokedListener.a(this.b);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p
    /* renamed from: a */
    public dx b(IBinder iBinder) {
        return dx.a.a(iBinder);
    }

    @Override // com.google.android.gms.internal.p
    protected void a(u uVar, p.d dVar) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("skip_oob", false);
        bundle.putStringArray("request_visible_actions", this.j);
        if (this.k != null) {
            bundle.putStringArray("required_features", this.k);
        }
        uVar.a(new i(dVar), 3136100, this.f, this.g, h(), this.h, bundle);
    }

    public void a(PlusClient.a aVar, Uri uri, int i2) {
        j();
        Bundle bundle = new Bundle();
        bundle.putInt("bounding_box", i2);
        c cVar = new c(aVar);
        try {
            ((dx) k()).a(cVar, uri, bundle);
        } catch (RemoteException e2) {
            cVar.a(8, (Bundle) null, (ParcelFileDescriptor) null);
        }
    }

    public void a(PlusClient.b bVar, String str) {
        j();
        j jVar = new j(bVar);
        try {
            ((dx) k()).a(jVar, str);
        } catch (RemoteException e2) {
            jVar.a(8, (Bundle) null, (Bundle) null);
        }
    }

    @Override // com.google.android.gms.internal.p
    protected String b() {
        return "com.google.android.gms.plus.service.START";
    }

    @Override // com.google.android.gms.internal.p
    protected String c() {
        return "com.google.android.gms.plus.internal.IPlusService";
    }
}
