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
    public final List<com.meizu.cloud.pushsdk.c.a.b> f37721a;

    /* renamed from: b  reason: collision with root package name */
    public final long f37722b;

    /* renamed from: c  reason: collision with root package name */
    public final String f37723c;

    /* renamed from: com.meizu.cloud.pushsdk.c.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static abstract class AbstractC0455a<T extends AbstractC0455a<T>> {

        /* renamed from: a  reason: collision with root package name */
        public List<com.meizu.cloud.pushsdk.c.a.b> f37724a = new LinkedList();

        /* renamed from: b  reason: collision with root package name */
        public long f37725b = System.currentTimeMillis();

        /* renamed from: c  reason: collision with root package name */
        public String f37726c = e.b();

        public abstract T a();

        public T a(long j) {
            this.f37725b = j;
            return a();
        }
    }

    public a(AbstractC0455a<?> abstractC0455a) {
        d.a(abstractC0455a.f37724a);
        d.a(abstractC0455a.f37726c);
        d.a(!abstractC0455a.f37726c.isEmpty(), "eventId cannot be empty");
        this.f37721a = abstractC0455a.f37724a;
        this.f37722b = abstractC0455a.f37725b;
        this.f37723c = abstractC0455a.f37726c;
    }

    public c a(c cVar) {
        cVar.a(NotificationStyle.EXPANDABLE_IMAGE_URL, c());
        cVar.a(TimeDisplaySetting.TIME_DISPLAY_SETTING, Long.toString(b()));
        return cVar;
    }

    public List<com.meizu.cloud.pushsdk.c.a.b> a() {
        return new ArrayList(this.f37721a);
    }

    public long b() {
        return this.f37722b;
    }

    public String c() {
        return this.f37723c;
    }
}
