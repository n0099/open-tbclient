package com.kascend.chushou.b.a.a;

import java.util.HashMap;
/* loaded from: classes6.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public final int f4070a;
    private final HashMap<String, Object> b = new HashMap<>();

    public h(int i) {
        this.f4070a = i;
    }

    public void a(String str, Object obj) {
        if (!tv.chushou.zues.utils.h.isEmpty(str)) {
            this.b.put(str, obj);
        }
    }
}
