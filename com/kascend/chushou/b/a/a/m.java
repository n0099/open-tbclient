package com.kascend.chushou.b.a.a;
/* loaded from: classes6.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    public String f4076a;
    public String b;
    public boolean c;

    public m(String str, String str2, boolean z) {
        this.f4076a = str;
        this.b = str2;
        this.c = z;
    }

    public boolean a(String str, String str2) {
        if (tv.chushou.zues.utils.h.isEmpty(str) || !str.equals(this.f4076a)) {
            return !tv.chushou.zues.utils.h.isEmpty(str2) && str2.equals(this.b);
        }
        return true;
    }
}
