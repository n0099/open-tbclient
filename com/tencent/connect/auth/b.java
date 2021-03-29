package com.tencent.connect.auth;

import com.tencent.tauth.IUiListener;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static b f39082a;

    /* renamed from: d  reason: collision with root package name */
    public static final /* synthetic */ boolean f39083d = !b.class.desiredAssertionStatus();

    /* renamed from: e  reason: collision with root package name */
    public static int f39084e = 0;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, a> f39085b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public final String f39086c = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public IUiListener f39087a;

        /* renamed from: b  reason: collision with root package name */
        public com.tencent.connect.auth.a f39088b;

        /* renamed from: c  reason: collision with root package name */
        public String f39089c;
    }

    public static b a() {
        if (f39082a == null) {
            f39082a = new b();
        }
        return f39082a;
    }

    public static int b() {
        int i = f39084e + 1;
        f39084e = i;
        return i;
    }

    public String c() {
        int ceil = (int) Math.ceil((Math.random() * 20.0d) + 3.0d);
        char[] charArray = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        int length = charArray.length;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < ceil; i++) {
            stringBuffer.append(charArray[(int) (Math.random() * length)]);
        }
        return stringBuffer.toString();
    }

    public String a(a aVar) {
        int b2 = b();
        try {
            HashMap<String, a> hashMap = this.f39085b;
            hashMap.put("" + b2, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return "" + b2;
    }
}
