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
    protected final List<com.meizu.cloud.pushsdk.c.a.b> f11574a;

    /* renamed from: b  reason: collision with root package name */
    protected final long f11575b;
    protected final String c;

    /* renamed from: com.meizu.cloud.pushsdk.c.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static abstract class AbstractC1182a<T extends AbstractC1182a<T>> {

        /* renamed from: a  reason: collision with root package name */
        private List<com.meizu.cloud.pushsdk.c.a.b> f11576a = new LinkedList();

        /* renamed from: b  reason: collision with root package name */
        private long f11577b = System.currentTimeMillis();
        private String c = e.b();

        /* JADX INFO: Access modifiers changed from: protected */
        public abstract T a();

        public T a(long j) {
            this.f11577b = j;
            return a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a(AbstractC1182a<?> abstractC1182a) {
        d.a(((AbstractC1182a) abstractC1182a).f11576a);
        d.a(((AbstractC1182a) abstractC1182a).c);
        d.a(!((AbstractC1182a) abstractC1182a).c.isEmpty(), "eventId cannot be empty");
        this.f11574a = ((AbstractC1182a) abstractC1182a).f11576a;
        this.f11575b = ((AbstractC1182a) abstractC1182a).f11577b;
        this.c = ((AbstractC1182a) abstractC1182a).c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c a(c cVar) {
        cVar.a(NotificationStyle.EXPANDABLE_IMAGE_URL, c());
        cVar.a("ts", Long.toString(b()));
        return cVar;
    }

    public List<com.meizu.cloud.pushsdk.c.a.b> a() {
        return new ArrayList(this.f11574a);
    }

    public long b() {
        return this.f11575b;
    }

    public String c() {
        return this.c;
    }
}
