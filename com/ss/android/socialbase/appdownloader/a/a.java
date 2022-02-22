package com.ss.android.socialbase.appdownloader.a;

import android.content.Context;
/* loaded from: classes4.dex */
public abstract class a implements e {
    public final Context a;

    /* renamed from: b  reason: collision with root package name */
    public final com.ss.android.socialbase.downloader.g.a f59916b;

    /* renamed from: c  reason: collision with root package name */
    public final String f59917c;

    public a(Context context, com.ss.android.socialbase.downloader.g.a aVar, String str) {
        this.a = context;
        this.f59916b = aVar;
        this.f59917c = str;
    }

    public boolean a() {
        if (this.a == null) {
            return false;
        }
        try {
        } catch (Throwable unused) {
            com.ss.android.socialbase.downloader.c.a.a();
        }
        return b().resolveActivity(this.a.getPackageManager()) != null;
    }
}
