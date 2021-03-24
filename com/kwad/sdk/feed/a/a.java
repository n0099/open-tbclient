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
    public static volatile a f34788d;

    /* renamed from: a  reason: collision with root package name */
    public List<AdTemplate> f34789a;

    /* renamed from: b  reason: collision with root package name */
    public List<AdTemplate> f34790b;

    /* renamed from: c  reason: collision with root package name */
    public List<InterfaceC0400a> f34791c;

    /* renamed from: com.kwad.sdk.feed.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0400a {
        @MainThread
        void a(int i);
    }

    public static a a() {
        if (f34788d == null) {
            synchronized (a.class) {
                if (f34788d == null) {
                    f34788d = new a();
                }
            }
        }
        return f34788d;
    }

    @MainThread
    public void a(int i) {
        List<InterfaceC0400a> list = this.f34791c;
        if (list == null) {
            return;
        }
        for (InterfaceC0400a interfaceC0400a : list) {
            interfaceC0400a.a(i);
        }
    }

    @MainThread
    public void a(InterfaceC0400a interfaceC0400a) {
        if (this.f34791c == null) {
            this.f34791c = new LinkedList();
        }
        this.f34791c.add(interfaceC0400a);
    }

    public void a(List<AdTemplate> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        if (this.f34789a == null) {
            this.f34789a = new ArrayList();
        }
        this.f34789a.clear();
        this.f34789a.addAll(list);
    }

    @Nullable
    public List<AdTemplate> b() {
        return this.f34789a;
    }

    @MainThread
    public void b(InterfaceC0400a interfaceC0400a) {
        if (this.f34791c == null) {
            this.f34791c = new LinkedList();
        }
        this.f34791c.remove(interfaceC0400a);
    }

    public void b(List<AdTemplate> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        if (this.f34790b == null) {
            this.f34790b = new ArrayList();
        }
        this.f34790b.clear();
        this.f34790b.addAll(list);
    }

    public void c() {
        List<AdTemplate> list = this.f34789a;
        if (list != null) {
            list.clear();
        }
        this.f34789a = null;
    }

    @Nullable
    public List<AdTemplate> d() {
        return this.f34790b;
    }

    public void e() {
        List<AdTemplate> list = this.f34790b;
        if (list != null) {
            list.clear();
        }
        this.f34790b = null;
    }

    @MainThread
    public void f() {
        List<InterfaceC0400a> list = this.f34791c;
        if (list != null) {
            list.clear();
        }
    }
}
