package com.xiaomi.push.log;

import android.util.Log;
import com.xiaomi.channel.commonutils.misc.h;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class g extends h.b {
    final /* synthetic */ f a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.a = fVar;
    }

    @Override // com.xiaomi.channel.commonutils.misc.h.b
    public void b() {
        List list;
        String str;
        String str2;
        list = f.f;
        if (list.isEmpty()) {
            return;
        }
        try {
            if (com.xiaomi.channel.commonutils.file.c.d()) {
                this.a.b();
            } else {
                str2 = this.a.d;
                Log.w(str2, "SDCard is unavailable.");
            }
        } catch (Exception e) {
            str = this.a.d;
            Log.e(str, "", e);
        }
    }
}
