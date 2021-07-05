package d.a.c.a.k;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
/* loaded from: classes8.dex */
public interface a {

    /* renamed from: d.a.c.a.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0582a {
        void a(SQLiteDatabase sQLiteDatabase);
    }

    boolean dropDatabase(Context context);

    SQLiteDatabase getWritableDatabase();

    void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3);

    void setOnCreateCallback(InterfaceC0582a interfaceC0582a);
}
