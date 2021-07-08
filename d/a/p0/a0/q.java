package d.a.p0.a0;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.model.SetPrivacyModel;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.r.q.b2;
import d.a.o0.r.s.a;
import d.a.o0.r.s.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f53884a;

    /* renamed from: b  reason: collision with root package name */
    public Context f53885b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.o0.r.s.j f53886c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.o0.r.s.l f53887d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.o0.r.s.a f53888e;

    /* renamed from: f  reason: collision with root package name */
    public i f53889f;

    /* renamed from: g  reason: collision with root package name */
    public CardPersonDynamicThreadData f53890g;

    /* renamed from: h  reason: collision with root package name */
    public List<d.a.o0.r.s.h> f53891h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.o0.r.s.h f53892i;
    public d.a.o0.r.s.h j;
    public d.a.o0.r.s.h k;
    public SetPrivacyModel l;
    public ForumManageModel m;
    public boolean n;
    public d.a.p0.z.a o;
    public l.d p;
    public SetPrivacyModel.a q;
    public l.d r;
    public l.d s;
    public d.a.c.a.e t;

    /* loaded from: classes7.dex */
    public class a implements l.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ q f53893a;

        public a(q qVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53893a = qVar;
        }

        @Override // d.a.o0.r.s.l.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f53893a.q();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements l.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ q f53894a;

        public b(q qVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53894a = qVar;
        }

        @Override // d.a.o0.r.s.l.d
        public void onClick() {
            int i2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f53894a.f53890g == null) {
                return;
            }
            this.f53894a.q();
            int i3 = 2;
            if (this.f53894a.f53890g.s == 1) {
                i2 = 2;
            } else {
                int i4 = this.f53894a.f53890g.s;
                i2 = 1;
            }
            if (this.f53894a.f53890g == null || !this.f53894a.f53890g.q) {
                if (this.f53894a.f53890g.getThreadData() != null) {
                    this.f53894a.o.f(this.f53894a.f53890g.getThreadData().n1());
                }
                i3 = (TbSingleton.getInstance().mCallFansTid == null || this.f53894a.f53890g.getThreadData() == null || !TbSingleton.getInstance().mCallFansTid.equals(this.f53894a.f53890g.getThreadData().n1())) ? 1 : 1;
                this.f53894a.o.b();
                if (this.f53894a.f53890g.getThreadData() != null) {
                    this.f53894a.o.d(i2, i3, this.f53894a.f53890g.getThreadData().n1());
                    return;
                }
                return;
            }
            this.f53894a.f53884a.showToast(R.string.privacy_thread_can_not_use_call_fans);
            if (this.f53894a.f53890g.getThreadData() != null) {
                this.f53894a.o.d(i2, 3, this.f53894a.f53890g.getThreadData().n1());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ q f53895e;

        public c(q qVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53895e = qVar;
        }

        @Override // d.a.o0.r.s.a.e
        public void onClick(d.a.o0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (!d.a.c.e.p.j.A()) {
                    d.a.c.e.p.l.L(this.f53895e.f53885b, R.string.neterror);
                    return;
                }
                if (this.f53895e.f53890g.s != 1) {
                    if (this.f53895e.f53890g.s == 3) {
                        TiebaStatic.log(new StatisticItem("c12600").param("obj_type", 1));
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c12599").param("obj_type", 3));
                }
                if (this.f53895e.n) {
                    this.f53895e.m.P(this.f53895e.f53890g.r);
                }
                this.f53895e.m.R(this.f53895e.f53890g.f14540e, this.f53895e.f53890g.j, this.f53895e.f53890g.f14541f, this.f53895e.f53890g.f14542g, 0, 0, true, this.f53895e.f53890g.r.J());
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(q qVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // d.a.o0.r.s.a.e
        public void onClick(d.a.o0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements SetPrivacyModel.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ q f53896a;

        public e(q qVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53896a = qVar;
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                d.a.c.e.p.l.M(this.f53896a.f53885b, str);
            }
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.f53896a.f53890g.q) {
                    this.f53896a.f53890g.q = false;
                    d.a.c.e.p.l.L(this.f53896a.f53885b, R.string.thread_has_open);
                    if (this.f53896a.f53892i != null) {
                        this.f53896a.f53892i.n(this.f53896a.f53885b.getString(R.string.set_thread_privacy));
                    }
                    if (this.f53896a.f53889f != null) {
                        this.f53896a.f53889f.a(false);
                        return;
                    }
                    return;
                }
                this.f53896a.f53890g.q = true;
                if (this.f53896a.f53892i != null) {
                    this.f53896a.f53892i.n(this.f53896a.f53885b.getString(R.string.set_thread_public_open));
                }
                if (this.f53896a.f53889f != null) {
                    this.f53896a.f53889f.a(true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016558, this.f53896a.f53890g.f14541f));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements l.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ q f53897a;

        public f(q qVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53897a = qVar;
        }

        @Override // d.a.o0.r.s.l.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!d.a.c.e.p.j.A()) {
                    d.a.c.e.p.l.L(this.f53897a.f53885b, R.string.neterror);
                    return;
                }
                if (this.f53897a.f53890g.q) {
                    if (this.f53897a.f53890g.s == 1) {
                        TiebaStatic.log(new StatisticItem("c12599").param("obj_type", 2));
                    }
                } else if (this.f53897a.f53890g.s != 1) {
                    if (this.f53897a.f53890g.s == 3) {
                        TiebaStatic.log(new StatisticItem("c12600").param("obj_type", 2));
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c12599").param("obj_type", 1));
                }
                if (this.f53897a.l == null) {
                    this.f53897a.l = new SetPrivacyModel(this.f53897a.f53884a, this.f53897a.f53890g);
                }
                if (!this.f53897a.l.C()) {
                    this.f53897a.l.D(this.f53897a.q);
                    this.f53897a.l.LoadData();
                }
                this.f53897a.q();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements l.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ q f53898a;

        public g(q qVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53898a = qVar;
        }

        @Override // d.a.o0.r.s.l.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!d.a.c.e.p.j.A()) {
                    d.a.c.e.p.l.L(this.f53898a.f53885b, R.string.neterror);
                    return;
                }
                if (this.f53898a.f53890g != null && this.f53898a.m != null) {
                    this.f53898a.p();
                    this.f53898a.f53888e.show();
                }
                this.f53898a.q();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h extends d.a.c.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ q f53899a;

        public h(q qVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53899a = qVar;
        }

        @Override // d.a.c.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && (obj instanceof ForumManageModel.b)) {
                ForumManageModel.b bVar = (ForumManageModel.b) obj;
                if (bVar.f21181c == 0) {
                    d.a.c.e.p.l.L(this.f53899a.f53885b, R.string.delete_success);
                    if (this.f53899a.f53890g != null) {
                        if (d.a.c.e.p.k.isEmpty(this.f53899a.f53890g.I)) {
                            if (d.a.c.e.p.k.isEmpty(this.f53899a.f53890g.f14541f)) {
                                return;
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016557, this.f53899a.f53890g.f14541f));
                            return;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921436, this.f53899a.f53890g.I));
                    }
                } else if (!d.a.c.e.p.k.isEmpty(bVar.f21180b)) {
                    d.a.c.e.p.l.M(this.f53899a.f53885b, bVar.f21180b);
                } else {
                    d.a.c.e.p.l.L(this.f53899a.f53885b, R.string.delete_fail);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface i {
        void a(boolean z);
    }

    public q(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = false;
        this.p = new b(this);
        this.q = new e(this);
        this.r = new f(this);
        this.s = new g(this);
        this.t = new h(this);
        if (tbPageContext == null) {
            return;
        }
        this.f53884a = tbPageContext;
        this.f53885b = tbPageContext.getPageActivity();
        this.f53891h = new ArrayList();
        this.f53887d = new d.a.o0.r.s.l(this.f53885b);
        ForumManageModel forumManageModel = new ForumManageModel(this.f53884a);
        this.m = forumManageModel;
        forumManageModel.setLoadDataCallBack(this.t);
        this.o = new d.a.p0.z.a(tbPageContext);
    }

    public void n(CardPersonDynamicThreadData cardPersonDynamicThreadData, boolean z) {
        d.a.o0.r.s.h hVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, cardPersonDynamicThreadData, z) == null) {
            this.f53890g = cardPersonDynamicThreadData;
            if (cardPersonDynamicThreadData == null || (hVar = this.f53892i) == null) {
                return;
            }
            if (cardPersonDynamicThreadData.q) {
                hVar.n(this.f53885b.getString(R.string.set_thread_public_open));
            } else {
                hVar.n(this.f53885b.getString(R.string.set_thread_privacy));
            }
            this.f53892i.p(z);
            if (this.j != null) {
                if (TbSingleton.getInstance().mCanCallFans) {
                    this.j.n(this.f53885b.getString(R.string.call_fans));
                } else {
                    if (TbSingleton.getInstance().mCallFansTid != null && this.f53890g.getThreadData() != null && TbSingleton.getInstance().mCallFansTid.equals(this.f53890g.getThreadData().n1())) {
                        this.j.n(this.f53885b.getString(R.string.have_called_fans));
                    } else {
                        this.j.n(this.f53885b.getString(R.string.call_fans));
                    }
                    this.j.o(R.color.cp_cont_b_alpha33);
                }
                this.j.p(z);
            }
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f53886c == null) {
            d.a.o0.r.s.h hVar = new d.a.o0.r.s.h(this.f53887d);
            this.f53892i = hVar;
            hVar.m(this.r);
            if (!this.n) {
                this.f53891h.add(this.f53892i);
            }
            if (TbSingleton.getInstance().mShowCallFans && !this.n) {
                d.a.o0.r.s.h hVar2 = new d.a.o0.r.s.h(this.f53885b.getString(R.string.call_fans), this.f53887d);
                this.j = hVar2;
                hVar2.m(this.p);
                this.f53891h.add(this.j);
            }
            d.a.o0.r.s.h hVar3 = new d.a.o0.r.s.h(this.f53885b.getString(R.string.delete), this.f53887d);
            this.k = hVar3;
            hVar3.m(this.s);
            this.f53891h.add(this.k);
            this.f53887d.m(new a(this));
            this.f53887d.k(this.f53891h);
            this.f53886c = new d.a.o0.r.s.j(this.f53884a, this.f53887d);
        }
    }

    public final void p() {
        b2 b2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f53888e == null) {
            d.a.o0.r.s.a aVar = new d.a.o0.r.s.a(this.f53884a.getPageActivity());
            this.f53888e = aVar;
            if (this.n) {
                aVar.setMessageId(R.string.del_dynamic_confirm);
            } else {
                CardPersonDynamicThreadData cardPersonDynamicThreadData = this.f53890g;
                if (cardPersonDynamicThreadData != null && (b2Var = cardPersonDynamicThreadData.r) != null && b2Var.L1()) {
                    this.f53888e.setMessageId(R.string.del_work_thread_confirm);
                } else {
                    this.f53888e.setMessageId(R.string.del_thread_confirm);
                }
            }
            this.f53888e.setPositiveButton(R.string.dialog_ok, new c(this));
            this.f53888e.setNegativeButton(R.string.dialog_cancel, new d(this));
            this.f53888e.setCancelable(true);
            this.f53888e.create(this.f53884a);
        }
    }

    public void q() {
        d.a.o0.r.s.j jVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (jVar = this.f53886c) != null && jVar.isShowing()) {
            this.f53886c.dismiss();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            d.a.o0.r.s.l lVar = this.f53887d;
            if (lVar != null) {
                lVar.j();
            }
            d.a.o0.r.s.a aVar = this.f53888e;
            if (aVar != null) {
                d.a.o0.s0.a.a(this.f53884a, aVar.getRealView());
            }
        }
    }

    public void s(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, iVar) == null) {
            this.f53889f = iVar;
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.n = z;
        }
    }

    public void u() {
        d.a.o0.r.s.j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (jVar = this.f53886c) == null) {
            return;
        }
        jVar.l();
    }
}
