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
/* loaded from: classes10.dex */
public class PBNative implements g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public E0 f76851a;

    /* renamed from: b  reason: collision with root package name */
    public PBNativeListener f76852b;

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
        E0 e0 = new E0(context, str);
        this.f76851a = e0;
        e0.f76786f = new t(this);
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                if (this.f76851a != null) {
                    this.f76851a.a();
                    this.f76851a = null;
                }
                if (this.f76852b != null) {
                    this.f76852b = null;
                }
            } catch (Exception unused) {
            }
        }
    }

    public String getBody() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            E0 e0 = this.f76851a;
            return (e0 == null || !e0.b()) ? "" : e0.f76783c.getDesc();
        }
        return (String) invokeV.objValue;
    }

    public String getCallToAction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            E0 e0 = this.f76851a;
            return (e0 == null || !e0.b()) ? "" : e0.f76783c.getBtndesc();
        }
        return (String) invokeV.objValue;
    }

    public String getHeadline() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            E0 e0 = this.f76851a;
            return (e0 == null || !e0.b()) ? "" : e0.f76783c.getTitle();
        }
        return (String) invokeV.objValue;
    }

    public String getIM() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            E0 e0 = this.f76851a;
            if (e0 != null) {
                String image = e0.b() ? e0.f76783c.getImage() : "";
                if (TextUtils.isEmpty(image)) {
                    E0 e02 = this.f76851a;
                    return e02.b() ? e02.f76783c.getIcon() : "";
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
            E0 e0 = this.f76851a;
            return (e0 == null || !e0.b()) ? "" : e0.f76783c.getIcon();
        }
        return (String) invokeV.objValue;
    }

    public int getMediaViewHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            E0 e0 = this.f76851a;
            if (e0 == null || !e0.b()) {
                return 0;
            }
            return e0.f76783c.getH();
        }
        return invokeV.intValue;
    }

    public int getMediaViewWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            E0 e0 = this.f76851a;
            if (e0 == null || !e0.b()) {
                return 0;
            }
            return e0.f76783c.getW();
        }
        return invokeV.intValue;
    }

    public String getPid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            E0 e0 = this.f76851a;
            return (e0 == null || !e0.b()) ? "" : e0.f76783c.getPid();
        }
        return (String) invokeV.objValue;
    }

    public boolean isD() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            E0 e0 = this.f76851a;
            if (e0 != null) {
                Info info = e0.f76783c;
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
            E0 e0 = this.f76851a;
            return e0 != null && e0.b();
        }
        return invokeV.booleanValue;
    }

    public void load() {
        E0 e0;
        m1 m1Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (e0 = this.f76851a) == null || (m1Var = e0.f76782b) == null) {
            return;
        }
        m1Var.b();
    }

    public void registerViewForInteraction(View view, PBMediaView pBMediaView) {
        E0 e0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048588, this, view, pBMediaView) == null) || (e0 = this.f76851a) == null) {
            return;
        }
        e0.a(view, pBMediaView);
    }

    public void registerViewForInteraction(View view, PBMediaView pBMediaView, List list) {
        E0 e0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048589, this, view, pBMediaView, list) == null) || (e0 = this.f76851a) == null) {
            return;
        }
        e0.a(view, pBMediaView, list);
    }

    public void setNativeListener(PBNativeListener pBNativeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, pBNativeListener) == null) {
            this.f76852b = pBNativeListener;
        }
    }
}
