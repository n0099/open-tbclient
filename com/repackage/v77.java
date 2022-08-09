package com.repackage;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class v77 {
    public static /* synthetic */ Interceptable $ic;
    public static v77 a;
    public transient /* synthetic */ FieldHolder $fh;

    public v77() {
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

    public static synchronized v77 f() {
        InterceptResult invokeV;
        v77 v77Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (v77.class) {
                if (a == null) {
                    synchronized (v77.class) {
                        if (a == null) {
                            a = new v77();
                        }
                    }
                }
                v77Var = a;
            }
            return v77Var;
        }
        return (v77) invokeV.objValue;
    }

    public void a(String str, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("unread_count", (Integer) 0);
        t77.d().update("tb_message_center", contentValues, "gid=? AND custom_group_type=?", new String[]{str, String.valueOf(i)});
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? t77.d().delete("tb_message_center", "custom_group_type=? AND is_friend!=?", new String[]{String.valueOf(2), String.valueOf(1)}) : invokeV.booleanValue;
    }

    public boolean c(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i)) == null) {
            try {
                return t77.d().delete("tb_message_center", "gid=? AND custom_group_type=?", new String[]{str, String.valueOf(i)});
            } catch (Exception e) {
                e.printStackTrace();
                TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.deleteByGid", new Object[0]);
                return false;
            }
        }
        return invokeLI.booleanValue;
    }

    public LinkedList<ImMessageCenterPojo> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            LinkedList<ImMessageCenterPojo> linkedList = new LinkedList<>();
            Cursor e = t77.d().e("SELECT * FROM tb_message_center", null);
            if (e != null) {
                while (e.moveToNext()) {
                    ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                    imMessageCenterPojo.setPulled_msgId(og.g(e.getString(e.getColumnIndex("pull_msgid")), 0L));
                    imMessageCenterPojo.setGid(e.getString(e.getColumnIndex("gid")));
                    imMessageCenterPojo.setGroup_name(e.getString(e.getColumnIndex("group_name")));
                    imMessageCenterPojo.setNameShow(e.getString(e.getColumnIndex("group_name_show")));
                    imMessageCenterPojo.setGroup_head(e.getString(e.getColumnIndex("group_head")));
                    imMessageCenterPojo.setCustomGroupType(e.getInt(e.getColumnIndex("custom_group_type")));
                    imMessageCenterPojo.setIsFriend(e.getInt(e.getColumnIndex("is_friend")));
                    imMessageCenterPojo.setUnread_count(e.getInt(e.getColumnIndex("unread_count")));
                    imMessageCenterPojo.setLast_rid(e.getLong(e.getColumnIndex("last_msgId")));
                    imMessageCenterPojo.setLast_user_name(e.getString(e.getColumnIndex("last_user_name")));
                    imMessageCenterPojo.setLast_content_time(e.getLong(e.getColumnIndex("last_content_time")));
                    imMessageCenterPojo.setSend_status(e.getInt(e.getColumnIndex(TableDefine.PaCmdQueueColumns.COLUMN_SEND_STATUS)));
                    imMessageCenterPojo.setLast_content(e.getString(e.getColumnIndex("last_content")));
                    imMessageCenterPojo.setPulled_msgId(e.getLong(e.getColumnIndex("pull_msgid")));
                    imMessageCenterPojo.setIs_hidden(e.getInt(e.getColumnIndex("is_hidden")));
                    imMessageCenterPojo.setSent_msgId(e.getLong(e.getColumnIndex("sent_mid")));
                    imMessageCenterPojo.setRead_msgId(e.getLong(e.getColumnIndex("read_mid")));
                    imMessageCenterPojo.setUserType(e.getInt(e.getColumnIndex("user_type")));
                    imMessageCenterPojo.setSid(e.getLong(e.getColumnIndex("sid")));
                    imMessageCenterPojo.setTaskId(e.getString(e.getColumnIndex("task_id")));
                    imMessageCenterPojo.setServiceId(e.getString(e.getColumnIndex("service_id")));
                    imMessageCenterPojo.setPushIds(e.getString(e.getColumnIndex("ext1")));
                    o(imMessageCenterPojo, e.getString(e.getColumnIndex("ext2")));
                    linkedList.add(imMessageCenterPojo);
                }
            }
            ri.a(e);
            return linkedList;
        }
        return (LinkedList) invokeV.objValue;
    }

    public LinkedList<ImMessageCenterPojo> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            LinkedList<ImMessageCenterPojo> linkedList = new LinkedList<>();
            Cursor e = t77.d().e("SELECT * FROM tb_message_center", null);
            if (e != null) {
                while (e.moveToNext()) {
                    ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                    imMessageCenterPojo.setPulled_msgId(og.g(e.getString(e.getColumnIndex("pull_msgid")), 0L));
                    imMessageCenterPojo.setGid(e.getString(e.getColumnIndex("gid")));
                    imMessageCenterPojo.setGroup_name(e.getString(e.getColumnIndex("group_name")));
                    imMessageCenterPojo.setNameShow(e.getString(e.getColumnIndex("group_name_show")));
                    imMessageCenterPojo.setGroup_head(e.getString(e.getColumnIndex("group_head")));
                    imMessageCenterPojo.setCustomGroupType(e.getInt(e.getColumnIndex("custom_group_type")));
                    imMessageCenterPojo.setIsFriend(e.getInt(e.getColumnIndex("is_friend")));
                    imMessageCenterPojo.setUnread_count(e.getInt(e.getColumnIndex("unread_count")));
                    imMessageCenterPojo.setLast_rid(e.getLong(e.getColumnIndex("last_msgId")));
                    imMessageCenterPojo.setLast_user_name(e.getString(e.getColumnIndex("last_user_name")));
                    imMessageCenterPojo.setLast_content_time(e.getLong(e.getColumnIndex("last_content_time")));
                    imMessageCenterPojo.setSend_status(e.getInt(e.getColumnIndex(TableDefine.PaCmdQueueColumns.COLUMN_SEND_STATUS)));
                    imMessageCenterPojo.setLast_content(e.getString(e.getColumnIndex("last_content")));
                    imMessageCenterPojo.setPulled_msgId(e.getLong(e.getColumnIndex("pull_msgid")));
                    imMessageCenterPojo.setIs_hidden(e.getInt(e.getColumnIndex("is_hidden")));
                    o(imMessageCenterPojo, e.getString(e.getColumnIndex("ext2")));
                    linkedList.add(imMessageCenterPojo);
                }
            }
            ri.a(e);
            return linkedList;
        }
        return (LinkedList) invokeV.objValue;
    }

    public ImMessageCenterPojo g(String str, int i) {
        InterceptResult invokeLI;
        ImMessageCenterPojo imMessageCenterPojo;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLI = interceptable.invokeLI(1048581, this, str, i)) != null) {
            return (ImMessageCenterPojo) invokeLI.objValue;
        }
        Cursor cursor = null;
        r2 = null;
        ImMessageCenterPojo imMessageCenterPojo2 = null;
        cursor = null;
        try {
            try {
                Cursor e = t77.d().e("select * from tb_message_center WHERE gid=? AND custom_group_type=?", new String[]{str, String.valueOf(i)});
                if (e != null) {
                    try {
                        try {
                            if (e.moveToNext()) {
                                imMessageCenterPojo = new ImMessageCenterPojo();
                                try {
                                    imMessageCenterPojo.setPulled_msgId(og.g(e.getString(e.getColumnIndex("pull_msgid")), 0L));
                                    imMessageCenterPojo.setGid(e.getString(e.getColumnIndex("gid")));
                                    imMessageCenterPojo.setGroup_name(e.getString(e.getColumnIndex("group_name")));
                                    imMessageCenterPojo.setNameShow(e.getString(e.getColumnIndex("group_name_show")));
                                    imMessageCenterPojo.setGroup_head(e.getString(e.getColumnIndex("group_head")));
                                    imMessageCenterPojo.setCustomGroupType(e.getInt(e.getColumnIndex("custom_group_type")));
                                    imMessageCenterPojo.setIsFriend(e.getInt(e.getColumnIndex("is_friend")));
                                    imMessageCenterPojo.setUnread_count(e.getInt(e.getColumnIndex("unread_count")));
                                    imMessageCenterPojo.setLast_rid(e.getLong(e.getColumnIndex("last_msgId")));
                                    imMessageCenterPojo.setLast_user_name(e.getString(e.getColumnIndex("last_user_name")));
                                    imMessageCenterPojo.setLast_content_time(e.getLong(e.getColumnIndex("last_content_time")));
                                    imMessageCenterPojo.setSend_status(e.getInt(e.getColumnIndex(TableDefine.PaCmdQueueColumns.COLUMN_SEND_STATUS)));
                                    imMessageCenterPojo.setLast_content(e.getString(e.getColumnIndex("last_content")));
                                    imMessageCenterPojo.setPulled_msgId(e.getLong(e.getColumnIndex("pull_msgid")));
                                    imMessageCenterPojo.setIs_hidden(e.getInt(e.getColumnIndex("is_hidden")));
                                    imMessageCenterPojo.setSent_msgId(e.getLong(e.getColumnIndex("sent_mid")));
                                    imMessageCenterPojo.setRead_msgId(e.getLong(e.getColumnIndex("read_mid")));
                                    imMessageCenterPojo.setUserType(e.getInt(e.getColumnIndex("user_type")));
                                    imMessageCenterPojo.setSid(e.getLong(e.getColumnIndex("sid")));
                                    imMessageCenterPojo.setTaskId(e.getString(e.getColumnIndex("task_id")));
                                    imMessageCenterPojo.setServiceId(e.getString(e.getColumnIndex("service_id")));
                                    imMessageCenterPojo.setPushIds(e.getString(e.getColumnIndex("ext1")));
                                    o(imMessageCenterPojo, e.getString(e.getColumnIndex("ext2")));
                                    imMessageCenterPojo2 = imMessageCenterPojo;
                                } catch (Exception e2) {
                                    e = e2;
                                    cursor = e;
                                    e.printStackTrace();
                                    TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.getGroupInfo", new Object[0]);
                                    ri.a(cursor);
                                    return imMessageCenterPojo;
                                }
                            }
                        } catch (Exception e3) {
                            e = e3;
                            imMessageCenterPojo = null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor = e;
                        ri.a(cursor);
                        throw th;
                    }
                }
                ri.a(e);
                return imMessageCenterPojo2;
            } catch (Exception e4) {
                e = e4;
                imMessageCenterPojo = null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public LinkedList<ImMessageCenterPojo> h() {
        InterceptResult invokeV;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048582, this)) != null) {
            return (LinkedList) invokeV.objValue;
        }
        LinkedList<ImMessageCenterPojo> linkedList = new LinkedList<>();
        Cursor cursor2 = null;
        try {
            cursor = t77.d().e("SELECT * FROM tb_message_center WHERE  custom_group_type IN (?,?,?,?,?)", new String[]{String.valueOf(1), String.valueOf(2), String.valueOf(4), String.valueOf(-2)});
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    try {
                        try {
                            ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                            imMessageCenterPojo.setGid(cursor.getString(cursor.getColumnIndex("gid")));
                            imMessageCenterPojo.setCustomGroupType(cursor.getInt(cursor.getColumnIndex("custom_group_type")));
                            linkedList.add(imMessageCenterPojo);
                        } catch (Exception e) {
                            e = e;
                            e.printStackTrace();
                            TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.getShrinkData", new Object[0]);
                            ri.a(cursor);
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor2 = cursor;
                        ri.a(cursor2);
                        throw th;
                    }
                }
            }
            ri.a(cursor);
            return linkedList;
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            ri.a(cursor2);
            throw th;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:20:0x0171 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:33:0x0008 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v4, types: [com.baidu.tieba.im.db.pojo.ImMessageCenterPojo] */
    public ImMessageCenterPojo i(String str) {
        InterceptResult invokeL;
        ImMessageCenterPojo imMessageCenterPojo;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048583, this, str)) != null) {
            return (ImMessageCenterPojo) invokeL.objValue;
        }
        Cursor cursor = 0;
        r2 = null;
        ImMessageCenterPojo imMessageCenterPojo2 = null;
        Cursor cursor2 = null;
        try {
            try {
                Cursor e = t77.d().e("select * from tb_message_center WHERE group_head like ? ", new String[]{str + "%"});
                if (e != null) {
                    try {
                        try {
                            if (e.moveToNext()) {
                                imMessageCenterPojo = new ImMessageCenterPojo();
                                try {
                                    imMessageCenterPojo.setPulled_msgId(og.g(e.getString(e.getColumnIndex("pull_msgid")), 0L));
                                    imMessageCenterPojo.setGid(e.getString(e.getColumnIndex("gid")));
                                    imMessageCenterPojo.setGroup_name(e.getString(e.getColumnIndex("group_name")));
                                    imMessageCenterPojo.setNameShow(e.getString(e.getColumnIndex("group_name_show")));
                                    imMessageCenterPojo.setGroup_head(e.getString(e.getColumnIndex("group_head")));
                                    imMessageCenterPojo.setCustomGroupType(e.getInt(e.getColumnIndex("custom_group_type")));
                                    imMessageCenterPojo.setIsFriend(e.getInt(e.getColumnIndex("is_friend")));
                                    imMessageCenterPojo.setUnread_count(e.getInt(e.getColumnIndex("unread_count")));
                                    imMessageCenterPojo.setLast_rid(e.getLong(e.getColumnIndex("last_msgId")));
                                    imMessageCenterPojo.setLast_user_name(e.getString(e.getColumnIndex("last_user_name")));
                                    imMessageCenterPojo.setLast_content_time(e.getLong(e.getColumnIndex("last_content_time")));
                                    imMessageCenterPojo.setSend_status(e.getInt(e.getColumnIndex(TableDefine.PaCmdQueueColumns.COLUMN_SEND_STATUS)));
                                    imMessageCenterPojo.setLast_content(e.getString(e.getColumnIndex("last_content")));
                                    imMessageCenterPojo.setPulled_msgId(e.getLong(e.getColumnIndex("pull_msgid")));
                                    imMessageCenterPojo.setIs_hidden(e.getInt(e.getColumnIndex("is_hidden")));
                                    imMessageCenterPojo.setSent_msgId(e.getLong(e.getColumnIndex("sent_mid")));
                                    imMessageCenterPojo.setRead_msgId(e.getLong(e.getColumnIndex("read_mid")));
                                    imMessageCenterPojo.setUserType(e.getInt(e.getColumnIndex("user_type")));
                                    imMessageCenterPojo.setSid(e.getLong(e.getColumnIndex("sid")));
                                    imMessageCenterPojo.setTaskId(e.getString(e.getColumnIndex("task_id")));
                                    imMessageCenterPojo.setServiceId(e.getString(e.getColumnIndex("service_id")));
                                    imMessageCenterPojo.setPushIds(e.getString(e.getColumnIndex("ext1")));
                                    o(imMessageCenterPojo, e.getString(e.getColumnIndex("ext2")));
                                    imMessageCenterPojo2 = imMessageCenterPojo;
                                } catch (Exception e2) {
                                    e = e2;
                                    cursor2 = e;
                                    e.printStackTrace();
                                    TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.getUidByPortrait", new Object[0]);
                                    ri.a(cursor2);
                                    cursor = imMessageCenterPojo;
                                    return cursor;
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            cursor = e;
                            ri.a(cursor);
                            throw th;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        imMessageCenterPojo = null;
                    }
                }
                ri.a(e);
                return imMessageCenterPojo2;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e4) {
            e = e4;
            imMessageCenterPojo = null;
        }
    }

    public final void j(ContentValues contentValues, ImMessageCenterPojo imMessageCenterPojo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, contentValues, imMessageCenterPojo) == null) || contentValues == null || imMessageCenterPojo == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(imMessageCenterPojo.getBjhAvatar())) {
                jSONObject.put("bjhAvatar", imMessageCenterPojo.getBjhAvatar());
            }
            if (imMessageCenterPojo.getShowOutOfStranger() > 0) {
                jSONObject.put("key_show_out_of_stranger", imMessageCenterPojo.getShowOutOfStranger());
            }
            if (imMessageCenterPojo.getImUserExtraData() != null) {
                jSONObject.put("key_user_extra_data", imMessageCenterPojo.getImUserExtraData().c());
            }
            contentValues.put("ext2", jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void k(ImMessageCenterPojo imMessageCenterPojo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, imMessageCenterPojo) == null) {
            l(imMessageCenterPojo, 1);
        }
    }

    public void l(ImMessageCenterPojo imMessageCenterPojo, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048586, this, imMessageCenterPojo, i) == null) {
            m(imMessageCenterPojo, i, 1);
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:75:0x00b9 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:77:0x0103 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:83:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r13v0, types: [int] */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v4, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r13v40 */
    /* JADX WARN: Type inference failed for: r13v6, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m(ImMessageCenterPojo imMessageCenterPojo, int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048587, this, imMessageCenterPojo, i, i2) == null) || imMessageCenterPojo == null || TextUtils.isEmpty(imMessageCenterPojo.getGid()) || og.g(imMessageCenterPojo.getGid(), 0L) == 0) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("gid", imMessageCenterPojo.getGid());
        contentValues.put("sid", Long.valueOf(imMessageCenterPojo.getSid()));
        contentValues.put("task_id", imMessageCenterPojo.getTaskId());
        contentValues.put("service_id", imMessageCenterPojo.getServiceId());
        if (i2 == 2) {
            contentValues.put("ext1", imMessageCenterPojo.getPushIds());
        }
        if (!TextUtils.isEmpty(imMessageCenterPojo.getGroup_name())) {
            contentValues.put("group_name", imMessageCenterPojo.getGroup_name());
        }
        if (!TextUtils.isEmpty(imMessageCenterPojo.getNameShow())) {
            contentValues.put("group_name_show", imMessageCenterPojo.getNameShow());
        }
        j(contentValues, imMessageCenterPojo);
        if (!TextUtils.isEmpty(imMessageCenterPojo.getGroup_head())) {
            contentValues.put("group_head", imMessageCenterPojo.getGroup_head());
        }
        contentValues.put("custom_group_type", Integer.valueOf(imMessageCenterPojo.getCustomGroupType()));
        int unread_count = imMessageCenterPojo.getUnread_count();
        Cursor cursor = null;
        if (i == 2) {
            contentValues.put("unread_count", Integer.valueOf(unread_count));
        } else if (i == 3) {
            try {
                if (unread_count > 0) {
                    try {
                        i = t77.d().e("SELECT * FROM tb_message_center WHERE gid=? AND custom_group_type=?", new String[]{imMessageCenterPojo.getGid(), String.valueOf(imMessageCenterPojo.getCustomGroupType())});
                    } catch (Exception e) {
                        e = e;
                        i = 0;
                    } catch (Throwable th) {
                        th = th;
                        ri.a(cursor);
                        throw th;
                    }
                    if (i != 0) {
                        try {
                        } catch (Exception e2) {
                            e = e2;
                            i = i;
                            BdLog.e(e);
                            ri.a(i);
                            contentValues.put("last_msgId", Long.valueOf(imMessageCenterPojo.getLast_rid()));
                            if (imMessageCenterPojo.getLast_user_name() != null) {
                            }
                            if (imMessageCenterPojo.getLast_content_time() != 0) {
                            }
                            if (imMessageCenterPojo.getLast_content() != null) {
                            }
                            contentValues.put(TableDefine.PaCmdQueueColumns.COLUMN_SEND_STATUS, Integer.valueOf(imMessageCenterPojo.getSend_status()));
                            contentValues.put("is_hidden", Integer.valueOf(imMessageCenterPojo.getIs_hidden()));
                            contentValues.put("is_friend", Integer.valueOf(imMessageCenterPojo.getIsFriend()));
                            if (imMessageCenterPojo.getPulled_msgId() != 0) {
                            }
                            if (imMessageCenterPojo.getSent_msgId() > 0) {
                            }
                            if (imMessageCenterPojo.getRead_msgId() > 0) {
                            }
                            contentValues.put("user_type", Integer.valueOf(imMessageCenterPojo.getUserType()));
                            BdLog.i("sql-" + contentValues);
                            if (t77.d().update("tb_message_center", contentValues, "gid=? AND custom_group_type=?", new String[]{imMessageCenterPojo.getGid(), String.valueOf(imMessageCenterPojo.getCustomGroupType())}) != 0) {
                            }
                        }
                        if (i.moveToNext()) {
                            int i3 = unread_count + i.getInt(i.getColumnIndex("unread_count"));
                            if (i3 > 0) {
                                contentValues.put("unread_count", Integer.valueOf(i3));
                            }
                            ri.a(i);
                        }
                    }
                    contentValues.put("unread_count", Integer.valueOf(unread_count));
                    ri.a(i);
                }
            } catch (Throwable th2) {
                th = th2;
                cursor = i;
            }
        }
        contentValues.put("last_msgId", Long.valueOf(imMessageCenterPojo.getLast_rid()));
        if (imMessageCenterPojo.getLast_user_name() != null) {
            contentValues.put("last_user_name", imMessageCenterPojo.getLast_user_name());
        }
        if (imMessageCenterPojo.getLast_content_time() != 0) {
            contentValues.put("last_content_time", Long.valueOf(imMessageCenterPojo.getLast_content_time()));
        }
        if (imMessageCenterPojo.getLast_content() != null) {
            contentValues.put("last_content", imMessageCenterPojo.getLast_content());
        }
        contentValues.put(TableDefine.PaCmdQueueColumns.COLUMN_SEND_STATUS, Integer.valueOf(imMessageCenterPojo.getSend_status()));
        contentValues.put("is_hidden", Integer.valueOf(imMessageCenterPojo.getIs_hidden()));
        contentValues.put("is_friend", Integer.valueOf(imMessageCenterPojo.getIsFriend()));
        if (imMessageCenterPojo.getPulled_msgId() != 0) {
            contentValues.put("pull_msgid", Long.valueOf(imMessageCenterPojo.getPulled_msgId()));
        }
        if (imMessageCenterPojo.getSent_msgId() > 0) {
            contentValues.put("sent_mid", Long.valueOf(imMessageCenterPojo.getSent_msgId()));
        }
        if (imMessageCenterPojo.getRead_msgId() > 0) {
            contentValues.put("read_mid", Long.valueOf(imMessageCenterPojo.getRead_msgId()));
        }
        contentValues.put("user_type", Integer.valueOf(imMessageCenterPojo.getUserType()));
        BdLog.i("sql-" + contentValues);
        if (t77.d().update("tb_message_center", contentValues, "gid=? AND custom_group_type=?", new String[]{imMessageCenterPojo.getGid(), String.valueOf(imMessageCenterPojo.getCustomGroupType())}) != 0) {
            BdLog.i("insert");
            t77.d().insert("tb_message_center", null, contentValues);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void n(ImMessageCenterPojo imMessageCenterPojo, int i) {
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048588, this, imMessageCenterPojo, i) == null) || imMessageCenterPojo == null || TextUtils.isEmpty(imMessageCenterPojo.getGid())) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("gid", imMessageCenterPojo.getGid());
        if (!TextUtils.isEmpty(imMessageCenterPojo.getGroup_name())) {
            contentValues.put("group_name", imMessageCenterPojo.getGroup_name());
        }
        if (!TextUtils.isEmpty(imMessageCenterPojo.getNameShow())) {
            contentValues.put("group_name_show", imMessageCenterPojo.getNameShow());
        }
        j(contentValues, imMessageCenterPojo);
        if (!TextUtils.isEmpty(imMessageCenterPojo.getGroup_head())) {
            contentValues.put("group_head", imMessageCenterPojo.getGroup_head());
        }
        contentValues.put("custom_group_type", Integer.valueOf(imMessageCenterPojo.getCustomGroupType()));
        int unread_count = imMessageCenterPojo.getUnread_count();
        Cursor cursor2 = null;
        if (i == 2) {
            contentValues.put("unread_count", Integer.valueOf(unread_count));
        } else if (i == 3 && unread_count > 0) {
            try {
                cursor = t77.d().e("SELECT * FROM tb_message_center WHERE gid=? AND custom_group_type=?", new String[]{imMessageCenterPojo.getGid(), String.valueOf(imMessageCenterPojo.getCustomGroupType())});
            } catch (Exception e) {
                e = e;
                cursor = null;
            } catch (Throwable th) {
                th = th;
                ri.a(cursor2);
                throw th;
            }
            if (cursor != null) {
                try {
                    try {
                    } catch (Exception e2) {
                        e = e2;
                        BdLog.e(e);
                        ri.a(cursor);
                        contentValues.put("last_msgId", Long.valueOf(imMessageCenterPojo.getLast_rid()));
                        if (imMessageCenterPojo.getLast_user_name() != null) {
                        }
                        if (imMessageCenterPojo.getLast_content_time() != 0) {
                        }
                        if (imMessageCenterPojo.getLast_content() != null) {
                        }
                        contentValues.put(TableDefine.PaCmdQueueColumns.COLUMN_SEND_STATUS, Integer.valueOf(imMessageCenterPojo.getSend_status()));
                        contentValues.put("is_hidden", Integer.valueOf(imMessageCenterPojo.getIs_hidden()));
                        contentValues.put("is_friend", Integer.valueOf(imMessageCenterPojo.getIsFriend()));
                        if (imMessageCenterPojo.getPulled_msgId() != 0) {
                        }
                        BdLog.i("sql-" + contentValues);
                        if (t77.d().update("tb_message_center", contentValues, "gid=? AND custom_group_type=?", new String[]{imMessageCenterPojo.getGid(), String.valueOf(imMessageCenterPojo.getCustomGroupType())}) != 0) {
                        }
                    }
                    if (cursor.moveToNext()) {
                        int i2 = unread_count + cursor.getInt(cursor.getColumnIndex("unread_count"));
                        if (i2 > 0) {
                            contentValues.put("unread_count", Integer.valueOf(i2));
                        }
                        ri.a(cursor);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = cursor;
                    ri.a(cursor2);
                    throw th;
                }
            }
            contentValues.put("unread_count", Integer.valueOf(unread_count));
            ri.a(cursor);
        }
        contentValues.put("last_msgId", Long.valueOf(imMessageCenterPojo.getLast_rid()));
        if (imMessageCenterPojo.getLast_user_name() != null) {
            contentValues.put("last_user_name", imMessageCenterPojo.getLast_user_name());
        }
        if (imMessageCenterPojo.getLast_content_time() != 0) {
            contentValues.put("last_content_time", Long.valueOf(imMessageCenterPojo.getLast_content_time()));
        }
        if (imMessageCenterPojo.getLast_content() != null) {
            contentValues.put("last_content", imMessageCenterPojo.getLast_content());
        }
        contentValues.put(TableDefine.PaCmdQueueColumns.COLUMN_SEND_STATUS, Integer.valueOf(imMessageCenterPojo.getSend_status()));
        contentValues.put("is_hidden", Integer.valueOf(imMessageCenterPojo.getIs_hidden()));
        contentValues.put("is_friend", Integer.valueOf(imMessageCenterPojo.getIsFriend()));
        if (imMessageCenterPojo.getPulled_msgId() != 0) {
            contentValues.put("pull_msgid", Long.valueOf(imMessageCenterPojo.getPulled_msgId()));
        }
        BdLog.i("sql-" + contentValues);
        if (t77.d().update("tb_message_center", contentValues, "gid=? AND custom_group_type=?", new String[]{imMessageCenterPojo.getGid(), String.valueOf(imMessageCenterPojo.getCustomGroupType())}) != 0) {
            BdLog.i("insert");
            t77.d().insert("tb_message_center", null, contentValues);
        }
    }

    public final void o(ImMessageCenterPojo imMessageCenterPojo, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, imMessageCenterPojo, str) == null) || imMessageCenterPojo == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            imMessageCenterPojo.setBjhAvatar(jSONObject.optString("bjhAvatar", null));
            imMessageCenterPojo.setShowOutOfStranger(jSONObject.optInt("key_show_out_of_stranger", 0));
            String optString = jSONObject.optString("key_user_extra_data");
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            up4 up4Var = new up4();
            up4Var.a(optString);
            imMessageCenterPojo.setImUserExtraData(up4Var);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
