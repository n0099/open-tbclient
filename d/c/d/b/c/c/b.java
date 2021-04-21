package d.c.d.b.c.c;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.tbadk.core.data.SmallTailInfo;
import d.c.d.b.l;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class b extends a<d.c.d.b.c.a.a> {
    public b() {
        super("duplicatelog");
    }

    @Override // d.c.d.b.c.c.a
    public HashMap<String, String> b() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("path", "TEXT");
        hashMap.put("insert_time", "INTEGER");
        hashMap.put("ext1", "TEXT");
        hashMap.put("ext2", "TEXT");
        return hashMap;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.c.d.b.c.c.a
    /* renamed from: e */
    public ContentValues a(d.c.d.b.c.a.a aVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("path", aVar.f66744a);
        contentValues.put("insert_time", Long.valueOf(aVar.f66745b));
        return contentValues;
    }

    public void f(SQLiteDatabase sQLiteDatabase, d.c.d.b.c.a.a aVar) {
        if (aVar == null || g(sQLiteDatabase, aVar.f66744a)) {
            return;
        }
        super.d(sQLiteDatabase, aVar);
        try {
            sQLiteDatabase.execSQL("delete from " + this.f66749a + " where _id in (select _id from " + this.f66749a + " order by insert_time desc limit 1000 offset 500" + SmallTailInfo.EMOTION_SUFFIX);
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
        int i;
        Cursor query;
        if (sQLiteDatabase == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            query = sQLiteDatabase.query(this.f66749a, null, "path=?", new String[]{str}, null, null, null);
            i = query.getCount();
        } catch (Exception e2) {
            e = e2;
            i = 0;
        }
        try {
            query.close();
        } catch (Exception e3) {
            e = e3;
            l.k.c(e);
            if (i <= 0) {
            }
        }
        return i <= 0;
    }
}
