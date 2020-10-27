package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes12.dex */
public final class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f4767a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ d f74a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f75a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(String str, Context context, d dVar) {
        this.f75a = str;
        this.f4767a = context;
        this.f74a = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (TextUtils.isEmpty(this.f75a)) {
            return;
        }
        String str = "";
        String[] split = this.f75a.split(Constants.WAVE_SEPARATOR);
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
            com.xiaomi.channel.commonutils.logger.b.m54a("ASSEMBLE_PUSH : receive incorrect token");
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.m54a("ASSEMBLE_PUSH : receive correct token");
        h.d(this.f4767a, this.f74a, str);
        h.m112a(this.f4767a);
    }
}
