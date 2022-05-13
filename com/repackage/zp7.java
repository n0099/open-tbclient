package com.repackage;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class zp7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public List<op7> b;

    public zp7(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new ArrayList();
        this.a = context;
        a();
    }

    public static int b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) {
            switch (i) {
                case 1:
                    return R.drawable.obfuscated_res_0x7f0807db;
                case 2:
                    return R.drawable.obfuscated_res_0x7f0807de;
                case 3:
                    return R.drawable.obfuscated_res_0x7f0807d4;
                case 4:
                    return R.drawable.obfuscated_res_0x7f0807df;
                case 5:
                    return R.drawable.obfuscated_res_0x7f0807e4;
                case 6:
                    return R.drawable.obfuscated_res_0x7f0807dd;
                case 7:
                    return R.drawable.obfuscated_res_0x7f0807e6;
                case 8:
                    return R.drawable.obfuscated_res_0x7f0807e1;
                case 9:
                    return R.drawable.obfuscated_res_0x7f0807e5;
                case 10:
                case 15:
                case 17:
                case 18:
                case 21:
                default:
                    return -1;
                case 11:
                    return R.drawable.obfuscated_res_0x7f0807e2;
                case 12:
                    return R.drawable.obfuscated_res_0x7f0807d7;
                case 13:
                    return R.drawable.obfuscated_res_0x7f0807e8;
                case 14:
                    return R.drawable.obfuscated_res_0x7f0807d2;
                case 16:
                    return R.drawable.obfuscated_res_0x7f0807d9;
                case 19:
                    return R.drawable.obfuscated_res_0x7f0807da;
                case 20:
                    return R.drawable.obfuscated_res_0x7f0807d3;
                case 22:
                    return R.drawable.obfuscated_res_0x7f0807d6;
                case 23:
                    return R.drawable.obfuscated_res_0x7f0807d8;
                case 24:
                    return R.drawable.obfuscated_res_0x7f0807e3;
                case 25:
                    return R.drawable.obfuscated_res_0x7f0807d5;
                case 26:
                    return R.drawable.obfuscated_res_0x7f0807dc;
                case 27:
                    return R.drawable.obfuscated_res_0x7f0807e0;
                case 28:
                    return R.drawable.obfuscated_res_0x7f0807e7;
            }
        }
        return invokeI.intValue;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b.add(new op7(1, this.a.getString(R.string.obfuscated_res_0x7f0f0909), R.drawable.obfuscated_res_0x7f0807db, false));
            this.b.add(new op7(3, this.a.getString(R.string.obfuscated_res_0x7f0f08ff), R.drawable.obfuscated_res_0x7f0807d4, false));
            this.b.add(new op7(11, this.a.getString(R.string.obfuscated_res_0x7f0f0912), R.drawable.obfuscated_res_0x7f0807e2, false));
            this.b.add(new op7(4, this.a.getString(R.string.obfuscated_res_0x7f0f090e), R.drawable.obfuscated_res_0x7f0807df, false));
            this.b.add(new op7(22, this.a.getString(R.string.obfuscated_res_0x7f0f0901), R.drawable.obfuscated_res_0x7f0807d6, false));
            this.b.add(new op7(5, this.a.getString(R.string.obfuscated_res_0x7f0f0916), R.drawable.obfuscated_res_0x7f0807e4, false));
            this.b.add(new op7(19, this.a.getString(R.string.obfuscated_res_0x7f0f0908), R.drawable.obfuscated_res_0x7f0807da, false));
            this.b.add(new op7(8, this.a.getString(R.string.obfuscated_res_0x7f0f0911), R.drawable.obfuscated_res_0x7f0807e1, false));
            this.b.add(new op7(2, this.a.getString(R.string.obfuscated_res_0x7f0f090d), R.drawable.obfuscated_res_0x7f0807de, false));
            this.b.add(new op7(16, this.a.getString(R.string.obfuscated_res_0x7f0f0906), R.drawable.obfuscated_res_0x7f0807d9, false));
            this.b.add(new op7(13, this.a.getString(R.string.obfuscated_res_0x7f0f091c), R.drawable.obfuscated_res_0x7f0807e8, false));
            this.b.add(new op7(12, this.a.getString(R.string.obfuscated_res_0x7f0f0902), R.drawable.obfuscated_res_0x7f0807d7, false));
            this.b.add(new op7(23, this.a.getString(R.string.obfuscated_res_0x7f0f0904), R.drawable.obfuscated_res_0x7f0807d8, false));
            this.b.add(new op7(14, this.a.getString(R.string.obfuscated_res_0x7f0f08fc), R.drawable.obfuscated_res_0x7f0807d2, false));
            this.b.add(new op7(20, this.a.getString(R.string.obfuscated_res_0x7f0f08fe), R.drawable.obfuscated_res_0x7f0807d3, false));
            this.b.add(new op7(7, this.a.getString(R.string.obfuscated_res_0x7f0f091a), R.drawable.obfuscated_res_0x7f0807e6, false));
            this.b.add(new op7(9, this.a.getString(R.string.obfuscated_res_0x7f0f0919), R.drawable.obfuscated_res_0x7f0807e5, false));
            this.b.add(new op7(6, this.a.getString(R.string.obfuscated_res_0x7f0f090c), R.drawable.obfuscated_res_0x7f0807dd, false));
            this.b.add(new op7(24, this.a.getString(R.string.obfuscated_res_0x7f0f0914), R.drawable.obfuscated_res_0x7f0807e3, false));
            this.b.add(new op7(25, this.a.getString(R.string.obfuscated_res_0x7f0f0900), R.drawable.obfuscated_res_0x7f0807d5, false));
            this.b.add(new op7(26, this.a.getString(R.string.obfuscated_res_0x7f0f090a), R.drawable.obfuscated_res_0x7f0807dc, false));
            this.b.add(new op7(27, this.a.getString(R.string.obfuscated_res_0x7f0f0910), R.drawable.obfuscated_res_0x7f0807e0, false));
            this.b.add(new op7(28, this.a.getString(R.string.obfuscated_res_0x7f0f091b), R.drawable.obfuscated_res_0x7f0807e7, false));
        }
    }

    public List<op7> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.b : (List) invokeV.objValue;
    }
}
