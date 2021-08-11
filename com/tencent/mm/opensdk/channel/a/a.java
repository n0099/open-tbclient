package com.tencent.mm.opensdk.channel.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.mm.opensdk.constants.Build;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.d;
/* loaded from: classes10.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.tencent.mm.opensdk.channel.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C2081a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f75864a;
        public String action;

        /* renamed from: b  reason: collision with root package name */
        public long f75865b;
        public Bundle bundle;
        public String content;

        public C2081a() {
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

    public static boolean a(Context context, C2081a c2081a) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, c2081a)) == null) {
            if (context == null) {
                str = "send fail, invalid argument";
            } else if (!d.b(c2081a.action)) {
                String str2 = null;
                if (!d.b(c2081a.f75864a)) {
                    str2 = c2081a.f75864a + ".permission.MM_MESSAGE";
                }
                Intent intent = new Intent(c2081a.action);
                Bundle bundle = c2081a.bundle;
                if (bundle != null) {
                    intent.putExtras(bundle);
                }
                String packageName = context.getPackageName();
                intent.putExtra("_mmessage_sdkVersion", Build.SDK_INT);
                intent.putExtra("_mmessage_appPackage", packageName);
                intent.putExtra("_mmessage_content", c2081a.content);
                intent.putExtra(ConstantsAPI.APP_SUPORT_CONTENT_TYPE, c2081a.f75865b);
                intent.putExtra("_mmessage_checksum", b.a(c2081a.content, Build.SDK_INT, packageName));
                context.sendBroadcast(intent, str2);
                Log.d("MicroMsg.SDK.MMessage", "send mm message, intent=" + intent + ", perm=" + str2);
                return true;
            } else {
                str = "send fail, action is null";
            }
            Log.e("MicroMsg.SDK.MMessage", str);
            return false;
        }
        return invokeLL.booleanValue;
    }
}
