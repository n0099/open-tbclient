package d.a.i0.n.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class f extends b<d.a.i0.n.h.f> {
    @Override // d.a.i0.n.g.c.b
    public List<d.a.i0.n.h.f> e(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        if (cursor == null || cursor.getCount() <= 0 || !cursor.moveToFirst()) {
            return arrayList;
        }
        do {
            d.a.i0.n.h.f fVar = new d.a.i0.n.h.f();
            if (b(cursor, fVar)) {
                arrayList.add(fVar);
            }
        } while (cursor.moveToNext());
        return arrayList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i0.n.g.c.b
    /* renamed from: f */
    public ContentValues c(d.a.i0.n.h.f fVar) {
        ContentValues a2 = super.a(fVar);
        a2.put("pkg_type", Integer.valueOf(fVar.o));
        return a2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i0.n.g.c.b
    /* renamed from: g */
    public d.a.i0.n.h.f d(Cursor cursor) {
        if (cursor == null || cursor.getCount() <= 0 || !cursor.moveToFirst()) {
            return null;
        }
        d.a.i0.n.h.f fVar = new d.a.i0.n.h.f();
        if (b(cursor, fVar)) {
            return fVar;
        }
        return null;
    }
}
