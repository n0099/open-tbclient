package d.a.s0.m2.i.a;

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
import d.a.r0.r.q.b2;
import d.a.s0.a0.q;
import java.util.Iterator;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f63565a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f63566b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.s0.m2.i.b.a f63567c;

    /* renamed from: d  reason: collision with root package name */
    public int f63568d;

    /* renamed from: e  reason: collision with root package name */
    public final CustomMessageListener f63569e;

    /* renamed from: f  reason: collision with root package name */
    public final CustomMessageListener f63570f;

    /* renamed from: g  reason: collision with root package name */
    public final CustomMessageListener f63571g;

    /* loaded from: classes9.dex */
    public class a implements q.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b2 f63572a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f63573b;

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
            this.f63573b = bVar;
            this.f63572a = b2Var;
        }

        @Override // d.a.s0.a0.q.i
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    l.L(this.f63573b.f63565a.getPageActivity(), R.string.thread_has_hide);
                }
                this.f63573b.h(z, this.f63572a);
            }
        }
    }

    /* renamed from: d.a.s0.m2.i.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1590b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f63574a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1590b(b bVar, int i2) {
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
            this.f63574a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof b2) && customResponsedMessage.getOrginalMessage() != null && customResponsedMessage.getOrginalMessage().getTag() == this.f63574a.f63566b && this.f63574a.f63567c != null && this.f63574a.f63567c.k0()) {
                this.f63574a.k((b2) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f63575a;

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
            this.f63575a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                this.f63575a.j((String) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f63576a;

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
            this.f63576a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                this.f63576a.i((String) customResponsedMessage.getData());
            }
        }
    }

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, d.a.s0.m2.i.b.a aVar, int i2) {
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
        this.f63569e = new C1590b(this, 2921428);
        this.f63570f = new c(this, 2016557);
        this.f63571g = new d(this, 2921436);
        this.f63565a = tbPageContext;
        this.f63566b = bdUniqueId;
        this.f63567c = aVar;
        this.f63568d = i2;
        this.f63569e.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f63569e);
        this.f63570f.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f63570f);
        this.f63571g.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f63571g);
    }

    public final void h(boolean z, b2 b2Var) {
        d.a.s0.m2.i.b.a aVar;
        b2 e2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048576, this, z, b2Var) == null) || b2Var == null || (aVar = this.f63567c) == null || ListUtils.isEmpty(aVar.J()) || this.f63567c.E() == null || this.f63567c.E().e() == null) {
            return;
        }
        boolean z2 = false;
        int i2 = 0;
        while (true) {
            if (i2 >= this.f63567c.J().size()) {
                break;
            }
            n nVar = this.f63567c.J().get(i2);
            if (nVar != null && (e2 = d.a.s0.m2.i.c.a.e(nVar)) != null && !StringUtils.isNull(e2.A) && e2.A.equals(b2Var.A)) {
                e2.f2 = z;
                d.a.s0.a0.e0.b d2 = d.a.s0.m2.i.c.a.d(e2);
                if (d2 != null) {
                    this.f63567c.J().set(i2, d2);
                    z2 = true;
                    break;
                }
            }
            i2++;
        }
        if (z2) {
            this.f63567c.E().n(this.f63567c.J());
        }
    }

    public final void i(String str) {
        d.a.s0.m2.i.b.a aVar;
        b2 e2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || StringUtils.isNull(str) || (aVar = this.f63567c) == null || ListUtils.isEmpty(aVar.J()) || this.f63567c.E() == null || this.f63567c.E().e() == null) {
            return;
        }
        boolean z = false;
        Iterator<n> it = this.f63567c.J().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            n next = it.next();
            if (next != null && (e2 = d.a.s0.m2.i.c.a.e(next)) != null && e2.J() != null && !StringUtils.isNull(e2.J().oriUgcNid) && e2.J().oriUgcNid.equals(str)) {
                it.remove();
                z = true;
                break;
            }
        }
        if (z) {
            this.f63567c.E().n(this.f63567c.J());
        }
    }

    public final void j(String str) {
        d.a.s0.m2.i.b.a aVar;
        b2 e2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || StringUtils.isNull(str) || (aVar = this.f63567c) == null || ListUtils.isEmpty(aVar.J()) || this.f63567c.E() == null || this.f63567c.E().e() == null) {
            return;
        }
        boolean z = false;
        Iterator<n> it = this.f63567c.J().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            n next = it.next();
            if (next != null && (e2 = d.a.s0.m2.i.c.a.e(next)) != null && !StringUtils.isNull(e2.A) && e2.A.equals(str)) {
                it.remove();
                z = true;
                break;
            }
        }
        if (z) {
            this.f63567c.E().n(this.f63567c.J());
        }
    }

    public final void k(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, b2Var) == null) {
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.r = b2Var;
            cardPersonDynamicThreadData.f14501e = String.valueOf(b2Var.Q());
            cardPersonDynamicThreadData.f14502f = b2Var.A;
            cardPersonDynamicThreadData.f14503g = b2Var.g2;
            cardPersonDynamicThreadData.q = b2Var.f2;
            if (b2Var != null && b2Var.J() != null) {
                cardPersonDynamicThreadData.I = b2Var.J().oriUgcNid;
            }
            q qVar = new q(this.f63565a);
            qVar.t(this.f63568d == 1);
            qVar.o();
            qVar.s(new a(this, b2Var));
            qVar.n(cardPersonDynamicThreadData, false);
            qVar.u();
        }
    }
}
