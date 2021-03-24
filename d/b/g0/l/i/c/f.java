package d.b.g0.l.i.c;

import android.content.ContentValues;
import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class f extends b<d.b.g0.l.k.f> {
    @Override // d.b.g0.l.i.c.b
    public List<d.b.g0.l.k.f> e(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        if (cursor == null || cursor.getCount() <= 0 || !cursor.moveToFirst()) {
            return arrayList;
        }
        do {
            d.b.g0.l.k.f fVar = new d.b.g0.l.k.f();
            if (b(cursor, fVar)) {
                arrayList.add(fVar);
            }
        } while (cursor.moveToNext());
        return arrayList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.l.i.c.b
    /* renamed from: f */
    public ContentValues c(d.b.g0.l.k.f fVar) {
        ContentValues a2 = super.a(fVar);
        a2.put("pkg_type", Integer.valueOf(fVar.o));
        return a2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.l.i.c.b
    /* renamed from: g */
    public d.b.g0.l.k.f d(Cursor cursor) {
        if (cursor == null || cursor.getCount() <= 0 || !cursor.moveToFirst()) {
            return null;
        }
        d.b.g0.l.k.f fVar = new d.b.g0.l.k.f();
        if (b(cursor, fVar)) {
            return fVar;
        }
        return null;
    }
}
