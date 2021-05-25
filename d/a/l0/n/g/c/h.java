package d.a.l0.n.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class h extends b<d.a.l0.n.h.h> {
    @Override // d.a.l0.n.g.c.b
    public List<d.a.l0.n.h.h> e(Cursor cursor) {
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
    public ContentValues c(d.a.l0.n.h.h hVar) {
        ContentValues a2 = super.a(hVar);
        a2.put("max_age", Long.valueOf(hVar.o));
        a2.put("token", hVar.p);
        a2.put("domains", hVar.q);
        a2.put("app_key", hVar.r);
        a2.put("app_name", hVar.s);
        return a2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.l0.n.g.c.b
    /* renamed from: g */
    public d.a.l0.n.h.h d(Cursor cursor) {
        if (cursor == null || cursor.getCount() <= 0 || !cursor.moveToFirst()) {
            return null;
        }
        return h(cursor);
    }

    public final d.a.l0.n.h.h h(Cursor cursor) {
        if (cursor != null) {
            int columnIndex = cursor.getColumnIndex("max_age");
            int columnIndex2 = cursor.getColumnIndex("token");
            int columnIndex3 = cursor.getColumnIndex("domains");
            int columnIndex4 = cursor.getColumnIndex("app_key");
            int columnIndex5 = cursor.getColumnIndex("app_name");
            d.a.l0.n.h.h hVar = new d.a.l0.n.h.h();
            if (b(cursor, hVar)) {
                hVar.o = cursor.getLong(columnIndex);
                hVar.p = cursor.getString(columnIndex2);
                hVar.q = cursor.getString(columnIndex3);
                hVar.r = cursor.getString(columnIndex4);
                hVar.s = cursor.getString(columnIndex5);
                return hVar;
            }
            return null;
        }
        return null;
    }
}
