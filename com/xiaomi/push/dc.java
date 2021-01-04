package com.xiaomi.push;

import android.content.Context;
import java.util.List;
/* loaded from: classes6.dex */
public abstract class dc {

    /* renamed from: a  reason: collision with root package name */
    private int f14231a;

    public dc(int i) {
        this.f14231a = i;
    }

    public int a() {
        return this.f14231a;
    }

    public abstract String a(Context context, String str, List<ay> list);

    /* renamed from: a  reason: collision with other method in class */
    public boolean m244a(Context context, String str, List<ay> list) {
        return true;
    }
}
