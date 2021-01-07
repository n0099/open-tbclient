package com.ss.android.socialbase.appdownloader.a;

import android.content.Context;
import android.util.Log;
/* loaded from: classes4.dex */
public abstract class a implements e {

    /* renamed from: a  reason: collision with root package name */
    protected final Context f13307a;

    /* renamed from: b  reason: collision with root package name */
    protected final String f13308b;

    public a(Context context, String str) {
        this.f13307a = context;
        this.f13308b = str;
    }

    public boolean a() {
        if (this.f13307a == null) {
            return false;
        }
        try {
            return b().resolveActivity(this.f13307a.getPackageManager()) != null;
        } catch (Throwable th) {
            if (com.ss.android.socialbase.downloader.f.a.a()) {
                Log.e("AbsDevicePlan", "check is valid failed!", th);
                return false;
            }
            return false;
        }
    }
}
