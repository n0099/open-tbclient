package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes10.dex */
public final class j implements Runnable {
    public final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ e f84a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f85a;

    public j(String str, Context context, e eVar) {
        this.f85a = str;
        this.a = context;
        this.f84a = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        if (TextUtils.isEmpty(this.f85a)) {
            return;
        }
        String[] split = this.f85a.split(Constants.WAVE_SEPARATOR);
        int length = split.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                str = "";
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
            com.xiaomi.channel.commonutils.logger.b.m181a("ASSEMBLE_PUSH : receive incorrect token");
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.m181a("ASSEMBLE_PUSH : receive correct token");
        i.d(this.a, this.f84a, str);
        i.m245a(this.a);
    }
}
