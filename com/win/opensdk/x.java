package com.win.opensdk;

import com.win.opensdk.core.Info;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes7.dex */
public class x {

    /* renamed from: b  reason: collision with root package name */
    public static x f37241b;

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap f37242a = new ConcurrentHashMap();

    public static x a() {
        if (f37241b == null) {
            synchronized (x.class) {
                if (f37241b == null) {
                    f37241b = new x();
                }
            }
        }
        return f37241b;
    }

    public Info a(String str) {
        Info info;
        synchronized (x.class) {
            info = (Info) this.f37242a.remove(str);
        }
        return info;
    }

    public void a(String str, Info info) {
        synchronized (x.class) {
            this.f37242a.put(str, info);
        }
    }
}
