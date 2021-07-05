package com.win.opensdk;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.core.Info;
import java.util.List;
/* loaded from: classes7.dex */
public class PBNative implements d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public i0 f42426a;

    /* renamed from: b  reason: collision with root package name */
    public PBNativeListener f42427b;

    public PBNative(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        i0 i0Var = new i0(context, str);
        this.f42426a = i0Var;
        i0Var.f42584f = new f(this);
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                if (this.f42426a != null) {
                    this.f42426a.a();
                    this.f42426a = null;
                }
                if (this.f42427b != null) {
                    this.f42427b = null;
                }
            } catch (Exception unused) {
            }
        }
    }

    public String getBody() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            i0 i0Var = this.f42426a;
            return (i0Var == null || !i0Var.b()) ? "" : i0Var.f42581c.getDesc();
        }
        return (String) invokeV.objValue;
    }

    public String getCallToAction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            i0 i0Var = this.f42426a;
            return (i0Var == null || !i0Var.b()) ? "" : i0Var.f42581c.getBtndesc();
        }
        return (String) invokeV.objValue;
    }

    public String getHeadline() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            i0 i0Var = this.f42426a;
            return (i0Var == null || !i0Var.b()) ? "" : i0Var.f42581c.getTitle();
        }
        return (String) invokeV.objValue;
    }

    public String getIM() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            i0 i0Var = this.f42426a;
            if (i0Var != null) {
                String image = i0Var.b() ? i0Var.f42581c.getImage() : "";
                if (TextUtils.isEmpty(image)) {
                    i0 i0Var2 = this.f42426a;
                    return i0Var2.b() ? i0Var2.f42581c.getIcon() : "";
                }
                return image;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public String getIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            i0 i0Var = this.f42426a;
            return (i0Var == null || !i0Var.b()) ? "" : i0Var.f42581c.getIcon();
        }
        return (String) invokeV.objValue;
    }

    public int getMediaViewHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            i0 i0Var = this.f42426a;
            if (i0Var == null || !i0Var.b()) {
                return 0;
            }
            return i0Var.f42581c.getH();
        }
        return invokeV.intValue;
    }

    public int getMediaViewWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            i0 i0Var = this.f42426a;
            if (i0Var == null || !i0Var.b()) {
                return 0;
            }
            return i0Var.f42581c.getW();
        }
        return invokeV.intValue;
    }

    public String getPid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            i0 i0Var = this.f42426a;
            return (i0Var == null || !i0Var.b()) ? "" : i0Var.f42581c.getPid();
        }
        return (String) invokeV.objValue;
    }

    public boolean isD() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            i0 i0Var = this.f42426a;
            if (i0Var != null) {
                Info info = i0Var.f42581c;
                return info != null && info.getOpent() == 1;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isReady() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            i0 i0Var = this.f42426a;
            return i0Var != null && i0Var.b();
        }
        return invokeV.booleanValue;
    }

    public void load() {
        i0 i0Var;
        K0 k0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (i0Var = this.f42426a) == null || (k0 = i0Var.f42580b) == null) {
            return;
        }
        k0.b();
    }

    public void registerViewForInteraction(View view, PBMediaView pBMediaView) {
        i0 i0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048588, this, view, pBMediaView) == null) || (i0Var = this.f42426a) == null) {
            return;
        }
        i0Var.a(view, pBMediaView);
    }

    public void registerViewForInteraction(View view, PBMediaView pBMediaView, List list) {
        i0 i0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048589, this, view, pBMediaView, list) == null) || (i0Var = this.f42426a) == null) {
            return;
        }
        i0Var.a(view, pBMediaView, list);
    }

    public void setNativeListener(PBNativeListener pBNativeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, pBNativeListener) == null) {
            this.f42427b = pBNativeListener;
        }
    }
}
