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
import b.g.a0.a.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.fun.ad.sdk.channel.csj.R;
import com.fun.ad.sdk.internal.api.utils.GlideHelper;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class e0 extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TextView f62867a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f62868b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f62869c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f62870d;

    /* renamed from: e  reason: collision with root package name */
    public Button f62871e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e0(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e0(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e0(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
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
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, tTNativeAd) == null) {
            this.f62867a.setText(tTNativeAd.getDescription());
            TTImage icon = tTNativeAd.getIcon();
            if (icon != null && icon.isValid()) {
                GlideHelper.get().load(getContext(), icon.getImageUrl(), this.f62868b);
            }
            this.f62869c.setText(TextUtils.isEmpty(tTNativeAd.getSource()) ? tTNativeAd.getTitle() : tTNativeAd.getSource());
            this.f62870d.setImageBitmap(tTNativeAd.getAdLogo());
            int interactionType = tTNativeAd.getInteractionType();
            if (interactionType == 2 || interactionType == 3) {
                this.f62871e.setVisibility(0);
                button = this.f62871e;
                i2 = R.string.fun_ad_interaction_type_browser;
            } else if (interactionType == 4) {
                this.f62871e.setVisibility(0);
                button = this.f62871e;
                i2 = R.string.fun_ad_interaction_type_download;
            } else if (interactionType != 5) {
                this.f62871e.setVisibility(8);
                return;
            } else {
                this.f62871e.setVisibility(0);
                button = this.f62871e;
                i2 = R.string.fun_ad_interaction_type_dial;
            }
            button.setText(i2);
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
            arrayList.add(this.f62871e);
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public h getDownloadListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new h(this.f62871e) : (h) invokeV.objValue;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onFinishInflate();
            this.f62867a = (TextView) findViewById(R.id.ad_description);
            this.f62870d = (ImageView) findViewById(R.id.ad_logo);
            this.f62868b = (ImageView) findViewById(R.id.ad_icon);
            this.f62869c = (TextView) findViewById(R.id.ad_source);
            this.f62871e = (Button) findViewById(R.id.ad_creative);
        }
    }
}
