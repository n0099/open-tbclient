package d.a.j0.r.l;

import android.content.Intent;
import android.database.Cursor;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TiebaDatabase;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes3.dex */
public class c {
    public static boolean a(AccountData accountData, d.a.c.a.k.b bVar) {
        return bVar.e("Insert into account_data(id,account,password,bduss,isactive,tbs,time,portrait,gender,member_iconurl,stoken,name_show) values(?,?,?,?,?,?,?,?,?,?,?,?)", new Object[]{accountData.getID(), accountData.getAccount(), accountData.getPassword(), accountData.getBDUSS(), Integer.valueOf(accountData.getIsActive()), accountData.getTbs(), Long.valueOf(new Date().getTime()), accountData.getPortrait(), Integer.valueOf(accountData.getSex()), accountData.getMemberIconUrl(), accountData.getStoken(), accountData.getAccountNameShow()});
    }

    public static void b() {
        TiebaDatabase.getInstance().getMainDBDatabaseManager().d("update account_data set isactive=0 where isactive=1");
    }

    public static boolean c(String str) {
        return TiebaDatabase.getInstance().getMainDBDatabaseManager().e("delete from account_data where id=?", new String[]{str});
    }

    public static int d() {
        d.a.c.a.k.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        int i2 = 0;
        Cursor cursor = null;
        try {
            if (mainDBDatabaseManager != null) {
                try {
                    cursor = mainDBDatabaseManager.j("select count(*) from account_data", null);
                    if (cursor != null && cursor.moveToFirst()) {
                        i2 = cursor.getInt(0);
                    }
                } catch (Exception e2) {
                    mainDBDatabaseManager.i(e2, "getAccountNum");
                }
            }
            return i2;
        } finally {
            d.a.c.e.m.a.a(cursor);
        }
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x00ac: MOVE  (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:24:0x00ac */
    public static AccountData e() {
        Cursor cursor;
        AccountData accountData;
        Exception e2;
        Cursor cursor2;
        d.a.c.a.k.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        Cursor cursor3 = null;
        try {
            if (mainDBDatabaseManager != null) {
                try {
                    cursor2 = mainDBDatabaseManager.j("select * from account_data where isactive=?", new String[]{String.valueOf(1)});
                    if (cursor2 != null) {
                        try {
                            if (cursor2.moveToFirst()) {
                                accountData = new AccountData();
                                try {
                                    accountData.setID(cursor2.getString(0));
                                    accountData.setAccount(cursor2.getString(1));
                                    accountData.setPassword(cursor2.getString(2));
                                    accountData.setBDUSS(cursor2.getString(3));
                                    accountData.setIsActive(cursor2.getInt(4));
                                    accountData.setTbs(cursor2.getString(5));
                                    accountData.setTime(cursor2.getLong(6));
                                    accountData.setPortrait(cursor2.getString(7));
                                    accountData.setSex(cursor2.getInt(9));
                                    accountData.setMemberIconUrl(cursor2.getString(10));
                                    accountData.setStoken(cursor2.getString(cursor2.getColumnIndex("stoken")));
                                    accountData.setNameShow(cursor2.getString(cursor2.getColumnIndex("name_show")));
                                    cursor3 = cursor2;
                                } catch (Exception e3) {
                                    e2 = e3;
                                    mainDBDatabaseManager.i(e2, "getActiveAccountData");
                                    d.a.c.e.m.a.a(cursor2);
                                    return accountData;
                                }
                            }
                        } catch (Exception e4) {
                            accountData = null;
                            e2 = e4;
                        }
                    }
                    accountData = null;
                    cursor3 = cursor2;
                } catch (Exception e5) {
                    accountData = null;
                    e2 = e5;
                    cursor2 = null;
                } catch (Throwable th) {
                    th = th;
                    d.a.c.e.m.a.a(cursor3);
                    throw th;
                }
            } else {
                accountData = null;
            }
            d.a.c.e.m.a.a(cursor3);
            return accountData;
        } catch (Throwable th2) {
            th = th2;
            cursor3 = cursor;
        }
    }

    public static ArrayList<AccountData> f() {
        d.a.c.a.k.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        ArrayList<AccountData> arrayList = new ArrayList<>();
        Cursor cursor = null;
        try {
            if (mainDBDatabaseManager != null) {
                try {
                    cursor = mainDBDatabaseManager.j("select * from account_data order by time desc", null);
                    while (cursor.moveToNext()) {
                        AccountData accountData = new AccountData();
                        accountData.setID(cursor.getString(0));
                        accountData.setAccount(cursor.getString(1));
                        accountData.setPassword(cursor.getString(2));
                        accountData.setBDUSS(cursor.getString(3));
                        accountData.setIsActive(cursor.getInt(4));
                        accountData.setTbs(cursor.getString(5));
                        accountData.setTime(cursor.getLong(6));
                        accountData.setPortrait(cursor.getString(7));
                        accountData.setSex(cursor.getInt(9));
                        accountData.setMemberIconUrl(cursor.getString(10));
                        accountData.setStoken(cursor.getString(cursor.getColumnIndex("stoken")));
                        accountData.setNameShow(cursor.getString(cursor.getColumnIndex("name_show")));
                        arrayList.add(accountData);
                    }
                } catch (Exception e2) {
                    mainDBDatabaseManager.i(e2, "getAllAccountData");
                }
            }
            return arrayList;
        } finally {
            d.a.c.e.m.a.a(cursor);
        }
    }

    public static void g(AccountData accountData) {
        if (accountData == null || accountData.getID() == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.baidu.tieba.action.accountChange");
        intent.putExtra("intent_data_accountData", TbadkCoreApplication.getCurrentAccountObj());
        intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
        TbadkCoreApplication.getInst().sendBroadcast(intent);
        String str = "set_basedata_account:";
        if (!StringUtils.isNull(accountData.getID()) && !StringUtils.isNull(accountData.getBDUSS())) {
            str = "set_basedata_account:valid_logined";
        } else if (!StringUtils.isNull(accountData.getBDUSS())) {
            str = "set_basedata_account:valid";
        } else if (!StringUtils.isNull(accountData.getID())) {
            str = "set_basedata_account:logined";
        }
        d.a.j0.r.z.a.a("account", -1L, 0, str, 0, "", new Object[0]);
        if (accountData.getIsActive() == 1) {
            b();
        }
        d.a.c.a.k.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        if (c(accountData.getID()) && a(accountData, mainDBDatabaseManager)) {
            return;
        }
        if (!mainDBDatabaseManager.d("DROP TABLE IF EXISTS account_data")) {
            mainDBDatabaseManager.b();
        }
        mainDBDatabaseManager.d("CREATE TABLE if not exists account_data(id,account,password,bduss,isactive int,tbs,time,portrait varchar(255), personal_gid int, gender int, member_iconurl varchar(255),stoken varchar(255),name_show varchar(255))");
        a(accountData, mainDBDatabaseManager);
    }
}
