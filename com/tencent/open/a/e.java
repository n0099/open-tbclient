package com.tencent.open.a;

import android.util.Log;
/* loaded from: classes14.dex */
public final class e extends i {

    /* renamed from: a  reason: collision with root package name */
    public static final e f7954a = new e();

    @Override // com.tencent.open.a.i
    protected void a(int i, Thread thread, long j, String str, String str2, Throwable th) {
        switch (i) {
            case 1:
                Log.v(str, str2, th);
                return;
            case 2:
                Log.d(str, str2, th);
                return;
            case 4:
                Log.i(str, str2, th);
                return;
            case 8:
                Log.w(str, str2, th);
                return;
            case 16:
                Log.e(str, str2, th);
                return;
            case 32:
                Log.e(str, str2, th);
                return;
            default:
                return;
        }
    }
}
