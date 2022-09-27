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
/* loaded from: classes8.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.tencent.mm.opensdk.channel.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0702a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String action;
        public long b;
        public Bundle bundle;
        public String content;

        public C0702a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public static boolean a(Context context, C0702a c0702a) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, c0702a)) == null) {
            if (context == null) {
                str = "send fail, invalid argument";
            } else if (!d.b(c0702a.action)) {
                String str2 = null;
                if (!d.b(c0702a.a)) {
                    str2 = c0702a.a + ".permission.MM_MESSAGE";
                }
                Intent intent = new Intent(c0702a.action);
                Bundle bundle = c0702a.bundle;
                if (bundle != null) {
                    intent.putExtras(bundle);
                }
                String packageName = context.getPackageName();
                intent.putExtra(ConstantsAPI.SDK_VERSION, Build.SDK_INT);
                intent.putExtra(ConstantsAPI.APP_PACKAGE, packageName);
                intent.putExtra(ConstantsAPI.CONTENT, c0702a.content);
                intent.putExtra(ConstantsAPI.APP_SUPORT_CONTENT_TYPE, c0702a.b);
                intent.putExtra(ConstantsAPI.CHECK_SUM, b.a(c0702a.content, Build.SDK_INT, packageName));
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
