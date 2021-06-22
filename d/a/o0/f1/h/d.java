package d.a.o0.f1.h;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.data.UpdatesItemData;
import com.baidu.tieba.im.data.ValidateItemData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.model.ModelHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static d f58287a;

    public static d f() {
        if (f58287a == null) {
            f58287a = new d();
        }
        return f58287a;
    }

    public boolean a(String str) {
        Boolean bool;
        try {
            h.e().b("tb_group_news", "notice_id = ?", new String[]{str});
            bool = Boolean.TRUE;
        } catch (Exception e2) {
            TiebaStatic.printDBExceptionLog(e2, "GroupNewsDao.deleteByNoticeId", new Object[0]);
            e2.printStackTrace();
            bool = Boolean.FALSE;
        }
        return bool.booleanValue();
    }

    public boolean b(List<UpdatesItemData> list) {
        Boolean bool = Boolean.FALSE;
        if (list == null || list.isEmpty()) {
            return false;
        }
        try {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                UpdatesItemData updatesItemData = list.get(i2);
                if (updatesItemData != null) {
                    h.e().b("tb_group_news", "notice_id=?", new String[]{updatesItemData.getNotice_id()});
                }
            }
        } catch (Exception e2) {
            TiebaStatic.printDBExceptionLog(e2, "GroupNewsDao.deleteByUpdatesData", new Object[0]);
            e2.printStackTrace();
            bool = Boolean.FALSE;
        }
        return bool.booleanValue();
    }

    public LinkedList<GroupNewsPojo> c(long j, int i2, int i3, String str) {
        Cursor h2;
        if (i3 < 0) {
            i3 = 0;
        }
        LinkedList<GroupNewsPojo> linkedList = new LinkedList<>();
        if (i2 <= 0) {
            i2 = 20;
        }
        Cursor cursor = null;
        try {
            try {
                if (j <= 0) {
                    if (TextUtils.isEmpty(str)) {
                        h2 = h.e().h("select * from tb_group_news ORDER BY time DESC LIMIT " + i2 + " OFFSET " + i3, null);
                    } else {
                        h2 = h.e().h(String.format("select * from tb_group_news WHERE cmd IN ( '%1$s' ) ORDER BY time DESC LIMIT " + i2 + " OFFSET " + i3, str), null);
                    }
                } else if (TextUtils.isEmpty(str)) {
                    h2 = h.e().h("select * from tb_group_news WHERE time <=? ORDER BY time DESC LIMIT " + i2 + " OFFSET " + i3, new String[]{String.valueOf(j)});
                } else {
                    h2 = h.e().h("select * from tb_group_news WHERE time <=? AND cmd IN ( ? ) ORDER BY time DESC LIMIT " + i2 + " OFFSET " + i3, new String[]{String.valueOf(j), str});
                }
                cursor = h2;
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
            d.a.c.e.p.m.a(cursor);
            return m(linkedList);
        } catch (Throwable th) {
            d.a.c.e.p.m.a(cursor);
            throw th;
        }
    }

    public GroupNewsPojo d(String str) {
        GroupNewsPojo groupNewsPojo;
        Exception e2;
        Cursor cursor;
        Cursor cursor2 = null;
        r1 = null;
        GroupNewsPojo groupNewsPojo2 = null;
        try {
            cursor = h.e().h("select * from tb_group_news WHERE notice_id = ?", new String[]{str});
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    try {
                        try {
                            groupNewsPojo = new GroupNewsPojo();
                        } catch (Exception e3) {
                            groupNewsPojo = groupNewsPojo2;
                            e2 = e3;
                        }
                        try {
                            groupNewsPojo.setCmd(cursor.getString(cursor.getColumnIndex("cmd")));
                            groupNewsPojo.setContent(cursor.getString(cursor.getColumnIndex("content")));
                            groupNewsPojo.setContent_status(cursor.getInt(cursor.getColumnIndex("content_status")));
                            groupNewsPojo.setExt(cursor.getString(cursor.getColumnIndex("ext")));
                            groupNewsPojo.setGid(cursor.getString(cursor.getColumnIndex("gid")));
                            groupNewsPojo.setNotice_id(cursor.getString(cursor.getColumnIndex("notice_id")));
                            groupNewsPojo.setTime(cursor.getLong(cursor.getColumnIndex("time")));
                            groupNewsPojo2 = groupNewsPojo;
                        } catch (Exception e4) {
                            e2 = e4;
                            e2.printStackTrace();
                            TiebaStatic.printDBExceptionLog(e2, "GroupNewsDao.getByNoticeId", new Object[0]);
                            d.a.c.e.p.m.a(cursor);
                            return groupNewsPojo;
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor2 = cursor;
                        d.a.c.e.p.m.a(cursor2);
                        throw th;
                    }
                }
            }
            d.a.c.e.p.m.a(cursor);
            return groupNewsPojo2;
        } catch (Exception e5) {
            groupNewsPojo = null;
            e2 = e5;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            d.a.c.e.p.m.a(cursor2);
            throw th;
        }
    }

    public int e(String str) {
        Cursor cursor = null;
        int i2 = 0;
        try {
            try {
                cursor = h.e().h(String.format("select count(*) from tb_group_news WHERE cmd IN ( '%1$s' )", str), null);
                i2 = cursor.moveToFirst() ? cursor.getInt(0) : -1;
            } catch (SQLiteException e2) {
                TiebaStatic.printDBExceptionLog(e2, "GroupNewsDao.getCountByCmd", new Object[0]);
                e2.printStackTrace();
            } catch (Exception e3) {
                TiebaStatic.printDBExceptionLog(e3, "GroupNewsDao.getCountByCmd", new Object[0]);
                e3.printStackTrace();
            }
            return i2;
        } finally {
            d.a.c.e.p.m.a(cursor);
        }
    }

    public int g(String str, int i2) {
        Cursor cursor = null;
        int i3 = 0;
        try {
            try {
                cursor = h.e().h(String.format("select count(*) from tb_group_news WHERE cmd IN ( '%1$s' ) and content_status = %2$s", str, "" + i2), null);
                i3 = cursor.moveToFirst() ? cursor.getInt(0) : -1;
            } catch (SQLiteException e2) {
                TiebaStatic.printDBExceptionLog(e2, "GroupNewsDao.getNewCountByCmd", new Object[0]);
                e2.printStackTrace();
            } catch (Exception e3) {
                TiebaStatic.printDBExceptionLog(e3, "GroupNewsDao.getNewCountByCmd", new Object[0]);
                e3.printStackTrace();
            }
            return i3;
        } finally {
            d.a.c.e.p.m.a(cursor);
        }
    }

    public int h(String str, int i2) {
        try {
            if (!TextUtils.isEmpty(str)) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("content_status", (Integer) 3);
                return h.e().j("tb_group_news", contentValues, "notice_id= ?", new String[]{str});
            }
        } catch (Exception e2) {
            TiebaStatic.printDBExceptionLog(e2, "GroupNewsDao.hideByNoticeIdSync", new Object[0]);
            e2.printStackTrace();
        }
        return 0;
    }

    public final long i(GroupNewsPojo groupNewsPojo) {
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
                SQLiteStatement a2 = h.e().a(stringBuffer.toString());
                if (a2 == null) {
                    d.a.c.e.p.m.c(a2);
                    return -1L;
                }
                a2.clearBindings();
                f.b(a2, 1, groupNewsPojo.getCmd());
                f.b(a2, 2, groupNewsPojo.getContent());
                a2.bindLong(3, groupNewsPojo.getContent_status());
                f.b(a2, 4, groupNewsPojo.getExt());
                f.b(a2, 5, groupNewsPojo.getGid());
                f.b(a2, 6, groupNewsPojo.getNotice_id());
                a2.bindLong(7, groupNewsPojo.getTime());
                long executeInsert = a2.executeInsert();
                d.a.c.e.p.m.c(a2);
                return executeInsert;
            } catch (Exception e2) {
                TiebaStatic.printDBExceptionLog(e2, "GroupNewsDao.insertByStatement", new Object[0]);
                d.a.c.e.p.m.c(null);
                return -1L;
            }
        } catch (Throwable th) {
            d.a.c.e.p.m.c(null);
            throw th;
        }
    }

    public boolean j(ValidateItemData validateItemData) {
        List<ValidateItemData> convertToValidateItemDataList;
        if (validateItemData == null || ModelHelper.getInstance().getValidateModel() == null || (convertToValidateItemDataList = ModelHelper.getInstance().getValidateModel().convertToValidateItemDataList(c(0L, Integer.MAX_VALUE, 0, "apply_join_group"))) == null || convertToValidateItemDataList.size() == 0) {
            return false;
        }
        int size = convertToValidateItemDataList.size();
        LinkedList<GroupNewsPojo> linkedList = new LinkedList<>();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            ValidateItemData validateItemData2 = convertToValidateItemDataList.get(i3);
            if (validateItemData2.getGroupId().equals(validateItemData.getGroupId()) && validateItemData2.getUserId().equals(validateItemData.getUserId()) && validateItemData.isPass()) {
                validateItemData2.setPass(true);
                if (validateItemData.isShown()) {
                    validateItemData2.setShown(true);
                }
                linkedList.add(validateItemData2.toGroupNewsPojo());
                i2++;
            }
        }
        BdLog.i("affectCount:" + i2);
        return n(linkedList).booleanValue();
    }

    public void k(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("content_status", (Integer) 2);
            h.e().j("tb_group_news", contentValues, "cmd=?", new String[]{str});
        } catch (Exception e2) {
            TiebaStatic.printDBExceptionLog(e2, "GroupNewsDao.markReadByCmd", new Object[0]);
            e2.printStackTrace();
        }
    }

    public boolean l(String str, int i2) {
        Cursor h2;
        Cursor cursor = null;
        cursor = null;
        try {
            if (i2 < 1000) {
                i2 = 1000;
            }
            try {
                h e2 = h.e();
                h2 = e2.h("SELECT * FROM tb_group_news ORDER BY notice_id DESC LIMIT " + i2 + ", 1", null);
            } catch (Exception e3) {
                e = e3;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            String string = h2.moveToNext() ? h2.getString(h2.getColumnIndex("notice_id")) : null;
            d.a.c.e.p.m.a(h2);
            if (string != null) {
                h.e().b("tb_group_news", "notice_id<?", new String[]{string});
            }
            d.a.c.e.p.m.a(h2);
            return true;
        } catch (Exception e4) {
            e = e4;
            cursor = h2;
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "shrink", new Object[0]);
            d.a.c.e.p.m.a(cursor);
            return false;
        } catch (Throwable th2) {
            th = th2;
            cursor = h2;
            d.a.c.e.p.m.a(cursor);
            throw th;
        }
    }

    public final LinkedList<GroupNewsPojo> m(LinkedList<GroupNewsPojo> linkedList) {
        LinkedList<GroupNewsPojo> linkedList2 = new LinkedList<>();
        ArrayList arrayList = new ArrayList();
        int size = linkedList.size();
        for (int i2 = 0; i2 < size; i2++) {
            GroupNewsPojo groupNewsPojo = linkedList.get(i2);
            boolean z = false;
            for (int i3 = 0; i3 < linkedList2.size(); i3++) {
                if (linkedList2.get(i3).getContent().equals(groupNewsPojo.getContent())) {
                    z = true;
                }
            }
            if (z) {
                arrayList.add(groupNewsPojo.getNotice_id());
            } else {
                linkedList2.add(groupNewsPojo);
            }
            int size2 = arrayList.size();
            for (int i4 = 0; i4 < size2; i4++) {
                h((String) arrayList.get(i4), 3);
            }
        }
        return linkedList2;
    }

    public Boolean n(LinkedList<GroupNewsPojo> linkedList) {
        Boolean bool = Boolean.FALSE;
        if (linkedList != null && linkedList.size() != 0) {
            try {
                try {
                    h.e().i();
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
                        if (h.e().j("tb_group_news", contentValues, "notice_id=?", new String[]{next.getNotice_id()}) == 0) {
                            i(next);
                        }
                        bool = Boolean.valueOf(bool.booleanValue() & true);
                    }
                } catch (Exception e2) {
                    TiebaStatic.printDBExceptionLog(e2, "GroupNewsDao.updateData", new Object[0]);
                    e2.printStackTrace();
                    bool = Boolean.FALSE;
                }
                return bool;
            } finally {
                h.e().c();
            }
        }
        return Boolean.FALSE;
    }
}
