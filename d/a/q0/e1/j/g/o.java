package d.a.q0.e1.j.g;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.AdapterViewHolder;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.homepage.tabfeed.data.SpecialColumnListData;
import com.baidu.tieba.homepage.tabfeed.view.SpecialTopicLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.k.e.s;
/* loaded from: classes8.dex */
public class o extends d.a.d.k.e.a<SpecialColumnListData, AdapterViewHolder<SpecialTopicLayout>> implements d.a.q0.e1.j.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext m;
    public String n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), SpecialColumnListData.TYPE);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.k.e.a
    /* renamed from: e0 */
    public AdapterViewHolder<SpecialTopicLayout> Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            SpecialTopicLayout specialTopicLayout = new SpecialTopicLayout(this.m);
            specialTopicLayout.setShowMore(true);
            return new AdapterViewHolder<>(specialTopicLayout);
        }
        return (AdapterViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.k.e.a
    /* renamed from: f0 */
    public View X(int i2, View view, ViewGroup viewGroup, SpecialColumnListData specialColumnListData, AdapterViewHolder<SpecialTopicLayout> adapterViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, specialColumnListData, adapterViewHolder})) == null) {
            SpecialTopicLayout b2 = adapterViewHolder.b();
            b2.setTabCode(this.n);
            b2.a(specialColumnListData);
            return adapterViewHolder.a();
        }
        return (View) invokeCommon.objValue;
    }

    public void g0(s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, sVar) == null) {
        }
    }

    @Override // d.a.q0.e1.j.d
    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.n = str;
        }
    }
}
