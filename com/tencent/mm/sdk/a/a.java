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
/* loaded from: classes4.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.tencent.mm.sdk.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C2256a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int flags;

        /* renamed from: h  reason: collision with root package name */
        public String f60516h;

        /* renamed from: i  reason: collision with root package name */
        public String f60517i;

        /* renamed from: j  reason: collision with root package name */
        public String f60518j;
        public Bundle k;

        public C2256a() {
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

    public static boolean a(Context context, C2256a c2256a) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, c2256a)) == null) {
            if (context == null || c2256a == null) {
                com.tencent.mm.sdk.b.a.a(MMessageActV2.TAG, "send fail, invalid argument");
                return false;
            } else if (c.a(c2256a.f60516h)) {
                com.tencent.mm.sdk.b.a.a(MMessageActV2.TAG, "send fail, invalid targetPkgName, targetPkgName = " + c2256a.f60516h);
                return false;
            } else {
                if (c.a(c2256a.f60517i)) {
                    c2256a.f60517i = c2256a.f60516h + MMessageActV2.DEFAULT_ENTRY_CLASS_NAME;
                }
                com.tencent.mm.sdk.b.a.c(MMessageActV2.TAG, "send, targetPkgName = " + c2256a.f60516h + ", targetClassName = " + c2256a.f60517i);
                Intent intent = new Intent();
                intent.setClassName(c2256a.f60516h, c2256a.f60517i);
                Bundle bundle = c2256a.k;
                if (bundle != null) {
                    intent.putExtras(bundle);
                }
                String packageName = context.getPackageName();
                intent.putExtra("_mmessage_sdkVersion", 570490883);
                intent.putExtra("_mmessage_appPackage", packageName);
                intent.putExtra("_mmessage_content", c2256a.f60518j);
                intent.putExtra("_mmessage_checksum", b.a(c2256a.f60518j, 570490883, packageName));
                int i2 = c2256a.flags;
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
