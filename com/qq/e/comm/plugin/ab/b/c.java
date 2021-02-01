package com.qq.e.comm.plugin.ab.b;

import com.qq.e.comm.util.StringUtil;
/* loaded from: classes15.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private String f11720a;

    /* renamed from: b  reason: collision with root package name */
    private String[] f11721b;

    public c(String str, String... strArr) {
        this.f11720a = str;
        this.f11721b = strArr;
    }

    public String a() {
        StringBuilder sb = new StringBuilder();
        if (this.f11720a != null) {
            sb.append(this.f11720a).append("(");
            if (this.f11721b != null && this.f11721b.length > 0) {
                sb.append("'").append(StringUtil.join("','", this.f11721b)).append("'");
            }
            sb.append(")");
        }
        return sb.toString();
    }
}
