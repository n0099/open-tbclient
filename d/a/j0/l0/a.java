package d.a.j0.l0;

import android.database.Cursor;
import android.text.TextUtils;
import com.baidu.tbadk.TiebaDatabase;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.EmotionUtil;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.faceshop.MyEmotionGroupData;
import java.io.File;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static a f56304a = new a();

    public static a c() {
        return f56304a;
    }

    public final boolean a(String str) {
        return new File(TbadkCoreApplication.getInst().getFilesDir(), str).exists();
    }

    public boolean b(MyEmotionGroupData myEmotionGroupData) {
        if (myEmotionGroupData == null) {
            return false;
        }
        d.a.c.a.k.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        try {
            mainDBDatabaseManager.f().delete(EmotionUtil.TABLE_NAME_USER_EMOTIONS, "uid = ? and groupId = ?", new String[]{myEmotionGroupData.uid, myEmotionGroupData.groupId});
            return true;
        } catch (Throwable th) {
            mainDBDatabaseManager.i(th, "EmotionsDBManager.deleteMyEmotion");
            return false;
        }
    }

    public MyEmotionGroupData d(String str, String str2) {
        Cursor cursor;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        d.a.c.a.k.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        try {
            cursor = mainDBDatabaseManager.f().rawQuery("SELECT * FROM user_emotions where uid = ? and groupId = ? ", new String[]{str, str2});
            try {
                if (cursor.moveToNext()) {
                    return i(cursor);
                }
            } catch (Throwable th) {
                th = th;
                try {
                    mainDBDatabaseManager.i(th, "EmotionsDBManager.getMyEmotion");
                    return null;
                } finally {
                    d.a.c.e.p.m.a(cursor);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
        return null;
    }

    public boolean e(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        d.a.c.a.k.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        Cursor cursor = null;
        try {
            cursor = mainDBDatabaseManager.f().rawQuery("SELECT * FROM user_emotions where uid = ? and groupId = ? ", new String[]{TbadkCoreApplication.getCurrentAccount(), str});
            return cursor.moveToNext();
        } catch (Throwable th) {
            try {
                mainDBDatabaseManager.i(th, "EmotionsDBManager.hasEmotionByPckID");
                return false;
            } finally {
                d.a.c.e.p.m.a(cursor);
            }
        }
    }

    public int f(d.a.j0.y1.f.a aVar) {
        List<d.a.j0.y1.f.b> list;
        if (aVar == null || (list = aVar.f62753e) == null || list.size() == 0) {
            return 0;
        }
        String str = ".emotions/" + aVar.f62749a;
        g k = g.k();
        List<d.a.j0.y1.f.b> list2 = aVar.f62753e;
        int i2 = 0;
        for (int i3 = 0; i3 < list2.size(); i3++) {
            d.a.j0.y1.f.b bVar = list2.get(i3);
            if (a(str + "/" + bVar.f62756g)) {
                if (a(str + "/" + bVar.f62757h)) {
                    StringBuilder sb = new StringBuilder(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX_SHORT);
                    sb.append(aVar.f62749a + "_" + bVar.f62755f);
                    sb.append(",");
                    sb.append(bVar.j);
                    sb.append(",");
                    sb.append(bVar.f62758i);
                    sb.append(",");
                    String str2 = SmallTailInfo.EMOTION_PREFIX + sb.toString() + d.a.c.e.p.q.c(sb.toString() + "7S6wbXjEKL9N").toLowerCase() + SmallTailInfo.EMOTION_SUFFIX;
                    boolean isGif = FileHelper.isGif(str, bVar.f62756g);
                    b.g(aVar.f62749a, bVar.f62757h, b.c(str2, true, false));
                    b.g(aVar.f62749a, bVar.f62756g, b.c(str2, false, isGif));
                    if (k.d(str2, aVar.f62749a, i3 + 1)) {
                        i2++;
                    }
                }
            }
        }
        return i2;
    }

    public int g(String str, InputStream inputStream) throws Exception {
        g k = g.k();
        List<String> a2 = b.a(str, inputStream);
        int i2 = 0;
        int i3 = 0;
        while (i2 < a2.size()) {
            i2++;
            if (k.d(a2.get(i2), str, i2)) {
                i3++;
            }
        }
        return i3;
    }

    public List<MyEmotionGroupData> h(String str) {
        LinkedList linkedList = new LinkedList();
        if (TextUtils.isEmpty(str)) {
            return linkedList;
        }
        Cursor cursor = null;
        try {
            cursor = TiebaDatabase.getInstance().getMainDBDatabaseManager().f().rawQuery("SELECT * FROM user_emotions where uid = ? order by updateTime desc ", new String[]{str});
            while (cursor.moveToNext()) {
                linkedList.add(i(cursor));
            }
        } finally {
            try {
                return linkedList;
            } finally {
            }
        }
        return linkedList;
    }

    public MyEmotionGroupData i(Cursor cursor) {
        MyEmotionGroupData myEmotionGroupData = new MyEmotionGroupData();
        myEmotionGroupData.id = cursor.getInt(cursor.getColumnIndex("id"));
        myEmotionGroupData.uid = cursor.getString(cursor.getColumnIndex("uid"));
        myEmotionGroupData.groupId = cursor.getString(cursor.getColumnIndex(TbEnum.SystemMessage.KEY_GROUP_ID));
        myEmotionGroupData.updateTime = cursor.getLong(cursor.getColumnIndex("updateTime"));
        return myEmotionGroupData;
    }
}
