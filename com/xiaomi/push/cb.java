package com.xiaomi.push;

import android.content.Context;
import android.database.Cursor;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.cg;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class cb extends cg.b<Long> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f40190a;

    /* renamed from: a  reason: collision with other field name */
    public String f172a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cb(String str, List<String> list, String str2, String[] strArr, String str3, String str4, String str5, int i2, String str6) {
        super(str, list, str2, strArr, str3, str4, str5, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r5;
            Object[] objArr = {str, list, str2, strArr, str3, str4, str5, Integer.valueOf(i2), str6};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (List) objArr2[1], (String) objArr2[2], (String[]) objArr2[3], (String) objArr2[4], (String) objArr2[5], (String) objArr2[6], ((Integer) objArr2[7]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f40190a = 0L;
        this.f172a = str6;
    }

    public static cb a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("count(*)");
            return new cb(str, arrayList, null, null, null, null, null, 0, "job to get count of all message");
        }
        return (cb) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.xiaomi.push.cg.b
    public Long a(Context context, Cursor cursor) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, cursor)) == null) ? Long.valueOf(cursor.getLong(0)) : (Long) invokeLL.objValue;
    }

    @Override // com.xiaomi.push.cg.b, com.xiaomi.push.cg.a
    public Object a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? Long.valueOf(this.f40190a) : invokeV.objValue;
    }

    @Override // com.xiaomi.push.cg.b
    public void a(Context context, List<Long> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, context, list) == null) || context == null || list == null || list.size() <= 0) {
            return;
        }
        this.f40190a = list.get(0).longValue();
    }
}
