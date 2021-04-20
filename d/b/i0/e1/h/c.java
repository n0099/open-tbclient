package d.b.i0.e1.h;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.data.MsgLocalData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static c f55299a;

    public static synchronized c h() {
        c cVar;
        synchronized (c.class) {
            if (f55299a == null) {
                f55299a = new c();
            }
            cVar = f55299a;
        }
        return cVar;
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        h.e().d("CREATE TABLE IF NOT EXISTS " + ("tb_group_msg_" + str) + "(mid BIGINT PRIMARY KEY, uid TEXT, user_info blob, create_time BIGINT, msg_type int, " + IMConstants.MSG_STATUS + " int, content blob, ext blob, read_flag int default 0, is_delete int default 0, rid BIGINT);");
    }

    public void b(List<ImMessageCenterPojo> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        Cursor cursor = null;
        try {
            try {
                cursor = h.e().h("select * from sqlite_master where type='table'", null);
                if (cursor != null) {
                    cursor.moveToFirst();
                    while (cursor.moveToNext()) {
                        linkedList.add(cursor.getString(cursor.getColumnIndex("name")));
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                TiebaStatic.printDBExceptionLog(e2, "GroupMsgDao.createMsgTable", new Object[0]);
            }
            for (ImMessageCenterPojo imMessageCenterPojo : list) {
                if (!linkedList.contains("tb_group_msg_" + imMessageCenterPojo.getGid())) {
                    a(imMessageCenterPojo.getGid());
                }
            }
        } finally {
            d.b.c.e.p.m.a(cursor);
        }
    }

    public boolean c(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            h.e().b("tb_group_msg_" + str, "mid=?", new String[]{str2});
            return true;
        } catch (Exception e2) {
            TiebaStatic.printDBExceptionLog(e2, "GroupMsgDao.deleteMsgByMid", new Object[0]);
            return false;
        }
    }

    public boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            h e2 = h.e();
            e2.d("delete from " + ("tb_group_msg_" + str));
            return true;
        } catch (Exception e3) {
            e3.printStackTrace();
            TiebaStatic.printDBExceptionLog(e3, "GroupMsgDao.deleteMsgTableById", new Object[0]);
            return false;
        }
    }

    public boolean e(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            h e2 = h.e();
            e2.d("DROP TABLE IF EXISTS " + ("tb_group_msg_" + str));
        } catch (Exception e3) {
            e3.printStackTrace();
            TiebaStatic.printDBExceptionLog(e3, "GroupMsgDao.dropMsgTableById", new Object[0]);
        }
        return false;
    }

    public LinkedHashMap<String, String> f(String str, int i, String str2, int i2) {
        Cursor h2;
        Cursor cursor = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int i3 = i2 <= 0 ? 20 : i2;
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        String str3 = "tb_group_msg_" + str;
        try {
            try {
                if (TextUtils.isEmpty(str2)) {
                    h2 = h.e().h("select * from " + str3 + " WHERE msg_type=? AND is_delete=? ORDER BY rid DESC LIMIT " + i3, new String[]{String.valueOf(i), String.valueOf(0)});
                } else {
                    h2 = h.e().h("select * from " + str3 + " WHERE mid <=? AND msg_type=? AND is_delete=? ORDER BY rid DESC LIMIT " + i3, new String[]{str2, String.valueOf(i), String.valueOf(0)});
                }
                Cursor cursor2 = h2;
                if (cursor2 != null) {
                    while (cursor2.moveToNext()) {
                        try {
                            linkedHashMap.put(cursor2.getString(cursor2.getColumnIndex("mid")), cursor2.getString(cursor2.getColumnIndex("content")));
                        } catch (SQLiteException e2) {
                            e = e2;
                            cursor = cursor2;
                            e.printStackTrace();
                            TiebaStatic.printDBExceptionLog(e, "GroupMsgDao.getAllByMsgType" + i, new Object[0]);
                            d.b.c.e.p.m.a(cursor);
                            return linkedHashMap;
                        } catch (Exception e3) {
                            e = e3;
                            cursor = cursor2;
                            e.printStackTrace();
                            TiebaStatic.printDBExceptionLog(e, "GroupMsgDao.getAllByMsgType" + i, new Object[0]);
                            d.b.c.e.p.m.a(cursor);
                            return linkedHashMap;
                        } catch (Throwable th) {
                            th = th;
                            cursor = cursor2;
                            d.b.c.e.p.m.a(cursor);
                            throw th;
                        }
                    }
                }
                d.b.c.e.p.m.a(cursor2);
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursor = null;
        } catch (Exception e5) {
            e = e5;
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
        return linkedHashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x010e A[EXC_TOP_SPLITTER, LOOP:0: B:47:0x010e->B:26:0x0114, LOOP_START, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public LinkedList<ChatMessage> g(String str, String str2, String str3, int i) {
        Cursor cursor;
        Cursor h2;
        Cursor cursor2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int i2 = i <= 0 ? 20 : i;
        LinkedList<ChatMessage> linkedList = new LinkedList<>();
        String str4 = "tb_group_msg_" + str;
        try {
            try {
            } catch (Throwable th) {
                th = th;
                d.b.c.e.p.m.a(cursor2);
                throw th;
            }
        } catch (SQLiteException e2) {
            e = e2;
            cursor = null;
        } catch (Exception e3) {
            e = e3;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            cursor2 = null;
            d.b.c.e.p.m.a(cursor2);
            throw th;
        }
        if (!TextUtils.isEmpty(str3) && !"0".equals(str3)) {
            h2 = h.e().h("select * from " + str4 + " WHERE rid<? AND is_delete=? ORDER BY rid DESC LIMIT " + i2, new String[]{str3, String.valueOf(0)});
            cursor = h2;
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    try {
                        CommonGroupChatMessage commonGroupChatMessage = new CommonGroupChatMessage();
                        commonGroupChatMessage.setGroupId(str);
                        commonGroupChatMessage.setContent(cursor.getString(cursor.getColumnIndex("content")));
                        commonGroupChatMessage.setTime(cursor.getLong(cursor.getColumnIndex("create_time")));
                        commonGroupChatMessage.setExtra(cursor.getString(cursor.getColumnIndex("ext")));
                        commonGroupChatMessage.setMsgId(cursor.getLong(cursor.getColumnIndex("mid")));
                        MsgLocalData msgLocalData = new MsgLocalData();
                        commonGroupChatMessage.setLocalData(msgLocalData);
                        msgLocalData.setStatus(Short.valueOf((short) cursor.getInt(cursor.getColumnIndex(IMConstants.MSG_STATUS))));
                        commonGroupChatMessage.setMsgType(cursor.getInt(cursor.getColumnIndex("msg_type")));
                        commonGroupChatMessage.setUserId(cursor.getColumnIndex("uid"));
                        commonGroupChatMessage.setUserInfo((UserData) OrmObject.objectWithJsonStr(cursor.getString(cursor.getColumnIndex("user_info")), UserData.class));
                        commonGroupChatMessage.setRecordId(cursor.getLong(cursor.getColumnIndex("rid")));
                        d.b.i0.e1.w.c.n(commonGroupChatMessage);
                        linkedList.addFirst(commonGroupChatMessage);
                    } catch (SQLiteException e4) {
                        e = e4;
                        e.printStackTrace();
                        TiebaStatic.printDBExceptionLog(e, "GroupMsgDao.getAll", new Object[0]);
                        a(str);
                        d.b.c.e.p.m.a(cursor);
                        return linkedList;
                    } catch (Exception e5) {
                        e = e5;
                        e.printStackTrace();
                        TiebaStatic.printDBExceptionLog(e, "GroupMsgDao.getAll", new Object[0]);
                        d.b.c.e.p.m.a(cursor);
                        return linkedList;
                    }
                }
            }
            d.b.c.e.p.m.a(cursor);
            return linkedList;
        }
        if (TextUtils.isEmpty(str2)) {
            h2 = h.e().h("select * from " + str4 + " WHERE is_delete=? ORDER BY rid DESC, mid DESC LIMIT " + i2, new String[]{String.valueOf(0)});
        } else {
            h2 = h.e().h("select * from " + str4 + " WHERE mid<? AND is_delete=? ORDER BY rid DESC, mid DESC LIMIT " + i2, new String[]{str2, String.valueOf(0)});
        }
        cursor = h2;
        if (cursor != null) {
        }
        d.b.c.e.p.m.a(cursor);
        return linkedList;
    }

    public long i(String str) {
        long j;
        Cursor h2;
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        String str2 = "tb_group_msg_" + str;
        Cursor cursor = null;
        try {
            try {
                Cursor h3 = h.e().h("select max(mid) from " + str2, null);
                if (h3 != null) {
                    try {
                        if (h3.moveToNext()) {
                            j = h3.getLong(0);
                            h2 = h.e().h("select count(*) from " + str2, null);
                            if (((h2 == null && h2.moveToNext()) ? h2.getInt(0) : 0) == 1 || j % 100 == 0) {
                                d.b.c.e.p.m.a(h2);
                                return j;
                            }
                            long a2 = d.b.i0.e1.w.b.a(j);
                            d.b.c.e.p.m.a(h2);
                            return a2;
                        }
                    } catch (SQLiteException e2) {
                        e = e2;
                        cursor = h3;
                        TiebaStatic.printDBExceptionLog(e, "GroupMsgDao.getMaxLastMid", new Object[0]);
                        e.printStackTrace();
                        a(str);
                        d.b.c.e.p.m.a(cursor);
                        return 0L;
                    } catch (Exception e3) {
                        e = e3;
                        cursor = h3;
                        TiebaStatic.printDBExceptionLog(e, "GroupMsgDao.getMaxLastMid", new Object[0]);
                        e.printStackTrace();
                        d.b.c.e.p.m.a(cursor);
                        return 0L;
                    } catch (Throwable th) {
                        th = th;
                        cursor = h3;
                        d.b.c.e.p.m.a(cursor);
                        throw th;
                    }
                }
                j = 0;
                h2 = h.e().h("select count(*) from " + str2, null);
                if (((h2 == null && h2.moveToNext()) ? h2.getInt(0) : 0) == 1) {
                }
                d.b.c.e.p.m.a(h2);
                return j;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (SQLiteException e4) {
            e = e4;
        } catch (Exception e5) {
            e = e5;
        }
    }

    public CommonMsgPojo j(String str) {
        Cursor cursor;
        Cursor cursor2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String str2 = "tb_group_msg_" + str;
        try {
            try {
                cursor = h.e().h("select * from " + str2 + " WHERE is_delete=? ORDER BY rid DESC LIMIT 1", new String[]{String.valueOf(0)});
                try {
                    CommonMsgPojo commonMsgPojo = new CommonMsgPojo();
                    if (cursor != null && cursor.moveToNext()) {
                        commonMsgPojo.setGid(str);
                        commonMsgPojo.setContent(cursor.getString(cursor.getColumnIndex("content")));
                        commonMsgPojo.setCreate_time(cursor.getLong(cursor.getColumnIndex("create_time")));
                        commonMsgPojo.setExt(cursor.getString(cursor.getColumnIndex("ext")));
                        commonMsgPojo.setMid(cursor.getLong(cursor.getColumnIndex("mid")));
                        commonMsgPojo.setMsg_status(cursor.getInt(cursor.getColumnIndex(IMConstants.MSG_STATUS)));
                        commonMsgPojo.setMsg_type(cursor.getInt(cursor.getColumnIndex("msg_type")));
                        commonMsgPojo.setUid(cursor.getString(cursor.getColumnIndex("uid")));
                        commonMsgPojo.setUser_info(cursor.getString(cursor.getColumnIndex("user_info")));
                        commonMsgPojo.setRid(cursor.getLong(cursor.getColumnIndex("rid")));
                        commonMsgPojo.setRead_flag(cursor.getInt(cursor.getColumnIndex("read_flag")));
                        commonMsgPojo.setIs_delete(cursor.getInt(cursor.getColumnIndex("is_delete")));
                        d.b.c.e.p.m.a(cursor);
                        return commonMsgPojo;
                    }
                } catch (SQLiteException e2) {
                    e = e2;
                    e.printStackTrace();
                    TiebaStatic.printDBExceptionLog(e, "GroupMsgDao.getNewestMsgContext", new Object[0]);
                    a(str);
                    d.b.c.e.p.m.a(cursor);
                    return null;
                } catch (Exception e3) {
                    e = e3;
                    e.printStackTrace();
                    TiebaStatic.printDBExceptionLog(e, "GroupMsgDao.getNewestMsgContext", new Object[0]);
                    d.b.c.e.p.m.a(cursor);
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                cursor2 = str2;
                d.b.c.e.p.m.a(cursor2);
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
            d.b.c.e.p.m.a(cursor2);
            throw th;
        }
        d.b.c.e.p.m.a(cursor);
        return null;
    }

    public int k(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        Cursor cursor = null;
        try {
            try {
                cursor = h.e().h("select count(*) from " + ("tb_group_msg_" + str) + " WHERE read_flag=? AND is_delete=?", new String[]{String.valueOf(1), String.valueOf(0)});
                if (cursor != null && cursor.moveToNext()) {
                    return cursor.getInt(0);
                }
            } catch (SQLiteException e2) {
                TiebaStatic.printDBExceptionLog(e2, "GroupMsgDao.getUnreadcount", new Object[0]);
                e2.printStackTrace();
            } catch (Exception e3) {
                TiebaStatic.printDBExceptionLog(e3, "GroupMsgDao.getUnreadcount", new Object[0]);
                e3.printStackTrace();
            }
            return 0;
        } finally {
            d.b.c.e.p.m.a(cursor);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00fa A[Catch: all -> 0x00fe, Exception -> 0x0103, TRY_ENTER, TRY_LEAVE, TryCatch #8 {Exception -> 0x0103, all -> 0x00fe, blocks: (B:25:0x00d0, B:35:0x00fa), top: B:104:0x00d0 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0197 A[Catch: all -> 0x0247, Exception -> 0x024c, TryCatch #11 {Exception -> 0x024c, all -> 0x0247, blocks: (B:32:0x00f2, B:41:0x0108, B:43:0x0197, B:46:0x01a7), top: B:98:0x00f2 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0238  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean l(String str, List<CommonMsgPojo> list, boolean z) {
        Cursor cursor;
        SQLiteStatement sQLiteStatement;
        Iterator<CommonMsgPojo> it;
        String str2;
        SQLiteStatement sQLiteStatement2;
        SQLiteStatement sQLiteStatement3;
        ContentValues contentValues;
        String str3;
        String str4 = "is_delete";
        String str5 = "read_flag";
        String str6 = "rid";
        if (list == null || TextUtils.isEmpty(str) || list == null || list.size() == 0) {
            return false;
        }
        String str7 = "tb_group_msg_" + str;
        try {
            sQLiteStatement = h.e().a(" INSERT INTO " + str7 + "(content,create_time,ext,mid," + IMConstants.MSG_STATUS + ",msg_type,uid,user_info,rid,read_flag,is_delete) VALUES(?,?,?,?,?,?,?,?,?,?,?);");
            try {
                Iterator<CommonMsgPojo> it2 = list.iterator();
                while (it2.hasNext()) {
                    CommonMsgPojo next = it2.next();
                    try {
                        if (z) {
                            try {
                                if (next.isSelf() && next.getRid() != 0) {
                                    it = it2;
                                    str2 = str4;
                                    sQLiteStatement2 = sQLiteStatement;
                                    try {
                                        h.e().b(str7, "mid=?", new String[]{String.valueOf(next.getRid())});
                                        String str8 = "";
                                        if (next.getContent() == null) {
                                            next.setContent("");
                                        }
                                        contentValues = new ContentValues();
                                        contentValues.put("content", next.getContent());
                                        contentValues.put("create_time", Long.valueOf(next.getCreate_time()));
                                        contentValues.put("ext", next.getExt());
                                        contentValues.put("mid", Long.valueOf(next.getMid()));
                                        contentValues.put(IMConstants.MSG_STATUS, Integer.valueOf(next.getMsg_status()));
                                        contentValues.put("msg_type", Integer.valueOf(next.getMsg_type()));
                                        contentValues.put("uid", next.getUid());
                                        contentValues.put("user_info", next.getUser_info());
                                        contentValues.put(str6, Long.valueOf(next.getRid()));
                                        contentValues.put(str5, Integer.valueOf(next.getRead_flag()));
                                        String str9 = str5;
                                        String str10 = str2;
                                        contentValues.put(str10, Integer.valueOf(next.getIs_delete()));
                                        String str11 = str6;
                                        if (h.e().j(str7, contentValues, "mid=?", new String[]{String.valueOf(next.getMid())}) != 0) {
                                            sQLiteStatement2.clearBindings();
                                            sQLiteStatement3 = sQLiteStatement2;
                                            try {
                                                sQLiteStatement3.bindString(1, TextUtils.isEmpty(next.getContent()) ? "" : next.getContent());
                                                str3 = str7;
                                                sQLiteStatement3.bindLong(2, next.getCreate_time());
                                                sQLiteStatement3.bindString(3, TextUtils.isEmpty(next.getExt()) ? "" : next.getExt());
                                                sQLiteStatement3.bindLong(4, next.getMid());
                                                sQLiteStatement3.bindLong(5, next.getMsg_status());
                                                sQLiteStatement3.bindLong(6, next.getMsg_type());
                                                sQLiteStatement3.bindString(7, TextUtils.isEmpty(next.getUid()) ? "" : next.getUid());
                                                if (!TextUtils.isEmpty(next.getUser_info())) {
                                                    str8 = next.getUser_info();
                                                }
                                                sQLiteStatement3.bindString(8, str8);
                                                sQLiteStatement3.bindLong(9, next.getRid());
                                                sQLiteStatement3.bindLong(10, next.getRead_flag());
                                                sQLiteStatement3.bindLong(11, next.getIs_delete());
                                                h.e().f(sQLiteStatement3);
                                            } catch (Exception e2) {
                                                e = e2;
                                                sQLiteStatement = sQLiteStatement3;
                                                try {
                                                    e.printStackTrace();
                                                    TiebaStatic.printDBExceptionLog(e, "GroupMsgDao.insertOrUpdate", new Object[0]);
                                                    d.b.c.e.p.m.a(null);
                                                    d.b.c.e.p.m.c(sQLiteStatement);
                                                    return false;
                                                } catch (Throwable th) {
                                                    th = th;
                                                    cursor = null;
                                                    d.b.c.e.p.m.a(cursor);
                                                    d.b.c.e.p.m.c(sQLiteStatement);
                                                    throw th;
                                                }
                                            } catch (Throwable th2) {
                                                th = th2;
                                                sQLiteStatement = sQLiteStatement3;
                                                cursor = null;
                                                d.b.c.e.p.m.a(cursor);
                                                d.b.c.e.p.m.c(sQLiteStatement);
                                                throw th;
                                            }
                                        } else {
                                            str3 = str7;
                                            sQLiteStatement3 = sQLiteStatement2;
                                        }
                                        it2 = it;
                                        sQLiteStatement = sQLiteStatement3;
                                        str7 = str3;
                                        str4 = str10;
                                        str5 = str9;
                                        str6 = str11;
                                    } catch (Exception e3) {
                                        e = e3;
                                        sQLiteStatement = sQLiteStatement2;
                                        e.printStackTrace();
                                        TiebaStatic.printDBExceptionLog(e, "GroupMsgDao.insertOrUpdate", new Object[0]);
                                        d.b.c.e.p.m.a(null);
                                        d.b.c.e.p.m.c(sQLiteStatement);
                                        return false;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        sQLiteStatement = sQLiteStatement2;
                                        cursor = null;
                                        d.b.c.e.p.m.a(cursor);
                                        d.b.c.e.p.m.c(sQLiteStatement);
                                        throw th;
                                    }
                                }
                            } catch (Exception e4) {
                                e = e4;
                            } catch (Throwable th4) {
                                th = th4;
                            }
                        }
                        String str82 = "";
                        if (next.getContent() == null) {
                        }
                        contentValues = new ContentValues();
                        contentValues.put("content", next.getContent());
                        contentValues.put("create_time", Long.valueOf(next.getCreate_time()));
                        contentValues.put("ext", next.getExt());
                        contentValues.put("mid", Long.valueOf(next.getMid()));
                        contentValues.put(IMConstants.MSG_STATUS, Integer.valueOf(next.getMsg_status()));
                        contentValues.put("msg_type", Integer.valueOf(next.getMsg_type()));
                        contentValues.put("uid", next.getUid());
                        contentValues.put("user_info", next.getUser_info());
                        contentValues.put(str6, Long.valueOf(next.getRid()));
                        contentValues.put(str5, Integer.valueOf(next.getRead_flag()));
                        String str92 = str5;
                        String str102 = str2;
                        contentValues.put(str102, Integer.valueOf(next.getIs_delete()));
                        String str112 = str6;
                        if (h.e().j(str7, contentValues, "mid=?", new String[]{String.valueOf(next.getMid())}) != 0) {
                        }
                        it2 = it;
                        sQLiteStatement = sQLiteStatement3;
                        str7 = str3;
                        str4 = str102;
                        str5 = str92;
                        str6 = str112;
                    } catch (Exception e5) {
                        e = e5;
                        sQLiteStatement3 = sQLiteStatement2;
                    } catch (Throwable th5) {
                        th = th5;
                        sQLiteStatement3 = sQLiteStatement2;
                    }
                    str2 = str4;
                    sQLiteStatement2 = sQLiteStatement;
                    it = it2;
                }
                d.b.c.e.p.m.a(null);
                d.b.c.e.p.m.c(sQLiteStatement);
                return true;
            } catch (Exception e6) {
                e = e6;
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Exception e7) {
            e = e7;
            sQLiteStatement = null;
        } catch (Throwable th7) {
            th = th7;
            cursor = null;
            sQLiteStatement = null;
            d.b.c.e.p.m.a(cursor);
            d.b.c.e.p.m.c(sQLiteStatement);
            throw th;
        }
    }

    public boolean m(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("is_delete", (Integer) 1);
            h.e().j("tb_group_msg_" + str, contentValues, "mid=?", new String[]{str2});
            return true;
        } catch (Exception e2) {
            TiebaStatic.printDBExceptionLog(e2, "GroupMsgDao.markDeleteMsgByMid", new Object[0]);
            return false;
        }
    }

    public boolean n(String str, int i) {
        String str2;
        Cursor h2;
        Cursor cursor = null;
        cursor = null;
        try {
            try {
                str2 = "tb_group_msg_" + str;
                if (i < 1000) {
                    i = 1000;
                }
                h2 = h.e().h("SELECT * FROM " + str2 + " ORDER BY mid DESC LIMIT " + i + ", 1", null);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e2) {
            e = e2;
        }
        try {
            String string = h2.moveToNext() ? h2.getString(h2.getColumnIndex("mid")) : null;
            d.b.c.e.p.m.a(h2);
            if (string != null) {
                h.e().b(str2, "mid<?", new String[]{string});
            }
            d.b.c.e.p.m.a(h2);
            return true;
        } catch (Exception e3) {
            e = e3;
            cursor = h2;
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "shrink", new Object[0]);
            d.b.c.e.p.m.a(cursor);
            return false;
        } catch (Throwable th2) {
            th = th2;
            cursor = h2;
            d.b.c.e.p.m.a(cursor);
            throw th;
        }
    }

    public boolean o(String str, String str2, String str3, int i) {
        Boolean bool;
        Boolean bool2 = Boolean.FALSE;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return false;
        }
        String str4 = "tb_group_msg_" + str;
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("mid", str3);
            contentValues.put(IMConstants.MSG_STATUS, Integer.valueOf(i));
            if (h.e().j(str4, contentValues, "mid=?", new String[]{str2}) > 0) {
                bool = Boolean.TRUE;
            } else {
                bool = Boolean.FALSE;
            }
            bool2 = bool;
        } catch (Exception e2) {
            TiebaStatic.printDBExceptionLog(e2, "GroupMsgDao.updateState", new Object[0]);
            e2.printStackTrace();
        }
        return bool2.booleanValue();
    }
}
