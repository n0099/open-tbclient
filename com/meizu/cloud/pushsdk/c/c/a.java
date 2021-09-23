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
    public final List<com.meizu.cloud.pushsdk.c.a.b> f75120a;

    /* renamed from: b  reason: collision with root package name */
    public final long f75121b;

    /* renamed from: c  reason: collision with root package name */
    public final String f75122c;

    /* renamed from: com.meizu.cloud.pushsdk.c.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static abstract class AbstractC2041a<T extends AbstractC2041a<T>> {

        /* renamed from: a  reason: collision with root package name */
        public List<com.meizu.cloud.pushsdk.c.a.b> f75123a = new LinkedList();

        /* renamed from: b  reason: collision with root package name */
        public long f75124b = System.currentTimeMillis();

        /* renamed from: c  reason: collision with root package name */
        public String f75125c = e.b();

        public abstract T a();

        public T a(long j2) {
            this.f75124b = j2;
            return a();
        }
    }

    public a(AbstractC2041a<?> abstractC2041a) {
        d.a(abstractC2041a.f75123a);
        d.a(abstractC2041a.f75125c);
        d.a(!abstractC2041a.f75125c.isEmpty(), "eventId cannot be empty");
        this.f75120a = abstractC2041a.f75123a;
        this.f75121b = abstractC2041a.f75124b;
        this.f75122c = abstractC2041a.f75125c;
    }

    public c a(c cVar) {
        cVar.a(NotificationStyle.EXPANDABLE_IMAGE_URL, c());
        cVar.a("ts", Long.toString(b()));
        return cVar;
    }

    public List<com.meizu.cloud.pushsdk.c.a.b> a() {
        return new ArrayList(this.f75120a);
    }

    public long b() {
        return this.f75121b;
    }

    public String c() {
        return this.f75122c;
    }
}
