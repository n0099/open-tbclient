package d.a.n0.f1.h;

import android.content.ContentValues;
import android.database.Cursor;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class l extends a {

    /* renamed from: d  reason: collision with root package name */
    public static a f54503d = null;

    /* renamed from: e  reason: collision with root package name */
    public static String f54504e = "tb_oficial_msg_";

    public l() {
        super("tb_oficial_msg_", OfficialChatMessage.class);
    }

    public static synchronized l t() {
        l lVar;
        synchronized (l.class) {
            if (f54503d == null) {
                f54503d = new l();
            }
            lVar = (l) f54503d;
        }
        return lVar;
    }

    public static List<d.a.n0.f1.h.o.a> u() {
        ArrayList arrayList;
        Exception e2;
        Cursor cursor;
        Cursor cursor2 = null;
        ArrayList arrayList2 = null;
        try {
            cursor = h.e().h("SELECT * FROM tb_message_center WHERE custom_group_type = ? AND (user_type = ? OR user_type = ?) ORDER BY visit_time DESC, last_content_time DESC", new String[]{String.valueOf(4), String.valueOf(3), String.valueOf(1)});
            if (cursor != null) {
                try {
                    try {
                        arrayList = new ArrayList(cursor.getCount());
                        while (cursor.moveToNext()) {
                            try {
                                d.a.n0.f1.h.o.a aVar = new d.a.n0.f1.h.o.a();
                                aVar.h(cursor.getString(cursor.getColumnIndex("gid")));
                                aVar.j(cursor.getInt(cursor.getColumnIndex("unread_count")));
                                aVar.i(cursor.getString(cursor.getColumnIndex("group_head")));
                                aVar.g(cursor.getString(cursor.getColumnIndex("group_name")));
                                aVar.k(cursor.getInt(cursor.getColumnIndex("user_type")));
                                int columnIndex = cursor.getColumnIndex("visit_time");
                                if (columnIndex >= 0) {
                                    aVar.l(cursor.getLong(columnIndex));
                                }
                                arrayList.add(aVar);
                            } catch (Exception e3) {
                                e2 = e3;
                                e2.printStackTrace();
                                TiebaStatic.printDBExceptionLog(e2, "ImMessageCenterDao.getOfficalListFromDb", new Object[0]);
                                d.a.c.e.p.m.a(cursor);
                                return arrayList;
                            }
                        }
                        arrayList2 = arrayList;
                    } catch (Throwable th) {
                        th = th;
                        cursor2 = cursor;
                        d.a.c.e.p.m.a(cursor2);
                        throw th;
                    }
                } catch (Exception e4) {
                    arrayList = null;
                    e2 = e4;
                }
            }
            d.a.c.e.p.m.a(cursor);
            return arrayList2;
        } catch (Exception e5) {
            arrayList = null;
            e2 = e5;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            d.a.c.e.p.m.a(cursor2);
            throw th;
        }
    }

    public static List<String> v() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            try {
                h e2 = h.e();
                cursor = e2.h("SELECT * FROM tb_message_center WHERE  custom_group_type=? AND (user_type=? OR user_type=?) ORDER BY last_content_time ASC", new String[]{String.valueOf(4), String.valueOf(3), String.valueOf(1)});
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        arrayList.add(cursor.getString(cursor.getColumnIndex("gid")));
                    }
                }
            } catch (Exception e3) {
                e3.printStackTrace();
                TiebaStatic.printDBExceptionLog(e3, "ImMessageCenterDao.getOfficalListFromDb", new Object[0]);
            }
            return arrayList;
        } finally {
            d.a.c.e.p.m.a(cursor);
        }
    }

    public void w(long j, long j2) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("visit_time", Long.valueOf(j2));
            contentValues.put("unread_count", (Integer) 0);
            int j3 = h.e().j("tb_message_center", contentValues, "gid = ?", new String[]{String.valueOf(j)});
            BdLog.d("updateReadCount result = " + j3);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void x(long j, long j2, int i2) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("read_count", Integer.valueOf(i2));
            h e2 = h.e();
            int j3 = e2.j(f54504e + j, contentValues, "mid = ?", new String[]{String.valueOf(j2)});
            BdLog.d("updateReadCount result = " + j3);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }
}
