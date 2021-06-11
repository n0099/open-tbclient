package com.kwad.sdk.feed.a;

import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static volatile a f35449d;

    /* renamed from: a  reason: collision with root package name */
    public List<AdTemplate> f35450a;

    /* renamed from: b  reason: collision with root package name */
    public List<AdTemplate> f35451b;

    /* renamed from: c  reason: collision with root package name */
    public List<InterfaceC0401a> f35452c;

    /* renamed from: com.kwad.sdk.feed.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0401a {
        @MainThread
        void a(int i2);
    }

    public static a a() {
        if (f35449d == null) {
            synchronized (a.class) {
                if (f35449d == null) {
                    f35449d = new a();
                }
            }
        }
        return f35449d;
    }

    @MainThread
    public void a(int i2) {
        List<InterfaceC0401a> list = this.f35452c;
        if (list == null) {
            return;
        }
        for (InterfaceC0401a interfaceC0401a : list) {
            interfaceC0401a.a(i2);
        }
    }

    @MainThread
    public void a(InterfaceC0401a interfaceC0401a) {
        if (this.f35452c == null) {
            this.f35452c = new LinkedList();
        }
        this.f35452c.add(interfaceC0401a);
    }

    public void a(List<AdTemplate> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        if (this.f35450a == null) {
            this.f35450a = new ArrayList();
        }
        this.f35450a.clear();
        this.f35450a.addAll(list);
    }

    @Nullable
    public List<AdTemplate> b() {
        return this.f35450a;
    }

    @MainThread
    public void b(InterfaceC0401a interfaceC0401a) {
        if (this.f35452c == null) {
            this.f35452c = new LinkedList();
        }
        this.f35452c.remove(interfaceC0401a);
    }

    public void b(List<AdTemplate> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        if (this.f35451b == null) {
            this.f35451b = new ArrayList();
        }
        this.f35451b.clear();
        this.f35451b.addAll(list);
    }

    public void c() {
        List<AdTemplate> list = this.f35450a;
        if (list != null) {
            list.clear();
        }
        this.f35450a = null;
    }

    @Nullable
    public List<AdTemplate> d() {
        return this.f35451b;
    }

    public void e() {
        List<AdTemplate> list = this.f35451b;
        if (list != null) {
            list.clear();
        }
        this.f35451b = null;
    }

    @MainThread
    public void f() {
        List<InterfaceC0401a> list = this.f35452c;
        if (list != null) {
            list.clear();
        }
    }
}
