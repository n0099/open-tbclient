package com.kwad.framework.filedownloader.services;

import android.content.Intent;
/* loaded from: classes10.dex */
public final class f {
    public static void f(com.kwad.framework.filedownloader.d.c cVar) {
        if (cVar != null) {
            if (cVar.tL() == -3) {
                Intent intent = new Intent("filedownloader.intent.action.completed");
                intent.putExtra("model", cVar);
                com.kwad.framework.filedownloader.f.c.wB().sendBroadcast(intent);
                return;
            }
            throw new IllegalStateException();
        }
        throw new IllegalArgumentException();
    }
}
