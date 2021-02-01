package com.bytedance.sdk.openadsdk.h.b;

import android.content.Context;
import android.database.Cursor;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.h.b.c;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static volatile b f7179a;

    /* renamed from: b  reason: collision with root package name */
    private Context f7180b;
    private AtomicBoolean c = new AtomicBoolean(false);

    public static b a() {
        if (f7179a == null) {
            synchronized (b.class) {
                if (f7179a == null) {
                    f7179a = new b();
                }
            }
        }
        return f7179a;
    }

    private b() {
        b();
    }

    public void b() {
        if (!this.c.get() && p.a() != null) {
            this.f7180b = p.a();
            this.c.set(true);
        }
    }

    public synchronized void c() {
        if (!this.c.get()) {
            b();
        } else {
            try {
                com.bytedance.sdk.openadsdk.multipro.a.a.a(this.f7180b, "logstats", "retry >=?", new String[]{String.valueOf(5)});
            } catch (Throwable th) {
            }
        }
    }

    public synchronized List<c.a> d() {
        LinkedList linkedList;
        LinkedList linkedList2 = new LinkedList();
        if (!this.c.get()) {
            b();
            linkedList = linkedList2;
        } else {
            Cursor a2 = com.bytedance.sdk.openadsdk.multipro.a.a.a(this.f7180b, "logstats", new String[]{"id", "value"}, "retry <?", new String[]{String.valueOf(5)}, null, null, null);
            if (a2 != null) {
                while (a2.moveToNext()) {
                    try {
                        linkedList2.add(new c.a(a2.getString(a2.getColumnIndex("id")), new JSONObject(a2.getString(a2.getColumnIndex("value")))));
                    } catch (Exception e) {
                    }
                }
                if (a2 != null) {
                    a2.close();
                }
            }
            linkedList = linkedList2;
        }
        return linkedList;
    }
}
