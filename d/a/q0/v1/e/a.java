package d.a.q0.v1.e;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.memberCenter.memberTask.FinishMemberTaskHttpResMessage;
import com.baidu.tieba.memberCenter.memberTask.FinishMemberTaskReqMessage;
import com.baidu.tieba.memberCenter.memberTask.FinishMemberTaskSocketMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b f65727a;

    /* renamed from: b  reason: collision with root package name */
    public int f65728b;

    /* renamed from: c  reason: collision with root package name */
    public int f65729c;

    /* renamed from: d  reason: collision with root package name */
    public long f65730d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.d.c.g.a f65731e;

    /* renamed from: d.a.q0.v1.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1796a extends d.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f65732a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1796a(a aVar, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2), Integer.valueOf(i3)};
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
            this.f65732a = aVar;
        }

        @Override // d.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof FinishMemberTaskHttpResMessage;
            if (z || (responsedMessage instanceof FinishMemberTaskSocketMessage)) {
                if (z) {
                    this.f65732a.f65728b = ((FinishMemberTaskHttpResMessage) responsedMessage).getStatus();
                } else if (responsedMessage instanceof FinishMemberTaskSocketMessage) {
                    this.f65732a.f65728b = ((FinishMemberTaskSocketMessage) responsedMessage).getStatus();
                }
                if (this.f65732a.f65727a != null) {
                    this.f65732a.f65727a.a(responsedMessage.getError(), responsedMessage.getErrorString(), this.f65732a.f65728b, this.f65732a.f65729c, this.f65732a.f65730d);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface b {
        void a(int i2, String str, int i3, int i4, long j);
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f65727a = null;
        this.f65731e = new C1796a(this, CmdConfigHttp.CMD_FINISH_MEMBER_TASK, 309429);
        d.a.q0.h3.d0.a.h(309429, FinishMemberTaskSocketMessage.class, false, false);
        d.a.q0.h3.d0.a.c(309429, CmdConfigHttp.CMD_FINISH_MEMBER_TASK, TbConfig.FINISH_MEMBER_TASK, FinishMemberTaskHttpResMessage.class, false, false, false, false);
        MessageManager.getInstance().registerListener(this.f65731e);
    }

    public void f(long j, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2)}) == null) {
            this.f65730d = j;
            this.f65729c = i2;
            FinishMemberTaskReqMessage finishMemberTaskReqMessage = new FinishMemberTaskReqMessage();
            finishMemberTaskReqMessage.setTaskId(j);
            MessageManager.getInstance().sendMessage(finishMemberTaskReqMessage);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.f65731e);
        }
    }

    public void h(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f65727a = bVar;
        }
    }
}
