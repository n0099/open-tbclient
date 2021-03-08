package com.kwad.sdk.feed.a;

import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private static volatile a d;

    /* renamed from: a  reason: collision with root package name */
    private List<AdTemplate> f6495a;
    private List<AdTemplate> b;
    private List<InterfaceC1133a> c;

    /* renamed from: com.kwad.sdk.feed.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1133a {
        @MainThread
        void a(int i);
    }

    private a() {
    }

    public static a a() {
        if (d == null) {
            synchronized (a.class) {
                if (d == null) {
                    d = new a();
                }
            }
        }
        return d;
    }

    @MainThread
    public void a(int i) {
        if (this.c == null) {
            return;
        }
        for (InterfaceC1133a interfaceC1133a : this.c) {
            interfaceC1133a.a(i);
        }
    }

    @MainThread
    public void a(InterfaceC1133a interfaceC1133a) {
        if (this.c == null) {
            this.c = new LinkedList();
        }
        this.c.add(interfaceC1133a);
    }

    public void a(List<AdTemplate> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        if (this.f6495a == null) {
            this.f6495a = new ArrayList();
        }
        this.f6495a.clear();
        this.f6495a.addAll(list);
    }

    @Nullable
    public List<AdTemplate> b() {
        return this.f6495a;
    }

    @MainThread
    public void b(InterfaceC1133a interfaceC1133a) {
        if (this.c == null) {
            this.c = new LinkedList();
        }
        this.c.remove(interfaceC1133a);
    }

    public void b(List<AdTemplate> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        if (this.b == null) {
            this.b = new ArrayList();
        }
        this.b.clear();
        this.b.addAll(list);
    }

    public void c() {
        if (this.f6495a != null) {
            this.f6495a.clear();
        }
        this.f6495a = null;
    }

    @Nullable
    public List<AdTemplate> d() {
        return this.b;
    }

    public void e() {
        if (this.b != null) {
            this.b.clear();
        }
        this.b = null;
    }

    @MainThread
    public void f() {
        if (this.c != null) {
            this.c.clear();
        }
    }
}
