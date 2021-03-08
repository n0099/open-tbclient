package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f8232a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ d f76a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f77a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(String str, Context context, d dVar) {
        this.f77a = str;
        this.f8232a = context;
        this.f76a = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (TextUtils.isEmpty(this.f77a)) {
            return;
        }
        String str = "";
        String[] split = this.f77a.split(Constants.WAVE_SEPARATOR);
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
            com.xiaomi.channel.commonutils.logger.b.m58a("ASSEMBLE_PUSH : receive incorrect token");
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.m58a("ASSEMBLE_PUSH : receive correct token");
        h.d(this.f8232a, this.f76a, str);
        h.m116a(this.f8232a);
    }
}
