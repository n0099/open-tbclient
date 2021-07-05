package d.a.s0.v.j.g.d.c;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.adapter.AlaEnterEffectAdapter;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.adapter.AlaEnterEffectCategoryAdapter;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.data.AlaEnterEffectData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.k.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f68181a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f68182b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.a.c.k.e.a> f68183c;

    /* renamed from: d  reason: collision with root package name */
    public AlaEnterEffectAdapter f68184d;

    /* renamed from: e  reason: collision with root package name */
    public AlaEnterEffectCategoryAdapter f68185e;

    /* renamed from: f  reason: collision with root package name */
    public List<n> f68186f;

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeListView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f68181a = tbPageContext;
        this.f68182b = bdTypeListView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f68183c = new ArrayList();
            AlaEnterEffectAdapter alaEnterEffectAdapter = new AlaEnterEffectAdapter(this.f68181a.getPageActivity());
            this.f68184d = alaEnterEffectAdapter;
            this.f68183c.add(alaEnterEffectAdapter);
            AlaEnterEffectCategoryAdapter alaEnterEffectCategoryAdapter = new AlaEnterEffectCategoryAdapter(this.f68181a.getPageActivity());
            this.f68185e = alaEnterEffectCategoryAdapter;
            this.f68183c.add(alaEnterEffectCategoryAdapter);
            this.f68182b.a(this.f68183c);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            for (d.a.c.k.e.a aVar : this.f68183c) {
                aVar.L();
            }
        }
    }

    public void c(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.f68182b.setData(list);
        this.f68186f = this.f68182b.getData();
    }

    public void d(String str, int i2) {
        List<n> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, str, i2) == null) || StringUtils.isNull(str) || (list = this.f68186f) == null) {
            return;
        }
        for (n nVar : list) {
            if (nVar instanceof AlaEnterEffectData) {
                AlaEnterEffectData alaEnterEffectData = (AlaEnterEffectData) nVar;
                if (alaEnterEffectData.type == 1 && str.equals(alaEnterEffectData.gift.giftId)) {
                    alaEnterEffectData.downLoadStatus = i2;
                    b();
                }
            }
        }
    }

    public void e(String str, boolean z) {
        List<n> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048580, this, str, z) == null) || TextUtils.isEmpty(str) || (list = this.f68186f) == null) {
            return;
        }
        for (n nVar : list) {
            if (nVar instanceof AlaEnterEffectData) {
                AlaEnterEffectData alaEnterEffectData = (AlaEnterEffectData) nVar;
                if (str.equals(alaEnterEffectData.id)) {
                    alaEnterEffectData.isOwn = z;
                    b();
                    return;
                }
            }
        }
    }

    public void f(String str, boolean z) {
        List<n> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048581, this, str, z) == null) || TextUtils.isEmpty(str) || (list = this.f68186f) == null) {
            return;
        }
        for (n nVar : list) {
            if (nVar instanceof AlaEnterEffectData) {
                AlaEnterEffectData alaEnterEffectData = (AlaEnterEffectData) nVar;
                if (str.equals(alaEnterEffectData.id)) {
                    alaEnterEffectData.use_status = z ? 1 : 0;
                } else {
                    alaEnterEffectData.use_status = 0;
                }
                b();
            }
        }
    }
}
