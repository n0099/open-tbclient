package com.xiaomi.push;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.xiaomi.push.cb;
/* loaded from: classes5.dex */
class cd implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f8299a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ cb.a f161a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(cb.a aVar, Context context) {
        this.f161a = aVar;
        this.f8299a = context;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, IGET, IGET, INVOKE, IGET, IGET, INVOKE, INVOKE, MOVE_EXCEPTION, IGET, IGET, INVOKE, IGET, IGET, INVOKE, IF, IGET, IGET, IGET, IGET, INVOKE, IGET, IGET, INVOKE, INVOKE, MOVE_EXCEPTION, IGET, IGET, INVOKE, IGET, IGET, INVOKE, IF, IGET, IGET, INVOKE, IGET, IGET, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    @Override // java.lang.Runnable
    public void run() {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                sQLiteDatabase = this.f161a.a();
                if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                    sQLiteDatabase.beginTransaction();
                    this.f161a.a(this.f8299a, sQLiteDatabase);
                    sQLiteDatabase.setTransactionSuccessful();
                }
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Exception e) {
                        com.xiaomi.channel.commonutils.logger.b.a(e);
                    }
                }
                if (this.f161a.f152a != null) {
                    this.f161a.f152a.close();
                }
                this.f161a.a(this.f8299a);
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Exception e3) {
                        com.xiaomi.channel.commonutils.logger.b.a(e3);
                        this.f161a.a(this.f8299a);
                    }
                }
                if (this.f161a.f152a != null) {
                    this.f161a.f152a.close();
                }
                this.f161a.a(this.f8299a);
            }
        } catch (Throwable th) {
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Exception e4) {
                    com.xiaomi.channel.commonutils.logger.b.a(e4);
                    this.f161a.a(this.f8299a);
                    throw th;
                }
            }
            if (this.f161a.f152a != null) {
                this.f161a.f152a.close();
            }
            this.f161a.a(this.f8299a);
            throw th;
        }
    }
}
