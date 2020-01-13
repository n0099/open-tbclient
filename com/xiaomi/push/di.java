package com.xiaomi.push;

import android.util.Log;
import com.xiaomi.push.al;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class di extends al.b {
    final /* synthetic */ dh a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public di(dh dhVar) {
        this.a = dhVar;
    }

    @Override // com.xiaomi.push.al.b
    public void b() {
        List list;
        String str;
        String str2;
        list = dh.f240a;
        if (list.isEmpty()) {
            return;
        }
        try {
            if (aa.d()) {
                this.a.m216a();
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
