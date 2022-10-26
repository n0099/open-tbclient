package com.win.opensdk;

import android.content.Context;
import android.widget.VideoView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class h implements f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ PBDrawVideo a;

    public h(PBDrawVideo pBDrawVideo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pBDrawVideo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = pBDrawVideo;
    }

    @Override // com.win.opensdk.f
    public void a(boolean z) {
        VideoView videoView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && (videoView = this.a.i) != null) {
            if (z) {
                videoView.start();
                this.a.a();
                return;
            }
            videoView.pause();
        }
    }

    @Override // com.win.opensdk.PBListener
    public void onFail(PBError pBError) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, pBError) == null) {
            if (pBError == PBError.PID_INVALID) {
                PBDrawVideoListener pBDrawVideoListener = this.a.d;
                if (pBDrawVideoListener != null) {
                    pBDrawVideoListener.onFail(PBError.NO_FILL);
                    return;
                }
                return;
            }
            PBDrawVideo pBDrawVideo = this.a;
            PBDrawVideoListener pBDrawVideoListener2 = pBDrawVideo.d;
            if (pBDrawVideoListener2 != null && !pBDrawVideo.f) {
                pBDrawVideoListener2.onFail(PBError.NO_FILL);
            }
        }
    }

    @Override // com.win.opensdk.PBListener
    public void onClicked() {
        PBDrawVideoListener pBDrawVideoListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (pBDrawVideoListener = this.a.d) != null) {
            pBDrawVideoListener.onClicked();
        }
    }

    @Override // com.win.opensdk.f
    public void onDisplayed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            PBDrawVideo pBDrawVideo = this.a;
            if (pBDrawVideo.d != null) {
                VideoView videoView = pBDrawVideo.i;
                if (videoView != null) {
                    videoView.start();
                    this.a.a();
                }
                this.a.d.onDisplayed();
            }
        }
    }

    @Override // com.win.opensdk.PBListener
    public void onLoaded() {
        boolean z;
        long j;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            c0 c0Var = this.a.c.a;
            if (c0Var != null && c0Var.b()) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                PBDrawVideo pBDrawVideo = this.a;
                Context context = pBDrawVideo.a;
                c0 c0Var2 = pBDrawVideo.c.a;
                if (c0Var2 != null && c0Var2.b()) {
                    j = c0Var2.c.getLo_timeout();
                } else {
                    j = 0;
                }
                Z1.b(context, j);
                c0 c0Var3 = this.a.c.a;
                String str2 = "";
                if (c0Var3 == null || !c0Var3.b()) {
                    str = "";
                } else {
                    str = c0Var3.c.getLoad_type();
                }
                if (str.equals("video")) {
                    c0 c0Var4 = this.a.c.a;
                    if (c0Var4 != null && c0Var4.b()) {
                        str2 = c0Var4.c.getLoad();
                    }
                    this.a.a(str2);
                    return;
                }
                PBDrawVideoListener pBDrawVideoListener = this.a.d;
                if (pBDrawVideoListener != null) {
                    pBDrawVideoListener.onFail(PBError.LOAD_TYPE_ERROR);
                }
            }
        }
    }
}
