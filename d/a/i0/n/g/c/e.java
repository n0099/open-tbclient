package d.a.i0.n.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class e extends b<d.a.i0.n.h.d> {
    @Override // d.a.i0.n.g.c.b
    public List<d.a.i0.n.h.d> e(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        if (cursor == null || cursor.getCount() <= 0 || !cursor.moveToFirst()) {
            return arrayList;
        }
        do {
            d.a.i0.n.h.d dVar = new d.a.i0.n.h.d();
            if (b(cursor, dVar)) {
                arrayList.add(dVar);
            }
        } while (cursor.moveToNext());
        return arrayList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i0.n.g.c.b
    /* renamed from: f */
    public ContentValues c(d.a.i0.n.h.d dVar) {
        return a(dVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i0.n.g.c.b
    /* renamed from: g */
    public d.a.i0.n.h.d d(Cursor cursor) {
        if (cursor == null || cursor.getCount() <= 0 || !cursor.moveToFirst()) {
            return null;
        }
        d.a.i0.n.h.d dVar = new d.a.i0.n.h.d();
        if (b(cursor, dVar)) {
            return dVar;
        }
        return null;
    }
}
