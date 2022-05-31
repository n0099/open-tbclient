package com.repackage;

import android.content.Context;
import android.widget.VideoView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.PBError;
/* loaded from: classes5.dex */
public class eo9 implements xn9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ vl9 a;

    public eo9(vl9 vl9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vl9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = vl9Var;
    }

    @Override // com.repackage.xn9
    public void a(boolean z) {
        VideoView videoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (videoView = this.a.h) == null) {
            return;
        }
        if (!z) {
            videoView.pause();
            return;
        }
        videoView.start();
        this.a.a();
    }

    @Override // com.win.opensdk.PBListener
    public void onClicked() {
        wl9 wl9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (wl9Var = this.a.c) == null) {
            return;
        }
        wl9Var.onClicked();
    }

    @Override // com.repackage.xn9
    public void onDisplayed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            vl9 vl9Var = this.a;
            if (vl9Var.c != null) {
                VideoView videoView = vl9Var.h;
                if (videoView != null) {
                    videoView.start();
                    this.a.a();
                }
                this.a.c.onDisplayed();
            }
        }
    }

    @Override // com.win.opensdk.PBListener
    public void onFail(PBError pBError) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, pBError) == null) {
            if (pBError == PBError.PID_INVALID) {
                wl9 wl9Var = this.a.c;
                if (wl9Var != null) {
                    wl9Var.onFail(PBError.NO_FILL);
                    return;
                }
                return;
            }
            vl9 vl9Var = this.a;
            wl9 wl9Var2 = vl9Var.c;
            if (wl9Var2 == null || vl9Var.e) {
                return;
            }
            wl9Var2.onFail(PBError.NO_FILL);
        }
    }

    @Override // com.win.opensdk.PBListener
    public void onLoaded() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            jn9 jn9Var = this.a.b.a;
            if (jn9Var != null && jn9Var.e()) {
                vl9 vl9Var = this.a;
                Context context = vl9Var.a;
                jn9 jn9Var2 = vl9Var.b.a;
                bn9.l(context, (jn9Var2 == null || !jn9Var2.e()) ? 0L : jn9Var2.c.getLo_timeout());
                jn9 jn9Var3 = this.a.b.a;
                String str = "";
                if (((jn9Var3 == null || !jn9Var3.e()) ? "" : jn9Var3.c.getLoad_type()).equals("video")) {
                    jn9 jn9Var4 = this.a.b.a;
                    if (jn9Var4 != null && jn9Var4.e()) {
                        str = jn9Var4.c.getLoad();
                    }
                    this.a.c(str);
                    return;
                }
                wl9 wl9Var = this.a.c;
                if (wl9Var != null) {
                    wl9Var.onFail(PBError.LOAD_TYPE_ERROR);
                }
            }
        }
    }
}
