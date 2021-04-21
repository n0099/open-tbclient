package d.b.j0.l0;

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
    public static a f58308a = new a();

    public static a c() {
        return f58308a;
    }

    public final boolean a(String str) {
        return new File(TbadkCoreApplication.getInst().getFilesDir(), str).exists();
    }

    public boolean b(MyEmotionGroupData myEmotionGroupData) {
        if (myEmotionGroupData == null) {
            return false;
        }
        d.b.c.a.k.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
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
        d.b.c.a.k.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
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
                    d.b.c.e.p.m.a(cursor);
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
        d.b.c.a.k.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        Cursor cursor = null;
        try {
            cursor = mainDBDatabaseManager.f().rawQuery("SELECT * FROM user_emotions where uid = ? and groupId = ? ", new String[]{TbadkCoreApplication.getCurrentAccount(), str});
            return cursor.moveToNext();
        } catch (Throwable th) {
            try {
                mainDBDatabaseManager.i(th, "EmotionsDBManager.hasEmotionByPckID");
                return false;
            } finally {
                d.b.c.e.p.m.a(cursor);
            }
        }
    }

    public int f(d.b.j0.y1.f.a aVar) {
        List<d.b.j0.y1.f.b> list;
        if (aVar == null || (list = aVar.f64478e) == null || list.size() == 0) {
            return 0;
        }
        String str = ".emotions/" + aVar.f64474a;
        g k = g.k();
        List<d.b.j0.y1.f.b> list2 = aVar.f64478e;
        int i = 0;
        for (int i2 = 0; i2 < list2.size(); i2++) {
            d.b.j0.y1.f.b bVar = list2.get(i2);
            if (a(str + "/" + bVar.f64481g)) {
                if (a(str + "/" + bVar.f64482h)) {
                    StringBuilder sb = new StringBuilder(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX_SHORT);
                    sb.append(aVar.f64474a + "_" + bVar.f64480f);
                    sb.append(",");
                    sb.append(bVar.j);
                    sb.append(",");
                    sb.append(bVar.i);
                    sb.append(",");
                    String str2 = SmallTailInfo.EMOTION_PREFIX + sb.toString() + d.b.c.e.p.q.c(sb.toString() + "7S6wbXjEKL9N").toLowerCase() + SmallTailInfo.EMOTION_SUFFIX;
                    boolean isGif = FileHelper.isGif(str, bVar.f64481g);
                    b.g(aVar.f64474a, bVar.f64482h, b.c(str2, true, false));
                    b.g(aVar.f64474a, bVar.f64481g, b.c(str2, false, isGif));
                    if (k.d(str2, aVar.f64474a, i2 + 1)) {
                        i++;
                    }
                }
            }
        }
        return i;
    }

    public int g(String str, InputStream inputStream) throws Exception {
        g k = g.k();
        List<String> a2 = b.a(str, inputStream);
        int i = 0;
        int i2 = 0;
        while (i < a2.size()) {
            i++;
            if (k.d(a2.get(i), str, i)) {
                i2++;
            }
        }
        return i2;
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
