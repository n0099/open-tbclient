package com.repackage;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.emotion.editortool.EmotionTabHost;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class m46 extends v15 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m46(Context context, int i, boolean z) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0525), 5, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = R.drawable.obfuscated_res_0x7f08097a;
        this.e = R.drawable.obfuscated_res_0x7f08097b;
        this.h = R.drawable.obfuscated_res_0x7f08097c;
        this.i = false;
        this.j = true;
        EmotionTabHost emotionTabHost = new EmotionTabHost(context);
        emotionTabHost.setShowBigEmotion(z);
        this.m = emotionTabHost;
        this.o = true;
        this.n = 6;
        this.p = new int[]{1, 34, 35};
    }

    @Override // com.repackage.v15
    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            ((EmotionTabHost) this.m).setShowUserCollect(z);
        }
    }

    @Override // com.repackage.v15
    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            ((EmotionTabHost) this.m).setShowDiyEmotion(z);
            super.f(z);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m46(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0525), 5, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = R.drawable.obfuscated_res_0x7f08097a;
        this.e = R.drawable.obfuscated_res_0x7f0807ef;
        this.h = R.drawable.obfuscated_res_0x7f08097c;
        this.i = false;
        this.j = true;
        this.m = new EmotionTabHost(context);
        this.o = true;
        this.n = 6;
        this.p = new int[]{1, 34, 35};
    }
}
