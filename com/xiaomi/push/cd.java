package com.xiaomi.push;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.xiaomi.push.cb;
/* loaded from: classes12.dex */
class cd implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f4834a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ cb.a f159a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(cb.a aVar, Context context) {
        this.f159a = aVar;
        this.f4834a = context;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, IGET, IGET, INVOKE, IGET, IGET, INVOKE, INVOKE, MOVE_EXCEPTION, IGET, IGET, INVOKE, IGET, IGET, INVOKE, IF, IGET, IGET, IGET, IGET, INVOKE, IGET, IGET, INVOKE, INVOKE, MOVE_EXCEPTION, IGET, IGET, INVOKE, IGET, IGET, INVOKE, IF, IGET, IGET, INVOKE, IGET, IGET, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    @Override // java.lang.Runnable
    public void run() {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                sQLiteDatabase = this.f159a.a();
                if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                    sQLiteDatabase.beginTransaction();
                    this.f159a.a(this.f4834a, sQLiteDatabase);
                    sQLiteDatabase.setTransactionSuccessful();
                }
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Exception e) {
                        com.xiaomi.channel.commonutils.logger.b.a(e);
                    }
                }
                if (this.f159a.f150a != null) {
                    this.f159a.f150a.close();
                }
                this.f159a.a(this.f4834a);
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Exception e3) {
                        com.xiaomi.channel.commonutils.logger.b.a(e3);
                        this.f159a.a(this.f4834a);
                    }
                }
                if (this.f159a.f150a != null) {
                    this.f159a.f150a.close();
                }
                this.f159a.a(this.f4834a);
            }
        } catch (Throwable th) {
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Exception e4) {
                    com.xiaomi.channel.commonutils.logger.b.a(e4);
                    this.f159a.a(this.f4834a);
                    throw th;
                }
            }
            if (this.f159a.f150a != null) {
                this.f159a.f150a.close();
            }
            this.f159a.a(this.f4834a);
            throw th;
        }
    }
}
