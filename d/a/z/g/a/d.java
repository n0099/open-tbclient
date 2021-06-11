package d.a.z.g.a;

import android.database.sqlite.SQLiteDatabase;
/* loaded from: classes2.dex */
public abstract class d {

    /* renamed from: a  reason: collision with root package name */
    public boolean f68644a = false;

    public boolean a() {
        return this.f68644a;
    }

    public abstract boolean b(SQLiteDatabase sQLiteDatabase);

    public void c(SQLiteDatabase sQLiteDatabase) {
        this.f68644a = false;
        try {
            sQLiteDatabase.beginTransaction();
            if (b(sQLiteDatabase)) {
                sQLiteDatabase.setTransactionSuccessful();
                this.f68644a = true;
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            try {
                sQLiteDatabase.endTransaction();
            } catch (Exception unused2) {
            }
            throw th;
        }
        try {
            sQLiteDatabase.endTransaction();
        } catch (Exception unused3) {
        }
    }
}
