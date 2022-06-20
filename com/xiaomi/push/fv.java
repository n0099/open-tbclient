package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
/* loaded from: classes8.dex */
public class fv implements fz {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ fu a;

    public fv(fu fuVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fuVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = fuVar;
    }

    @Override // com.xiaomi.push.fz
    public void a(fw fwVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fwVar) == null) {
            com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + this.a.f393a.format(new Date()) + " Connection started (" + this.a.f390a.hashCode() + SmallTailInfo.EMOTION_SUFFIX);
        }
    }

    @Override // com.xiaomi.push.fz
    public void a(fw fwVar, int i, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fwVar, i, exc) == null) {
            com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + this.a.f393a.format(new Date()) + " Connection closed (" + this.a.f390a.hashCode() + SmallTailInfo.EMOTION_SUFFIX);
        }
    }

    @Override // com.xiaomi.push.fz
    public void a(fw fwVar, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, fwVar, exc) == null) {
            com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + this.a.f393a.format(new Date()) + " Reconnection failed due to an exception (" + this.a.f390a.hashCode() + SmallTailInfo.EMOTION_SUFFIX);
            exc.printStackTrace();
        }
    }

    @Override // com.xiaomi.push.fz
    public void b(fw fwVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fwVar) == null) {
            com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + this.a.f393a.format(new Date()) + " Connection reconnected (" + this.a.f390a.hashCode() + SmallTailInfo.EMOTION_SUFFIX);
        }
    }
}
