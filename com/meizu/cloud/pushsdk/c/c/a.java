package com.meizu.cloud.pushsdk.c.c;

import com.meizu.cloud.pushsdk.c.a.c;
import com.meizu.cloud.pushsdk.c.f.d;
import com.meizu.cloud.pushsdk.c.f.e;
import com.meizu.cloud.pushsdk.notification.model.NotificationStyle;
import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final List<com.meizu.cloud.pushsdk.c.a.b> f37722a;

    /* renamed from: b  reason: collision with root package name */
    public final long f37723b;

    /* renamed from: c  reason: collision with root package name */
    public final String f37724c;

    /* renamed from: com.meizu.cloud.pushsdk.c.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static abstract class AbstractC0456a<T extends AbstractC0456a<T>> {

        /* renamed from: a  reason: collision with root package name */
        public List<com.meizu.cloud.pushsdk.c.a.b> f37725a = new LinkedList();

        /* renamed from: b  reason: collision with root package name */
        public long f37726b = System.currentTimeMillis();

        /* renamed from: c  reason: collision with root package name */
        public String f37727c = e.b();

        public abstract T a();

        public T a(long j) {
            this.f37726b = j;
            return a();
        }
    }

    public a(AbstractC0456a<?> abstractC0456a) {
        d.a(abstractC0456a.f37725a);
        d.a(abstractC0456a.f37727c);
        d.a(!abstractC0456a.f37727c.isEmpty(), "eventId cannot be empty");
        this.f37722a = abstractC0456a.f37725a;
        this.f37723b = abstractC0456a.f37726b;
        this.f37724c = abstractC0456a.f37727c;
    }

    public c a(c cVar) {
        cVar.a(NotificationStyle.EXPANDABLE_IMAGE_URL, c());
        cVar.a(TimeDisplaySetting.TIME_DISPLAY_SETTING, Long.toString(b()));
        return cVar;
    }

    public List<com.meizu.cloud.pushsdk.c.a.b> a() {
        return new ArrayList(this.f37722a);
    }

    public long b() {
        return this.f37723b;
    }

    public String c() {
        return this.f37724c;
    }
}
