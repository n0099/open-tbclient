package com.xiaomi.push;

import android.content.Context;
import java.util.List;
/* loaded from: classes10.dex */
public abstract class cx {
    public int a;

    public cx(int i) {
        this.a = i;
    }

    public int a() {
        return this.a;
    }

    public abstract String a(Context context, String str, List<bh> list);

    /* renamed from: a  reason: collision with other method in class */
    public boolean m349a(Context context, String str, List<bh> list) {
        return true;
    }
}
