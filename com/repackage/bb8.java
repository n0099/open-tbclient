package com.repackage;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.recapp.async.IAdBaseAsyncController;
import com.baidu.tieba.recapp.constants.PlaceId;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes5.dex */
public class bb8 implements fa8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final lk5 a;
    public Map<String, AdvertAppInfo> b;
    public za8 c;
    public int d;
    public final Set<String> e;
    public boolean f;

    public bb8(IAdBaseAsyncController.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = new LinkedHashSet();
        this.f = false;
        lk5 lk5Var = new lk5(PlaceId.PIC_PAGE_INSERT, "PIC_PAGE", aVar);
        this.a = lk5Var;
        lk5Var.e(false);
        this.b = new HashMap();
        this.d = di5.a().c();
    }

    @Override // com.repackage.fa8
    public View b(@NonNull String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, str, z)) == null) {
            this.f = z;
            return this.c.b(this.b.get(str), z);
        }
        return (View) invokeLZ.objValue;
    }

    @Override // com.repackage.fa8
    public AdvertAppInfo d(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? this.b.get(str) : (AdvertAppInfo) invokeL.objValue;
    }

    @Override // com.repackage.fa8
    public void e(@NonNull String str, @NonNull AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, advertAppInfo) == null) {
            this.b.put(str, advertAppInfo);
        }
    }

    @Override // com.repackage.fa8
    public boolean f(@NonNull String str) {
        InterceptResult invokeL;
        AdvertAppInfo advertAppInfo;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? (TextUtils.isEmpty(str) || (advertAppInfo = this.b.get(str)) == null || w88.l(advertAppInfo)) ? false : true : invokeL.booleanValue;
    }

    @Override // com.repackage.fa8
    public void g(@NonNull wc5 wc5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, wc5Var) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("forum_id", wc5Var.c);
            hashMap.put("forum_name", wc5Var.d);
            this.a.d(this.d, hashMap);
        }
    }

    @Override // com.repackage.fa8
    public int getAdCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            int i = 0;
            if (this.b.isEmpty()) {
                return 0;
            }
            for (AdvertAppInfo advertAppInfo : this.b.values()) {
                if (!w88.l(advertAppInfo)) {
                    i++;
                }
            }
            return i;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.fa8
    public void h(@NonNull TbPageContext tbPageContext, @NonNull DragImageView.h hVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048582, this, tbPageContext, hVar, z) == null) {
            this.c = new za8(tbPageContext, z, hVar);
        }
    }

    @Override // com.repackage.fa8
    public void j(@NonNull String str) {
        AdvertAppInfo advertAppInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, str) == null) || (advertAppInfo = this.b.get(str)) == null) {
            return;
        }
        eb8.o(advertAppInfo);
        bd7.b(bd7.a(advertAppInfo));
        boolean add = this.e.add(str);
        if (!this.f && add) {
            this.c.d();
        } else {
            this.c.c();
        }
    }

    @Override // com.repackage.fa8
    public void k(@NonNull AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, advertAppInfo) == null) {
            eb8.h(advertAppInfo, 0, 2);
        }
    }

    @Override // com.repackage.fa8
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.b.clear();
        }
    }

    @Override // com.repackage.fa8
    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? !this.b.isEmpty() : invokeV.booleanValue;
    }

    @Override // com.repackage.fa8
    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.c.f(this.b.get(str));
        }
    }

    @Override // com.repackage.fa8
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.c.e();
            this.a.b();
            this.e.clear();
        }
    }
}
