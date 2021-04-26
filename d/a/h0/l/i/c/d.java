package d.a.h0.l.i.c;

import android.content.ContentValues;
import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class d extends b<d.a.h0.l.k.b> {
    @Override // d.a.h0.l.i.c.b
    public List<d.a.h0.l.k.b> e(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        if (cursor == null || cursor.getCount() <= 0 || !cursor.moveToFirst()) {
            return arrayList;
        }
        do {
            d.a.h0.l.k.b bVar = new d.a.h0.l.k.b();
            if (b(cursor, bVar)) {
                arrayList.add(bVar);
            }
        } while (cursor.moveToNext());
        return arrayList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.h0.l.i.c.b
    /* renamed from: f */
    public ContentValues c(d.a.h0.l.k.b bVar) {
        return a(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.h0.l.i.c.b
    /* renamed from: g */
    public d.a.h0.l.k.b d(Cursor cursor) {
        if (cursor == null || cursor.getCount() <= 0 || !cursor.moveToFirst()) {
            return null;
        }
        d.a.h0.l.k.b bVar = new d.a.h0.l.k.b();
        if (b(cursor, bVar)) {
            return bVar;
        }
        return null;
    }
}
