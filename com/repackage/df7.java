package com.repackage;

import android.content.Context;
import android.widget.LinearLayout;
import com.baidu.tbadk.editortools.RawLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.location.editortool.PbLocationInfoContainer;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class df7 extends u05 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public df7(Context context) {
        super(context, (String) null, 8);
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
                super((Context) objArr2[0], (String) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = false;
        this.l = 3;
        this.k = new PbLocationInfoContainer(context);
        this.n = new int[]{20, 19};
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public df7(Context context, boolean z) {
        super(context, (String) null, 8);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.m = false;
        this.l = 3;
        this.k = new PbLocationInfoContainer(context);
        RawLayout.LayoutParams layoutParams = new RawLayout.LayoutParams(-2, oi.f(getContext(), R.dimen.obfuscated_res_0x7f0702ce));
        ((LinearLayout.LayoutParams) layoutParams).leftMargin = oi.f(getContext(), R.dimen.obfuscated_res_0x7f070207);
        ((LinearLayout.LayoutParams) layoutParams).rightMargin = oi.f(getContext(), R.dimen.obfuscated_res_0x7f070207);
        ((LinearLayout.LayoutParams) layoutParams).bottomMargin = oi.f(getContext(), R.dimen.obfuscated_res_0x7f070276);
        ((LinearLayout.LayoutParams) layoutParams).topMargin = oi.f(getContext(), R.dimen.obfuscated_res_0x7f070276);
        ((PbLocationInfoContainer) this.k).setLayoutParams(layoutParams);
        this.n = new int[]{20, 19};
    }
}
