package com.xiaomi.push;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.xiaomi.push.ci;
/* loaded from: classes10.dex */
public class ck implements Runnable {
    public final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ ci.a f180a;

    public ck(ci.a aVar, Context context) {
        this.f180a = aVar;
        this.a = context;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, IGET, IGET, INVOKE] complete} */
    @Override // java.lang.Runnable
    public void run() {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                sQLiteDatabase = this.f180a.a();
                if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                    sQLiteDatabase.beginTransaction();
                    this.f180a.a(this.a, sQLiteDatabase);
                    sQLiteDatabase.setTransactionSuccessful();
                }
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Exception e) {
                        e = e;
                        com.xiaomi.channel.commonutils.logger.b.a(e);
                        this.f180a.a(this.a);
                    }
                }
                if (this.f180a.f171a != null) {
                    this.f180a.f171a.close();
                }
            } catch (Throwable th) {
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Exception e2) {
                        com.xiaomi.channel.commonutils.logger.b.a(e2);
                        this.f180a.a(this.a);
                        throw th;
                    }
                }
                if (this.f180a.f171a != null) {
                    this.f180a.f171a.close();
                }
                this.f180a.a(this.a);
                throw th;
            }
        } catch (Exception e3) {
            com.xiaomi.channel.commonutils.logger.b.a(e3);
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Exception e4) {
                    e = e4;
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    this.f180a.a(this.a);
                }
            }
            if (this.f180a.f171a != null) {
                this.f180a.f171a.close();
            }
        }
        this.f180a.a(this.a);
    }
}
