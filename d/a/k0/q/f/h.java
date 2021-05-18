package d.a.k0.q.f;

import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import d.a.c.e.p.m;
/* loaded from: classes4.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public static volatile SQLiteDatabase f58212a;

    public static synchronized void a() {
        synchronized (h.class) {
            m.b(f58212a);
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
            if (f58212a != null && f58212a.isOpen()) {
                return f58212a;
            }
            f58212a = new g(TbadkCoreApplication.getInst().getApp()).getWritableDatabase();
            return f58212a;
        }
    }
}
