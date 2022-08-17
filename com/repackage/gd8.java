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
/* loaded from: classes6.dex */
public class gd8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext<?> a;
    public final DragImageView.h b;
    public final boolean c;
    public Map<AdvertAppInfo, fd8> d;
    public fd8 e;

    /* loaded from: classes6.dex */
    public class a implements ne7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fd8 a;

        public a(gd8 gd8Var, fd8 fd8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gd8Var, fd8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fd8Var;
        }

        @Override // com.repackage.ne7
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
                if (zb8.h(i)) {
                    ld8.f(a, 0, str, i);
                } else {
                    ld8.m(a, 0, str);
                }
                ve7.c(a);
            }
        }
    }

    public gd8(@NonNull TbPageContext<?> tbPageContext, boolean z, DragImageView.h hVar) {
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

    public fd8 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            fd8 fd8Var = new fd8(this.a);
            fd8Var.b();
            fd8Var.setBusinessType(99);
            fd8Var.setFromCDN(this.c);
            fd8Var.C(this.b);
            fd8Var.setAfterClickSchemeListener(new a(this, fd8Var));
            return fd8Var;
        }
        return (fd8) invokeV.objValue;
    }

    public View b(AdvertAppInfo advertAppInfo, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, advertAppInfo, z)) == null) {
            if (advertAppInfo == null || !(advertAppInfo.h instanceof AdCard)) {
                return null;
            }
            fd8 fd8Var = this.d.get(advertAppInfo);
            if (fd8Var == null) {
                fd8Var = a();
                this.d.put(advertAppInfo, fd8Var);
            }
            fd8Var.e((AdCard) advertAppInfo.h);
            this.e = fd8Var;
            if (z) {
                fd8Var.w();
            }
            return fd8Var.r();
        }
        return (View) invokeLZ.objValue;
    }

    public void c() {
        fd8 fd8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (fd8Var = this.e) == null) {
            return;
        }
        fd8Var.w();
    }

    public void d() {
        fd8 fd8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (fd8Var = this.e) == null) {
            return;
        }
        fd8Var.A();
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            for (fd8 fd8Var : this.d.values()) {
                if (fd8Var != null) {
                    fd8Var.B();
                }
            }
            this.d.clear();
        }
    }

    public void f(AdvertAppInfo advertAppInfo) {
        fd8 fd8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, advertAppInfo) == null) || advertAppInfo == null || (fd8Var = this.d.get(advertAppInfo)) == null) {
            return;
        }
        fd8Var.B();
        this.d.remove(advertAppInfo);
    }
}
