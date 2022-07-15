package com.repackage;

import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.im.forum.detail.BarEmotionResponseMessage;
import com.baidu.tieba.im.forum.detail.ForumDetailActivity;
import com.baidu.tieba.im.forum.detail.ItemEmotionView;
import com.baidu.tieba.im.forum.detail.ItemFootNavView;
import com.baidu.tieba.im.forum.detail.ItemHeaderView;
import com.baidu.tieba.im.forum.detail.ItemHotThreadView;
import com.baidu.tieba.im.forum.detail.ItemInfoView;
import com.baidu.tieba.im.forum.detail.ItemMsgManage;
import com.baidu.tieba.view.CustomScrollView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.cr4;
import java.util.List;
import tbclient.GetForumDetail.BzApplySwitch;
import tbclient.GetForumDetail.ManagerElectionTab;
import tbclient.ManagerApplyInfo;
import tbclient.PriManagerApplyInfo;
import tbclient.RecommendForumInfo;
import tbclient.SimpleThreadInfo;
/* loaded from: classes6.dex */
public class n67 extends b9<ForumDetailActivity> {
    public static /* synthetic */ Interceptable $ic;
    public static final int p;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumDetailActivity a;
    public View b;
    public LinearLayout c;
    public NavigationBar d;
    public NoNetworkView e;
    public NoDataView f;
    public CustomScrollView g;
    public ItemHeaderView h;
    public ItemInfoView i;
    public ItemMsgManage j;
    public ItemEmotionView k;
    public ItemHotThreadView l;
    public ItemFootNavView m;
    public cr4 n;
    public View.OnClickListener o;

    /* loaded from: classes6.dex */
    public class a implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n67 a;

        public a(n67 n67Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n67Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n67Var;
        }

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                this.a.n.dismiss();
                this.a.a.D1();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n67 a;

        public b(n67 n67Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n67Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n67Var;
        }

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                this.a.n.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n67 a;

        public c(n67 n67Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n67Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n67Var;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    this.a.m.o(false);
                } else if (action == 1) {
                    this.a.m.o(true);
                } else if (action == 2) {
                    this.a.m.o(false);
                }
                return false;
            }
            return invokeLL.booleanValue;
        }

        public /* synthetic */ c(n67 n67Var, a aVar) {
            this(n67Var);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755517470, "Lcom/repackage/n67;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755517470, "Lcom/repackage/n67;");
                return;
            }
        }
        p = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds364);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n67(ForumDetailActivity forumDetailActivity) {
        super(forumDetailActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {forumDetailActivity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((d9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = forumDetailActivity;
        n();
    }

    public NoNetworkView k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.e : (NoNetworkView) invokeV.objValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a.hideLoadingView(this.b);
        }
    }

    public void m() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (noDataView = this.f) == null) {
            return;
        }
        noDataView.setVisibility(8);
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.c = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f091c7b);
            TextView textView = new TextView(this.a.getActivity());
            textView.setLayoutParams(new LinearLayout.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
            this.c.addView(textView, 0);
            NavigationBar navigationBar = (NavigationBar) this.a.findViewById(R.id.obfuscated_res_0x7f092437);
            this.d = navigationBar;
            navigationBar.setCenterTextTitle(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0664));
            this.d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.d.showBottomLine();
            this.e = (NoNetworkView) this.a.findViewById(R.id.obfuscated_res_0x7f091607);
            CustomScrollView customScrollView = (CustomScrollView) this.a.findViewById(R.id.obfuscated_res_0x7f091c7a);
            this.g = customScrollView;
            customScrollView.setOnTouchListener(new c(this, null));
            this.h = (ItemHeaderView) this.a.findViewById(R.id.obfuscated_res_0x7f090f43);
            this.i = (ItemInfoView) this.a.findViewById(R.id.obfuscated_res_0x7f090f49);
            this.j = (ItemMsgManage) this.a.findViewById(R.id.obfuscated_res_0x7f090f51);
            this.k = (ItemEmotionView) this.a.findViewById(R.id.obfuscated_res_0x7f090f37);
            this.l = (ItemHotThreadView) this.a.findViewById(R.id.obfuscated_res_0x7f090f46);
            ItemFootNavView itemFootNavView = (ItemFootNavView) this.a.findViewById(R.id.obfuscated_res_0x7f090f38);
            this.m = itemFootNavView;
            itemFootNavView.setClickable(true);
            this.b = this.a.findViewById(R.id.obfuscated_res_0x7f091b70);
            this.j.setMsgOnClickListener(this.a);
            this.k.setEmotionOnClickListener(this.a);
            this.j.setSwitchChangeListener(this.a);
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.m.n(this.a);
        }
    }

    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.a.getLayoutMode().k(i == 1);
            this.a.getLayoutMode().j(this.b);
            this.d.onChangeSkinType(getPageContext(), i);
            this.e.d(getPageContext(), i);
            this.h.b(this.a, i);
            this.i.b(this.a, i);
            this.j.b(this.a, i);
            this.l.d(this.a, i);
            this.m.m(this.a, i);
        }
    }

    public void p(BarEmotionResponseMessage.ForumEmotionData forumEmotionData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, forumEmotionData) == null) {
            this.k.setEmotionData(forumEmotionData);
        }
    }

    public void q(RecommendForumInfo recommendForumInfo, boolean z, boolean z2, ManagerApplyInfo managerApplyInfo, PriManagerApplyInfo priManagerApplyInfo, ManagerElectionTab managerElectionTab, BzApplySwitch bzApplySwitch) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{recommendForumInfo, Boolean.valueOf(z), Boolean.valueOf(z2), managerApplyInfo, priManagerApplyInfo, managerElectionTab, bzApplySwitch}) == null) {
            this.h.setData(recommendForumInfo);
            this.i.setData(recommendForumInfo);
            this.j.setData(recommendForumInfo, z, z2, managerApplyInfo, priManagerApplyInfo, managerElectionTab);
            this.m.setData(recommendForumInfo, this.a);
        }
    }

    public void r(RecommendForumInfo recommendForumInfo, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, recommendForumInfo, z) == null) {
            this.j.setShowState(recommendForumInfo, z);
        }
    }

    public void s(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, onClickListener) == null) {
            this.o = onClickListener;
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.j.setSwitch(z);
        }
    }

    public void u(List<SimpleThreadInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, list) == null) {
            this.l.setData(list);
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (this.n == null) {
                cr4 cr4Var = new cr4(this.a.getPageContext().getPageActivity());
                this.n = cr4Var;
                cr4Var.setMessageId(R.string.obfuscated_res_0x7f0f0cc5);
                this.n.setPositiveButton(R.string.obfuscated_res_0x7f0f0262, new a(this));
                this.n.setNegativeButton(R.string.obfuscated_res_0x7f0f036a, new b(this));
            }
            this.n.create(getPageContext()).show();
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.a.showLoadingView(this.b);
        }
    }

    public void x(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            if (this.f == null) {
                NoDataView a2 = NoDataViewFactory.a(this.a.getPageContext().getPageActivity(), this.c, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NETERROR, p), NoDataViewFactory.e.d(null, this.a.getResources().getString(i)), null);
                this.f = a2;
                a2.setOnClickListener(this.o);
            }
            this.f.setTextOption(NoDataViewFactory.e.d(null, this.a.getResources().getString(i)));
            this.f.f(this.a.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.f.setVisibility(0);
        }
    }

    public void y(RecommendForumInfo recommendForumInfo, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048591, this, recommendForumInfo, z) == null) {
            this.m.r(z);
            this.j.setShowState(recommendForumInfo, z);
        }
    }
}
