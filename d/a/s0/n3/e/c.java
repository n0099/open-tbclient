package d.a.s0.n3.e;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.PersonalBackdropListActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.MemberRecommendView;
import com.baidu.tieba.themeCenter.background.BackgroundGroupActivity;
import com.baidu.tieba.themeCenter.background.DressItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BackgroundGroupActivity f64138a;

    /* renamed from: b  reason: collision with root package name */
    public View f64139b;

    /* renamed from: c  reason: collision with root package name */
    public View f64140c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f64141d;

    /* renamed from: e  reason: collision with root package name */
    public MemberRecommendView f64142e;

    /* renamed from: f  reason: collision with root package name */
    public BdListView f64143f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f64144g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f64145h;

    /* renamed from: i  reason: collision with root package name */
    public int f64146i;
    public d.a.s0.n3.e.a j;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f64147e;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64147e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.log("c10283");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalBackdropListActivityConfig(this.f64147e.f64138a.getActivity())));
            }
        }
    }

    public c(BackgroundGroupActivity backgroundGroupActivity, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {backgroundGroupActivity, dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f64146i = 0;
        this.f64138a = backgroundGroupActivity;
        this.f64146i = l.g(backgroundGroupActivity.getPageContext().getPageActivity(), R.dimen.ds320);
        View inflate = LayoutInflater.from(this.f64138a.getPageContext().getPageActivity()).inflate(R.layout.background_group, (ViewGroup) null);
        this.f64139b = inflate;
        this.f64138a.setContentView(inflate);
        this.f64140c = this.f64139b.findViewById(R.id.body_view);
        NavigationBar navigationBar = (NavigationBar) this.f64139b.findViewById(R.id.view_navigation_bar);
        this.f64141d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f64141d.setTitleText(R.string.personal_background);
        MemberRecommendView memberRecommendView = (MemberRecommendView) this.f64139b.findViewById(R.id.view_member_recommend);
        this.f64142e = memberRecommendView;
        memberRecommendView.setFromType(4);
        this.f64143f = (BdListView) this.f64139b.findViewById(R.id.listview_bg_group);
        TextView textView = new TextView(this.f64138a.getActivity());
        this.f64144g = textView;
        textView.setHeight(l.g(this.f64138a.getActivity(), R.dimen.ds104));
        TextView textView2 = (TextView) LayoutInflater.from(this.f64138a.getPageContext().getPageActivity()).inflate(R.layout.look_more_view, (ViewGroup) null);
        this.f64145h = textView2;
        textView2.setText(R.string.more_backgrounds);
        this.f64145h.setOnClickListener(new a(this));
        this.j = new d.a.s0.n3.e.a(this.f64138a.getPageContext(), dVar);
        TextView textView3 = new TextView(this.f64138a.getActivity());
        textView3.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.g(this.f64138a.getActivity(), R.dimen.ds98)));
        this.f64143f.x(textView3, 0);
        this.f64143f.addFooterView(this.f64145h);
        this.f64143f.setAdapter((ListAdapter) this.j);
    }

    public final List<Object> b(List<b> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            ArrayList arrayList = new ArrayList();
            for (b bVar : list) {
                arrayList.add(bVar.b());
                List<DressItemData> a2 = bVar.a();
                int size = a2.size();
                if (size > 3) {
                    size = 3;
                }
                for (int i2 = 0; i2 < size; i2 = i2 + 2 + 1) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i3 = 0; i3 < 3; i3++) {
                        int i4 = i2 + i3;
                        if (i4 < size) {
                            arrayList2.add(a2.get(i4));
                        }
                    }
                    arrayList.add(arrayList2);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SkinManager.setBackgroundColor(this.f64139b, R.color.CAM_X0204);
            this.f64138a.hideNetRefreshView(this.f64139b);
            this.f64140c.setVisibility(0);
        }
    }

    public View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f64139b : (View) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f64140c.setVisibility(8);
        }
    }

    public void f() {
        d.a.s0.n3.e.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            d.a.r0.s0.a.a(this.f64138a.getPageContext(), this.f64139b);
            this.f64138a.getLayoutMode().j(this.f64145h);
            d.a.r0.r.u.c.d(this.f64145h).t(R.color.CAM_X0108);
            NavigationBar navigationBar = this.f64141d;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.f64138a.getPageContext(), TbadkApplication.getInst().getSkinType());
            }
            BdListView bdListView = this.f64143f;
            if (bdListView != null && bdListView.getVisibility() == 0 && (aVar = this.j) != null) {
                aVar.notifyDataSetChanged();
            }
            SkinManager.setBackgroundColor(this.f64144g, R.color.CAM_X0204);
            this.f64142e.d();
        }
    }

    public final void g(List<Object> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            if (list != null && list.size() > 0) {
                this.f64143f.setVisibility(0);
                this.j.a(list);
                this.j.notifyDataSetChanged();
                return;
            }
            this.f64143f.setVisibility(8);
        }
    }

    public final boolean h(d.a.s0.n3.h.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, eVar)) == null) {
            if (eVar != null && !StringUtils.isNull(eVar.c())) {
                this.f64142e.setVisibility(0);
                this.f64142e.e(eVar);
                return true;
            }
            this.f64142e.setVisibility(8);
            return false;
        }
        return invokeL.booleanValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f64140c.setVisibility(0);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f64140c.setVisibility(8);
            SkinManager.setBackgroundColor(this.f64139b, R.color.CAM_X0201);
            String string = this.f64138a.getPageContext().getResources().getString(R.string.no_data_text);
            this.f64138a.setNetRefreshViewTopMargin(this.f64146i);
            this.f64138a.showNetRefreshView(this.f64139b, string, false);
        }
    }

    public void k(d.a.s0.n3.h.e eVar, List<b> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048585, this, eVar, list, z) == null) {
            if (list != null && list.size() > 0) {
                c();
                if (h(eVar)) {
                    this.f64143f.removeHeaderView(this.f64144g);
                    this.f64143f.addHeaderView(this.f64144g);
                } else {
                    this.f64143f.removeHeaderView(this.f64144g);
                }
                g(b(list));
                return;
            }
            j();
        }
    }
}
