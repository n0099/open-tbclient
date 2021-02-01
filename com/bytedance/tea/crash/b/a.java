package com.bytedance.tea.crash.b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.bytedance.tea.crash.g.j;
/* loaded from: classes6.dex */
public class a {
    private static volatile a pvG;
    private SQLiteDatabase c;
    private com.bytedance.tea.crash.b.b.b pvH;

    private a() {
    }

    public static a eqV() {
        if (pvG == null) {
            synchronized (a.class) {
                if (pvG == null) {
                    pvG = new a();
                }
            }
        }
        return pvG;
    }

    public void a(Context context) {
        try {
            this.c = new b(context).getWritableDatabase();
        } catch (Throwable th) {
            j.b(th);
        }
        this.pvH = new com.bytedance.tea.crash.b.b.b();
    }

    public synchronized void a(com.bytedance.tea.crash.b.a.a aVar) {
        if (this.pvH != null) {
            this.pvH.a(this.c, aVar);
        }
    }

    public synchronized boolean a(String str) {
        return this.pvH != null ? this.pvH.c(this.c, str) : false;
    }
}
