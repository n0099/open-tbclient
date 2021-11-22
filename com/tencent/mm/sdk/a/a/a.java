package com.tencent.mm.sdk.a.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.mm.sdk.b.c;
/* loaded from: classes2.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.tencent.mm.sdk.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C2059a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String j;
        public Bundle k;
        public String l;
        public String m;

        public C2059a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public static boolean a(Context context, C2059a c2059a) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, c2059a)) == null) {
            if (context == null || c2059a == null) {
                str = "send fail, invalid argument";
            } else if (!c.a(c2059a.m)) {
                String str2 = null;
                if (!c.a(c2059a.l)) {
                    str2 = c2059a.l + ".permission.MM_MESSAGE";
                }
                Intent intent = new Intent(c2059a.m);
                Bundle bundle = c2059a.k;
                if (bundle != null) {
                    intent.putExtras(bundle);
                }
                String packageName = context.getPackageName();
                intent.putExtra("_mmessage_sdkVersion", 570490883);
                intent.putExtra("_mmessage_appPackage", packageName);
                intent.putExtra("_mmessage_content", c2059a.j);
                intent.putExtra("_mmessage_checksum", b.a(c2059a.j, 570490883, packageName));
                context.sendBroadcast(intent, str2);
                com.tencent.mm.sdk.b.a.c("MicroMsg.SDK.MMessage", "send mm message, intent=" + intent + ", perm=" + str2);
                return true;
            } else {
                str = "send fail, action is null";
            }
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.MMessage", str);
            return false;
        }
        return invokeLL.booleanValue;
    }
}
