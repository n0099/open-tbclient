package d.b.i0.q.f;

import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import d.b.c.e.p.m;
/* loaded from: classes4.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public static volatile SQLiteDatabase f59010a;

    public static synchronized void a() {
        synchronized (h.class) {
            m.b(f59010a);
        }
    }

    public static synchronized SQLiteDatabase b() {
        synchronized (h.class) {
            try {
            } catch (Exception e2) {
                TiebaStatic.printDBExceptionLog(e2, "RelationshipDbManager.getRelationshipDataBase", new Object[0]);
            }
            if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                return null;
            }
            if (f59010a != null && f59010a.isOpen()) {
                return f59010a;
            }
            f59010a = new g(TbadkCoreApplication.getInst().getApp()).getWritableDatabase();
            return f59010a;
        }
    }
}
