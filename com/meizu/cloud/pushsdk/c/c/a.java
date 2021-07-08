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
    public final List<com.meizu.cloud.pushsdk.c.a.b> f37388a;

    /* renamed from: b  reason: collision with root package name */
    public final long f37389b;

    /* renamed from: c  reason: collision with root package name */
    public final String f37390c;

    /* renamed from: com.meizu.cloud.pushsdk.c.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static abstract class AbstractC0464a<T extends AbstractC0464a<T>> {

        /* renamed from: a  reason: collision with root package name */
        public List<com.meizu.cloud.pushsdk.c.a.b> f37391a = new LinkedList();

        /* renamed from: b  reason: collision with root package name */
        public long f37392b = System.currentTimeMillis();

        /* renamed from: c  reason: collision with root package name */
        public String f37393c = e.b();

        public abstract T a();

        public T a(long j) {
            this.f37392b = j;
            return a();
        }
    }

    public a(AbstractC0464a<?> abstractC0464a) {
        d.a(abstractC0464a.f37391a);
        d.a(abstractC0464a.f37393c);
        d.a(!abstractC0464a.f37393c.isEmpty(), "eventId cannot be empty");
        this.f37388a = abstractC0464a.f37391a;
        this.f37389b = abstractC0464a.f37392b;
        this.f37390c = abstractC0464a.f37393c;
    }

    public c a(c cVar) {
        cVar.a(NotificationStyle.EXPANDABLE_IMAGE_URL, c());
        cVar.a("ts", Long.toString(b()));
        return cVar;
    }

    public List<com.meizu.cloud.pushsdk.c.a.b> a() {
        return new ArrayList(this.f37388a);
    }

    public long b() {
        return this.f37389b;
    }

    public String c() {
        return this.f37390c;
    }
}
