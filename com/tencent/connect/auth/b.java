package com.tencent.connect.auth;

import com.tencent.tauth.IUiListener;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static b f36306a;

    /* renamed from: d  reason: collision with root package name */
    public static final /* synthetic */ boolean f36307d = !b.class.desiredAssertionStatus();

    /* renamed from: e  reason: collision with root package name */
    public static int f36308e = 0;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, a> f36309b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public final String f36310c = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public IUiListener f36311a;

        /* renamed from: b  reason: collision with root package name */
        public com.tencent.connect.auth.a f36312b;

        /* renamed from: c  reason: collision with root package name */
        public String f36313c;
    }

    public static b a() {
        if (f36306a == null) {
            f36306a = new b();
        }
        return f36306a;
    }

    public static int b() {
        int i2 = f36308e + 1;
        f36308e = i2;
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
            HashMap<String, a> hashMap = this.f36309b;
            hashMap.put("" + b2, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return "" + b2;
    }
}
