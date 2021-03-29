package com.kwad.sdk.feed.a;

import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static volatile a f34789d;

    /* renamed from: a  reason: collision with root package name */
    public List<AdTemplate> f34790a;

    /* renamed from: b  reason: collision with root package name */
    public List<AdTemplate> f34791b;

    /* renamed from: c  reason: collision with root package name */
    public List<InterfaceC0401a> f34792c;

    /* renamed from: com.kwad.sdk.feed.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0401a {
        @MainThread
        void a(int i);
    }

    public static a a() {
        if (f34789d == null) {
            synchronized (a.class) {
                if (f34789d == null) {
                    f34789d = new a();
                }
            }
        }
        return f34789d;
    }

    @MainThread
    public void a(int i) {
        List<InterfaceC0401a> list = this.f34792c;
        if (list == null) {
            return;
        }
        for (InterfaceC0401a interfaceC0401a : list) {
            interfaceC0401a.a(i);
        }
    }

    @MainThread
    public void a(InterfaceC0401a interfaceC0401a) {
        if (this.f34792c == null) {
            this.f34792c = new LinkedList();
        }
        this.f34792c.add(interfaceC0401a);
    }

    public void a(List<AdTemplate> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        if (this.f34790a == null) {
            this.f34790a = new ArrayList();
        }
        this.f34790a.clear();
        this.f34790a.addAll(list);
    }

    @Nullable
    public List<AdTemplate> b() {
        return this.f34790a;
    }

    @MainThread
    public void b(InterfaceC0401a interfaceC0401a) {
        if (this.f34792c == null) {
            this.f34792c = new LinkedList();
        }
        this.f34792c.remove(interfaceC0401a);
    }

    public void b(List<AdTemplate> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        if (this.f34791b == null) {
            this.f34791b = new ArrayList();
        }
        this.f34791b.clear();
        this.f34791b.addAll(list);
    }

    public void c() {
        List<AdTemplate> list = this.f34790a;
        if (list != null) {
            list.clear();
        }
        this.f34790a = null;
    }

    @Nullable
    public List<AdTemplate> d() {
        return this.f34791b;
    }

    public void e() {
        List<AdTemplate> list = this.f34791b;
        if (list != null) {
            list.clear();
        }
        this.f34791b = null;
    }

    @MainThread
    public void f() {
        List<InterfaceC0401a> list = this.f34792c;
        if (list != null) {
            list.clear();
        }
    }
}
