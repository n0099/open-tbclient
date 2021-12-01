package com.meizu.cloud.pushsdk.c.c;

import com.meizu.cloud.pushsdk.c.a.c;
import com.meizu.cloud.pushsdk.c.f.d;
import com.meizu.cloud.pushsdk.c.f.e;
import com.meizu.cloud.pushsdk.notification.model.NotificationStyle;
import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    public final List<com.meizu.cloud.pushsdk.c.a.b> a;

    /* renamed from: b  reason: collision with root package name */
    public final long f60427b;

    /* renamed from: c  reason: collision with root package name */
    public final String f60428c;

    /* renamed from: com.meizu.cloud.pushsdk.c.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static abstract class AbstractC2084a<T extends AbstractC2084a<T>> {
        public List<com.meizu.cloud.pushsdk.c.a.b> a = new LinkedList();

        /* renamed from: b  reason: collision with root package name */
        public long f60429b = System.currentTimeMillis();

        /* renamed from: c  reason: collision with root package name */
        public String f60430c = e.b();

        public abstract T a();

        public T a(long j2) {
            this.f60429b = j2;
            return a();
        }
    }

    public a(AbstractC2084a<?> abstractC2084a) {
        d.a(abstractC2084a.a);
        d.a(abstractC2084a.f60430c);
        d.a(!abstractC2084a.f60430c.isEmpty(), "eventId cannot be empty");
        this.a = abstractC2084a.a;
        this.f60427b = abstractC2084a.f60429b;
        this.f60428c = abstractC2084a.f60430c;
    }

    public c a(c cVar) {
        cVar.a(NotificationStyle.EXPANDABLE_IMAGE_URL, c());
        cVar.a(TimeDisplaySetting.TIME_DISPLAY_SETTING, Long.toString(b()));
        return cVar;
    }

    public List<com.meizu.cloud.pushsdk.c.a.b> a() {
        return new ArrayList(this.a);
    }

    public long b() {
        return this.f60427b;
    }

    public String c() {
        return this.f60428c;
    }
}
