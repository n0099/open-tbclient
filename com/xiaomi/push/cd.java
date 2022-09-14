package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.cj;
/* loaded from: classes8.dex */
public class cd extends cf {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cd(String str, String str2, String[] strArr, String str3) {
        super(str, str2, strArr, str3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, strArr, str3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (String) objArr2[1], (String[]) objArr2[2], (String) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static cd a(Context context, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65537, null, context, str, i)) == null) {
            com.xiaomi.channel.commonutils.logger.b.b("delete  messages when db size is too bigger");
            String m238a = cj.a(context).m238a(str);
            if (TextUtils.isEmpty(m238a)) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("rowDataId in (select ");
            sb.append("rowDataId from " + m238a);
            sb.append(" order by createTimeStamp asc");
            sb.append(" limit ?)");
            return new cd(str, sb.toString(), new String[]{String.valueOf(i)}, "a job build to delete history message");
        }
        return (cd) invokeLLI.objValue;
    }

    private void a(long j) {
        String[] strArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(65538, this, j) == null) || (strArr = ((cj.d) this).f176a) == null || strArr.length <= 0) {
            return;
        }
        strArr[0] = String.valueOf(j);
    }

    @Override // com.xiaomi.push.cj.a
    public void a(Context context, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, context, obj) == null) && (obj instanceof Long)) {
            long longValue = ((Long) obj).longValue();
            long a = cp.a(m240a());
            long j = cb.f159a;
            if (a <= j) {
                com.xiaomi.channel.commonutils.logger.b.b("db size is suitable");
                return;
            }
            long j2 = (long) ((((a - j) * 1.2d) / j) * longValue);
            a(j2);
            bx a2 = bx.a(context);
            a2.a("begin delete " + j2 + "noUpload messages , because db size is " + a + "B");
            super.a(context, obj);
        }
    }
}
