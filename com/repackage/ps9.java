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
public class ps9 implements is9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ gq9 a;

    public ps9(gq9 gq9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gq9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = gq9Var;
    }

    @Override // com.repackage.is9
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
        hq9 hq9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (hq9Var = this.a.c) == null) {
            return;
        }
        hq9Var.onClicked();
    }

    @Override // com.repackage.is9
    public void onDisplayed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            gq9 gq9Var = this.a;
            if (gq9Var.c != null) {
                VideoView videoView = gq9Var.h;
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
                hq9 hq9Var = this.a.c;
                if (hq9Var != null) {
                    hq9Var.onFail(PBError.NO_FILL);
                    return;
                }
                return;
            }
            gq9 gq9Var = this.a;
            hq9 hq9Var2 = gq9Var.c;
            if (hq9Var2 == null || gq9Var.e) {
                return;
            }
            hq9Var2.onFail(PBError.NO_FILL);
        }
    }

    @Override // com.win.opensdk.PBListener
    public void onLoaded() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ur9 ur9Var = this.a.b.a;
            if (ur9Var != null && ur9Var.e()) {
                gq9 gq9Var = this.a;
                Context context = gq9Var.a;
                ur9 ur9Var2 = gq9Var.b.a;
                mr9.l(context, (ur9Var2 == null || !ur9Var2.e()) ? 0L : ur9Var2.c.getLo_timeout());
                ur9 ur9Var3 = this.a.b.a;
                String str = "";
                if (((ur9Var3 == null || !ur9Var3.e()) ? "" : ur9Var3.c.getLoad_type()).equals("video")) {
                    ur9 ur9Var4 = this.a.b.a;
                    if (ur9Var4 != null && ur9Var4.e()) {
                        str = ur9Var4.c.getLoad();
                    }
                    this.a.c(str);
                    return;
                }
                hq9 hq9Var = this.a.c;
                if (hq9Var != null) {
                    hq9Var.onFail(PBError.LOAD_TYPE_ERROR);
                }
            }
        }
    }
}
