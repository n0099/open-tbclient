package d.a.q0.m2.i.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
import d.a.d.k.e.n;
import d.a.p0.s.q.b2;
import d.a.q0.a0.q;
import java.util.Iterator;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f60942a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f60943b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.q0.m2.i.b.a f60944c;

    /* renamed from: d  reason: collision with root package name */
    public int f60945d;

    /* renamed from: e  reason: collision with root package name */
    public final CustomMessageListener f60946e;

    /* renamed from: f  reason: collision with root package name */
    public final CustomMessageListener f60947f;

    /* renamed from: g  reason: collision with root package name */
    public final CustomMessageListener f60948g;

    /* loaded from: classes8.dex */
    public class a implements q.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b2 f60949a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f60950b;

        public a(b bVar, b2 b2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, b2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60950b = bVar;
            this.f60949a = b2Var;
        }

        @Override // d.a.q0.a0.q.j
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    l.L(this.f60950b.f60942a.getPageActivity(), R.string.thread_has_hide);
                }
                this.f60950b.h(z, this.f60949a);
            }
        }
    }

    /* renamed from: d.a.q0.m2.i.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1551b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f60951a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1551b(b bVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60951a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof b2) && customResponsedMessage.getOrginalMessage() != null && customResponsedMessage.getOrginalMessage().getTag() == this.f60951a.f60943b && this.f60951a.f60944c != null && this.f60951a.f60944c.n0()) {
                this.f60951a.k((b2) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f60952a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(b bVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60952a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                this.f60952a.j((String) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f60953a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(b bVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60953a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                this.f60953a.i((String) customResponsedMessage.getData());
            }
        }
    }

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, d.a.q0.m2.i.b.a aVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, aVar, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f60946e = new C1551b(this, 2921428);
        this.f60947f = new c(this, 2016557);
        this.f60948g = new d(this, 2921436);
        this.f60942a = tbPageContext;
        this.f60943b = bdUniqueId;
        this.f60944c = aVar;
        this.f60945d = i2;
        this.f60946e.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f60946e);
        this.f60947f.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f60947f);
        this.f60948g.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f60948g);
    }

    public final void h(boolean z, b2 b2Var) {
        d.a.q0.m2.i.b.a aVar;
        b2 e2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048576, this, z, b2Var) == null) || b2Var == null || (aVar = this.f60944c) == null || ListUtils.isEmpty(aVar.J()) || this.f60944c.E() == null || this.f60944c.E().e() == null) {
            return;
        }
        boolean z2 = false;
        int i2 = 0;
        while (true) {
            if (i2 >= this.f60944c.J().size()) {
                break;
            }
            n nVar = this.f60944c.J().get(i2);
            if (nVar != null && (e2 = d.a.q0.m2.i.c.a.e(nVar)) != null && !StringUtils.isNull(e2.A) && e2.A.equals(b2Var.A)) {
                e2.f2 = z;
                d.a.q0.a0.e0.b d2 = d.a.q0.m2.i.c.a.d(e2);
                if (d2 != null) {
                    this.f60944c.J().set(i2, d2);
                    z2 = true;
                    break;
                }
            }
            i2++;
        }
        if (z2) {
            this.f60944c.E().n(this.f60944c.J());
        }
    }

    public final void i(String str) {
        d.a.q0.m2.i.b.a aVar;
        b2 e2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || StringUtils.isNull(str) || (aVar = this.f60944c) == null || ListUtils.isEmpty(aVar.J()) || this.f60944c.E() == null || this.f60944c.E().e() == null) {
            return;
        }
        boolean z = false;
        Iterator<n> it = this.f60944c.J().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            n next = it.next();
            if (next != null && (e2 = d.a.q0.m2.i.c.a.e(next)) != null && e2.J() != null && !StringUtils.isNull(e2.J().oriUgcNid) && e2.J().oriUgcNid.equals(str)) {
                it.remove();
                z = true;
                break;
            }
        }
        if (z) {
            this.f60944c.E().n(this.f60944c.J());
        }
    }

    public final void j(String str) {
        d.a.q0.m2.i.b.a aVar;
        b2 e2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || StringUtils.isNull(str) || (aVar = this.f60944c) == null || ListUtils.isEmpty(aVar.J()) || this.f60944c.E() == null || this.f60944c.E().e() == null) {
            return;
        }
        boolean z = false;
        Iterator<n> it = this.f60944c.J().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            n next = it.next();
            if (next != null && (e2 = d.a.q0.m2.i.c.a.e(next)) != null && !StringUtils.isNull(e2.A) && e2.A.equals(str)) {
                it.remove();
                z = true;
                break;
            }
        }
        if (z) {
            this.f60944c.E().n(this.f60944c.J());
        }
    }

    public final void k(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, b2Var) == null) {
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.r = b2Var;
            cardPersonDynamicThreadData.f14588e = String.valueOf(b2Var.R());
            cardPersonDynamicThreadData.f14589f = b2Var.A;
            cardPersonDynamicThreadData.f14590g = b2Var.g2;
            cardPersonDynamicThreadData.q = b2Var.f2;
            if (b2Var != null && b2Var.J() != null) {
                cardPersonDynamicThreadData.I = b2Var.J().oriUgcNid;
            }
            q qVar = new q(this.f60942a);
            qVar.t(this.f60945d == 1);
            qVar.o();
            qVar.s(new a(this, b2Var));
            qVar.n(cardPersonDynamicThreadData, false);
            qVar.u();
        }
    }
}
