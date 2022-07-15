package com.repackage;

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
import java.util.List;
import tbclient.GetMemberTaskList.ImgInfo;
/* loaded from: classes6.dex */
public class lj7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<ImgInfo> a;
    public long b;
    public List<hj7> c;
    public b d;
    public za e;

    /* loaded from: classes6.dex */
    public class a extends za {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lj7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(lj7 lj7Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lj7Var, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lj7Var;
        }

        @Override // com.repackage.za
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
                        if (this.a.d != null) {
                            this.a.d.a(memberTaskCenterHttpResMessage.getError(), memberTaskCenterHttpResMessage.getErrorString());
                            return;
                        }
                        return;
                    }
                    this.a.a = memberTaskCenterHttpResMessage.getImageList();
                    this.a.c = memberTaskCenterHttpResMessage.getTaskList();
                    if (memberTaskCenterHttpResMessage.getUserPointInfo() != null) {
                        this.a.b = memberTaskCenterHttpResMessage.getUserPointInfo().points_total.longValue();
                    }
                    if (this.a.d != null) {
                        this.a.d.b(this.a.a, this.a.c, this.a.b);
                    }
                }
                if (responsedMessage instanceof MemberTaskCenterSocketResMessage) {
                    MemberTaskCenterSocketResMessage memberTaskCenterSocketResMessage = (MemberTaskCenterSocketResMessage) responsedMessage;
                    if (memberTaskCenterSocketResMessage.hasError()) {
                        if (this.a.d != null) {
                            this.a.d.a(memberTaskCenterSocketResMessage.getError(), memberTaskCenterSocketResMessage.getErrorString());
                            return;
                        }
                        return;
                    }
                    this.a.a = memberTaskCenterSocketResMessage.getImageList();
                    this.a.c = memberTaskCenterSocketResMessage.getTaskList();
                    if (memberTaskCenterSocketResMessage.getUserPointInfo() != null) {
                        this.a.b = memberTaskCenterSocketResMessage.getUserPointInfo().points_total.longValue();
                    }
                    if (this.a.d != null) {
                        this.a.d.b(this.a.a, this.a.c, this.a.b);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a(int i, String str);

        void b(List<ImgInfo> list, List<hj7> list2, long j);
    }

    public lj7() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = new a(this, CmdConfigHttp.CMD_MEMBER_TASK, 309427);
        wh8.h(309427, MemberTaskCenterSocketResMessage.class, false, false);
        wh8.c(309427, CmdConfigHttp.CMD_MEMBER_TASK, TbConfig.GET_MEMBER_TASK, MemberTaskCenterHttpResMessage.class, false, false, false, false);
        MessageManager.getInstance().registerListener(this.e);
    }

    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : invokeV.longValue;
    }

    public List<hj7> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.c : (List) invokeV.objValue;
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
            MessageManager.getInstance().unRegisterListener(this.e);
        }
    }

    public void l(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
            this.b = j;
        }
    }

    public void m(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.d = bVar;
        }
    }
}
