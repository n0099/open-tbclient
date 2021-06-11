package com.win.opensdk;

import com.win.opensdk.core.Info;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes7.dex */
public class x {

    /* renamed from: b  reason: collision with root package name */
    public static x f40849b;

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap f40850a = new ConcurrentHashMap();

    public static x a() {
        if (f40849b == null) {
            synchronized (x.class) {
                if (f40849b == null) {
                    f40849b = new x();
                }
            }
        }
        return f40849b;
    }

    public Info a(String str) {
        Info info;
        synchronized (x.class) {
            info = (Info) this.f40850a.remove(str);
        }
        return info;
    }

    public void a(String str, Info info) {
        synchronized (x.class) {
            this.f40850a.put(str, info);
        }
    }
}
