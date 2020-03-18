package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class k implements Runnable {
    final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ f f72a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f73a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(String str, Context context, f fVar) {
        this.f73a = str;
        this.a = context;
        this.f72a = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (TextUtils.isEmpty(this.f73a)) {
            return;
        }
        String str = "";
        String[] split = this.f73a.split(Constants.WAVE_SEPARATOR);
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
            com.xiaomi.channel.commonutils.logger.b.m45a("ASSEMBLE_PUSH : receive incorrect token");
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.m45a("ASSEMBLE_PUSH : receive correct token");
        j.d(this.a, this.f72a, str);
        j.m101a(this.a);
    }
}
