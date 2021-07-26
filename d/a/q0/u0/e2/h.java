package d.a.q0.u0.e2;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.PraiseModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.s.q.a2;
import d.a.p0.s.q.b2;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes8.dex */
public class h extends j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public b2 f63344h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f63345i;
    public String j;
    public PraiseModel k;
    public final CustomMessageListener l;

    /* loaded from: classes8.dex */
    public class a implements PraiseModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f63346a;

        public a(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63346a = hVar;
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (this.f63346a.f63345i) {
                    int i2 = 1;
                    if (this.f63346a.f63344h != null && this.f63346a.f63344h.H0().getIsLike() == 1) {
                        i2 = 0;
                    }
                    this.f63346a.h(i2);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004006));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.b
        public void b(int i2, String str) {
            FrsFragment frsFragment;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) || (frsFragment = this.f63346a.f63349b) == null || frsFragment.getPageContext() == null || !this.f63346a.f63345i || TextUtils.isEmpty(str)) {
                return;
            }
            if (AntiHelper.m(i2, str)) {
                AntiHelper.u(this.f63346a.f63349b.getPageContext().getPageActivity(), str);
            } else {
                this.f63346a.f63349b.showToast(str);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f63347a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(h hVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, Integer.valueOf(i2)};
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
            this.f63347a = hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof b2)) {
                b2 b2Var = (b2) customResponsedMessage.getData();
                this.f63347a.j = b2Var.d0();
                if (TextUtils.isEmpty(this.f63347a.j) || b2Var.H0() == null) {
                    return;
                }
                this.f63347a.h(b2Var.H0().getIsLike());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(FrsFragment frsFragment) {
        super(frsFragment);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((FrsFragment) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        b bVar = new b(this, 2004004);
        this.l = bVar;
        this.f63349b.registerListener(bVar);
        this.k = e();
    }

    public final PraiseModel e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.k == null) {
                this.k = new PraiseModel(this.f63349b.getPageContext(), new a(this));
            }
            return this.k;
        }
        return (PraiseModel) invokeV.objValue;
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.f63345i = z;
        }
    }

    public void g(b2 b2Var, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, b2Var, i2) == null) || b2Var == null) {
            return;
        }
        if (i2 == 1) {
            PraiseData H0 = b2Var.H0();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (H0 == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i2);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    b2Var.T3(praiseData);
                    return;
                }
                b2Var.H0().getUser().add(0, metaData);
                b2Var.H0().setNum(b2Var.H0().getNum() + 1);
                b2Var.H0().setIsLike(i2);
            }
        } else if (b2Var.H0() != null) {
            b2Var.H0().setIsLike(i2);
            b2Var.H0().setNum(b2Var.H0().getNum() - 1);
            ArrayList<MetaData> user = b2Var.H0().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        b2Var.H0().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    public void h(int i2) {
        FrsViewData l0;
        ArrayList<d.a.d.k.e.n> threadList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || (l0 = this.f63349b.l0()) == null || this.f63348a == null || (threadList = l0.getThreadList()) == null) {
            return;
        }
        Iterator<d.a.d.k.e.n> it = threadList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            d.a.d.k.e.n next = it.next();
            if (next instanceof a2) {
                b2 b2Var = ((a2) next).w;
                if (b2Var == this.f63344h) {
                    g(b2Var, i2);
                    this.f63344h = null;
                    break;
                } else if (b2Var.d0() != null && b2Var.d0().equals(this.j)) {
                    g(b2Var, i2);
                    this.j = null;
                    break;
                }
            }
        }
        this.f63348a.W().g(threadList, l0);
        this.f63348a.W().notifyDataSetChanged();
    }
}
