package com.qq.e.comm.plugin.ab.b;

import com.qq.e.comm.util.StringUtil;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private String f11718a;

    /* renamed from: b  reason: collision with root package name */
    private String[] f11719b;

    public c(String str, String... strArr) {
        this.f11718a = str;
        this.f11719b = strArr;
    }

    public String a() {
        StringBuilder sb = new StringBuilder();
        if (this.f11718a != null) {
            sb.append(this.f11718a).append("(");
            if (this.f11719b != null && this.f11719b.length > 0) {
                sb.append("'").append(StringUtil.join("','", this.f11719b)).append("'");
            }
            sb.append(")");
        }
        return sb.toString();
    }
}
