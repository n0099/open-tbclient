package com.repackage;

import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class m67 extends a67 {
    public static /* synthetic */ Interceptable $ic = null;
    public static a67 d = null;
    public static String e = "tb_private_msg_";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755547261, "Lcom/repackage/m67;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755547261, "Lcom/repackage/m67;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m67() {
        super("tb_private_msg_", PersonalChatMessage.class);
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

    public static synchronized m67 t() {
        InterceptResult invokeV;
        m67 m67Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (m67.class) {
                if (d == null) {
                    d = new m67();
                }
                m67Var = (m67) d;
            }
            return m67Var;
        }
        return (m67) invokeV.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r11v0, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    public CommonMsgPojo u(String str, int i) {
        InterceptResult invokeLI;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, str, i)) == null) {
            Cursor cursor2 = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                try {
                    cursor = h67.d().e("select * from " + (e + str) + " WHERE is_delete=? AND msg_type= ?", new String[]{String.valueOf(0), String.valueOf(i)});
                    try {
                        CommonMsgPojo commonMsgPojo = new CommonMsgPojo();
                        if (cursor != null && cursor.moveToNext()) {
                            commonMsgPojo.setGid(str);
                            commonMsgPojo.setUid(cursor.getString(cursor.getColumnIndex("uid")));
                            commonMsgPojo.setUser_info(cursor.getString(cursor.getColumnIndex("user_info")));
                            commonMsgPojo.setToUid(cursor.getString(cursor.getColumnIndex("to_uid")));
                            commonMsgPojo.setToUser_info(cursor.getString(cursor.getColumnIndex("to_user_info")));
                            commonMsgPojo.setContent(cursor.getString(cursor.getColumnIndex("content")));
                            commonMsgPojo.setCreate_time(cursor.getLong(cursor.getColumnIndex("create_time")));
                            commonMsgPojo.setExt(cursor.getString(cursor.getColumnIndex("ext")));
                            commonMsgPojo.setMid(cursor.getLong(cursor.getColumnIndex("mid")));
                            commonMsgPojo.setMsg_status(cursor.getInt(cursor.getColumnIndex(IMConstants.MSG_STATUS)));
                            commonMsgPojo.setMsg_type(cursor.getInt(cursor.getColumnIndex("msg_type")));
                            commonMsgPojo.setRid(cursor.getLong(cursor.getColumnIndex("rid")));
                            commonMsgPojo.setRead_flag(cursor.getInt(cursor.getColumnIndex("read_flag")));
                            commonMsgPojo.setIs_delete(cursor.getInt(cursor.getColumnIndex("is_delete")));
                            commonMsgPojo.setIsFriend(cursor.getInt(cursor.getColumnIndex("is_friend")));
                            pi.a(cursor);
                            return commonMsgPojo;
                        }
                    } catch (SQLiteException e2) {
                        e = e2;
                        TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.getMsgContextByMsgType", new Object[0]);
                        e.printStackTrace();
                        b(str);
                        pi.a(cursor);
                        return null;
                    } catch (Exception e3) {
                        e = e3;
                        TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.getMsgContextByMsgType", new Object[0]);
                        e.printStackTrace();
                        pi.a(cursor);
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor2 = i;
                    pi.a(cursor2);
                    throw th;
                }
            } catch (SQLiteException e4) {
                e = e4;
                cursor = null;
            } catch (Exception e5) {
                e = e5;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                pi.a(cursor2);
                throw th;
            }
            pi.a(cursor);
            return null;
        }
        return (CommonMsgPojo) invokeLI.objValue;
    }
}
