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
    protected final List<com.meizu.cloud.pushsdk.c.a.b> f11573a;

    /* renamed from: b  reason: collision with root package name */
    protected final long f11574b;
    protected final String c;

    /* renamed from: com.meizu.cloud.pushsdk.c.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static abstract class AbstractC1141a<T extends AbstractC1141a<T>> {

        /* renamed from: a  reason: collision with root package name */
        private List<com.meizu.cloud.pushsdk.c.a.b> f11575a = new LinkedList();

        /* renamed from: b  reason: collision with root package name */
        private long f11576b = System.currentTimeMillis();
        private String c = e.b();

        /* JADX INFO: Access modifiers changed from: protected */
        public abstract T a();

        public T a(long j) {
            this.f11576b = j;
            return a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a(AbstractC1141a<?> abstractC1141a) {
        d.a(((AbstractC1141a) abstractC1141a).f11575a);
        d.a(((AbstractC1141a) abstractC1141a).c);
        d.a(!((AbstractC1141a) abstractC1141a).c.isEmpty(), "eventId cannot be empty");
        this.f11573a = ((AbstractC1141a) abstractC1141a).f11575a;
        this.f11574b = ((AbstractC1141a) abstractC1141a).f11576b;
        this.c = ((AbstractC1141a) abstractC1141a).c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c a(c cVar) {
        cVar.a(NotificationStyle.EXPANDABLE_IMAGE_URL, c());
        cVar.a("ts", Long.toString(b()));
        return cVar;
    }

    public List<com.meizu.cloud.pushsdk.c.a.b> a() {
        return new ArrayList(this.f11573a);
    }

    public long b() {
        return this.f11574b;
    }

    public String c() {
        return this.c;
    }
}
