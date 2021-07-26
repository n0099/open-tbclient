package d.a.q0.a0;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.model.SetPrivacyModel;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.s.q.b2;
import d.a.p0.s.s.a;
import d.a.p0.s.s.l;
import d.a.p0.t.c.i0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f54427a;

    /* renamed from: b  reason: collision with root package name */
    public Context f54428b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.p0.s.s.j f54429c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.p0.s.s.l f54430d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.p0.s.s.a f54431e;

    /* renamed from: f  reason: collision with root package name */
    public j f54432f;

    /* renamed from: g  reason: collision with root package name */
    public CardPersonDynamicThreadData f54433g;

    /* renamed from: h  reason: collision with root package name */
    public List<d.a.p0.s.s.h> f54434h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.p0.s.s.h f54435i;
    public d.a.p0.s.s.h j;
    public d.a.p0.s.s.h k;
    public d.a.p0.s.s.h l;
    public SetPrivacyModel m;
    public ForumManageModel n;
    public boolean o;
    public d.a.q0.z.a p;
    public l.d q;
    public SetPrivacyModel.a r;
    public l.d s;
    public l.d t;
    public l.d u;
    public d.a.d.a.e v;

    /* loaded from: classes7.dex */
    public class a implements l.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ q f54436a;

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
            this.f54436a = qVar;
        }

        @Override // d.a.p0.s.s.l.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f54436a.q();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements l.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ q f54437a;

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
            this.f54437a = qVar;
        }

        @Override // d.a.p0.s.s.l.d
        public void onClick() {
            int i2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f54437a.f54433g == null) {
                return;
            }
            this.f54437a.q();
            int i3 = 2;
            if (this.f54437a.f54433g.s == 1) {
                i2 = 2;
            } else {
                int i4 = this.f54437a.f54433g.s;
                i2 = 1;
            }
            if (this.f54437a.f54433g == null || !this.f54437a.f54433g.q) {
                if (this.f54437a.f54433g.getThreadData() != null) {
                    this.f54437a.p.f(this.f54437a.f54433g.getThreadData().o1());
                }
                i3 = (TbSingleton.getInstance().mCallFansTid == null || this.f54437a.f54433g.getThreadData() == null || !TbSingleton.getInstance().mCallFansTid.equals(this.f54437a.f54433g.getThreadData().o1())) ? 1 : 1;
                this.f54437a.p.b();
                if (this.f54437a.f54433g.getThreadData() != null) {
                    this.f54437a.p.d(i2, i3, this.f54437a.f54433g.getThreadData().o1());
                    return;
                }
                return;
            }
            this.f54437a.f54427a.showToast(R.string.privacy_thread_can_not_use_call_fans);
            if (this.f54437a.f54433g.getThreadData() != null) {
                this.f54437a.p.d(i2, 3, this.f54437a.f54433g.getThreadData().o1());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ q f54438e;

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
            this.f54438e = qVar;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (!d.a.d.e.p.j.A()) {
                    d.a.d.e.p.l.L(this.f54438e.f54428b, R.string.neterror);
                    return;
                }
                if (this.f54438e.f54433g.s != 1) {
                    if (this.f54438e.f54433g.s == 3) {
                        TiebaStatic.log(new StatisticItem("c12600").param("obj_type", 1));
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c12599").param("obj_type", 3));
                }
                if (this.f54438e.o) {
                    this.f54438e.n.P(this.f54438e.f54433g.r);
                }
                this.f54438e.n.R(this.f54438e.f54433g.f14588e, this.f54438e.f54433g.j, this.f54438e.f54433g.f14589f, this.f54438e.f54433g.f14590g, 0, 0, true, this.f54438e.f54433g.r.J());
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

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
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
        public final /* synthetic */ q f54439a;

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
            this.f54439a = qVar;
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                d.a.d.e.p.l.M(this.f54439a.f54428b, str);
            }
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.f54439a.f54433g.q) {
                    this.f54439a.f54433g.q = false;
                    d.a.d.e.p.l.L(this.f54439a.f54428b, R.string.thread_has_open);
                    if (this.f54439a.f54435i != null) {
                        this.f54439a.f54435i.n(this.f54439a.f54428b.getString(R.string.set_thread_privacy));
                    }
                    if (this.f54439a.f54432f != null) {
                        this.f54439a.f54432f.a(false);
                        return;
                    }
                    return;
                }
                this.f54439a.f54433g.q = true;
                if (this.f54439a.f54435i != null) {
                    this.f54439a.f54435i.n(this.f54439a.f54428b.getString(R.string.set_thread_public_open));
                }
                if (this.f54439a.f54432f != null) {
                    this.f54439a.f54432f.a(true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016558, this.f54439a.f54433g.f14589f));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements l.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ q f54440a;

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
            this.f54440a = qVar;
        }

        @Override // d.a.p0.s.s.l.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!d.a.d.e.p.j.A()) {
                    d.a.d.e.p.l.L(this.f54440a.f54428b, R.string.neterror);
                    return;
                }
                if (this.f54440a.f54433g.q) {
                    if (this.f54440a.f54433g.s == 1) {
                        TiebaStatic.log(new StatisticItem("c12599").param("obj_type", 2));
                    }
                } else if (this.f54440a.f54433g.s != 1) {
                    if (this.f54440a.f54433g.s == 3) {
                        TiebaStatic.log(new StatisticItem("c12600").param("obj_type", 2));
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c12599").param("obj_type", 1));
                }
                if (this.f54440a.m == null) {
                    this.f54440a.m = new SetPrivacyModel(this.f54440a.f54427a, this.f54440a.f54433g);
                }
                if (!this.f54440a.m.C()) {
                    this.f54440a.m.D(this.f54440a.r);
                    this.f54440a.m.LoadData();
                }
                this.f54440a.q();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements l.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ q f54441a;

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
            this.f54441a = qVar;
        }

        @Override // d.a.p0.s.s.l.d
        public void onClick() {
            String b2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!d.a.d.e.p.j.A()) {
                    d.a.d.e.p.l.L(this.f54441a.f54428b, R.string.neterror);
                    return;
                }
                i0 tiebaPlusConfigData = TbSingleton.getInstance().getTiebaPlusConfigData();
                b2 threadData = this.f54441a.f54433g.getThreadData();
                if (tiebaPlusConfigData == null || threadData == null || (b2 = tiebaPlusConfigData.b(threadData.o1())) == null) {
                    return;
                }
                UrlManager.getInstance().dealOneLink(this.f54441a.f54427a, new String[]{b2});
                this.f54441a.q();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements l.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ q f54442a;

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
            this.f54442a = qVar;
        }

        @Override // d.a.p0.s.s.l.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!d.a.d.e.p.j.A()) {
                    d.a.d.e.p.l.L(this.f54442a.f54428b, R.string.neterror);
                    return;
                }
                if (this.f54442a.f54433g != null && this.f54442a.n != null) {
                    this.f54442a.p();
                    this.f54442a.f54431e.show();
                }
                this.f54442a.q();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i extends d.a.d.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ q f54443a;

        public i(q qVar) {
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
            this.f54443a = qVar;
        }

        @Override // d.a.d.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && (obj instanceof ForumManageModel.b)) {
                ForumManageModel.b bVar = (ForumManageModel.b) obj;
                if (bVar.f21299c == 0) {
                    d.a.d.e.p.l.L(this.f54443a.f54428b, R.string.delete_success);
                    if (this.f54443a.f54433g != null) {
                        if (d.a.d.e.p.k.isEmpty(this.f54443a.f54433g.I)) {
                            if (d.a.d.e.p.k.isEmpty(this.f54443a.f54433g.f14589f)) {
                                return;
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016557, this.f54443a.f54433g.f14589f));
                            return;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921436, this.f54443a.f54433g.I));
                    }
                } else if (!d.a.d.e.p.k.isEmpty(bVar.f21298b)) {
                    d.a.d.e.p.l.M(this.f54443a.f54428b, bVar.f21298b);
                } else {
                    d.a.d.e.p.l.L(this.f54443a.f54428b, R.string.delete_fail);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface j {
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
        this.o = false;
        this.q = new b(this);
        this.r = new e(this);
        this.s = new f(this);
        this.t = new g(this);
        this.u = new h(this);
        this.v = new i(this);
        if (tbPageContext == null) {
            return;
        }
        this.f54427a = tbPageContext;
        this.f54428b = tbPageContext.getPageActivity();
        this.f54434h = new ArrayList();
        this.f54430d = new d.a.p0.s.s.l(this.f54428b);
        ForumManageModel forumManageModel = new ForumManageModel(this.f54427a);
        this.n = forumManageModel;
        forumManageModel.setLoadDataCallBack(this.v);
        this.p = new d.a.q0.z.a(tbPageContext);
    }

    public void n(CardPersonDynamicThreadData cardPersonDynamicThreadData, boolean z) {
        d.a.p0.s.s.h hVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, cardPersonDynamicThreadData, z) == null) {
            this.f54433g = cardPersonDynamicThreadData;
            if (cardPersonDynamicThreadData == null || (hVar = this.f54435i) == null) {
                return;
            }
            if (cardPersonDynamicThreadData.q) {
                hVar.n(this.f54428b.getString(R.string.set_thread_public_open));
            } else {
                hVar.n(this.f54428b.getString(R.string.set_thread_privacy));
            }
            this.f54435i.p(z);
            if (this.j != null) {
                if (TbSingleton.getInstance().mCanCallFans) {
                    this.j.n(this.f54428b.getString(R.string.call_fans));
                } else {
                    if (TbSingleton.getInstance().mCallFansTid != null && this.f54433g.getThreadData() != null && TbSingleton.getInstance().mCallFansTid.equals(this.f54433g.getThreadData().o1())) {
                        this.j.n(this.f54428b.getString(R.string.have_called_fans));
                    } else {
                        this.j.n(this.f54428b.getString(R.string.call_fans));
                    }
                    this.j.o(R.color.cp_cont_b_alpha33);
                }
                this.j.p(z);
            }
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f54429c == null) {
            if (TbSingleton.getInstance().getTiebaPlusConfigData() != null && TbSingleton.getInstance().getTiebaPlusConfigData().c()) {
                d.a.p0.s.s.h hVar = new d.a.p0.s.s.h(this.f54428b.getString(R.string.heating_thread), this.f54430d);
                this.l = hVar;
                hVar.m(this.t);
                this.f54434h.add(this.l);
            }
            d.a.p0.s.s.h hVar2 = new d.a.p0.s.s.h(this.f54430d);
            this.f54435i = hVar2;
            hVar2.m(this.s);
            if (!this.o) {
                this.f54434h.add(this.f54435i);
            }
            if (TbSingleton.getInstance().mShowCallFans && !this.o) {
                d.a.p0.s.s.h hVar3 = new d.a.p0.s.s.h(this.f54428b.getString(R.string.call_fans), this.f54430d);
                this.j = hVar3;
                hVar3.m(this.q);
                this.f54434h.add(this.j);
            }
            d.a.p0.s.s.h hVar4 = new d.a.p0.s.s.h(this.f54428b.getString(R.string.delete), this.f54430d);
            this.k = hVar4;
            hVar4.m(this.u);
            this.f54434h.add(this.k);
            this.f54430d.m(new a(this));
            this.f54430d.k(this.f54434h);
            this.f54429c = new d.a.p0.s.s.j(this.f54427a, this.f54430d);
        }
    }

    public final void p() {
        b2 b2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f54431e == null) {
            d.a.p0.s.s.a aVar = new d.a.p0.s.s.a(this.f54427a.getPageActivity());
            this.f54431e = aVar;
            if (this.o) {
                aVar.setMessageId(R.string.del_dynamic_confirm);
            } else {
                CardPersonDynamicThreadData cardPersonDynamicThreadData = this.f54433g;
                if (cardPersonDynamicThreadData != null && (b2Var = cardPersonDynamicThreadData.r) != null && b2Var.M1()) {
                    this.f54431e.setMessageId(R.string.del_work_thread_confirm);
                } else {
                    this.f54431e.setMessageId(R.string.del_thread_confirm);
                }
            }
            this.f54431e.setPositiveButton(R.string.dialog_ok, new c(this));
            this.f54431e.setNegativeButton(R.string.dialog_cancel, new d(this));
            this.f54431e.setCancelable(true);
            this.f54431e.create(this.f54427a);
        }
    }

    public void q() {
        d.a.p0.s.s.j jVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (jVar = this.f54429c) != null && jVar.isShowing()) {
            this.f54429c.dismiss();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            d.a.p0.s.s.l lVar = this.f54430d;
            if (lVar != null) {
                lVar.j();
            }
            d.a.p0.s.s.a aVar = this.f54431e;
            if (aVar != null) {
                d.a.p0.u0.a.a(this.f54427a, aVar.getRealView());
            }
        }
    }

    public void s(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jVar) == null) {
            this.f54432f = jVar;
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.o = z;
        }
    }

    public void u() {
        d.a.p0.s.s.j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (jVar = this.f54429c) == null) {
            return;
        }
        jVar.l();
    }
}
