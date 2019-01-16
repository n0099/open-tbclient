package com.meizu.cloud.pushsdk.pushtracer.b;

import com.baidu.ar.constants.HttpConstants;
import com.baidu.ar.statistic.StatisticConstants;
import com.meizu.cloud.pushsdk.pushtracer.utils.c;
import com.meizu.cloud.pushsdk.pushtracer.utils.d;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    protected final List<com.meizu.cloud.pushsdk.pushtracer.a.b> a;
    protected final long b;
    protected final String c;

    /* renamed from: com.meizu.cloud.pushsdk.pushtracer.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static abstract class AbstractC0372a<T extends AbstractC0372a<T>> {
        private List<com.meizu.cloud.pushsdk.pushtracer.a.b> a = new LinkedList();
        private long b = System.currentTimeMillis();
        private String c = d.b();

        /* JADX INFO: Access modifiers changed from: protected */
        public abstract T a();

        public T a(long j) {
            this.b = j;
            return a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a(AbstractC0372a<?> abstractC0372a) {
        c.a(((AbstractC0372a) abstractC0372a).a);
        c.a(((AbstractC0372a) abstractC0372a).c);
        c.a(!((AbstractC0372a) abstractC0372a).c.isEmpty(), "eventId cannot be empty");
        this.a = ((AbstractC0372a) abstractC0372a).a;
        this.b = ((AbstractC0372a) abstractC0372a).b;
        this.c = ((AbstractC0372a) abstractC0372a).c;
    }

    public List<com.meizu.cloud.pushsdk.pushtracer.a.b> a() {
        return new ArrayList(this.a);
    }

    public long b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.meizu.cloud.pushsdk.pushtracer.a.c a(com.meizu.cloud.pushsdk.pushtracer.a.c cVar) {
        cVar.a(StatisticConstants.EVENT_ID, c());
        cVar.a(HttpConstants.TIMESTAMP, Long.toString(b()));
        return cVar;
    }
}
