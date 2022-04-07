package com.repackage;

import android.database.Cursor;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TiebaDatabase;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class vl8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755227217, "Lcom/repackage/vl8;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755227217, "Lcom/repackage/vl8;");
        }
    }

    public static boolean a(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, str, i)) == null) {
            h9 mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            mainDBDatabaseManager.e("delete from cash_data where type=?", new String[]{String.valueOf(i)});
            return mainDBDatabaseManager.e("Insert into cash_data(type ,account ,data ) values(?,?,?)", new String[]{String.valueOf(i), "", str});
        }
        return invokeLI.booleanValue;
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            c(0);
        }
    }

    public static void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65539, null, i) == null) {
            h9 mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            if (i == 0) {
                mainDBDatabaseManager.d("delete from search_data");
            } else if (i != 1) {
            } else {
                mainDBDatabaseManager.d("delete from search_post_data");
            }
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            c(1);
        }
    }

    public static void e(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65541, null, i) == null) || TbadkCoreApplication.getCurrentAccount() == null) {
            return;
        }
        TiebaDatabase.getInstance().getMainDBDatabaseManager().e("delete from cash_data where type=? and account=?", new String[]{String.valueOf(i), TbadkCoreApplication.getCurrentAccount()});
    }

    public static void f(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65542, null, i, str) == null) {
            TiebaDatabase.getInstance().getMainDBDatabaseManager().e("delete from cash_data where type=? and account=?", new String[]{String.valueOf(i), (str == null || str.length() == 0) ? "0" : "0"});
        }
    }

    public static void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, str) == null) {
            f(13, str);
        }
    }

    public static void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, str) == null) {
            i(0, str);
        }
    }

    public static void i(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65545, null, i, str) == null) {
            h9 mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            if (str != null) {
                if (i == 0) {
                    mainDBDatabaseManager.e("delete from search_data where key=?", new String[]{str});
                } else if (i != 1) {
                } else {
                    mainDBDatabaseManager.e("delete from search_post_data where key=?", new String[]{str});
                }
            }
        }
    }

    public static void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            e(2);
        }
    }

    public static ArrayList<String> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? l(0) : (ArrayList) invokeV.objValue;
    }

    public static ArrayList<String> l(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65548, null, i)) == null) {
            h9 mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            ArrayList<String> arrayList = new ArrayList<>();
            Cursor cursor = null;
            try {
                try {
                    if (i == 0) {
                        cursor = mainDBDatabaseManager.j("select * from search_data order by time desc limit 20", null);
                    } else if (i == 1) {
                        cursor = mainDBDatabaseManager.j("select * from search_post_data order by time desc limit 5", null);
                    }
                    while (cursor.moveToNext()) {
                        String string = cursor.getString(0);
                        if (string != null && string.length() > 0) {
                            arrayList.add(string);
                        }
                    }
                } catch (Exception e) {
                    mainDBDatabaseManager.i(e, "getAllSearchData");
                }
                return arrayList;
            } finally {
                lg.a(cursor);
            }
        }
        return (ArrayList) invokeI.objValue;
    }

    public static ArrayList<String> m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? l(1) : (ArrayList) invokeV.objValue;
    }

    public static void n() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65550, null) == null) || TbadkCoreApplication.getCurrentAccount() == null || TbadkCoreApplication.getCurrentAccount().length() <= 0 || TbadkCoreApplication.getCurrentAccountName() == null) {
            return;
        }
        h9 mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        Cursor cursor = null;
        try {
            try {
                cursor = mainDBDatabaseManager.j("select * from setting where account=?", new String[]{TbadkCoreApplication.getCurrentAccount()});
                if (cursor != null && cursor.moveToFirst()) {
                    zx4.d().H(cursor.getInt(cursor.getColumnIndex("frequency")));
                    zx4.d().J(cursor.getInt(cursor.getColumnIndex("fans_switch")) == 1);
                    if (cursor.getInt(cursor.getColumnIndex("reply_me_switch")) == 0) {
                        zx4.d().K(false);
                    } else {
                        zx4.d().K(true);
                    }
                    if (cursor.getInt(cursor.getColumnIndex("at_me_switch")) == 0) {
                        zx4.d().F(false);
                    } else {
                        zx4.d().F(true);
                    }
                    if (cursor.getInt(cursor.getColumnIndex("zan_me_switch")) == 0) {
                        zx4.d().N(false);
                    } else {
                        zx4.d().N(true);
                    }
                    zx4.d().a(cursor.getInt(cursor.getColumnIndex("remind_tone")));
                    if (cursor.getInt(cursor.getColumnIndex("msg_chat_switch")) == 0) {
                        zx4.d().G(false);
                    } else {
                        zx4.d().G(true);
                    }
                    if (cursor.getInt(cursor.getColumnIndex("nodisturb_switch")) == 0) {
                        zx4.d().P(false);
                    } else {
                        zx4.d().P(true);
                    }
                    String string = cursor.getString(cursor.getColumnIndex("nodisturb_start_time"));
                    if (TextUtils.isEmpty(string)) {
                        zx4.d().Q(TbConfig.MSG_DEFAULT_NODISTURB_START_TIME);
                    } else {
                        zx4.d().Q(string);
                    }
                    String string2 = cursor.getString(cursor.getColumnIndex("nodisturb_end_time"));
                    if (TextUtils.isEmpty(string2)) {
                        zx4.d().O(TbConfig.MSG_DEFAULT_NODISTURB_END_TIME);
                    } else {
                        zx4.d().O(string2);
                    }
                    if (cursor.getInt(cursor.getColumnIndex("remind_light")) == 0) {
                        zx4.d().I(false);
                    } else {
                        zx4.d().I(true);
                    }
                    if (cursor.getInt(cursor.getColumnIndex("stranger_chat_switch")) == 0) {
                        zx4.d().W(false);
                    } else {
                        zx4.d().W(true);
                    }
                } else {
                    zx4.d().H(300);
                    zx4.d().J(true);
                    zx4.d().K(true);
                    zx4.d().F(true);
                    zx4.d().N(true);
                    zx4.d().L(true);
                    zx4.d().M(false);
                    zx4.d().I(true);
                    zx4.d().W(false);
                    zx4.d().G(true);
                    zx4.d().P(false);
                    zx4.d().Q(TbConfig.MSG_DEFAULT_NODISTURB_START_TIME);
                    zx4.d().O(TbConfig.MSG_DEFAULT_NODISTURB_END_TIME);
                }
            } catch (Exception e) {
                mainDBDatabaseManager.i(e, "getSettingData");
            }
            lg.a(cursor);
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001311));
        } catch (Throwable th) {
            lg.a(null);
            throw th;
        }
    }

    public static void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, str) == null) {
            p(0, str);
        }
    }

    public static void p(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65552, null, i, str) == null) {
            h9 mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            if (str != null) {
                if (i == 0) {
                    mainDBDatabaseManager.e("delete from search_data where key=?", new String[]{str});
                    mainDBDatabaseManager.e("Insert into search_data(key,account,time) values(?,?,?)", new Object[]{str, TbadkCoreApplication.getCurrentAccount(), Long.valueOf(System.currentTimeMillis())});
                } else if (i != 1) {
                } else {
                    mainDBDatabaseManager.e("delete from search_post_data where key=?", new String[]{str});
                    mainDBDatabaseManager.e("Insert into search_post_data(key,account,time) values(?,?,?)", new Object[]{str, TbadkCoreApplication.getCurrentAccount(), Long.valueOf(System.currentTimeMillis())});
                }
            }
        }
    }

    public static void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, str) == null) {
            p(1, str);
        }
    }

    public static void r() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65554, null) == null) || TbadkCoreApplication.getCurrentAccount() == null) {
            return;
        }
        h9 mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        mainDBDatabaseManager.e("delete from setting where account=?", new Object[]{TbadkCoreApplication.getCurrentAccount()});
        mainDBDatabaseManager.e("Insert into setting(account,frequency,fans_switch,reply_me_switch,at_me_switch,remind_tone,msg_chat_switch,nodisturb_switch,nodisturb_start_time,nodisturb_end_time,remind_light,stranger_chat_switch,zan_me_switch) values(?,?,?,?,?,?,?,?,?,?,?,?,?)", new Object[]{TbadkCoreApplication.getCurrentAccount(), Integer.valueOf(zx4.d().e()), Integer.valueOf(zx4.d().t() ? 1 : 0), Integer.valueOf(zx4.d().v() ? 1 : 0), Integer.valueOf(zx4.d().q() ? 1 : 0), Integer.valueOf(zx4.d().c()), Integer.valueOf(zx4.d().r() ? 1 : 0), Integer.valueOf(zx4.d().z() ? 1 : 0), zx4.d().g(), zx4.d().f(), Integer.valueOf(zx4.d().s() ? 1 : 0), Integer.valueOf(zx4.d().B() ? 1 : 0), Integer.valueOf(zx4.d().y() ? 1 : 0)});
    }
}
