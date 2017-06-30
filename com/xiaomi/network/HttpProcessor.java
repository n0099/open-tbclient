package com.xiaomi.network;

import android.content.Context;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class HttpProcessor {
    private int a;

    public HttpProcessor(int i) {
        this.a = i;
    }

    public int a() {
        return this.a;
    }

    public boolean a(Context context, String str, List<com.xiaomi.channel.commonutils.network.c> list) {
        return true;
    }

    public abstract String b(Context context, String str, List<com.xiaomi.channel.commonutils.network.c> list);
}
