package com.kwad.sdk.feed.a;

import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class a {
    private static volatile a d;

    /* renamed from: a  reason: collision with root package name */
    private List<AdTemplate> f10106a;

    /* renamed from: b  reason: collision with root package name */
    private List<AdTemplate> f10107b;
    private List<InterfaceC1086a> c;

    /* renamed from: com.kwad.sdk.feed.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC1086a {
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
        for (InterfaceC1086a interfaceC1086a : this.c) {
            interfaceC1086a.a(i);
        }
    }

    @MainThread
    public void a(InterfaceC1086a interfaceC1086a) {
        if (this.c == null) {
            this.c = new LinkedList();
        }
        this.c.add(interfaceC1086a);
    }

    public void a(List<AdTemplate> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        if (this.f10106a == null) {
            this.f10106a = new ArrayList();
        }
        this.f10106a.clear();
        this.f10106a.addAll(list);
    }

    @Nullable
    public List<AdTemplate> b() {
        return this.f10106a;
    }

    @MainThread
    public void b(InterfaceC1086a interfaceC1086a) {
        if (this.c == null) {
            this.c = new LinkedList();
        }
        this.c.remove(interfaceC1086a);
    }

    public void b(List<AdTemplate> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        if (this.f10107b == null) {
            this.f10107b = new ArrayList();
        }
        this.f10107b.clear();
        this.f10107b.addAll(list);
    }

    public void c() {
        if (this.f10106a != null) {
            this.f10106a.clear();
        }
        this.f10106a = null;
    }

    @Nullable
    public List<AdTemplate> d() {
        return this.f10107b;
    }

    public void e() {
        if (this.f10107b != null) {
            this.f10107b.clear();
        }
        this.f10107b = null;
    }

    @MainThread
    public void f() {
        if (this.c != null) {
            this.c.clear();
        }
    }
}
