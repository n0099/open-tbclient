package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.cg;
/* loaded from: classes8.dex */
public class ca extends cc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ca(String str, String str2, String[] strArr, String str3) {
        super(str, str2, strArr, str3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, strArr, str3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (String) objArr2[1], (String[]) objArr2[2], (String) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static ca a(Context context, String str, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65537, null, context, str, i2)) == null) {
            com.xiaomi.channel.commonutils.logger.b.b("delete  messages when db size is too bigger");
            String m277a = cg.a(context).m277a(str);
            if (TextUtils.isEmpty(m277a)) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("rowDataId in (select ");
            sb.append("rowDataId from " + m277a);
            sb.append(" order by createTimeStamp asc");
            sb.append(" limit ?)");
            return new ca(str, sb.toString(), new String[]{String.valueOf(i2)}, "a job build to delete history message");
        }
        return (ca) invokeLLI.objValue;
    }

    private void a(long j2) {
        String[] strArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(65538, this, j2) == null) || (strArr = ((cg.d) this).f191a) == null || strArr.length <= 0) {
            return;
        }
        strArr[0] = String.valueOf(j2);
    }

    @Override // com.xiaomi.push.cg.a
    public void a(Context context, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, context, obj) == null) && (obj instanceof Long)) {
            long longValue = ((Long) obj).longValue();
            long a = cm.a(m279a());
            long j2 = by.f172a;
            if (a <= j2) {
                com.xiaomi.channel.commonutils.logger.b.b("db size is suitable");
                return;
            }
            long j3 = (long) ((((a - j2) * 1.2d) / j2) * longValue);
            a(j3);
            bu a2 = bu.a(context);
            a2.a("begin delete " + j3 + "noUpload messages , because db size is " + a + "B");
            super.a(context, obj);
        }
    }
}
