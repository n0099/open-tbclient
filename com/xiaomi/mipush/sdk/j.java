package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes7.dex */
public final class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f40949a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ e f90a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f91a;

    public j(String str, Context context, e eVar) {
        this.f91a = str;
        this.f40949a = context;
        this.f90a = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        if (TextUtils.isEmpty(this.f91a)) {
            return;
        }
        String[] split = this.f91a.split(Constants.WAVE_SEPARATOR);
        int length = split.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                str = "";
                break;
            }
            String str2 = split[i2];
            if (!TextUtils.isEmpty(str2) && str2.startsWith("token:")) {
                str = str2.substring(str2.indexOf(":") + 1);
                break;
            }
            i2++;
        }
        if (TextUtils.isEmpty(str)) {
            com.xiaomi.channel.commonutils.logger.b.m56a("ASSEMBLE_PUSH : receive incorrect token");
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.m56a("ASSEMBLE_PUSH : receive correct token");
        i.d(this.f40949a, this.f90a, str);
        i.m116a(this.f40949a);
    }
}
