package com.qq.e.comm.plugin.ab.b;

import com.qq.e.comm.util.StringUtil;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private String f12018a;

    /* renamed from: b  reason: collision with root package name */
    private String[] f12019b;

    public c(String str, String... strArr) {
        this.f12018a = str;
        this.f12019b = strArr;
    }

    public String a() {
        StringBuilder sb = new StringBuilder();
        if (this.f12018a != null) {
            sb.append(this.f12018a).append("(");
            if (this.f12019b != null && this.f12019b.length > 0) {
                sb.append("'").append(StringUtil.join("','", this.f12019b)).append("'");
            }
            sb.append(")");
        }
        return sb.toString();
    }
}
