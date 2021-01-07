package com.xiaomi.push;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.xiaomi.push.cb;
/* loaded from: classes6.dex */
class cd implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f14209a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ cb.a f241a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(cb.a aVar, Context context) {
        this.f241a = aVar;
        this.f14209a = context;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, IGET, IGET, INVOKE, IGET, IGET, INVOKE, INVOKE, MOVE_EXCEPTION, IGET, IGET, INVOKE, IGET, IGET, INVOKE, IF, IGET, IGET, IGET, IGET, INVOKE, IGET, IGET, INVOKE, INVOKE, MOVE_EXCEPTION, IGET, IGET, INVOKE, IGET, IGET, INVOKE, IF, IGET, IGET, INVOKE, IGET, IGET, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    @Override // java.lang.Runnable
    public void run() {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                sQLiteDatabase = this.f241a.a();
                if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                    sQLiteDatabase.beginTransaction();
                    this.f241a.a(this.f14209a, sQLiteDatabase);
                    sQLiteDatabase.setTransactionSuccessful();
                }
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Exception e) {
                        com.xiaomi.channel.commonutils.logger.b.a(e);
                    }
                }
                if (this.f241a.f232a != null) {
                    this.f241a.f232a.close();
                }
                this.f241a.a(this.f14209a);
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Exception e3) {
                        com.xiaomi.channel.commonutils.logger.b.a(e3);
                        this.f241a.a(this.f14209a);
                    }
                }
                if (this.f241a.f232a != null) {
                    this.f241a.f232a.close();
                }
                this.f241a.a(this.f14209a);
            }
        } catch (Throwable th) {
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Exception e4) {
                    com.xiaomi.channel.commonutils.logger.b.a(e4);
                    this.f241a.a(this.f14209a);
                    throw th;
                }
            }
            if (this.f241a.f232a != null) {
                this.f241a.f232a.close();
            }
            this.f241a.a(this.f14209a);
            throw th;
        }
    }
}
