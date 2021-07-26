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
    public final List<com.meizu.cloud.pushsdk.c.a.b> f37577a;

    /* renamed from: b  reason: collision with root package name */
    public final long f37578b;

    /* renamed from: c  reason: collision with root package name */
    public final String f37579c;

    /* renamed from: com.meizu.cloud.pushsdk.c.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static abstract class AbstractC0466a<T extends AbstractC0466a<T>> {

        /* renamed from: a  reason: collision with root package name */
        public List<com.meizu.cloud.pushsdk.c.a.b> f37580a = new LinkedList();

        /* renamed from: b  reason: collision with root package name */
        public long f37581b = System.currentTimeMillis();

        /* renamed from: c  reason: collision with root package name */
        public String f37582c = e.b();

        public abstract T a();

        public T a(long j) {
            this.f37581b = j;
            return a();
        }
    }

    public a(AbstractC0466a<?> abstractC0466a) {
        d.a(abstractC0466a.f37580a);
        d.a(abstractC0466a.f37582c);
        d.a(!abstractC0466a.f37582c.isEmpty(), "eventId cannot be empty");
        this.f37577a = abstractC0466a.f37580a;
        this.f37578b = abstractC0466a.f37581b;
        this.f37579c = abstractC0466a.f37582c;
    }

    public c a(c cVar) {
        cVar.a(NotificationStyle.EXPANDABLE_IMAGE_URL, c());
        cVar.a("ts", Long.toString(b()));
        return cVar;
    }

    public List<com.meizu.cloud.pushsdk.c.a.b> a() {
        return new ArrayList(this.f37577a);
    }

    public long b() {
        return this.f37578b;
    }

    public String c() {
        return this.f37579c;
    }
}
