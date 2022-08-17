package com.repackage;

import android.database.Cursor;
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
public class zl8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755108053, "Lcom/repackage/zl8;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755108053, "Lcom/repackage/zl8;");
        }
    }

    public static boolean a(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, str, i)) == null) {
            j9 mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
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
            j9 mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
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
            j9 mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
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
            j9 mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
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
                ng.a(cursor);
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
        j9 mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        Cursor cursor = null;
        try {
            try {
                cursor = mainDBDatabaseManager.j("select * from setting where account=?", new String[]{TbadkCoreApplication.getCurrentAccount()});
                if (cursor != null && cursor.moveToFirst()) {
                    lz4.d().K(cursor.getInt(cursor.getColumnIndex("frequency")));
                    lz4.d().M(cursor.getInt(cursor.getColumnIndex("fans_switch")) == 1);
                    if (cursor.getInt(cursor.getColumnIndex("reply_me_switch")) == 0) {
                        lz4.d().N(false);
                    } else {
                        lz4.d().N(true);
                    }
                    if (cursor.getInt(cursor.getColumnIndex("at_me_switch")) == 0) {
                        lz4.d().I(false);
                    } else {
                        lz4.d().I(true);
                    }
                    if (cursor.getInt(cursor.getColumnIndex("zan_me_switch")) == 0) {
                        lz4.d().Q(false);
                    } else {
                        lz4.d().Q(true);
                    }
                    lz4.d().a(cursor.getInt(cursor.getColumnIndex("remind_tone")));
                    if (cursor.getInt(cursor.getColumnIndex("msg_chat_switch")) == 0) {
                        lz4.d().J(false);
                    } else {
                        lz4.d().J(true);
                    }
                    if (cursor.getInt(cursor.getColumnIndex("nodisturb_switch")) == 0) {
                        lz4.d().S(false);
                    } else {
                        lz4.d().S(true);
                    }
                    lz4.d().T(TbConfig.MSG_DEFAULT_NODISTURB_START_TIME);
                    lz4.d().R(TbConfig.MSG_DEFAULT_NODISTURB_END_TIME);
                    if (cursor.getInt(cursor.getColumnIndex("remind_light")) == 0) {
                        lz4.d().L(false);
                    } else {
                        lz4.d().L(true);
                    }
                    if (cursor.getInt(cursor.getColumnIndex("stranger_chat_switch")) == 0) {
                        lz4.d().Z(false);
                    } else {
                        lz4.d().Z(true);
                    }
                } else {
                    lz4.d().K(300);
                    lz4.d().M(true);
                    lz4.d().N(true);
                    lz4.d().I(true);
                    lz4.d().Q(true);
                    lz4.d().O(true);
                    lz4.d().P(false);
                    lz4.d().L(true);
                    lz4.d().Z(false);
                    lz4.d().J(true);
                    lz4.d().S(false);
                    lz4.d().T(TbConfig.MSG_DEFAULT_NODISTURB_START_TIME);
                    lz4.d().R(TbConfig.MSG_DEFAULT_NODISTURB_END_TIME);
                }
            } catch (Exception e) {
                mainDBDatabaseManager.i(e, "getSettingData");
            }
            ng.a(cursor);
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001311));
        } catch (Throwable th) {
            ng.a(null);
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
            j9 mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
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
        j9 mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        mainDBDatabaseManager.e("delete from setting where account=?", new Object[]{TbadkCoreApplication.getCurrentAccount()});
        mainDBDatabaseManager.e("Insert into setting(account,frequency,fans_switch,reply_me_switch,at_me_switch,remind_tone,msg_chat_switch,nodisturb_switch,nodisturb_start_time,nodisturb_end_time,remind_light,stranger_chat_switch,zan_me_switch) values(?,?,?,?,?,?,?,?,?,?,?,?,?)", new Object[]{TbadkCoreApplication.getCurrentAccount(), Integer.valueOf(lz4.d().f()), Integer.valueOf(lz4.d().w() ? 1 : 0), Integer.valueOf(lz4.d().y() ? 1 : 0), Integer.valueOf(lz4.d().t() ? 1 : 0), Integer.valueOf(lz4.d().c()), Integer.valueOf(lz4.d().u() ? 1 : 0), Integer.valueOf(lz4.d().C() ? 1 : 0), lz4.d().h(), lz4.d().g(), Integer.valueOf(lz4.d().v() ? 1 : 0), Integer.valueOf(lz4.d().E() ? 1 : 0), Integer.valueOf(lz4.d().B() ? 1 : 0)});
    }
}
