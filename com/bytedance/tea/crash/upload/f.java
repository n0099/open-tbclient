package com.bytedance.tea.crash.upload;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private final int f5198a;
    private String b;
    private JSONObject c;

    public f(int i) {
        this.f5198a = i;
    }

    public f(int i, Throwable th) {
        this.f5198a = i;
        if (th != null) {
            this.b = th.getMessage();
        }
    }

    public f(int i, String str) {
        this.f5198a = i;
        this.b = str;
    }

    public f(int i, JSONObject jSONObject) {
        this.f5198a = i;
        this.c = jSONObject;
    }

    public boolean a() {
        return this.f5198a == 0;
    }
}
