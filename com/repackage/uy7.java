package com.repackage;

import android.os.Bundle;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.person.PersonMoreData;
import com.baidu.tieba.person.PersonMoreItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class uy7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public vy7 a;
    public TbPageContext b;
    public List<jn> c;
    public PersonMoreData d;

    public uy7(TbPageContext tbPageContext, Bundle bundle, nw5<rz7> nw5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bundle, nw5Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = tbPageContext;
        vy7 vy7Var = new vy7(tbPageContext);
        this.a = vy7Var;
        vy7Var.f(nw5Var);
        if (bundle == null || !(OrmObject.objectWithBundle(bundle, PersonMoreData.class) instanceof PersonMoreData)) {
            return;
        }
        this.d = (PersonMoreData) OrmObject.objectWithBundle(bundle, PersonMoreData.class);
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.c = new ArrayList();
            PersonMoreData personMoreData = this.d;
            if (personMoreData == null || ListUtils.isEmpty(personMoreData.mUrlMaps)) {
                return;
            }
            for (PersonMoreItemData personMoreItemData : this.d.mUrlMaps) {
                if (personMoreItemData != null && !StringUtils.isNull(personMoreItemData.mUrl)) {
                    rz7 rz7Var = new rz7();
                    rz7Var.e = personMoreItemData.mName;
                    rz7Var.a = 36;
                    rz7Var.g = personMoreItemData.mUrl;
                    rz7Var.k = personMoreItemData.mId;
                    this.c.add(rz7Var);
                }
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.b.getPageActivity().setContentView(R.layout.obfuscated_res_0x7f0d0698);
            this.a.c(this.b.getPageActivity().findViewById(R.id.obfuscated_res_0x7f0917f7));
            a();
            this.a.e(this.c);
        }
    }

    public void c() {
        vy7 vy7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (vy7Var = this.a) == null) {
            return;
        }
        vy7Var.d();
    }
}
