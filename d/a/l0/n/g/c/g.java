package d.a.l0.n.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class g extends b<d.a.l0.n.h.g> {
    @Override // d.a.l0.n.g.c.b
    public List<d.a.l0.n.h.g> e(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        if (cursor == null || cursor.getCount() <= 0 || !cursor.moveToFirst()) {
            return arrayList;
        }
        do {
            arrayList.add(h(cursor));
        } while (cursor.moveToNext());
        return arrayList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.l0.n.g.c.b
    /* renamed from: f */
    public ContentValues c(d.a.l0.n.h.g gVar) {
        ContentValues a2 = super.a(gVar);
        a2.put("independent", Integer.valueOf(gVar.r ? 1 : 0));
        a2.put("sub_pkg_name", gVar.p);
        a2.put(Constants.APP_ID, gVar.o);
        return a2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.l0.n.g.c.b
    /* renamed from: g */
    public d.a.l0.n.h.g d(Cursor cursor) {
        if (cursor == null || cursor.getCount() <= 0 || !cursor.moveToFirst()) {
            return null;
        }
        return h(cursor);
    }

    public final d.a.l0.n.h.g h(Cursor cursor) {
        if (cursor != null) {
            int columnIndex = cursor.getColumnIndex("independent");
            int columnIndex2 = cursor.getColumnIndex("sub_pkg_name");
            int columnIndex3 = cursor.getColumnIndex(Constants.APP_ID);
            d.a.l0.n.h.g gVar = new d.a.l0.n.h.g();
            if (b(cursor, gVar)) {
                gVar.r = cursor.getInt(columnIndex) == 1;
                gVar.p = cursor.getString(columnIndex2);
                gVar.o = cursor.getString(columnIndex3);
                return gVar;
            }
            return null;
        }
        return null;
    }
}
