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
public class t77 extends z8<StrangerListActivity> {
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
        public final /* synthetic */ t77 a;

        public a(t77 t77Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t77Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t77Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                t77 t77Var = this.a;
                t77Var.y(!t77Var.l);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ StrangerListActivity a;
        public final /* synthetic */ t77 b;

        public b(t77 t77Var, StrangerListActivity strangerListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t77Var, strangerListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = t77Var;
            this.a = strangerListActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.p.setVisibility(0);
                this.b.d.setCenterTextTitle(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0636));
                this.b.q.setVisibility(0);
                this.b.y(false);
                this.b.w(false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t77 a;

        public c(t77 t77Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t77Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t77Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.e.showBlockDialog(true);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t77(StrangerListActivity strangerListActivity) {
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
                super((b9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = false;
        this.j = null;
        this.l = false;
        strangerListActivity.setContentView(R.layout.obfuscated_res_0x7f0d0797);
        this.e = strangerListActivity;
        t(strangerListActivity);
        u(strangerListActivity);
        s(strangerListActivity);
    }

    public StrangerListAdapter j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.c : (StrangerListAdapter) invokeV.objValue;
    }

    public BdListView k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.b : (BdListView) invokeV.objValue;
    }

    public View l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.p : (View) invokeV.objValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.i : invokeV.booleanValue;
    }

    public FrameLayout n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a : (FrameLayout) invokeV.objValue;
    }

    public NavigationBar o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.d : (NavigationBar) invokeV.objValue;
    }

    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.e.getLayoutMode().k(i == 1);
            this.e.getLayoutMode().j(this.f);
            this.d.onChangeSkinType(this.e.getPageContext(), i);
            this.g.c(this.e.getPageContext(), i);
            this.c.notifyDataSetChanged();
            wq4 d = wq4.d(this.q);
            d.n(R.string.J_X01);
            d.f(R.color.CAM_X0209);
            WebPManager.setPureDrawable(this.p, R.drawable.obfuscated_res_0x7f0809e0, R.color.CAM_X0105, null);
            WebPManager.setPureDrawable(this.q, R.drawable.obfuscated_res_0x7f0809da, R.color.CAM_X0105, null);
            NoDataView noDataView = this.h;
            if (noDataView != null) {
                noDataView.f(this.e.getPageContext(), i);
            }
        }
    }

    public NoDataView q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.h : (NoDataView) invokeV.objValue;
    }

    public View r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.q : (View) invokeV.objValue;
    }

    public final void s(StrangerListActivity strangerListActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, strangerListActivity) == null) {
            RelativeLayout relativeLayout = (RelativeLayout) strangerListActivity.findViewById(R.id.obfuscated_res_0x7f092002);
            this.j = relativeLayout;
            this.k = (TextView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f091c55);
            int f = li.f(this.e.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f07026f);
            Drawable pureDrawable = WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080351, SkinManager.getColor(R.color.CAM_X0111), null);
            pureDrawable.setBounds(0, 0, f, f);
            this.k.setText(this.e.getPageContext().getString(R.string.obfuscated_res_0x7f0f10ea));
            this.k.setCompoundDrawables(pureDrawable, null, null, null);
            this.k.setOnClickListener(new a(this));
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) strangerListActivity.findViewById(R.id.obfuscated_res_0x7f090495);
            this.m = tBSpecificationBtn;
            tBSpecificationBtn.setText(getPageContext().getString(R.string.obfuscated_res_0x7f0f0376));
            this.m.setTextSize(R.dimen.T_X07);
            pt4 pt4Var = new pt4();
            pt4Var.p(R.color.CAM_X0105);
            this.m.setConfig(pt4Var);
            this.m.setOnClickListener(new b(this, strangerListActivity));
            TBSpecificationBtn tBSpecificationBtn2 = (TBSpecificationBtn) this.j.findViewById(R.id.obfuscated_res_0x7f090760);
            this.n = tBSpecificationBtn2;
            tBSpecificationBtn2.setText(getPageContext().getString(R.string.obfuscated_res_0x7f0f0635));
            this.n.setTextSize(R.dimen.T_X07);
            pt4 pt4Var2 = new pt4();
            pt4Var2.p(R.color.CAM_X0301);
            this.n.setConfig(pt4Var2);
            this.n.setOnClickListener(new c(this));
        }
    }

    public final void t(StrangerListActivity strangerListActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, strangerListActivity) == null) {
            NavigationBar navigationBar = (NavigationBar) strangerListActivity.findViewById(R.id.obfuscated_res_0x7f0923a2);
            this.d = navigationBar;
            navigationBar.setCenterTextTitle(strangerListActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f0636));
            this.d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.d.showBottomLine();
            wq4.d(this.d.getCenterText()).A(R.string.F_X02);
            ImageView imageView = (ImageView) this.d.getCenterImgBox();
            this.q = imageView;
            imageView.setOnClickListener(this.e);
            this.q.setVisibility(0);
            int f = li.f(strangerListActivity, R.dimen.L_X05);
            this.q.setPadding(f, f, f, f);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.q.getLayoutParams();
            layoutParams.leftMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003);
            layoutParams.width = li.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0702c3);
            layoutParams.height = li.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0702c3);
            this.q.setLayoutParams(layoutParams);
            TextView centerText = this.d.getCenterText();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) centerText.getLayoutParams();
            layoutParams2.rightMargin = 0;
            centerText.setLayoutParams(layoutParams2);
            ImageView imageView2 = (ImageView) this.d.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d0796, this.e);
            this.p = imageView2;
            WebPManager.setPureDrawable(imageView2, R.drawable.obfuscated_res_0x7f0809e0, R.color.CAM_X0105, null);
            WebPManager.setPureDrawable(this.q, R.drawable.obfuscated_res_0x7f0809da, R.color.CAM_X0105, null);
            LinearLayout linearLayout = (LinearLayout) strangerListActivity.findViewById(R.id.obfuscated_res_0x7f091adb);
            this.f = linearLayout;
            this.g = (NoNetworkView) linearLayout.findViewById(R.id.obfuscated_res_0x7f09156c);
        }
    }

    public final void u(StrangerListActivity strangerListActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, strangerListActivity) == null) {
            this.a = (FrameLayout) strangerListActivity.findViewById(R.id.obfuscated_res_0x7f09142b);
            BdListView bdListView = (BdListView) strangerListActivity.findViewById(R.id.obfuscated_res_0x7f09142a);
            this.b = bdListView;
            bdListView.setOnItemClickListener(strangerListActivity);
            this.b.setOnItemLongClickListener(strangerListActivity);
            StrangerListAdapter strangerListAdapter = new StrangerListAdapter(strangerListActivity);
            this.c = strangerListAdapter;
            this.b.setAdapter((ListAdapter) strangerListAdapter);
            this.h = NoDataViewFactory.a(strangerListActivity.getPageContext().getPageActivity(), this.f, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.CREATE), NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f0c63), null);
        }
    }

    public void v(List<ImMessageCenterShowItemData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, list) == null) {
            this.c.r(list);
            if (list == null || list.size() > 0) {
                return;
            }
            this.o.setVisibility(8);
        }
    }

    public void w(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            if (z) {
                this.j.setVisibility(0);
                this.c.s(true);
                this.c.notifyDataSetChanged();
                if (this.e.hasSelectedData()) {
                    x(true);
                } else {
                    x(false);
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

    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            if (z) {
                this.n.setEnabled(true);
            } else {
                this.n.setEnabled(false);
            }
        }
    }

    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            int f = li.f(this.e.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f07026f);
            if (z) {
                Drawable pureDrawable = WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080353, SkinManager.getColor(R.color.CAM_X0304), null);
                pureDrawable.setBounds(0, 0, f, f);
                this.k.setText(this.e.getPageContext().getString(R.string.obfuscated_res_0x7f0f10ea));
                this.k.setCompoundDrawables(pureDrawable, null, null, null);
                x(true);
                this.l = true;
                this.e.updateEditStatus(true);
                return;
            }
            Drawable pureDrawable2 = WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080351, SkinManager.getColor(R.color.CAM_X0111), null);
            pureDrawable2.setBounds(0, 0, f, f);
            this.k.setText(this.e.getPageContext().getString(R.string.obfuscated_res_0x7f0f10ea));
            this.k.setCompoundDrawables(pureDrawable2, null, null, null);
            x(false);
            this.l = false;
            this.e.updateEditStatus(false);
        }
    }
}
