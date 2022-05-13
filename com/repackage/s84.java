package com.repackage;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.List;
/* loaded from: classes7.dex */
public abstract class s84<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public s84() {
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

    public ContentValues a(q94 q94Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, q94Var)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("bundle_id", q94Var.g);
            contentValues.put("category", Integer.valueOf(q94Var.h));
            contentValues.put("version_name", q94Var.j);
            contentValues.put("version_code", Long.valueOf(q94Var.i));
            contentValues.put("size", Long.valueOf(q94Var.k));
            contentValues.put(PackageTable.MD5, q94Var.l);
            contentValues.put("sign", q94Var.m);
            contentValues.put(TTDownloadField.TT_DOWNLOAD_URL, q94Var.n);
            contentValues.put(PackageTable.FILE_PATH, q94Var.a);
            contentValues.put(PackageTable.CURRENT_SIZE, Long.valueOf(q94Var.b));
            contentValues.put("create_time", Long.valueOf(q94Var.c));
            contentValues.put("update_time", Long.valueOf(q94Var.d));
            contentValues.put("state", Integer.valueOf(q94Var.e));
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    public boolean b(Cursor cursor, q94 q94Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cursor, q94Var)) == null) {
            if (cursor != null) {
                int columnIndex = cursor.getColumnIndex("bundle_id");
                int columnIndex2 = cursor.getColumnIndex("category");
                int columnIndex3 = cursor.getColumnIndex("version_name");
                int columnIndex4 = cursor.getColumnIndex("version_code");
                int columnIndex5 = cursor.getColumnIndex("size");
                int columnIndex6 = cursor.getColumnIndex(PackageTable.MD5);
                int columnIndex7 = cursor.getColumnIndex("sign");
                int columnIndex8 = cursor.getColumnIndex(TTDownloadField.TT_DOWNLOAD_URL);
                int columnIndex9 = cursor.getColumnIndex("_id");
                int columnIndex10 = cursor.getColumnIndex(PackageTable.FILE_PATH);
                int columnIndex11 = cursor.getColumnIndex(PackageTable.CURRENT_SIZE);
                int columnIndex12 = cursor.getColumnIndex("create_time");
                int columnIndex13 = cursor.getColumnIndex("update_time");
                int columnIndex14 = cursor.getColumnIndex("state");
                String string = cursor.getString(columnIndex);
                if (TextUtils.isEmpty(string)) {
                    return false;
                }
                q94Var.g = string;
                q94Var.h = cursor.getInt(columnIndex2);
                q94Var.j = cursor.getString(columnIndex3);
                q94Var.i = cursor.getLong(columnIndex4);
                q94Var.k = cursor.getLong(columnIndex5);
                q94Var.l = cursor.getString(columnIndex6);
                q94Var.m = cursor.getString(columnIndex7);
                q94Var.n = cursor.getString(columnIndex8);
                q94Var.a = cursor.getString(columnIndex10);
                q94Var.b = cursor.getLong(columnIndex11);
                q94Var.c = cursor.getLong(columnIndex12);
                q94Var.d = cursor.getLong(columnIndex13);
                q94Var.f = cursor.getLong(columnIndex9);
                q94Var.e = cursor.getInt(columnIndex14);
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public abstract ContentValues c(T t);

    public abstract T d(Cursor cursor) throws SQLException;

    public abstract List<T> e(Cursor cursor) throws SQLException;
}
