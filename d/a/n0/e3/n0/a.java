package d.a.n0.e3.n0;

import android.database.Cursor;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TiebaDatabase;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class a {
    public static boolean a(String str, int i2) {
        d.a.c.a.k.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        mainDBDatabaseManager.e("delete from cash_data where type=?", new String[]{String.valueOf(i2)});
        return mainDBDatabaseManager.e("Insert into cash_data(type ,account ,data ) values(?,?,?)", new String[]{String.valueOf(i2), "", str});
    }

    public static void b() {
        c(0);
    }

    public static void c(int i2) {
        d.a.c.a.k.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        if (i2 == 0) {
            mainDBDatabaseManager.d("delete from search_data");
        } else if (i2 != 1) {
        } else {
            mainDBDatabaseManager.d("delete from search_post_data");
        }
    }

    public static void d() {
        c(1);
    }

    public static void e(int i2) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            return;
        }
        TiebaDatabase.getInstance().getMainDBDatabaseManager().e("delete from cash_data where type=? and account=?", new String[]{String.valueOf(i2), TbadkCoreApplication.getCurrentAccount()});
    }

    public static void f(int i2, String str) {
        TiebaDatabase.getInstance().getMainDBDatabaseManager().e("delete from cash_data where type=? and account=?", new String[]{String.valueOf(i2), (str == null || str.length() == 0) ? "0" : "0"});
    }

    public static void g(String str) {
        f(13, str);
    }

    public static void h(String str) {
        i(0, str);
    }

    public static void i(int i2, String str) {
        d.a.c.a.k.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        if (str != null) {
            if (i2 == 0) {
                mainDBDatabaseManager.e("delete from search_data where key=?", new String[]{str});
            } else if (i2 != 1) {
            } else {
                mainDBDatabaseManager.e("delete from search_post_data where key=?", new String[]{str});
            }
        }
    }

    public static void j() {
        e(2);
    }

    public static ArrayList<String> k() {
        return l(0);
    }

    public static ArrayList<String> l(int i2) {
        d.a.c.a.k.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        ArrayList<String> arrayList = new ArrayList<>();
        Cursor cursor = null;
        try {
            try {
                if (i2 == 0) {
                    cursor = mainDBDatabaseManager.j("select * from search_data order by time desc limit 20", null);
                } else if (i2 == 1) {
                    cursor = mainDBDatabaseManager.j("select * from search_post_data order by time desc limit 5", null);
                }
                while (cursor.moveToNext()) {
                    String string = cursor.getString(0);
                    if (string != null && string.length() > 0) {
                        arrayList.add(string);
                    }
                }
            } catch (Exception e2) {
                mainDBDatabaseManager.i(e2, "getAllSearchData");
            }
            return arrayList;
        } finally {
            d.a.c.e.m.a.a(cursor);
        }
    }

    public static ArrayList<String> m() {
        return l(1);
    }

    public static void n() {
        if (TbadkCoreApplication.getCurrentAccount() == null || TbadkCoreApplication.getCurrentAccount().length() <= 0 || TbadkCoreApplication.getCurrentAccountName() == null) {
            return;
        }
        d.a.c.a.k.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        Cursor cursor = null;
        try {
            try {
                cursor = mainDBDatabaseManager.j("select * from setting where account=?", new String[]{TbadkCoreApplication.getCurrentAccount()});
                if (cursor != null && cursor.moveToFirst()) {
                    d.a.m0.s.d.d.d().E(cursor.getInt(cursor.getColumnIndex("frequency")));
                    d.a.m0.s.d.d.d().G(cursor.getInt(cursor.getColumnIndex("fans_switch")) == 1);
                    if (cursor.getInt(cursor.getColumnIndex("reply_me_switch")) == 0) {
                        d.a.m0.s.d.d.d().H(false);
                    } else {
                        d.a.m0.s.d.d.d().H(true);
                    }
                    if (cursor.getInt(cursor.getColumnIndex("at_me_switch")) == 0) {
                        d.a.m0.s.d.d.d().C(false);
                    } else {
                        d.a.m0.s.d.d.d().C(true);
                    }
                    if (cursor.getInt(cursor.getColumnIndex("zan_me_switch")) == 0) {
                        d.a.m0.s.d.d.d().K(false);
                    } else {
                        d.a.m0.s.d.d.d().K(true);
                    }
                    d.a.m0.s.d.d.d().a(cursor.getInt(cursor.getColumnIndex("remind_tone")));
                    if (cursor.getInt(cursor.getColumnIndex("msg_chat_switch")) == 0) {
                        d.a.m0.s.d.d.d().D(false);
                    } else {
                        d.a.m0.s.d.d.d().D(true);
                    }
                    if (cursor.getInt(cursor.getColumnIndex("nodisturb_switch")) == 0) {
                        d.a.m0.s.d.d.d().M(false);
                    } else {
                        d.a.m0.s.d.d.d().M(true);
                    }
                    String string = cursor.getString(cursor.getColumnIndex("nodisturb_start_time"));
                    if (TextUtils.isEmpty(string)) {
                        d.a.m0.s.d.d.d().N(TbConfig.MSG_DEFAULT_NODISTURB_START_TIME);
                    } else {
                        d.a.m0.s.d.d.d().N(string);
                    }
                    String string2 = cursor.getString(cursor.getColumnIndex("nodisturb_end_time"));
                    if (TextUtils.isEmpty(string2)) {
                        d.a.m0.s.d.d.d().L(TbConfig.MSG_DEFAULT_NODISTURB_END_TIME);
                    } else {
                        d.a.m0.s.d.d.d().L(string2);
                    }
                    if (cursor.getInt(cursor.getColumnIndex("remind_light")) == 0) {
                        d.a.m0.s.d.d.d().F(false);
                    } else {
                        d.a.m0.s.d.d.d().F(true);
                    }
                    if (cursor.getInt(cursor.getColumnIndex("stranger_chat_switch")) == 0) {
                        d.a.m0.s.d.d.d().T(false);
                    } else {
                        d.a.m0.s.d.d.d().T(true);
                    }
                } else {
                    d.a.m0.s.d.d.d().E(300);
                    d.a.m0.s.d.d.d().G(true);
                    d.a.m0.s.d.d.d().H(true);
                    d.a.m0.s.d.d.d().C(true);
                    d.a.m0.s.d.d.d().K(true);
                    d.a.m0.s.d.d.d().I(true);
                    d.a.m0.s.d.d.d().J(false);
                    d.a.m0.s.d.d.d().F(true);
                    d.a.m0.s.d.d.d().T(false);
                    d.a.m0.s.d.d.d().D(true);
                    d.a.m0.s.d.d.d().M(false);
                    d.a.m0.s.d.d.d().N(TbConfig.MSG_DEFAULT_NODISTURB_START_TIME);
                    d.a.m0.s.d.d.d().L(TbConfig.MSG_DEFAULT_NODISTURB_END_TIME);
                }
            } catch (Exception e2) {
                mainDBDatabaseManager.i(e2, "getSettingData");
            }
            d.a.c.e.m.a.a(cursor);
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001311));
        } catch (Throwable th) {
            d.a.c.e.m.a.a(null);
            throw th;
        }
    }

    public static void o(String str) {
        p(0, str);
    }

    public static void p(int i2, String str) {
        d.a.c.a.k.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        if (str != null) {
            if (i2 == 0) {
                mainDBDatabaseManager.e("delete from search_data where key=?", new String[]{str});
                mainDBDatabaseManager.e("Insert into search_data(key,account,time) values(?,?,?)", new Object[]{str, TbadkCoreApplication.getCurrentAccount(), Long.valueOf(System.currentTimeMillis())});
            } else if (i2 != 1) {
            } else {
                mainDBDatabaseManager.e("delete from search_post_data where key=?", new String[]{str});
                mainDBDatabaseManager.e("Insert into search_post_data(key,account,time) values(?,?,?)", new Object[]{str, TbadkCoreApplication.getCurrentAccount(), Long.valueOf(System.currentTimeMillis())});
            }
        }
    }

    public static void q(String str) {
        p(1, str);
    }

    public static void r() {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            return;
        }
        d.a.c.a.k.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        mainDBDatabaseManager.e("delete from setting where account=?", new Object[]{TbadkCoreApplication.getCurrentAccount()});
        mainDBDatabaseManager.e("Insert into setting(account,frequency,fans_switch,reply_me_switch,at_me_switch,remind_tone,msg_chat_switch,nodisturb_switch,nodisturb_start_time,nodisturb_end_time,remind_light,stranger_chat_switch,zan_me_switch) values(?,?,?,?,?,?,?,?,?,?,?,?,?)", new Object[]{TbadkCoreApplication.getCurrentAccount(), Integer.valueOf(d.a.m0.s.d.d.d().e()), Integer.valueOf(d.a.m0.s.d.d.d().r() ? 1 : 0), Integer.valueOf(d.a.m0.s.d.d.d().t() ? 1 : 0), Integer.valueOf(d.a.m0.s.d.d.d().o() ? 1 : 0), Integer.valueOf(d.a.m0.s.d.d.d().c()), Integer.valueOf(d.a.m0.s.d.d.d().p() ? 1 : 0), Integer.valueOf(d.a.m0.s.d.d.d().x() ? 1 : 0), d.a.m0.s.d.d.d().g(), d.a.m0.s.d.d.d().f(), Integer.valueOf(d.a.m0.s.d.d.d().q() ? 1 : 0), Integer.valueOf(d.a.m0.s.d.d.d().z() ? 1 : 0), Integer.valueOf(d.a.m0.s.d.d.d().w() ? 1 : 0)});
    }
}
