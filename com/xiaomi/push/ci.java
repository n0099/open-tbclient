package com.xiaomi.push;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.xiaomi.push.cg;
/* loaded from: classes7.dex */
public class ci implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f40609a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ cg.a f184a;

    public ci(cg.a aVar, Context context) {
        this.f184a = aVar;
        this.f40609a = context;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, IGET, IGET, INVOKE] complete} */
    @Override // java.lang.Runnable
    public void run() {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                sQLiteDatabase = this.f184a.a();
                if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                    sQLiteDatabase.beginTransaction();
                    this.f184a.a(this.f40609a, sQLiteDatabase);
                    sQLiteDatabase.setTransactionSuccessful();
                }
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Exception e2) {
                        e = e2;
                        com.xiaomi.channel.commonutils.logger.b.a(e);
                        this.f184a.a(this.f40609a);
                    }
                }
                if (this.f184a.f175a != null) {
                    this.f184a.f175a.close();
                }
            } catch (Throwable th) {
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Exception e3) {
                        com.xiaomi.channel.commonutils.logger.b.a(e3);
                        this.f184a.a(this.f40609a);
                        throw th;
                    }
                }
                if (this.f184a.f175a != null) {
                    this.f184a.f175a.close();
                }
                this.f184a.a(this.f40609a);
                throw th;
            }
        } catch (Exception e4) {
            com.xiaomi.channel.commonutils.logger.b.a(e4);
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Exception e5) {
                    e = e5;
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    this.f184a.a(this.f40609a);
                }
            }
            if (this.f184a.f175a != null) {
                this.f184a.f175a.close();
            }
        }
        this.f184a.a(this.f40609a);
    }
}
