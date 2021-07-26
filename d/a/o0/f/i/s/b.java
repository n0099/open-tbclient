package d.a.o0.f.i.s;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.f.i.f;
/* loaded from: classes7.dex */
public class b extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean G;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context, AdElementInfo adElementInfo, d.a.o0.f.i.n.a aVar) {
        super(context, adElementInfo, aVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, adElementInfo, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AdElementInfo) objArr2[1], (d.a.o0.f.i.n.a) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.G = false;
    }

    @Override // d.a.o0.f.i.s.a
    public void C(RelativeLayout relativeLayout, AdElementInfo adElementInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, relativeLayout, adElementInfo) == null) {
            int videoWidth = adElementInfo.getVideoWidth();
            int videoHeight = adElementInfo.getVideoHeight();
            this.n = d.a.o0.f.i.m.a.b().q();
            this.o = d.a.o0.f.i.m.a.b().p();
            if (videoWidth < videoHeight) {
                this.G = true;
                int i2 = this.n;
                int i3 = (int) (((i2 - videoWidth) / 2) * 0.8d);
                int i4 = (int) (((i2 - videoWidth) / 2) * 0.1d);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i3, i3);
                layoutParams.leftMargin = (this.n - i3) - i4;
                layoutParams.addRule(15);
                layoutParams.removeRule(13);
                layoutParams.removeRule(12);
                layoutParams.bottomMargin = 0;
                relativeLayout.setLayoutParams(layoutParams);
                relativeLayout.setBackgroundColor(this.w.getColor(d.a.o0.f.i.b.ng_game_black));
            }
        }
    }

    @Override // d.a.o0.f.i.s.a
    public String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.G ? "reward_banner_land_html" : "reward_banner_html" : (String) invokeV.objValue;
    }

    @Override // d.a.o0.f.i.s.a
    @SuppressLint({"InflateParams"})
    public View u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? LayoutInflater.from(this.p).inflate(f.ng_game_land_play, (ViewGroup) null) : (View) invokeV.objValue;
    }
}
