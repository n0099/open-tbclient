package com.repackage;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.LocalChannelTopicListActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.suspended.SuspendedActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.topic.local.LocalChannelTopicDecoration;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class w07 implements x95 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public LinearLayout b;
    public NavigationBar c;
    public View d;
    public EMTextView e;
    public EMTextView f;
    public RelativeLayout g;
    public BdTypeRecyclerView h;
    public x45 i;
    public y45 j;
    public View.OnClickListener k;
    public boolean l;

    /* loaded from: classes7.dex */
    public class a implements bp {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w07 a;

        public a(w07 w07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w07Var;
        }

        @Override // com.repackage.bp
        public void b(View view2, ro roVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, roVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) || this.a.a == null || this.a.a.getPageActivity() == null || !(roVar instanceof y07)) {
                return;
            }
            this.a.r();
            String str = ((y07) roVar).a;
            if (!this.a.l) {
                if (this.a.a.getPageActivity() instanceof SuspendedActivity) {
                    ((SuspendedActivity) this.a.a.getPageActivity()).setForceFinishWithoutAnim(true);
                }
                this.a.a.getPageActivity().finish();
                if (this.a.a == null || this.a.a.getPageActivity() == null) {
                    return;
                }
                WriteActivityConfig.newInstance(this.a.a.getPageActivity()).setType(9).setFrom("main_tab").setCallFrom("2").setIsPostLocalChannelDynamic(true).setLocalChannelTopic(str).send();
                return;
            }
            Intent intent = new Intent();
            intent.putExtra(LocalChannelTopicListActivityConfig.KEY_RESPONSE_TOPIC, str);
            this.a.a.getPageActivity().setResult(-1, intent);
            this.a.a.getPageActivity().finish();
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z07 a;
        public final /* synthetic */ w07 b;

        public b(w07 w07Var, z07 z07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w07Var, z07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = w07Var;
            this.a = z07Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.b.a == null) {
                return;
            }
            this.b.q();
            this.b.j(this.a);
        }
    }

    public w07(TbPageContext tbPageContext, LinearLayout linearLayout, NavigationBar navigationBar, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, linearLayout, navigationBar, onClickListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        this.b = linearLayout;
        this.c = navigationBar;
        this.k = onClickListener;
        i();
        h();
    }

    public final void f() {
        x45 x45Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.g == null || (x45Var = this.i) == null || !x45Var.isViewAttached()) {
            return;
        }
        this.i.dettachView(this.g);
    }

    public final void g() {
        y45 y45Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.g == null || (y45Var = this.j) == null || !y45Var.isViewAttached()) {
            return;
        }
        this.j.dettachView(this.g);
    }

    @Override // com.repackage.y95
    public Intent getResultIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (Intent) invokeV.objValue;
    }

    public final void h() {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (tbPageContext = this.a) == null || this.b == null) {
            return;
        }
        LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d048f, (ViewGroup) this.b, true);
        this.g = (RelativeLayout) this.b.findViewById(R.id.obfuscated_res_0x7f091321);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.b.findViewById(R.id.obfuscated_res_0x7f091a6a);
        this.h = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.a.getPageActivity()));
        this.h.setFadingEdgeLength(0);
        this.h.setOverScrollMode(2);
        this.h.addItemDecoration(new LocalChannelTopicDecoration());
        ArrayList arrayList = new ArrayList();
        v07 v07Var = new v07(this.a, y07.e);
        v07Var.V(new a(this));
        arrayList.add(v07Var);
        this.h.a(arrayList);
        this.h.setVisibility(8);
        g();
        n();
    }

    public final void i() {
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.a == null || (navigationBar = this.c) == null) {
            return;
        }
        navigationBar.setFixedHeight(false);
        if (this.c.getContentLayout() != null && this.c.getContentLayout().getLayoutParams() != null) {
            this.c.getContentLayout().getLayoutParams().height = mi.f(this.a.getPageActivity(), R.dimen.tbds161);
            this.c.getContentLayout().requestLayout();
        }
        this.d = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0490, this.c.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER), true);
        this.e = (EMTextView) this.c.findViewById(R.id.obfuscated_res_0x7f091320);
        this.f = (EMTextView) this.c.findViewById(R.id.obfuscated_res_0x7f09131f);
    }

    @Override // com.repackage.y95
    public boolean isOnViewCancel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.y95
    public boolean isOnViewTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.h;
            if (bdTypeRecyclerView == null || bdTypeRecyclerView.getVisibility() != 0) {
                return true;
            }
            return this.h.getFirstVisiblePosition() == 0 && this.h.getChildAt(0) != null && this.h.getChildAt(0).getTop() == 0;
        }
        return invokeV.booleanValue;
    }

    public final void j(z07 z07Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, z07Var) == null) {
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.a.getPageActivity());
            pbActivityConfig.setThreadId(z07Var.a.b);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
        }
    }

    public void k(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, intent) == null) || intent == null) {
            return;
        }
        this.l = intent.getBooleanExtra(LocalChannelTopicListActivityConfig.KEY_IS_RESPONSE_FOR_TOPIC, false);
        s();
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            o(this.a.getString(R.string.obfuscated_res_0x7f0f09ec), true);
            f();
            this.h.setVisibility(8);
        }
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.h;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.setVisibility(8);
            }
            f();
            o(str, false);
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.a == null || this.g == null) {
            return;
        }
        x45 x45Var = this.i;
        if (x45Var == null || !x45Var.isViewAttached()) {
            if (this.i == null) {
                this.i = new x45(this.a.getPageActivity());
            }
            this.i.attachView(this.g);
        }
    }

    public final void o(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048588, this, str, z) == null) || this.a == null || this.g == null) {
            return;
        }
        y45 y45Var = this.j;
        if (y45Var == null || !y45Var.isViewAttached()) {
            if (this.j == null) {
                this.j = new y45(this.a.getPageActivity(), this.k);
            }
            if (z) {
                this.j.i(R.drawable.new_pic_emotion_07);
                this.j.e();
            } else {
                this.j.i(R.drawable.new_pic_emotion_08);
                this.j.p();
            }
            this.j.o(str);
            this.j.attachView(this.g);
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
        }
    }

    @Override // com.repackage.y95
    public void onViewChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048590, this, i) == null) || this.a == null) {
            return;
        }
        SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0108);
        Drawable pureDrawable = WebPManager.getPureDrawable(R.drawable.icon_pure_arrow12_right_n, SkinManager.getColor(R.color.CAM_X0108), null);
        if (this.f != null && pureDrawable != null) {
            int f = mi.f(this.a.getPageActivity(), R.dimen.tbds31);
            pureDrawable.setBounds(0, 0, f, f);
            this.f.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, pureDrawable, (Drawable) null);
        }
        x45 x45Var = this.i;
        if (x45Var != null) {
            x45Var.m(i);
        }
        y45 y45Var = this.j;
        if (y45Var != null) {
            y45Var.onChangeSkinType();
        }
        BdTypeRecyclerView bdTypeRecyclerView = this.h;
        if (bdTypeRecyclerView == null || bdTypeRecyclerView.getAdapter() == null) {
            return;
        }
        this.h.getAdapter().notifyDataSetChanged();
    }

    public void p(z07 z07Var) {
        EMTextView eMTextView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, z07Var) == null) {
            if (z07Var == null) {
                l();
            } else if (this.d == null || (eMTextView = this.f) == null || this.h == null) {
            } else {
                x07 x07Var = z07Var.a;
                if (x07Var != null) {
                    eMTextView.setText(x07Var.a);
                    this.f.setVisibility(0);
                    this.d.setOnClickListener(new b(this, z07Var));
                }
                if (ListUtils.isEmpty(z07Var.b)) {
                    l();
                    return;
                }
                f();
                g();
                this.h.setVisibility(0);
                this.h.setData(z07Var.b);
            }
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            TiebaStatic.log(new StatisticItem("c14524"));
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            TiebaStatic.log(new StatisticItem("c14523"));
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            TiebaStatic.log(new StatisticItem("c14522").param("obj_source", this.l ? 2 : 1));
        }
    }

    @Override // com.repackage.x95
    public void u(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048595, this, f) == null) {
            this.h.setPressed(false);
        }
    }
}
