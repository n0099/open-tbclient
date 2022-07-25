package com.facebook.drawee.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.net.Uri;
import android.util.AttributeSet;
import androidx.annotation.DrawableRes;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.util.UriUtil;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes4.dex */
public class SimpleDraweeView extends GenericDraweeView {
    public static /* synthetic */ Interceptable $ic;
    public static Supplier<? extends AbstractDraweeControllerBuilder> sDraweecontrollerbuildersupplier;
    public static Supplier<Supplier<? extends AbstractDraweeControllerBuilder>> sSupplierFactory;
    public transient /* synthetic */ FieldHolder $fh;
    public AbstractDraweeControllerBuilder mControllerBuilder;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleDraweeView(Context context, GenericDraweeHierarchy genericDraweeHierarchy) {
        super(context, genericDraweeHierarchy);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, genericDraweeHierarchy};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (GenericDraweeHierarchy) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        init(context, null);
    }

    private void init(Context context, @Nullable AttributeSet attributeSet) {
        int resourceId;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65541, this, context, attributeSet) == null) || isInEditMode()) {
            return;
        }
        if (sDraweecontrollerbuildersupplier == null) {
            sDraweecontrollerbuildersupplier = sSupplierFactory.get();
        }
        try {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("SimpleDraweeView#init");
            }
            if (isInEditMode()) {
                getTopLevelDrawable().setVisible(true, false);
                getTopLevelDrawable().invalidateSelf();
            } else {
                Preconditions.checkNotNull(sDraweecontrollerbuildersupplier, "SimpleDraweeView was not initialized!");
                this.mControllerBuilder = sDraweecontrollerbuildersupplier.get();
            }
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f040024, R.attr.obfuscated_res_0x7f040025, R.attr.obfuscated_res_0x7f040026, R.attr.obfuscated_res_0x7f04005c, R.attr.obfuscated_res_0x7f04015b, R.attr.obfuscated_res_0x7f04015f, R.attr.obfuscated_res_0x7f040160, R.attr.obfuscated_res_0x7f0402a8, R.attr.obfuscated_res_0x7f0402c6, R.attr.obfuscated_res_0x7f0402c7, R.attr.obfuscated_res_0x7f0402cf, R.attr.obfuscated_res_0x7f0402d1, R.attr.obfuscated_res_0x7f0402d2, R.attr.obfuscated_res_0x7f0402d3, R.attr.obfuscated_res_0x7f040332, R.attr.obfuscated_res_0x7f040333, R.attr.obfuscated_res_0x7f04034b, R.attr.obfuscated_res_0x7f04034c, R.attr.obfuscated_res_0x7f04034d, R.attr.obfuscated_res_0x7f04034e, R.attr.obfuscated_res_0x7f04034f, R.attr.obfuscated_res_0x7f040357, R.attr.obfuscated_res_0x7f040358, R.attr.obfuscated_res_0x7f040359, R.attr.obfuscated_res_0x7f04035a, R.attr.obfuscated_res_0x7f04035c, R.attr.obfuscated_res_0x7f04035e, R.attr.obfuscated_res_0x7f04035f, R.attr.obfuscated_res_0x7f040360, R.attr.obfuscated_res_0x7f040361, R.attr.obfuscated_res_0x7f040489, R.attr.obfuscated_res_0x7f0405e7});
                if (obtainStyledAttributes.hasValue(2)) {
                    setImageURI(Uri.parse(obtainStyledAttributes.getString(2)), (Object) null);
                } else if (obtainStyledAttributes.hasValue(0)) {
                    int resourceId2 = obtainStyledAttributes.getResourceId(0, -1);
                    if (resourceId2 != -1) {
                        if (isInEditMode()) {
                            setImageResource(resourceId2);
                        } else {
                            setActualImageResource(resourceId2);
                        }
                    }
                } else if (obtainStyledAttributes.hasValue(31) && (resourceId = obtainStyledAttributes.getResourceId(31, -1)) != -1) {
                    setImageURI(UriUtil.getUriForResourceId(resourceId), (Object) null);
                }
                obtainStyledAttributes.recycle();
            }
        } finally {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
    }

    public static void initialize(Supplier<Supplier<? extends AbstractDraweeControllerBuilder>> supplier) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, supplier) == null) {
            sSupplierFactory = supplier;
        }
    }

    public static void shutDown() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            sSupplierFactory = null;
            sDraweecontrollerbuildersupplier = null;
        }
    }

    public AbstractDraweeControllerBuilder getControllerBuilder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mControllerBuilder : (AbstractDraweeControllerBuilder) invokeV.objValue;
    }

    public void setActualImageResource(@DrawableRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            setActualImageResource(i, null);
        }
    }

    public void setImageRequest(ImageRequest imageRequest) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, imageRequest) == null) {
            setController(this.mControllerBuilder.setImageRequest(imageRequest).setOldController(getController()).build());
        }
    }

    @Override // com.facebook.drawee.view.DraweeView, android.widget.ImageView
    public void setImageResource(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            super.setImageResource(i);
        }
    }

    @Override // com.facebook.drawee.view.DraweeView, android.widget.ImageView
    public void setImageURI(Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, uri) == null) {
            setImageURI(uri, (Object) null);
        }
    }

    public void setImageURIWithHeader(Uri uri, Map<String, String> map, @Nullable Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, uri, map, obj) == null) {
            setController(getControllerBuilder().setUri(uri, map).setCallerContext(obj).setOldController(getController()).build());
        }
    }

    public void setActualImageResource(@DrawableRes int i, @Nullable Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, obj) == null) {
            setImageURI(UriUtil.getUriForResourceId(i), obj);
        }
    }

    public void setImageURI(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            setImageURI(str, (Object) null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleDraweeView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        init(context, null);
    }

    public void setImageURI(Uri uri, @Nullable Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, uri, obj) == null) {
            setController(this.mControllerBuilder.setCallerContext(obj).setUri(uri).setOldController(getController()).build());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleDraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        init(context, attributeSet);
    }

    public void setImageURIWithHeader(Uri uri, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, uri, map) == null) {
            setImageURIWithHeader(uri, map, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleDraweeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        init(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @TargetApi(21)
    public SimpleDraweeView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        init(context, attributeSet);
    }

    public void setImageURI(@Nullable String str, @Nullable Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, obj) == null) {
            setImageURI(str != null ? Uri.parse(str) : null, obj);
        }
    }
}
