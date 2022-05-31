package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes7.dex */
public class ws6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public String b;
    public final List<iw4> c;
    public boolean d;

    public ws6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 1;
        this.b = "https://boxnovel.baidu.com/boxnovel/haokan";
        this.c = new ArrayList();
        i();
    }

    public iw4 a(int i, String str, String str2, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, str2, str3})) == null) {
            iw4 iw4Var = new iw4();
            iw4Var.a = i;
            iw4Var.b = str;
            iw4Var.c = str2;
            iw4Var.d = str3;
            return iw4Var;
        }
        return (iw4) invokeCommon.objValue;
    }

    public iw4 b(int i, String str, String str2) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str, str2)) == null) {
            iw4 iw4Var = new iw4();
            iw4Var.a = i;
            iw4Var.b = str;
            iw4Var.c = str2;
            return iw4Var;
        }
        return (iw4) invokeILL.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.d) {
                return false;
            }
            List<iw4> h = h();
            int size = h.size();
            if (size != this.c.size()) {
                return true;
            }
            for (int i = 0; i < size; i++) {
                if (h.get(i) != null && !h.get(i).equals(this.c.get(i))) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final List<iw4> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(b(5, f(R.string.obfuscated_res_0x7f0f1360), ""));
            arrayList.add(b(6, f(R.string.obfuscated_res_0x7f0f135c), ""));
            arrayList.add(b(201, f(R.string.obfuscated_res_0x7f0f135b), "game"));
            arrayList.add(b(201, f(R.string.obfuscated_res_0x7f0f1358), "digital"));
            arrayList.add(b(201, f(R.string.obfuscated_res_0x7f0f1359), "entertainment"));
            arrayList.add(b(201, f(R.string.obfuscated_res_0x7f0f135a), "films"));
            arrayList.add(b(201, f(R.string.obfuscated_res_0x7f0f1356), "campus"));
            arrayList.add(b(201, f(R.string.obfuscated_res_0x7f0f1355), "animes"));
            arrayList.add(b(201, f(R.string.obfuscated_res_0x7f0f135f), "sports"));
            arrayList.add(a(202, f(R.string.obfuscated_res_0x7f0f135d), AccountConstants.LOGIN_TYPE_NATIVE_SRC_NOVEL, this.b));
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a : invokeV.intValue;
    }

    public final String f(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) ? TbadkCoreApplication.getInst().getString(i) : (String) invokeI.objValue;
    }

    public List<iw4> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.c : (List) invokeV.objValue;
    }

    public final List<iw4> h() {
        InterceptResult invokeV;
        JSONArray jSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ArrayList arrayList = new ArrayList();
            try {
                jSONArray = new JSONArray(ys4.k().q("key_index_tab_info_list", "[]"));
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (jSONArray.length() == 0) {
                this.d = true;
                return d();
            }
            this.d = false;
            for (int i = 0; i < jSONArray.length(); i++) {
                iw4 iw4Var = new iw4();
                iw4Var.f(jSONArray.getJSONObject(i));
                if (!iw4Var.d()) {
                    arrayList.add(iw4Var);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            List<iw4> h = h();
            if (ListUtils.isEmpty(h)) {
                return;
            }
            this.c.addAll(h);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            List<iw4> list = this.c;
            if (list != null) {
                list.clear();
            }
            i();
        }
    }
}
