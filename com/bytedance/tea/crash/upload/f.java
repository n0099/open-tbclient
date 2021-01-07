package com.bytedance.tea.crash.upload;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private final int f7981a;

    /* renamed from: b  reason: collision with root package name */
    private String f7982b;
    private JSONObject c;

    public f(int i) {
        this.f7981a = i;
    }

    public f(int i, Throwable th) {
        this.f7981a = i;
        if (th != null) {
            this.f7982b = th.getMessage();
        }
    }

    public f(int i, String str) {
        this.f7981a = i;
        this.f7982b = str;
    }

    public f(int i, JSONObject jSONObject) {
        this.f7981a = i;
        this.c = jSONObject;
    }

    public boolean a() {
        return this.f7981a == 0;
    }
}
