package com.bytedance.tea.crash.upload;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private final int f7683a;

    /* renamed from: b  reason: collision with root package name */
    private String f7684b;
    private JSONObject c;

    public f(int i) {
        this.f7683a = i;
    }

    public f(int i, Throwable th) {
        this.f7683a = i;
        if (th != null) {
            this.f7684b = th.getMessage();
        }
    }

    public f(int i, String str) {
        this.f7683a = i;
        this.f7684b = str;
    }

    public f(int i, JSONObject jSONObject) {
        this.f7683a = i;
        this.c = jSONObject;
    }

    public boolean a() {
        return this.f7683a == 0;
    }
}
