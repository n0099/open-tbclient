package d.a.s0.h2.k.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.pb.pb.godreply.LookMoreHttpResMessage;
import com.baidu.tieba.pb.pb.godreply.LookMoreReqMessage;
import com.baidu.tieba.pb.pb.godreply.LookMoreSocketResMessage;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes9.dex */
public class e0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PbModel f60493a;

    /* renamed from: b  reason: collision with root package name */
    public b f60494b;

    /* renamed from: c  reason: collision with root package name */
    public final BdUniqueId f60495c;

    /* renamed from: d  reason: collision with root package name */
    public final d.a.c.c.g.a f60496d;

    /* loaded from: classes9.dex */
    public class a extends d.a.c.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e0 f60497a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(e0 e0Var, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e0Var, Integer.valueOf(i2), Integer.valueOf(i3)};
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
            this.f60497a = e0Var;
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            if (responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() == null || responsedMessage.getOrginalMessage().getTag() == this.f60497a.f60495c) {
                if (responsedMessage instanceof LookMoreHttpResMessage) {
                    LookMoreHttpResMessage lookMoreHttpResMessage = (LookMoreHttpResMessage) responsedMessage;
                    List<PostData> data = lookMoreHttpResMessage.getData();
                    String errorString = lookMoreHttpResMessage.getErrorString();
                    int error = lookMoreHttpResMessage.getError();
                    if (error != 0) {
                        this.f60497a.f60494b.a(error, errorString, "");
                    } else if (ListUtils.isEmpty(data)) {
                    } else {
                        this.f60497a.f60494b.onSuccess(data);
                    }
                } else if (responsedMessage instanceof LookMoreSocketResMessage) {
                    LookMoreSocketResMessage lookMoreSocketResMessage = (LookMoreSocketResMessage) responsedMessage;
                    List<PostData> data2 = lookMoreSocketResMessage.getData();
                    String errorString2 = lookMoreSocketResMessage.getErrorString();
                    int error2 = lookMoreSocketResMessage.getError();
                    if (error2 != 0) {
                        this.f60497a.f60494b.a(error2, errorString2, "");
                    } else if (data2 != null) {
                        this.f60497a.f60494b.onSuccess(data2);
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface b {
        void a(int i2, String str, String str2);

        void onSuccess(List<PostData> list);
    }

    public e0(PbModel pbModel, BaseFragmentActivity baseFragmentActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbModel, baseFragmentActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f60496d = new a(this, CmdConfigHttp.CMD_PB_GOD_MORE, 309446);
        this.f60493a = pbModel;
        this.f60495c = BdUniqueId.gen();
        e();
        this.f60496d.setTag(baseFragmentActivity.getUniqueId());
        MessageManager.getInstance().registerListener(this.f60496d);
        this.f60494b = null;
    }

    public void c(List<Long> list) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || (pbModel = this.f60493a) == null || pbModel.D0() == null) {
            return;
        }
        int k = d.a.c.e.p.l.k(TbadkCoreApplication.getInst());
        int i2 = d.a.c.e.p.l.i(TbadkCoreApplication.getInst());
        LookMoreReqMessage lookMoreReqMessage = new LookMoreReqMessage();
        lookMoreReqMessage.setKz(Long.valueOf(d.a.c.e.m.b.f(this.f60493a.f19381e, 0L)));
        lookMoreReqMessage.setPost_id(list);
        lookMoreReqMessage.setSt_type(d.a.c.e.m.b.d(this.f60493a.mStType, 0));
        lookMoreReqMessage.setWith_floor(1);
        lookMoreReqMessage.setScr_w(k);
        lookMoreReqMessage.setScr_h(i2);
        lookMoreReqMessage.setTag(this.f60495c);
        MessageManager.getInstance().sendMessage(lookMoreReqMessage);
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.f60496d);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_PB_GOD_MORE, d.a.s0.h3.d0.a.a(TbConfig.PB_MORE_GOD_REPLY_URL, 309446));
            tbHttpMessageTask.setResponsedClass(LookMoreHttpResMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            d.a.s0.h3.d0.a.f(309446, LookMoreSocketResMessage.class, false);
        }
    }

    public void f(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.f60494b = bVar;
        }
    }
}
