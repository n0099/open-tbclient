package com.kwad.sdk.reward;

import java.util.HashSet;
import java.util.Set;
/* loaded from: classes8.dex */
public class b {
    public Set<InterfaceC2128b> a;

    /* loaded from: classes8.dex */
    public static class a {
        public static b a = new b();
    }

    /* renamed from: com.kwad.sdk.reward.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC2128b {
        void onPageClose();
    }

    public b() {
        this.a = new HashSet();
    }

    public static b a() {
        return a.a;
    }

    public void a(InterfaceC2128b interfaceC2128b) {
        if (interfaceC2128b != null) {
            this.a.add(interfaceC2128b);
        }
    }

    public void b() {
        if (this.a.size() == 0) {
            return;
        }
        for (InterfaceC2128b interfaceC2128b : this.a) {
            interfaceC2128b.onPageClose();
        }
    }

    public void b(InterfaceC2128b interfaceC2128b) {
        this.a.remove(interfaceC2128b);
    }
}
