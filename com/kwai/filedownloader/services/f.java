package com.kwai.filedownloader.services;

import android.content.Intent;
/* loaded from: classes5.dex */
public class f {
    public static void a(com.kwai.filedownloader.d.c cVar) {
        if (cVar == null) {
            throw new IllegalArgumentException();
        }
        if (cVar.f() != -3) {
            throw new IllegalStateException();
        }
        Intent intent = new Intent("filedownloader.intent.action.completed");
        intent.putExtra("model", cVar);
        com.kwai.filedownloader.f.c.a().sendBroadcast(intent);
    }
}
