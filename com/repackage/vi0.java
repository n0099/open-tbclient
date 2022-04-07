package com.repackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.nadcore.widget.IAdImageView;
import com.baidu.searchbox.crius.CriusRuntime;
import com.baidu.searchbox.crius.data.RenderData;
import com.baidu.searchbox.crius.factory.INativeRenderFactory;
import com.baidu.searchbox.crius.util.CriusUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sina.weibo.sdk.utils.ResourceManager;
/* loaded from: classes7.dex */
public class vi0 implements INativeRenderFactory {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "vi0";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755230348, "Lcom/repackage/vi0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755230348, "Lcom/repackage/vi0;");
        }
    }

    public vi0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final Drawable a(String str, @NonNull Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, context)) == null) {
            if (!TextUtils.isEmpty(str) && str.startsWith("file://") && str.length() > 7) {
                try {
                    return context.getResources().getDrawable(context.getResources().getIdentifier(str.substring(7), ResourceManager.DRAWABLE, context.getPackageName()));
                } catch (Exception unused) {
                    if (CriusRuntime.DEBUG) {
                        String str2 = a;
                        Log.e(str2, "crius find placeholder image failed，placeHolder=" + str);
                    }
                }
            }
            return null;
        }
        return (Drawable) invokeLL.objValue;
    }

    public final void b(AdImageView adImageView, RenderData renderData, boolean z) {
        Drawable a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adImageView, renderData, z) == null) || adImageView == null) {
            return;
        }
        String str = renderData.placeHolderImage;
        String str2 = renderData.placeHolderImageNight;
        if (TextUtils.isEmpty(str)) {
            str = renderData.backgroundImage;
            str2 = renderData.backgroundImageNight;
            if (TextUtils.isEmpty(str)) {
                adImageView.setBackground(null);
            }
        }
        if (z && !TextUtils.isEmpty(str2)) {
            str = str2;
        }
        if (TextUtils.isEmpty(str) || (a2 = a(str, hi0.b())) == null) {
            return;
        }
        adImageView.setPlaceHolderDrawable(a2);
    }

    @Override // com.baidu.searchbox.crius.factory.INativeRenderFactory
    public View createView(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, str)) == null) {
            if ("image".equalsIgnoreCase(str)) {
                AdImageView adImageView = new AdImageView(context);
                adImageView.setImageScaleType(IAdImageView.ImageScaleType.CENTER_CROP);
                return adImageView;
            }
            return null;
        }
        return (View) invokeLL.objValue;
    }

    @Override // com.baidu.searchbox.crius.factory.INativeRenderFactory
    public boolean renderBackground(String str, View view2, String str2, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, str, view2, str2, str3)) == null) {
            if (view2 == null || TextUtils.isEmpty(str2)) {
                return false;
            }
            if (str2.startsWith("file://") && str2.length() > 7) {
                Drawable a2 = a(str2, hi0.b());
                Drawable a3 = a(str3, hi0.b());
                if (a2 == null) {
                    view2.setBackground(null);
                } else if (a3 != null) {
                    StateListDrawable stateListDrawable = new StateListDrawable();
                    stateListDrawable.addState(new int[]{16842919}, a3);
                    stateListDrawable.addState(new int[]{-16842919}, a2);
                    view2.setBackground(stateListDrawable);
                } else {
                    view2.setBackground(a2);
                }
            }
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.searchbox.crius.factory.INativeRenderFactory
    public boolean renderView(String str, View view2, RenderData renderData, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        int positive;
        int positive2;
        int positive3;
        int positive4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{str, view2, renderData, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            boolean z3 = false;
            if (renderData == null || view2 == null || !(view2 instanceof AdImageView)) {
                return false;
            }
            AdImageView adImageView = (AdImageView) view2;
            float f = renderData.borderRadius;
            if (f > 0.0f) {
                positive = (int) CriusUtil.positive(f);
                positive2 = positive;
                positive3 = positive2;
                positive4 = positive3;
            } else {
                positive = (int) CriusUtil.positive(renderData.borderRadiusLeftTop);
                positive2 = (int) CriusUtil.positive(renderData.borderRadiusRightTop);
                positive3 = (int) CriusUtil.positive(renderData.borderRadiusLeftBottom);
                positive4 = (int) CriusUtil.positive(renderData.borderRadiusRightBottom);
            }
            if (positive > 0 || positive2 > 0 || positive3 > 0 || positive4 > 0) {
                adImageView.setRadius(positive, positive2, positive3, positive4);
            }
            int i = renderData.width;
            if (i == renderData.height && positive == positive2 && positive2 == positive3 && positive3 == positive4 && positive3 * 2 == i) {
                z3 = true;
            }
            if (z3) {
                adImageView.setCircle();
            }
            adImageView.setBorder(renderData.borderRadiusWidth, renderData.borderRadiusColor);
            b(adImageView, renderData, z);
            adImageView.g(renderData.src);
            return true;
        }
        return invokeCommon.booleanValue;
    }
}
