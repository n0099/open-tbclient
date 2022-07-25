package com.kwad.components.ad.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class AppScoreView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView Cj;
    public ImageView Ck;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AppScoreView(Context context) {
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
    public AppScoreView(Context context, @Nullable AttributeSet attributeSet) {
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
    public AppScoreView(Context context, @Nullable AttributeSet attributeSet, int i) {
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
        initView();
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            LinearLayout.inflate(getContext(), R.layout.obfuscated_res_0x7f0d0406, this);
            this.Cj = (ImageView) findViewById(R.id.obfuscated_res_0x7f091166);
            this.Ck = (ImageView) findViewById(R.id.obfuscated_res_0x7f091165);
        }
    }

    public void setScore(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048576, this, f) == null) {
            double d = f;
            if (d > 4.5d) {
                this.Cj.setImageResource(R.drawable.obfuscated_res_0x7f080c46);
                this.Ck.setImageResource(R.drawable.obfuscated_res_0x7f080c46);
            } else if (d > 4.0d) {
                this.Cj.setImageResource(R.drawable.obfuscated_res_0x7f080c46);
                this.Ck.setImageResource(R.drawable.obfuscated_res_0x7f080c47);
            } else if (d > 3.5d) {
                this.Cj.setImageResource(R.drawable.obfuscated_res_0x7f080c46);
                this.Ck.setImageResource(R.drawable.obfuscated_res_0x7f080c48);
            } else {
                int i = (d > 3.0d ? 1 : (d == 3.0d ? 0 : -1));
                if (i > 0) {
                    this.Cj.setImageResource(R.drawable.obfuscated_res_0x7f080c47);
                    this.Ck.setImageResource(R.drawable.obfuscated_res_0x7f080c48);
                } else if (i == 0) {
                    this.Cj.setImageResource(R.drawable.obfuscated_res_0x7f080c48);
                    this.Ck.setImageResource(R.drawable.obfuscated_res_0x7f080c48);
                }
            }
        }
    }
}
