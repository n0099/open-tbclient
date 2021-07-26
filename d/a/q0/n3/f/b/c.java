package d.a.q0.n3.f.b;

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
import com.baidu.tbadk.core.atomData.BubbleListActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.MemberRecommendView;
import com.baidu.tieba.themeCenter.background.DressItemData;
import com.baidu.tieba.themeCenter.bubble.group.BubbleGroupActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
import d.a.q0.n3.h.e;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BubbleGroupActivity f61588a;

    /* renamed from: b  reason: collision with root package name */
    public View f61589b;

    /* renamed from: c  reason: collision with root package name */
    public View f61590c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f61591d;

    /* renamed from: e  reason: collision with root package name */
    public MemberRecommendView f61592e;

    /* renamed from: f  reason: collision with root package name */
    public BdListView f61593f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f61594g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f61595h;

    /* renamed from: i  reason: collision with root package name */
    public int f61596i;
    public d.a.q0.n3.f.b.a j;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f61597e;

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
            this.f61597e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.log("c10283");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleListActivityConfig(this.f61597e.f61588a.getActivity())));
            }
        }
    }

    public c(BubbleGroupActivity bubbleGroupActivity, d.a.q0.n3.f.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bubbleGroupActivity, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f61596i = 0;
        this.f61588a = bubbleGroupActivity;
        this.f61596i = l.g(bubbleGroupActivity.getPageContext().getPageActivity(), R.dimen.ds320);
        View inflate = LayoutInflater.from(this.f61588a.getPageContext().getPageActivity()).inflate(R.layout.bubble_group, (ViewGroup) null);
        this.f61589b = inflate;
        this.f61588a.setContentView(inflate);
        this.f61590c = this.f61589b.findViewById(R.id.body_view);
        NavigationBar navigationBar = (NavigationBar) this.f61589b.findViewById(R.id.view_navigation_bar);
        this.f61591d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f61591d.setTitleText(R.string.editor_privilege);
        MemberRecommendView memberRecommendView = (MemberRecommendView) this.f61589b.findViewById(R.id.view_member_recommend);
        this.f61592e = memberRecommendView;
        memberRecommendView.setFromType(6);
        this.f61593f = (BdListView) this.f61589b.findViewById(R.id.listview_group);
        TextView textView = new TextView(this.f61588a.getActivity());
        this.f61594g = textView;
        textView.setHeight(l.g(this.f61588a.getActivity(), R.dimen.ds104));
        TextView textView2 = (TextView) LayoutInflater.from(this.f61588a.getPageContext().getPageActivity()).inflate(R.layout.look_more_view, (ViewGroup) null);
        this.f61595h = textView2;
        textView2.setText(R.string.more_bubble);
        this.f61595h.setOnClickListener(new a(this));
        this.j = new d.a.q0.n3.f.b.a(this.f61588a.getPageContext(), aVar);
        TextView textView3 = new TextView(this.f61588a.getActivity());
        textView3.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.g(this.f61588a.getActivity(), R.dimen.ds98)));
        this.f61593f.x(textView3, 0);
        this.f61593f.addFooterView(this.f61595h);
        this.f61593f.setAdapter((ListAdapter) this.j);
    }

    public final List<Object> b(List<b> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            ArrayList arrayList = new ArrayList();
            for (b bVar : list) {
                List<DressItemData> a2 = bVar.a();
                int size = a2.size();
                if (size != 0) {
                    arrayList.add(bVar.b());
                    if (size > 4) {
                        size = 4;
                    }
                    for (int i2 = 0; i2 < size; i2 = i2 + 1 + 1) {
                        ArrayList arrayList2 = new ArrayList();
                        for (int i3 = 0; i3 < 2; i3++) {
                            int i4 = i2 + i3;
                            if (i4 < size) {
                                arrayList2.add(a2.get(i4));
                            }
                        }
                        arrayList.add(arrayList2);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SkinManager.setBackgroundColor(this.f61589b, R.color.CAM_X0204);
            this.f61588a.hideNetRefreshView(this.f61589b);
            this.f61590c.setVisibility(0);
        }
    }

    public View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f61589b : (View) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f61590c.setVisibility(8);
        }
    }

    public void f() {
        d.a.q0.n3.f.b.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            d.a.p0.u0.a.a(this.f61588a.getPageContext(), this.f61589b);
            d.a.p0.u0.a.a(this.f61588a.getPageContext(), this.f61595h);
            NavigationBar navigationBar = this.f61591d;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.f61588a.getPageContext(), TbadkApplication.getInst().getSkinType());
            }
            BdListView bdListView = this.f61593f;
            if (bdListView != null && bdListView.getVisibility() == 0 && (aVar = this.j) != null) {
                aVar.notifyDataSetChanged();
            }
            this.f61592e.d();
            SkinManager.setBackgroundColor(this.f61594g, R.color.CAM_X0204);
        }
    }

    public final void g(List<Object> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            if (list != null && list.size() > 0) {
                this.f61593f.setVisibility(0);
                this.j.a(list);
                this.j.notifyDataSetChanged();
                return;
            }
            this.f61593f.setVisibility(8);
        }
    }

    public final boolean h(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, eVar)) == null) {
            if (eVar != null && !StringUtils.isNull(eVar.c())) {
                this.f61592e.setVisibility(0);
                this.f61592e.e(eVar);
                return true;
            }
            this.f61592e.setVisibility(8);
            return false;
        }
        return invokeL.booleanValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f61590c.setVisibility(0);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f61590c.setVisibility(8);
            SkinManager.setBackgroundColor(this.f61589b, R.color.CAM_X0201);
            String string = this.f61588a.getPageContext().getResources().getString(R.string.no_data_text);
            this.f61588a.setNetRefreshViewTopMargin(this.f61596i);
            this.f61588a.showNetRefreshView(this.f61589b, string, false);
        }
    }

    public void k(e eVar, List<b> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048585, this, eVar, list, z) == null) {
            if (list != null && list.size() > 0) {
                c();
                if (h(eVar)) {
                    this.f61593f.removeHeaderView(this.f61594g);
                    this.f61593f.addHeaderView(this.f61594g);
                } else {
                    this.f61593f.removeHeaderView(this.f61594g);
                }
                g(b(list));
                return;
            }
            j();
        }
    }
}
