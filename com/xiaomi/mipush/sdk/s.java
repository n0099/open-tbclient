package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.Cif;
import com.xiaomi.push.dk;
import com.xiaomi.push.hg;
import com.xiaomi.push.ht;
/* loaded from: classes8.dex */
public class s implements dk {
    private Context a;

    public s(Context context) {
        this.a = context;
    }

    @Override // com.xiaomi.push.dk
    public String a() {
        return d.m85a(this.a).d();
    }

    @Override // com.xiaomi.push.dk
    public void a(Cif cif, hg hgVar, ht htVar) {
        ay.a(this.a).a((ay) cif, hgVar, htVar);
    }
}
