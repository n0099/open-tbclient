package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public final class j implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f70630a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ e f98a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f99a;

    public j(String str, Context context, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, context, eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f99a = str;
        this.f70630a = context;
        this.f98a = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || TextUtils.isEmpty(this.f99a)) {
            return;
        }
        String[] split = this.f99a.split(Constants.WAVE_SEPARATOR);
        int length = split.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                str = "";
                break;
            }
            String str2 = split[i2];
            if (!TextUtils.isEmpty(str2) && str2.startsWith("token:")) {
                str = str2.substring(str2.indexOf(":") + 1);
                break;
            }
            i2++;
        }
        if (TextUtils.isEmpty(str)) {
            com.xiaomi.channel.commonutils.logger.b.m73a("ASSEMBLE_PUSH : receive incorrect token");
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.m73a("ASSEMBLE_PUSH : receive correct token");
        i.d(this.f70630a, this.f98a, str);
        i.m133a(this.f70630a);
    }
}
