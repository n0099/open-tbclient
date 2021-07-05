package d.a.s0.j2.j;

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
import d.a.c.k.e.n;
import d.a.s0.a0.b0;
import d.a.s0.k2.e.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c f62390a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f62391b;

    /* renamed from: c  reason: collision with root package name */
    public List<n> f62392c;

    /* renamed from: d  reason: collision with root package name */
    public PersonMoreData f62393d;

    public b(TbPageContext tbPageContext, Bundle bundle, b0<h> b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bundle, b0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f62391b = tbPageContext;
        c cVar = new c(tbPageContext);
        this.f62390a = cVar;
        cVar.f(b0Var);
        if (bundle == null || !(OrmObject.objectWithBundle(bundle, PersonMoreData.class) instanceof PersonMoreData)) {
            return;
        }
        this.f62393d = (PersonMoreData) OrmObject.objectWithBundle(bundle, PersonMoreData.class);
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f62392c = new ArrayList();
            PersonMoreData personMoreData = this.f62393d;
            if (personMoreData == null || ListUtils.isEmpty(personMoreData.mUrlMaps)) {
                return;
            }
            for (PersonMoreItemData personMoreItemData : this.f62393d.mUrlMaps) {
                if (personMoreItemData != null && !StringUtils.isNull(personMoreItemData.mUrl)) {
                    h hVar = new h();
                    hVar.f62648i = personMoreItemData.mName;
                    hVar.f62644e = 36;
                    hVar.k = personMoreItemData.mUrl;
                    hVar.o = personMoreItemData.mId;
                    this.f62392c.add(hVar);
                }
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f62391b.getPageActivity().setContentView(R.layout.person_center_more_layout);
            this.f62390a.c(this.f62391b.getPageActivity().findViewById(R.id.person_more_layout));
            a();
            this.f62390a.e(this.f62392c);
        }
    }

    public void c() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (cVar = this.f62390a) == null) {
            return;
        }
        cVar.d();
    }
}
