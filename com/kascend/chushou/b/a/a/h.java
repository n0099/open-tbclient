package com.kascend.chushou.b.a.a;

import java.util.HashMap;
/* loaded from: classes4.dex */
public class h {
    public final int a;
    private final HashMap<String, Object> b = new HashMap<>();

    public h(int i) {
        this.a = i;
    }

    public void a(String str, Object obj) {
        if (!tv.chushou.zues.utils.h.isEmpty(str)) {
            this.b.put(str, obj);
        }
    }
}
