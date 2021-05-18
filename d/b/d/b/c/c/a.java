package d.b.d.b.c.c;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.tbadk.core.data.SmallTailInfo;
import d.b.d.b.l;
import java.util.HashMap;
/* loaded from: classes6.dex */
public abstract class a<T> {

    /* renamed from: a  reason: collision with root package name */
    public final String f65838a;

    public a(String str) {
        this.f65838a = str;
    }

    public abstract ContentValues a(T t);

    public abstract HashMap<String, String> b();

    public void c(SQLiteDatabase sQLiteDatabase) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("CREATE TABLE ");
            sb.append(this.f65838a);
            sb.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT, ");
            HashMap<String, String> b2 = b();
            if (b2 != null) {
                for (String str : b2.keySet()) {
                    sb.append(str);
                    sb.append(" ");
                    sb.append(b2.get(str));
                    sb.append(",");
                }
                sb.delete(sb.length() - 1, sb.length());
                sb.append(SmallTailInfo.EMOTION_SUFFIX);
                sQLiteDatabase.execSQL(sb.toString());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void d(SQLiteDatabase sQLiteDatabase, T t) {
        if (sQLiteDatabase == null || t == null) {
            return;
        }
        try {
            sQLiteDatabase.insert(this.f65838a, null, a(t));
        } catch (Exception e2) {
            l.k.c(e2);
        }
    }
}
