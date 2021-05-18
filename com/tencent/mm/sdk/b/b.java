package com.tencent.mm.sdk.b;

import android.util.Log;
import com.tencent.mm.sdk.b.a;
/* loaded from: classes7.dex */
public final class b implements a.InterfaceC0462a {
    @Override // com.tencent.mm.sdk.b.a.InterfaceC0462a
    public final int b() {
        int i2;
        i2 = a.level;
        return i2;
    }

    @Override // com.tencent.mm.sdk.b.a.InterfaceC0462a
    public final void d(String str, String str2) {
        int i2;
        i2 = a.level;
        if (i2 <= 2) {
            Log.i(str, str2);
        }
    }

    @Override // com.tencent.mm.sdk.b.a.InterfaceC0462a
    public final void e(String str, String str2) {
        int i2;
        i2 = a.level;
        if (i2 <= 1) {
            Log.d(str, str2);
        }
    }

    @Override // com.tencent.mm.sdk.b.a.InterfaceC0462a
    public final void f(String str, String str2) {
        int i2;
        i2 = a.level;
        if (i2 <= 4) {
            Log.e(str, str2);
        }
    }
}
