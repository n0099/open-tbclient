package com.xiaomi.push;

import com.xiaomi.push.cb;
/* loaded from: classes6.dex */
public class bx extends cb.d {

    /* renamed from: a  reason: collision with root package name */
    protected String f14196a;

    public bx(String str, String str2, String[] strArr, String str3) {
        super(str, str2, strArr);
        this.f14196a = "MessageDeleteJob";
        this.f14196a = str3;
    }

    public static bx a(String str) {
        return new bx(str, "status = ?", new String[]{String.valueOf(2)}, "a job build to delete uploaded job");
    }
}
