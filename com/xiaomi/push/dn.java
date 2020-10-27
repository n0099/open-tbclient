package com.xiaomi.push;

import android.util.Log;
import com.xiaomi.push.al;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes12.dex */
public class dn extends al.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ dm f4861a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dn(dm dmVar) {
        this.f4861a = dmVar;
    }

    @Override // com.xiaomi.push.al.b
    public void b() {
        List list;
        String str;
        String str2;
        list = dm.f221a;
        if (list.isEmpty()) {
            return;
        }
        try {
            if (aa.d()) {
                this.f4861a.m230a();
            } else {
                str2 = this.f4861a.b;
                Log.w(str2, "SDCard is unavailable.");
            }
        } catch (Exception e) {
            str = this.f4861a.b;
            Log.e(str, "", e);
        }
    }
}
