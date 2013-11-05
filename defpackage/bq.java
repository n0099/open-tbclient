package defpackage;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import com.baidu.cloudsdk.common.util.CoordinateManager;
/* renamed from: bq  reason: default package */
/* loaded from: classes.dex */
public class bq implements LocationListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ CoordinateManager.a f385a;

    public bq(CoordinateManager.a aVar) {
        this.f385a = aVar;
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
        CoordinateManager.this.c = this.f385a.c = location;
    }

    @Override // android.location.LocationListener
    public void onProviderDisabled(String str) {
    }

    @Override // android.location.LocationListener
    public void onProviderEnabled(String str) {
    }

    @Override // android.location.LocationListener
    public void onStatusChanged(String str, int i, Bundle bundle) {
    }
}
