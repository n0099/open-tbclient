package com.xiaomi.push;

import android.util.Log;
import com.xiaomi.push.al;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class dn extends al.b {
    final /* synthetic */ dm a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dn(dm dmVar) {
        this.a = dmVar;
    }

    @Override // com.xiaomi.push.al.b
    public void b() {
        List list;
        String str;
        String str2;
        list = dm.f229a;
        if (list.isEmpty()) {
            return;
        }
        try {
            if (aa.d()) {
                this.a.m224a();
            } else {
                str2 = this.a.b;
                Log.w(str2, "SDCard is unavailable.");
            }
        } catch (Exception e) {
            str = this.a.b;
            Log.e(str, "", e);
        }
    }
}
