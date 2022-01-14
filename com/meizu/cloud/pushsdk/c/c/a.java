package com.meizu.cloud.pushsdk.c.c;

import com.meizu.cloud.pushsdk.c.a.c;
import com.meizu.cloud.pushsdk.c.f.d;
import com.meizu.cloud.pushsdk.c.f.e;
import com.meizu.cloud.pushsdk.notification.model.NotificationStyle;
import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    public final List<com.meizu.cloud.pushsdk.c.a.b> a;

    /* renamed from: b  reason: collision with root package name */
    public final long f58699b;

    /* renamed from: c  reason: collision with root package name */
    public final String f58700c;

    /* renamed from: com.meizu.cloud.pushsdk.c.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static abstract class AbstractC2169a<T extends AbstractC2169a<T>> {
        public List<com.meizu.cloud.pushsdk.c.a.b> a = new LinkedList();

        /* renamed from: b  reason: collision with root package name */
        public long f58701b = System.currentTimeMillis();

        /* renamed from: c  reason: collision with root package name */
        public String f58702c = e.b();

        public abstract T a();

        public T a(long j2) {
            this.f58701b = j2;
            return a();
        }
    }

    public a(AbstractC2169a<?> abstractC2169a) {
        d.a(abstractC2169a.a);
        d.a(abstractC2169a.f58702c);
        d.a(!abstractC2169a.f58702c.isEmpty(), "eventId cannot be empty");
        this.a = abstractC2169a.a;
        this.f58699b = abstractC2169a.f58701b;
        this.f58700c = abstractC2169a.f58702c;
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
        return this.f58699b;
    }

    public String c() {
        return this.f58700c;
    }
}
