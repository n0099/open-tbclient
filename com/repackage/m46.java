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
/* loaded from: classes6.dex */
public class m46 extends no4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String d;
    public List<l46> e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755549214, "Lcom/repackage/m46;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755549214, "Lcom/repackage/m46;");
                return;
            }
        }
        BdUniqueId.gen();
    }

    public m46() {
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
        g(13);
        this.e = new ArrayList();
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.d : (String) invokeV.objValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.e.add(new l46(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0905), R.drawable.obfuscated_res_0x7f0807cf));
            this.e.add(new l46(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f08fb), R.drawable.obfuscated_res_0x7f0807cb));
            this.e.add(new l46(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0915), R.drawable.obfuscated_res_0x7f0807d7));
            this.e.add(new l46(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f08fd), R.drawable.obfuscated_res_0x7f0807cc));
            this.e.add(new l46(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f08ff), R.drawable.obfuscated_res_0x7f0807d8));
            this.e.add(new l46(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f090f), R.drawable.obfuscated_res_0x7f0807d2));
            this.e.add(new l46(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f08f9), R.drawable.obfuscated_res_0x7f0807cd));
            this.e.add(new l46(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f090d), R.drawable.obfuscated_res_0x7f0807ce));
            this.e.add(new l46(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f090b), R.drawable.obfuscated_res_0x7f0807d4));
            this.e.add(new l46(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0912), R.drawable.obfuscated_res_0x7f0807d3));
            this.e.add(new l46(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0906), R.drawable.obfuscated_res_0x7f0807d0));
            this.e.add(new l46(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0911), R.drawable.obfuscated_res_0x7f0807d1));
            this.e.add(new l46(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0907), R.drawable.obfuscated_res_0x7f0807d6));
            this.e.add(new l46(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0910), R.drawable.obfuscated_res_0x7f0807d5));
        }
    }

    public List<l46> k() {
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
