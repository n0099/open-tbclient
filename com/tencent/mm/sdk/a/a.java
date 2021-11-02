package com.tencent.mm.sdk.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.sdk.a.a.b;
import com.tencent.mm.sdk.b.c;
/* loaded from: classes2.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.tencent.mm.sdk.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C2020a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int flags;

        /* renamed from: h  reason: collision with root package name */
        public String f69974h;

        /* renamed from: i  reason: collision with root package name */
        public String f69975i;
        public String j;
        public Bundle k;

        public C2020a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.flags = -1;
        }
    }

    public static boolean a(Context context, C2020a c2020a) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, c2020a)) == null) {
            if (context == null || c2020a == null) {
                com.tencent.mm.sdk.b.a.a(MMessageActV2.TAG, "send fail, invalid argument");
                return false;
            } else if (c.a(c2020a.f69974h)) {
                com.tencent.mm.sdk.b.a.a(MMessageActV2.TAG, "send fail, invalid targetPkgName, targetPkgName = " + c2020a.f69974h);
                return false;
            } else {
                if (c.a(c2020a.f69975i)) {
                    c2020a.f69975i = c2020a.f69974h + MMessageActV2.DEFAULT_ENTRY_CLASS_NAME;
                }
                com.tencent.mm.sdk.b.a.c(MMessageActV2.TAG, "send, targetPkgName = " + c2020a.f69974h + ", targetClassName = " + c2020a.f69975i);
                Intent intent = new Intent();
                intent.setClassName(c2020a.f69974h, c2020a.f69975i);
                Bundle bundle = c2020a.k;
                if (bundle != null) {
                    intent.putExtras(bundle);
                }
                String packageName = context.getPackageName();
                intent.putExtra("_mmessage_sdkVersion", 570490883);
                intent.putExtra("_mmessage_appPackage", packageName);
                intent.putExtra("_mmessage_content", c2020a.j);
                intent.putExtra("_mmessage_checksum", b.a(c2020a.j, 570490883, packageName));
                int i2 = c2020a.flags;
                if (i2 == -1) {
                    intent.addFlags(268435456).addFlags(134217728);
                } else {
                    intent.setFlags(i2);
                }
                try {
                    context.startActivity(intent);
                    com.tencent.mm.sdk.b.a.c(MMessageActV2.TAG, "send mm message, intent=" + intent);
                    return true;
                } catch (Exception e2) {
                    com.tencent.mm.sdk.b.a.a(MMessageActV2.TAG, "send fail, ex = %s", e2.getMessage());
                    return false;
                }
            }
        }
        return invokeLL.booleanValue;
    }
}
