package d.b.i0.e1.h;

import android.database.Cursor;
import android.text.TextUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.switchs.StrangeCleanSwitch;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    public static int f55334a = 1500;

    /* renamed from: b  reason: collision with root package name */
    public static int f55335b = 500;

    public static void a() {
        String d2;
        try {
            if (!StrangeCleanSwitch.isOn()) {
                d.b.h0.r.z.a.a("StrangeClean", -1L, -1, "cleanMessageCenter", -1, "witch is close", new Object[0]);
                return;
            }
            try {
                h.e().i();
                d2 = d();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (TextUtils.isEmpty(d2)) {
                return;
            }
            boolean b2 = b(d2);
            d.b.h0.r.z.a.a("StrangeClean", -1L, -1, "cleanMessageCenter", -1, "clean suc " + b2, new Object[0]);
        } finally {
            h.e().c();
        }
    }

    public static boolean b(String str) {
        try {
            h e2 = h.e();
            return e2.d("DELETE FROM tb_message_center WHERE gid IN(" + str + ") AND custom_group_type= " + String.valueOf(2) + " AND is_friend!=" + String.valueOf(1));
        } catch (Exception e3) {
            e3.printStackTrace();
            TiebaStatic.printDBExceptionLog(e3, "ImMessageCenterDao.deleteStrange", new Object[0]);
            return false;
        }
    }

    public static int c() {
        return d.b.h0.r.d0.b.j().k("key_max_stranger", f55334a);
    }

    public static String d() {
        List<String> e2;
        StringBuilder sb = new StringBuilder();
        try {
            e2 = e();
        } catch (Exception e3) {
            e3.printStackTrace();
            TiebaStatic.printDBExceptionLog(e3, "ImMessageCenterDao.getStrangeData", new Object[0]);
        }
        if (e2 != null && e2.size() != 0) {
            int c2 = c();
            d.b.h0.r.z.a.a("StrangeClean", -1L, -1, "getStrangeData", -1, "strange size is " + e2.size() + " max is " + c2, new Object[0]);
            if (e2.size() > c2) {
                int i = 2000;
                if (2000 >= e2.size() - c2) {
                    i = e2.size() - c2;
                }
                boolean z = true;
                for (String str : e2.subList(0, i)) {
                    if (z) {
                        z = false;
                    } else {
                        sb.append(",");
                    }
                    sb.append(str);
                }
            }
            return sb.toString();
        }
        return null;
    }

    public static List<String> e() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            try {
                cursor = h.e().h("SELECT * FROM tb_message_center WHERE  custom_group_type=? AND is_friend!=?  ORDER BY last_content_time ASC", new String[]{String.valueOf(2), String.valueOf(1)});
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        arrayList.add(cursor.getString(cursor.getColumnIndex("gid")));
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                TiebaStatic.printDBExceptionLog(e2, "ImMessageCenterDao.getStrangeDataFromDb", new Object[0]);
            }
            return arrayList;
        } finally {
            d.b.c.e.p.m.a(cursor);
        }
    }

    public static void f(int i) {
        int i2 = f55335b;
        if (i < i2) {
            i = i2;
        }
        d.b.h0.r.d0.b.j().v("key_max_stranger", i);
    }
}
