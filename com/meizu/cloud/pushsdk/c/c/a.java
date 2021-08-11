package com.meizu.cloud.pushsdk.c.c;

import com.meizu.cloud.pushsdk.c.a.c;
import com.meizu.cloud.pushsdk.c.f.d;
import com.meizu.cloud.pushsdk.c.f.e;
import com.meizu.cloud.pushsdk.notification.model.NotificationStyle;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes10.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final List<com.meizu.cloud.pushsdk.c.a.b> f74421a;

    /* renamed from: b  reason: collision with root package name */
    public final long f74422b;

    /* renamed from: c  reason: collision with root package name */
    public final String f74423c;

    /* renamed from: com.meizu.cloud.pushsdk.c.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static abstract class AbstractC2033a<T extends AbstractC2033a<T>> {

        /* renamed from: a  reason: collision with root package name */
        public List<com.meizu.cloud.pushsdk.c.a.b> f74424a = new LinkedList();

        /* renamed from: b  reason: collision with root package name */
        public long f74425b = System.currentTimeMillis();

        /* renamed from: c  reason: collision with root package name */
        public String f74426c = e.b();

        public abstract T a();

        public T a(long j2) {
            this.f74425b = j2;
            return a();
        }
    }

    public a(AbstractC2033a<?> abstractC2033a) {
        d.a(abstractC2033a.f74424a);
        d.a(abstractC2033a.f74426c);
        d.a(!abstractC2033a.f74426c.isEmpty(), "eventId cannot be empty");
        this.f74421a = abstractC2033a.f74424a;
        this.f74422b = abstractC2033a.f74425b;
        this.f74423c = abstractC2033a.f74426c;
    }

    public c a(c cVar) {
        cVar.a(NotificationStyle.EXPANDABLE_IMAGE_URL, c());
        cVar.a("ts", Long.toString(b()));
        return cVar;
    }

    public List<com.meizu.cloud.pushsdk.c.a.b> a() {
        return new ArrayList(this.f74421a);
    }

    public long b() {
        return this.f74422b;
    }

    public String c() {
        return this.f74423c;
    }
}
