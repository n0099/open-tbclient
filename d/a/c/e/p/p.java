package d.a.c.e.p;

import android.database.Cursor;
import com.baidu.adp.lib.util.BdLog;
import d.a.c.e.d.l;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class p {

    /* loaded from: classes.dex */
    public static class b implements Comparator<l.b<?>> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(l.b<?> bVar, l.b<?> bVar2) {
            long j = bVar.f38879c;
            long j2 = bVar2.f38879c;
            if (j == j2) {
                return 0;
            }
            return j > j2 ? -1 : 1;
        }
    }

    /* JADX WARN: Type inference failed for: r3v10, types: [T, byte[]] */
    public static List<l.b<byte[]>> a(d.a.c.e.d.l<byte[]> lVar) {
        Cursor cursor;
        LinkedList linkedList = new LinkedList();
        try {
            cursor = c(lVar);
        } catch (Throwable th) {
            th = th;
            cursor = null;
        }
        if (cursor == null) {
            return null;
        }
        while (cursor.moveToNext()) {
            try {
                l.b bVar = new l.b();
                bVar.f38877a = cursor.getString(cursor.getColumnIndex("m_key"));
                bVar.f38879c = cursor.getLong(cursor.getColumnIndex("saveTime"));
                cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                bVar.f38878b = cursor.getBlob(cursor.getColumnIndex("m_value"));
                linkedList.add(bVar);
            } catch (Throwable th2) {
                th = th2;
                try {
                    BdLog.e(th);
                    d.a.c.e.m.a.a(cursor);
                    Collections.sort(linkedList, new b());
                    return linkedList;
                } finally {
                    d.a.c.e.m.a.a(cursor);
                }
            }
        }
        d.a.c.e.m.a.a(cursor);
        Collections.sort(linkedList, new b());
        return linkedList;
    }

    /* JADX WARN: Type inference failed for: r3v10, types: [T, java.lang.String] */
    public static List<l.b<String>> b(d.a.c.e.d.l<String> lVar) {
        Cursor cursor;
        LinkedList linkedList = new LinkedList();
        try {
            cursor = c(lVar);
        } catch (Throwable th) {
            th = th;
            cursor = null;
        }
        if (cursor == null) {
            return null;
        }
        while (cursor.moveToNext()) {
            try {
                l.b bVar = new l.b();
                bVar.f38877a = cursor.getString(cursor.getColumnIndex("m_key"));
                bVar.f38879c = cursor.getLong(cursor.getColumnIndex("saveTime"));
                cursor.getLong(cursor.getColumnIndex("timeToExpire"));
                bVar.f38878b = cursor.getString(cursor.getColumnIndex("m_value"));
                linkedList.add(bVar);
            } catch (Throwable th2) {
                th = th2;
                try {
                    BdLog.e(th);
                    d.a.c.e.m.a.a(cursor);
                    Collections.sort(linkedList, new b());
                    return linkedList;
                } finally {
                    d.a.c.e.m.a.a(cursor);
                }
            }
        }
        d.a.c.e.m.a.a(cursor);
        Collections.sort(linkedList, new b());
        return linkedList;
    }

    public static Cursor c(d.a.c.e.d.l<?> lVar) {
        if (lVar != null && (lVar instanceof l.c)) {
            l.c cVar = (l.c) lVar;
            if (cVar.c() instanceof d.a.c.e.d.j) {
                d.a.c.e.d.c n = ((d.a.c.e.d.j) cVar.c()).n();
                return n.q(n.h().f(), cVar.j());
            }
            return null;
        }
        return null;
    }
}
