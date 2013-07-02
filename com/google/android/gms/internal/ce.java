package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.internal.cb;
import com.google.android.gms.internal.cc;
import com.google.android.gms.internal.p;
import com.google.android.gms.location.LocationClient;
import com.google.android.gms.location.LocationStatusCodes;
/* loaded from: classes.dex */
public class ce extends p {
    private final cd f;
    private final String g;

    /* loaded from: classes.dex */
    final class a extends p.b {
        private final int b;
        private final String[] c;

        public a(LocationClient.OnAddGeofencesResultListener onAddGeofencesResultListener, int i, String[] strArr) {
            super(onAddGeofencesResultListener);
            this.b = LocationStatusCodes.a(i);
            this.c = strArr;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.p.b
        public void a(LocationClient.OnAddGeofencesResultListener onAddGeofencesResultListener) {
            if (onAddGeofencesResultListener != null) {
                onAddGeofencesResultListener.a(this.b, this.c);
            }
        }
    }

    /* loaded from: classes.dex */
    final class b extends cb.a {
        final /* synthetic */ ce a;
        private final LocationClient.OnAddGeofencesResultListener b;
        private final LocationClient.OnRemoveGeofencesResultListener c;

        @Override // com.google.android.gms.internal.cb
        public void a(int i, PendingIntent pendingIntent) {
            this.a.a(new d(1, this.c, i, pendingIntent));
        }

        @Override // com.google.android.gms.internal.cb
        public void a(int i, String[] strArr) {
            this.a.a(new a(this.b, i, strArr));
        }

        @Override // com.google.android.gms.internal.cb
        public void b(int i, String[] strArr) {
            this.a.a(new d(2, this.c, i, strArr));
        }
    }

    /* loaded from: classes.dex */
    final class c implements ch {
        final /* synthetic */ ce a;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.gms.internal.ch
        /* renamed from: a */
        public cc b() {
            return (cc) this.a.k();
        }
    }

    /* loaded from: classes.dex */
    final class d extends p.b {
        private final int b;
        private final String[] c;
        private final PendingIntent d;
        private final int f;

        public d(int i, LocationClient.OnRemoveGeofencesResultListener onRemoveGeofencesResultListener, int i2, PendingIntent pendingIntent) {
            super(onRemoveGeofencesResultListener);
            n.a(i == 1);
            this.f = i;
            this.b = LocationStatusCodes.a(i2);
            this.d = pendingIntent;
            this.c = null;
        }

        public d(int i, LocationClient.OnRemoveGeofencesResultListener onRemoveGeofencesResultListener, int i2, String[] strArr) {
            super(onRemoveGeofencesResultListener);
            n.a(i == 2);
            this.f = i;
            this.b = LocationStatusCodes.a(i2);
            this.c = strArr;
            this.d = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.p.b
        public void a(LocationClient.OnRemoveGeofencesResultListener onRemoveGeofencesResultListener) {
            if (onRemoveGeofencesResultListener != null) {
                switch (this.f) {
                    case 1:
                        onRemoveGeofencesResultListener.a(this.b, this.d);
                        return;
                    case 2:
                        onRemoveGeofencesResultListener.a(this.b, this.c);
                        return;
                    default:
                        Log.wtf("LocationClientImpl", "Unsupported action: " + this.f);
                        return;
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p
    /* renamed from: a */
    public cc b(IBinder iBinder) {
        return cc.a.a(iBinder);
    }

    @Override // com.google.android.gms.internal.p
    public void a() {
        synchronized (this.f) {
            if (f()) {
                this.f.a();
            }
            super.a();
        }
    }

    @Override // com.google.android.gms.internal.p
    protected void a(u uVar, p.d dVar) {
        Bundle bundle = new Bundle();
        bundle.putString("client_name", this.g);
        uVar.e(dVar, 3136100, g().getPackageName(), bundle);
    }

    @Override // com.google.android.gms.internal.p
    protected String b() {
        return "com.google.android.location.internal.GoogleLocationManagerService.START";
    }

    @Override // com.google.android.gms.internal.p
    protected String c() {
        return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
    }
}
