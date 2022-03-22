package com.kwad.sdk.reward;

import java.util.HashSet;
import java.util.Set;
/* loaded from: classes7.dex */
public class b {
    public Set<InterfaceC1989b> a;

    /* loaded from: classes7.dex */
    public static class a {
        public static b a = new b();
    }

    /* renamed from: com.kwad.sdk.reward.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC1989b {
        void onPageClose();
    }

    public b() {
        this.a = new HashSet();
    }

    public static b a() {
        return a.a;
    }

    public void a(InterfaceC1989b interfaceC1989b) {
        if (interfaceC1989b != null) {
            this.a.add(interfaceC1989b);
        }
    }

    public void b() {
        if (this.a.size() == 0) {
            return;
        }
        for (InterfaceC1989b interfaceC1989b : this.a) {
            interfaceC1989b.onPageClose();
        }
    }

    public void b(InterfaceC1989b interfaceC1989b) {
        this.a.remove(interfaceC1989b);
    }
}
