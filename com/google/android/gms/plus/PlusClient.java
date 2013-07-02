package com.google.android.gms.plus;

import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.internal.du;
import com.google.android.gms.internal.dy;
import com.google.android.gms.plus.model.moments.MomentBuffer;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
/* loaded from: classes.dex */
public class PlusClient implements GooglePlayServicesClient {
    final dy a;

    /* loaded from: classes.dex */
    public class Builder {
    }

    /* loaded from: classes.dex */
    public interface OnAccessRevokedListener {
        void a(ConnectionResult connectionResult);
    }

    /* loaded from: classes.dex */
    public interface OnMomentsLoadedListener {
        void a(ConnectionResult connectionResult, MomentBuffer momentBuffer, String str, String str2);
    }

    /* loaded from: classes.dex */
    public interface OnPeopleLoadedListener {
        void a(ConnectionResult connectionResult, PersonBuffer personBuffer, String str);
    }

    /* loaded from: classes.dex */
    public interface OnPersonLoadedListener {
        void a(ConnectionResult connectionResult, Person person);
    }

    /* loaded from: classes.dex */
    public interface a {
        void a(ConnectionResult connectionResult, ParcelFileDescriptor parcelFileDescriptor);
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(ConnectionResult connectionResult, du duVar);
    }

    public void a(GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks) {
        this.a.a(connectionCallbacks);
    }

    public void a(GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.a.a(onConnectionFailedListener);
    }

    public void a(a aVar, Uri uri, int i) {
        this.a.a(aVar, uri, i);
    }

    public void a(b bVar, String str) {
        this.a.a(bVar, str);
    }

    public boolean a() {
        return this.a.f();
    }

    public boolean b(GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks) {
        return this.a.b(connectionCallbacks);
    }

    public boolean b(GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener) {
        return this.a.b(onConnectionFailedListener);
    }

    public void c(GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks) {
        this.a.c(connectionCallbacks);
    }

    public void c(GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.a.c(onConnectionFailedListener);
    }
}
