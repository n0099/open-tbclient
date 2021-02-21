package com.xiaomi.push;

import android.util.Log;
import com.xiaomi.push.al;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class dn extends al.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ dm f13952a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dn(dm dmVar) {
        this.f13952a = dmVar;
    }

    @Override // com.xiaomi.push.al.b
    public void b() {
        List list;
        String str;
        String str2;
        list = dm.f302a;
        if (list.isEmpty()) {
            return;
        }
        try {
            if (aa.d()) {
                this.f13952a.m255a();
            } else {
                str2 = this.f13952a.f13951b;
                Log.w(str2, "SDCard is unavailable.");
            }
        } catch (Exception e) {
            str = this.f13952a.f13951b;
            Log.e(str, "", e);
        }
    }
}
