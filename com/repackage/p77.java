package com.repackage;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.data.UpdatesItemData;
import com.baidu.tieba.im.data.ValidateItemData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.model.ModelHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes7.dex */
public class p77 {
    public static /* synthetic */ Interceptable $ic;
    public static p77 a;
    public transient /* synthetic */ FieldHolder $fh;

    public p77() {
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

    public static p77 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                a = new p77();
            }
            return a;
        }
        return (p77) invokeV.objValue;
    }

    public boolean a(String str) {
        InterceptResult invokeL;
        Boolean bool;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            try {
                t77.d().delete("tb_group_news", "notice_id = ?", new String[]{str});
                bool = Boolean.TRUE;
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "GroupNewsDao.deleteByNoticeId", new Object[0]);
                e.printStackTrace();
                bool = Boolean.FALSE;
            }
            return bool.booleanValue();
        }
        return invokeL.booleanValue;
    }

    public boolean b(List<UpdatesItemData> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            Boolean bool = Boolean.FALSE;
            if (list == null || list.isEmpty()) {
                return false;
            }
            try {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    UpdatesItemData updatesItemData = list.get(i);
                    if (updatesItemData != null) {
                        t77.d().delete("tb_group_news", "notice_id=?", new String[]{updatesItemData.getNotice_id()});
                    }
                }
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "GroupNewsDao.deleteByUpdatesData", new Object[0]);
                e.printStackTrace();
                bool = Boolean.FALSE;
            }
            return bool.booleanValue();
        }
        return invokeL.booleanValue;
    }

    public LinkedList<GroupNewsPojo> c(long j, int i, int i2, String str) {
        InterceptResult invokeCommon;
        Cursor e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), str})) == null) {
            if (i2 < 0) {
                i2 = 0;
            }
            LinkedList<GroupNewsPojo> linkedList = new LinkedList<>();
            if (i <= 0) {
                i = 20;
            }
            Cursor cursor = null;
            try {
                try {
                    if (j <= 0) {
                        if (TextUtils.isEmpty(str)) {
                            e = t77.d().e("select * from tb_group_news ORDER BY time DESC LIMIT " + i + " OFFSET " + i2, null);
                        } else {
                            e = t77.d().e(String.format("select * from tb_group_news WHERE cmd IN ( '%1$s' ) ORDER BY time DESC LIMIT " + i + " OFFSET " + i2, str), null);
                        }
                    } else if (TextUtils.isEmpty(str)) {
                        e = t77.d().e("select * from tb_group_news WHERE time <=? ORDER BY time DESC LIMIT " + i + " OFFSET " + i2, new String[]{String.valueOf(j)});
                    } else {
                        e = t77.d().e("select * from tb_group_news WHERE time <=? AND cmd IN ( ? ) ORDER BY time DESC LIMIT " + i + " OFFSET " + i2, new String[]{String.valueOf(j), str});
                    }
                    cursor = e;
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            GroupNewsPojo groupNewsPojo = new GroupNewsPojo();
                            groupNewsPojo.setCmd(cursor.getString(cursor.getColumnIndex("cmd")));
                            groupNewsPojo.setContent(cursor.getString(cursor.getColumnIndex("content")));
                            groupNewsPojo.setContent_status(cursor.getInt(cursor.getColumnIndex("content_status")));
                            groupNewsPojo.setExt(cursor.getString(cursor.getColumnIndex("ext")));
                            groupNewsPojo.setGid(cursor.getString(cursor.getColumnIndex("gid")));
                            groupNewsPojo.setNotice_id(cursor.getString(cursor.getColumnIndex("notice_id")));
                            groupNewsPojo.setTime(cursor.getLong(cursor.getColumnIndex("time")));
                            linkedList.add(groupNewsPojo);
                        }
                    }
                } catch (Exception e2) {
                    TiebaStatic.printDBExceptionLog(e2, "GroupNewsDao.getAllByCmd", new Object[0]);
                    e2.printStackTrace();
                }
                ri.a(cursor);
                return l(linkedList);
            } catch (Throwable th) {
                ri.a(cursor);
                throw th;
            }
        }
        return (LinkedList) invokeCommon.objValue;
    }

    public GroupNewsPojo d(String str) {
        InterceptResult invokeL;
        GroupNewsPojo groupNewsPojo;
        Exception e;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048579, this, str)) != null) {
            return (GroupNewsPojo) invokeL.objValue;
        }
        Cursor cursor2 = null;
        r1 = null;
        GroupNewsPojo groupNewsPojo2 = null;
        try {
            cursor = t77.d().e("select * from tb_group_news WHERE notice_id = ?", new String[]{str});
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    try {
                        try {
                            groupNewsPojo = new GroupNewsPojo();
                            try {
                                groupNewsPojo.setCmd(cursor.getString(cursor.getColumnIndex("cmd")));
                                groupNewsPojo.setContent(cursor.getString(cursor.getColumnIndex("content")));
                                groupNewsPojo.setContent_status(cursor.getInt(cursor.getColumnIndex("content_status")));
                                groupNewsPojo.setExt(cursor.getString(cursor.getColumnIndex("ext")));
                                groupNewsPojo.setGid(cursor.getString(cursor.getColumnIndex("gid")));
                                groupNewsPojo.setNotice_id(cursor.getString(cursor.getColumnIndex("notice_id")));
                                groupNewsPojo.setTime(cursor.getLong(cursor.getColumnIndex("time")));
                                groupNewsPojo2 = groupNewsPojo;
                            } catch (Exception e2) {
                                e = e2;
                                e.printStackTrace();
                                TiebaStatic.printDBExceptionLog(e, "GroupNewsDao.getByNoticeId", new Object[0]);
                                ri.a(cursor);
                                return groupNewsPojo;
                            }
                        } catch (Throwable th) {
                            th = th;
                            cursor2 = cursor;
                            ri.a(cursor2);
                            throw th;
                        }
                    } catch (Exception e3) {
                        groupNewsPojo = groupNewsPojo2;
                        e = e3;
                    }
                }
            }
            ri.a(cursor);
            return groupNewsPojo2;
        } catch (Exception e4) {
            groupNewsPojo = null;
            e = e4;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            ri.a(cursor2);
            throw th;
        }
    }

    public int e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            Cursor cursor = null;
            int i = 0;
            try {
                try {
                    cursor = t77.d().e(String.format("select count(*) from tb_group_news WHERE cmd IN ( '%1$s' )", str), null);
                    i = cursor.moveToFirst() ? cursor.getInt(0) : -1;
                } catch (SQLiteException e) {
                    TiebaStatic.printDBExceptionLog(e, "GroupNewsDao.getCountByCmd", new Object[0]);
                    e.printStackTrace();
                } catch (Exception e2) {
                    TiebaStatic.printDBExceptionLog(e2, "GroupNewsDao.getCountByCmd", new Object[0]);
                    e2.printStackTrace();
                }
                return i;
            } finally {
                ri.a(cursor);
            }
        }
        return invokeL.intValue;
    }

    public int g(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, str, i)) == null) {
            Cursor cursor = null;
            int i2 = 0;
            try {
                try {
                    try {
                        cursor = t77.d().e(String.format("select count(*) from tb_group_news WHERE cmd IN ( '%1$s' ) and content_status = %2$s", str, "" + i), null);
                        i2 = cursor.moveToFirst() ? cursor.getInt(0) : -1;
                    } catch (Exception e) {
                        TiebaStatic.printDBExceptionLog(e, "GroupNewsDao.getNewCountByCmd", new Object[0]);
                        e.printStackTrace();
                    }
                } catch (SQLiteException e2) {
                    TiebaStatic.printDBExceptionLog(e2, "GroupNewsDao.getNewCountByCmd", new Object[0]);
                    e2.printStackTrace();
                }
                return i2;
            } finally {
                ri.a(cursor);
            }
        }
        return invokeLI.intValue;
    }

    public int h(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, str, i)) == null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("content_status", (Integer) 3);
                    return t77.d().update("tb_group_news", contentValues, "notice_id= ?", new String[]{str});
                }
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "GroupNewsDao.hideByNoticeIdSync", new Object[0]);
                e.printStackTrace();
            }
            return 0;
        }
        return invokeLI.intValue;
    }

    public final long i(GroupNewsPojo groupNewsPojo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, groupNewsPojo)) == null) {
            try {
                try {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("INSERT INTO ");
                    stringBuffer.append("tb_group_news");
                    stringBuffer.append("(");
                    stringBuffer.append("cmd");
                    stringBuffer.append(",");
                    stringBuffer.append("content");
                    stringBuffer.append(",");
                    stringBuffer.append("content_status");
                    stringBuffer.append(",");
                    stringBuffer.append("ext");
                    stringBuffer.append(",");
                    stringBuffer.append("gid");
                    stringBuffer.append(",");
                    stringBuffer.append("notice_id");
                    stringBuffer.append(",");
                    stringBuffer.append("time");
                    stringBuffer.append(") VALUES(?,?,?,?,?,?,?)");
                    SQLiteStatement a2 = t77.d().a(stringBuffer.toString());
                    if (a2 == null) {
                        ri.c(a2);
                        return -1L;
                    }
                    a2.clearBindings();
                    r77.b(a2, 1, groupNewsPojo.getCmd());
                    r77.b(a2, 2, groupNewsPojo.getContent());
                    a2.bindLong(3, groupNewsPojo.getContent_status());
                    r77.b(a2, 4, groupNewsPojo.getExt());
                    r77.b(a2, 5, groupNewsPojo.getGid());
                    r77.b(a2, 6, groupNewsPojo.getNotice_id());
                    a2.bindLong(7, groupNewsPojo.getTime());
                    long executeInsert = a2.executeInsert();
                    ri.c(a2);
                    return executeInsert;
                } catch (Exception e) {
                    TiebaStatic.printDBExceptionLog(e, "GroupNewsDao.insertByStatement", new Object[0]);
                    ri.c(null);
                    return -1L;
                }
            } catch (Throwable th) {
                ri.c(null);
                throw th;
            }
        }
        return invokeL.longValue;
    }

    public boolean j(ValidateItemData validateItemData) {
        InterceptResult invokeL;
        List<ValidateItemData> convertToValidateItemDataList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, validateItemData)) == null) {
            if (validateItemData == null || ModelHelper.getInstance().getValidateModel() == null || (convertToValidateItemDataList = ModelHelper.getInstance().getValidateModel().convertToValidateItemDataList(c(0L, Integer.MAX_VALUE, 0, "apply_join_group"))) == null || convertToValidateItemDataList.size() == 0) {
                return false;
            }
            int size = convertToValidateItemDataList.size();
            LinkedList<GroupNewsPojo> linkedList = new LinkedList<>();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                ValidateItemData validateItemData2 = convertToValidateItemDataList.get(i2);
                if (validateItemData2.getGroupId().equals(validateItemData.getGroupId()) && validateItemData2.getUserId().equals(validateItemData.getUserId()) && validateItemData.isPass()) {
                    validateItemData2.setPass(true);
                    if (validateItemData.isShown()) {
                        validateItemData2.setShown(true);
                    }
                    linkedList.add(validateItemData2.toGroupNewsPojo());
                    i++;
                }
            }
            BdLog.i("affectCount:" + i);
            return m(linkedList).booleanValue();
        }
        return invokeL.booleanValue;
    }

    public boolean k(String str, int i) {
        InterceptResult invokeLI;
        Cursor e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048585, this, str, i)) == null) {
            Cursor cursor = null;
            cursor = null;
            if (i < 1000) {
                i = 1000;
            }
            try {
                try {
                    t77 d = t77.d();
                    e = d.e("SELECT * FROM tb_group_news ORDER BY notice_id DESC LIMIT " + i + ", 1", null);
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                String string = e.moveToNext() ? e.getString(e.getColumnIndex("notice_id")) : null;
                ri.a(e);
                if (string != null) {
                    t77.d().delete("tb_group_news", "notice_id<?", new String[]{string});
                }
                ri.a(e);
                return true;
            } catch (Exception e3) {
                e = e3;
                cursor = e;
                e.printStackTrace();
                TiebaStatic.printDBExceptionLog(e, "shrink", new Object[0]);
                ri.a(cursor);
                return false;
            } catch (Throwable th2) {
                th = th2;
                cursor = e;
                ri.a(cursor);
                throw th;
            }
        }
        return invokeLI.booleanValue;
    }

    public final LinkedList<GroupNewsPojo> l(LinkedList<GroupNewsPojo> linkedList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, linkedList)) == null) {
            LinkedList<GroupNewsPojo> linkedList2 = new LinkedList<>();
            ArrayList arrayList = new ArrayList();
            int size = linkedList.size();
            for (int i = 0; i < size; i++) {
                GroupNewsPojo groupNewsPojo = linkedList.get(i);
                boolean z = false;
                for (int i2 = 0; i2 < linkedList2.size(); i2++) {
                    if (linkedList2.get(i2).getContent().equals(groupNewsPojo.getContent())) {
                        z = true;
                    }
                }
                if (z) {
                    arrayList.add(groupNewsPojo.getNotice_id());
                } else {
                    linkedList2.add(groupNewsPojo);
                }
                int size2 = arrayList.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    h((String) arrayList.get(i3), 3);
                }
            }
            return linkedList2;
        }
        return (LinkedList) invokeL.objValue;
    }

    public Boolean m(LinkedList<GroupNewsPojo> linkedList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, linkedList)) == null) {
            Boolean bool = Boolean.FALSE;
            if (linkedList != null && linkedList.size() != 0) {
                try {
                    try {
                        t77.d().f();
                        Iterator<GroupNewsPojo> it = linkedList.iterator();
                        LinkedList<GroupNewsPojo> linkedList2 = null;
                        List<ValidateItemData> list = null;
                        while (it.hasNext()) {
                            GroupNewsPojo next = it.next();
                            if (next.getCmd().equals("apply_join_group")) {
                                if (linkedList2 == null) {
                                    linkedList2 = c(0L, Integer.MAX_VALUE, 0, "apply_join_group");
                                    if (ModelHelper.getInstance().getValidateModel() != null) {
                                        list = ModelHelper.getInstance().getValidateModel().convertToValidateItemDataList(linkedList2);
                                    }
                                    if (list == null) {
                                        list = new LinkedList<>();
                                    }
                                }
                                if (list != null) {
                                    ValidateItemData convertToValidateItemData = ModelHelper.getInstance().getValidateModel() != null ? ModelHelper.getInstance().getValidateModel().convertToValidateItemData(next) : null;
                                    if (convertToValidateItemData != null) {
                                        for (ValidateItemData validateItemData : list) {
                                            if (convertToValidateItemData.getUserId() != null && convertToValidateItemData.getUserId().equals(validateItemData.getUserId()) && convertToValidateItemData.getGroupId() != null && convertToValidateItemData.getGroupId().equals(validateItemData.getGroupId())) {
                                                a(validateItemData.getNotice_id());
                                            }
                                        }
                                    }
                                }
                            }
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("cmd", next.getCmd());
                            contentValues.put("content", next.getContent());
                            contentValues.put("content_status", Integer.valueOf(next.getContent_status()));
                            contentValues.put("ext", next.getExt());
                            contentValues.put("gid", next.getGid());
                            contentValues.put("notice_id", next.getNotice_id());
                            contentValues.put("time", Long.valueOf(next.getTime()));
                            if (t77.d().update("tb_group_news", contentValues, "notice_id=?", new String[]{next.getNotice_id()}) == 0) {
                                i(next);
                            }
                            bool = Boolean.valueOf(bool.booleanValue() & true);
                        }
                    } catch (Exception e) {
                        TiebaStatic.printDBExceptionLog(e, "GroupNewsDao.updateData", new Object[0]);
                        e.printStackTrace();
                        bool = Boolean.FALSE;
                    }
                    return bool;
                } finally {
                    t77.d().b();
                }
            }
            return Boolean.FALSE;
        }
        return (Boolean) invokeL.objValue;
    }
}
