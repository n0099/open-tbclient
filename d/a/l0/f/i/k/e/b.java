package d.a.l0.f.i.k.e;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/* loaded from: classes3.dex */
public class b extends SQLiteOpenHelper {
    public b(Context context) {
        super(context, "swan_ad_download.db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("create table if not exists ad_download(_id varchar(500) PRIMARY KEY NOT NULL,createAt long NOT NULL,uri varchar(255) NOT NULL,packagename varchar(255),path varchar(255) NOT NULL,size long NOT NULL,progress long NOT NULL,status integer NOT NULL);");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
    }
}
