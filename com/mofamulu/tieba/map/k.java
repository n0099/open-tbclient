package com.mofamulu.tieba.map;

import android.location.Location;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements Runnable {
    final /* synthetic */ FreeLocationService a;
    private final /* synthetic */ Location b;
    private final /* synthetic */ boolean c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(FreeLocationService freeLocationService, Location location, boolean z) {
        this.a = freeLocationService;
        this.b = location;
        this.c = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            Location location = new Location("gps");
            location.setLatitude(35.36273d);
            location.setLongitude(138.731368d);
            if (this.a.a(location, this.b)) {
                this.a.a(location);
                this.a.k = location.getProvider();
            } else {
                this.a.a(this.b);
            }
            if (this.c) {
                this.a.a((String) null);
            }
        } catch (Throwable th) {
            this.a.b(this.c);
        }
    }
}
