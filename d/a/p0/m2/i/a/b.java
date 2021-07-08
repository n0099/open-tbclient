package d.a.p0.m2.i.a;

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
import d.a.c.e.p.l;
import d.a.c.k.e.n;
import d.a.o0.r.q.b2;
import d.a.p0.a0.q;
import java.util.Iterator;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f60328a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f60329b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.p0.m2.i.b.a f60330c;

    /* renamed from: d  reason: collision with root package name */
    public int f60331d;

    /* renamed from: e  reason: collision with root package name */
    public final CustomMessageListener f60332e;

    /* renamed from: f  reason: collision with root package name */
    public final CustomMessageListener f60333f;

    /* renamed from: g  reason: collision with root package name */
    public final CustomMessageListener f60334g;

    /* loaded from: classes8.dex */
    public class a implements q.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b2 f60335a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f60336b;

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
            this.f60336b = bVar;
            this.f60335a = b2Var;
        }

        @Override // d.a.p0.a0.q.i
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    l.L(this.f60336b.f60328a.getPageActivity(), R.string.thread_has_hide);
                }
                this.f60336b.h(z, this.f60335a);
            }
        }
    }

    /* renamed from: d.a.p0.m2.i.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1546b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f60337a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1546b(b bVar, int i2) {
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
            this.f60337a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof b2) && customResponsedMessage.getOrginalMessage() != null && customResponsedMessage.getOrginalMessage().getTag() == this.f60337a.f60329b && this.f60337a.f60330c != null && this.f60337a.f60330c.k0()) {
                this.f60337a.k((b2) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f60338a;

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
            this.f60338a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                this.f60338a.j((String) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f60339a;

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
            this.f60339a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                this.f60339a.i((String) customResponsedMessage.getData());
            }
        }
    }

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, d.a.p0.m2.i.b.a aVar, int i2) {
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
        this.f60332e = new C1546b(this, 2921428);
        this.f60333f = new c(this, 2016557);
        this.f60334g = new d(this, 2921436);
        this.f60328a = tbPageContext;
        this.f60329b = bdUniqueId;
        this.f60330c = aVar;
        this.f60331d = i2;
        this.f60332e.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f60332e);
        this.f60333f.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f60333f);
        this.f60334g.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f60334g);
    }

    public final void h(boolean z, b2 b2Var) {
        d.a.p0.m2.i.b.a aVar;
        b2 e2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048576, this, z, b2Var) == null) || b2Var == null || (aVar = this.f60330c) == null || ListUtils.isEmpty(aVar.J()) || this.f60330c.E() == null || this.f60330c.E().e() == null) {
            return;
        }
        boolean z2 = false;
        int i2 = 0;
        while (true) {
            if (i2 >= this.f60330c.J().size()) {
                break;
            }
            n nVar = this.f60330c.J().get(i2);
            if (nVar != null && (e2 = d.a.p0.m2.i.c.a.e(nVar)) != null && !StringUtils.isNull(e2.A) && e2.A.equals(b2Var.A)) {
                e2.f2 = z;
                d.a.p0.a0.e0.b d2 = d.a.p0.m2.i.c.a.d(e2);
                if (d2 != null) {
                    this.f60330c.J().set(i2, d2);
                    z2 = true;
                    break;
                }
            }
            i2++;
        }
        if (z2) {
            this.f60330c.E().n(this.f60330c.J());
        }
    }

    public final void i(String str) {
        d.a.p0.m2.i.b.a aVar;
        b2 e2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || StringUtils.isNull(str) || (aVar = this.f60330c) == null || ListUtils.isEmpty(aVar.J()) || this.f60330c.E() == null || this.f60330c.E().e() == null) {
            return;
        }
        boolean z = false;
        Iterator<n> it = this.f60330c.J().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            n next = it.next();
            if (next != null && (e2 = d.a.p0.m2.i.c.a.e(next)) != null && e2.J() != null && !StringUtils.isNull(e2.J().oriUgcNid) && e2.J().oriUgcNid.equals(str)) {
                it.remove();
                z = true;
                break;
            }
        }
        if (z) {
            this.f60330c.E().n(this.f60330c.J());
        }
    }

    public final void j(String str) {
        d.a.p0.m2.i.b.a aVar;
        b2 e2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || StringUtils.isNull(str) || (aVar = this.f60330c) == null || ListUtils.isEmpty(aVar.J()) || this.f60330c.E() == null || this.f60330c.E().e() == null) {
            return;
        }
        boolean z = false;
        Iterator<n> it = this.f60330c.J().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            n next = it.next();
            if (next != null && (e2 = d.a.p0.m2.i.c.a.e(next)) != null && !StringUtils.isNull(e2.A) && e2.A.equals(str)) {
                it.remove();
                z = true;
                break;
            }
        }
        if (z) {
            this.f60330c.E().n(this.f60330c.J());
        }
    }

    public final void k(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, b2Var) == null) {
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.r = b2Var;
            cardPersonDynamicThreadData.f14540e = String.valueOf(b2Var.Q());
            cardPersonDynamicThreadData.f14541f = b2Var.A;
            cardPersonDynamicThreadData.f14542g = b2Var.g2;
            cardPersonDynamicThreadData.q = b2Var.f2;
            if (b2Var != null && b2Var.J() != null) {
                cardPersonDynamicThreadData.I = b2Var.J().oriUgcNid;
            }
            q qVar = new q(this.f60328a);
            qVar.t(this.f60331d == 1);
            qVar.o();
            qVar.s(new a(this, b2Var));
            qVar.n(cardPersonDynamicThreadData, false);
            qVar.u();
        }
    }
}
