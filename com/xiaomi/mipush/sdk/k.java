package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class k implements Runnable {
    final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ f f73a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f74a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(String str, Context context, f fVar) {
        this.f74a = str;
        this.a = context;
        this.f73a = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (TextUtils.isEmpty(this.f74a)) {
            return;
        }
        String str = "";
        String[] split = this.f74a.split(Constants.WAVE_SEPARATOR);
        int length = split.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            String str2 = split[i];
            if (!TextUtils.isEmpty(str2) && str2.startsWith("token:")) {
                str = str2.substring(str2.indexOf(":") + 1);
                break;
            }
            i++;
        }
        if (TextUtils.isEmpty(str)) {
            com.xiaomi.channel.commonutils.logger.b.m47a("ASSEMBLE_PUSH : receive incorrect token");
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.m47a("ASSEMBLE_PUSH : receive correct token");
        j.d(this.a, this.f73a, str);
        j.m103a(this.a);
    }
}
