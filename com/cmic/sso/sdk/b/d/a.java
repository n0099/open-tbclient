package com.cmic.sso.sdk.b.d;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f30617a;

    /* renamed from: b  reason: collision with root package name */
    public String f30618b;

    public a(int i2, String str) {
        this.f30617a = i2;
        this.f30618b = str;
    }

    public int a() {
        return this.f30617a;
    }

    public String b() {
        return this.f30618b;
    }

    public static a a(int i2) {
        switch (i2) {
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
                return new a(i2, "网络异常");
        }
    }
}
