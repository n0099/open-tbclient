package d.b.g0.l.i.c;

import android.content.ContentValues;
import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class e extends b<d.b.g0.l.k.d> {
    @Override // d.b.g0.l.i.c.b
    public List<d.b.g0.l.k.d> e(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        if (cursor == null || cursor.getCount() <= 0 || !cursor.moveToFirst()) {
            return arrayList;
        }
        do {
            d.b.g0.l.k.d dVar = new d.b.g0.l.k.d();
            if (b(cursor, dVar)) {
                arrayList.add(dVar);
            }
        } while (cursor.moveToNext());
        return arrayList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.l.i.c.b
    /* renamed from: f */
    public ContentValues c(d.b.g0.l.k.d dVar) {
        return a(dVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.l.i.c.b
    /* renamed from: g */
    public d.b.g0.l.k.d d(Cursor cursor) {
        if (cursor == null || cursor.getCount() <= 0 || !cursor.moveToFirst()) {
            return null;
        }
        d.b.g0.l.k.d dVar = new d.b.g0.l.k.d();
        if (b(cursor, dVar)) {
            return dVar;
        }
        return null;
    }
}
