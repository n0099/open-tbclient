package com.repackage;

import android.graphics.Rect;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AbsListView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.compatible.menukey.MenuKeyUtils;
import com.repackage.dt7;
import com.repackage.nr4;
import com.repackage.xj6;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class fk6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsGameSubPbActivity a;
    public RelativeLayout b;
    public View c;
    public ek6 d;
    public BdTypeListView e;
    public NavigationBar f;
    public FrameLayout g;
    public LinearLayout h;
    public EditText i;
    public TextView j;
    public TextView k;
    public TextView l;
    public ProgressBar m;
    public View n;
    public zj6 o;
    public yj6 p;
    public View.OnClickListener q;
    public ViewTreeObserver.OnGlobalLayoutListener r;
    public bk6 s;
    public List<ro> t;
    public String u;
    public String v;
    public long w;
    public boolean x;
    public boolean y;
    public dt7 z;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fk6 a;

        public a(fk6 fk6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fk6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fk6Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.i.requestFocus();
                mi.w(this.a.a.getPageContext().getPageActivity(), this.a.i);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fk6 a;

        public b(fk6 fk6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fk6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fk6Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.i.requestFocus();
                mi.L(this.a.a.getPageContext().getPageActivity(), this.a.i);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements dt7.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fk6 a;

        public c(fk6 fk6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fk6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fk6Var;
        }

        @Override // com.repackage.dt7.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.repackage.dt7.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.repackage.dt7.a
        public boolean c(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent)) == null) {
                this.a.s(false);
                this.a.N(view2);
                this.a.s(true);
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class d implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fk6 a;

        public d(fk6 fk6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fk6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fk6Var;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i, i2, i3) == null) {
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i) == null) || i == 0) {
                return;
            }
            mi.w(this.a.a.getPageContext().getPageActivity(), this.a.i);
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fk6 a;

        public e(fk6 fk6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fk6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fk6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                fk6 fk6Var = this.a;
                fk6Var.p(fk6Var.i.getText().toString());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements xj6.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fk6 a;

        public f(fk6 fk6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fk6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fk6Var;
        }

        @Override // com.repackage.xj6.a
        public void a(dk6 dk6Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, dk6Var) == null) || dk6Var == null) {
                return;
            }
            this.a.M(dk6Var);
        }

        @Override // com.repackage.xj6.a
        public void b(dk6 dk6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dk6Var) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.a.a.getPageContext().getPageActivity()).createNormalConfig(Long.valueOf(dk6Var.c).longValue(), String.valueOf(this.a.w).equals(dk6Var.c), false)));
            }
        }

        @Override // com.repackage.xj6.a
        public void c(dk6 dk6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dk6Var) == null) {
                if (this.a.o != null) {
                    this.a.o.i();
                }
                if (dk6Var == null) {
                    this.a.t(null);
                    this.a.J();
                    return;
                }
                this.a.t(dk6Var.d);
                this.a.v = dk6Var.c;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fk6 a;

        public g(fk6 fk6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fk6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fk6Var;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Rect rect = new Rect();
                this.a.a.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int r = mi.r(this.a.a.getPageContext().getPageActivity());
                int[] p = mi.p(this.a.a.getPageContext().getPageActivity());
                if (p[1] - rect.bottom > p[1] / 4 && !this.a.x) {
                    this.a.x = true;
                    this.a.F(true);
                } else if (p[1] - rect.height() == r && this.a.x) {
                    this.a.x = false;
                    this.a.F(false);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements nr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nr4 a;
        public final /* synthetic */ dk6 b;
        public final /* synthetic */ fk6 c;

        public h(fk6 fk6Var, nr4 nr4Var, dk6 dk6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fk6Var, nr4Var, dk6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = fk6Var;
            this.a = nr4Var;
            this.b = dk6Var;
        }

        @Override // com.repackage.nr4.e
        public void onClick(nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                this.a.dismiss();
                this.c.r(this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements nr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nr4 a;

        public i(fk6 fk6Var, nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fk6Var, nr4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nr4Var;
        }

        @Override // com.repackage.nr4.e
        public void onClick(nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ fk6 b;

        public j(fk6 fk6Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fk6Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fk6Var;
            this.a = i;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
            }
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
                if (!TextUtils.isEmpty(charSequence)) {
                    this.b.j.setEnabled(true);
                    String charSequence2 = charSequence.toString();
                    if (StringUtils.isNull(charSequence2)) {
                        return;
                    }
                    int b = xd5.b(charSequence2);
                    int i4 = this.a;
                    if (b > i4) {
                        String k = xd5.k(charSequence2, 0, i4 - 1);
                        this.b.i.setText(k);
                        this.b.i.setSelection(this.b.i.getText().length());
                        UtilHelper.showToast(this.b.a.getPageContext().getPageActivity().getApplication(), this.b.a.getPageContext().getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f051c, Integer.valueOf(k.length())));
                        return;
                    }
                    return;
                }
                this.b.J();
                this.b.j.setEnabled(false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ fk6 b;

        public k(fk6 fk6Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fk6Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fk6Var;
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.e.setEnabled(this.a);
            }
        }
    }

    public fk6(FrsGameSubPbActivity frsGameSubPbActivity, View.OnClickListener onClickListener, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsGameSubPbActivity, onClickListener, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.z = new dt7(new c(this));
        this.a = frsGameSubPbActivity;
        this.q = onClickListener;
        this.u = str;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(frsGameSubPbActivity.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0312, (ViewGroup) null);
        this.b = relativeLayout;
        BdTypeListView bdTypeListView = (BdTypeListView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f091575);
        this.e = bdTypeListView;
        bdTypeListView.setOnTouchListener(this.z);
        this.e.setOnScrollListener(new d(this));
        this.d = new ek6(this.a.getPageContext());
        this.c = BdListViewHelper.d(this.a.getActivity(), this.e, BdListViewHelper.HeadType.DEFAULT);
        TextView textView = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091e19);
        this.k = textView;
        textView.setOnClickListener(this.q);
        this.l = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f0915b1);
        this.g = (FrameLayout) this.b.findViewById(R.id.obfuscated_res_0x7f0903e8);
        this.h = (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f091e17);
        this.i = (EditText) this.b.findViewById(R.id.obfuscated_res_0x7f091e18);
        TextView textView2 = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091e1a);
        this.j = textView2;
        textView2.setOnClickListener(new e(this));
        this.m = (ProgressBar) this.b.findViewById(R.id.obfuscated_res_0x7f091976);
        C();
        yj6 yj6Var = new yj6(this.a.getPageContext(), this.e);
        this.p = yj6Var;
        yj6Var.b(new f(this));
        K(140);
        B();
        D(TbadkCoreApplication.getInst().getSkinType());
        this.t = new ArrayList();
        this.w = kg.g(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    public void A(boolean z, String str, dk6 dk6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), str, dk6Var}) == null) {
            if (z) {
                BdToast.d(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f120f), 1).q();
                this.t.remove(dk6Var);
                this.p.c(this.t);
                G(this.y);
                return;
            }
            if (TextUtils.isEmpty(str)) {
                str = this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f120e);
            }
            BdToast.d(this.a.getPageContext().getPageActivity(), str, 1).q();
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.r = new g(this);
            this.a.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.r);
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            NavigationBar navigationBar = (NavigationBar) this.b.findViewById(R.id.obfuscated_res_0x7f0923fd);
            this.f = navigationBar;
            this.n = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            ImageView backImageView = this.f.getBackImageView();
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.n.getLayoutParams();
                int f2 = mi.f(this.a.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070201);
                layoutParams.height = f2;
                layoutParams.width = f2;
                backImageView.setLayoutParams(layoutParams);
            }
            View view2 = this.n;
            if (view2 != null && (view2.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.n.getLayoutParams();
                layoutParams2.width = -2;
                layoutParams2.height = -1;
                this.n.setPadding(mi.f(this.a.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070207), this.n.getPaddingTop(), this.n.getPaddingRight(), this.n.getPaddingBottom());
                this.n.setLayoutParams(layoutParams2);
            }
            if (this.f.getBackImageView() != null) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f.getBackImageView(), R.drawable.obfuscated_res_0x7f080611, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
    }

    public void D(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.a.getLayoutMode().k(i2 == 1);
            this.a.getLayoutMode().j(this.b);
            SkinManager.setBackgroundColor(this.b, R.color.CAM_X0201);
            this.f.onChangeSkinType(this.a.getPageContext(), i2);
            this.d.d(i2);
            SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0110);
            this.k.setAlpha(0.95f);
            SkinManager.setBackgroundResource(this.k, R.drawable.pb_ecomm_comment_bg);
            SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0109);
            SkinManager.setBackgroundResource(this.h, R.drawable.pb_ecomm_comment_bg);
            SkinManager.setViewTextColor(this.i, (int) R.color.CAM_X0106);
            this.i.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
            SkinManager.setViewTextColor(this.j, (int) R.color.game_sub_pb_send_txt_color);
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.r == null) {
            return;
        }
        this.a.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.r);
    }

    public final void F(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            if (z) {
                Rect rect = new Rect();
                this.h.getWindowVisibleDisplayFrame(rect);
                int d2 = (mi.p(this.a.getPageContext().getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? mi.d(this.a.getPageContext().getPageActivity(), 48.0f) : 0);
                FrameLayout frameLayout = this.g;
                frameLayout.scrollTo(frameLayout.getScrollX(), d2);
                return;
            }
            this.g.setScrollY(0);
        }
    }

    public final void G(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            if (ListUtils.isEmpty(this.t)) {
                this.e.setNextPage(null);
                this.l.setVisibility(0);
            } else {
                this.e.setNextPage(this.d);
                this.l.setVisibility(8);
                if (z) {
                    this.d.Q();
                } else {
                    this.d.f();
                }
            }
            L();
        }
    }

    public void H(zj6 zj6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, zj6Var) == null) {
            this.o = zj6Var;
        }
    }

    public void I(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pVar) == null) {
            this.e.setOnSrollToBottomListener(pVar);
        }
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            bk6 bk6Var = this.s;
            this.v = bk6Var != null ? bk6Var.a : null;
        }
    }

    public final void K(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.i.addTextChangedListener(new j(this, i2));
        }
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (!ListUtils.isEmpty(this.t)) {
                this.f.setCenterTextTitle(String.format(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1211), StringHelper.numFormatOver10000(this.t.size())));
            } else {
                this.f.setCenterTextTitle(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0fa6));
            }
        }
    }

    public final void M(dk6 dk6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, dk6Var) == null) {
            nr4 nr4Var = new nr4(this.a.getPageContext().getPageActivity());
            nr4Var.setTitle((String) null);
            nr4Var.setMessageId(R.string.obfuscated_res_0x7f0f0492);
            nr4Var.setCanceledOnTouchOutside(true);
            nr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f04e3, new h(this, nr4Var, dk6Var));
            nr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f04de, new i(this, nr4Var));
            nr4Var.create(this.a.getPageContext()).show();
        }
    }

    public void N(View view2) {
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, view2) == null) || this.c == null || (navigationBar = this.f) == null) {
            return;
        }
        if (navigationBar.isNavigationBarExcludeStatusbarVisible()) {
            this.f.showNavigationBarExcludeStatusbar(false);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.c.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
            } else {
                BdTypeListView bdTypeListView = this.e;
                if (bdTypeListView != null) {
                    bdTypeListView.removeHeaderView(this.c);
                }
            }
            this.f.setVisibility(8);
            return;
        }
        this.f.showNavigationBarExcludeStatusbar(true);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.c.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + mi.f(this.a.getActivity(), R.dimen.obfuscated_res_0x7f070282)));
        } else {
            BdTypeListView bdTypeListView2 = this.e;
            if (bdTypeListView2 != null) {
                bdTypeListView2.x(this.c, 0);
            }
        }
        this.f.setVisibility(0);
    }

    public void O(boolean z, bk6 bk6Var, List<ro> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Boolean.valueOf(z), bk6Var, list}) == null) {
            this.y = z;
            this.s = bk6Var;
            J();
            if (ListUtils.isEmpty(list)) {
                G(z);
                return;
            }
            this.t.clear();
            this.t.addAll(list);
            this.l.setVisibility(8);
            this.e.setNextPage(this.d);
            this.p.c(list);
            q();
            this.k.setVisibility(0);
            this.k.setText(R.string.obfuscated_res_0x7f0f108b);
            G(z);
        }
    }

    public void P(boolean z) {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048591, this, z) == null) || (view2 = this.c) == null || view2.getLayoutParams() == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
        if (z) {
            q();
            layoutParams.height = mi.f(this.a.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070282);
        } else {
            layoutParams.height = mi.f(this.a.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070282) + UtilHelper.getLightStatusBarHeight();
        }
        this.c.setLayoutParams(layoutParams);
    }

    public void Q(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.m.setVisibility(i2);
        }
    }

    public final void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            Q(0);
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_ADD_SUB_COMMENT);
            httpMessage.addParam("user_id", this.w);
            httpMessage.addParam("reply_user_id", this.v);
            httpMessage.addParam("content", str);
            httpMessage.addParam("main_tower_id", this.u);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || this.f.getBackImageView() == null) {
            return;
        }
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f.getBackImageView(), R.drawable.obfuscated_res_0x7f080611, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public final void r(dk6 dk6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, dk6Var) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_DELETE_SUB_COMMENT);
            httpMessage.addParam("user_id", this.w);
            httpMessage.addParam("main_tower_id", dk6Var.b);
            httpMessage.addParam("id", dk6Var.a);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public final void s(boolean z) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048596, this, z) == null) || (bdTypeListView = this.e) == null) {
            return;
        }
        if (!z) {
            bdTypeListView.setEnabled(z);
        } else {
            bdTypeListView.postDelayed(new k(this, z), 10L);
        }
    }

    public void t(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.k.setVisibility(8);
            this.h.setVisibility(0);
            this.i.post(new b(this));
            if (TextUtils.isEmpty(str)) {
                return;
            }
            String format = String.format(this.a.getPageContext().getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f0fb5), str);
            this.i.setText(format);
            this.i.setSelection(format.length());
        }
    }

    public ListView u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.e : (ListView) invokeV.objValue;
    }

    public NavigationBar v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f : (NavigationBar) invokeV.objValue;
    }

    public TextView w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.k : (TextView) invokeV.objValue;
    }

    public View x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.b : (View) invokeV.objValue;
    }

    public View y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.c : (View) invokeV.objValue;
    }

    public void z(boolean z, String str, dk6 dk6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{Boolean.valueOf(z), str, dk6Var}) == null) {
            Q(8);
            if (z && dk6Var != null) {
                BdToast.d(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f120d), 1).q();
                this.i.setText((CharSequence) null);
                this.t.add(dk6Var);
                this.p.c(this.t);
                G(this.y);
                this.i.post(new a(this));
                return;
            }
            if (TextUtils.isEmpty(str)) {
                str = this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f120c);
            }
            BdToast.d(this.a.getPageContext().getPageActivity(), str, 1).q();
        }
    }
}
