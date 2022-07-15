package com.repackage;

import android.content.ContentValues;
import android.database.Cursor;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class d67 extends s57 {
    public static /* synthetic */ Interceptable $ic = null;
    public static s57 d = null;
    public static String e = "tb_oficial_msg_";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755815380, "Lcom/repackage/d67;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755815380, "Lcom/repackage/d67;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d67() {
        super("tb_oficial_msg_", OfficialChatMessage.class);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                super((String) objArr[0], (Class) objArr[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static synchronized d67 v() {
        InterceptResult invokeV;
        d67 d67Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (d67.class) {
                if (d == null) {
                    d = new d67();
                }
                d67Var = (d67) d;
            }
            return d67Var;
        }
        return (d67) invokeV.objValue;
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x00b5: MOVE  (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:29:0x00b5 */
    public static List<i67> w() {
        InterceptResult invokeV;
        ArrayList arrayList;
        Exception e2;
        Cursor cursor;
        Cursor cursor2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65539, null)) != null) {
            return (List) invokeV.objValue;
        }
        Cursor cursor3 = null;
        ArrayList arrayList2 = null;
        try {
            try {
                cursor = z57.d().e("SELECT * FROM tb_message_center WHERE custom_group_type = ? AND (user_type = ? OR user_type = ?) ORDER BY visit_time DESC, last_content_time DESC", new String[]{String.valueOf(4), String.valueOf(3), String.valueOf(1)});
                if (cursor != null) {
                    try {
                        arrayList = new ArrayList(cursor.getCount());
                        while (cursor.moveToNext()) {
                            try {
                                i67 i67Var = new i67();
                                i67Var.h(cursor.getString(cursor.getColumnIndex("gid")));
                                i67Var.j(cursor.getInt(cursor.getColumnIndex("unread_count")));
                                i67Var.i(cursor.getString(cursor.getColumnIndex("group_head")));
                                i67Var.g(cursor.getString(cursor.getColumnIndex("group_name")));
                                i67Var.k(cursor.getInt(cursor.getColumnIndex("user_type")));
                                int columnIndex = cursor.getColumnIndex("visit_time");
                                if (columnIndex >= 0) {
                                    i67Var.l(cursor.getLong(columnIndex));
                                }
                                arrayList.add(i67Var);
                            } catch (Exception e3) {
                                e2 = e3;
                                e2.printStackTrace();
                                TiebaStatic.printDBExceptionLog(e2, "ImMessageCenterDao.getOfficalListFromDb", new Object[0]);
                                qi.a(cursor);
                                return arrayList;
                            }
                        }
                        arrayList2 = arrayList;
                    } catch (Exception e4) {
                        arrayList = null;
                        e2 = e4;
                    }
                }
                qi.a(cursor);
                return arrayList2;
            } catch (Throwable th) {
                th = th;
                cursor3 = cursor2;
                qi.a(cursor3);
                throw th;
            }
        } catch (Exception e5) {
            arrayList = null;
            e2 = e5;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            qi.a(cursor3);
            throw th;
        }
    }

    public static List<String> x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            ArrayList arrayList = new ArrayList();
            Cursor cursor = null;
            try {
                try {
                    z57 d2 = z57.d();
                    cursor = d2.e("SELECT * FROM tb_message_center WHERE  custom_group_type=? AND (user_type=? OR user_type=?) ORDER BY last_content_time ASC", new String[]{String.valueOf(4), String.valueOf(3), String.valueOf(1)});
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            arrayList.add(cursor.getString(cursor.getColumnIndex("gid")));
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    TiebaStatic.printDBExceptionLog(e2, "ImMessageCenterDao.getOfficalListFromDb", new Object[0]);
                }
                return arrayList;
            } finally {
                qi.a(cursor);
            }
        }
        return (List) invokeV.objValue;
    }

    public void y(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("visit_time", Long.valueOf(j2));
                contentValues.put("unread_count", (Integer) 0);
                int update = z57.d().update("tb_message_center", contentValues, "gid = ?", new String[]{String.valueOf(j)});
                BdLog.d("updateReadCount result = " + update);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void z(long j, long j2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i)}) == null) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("read_count", Integer.valueOf(i));
                z57 d2 = z57.d();
                int update = d2.update(e + j, contentValues, "mid = ?", new String[]{String.valueOf(j2)});
                BdLog.d("updateReadCount result = " + update);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
