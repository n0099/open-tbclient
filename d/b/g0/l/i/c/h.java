package d.b.g0.l.i.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class h extends b<d.b.g0.l.k.h> {
    @Override // d.b.g0.l.i.c.b
    public List<d.b.g0.l.k.h> e(Cursor cursor) {
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
    @Override // d.b.g0.l.i.c.b
    /* renamed from: f */
    public ContentValues c(d.b.g0.l.k.h hVar) {
        ContentValues a2 = super.a(hVar);
        a2.put("max_age", Long.valueOf(hVar.o));
        a2.put("token", hVar.p);
        a2.put("domains", hVar.q);
        a2.put(com.alipay.sdk.cons.b.f1858h, hVar.r);
        a2.put(DpStatConstants.KEY_APP_NAME, hVar.s);
        return a2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.l.i.c.b
    /* renamed from: g */
    public d.b.g0.l.k.h d(Cursor cursor) {
        if (cursor == null || cursor.getCount() <= 0 || !cursor.moveToFirst()) {
            return null;
        }
        return h(cursor);
    }

    public final d.b.g0.l.k.h h(Cursor cursor) {
        if (cursor != null) {
            int columnIndex = cursor.getColumnIndex("max_age");
            int columnIndex2 = cursor.getColumnIndex("token");
            int columnIndex3 = cursor.getColumnIndex("domains");
            int columnIndex4 = cursor.getColumnIndex(com.alipay.sdk.cons.b.f1858h);
            int columnIndex5 = cursor.getColumnIndex(DpStatConstants.KEY_APP_NAME);
            d.b.g0.l.k.h hVar = new d.b.g0.l.k.h();
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
