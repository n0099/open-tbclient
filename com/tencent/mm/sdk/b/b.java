package com.tencent.mm.sdk.b;

import android.util.Log;
import com.tencent.mm.sdk.b.a;
/* loaded from: classes15.dex */
final class b implements a.InterfaceC1237a {
    @Override // com.tencent.mm.sdk.b.a.InterfaceC1237a
    public final int b() {
        int i;
        i = a.level;
        return i;
    }

    @Override // com.tencent.mm.sdk.b.a.InterfaceC1237a
    public final void d(String str, String str2) {
        int i;
        i = a.level;
        if (i <= 2) {
            Log.i(str, str2);
        }
    }

    @Override // com.tencent.mm.sdk.b.a.InterfaceC1237a
    public final void e(String str, String str2) {
        int i;
        i = a.level;
        if (i <= 1) {
            Log.d(str, str2);
        }
    }

    @Override // com.tencent.mm.sdk.b.a.InterfaceC1237a
    public final void f(String str, String str2) {
        int i;
        i = a.level;
        if (i <= 4) {
            Log.e(str, str2);
        }
    }
}
