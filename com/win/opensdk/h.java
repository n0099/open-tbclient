package com.win.opensdk;

import android.content.Context;
import android.util.Log;
import android.widget.VideoView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class h implements f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PBDrawVideo f39813a;

    public h(PBDrawVideo pBDrawVideo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pBDrawVideo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f39813a = pBDrawVideo;
    }

    @Override // com.win.opensdk.f
    public void a(boolean z) {
        VideoView videoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (videoView = this.f39813a.f39625h) == null) {
            return;
        }
        if (!z) {
            videoView.pause();
            return;
        }
        videoView.start();
        this.f39813a.a();
    }

    @Override // com.win.opensdk.PBListener
    public void onClicked() {
        PBDrawVideoListener pBDrawVideoListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (pBDrawVideoListener = this.f39813a.f39620c) == null) {
            return;
        }
        pBDrawVideoListener.onClicked();
    }

    @Override // com.win.opensdk.f
    public void onDisplayed() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f39813a.f39620c == null) {
            return;
        }
        Log.e("regiser", "回调给开发者onDisplayed");
        VideoView videoView = this.f39813a.f39625h;
        if (videoView != null) {
            videoView.start();
            this.f39813a.a();
        }
        this.f39813a.f39620c.onDisplayed();
    }

    @Override // com.win.opensdk.PBListener
    public void onFail(PBError pBError) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, pBError) == null) {
            if (pBError == PBError.PID_INVALID) {
                PBDrawVideoListener pBDrawVideoListener = this.f39813a.f39620c;
                if (pBDrawVideoListener != null) {
                    pBDrawVideoListener.onFail(PBError.NO_FILL);
                    return;
                }
                return;
            }
            PBDrawVideo pBDrawVideo = this.f39813a;
            PBDrawVideoListener pBDrawVideoListener2 = pBDrawVideo.f39620c;
            if (pBDrawVideoListener2 == null || pBDrawVideo.f39622e) {
                return;
            }
            pBDrawVideoListener2.onFail(PBError.NO_FILL);
        }
    }

    @Override // com.win.opensdk.PBListener
    public void onLoaded() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            d0 d0Var = this.f39813a.f39619b.f39792a;
            if (d0Var != null && d0Var.b()) {
                PBDrawVideo pBDrawVideo = this.f39813a;
                Context context = pBDrawVideo.f39618a;
                d0 d0Var2 = pBDrawVideo.f39619b.f39792a;
                U1.b(context, (d0Var2 == null || !d0Var2.b()) ? 0L : d0Var2.f39779c.getLo_timeout());
                d0 d0Var3 = this.f39813a.f39619b.f39792a;
                String str = "";
                if (((d0Var3 == null || !d0Var3.b()) ? "" : d0Var3.f39779c.getLoad_type()).equals("video")) {
                    d0 d0Var4 = this.f39813a.f39619b.f39792a;
                    if (d0Var4 != null && d0Var4.b()) {
                        str = d0Var4.f39779c.getLoad();
                    }
                    this.f39813a.a(str);
                    return;
                }
                PBDrawVideoListener pBDrawVideoListener = this.f39813a.f39620c;
                if (pBDrawVideoListener != null) {
                    pBDrawVideoListener.onFail(PBError.LOAD_TYPE_ERROR);
                }
            }
        }
    }
}
