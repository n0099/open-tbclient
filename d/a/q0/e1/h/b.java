package d.a.q0.e1.h;

import androidx.collection.LongSparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tieba.homepage.GetMyPostHttpResponseMessage;
import com.baidu.tieba.homepage.GetMyPostSocketResponseMessage;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
import d.a.d.k.e.n;
import d.a.q0.e1.h.h.c0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.ThreadInfo;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final List<n> f56006a;

    /* renamed from: b  reason: collision with root package name */
    public final c0 f56007b;

    /* renamed from: c  reason: collision with root package name */
    public LongSparseArray<ThreadInfo> f56008c;

    /* renamed from: d  reason: collision with root package name */
    public List<ThreadInfo> f56009d;

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f56010e;

    /* renamed from: f  reason: collision with root package name */
    public d f56011f;

    /* renamed from: g  reason: collision with root package name */
    public CustomMessageListener f56012g;

    /* renamed from: h  reason: collision with root package name */
    public final d.a.d.c.g.a f56013h;

    /* renamed from: i  reason: collision with root package name */
    public final CustomMessageListener f56014i;

    /* loaded from: classes8.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f56015a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b bVar, int i2) {
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
            this.f56015a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                PostWriteCallBackData postWriteCallBackData = (PostWriteCallBackData) customResponsedMessage.getData();
                long f2 = d.a.d.e.m.b.f(postWriteCallBackData.getPostId(), 0L);
                long f3 = d.a.d.e.m.b.f(postWriteCallBackData.getThreadId(), 0L);
                if (f2 == 0 || f3 == 0) {
                    return;
                }
                d.a.d.e.m.e.a().removeCallbacks(this.f56015a.f56011f);
                b bVar = this.f56015a;
                bVar.f56011f = new d(bVar, f3, f2);
                d.a.d.e.m.e.a().postDelayed(this.f56015a.f56011f, 500L);
            }
        }
    }

    /* renamed from: d.a.q0.e1.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1352b extends d.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1352b(b bVar, int i2, int i3) {
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
        }

        @Override // d.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                    GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
                } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                    GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f56016a;

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
            this.f56016a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Long l;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (StringUtils.isNull(str) || ListUtils.isEmpty(this.f56016a.f56006a) || ListUtils.isEmpty(this.f56016a.f56009d)) {
                    return;
                }
                Iterator it = this.f56016a.f56006a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    n nVar = (n) it.next();
                    if (nVar instanceof d.a.q0.a0.e0.b) {
                        d.a.q0.a0.e0.b bVar = (d.a.q0.a0.e0.b) nVar;
                        if (bVar.getThreadData() != null && bVar.getThreadData().o1() != null && bVar.getThreadData().o1().equals(str)) {
                            it.remove();
                            d.a.q0.e1.h.k.b.b(this.f56016a.f56006a);
                            this.f56016a.f56007b.z(new ArrayList(this.f56016a.f56006a));
                            break;
                        }
                    }
                }
                long f2 = d.a.d.e.m.b.f(str, 0L);
                Iterator it2 = this.f56016a.f56009d.iterator();
                while (it2.hasNext()) {
                    ThreadInfo threadInfo = (ThreadInfo) it2.next();
                    if (threadInfo != null && (l = threadInfo.tid) != null && l.longValue() == f2) {
                        it2.remove();
                        return;
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public long f56017e;

        /* renamed from: f  reason: collision with root package name */
        public long f56018f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f56019g;

        public d(b bVar, long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Long.valueOf(j), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56019g = bVar;
            this.f56017e = j;
            this.f56018f = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int k = l.k(TbadkCoreApplication.getInst());
                int i2 = l.i(TbadkCoreApplication.getInst());
                float f2 = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                int i3 = TbImageHelper.getInstance().isShowBigImage() ? 2 : 1;
                RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                requestGetMyPostNetMessage.setTag(this.f56019g.f56010e);
                requestGetMyPostNetMessage.setParams(this.f56017e, this.f56018f, 0L, k, i2, f2, i3);
                MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
            }
        }
    }

    public b(List<n> list, c0 c0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, c0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f56008c = new LongSparseArray<>();
        this.f56012g = new a(this, 2921030);
        this.f56013h = new C1352b(this, CmdConfigHttp.CMD_GET_MY_POST, 303111);
        this.f56014i = new c(this, 2921031);
        this.f56006a = list;
        this.f56007b = c0Var;
    }

    public void g(List<ThreadInfo> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        Iterator<ThreadInfo> it = list.iterator();
        while (it.hasNext()) {
            ThreadInfo next = it.next();
            if (next != null && this.f56008c.get(next.tid.longValue()) != null) {
                it.remove();
            }
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f56011f == null) {
            return;
        }
        d.a.d.e.m.e.a().removeCallbacks(this.f56011f);
    }

    public void i(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdUniqueId) == null) {
            this.f56010e = bdUniqueId;
            this.f56012g.setTag(bdUniqueId);
            this.f56012g.setSelfListener(false);
            this.f56013h.setTag(bdUniqueId);
            this.f56013h.getHttpMessageListener().setSelfListener(true);
            this.f56013h.getSocketMessageListener().setSelfListener(true);
            this.f56014i.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.f56012g);
            MessageManager.getInstance().registerListener(this.f56013h);
            MessageManager.getInstance().registerListener(this.f56014i);
        }
    }

    public void j(List<ThreadInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.f56009d = list;
        }
    }
}
