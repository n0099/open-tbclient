package com.kwad.sdk.reward;

import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class b {
    public Set<InterfaceC2149b> a;

    /* loaded from: classes4.dex */
    public static class a {
        public static b a = new b();
    }

    /* renamed from: com.kwad.sdk.reward.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC2149b {
        void onPageClose();
    }

    public b() {
        this.a = new HashSet();
    }

    public static b a() {
        return a.a;
    }

    public void a(InterfaceC2149b interfaceC2149b) {
        if (interfaceC2149b != null) {
            this.a.add(interfaceC2149b);
        }
    }

    public void b() {
        if (this.a.size() == 0) {
            return;
        }
        for (InterfaceC2149b interfaceC2149b : this.a) {
            interfaceC2149b.onPageClose();
        }
    }

    public void b(InterfaceC2149b interfaceC2149b) {
        this.a.remove(interfaceC2149b);
    }
}
