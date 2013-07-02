package com.google.android.gms.maps;

import android.location.Location;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.internal.bc;
import com.google.android.gms.internal.bd;
import com.google.android.gms.internal.ck;
import com.google.android.gms.internal.cm;
import com.google.android.gms.internal.cn;
import com.google.android.gms.internal.co;
import com.google.android.gms.internal.cp;
import com.google.android.gms.internal.cq;
import com.google.android.gms.internal.cr;
import com.google.android.gms.internal.cs;
import com.google.android.gms.internal.ct;
import com.google.android.gms.internal.cu;
import com.google.android.gms.internal.dm;
import com.google.android.gms.internal.x;
import com.google.android.gms.maps.LocationSource;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.ILocationSourceDelegate;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.RuntimeRemoteException;
/* loaded from: classes.dex */
public final class GoogleMap {
    private final IGoogleMapDelegate a;

    /* renamed from: com.google.android.gms.maps.GoogleMap$1  reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 extends ILocationSourceDelegate.a {
        final /* synthetic */ LocationSource a;

        @Override // com.google.android.gms.maps.internal.ILocationSourceDelegate
        public void a() {
            this.a.a();
        }

        @Override // com.google.android.gms.maps.internal.ILocationSourceDelegate
        public void a(final cp cpVar) {
            this.a.a(new LocationSource.OnLocationChangedListener() { // from class: com.google.android.gms.maps.GoogleMap.1.1
            });
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap$3  reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass3 extends cq.a {
        final /* synthetic */ OnMapClickListener a;

        @Override // com.google.android.gms.internal.cq
        public void a(LatLng latLng) {
            this.a.a(latLng);
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap$4  reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass4 extends cr.a {
        final /* synthetic */ OnMapLongClickListener a;

        @Override // com.google.android.gms.internal.cr
        public void a(LatLng latLng) {
            this.a.a(latLng);
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap$5  reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass5 extends cs.a {
        final /* synthetic */ OnMarkerClickListener a;

        @Override // com.google.android.gms.internal.cs
        public boolean a(dm dmVar) {
            return this.a.a(new Marker(dmVar));
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap$6  reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass6 extends ct.a {
        final /* synthetic */ OnMarkerDragListener a;

        @Override // com.google.android.gms.internal.ct
        public void a(dm dmVar) {
            this.a.a(new Marker(dmVar));
        }

        @Override // com.google.android.gms.internal.ct
        public void b(dm dmVar) {
            this.a.b(new Marker(dmVar));
        }

        @Override // com.google.android.gms.internal.ct
        public void c(dm dmVar) {
            this.a.c(new Marker(dmVar));
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap$9  reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass9 extends cu.a {
        final /* synthetic */ OnMyLocationChangeListener a;

        @Override // com.google.android.gms.internal.cu
        public void a(bc bcVar) {
            this.a.a((Location) bd.a(bcVar));
        }
    }

    /* loaded from: classes.dex */
    public interface CancelableCallback {
        void a();

        void b();
    }

    /* loaded from: classes.dex */
    public interface InfoWindowAdapter {
        View a(Marker marker);

        View b(Marker marker);
    }

    /* loaded from: classes.dex */
    public interface OnCameraChangeListener {
        void a(CameraPosition cameraPosition);
    }

    /* loaded from: classes.dex */
    public interface OnInfoWindowClickListener {
        void a(Marker marker);
    }

    /* loaded from: classes.dex */
    public interface OnMapClickListener {
        void a(LatLng latLng);
    }

    /* loaded from: classes.dex */
    public interface OnMapLongClickListener {
        void a(LatLng latLng);
    }

    /* loaded from: classes.dex */
    public interface OnMarkerClickListener {
        boolean a(Marker marker);
    }

    /* loaded from: classes.dex */
    public interface OnMarkerDragListener {
        void a(Marker marker);

        void b(Marker marker);

        void c(Marker marker);
    }

    /* loaded from: classes.dex */
    public interface OnMyLocationChangeListener {
        void a(Location location);
    }

    /* loaded from: classes.dex */
    final class a extends ck.a {
        private final CancelableCallback a;

        @Override // com.google.android.gms.internal.ck
        public void a() {
            this.a.a();
        }

        @Override // com.google.android.gms.internal.ck
        public void b() {
            this.a.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public GoogleMap(IGoogleMapDelegate iGoogleMapDelegate) {
        this.a = (IGoogleMapDelegate) x.a(iGoogleMapDelegate);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IGoogleMapDelegate a() {
        return this.a;
    }

    public final Marker a(MarkerOptions markerOptions) {
        try {
            dm a2 = this.a.a(markerOptions);
            if (a2 != null) {
                return new Marker(a2);
            }
            return null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void a(int i) {
        try {
            this.a.a(i);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void a(CameraUpdate cameraUpdate) {
        try {
            this.a.b(cameraUpdate.a());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void a(final InfoWindowAdapter infoWindowAdapter) {
        try {
            if (infoWindowAdapter == null) {
                this.a.a((cm) null);
            } else {
                this.a.a(new cm.a() { // from class: com.google.android.gms.maps.GoogleMap.8
                    @Override // com.google.android.gms.internal.cm
                    public bc a(dm dmVar) {
                        return bd.a(infoWindowAdapter.a(new Marker(dmVar)));
                    }

                    @Override // com.google.android.gms.internal.cm
                    public bc b(dm dmVar) {
                        return bd.a(infoWindowAdapter.b(new Marker(dmVar)));
                    }
                });
            }
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void a(final OnCameraChangeListener onCameraChangeListener) {
        try {
            if (onCameraChangeListener == null) {
                this.a.a((cn) null);
            } else {
                this.a.a(new cn.a() { // from class: com.google.android.gms.maps.GoogleMap.2
                    @Override // com.google.android.gms.internal.cn
                    public void a(CameraPosition cameraPosition) {
                        onCameraChangeListener.a(cameraPosition);
                    }
                });
            }
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void a(final OnInfoWindowClickListener onInfoWindowClickListener) {
        try {
            if (onInfoWindowClickListener == null) {
                this.a.a((co) null);
            } else {
                this.a.a(new co.a() { // from class: com.google.android.gms.maps.GoogleMap.7
                    @Override // com.google.android.gms.internal.co
                    public void a(dm dmVar) {
                        onInfoWindowClickListener.a(new Marker(dmVar));
                    }
                });
            }
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final CameraPosition b() {
        try {
            return this.a.a();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
