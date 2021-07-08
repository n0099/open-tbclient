package d.a.p0.i1.h;

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
/* loaded from: classes8.dex */
public class l extends a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: d  reason: collision with root package name */
    public static a f58425d = null;

    /* renamed from: e  reason: collision with root package name */
    public static String f58426e = "tb_oficial_msg_";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1170170541, "Ld/a/p0/i1/h/l;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1170170541, "Ld/a/p0/i1/h/l;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l() {
        super("tb_oficial_msg_", OfficialChatMessage.class);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                super((String) objArr[0], (Class) objArr[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static synchronized l t() {
        InterceptResult invokeV;
        l lVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (l.class) {
                if (f58425d == null) {
                    f58425d = new l();
                }
                lVar = (l) f58425d;
            }
            return lVar;
        }
        return (l) invokeV.objValue;
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x00b6: MOVE  (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:29:0x00b6 */
    public static List<d.a.p0.i1.h.o.a> u() {
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
                cursor = h.e().h("SELECT * FROM tb_message_center WHERE custom_group_type = ? AND (user_type = ? OR user_type = ?) ORDER BY visit_time DESC, last_content_time DESC", new String[]{String.valueOf(4), String.valueOf(3), String.valueOf(1)});
                if (cursor != null) {
                    try {
                        arrayList = new ArrayList(cursor.getCount());
                        while (cursor.moveToNext()) {
                            try {
                                d.a.p0.i1.h.o.a aVar = new d.a.p0.i1.h.o.a();
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
                    } catch (Exception e4) {
                        arrayList = null;
                        e2 = e4;
                    }
                }
                d.a.c.e.p.m.a(cursor);
                return arrayList2;
            } catch (Throwable th) {
                th = th;
                cursor3 = cursor2;
                d.a.c.e.p.m.a(cursor3);
                throw th;
            }
        } catch (Exception e5) {
            arrayList = null;
            e2 = e5;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            d.a.c.e.p.m.a(cursor3);
            throw th;
        }
    }

    public static List<String> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
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
        return (List) invokeV.objValue;
    }

    public void w(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
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
    }

    public void x(long j, long j2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("read_count", Integer.valueOf(i2));
                h e2 = h.e();
                int j3 = e2.j(f58426e + j, contentValues, "mid = ?", new String[]{String.valueOf(j2)});
                BdLog.d("updateReadCount result = " + j3);
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }
}
