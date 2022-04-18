package com.repackage;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TiebaDatabase;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class rb8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final rb8 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-47653364, "Lcom/repackage/rb8$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-47653364, "Lcom/repackage/rb8$a;");
                    return;
                }
            }
            a = new rb8();
        }
    }

    public rb8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static rb8 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? a.a : (rb8) invokeV.objValue;
    }

    public final ContentValues a(sb8 sb8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, sb8Var)) == null) {
            if (sb8Var == null || TextUtils.isEmpty(sb8Var.a)) {
                return null;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("download_key", sb8Var.a);
            contentValues.put("package_name", sb8Var.b);
            contentValues.put("finish_download_time", String.valueOf(sb8Var.c));
            contentValues.put("show_times", String.valueOf(sb8Var.d));
            contentValues.put("last_show_time", String.valueOf(sb8Var.e));
            contentValues.put("ad_string", sb8Var.f);
            contentValues.put("cmatch", sb8Var.g);
            contentValues.put("install_status", Integer.valueOf(sb8Var.h));
            contentValues.put("ad_extension_info1", sb8Var.i);
            contentValues.put("ad_extension_info2", sb8Var.j);
            contentValues.put("ad_extension_info3", sb8Var.k);
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    public final sb8 b(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cursor)) == null) {
            if (cursor != null && !cursor.isClosed()) {
                try {
                    sb8 sb8Var = new sb8();
                    sb8Var.a = cursor.getString(cursor.getColumnIndex("download_key"));
                    sb8Var.b = cursor.getString(cursor.getColumnIndex("package_name"));
                    sb8Var.c = Long.parseLong(cursor.getString(cursor.getColumnIndex("finish_download_time")));
                    sb8Var.d = Integer.parseInt(cursor.getString(cursor.getColumnIndex("show_times")));
                    sb8Var.e = Long.parseLong(cursor.getString(cursor.getColumnIndex("last_show_time")));
                    sb8Var.f = cursor.getString(cursor.getColumnIndex("ad_string"));
                    sb8Var.g = cursor.getString(cursor.getColumnIndex("cmatch"));
                    sb8Var.h = Integer.parseInt(cursor.getString(cursor.getColumnIndex("install_status")));
                    sb8Var.i = cursor.getString(cursor.getColumnIndex("ad_extension_info1"));
                    sb8Var.j = cursor.getString(cursor.getColumnIndex("ad_extension_info2"));
                    sb8Var.k = cursor.getString(cursor.getColumnIndex("ad_extension_info3"));
                    return sb8Var;
                } catch (Exception unused) {
                }
            }
            return null;
        }
        return (sb8) invokeL.objValue;
    }

    public synchronized void c(Integer num, Integer num2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, num, num2) == null) {
            synchronized (this) {
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                f.delete("ad_follow_up_info_table", "finish_download_time < ? and show_times >= ?", new String[]{String.valueOf(System.currentTimeMillis() - ((((num.intValue() * 24) * 60) * 60) * 1000)), String.valueOf(num2)});
                f.setTransactionSuccessful();
                f.endTransaction();
            }
        }
    }

    public synchronized void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                f.delete("ad_follow_up_info_table", "download_key = ?", new String[]{str});
                f.setTransactionSuccessful();
                f.endTransaction();
            }
        }
    }

    public synchronized List<sb8> f(Integer num, Integer num2) {
        InterceptResult invokeLL;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, num, num2)) == null) {
            synchronized (this) {
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                long currentTimeMillis = System.currentTimeMillis() - ((((num.intValue() * 24) * 60) * 60) * 1000);
                arrayList = new ArrayList();
                Cursor rawQuery = f.rawQuery("SELECT * FROM ad_follow_up_info_table where finish_download_time > ? and show_times < ? and install_status = ? order by finish_download_time desc", new String[]{String.valueOf(currentTimeMillis), String.valueOf(num2), String.valueOf(1)});
                while (rawQuery.moveToNext()) {
                    sb8 b = b(rawQuery);
                    if (b != null && !arrayList.contains(b)) {
                        arrayList.add(b);
                    }
                }
                f.setTransactionSuccessful();
                pi.a(rawQuery);
                f.endTransaction();
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public synchronized void g(sb8 sb8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, sb8Var) == null) {
            synchronized (this) {
                if (sb8Var != null) {
                    if (!TextUtils.isEmpty(sb8Var.a) && !TextUtils.isEmpty(sb8Var.b)) {
                        SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                        f.beginTransaction();
                        f.replace("ad_follow_up_info_table", null, a(sb8Var));
                        f.setTransactionSuccessful();
                        f.endTransaction();
                    }
                }
            }
        }
    }
}
