package com.repackage;

import android.content.ContentValues;
import android.database.Cursor;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class k74 extends f74<f84> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public k74() {
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

    @Override // com.repackage.f74
    public List<f84> e(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cursor)) == null) {
            ArrayList arrayList = new ArrayList();
            if (cursor == null || cursor.getCount() <= 0 || !cursor.moveToFirst()) {
                return arrayList;
            }
            do {
                arrayList.add(h(cursor));
            } while (cursor.moveToNext());
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.f74
    /* renamed from: f */
    public ContentValues c(f84 f84Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, f84Var)) == null) {
            ContentValues a = super.a(f84Var);
            a.put("independent", Integer.valueOf(f84Var.r ? 1 : 0));
            a.put("sub_pkg_name", f84Var.p);
            a.put("app_id", f84Var.o);
            return a;
        }
        return (ContentValues) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.f74
    /* renamed from: g */
    public f84 d(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, cursor)) == null) {
            if (cursor == null || cursor.getCount() <= 0 || !cursor.moveToFirst()) {
                return null;
            }
            return h(cursor);
        }
        return (f84) invokeL.objValue;
    }

    public final f84 h(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, cursor)) == null) {
            if (cursor != null) {
                int columnIndex = cursor.getColumnIndex("independent");
                int columnIndex2 = cursor.getColumnIndex("sub_pkg_name");
                int columnIndex3 = cursor.getColumnIndex("app_id");
                f84 f84Var = new f84();
                if (b(cursor, f84Var)) {
                    f84Var.r = cursor.getInt(columnIndex) == 1;
                    f84Var.p = cursor.getString(columnIndex2);
                    f84Var.o = cursor.getString(columnIndex3);
                    return f84Var;
                }
                return null;
            }
            return null;
        }
        return (f84) invokeL.objValue;
    }
}
