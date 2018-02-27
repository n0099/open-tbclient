package com.meizu.cloud.pushsdk.b.c;

import com.meizu.cloud.pushsdk.b.a.c;
import com.meizu.cloud.pushsdk.b.f.d;
import com.meizu.cloud.pushsdk.b.f.e;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    protected final List<com.meizu.cloud.pushsdk.b.a.b> a;
    protected final long b;
    protected final String c;

    /* renamed from: com.meizu.cloud.pushsdk.b.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static abstract class AbstractC0267a<T extends AbstractC0267a<T>> {
        private List<com.meizu.cloud.pushsdk.b.a.b> a = new LinkedList();
        private long b = System.currentTimeMillis();
        private String c = e.b();

        /* JADX INFO: Access modifiers changed from: protected */
        public abstract T a();

        public T a(long j) {
            this.b = j;
            return a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a(AbstractC0267a<?> abstractC0267a) {
        d.a(((AbstractC0267a) abstractC0267a).a);
        d.a(((AbstractC0267a) abstractC0267a).c);
        d.a(!((AbstractC0267a) abstractC0267a).c.isEmpty(), "eventId cannot be empty");
        this.a = ((AbstractC0267a) abstractC0267a).a;
        this.b = ((AbstractC0267a) abstractC0267a).b;
        this.c = ((AbstractC0267a) abstractC0267a).c;
    }

    public List<com.meizu.cloud.pushsdk.b.a.b> a() {
        return new ArrayList(this.a);
    }

    public long b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c a(c cVar) {
        cVar.a("event_id", c());
        cVar.a("timestamp", Long.toString(b()));
        return cVar;
    }
}
