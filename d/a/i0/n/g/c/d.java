package d.a.i0.n.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class d extends b<d.a.i0.n.h.b> {
    @Override // d.a.i0.n.g.c.b
    public List<d.a.i0.n.h.b> e(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        if (cursor == null || cursor.getCount() <= 0 || !cursor.moveToFirst()) {
            return arrayList;
        }
        do {
            d.a.i0.n.h.b bVar = new d.a.i0.n.h.b();
            if (b(cursor, bVar)) {
                arrayList.add(bVar);
            }
        } while (cursor.moveToNext());
        return arrayList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i0.n.g.c.b
    /* renamed from: f */
    public ContentValues c(d.a.i0.n.h.b bVar) {
        return a(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i0.n.g.c.b
    /* renamed from: g */
    public d.a.i0.n.h.b d(Cursor cursor) {
        if (cursor == null || cursor.getCount() <= 0 || !cursor.moveToFirst()) {
            return null;
        }
        d.a.i0.n.h.b bVar = new d.a.i0.n.h.b();
        if (b(cursor, bVar)) {
            return bVar;
        }
        return null;
    }
}
