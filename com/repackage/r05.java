package com.repackage;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.MoreDeskView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class r05 extends u05 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r05(Context context) {
        super(context, null, 2, 0);
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
                super((Context) objArr2[0], (String) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0ad0);
        this.d = R.drawable.obfuscated_res_0x7f08096b;
        this.e = R.drawable.obfuscated_res_0x7f080814;
        this.g = false;
        this.h = true;
        this.k = new MoreDeskView(context);
        this.m = true;
        this.l = 6;
        this.n = new int[]{1};
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r05(Context context, boolean z) {
        super(context, null, 2, 0);
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
                super((Context) objArr2[0], (String) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0ad0);
        this.d = R.drawable.obfuscated_res_0x7f08096b;
        this.e = R.drawable.obfuscated_res_0x7f080814;
        this.g = false;
        this.h = true;
        this.k = new MoreDeskView(context, !z);
        this.m = true;
        this.l = 6;
        this.n = new int[]{1};
    }
}
