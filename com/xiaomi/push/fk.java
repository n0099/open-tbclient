package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
/* loaded from: classes2.dex */
public class fk implements fo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ fj f70946a;

    public fk(fj fjVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fjVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f70946a = fjVar;
    }

    @Override // com.xiaomi.push.fo
    public void a(fl flVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, flVar) == null) {
            com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + this.f70946a.f393a.format(new Date()) + " Connection started (" + this.f70946a.f390a.hashCode() + SmallTailInfo.EMOTION_SUFFIX);
        }
    }

    @Override // com.xiaomi.push.fo
    public void a(fl flVar, int i2, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, flVar, i2, exc) == null) {
            com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + this.f70946a.f393a.format(new Date()) + " Connection closed (" + this.f70946a.f390a.hashCode() + SmallTailInfo.EMOTION_SUFFIX);
        }
    }

    @Override // com.xiaomi.push.fo
    public void a(fl flVar, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, flVar, exc) == null) {
            com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + this.f70946a.f393a.format(new Date()) + " Reconnection failed due to an exception (" + this.f70946a.f390a.hashCode() + SmallTailInfo.EMOTION_SUFFIX);
            exc.printStackTrace();
        }
    }

    @Override // com.xiaomi.push.fo
    public void b(fl flVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, flVar) == null) {
            com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + this.f70946a.f393a.format(new Date()) + " Connection reconnected (" + this.f70946a.f390a.hashCode() + SmallTailInfo.EMOTION_SUFFIX);
        }
    }
}
