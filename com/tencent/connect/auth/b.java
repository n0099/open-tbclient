package com.tencent.connect.auth;

import com.tencent.tauth.IUiListener;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static b f39081a;

    /* renamed from: d  reason: collision with root package name */
    public static final /* synthetic */ boolean f39082d = !b.class.desiredAssertionStatus();

    /* renamed from: e  reason: collision with root package name */
    public static int f39083e = 0;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, a> f39084b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public final String f39085c = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public IUiListener f39086a;

        /* renamed from: b  reason: collision with root package name */
        public com.tencent.connect.auth.a f39087b;

        /* renamed from: c  reason: collision with root package name */
        public String f39088c;
    }

    public static b a() {
        if (f39081a == null) {
            f39081a = new b();
        }
        return f39081a;
    }

    public static int b() {
        int i = f39083e + 1;
        f39083e = i;
        return i;
    }

    public String c() {
        int ceil = (int) Math.ceil((Math.random() * 20.0d) + 3.0d);
        char[] charArray = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        int length = charArray.length;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < ceil; i++) {
            double random = Math.random();
            double d2 = length;
            Double.isNaN(d2);
            stringBuffer.append(charArray[(int) (random * d2)]);
        }
        return stringBuffer.toString();
    }

    public String a(a aVar) {
        int b2 = b();
        try {
            HashMap<String, a> hashMap = this.f39084b;
            hashMap.put("" + b2, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return "" + b2;
    }
}
