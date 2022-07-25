package com.repackage;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity;
import com.baidu.tieba.imMessageCenter.im.stranger.StrangerListAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class w97 extends b9<StrangerListActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrameLayout a;
    public BdListView b;
    public StrangerListAdapter c;
    public NavigationBar d;
    public StrangerListActivity e;
    public ViewGroup f;
    public NoNetworkView g;
    public NoDataView h;
    public boolean i;
    public RelativeLayout j;
    public TextView k;
    public boolean l;
    public TBSpecificationBtn m;
    public TBSpecificationBtn n;
    public TextView o;
    public ImageView p;
    public ImageView q;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w97 a;

        public a(w97 w97Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w97Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w97Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                w97 w97Var = this.a;
                w97Var.A(!w97Var.l);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ StrangerListActivity a;
        public final /* synthetic */ w97 b;

        public b(w97 w97Var, StrangerListActivity strangerListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w97Var, strangerListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = w97Var;
            this.a = strangerListActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.p.setVisibility(0);
                this.b.d.setCenterTextTitle(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0630));
                this.b.q.setVisibility(0);
                this.b.A(false);
                this.b.y(false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w97 a;

        public c(w97 w97Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w97Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w97Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.e.b2(true);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w97(StrangerListActivity strangerListActivity) {
        super(strangerListActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {strangerListActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((d9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = false;
        this.j = null;
        this.l = false;
        strangerListActivity.setContentView(R.layout.obfuscated_res_0x7f0d07be);
        this.e = strangerListActivity;
        v(strangerListActivity);
        w(strangerListActivity);
        u(strangerListActivity);
    }

    public void A(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            int f = pi.f(this.e.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f07026f);
            if (z) {
                Drawable pureDrawable = WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080353, SkinManager.getColor(R.color.CAM_X0304), null);
                pureDrawable.setBounds(0, 0, f, f);
                this.k.setText(this.e.getPageContext().getString(R.string.obfuscated_res_0x7f0f10a8));
                this.k.setCompoundDrawables(pureDrawable, null, null, null);
                z(true);
                this.l = true;
                this.e.d2(true);
                return;
            }
            Drawable pureDrawable2 = WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080351, SkinManager.getColor(R.color.CAM_X0111), null);
            pureDrawable2.setBounds(0, 0, f, f);
            this.k.setText(this.e.getPageContext().getString(R.string.obfuscated_res_0x7f0f10a8));
            this.k.setCompoundDrawables(pureDrawable2, null, null, null);
            z(false);
            this.l = false;
            this.e.d2(false);
        }
    }

    public StrangerListAdapter m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.c : (StrangerListAdapter) invokeV.objValue;
    }

    public BdListView n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.b : (BdListView) invokeV.objValue;
    }

    public View o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.p : (View) invokeV.objValue;
    }

    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.e.getLayoutMode().k(i == 1);
            this.e.getLayoutMode().j(this.f);
            this.d.onChangeSkinType(this.e.getPageContext(), i);
            this.g.d(this.e.getPageContext(), i);
            this.c.notifyDataSetChanged();
            vr4 d = vr4.d(this.q);
            d.n(R.string.J_X01);
            d.f(R.color.CAM_X0209);
            WebPManager.setPureDrawable(this.p, R.drawable.obfuscated_res_0x7f0809d4, R.color.CAM_X0105, null);
            WebPManager.setPureDrawable(this.q, R.drawable.obfuscated_res_0x7f0809ce, R.color.CAM_X0105, null);
            NoDataView noDataView = this.h;
            if (noDataView != null) {
                noDataView.f(this.e.getPageContext(), i);
            }
        }
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.i : invokeV.booleanValue;
    }

    public FrameLayout q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.a : (FrameLayout) invokeV.objValue;
    }

    public NavigationBar r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.d : (NavigationBar) invokeV.objValue;
    }

    public NoDataView s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.h : (NoDataView) invokeV.objValue;
    }

    public View t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.q : (View) invokeV.objValue;
    }

    public final void u(StrangerListActivity strangerListActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, strangerListActivity) == null) {
            RelativeLayout relativeLayout = (RelativeLayout) strangerListActivity.findViewById(R.id.obfuscated_res_0x7f0920aa);
            this.j = relativeLayout;
            this.k = (TextView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f091cf8);
            int f = pi.f(this.e.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f07026f);
            Drawable pureDrawable = WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080351, SkinManager.getColor(R.color.CAM_X0111), null);
            pureDrawable.setBounds(0, 0, f, f);
            this.k.setText(this.e.getPageContext().getString(R.string.obfuscated_res_0x7f0f10a8));
            this.k.setCompoundDrawables(pureDrawable, null, null, null);
            this.k.setOnClickListener(new a(this));
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) strangerListActivity.findViewById(R.id.obfuscated_res_0x7f090477);
            this.m = tBSpecificationBtn;
            tBSpecificationBtn.setText(getPageContext().getString(R.string.obfuscated_res_0x7f0f036a));
            this.m.setTextSize(R.dimen.T_X07);
            wu4 wu4Var = new wu4();
            wu4Var.p(R.color.CAM_X0105);
            this.m.setConfig(wu4Var);
            this.m.setOnClickListener(new b(this, strangerListActivity));
            TBSpecificationBtn tBSpecificationBtn2 = (TBSpecificationBtn) this.j.findViewById(R.id.obfuscated_res_0x7f090751);
            this.n = tBSpecificationBtn2;
            tBSpecificationBtn2.setText(getPageContext().getString(R.string.obfuscated_res_0x7f0f062f));
            this.n.setTextSize(R.dimen.T_X07);
            wu4 wu4Var2 = new wu4();
            wu4Var2.p(R.color.CAM_X0301);
            this.n.setConfig(wu4Var2);
            this.n.setOnClickListener(new c(this));
        }
    }

    public final void v(StrangerListActivity strangerListActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, strangerListActivity) == null) {
            NavigationBar navigationBar = (NavigationBar) strangerListActivity.findViewById(R.id.obfuscated_res_0x7f092439);
            this.d = navigationBar;
            navigationBar.setCenterTextTitle(strangerListActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f0630));
            this.d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.d.showBottomLine();
            vr4.d(this.d.getCenterText()).A(R.string.F_X02);
            ImageView imageView = (ImageView) this.d.getCenterImgBox();
            this.q = imageView;
            imageView.setOnClickListener(this.e);
            this.q.setVisibility(0);
            int f = pi.f(strangerListActivity, R.dimen.L_X05);
            this.q.setPadding(f, f, f, f);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.q.getLayoutParams();
            layoutParams.leftMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003);
            layoutParams.width = pi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0702c0);
            layoutParams.height = pi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0702c0);
            this.q.setLayoutParams(layoutParams);
            TextView centerText = this.d.getCenterText();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) centerText.getLayoutParams();
            layoutParams2.rightMargin = 0;
            centerText.setLayoutParams(layoutParams2);
            ImageView imageView2 = (ImageView) this.d.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d07bd, this.e);
            this.p = imageView2;
            WebPManager.setPureDrawable(imageView2, R.drawable.obfuscated_res_0x7f0809d4, R.color.CAM_X0105, null);
            WebPManager.setPureDrawable(this.q, R.drawable.obfuscated_res_0x7f0809ce, R.color.CAM_X0105, null);
            LinearLayout linearLayout = (LinearLayout) strangerListActivity.findViewById(R.id.obfuscated_res_0x7f091b4c);
            this.f = linearLayout;
            this.g = (NoNetworkView) linearLayout.findViewById(R.id.obfuscated_res_0x7f0915e2);
        }
    }

    public final void w(StrangerListActivity strangerListActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, strangerListActivity) == null) {
            this.a = (FrameLayout) strangerListActivity.findViewById(R.id.obfuscated_res_0x7f0914a0);
            BdListView bdListView = (BdListView) strangerListActivity.findViewById(R.id.obfuscated_res_0x7f09149f);
            this.b = bdListView;
            bdListView.setOnItemClickListener(strangerListActivity);
            this.b.setOnItemLongClickListener(strangerListActivity);
            StrangerListAdapter strangerListAdapter = new StrangerListAdapter(strangerListActivity);
            this.c = strangerListAdapter;
            this.b.setAdapter((ListAdapter) strangerListAdapter);
            this.h = NoDataViewFactory.a(strangerListActivity.getPageContext().getPageActivity(), this.f, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.CREATE), NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f0c46), null);
        }
    }

    public void x(List<ImMessageCenterShowItemData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, list) == null) {
            this.c.r(list);
            if (list == null || list.size() > 0) {
                return;
            }
            this.o.setVisibility(8);
        }
    }

    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            if (z) {
                this.j.setVisibility(0);
                this.c.s(true);
                this.c.notifyDataSetChanged();
                if (this.e.S1()) {
                    z(true);
                } else {
                    z(false);
                }
                this.i = true;
                return;
            }
            this.j.setVisibility(8);
            this.c.s(false);
            this.c.notifyDataSetChanged();
            this.i = false;
        }
    }

    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            if (z) {
                this.n.setEnabled(true);
            } else {
                this.n.setEnabled(false);
            }
        }
    }
}
