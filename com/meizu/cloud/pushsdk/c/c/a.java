package com.meizu.cloud.pushsdk.c.c;

import com.meizu.cloud.pushsdk.c.a.c;
import com.meizu.cloud.pushsdk.c.f.d;
import com.meizu.cloud.pushsdk.c.f.e;
import com.meizu.cloud.pushsdk.notification.model.NotificationStyle;
import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    public final List<com.meizu.cloud.pushsdk.c.a.b> a;

    /* renamed from: b  reason: collision with root package name */
    public final long f58911b;

    /* renamed from: c  reason: collision with root package name */
    public final String f58912c;

    /* renamed from: com.meizu.cloud.pushsdk.c.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static abstract class AbstractC2185a<T extends AbstractC2185a<T>> {
        public List<com.meizu.cloud.pushsdk.c.a.b> a = new LinkedList();

        /* renamed from: b  reason: collision with root package name */
        public long f58913b = System.currentTimeMillis();

        /* renamed from: c  reason: collision with root package name */
        public String f58914c = e.b();

        public abstract T a();

        public T a(long j2) {
            this.f58913b = j2;
            return a();
        }
    }

    public a(AbstractC2185a<?> abstractC2185a) {
        d.a(abstractC2185a.a);
        d.a(abstractC2185a.f58914c);
        d.a(!abstractC2185a.f58914c.isEmpty(), "eventId cannot be empty");
        this.a = abstractC2185a.a;
        this.f58911b = abstractC2185a.f58913b;
        this.f58912c = abstractC2185a.f58914c;
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
        return this.f58911b;
    }

    public String c() {
        return this.f58912c;
    }
}
