package com.xiaomi.push;

import android.content.Context;
import java.util.List;
/* loaded from: classes12.dex */
public abstract class dc {

    /* renamed from: a  reason: collision with root package name */
    private int f4849a;

    public dc(int i) {
        this.f4849a = i;
    }

    public int a() {
        return this.f4849a;
    }

    public abstract String a(Context context, String str, List<ay> list);

    /* renamed from: a  reason: collision with other method in class */
    public boolean m225a(Context context, String str, List<ay> list) {
        return true;
    }
}
