package com.qq.e.comm.plugin.r.b;

import com.baidu.tbadk.core.atomData.ForumSquareActivityConfig;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private String f12381a;

    /* renamed from: b  reason: collision with root package name */
    private String f12382b;
    private int c;
    private int d;
    private String e;
    private String f;
    private String g;
    private int h;
    private int k;
    private boolean l;
    private boolean m;
    private boolean n;
    private int i = -1;
    private int j = -1;
    private boolean o = false;
    private int p = 0;
    private boolean q = false;
    private boolean r = false;

    public c(JSONObject jSONObject) {
        this.k = -1;
        this.m = false;
        this.n = false;
        this.f12381a = jSONObject.optString("name");
        this.f12382b = jSONObject.optString("identity");
        this.c = jSONObject.optInt("bid");
        this.d = jSONObject.optInt("priority");
        this.k = jSONObject.optInt("c_priority");
        this.e = jSONObject.optString(ForumSquareActivityConfig.FORUM_CLASS_NAME);
        this.f = jSONObject.optString("view_id");
        this.g = jSONObject.optString("ext");
        this.h = jSONObject.optInt("timeout");
        this.m = jSONObject.optBoolean("enable_rt_priority");
        this.n = jSONObject.optBoolean("enable_rt_bid");
    }

    public String a() {
        return this.f12381a;
    }

    public void a(int i) {
        this.i = i;
    }

    public void a(boolean z) {
        this.l = z;
    }

    public String b() {
        return this.f12382b;
    }

    public void b(int i) {
        this.j = i;
    }

    public void b(boolean z) {
        this.o = z;
    }

    public int c() {
        return this.c;
    }

    public void c(int i) {
        this.p = i;
    }

    public void c(boolean z) {
        this.q = z;
    }

    public int d() {
        return this.d;
    }

    public void d(boolean z) {
        this.r = z;
    }

    public String e() {
        return this.e;
    }

    public String f() {
        return this.f;
    }

    public String g() {
        return this.g;
    }

    public int h() {
        return this.h;
    }

    public int i() {
        return this.i;
    }

    public boolean j() {
        return this.m;
    }

    public boolean k() {
        return this.n;
    }

    public int l() {
        return this.j;
    }

    public boolean m() {
        return this.l;
    }

    public int n() {
        return this.k;
    }

    public boolean o() {
        return this.o;
    }

    public int p() {
        return this.p;
    }

    public boolean q() {
        return this.q;
    }

    public boolean r() {
        return this.r;
    }
}
