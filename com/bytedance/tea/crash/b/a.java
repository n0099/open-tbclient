package com.bytedance.tea.crash.b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.bytedance.tea.crash.g.j;
/* loaded from: classes6.dex */
public class a {
    private static volatile a pwg;
    private SQLiteDatabase c;
    private com.bytedance.tea.crash.b.b.b pwh;

    private a() {
    }

    public static a erd() {
        if (pwg == null) {
            synchronized (a.class) {
                if (pwg == null) {
                    pwg = new a();
                }
            }
        }
        return pwg;
    }

    public void a(Context context) {
        try {
            this.c = new b(context).getWritableDatabase();
        } catch (Throwable th) {
            j.b(th);
        }
        this.pwh = new com.bytedance.tea.crash.b.b.b();
    }

    public synchronized void a(com.bytedance.tea.crash.b.a.a aVar) {
        if (this.pwh != null) {
            this.pwh.a(this.c, aVar);
        }
    }

    public synchronized boolean a(String str) {
        return this.pwh != null ? this.pwh.c(this.c, str) : false;
    }
}
