package com.kwad.sdk.reward;

import java.util.HashSet;
import java.util.Set;
/* loaded from: classes5.dex */
public class b {
    public Set<InterfaceC0329b> a;

    /* loaded from: classes5.dex */
    public static class a {
        public static b a = new b();
    }

    /* renamed from: com.kwad.sdk.reward.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0329b {
        void onPageClose();
    }

    public b() {
        this.a = new HashSet();
    }

    public static b a() {
        return a.a;
    }

    public void a(InterfaceC0329b interfaceC0329b) {
        if (interfaceC0329b != null) {
            this.a.add(interfaceC0329b);
        }
    }

    public void b() {
        if (this.a.size() == 0) {
            return;
        }
        for (InterfaceC0329b interfaceC0329b : this.a) {
            interfaceC0329b.onPageClose();
        }
    }

    public void b(InterfaceC0329b interfaceC0329b) {
        this.a.remove(interfaceC0329b);
    }
}
