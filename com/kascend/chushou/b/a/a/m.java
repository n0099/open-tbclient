package com.kascend.chushou.b.a.a;
/* loaded from: classes5.dex */
public class m {
    public String a;
    public String b;
    public boolean c;

    public m(String str, String str2, boolean z) {
        this.a = str;
        this.b = str2;
        this.c = z;
    }

    public boolean a(String str, String str2) {
        if (tv.chushou.zues.utils.h.isEmpty(str) || !str.equals(this.a)) {
            return !tv.chushou.zues.utils.h.isEmpty(str2) && str2.equals(this.b);
        }
        return true;
    }
}
