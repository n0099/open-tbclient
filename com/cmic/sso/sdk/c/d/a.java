package com.cmic.sso.sdk.c.d;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private int f8015a;

    /* renamed from: b  reason: collision with root package name */
    private String f8016b;

    private a(int i, String str) {
        this.f8015a = i;
        this.f8016b = str;
    }

    public int a() {
        return this.f8015a;
    }

    public String b() {
        return this.f8016b;
    }

    public static a PY(int i) {
        switch (i) {
            case 102102:
                return new a(102102, "网络异常");
            case 102223:
                return new a(102223, "数据解析异常");
            case 102508:
                return new a(102508, "数据网络切换失败");
            case 200025:
                return new a(200025, "登录超时");
            case 200039:
                return new a(200039, "电信取号接口失败");
            case 200050:
                return new a(200050, "EOF异常");
            default:
                return new a(i, "网络异常");
        }
    }
}
