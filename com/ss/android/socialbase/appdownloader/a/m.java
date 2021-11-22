package com.ss.android.socialbase.appdownloader.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class m extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(Context context, com.ss.android.socialbase.downloader.g.a aVar, String str) {
        super(context, aVar, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, aVar, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (com.ss.android.socialbase.downloader.g.a) objArr2[1], (String) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static String a(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, map)) == null) {
            if (map == null) {
                return "";
            }
            StringBuffer stringBuffer = new StringBuffer();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                stringBuffer.append(entry.getKey());
                stringBuffer.append("=");
                stringBuffer.append(URLEncoder.encode(entry.getValue()));
                stringBuffer.append("&");
            }
            String stringBuffer2 = stringBuffer.toString();
            return stringBuffer2.endsWith("&") ? stringBuffer2.substring(0, stringBuffer2.length() - 1) : stringBuffer2;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.ss.android.socialbase.appdownloader.a.e
    public Intent b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String c2 = this.f69818b.c("s");
            String a2 = com.ss.android.socialbase.appdownloader.f.c.a(this.f69818b.c("bb"), c2);
            if (!TextUtils.isEmpty(a2) && a2.split(",").length == 2) {
                String a3 = com.ss.android.socialbase.appdownloader.f.c.a(this.f69818b.c("bc"), c2);
                if (!TextUtils.isEmpty(a3) && a3.split(",").length == 2) {
                    String[] split = a2.split(",");
                    String[] split2 = a3.split(",");
                    String a4 = com.ss.android.socialbase.appdownloader.f.c.a(this.f69818b.c("bd"), c2);
                    String a5 = com.ss.android.socialbase.appdownloader.f.c.a(this.f69818b.c("be"), c2);
                    String a6 = com.ss.android.socialbase.appdownloader.f.c.a(this.f69818b.c("bf"), c2);
                    HashMap hashMap = new HashMap();
                    hashMap.put(split[0], split[1]);
                    hashMap.put(split2[0], split2[1]);
                    hashMap.put(a4, this.f69819c);
                    Intent intent = new Intent();
                    intent.setAction(a6);
                    intent.setData(Uri.parse(a5 + a(hashMap)));
                    intent.addFlags(268468224);
                    return intent;
                }
            }
            return null;
        }
        return (Intent) invokeV.objValue;
    }
}
