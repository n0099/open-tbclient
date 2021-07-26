package d.a.q0.v1.e;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.memberCenter.memberTask.MemberTaskCenterHttpResMessage;
import com.baidu.tieba.memberCenter.memberTask.MemberTaskCenterRequestMessage;
import com.baidu.tieba.memberCenter.memberTask.MemberTaskCenterSocketResMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.v1.c.b.r;
import java.util.List;
import tbclient.GetMemberTaskList.ImgInfo;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<ImgInfo> f65740a;

    /* renamed from: b  reason: collision with root package name */
    public long f65741b;

    /* renamed from: c  reason: collision with root package name */
    public List<r> f65742c;

    /* renamed from: d  reason: collision with root package name */
    public b f65743d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.d.c.g.a f65744e;

    /* loaded from: classes8.dex */
    public class a extends d.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f65745a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(c cVar, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2), Integer.valueOf(i3)};
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
            this.f65745a = cVar;
        }

        @Override // d.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof MemberTaskCenterHttpResMessage;
            if (z || (responsedMessage instanceof MemberTaskCenterSocketResMessage)) {
                if (z) {
                    MemberTaskCenterHttpResMessage memberTaskCenterHttpResMessage = (MemberTaskCenterHttpResMessage) responsedMessage;
                    if (memberTaskCenterHttpResMessage.hasError()) {
                        if (this.f65745a.f65743d != null) {
                            this.f65745a.f65743d.a(memberTaskCenterHttpResMessage.getError(), memberTaskCenterHttpResMessage.getErrorString());
                            return;
                        }
                        return;
                    }
                    this.f65745a.f65740a = memberTaskCenterHttpResMessage.getImageList();
                    this.f65745a.f65742c = memberTaskCenterHttpResMessage.getTaskList();
                    if (memberTaskCenterHttpResMessage.getUserPointInfo() != null) {
                        this.f65745a.f65741b = memberTaskCenterHttpResMessage.getUserPointInfo().points_total.longValue();
                    }
                    if (this.f65745a.f65743d != null) {
                        this.f65745a.f65743d.b(this.f65745a.f65740a, this.f65745a.f65742c, this.f65745a.f65741b);
                    }
                }
                if (responsedMessage instanceof MemberTaskCenterSocketResMessage) {
                    MemberTaskCenterSocketResMessage memberTaskCenterSocketResMessage = (MemberTaskCenterSocketResMessage) responsedMessage;
                    if (memberTaskCenterSocketResMessage.hasError()) {
                        if (this.f65745a.f65743d != null) {
                            this.f65745a.f65743d.a(memberTaskCenterSocketResMessage.getError(), memberTaskCenterSocketResMessage.getErrorString());
                            return;
                        }
                        return;
                    }
                    this.f65745a.f65740a = memberTaskCenterSocketResMessage.getImageList();
                    this.f65745a.f65742c = memberTaskCenterSocketResMessage.getTaskList();
                    if (memberTaskCenterSocketResMessage.getUserPointInfo() != null) {
                        this.f65745a.f65741b = memberTaskCenterSocketResMessage.getUserPointInfo().points_total.longValue();
                    }
                    if (this.f65745a.f65743d != null) {
                        this.f65745a.f65743d.b(this.f65745a.f65740a, this.f65745a.f65742c, this.f65745a.f65741b);
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface b {
        void a(int i2, String str);

        void b(List<ImgInfo> list, List<r> list2, long j);
    }

    public c() {
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
        this.f65744e = new a(this, CmdConfigHttp.CMD_MEMBER_TASK, 309427);
        d.a.q0.h3.d0.a.h(309427, MemberTaskCenterSocketResMessage.class, false, false);
        d.a.q0.h3.d0.a.c(309427, CmdConfigHttp.CMD_MEMBER_TASK, TbConfig.GET_MEMBER_TASK, MemberTaskCenterHttpResMessage.class, false, false, false, false);
        MessageManager.getInstance().registerListener(this.f65744e);
    }

    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f65741b : invokeV.longValue;
    }

    public List<r> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f65742c : (List) invokeV.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            MessageManager.getInstance().sendMessage(new MemberTaskCenterRequestMessage());
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.f65744e);
        }
    }

    public void l(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
            this.f65741b = j;
        }
    }

    public void m(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.f65743d = bVar;
        }
    }
}
