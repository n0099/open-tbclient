package com.xiaomi.push;

import android.content.Context;
import java.util.List;
/* loaded from: classes8.dex */
public abstract class cx {
    private int a;

    public cx(int i) {
        this.a = i;
    }

    public int a() {
        return this.a;
    }

    public abstract String a(Context context, String str, List<ar> list);

    /* renamed from: a  reason: collision with other method in class */
    public boolean m219a(Context context, String str, List<ar> list) {
        return true;
    }
}
