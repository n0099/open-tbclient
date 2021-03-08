package com.bytedance.tea.crash.b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.bytedance.tea.crash.g.j;
/* loaded from: classes6.dex */
public class a {
    private static volatile a pyj;
    private SQLiteDatabase c;
    private com.bytedance.tea.crash.b.b.b pyk;

    private a() {
    }

    public static a erm() {
        if (pyj == null) {
            synchronized (a.class) {
                if (pyj == null) {
                    pyj = new a();
                }
            }
        }
        return pyj;
    }

    public void a(Context context) {
        try {
            this.c = new b(context).getWritableDatabase();
        } catch (Throwable th) {
            j.b(th);
        }
        this.pyk = new com.bytedance.tea.crash.b.b.b();
    }

    public synchronized void a(com.bytedance.tea.crash.b.a.a aVar) {
        if (this.pyk != null) {
            this.pyk.a(this.c, aVar);
        }
    }

    public synchronized boolean a(String str) {
        return this.pyk != null ? this.pyk.c(this.c, str) : false;
    }
}
