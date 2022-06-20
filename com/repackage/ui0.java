package com.repackage;

import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.consts.AdDownloadAction;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class ui0 extends Handler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ii0 a;
    public float b;

    public ui0(@NonNull ii0 ii0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ii0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = -1.0f;
        this.a = ii0Var;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c();
            long j = this.a.q.d;
            if (j <= 0) {
                return;
            }
            this.b = (((float) j) * 0.595f) / 768000.0f;
            Message message = new Message();
            message.what = 1;
            sendMessage(message);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Message message = new Message();
            message.what = 1;
            sendMessageDelayed(message, (this.b / 59.500004f) * 1000.0f);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            removeMessages(1);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, message) == null) {
            super.handleMessage(message);
            if (message.what != 1) {
                c();
                return;
            }
            ii0 ii0Var = this.a;
            if (ii0Var.q.f == 1) {
                return;
            }
            if (ii0Var.c != AdDownloadStatus.DOWNLOADING) {
                c();
                return;
            }
            float f = ii0Var.j;
            if (f >= 0.595f) {
                c();
                return;
            }
            ii0Var.j = Math.max(ii0Var.i, f) + 0.01f;
            vh0.b().e(AdDownloadAction.PROGRESS_UPDATE, this.a);
            b();
        }
    }
}
