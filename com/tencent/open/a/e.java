package com.tencent.open.a;

import android.util.Log;
/* loaded from: classes7.dex */
public final class e extends i {

    /* renamed from: a  reason: collision with root package name */
    public static final e f40049a = new e();

    @Override // com.tencent.open.a.i
    public void a(int i2, Thread thread, long j, String str, String str2, Throwable th) {
        if (i2 == 1) {
            Log.v(str, str2, th);
        } else if (i2 == 2) {
            Log.d(str, str2, th);
        } else if (i2 == 4) {
            Log.i(str, str2, th);
        } else if (i2 == 8) {
            Log.w(str, str2, th);
        } else if (i2 == 16) {
            Log.e(str, str2, th);
        } else if (i2 != 32) {
        } else {
            Log.e(str, str2, th);
        }
    }
}
