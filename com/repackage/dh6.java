package com.repackage;

import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumRulesShowActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.ForumRuleBaseData;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupEditText;
import com.baidu.tbadk.core.view.spanGroup.TbLinkSpanGroup;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.forumRule.ForumRulesEditActivity;
import com.baidu.tieba.pb.pb.main.view.EditorScrollView;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.repackage.eh6;
import com.repackage.oq4;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/* loaded from: classes5.dex */
public class dh6 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView A;
    public TextView B;
    public zx5 C;
    public EditorScrollView D;
    public List<eh6> E;
    public ForumRuleBaseData F;
    public BdTopToast G;
    public boolean H;
    public int I;
    public mq4 J;
    public oq4 K;
    public boolean L;
    public Runnable M;
    public oq4.d N;
    public oq4.d O;
    public final TbPageContext<?> a;
    public final String b;
    public final String c;
    public final String d;
    public vg6 e;
    public ForumRulesEditActivity f;
    public View g;
    public View h;
    public View i;
    public RelativeLayout j;
    public RelativeLayout k;
    public ImageView l;
    public ImageView m;
    public ImageView n;
    public EMTextView o;
    public EMTextView p;
    public EMTextView q;
    public EMTextView r;
    public EMTextView s;
    public EMTextView t;
    public EditText u;
    public EditText v;
    public LinearLayout w;
    public LinearLayout x;
    public NavigationBar y;
    public TextView z;

    /* loaded from: classes5.dex */
    public class a implements oq4.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dh6 a;

        public a(dh6 dh6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dh6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dh6Var;
        }

        @Override // com.repackage.oq4.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.C();
                if (this.a.f != null) {
                    this.a.f.finish();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View.OnClickListener a;

        public b(dh6 dh6Var, View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dh6Var, onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.onClick(view2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dh6 a;

        public c(dh6 dh6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dh6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dh6Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.t(true, null, false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements ViewTreeObserver.OnScrollChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dh6 a;

        public d(dh6 dh6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dh6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dh6Var;
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.D();
                li.x(this.a.a.getPageActivity(), this.a.u);
                li.x(this.a.a.getPageActivity(), this.a.v);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dh6 a;

        public e(dh6 dh6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dh6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dh6Var;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                int length = editable.toString().length();
                this.a.V(length);
                dh6.P(this.a.q, length, 50);
                this.a.K();
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
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dh6 a;

        /* loaded from: classes5.dex */
        public class a implements View.OnTouchListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                    if (motionEvent.getAction() == 0) {
                        view2.getParent().requestDisallowInterceptTouchEvent(true);
                    } else if (motionEvent.getAction() == 1) {
                        view2.getParent().requestDisallowInterceptTouchEvent(false);
                    } else if (motionEvent.getAction() == 3) {
                        view2.getParent().requestDisallowInterceptTouchEvent(false);
                    }
                    return false;
                }
                return invokeLL.booleanValue;
            }
        }

        public f(dh6 dh6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dh6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dh6Var;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                int length = editable.toString().length();
                this.a.u(length);
                dh6.P(this.a.s, length, 500);
                this.a.K();
                if (this.a.v.getLineCount() > 6) {
                    this.a.v.setOnTouchListener(new a(this));
                } else {
                    this.a.v.setOnTouchListener(null);
                }
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
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eh6 a;
        public final /* synthetic */ dh6 b;

        /* loaded from: classes5.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g a;

            public a(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = gVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    g gVar = this.a;
                    gVar.b.M(gVar.a);
                }
            }
        }

        public g(dh6 dh6Var, eh6 eh6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dh6Var, eh6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dh6Var;
            this.a = eh6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.k().getText().toString().length() != 0 || this.a.l().getText().toString().length() != 0) {
                    this.b.T(new a(this));
                } else {
                    this.b.M(this.a);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements eh6.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dh6 a;

        public h(dh6 dh6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dh6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dh6Var;
        }

        @Override // com.repackage.eh6.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.K();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dh6 a;

        public i(dh6 dh6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dh6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dh6Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.D.fullScroll(130);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements oq4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dh6 a;

        public j(dh6 dh6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dh6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dh6Var;
        }

        @Override // com.repackage.oq4.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.C();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k implements oq4.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dh6 a;

        public k(dh6 dh6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dh6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dh6Var;
        }

        @Override // com.repackage.oq4.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.y();
            }
        }
    }

    public dh6(TbPageContext<?> tbPageContext, vg6 vg6Var, View view2, String str, String str2, String str3, String str4, int i2, ForumRulesEditActivity forumRulesEditActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, vg6Var, view2, str, str2, str3, str4, Integer.valueOf(i2), forumRulesEditActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.E = new ArrayList();
        this.F = new ForumRuleBaseData();
        this.H = true;
        this.L = false;
        this.M = new c(this);
        this.N = new k(this);
        this.O = new a(this);
        this.a = tbPageContext;
        this.b = str;
        this.c = str2;
        this.d = str4;
        this.I = i2;
        this.f = forumRulesEditActivity;
        this.e = vg6Var;
        E(view2, str3);
    }

    public static void P(TextView textView, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65537, null, textView, i2, i3) == null) {
            textView.setText(i2 + "/" + i3);
            if (i2 > i3) {
                wq4.d(textView).v(R.color.CAM_X0301);
            } else {
                wq4.d(textView).v(R.color.CAM_X0111);
            }
        }
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            String format = String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0694), this.c, ki.getDateStringMouth(new Date()));
            this.u.setText(format);
            this.u.setSelection(format.length());
            ViewGroup.LayoutParams layoutParams = this.u.getLayoutParams();
            layoutParams.width = -1;
            this.u.setLayoutParams(layoutParams);
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.E.size() <= 0 || this.x == null) {
            return;
        }
        eh6 eh6Var = this.E.get(0);
        this.x.removeView(eh6Var.m());
        this.E.remove(eh6Var);
        J();
        L();
    }

    public void C() {
        mq4 mq4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (mq4Var = this.J) != null && mq4Var.isShowing()) {
            this.J.dismiss();
        }
    }

    public final void D() {
        zx5 zx5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (zx5Var = this.C) == null) {
            return;
        }
        zx5Var.I();
    }

    public final void E(View view2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, view2, str) == null) {
            this.g = view2;
            this.y = (NavigationBar) view2.findViewById(R.id.obfuscated_res_0x7f0914d8);
            this.w = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091aed);
            this.D = (EditorScrollView) view2.findViewById(R.id.obfuscated_res_0x7f091c00);
            this.l = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090a0f);
            this.j = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090a77);
            this.m = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090a0e);
            this.o = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f090a10);
            this.h = view2.findViewById(R.id.obfuscated_res_0x7f090a76);
            this.u = (EditText) view2.findViewById(R.id.obfuscated_res_0x7f0908f5);
            this.p = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f092209);
            this.q = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f092036);
            this.i = view2.findViewById(R.id.obfuscated_res_0x7f090a74);
            this.r = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f0918d5);
            this.v = (EditText) view2.findViewById(R.id.obfuscated_res_0x7f0918d3);
            this.s = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f0918d4);
            this.x = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0912ab);
            this.k = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090708);
            this.t = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f090707);
            this.n = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090709);
            TextView addTextButton = this.y.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.a.getString(R.string.obfuscated_res_0x7f0f04e5), null);
            this.B = addTextButton;
            addTextButton.setId(R.id.obfuscated_res_0x7f09150f);
            this.B.setOnClickListener(this);
            this.y.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f0697));
            EMTextView eMTextView = new EMTextView(this.a.getPageActivity());
            this.z = eMTextView;
            eMTextView.setText(this.a.getString(R.string.obfuscated_res_0x7f0f1531));
            this.z.setGravity(16);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            layoutParams.gravity = 17;
            this.z.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X004), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X004), 0);
            this.z.setLayoutParams(layoutParams);
            this.y.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.z, this);
            EMTextView eMTextView2 = new EMTextView(this.a.getPageActivity());
            this.A = eMTextView2;
            eMTextView2.setText(this.a.getString(R.string.obfuscated_res_0x7f0f0f2a));
            this.A.setEnabled(false);
            this.A.setGravity(16);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
            layoutParams2.rightMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X007);
            this.A.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X004), 0, 0, 0);
            this.A.setLayoutParams(layoutParams2);
            this.y.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.A, this);
            F();
            S();
            t(false, null, false);
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.j.setOnClickListener(this);
            this.p.setOnClickListener(this);
            this.k.setOnClickListener(this);
            this.w.setOnClickListener(this);
            this.y.setOnClickListener(this);
            P(this.q, 0, 50);
            P(this.s, 0, 500);
            this.D.setListener(new d(this));
            this.u.addTextChangedListener(new e(this));
            this.v.addTextChangedListener(new f(this));
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.G = null;
            this.F = null;
            this.e = null;
            this.f = null;
            C();
            this.J = null;
            this.K = null;
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.J == null) {
                oq4 oq4Var = new oq4(this.a.getPageActivity());
                this.K = oq4Var;
                oq4Var.q(this.a.getString(R.string.obfuscated_res_0x7f0f069d));
                this.J = new mq4(this.a, this.K);
                ArrayList arrayList = new ArrayList();
                kq4 kq4Var = new kq4(this.a.getString(R.string.obfuscated_res_0x7f0f108c), this.K);
                kq4Var.q(R.color.CAM_X0302);
                kq4Var.m(this.N);
                arrayList.add(kq4Var);
                kq4 kq4Var2 = new kq4(this.a.getString(R.string.obfuscated_res_0x7f0f0c9d), this.K);
                kq4Var2.m(this.O);
                arrayList.add(kq4Var2);
                this.K.m(new j(this));
                this.K.j(arrayList);
            }
            R();
        }
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.F == null) {
                this.F = new ForumRuleBaseData();
            }
            ArrayList arrayList = new ArrayList();
            List<eh6> list = this.E;
            if (list != null && list.size() > 0) {
                for (int i2 = 0; i2 < this.E.size(); i2++) {
                    ForumRuleBaseData.ForumRuleItemData forumRuleItemData = new ForumRuleBaseData.ForumRuleItemData();
                    eh6 eh6Var = this.E.get(i2);
                    EditText l = eh6Var.l();
                    SpanGroupEditText k2 = eh6Var.k();
                    if (l != null) {
                        forumRuleItemData.setTitle(l.getText().toString());
                    }
                    if (k2 != null) {
                        forumRuleItemData.setContent(k2.getSpanGroupManager().E());
                    }
                    forumRuleItemData.setStatus(i2 + "");
                    arrayList.add(forumRuleItemData);
                }
            }
            this.F.setTitle(this.u.getText().toString());
            this.F.setPreface(this.v.getText().toString());
            this.F.setList(arrayList);
        }
    }

    public final void J() {
        List<eh6> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (list = this.E) == null) {
            return;
        }
        if (list.size() >= 20) {
            this.t.setText(this.a.getString(R.string.obfuscated_res_0x7f0f06a3));
            this.k.setEnabled(false);
            this.t.setEnabled(false);
            this.H = false;
            this.n.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080919, ef8.a(SkinManager.getColor(R.color.CAM_X0105), SkinManager.RESOURCE_ALPHA_DISABLE), WebPManager.ResourceStateType.NORMAL_PRESS));
            wq4 d2 = wq4.d(this.k);
            d2.k(R.color.CAM_X0902);
            d2.l(R.dimen.L_X02);
            d2.n(R.string.J_X07);
            d2.e(R.string.A_X09);
            d2.f(R.color.CAM_X0201);
            return;
        }
        this.t.setText(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f069f), Integer.valueOf(20 - this.E.size())));
        this.k.setEnabled(true);
        this.t.setEnabled(true);
        this.H = true;
        this.n.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080919, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
        wq4 d3 = wq4.d(this.k);
        d3.k(R.color.CAM_X0902);
        d3.l(R.dimen.L_X02);
        d3.n(R.string.J_X07);
        d3.e(R.string.A_X01);
        d3.f(R.color.CAM_X0201);
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.A == null) {
            return;
        }
        if (z()) {
            this.A.setEnabled(true);
        } else {
            this.A.setEnabled(false);
        }
    }

    public final void L() {
        List<eh6> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (list = this.E) == null || list.size() <= 0) {
            return;
        }
        for (int i2 = 0; i2 < this.E.size(); i2++) {
            eh6 eh6Var = this.E.get(i2);
            eh6Var.t(i2);
            eh6Var.s(i2);
        }
    }

    public final void M(eh6 eh6Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, eh6Var) == null) || eh6Var == null) {
            return;
        }
        this.x.removeView(eh6Var.m());
        this.E.remove(eh6Var);
        Q();
        J();
        L();
        K();
    }

    public final void N(eh6 eh6Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, eh6Var) == null) || eh6Var == null) {
            return;
        }
        eh6Var.o(new g(this, eh6Var));
        eh6Var.p(new h(this));
    }

    public void O(ForumRuleBaseData forumRuleBaseData, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048590, this, forumRuleBaseData, z) == null) || this.g == null || forumRuleBaseData == null) {
            return;
        }
        this.u.setText(forumRuleBaseData.getTitle());
        this.u.setSelection(forumRuleBaseData.getTitle() != null ? forumRuleBaseData.getTitle().length() : 0);
        this.v.setText(forumRuleBaseData.getPreface());
        this.v.setSelection(forumRuleBaseData.getPreface() != null ? forumRuleBaseData.getPreface().length() : 0);
        if (forumRuleBaseData.getPbDataList() != null && forumRuleBaseData.getPbDataList().size() > 0) {
            eh6 eh6Var = this.E.get(0);
            this.x.removeView(eh6Var.m());
            this.E.remove(eh6Var);
            for (int i2 = 0; i2 < forumRuleBaseData.getPbDataList().size(); i2++) {
                t(false, forumRuleBaseData.getPbDataList().get(i2), !z);
            }
            return;
        }
        B();
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || this.E.get(0) == null) {
            return;
        }
        if (this.E.size() == 1) {
            this.E.get(0).q(false);
        } else {
            this.E.get(0).q(true);
        }
    }

    public void R() {
        ForumRulesEditActivity forumRulesEditActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || this.J == null || (forumRulesEditActivity = this.f) == null || forumRulesEditActivity.isFinishing()) {
            return;
        }
        this.J.m();
    }

    public final void S() {
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && this.C == null && (relativeLayout = this.j) != null) {
            zx5 zx5Var = new zx5(this.a, relativeLayout);
            this.C = zx5Var;
            zx5Var.g0(R.drawable.obfuscated_res_0x7f0802ef);
            this.C.O(16);
            this.C.U(true);
            this.C.h0(true);
            this.C.N(3000);
            this.C.j0(UtilHelper.getDimenPixelSize(R.dimen.tbds20));
            this.C.m0(this.a.getString(R.string.obfuscated_res_0x7f0f0699), "key_forum_rule_first_edit");
        }
    }

    public final void T(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, onClickListener) == null) {
            rq4 rq4Var = new rq4(this.a.getPageActivity());
            rq4Var.u(R.string.obfuscated_res_0x7f0f06a2);
            rq4Var.l(R.string.obfuscated_res_0x7f0f06a1);
            rq4Var.r(new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f0c3f, TBAlertConfig.OperateBtnStyle.SECONDARY), new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f049f, TBAlertConfig.OperateBtnStyle.MAIN, new b(this, onClickListener)));
            rq4Var.g();
            rq4Var.i(false);
            rq4Var.x();
        }
    }

    public final void U(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            BdTopToast bdTopToast = this.G;
            if (bdTopToast == null || !bdTopToast.isShown()) {
                BdTopToast bdTopToast2 = new BdTopToast(this.a.getPageActivity(), 2000);
                bdTopToast2.i(false);
                bdTopToast2.h(str);
                this.G = bdTopToast2;
                bdTopToast2.j((ViewGroup) this.g.findViewById(R.id.obfuscated_res_0x7f0912b9));
            }
        }
    }

    public final void V(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            if (i2 > 0) {
                this.p.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = this.u.getLayoutParams();
                layoutParams.width = -1;
                this.u.setLayoutParams(layoutParams);
                return;
            }
            this.p.setVisibility(0);
            ViewGroup.LayoutParams layoutParams2 = this.u.getLayoutParams();
            layoutParams2.width = -2;
            this.u.setLayoutParams(layoutParams2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, view2) == null) {
            if (view2 == this.B) {
                H();
            } else if (view2 == this.A) {
                w();
            } else if (view2 == this.z) {
                I();
                this.a.sendMessage(new CustomMessage(2002001, new ForumRulesShowActivityConfig(this.a.getPageActivity(), this.b, this.c, this.F, ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW, this.d, this.I)));
            } else if (view2 == this.j) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FrsActivityConfig(this.a.getPageActivity()).createNormalCfg(this.c, FrsActivityConfig.FRS_FROM_FORUM_RULE_EDIT)));
            } else if (view2 == this.p) {
                A();
            } else if (view2 != this.w && view2 != this.y) {
                if (view2 == this.k) {
                    mg.a().removeCallbacks(this.M);
                    mg.a().postDelayed(this.M, 300L);
                }
            } else {
                li.x(this.a.getPageActivity(), this.u);
                li.x(this.a.getPageActivity(), this.v);
            }
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            B();
            r(R.string.obfuscated_res_0x7f0f068f, R.string.obfuscated_res_0x7f0f068e);
            r(R.string.obfuscated_res_0x7f0f069b, R.string.obfuscated_res_0x7f0f069a);
            r(R.string.obfuscated_res_0x7f0f0693, R.string.obfuscated_res_0x7f0f0692);
            r(R.string.obfuscated_res_0x7f0f0688, R.string.obfuscated_res_0x7f0f0687);
            t(false, null, false);
        }
    }

    public final void r(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048599, this, i2, i3) == null) || this.x == null) {
            return;
        }
        eh6 eh6Var = new eh6(this.a.getPageActivity());
        N(eh6Var);
        s(eh6Var);
        String string = TbadkApplication.getInst().getResources().getString(i2);
        String string2 = TbadkApplication.getInst().getResources().getString(i3);
        eh6Var.l().setText(string);
        eh6Var.l().setSelection(string.length());
        eh6Var.k().insert(string2);
        eh6Var.k().setSelection(eh6Var.k().getText().toString().length());
    }

    public final void s(eh6 eh6Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, eh6Var) == null) || eh6Var == null) {
            return;
        }
        this.x.addView(eh6Var.m());
        this.E.add(eh6Var);
        Q();
        if (this.E.indexOf(eh6Var) != -1) {
            eh6Var.t(this.E.indexOf(eh6Var));
            eh6Var.s(this.E.indexOf(eh6Var));
        }
        K();
        J();
    }

    public final void t(boolean z, ForumRuleBaseData.ForumRuleItemPbData forumRuleItemPbData, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{Boolean.valueOf(z), forumRuleItemPbData, Boolean.valueOf(z2)}) == null) || this.x == null) {
            return;
        }
        eh6 eh6Var = new eh6(this.a.getPageActivity());
        N(eh6Var);
        s(eh6Var);
        if (forumRuleItemPbData != null) {
            eh6Var.l().setText(forumRuleItemPbData.title);
            EditText l = eh6Var.l();
            String str = forumRuleItemPbData.title;
            l.setSelection(str != null ? str.length() : 0);
            if (forumRuleItemPbData.mContent != null) {
                for (int i2 = 0; i2 < forumRuleItemPbData.mContent.size(); i2++) {
                    ForumRuleBaseData.ForumRuleItemPbContentData forumRuleItemPbContentData = forumRuleItemPbData.mContent.get(i2);
                    if (forumRuleItemPbContentData != null) {
                        if ("a".equals(forumRuleItemPbContentData.tag)) {
                            TbLinkSpanGroup tbLinkSpanGroup = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.PARSED_EXTERNAL_LINK);
                            SpanGroupEditText k2 = eh6Var.k();
                            tbLinkSpanGroup.a(k2.getText(), k2.getSelectionEnd(), k2.getSelectionEnd(), (int) k2.getTextSize());
                            tbLinkSpanGroup.C(forumRuleItemPbContentData.href);
                            tbLinkSpanGroup.z(forumRuleItemPbContentData.value);
                            tbLinkSpanGroup.r();
                            k2.getSpanGroupManager().H(tbLinkSpanGroup);
                        } else if ("plainText".equals(forumRuleItemPbContentData.tag)) {
                            eh6Var.k().insert(forumRuleItemPbContentData.value);
                        } else if (TtmlNode.TAG_BR.equals(forumRuleItemPbContentData.tag)) {
                            eh6Var.k().insert("\r\n");
                        }
                    }
                }
            }
            eh6Var.k().setSelection(eh6Var.k().getText().toString().length());
            if (z2 && "1".equals(forumRuleItemPbData.status)) {
                eh6Var.l().setTextColor(SkinManager.getColor(R.color.CAM_X0301));
                eh6Var.k().setTextColor(SkinManager.getColor(R.color.CAM_X0301));
                eh6Var.r(true);
            }
        }
        if (z) {
            mg.a().post(new i(this));
        }
    }

    public final void u(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            if (i2 == 0 && !this.L) {
                if ("Meizu".equalsIgnoreCase(Build.BRAND)) {
                    ch6.c(UtilHelper.getDimenPixelSize(R.dimen.tbds6), UtilHelper.getDimenPixelSize(R.dimen.tbds20), this.v);
                    this.L = true;
                } else if ("Xiaomi".equalsIgnoreCase(Build.BRAND)) {
                    ch6.c(0, UtilHelper.getDimenPixelSize(R.dimen.tbds_20), this.v);
                    this.L = true;
                }
            } else if (this.L) {
                this.L = false;
                ch6.c(0, 0, this.v);
            }
        }
    }

    public void v(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048603, this, i2) == null) || this.g == null) {
            return;
        }
        wq4.d(this.w).f(R.color.CAM_X0201);
        wq4.d(this.o).v(R.color.CAM_X0105);
        wq4.d(this.h).f(R.color.CAM_X0210);
        wq4.d(this.i).f(R.color.CAM_X0210);
        wq4.d(this.q).v(R.color.CAM_X0111);
        wq4.d(this.s).v(R.color.CAM_X0111);
        wq4 d2 = wq4.d(this.p);
        d2.v(R.color.CAM_X0304);
        d2.A(R.string.F_X02);
        wq4 d3 = wq4.d(this.r);
        d3.v(R.color.CAM_X0107);
        d3.A(R.string.F_X02);
        wq4.d(this.B).x(R.color.CAM_X0105);
        wq4 d4 = wq4.d(this.z);
        d4.x(R.color.CAM_X0302);
        d4.z(R.dimen.T_X05);
        wq4.d(this.A).z(R.dimen.T_X05);
        this.A.setTextColor(SkinManager.getColorStateListWithClickAndDisableState(R.color.CAM_X0302, TbadkCoreApplication.getInst().getSkinType()));
        this.t.setTextColor(SkinManager.getColorStateListWithClickAndDisableState(R.color.CAM_X0105, TbadkCoreApplication.getInst().getSkinType()));
        this.u.setHintTextColor(SkinManager.getColor(R.color.CAM_X0111));
        this.u.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        this.v.setHintTextColor(SkinManager.getColor(R.color.CAM_X0111));
        this.v.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        this.l.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080928, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
        this.m.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_list_arrow16_right, SkinManager.getColor(R.color.CAM_X0107), WebPManager.ResourceStateType.NORMAL_PRESS));
        if (this.H) {
            this.n.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080919, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
        } else {
            this.n.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080919, ef8.a(SkinManager.getColor(R.color.CAM_X0304), SkinManager.RESOURCE_ALPHA_PRESS), WebPManager.ResourceStateType.NORMAL_PRESS));
        }
        NavigationBar navigationBar = this.y;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.a, i2);
        }
        oq4 oq4Var = this.K;
        if (oq4Var != null) {
            oq4Var.i();
        }
        if (i2 == 0) {
            jv8.l(this.u, R.drawable.obfuscated_res_0x7f0804ae);
            jv8.l(this.v, R.drawable.obfuscated_res_0x7f0804ae);
        } else {
            jv8.l(this.u, R.drawable.obfuscated_res_0x7f0804af);
            jv8.l(this.v, R.drawable.obfuscated_res_0x7f0804af);
        }
        wq4 d5 = wq4.d(this.k);
        d5.k(R.color.CAM_X0902);
        d5.l(R.dimen.L_X02);
        d5.n(R.string.J_X07);
        d5.e(this.H ? R.string.A_X01 : R.string.A_X09);
        d5.f(R.color.CAM_X0201);
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            EditText editText = this.u;
            if (editText != null && editText.getText().toString().length() > 50) {
                U(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0684), this.a.getString(R.string.obfuscated_res_0x7f0f068d)));
                return;
            }
            List<eh6> list = this.E;
            if (list != null && list.size() > 0) {
                for (int i2 = 0; i2 < this.E.size(); i2++) {
                    new ForumRuleBaseData.ForumRuleItemData();
                    eh6 eh6Var = this.E.get(i2);
                    EditText l = eh6Var.l();
                    SpanGroupEditText k2 = eh6Var.k();
                    if (l != null && l.getText().toString().trim().length() > 30) {
                        U(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0684), String.format(this.a.getString(R.string.obfuscated_res_0x7f0f068a), ch6.d(i2 + 1), this.a.getString(R.string.obfuscated_res_0x7f0f06a5))));
                        return;
                    } else if (k2 != null && k2.getText().toString().length() > 1000) {
                        U(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0684), String.format(this.a.getString(R.string.obfuscated_res_0x7f0f068a), ch6.d(i2 + 1), this.a.getString(R.string.obfuscated_res_0x7f0f0685))));
                        return;
                    }
                }
            }
            EditText editText2 = this.v;
            if (editText2 != null && editText2.getText().toString().length() > 500) {
                U(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0684), this.a.getString(R.string.obfuscated_res_0x7f0f0691)));
                return;
            }
            I();
            this.e.commitData(this.F, false);
        }
    }

    public final boolean x() {
        InterceptResult invokeV;
        int i2;
        int i3;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            ForumRuleBaseData forumRuleBaseData = this.F;
            if (forumRuleBaseData != null) {
                i2 = forumRuleBaseData.getTitle() != null ? this.F.getTitle().length() : 0;
                if (this.F.getList() == null || this.F.getList().size() <= 0) {
                    i4 = 0;
                    i5 = 0;
                } else {
                    i4 = 0;
                    i5 = 0;
                    for (int i6 = 0; i6 < this.F.getList().size(); i6++) {
                        ForumRuleBaseData.ForumRuleItemData forumRuleItemData = this.F.getList().get(i6);
                        if (forumRuleItemData != null) {
                            if (forumRuleItemData.getTitle() != null) {
                                i4 += forumRuleItemData.getTitle().length();
                            }
                            if (forumRuleItemData.getContent() != null) {
                                i5 += forumRuleItemData.getContent().length();
                            }
                        }
                    }
                }
                i3 = this.F.getPreface() != null ? this.F.getPreface().length() : 0;
            } else {
                i2 = 0;
                i3 = 0;
                i4 = 0;
                i5 = 0;
            }
            if (i2 + i4 + i5 + i3 > 5000) {
                C();
                U(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f069e), 5000));
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            I();
            if (x()) {
                return;
            }
            ForumRuleBaseData forumRuleBaseData = this.F;
            if (forumRuleBaseData != null) {
                if (forumRuleBaseData.getTitle().length() > 50) {
                    C();
                    U(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f069c), this.a.getString(R.string.obfuscated_res_0x7f0f068d), 50));
                    return;
                }
                if (this.F.getList() != null) {
                    for (int i2 = 0; i2 < this.F.getList().size(); i2++) {
                        ForumRuleBaseData.ForumRuleItemData forumRuleItemData = this.F.getList().get(i2);
                        if (forumRuleItemData != null) {
                            if (forumRuleItemData.getTitle().length() > 50) {
                                C();
                                U(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f069c), this.a.getString(R.string.obfuscated_res_0x7f0f068c), 50));
                                return;
                            } else if (forumRuleItemData.getContent().length() > 1000) {
                                C();
                                U(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f069c), this.a.getString(R.string.obfuscated_res_0x7f0f068b), 1000));
                                return;
                            }
                        }
                    }
                }
                if (this.F.getPreface().length() > 600) {
                    C();
                    U(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f069c), this.a.getString(R.string.obfuscated_res_0x7f0f0691), 600));
                    return;
                }
            }
            this.e.commitData(this.F, true);
        }
    }

    public final boolean z() {
        InterceptResult invokeV;
        EditText editText;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            if (this.A == null || (editText = this.u) == null || editText.getText().toString().trim().length() <= 0) {
                return false;
            }
            EditText editText2 = this.v;
            if (editText2 == null || editText2.getText().toString().trim().length() > 0) {
                List<eh6> list = this.E;
                if (list == null || list.size() <= 0) {
                    return true;
                }
                for (int i2 = 0; i2 < this.E.size(); i2++) {
                    eh6 eh6Var = this.E.get(i2);
                    EditText l = eh6Var.l();
                    SpanGroupEditText k2 = eh6Var.k();
                    if (l == null || l.getText().toString().trim().length() <= 0 || k2 == null || k2.getText().toString().trim().length() <= 0) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
