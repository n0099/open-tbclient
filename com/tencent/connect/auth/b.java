package com.tencent.connect.auth;

import com.tencent.tauth.IUiListener;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static b f39466a;

    /* renamed from: d  reason: collision with root package name */
    public static final /* synthetic */ boolean f39467d = !b.class.desiredAssertionStatus();

    /* renamed from: e  reason: collision with root package name */
    public static int f39468e = 0;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, a> f39469b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public final String f39470c = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public IUiListener f39471a;

        /* renamed from: b  reason: collision with root package name */
        public com.tencent.connect.auth.a f39472b;

        /* renamed from: c  reason: collision with root package name */
        public String f39473c;
    }

    public static b a() {
        if (f39466a == null) {
            f39466a = new b();
        }
        return f39466a;
    }

    public static int b() {
        int i = f39468e + 1;
        f39468e = i;
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
            HashMap<String, a> hashMap = this.f39469b;
            hashMap.put("" + b2, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return "" + b2;
    }
}
