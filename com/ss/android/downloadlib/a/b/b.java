package com.ss.android.downloadlib.a.b;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static int f13230a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static int f13231b = 1;
    public static int c = 2;
    private int d = f13230a;
    private long e = 0;
    private JSONObject f = null;
    private int g = 0;
    private String h = "";
    private String i = "";

    public boolean a() {
        return this.d == f13231b;
    }

    public int b() {
        return this.g;
    }

    public b RO(int i) {
        this.d = i;
        return this;
    }

    public b RP(int i) {
        this.g = i;
        return this;
    }
}
