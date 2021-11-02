package com.fun.module.gdt;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.channel.gdt.R;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public abstract class x extends NativeAdContainer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TextView f62881a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f62882b;

    /* renamed from: c  reason: collision with root package name */
    public Button f62883c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public x(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public x(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(Context context, @Nullable AttributeSet attributeSet, int i2) {
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

    public List<View> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f62883c);
            arrayList.add(this.f62882b);
            arrayList.add(this.f62881a);
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public void a(NativeUnifiedADData nativeUnifiedADData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nativeUnifiedADData) == null) {
            this.f62882b.setText(nativeUnifiedADData.getTitle());
            this.f62881a.setText(nativeUnifiedADData.getDesc());
            nativeUnifiedADData.bindAdToView(getContext(), this, null, a());
            b(nativeUnifiedADData);
        }
    }

    public void b(NativeUnifiedADData nativeUnifiedADData) {
        Button button;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, nativeUnifiedADData) == null) {
            if (nativeUnifiedADData.isAppAd()) {
                int appStatus = nativeUnifiedADData.getAppStatus();
                if (appStatus == 0) {
                    button = this.f62883c;
                    i2 = R.string.fun_ad_interaction_type_download;
                } else if (appStatus == 1) {
                    button = this.f62883c;
                    i2 = R.string.fun_ad_interaction_type_start;
                } else if (appStatus == 2) {
                    button = this.f62883c;
                    i2 = R.string.fun_ad_interaction_type_update;
                } else if (appStatus == 4) {
                    this.f62883c.setText(String.format("%s/100", Integer.valueOf(nativeUnifiedADData.getProgress())));
                    return;
                } else if (appStatus == 8) {
                    button = this.f62883c;
                    i2 = R.string.fun_ad_interaction_type_install;
                } else if (appStatus == 16) {
                    button = this.f62883c;
                    i2 = R.string.fun_ad_interaction_type_redownload;
                }
                button.setText(i2);
            }
            button = this.f62883c;
            i2 = R.string.fun_ad_interaction_type_view;
            button.setText(i2);
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onFinishInflate();
            this.f62881a = (TextView) findViewById(R.id.ad_description);
            this.f62882b = (TextView) findViewById(R.id.ad_title);
            this.f62883c = (Button) findViewById(R.id.ad_creative);
        }
    }
}
