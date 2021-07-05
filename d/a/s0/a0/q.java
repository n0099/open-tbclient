package d.a.s0.a0;

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
import d.a.r0.r.q.b2;
import d.a.r0.r.s.a;
import d.a.r0.r.s.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f57139a;

    /* renamed from: b  reason: collision with root package name */
    public Context f57140b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.r0.r.s.j f57141c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.r0.r.s.l f57142d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.r0.r.s.a f57143e;

    /* renamed from: f  reason: collision with root package name */
    public i f57144f;

    /* renamed from: g  reason: collision with root package name */
    public CardPersonDynamicThreadData f57145g;

    /* renamed from: h  reason: collision with root package name */
    public List<d.a.r0.r.s.h> f57146h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.r0.r.s.h f57147i;
    public d.a.r0.r.s.h j;
    public d.a.r0.r.s.h k;
    public SetPrivacyModel l;
    public ForumManageModel m;
    public boolean n;
    public d.a.s0.z.a o;
    public l.d p;
    public SetPrivacyModel.a q;
    public l.d r;
    public l.d s;
    public d.a.c.a.e t;

    /* loaded from: classes9.dex */
    public class a implements l.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ q f57148a;

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
            this.f57148a = qVar;
        }

        @Override // d.a.r0.r.s.l.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f57148a.q();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements l.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ q f57149a;

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
            this.f57149a = qVar;
        }

        @Override // d.a.r0.r.s.l.d
        public void onClick() {
            int i2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f57149a.f57145g == null) {
                return;
            }
            this.f57149a.q();
            int i3 = 2;
            if (this.f57149a.f57145g.s == 1) {
                i2 = 2;
            } else {
                int i4 = this.f57149a.f57145g.s;
                i2 = 1;
            }
            if (this.f57149a.f57145g == null || !this.f57149a.f57145g.q) {
                if (this.f57149a.f57145g.getThreadData() != null) {
                    this.f57149a.o.f(this.f57149a.f57145g.getThreadData().n1());
                }
                i3 = (TbSingleton.getInstance().mCallFansTid == null || this.f57149a.f57145g.getThreadData() == null || !TbSingleton.getInstance().mCallFansTid.equals(this.f57149a.f57145g.getThreadData().n1())) ? 1 : 1;
                this.f57149a.o.b();
                if (this.f57149a.f57145g.getThreadData() != null) {
                    this.f57149a.o.d(i2, i3, this.f57149a.f57145g.getThreadData().n1());
                    return;
                }
                return;
            }
            this.f57149a.f57139a.showToast(R.string.privacy_thread_can_not_use_call_fans);
            if (this.f57149a.f57145g.getThreadData() != null) {
                this.f57149a.o.d(i2, 3, this.f57149a.f57145g.getThreadData().n1());
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ q f57150e;

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
            this.f57150e = qVar;
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (!d.a.c.e.p.j.A()) {
                    d.a.c.e.p.l.L(this.f57150e.f57140b, R.string.neterror);
                    return;
                }
                if (this.f57150e.f57145g.s != 1) {
                    if (this.f57150e.f57145g.s == 3) {
                        TiebaStatic.log(new StatisticItem("c12600").param("obj_type", 1));
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c12599").param("obj_type", 3));
                }
                if (this.f57150e.n) {
                    this.f57150e.m.P(this.f57150e.f57145g.r);
                }
                this.f57150e.m.R(this.f57150e.f57145g.f14501e, this.f57150e.f57145g.j, this.f57150e.f57145g.f14502f, this.f57150e.f57145g.f14503g, 0, 0, true, this.f57150e.f57145g.r.J());
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes9.dex */
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

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements SetPrivacyModel.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ q f57151a;

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
            this.f57151a = qVar;
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                d.a.c.e.p.l.M(this.f57151a.f57140b, str);
            }
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.f57151a.f57145g.q) {
                    this.f57151a.f57145g.q = false;
                    d.a.c.e.p.l.L(this.f57151a.f57140b, R.string.thread_has_open);
                    if (this.f57151a.f57147i != null) {
                        this.f57151a.f57147i.n(this.f57151a.f57140b.getString(R.string.set_thread_privacy));
                    }
                    if (this.f57151a.f57144f != null) {
                        this.f57151a.f57144f.a(false);
                        return;
                    }
                    return;
                }
                this.f57151a.f57145g.q = true;
                if (this.f57151a.f57147i != null) {
                    this.f57151a.f57147i.n(this.f57151a.f57140b.getString(R.string.set_thread_public_open));
                }
                if (this.f57151a.f57144f != null) {
                    this.f57151a.f57144f.a(true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016558, this.f57151a.f57145g.f14502f));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f implements l.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ q f57152a;

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
            this.f57152a = qVar;
        }

        @Override // d.a.r0.r.s.l.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!d.a.c.e.p.j.A()) {
                    d.a.c.e.p.l.L(this.f57152a.f57140b, R.string.neterror);
                    return;
                }
                if (this.f57152a.f57145g.q) {
                    if (this.f57152a.f57145g.s == 1) {
                        TiebaStatic.log(new StatisticItem("c12599").param("obj_type", 2));
                    }
                } else if (this.f57152a.f57145g.s != 1) {
                    if (this.f57152a.f57145g.s == 3) {
                        TiebaStatic.log(new StatisticItem("c12600").param("obj_type", 2));
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c12599").param("obj_type", 1));
                }
                if (this.f57152a.l == null) {
                    this.f57152a.l = new SetPrivacyModel(this.f57152a.f57139a, this.f57152a.f57145g);
                }
                if (!this.f57152a.l.C()) {
                    this.f57152a.l.D(this.f57152a.q);
                    this.f57152a.l.LoadData();
                }
                this.f57152a.q();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class g implements l.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ q f57153a;

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
            this.f57153a = qVar;
        }

        @Override // d.a.r0.r.s.l.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!d.a.c.e.p.j.A()) {
                    d.a.c.e.p.l.L(this.f57153a.f57140b, R.string.neterror);
                    return;
                }
                if (this.f57153a.f57145g != null && this.f57153a.m != null) {
                    this.f57153a.p();
                    this.f57153a.f57143e.show();
                }
                this.f57153a.q();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class h extends d.a.c.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ q f57154a;

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
            this.f57154a = qVar;
        }

        @Override // d.a.c.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && (obj instanceof ForumManageModel.b)) {
                ForumManageModel.b bVar = (ForumManageModel.b) obj;
                if (bVar.f21135c == 0) {
                    d.a.c.e.p.l.L(this.f57154a.f57140b, R.string.delete_success);
                    if (this.f57154a.f57145g != null) {
                        if (d.a.c.e.p.k.isEmpty(this.f57154a.f57145g.I)) {
                            if (d.a.c.e.p.k.isEmpty(this.f57154a.f57145g.f14502f)) {
                                return;
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016557, this.f57154a.f57145g.f14502f));
                            return;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921436, this.f57154a.f57145g.I));
                    }
                } else if (!d.a.c.e.p.k.isEmpty(bVar.f21134b)) {
                    d.a.c.e.p.l.M(this.f57154a.f57140b, bVar.f21134b);
                } else {
                    d.a.c.e.p.l.L(this.f57154a.f57140b, R.string.delete_fail);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
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
        this.f57139a = tbPageContext;
        this.f57140b = tbPageContext.getPageActivity();
        this.f57146h = new ArrayList();
        this.f57142d = new d.a.r0.r.s.l(this.f57140b);
        ForumManageModel forumManageModel = new ForumManageModel(this.f57139a);
        this.m = forumManageModel;
        forumManageModel.setLoadDataCallBack(this.t);
        this.o = new d.a.s0.z.a(tbPageContext);
    }

    public void n(CardPersonDynamicThreadData cardPersonDynamicThreadData, boolean z) {
        d.a.r0.r.s.h hVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, cardPersonDynamicThreadData, z) == null) {
            this.f57145g = cardPersonDynamicThreadData;
            if (cardPersonDynamicThreadData == null || (hVar = this.f57147i) == null) {
                return;
            }
            if (cardPersonDynamicThreadData.q) {
                hVar.n(this.f57140b.getString(R.string.set_thread_public_open));
            } else {
                hVar.n(this.f57140b.getString(R.string.set_thread_privacy));
            }
            this.f57147i.p(z);
            if (this.j != null) {
                if (TbSingleton.getInstance().mCanCallFans) {
                    this.j.n(this.f57140b.getString(R.string.call_fans));
                } else {
                    if (TbSingleton.getInstance().mCallFansTid != null && this.f57145g.getThreadData() != null && TbSingleton.getInstance().mCallFansTid.equals(this.f57145g.getThreadData().n1())) {
                        this.j.n(this.f57140b.getString(R.string.have_called_fans));
                    } else {
                        this.j.n(this.f57140b.getString(R.string.call_fans));
                    }
                    this.j.o(R.color.cp_cont_b_alpha33);
                }
                this.j.p(z);
            }
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f57141c == null) {
            d.a.r0.r.s.h hVar = new d.a.r0.r.s.h(this.f57142d);
            this.f57147i = hVar;
            hVar.m(this.r);
            if (!this.n) {
                this.f57146h.add(this.f57147i);
            }
            if (TbSingleton.getInstance().mShowCallFans && !this.n) {
                d.a.r0.r.s.h hVar2 = new d.a.r0.r.s.h(this.f57140b.getString(R.string.call_fans), this.f57142d);
                this.j = hVar2;
                hVar2.m(this.p);
                this.f57146h.add(this.j);
            }
            d.a.r0.r.s.h hVar3 = new d.a.r0.r.s.h(this.f57140b.getString(R.string.delete), this.f57142d);
            this.k = hVar3;
            hVar3.m(this.s);
            this.f57146h.add(this.k);
            this.f57142d.m(new a(this));
            this.f57142d.k(this.f57146h);
            this.f57141c = new d.a.r0.r.s.j(this.f57139a, this.f57142d);
        }
    }

    public final void p() {
        b2 b2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f57143e == null) {
            d.a.r0.r.s.a aVar = new d.a.r0.r.s.a(this.f57139a.getPageActivity());
            this.f57143e = aVar;
            if (this.n) {
                aVar.setMessageId(R.string.del_dynamic_confirm);
            } else {
                CardPersonDynamicThreadData cardPersonDynamicThreadData = this.f57145g;
                if (cardPersonDynamicThreadData != null && (b2Var = cardPersonDynamicThreadData.r) != null && b2Var.L1()) {
                    this.f57143e.setMessageId(R.string.del_work_thread_confirm);
                } else {
                    this.f57143e.setMessageId(R.string.del_thread_confirm);
                }
            }
            this.f57143e.setPositiveButton(R.string.dialog_ok, new c(this));
            this.f57143e.setNegativeButton(R.string.dialog_cancel, new d(this));
            this.f57143e.setCancelable(true);
            this.f57143e.create(this.f57139a);
        }
    }

    public void q() {
        d.a.r0.r.s.j jVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (jVar = this.f57141c) != null && jVar.isShowing()) {
            this.f57141c.dismiss();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            d.a.r0.r.s.l lVar = this.f57142d;
            if (lVar != null) {
                lVar.j();
            }
            d.a.r0.r.s.a aVar = this.f57143e;
            if (aVar != null) {
                d.a.r0.s0.a.a(this.f57139a, aVar.getRealView());
            }
        }
    }

    public void s(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, iVar) == null) {
            this.f57144f = iVar;
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.n = z;
        }
    }

    public void u() {
        d.a.r0.r.s.j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (jVar = this.f57141c) == null) {
            return;
        }
        jVar.l();
    }
}
