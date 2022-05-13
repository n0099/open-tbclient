package com.tachikoma.core.component.progressbar;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.annotation.TK_EXPORT_CLASS;
import com.tachikoma.core.Tachikoma;
import com.tachikoma.core.component.TKBase;
import com.tachikoma.core.utility.TKColorUtil;
import com.tachikoma.core.utility.TKConverter;
import java.util.List;
@TK_EXPORT_CLASS
/* loaded from: classes7.dex */
public class KTProgressBarView extends TKBase<ProgressBar> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MAX_PROGRESS = 1000;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean animating;
    public String backgroundColor;
    public String color;
    public float cornerRadius;
    public String mColor;
    public double progress;
    public int style;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KTProgressBarView(@NonNull Context context, @Nullable List<Object> list) {
        super(context, list);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (List) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.style = 16842871;
        this.cornerRadius = 0.0f;
        if (list != null) {
            try {
                if (list.size() > 0 && (list.get(0) instanceof String)) {
                    this.style = getStyleFromString((String) list.get(0));
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        getView().setMax(1000);
    }

    private Drawable generateBackDrawable(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, str)) == null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(this.cornerRadius);
            ClipDrawable clipDrawable = new ClipDrawable(gradientDrawable, 3, 1);
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setCornerRadius(this.cornerRadius);
            if (!TextUtils.isEmpty(str)) {
                gradientDrawable2.setColor(Color.parseColor(str));
            }
            return new LayerDrawable(new Drawable[]{gradientDrawable2, clipDrawable});
        }
        return (Drawable) invokeL.objValue;
    }

    public static int getStyleFromString(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (str != null) {
                if (str.equals("Horizontal")) {
                    return 16842872;
                }
                if (str.equals("Small")) {
                    return 16842873;
                }
                if (str.equals("Large")) {
                    return 16842874;
                }
                if (str.equals("Inverse")) {
                    return 16843399;
                }
                if (str.equals("SmallInverse")) {
                    return 16843400;
                }
                if (str.equals("LargeInverse")) {
                    return 16843401;
                }
                if (str.equals("Normal")) {
                    return 16842871;
                }
                throw new Exception("Unknown ProgressBar style: " + str);
            }
            throw new Exception("ProgressBar needs to have a style, null received");
        }
        return invokeL.intValue;
    }

    private void setProgressColor(ProgressBar progressBar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, this, progressBar, str) == null) {
            Drawable indeterminateDrawable = progressBar.isIndeterminate() ? progressBar.getIndeterminateDrawable() : progressBar.getProgressDrawable();
            if (indeterminateDrawable == null) {
                indeterminateDrawable = generateBackDrawable(this.backgroundColor);
                setProgressDrawable(getView().isIndeterminate(), indeterminateDrawable);
            }
            if (indeterminateDrawable instanceof LayerDrawable) {
                LayerDrawable layerDrawable = (LayerDrawable) indeterminateDrawable;
                Drawable drawable = layerDrawable.getDrawable(layerDrawable.getNumberOfLayers() - 1);
                if (str == null || !str.startsWith("#")) {
                    drawable.clearColorFilter();
                } else {
                    drawable.setColorFilter(Color.parseColor(str), PorterDuff.Mode.SRC_IN);
                }
            }
        }
    }

    private void setProgressDrawable(boolean z, Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(InputDeviceCompat.SOURCE_TRACKBALL, this, z, drawable) == null) {
            if (z) {
                getView().setIndeterminateDrawable(drawable);
            } else {
                getView().setProgressDrawable(drawable);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.tachikoma.core.component.TKBase
    public ProgressBar createViewInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) ? new ProgressBar(context, null, this.style) : (ProgressBar) invokeL.objValue;
    }

    public void setAnimating(boolean z) {
        ProgressBar view2;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (z) {
                view2 = getView();
                i = 0;
            } else {
                view2 = getView();
                i = 8;
            }
            view2.setVisibility(i);
        }
    }

    @Override // com.tachikoma.core.component.TKBase
    public void setBackgroundColor(Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, obj) == null) && (obj instanceof String)) {
            this.backgroundColor = (String) obj;
            setProgressDrawable(getView().isIndeterminate(), generateBackDrawable(TKColorUtil.rgba2argb(this.backgroundColor)));
        }
    }

    public void setColor(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            setProgressColor(getView(), TKColorUtil.rgba2argb(str));
        }
    }

    public void setCornerRadius(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048581, this, f) == null) {
            this.cornerRadius = TKConverter.dp2px(Tachikoma.sApplication, f);
            setProgressDrawable(getView().isIndeterminate(), generateBackDrawable(this.backgroundColor));
        }
    }

    public void setIndeterminate(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            getView().setIndeterminate(z);
            setProgressDrawable(z, generateBackDrawable(TKColorUtil.rgba2argb(this.backgroundColor)));
        }
    }

    public void setProgress(double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Double.valueOf(d)}) == null) {
            getView().getMax();
            getView().setProgress((int) (d * 1000.0d));
        }
    }
}
