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
/* loaded from: classes3.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.tencent.mm.sdk.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C2166a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: j  reason: collision with root package name */
        public String f62265j;

        /* renamed from: k  reason: collision with root package name */
        public Bundle f62266k;
        public String l;
        public String m;

        public C2166a() {
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

    public static boolean a(Context context, C2166a c2166a) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, c2166a)) == null) {
            if (context == null || c2166a == null) {
                str = "send fail, invalid argument";
            } else if (!c.a(c2166a.m)) {
                String str2 = null;
                if (!c.a(c2166a.l)) {
                    str2 = c2166a.l + ".permission.MM_MESSAGE";
                }
                Intent intent = new Intent(c2166a.m);
                Bundle bundle = c2166a.f62266k;
                if (bundle != null) {
                    intent.putExtras(bundle);
                }
                String packageName = context.getPackageName();
                intent.putExtra("_mmessage_sdkVersion", 570490883);
                intent.putExtra("_mmessage_appPackage", packageName);
                intent.putExtra("_mmessage_content", c2166a.f62265j);
                intent.putExtra("_mmessage_checksum", b.a(c2166a.f62265j, 570490883, packageName));
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
