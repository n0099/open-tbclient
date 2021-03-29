package d.b.i0.d1.h;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.data.MsgLocalData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes3.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public String f53773a;

    /* renamed from: b  reason: collision with root package name */
    public Class<? extends ChatMessage> f53774b;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f53775c = null;

    public a(String str, Class<? extends ChatMessage> cls) {
        this.f53773a = str;
        this.f53774b = cls;
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x006d: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:36:0x006d */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Void a(LinkedList<String> linkedList) {
        Cursor cursor;
        Cursor cursor2;
        Iterator<String> it;
        Cursor cursor3 = null;
        if (linkedList == null || linkedList.size() == 0) {
            return null;
        }
        LinkedList linkedList2 = new LinkedList();
        try {
            try {
                cursor = h.e().h("select * from sqlite_master where type='table'", null);
                if (cursor != null) {
                    try {
                        cursor.moveToFirst();
                        while (cursor.moveToNext()) {
                            linkedList2.add(cursor.getString(cursor.getColumnIndex("name")));
                        }
                    } catch (Exception e2) {
                        e = e2;
                        TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.createMsgTable", new Object[0]);
                        e.printStackTrace();
                        d.b.b.e.p.m.a(cursor);
                        it = linkedList.iterator();
                        while (it.hasNext()) {
                        }
                        return null;
                    }
                }
            } catch (Throwable th) {
                th = th;
                cursor3 = cursor2;
                d.b.b.e.p.m.a(cursor3);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            d.b.b.e.p.m.a(cursor3);
            throw th;
        }
        d.b.b.e.p.m.a(cursor);
        it = linkedList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!TextUtils.isEmpty(next) && !linkedList2.contains(next)) {
                b(next);
            }
        }
        return null;
    }

    public synchronized void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        h.e().d("CREATE TABLE IF NOT EXISTS " + (this.f53773a + str) + "(mid BIGINT PRIMARY KEY, uid TEXT, user_info blob, to_uid TEXT, to_user_info blob, create_time BIGINT, msg_type int, " + IMConstants.MSG_STATUS + " int, content blob, ext blob, read_flag int default 0, is_delete int default 0, rid BIGINT, is_friend int default 1, read_count LONG default -1);");
    }

    public boolean c(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            h.e().b(this.f53773a + str, "mid=?", new String[]{str2});
            return true;
        } catch (Exception e2) {
            TiebaStatic.printDBExceptionLog(e2, "PersonalMsgDao.deleteMsgByMid", new Object[0]);
            return false;
        }
    }

    public boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.f53775c == null) {
            this.f53775c = h();
        }
        List<String> list = this.f53775c;
        if (list != null && list.contains(str)) {
            Iterator<String> it = this.f53775c.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (next.equals(str)) {
                    this.f53775c.remove(next);
                    break;
                }
            }
        }
        String str2 = this.f53773a + str;
        return h.e().d("delete from " + str2);
    }

    public boolean e(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.f53775c == null) {
            this.f53775c = h();
        }
        List<String> list = this.f53775c;
        if (list != null && list.contains(str)) {
            Iterator<String> it = this.f53775c.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (next.equals(str)) {
                    this.f53775c.remove(next);
                    break;
                }
            }
        }
        String str2 = this.f53773a + str;
        return h.e().d("DROP TABLE IF EXISTS " + str2);
    }

    public LinkedHashMap<String, String> f(String str, int i, String str2, int i2) {
        Cursor cursor;
        Cursor h2;
        Cursor cursor2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int i3 = i2 <= 0 ? 20 : i2;
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        String str3 = this.f53773a + str;
        try {
            try {
                if (TextUtils.isEmpty(str2)) {
                    h2 = h.e().h("select * from " + str3 + " WHERE msg_type=? AND is_delete=? ORDER BY rid DESC LIMIT " + i3, new String[]{String.valueOf(i), String.valueOf(0)});
                } else {
                    h2 = h.e().h("select * from " + str3 + " WHERE mid <=? AND msg_type=? AND is_delete=? ORDER BY rid DESC LIMIT " + i3, new String[]{str2, String.valueOf(i), String.valueOf(0)});
                }
                cursor = h2;
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        try {
                            linkedHashMap.put(cursor.getString(cursor.getColumnIndex("mid")), cursor.getString(cursor.getColumnIndex("content")));
                        } catch (SQLiteException e2) {
                            e = e2;
                            TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.getAllByMsgType" + i, new Object[0]);
                            e.printStackTrace();
                            b(str);
                            d.b.b.e.p.m.a(cursor);
                            return linkedHashMap;
                        } catch (Exception e3) {
                            e = e3;
                            TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.getAllByMsgType" + i, new Object[0]);
                            e.printStackTrace();
                            d.b.b.e.p.m.a(cursor);
                            return linkedHashMap;
                        }
                    }
                }
            } catch (Throwable th) {
                th = th;
                d.b.b.e.p.m.a(cursor2);
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
            cursor2 = null;
            d.b.b.e.p.m.a(cursor2);
            throw th;
        }
        d.b.b.e.p.m.a(cursor);
        return linkedHashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0113 A[EXC_TOP_SPLITTER, LOOP:0: B:53:0x0113->B:30:0x01f1, LOOP_START, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public LinkedList<ChatMessage> g(long j, String str, String str2, int i) {
        Cursor cursor;
        Cursor h2;
        Cursor cursor2 = null;
        if (j == 0) {
            return null;
        }
        String valueOf = String.valueOf(j);
        int i2 = i <= 0 ? 20 : i;
        LinkedList<ChatMessage> linkedList = new LinkedList<>();
        String str3 = this.f53773a + valueOf;
        try {
            try {
            } catch (Throwable th) {
                th = th;
                d.b.b.e.p.m.a(cursor2);
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
            d.b.b.e.p.m.a(cursor2);
            throw th;
        }
        if (!TextUtils.isEmpty(str2) && !"0".equals(str2)) {
            h2 = h.e().h("select * from " + str3 + " WHERE rid<? AND is_delete=? ORDER BY rid DESC LIMIT " + i2, new String[]{str2, String.valueOf(0)});
            cursor = h2;
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    try {
                        ChatMessage newInstance = this.f53774b.newInstance();
                        newInstance.setGroupId(String.valueOf(d.b.i0.d1.s.a.i));
                        newInstance.setContent(cursor.getString(cursor.getColumnIndex("content")));
                        newInstance.setTime(cursor.getLong(cursor.getColumnIndex("create_time")));
                        newInstance.setExtra(cursor.getString(cursor.getColumnIndex("ext")));
                        newInstance.setMsgId(cursor.getLong(cursor.getColumnIndex("mid")));
                        newInstance.setUserId(cursor.getLong(cursor.getColumnIndex("uid")));
                        newInstance.setUserInfo((UserData) OrmObject.objectWithJsonStr(cursor.getString(cursor.getColumnIndex("user_info")), UserData.class));
                        newInstance.setToUserId(cursor.getLong(cursor.getColumnIndex("to_uid")));
                        newInstance.setToUserInfo((UserData) OrmObject.objectWithJsonStr(cursor.getString(cursor.getColumnIndex("to_user_info")), UserData.class));
                        MsgLocalData msgLocalData = new MsgLocalData();
                        newInstance.setLocalData(msgLocalData);
                        msgLocalData.setStatus(Short.valueOf((short) cursor.getInt(cursor.getColumnIndex(IMConstants.MSG_STATUS))));
                        newInstance.setMsgType(cursor.getInt(cursor.getColumnIndex("msg_type")));
                        newInstance.setRecordId(cursor.getLong(cursor.getColumnIndex("rid")));
                        d.b.i0.d1.w.c.n(newInstance);
                        newInstance.setIsFriend(cursor.getInt(cursor.getColumnIndex("is_friend")));
                        int columnIndex = cursor.getColumnIndex("read_count");
                        if (columnIndex >= 0) {
                            newInstance.setReadCountPv(cursor.getInt(columnIndex));
                        }
                        linkedList.addFirst(newInstance);
                    } catch (SQLiteException e4) {
                        e = e4;
                        TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.getAll", new Object[0]);
                        e.printStackTrace();
                        b(valueOf);
                        d.b.b.e.p.m.a(cursor);
                        return linkedList;
                    } catch (Exception e5) {
                        e = e5;
                        TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.getAll", new Object[0]);
                        e.printStackTrace();
                        d.b.b.e.p.m.a(cursor);
                        return linkedList;
                    }
                }
            }
            d.b.b.e.p.m.a(cursor);
            return linkedList;
        }
        if (TextUtils.isEmpty(str)) {
            h2 = h.e().h("select * from " + str3 + " WHERE is_delete=? ORDER BY rid DESC, mid DESC LIMIT " + i2, new String[]{String.valueOf(0)});
        } else {
            h2 = h.e().h("select * from " + str3 + " WHERE mid<? AND is_delete=? ORDER BY rid DESC, mid DESC LIMIT " + i2, new String[]{str, String.valueOf(0)});
        }
        cursor = h2;
        if (cursor != null) {
        }
        d.b.b.e.p.m.a(cursor);
        return linkedList;
    }

    public LinkedList<String> h() {
        LinkedList<String> linkedList = new LinkedList<>();
        Cursor cursor = null;
        try {
            try {
                cursor = h.e().h("select * from sqlite_master where type='table'", null);
                if (cursor != null) {
                    cursor.moveToFirst();
                    while (cursor.moveToNext()) {
                        String string = cursor.getString(cursor.getColumnIndex("name"));
                        if (string.startsWith(this.f53773a)) {
                            linkedList.add(string.subSequence(this.f53773a.length(), string.length()).toString());
                        }
                    }
                }
            } catch (Exception e2) {
                TiebaStatic.printDBExceptionLog(e2, "PersonalMsgDao.getChatUserIdSync", new Object[0]);
                e2.printStackTrace();
            }
            return linkedList;
        } finally {
            d.b.b.e.p.m.a(cursor);
        }
    }

    public long i(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        Cursor cursor = null;
        try {
            try {
                cursor = h.e().h("select max(mid) from " + (this.f53773a + str), null);
                if (cursor != null && cursor.moveToNext()) {
                    return cursor.getLong(0);
                }
            } catch (SQLiteException e2) {
                TiebaStatic.printDBExceptionLog(e2, "PersonalMsgDao.getMaxLastMid", new Object[0]);
                e2.printStackTrace();
                b(str);
            } catch (Exception e3) {
                TiebaStatic.printDBExceptionLog(e3, "PersonalMsgDao.getMaxLastMid", new Object[0]);
                e3.printStackTrace();
            }
            return 0L;
        } finally {
            d.b.b.e.p.m.a(cursor);
        }
    }

    public CommonMsgPojo j(String str) {
        Cursor cursor;
        Cursor cursor2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String str2 = this.f53773a + str;
        try {
            try {
                cursor = h.e().h("select * from " + str2 + " WHERE is_delete=? ORDER BY rid DESC LIMIT 1", new String[]{String.valueOf(0)});
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
                        d.b.b.e.p.m.a(cursor);
                        return commonMsgPojo;
                    }
                } catch (SQLiteException e2) {
                    e = e2;
                    TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.getNewestMsgContext", new Object[0]);
                    e.printStackTrace();
                    b(str);
                    d.b.b.e.p.m.a(cursor);
                    return null;
                } catch (Exception e3) {
                    e = e3;
                    TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.getNewestMsgContext", new Object[0]);
                    e.printStackTrace();
                    d.b.b.e.p.m.a(cursor);
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                cursor2 = str2;
                d.b.b.e.p.m.a(cursor2);
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
            d.b.b.e.p.m.a(cursor2);
            throw th;
        }
        d.b.b.e.p.m.a(cursor);
        return null;
    }

    public LinkedList<ChatMessage> k(Map<String, d.b.i0.d1.h.o.a> map, int i) {
        Cursor cursor = null;
        if (map == null || map.size() <= 0) {
            return null;
        }
        Set<String> keySet = map.keySet();
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM(");
        Iterator<String> it = keySet.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            sb.append("SELECT * FROM ");
            sb.append(this.f53773a + it.next());
            sb.append(" WHERE ");
            sb.append("msg_type");
            sb.append(" = 7");
            sb.append(" AND ");
            sb.append("is_delete");
            sb.append(" = ");
            sb.append(0);
            int i3 = i2 + 1;
            if (i2 != map.size() - 1) {
                sb.append(" UNION ALL ");
            }
            i2 = i3;
        }
        sb.append(") ORDER BY ");
        sb.append("create_time");
        sb.append(" DESC LIMIT ?");
        LinkedList<ChatMessage> linkedList = new LinkedList<>();
        try {
            try {
                cursor = h.e().h(sb.toString(), new String[]{String.valueOf(i)});
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        ChatMessage newInstance = this.f53774b.newInstance();
                        newInstance.setObjContent(map.get(cursor.getString(cursor.getColumnIndex("uid"))));
                        newInstance.setContent(cursor.getString(cursor.getColumnIndex("content")));
                        newInstance.setTime(cursor.getLong(cursor.getColumnIndex("create_time")));
                        newInstance.setExtra(cursor.getString(cursor.getColumnIndex("ext")));
                        newInstance.setMsgId(cursor.getLong(cursor.getColumnIndex("mid")));
                        newInstance.setUserId(cursor.getLong(cursor.getColumnIndex("uid")));
                        newInstance.setUserInfo((UserData) OrmObject.objectWithJsonStr(cursor.getString(cursor.getColumnIndex("user_info")), UserData.class));
                        newInstance.setToUserId(cursor.getLong(cursor.getColumnIndex("to_uid")));
                        newInstance.setToUserInfo((UserData) OrmObject.objectWithJsonStr(cursor.getString(cursor.getColumnIndex("to_user_info")), UserData.class));
                        MsgLocalData msgLocalData = new MsgLocalData();
                        newInstance.setLocalData(msgLocalData);
                        msgLocalData.setStatus(Short.valueOf((short) cursor.getInt(cursor.getColumnIndex(IMConstants.MSG_STATUS))));
                        newInstance.setMsgType(cursor.getInt(cursor.getColumnIndex("msg_type")));
                        newInstance.setRecordId(cursor.getLong(cursor.getColumnIndex("rid")));
                        newInstance.setIsFriend(cursor.getInt(cursor.getColumnIndex("is_friend")));
                        int columnIndex = cursor.getColumnIndex("read_count");
                        if (columnIndex >= 0) {
                            newInstance.setReadCountPv(cursor.getInt(columnIndex));
                        }
                        linkedList.add(newInstance);
                    }
                }
            } catch (SQLiteException e2) {
                TiebaStatic.printDBExceptionLog(e2, "OfficialMsgDao.getOfficialMsgByGid", new Object[0]);
                e2.printStackTrace();
            } catch (Exception e3) {
                TiebaStatic.printDBExceptionLog(e3, "OfficialMsgDao.getOfficialMsgByGid", new Object[0]);
                e3.printStackTrace();
            }
            return linkedList;
        } finally {
            d.b.b.e.p.m.a(cursor);
        }
    }

    public int l(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        Cursor cursor = null;
        try {
            try {
                cursor = h.e().h("select count(*) from " + (this.f53773a + str) + " WHERE read_flag=? AND is_delete=?", new String[]{String.valueOf(1), String.valueOf(0)});
                if (cursor != null && cursor.moveToNext()) {
                    return cursor.getInt(0);
                }
            } catch (SQLiteException e2) {
                TiebaStatic.printDBExceptionLog(e2, "PersonalMsgDao.getUnreadcount", new Object[0]);
                e2.printStackTrace();
            } catch (Exception e3) {
                TiebaStatic.printDBExceptionLog(e3, "PersonalMsgDao.getUnreadcount", new Object[0]);
                e3.printStackTrace();
            }
            return 0;
        } finally {
            d.b.b.e.p.m.a(cursor);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x01ec A[Catch: all -> 0x0285, Exception -> 0x028a, TRY_LEAVE, TryCatch #11 {Exception -> 0x028a, all -> 0x0285, blocks: (B:40:0x013e, B:42:0x01ec), top: B:83:0x013e }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0276  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean m(long j, List<CommonMsgPojo> list, boolean z) {
        Cursor cursor;
        SQLiteStatement sQLiteStatement;
        SQLiteStatement sQLiteStatement2;
        String str;
        String str2;
        SQLiteStatement sQLiteStatement3;
        ContentValues contentValues;
        String str3;
        String str4 = "rid";
        String str5 = "msg_type";
        if (list == null || j == 0 || TbadkCoreApplication.getCurrentAccount() == null) {
            return false;
        }
        String valueOf = String.valueOf(j);
        String str6 = this.f53773a + valueOf;
        if (this.f53775c == null) {
            this.f53775c = h();
        }
        if (!this.f53775c.contains(valueOf)) {
            b(valueOf);
            this.f53775c.add(valueOf);
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(" INSERT INTO ");
            sb.append(str6);
            sb.append("(");
            sb.append("content");
            sb.append(",");
            sb.append("create_time");
            sb.append(",");
            sb.append("ext");
            sb.append(",");
            sb.append("mid");
            sb.append(",");
            sb.append("uid");
            sb.append(",");
            sb.append("user_info");
            sb.append(",");
            sb.append("to_uid");
            sb.append(",");
            sb.append("to_user_info");
            sb.append(",");
            sb.append(IMConstants.MSG_STATUS);
            sb.append(",");
            sb.append("msg_type");
            sb.append(",");
            sb.append("rid");
            sb.append(",");
            String str7 = "read_flag";
            sb.append(str7);
            sb.append(",");
            String str8 = "is_delete";
            sb.append(str8);
            sb.append(",");
            sb.append("is_friend");
            String str9 = "is_friend";
            sb.append(") VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
            sQLiteStatement = h.e().a(sb.toString());
            try {
                Iterator<CommonMsgPojo> it = list.iterator();
                while (it.hasNext()) {
                    CommonMsgPojo next = it.next();
                    Iterator<CommonMsgPojo> it2 = it;
                    try {
                        if (z) {
                            try {
                                if (next.isSelf() && next.getRid() != 0) {
                                    sQLiteStatement2 = sQLiteStatement;
                                    try {
                                        str = str8;
                                        str2 = str7;
                                        h.e().b(str6, "mid=?", new String[]{String.valueOf(next.getRid())});
                                        contentValues = new ContentValues();
                                        contentValues.put("content", next.getContent());
                                        contentValues.put("create_time", Long.valueOf(next.getCreate_time()));
                                        contentValues.put("ext", next.getExt());
                                        contentValues.put("mid", Long.valueOf(next.getMid()));
                                        contentValues.put("uid", next.getUid());
                                        contentValues.put("user_info", next.getUser_info());
                                        contentValues.put("to_uid", next.getToUid());
                                        contentValues.put("to_user_info", next.getToUser_info());
                                        contentValues.put(IMConstants.MSG_STATUS, Integer.valueOf(next.getMsg_status()));
                                        contentValues.put(str5, Integer.valueOf(next.getMsg_type()));
                                        contentValues.put(str4, Long.valueOf(next.getRid()));
                                        String str10 = str2;
                                        contentValues.put(str10, Integer.valueOf(next.getRead_flag()));
                                        String str11 = str;
                                        contentValues.put(str11, Integer.valueOf(next.getIs_delete()));
                                        String str12 = str9;
                                        contentValues.put(str12, Integer.valueOf(next.getIsFriend()));
                                        str9 = str12;
                                        String str13 = str4;
                                        if (h.e().j(str6, contentValues, "mid=?", new String[]{String.valueOf(next.getMid())}) != 0) {
                                            sQLiteStatement2.clearBindings();
                                            sQLiteStatement3 = sQLiteStatement2;
                                            try {
                                                sQLiteStatement3.bindString(1, next.getContent());
                                                str3 = str5;
                                                sQLiteStatement3.bindLong(2, next.getCreate_time());
                                                sQLiteStatement3.bindString(3, next.getExt());
                                                sQLiteStatement3.bindLong(4, next.getMid());
                                                sQLiteStatement3.bindString(5, next.getUid());
                                                sQLiteStatement3.bindString(6, next.getUser_info());
                                                sQLiteStatement3.bindString(7, next.getToUid());
                                                sQLiteStatement3.bindString(8, next.getToUser_info());
                                                sQLiteStatement3.bindLong(9, next.getMsg_status());
                                                sQLiteStatement3.bindLong(10, next.getMsg_type());
                                                sQLiteStatement3.bindLong(11, next.getRid());
                                                sQLiteStatement3.bindLong(12, next.getRead_flag());
                                                sQLiteStatement3.bindLong(13, next.getIs_delete());
                                                sQLiteStatement3.bindLong(14, next.getIsFriend());
                                                sQLiteStatement3.executeInsert();
                                            } catch (Exception e2) {
                                                e = e2;
                                                sQLiteStatement = sQLiteStatement3;
                                                try {
                                                    TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.insertOrUpdate", new Object[0]);
                                                    e.printStackTrace();
                                                    d.b.b.e.p.m.a(null);
                                                    d.b.b.e.p.m.c(sQLiteStatement);
                                                    return true;
                                                } catch (Throwable th) {
                                                    th = th;
                                                    cursor = null;
                                                    d.b.b.e.p.m.a(cursor);
                                                    d.b.b.e.p.m.c(sQLiteStatement);
                                                    throw th;
                                                }
                                            } catch (Throwable th2) {
                                                th = th2;
                                                sQLiteStatement = sQLiteStatement3;
                                                cursor = null;
                                                d.b.b.e.p.m.a(cursor);
                                                d.b.b.e.p.m.c(sQLiteStatement);
                                                throw th;
                                            }
                                        } else {
                                            str3 = str5;
                                            sQLiteStatement3 = sQLiteStatement2;
                                        }
                                        sQLiteStatement = sQLiteStatement3;
                                        str5 = str3;
                                        str8 = str11;
                                        str7 = str10;
                                        str4 = str13;
                                        it = it2;
                                    } catch (Exception e3) {
                                        e = e3;
                                        sQLiteStatement = sQLiteStatement2;
                                        TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.insertOrUpdate", new Object[0]);
                                        e.printStackTrace();
                                        d.b.b.e.p.m.a(null);
                                        d.b.b.e.p.m.c(sQLiteStatement);
                                        return true;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        sQLiteStatement = sQLiteStatement2;
                                        cursor = null;
                                        d.b.b.e.p.m.a(cursor);
                                        d.b.b.e.p.m.c(sQLiteStatement);
                                        throw th;
                                    }
                                }
                            } catch (Exception e4) {
                                e = e4;
                            } catch (Throwable th4) {
                                th = th4;
                            }
                        }
                        contentValues = new ContentValues();
                        contentValues.put("content", next.getContent());
                        contentValues.put("create_time", Long.valueOf(next.getCreate_time()));
                        contentValues.put("ext", next.getExt());
                        contentValues.put("mid", Long.valueOf(next.getMid()));
                        contentValues.put("uid", next.getUid());
                        contentValues.put("user_info", next.getUser_info());
                        contentValues.put("to_uid", next.getToUid());
                        contentValues.put("to_user_info", next.getToUser_info());
                        contentValues.put(IMConstants.MSG_STATUS, Integer.valueOf(next.getMsg_status()));
                        contentValues.put(str5, Integer.valueOf(next.getMsg_type()));
                        contentValues.put(str4, Long.valueOf(next.getRid()));
                        String str102 = str2;
                        contentValues.put(str102, Integer.valueOf(next.getRead_flag()));
                        String str112 = str;
                        contentValues.put(str112, Integer.valueOf(next.getIs_delete()));
                        String str122 = str9;
                        contentValues.put(str122, Integer.valueOf(next.getIsFriend()));
                        str9 = str122;
                        String str132 = str4;
                        if (h.e().j(str6, contentValues, "mid=?", new String[]{String.valueOf(next.getMid())}) != 0) {
                        }
                        sQLiteStatement = sQLiteStatement3;
                        str5 = str3;
                        str8 = str112;
                        str7 = str102;
                        str4 = str132;
                        it = it2;
                    } catch (Exception e5) {
                        e = e5;
                        sQLiteStatement3 = sQLiteStatement2;
                    } catch (Throwable th5) {
                        th = th5;
                        sQLiteStatement3 = sQLiteStatement2;
                    }
                    str = str8;
                    sQLiteStatement2 = sQLiteStatement;
                    str2 = str7;
                }
                d.b.b.e.p.m.a(null);
                d.b.b.e.p.m.c(sQLiteStatement);
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
            d.b.b.e.p.m.a(cursor);
            d.b.b.e.p.m.c(sQLiteStatement);
            throw th;
        }
    }

    public boolean n(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("is_delete", (Integer) 1);
            h.e().j(this.f53773a + str, contentValues, "mid=?", new String[]{str2});
            return true;
        } catch (Exception e2) {
            TiebaStatic.printDBExceptionLog(e2, "PersonalMsgDao.markDeleteMsgByMid", new Object[0]);
            return false;
        }
    }

    public boolean o(String str) {
        try {
            r(Long.parseLong(str), true);
            return true;
        } catch (Exception e2) {
            TiebaStatic.printDBExceptionLog(e2, "PersonalMsgDao.markDeleteMsgTable", new Object[0]);
            return false;
        }
    }

    public void p() {
        this.f53775c = null;
    }

    public boolean q(String str, int i) {
        String str2;
        Cursor h2;
        Cursor cursor = null;
        cursor = null;
        try {
            try {
                str2 = this.f53773a + str;
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
            d.b.b.e.p.m.a(h2);
            if (string != null) {
                h.e().b(str2, "mid<?", new String[]{string});
            }
            d.b.b.e.p.m.a(h2);
            return true;
        } catch (Exception e3) {
            e = e3;
            cursor = h2;
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "shrink", new Object[0]);
            d.b.b.e.p.m.a(cursor);
            return false;
        } catch (Throwable th2) {
            th = th2;
            cursor = h2;
            d.b.b.e.p.m.a(cursor);
            throw th;
        }
    }

    public void r(long j, boolean z) {
        String str = this.f53773a + j;
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("is_delete", Integer.valueOf(z ? 1 : 0));
            h.e().j(str, contentValues, "uid!=?", new String[]{"0"});
        } catch (Exception e2) {
            TiebaStatic.printDBExceptionLog(e2, "PersonalMsgDao.updateState", new Object[0]);
            e2.printStackTrace();
        }
    }

    public boolean s(long j, long j2, String str, String str2, int i) {
        Boolean bool;
        Boolean bool2 = Boolean.FALSE;
        if (j == 0 || j2 == 0 || TbadkCoreApplication.getCurrentAccount() == null) {
            return false;
        }
        String valueOf = String.valueOf(j);
        if (TbadkCoreApplication.getCurrentAccount().equals(valueOf)) {
            valueOf = String.valueOf(j2);
        }
        String str3 = this.f53773a + valueOf;
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("mid", str2);
            contentValues.put(IMConstants.MSG_STATUS, Integer.valueOf(i));
            if (h.e().j(str3, contentValues, "mid=?", new String[]{str}) > 0) {
                bool = Boolean.TRUE;
            } else {
                bool = Boolean.FALSE;
            }
            bool2 = bool;
        } catch (Exception e2) {
            TiebaStatic.printDBExceptionLog(e2, "PersonalMsgDao.updateState", new Object[0]);
            e2.printStackTrace();
        }
        return bool2.booleanValue();
    }
}
