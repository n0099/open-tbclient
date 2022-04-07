package com.repackage;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.tbadk.TiebaDatabase;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.EmotionUtil;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.faceshop.CollectEmotionData;
import com.baidu.tieba.faceshop.EmotionData;
import com.baidu.tieba.faceshop.EmotionGroupData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class c96 {
    public static /* synthetic */ Interceptable $ic;
    public static c96 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755842319, "Lcom/repackage/c96;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755842319, "Lcom/repackage/c96;");
                return;
            }
        }
        a = new c96();
    }

    public c96() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static c96 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a : (c96) invokeV.objValue;
    }

    public boolean a(CollectEmotionData collectEmotionData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, collectEmotionData)) == null) {
            h9 mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            SQLiteDatabase f = mainDBDatabaseManager.f();
            f.beginTransaction();
            try {
                f.delete("user_collect_emotion", "uid = ? and pid = ?", new String[]{TbadkCoreApplication.getCurrentAccountForEmotion(), collectEmotionData.pid});
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
                f.insert("user_collect_emotion", null, contentValues);
                f.setTransactionSuccessful();
                return true;
            } catch (Throwable th) {
                try {
                    mainDBDatabaseManager.i(th, "EmotionsDBManager.addCollectEmotion");
                    return false;
                } finally {
                    f.endTransaction();
                }
            }
        }
        return invokeL.booleanValue;
    }

    public boolean b(List<CollectEmotionData> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            if (list == null) {
                return false;
            }
            int i = 0;
            for (CollectEmotionData collectEmotionData : list) {
                if (collectEmotionData != null && a(collectEmotionData)) {
                    i++;
                }
            }
            return i > 0;
        }
        return invokeL.booleanValue;
    }

    public boolean c(EmotionData emotionData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, emotionData)) == null) {
            h9 mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            SQLiteDatabase f = mainDBDatabaseManager.f();
            f.beginTransaction();
            try {
                f.delete("emotions", "sharpText = ?", new String[]{emotionData.sharpText});
                ContentValues contentValues = new ContentValues();
                contentValues.put("sharpText", emotionData.sharpText);
                contentValues.put(TbEnum.SystemMessage.KEY_GROUP_ID, emotionData.groupId);
                contentValues.put("orderId", Integer.valueOf(emotionData.orderId));
                f.insert("emotions", null, contentValues);
                f.setTransactionSuccessful();
                return true;
            } catch (Throwable th) {
                try {
                    mainDBDatabaseManager.i(th, "EmotionsDBManager.addEmotion");
                    return false;
                } finally {
                    f.endTransaction();
                }
            }
        }
        return invokeL.booleanValue;
    }

    public boolean d(String str, String str2, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048579, this, str, str2, i)) == null) {
            EmotionData emotionData = new EmotionData();
            emotionData.sharpText = str;
            emotionData.groupId = str2;
            emotionData.orderId = i;
            return c(emotionData);
        }
        return invokeLLI.booleanValue;
    }

    public boolean e(EmotionGroupData emotionGroupData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, emotionGroupData)) == null) {
            h9 mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            SQLiteDatabase f = mainDBDatabaseManager.f();
            f.beginTransaction();
            try {
                f.delete("emotion_group", "groupId = ?", new String[]{emotionGroupData.groupId});
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
                contentValues.put(TTDownloadField.TT_DOWNLOAD_URL, emotionGroupData.downloadUrl);
                f.insert("emotion_group", null, contentValues);
                f.setTransactionSuccessful();
                return true;
            } catch (Throwable th) {
                try {
                    mainDBDatabaseManager.i(th, "EmotionsDBManager.addEmotionGroup");
                    return false;
                } finally {
                    f.endTransaction();
                }
            }
        }
        return invokeL.booleanValue;
    }

    public boolean f(String str, EmotionGroupData emotionGroupData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, emotionGroupData)) == null) {
            if (TextUtils.isEmpty(str) || emotionGroupData == null) {
                return false;
            }
            h9 mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            SQLiteDatabase f = mainDBDatabaseManager.f();
            f.beginTransaction();
            try {
                f.delete(EmotionUtil.TABLE_NAME_USER_EMOTIONS, "uid = ? and groupId = ?", new String[]{str, emotionGroupData.groupId});
                ContentValues contentValues = new ContentValues();
                contentValues.put("uid", str);
                contentValues.put(TbEnum.SystemMessage.KEY_GROUP_ID, emotionGroupData.groupId);
                contentValues.put("updateTime", Long.valueOf(System.currentTimeMillis()));
                f.insert(EmotionUtil.TABLE_NAME_USER_EMOTIONS, null, contentValues);
                f.setTransactionSuccessful();
                return true;
            } catch (Throwable th) {
                try {
                    mainDBDatabaseManager.i(th, "EmotionsDBManager.addToMyEmotion");
                    return false;
                } finally {
                    f.endTransaction();
                }
            }
        }
        return invokeLL.booleanValue;
    }

    public void g(CollectEmotionData collectEmotionData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, collectEmotionData) == null) || collectEmotionData == null) {
            return;
        }
        h9 mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        try {
            mainDBDatabaseManager.f().delete("user_collect_emotion", "pid = ? and uid = ? ", new String[]{collectEmotionData.pid, collectEmotionData.uid});
        } catch (Throwable th) {
            mainDBDatabaseManager.i(th, "EmotionsDBManager.deleteCurCollect");
        }
    }

    public boolean h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            h9 mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            SQLiteDatabase f = mainDBDatabaseManager.f();
            f.beginTransaction();
            try {
                f.delete("emotions", "groupId = ?", new String[]{str});
                f.setTransactionSuccessful();
                return true;
            } catch (Throwable th) {
                try {
                    mainDBDatabaseManager.i(th, "EmotionsDBManager.deleteEmotion");
                    return false;
                } finally {
                    f.endTransaction();
                }
            }
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, MOVE_EXCEPTION, CONST_STR, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    public int i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            Cursor cursor = null;
            int i = 1;
            try {
                cursor = TiebaDatabase.getInstance().getMainDBDatabaseManager().f().rawQuery("SELECT count(*) FROM user_collect_emotion where uid = ? order by order_id asc ", new String[]{str});
                while (cursor.moveToNext()) {
                    i = cursor.getInt(0);
                }
            } finally {
                try {
                    return i;
                } finally {
                }
            }
            return i;
        }
        return invokeL.intValue;
    }

    public EmotionGroupData j(String str) {
        InterceptResult invokeL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            h9 mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            try {
                cursor = mainDBDatabaseManager.f().rawQuery("SELECT * FROM emotion_group where groupId = ? ", new String[]{str});
                try {
                    if (cursor.moveToNext()) {
                        return q(cursor);
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        mainDBDatabaseManager.i(th, "EmotionsDBManager.getEmotionGroup");
                        return null;
                    } finally {
                        pi.a(cursor);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
            }
            return null;
        }
        return (EmotionGroupData) invokeL.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, MOVE_EXCEPTION, CONST_STR, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    public List<EmotionGroupData> l(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
            LinkedList linkedList = new LinkedList();
            Cursor cursor = null;
            try {
                cursor = f.rawQuery("SELECT * FROM emotion_group where status = ? ", new String[]{String.valueOf(i)});
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
        return (List) invokeI.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, MOVE_EXCEPTION, CONST_STR, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    public List<EmotionData> m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
            LinkedList linkedList = new LinkedList();
            Cursor cursor = null;
            try {
                cursor = f.rawQuery("SELECT * FROM emotions where groupId = ? order by orderId asc ", new String[]{String.valueOf(str)});
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
        return (List) invokeL.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, MOVE_EXCEPTION, CONST_STR, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    public List<CollectEmotionData> n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
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
        return (List) invokeL.objValue;
    }

    public void o(List<String> list, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, list, str) == null) || list == null || list.isEmpty()) {
            return;
        }
        Collections.reverse(list);
        h9 mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        SQLiteDatabase f = mainDBDatabaseManager.f();
        long currentTimeMillis = System.currentTimeMillis();
        try {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                ContentValues contentValues = new ContentValues();
                long j = 1 + currentTimeMillis;
                contentValues.put("updateTime", Long.valueOf(currentTimeMillis));
                f.update(EmotionUtil.TABLE_NAME_USER_EMOTIONS, contentValues, "uid = ? and groupId = ?", new String[]{str, it.next()});
                currentTimeMillis = j;
            }
        } catch (Throwable th) {
            mainDBDatabaseManager.i(th, "EmotionsDBManager.orderEmotion");
        }
    }

    public EmotionData p(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, cursor)) == null) {
            EmotionData emotionData = new EmotionData();
            emotionData.sharpText = cursor.getString(cursor.getColumnIndex("sharpText"));
            emotionData.groupId = cursor.getString(cursor.getColumnIndex(TbEnum.SystemMessage.KEY_GROUP_ID));
            emotionData.orderId = cursor.getInt(cursor.getColumnIndex("orderId"));
            return emotionData;
        }
        return (EmotionData) invokeL.objValue;
    }

    public EmotionGroupData q(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, cursor)) == null) {
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
            emotionGroupData.downloadUrl = cursor.getString(cursor.getColumnIndex(TTDownloadField.TT_DOWNLOAD_URL));
            return emotionGroupData;
        }
        return (EmotionGroupData) invokeL.objValue;
    }

    public void r(CollectEmotionData collectEmotionData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, collectEmotionData) == null) || collectEmotionData == null) {
            return;
        }
        h9 mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        SQLiteDatabase f = mainDBDatabaseManager.f();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("order_id", Integer.valueOf(collectEmotionData.orderId));
            f.update("user_collect_emotion", contentValues, "uid = ? and pid = ?", new String[]{collectEmotionData.uid, collectEmotionData.pid});
        } catch (Throwable th) {
            mainDBDatabaseManager.i(th, "EmotionsDBManager.updateCollect");
        }
    }
}
