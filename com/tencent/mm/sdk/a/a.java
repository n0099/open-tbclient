package com.tencent.mm.sdk.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.sdk.a.a.b;
import com.tencent.mm.sdk.b.c;
/* loaded from: classes7.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.tencent.mm.sdk.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0649a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int flags;
        public String h;
        public String i;
        public String j;
        public Bundle k;

        public C0649a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.flags = -1;
        }
    }

    public static boolean a(Context context, C0649a c0649a) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, c0649a)) == null) {
            if (context == null || c0649a == null) {
                com.tencent.mm.sdk.b.a.a(MMessageActV2.TAG, "send fail, invalid argument");
                return false;
            } else if (c.a(c0649a.h)) {
                com.tencent.mm.sdk.b.a.a(MMessageActV2.TAG, "send fail, invalid targetPkgName, targetPkgName = " + c0649a.h);
                return false;
            } else {
                if (c.a(c0649a.i)) {
                    c0649a.i = c0649a.h + MMessageActV2.DEFAULT_ENTRY_CLASS_NAME;
                }
                com.tencent.mm.sdk.b.a.c(MMessageActV2.TAG, "send, targetPkgName = " + c0649a.h + ", targetClassName = " + c0649a.i);
                Intent intent = new Intent();
                intent.setClassName(c0649a.h, c0649a.i);
                Bundle bundle = c0649a.k;
                if (bundle != null) {
                    intent.putExtras(bundle);
                }
                String packageName = context.getPackageName();
                intent.putExtra("_mmessage_sdkVersion", 570490883);
                intent.putExtra("_mmessage_appPackage", packageName);
                intent.putExtra("_mmessage_content", c0649a.j);
                intent.putExtra("_mmessage_checksum", b.a(c0649a.j, 570490883, packageName));
                int i = c0649a.flags;
                if (i == -1) {
                    intent.addFlags(LaunchTaskConstants.OTHER_PROCESS).addFlags(134217728);
                } else {
                    intent.setFlags(i);
                }
                try {
                    context.startActivity(intent);
                    com.tencent.mm.sdk.b.a.c(MMessageActV2.TAG, "send mm message, intent=" + intent);
                    return true;
                } catch (Exception e) {
                    com.tencent.mm.sdk.b.a.a(MMessageActV2.TAG, "send fail, ex = %s", e.getMessage());
                    return false;
                }
            }
        }
        return invokeLL.booleanValue;
    }
}
