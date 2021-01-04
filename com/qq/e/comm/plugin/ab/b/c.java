package com.qq.e.comm.plugin.ab.b;

import com.qq.e.comm.util.StringUtil;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private String f12017a;

    /* renamed from: b  reason: collision with root package name */
    private String[] f12018b;

    public c(String str, String... strArr) {
        this.f12017a = str;
        this.f12018b = strArr;
    }

    public String a() {
        StringBuilder sb = new StringBuilder();
        if (this.f12017a != null) {
            sb.append(this.f12017a).append("(");
            if (this.f12018b != null && this.f12018b.length > 0) {
                sb.append("'").append(StringUtil.join("','", this.f12018b)).append("'");
            }
            sb.append(")");
        }
        return sb.toString();
    }
}
