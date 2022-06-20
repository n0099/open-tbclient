package com.repackage;

import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class z36 extends wn4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String d;
    public List<y36> e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755162892, "Lcom/repackage/z36;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755162892, "Lcom/repackage/z36;");
                return;
            }
        }
        BdUniqueId.gen();
    }

    public z36() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        f(13);
        this.e = new ArrayList();
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.d : (String) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.e.add(new y36(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0914), R.drawable.obfuscated_res_0x7f0807b5));
            this.e.add(new y36(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f090a), R.drawable.obfuscated_res_0x7f0807b1));
            this.e.add(new y36(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0924), R.drawable.obfuscated_res_0x7f0807bd));
            this.e.add(new y36(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f090c), R.drawable.obfuscated_res_0x7f0807b2));
            this.e.add(new y36(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f090e), R.drawable.obfuscated_res_0x7f0807be));
            this.e.add(new y36(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f091e), R.drawable.obfuscated_res_0x7f0807b8));
            this.e.add(new y36(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0908), R.drawable.obfuscated_res_0x7f0807b3));
            this.e.add(new y36(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f091c), R.drawable.obfuscated_res_0x7f0807b4));
            this.e.add(new y36(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f091a), R.drawable.obfuscated_res_0x7f0807ba));
            this.e.add(new y36(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0921), R.drawable.obfuscated_res_0x7f0807b9));
            this.e.add(new y36(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0915), R.drawable.obfuscated_res_0x7f0807b6));
            this.e.add(new y36(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0920), R.drawable.obfuscated_res_0x7f0807b7));
            this.e.add(new y36(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0916), R.drawable.obfuscated_res_0x7f0807bc));
            this.e.add(new y36(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f091f), R.drawable.obfuscated_res_0x7f0807bb));
        }
    }

    public List<y36> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.e : (List) invokeV.objValue;
    }

    public void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.d = str;
        }
    }
}
