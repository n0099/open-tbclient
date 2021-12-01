package com.win.opensdk;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.p.a.a5;
import c.p.a.f5;
import c.p.a.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.core.Info;
import java.util.List;
/* loaded from: classes3.dex */
public class PBNative {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AD_TYPE_HTML = "h5";
    public static final String AD_TYPE_IMG = "image";
    public static final String AD_TYPE_UNKNOWN = "unknown";
    public static final String AD_TYPE_VIDEO = "video";
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public l f62607b;

    /* renamed from: c  reason: collision with root package name */
    public PBNativeListener f62608c;

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
        this.a = str;
        l lVar = new l(context, str);
        this.f62607b = lVar;
        lVar.f30830f = new f5(this);
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                if (this.f62607b != null) {
                    this.f62607b.b();
                    this.f62607b = null;
                }
                if (this.f62608c != null) {
                    this.f62608c = null;
                }
            } catch (Exception unused) {
            }
        }
    }

    public String getAdType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            l lVar = this.f62607b;
            if (lVar == null || !lVar.g()) {
                return "unknown";
            }
            String material_type = lVar.f30827c.getMaterial_type();
            return !TextUtils.isEmpty(material_type) ? material_type : "unknown";
        }
        return (String) invokeV.objValue;
    }

    public String getBody() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            l lVar = this.f62607b;
            return (lVar == null || !lVar.g()) ? "" : lVar.f30827c.getDesc();
        }
        return (String) invokeV.objValue;
    }

    public String getCallToAction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            l lVar = this.f62607b;
            return (lVar == null || !lVar.g()) ? "" : lVar.f30827c.getBtndesc();
        }
        return (String) invokeV.objValue;
    }

    public String getHeadline() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            l lVar = this.f62607b;
            return (lVar == null || !lVar.g()) ? "" : lVar.f30827c.getTitle();
        }
        return (String) invokeV.objValue;
    }

    public String getIM() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            l lVar = this.f62607b;
            if (lVar != null) {
                String image = lVar.g() ? lVar.f30827c.getImage() : "";
                if (TextUtils.isEmpty(image)) {
                    l lVar2 = this.f62607b;
                    return lVar2.g() ? lVar2.f30827c.getIcon() : "";
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            l lVar = this.f62607b;
            return (lVar == null || !lVar.g()) ? "" : lVar.f30827c.getIcon();
        }
        return (String) invokeV.objValue;
    }

    public int getMediaViewHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            l lVar = this.f62607b;
            if (lVar == null || !lVar.g()) {
                return 0;
            }
            return lVar.f30827c.getH();
        }
        return invokeV.intValue;
    }

    public int getMediaViewWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            l lVar = this.f62607b;
            if (lVar == null || !lVar.g()) {
                return 0;
            }
            return lVar.f30827c.getW();
        }
        return invokeV.intValue;
    }

    public String getPid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public boolean isD() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            l lVar = this.f62607b;
            if (lVar != null) {
                Info info = lVar.f30827c;
                return info != null && info.getOpent() == 1;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isReady() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            l lVar = this.f62607b;
            return lVar != null && lVar.g();
        }
        return invokeV.booleanValue;
    }

    public void load() {
        l lVar;
        a5 a5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (lVar = this.f62607b) == null || (a5Var = lVar.f30826b) == null) {
            return;
        }
        a5Var.g();
    }

    public void registerViewForInteraction(View view, PBMediaView pBMediaView) {
        l lVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, view, pBMediaView) == null) || (lVar = this.f62607b) == null) {
            return;
        }
        lVar.c(view, pBMediaView);
    }

    public void registerViewForInteraction(View view, PBMediaView pBMediaView, List list) {
        l lVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048590, this, view, pBMediaView, list) == null) || (lVar = this.f62607b) == null) {
            return;
        }
        lVar.d(view, pBMediaView, list);
    }

    public void setNativeListener(PBNativeListener pBNativeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, pBNativeListener) == null) {
            this.f62608c = pBNativeListener;
        }
    }
}
