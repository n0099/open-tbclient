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
public class x88 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext<?> a;
    public final DragImageView.h b;
    public final boolean c;
    public Map<AdvertAppInfo, w88> d;
    public w88 e;

    /* loaded from: classes7.dex */
    public class a implements qa7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w88 a;

        public a(x88 x88Var, w88 w88Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x88Var, w88Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w88Var;
        }

        @Override // com.repackage.qa7
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
                if (r78.h(i)) {
                    c98.f(a, 0, str, i);
                } else {
                    c98.m(a, 0, str);
                }
                ya7.c(a);
            }
        }
    }

    public x88(@NonNull TbPageContext<?> tbPageContext, boolean z, DragImageView.h hVar) {
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

    public w88 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            w88 w88Var = new w88(this.a);
            w88Var.c();
            w88Var.setBusinessType(99);
            w88Var.setFromCDN(this.c);
            w88Var.C(this.b);
            w88Var.setAfterClickSchemeListener(new a(this, w88Var));
            return w88Var;
        }
        return (w88) invokeV.objValue;
    }

    public View b(AdvertAppInfo advertAppInfo, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, advertAppInfo, z)) == null) {
            if (advertAppInfo == null || !(advertAppInfo.h instanceof AdCard)) {
                return null;
            }
            w88 w88Var = this.d.get(advertAppInfo);
            if (w88Var == null) {
                w88Var = a();
                this.d.put(advertAppInfo, w88Var);
            }
            w88Var.d((AdCard) advertAppInfo.h);
            this.e = w88Var;
            if (z) {
                w88Var.w();
            }
            return w88Var.r();
        }
        return (View) invokeLZ.objValue;
    }

    public void c() {
        w88 w88Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (w88Var = this.e) == null) {
            return;
        }
        w88Var.w();
    }

    public void d() {
        w88 w88Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (w88Var = this.e) == null) {
            return;
        }
        w88Var.A();
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            for (w88 w88Var : this.d.values()) {
                if (w88Var != null) {
                    w88Var.B();
                }
            }
            this.d.clear();
        }
    }

    public void f(AdvertAppInfo advertAppInfo) {
        w88 w88Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, advertAppInfo) == null) || advertAppInfo == null || (w88Var = this.d.get(advertAppInfo)) == null) {
            return;
        }
        w88Var.B();
        this.d.remove(advertAppInfo);
    }
}
