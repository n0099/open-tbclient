package com.xiaomi.push;

import android.util.Log;
import com.xiaomi.push.al;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class dn extends al.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ dm f8326a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dn(dm dmVar) {
        this.f8326a = dmVar;
    }

    @Override // com.xiaomi.push.al.b
    public void b() {
        List list;
        String str;
        String str2;
        list = dm.f223a;
        if (list.isEmpty()) {
            return;
        }
        try {
            if (aa.d()) {
                this.f8326a.m234a();
            } else {
                str2 = this.f8326a.b;
                Log.w(str2, "SDCard is unavailable.");
            }
        } catch (Exception e) {
            str = this.f8326a.b;
            Log.e(str, "", e);
        }
    }
}
