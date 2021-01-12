package com.bytedance.tea.crash.b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.bytedance.tea.crash.g.j;
/* loaded from: classes4.dex */
public class a {
    private static volatile a plq;
    private SQLiteDatabase c;
    private com.bytedance.tea.crash.b.b.b plr;

    private a() {
    }

    public static a eoD() {
        if (plq == null) {
            synchronized (a.class) {
                if (plq == null) {
                    plq = new a();
                }
            }
        }
        return plq;
    }

    public void a(Context context) {
        try {
            this.c = new b(context).getWritableDatabase();
        } catch (Throwable th) {
            j.b(th);
        }
        this.plr = new com.bytedance.tea.crash.b.b.b();
    }

    public synchronized void a(com.bytedance.tea.crash.b.a.a aVar) {
        if (this.plr != null) {
            this.plr.a(this.c, aVar);
        }
    }

    public synchronized boolean a(String str) {
        return this.plr != null ? this.plr.c(this.c, str) : false;
    }
}
