package com.bytedance.tea.crash.upload;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private final int f7980a;

    /* renamed from: b  reason: collision with root package name */
    private String f7981b;
    private JSONObject c;

    public f(int i) {
        this.f7980a = i;
    }

    public f(int i, Throwable th) {
        this.f7980a = i;
        if (th != null) {
            this.f7981b = th.getMessage();
        }
    }

    public f(int i, String str) {
        this.f7980a = i;
        this.f7981b = str;
    }

    public f(int i, JSONObject jSONObject) {
        this.f7980a = i;
        this.c = jSONObject;
    }

    public boolean a() {
        return this.f7980a == 0;
    }
}
