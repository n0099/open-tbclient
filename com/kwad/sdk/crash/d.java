package com.kwad.sdk.crash;

import android.content.Context;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.kwad.sdk.crash.b;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
/* loaded from: classes7.dex */
public final class d {
    public com.kwad.sdk.crash.a.b ahc;
    public b ahd;
    public long ahe;

    /* loaded from: classes7.dex */
    public static class a {
        public static final d ahf = new d((byte) 0);
    }

    public d() {
        this.ahc = new com.kwad.sdk.crash.a.b();
        this.ahd = new b.a().wy();
    }

    public /* synthetic */ d(byte b) {
        this();
    }

    public static d wz() {
        return a.ahf;
    }

    public final void a(@NonNull b bVar) {
        this.ahd = bVar;
        this.ahe = SystemClock.elapsedRealtime();
        this.ahc.a(bVar.agI, bVar.agJ);
    }

    public final void b(int i, ExceptionMessage exceptionMessage) {
        e ww = this.ahd.ww();
        if (ww != null) {
            ww.a(i, exceptionMessage);
        }
    }

    public final Context getContext() {
        return this.ahd.context;
    }

    public final String getSdkVersion() {
        return this.ahd.agF.mSdkVersion;
    }

    public final boolean isDebug() {
        return this.ahd.wx();
    }

    public final String[] wA() {
        return this.ahc.wM();
    }

    public final String[] wB() {
        return this.ahc.wB();
    }

    public final String wC() {
        return this.ahd.agF.ahv;
    }

    public final int wD() {
        return this.ahd.agF.ahz;
    }

    public final g wE() {
        return this.ahd.agH;
    }

    public final long wF() {
        return SystemClock.elapsedRealtime() - this.ahe;
    }
}
