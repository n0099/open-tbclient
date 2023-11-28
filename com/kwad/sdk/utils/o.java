package com.kwad.sdk.utils;

import com.kwad.sdk.service.ServiceProvider;
/* loaded from: classes10.dex */
public final class o {
    public static boolean aNh;
    public static boolean aNi;

    public static boolean JH() {
        return (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).T(2L)) & aNh;
    }

    public static boolean JI() {
        return (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).T(4L)) & aNh;
    }

    public static boolean JJ() {
        if (((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).yl() && aNh) {
            return true;
        }
        return false;
    }

    public static boolean JK() {
        return (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).T(16L)) & aNh;
    }

    public static boolean JL() {
        return (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).T(4096L)) & aNh;
    }

    public static boolean JM() {
        return (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).T(1L)) & aNh;
    }

    public static boolean JN() {
        return (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).T(128L)) & aNh;
    }

    public static boolean JO() {
        return (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).T(128L)) & aNh;
    }

    public static synchronized void bO(boolean z) {
        synchronized (o.class) {
            if (aNi) {
                return;
            }
            aNi = true;
            aNh = true;
            ((com.kwad.sdk.service.a.b) ServiceProvider.get(com.kwad.sdk.service.a.b.class)).yd();
        }
    }
}
