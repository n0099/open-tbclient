package d.a.s0.a0;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.BlueCheckRadioButton;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.r.q.b2;
import d.a.r0.r.q.m0;
import d.a.r0.r.s.a;
import d.a.r0.r.s.l;
import d.a.s0.u0.v0;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import tbclient.BawuThrones;
/* loaded from: classes9.dex */
public class c0 extends d.a.r0.r.s.j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public final CompoundButton.OnCheckedChangeListener B;
    public final d.a.c.a.e C;
    public final l.e D;
    public TbPageContext o;
    public Context p;
    public final d.a.r0.r.s.l q;
    public d.a.r0.r.s.a r;
    public d.a.r0.r.s.a s;
    public Dialog t;
    public final List<d.a.r0.r.s.h> u;
    public String v;
    public String w;
    public List<BlueCheckRadioButton> x;
    public b2 y;
    public ForumManageModel z;

    /* loaded from: classes9.dex */
    public class a implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c0 f57037e;

        public a(c0 c0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57037e = c0Var;
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (aVar != null) {
                    aVar.dismiss();
                }
                if (!d.a.c.e.p.j.A()) {
                    d.a.c.e.p.l.L(this.f57037e.p, R.string.neterror);
                } else {
                    this.f57037e.b0(null);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c0 f57038e;

        public b(c0 c0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57038e = c0Var;
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                return;
            }
            aVar.dismiss();
        }
    }

    /* loaded from: classes9.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c0 f57039e;

        public c(c0 c0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57039e = c0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                d.a.c.e.m.g.b(this.f57039e.t, this.f57039e.o);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c0 f57040e;

        public d(c0 c0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57040e = c0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                d.a.c.e.m.g.b(this.f57040e.t, this.f57040e.o);
                c0 c0Var = this.f57040e;
                c0Var.d0(c0Var.w, false);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c0 f57041e;

        public e(c0 c0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57041e = c0Var;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) && z && (compoundButton.getTag() instanceof String)) {
                this.f57041e.w = (String) compoundButton.getTag();
                if (this.f57041e.x != null) {
                    for (BlueCheckRadioButton blueCheckRadioButton : this.f57041e.x) {
                        String str = (String) blueCheckRadioButton.getTag();
                        if (str != null && this.f57041e.w != null && !str.equals(this.f57041e.w)) {
                            blueCheckRadioButton.setChecked(false);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f extends d.a.c.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c0 f57042a;

        /* loaded from: classes9.dex */
        public class a implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(f fVar) {
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

            @Override // d.a.r0.r.s.a.e
            public void onClick(d.a.r0.r.s.a aVar) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                    return;
                }
                aVar.dismiss();
            }
        }

        public f(c0 c0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57042a = c0Var;
        }

        @Override // d.a.c.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, obj) == null) || obj == null || this.f57042a.z == null) {
                return;
            }
            switch (this.f57042a.z.getLoadDataMode()) {
                case 0:
                    ForumManageModel.b bVar = (ForumManageModel.b) obj;
                    if (bVar == null || bVar.f21136d != 0) {
                        d.a.c.e.p.l.M(this.f57042a.p, this.f57042a.T(R.string.delete_fail, new Object[0]));
                        return;
                    } else if (bVar.f21133a) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, this.f57042a.y.c0()));
                        d.a.c.e.p.l.L(this.f57042a.p, R.string.delete_success);
                        return;
                    } else {
                        String T = !TextUtils.isEmpty(bVar.f21134b) ? bVar.f21134b : this.f57042a.T(R.string.delete_fail, new Object[0]);
                        if (bVar.f21135c == 1211066) {
                            if (this.f57042a.s == null) {
                                c0 c0Var = this.f57042a;
                                c0Var.s = new d.a.r0.r.s.a(c0Var.o.getPageActivity());
                                this.f57042a.s.setMessage(T);
                                this.f57042a.s.setPositiveButton(R.string.dialog_known, new a(this));
                                this.f57042a.s.setCancelable(true);
                                this.f57042a.s.create(this.f57042a.o);
                            }
                            this.f57042a.s.show();
                            return;
                        }
                        d.a.c.e.p.l.M(this.f57042a.p, T);
                        return;
                    }
                case 1:
                    ForumManageModel.d dVar = (ForumManageModel.d) obj;
                    if (dVar == null) {
                        d.a.c.e.p.l.M(this.f57042a.p, this.f57042a.T(R.string.mute_fail, new Object[0]));
                        return;
                    } else if (dVar.f21140a) {
                        d.a.c.e.p.l.M(this.f57042a.p, !TextUtils.isEmpty(dVar.f21141b) ? dVar.f21141b : this.f57042a.T(R.string.mute_success, new Object[0]));
                        return;
                    } else {
                        d.a.c.e.p.l.M(this.f57042a.p, !TextUtils.isEmpty(dVar.f21141b) ? dVar.f21141b : this.f57042a.T(R.string.mute_fail, new Object[0]));
                        return;
                    }
                case 2:
                case 3:
                case 4:
                case 5:
                    c0 c0Var2 = this.f57042a;
                    c0Var2.S(c0Var2.z.getLoadDataMode(), (ForumManageModel.g) obj);
                    return;
                case 6:
                    ForumManageModel.g gVar = (ForumManageModel.g) obj;
                    if (gVar == null || !gVar.f21154a) {
                        d.a.c.e.p.l.M(this.f57042a.p, this.f57042a.T(R.string.operation_failed, new Object[0]));
                        return;
                    } else {
                        this.f57042a.a0(gVar.f21156c);
                        return;
                    }
                default:
                    return;
            }
        }
    }

    /* loaded from: classes9.dex */
    public class g implements l.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c0 f57043e;

        public g(c0 c0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57043e = c0Var;
        }

        @Override // d.a.r0.r.s.l.e
        public void onItemClick(d.a.r0.r.s.l lVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, lVar, i2, view) == null) {
                this.f57043e.dismiss();
                if (!d.a.c.e.p.j.z()) {
                    d.a.c.e.p.l.L(this.f57043e.p, R.string.network_not_available);
                    return;
                }
                if (i2 == 1) {
                    if (this.f57043e.y != null && this.f57043e.y.H() != null) {
                        if (UtilHelper.isCurrentAccount(this.f57043e.y.H().getUserId())) {
                            c0 c0Var = this.f57043e;
                            c0Var.Z(c0Var.y.L1());
                        } else {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921515, new d.a.s0.h.g(1, this.f57043e.z, this.f57043e.y)));
                        }
                    }
                } else if (i2 == 2) {
                    this.f57043e.c0();
                } else if (i2 == 3) {
                    this.f57043e.e0();
                } else if (i2 == 4) {
                    c0 c0Var2 = this.f57043e;
                    c0Var2.d0(c0Var2.v, true);
                } else if (i2 == 5) {
                    this.f57043e.L();
                } else if (i2 == 6) {
                    this.f57043e.X();
                } else if (i2 == 7) {
                    this.f57043e.K();
                } else if (i2 == 8) {
                    this.f57043e.J();
                }
                this.f57043e.V(i2);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c0(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((d.a.c.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.v = "0";
        this.w = "0";
        this.A = false;
        this.B = new e(this);
        this.C = new f(this);
        this.D = new g(this);
        this.o = tbPageContext;
        this.p = tbPageContext.getPageActivity();
        this.u = new ArrayList();
        d.a.r0.r.s.l lVar = new d.a.r0.r.s.l(this.p);
        this.q = lVar;
        lVar.q(T(R.string.thread_manager, new Object[0]));
        this.q.n(this.D);
        ForumManageModel forumManageModel = new ForumManageModel(this.o);
        this.z = forumManageModel;
        forumManageModel.setLoadDataCallBack(this.C);
        this.A = z;
        h(this.q);
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921475, this.y));
        }
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            d.a.s0.u0.a.h().p(true, false);
        }
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            d.a.s0.u0.b.e().m(true, false);
        }
    }

    public final BlueCheckRadioButton M(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            BlueCheckRadioButton blueCheckRadioButton = new BlueCheckRadioButton(this.p);
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, d.a.c.e.p.l.g(this.p, R.dimen.ds100));
            blueCheckRadioButton.setOnCheckedChangeListener(this.B);
            blueCheckRadioButton.setTag(str);
            blueCheckRadioButton.setText(str2);
            blueCheckRadioButton.setLayoutParams(layoutParams);
            return blueCheckRadioButton;
        }
        return (BlueCheckRadioButton) invokeLL.objValue;
    }

    public final void N() {
        List<d.a.r0.r.s.h> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.y == null || (list = this.u) == null || this.q == null) {
            return;
        }
        list.clear();
        if (d.a.s0.u0.j.c(d.a.s0.u0.j.a()) && !d.a.s0.u0.j.e()) {
            if (!this.y.I1() && (this.y.H() == null || !this.y.H().isForumBusinessAccount() || this.y.isSelf() || v0.isOn())) {
                int i2 = R.string.delete_page;
                if (this.y.L1()) {
                    i2 = R.string.delete_page_work;
                }
                this.u.add(new d.a.r0.r.s.h(1, T(i2, new Object[0]), this.q));
            }
            if (!UtilHelper.isCurrentAccount(this.y.H() != null ? this.y.H().getUserId() : "") && (this.y.H() == null || !this.y.H().isForumBusinessAccount())) {
                this.u.add(new d.a.r0.r.s.h(2, T(R.string.thread_forbid, new Object[0]), this.q));
            }
        }
        if (d.a.s0.u0.j.d() || d.a.s0.u0.j.e()) {
            this.u.add(new d.a.r0.r.s.h(3, T(this.y.m0() == 1 ? R.string.cancel_top : R.string.top, new Object[0]), this.q));
        }
        if (d.a.s0.u0.j.d() || d.a.s0.u0.j.f()) {
            this.u.add(new d.a.r0.r.s.h(4, T(this.y.l0() == 1 ? R.string.cancel_good : R.string.commit_good, new Object[0]), this.q));
        }
        if (d.a.s0.u0.j.d()) {
            this.u.add(new d.a.r0.r.s.h(6, T(R.string.frs_recommend_thread, new Object[0]), this.q));
        }
        if (d.a.s0.u0.j.d() && this.A) {
            this.u.add(new d.a.r0.r.s.h(7, T(R.string.frs_move_area_thread, new Object[0]), this.q));
        }
        if (d.a.s0.u0.j.d() || d.a.s0.u0.j.e()) {
            this.u.add(new d.a.r0.r.s.h(8, T(R.string.frs_forum_bawu_send_broadcast, new Object[0]), this.q));
        }
        if (!d.a.s0.u0.j.e() && d.a.s0.u0.b.e().h() && this.A && (this.y.H() == null || !this.y.H().isForumBusinessAccount() || this.y.isSelf() || v0.isOn())) {
            this.u.add(new d.a.r0.r.s.h(5, T(R.string.multi_delete, new Object[0]), this.q));
        }
        this.q.k(this.u);
    }

    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            P();
        }
    }

    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            Q();
            R();
            dismiss();
        }
    }

    public void Q() {
        d.a.r0.r.s.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (aVar = this.r) != null && aVar.isShowing()) {
            this.r.dismiss();
        }
    }

    public void R() {
        Dialog dialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (dialog = this.t) != null && dialog.isShowing()) {
            this.t.dismiss();
        }
    }

    public final void S(int i2, ForumManageModel.g gVar) {
        String T;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048585, this, i2, gVar) == null) {
            b2 b2Var = this.y;
            if (b2Var != null && gVar != null && gVar.f21154a) {
                String str = "";
                boolean z = true;
                if (i2 == 2) {
                    b2Var.C3(1);
                    d.a.r0.r.q.a0 a0Var = new d.a.r0.r.q.a0();
                    a0Var.f55840a = 2;
                    a0Var.f55841b = this.y.n1();
                    if (d.a.s0.u0.j.d()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921469, a0Var));
                    } else {
                        str = U(gVar.f21155b, R.string.set_good_success);
                        z = false;
                    }
                } else {
                    if (i2 == 3) {
                        b2Var.C3(0);
                        str = U(gVar.f21155b, R.string.operation_success);
                    } else if (i2 == 4) {
                        b2Var.D3(1);
                        d.a.r0.r.q.a0 a0Var2 = new d.a.r0.r.q.a0();
                        a0Var2.f55840a = 1;
                        a0Var2.f55841b = this.y.n1();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921469, a0Var2));
                    } else if (i2 == 5) {
                        b2Var.D3(0);
                        str = U(gVar.f21155b, R.string.operation_success);
                    }
                    z = false;
                }
                ForumManageModel.e eVar = new ForumManageModel.e();
                eVar.f21142a = this.y.c0();
                eVar.f21144c = this.y.W();
                eVar.f21143b = String.valueOf(this.y.Q());
                eVar.f21145d = i2;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921316, eVar));
                if (TextUtils.isEmpty(str)) {
                    str = T(R.string.operation_success, new Object[0]);
                }
                if (z) {
                    return;
                }
                d.a.c.e.p.l.M(this.p, str);
                return;
            }
            if (gVar != null && !TextUtils.isEmpty(gVar.f21155b)) {
                T = gVar.f21155b;
            } else {
                T = T(R.string.operation_failed, new Object[0]);
            }
            d.a.c.e.p.l.M(this.p, T);
        }
    }

    public final String T(int i2, Object... objArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048586, this, i2, objArr)) == null) {
            Context context = this.p;
            if (context == null) {
                return null;
            }
            return context.getString(i2, objArr);
        }
        return (String) invokeIL.objValue;
    }

    public final String U(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048587, this, str, i2)) == null) ? !TextUtils.isEmpty(str) ? str : T(i2, new Object[0]) : (String) invokeLI.objValue;
    }

    public final void V(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || this.y == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_MANAGE_ITEM_CLICK).param("obj_type", i2).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.y.Q()).param("tid", this.y.c0()));
    }

    public void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            d.a.r0.r.s.l lVar = this.q;
            if (lVar != null) {
                lVar.j();
            }
            d.a.r0.r.s.a aVar = this.r;
            if (aVar != null) {
                d.a.r0.s0.a.a(this.o, aVar.getRealView());
            }
            d.a.r0.r.s.a aVar2 = this.s;
            if (aVar2 != null) {
                d.a.r0.s0.a.a(this.o, aVar2.getRealView());
            }
        }
    }

    public final void X() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || this.o == null || this.y == null) {
            return;
        }
        BawuThrones b2 = d.a.s0.u0.c.c().b();
        if (b2 == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921465));
        } else if (b2.total_recommend_num.intValue() == b2.used_recommend_num.intValue()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921465));
        } else if (d.a.r0.r.d0.b.j().g("key_frs_recommend_tip", true)) {
            d.a.s0.u0.c.c().f(this.o, String.valueOf(this.y.Q()), this.y.c0());
        } else {
            d.a.s0.u0.c.c().d(String.valueOf(this.y.Q()), this.y.c0());
        }
    }

    public void Y(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, b2Var) == null) {
            this.y = b2Var;
            N();
        }
    }

    public void Z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            Q();
            TbPageContext tbPageContext = this.o;
            if (tbPageContext == null) {
                return;
            }
            if (this.r == null) {
                d.a.r0.r.s.a aVar = new d.a.r0.r.s.a(tbPageContext.getPageActivity());
                this.r = aVar;
                if (z) {
                    aVar.setMessageId(R.string.del_work_thread_confirm);
                } else {
                    aVar.setMessageId(R.string.del_thread_confirm);
                }
                this.r.setPositiveButton(R.string.dialog_ok, new a(this));
                this.r.setNegativeButton(R.string.dialog_cancel, new b(this));
                this.r.setCancelable(true);
                this.r.create(this.o);
            }
            this.r.show();
        }
    }

    public final void a0(ArrayList<m0> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, arrayList) == null) {
            if (this.t == null) {
                View inflate = LayoutInflater.from(this.p).inflate(R.layout.commit_good, (ViewGroup) null);
                Dialog dialog = new Dialog(this.p, R.style.common_alert_dialog);
                this.t = dialog;
                dialog.setCanceledOnTouchOutside(true);
                this.t.setCancelable(true);
                this.t.setContentView(inflate);
                WindowManager.LayoutParams attributes = this.t.getWindow().getAttributes();
                attributes.width = d.a.c.e.p.l.g(this.p, R.dimen.ds540);
                this.t.getWindow().setAttributes(attributes);
                inflate.findViewById(R.id.dialog_button_cancel).setOnClickListener(new c(this));
                inflate.findViewById(R.id.dialog_button_ok).setOnClickListener(new d(this));
            }
            d.a.r0.s0.a.a(this.o, this.t.findViewById(R.id.commit_good_layout));
            LinearLayout linearLayout = (LinearLayout) this.t.findViewById(R.id.good_class_group);
            linearLayout.removeAllViews();
            this.x = new ArrayList();
            BlueCheckRadioButton M = M(this.v, T(R.string.thread_good_class, new Object[0]));
            M.setChecked(true);
            linearLayout.addView(M);
            this.x.add(M);
            if (arrayList != null) {
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    m0 m0Var = arrayList.get(i2);
                    if (m0Var != null && !TextUtils.isEmpty(m0Var.b()) && m0Var.a() > 0) {
                        BlueCheckRadioButton M2 = M(String.valueOf(m0Var.a()), m0Var.b());
                        this.x.add(M2);
                        View view = new View(this.p);
                        view.setLayoutParams(new LinearLayout.LayoutParams(-1, d.a.c.e.p.l.g(this.p, R.dimen.ds1)));
                        linearLayout.addView(view);
                        linearLayout.addView(M2);
                        SkinManager.setBackgroundColor(view, R.color.CAM_X0204);
                    }
                }
                ScrollView scrollView = (ScrollView) this.t.findViewById(R.id.good_scroll);
                ViewGroup.LayoutParams layoutParams = scrollView.getLayoutParams();
                int size2 = arrayList.size();
                if (size2 == 0 || size2 == 1) {
                    layoutParams.height = d.a.c.e.p.l.e(this.p, 120.0f);
                } else if (size2 != 2) {
                    layoutParams.height = d.a.c.e.p.l.e(this.p, 220.0f);
                } else {
                    layoutParams.height = d.a.c.e.p.l.e(this.p, 186.0f);
                }
                scrollView.setLayoutParams(layoutParams);
                scrollView.removeAllViews();
                scrollView.addView(linearLayout);
            }
            d.a.c.e.m.g.j(this.t, this.o);
        }
    }

    public final void b0(JSONArray jSONArray) {
        b2 b2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, jSONArray) == null) || this.z == null || (b2Var = this.y) == null || b2Var.H() == null) {
            return;
        }
        String userId = this.y.H().getUserId();
        String c0 = this.y.c0();
        String W = this.y.W();
        String valueOf = String.valueOf(this.y.Q());
        boolean isCurrentAccount = UtilHelper.isCurrentAccount(userId);
        if (jSONArray != null) {
            this.z.Q(StringHelper.JsonArrayToString(jSONArray));
        }
        this.z.R(valueOf, W, c0, null, 0, 1, isCurrentAccount, this.y.J());
    }

    public final void c0() {
        b2 b2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || this.p == null || (b2Var = this.y) == null || b2Var.H() == null) {
            return;
        }
        String userId = this.y.H().getUserId();
        String userName = this.y.H().getUserName();
        String name_show = this.y.H().getName_show();
        String c0 = this.y.c0();
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.p, String.valueOf(this.y.Q()), this.y.W(), c0, userId, userName, name_show, null, this.y.H().getPortrait())));
    }

    public final void d0(String str, boolean z) {
        b2 b2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048596, this, str, z) == null) || (b2Var = this.y) == null || this.z == null) {
            return;
        }
        this.z.S(String.valueOf(this.y.Q()), this.y.W(), this.y.c0(), b2Var.l0() == 1 ? 3 : z ? 6 : 2, str);
    }

    public final void e0() {
        b2 b2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (b2Var = this.y) == null || this.z == null) {
            return;
        }
        int i2 = b2Var.m0() == 1 ? 5 : 4;
        this.z.S(String.valueOf(this.y.Q()), this.y.W(), this.y.c0(), i2, null);
    }
}
