package com.kwad.sdk.crash;

import android.content.Context;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.kwad.sdk.crash.c;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
/* loaded from: classes10.dex */
public final class e {
    public com.kwad.sdk.crash.b.b aEG;
    public c aEH;
    public long aEI;

    /* loaded from: classes10.dex */
    public static class a {
        public static final e aEJ = new e((byte) 0);
    }

    public e() {
        this.aEG = new com.kwad.sdk.crash.b.b();
        this.aEH = new c.a().Gk();
    }

    public static e Gl() {
        return a.aEJ;
    }

    public final String[] Gm() {
        return this.aEG.Gz();
    }

    public final String[] Gn() {
        return this.aEG.Gn();
    }

    public final String Go() {
        return this.aEH.aEf.aFh;
    }

    public final int Gp() {
        return this.aEH.aEf.aFl;
    }

    public final c Gq() {
        return this.aEH;
    }

    public final h Gr() {
        return this.aEH.aEh;
    }

    public final long Gs() {
        return SystemClock.elapsedRealtime() - this.aEI;
    }

    public final String getAppId() {
        return this.aEH.aEg.aEY;
    }

    public final Context getContext() {
        return this.aEH.context;
    }

    public final String getSdkVersion() {
        return this.aEH.aEf.mSdkVersion;
    }

    public final boolean isDebug() {
        return this.aEH.Gi();
    }

    public /* synthetic */ e(byte b) {
        this();
    }

    public final void a(@NonNull c cVar) {
        this.aEH = cVar;
        this.aEI = SystemClock.elapsedRealtime();
        this.aEG.a(cVar.aEi, cVar.aEj);
    }

    public final void b(int i, ExceptionMessage exceptionMessage) {
        f Gh = this.aEH.Gh();
        if (Gh != null) {
            Gh.a(i, exceptionMessage);
        }
    }
}
