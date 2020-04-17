package com.xiaomi.push;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.xiaomi.push.bw;
/* loaded from: classes8.dex */
class by implements Runnable {
    final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ bw.a f174a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(bw.a aVar, Context context) {
        this.f174a = aVar;
        this.a = context;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, IGET, IGET, INVOKE, IGET, IGET, INVOKE, INVOKE, MOVE_EXCEPTION, IGET, IGET, INVOKE, IGET, IGET, INVOKE, IF, IGET, IGET, IGET, IGET, INVOKE, IGET, IGET, INVOKE, INVOKE, MOVE_EXCEPTION, IGET, IGET, INVOKE, IGET, IGET, INVOKE, IF, IGET, IGET, INVOKE, IGET, IGET, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    @Override // java.lang.Runnable
    public void run() {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                sQLiteDatabase = this.f174a.a();
                if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                    sQLiteDatabase.beginTransaction();
                    this.f174a.a(this.a, sQLiteDatabase);
                    sQLiteDatabase.setTransactionSuccessful();
                }
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Exception e) {
                        com.xiaomi.channel.commonutils.logger.b.a(e);
                    }
                }
                if (this.f174a.f165a != null) {
                    this.f174a.f165a.close();
                }
                this.f174a.a(this.a);
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Exception e3) {
                        com.xiaomi.channel.commonutils.logger.b.a(e3);
                        this.f174a.a(this.a);
                    }
                }
                if (this.f174a.f165a != null) {
                    this.f174a.f165a.close();
                }
                this.f174a.a(this.a);
            }
        } catch (Throwable th) {
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Exception e4) {
                    com.xiaomi.channel.commonutils.logger.b.a(e4);
                    this.f174a.a(this.a);
                    throw th;
                }
            }
            if (this.f174a.f165a != null) {
                this.f174a.f165a.close();
            }
            this.f174a.a(this.a);
            throw th;
        }
    }
}
