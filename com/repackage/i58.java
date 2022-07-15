package com.repackage;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.view.PersonCommonForumCardView;
import com.baidu.tieba.personPolymeric.view.PersonCommonForumItemView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class i58 extends jx5<g48> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> i;
    public int j;
    public g48 k;
    public b l;
    public eg<PersonCommonForumItemView> m;
    public TextView n;
    public ListViewPager o;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public class b extends PagerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i58 a;

        public b(i58 i58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i58Var;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIL(1048576, this, viewGroup, i, obj) == null) && (obj instanceof PersonCommonForumCardView)) {
                PersonCommonForumCardView personCommonForumCardView = (PersonCommonForumCardView) obj;
                personCommonForumCardView.k();
                viewGroup.removeView(personCommonForumCardView);
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.a.k == null || ListUtils.isEmpty(this.a.k.a)) {
                    return 0;
                }
                return this.a.k.a.size() % 4 == 0 ? this.a.k.a.size() / 4 : (this.a.k.a.size() / 4) + 1;
            }
            return invokeV.intValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i)) == null) {
                List<j48> v = this.a.v(i);
                if (ListUtils.isEmpty(v)) {
                    return null;
                }
                PersonCommonForumCardView personCommonForumCardView = new PersonCommonForumCardView(this.a.i.getPageActivity());
                personCommonForumCardView.setForumItemViewBdObjectPool(this.a.m);
                personCommonForumCardView.setData(v);
                personCommonForumCardView.setVerticalSpacing(TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.tbds42));
                viewGroup.addView(personCommonForumCardView);
                return personCommonForumCardView;
            }
            return invokeLI.objValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view2, Object obj) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, view2, obj)) == null) ? view2 == obj : invokeLL.booleanValue;
        }

        public /* synthetic */ b(i58 i58Var, a aVar) {
            this(i58Var);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i58(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = 3;
        this.l = new b(this, null);
        this.i = tbPageContext;
        View h = h();
        this.n = (TextView) h.findViewById(R.id.obfuscated_res_0x7f09066b);
        this.o = (ListViewPager) h.findViewById(R.id.obfuscated_res_0x7f09066c);
        if ("NX40X".equals(Build.MODEL)) {
            h.setLayerType(2, null);
            if (h instanceof ViewGroup) {
                ((ViewGroup) h).setClipChildren(true);
            }
        }
        this.o.setOffscreenPageLimit(1);
    }

    @Override // com.repackage.jx5
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d06c7 : invokeV.intValue;
    }

    @Override // com.repackage.jx5
    public void j(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            if (this.j != i) {
                SkinManager.setBackgroundResource(h(), R.color.CAM_X0201);
                SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0109);
                int childCount = this.o.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = this.o.getChildAt(i2);
                    if (childAt instanceof PersonCommonForumCardView) {
                        ((PersonCommonForumCardView) childAt).j();
                    }
                }
            }
            this.j = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
        }
    }

    public final List<j48> v(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            g48 g48Var = this.k;
            if (g48Var == null || ListUtils.isEmpty(g48Var.a)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int i2 = i * 4;
            for (int i3 = i2; i3 < i2 + 4; i3++) {
                j48 j48Var = (j48) ListUtils.getItem(this.k.a, i3);
                if (j48Var != null) {
                    arrayList.add(j48Var);
                }
            }
            return arrayList;
        }
        return (List) invokeI.objValue;
    }

    public final boolean w(g48 g48Var) {
        InterceptResult invokeL;
        g48 g48Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, g48Var)) == null) {
            if (g48Var == null || ListUtils.isEmpty(g48Var.a) || g48Var == (g48Var2 = this.k)) {
                return false;
            }
            if (g48Var2 == null || ListUtils.isEmpty(g48Var2.a)) {
                return true;
            }
            if (!ListUtils.isEmpty(g48Var.a)) {
                if (g48Var.a.size() != this.k.a.size()) {
                    return true;
                }
                for (int i = 0; i < g48Var.a.size(); i++) {
                    if (this.k.a.get(i) == null || g48Var.a.get(i).a != this.k.a.get(i).a) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.jx5
    /* renamed from: x */
    public void i(g48 g48Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, g48Var) == null) {
            if (w(g48Var)) {
                this.k = g48Var;
                if (ListUtils.getCount(g48Var.a) <= 2) {
                    this.o.getLayoutParams().height = pi.f(this.i.getPageActivity(), R.dimen.obfuscated_res_0x7f070249);
                }
                this.o.setAdapter(this.l);
            }
            j(this.i, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void y(eg<PersonCommonForumItemView> egVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, egVar) == null) {
            this.m = egVar;
        }
    }
}
