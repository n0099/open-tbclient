package com.bytedance.tea.crash.b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.bytedance.tea.crash.g.j;
/* loaded from: classes4.dex */
public class a {
    private static volatile a ppV;
    private SQLiteDatabase c;
    private com.bytedance.tea.crash.b.b.b ppW;

    private a() {
    }

    public static a esw() {
        if (ppV == null) {
            synchronized (a.class) {
                if (ppV == null) {
                    ppV = new a();
                }
            }
        }
        return ppV;
    }

    public void a(Context context) {
        try {
            this.c = new b(context).getWritableDatabase();
        } catch (Throwable th) {
            j.b(th);
        }
        this.ppW = new com.bytedance.tea.crash.b.b.b();
    }

    public synchronized void a(com.bytedance.tea.crash.b.a.a aVar) {
        if (this.ppW != null) {
            this.ppW.a(this.c, aVar);
        }
    }

    public synchronized boolean a(String str) {
        return this.ppW != null ? this.ppW.c(this.c, str) : false;
    }
}
