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
import com.repackage.jo9;
import com.repackage.tt9;
import com.repackage.yt9;
import com.win.opensdk.core.Info;
import java.util.List;
/* loaded from: classes8.dex */
public class PBNative {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AD_TYPE_HTML = "h5";
    public static final String AD_TYPE_IMG = "image";
    public static final String AD_TYPE_UNKNOWN = "unknown";
    public static final String AD_TYPE_VIDEO = "video";
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public jo9 b;
    public PBNativeListener c;

    public PBNative(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = str;
        jo9 jo9Var = new jo9(context, str);
        this.b = jo9Var;
        jo9Var.f = new yt9(this);
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                if (this.b != null) {
                    this.b.b();
                    this.b = null;
                }
                if (this.c != null) {
                    this.c = null;
                }
            } catch (Exception unused) {
            }
        }
    }

    public String getAdType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            jo9 jo9Var = this.b;
            if (jo9Var == null || !jo9Var.g()) {
                return "unknown";
            }
            String material_type = jo9Var.c.getMaterial_type();
            return !TextUtils.isEmpty(material_type) ? material_type : "unknown";
        }
        return (String) invokeV.objValue;
    }

    public String getBody() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            jo9 jo9Var = this.b;
            return (jo9Var == null || !jo9Var.g()) ? "" : jo9Var.c.getDesc();
        }
        return (String) invokeV.objValue;
    }

    public String getCallToAction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            jo9 jo9Var = this.b;
            return (jo9Var == null || !jo9Var.g()) ? "" : jo9Var.c.getBtndesc();
        }
        return (String) invokeV.objValue;
    }

    public String getHeadline() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            jo9 jo9Var = this.b;
            return (jo9Var == null || !jo9Var.g()) ? "" : jo9Var.c.getTitle();
        }
        return (String) invokeV.objValue;
    }

    public String getIM() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            jo9 jo9Var = this.b;
            if (jo9Var != null) {
                String image = jo9Var.g() ? jo9Var.c.getImage() : "";
                if (TextUtils.isEmpty(image)) {
                    jo9 jo9Var2 = this.b;
                    return jo9Var2.g() ? jo9Var2.c.getIcon() : "";
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
            jo9 jo9Var = this.b;
            return (jo9Var == null || !jo9Var.g()) ? "" : jo9Var.c.getIcon();
        }
        return (String) invokeV.objValue;
    }

    public int getMediaViewHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            jo9 jo9Var = this.b;
            if (jo9Var == null || !jo9Var.g()) {
                return 0;
            }
            return jo9Var.c.getH();
        }
        return invokeV.intValue;
    }

    public int getMediaViewWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            jo9 jo9Var = this.b;
            if (jo9Var == null || !jo9Var.g()) {
                return 0;
            }
            return jo9Var.c.getW();
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
            jo9 jo9Var = this.b;
            if (jo9Var != null) {
                Info info = jo9Var.c;
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
            jo9 jo9Var = this.b;
            return jo9Var != null && jo9Var.g();
        }
        return invokeV.booleanValue;
    }

    public void load() {
        jo9 jo9Var;
        tt9 tt9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (jo9Var = this.b) == null || (tt9Var = jo9Var.b) == null) {
            return;
        }
        tt9Var.g();
    }

    public void registerViewForInteraction(View view2, PBMediaView pBMediaView) {
        jo9 jo9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, view2, pBMediaView) == null) || (jo9Var = this.b) == null) {
            return;
        }
        jo9Var.c(view2, pBMediaView);
    }

    public void registerViewForInteraction(View view2, PBMediaView pBMediaView, List list) {
        jo9 jo9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048590, this, view2, pBMediaView, list) == null) || (jo9Var = this.b) == null) {
            return;
        }
        jo9Var.d(view2, pBMediaView, list);
    }

    public void setNativeListener(PBNativeListener pBNativeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, pBNativeListener) == null) {
            this.c = pBNativeListener;
        }
    }
}
