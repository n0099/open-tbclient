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
public class wp7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public List<lp7> b;

    public wp7(Context context) {
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
                    return R.drawable.obfuscated_res_0x7f0807f1;
                case 2:
                    return R.drawable.obfuscated_res_0x7f0807f4;
                case 3:
                    return R.drawable.obfuscated_res_0x7f0807ea;
                case 4:
                    return R.drawable.obfuscated_res_0x7f0807f5;
                case 5:
                    return R.drawable.obfuscated_res_0x7f0807fa;
                case 6:
                    return R.drawable.obfuscated_res_0x7f0807f3;
                case 7:
                    return R.drawable.obfuscated_res_0x7f0807fc;
                case 8:
                    return R.drawable.obfuscated_res_0x7f0807f7;
                case 9:
                    return R.drawable.obfuscated_res_0x7f0807fb;
                case 10:
                case 15:
                case 17:
                case 18:
                case 21:
                default:
                    return -1;
                case 11:
                    return R.drawable.obfuscated_res_0x7f0807f8;
                case 12:
                    return R.drawable.obfuscated_res_0x7f0807ed;
                case 13:
                    return R.drawable.obfuscated_res_0x7f0807fe;
                case 14:
                    return R.drawable.obfuscated_res_0x7f0807e8;
                case 16:
                    return R.drawable.obfuscated_res_0x7f0807ef;
                case 19:
                    return R.drawable.obfuscated_res_0x7f0807f0;
                case 20:
                    return R.drawable.obfuscated_res_0x7f0807e9;
                case 22:
                    return R.drawable.obfuscated_res_0x7f0807ec;
                case 23:
                    return R.drawable.obfuscated_res_0x7f0807ee;
                case 24:
                    return R.drawable.obfuscated_res_0x7f0807f9;
                case 25:
                    return R.drawable.obfuscated_res_0x7f0807eb;
                case 26:
                    return R.drawable.obfuscated_res_0x7f0807f2;
                case 27:
                    return R.drawable.obfuscated_res_0x7f0807f6;
                case 28:
                    return R.drawable.obfuscated_res_0x7f0807fd;
            }
        }
        return invokeI.intValue;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b.add(new lp7(1, this.a.getString(R.string.obfuscated_res_0x7f0f0905), R.drawable.obfuscated_res_0x7f0807f1, false));
            this.b.add(new lp7(3, this.a.getString(R.string.obfuscated_res_0x7f0f08fb), R.drawable.obfuscated_res_0x7f0807ea, false));
            this.b.add(new lp7(11, this.a.getString(R.string.obfuscated_res_0x7f0f090e), R.drawable.obfuscated_res_0x7f0807f8, false));
            this.b.add(new lp7(4, this.a.getString(R.string.obfuscated_res_0x7f0f090a), R.drawable.obfuscated_res_0x7f0807f5, false));
            this.b.add(new lp7(22, this.a.getString(R.string.obfuscated_res_0x7f0f08fd), R.drawable.obfuscated_res_0x7f0807ec, false));
            this.b.add(new lp7(5, this.a.getString(R.string.obfuscated_res_0x7f0f0912), R.drawable.obfuscated_res_0x7f0807fa, false));
            this.b.add(new lp7(19, this.a.getString(R.string.obfuscated_res_0x7f0f0904), R.drawable.obfuscated_res_0x7f0807f0, false));
            this.b.add(new lp7(8, this.a.getString(R.string.obfuscated_res_0x7f0f090d), R.drawable.obfuscated_res_0x7f0807f7, false));
            this.b.add(new lp7(2, this.a.getString(R.string.obfuscated_res_0x7f0f0909), R.drawable.obfuscated_res_0x7f0807f4, false));
            this.b.add(new lp7(16, this.a.getString(R.string.obfuscated_res_0x7f0f0902), R.drawable.obfuscated_res_0x7f0807ef, false));
            this.b.add(new lp7(13, this.a.getString(R.string.obfuscated_res_0x7f0f0918), R.drawable.obfuscated_res_0x7f0807fe, false));
            this.b.add(new lp7(12, this.a.getString(R.string.obfuscated_res_0x7f0f08fe), R.drawable.obfuscated_res_0x7f0807ed, false));
            this.b.add(new lp7(23, this.a.getString(R.string.obfuscated_res_0x7f0f0900), R.drawable.obfuscated_res_0x7f0807ee, false));
            this.b.add(new lp7(14, this.a.getString(R.string.obfuscated_res_0x7f0f08f8), R.drawable.obfuscated_res_0x7f0807e8, false));
            this.b.add(new lp7(20, this.a.getString(R.string.obfuscated_res_0x7f0f08fa), R.drawable.obfuscated_res_0x7f0807e9, false));
            this.b.add(new lp7(7, this.a.getString(R.string.obfuscated_res_0x7f0f0916), R.drawable.obfuscated_res_0x7f0807fc, false));
            this.b.add(new lp7(9, this.a.getString(R.string.obfuscated_res_0x7f0f0915), R.drawable.obfuscated_res_0x7f0807fb, false));
            this.b.add(new lp7(6, this.a.getString(R.string.obfuscated_res_0x7f0f0908), R.drawable.obfuscated_res_0x7f0807f3, false));
            this.b.add(new lp7(24, this.a.getString(R.string.obfuscated_res_0x7f0f0910), R.drawable.obfuscated_res_0x7f0807f9, false));
            this.b.add(new lp7(25, this.a.getString(R.string.obfuscated_res_0x7f0f08fc), R.drawable.obfuscated_res_0x7f0807eb, false));
            this.b.add(new lp7(26, this.a.getString(R.string.obfuscated_res_0x7f0f0906), R.drawable.obfuscated_res_0x7f0807f2, false));
            this.b.add(new lp7(27, this.a.getString(R.string.obfuscated_res_0x7f0f090c), R.drawable.obfuscated_res_0x7f0807f6, false));
            this.b.add(new lp7(28, this.a.getString(R.string.obfuscated_res_0x7f0f0917), R.drawable.obfuscated_res_0x7f0807fd, false));
        }
    }

    public List<lp7> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.b : (List) invokeV.objValue;
    }
}
