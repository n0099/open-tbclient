package com.bytedance.sdk.openadsdk.h.c;

import android.content.Context;
import android.database.Cursor;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.h.c.c;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f29120a;

    /* renamed from: b  reason: collision with root package name */
    public Context f29121b;

    /* renamed from: c  reason: collision with root package name */
    public AtomicBoolean f29122c = new AtomicBoolean(false);

    public b() {
        b();
    }

    public static b a() {
        if (f29120a == null) {
            synchronized (b.class) {
                if (f29120a == null) {
                    f29120a = new b();
                }
            }
        }
        return f29120a;
    }

    public void b() {
        if (this.f29122c.get() || p.a() == null) {
            return;
        }
        this.f29121b = p.a();
        this.f29122c.set(true);
    }

    public synchronized void c() {
        if (!this.f29122c.get()) {
            b();
        } else {
            try {
                com.bytedance.sdk.openadsdk.multipro.a.a.a(this.f29121b, "logstats", "retry >=?", new String[]{String.valueOf(5)});
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x005d, code lost:
        if (r1 != null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x005f, code lost:
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x006a, code lost:
        if (r1 != null) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized List<c.a> d() {
        LinkedList linkedList = new LinkedList();
        if (!this.f29122c.get()) {
            b();
            return linkedList;
        }
        Cursor a2 = com.bytedance.sdk.openadsdk.multipro.a.a.a(this.f29121b, "logstats", new String[]{"id", "value"}, "retry <?", new String[]{String.valueOf(5)}, null, null, null);
        if (a2 != null) {
            while (a2.moveToNext()) {
                try {
                    try {
                        linkedList.add(new c.a(a2.getString(a2.getColumnIndex("id")), new JSONObject(a2.getString(a2.getColumnIndex("value")))));
                    } catch (Exception unused) {
                    }
                } catch (Exception unused2) {
                }
            }
        }
        return linkedList;
    }
}
