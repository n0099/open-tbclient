package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class i implements Runnable {
    final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ d f82a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f83a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(String str, Context context, d dVar) {
        this.f83a = str;
        this.a = context;
        this.f82a = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (TextUtils.isEmpty(this.f83a)) {
            return;
        }
        String str = "";
        String[] split = this.f83a.split(Constants.WAVE_SEPARATOR);
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
            com.xiaomi.channel.commonutils.logger.b.m48a("ASSEMBLE_PUSH : receive incorrect token");
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.m48a("ASSEMBLE_PUSH : receive correct token");
        h.d(this.a, this.f82a, str);
        h.m106a(this.a);
    }
}
