package com.tencent.connect.auth;

import com.tencent.tauth.IUiListener;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static b f37061a;

    /* renamed from: d  reason: collision with root package name */
    public static final /* synthetic */ boolean f37062d = !b.class.desiredAssertionStatus();

    /* renamed from: e  reason: collision with root package name */
    public static int f37063e = 0;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, a> f37064b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public final String f37065c = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public IUiListener f37066a;

        /* renamed from: b  reason: collision with root package name */
        public com.tencent.connect.auth.a f37067b;

        /* renamed from: c  reason: collision with root package name */
        public String f37068c;
    }

    public static b a() {
        if (f37061a == null) {
            f37061a = new b();
        }
        return f37061a;
    }

    public static int b() {
        int i2 = f37063e + 1;
        f37063e = i2;
        return i2;
    }

    public String c() {
        int ceil = (int) Math.ceil((Math.random() * 20.0d) + 3.0d);
        char[] charArray = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        int length = charArray.length;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < ceil; i2++) {
            stringBuffer.append(charArray[(int) (Math.random() * length)]);
        }
        return stringBuffer.toString();
    }

    public String a(a aVar) {
        int b2 = b();
        try {
            HashMap<String, a> hashMap = this.f37064b;
            hashMap.put("" + b2, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return "" + b2;
    }
}
