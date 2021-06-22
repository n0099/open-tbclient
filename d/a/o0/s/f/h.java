package d.a.o0.s.f;

import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import d.a.c.e.p.m;
/* loaded from: classes4.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public static volatile SQLiteDatabase f64189a;

    public static synchronized void a() {
        synchronized (h.class) {
            m.b(f64189a);
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
            if (f64189a != null && f64189a.isOpen()) {
                return f64189a;
            }
            f64189a = new g(TbadkCoreApplication.getInst().getApp()).getWritableDatabase();
            return f64189a;
        }
    }
}
