package com.bytedance.sdk.openadsdk.g.c;

import android.content.Context;
import android.database.Cursor;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.g.c.c;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static volatile b f4776a;
    private Context b;
    private AtomicBoolean c = new AtomicBoolean(false);

    public static b a() {
        if (f4776a == null) {
            synchronized (b.class) {
                if (f4776a == null) {
                    f4776a = new b();
                }
            }
        }
        return f4776a;
    }

    private b() {
        b();
    }

    public void b() {
        if (!this.c.get() && p.a() != null) {
            this.b = p.a();
            this.c.set(true);
        }
    }

    public synchronized void c() {
        if (!this.c.get()) {
            b();
        } else {
            try {
                com.bytedance.sdk.openadsdk.multipro.a.a.a(this.b, "logstats", "retry >=?", new String[]{String.valueOf(5)});
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
            Cursor a2 = com.bytedance.sdk.openadsdk.multipro.a.a.a(this.b, "logstats", new String[]{"id", "value"}, "retry <?", new String[]{String.valueOf(5)}, null, null, null);
            if (a2 != null) {
                while (a2.moveToNext()) {
                    try {
                        try {
                            linkedList2.add(new c.a(a2.getString(a2.getColumnIndex("id")), new JSONObject(a2.getString(a2.getColumnIndex("value")))));
                        } catch (Exception e) {
                        }
                    } catch (Exception e2) {
                        if (a2 != null) {
                            a2.close();
                        }
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
