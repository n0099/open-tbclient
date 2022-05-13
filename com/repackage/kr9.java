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
public class kr9 implements dr9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ bp9 a;

    public kr9(bp9 bp9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bp9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = bp9Var;
    }

    @Override // com.repackage.dr9
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
        cp9 cp9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (cp9Var = this.a.c) == null) {
            return;
        }
        cp9Var.onClicked();
    }

    @Override // com.repackage.dr9
    public void onDisplayed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            bp9 bp9Var = this.a;
            if (bp9Var.c != null) {
                VideoView videoView = bp9Var.h;
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
                cp9 cp9Var = this.a.c;
                if (cp9Var != null) {
                    cp9Var.onFail(PBError.NO_FILL);
                    return;
                }
                return;
            }
            bp9 bp9Var = this.a;
            cp9 cp9Var2 = bp9Var.c;
            if (cp9Var2 == null || bp9Var.e) {
                return;
            }
            cp9Var2.onFail(PBError.NO_FILL);
        }
    }

    @Override // com.win.opensdk.PBListener
    public void onLoaded() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            pq9 pq9Var = this.a.b.a;
            if (pq9Var != null && pq9Var.e()) {
                bp9 bp9Var = this.a;
                Context context = bp9Var.a;
                pq9 pq9Var2 = bp9Var.b.a;
                hq9.l(context, (pq9Var2 == null || !pq9Var2.e()) ? 0L : pq9Var2.c.getLo_timeout());
                pq9 pq9Var3 = this.a.b.a;
                String str = "";
                if (((pq9Var3 == null || !pq9Var3.e()) ? "" : pq9Var3.c.getLoad_type()).equals("video")) {
                    pq9 pq9Var4 = this.a.b.a;
                    if (pq9Var4 != null && pq9Var4.e()) {
                        str = pq9Var4.c.getLoad();
                    }
                    this.a.c(str);
                    return;
                }
                cp9 cp9Var = this.a.c;
                if (cp9Var != null) {
                    cp9Var.onFail(PBError.LOAD_TYPE_ERROR);
                }
            }
        }
    }
}
