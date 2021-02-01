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

    /* renamed from: a  reason: collision with root package name */
    protected final List<com.meizu.cloud.pushsdk.c.a.b> f11276a;

    /* renamed from: b  reason: collision with root package name */
    protected final long f11277b;
    protected final String c;

    /* renamed from: com.meizu.cloud.pushsdk.c.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static abstract class AbstractC1169a<T extends AbstractC1169a<T>> {

        /* renamed from: a  reason: collision with root package name */
        private List<com.meizu.cloud.pushsdk.c.a.b> f11278a = new LinkedList();

        /* renamed from: b  reason: collision with root package name */
        private long f11279b = System.currentTimeMillis();
        private String c = e.b();

        /* JADX INFO: Access modifiers changed from: protected */
        public abstract T a();

        public T a(long j) {
            this.f11279b = j;
            return a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a(AbstractC1169a<?> abstractC1169a) {
        d.a(((AbstractC1169a) abstractC1169a).f11278a);
        d.a(((AbstractC1169a) abstractC1169a).c);
        d.a(!((AbstractC1169a) abstractC1169a).c.isEmpty(), "eventId cannot be empty");
        this.f11276a = ((AbstractC1169a) abstractC1169a).f11278a;
        this.f11277b = ((AbstractC1169a) abstractC1169a).f11279b;
        this.c = ((AbstractC1169a) abstractC1169a).c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c a(c cVar) {
        cVar.a(NotificationStyle.EXPANDABLE_IMAGE_URL, c());
        cVar.a(TimeDisplaySetting.TIME_DISPLAY_SETTING, Long.toString(b()));
        return cVar;
    }

    public List<com.meizu.cloud.pushsdk.c.a.b> a() {
        return new ArrayList(this.f11276a);
    }

    public long b() {
        return this.f11277b;
    }

    public String c() {
        return this.c;
    }
}
