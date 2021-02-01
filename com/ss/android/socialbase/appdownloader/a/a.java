package com.ss.android.socialbase.appdownloader.a;

import android.content.Context;
import android.util.Log;
/* loaded from: classes6.dex */
public abstract class a implements e {

    /* renamed from: a  reason: collision with root package name */
    protected final Context f13009a;

    /* renamed from: b  reason: collision with root package name */
    protected final String f13010b;

    public a(Context context, String str) {
        this.f13009a = context;
        this.f13010b = str;
    }

    public boolean a() {
        if (this.f13009a == null) {
            return false;
        }
        try {
            return b().resolveActivity(this.f13009a.getPackageManager()) != null;
        } catch (Throwable th) {
            if (com.ss.android.socialbase.downloader.f.a.a()) {
                Log.e("AbsDevicePlan", "check is valid failed!", th);
                return false;
            }
            return false;
        }
    }
}
