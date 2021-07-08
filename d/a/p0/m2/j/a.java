package d.a.p0.m2.j;

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
/* loaded from: classes8.dex */
public class a extends d.a.p0.a0.b<d.a.p0.m2.e.c> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> m;
    public int n;
    public d.a.p0.m2.e.c o;
    public b p;
    public d.a.c.e.k.b<PersonCommonForumItemView> q;
    public TextView r;
    public ListViewPager s;

    /* renamed from: d.a.p0.m2.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class C1549a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public class b extends PagerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f60364a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60364a = aVar;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIL(1048576, this, viewGroup, i2, obj) == null) && (obj instanceof PersonCommonForumCardView)) {
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
                if (this.f60364a.o == null || ListUtils.isEmpty(this.f60364a.o.f60238e)) {
                    return 0;
                }
                return this.f60364a.o.f60238e.size() % 4 == 0 ? this.f60364a.o.f60238e.size() / 4 : (this.f60364a.o.f60238e.size() / 4) + 1;
            }
            return invokeV.intValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i2)) == null) {
                List<d.a.p0.m2.e.f> v = this.f60364a.v(i2);
                if (ListUtils.isEmpty(v)) {
                    return null;
                }
                PersonCommonForumCardView personCommonForumCardView = new PersonCommonForumCardView(this.f60364a.m.getPageActivity());
                personCommonForumCardView.setForumItemViewBdObjectPool(this.f60364a.q);
                personCommonForumCardView.setData(v);
                personCommonForumCardView.setVerticalSpacing(TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.tbds42));
                viewGroup.addView(personCommonForumCardView);
                return personCommonForumCardView;
            }
            return invokeLI.objValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, view, obj)) == null) ? view == obj : invokeLL.booleanValue;
        }

        public /* synthetic */ b(a aVar, C1549a c1549a) {
            this(aVar);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = 3;
        this.p = new b(this, null);
        this.m = tbPageContext;
        View k = k();
        this.r = (TextView) k.findViewById(R.id.common_forum_title);
        this.s = (ListViewPager) k.findViewById(R.id.common_forum_viewpager);
        if ("NX40X".equals(Build.MODEL)) {
            k.setLayerType(2, null);
            if (k instanceof ViewGroup) {
                ((ViewGroup) k).setClipChildren(true);
            }
        }
        this.s.setOffscreenPageLimit(1);
    }

    @Override // d.a.p0.a0.b
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.person_info_common_forum_layout : invokeV.intValue;
    }

    @Override // d.a.p0.a0.b
    public void m(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            if (this.n != i2) {
                SkinManager.setBackgroundResource(k(), R.color.CAM_X0201);
                SkinManager.setViewTextColor(this.r, R.color.CAM_X0109);
                int childCount = this.s.getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt = this.s.getChildAt(i3);
                    if (childAt instanceof PersonCommonForumCardView) {
                        ((PersonCommonForumCardView) childAt).j();
                    }
                }
            }
            this.n = i2;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
        }
    }

    public final List<d.a.p0.m2.e.f> v(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            d.a.p0.m2.e.c cVar = this.o;
            if (cVar == null || ListUtils.isEmpty(cVar.f60238e)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int i3 = i2 * 4;
            for (int i4 = i3; i4 < i3 + 4; i4++) {
                d.a.p0.m2.e.f fVar = (d.a.p0.m2.e.f) ListUtils.getItem(this.o.f60238e, i4);
                if (fVar != null) {
                    arrayList.add(fVar);
                }
            }
            return arrayList;
        }
        return (List) invokeI.objValue;
    }

    public final boolean w(d.a.p0.m2.e.c cVar) {
        InterceptResult invokeL;
        d.a.p0.m2.e.c cVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, cVar)) == null) {
            if (cVar == null || ListUtils.isEmpty(cVar.f60238e) || cVar == (cVar2 = this.o)) {
                return false;
            }
            if (cVar2 == null || ListUtils.isEmpty(cVar2.f60238e)) {
                return true;
            }
            if (!ListUtils.isEmpty(cVar.f60238e)) {
                if (cVar.f60238e.size() != this.o.f60238e.size()) {
                    return true;
                }
                for (int i2 = 0; i2 < cVar.f60238e.size(); i2++) {
                    if (this.o.f60238e.get(i2) == null || cVar.f60238e.get(i2).f60248e != this.o.f60238e.get(i2).f60248e) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.p0.a0.b
    /* renamed from: x */
    public void l(d.a.p0.m2.e.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            if (w(cVar)) {
                this.o = cVar;
                if (ListUtils.getCount(cVar.f60238e) <= 2) {
                    this.s.getLayoutParams().height = d.a.c.e.p.l.g(this.m.getPageActivity(), R.dimen.ds140);
                }
                this.s.setAdapter(this.p);
            }
            m(this.m, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void y(d.a.c.e.k.b<PersonCommonForumItemView> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            this.q = bVar;
        }
    }
}
