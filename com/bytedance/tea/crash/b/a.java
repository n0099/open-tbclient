package com.bytedance.tea.crash.b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.bytedance.tea.crash.g.j;
/* loaded from: classes4.dex */
public class a {
    private static volatile a plr;
    private SQLiteDatabase c;
    private com.bytedance.tea.crash.b.b.b pls;

    private a() {
    }

    public static a eoD() {
        if (plr == null) {
            synchronized (a.class) {
                if (plr == null) {
                    plr = new a();
                }
            }
        }
        return plr;
    }

    public void a(Context context) {
        try {
            this.c = new b(context).getWritableDatabase();
        } catch (Throwable th) {
            j.b(th);
        }
        this.pls = new com.bytedance.tea.crash.b.b.b();
    }

    public synchronized void a(com.bytedance.tea.crash.b.a.a aVar) {
        if (this.pls != null) {
            this.pls.a(this.c, aVar);
        }
    }

    public synchronized boolean a(String str) {
        return this.pls != null ? this.pls.c(this.c, str) : false;
    }
}
