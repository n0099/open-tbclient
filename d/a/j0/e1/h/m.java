package d.a.j0.e1.h;

import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
/* loaded from: classes4.dex */
public class m extends a {

    /* renamed from: d  reason: collision with root package name */
    public static a f53608d = null;

    /* renamed from: e  reason: collision with root package name */
    public static String f53609e = "tb_private_msg_";

    public m() {
        super("tb_private_msg_", PersonalChatMessage.class);
    }

    public static synchronized m t() {
        m mVar;
        synchronized (m.class) {
            if (f53608d == null) {
                f53608d = new m();
            }
            mVar = (m) f53608d;
        }
        return mVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r11v0, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    public CommonMsgPojo u(String str, int i2) {
        Cursor cursor;
        Cursor cursor2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            try {
                cursor = h.e().h("select * from " + (f53609e + str) + " WHERE is_delete=? AND msg_type= ?", new String[]{String.valueOf(0), String.valueOf(i2)});
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
                        d.a.c.e.p.m.a(cursor);
                        return commonMsgPojo;
                    }
                } catch (SQLiteException e2) {
                    e = e2;
                    TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.getMsgContextByMsgType", new Object[0]);
                    e.printStackTrace();
                    b(str);
                    d.a.c.e.p.m.a(cursor);
                    return null;
                } catch (Exception e3) {
                    e = e3;
                    TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.getMsgContextByMsgType", new Object[0]);
                    e.printStackTrace();
                    d.a.c.e.p.m.a(cursor);
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                cursor2 = i2;
                d.a.c.e.p.m.a(cursor2);
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
            d.a.c.e.p.m.a(cursor2);
            throw th;
        }
        d.a.c.e.p.m.a(cursor);
        return null;
    }
}
