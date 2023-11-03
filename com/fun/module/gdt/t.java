package com.fun.module.gdt;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public abstract class t extends NativeAdContainer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;
    public TextView b;
    public Button c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public t(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public t(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(Context context, @Nullable AttributeSet attributeSet, int i) {
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

    public List<View> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.c);
            arrayList.add(this.b);
            arrayList.add(this.a);
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public void a(NativeUnifiedADData nativeUnifiedADData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nativeUnifiedADData) == null) {
            this.b.setText(nativeUnifiedADData.getTitle());
            this.a.setText(nativeUnifiedADData.getDesc());
            nativeUnifiedADData.bindAdToView(getContext(), this, null, a());
            b(nativeUnifiedADData);
        }
    }

    public void b(NativeUnifiedADData nativeUnifiedADData) {
        Button button;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, nativeUnifiedADData) == null) {
            if (nativeUnifiedADData.isAppAd()) {
                int appStatus = nativeUnifiedADData.getAppStatus();
                if (appStatus == 0) {
                    button = this.c;
                    i = R.string.obfuscated_res_0x7f0f08b6;
                } else if (appStatus == 1) {
                    button = this.c;
                    i = R.string.obfuscated_res_0x7f0f08bd;
                } else if (appStatus == 2) {
                    button = this.c;
                    i = R.string.obfuscated_res_0x7f0f08c1;
                } else if (appStatus == 4) {
                    this.c.setText(String.format("%s/100", Integer.valueOf(nativeUnifiedADData.getProgress())));
                    return;
                } else if (appStatus == 8) {
                    button = this.c;
                    i = R.string.obfuscated_res_0x7f0f08b9;
                } else if (appStatus == 16) {
                    button = this.c;
                    i = R.string.obfuscated_res_0x7f0f08bb;
                }
                button.setText(i);
            }
            button = this.c;
            i = R.string.obfuscated_res_0x7f0f08c2;
            button.setText(i);
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onFinishInflate();
            this.a = (TextView) findViewById(R.id.obfuscated_res_0x7f0900c1);
            this.b = (TextView) findViewById(R.id.obfuscated_res_0x7f090127);
            this.c = (Button) findViewById(R.id.obfuscated_res_0x7f0900bd);
        }
    }
}
