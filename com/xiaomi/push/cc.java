package com.xiaomi.push;

import com.xiaomi.push.cg;
/* loaded from: classes7.dex */
public class cc extends cg.d {

    /* renamed from: a  reason: collision with root package name */
    public String f37451a;

    public cc(String str, String str2, String[] strArr, String str3) {
        super(str, str2, strArr);
        this.f37451a = "MessageDeleteJob";
        this.f37451a = str3;
    }

    public static cc a(String str) {
        return new cc(str, "status = ?", new String[]{String.valueOf(2)}, "a job build to delete uploaded job");
    }
}
