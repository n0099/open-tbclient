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
/* loaded from: classes8.dex */
public class PBNative implements g {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AD_TYPE_HTML = "h5";
    public static final String AD_TYPE_IMG = "image";
    public static final String AD_TYPE_UNKNOWN = "unknown";
    public static final String AD_TYPE_VIDEO = "video";
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public D0 b;
    public PBNativeListener c;

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                if (this.b != null) {
                    this.b.a();
                    this.b = null;
                }
                if (this.c != null) {
                    this.c = null;
                }
            } catch (Exception unused) {
            }
        }
    }

    public String getPid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public boolean isReady() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            D0 d0 = this.b;
            return d0 != null && d0.b();
        }
        return invokeV.booleanValue;
    }

    public void registerViewForInteraction(View view2, PBMediaView pBMediaView) {
        D0 d0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, view2, pBMediaView) == null) || (d0 = this.b) == null) {
            return;
        }
        d0.a(view2, pBMediaView);
    }

    public void registerViewForInteraction(View view2, PBMediaView pBMediaView, List list) {
        D0 d0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048590, this, view2, pBMediaView, list) == null) || (d0 = this.b) == null) {
            return;
        }
        d0.a(view2, pBMediaView, list);
    }

    public void setNativeListener(PBNativeListener pBNativeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, pBNativeListener) == null) {
            this.c = pBNativeListener;
        }
    }

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
        D0 d0 = new D0(context, str);
        this.b = d0;
        d0.f = new s(this);
    }

    public String getAdType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            D0 d0 = this.b;
            if (d0 == null || !d0.b()) {
                return "unknown";
            }
            String material_type = d0.c.getMaterial_type();
            if (TextUtils.isEmpty(material_type)) {
                return "unknown";
            }
            return material_type;
        }
        return (String) invokeV.objValue;
    }

    public String getBody() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            D0 d0 = this.b;
            if (d0 != null && d0.b()) {
                return d0.c.getDesc();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public String getCallToAction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            D0 d0 = this.b;
            if (d0 != null && d0.b()) {
                return d0.c.getBtndesc();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public String getHeadline() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            D0 d0 = this.b;
            if (d0 != null && d0.b()) {
                return d0.c.getTitle();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public String getIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            D0 d0 = this.b;
            if (d0 != null && d0.b()) {
                return d0.c.getIcon();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public int getMediaViewHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            D0 d0 = this.b;
            if (d0 != null && d0.b()) {
                return d0.c.getH();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int getMediaViewWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            D0 d0 = this.b;
            if (d0 != null && d0.b()) {
                return d0.c.getW();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean isD() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            D0 d0 = this.b;
            if (d0 == null) {
                return false;
            }
            Info info = d0.c;
            if (info != null && info.getOpent() == 1) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void load() {
        D0 d0;
        r1 r1Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (d0 = this.b) != null && (r1Var = d0.b) != null) {
            r1Var.b();
        }
    }

    public String getIM() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            D0 d0 = this.b;
            if (d0 == null) {
                return "";
            }
            if (!d0.b()) {
                str = "";
            } else {
                str = d0.c.getImage();
            }
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
            D0 d02 = this.b;
            if (!d02.b()) {
                return "";
            }
            return d02.c.getIcon();
        }
        return (String) invokeV.objValue;
    }
}
