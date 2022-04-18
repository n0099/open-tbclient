package com.repackage;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.tbadk.TiebaDatabase;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TiebaMainDatabaseHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a36 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final a36 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-577814000, "Lcom/repackage/a36$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-577814000, "Lcom/repackage/a36$a;");
                    return;
                }
            }
            a = new a36();
        }
    }

    public a36() {
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

    public static final a36 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? a.a : (a36) invokeV.objValue;
    }

    private long insert(SQLiteDatabase sQLiteDatabase, z26 z26Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, sQLiteDatabase, z26Var)) == null) {
            try {
                return sQLiteDatabase.insert(TiebaMainDatabaseHelper.TABLE_NAME_DOWNLOAD_INFO, null, a(z26Var));
            } catch (Throwable th) {
                th.printStackTrace();
                return -1L;
            }
        }
        return invokeLL.longValue;
    }

    private long update(SQLiteDatabase sQLiteDatabase, z26 z26Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, sQLiteDatabase, z26Var)) == null) {
            try {
                return sQLiteDatabase.update(TiebaMainDatabaseHelper.TABLE_NAME_DOWNLOAD_INFO, a(z26Var), "pkg_name = ?", new String[]{String.valueOf(z26Var.a.pkgName)});
            } catch (Throwable th) {
                th.printStackTrace();
                return -1L;
            }
        }
        return invokeLL.longValue;
    }

    public final ContentValues a(z26 z26Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, z26Var)) == null) {
            if (z26Var == null) {
                return null;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put(EmotionResourceInfo.JSON_KEY_PKG_NAME, z26Var.a.pkgName);
            contentValues.put("download_time", Long.valueOf(System.currentTimeMillis()));
            contentValues.put("item_info", f(z26Var.a));
            contentValues.put("item_source", Integer.valueOf(z26Var.b));
            contentValues.put("storage_location", Integer.valueOf(z26Var.c));
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    public final lz4 b(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cursor)) == null) {
            if (cursor == null || cursor.isClosed()) {
                return null;
            }
            lz4 lz4Var = new lz4();
            lz4Var.a = cursor.getString(cursor.getColumnIndex(EmotionResourceInfo.JSON_KEY_PKG_NAME));
            cursor.getLong(cursor.getColumnIndex("download_time"));
            lz4Var.c = cursor.getString(cursor.getColumnIndex("item_info"));
            lz4Var.d = cursor.getInt(cursor.getColumnIndex("item_source"));
            lz4Var.e = cursor.getInt(cursor.getColumnIndex("storage_location"));
            return lz4Var;
        }
        return (lz4) invokeL.objValue;
    }

    public synchronized boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            synchronized (this) {
                if (ni.isEmpty(str)) {
                    return false;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                int delete = f.delete(TiebaMainDatabaseHelper.TABLE_NAME_DOWNLOAD_INFO, "pkg_name = ?", new String[]{str});
                f.setTransactionSuccessful();
                f.endTransaction();
                return delete >= 0;
            }
        }
        return invokeL.booleanValue;
    }

    public synchronized List<lz4> d() {
        InterceptResult invokeV;
        LinkedList linkedList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this) {
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                linkedList = new LinkedList();
                Cursor rawQuery = f.rawQuery(String.format("SELECT * FROM %s ORDER BY %s DESC", TiebaMainDatabaseHelper.TABLE_NAME_DOWNLOAD_INFO, "download_time"), null);
                while (rawQuery.moveToNext()) {
                    lz4 b = b(rawQuery);
                    if (b != null) {
                        linkedList.add(b);
                    }
                }
                f.setTransactionSuccessful();
                pi.a(rawQuery);
                f.endTransaction();
            }
            return linkedList;
        }
        return (List) invokeV.objValue;
    }

    public final String f(ItemData itemData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, itemData)) == null) {
            if (itemData == null) {
                return "";
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("item_id", itemData.itemId);
                jSONObject.put("item_name", itemData.mTitle);
                jSONObject.put("icon_size", itemData.mIconSize);
                jSONObject.put("icon_url", itemData.mIconUrl);
                if (!ListUtils.isEmpty(itemData.mTags)) {
                    jSONObject.put("tags", new JSONArray((Collection) itemData.mTags));
                }
                jSONObject.put("score", itemData.mScore);
                jSONObject.put(AccountConstants.LOGIN_TYPE_NATIVE_SRC_STAR, itemData.mStar);
                jSONObject.put("button_name", itemData.buttonName);
                jSONObject.put("button_link", itemData.buttonLink);
                jSONObject.put("button_link_type", itemData.buttonLinkType);
                jSONObject.put("apk_name", itemData.pkgName);
                jSONObject.put("forum_name", itemData.forumName);
                jSONObject.put("item_appid", itemData.appId);
                if (itemData.apkDetail != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("developer", itemData.apkDetail.developer);
                    jSONObject2.put("publisher", itemData.apkDetail.publisher);
                    jSONObject2.put("version", itemData.apkDetail.version);
                    jSONObject2.put("version_code", itemData.apkDetail.version_code);
                    jSONObject2.put("update_time", itemData.apkDetail.update_time);
                    jSONObject2.put("size", itemData.apkDetail.size);
                    jSONObject2.put("need_network", itemData.apkDetail.need_network);
                    jSONObject2.put("need_inner_buy", itemData.apkDetail.need_inner_buy);
                    jSONObject2.put("authority_url", itemData.apkDetail.authority_url);
                    jSONObject2.put("privacy_url", itemData.apkDetail.privacy_url);
                    jSONObject2.put("pkg_source", itemData.apkDetail.pkg_source);
                    jSONObject.put("apk_detail", jSONObject2);
                }
            } catch (JSONException unused) {
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }

    public synchronized long g(z26 z26Var) {
        InterceptResult invokeL;
        long insert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, z26Var)) == null) {
            synchronized (this) {
                if (z26Var == null) {
                    return -1L;
                }
                SQLiteDatabase f = TiebaDatabase.getInstance().getMainDBDatabaseManager().f();
                f.beginTransaction();
                Cursor rawQuery = f.rawQuery("SELECT * FROM download_info where pkg_name = ?", new String[]{z26Var.a.pkgName});
                if (rawQuery.getCount() > 0) {
                    insert = update(f, z26Var);
                } else {
                    insert = insert(f, z26Var);
                }
                f.setTransactionSuccessful();
                pi.a(rawQuery);
                f.endTransaction();
                return insert;
            }
        }
        return invokeL.longValue;
    }
}
