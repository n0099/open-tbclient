package com.xiaomi.push;

import android.content.Context;
import java.util.List;
/* loaded from: classes8.dex */
public abstract class dc {
    private int a;

    public dc(int i) {
        this.a = i;
    }

    public int a() {
        return this.a;
    }

    public abstract String a(Context context, String str, List<ay> list);

    /* renamed from: a  reason: collision with other method in class */
    public boolean m223a(Context context, String str, List<ay> list) {
        return true;
    }
}
