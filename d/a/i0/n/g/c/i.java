package d.a.i0.n.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import androidx.annotation.NonNull;
import com.baidu.swan.pms.utils.AbiType;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class i extends b<d.a.i0.n.h.i> implements Object {
    public static int f(@NonNull Cursor cursor, @NonNull String str) {
        return cursor.getColumnIndex(str);
    }

    @Override // d.a.i0.n.g.c.b
    public List<d.a.i0.n.h.i> e(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        if (cursor == null || cursor.getCount() <= 0 || !cursor.moveToFirst()) {
            return arrayList;
        }
        do {
            arrayList.add(i(cursor));
        } while (cursor.moveToNext());
        return arrayList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i0.n.g.c.b
    /* renamed from: g */
    public ContentValues c(d.a.i0.n.h.i iVar) {
        ContentValues a2 = super.a(iVar);
        a2.put("max_age", Long.valueOf(iVar.o));
        a2.put("abi", iVar.q.id);
        a2.put("lib_name", iVar.p);
        return a2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i0.n.g.c.b
    /* renamed from: h */
    public d.a.i0.n.h.i d(Cursor cursor) {
        if (cursor == null || cursor.getCount() <= 0 || !cursor.moveToFirst()) {
            return null;
        }
        return i(cursor);
    }

    public final d.a.i0.n.h.i i(Cursor cursor) {
        if (cursor != null) {
            d.a.i0.n.h.i iVar = new d.a.i0.n.h.i();
            if (b(cursor, iVar)) {
                iVar.o = cursor.getLong(f(cursor, "max_age"));
                iVar.q = AbiType.findById(cursor.getString(f(cursor, "abi")), null);
                iVar.p = cursor.getString(f(cursor, "lib_name"));
                return iVar;
            }
        }
        return null;
    }
}
