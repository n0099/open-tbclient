package com.repackage;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class za8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext<?> a;
    public final DragImageView.h b;
    public final boolean c;
    public Map<AdvertAppInfo, ya8> d;
    public ya8 e;

    /* loaded from: classes7.dex */
    public class a implements tc7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ya8 a;

        public a(za8 za8Var, ya8 ya8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {za8Var, ya8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ya8Var;
        }

        @Override // com.repackage.tc7
        public void a(int i, HashMap<String, Object> hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, hashMap) == null) {
                AdvertAppInfo a = this.a.a();
                if (i == 0 || a == null) {
                    return;
                }
                String str = "image";
                if (hashMap != null) {
                    String str2 = (String) hashMap.get("da_area");
                    if (!TextUtils.isEmpty(str2)) {
                        str = str2;
                    }
                }
                if (t98.h(i)) {
                    eb8.f(a, 0, str, i);
                } else {
                    eb8.m(a, 0, str);
                }
                bd7.c(a);
            }
        }
    }

    public za8(@NonNull TbPageContext<?> tbPageContext, boolean z, DragImageView.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Boolean.valueOf(z), hVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        this.c = z;
        this.b = hVar;
        this.d = new HashMap();
    }

    public ya8 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ya8 ya8Var = new ya8(this.a);
            ya8Var.b();
            ya8Var.setBusinessType(99);
            ya8Var.setFromCDN(this.c);
            ya8Var.C(this.b);
            ya8Var.setAfterClickSchemeListener(new a(this, ya8Var));
            return ya8Var;
        }
        return (ya8) invokeV.objValue;
    }

    public View b(AdvertAppInfo advertAppInfo, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, advertAppInfo, z)) == null) {
            if (advertAppInfo == null || !(advertAppInfo.h instanceof AdCard)) {
                return null;
            }
            ya8 ya8Var = this.d.get(advertAppInfo);
            if (ya8Var == null) {
                ya8Var = a();
                this.d.put(advertAppInfo, ya8Var);
            }
            ya8Var.c((AdCard) advertAppInfo.h);
            this.e = ya8Var;
            if (z) {
                ya8Var.w();
            }
            return ya8Var.r();
        }
        return (View) invokeLZ.objValue;
    }

    public void c() {
        ya8 ya8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (ya8Var = this.e) == null) {
            return;
        }
        ya8Var.w();
    }

    public void d() {
        ya8 ya8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (ya8Var = this.e) == null) {
            return;
        }
        ya8Var.A();
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            for (ya8 ya8Var : this.d.values()) {
                if (ya8Var != null) {
                    ya8Var.B();
                }
            }
            this.d.clear();
        }
    }

    public void f(AdvertAppInfo advertAppInfo) {
        ya8 ya8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, advertAppInfo) == null) || advertAppInfo == null || (ya8Var = this.d.get(advertAppInfo)) == null) {
            return;
        }
        ya8Var.B();
        this.d.remove(advertAppInfo);
    }
}
