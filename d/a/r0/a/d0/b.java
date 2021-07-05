package d.a.r0.a.d0;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BdToken.backUser.BackUserHTTPResMsg;
import com.baidu.tbadk.BdToken.backUser.BackUserReqMsg;
import com.baidu.tbadk.BdToken.backUser.BackUserSocketResMsg;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BdUniqueId f54579a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.c.c.g.a f54580b;

    /* loaded from: classes9.dex */
    public class a extends d.a.c.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f54581a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b bVar, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54581a = bVar;
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null || responsedMessage.getOrginalMessage() == null || this.f54581a.b() != responsedMessage.getOrginalMessage().getTag() || responsedMessage.hasError() || responsedMessage.getError() != 0) {
                return;
            }
            d.a.r0.a.d0.a aVar = null;
            if (responsedMessage instanceof BackUserHTTPResMsg) {
                aVar = ((BackUserHTTPResMsg) responsedMessage).getData();
            } else if (responsedMessage instanceof BackUserSocketResMsg) {
                aVar = ((BackUserSocketResMsg) responsedMessage).getData();
            }
            if (aVar == null || !aVar.f54578a) {
                return;
            }
            d.a.r0.r.d0.b.j().w(d.a.r0.r.d0.b.n("pref_key_last_request_mission"), System.currentTimeMillis());
            d.a.r0.r.c0.a.e().i();
        }
    }

    public b(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f54580b = new a(this, CmdConfigHttp.CMD_BACK_USER, 309689);
        this.f54579a = bdUniqueId;
        c();
        this.f54580b.setTag(this.f54579a);
        MessageManager.getInstance().registerListener(this.f54580b);
    }

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? !UtilHelper.isSameDay(d.a.r0.r.d0.b.j().l(d.a.r0.r.d0.b.n("pref_key_last_request_mission"), 0L), System.currentTimeMillis()) : invokeV.booleanValue;
    }

    public BdUniqueId b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f54579a : (BdUniqueId) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            d.a.s0.h3.d0.a.h(309689, BackUserSocketResMsg.class, false, false);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_BACK_USER, d.a.s0.h3.d0.a.a(TbConfig.URL_BACK_USER, 309689));
            tbHttpMessageTask.setResponsedClass(BackUserHTTPResMsg.class);
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && a()) {
            BackUserReqMsg backUserReqMsg = new BackUserReqMsg();
            backUserReqMsg.setTag(this.f54579a);
            MessageManager.getInstance().sendMessage(backUserReqMsg);
        }
    }
}
