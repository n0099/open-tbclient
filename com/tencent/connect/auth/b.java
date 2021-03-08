package com.tencent.connect.auth;

import com.tencent.tauth.IUiListener;
import java.util.HashMap;
/* loaded from: classes14.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static b f7920a;
    static final /* synthetic */ boolean d;
    private static int e;
    public HashMap<String, a> b = new HashMap<>();
    public final String c = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    /* loaded from: classes14.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public IUiListener f7921a;
        public com.tencent.connect.auth.a b;
        public String c;
    }

    static {
        d = !b.class.desiredAssertionStatus();
        e = 0;
    }

    public static b a() {
        if (f7920a == null) {
            f7920a = new b();
        }
        return f7920a;
    }

    public static int b() {
        int i = e + 1;
        e = i;
        return i;
    }

    public String a(a aVar) {
        int b = b();
        try {
            this.b.put("" + b, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return "" + b;
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
}
