package com.fun.module.csj;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.tieba.mo9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.fun.ad.sdk.internal.api.utils.GlideHelper;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class g0 extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;
    public ImageView b;
    public TextView c;
    public ImageView d;
    public Button e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g0(Context context) {
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
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g0(Context context, @Nullable AttributeSet attributeSet) {
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
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g0(Context context, @Nullable AttributeSet attributeSet, int i) {
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
    }

    public void a(TTNativeAd tTNativeAd) {
        Button button;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, tTNativeAd) == null) {
            this.a.setText(tTNativeAd.getDescription());
            TTImage icon = tTNativeAd.getIcon();
            if (icon != null && icon.isValid()) {
                GlideHelper.get().load(getContext(), icon.getImageUrl(), this.b);
            }
            this.c.setText(TextUtils.isEmpty(tTNativeAd.getSource()) ? tTNativeAd.getTitle() : tTNativeAd.getSource());
            this.d.setImageBitmap(tTNativeAd.getAdLogo());
            int interactionType = tTNativeAd.getInteractionType();
            if (interactionType == 2 || interactionType == 3) {
                this.e.setVisibility(0);
                button = this.e;
                i = R.string.obfuscated_res_0x7f0f079a;
            } else if (interactionType == 4) {
                this.e.setVisibility(0);
                button = this.e;
                i = R.string.obfuscated_res_0x7f0f079c;
            } else if (interactionType != 5) {
                this.e.setVisibility(8);
                return;
            } else {
                this.e.setVisibility(0);
                button = this.e;
                i = R.string.obfuscated_res_0x7f0f079b;
            }
            button.setText(i);
        }
    }

    public List<View> getClickViews() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this);
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public List<View> getCreativeViews() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.e);
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public mo9 getDownloadListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new mo9(this.e) : (mo9) invokeV.objValue;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onFinishInflate();
            this.a = (TextView) findViewById(R.id.obfuscated_res_0x7f0900a1);
            this.d = (ImageView) findViewById(R.id.obfuscated_res_0x7f0900dd);
            this.b = (ImageView) findViewById(R.id.obfuscated_res_0x7f0900a9);
            this.c = (TextView) findViewById(R.id.ad_source);
            this.e = (Button) findViewById(R.id.obfuscated_res_0x7f09009d);
        }
    }
}
