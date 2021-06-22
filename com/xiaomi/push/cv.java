package com.xiaomi.push;

import android.content.Context;
import java.util.List;
/* loaded from: classes7.dex */
public abstract class cv {

    /* renamed from: a  reason: collision with root package name */
    public int f41199a;

    public cv(int i2) {
        this.f41199a = i2;
    }

    public int a() {
        return this.f41199a;
    }

    public abstract String a(Context context, String str, List<bf> list);

    /* renamed from: a  reason: collision with other method in class */
    public boolean m224a(Context context, String str, List<bf> list) {
        return true;
    }
}
