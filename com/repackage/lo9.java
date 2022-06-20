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
public class lo9 implements eo9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ cm9 a;

    public lo9(cm9 cm9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cm9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = cm9Var;
    }

    @Override // com.repackage.eo9
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
        dm9 dm9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (dm9Var = this.a.c) == null) {
            return;
        }
        dm9Var.onClicked();
    }

    @Override // com.repackage.eo9
    public void onDisplayed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            cm9 cm9Var = this.a;
            if (cm9Var.c != null) {
                VideoView videoView = cm9Var.h;
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
                dm9 dm9Var = this.a.c;
                if (dm9Var != null) {
                    dm9Var.onFail(PBError.NO_FILL);
                    return;
                }
                return;
            }
            cm9 cm9Var = this.a;
            dm9 dm9Var2 = cm9Var.c;
            if (dm9Var2 == null || cm9Var.e) {
                return;
            }
            dm9Var2.onFail(PBError.NO_FILL);
        }
    }

    @Override // com.win.opensdk.PBListener
    public void onLoaded() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            qn9 qn9Var = this.a.b.a;
            if (qn9Var != null && qn9Var.e()) {
                cm9 cm9Var = this.a;
                Context context = cm9Var.a;
                qn9 qn9Var2 = cm9Var.b.a;
                in9.l(context, (qn9Var2 == null || !qn9Var2.e()) ? 0L : qn9Var2.c.getLo_timeout());
                qn9 qn9Var3 = this.a.b.a;
                String str = "";
                if (((qn9Var3 == null || !qn9Var3.e()) ? "" : qn9Var3.c.getLoad_type()).equals("video")) {
                    qn9 qn9Var4 = this.a.b.a;
                    if (qn9Var4 != null && qn9Var4.e()) {
                        str = qn9Var4.c.getLoad();
                    }
                    this.a.c(str);
                    return;
                }
                dm9 dm9Var = this.a.c;
                if (dm9Var != null) {
                    dm9Var.onFail(PBError.LOAD_TYPE_ERROR);
                }
            }
        }
    }
}
