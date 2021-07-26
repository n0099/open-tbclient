package d.a.q0.u0.p1.f;

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
import com.android.internal.http.multipart.Part;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
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
import d.a.p0.s.s.l;
import d.a.p0.s.s.o;
import d.a.q0.u0.p1.f.b;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/* loaded from: classes8.dex */
public class a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout A;
    public LinearLayout B;
    public NavigationBar C;
    public TextView D;
    public TextView E;
    public TextView F;
    public d.a.q0.e0.e G;
    public EditorScrollView H;
    public List<d.a.q0.u0.p1.f.b> I;
    public ForumRuleBaseData J;
    public BdTopToast K;
    public boolean L;
    public int M;
    public d.a.p0.s.s.j N;
    public l O;
    public boolean P;
    public Runnable Q;
    public l.d R;
    public l.d S;

    /* renamed from: e  reason: collision with root package name */
    public final TbPageContext<?> f64171e;

    /* renamed from: f  reason: collision with root package name */
    public final String f64172f;

    /* renamed from: g  reason: collision with root package name */
    public final String f64173g;

    /* renamed from: h  reason: collision with root package name */
    public final String f64174h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.q0.u0.p1.b.b f64175i;
    public ForumRulesEditActivity j;
    public View k;
    public View l;
    public View m;
    public RelativeLayout n;
    public RelativeLayout o;
    public ImageView p;
    public ImageView q;
    public ImageView r;
    public EMTextView s;
    public EMTextView t;
    public EMTextView u;
    public EMTextView v;
    public EMTextView w;
    public EMTextView x;
    public EditText y;
    public EditText z;

    /* renamed from: d.a.q0.u0.p1.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1714a implements l.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f64176a;

        public C1714a(a aVar) {
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
            this.f64176a = aVar;
        }

        @Override // d.a.p0.s.s.l.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f64176a.B();
                if (this.f64176a.j != null) {
                    this.f64176a.j.finish();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f64177e;

        public b(a aVar, View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64177e = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f64177e.onClick(view);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f64178e;

        public c(a aVar) {
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
            this.f64178e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f64178e.s(true, null, false);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements ViewTreeObserver.OnScrollChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f64179a;

        public d(a aVar) {
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
            this.f64179a = aVar;
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f64179a.F();
                d.a.d.e.p.l.x(this.f64179a.f64171e.getPageActivity(), this.f64179a.y);
                d.a.d.e.p.l.x(this.f64179a.f64171e.getPageActivity(), this.f64179a.z);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f64180e;

        public e(a aVar) {
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
            this.f64180e = aVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                int length = editable.toString().length();
                this.f64180e.Y(length);
                a.R(this.f64180e.u, length, 50);
                this.f64180e.M();
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f64181e;

        /* renamed from: d.a.q0.u0.p1.f.a$f$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class View$OnTouchListenerC1715a implements View.OnTouchListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public View$OnTouchListenerC1715a(f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                    if (motionEvent.getAction() == 0) {
                        view.getParent().requestDisallowInterceptTouchEvent(true);
                    } else if (motionEvent.getAction() == 1) {
                        view.getParent().requestDisallowInterceptTouchEvent(false);
                    } else if (motionEvent.getAction() == 3) {
                        view.getParent().requestDisallowInterceptTouchEvent(false);
                    }
                    return false;
                }
                return invokeLL.booleanValue;
            }
        }

        public f(a aVar) {
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
            this.f64181e = aVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                int length = editable.toString().length();
                this.f64181e.t(length);
                a.R(this.f64181e.w, length, 500);
                this.f64181e.M();
                if (this.f64181e.z.getLineCount() > 6) {
                    this.f64181e.z.setOnTouchListener(new View$OnTouchListenerC1715a(this));
                } else {
                    this.f64181e.z.setOnTouchListener(null);
                }
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.u0.p1.f.b f64182e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f64183f;

        /* renamed from: d.a.q0.u0.p1.f.a$g$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class View$OnClickListenerC1716a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ g f64184e;

            public View$OnClickListenerC1716a(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f64184e = gVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    g gVar = this.f64184e;
                    gVar.f64183f.O(gVar.f64182e);
                }
            }
        }

        public g(a aVar, d.a.q0.u0.p1.f.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64183f = aVar;
            this.f64182e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f64182e.k().getText().toString().length() != 0 || this.f64182e.l().getText().toString().length() != 0) {
                    this.f64183f.V(new View$OnClickListenerC1716a(this));
                } else {
                    this.f64183f.O(this.f64182e);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements b.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f64185a;

        public h(a aVar) {
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
            this.f64185a = aVar;
        }

        @Override // d.a.q0.u0.p1.f.b.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f64185a.M();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f64186e;

        public i(a aVar) {
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
            this.f64186e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f64186e.H.fullScroll(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j implements l.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f64187a;

        public j(a aVar) {
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
            this.f64187a = aVar;
        }

        @Override // d.a.p0.s.s.l.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f64187a.B();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class k implements l.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f64188a;

        public k(a aVar) {
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
            this.f64188a = aVar;
        }

        @Override // d.a.p0.s.s.l.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f64188a.x();
            }
        }
    }

    public a(TbPageContext<?> tbPageContext, d.a.q0.u0.p1.b.b bVar, View view, String str, String str2, String str3, String str4, int i2, ForumRulesEditActivity forumRulesEditActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bVar, view, str, str2, str3, str4, Integer.valueOf(i2), forumRulesEditActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.I = new ArrayList();
        this.J = new ForumRuleBaseData();
        this.L = true;
        this.P = false;
        this.Q = new c(this);
        this.R = new k(this);
        this.S = new C1714a(this);
        this.f64171e = tbPageContext;
        this.f64172f = str;
        this.f64173g = str2;
        this.f64174h = str4;
        this.M = i2;
        this.j = forumRulesEditActivity;
        this.f64175i = bVar;
        G(view, str3);
    }

    public static void R(TextView textView, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65537, null, textView, i2, i3) == null) {
            textView.setText(i2 + "/" + i3);
            if (i2 > i3) {
                d.a.p0.s.u.c.d(textView).t(R.color.CAM_X0301);
            } else {
                d.a.p0.s.u.c.d(textView).t(R.color.CAM_X0111);
            }
        }
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.I.size() <= 0 || this.B == null) {
            return;
        }
        d.a.q0.u0.p1.f.b bVar = this.I.get(0);
        this.B.removeView(bVar.m());
        this.I.remove(bVar);
        L();
        N();
    }

    public void B() {
        d.a.p0.s.s.j jVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (jVar = this.N) != null && jVar.isShowing()) {
            this.N.dismiss();
        }
    }

    public final void F() {
        d.a.q0.e0.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (eVar = this.G) == null) {
            return;
        }
        eVar.I();
    }

    public final void G(View view, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, view, str) == null) {
            this.k = view;
            this.C = (NavigationBar) view.findViewById(R.id.navi_forumrule_title);
            this.A = (LinearLayout) view.findViewById(R.id.rule_main_content);
            this.H = (EditorScrollView) view.findViewById(R.id.scrool_main);
            this.p = (ImageView) view.findViewById(R.id.forum_copy_icon);
            this.n = (RelativeLayout) view.findViewById(R.id.forum_to_copy_rl);
            this.q = (ImageView) view.findViewById(R.id.forum_copy_arrow);
            this.s = (EMTextView) view.findViewById(R.id.forum_copy_title);
            this.l = view.findViewById(R.id.forum_to_copy_divider);
            this.y = (EditText) view.findViewById(R.id.et_big_title);
            this.t = (EMTextView) view.findViewById(R.id.tv_used_example);
            this.u = (EMTextView) view.findViewById(R.id.title_number);
            this.m = view.findViewById(R.id.forum_title_divider);
            this.v = (EMTextView) view.findViewById(R.id.preface_title);
            this.z = (EditText) view.findViewById(R.id.preface_content);
            this.w = (EMTextView) view.findViewById(R.id.preface_number);
            this.B = (LinearLayout) view.findViewById(R.id.ll_add_rule);
            this.o = (RelativeLayout) view.findViewById(R.id.create_rule_btn);
            this.x = (EMTextView) view.findViewById(R.id.create_rule);
            this.r = (ImageView) view.findViewById(R.id.create_rule_icon);
            TextView addTextButton = this.C.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.f64171e.getString(R.string.dialog_cancel), null);
            this.F = addTextButton;
            addTextButton.setId(R.id.negative_feedback_view);
            this.F.setOnClickListener(this);
            this.C.setCenterTextTitle(this.f64171e.getString(R.string.forum_rule_defalt_title_setting));
            EMTextView eMTextView = new EMTextView(this.f64171e.getPageActivity());
            this.D = eMTextView;
            eMTextView.setText(this.f64171e.getString(R.string.video_preview));
            this.D.setGravity(16);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            layoutParams.gravity = 17;
            this.D.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X004), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X004), 0);
            this.D.setLayoutParams(layoutParams);
            this.C.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.D, this);
            EMTextView eMTextView2 = new EMTextView(this.f64171e.getPageActivity());
            this.E = eMTextView2;
            eMTextView2.setText(this.f64171e.getString(R.string.push_commit));
            this.E.setEnabled(false);
            this.E.setGravity(16);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
            layoutParams2.rightMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X007);
            this.E.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X004), 0, 0, 0);
            this.E.setLayoutParams(layoutParams2);
            this.C.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.E, this);
            H();
            U();
            s(false, null, false);
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.n.setOnClickListener(this);
            this.t.setOnClickListener(this);
            this.o.setOnClickListener(this);
            this.A.setOnClickListener(this);
            this.C.setOnClickListener(this);
            R(this.u, 0, 50);
            R(this.w, 0, 500);
            this.H.setListener(new d(this));
            this.y.addTextChangedListener(new e(this));
            this.z.addTextChangedListener(new f(this));
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.K = null;
            this.J = null;
            this.f64175i = null;
            this.j = null;
            B();
            this.N = null;
            this.O = null;
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.N == null) {
                l lVar = new l(this.f64171e.getPageActivity());
                this.O = lVar;
                lVar.q(this.f64171e.getString(R.string.forum_rule_draft_title));
                this.N = new d.a.p0.s.s.j(this.f64171e, this.O);
                ArrayList arrayList = new ArrayList();
                d.a.p0.s.s.h hVar = new d.a.p0.s.s.h(this.f64171e.getString(R.string.save), this.O);
                hVar.o(R.color.CAM_X0302);
                hVar.m(this.R);
                arrayList.add(hVar);
                d.a.p0.s.s.h hVar2 = new d.a.p0.s.s.h(this.f64171e.getString(R.string.not_save), this.O);
                hVar2.m(this.S);
                arrayList.add(hVar2);
                this.O.m(new j(this));
                this.O.k(arrayList);
            }
            T();
        }
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.J == null) {
                this.J = new ForumRuleBaseData();
            }
            ArrayList arrayList = new ArrayList();
            List<d.a.q0.u0.p1.f.b> list = this.I;
            if (list != null && list.size() > 0) {
                for (int i2 = 0; i2 < this.I.size(); i2++) {
                    ForumRuleBaseData.ForumRuleItemData forumRuleItemData = new ForumRuleBaseData.ForumRuleItemData();
                    d.a.q0.u0.p1.f.b bVar = this.I.get(i2);
                    EditText l = bVar.l();
                    SpanGroupEditText k2 = bVar.k();
                    if (l != null) {
                        forumRuleItemData.setTitle(l.getText().toString());
                    }
                    if (k2 != null) {
                        forumRuleItemData.setContent(k2.getSpanGroupManager().t());
                    }
                    forumRuleItemData.setStatus(i2 + "");
                    arrayList.add(forumRuleItemData);
                }
            }
            this.J.setTitle(this.y.getText().toString());
            this.J.setPreface(this.z.getText().toString());
            this.J.setList(arrayList);
        }
    }

    public final void L() {
        List<d.a.q0.u0.p1.f.b> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (list = this.I) == null) {
            return;
        }
        if (list.size() >= 20) {
            this.x.setText(this.f64171e.getString(R.string.forum_rule_item_number_max));
            this.o.setEnabled(false);
            this.x.setEnabled(false);
            this.L = false;
            this.r.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_edit_add12, d.a.q0.h3.c.a(SkinManager.getColor(R.color.CAM_X0105), SkinManager.RESOURCE_ALPHA_DISABLE), WebPManager.ResourceStateType.NORMAL_PRESS));
            d.a.p0.s.u.c d2 = d.a.p0.s.u.c.d(this.o);
            d2.k(R.color.CAM_X0902);
            d2.l(R.dimen.L_X02);
            d2.n(R.string.J_X07);
            d2.e(R.string.A_X09);
            d2.f(R.color.CAM_X0201);
            return;
        }
        this.x.setText(String.format(this.f64171e.getString(R.string.forum_rule_item_add_number), Integer.valueOf(20 - this.I.size())));
        this.o.setEnabled(true);
        this.x.setEnabled(true);
        this.L = true;
        this.r.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_edit_add12, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
        d.a.p0.s.u.c d3 = d.a.p0.s.u.c.d(this.o);
        d3.k(R.color.CAM_X0902);
        d3.l(R.dimen.L_X02);
        d3.n(R.string.J_X07);
        d3.e(R.string.A_X01);
        d3.f(R.color.CAM_X0201);
    }

    public final void M() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.E == null) {
            return;
        }
        if (y()) {
            this.E.setEnabled(true);
        } else {
            this.E.setEnabled(false);
        }
    }

    public final void N() {
        List<d.a.q0.u0.p1.f.b> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (list = this.I) == null || list.size() <= 0) {
            return;
        }
        for (int i2 = 0; i2 < this.I.size(); i2++) {
            d.a.q0.u0.p1.f.b bVar = this.I.get(i2);
            bVar.t(i2);
            bVar.s(i2);
        }
    }

    public final void O(d.a.q0.u0.p1.f.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, bVar) == null) || bVar == null) {
            return;
        }
        this.B.removeView(bVar.m());
        this.I.remove(bVar);
        S();
        L();
        N();
        M();
    }

    public final void P(d.a.q0.u0.p1.f.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) || bVar == null) {
            return;
        }
        bVar.o(new g(this, bVar));
        bVar.p(new h(this));
    }

    public void Q(ForumRuleBaseData forumRuleBaseData, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048589, this, forumRuleBaseData, z) == null) || this.k == null || forumRuleBaseData == null) {
            return;
        }
        this.y.setText(forumRuleBaseData.getTitle());
        this.y.setSelection(forumRuleBaseData.getTitle() != null ? forumRuleBaseData.getTitle().length() : 0);
        this.z.setText(forumRuleBaseData.getPreface());
        this.z.setSelection(forumRuleBaseData.getPreface() != null ? forumRuleBaseData.getPreface().length() : 0);
        if (forumRuleBaseData.getPbDataList() != null && forumRuleBaseData.getPbDataList().size() > 0) {
            d.a.q0.u0.p1.f.b bVar = this.I.get(0);
            this.B.removeView(bVar.m());
            this.I.remove(bVar);
            for (int i2 = 0; i2 < forumRuleBaseData.getPbDataList().size(); i2++) {
                s(false, forumRuleBaseData.getPbDataList().get(i2), !z);
            }
            return;
        }
        A();
    }

    public final void S() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || this.I.get(0) == null) {
            return;
        }
        if (this.I.size() == 1) {
            this.I.get(0).q(false);
        } else {
            this.I.get(0).q(true);
        }
    }

    public void T() {
        ForumRulesEditActivity forumRulesEditActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || this.N == null || (forumRulesEditActivity = this.j) == null || forumRulesEditActivity.isFinishing()) {
            return;
        }
        this.N.l();
    }

    public final void U() {
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && this.G == null && (relativeLayout = this.n) != null) {
            d.a.q0.e0.e eVar = new d.a.q0.e0.e(this.f64171e, relativeLayout);
            this.G = eVar;
            eVar.g0(R.drawable.bg_tip_blue_up_left);
            this.G.O(16);
            this.G.U(true);
            this.G.h0(true);
            this.G.N(3000);
            this.G.j0(UtilHelper.getDimenPixelSize(R.dimen.tbds20));
            this.G.m0(this.f64171e.getString(R.string.forum_rule_defalt_tocopy_tip), "key_forum_rule_first_edit");
        }
    }

    public final void V(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, onClickListener) == null) {
            o oVar = new o(this.f64171e.getPageActivity());
            oVar.p(R.string.forum_rule_item_del_dialog_title);
            oVar.j(R.string.forum_rule_item_del_dialog_abstract);
            oVar.o(new TBAlertConfig.a(R.string.next_time, TBAlertConfig.OperateBtnStyle.SECONDARY), new TBAlertConfig.a(R.string.del_post, TBAlertConfig.OperateBtnStyle.MAIN, new b(this, onClickListener)));
            oVar.f();
            oVar.g(false);
            oVar.r();
        }
    }

    public final void X(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            BdTopToast bdTopToast = this.K;
            if (bdTopToast == null || !bdTopToast.isShown()) {
                BdTopToast bdTopToast2 = new BdTopToast(this.f64171e.getPageActivity(), 2000);
                bdTopToast2.i(false);
                bdTopToast2.h(str);
                this.K = bdTopToast2;
                bdTopToast2.j((ViewGroup) this.k.findViewById(R.id.ll_forum_rule_all));
            }
        }
    }

    public final void Y(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            if (i2 > 0) {
                this.t.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = this.y.getLayoutParams();
                layoutParams.width = -1;
                this.y.setLayoutParams(layoutParams);
                return;
            }
            this.t.setVisibility(0);
            ViewGroup.LayoutParams layoutParams2 = this.y.getLayoutParams();
            layoutParams2.width = -2;
            this.y.setLayoutParams(layoutParams2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, view) == null) {
            if (view == this.F) {
                J();
            } else if (view == this.E) {
                v();
            } else if (view == this.D) {
                K();
                this.f64171e.sendMessage(new CustomMessage(2002001, new ForumRulesShowActivityConfig(this.f64171e.getPageActivity(), this.f64172f, this.f64173g, this.J, ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW, this.f64174h, this.M)));
            } else if (view == this.n) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FrsActivityConfig(this.f64171e.getPageActivity()).createNormalCfg(this.f64173g, FrsActivityConfig.FRS_FROM_FORUM_RULE_EDIT)));
            } else if (view == this.t) {
                z();
            } else if (view != this.A && view != this.C) {
                if (view == this.o) {
                    d.a.d.e.m.e.a().removeCallbacks(this.Q);
                    d.a.d.e.m.e.a().postDelayed(this.Q, 300L);
                }
            } else {
                d.a.d.e.p.l.x(this.f64171e.getPageActivity(), this.y);
                d.a.d.e.p.l.x(this.f64171e.getPageActivity(), this.z);
            }
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            A();
            q(R.string.forum_rule_defalt_one_title, R.string.forum_rule_defalt_one_content);
            q(R.string.forum_rule_defalt_two_title, R.string.forum_rule_defalt_two_content);
            q(R.string.forum_rule_defalt_three_title, R.string.forum_rule_defalt_three_content);
            q(R.string.forum_rule_defalt_four_title, R.string.forum_rule_defalt_four_content);
            s(false, null, false);
        }
    }

    public final void q(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048598, this, i2, i3) == null) || this.B == null) {
            return;
        }
        d.a.q0.u0.p1.f.b bVar = new d.a.q0.u0.p1.f.b(this.f64171e.getPageActivity());
        P(bVar);
        r(bVar);
        String string = TbadkApplication.getInst().getResources().getString(i2);
        String string2 = TbadkApplication.getInst().getResources().getString(i3);
        bVar.l().setText(string);
        bVar.l().setSelection(string.length());
        bVar.k().d(string2);
        bVar.k().setSelection(bVar.k().getText().toString().length());
    }

    public final void r(d.a.q0.u0.p1.f.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, bVar) == null) || bVar == null) {
            return;
        }
        this.B.addView(bVar.m());
        this.I.add(bVar);
        S();
        if (this.I.indexOf(bVar) != -1) {
            bVar.t(this.I.indexOf(bVar));
            bVar.s(this.I.indexOf(bVar));
        }
        M();
        L();
    }

    public final void s(boolean z, ForumRuleBaseData.ForumRuleItemPbData forumRuleItemPbData, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{Boolean.valueOf(z), forumRuleItemPbData, Boolean.valueOf(z2)}) == null) || this.B == null) {
            return;
        }
        d.a.q0.u0.p1.f.b bVar = new d.a.q0.u0.p1.f.b(this.f64171e.getPageActivity());
        P(bVar);
        r(bVar);
        if (forumRuleItemPbData != null) {
            bVar.l().setText(forumRuleItemPbData.title);
            EditText l = bVar.l();
            String str = forumRuleItemPbData.title;
            l.setSelection(str != null ? str.length() : 0);
            if (forumRuleItemPbData.mContent != null) {
                for (int i2 = 0; i2 < forumRuleItemPbData.mContent.size(); i2++) {
                    ForumRuleBaseData.ForumRuleItemPbContentData forumRuleItemPbContentData = forumRuleItemPbData.mContent.get(i2);
                    if (forumRuleItemPbContentData != null) {
                        if ("a".equals(forumRuleItemPbContentData.tag)) {
                            TbLinkSpanGroup tbLinkSpanGroup = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.PARSED_EXTERNAL_LINK);
                            SpanGroupEditText k2 = bVar.k();
                            tbLinkSpanGroup.a(k2.getText(), k2.getSelectionEnd(), k2.getSelectionEnd(), (int) k2.getTextSize());
                            tbLinkSpanGroup.C(forumRuleItemPbContentData.href);
                            tbLinkSpanGroup.z(forumRuleItemPbContentData.value);
                            tbLinkSpanGroup.r();
                            k2.getSpanGroupManager().v(tbLinkSpanGroup);
                        } else if ("plainText".equals(forumRuleItemPbContentData.tag)) {
                            bVar.k().d(forumRuleItemPbContentData.value);
                        } else if ("br".equals(forumRuleItemPbContentData.tag)) {
                            bVar.k().d(Part.CRLF);
                        }
                    }
                }
            }
            bVar.k().setSelection(bVar.k().getText().toString().length());
            if (z2 && "1".equals(forumRuleItemPbData.status)) {
                bVar.l().setTextColor(SkinManager.getColor(R.color.CAM_X0301));
                bVar.k().setTextColor(SkinManager.getColor(R.color.CAM_X0301));
                bVar.r(true);
            }
        }
        if (z) {
            d.a.d.e.m.e.a().post(new i(this));
        }
    }

    public final void t(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            if (i2 == 0 && !this.P) {
                if ("Meizu".equalsIgnoreCase(Build.BRAND)) {
                    d.a.q0.u0.p1.e.a.c(UtilHelper.getDimenPixelSize(R.dimen.tbds6), UtilHelper.getDimenPixelSize(R.dimen.tbds20), this.z);
                    this.P = true;
                } else if ("Xiaomi".equalsIgnoreCase(Build.BRAND)) {
                    d.a.q0.u0.p1.e.a.c(0, UtilHelper.getDimenPixelSize(R.dimen.tbds_20), this.z);
                    this.P = true;
                }
            } else if (this.P) {
                this.P = false;
                d.a.q0.u0.p1.e.a.c(0, 0, this.z);
            }
        }
    }

    public void u(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048602, this, i2) == null) || this.k == null) {
            return;
        }
        d.a.p0.s.u.c.d(this.A).f(R.color.CAM_X0201);
        d.a.p0.s.u.c.d(this.s).t(R.color.CAM_X0105);
        d.a.p0.s.u.c.d(this.l).f(R.color.CAM_X0210);
        d.a.p0.s.u.c.d(this.m).f(R.color.CAM_X0210);
        d.a.p0.s.u.c.d(this.u).t(R.color.CAM_X0111);
        d.a.p0.s.u.c.d(this.w).t(R.color.CAM_X0111);
        d.a.p0.s.u.c d2 = d.a.p0.s.u.c.d(this.t);
        d2.t(R.color.CAM_X0304);
        d2.y(R.string.F_X02);
        d.a.p0.s.u.c d3 = d.a.p0.s.u.c.d(this.v);
        d3.t(R.color.CAM_X0107);
        d3.y(R.string.F_X02);
        d.a.p0.s.u.c.d(this.F).v(R.color.CAM_X0105);
        d.a.p0.s.u.c d4 = d.a.p0.s.u.c.d(this.D);
        d4.v(R.color.CAM_X0302);
        d4.x(R.dimen.T_X05);
        d.a.p0.s.u.c.d(this.E).x(R.dimen.T_X05);
        this.E.setTextColor(SkinManager.getColorStateListWithClickAndDisableState(R.color.CAM_X0302, TbadkCoreApplication.getInst().getSkinType()));
        this.x.setTextColor(SkinManager.getColorStateListWithClickAndDisableState(R.color.CAM_X0105, TbadkCoreApplication.getInst().getSkinType()));
        this.y.setHintTextColor(SkinManager.getColor(R.color.CAM_X0111));
        this.y.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        this.z.setHintTextColor(SkinManager.getColor(R.color.CAM_X0111));
        this.z.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        this.p.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_frs_recommend_copy18, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
        this.q.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_list_arrow16_right, SkinManager.getColor(R.color.CAM_X0107), WebPManager.ResourceStateType.NORMAL_PRESS));
        if (this.L) {
            this.r.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_edit_add12, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
        } else {
            this.r.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_edit_add12, d.a.q0.h3.c.a(SkinManager.getColor(R.color.CAM_X0304), SkinManager.RESOURCE_ALPHA_PRESS), WebPManager.ResourceStateType.NORMAL_PRESS));
        }
        NavigationBar navigationBar = this.C;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f64171e, i2);
        }
        l lVar = this.O;
        if (lVar != null) {
            lVar.j();
        }
        if (i2 == 0) {
            d.a.q0.a4.i.e(this.y, R.drawable.edittext_cursor);
            d.a.q0.a4.i.e(this.z, R.drawable.edittext_cursor);
        } else {
            d.a.q0.a4.i.e(this.y, R.drawable.edittext_cursor_1);
            d.a.q0.a4.i.e(this.z, R.drawable.edittext_cursor_1);
        }
        d.a.p0.s.u.c d5 = d.a.p0.s.u.c.d(this.o);
        d5.k(R.color.CAM_X0902);
        d5.l(R.dimen.L_X02);
        d5.n(R.string.J_X07);
        d5.e(this.L ? R.string.A_X01 : R.string.A_X09);
        d5.f(R.color.CAM_X0201);
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            EditText editText = this.y;
            if (editText != null && editText.getText().toString().length() > 50) {
                X(String.format(this.f64171e.getString(R.string.forum_rule_commit_error_toast), this.f64171e.getString(R.string.forum_rule_defalt_main_title)));
                return;
            }
            List<d.a.q0.u0.p1.f.b> list = this.I;
            if (list != null && list.size() > 0) {
                for (int i2 = 0; i2 < this.I.size(); i2++) {
                    new ForumRuleBaseData.ForumRuleItemData();
                    d.a.q0.u0.p1.f.b bVar = this.I.get(i2);
                    EditText l = bVar.l();
                    SpanGroupEditText k2 = bVar.k();
                    if (l != null && l.getText().toString().trim().length() > 30) {
                        X(String.format(this.f64171e.getString(R.string.forum_rule_commit_error_toast), String.format(this.f64171e.getString(R.string.forum_rule_defalt_has_forum_rule), d.a.q0.u0.p1.e.a.d(i2 + 1), this.f64171e.getString(R.string.forum_rule_title))));
                        return;
                    } else if (k2 != null && k2.getText().toString().length() > 1000) {
                        X(String.format(this.f64171e.getString(R.string.forum_rule_commit_error_toast), String.format(this.f64171e.getString(R.string.forum_rule_defalt_has_forum_rule), d.a.q0.u0.p1.e.a.d(i2 + 1), this.f64171e.getString(R.string.forum_rule_content))));
                        return;
                    }
                }
            }
            EditText editText2 = this.z;
            if (editText2 != null && editText2.getText().toString().length() > 500) {
                X(String.format(this.f64171e.getString(R.string.forum_rule_commit_error_toast), this.f64171e.getString(R.string.forum_rule_defalt_preface_title)));
                return;
            }
            K();
            this.f64175i.commitData(this.J, false);
        }
    }

    public final boolean w() {
        InterceptResult invokeV;
        int i2;
        int i3;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            ForumRuleBaseData forumRuleBaseData = this.J;
            if (forumRuleBaseData != null) {
                i2 = forumRuleBaseData.getTitle() != null ? this.J.getTitle().length() : 0;
                if (this.J.getList() == null || this.J.getList().size() <= 0) {
                    i4 = 0;
                    i5 = 0;
                } else {
                    i4 = 0;
                    i5 = 0;
                    for (int i6 = 0; i6 < this.J.getList().size(); i6++) {
                        ForumRuleBaseData.ForumRuleItemData forumRuleItemData = this.J.getList().get(i6);
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
                i3 = this.J.getPreface() != null ? this.J.getPreface().length() : 0;
            } else {
                i2 = 0;
                i3 = 0;
                i4 = 0;
                i5 = 0;
            }
            if (i2 + i4 + i5 + i3 > 5000) {
                B();
                X(String.format(this.f64171e.getString(R.string.forum_rule_draft_total_num_error_toast), 5000));
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            K();
            if (w()) {
                return;
            }
            ForumRuleBaseData forumRuleBaseData = this.J;
            if (forumRuleBaseData != null) {
                if (forumRuleBaseData.getTitle().length() > 50) {
                    B();
                    X(String.format(this.f64171e.getString(R.string.forum_rule_draft_error_toast), this.f64171e.getString(R.string.forum_rule_defalt_main_title), 50));
                    return;
                }
                if (this.J.getList() != null) {
                    for (int i2 = 0; i2 < this.J.getList().size(); i2++) {
                        ForumRuleBaseData.ForumRuleItemData forumRuleItemData = this.J.getList().get(i2);
                        if (forumRuleItemData != null) {
                            if (forumRuleItemData.getTitle().length() > 50) {
                                B();
                                X(String.format(this.f64171e.getString(R.string.forum_rule_draft_error_toast), this.f64171e.getString(R.string.forum_rule_defalt_item_title), 50));
                                return;
                            } else if (forumRuleItemData.getContent().length() > 1000) {
                                B();
                                X(String.format(this.f64171e.getString(R.string.forum_rule_draft_error_toast), this.f64171e.getString(R.string.forum_rule_defalt_item_content), 1000));
                                return;
                            }
                        }
                    }
                }
                if (this.J.getPreface().length() > 600) {
                    B();
                    X(String.format(this.f64171e.getString(R.string.forum_rule_draft_error_toast), this.f64171e.getString(R.string.forum_rule_defalt_preface_title), 600));
                    return;
                }
            }
            this.f64175i.commitData(this.J, true);
        }
    }

    public final boolean y() {
        InterceptResult invokeV;
        EditText editText;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            if (this.E == null || (editText = this.y) == null || editText.getText().toString().trim().length() <= 0) {
                return false;
            }
            EditText editText2 = this.z;
            if (editText2 == null || editText2.getText().toString().trim().length() > 0) {
                List<d.a.q0.u0.p1.f.b> list = this.I;
                if (list == null || list.size() <= 0) {
                    return true;
                }
                for (int i2 = 0; i2 < this.I.size(); i2++) {
                    d.a.q0.u0.p1.f.b bVar = this.I.get(i2);
                    EditText l = bVar.l();
                    SpanGroupEditText k2 = bVar.k();
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

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            String format = String.format(this.f64171e.getString(R.string.forum_rule_defalt_title_demo), this.f64173g, d.a.d.e.p.k.getDateStringMouth(new Date()));
            this.y.setText(format);
            this.y.setSelection(format.length());
            ViewGroup.LayoutParams layoutParams = this.y.getLayoutParams();
            layoutParams.width = -1;
            this.y.setLayoutParams(layoutParams);
        }
    }
}
