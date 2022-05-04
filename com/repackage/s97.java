package com.repackage;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SearchFriendActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList;
import com.baidu.tieba.imMessageCenter.im.friend.InviteFriendListActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.r97;
import java.util.List;
/* loaded from: classes7.dex */
public class s97 extends z8<InviteFriendListActivity> implements r97.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final InviteFriendListActivity a;
    public NavigationBar b;
    public View c;
    public BdListView d;
    public r97 e;
    public NoDataView f;
    public ProgressBar g;
    public View h;
    public InviteFriendCandidateList i;
    public LinearLayout j;
    public Button k;
    public View l;
    public int m;
    public boolean n;
    public TextView o;
    public View p;
    public View q;
    public EditText r;
    public TextView s;
    public TextWatcher t;
    public ImageView u;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s97 a;

        public a(s97 s97Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s97Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s97Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SearchFriendActivityConfig(this.a.a.getPageContext().getPageActivity())));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements InviteFriendCandidateList.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s97 a;

        public b(s97 s97Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s97Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s97Var;
        }

        @Override // com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.b
        public void a(View view2, Object obj) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, view2, obj) == null) || obj == null) {
                return;
            }
            if (obj instanceof TbCheckBox.c) {
                ((TbCheckBox.c) obj).setChecked(false);
            }
            View findViewWithTag = this.a.d.findViewWithTag(obj);
            if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                ((TbCheckBox) findViewWithTag).setChecked(false);
            } else if (obj instanceof iy4) {
                this.a.H((iy4) obj);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s97 a;

        public c(s97 s97Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s97Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s97Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.p != null && this.a.p.getVisibility() == 0) {
                    this.a.B();
                    return;
                }
                oi.w(this.a.a.getPageContext().getPageActivity(), this.a.r);
                this.a.a.finish();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s97 a;

        public d(s97 s97Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s97Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s97Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.o.setVisibility(8);
                this.a.q.setVisibility(8);
                this.a.p.setVisibility(0);
                this.a.r.requestFocus();
                oi.L(this.a.a.getPageContext().getPageActivity(), this.a.r);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s97 a;

        public e(s97 s97Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s97Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s97Var;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String charSequence2String;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || (charSequence2String = ni.charSequence2String(editable, null)) == null) {
                return;
            }
            if (charSequence2String.length() > 0) {
                this.a.s.setVisibility(0);
            } else {
                this.a.s.setVisibility(8);
            }
            this.a.z();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s97 a;

        public f(s97 s97Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s97Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s97Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.r.getText().clear();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s97 a;

        public g(s97 s97Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s97Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s97Var;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                this.a.A();
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class h implements TbCheckBox.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s97 a;

        public h(s97 s97Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s97Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s97Var;
        }

        @Override // com.baidu.tbadk.core.view.TbCheckBox.b
        public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{tbCheckBox, Boolean.valueOf(z), obj}) == null) {
                this.a.A();
                if (obj == null || !(obj instanceof iy4)) {
                    return;
                }
                if (z) {
                    if (this.a.v() <= this.a.i.getItemLength()) {
                        this.a.a.showToast(String.format(this.a.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0937), Integer.valueOf(this.a.m)));
                        tbCheckBox.setChecked(false);
                        ((iy4) obj).setChecked(false);
                        return;
                    }
                    this.a.r((iy4) obj);
                    return;
                }
                this.a.H((iy4) obj);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s97(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inviteFriendListActivity, Boolean.valueOf(z)};
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
        this.m = 0;
        this.a = inviteFriendListActivity;
        this.n = z;
        D();
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            oi.w(this.a.getPageContext().getPageActivity(), this.r);
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            oi.w(this.a.getPageContext().getPageActivity(), this.r);
            this.p.setVisibility(8);
            this.o.setVisibility(0);
            this.q.setVisibility(0);
            this.r.getText().clear();
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            NavigationBar navigationBar = (NavigationBar) this.c.findViewById(R.id.obfuscated_res_0x7f0923ad);
            this.b = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new c(this));
            if (this.n) {
                this.o = this.b.setTitleText(R.string.obfuscated_res_0x7f0f0934);
            } else {
                this.o = this.b.setTitleText(R.string.obfuscated_res_0x7f0f0935);
            }
            View addCustomView = this.b.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d007f, new d(this));
            this.q = addCustomView;
            this.u = (ImageView) addCustomView.findViewById(R.id.obfuscated_res_0x7f091545);
            View addCustomView2 = this.b.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.obfuscated_res_0x7f0d05e7, (View.OnClickListener) null);
            this.p = addCustomView2;
            addCustomView2.setVisibility(8);
            EditText editText = (EditText) this.p.findViewById(R.id.obfuscated_res_0x7f09091a);
            this.r = editText;
            if (editText.getParent() != null) {
                ((View) this.r.getParent()).setFocusable(true);
                ((View) this.r.getParent()).setFocusableInTouchMode(true);
            }
            e eVar = new e(this);
            this.t = eVar;
            this.r.addTextChangedListener(eVar);
            TextView textView = (TextView) this.p.findViewById(R.id.obfuscated_res_0x7f09091b);
            this.s = textView;
            textView.setOnClickListener(new f(this));
        }
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.a.setContentView(R.layout.obfuscated_res_0x7f0d03f3);
            this.c = this.a.findViewById(R.id.obfuscated_res_0x7f091ade);
            C();
            BdListView bdListView = (BdListView) this.c.findViewById(R.id.obfuscated_res_0x7f090ab9);
            this.d = bdListView;
            bdListView.setOnItemClickListener(this.a);
            if (this.n) {
                this.f = NoDataViewFactory.a(this.a.getPageContext().getPageActivity(), this.c, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.a), NoDataViewFactory.e.b(R.string.obfuscated_res_0x7f0f0c3c, R.string.obfuscated_res_0x7f0f0c3d), null);
            } else {
                this.f = NoDataViewFactory.a(this.a.getPageContext().getPageActivity(), this.c, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.GIFT, BdListViewHelper.a), NoDataViewFactory.e.b(R.string.obfuscated_res_0x7f0f0c2b, R.string.obfuscated_res_0x7f0f0c2c), NoDataViewFactory.c.a(new NoDataViewFactory.b(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0617), new a(this))));
            }
            this.g = (ProgressBar) this.c.findViewById(R.id.obfuscated_res_0x7f09191d);
            InviteFriendCandidateList inviteFriendCandidateList = (InviteFriendCandidateList) this.c.findViewById(R.id.obfuscated_res_0x7f0904a4);
            this.i = inviteFriendCandidateList;
            inviteFriendCandidateList.n(new b(this));
            this.j = (LinearLayout) this.c.findViewById(R.id.obfuscated_res_0x7f090f4e);
            this.h = this.c.findViewById(R.id.obfuscated_res_0x7f090f4f);
            if (this.n) {
                this.j.setVisibility(8);
                this.h.setVisibility(8);
            }
            s();
            Button button = (Button) this.c.findViewById(R.id.obfuscated_res_0x7f090467);
            this.k = button;
            button.setOnClickListener(this.a);
            t();
            L();
            I(0);
        }
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            View view2 = this.p;
            return view2 != null && view2.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.r.removeTextChangedListener(this.t);
        }
    }

    public void G(List<iy4> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048582, this, list, z) == null) {
            if (this.e == null) {
                r97 r97Var = new r97(this.a, this.n);
                this.e = r97Var;
                r97Var.f(this);
                this.e.d(new h(this));
                this.d.setAdapter((ListAdapter) this.e);
            }
            if (!z && list.isEmpty()) {
                this.f.setVisibility(0);
                this.d.setVisibility(8);
                if (this.n) {
                    return;
                }
                this.j.setVisibility(8);
                return;
            }
            this.f.setVisibility(8);
            this.d.setVisibility(0);
            this.e.e(list);
            this.e.notifyDataSetChanged();
            if (this.n) {
                return;
            }
            this.j.setVisibility(0);
        }
    }

    public void H(iy4 iy4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, iy4Var) == null) || iy4Var == null) {
            return;
        }
        this.i.l(iy4Var);
        I(this.i.getItemLength());
        M();
    }

    public final void I(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.k.setText(String.format(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0936), Integer.valueOf(i)));
        }
    }

    public void K(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.m = i;
            this.i.setMaxCount(i);
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.d.setOnTouchListener(new g(this));
        }
    }

    public final void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (this.i.getItemLength() > 0) {
                this.k.setEnabled(true);
            } else {
                this.k.setEnabled(false);
            }
        }
    }

    @Override // com.repackage.r97.b
    public void b(View view2, iy4 iy4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048588, this, view2, iy4Var) == null) || iy4Var == null) {
            return;
        }
        this.i.h(iy4Var);
    }

    public void e() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (noDataView = this.f) == null) {
            return;
        }
        noDataView.d(this.a.getPageContext());
    }

    public void f() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (noDataView = this.f) == null) {
            return;
        }
        noDataView.e();
    }

    public void r(iy4 iy4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, iy4Var) == null) || iy4Var == null) {
            return;
        }
        this.i.e(iy4Var);
        I(this.i.getItemLength());
        M();
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            int dimensionPixelSize = this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070275) + this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701be) + this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701be);
            View view2 = new View(this.a.getPageContext().getPageActivity());
            this.l = view2;
            view2.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
            this.l.setEnabled(false);
            this.d.addFooterView(this.l);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            this.a.getLayoutMode().k(skinType == 1);
            this.a.getLayoutMode().j(this.c);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.u, R.drawable.icon_pure_topbar_search44_svg, R.color.CAM_X0105, null);
            this.b.onChangeSkinType(this.a.getPageContext(), skinType);
            this.f.f(this.a.getPageContext(), skinType);
            SkinManager.setBackgroundResource(this.l, R.drawable.invite_friend_list_item_bg_color);
            this.l.setEnabled(false);
        }
    }

    public String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.i.g() : (String) invokeV.objValue;
    }

    public int v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.m : invokeV.intValue;
    }

    public int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.k.getId() : invokeV.intValue;
    }

    public View x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.c : (View) invokeV.objValue;
    }

    public String y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            Editable text = this.r.getText();
            return text != null ? text.toString() : "";
        }
        return (String) invokeV.objValue;
    }

    public final void z() {
        InviteFriendListActivity inviteFriendListActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (inviteFriendListActivity = this.a) == null) {
            return;
        }
        inviteFriendListActivity.refreshWithCurrentData();
    }
}
