package com.repackage;

import android.content.Context;
import android.widget.VideoView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.PBError;
/* loaded from: classes6.dex */
public class is9 implements bs9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ zp9 a;

    public is9(zp9 zp9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zp9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = zp9Var;
    }

    @Override // com.repackage.bs9
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
        aq9 aq9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (aq9Var = this.a.c) == null) {
            return;
        }
        aq9Var.onClicked();
    }

    @Override // com.repackage.bs9
    public void onDisplayed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            zp9 zp9Var = this.a;
            if (zp9Var.c != null) {
                VideoView videoView = zp9Var.h;
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
                aq9 aq9Var = this.a.c;
                if (aq9Var != null) {
                    aq9Var.onFail(PBError.NO_FILL);
                    return;
                }
                return;
            }
            zp9 zp9Var = this.a;
            aq9 aq9Var2 = zp9Var.c;
            if (aq9Var2 == null || zp9Var.e) {
                return;
            }
            aq9Var2.onFail(PBError.NO_FILL);
        }
    }

    @Override // com.win.opensdk.PBListener
    public void onLoaded() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            nr9 nr9Var = this.a.b.a;
            if (nr9Var != null && nr9Var.e()) {
                zp9 zp9Var = this.a;
                Context context = zp9Var.a;
                nr9 nr9Var2 = zp9Var.b.a;
                fr9.l(context, (nr9Var2 == null || !nr9Var2.e()) ? 0L : nr9Var2.c.getLo_timeout());
                nr9 nr9Var3 = this.a.b.a;
                String str = "";
                if (((nr9Var3 == null || !nr9Var3.e()) ? "" : nr9Var3.c.getLoad_type()).equals("video")) {
                    nr9 nr9Var4 = this.a.b.a;
                    if (nr9Var4 != null && nr9Var4.e()) {
                        str = nr9Var4.c.getLoad();
                    }
                    this.a.c(str);
                    return;
                }
                aq9 aq9Var = this.a.c;
                if (aq9Var != null) {
                    aq9Var.onFail(PBError.LOAD_TYPE_ERROR);
                }
            }
        }
    }
}
