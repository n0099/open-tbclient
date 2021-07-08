package d.a.p0.u0.h1;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.j;
import d.a.p0.u0.h1.g;
/* loaded from: classes8.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c f62882a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f62883b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.o0.s.e.a f62884c;

    /* renamed from: d  reason: collision with root package name */
    public BdUniqueId f62885d;

    /* renamed from: e  reason: collision with root package name */
    public CustomMessageListener f62886e;

    /* loaded from: classes8.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f62887a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(h hVar, int i2) {
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
            this.f62887a = hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            UpdateAttentionMessage.a data;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || !(customResponsedMessage instanceof UpdateAttentionMessage) || this.f62887a.f62882a == null || (data = (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage).getData()) == null) {
                return;
            }
            if (!data.f12817a) {
                this.f62887a.f62882a.c(updateAttentionMessage.getData().f12818b);
            } else {
                this.f62887a.f62882a.e(data.f12820d);
            }
        }
    }

    public h(TbPageContext tbPageContext, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f62885d = BdUniqueId.gen();
        this.f62886e = new a(this, 2001115);
        this.f62883b = tbPageContext;
        this.f62882a = cVar;
        this.f62884c = new d.a.o0.s.e.a(tbPageContext);
        this.f62886e.setSelfListener(true);
        this.f62886e.setTag(this.f62885d);
        MessageManager.getInstance().registerListener(this.f62886e);
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            d.a.o0.s.e.a aVar = this.f62884c;
            if (aVar != null) {
                aVar.g();
            }
            MessageManager.getInstance().unRegisterListener(this.f62886e);
        }
    }

    public void c(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar) == null) {
            if (!j.z()) {
                this.f62883b.showToast(R.string.no_network);
            } else if (gVar == null || gVar.y == null || this.f62884c == null || !ViewHelper.checkUpIsLogin(this.f62883b.getPageActivity())) {
            } else {
                d.a.o0.s.e.a aVar = this.f62884c;
                g.b bVar = gVar.y;
                aVar.l(!bVar.f62863e, bVar.f62862d, bVar.f62859a, this.f62885d);
            }
        }
    }

    public void d(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gVar) == null) {
            if (!j.z()) {
                this.f62883b.showToast(R.string.no_network);
            } else if (gVar == null || this.f62882a == null || !ViewHelper.checkUpIsLogin(this.f62883b.getPageActivity())) {
            } else {
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
                httpMessage.addParam("thread_id", gVar.f62849f);
                httpMessage.addParam("op_type", Boolean.valueOf(gVar.p));
                httpMessage.addParam("obj_type", 3);
                httpMessage.addParam("agree_type", 2);
                httpMessage.addParam("forum_id", gVar.f62848e);
                httpMessage.addParam("z_id", TbadkCoreApplication.getInst().getZid());
                if (!StringUtil.isEmpty(gVar.u)) {
                    httpMessage.addParam("obj_source", gVar.u);
                }
                httpMessage.addHeader("needSig", "1");
                MessageManager.getInstance().sendMessage(httpMessage);
                this.f62882a.d();
            }
        }
    }
}
