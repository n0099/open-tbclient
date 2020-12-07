package com.meizu.cloud.pushsdk.c.c;

import com.meizu.cloud.pushsdk.c.a.c;
import com.meizu.cloud.pushsdk.c.f.d;
import com.meizu.cloud.pushsdk.c.f.e;
import com.meizu.cloud.pushsdk.notification.model.NotificationStyle;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes16.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    protected final List<com.meizu.cloud.pushsdk.c.a.b> f4164a;
    protected final long b;
    protected final String c;

    /* renamed from: com.meizu.cloud.pushsdk.c.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public static abstract class AbstractC1010a<T extends AbstractC1010a<T>> {

        /* renamed from: a  reason: collision with root package name */
        private List<com.meizu.cloud.pushsdk.c.a.b> f4165a = new LinkedList();
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
    public a(AbstractC1010a<?> abstractC1010a) {
        d.a(((AbstractC1010a) abstractC1010a).f4165a);
        d.a(((AbstractC1010a) abstractC1010a).c);
        d.a(!((AbstractC1010a) abstractC1010a).c.isEmpty(), "eventId cannot be empty");
        this.f4164a = ((AbstractC1010a) abstractC1010a).f4165a;
        this.b = ((AbstractC1010a) abstractC1010a).b;
        this.c = ((AbstractC1010a) abstractC1010a).c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c a(c cVar) {
        cVar.a(NotificationStyle.EXPANDABLE_IMAGE_URL, c());
        cVar.a("ts", Long.toString(b()));
        return cVar;
    }

    public List<com.meizu.cloud.pushsdk.c.a.b> a() {
        return new ArrayList(this.f4164a);
    }

    public long b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }
}
