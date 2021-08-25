package com.win.opensdk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class p extends Handler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PBDrawVideo f76947a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(PBDrawVideo pBDrawVideo, Looper looper) {
        super(looper);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pBDrawVideo, looper};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Looper) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f76947a = pBDrawVideo;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        PBDrawVideo pBDrawVideo;
        PBDrawVideoListener pBDrawVideoListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, message) == null) || message.what != 0 || (pBDrawVideoListener = (pBDrawVideo = this.f76947a).f76657c) == null || pBDrawVideo.f76658d) {
            return;
        }
        pBDrawVideoListener.onFail(PBError.LOAD_TIME_OUT);
        this.f76947a.f76659e = true;
    }
}
