package com.meizu.cloud.pushsdk.c.c;

import com.meizu.cloud.pushsdk.c.a.c;
import com.meizu.cloud.pushsdk.c.f.d;
import com.meizu.cloud.pushsdk.c.f.e;
import com.meizu.cloud.pushsdk.notification.model.NotificationStyle;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final List<com.meizu.cloud.pushsdk.c.a.b> f34834a;

    /* renamed from: b  reason: collision with root package name */
    public final long f34835b;

    /* renamed from: c  reason: collision with root package name */
    public final String f34836c;

    /* renamed from: com.meizu.cloud.pushsdk.c.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static abstract class AbstractC0405a<T extends AbstractC0405a<T>> {

        /* renamed from: a  reason: collision with root package name */
        public List<com.meizu.cloud.pushsdk.c.a.b> f34837a = new LinkedList();

        /* renamed from: b  reason: collision with root package name */
        public long f34838b = System.currentTimeMillis();

        /* renamed from: c  reason: collision with root package name */
        public String f34839c = e.b();

        public abstract T a();

        public T a(long j) {
            this.f34838b = j;
            return a();
        }
    }

    public a(AbstractC0405a<?> abstractC0405a) {
        d.a(abstractC0405a.f34837a);
        d.a(abstractC0405a.f34839c);
        d.a(!abstractC0405a.f34839c.isEmpty(), "eventId cannot be empty");
        this.f34834a = abstractC0405a.f34837a;
        this.f34835b = abstractC0405a.f34838b;
        this.f34836c = abstractC0405a.f34839c;
    }

    public c a(c cVar) {
        cVar.a(NotificationStyle.EXPANDABLE_IMAGE_URL, c());
        cVar.a("ts", Long.toString(b()));
        return cVar;
    }

    public List<com.meizu.cloud.pushsdk.c.a.b> a() {
        return new ArrayList(this.f34834a);
    }

    public long b() {
        return this.f34835b;
    }

    public String c() {
        return this.f34836c;
    }
}
