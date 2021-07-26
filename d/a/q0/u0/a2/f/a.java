package d.a.q0.u0.a2.f;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.itemtab.card.CardItemDetailListItemLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.u0.a2.g.d;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class a extends d.a.k.a<d.a.q0.u0.a2.g.b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View j;
    public EMTextView k;
    public ArrayList<d> l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // d.a.k.a
    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.j == null) {
                View inflate = LayoutInflater.from(this.f43131f).inflate(R.layout.card_item_detail_info, (ViewGroup) null, true);
                this.j = inflate;
                this.k = (EMTextView) inflate.findViewById(R.id.item_detail_title);
            }
            return this.j;
        }
        return (View) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.k.p
    /* renamed from: o */
    public void a(d.a.q0.u0.a2.g.b bVar) {
        boolean z;
        View childAt;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) && bVar != null && bVar.d()) {
            ArrayList<d> c2 = bVar.c();
            if (ListUtils.getCount(c2) != ListUtils.getCount(this.l)) {
                if (ListUtils.getCount(this.l) > 0) {
                    ((ViewGroup) this.j).removeViews(1, ListUtils.getCount(this.l));
                }
                z = true;
            } else {
                z = false;
            }
            if (c2 != null) {
                for (int i2 = 0; i2 < c2.size(); i2++) {
                    if (z) {
                        childAt = new CardItemDetailListItemLayout(this.f43131f);
                        ((ViewGroup) this.j).addView(childAt, -1, -2);
                    } else {
                        childAt = ((ViewGroup) this.j).getChildAt(i2 + 1);
                    }
                    if (childAt instanceof CardItemDetailListItemLayout) {
                        ((CardItemDetailListItemLayout) childAt).setData(c2.get(i2));
                    }
                }
            }
            ViewGroup viewGroup = (ViewGroup) this.j;
            int childCount = viewGroup.getChildCount() - 1;
            while (true) {
                if (childCount <= 0) {
                    break;
                }
                if ((viewGroup.getChildAt(childCount) instanceof CardItemDetailListItemLayout) && viewGroup.getChildAt(childCount).getVisibility() == 0) {
                    ((CardItemDetailListItemLayout) viewGroup.getChildAt(childCount)).setDividerVisible(false);
                    break;
                }
                childCount--;
            }
            this.l = c2;
        }
    }

    @Override // d.a.k.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i2) == null) {
            d.a.p0.s.u.c d2 = d.a.p0.s.u.c.d(this.j);
            d2.n(R.string.J_X06);
            d2.f(R.color.CAM_X0205);
            d.a.p0.s.u.c d3 = d.a.p0.s.u.c.d(this.k);
            d3.y(R.string.F_X02);
            d3.t(R.color.CAM_X0105);
            for (int i3 = 0; i3 < ((ViewGroup) this.j).getChildCount(); i3++) {
                if (((ViewGroup) this.j).getChildAt(i3) instanceof CardItemDetailListItemLayout) {
                    ((CardItemDetailListItemLayout) ((ViewGroup) this.j).getChildAt(i3)).d();
                }
            }
        }
    }
}
