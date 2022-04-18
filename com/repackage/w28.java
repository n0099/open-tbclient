package com.repackage;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.adp.widget.design.TbTabLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.personCenter.view.PersonCenterSmartAppPageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class w28 extends tw5<o28> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<g28> i;
    public List<PersonCenterSmartAppPageView> j;
    public BdBaseViewPager k;
    public TbTabLayout l;
    public View m;
    public a n;
    public PersonCenterSmartAppPageView o;

    /* loaded from: classes7.dex */
    public class a extends PagerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<PersonCenterSmartAppPageView> a;

        public a(w28 w28Var, List<PersonCenterSmartAppPageView> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w28Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = list;
        }

        public void b(List<PersonCenterSmartAppPageView> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                this.a = list;
                notifyDataSetChanged();
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, i, obj) == null) {
                viewGroup.removeView((View) obj);
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a.size() : invokeV.intValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
                int indexOf = this.a.indexOf(obj);
                if (indexOf == -1) {
                    return -2;
                }
                return indexOf;
            }
            return invokeL.intValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, viewGroup, i)) == null) {
                PersonCenterSmartAppPageView personCenterSmartAppPageView = this.a.get(i);
                viewGroup.addView(personCenterSmartAppPageView);
                return personCenterSmartAppPageView;
            }
            return invokeLI.objValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view2, Object obj) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, view2, obj)) == null) ? view2 == obj : invokeLL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w28(TbPageContext<?> tbPageContext) {
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
        View k = k();
        this.k = (BdBaseViewPager) k.findViewById(R.id.obfuscated_res_0x7f09241d);
        this.l = (TbTabLayout) k.findViewById(R.id.obfuscated_res_0x7f092064);
        this.m = k.findViewById(R.id.obfuscated_res_0x7f090393);
        this.l.setTabMode(1);
        ArrayList arrayList = new ArrayList();
        this.j = arrayList;
        a aVar = new a(this, arrayList);
        this.n = aVar;
        this.k.setAdapter(aVar);
        this.l.setupWithViewPager(this.k);
        this.m.setVisibility(8);
        m(j(), this.a);
    }

    @Override // com.repackage.tw5
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d06b4 : invokeV.intValue;
    }

    @Override // com.repackage.tw5
    public void m(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            for (PersonCenterSmartAppPageView personCenterSmartAppPageView : this.j) {
                if (personCenterSmartAppPageView != null) {
                    personCenterSmartAppPageView.c();
                }
            }
            SkinManager.setBackgroundColor(k(), R.color.CAM_X0205);
            this.l.setSelectedTabIndicatorColor(SkinManager.getColor(R.color.CAM_X0629));
            this.l.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(oi.f(tbPageContext.getPageActivity(), R.dimen.tbds3), SkinManager.getColor(R.color.CAM_X0625)));
            SkinManager.setBackgroundColor(this.m, R.color.CAM_X0204);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
        }
    }

    public final void s(g28 g28Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, g28Var) == null) {
            if (this.o.b()) {
                this.o.a(g28Var);
                return;
            }
            PersonCenterSmartAppPageView personCenterSmartAppPageView = new PersonCenterSmartAppPageView(getContext());
            this.o = personCenterSmartAppPageView;
            this.j.add(personCenterSmartAppPageView);
            this.o.a(g28Var);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.tw5
    /* renamed from: t */
    public void l(o28 o28Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, o28Var) == null) {
            if (o28Var != null && o28Var.e() != null && !ListUtils.isEmpty(o28Var.e())) {
                p(0);
                this.j.clear();
                this.i = o28Var.e();
                PersonCenterSmartAppPageView personCenterSmartAppPageView = new PersonCenterSmartAppPageView(getContext());
                this.o = personCenterSmartAppPageView;
                this.j.add(personCenterSmartAppPageView);
                int min = Math.min(7, this.i.size());
                for (int i = 0; i < min; i++) {
                    s((g28) ListUtils.getItem(this.i, i));
                }
                if (this.i.isEmpty()) {
                    p(8);
                } else {
                    s(new p28());
                }
                if (this.j.size() <= 1) {
                    this.l.setVisibility(8);
                } else {
                    this.l.setVisibility(0);
                }
                this.n.b(this.j);
                m(j(), this.a);
                return;
            }
            p(8);
        }
    }
}
