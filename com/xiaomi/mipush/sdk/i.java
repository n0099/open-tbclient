package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes18.dex */
public final class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f4539a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ d f77a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f78a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(String str, Context context, d dVar) {
        this.f78a = str;
        this.f4539a = context;
        this.f77a = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (TextUtils.isEmpty(this.f78a)) {
            return;
        }
        String str = "";
        String[] split = this.f78a.split(Constants.WAVE_SEPARATOR);
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
        h.d(this.f4539a, this.f77a, str);
        h.m105a(this.f4539a);
    }
}
