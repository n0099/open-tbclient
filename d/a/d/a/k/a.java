package d.a.d.a.k;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
/* loaded from: classes7.dex */
public interface a {

    /* renamed from: d.a.d.a.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0552a {
        void a(SQLiteDatabase sQLiteDatabase);
    }

    boolean dropDatabase(Context context);

    SQLiteDatabase getWritableDatabase();

    void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3);

    void setOnCreateCallback(InterfaceC0552a interfaceC0552a);
}
