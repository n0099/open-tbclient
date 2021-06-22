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
    public final List<com.meizu.cloud.pushsdk.c.a.b> f38611a;

    /* renamed from: b  reason: collision with root package name */
    public final long f38612b;

    /* renamed from: c  reason: collision with root package name */
    public final String f38613c;

    /* renamed from: com.meizu.cloud.pushsdk.c.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static abstract class AbstractC0459a<T extends AbstractC0459a<T>> {

        /* renamed from: a  reason: collision with root package name */
        public List<com.meizu.cloud.pushsdk.c.a.b> f38614a = new LinkedList();

        /* renamed from: b  reason: collision with root package name */
        public long f38615b = System.currentTimeMillis();

        /* renamed from: c  reason: collision with root package name */
        public String f38616c = e.b();

        public abstract T a();

        public T a(long j) {
            this.f38615b = j;
            return a();
        }
    }

    public a(AbstractC0459a<?> abstractC0459a) {
        d.a(abstractC0459a.f38614a);
        d.a(abstractC0459a.f38616c);
        d.a(!abstractC0459a.f38616c.isEmpty(), "eventId cannot be empty");
        this.f38611a = abstractC0459a.f38614a;
        this.f38612b = abstractC0459a.f38615b;
        this.f38613c = abstractC0459a.f38616c;
    }

    public c a(c cVar) {
        cVar.a(NotificationStyle.EXPANDABLE_IMAGE_URL, c());
        cVar.a("ts", Long.toString(b()));
        return cVar;
    }

    public List<com.meizu.cloud.pushsdk.c.a.b> a() {
        return new ArrayList(this.f38611a);
    }

    public long b() {
        return this.f38612b;
    }

    public String c() {
        return this.f38613c;
    }
}
