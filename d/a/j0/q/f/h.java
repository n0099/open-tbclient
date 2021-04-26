package d.a.j0.q.f;

import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import d.a.c.e.p.m;
/* loaded from: classes4.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public static volatile SQLiteDatabase f57470a;

    public static synchronized void a() {
        synchronized (h.class) {
            m.b(f57470a);
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
            if (f57470a != null && f57470a.isOpen()) {
                return f57470a;
            }
            f57470a = new g(TbadkCoreApplication.getInst().getApp()).getWritableDatabase();
            return f57470a;
        }
    }
}
