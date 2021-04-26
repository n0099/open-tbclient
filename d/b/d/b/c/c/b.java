package d.b.d.b.c.c;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.tbadk.core.data.SmallTailInfo;
import d.b.d.b.l;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class b extends a<d.b.d.b.c.a.a> {
    public b() {
        super("duplicatelog");
    }

    @Override // d.b.d.b.c.c.a
    public HashMap<String, String> b() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("path", "TEXT");
        hashMap.put("insert_time", "INTEGER");
        hashMap.put("ext1", "TEXT");
        hashMap.put("ext2", "TEXT");
        return hashMap;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.d.b.c.c.a
    /* renamed from: e */
    public ContentValues a(d.b.d.b.c.a.a aVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("path", aVar.f65147a);
        contentValues.put("insert_time", Long.valueOf(aVar.f65148b));
        return contentValues;
    }

    public void f(SQLiteDatabase sQLiteDatabase, d.b.d.b.c.a.a aVar) {
        if (aVar == null || g(sQLiteDatabase, aVar.f65147a)) {
            return;
        }
        super.d(sQLiteDatabase, aVar);
        try {
            sQLiteDatabase.execSQL("delete from " + this.f65152a + " where _id in (select _id from " + this.f65152a + " order by insert_time desc limit 1000 offset 500" + SmallTailInfo.EMOTION_SUFFIX);
        } catch (Exception e2) {
            l.k.c(e2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x002d A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean g(SQLiteDatabase sQLiteDatabase, String str) {
        int i2;
        Cursor query;
        if (sQLiteDatabase == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            query = sQLiteDatabase.query(this.f65152a, null, "path=?", new String[]{str}, null, null, null);
            i2 = query.getCount();
        } catch (Exception e2) {
            e = e2;
            i2 = 0;
        }
        try {
            query.close();
        } catch (Exception e3) {
            e = e3;
            l.k.c(e);
            if (i2 <= 0) {
            }
        }
        return i2 <= 0;
    }
}
