package d.a.n0.m0;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.mobads.container.bridge.BaiduAppJsBridgeHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.tbadk.TiebaDatabase;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.EmotionUtil;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.faceshop.CollectEmotionData;
import com.baidu.tieba.faceshop.EmotionData;
import com.baidu.tieba.faceshop.EmotionGroupData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static g f60935a = new g();

    public static g k() {
        return f60935a;
    }

    public boolean a(CollectEmotionData collectEmotionData) {
        d.a.c.a.k.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        SQLiteDatabase f2 = mainDBDatabaseManager.f();
        f2.beginTransaction();
        try {
            f2.delete("user_collect_emotion", "uid = ? and pid = ?", new String[]{TbadkCoreApplication.getCurrentAccountForEmotion(), collectEmotionData.pid});
            ContentValues contentValues = new ContentValues();
            contentValues.put("pid", collectEmotionData.pid);
            contentValues.put("uid", collectEmotionData.uid);
            if (!TextUtils.isEmpty(collectEmotionData.sharpText)) {
                contentValues.put("sharp_text", collectEmotionData.sharpText.toLowerCase());
            } else {
                contentValues.put("sharp_text", "");
            }
            contentValues.put("order_id", Integer.valueOf(collectEmotionData.orderId));
            contentValues.put("width", Integer.valueOf(collectEmotionData.width));
            contentValues.put("height", Integer.valueOf(collectEmotionData.height));
            contentValues.put("pic_url", collectEmotionData.picUrl);
            contentValues.put("thumbnail", collectEmotionData.thumbnail);
            contentValues.put(UnitedSchemeConstants.UNITED_SCHEME_BACKUP, collectEmotionData.backup);
            f2.insert("user_collect_emotion", null, contentValues);
            f2.setTransactionSuccessful();
            return true;
        } catch (Throwable th) {
            try {
                mainDBDatabaseManager.i(th, "EmotionsDBManager.addCollectEmotion");
                return false;
            } finally {
                f2.endTransaction();
            }
        }
    }

    public boolean b(List<CollectEmotionData> list) {
        if (list == null) {
            return false;
        }
        int i2 = 0;
        for (CollectEmotionData collectEmotionData : list) {
            if (collectEmotionData != null && a(collectEmotionData)) {
                i2++;
            }
        }
        return i2 > 0;
    }

    public boolean c(EmotionData emotionData) {
        d.a.c.a.k.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        SQLiteDatabase f2 = mainDBDatabaseManager.f();
        f2.beginTransaction();
        try {
            f2.delete("emotions", "sharpText = ?", new String[]{emotionData.sharpText});
            ContentValues contentValues = new ContentValues();
            contentValues.put("sharpText", emotionData.sharpText);
            contentValues.put(TbEnum.SystemMessage.KEY_GROUP_ID, emotionData.groupId);
            contentValues.put("orderId", Integer.valueOf(emotionData.orderId));
            f2.insert("emotions", null, contentValues);
            f2.setTransactionSuccessful();
            return true;
        } catch (Throwable th) {
            try {
                mainDBDatabaseManager.i(th, "EmotionsDBManager.addEmotion");
                return false;
            } finally {
                f2.endTransaction();
            }
        }
    }

    public boolean d(String str, String str2, int i2) {
        EmotionData emotionData = new EmotionData();
        emotionData.sharpText = str;
        emotionData.groupId = str2;
        emotionData.orderId = i2;
        return c(emotionData);
    }

    public boolean e(EmotionGroupData emotionGroupData) {
        d.a.c.a.k.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        SQLiteDatabase f2 = mainDBDatabaseManager.f();
        f2.beginTransaction();
        try {
            f2.delete("emotion_group", "groupId = ?", new String[]{emotionGroupData.groupId});
            ContentValues contentValues = new ContentValues();
            contentValues.put(TbEnum.SystemMessage.KEY_GROUP_ID, emotionGroupData.groupId);
            contentValues.put(TbEnum.SystemMessage.KEY_GROUP_NAME, emotionGroupData.groupName);
            contentValues.put("groupDesc", emotionGroupData.groupDesc);
            contentValues.put("emotionsCount", Integer.valueOf(emotionGroupData.emotionsCount));
            contentValues.put("width", Integer.valueOf(emotionGroupData.width));
            contentValues.put("height", Integer.valueOf(emotionGroupData.height));
            contentValues.put("status", Integer.valueOf(emotionGroupData.status));
            contentValues.put("downloadTime", Long.valueOf(emotionGroupData.downloadTime));
            contentValues.put("bytesLength", Integer.valueOf(emotionGroupData.bytesLength));
            contentValues.put("bytesReceived", Integer.valueOf(emotionGroupData.bytesReceived));
            contentValues.put(BaiduAppJsBridgeHandler.INPUT_PARAM_DOWNLOAD_URL, emotionGroupData.downloadUrl);
            f2.insert("emotion_group", null, contentValues);
            f2.setTransactionSuccessful();
            return true;
        } catch (Throwable th) {
            try {
                mainDBDatabaseManager.i(th, "EmotionsDBManager.addEmotionGroup");
                return false;
            } finally {
                f2.endTransaction();
            }
        }
    }

    public boolean f(String str, EmotionGroupData emotionGroupData) {
        if (TextUtils.isEmpty(str) || emotionGroupData == null) {
            return false;
        }
        d.a.c.a.k.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        SQLiteDatabase f2 = mainDBDatabaseManager.f();
        f2.beginTransaction();
        try {
            f2.delete(EmotionUtil.TABLE_NAME_USER_EMOTIONS, "uid = ? and groupId = ?", new String[]{str, emotionGroupData.groupId});
            ContentValues contentValues = new ContentValues();
            contentValues.put("uid", str);
            contentValues.put(TbEnum.SystemMessage.KEY_GROUP_ID, emotionGroupData.groupId);
            contentValues.put("updateTime", Long.valueOf(System.currentTimeMillis()));
            f2.insert(EmotionUtil.TABLE_NAME_USER_EMOTIONS, null, contentValues);
            f2.setTransactionSuccessful();
            return true;
        } catch (Throwable th) {
            try {
                mainDBDatabaseManager.i(th, "EmotionsDBManager.addToMyEmotion");
                return false;
            } finally {
                f2.endTransaction();
            }
        }
    }

    public void g(CollectEmotionData collectEmotionData) {
        if (collectEmotionData == null) {
            return;
        }
        d.a.c.a.k.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        try {
            mainDBDatabaseManager.f().delete("user_collect_emotion", "pid = ? and uid = ? ", new String[]{collectEmotionData.pid, collectEmotionData.uid});
        } catch (Throwable th) {
            mainDBDatabaseManager.i(th, "EmotionsDBManager.deleteCurCollect");
        }
    }

    public boolean h(String str) {
        d.a.c.a.k.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        SQLiteDatabase f2 = mainDBDatabaseManager.f();
        f2.beginTransaction();
        try {
            f2.delete("emotions", "groupId = ?", new String[]{str});
            f2.setTransactionSuccessful();
            return true;
        } catch (Throwable th) {
            try {
                mainDBDatabaseManager.i(th, "EmotionsDBManager.deleteEmotion");
                return false;
            } finally {
                f2.endTransaction();
            }
        }
    }

    public int i(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        Cursor cursor = null;
        int i2 = 1;
        try {
            cursor = TiebaDatabase.getInstance().getMainDBDatabaseManager().f().rawQuery("SELECT count(*) FROM user_collect_emotion where uid = ? order by order_id asc ", new String[]{str});
            while (cursor.moveToNext()) {
                i2 = cursor.getInt(0);
            }
        } finally {
            try {
                return i2;
            } finally {
            }
        }
        return i2;
    }

    public EmotionGroupData j(String str) {
        Cursor cursor;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        d.a.c.a.k.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        try {
            cursor = mainDBDatabaseManager.f().rawQuery("SELECT * FROM emotion_group where groupId = ? ", new String[]{str});
        } catch (Throwable th) {
            th = th;
            cursor = null;
        }
        try {
            if (cursor.moveToNext()) {
                return q(cursor);
            }
        } catch (Throwable th2) {
            th = th2;
            try {
                mainDBDatabaseManager.i(th, "EmotionsDBManager.getEmotionGroup");
                return null;
            } finally {
                d.a.c.e.p.m.a(cursor);
            }
        }
        return null;
    }

    public List<EmotionGroupData> l(int i2) {
        SQLiteDatabase f2 = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
        LinkedList linkedList = new LinkedList();
        Cursor cursor = null;
        try {
            cursor = f2.rawQuery("SELECT * FROM emotion_group where status = ? ", new String[]{String.valueOf(i2)});
            while (cursor.moveToNext()) {
                linkedList.add(q(cursor));
            }
        } finally {
            try {
                return linkedList;
            } finally {
            }
        }
        return linkedList;
    }

    public List<EmotionData> m(String str) {
        SQLiteDatabase f2 = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
        LinkedList linkedList = new LinkedList();
        Cursor cursor = null;
        try {
            cursor = f2.rawQuery("SELECT * FROM emotions where groupId = ? order by orderId asc ", new String[]{String.valueOf(str)});
            while (cursor.moveToNext()) {
                linkedList.add(p(cursor));
            }
        } finally {
            try {
                return linkedList;
            } finally {
            }
        }
        return linkedList;
    }

    public List<CollectEmotionData> n(String str) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        Cursor cursor = null;
        try {
            cursor = TiebaDatabase.getInstance().getMainDBDatabaseManager().f().rawQuery("SELECT * FROM user_collect_emotion where uid = ? order by order_id desc ", new String[]{str});
            while (cursor.moveToNext()) {
                CollectEmotionData collectEmotionData = new CollectEmotionData();
                collectEmotionData.pid = cursor.getString(cursor.getColumnIndex("pid"));
                collectEmotionData.uid = cursor.getString(cursor.getColumnIndex("uid"));
                collectEmotionData.sharpText = cursor.getString(cursor.getColumnIndex("sharp_text")).toLowerCase();
                collectEmotionData.orderId = cursor.getInt(cursor.getColumnIndex("order_id"));
                collectEmotionData.width = cursor.getInt(cursor.getColumnIndex("width"));
                collectEmotionData.height = cursor.getInt(cursor.getColumnIndex("height"));
                collectEmotionData.picUrl = cursor.getString(cursor.getColumnIndex("pic_url"));
                collectEmotionData.thumbnail = cursor.getString(cursor.getColumnIndex("thumbnail"));
                collectEmotionData.backup = cursor.getString(cursor.getColumnIndex(UnitedSchemeConstants.UNITED_SCHEME_BACKUP));
                collectEmotionData.groupId = "collect_" + collectEmotionData.uid;
                arrayList.add(collectEmotionData);
            }
        } finally {
            try {
                return arrayList;
            } finally {
            }
        }
        return arrayList;
    }

    public void o(List<String> list, String str) {
        if (list == null || list.isEmpty()) {
            return;
        }
        Collections.reverse(list);
        d.a.c.a.k.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        SQLiteDatabase f2 = mainDBDatabaseManager.f();
        long currentTimeMillis = System.currentTimeMillis();
        try {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                ContentValues contentValues = new ContentValues();
                long j = 1 + currentTimeMillis;
                contentValues.put("updateTime", Long.valueOf(currentTimeMillis));
                f2.update(EmotionUtil.TABLE_NAME_USER_EMOTIONS, contentValues, "uid = ? and groupId = ?", new String[]{str, it.next()});
                currentTimeMillis = j;
            }
        } catch (Throwable th) {
            mainDBDatabaseManager.i(th, "EmotionsDBManager.orderEmotion");
        }
    }

    public EmotionData p(Cursor cursor) {
        EmotionData emotionData = new EmotionData();
        emotionData.sharpText = cursor.getString(cursor.getColumnIndex("sharpText"));
        emotionData.groupId = cursor.getString(cursor.getColumnIndex(TbEnum.SystemMessage.KEY_GROUP_ID));
        emotionData.orderId = cursor.getInt(cursor.getColumnIndex("orderId"));
        return emotionData;
    }

    public EmotionGroupData q(Cursor cursor) {
        EmotionGroupData emotionGroupData = new EmotionGroupData();
        emotionGroupData.groupId = cursor.getString(cursor.getColumnIndex(TbEnum.SystemMessage.KEY_GROUP_ID));
        emotionGroupData.groupName = cursor.getString(cursor.getColumnIndex(TbEnum.SystemMessage.KEY_GROUP_NAME));
        emotionGroupData.groupDesc = cursor.getString(cursor.getColumnIndex("groupDesc"));
        emotionGroupData.emotionsCount = cursor.getInt(cursor.getColumnIndex("emotionsCount"));
        emotionGroupData.width = cursor.getInt(cursor.getColumnIndex("width"));
        emotionGroupData.height = cursor.getInt(cursor.getColumnIndex("height"));
        emotionGroupData.status = cursor.getInt(cursor.getColumnIndex("status"));
        emotionGroupData.downloadTime = cursor.getInt(cursor.getColumnIndex("downloadTime"));
        emotionGroupData.bytesLength = cursor.getInt(cursor.getColumnIndex("bytesLength"));
        emotionGroupData.bytesReceived = cursor.getInt(cursor.getColumnIndex("bytesReceived"));
        emotionGroupData.downloadUrl = cursor.getString(cursor.getColumnIndex(BaiduAppJsBridgeHandler.INPUT_PARAM_DOWNLOAD_URL));
        return emotionGroupData;
    }

    public void r(CollectEmotionData collectEmotionData) {
        if (collectEmotionData == null) {
            return;
        }
        d.a.c.a.k.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        SQLiteDatabase f2 = mainDBDatabaseManager.f();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("order_id", Integer.valueOf(collectEmotionData.orderId));
            f2.update("user_collect_emotion", contentValues, "uid = ? and pid = ?", new String[]{collectEmotionData.uid, collectEmotionData.pid});
        } catch (Throwable th) {
            mainDBDatabaseManager.i(th, "EmotionsDBManager.updateCollect");
        }
    }
}
