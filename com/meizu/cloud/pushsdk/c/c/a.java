package com.meizu.cloud.pushsdk.c.c;

import com.meizu.cloud.pushsdk.c.a.c;
import com.meizu.cloud.pushsdk.c.f.d;
import com.meizu.cloud.pushsdk.c.f.e;
import com.meizu.cloud.pushsdk.notification.model.NotificationStyle;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final List<com.meizu.cloud.pushsdk.c.a.b> f40374a;

    /* renamed from: b  reason: collision with root package name */
    public final long f40375b;

    /* renamed from: c  reason: collision with root package name */
    public final String f40376c;

    /* renamed from: com.meizu.cloud.pushsdk.c.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static abstract class AbstractC0503a<T extends AbstractC0503a<T>> {

        /* renamed from: a  reason: collision with root package name */
        public List<com.meizu.cloud.pushsdk.c.a.b> f40377a = new LinkedList();

        /* renamed from: b  reason: collision with root package name */
        public long f40378b = System.currentTimeMillis();

        /* renamed from: c  reason: collision with root package name */
        public String f40379c = e.b();

        public abstract T a();

        public T a(long j) {
            this.f40378b = j;
            return a();
        }
    }

    public a(AbstractC0503a<?> abstractC0503a) {
        d.a(abstractC0503a.f40377a);
        d.a(abstractC0503a.f40379c);
        d.a(!abstractC0503a.f40379c.isEmpty(), "eventId cannot be empty");
        this.f40374a = abstractC0503a.f40377a;
        this.f40375b = abstractC0503a.f40378b;
        this.f40376c = abstractC0503a.f40379c;
    }

    public c a(c cVar) {
        cVar.a(NotificationStyle.EXPANDABLE_IMAGE_URL, c());
        cVar.a("ts", Long.toString(b()));
        return cVar;
    }

    public List<com.meizu.cloud.pushsdk.c.a.b> a() {
        return new ArrayList(this.f40374a);
    }

    public long b() {
        return this.f40375b;
    }

    public String c() {
        return this.f40376c;
    }
}
