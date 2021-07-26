package d.a.q0.e1.h;

import android.os.Looper;
import android.os.MessageQueue;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.ala.atomdata.AlaSDKShareEmptyActivityConfig;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.searchbox.live.interfaces.ILiveNPSPlugin;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.FullBrowseHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.LiveRoomClosedQueryMessage;
import com.baidu.tieba.frs.SmartBubbleAnimatedView;
import com.baidu.tieba.homepage.BlessHttpResponseMessage;
import com.baidu.tieba.homepage.BlessSocketResponseMessage;
import com.baidu.tieba.homepage.GetMyPostHttpResponseMessage;
import com.baidu.tieba.homepage.GetMyPostSocketResponseMessage;
import com.baidu.tieba.homepage.HomePageStatic;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.baidu.tieba.homepage.personalize.view.HomePageBrowseModelTipView;
import com.baidu.tieba.homepage.personalize.view.HomePageYoungsterTopView;
import com.baidu.tieba.message.RequestBlessMessage;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.net.tnc.TNCManager;
import com.squareup.wire.Wire;
import d.a.k.v0.a;
import d.a.p0.s.f0.f;
import d.a.p0.s.q.b2;
import d.a.p0.s.q.k1;
import d.a.p0.s.q.m1;
import d.a.p0.s.q.o0;
import d.a.q0.i0.a;
import d.a.q0.u0.c1;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.Anti;
import tbclient.App;
import tbclient.BannerList;
import tbclient.BlockPopInfo;
import tbclient.DiscoverHotForum;
import tbclient.GetMyPost.GetMyPostResIdl;
import tbclient.GodInfo;
import tbclient.Personalized.DataRes;
import tbclient.ThreadInfo;
import tbclient.User;
import tbclient.Zan;
/* loaded from: classes8.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public boolean B;
    public int C;
    public boolean D;
    public d.a.p0.b1.a0 E;
    public View.OnTouchListener F;
    public d.a.q0.e1.h.j.h G;
    public boolean H;
    public BdUniqueId I;
    public SmartBubbleAnimatedView J;
    public HomePageYoungsterTopView K;
    public HomePageBrowseModelTipView L;
    public int M;
    public BdUniqueId N;
    public a.C0620a O;
    public ThreadInfo P;
    public RecyclerView.OnScrollListener Q;
    public View.OnTouchListener R;
    public a.b S;
    public final CustomMessageListener T;
    public final CustomMessageListener U;
    public final CustomMessageListener V;
    public final CustomMessageListener W;
    public CustomMessageListener X;
    public CustomMessageListener Y;
    public CustomMessageListener Z;

    /* renamed from: a  reason: collision with root package name */
    public final long f56022a;
    public CustomMessageListener a0;

    /* renamed from: b  reason: collision with root package name */
    public final d.a.q0.e1.h.b f56023b;
    public String b0;

    /* renamed from: c  reason: collision with root package name */
    public l0 f56024c;
    public int c0;

    /* renamed from: d  reason: collision with root package name */
    public final List<d.a.d.k.e.n> f56025d;
    public Runnable d0;

    /* renamed from: e  reason: collision with root package name */
    public DataRes.Builder f56026e;
    public d.a.q0.e1.h.d e0;

    /* renamed from: f  reason: collision with root package name */
    public int f56027f;
    public CustomMessageListener f0;

    /* renamed from: g  reason: collision with root package name */
    public boolean f56028g;
    public CustomMessageListener g0;

    /* renamed from: h  reason: collision with root package name */
    public boolean f56029h;
    public CustomMessageListener h0;

    /* renamed from: i  reason: collision with root package name */
    public int f56030i;
    public CustomMessageListener i0;
    public final TbPageContext<?> j;
    public CustomMessageListener j0;
    public final BdTypeRecyclerView k;
    public CustomMessageListener k0;
    public final BigdaySwipeRefreshLayout l;
    public d.a.d.c.g.a l0;
    public final d.a.q0.e1.h.h.c0 m;
    public CustomMessageListener m0;
    public int n;
    public CustomMessageListener n0;
    public c1 o;
    public final d.a.d.c.g.a o0;
    public final d.a.q0.e1.h.k.a p;
    public CustomMessageListener p0;
    public d.a.q0.h3.h0.f q;
    public d.a.p0.o0.c r;
    public ScrollFragmentTabHost s;
    public d.a.q0.i0.a t;
    public boolean u;
    public d.a.q0.n2.i v;
    public int w;
    public int x;
    public boolean y;
    public boolean z;

    /* loaded from: classes8.dex */
    public class a implements CustomMessageTask.CustomRunnable<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f56031e;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56031e = eVar;
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                ThreadCardViewHolder d0 = this.f56031e.d0();
                if (d0 != null && d0.b() != null) {
                    return new CustomResponsedMessage<>(2016323, Boolean.valueOf(d0.b().o(new a.C0620a(6))));
                }
                return new CustomResponsedMessage<>(2016323, Boolean.FALSE);
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class a0 extends d.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f56032a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a0(e eVar, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2), Integer.valueOf(i3)};
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
            this.f56032a = eVar;
        }

        @Override // d.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            long j;
            long j2;
            d.a.q0.e1.k.b.c.b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            if (responsedMessage instanceof BlessHttpResponseMessage) {
                BlessHttpResponseMessage blessHttpResponseMessage = (BlessHttpResponseMessage) responsedMessage;
                j = blessHttpResponseMessage.userPkId;
                j2 = blessHttpResponseMessage.pkID;
            } else if (responsedMessage instanceof BlessSocketResponseMessage) {
                BlessSocketResponseMessage blessSocketResponseMessage = (BlessSocketResponseMessage) responsedMessage;
                j = blessSocketResponseMessage.userPkId;
                j2 = blessSocketResponseMessage.pkID;
            } else {
                j = 0;
                j2 = 0;
            }
            if (j2 == 0 && responsedMessage.getOrginalMessage() != null && (responsedMessage.getOrginalMessage().getExtra() instanceof RequestBlessMessage)) {
                j2 = ((RequestBlessMessage) responsedMessage.getOrginalMessage().getExtra()).pk_id.longValue();
            }
            if (j2 == 0) {
                return;
            }
            for (d.a.d.k.e.n nVar : this.f56032a.f56025d) {
                if ((nVar instanceof d.a.q0.e1.k.b.c.a) && (bVar = ((d.a.q0.e1.k.b.c.a) nVar).a0) != null && j2 == bVar.f56354b) {
                    bVar.f56355c = j;
                    return;
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements MessageQueue.IdleHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f56033a;

        public b(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56033a = eVar;
        }

        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.f56033a.t0();
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f56034a;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b0 f56035e;

            public a(b0 b0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {b0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f56035e = b0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f56035e.f56034a.m.m();
                    if (this.f56035e.f56034a.y || !this.f56035e.f56034a.z) {
                        return;
                    }
                    this.f56035e.f56034a.v.n(this.f56035e.f56034a.w, this.f56035e.f56034a.x, this.f56035e.f56034a.u, true);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b0(e eVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2)};
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
            this.f56034a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b2 b2Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                List<d.a.d.k.e.n> h2 = this.f56034a.m.h();
                if (!ListUtils.isEmpty(h2)) {
                    for (d.a.d.k.e.n nVar : h2) {
                        if (nVar instanceof d.a.q0.a0.e0.k) {
                            d.a.q0.a0.e0.k kVar = (d.a.q0.a0.e0.k) nVar;
                            if (kVar.o != 0 && (b2Var = kVar.f54338e) != null) {
                                int[] e0 = b2Var.e0();
                                kVar.o = e0[0];
                                kVar.p = e0[1];
                            }
                        }
                    }
                }
                d.a.d.e.m.e.a().postDelayed(new a(this), 500L);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends d.a.p0.b1.f0<DataRes> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.p0.b1.f0
        /* renamed from: a */
        public DataRes doInBackground() {
            InterceptResult invokeV;
            byte[] bArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                d.a.d.e.d.l<byte[]> e2 = d.a.p0.s.r.a.f().e("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
                if (e2 != null && (bArr = e2.get("0")) != null && bArr.length != 0) {
                    try {
                        return (DataRes) new Wire(new Class[0]).parseFrom(bArr, DataRes.class);
                    } catch (IOException e3) {
                        BdLog.e(e3);
                    }
                }
                return null;
            }
            return (DataRes) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class c0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f56036a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c0(e eVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2)};
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
            this.f56036a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof k1)) {
                k1 k1Var = (k1) customResponsedMessage.getData();
                if (k1Var.f53376a != 1) {
                    return;
                }
                int k = d.a.d.e.p.l.k(TbadkCoreApplication.getInst());
                int i2 = d.a.d.e.p.l.i(TbadkCoreApplication.getInst());
                float f2 = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                int i3 = TbImageHelper.getInstance().isShowBigImage() ? 2 : 1;
                RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                requestGetMyPostNetMessage.setTag(this.f56036a.N);
                requestGetMyPostNetMessage.setParams(d.a.d.e.m.b.f(k1Var.f53378c, 0L), 0L, 0L, k, i2, f2, i3);
                requestGetMyPostNetMessage.setBFrom("push");
                MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements d.a.p0.b1.n<DataRes> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f56037a;

        public d(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56037a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.p0.b1.n
        /* renamed from: a */
        public void onReturnDataInUI(DataRes dataRes) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dataRes) == null) {
                this.f56037a.w0(dataRes);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d0 extends d.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f56038a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d0(e eVar, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2), Integer.valueOf(i3)};
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
            this.f56038a = eVar;
        }

        @Override // d.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            GetMyPostResIdl responseData;
            tbclient.GetMyPost.DataRes dataRes;
            ThreadInfo threadInfo;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                    responseData = ((GetMyPostHttpResponseMessage) responsedMessage).getResponseData();
                } else {
                    responseData = responsedMessage instanceof GetMyPostSocketResponseMessage ? ((GetMyPostSocketResponseMessage) responsedMessage).getResponseData() : null;
                }
                if (responseData == null || (dataRes = responseData.data) == null || (threadInfo = dataRes.thread_info) == null) {
                    return;
                }
                this.f56038a.P = threadInfo;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921455));
            }
        }
    }

    /* renamed from: d.a.q0.e1.h.e$e  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1353e extends d.a.p0.b1.f0<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DataRes.Builder f56039a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f56040b;

        public C1353e(e eVar, DataRes.Builder builder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, builder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56040b = eVar;
            this.f56039a = builder;
        }

        @Override // d.a.p0.b1.f0
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                DataRes.Builder builder = new DataRes.Builder(this.f56039a.build(true));
                this.f56040b.f56023b.g(builder.thread_list);
                try {
                    d.a.p0.s.r.a.f().e("tb.rec_old_data", TbadkCoreApplication.getCurrentAccount()).g("0", builder.build(true).toByteArray());
                    return null;
                } catch (Exception e2) {
                    BdLog.e(e2);
                    return null;
                }
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class e0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f56041a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e0(e eVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2)};
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
            this.f56041a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && d.a.p0.t.h.a.e(TbadkCoreApplication.getInst(), 1)) {
                d.a.p0.t.h.a.g(this.f56041a.j, 7, 0L);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f extends d.a.p0.b1.f0<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DataRes.Builder f56042a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f56043b;

        public f(e eVar, DataRes.Builder builder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, builder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56043b = eVar;
            this.f56042a = builder;
        }

        @Override // d.a.p0.b1.f0
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                DataRes.Builder builder = new DataRes.Builder(this.f56042a.build(true));
                this.f56043b.f56023b.g(builder.thread_list);
                try {
                    d.a.p0.s.r.a.f().e("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount()).g("0", builder.build(true).toByteArray());
                    return null;
                } catch (Exception e2) {
                    BdLog.e(e2);
                    return null;
                }
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class f0 implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f56044e;

        public f0(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56044e = eVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (this.f56044e.F != null) {
                    this.f56044e.F.onTouch(view, motionEvent);
                }
                if (this.f56044e.t != null) {
                    this.f56044e.t.c(motionEvent);
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f56045e;

        public g(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56045e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                FullBrowseHelper.checkAndShowFullBrowseModeDialog(this.f56045e.j, null);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g0 implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f56046a;

        public g0(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56046a = eVar;
        }

        @Override // d.a.q0.i0.a.b
        public void a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                this.f56046a.u = false;
            }
        }

        @Override // d.a.q0.i0.a.b
        public void b(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
                this.f56046a.u = true;
            }
        }

        @Override // d.a.q0.i0.a.b
        public void c(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            }
        }

        @Override // d.a.q0.i0.a.b
        public void d(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements HomePageYoungsterTopView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f56047a;

        public h(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56047a = eVar;
        }

        @Override // com.baidu.tieba.homepage.personalize.view.HomePageYoungsterTopView.b
        public void onDelete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                BdTopToast bdTopToast = new BdTopToast(this.f56047a.j.getPageActivity(), 2000);
                bdTopToast.i(true);
                bdTopToast.h(this.f56047a.j.getPageActivity().getString(R.string.youngster_frs_top_toast));
                bdTopToast.j((ViewGroup) this.f56047a.j.getPageActivity().findViewById(R.id.maintabContainer));
                this.f56047a.Y0(false);
                d.a.p0.s.d0.b.j().t("key_youngster_homgpage_top_view_closed", true);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f56048a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h0(e eVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2)};
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
            this.f56048a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f56048a.k == null) {
                return;
            }
            this.f56048a.v.w();
            this.f56048a.z = false;
            this.f56048a.l.setRefreshing(true);
        }
    }

    /* loaded from: classes8.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f56049a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(e eVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2)};
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
            this.f56049a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b2 b2Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof b2) || this.f56049a.f56026e == null || ListUtils.getCount(this.f56049a.f56026e.thread_list) == 0 || (b2Var = (b2) customResponsedMessage.getData()) == null || b2Var.H0() == null || b2Var.d0() == null || ListUtils.getCount(this.f56049a.f56026e.thread_list) == 0) {
                return;
            }
            for (int i2 = 0; i2 < this.f56049a.f56026e.thread_list.size(); i2++) {
                ThreadInfo threadInfo = this.f56049a.f56026e.thread_list.get(i2);
                if (threadInfo != null && threadInfo.id.longValue() == d.a.d.e.m.b.f(b2Var.d0(), -1L)) {
                    ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                    Zan.Builder builder2 = new Zan.Builder(builder.zan);
                    builder2.num = Integer.valueOf((int) b2Var.H0().getNum());
                    builder.zan = builder2.build(true);
                    this.f56049a.f56026e.thread_list.set(i2, builder.build(true));
                    return;
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f56050a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i0(e eVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2)};
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
            this.f56050a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f56050a.k == null) {
                return;
            }
            this.f56050a.a0();
        }
    }

    /* loaded from: classes8.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f56051a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(e eVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2)};
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
            this.f56051a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b2 b2Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage.getOrginalMessage() instanceof LiveRoomClosedQueryMessage)) {
                List<Long> ids = ((LiveRoomClosedQueryMessage) customResponsedMessage.getOrginalMessage()).getIds();
                List<Object> originData = ((LiveRoomClosedQueryMessage) customResponsedMessage.getOrginalMessage()).getOriginData();
                if (ListUtils.isEmpty(this.f56051a.f56025d) || ListUtils.isEmpty(ids) || ListUtils.isEmpty(originData)) {
                    return;
                }
                for (int i2 = 0; i2 < originData.size(); i2++) {
                    if ((originData.get(i2) instanceof b2) && (b2Var = (b2) originData.get(i2)) != null && b2Var.h1() != null && ids.contains(Long.valueOf(b2Var.h1().live_id))) {
                        this.f56051a.f56025d.remove(b2Var);
                    }
                }
                if (this.f56051a.m != null) {
                    this.f56051a.m.z(new ArrayList(this.f56051a.f56025d));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f56052a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j0(e eVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2)};
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
            this.f56052a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                Object data = customResponsedMessage.getData();
                int intValue = data instanceof Integer ? ((Integer) data).intValue() : 0;
                if (intValue == 2) {
                    BdTopToast bdTopToast = new BdTopToast(this.f56052a.j.getPageActivity(), 2000);
                    bdTopToast.i(true);
                    bdTopToast.h(this.f56052a.j.getPageActivity().getString(R.string.youngster_open_title));
                    bdTopToast.j((ViewGroup) this.f56052a.j.getPageActivity().findViewById(R.id.maintabContainer));
                    this.f56052a.Y0(true);
                } else if (intValue == 3) {
                    BdTopToast bdTopToast2 = new BdTopToast(this.f56052a.j.getPageActivity(), 2000);
                    bdTopToast2.i(true);
                    bdTopToast2.h(this.f56052a.j.getPageActivity().getString(R.string.youngster_close_title));
                    bdTopToast2.j((ViewGroup) this.f56052a.j.getPageActivity().findViewById(R.id.maintabContainer));
                    this.f56052a.Y0(false);
                } else if (intValue != 5) {
                    if (d.a.p0.e1.b.e.d()) {
                        this.f56052a.Y0(true);
                    }
                } else {
                    BdTopToast bdTopToast3 = new BdTopToast(this.f56052a.j.getPageActivity(), 2000);
                    bdTopToast3.i(true);
                    bdTopToast3.h(this.f56052a.j.getPageActivity().getString(R.string.youngster_reset_title));
                    bdTopToast3.j((ViewGroup) this.f56052a.j.getPageActivity().findViewById(R.id.maintabContainer));
                    this.f56052a.Y0(true);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class k implements ScrollFragmentTabHost.t {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f56053a;

        public k(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56053a = eVar;
        }

        @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.t
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.f56053a.s.B(i2) == 1 || this.f56053a.o == null) {
                return;
            }
            this.f56053a.o.d();
        }
    }

    /* loaded from: classes8.dex */
    public class k0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f56054a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k0(e eVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2)};
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
            this.f56054a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            Boolean bool = Boolean.FALSE;
            if (customResponsedMessage.getData() instanceof Boolean) {
                bool = (Boolean) customResponsedMessage.getData();
            }
            if (bool.booleanValue()) {
                this.f56054a.V0(true);
            } else {
                this.f56054a.V0(false);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f56055a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(e eVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2)};
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
            this.f56055a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            User user;
            int intValue;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || !(customResponsedMessage instanceof UpdateAttentionMessage) || this.f56055a.f56026e == null || ListUtils.isEmpty(this.f56055a.f56026e.thread_list)) {
                return;
            }
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage.getData() == null || StringUtils.isNull(updateAttentionMessage.getData().f12868c)) {
                return;
            }
            int i2 = 0;
            while (true) {
                if (i2 >= this.f56055a.f56026e.thread_list.size()) {
                    break;
                }
                ThreadInfo threadInfo = this.f56055a.f56026e.thread_list.get(i2);
                if (threadInfo == null || (user = threadInfo.author) == null || user.id.longValue() != d.a.d.e.m.b.f(updateAttentionMessage.getData().f12868c, -1L)) {
                    i2++;
                } else {
                    ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                    User.Builder builder2 = new User.Builder(builder.author);
                    builder2.is_like = Integer.valueOf(updateAttentionMessage.getData().f12869d ? 1 : 0);
                    builder2.has_concerned = Integer.valueOf(updateAttentionMessage.getData().f12869d ? 1 : 0);
                    GodInfo.Builder builder3 = new GodInfo.Builder(builder2.god_data);
                    if (updateAttentionMessage.getData().f12869d) {
                        intValue = builder2.fans_num.intValue() + 1;
                        builder3.followed = 1;
                    } else {
                        builder3.followed = 0;
                        intValue = builder2.fans_num.intValue() - 1;
                    }
                    builder2.fans_num = Integer.valueOf(intValue);
                    builder2.god_data = builder3.build(true);
                    builder.author = builder2.build(true);
                    this.f56055a.f56026e.thread_list.set(i2, builder.build(true));
                }
            }
            this.f56055a.c1(updateAttentionMessage);
        }
    }

    /* loaded from: classes8.dex */
    public interface l0 {
        void a(int i2, d.a.p0.b1.c cVar, int i3);

        void b();

        void c(int i2, int i3, d.a.p0.b1.c cVar, int i4);

        void d(boolean z);

        void onError(int i2, String str);
    }

    /* loaded from: classes8.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f56056a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(e eVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2)};
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
            this.f56056a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Long) || this.f56056a.f56026e == null || this.f56056a.f56026e.hot_recomforum == null || ListUtils.isEmpty(this.f56056a.f56026e.hot_recomforum.tab_list)) {
                return;
            }
            long longValue = ((Long) customResponsedMessage.getData()).longValue();
            DiscoverHotForum.Builder builder = new DiscoverHotForum.Builder(this.f56056a.f56026e.hot_recomforum);
            if (d.a.q0.e1.c.c.c(builder, longValue, customResponsedMessage.getCmd() == 2001335)) {
                this.f56056a.f56026e.hot_recomforum = builder.build(true);
                this.f56056a.F0(new DataRes.Builder(this.f56056a.f56026e.build(true)));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class n extends d.a.p0.b1.f0<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f56057a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f56058b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e f56059c;

        public n(e eVar, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56059c = eVar;
            this.f56057a = str;
            this.f56058b = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // d.a.p0.b1.f0
        public Boolean doInBackground() {
            InterceptResult invokeV;
            int intValue;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                try {
                    d.a.d.e.d.l<byte[]> e2 = d.a.p0.s.r.a.f().e("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
                    if (e2 == null) {
                        return Boolean.FALSE;
                    }
                    byte[] bArr = e2.get("0");
                    if (bArr != null && bArr.length != 0) {
                        DataRes.Builder builder = new DataRes.Builder((DataRes) new Wire(new Class[0]).parseFrom(bArr, DataRes.class));
                        if (builder.thread_list != null && builder.thread_list.size() > 0) {
                            for (int i2 = 0; i2 < builder.thread_list.size(); i2++) {
                                ThreadInfo threadInfo = builder.thread_list.get(i2);
                                if (threadInfo != null && threadInfo.author != null && threadInfo.author.id.longValue() == d.a.d.e.m.b.f(this.f56057a, -1L)) {
                                    ThreadInfo.Builder builder2 = new ThreadInfo.Builder(threadInfo);
                                    User.Builder builder3 = new User.Builder(builder2.author);
                                    builder3.is_like = Integer.valueOf(this.f56058b ? 1 : 0);
                                    builder3.has_concerned = Integer.valueOf(this.f56058b ? 1 : 0);
                                    GodInfo.Builder builder4 = new GodInfo.Builder(builder3.god_data);
                                    if (this.f56058b) {
                                        intValue = builder3.fans_num.intValue() + 1;
                                        builder4.followed = 1;
                                    } else {
                                        intValue = builder3.fans_num.intValue() - 1;
                                        builder4.followed = 0;
                                    }
                                    builder3.fans_num = Integer.valueOf(intValue);
                                    builder3.god_data = builder4.build(true);
                                    builder2.author = builder3.build(true);
                                    builder.thread_list.set(i2, builder2.build(true));
                                }
                            }
                            DataRes.Builder builder5 = new DataRes.Builder(builder.build(true));
                            this.f56059c.f56023b.g(builder5.thread_list);
                            e2.g("0", builder5.build(true).toByteArray());
                            return Boolean.TRUE;
                        }
                        return Boolean.FALSE;
                    }
                    return Boolean.FALSE;
                } catch (Exception e3) {
                    BdLog.e(e3);
                    return Boolean.FALSE;
                }
            }
            return (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class o implements d.a.p0.b1.n<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public o(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.p0.b1.n
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public class p extends d.a.p0.b1.f0<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f56060a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f56061b;

        public p(e eVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56061b = eVar;
            this.f56060a = i2;
        }

        @Override // d.a.p0.b1.f0
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                d.a.d.e.d.l<String> h2 = d.a.p0.s.r.a.f().h(this.f56061b.b0, TbadkCoreApplication.getCurrentAccount());
                if (h2 != null) {
                    h2.e(this.f56061b.b0, Integer.toString(this.f56060a), 43200000L);
                    return null;
                }
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class q implements d.a.q0.e1.h.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f56062a;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f56063e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ q f56064f;

            public a(q qVar, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {qVar, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f56064f = qVar;
                this.f56063e = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f56064f.f56062a.k.getHandler() == null) {
                    return;
                }
                this.f56064f.f56062a.k.requestFocusFromTouch();
                if (this.f56063e > this.f56064f.f56062a.k.getCount() - 1) {
                    return;
                }
                this.f56064f.f56062a.k.setSelection(this.f56063e);
            }
        }

        public q(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56062a = eVar;
        }

        @Override // d.a.q0.e1.h.d
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (this.f56062a.d0 == null) {
                    this.f56062a.d0 = new a(this, i2);
                }
                this.f56062a.k.removeCallbacks(this.f56062a.d0);
                this.f56062a.k.post(this.f56062a.d0);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class r extends d.a.p0.b1.f0<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f56065a;

        public r(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56065a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.p0.b1.f0
        /* renamed from: a */
        public String doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                d.a.d.e.d.l<String> h2 = d.a.p0.s.r.a.f().h(this.f56065a.b0, TbadkCoreApplication.getCurrentAccount());
                if (h2 != null) {
                    return h2.get(this.f56065a.b0);
                }
                return null;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class s implements d.a.p0.b1.n<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.e1.h.d f56066a;

        public s(e eVar, d.a.q0.e1.h.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56066a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.p0.b1.n
        /* renamed from: a */
        public void onReturnDataInUI(String str) {
            d.a.q0.e1.h.d dVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (dVar = this.f56066a) == null) {
                return;
            }
            dVar.a(d.a.d.e.m.b.d(str, 0));
        }
    }

    /* loaded from: classes8.dex */
    public class t extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f56067a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t(e eVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2)};
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
            this.f56067a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f56067a.G == null) {
                return;
            }
            TbSingleton.getInstance().isAddBanner = false;
            this.f56067a.f56025d.remove(this.f56067a.G);
            this.f56067a.m.z(new ArrayList(this.f56067a.f56025d));
            d.a.p0.s.d0.b.j().w("key_maintab_banner_close_time", System.currentTimeMillis());
        }
    }

    /* loaded from: classes8.dex */
    public class u extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f56068a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public u(e eVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2)};
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
            this.f56068a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f56068a.b0(customResponsedMessage);
                if (this.f56068a.v == null || !this.f56068a.z) {
                    return;
                }
                this.f56068a.v.n(this.f56068a.w, this.f56068a.x, this.f56068a.u, true);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class v extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f56069a;

        /* renamed from: b  reason: collision with root package name */
        public int f56070b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f56071c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e f56072d;

        public v(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56072d = eVar;
            this.f56069a = -1;
            this.f56070b = 0;
            this.f56071c = false;
        }

        public void a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                if (this.f56070b > i2) {
                    this.f56071c = true;
                }
                if (this.f56072d.E != null && !this.f56072d.y) {
                    this.f56072d.E.a(this.f56070b, i2);
                }
                this.f56070b = i2;
                int i4 = (i3 + i2) - 1;
                if (!this.f56071c && this.f56069a != i4) {
                    this.f56069a = i4;
                    this.f56072d.A0(i4);
                }
                if (this.f56071c && this.f56069a != i2) {
                    this.f56069a = i2;
                    this.f56072d.A0(i2);
                }
                this.f56072d.c0 = i2;
                this.f56072d.w = i2;
                this.f56072d.x = i4;
                ThreadCardViewHolder d0 = this.f56072d.d0();
                if (d0 == null || d0.b() == null) {
                    return;
                }
                d0.b().o(this.f56072d.O);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i2) == null) {
                if (this.f56072d.r == null) {
                    this.f56072d.r = new d.a.p0.o0.c();
                    this.f56072d.r.a(1005);
                    this.f56072d.r.f52814e = 1;
                }
                if (this.f56072d.E != null && !this.f56072d.y) {
                    this.f56072d.E.b(recyclerView, i2);
                }
                if (i2 == 0) {
                    d.a.q0.e1.h.c.b(this.f56072d.k);
                    this.f56072d.r.e();
                    d.a.q0.a0.t.b().d(true);
                    d.a.q0.o.d.c().h("page_recommend", "show_");
                    d.a.q0.g3.c.g().h(this.f56072d.I, false);
                    this.f56071c = false;
                    if (this.f56072d.v == null || !this.f56072d.z || this.f56072d.y) {
                        return;
                    }
                    this.f56072d.v.m(this.f56072d.w, this.f56072d.x, this.f56072d.u, 1);
                    return;
                }
                this.f56072d.r.d();
                if (i2 == 1) {
                    if (this.f56072d.o != null) {
                        this.f56072d.o.d();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921418));
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            int i4;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, recyclerView, i2, i3) == null) {
                int i5 = 0;
                if (recyclerView == null || !(recyclerView instanceof BdRecyclerView)) {
                    i4 = 0;
                } else {
                    BdRecyclerView bdRecyclerView = (BdRecyclerView) recyclerView;
                    i5 = bdRecyclerView.getFirstVisiblePosition();
                    i4 = bdRecyclerView.getLastVisiblePosition();
                }
                a(i5, (i4 - i5) + 1);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class w extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f56073a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public w(e eVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2)};
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
            this.f56073a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f56073a.b0(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class x extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f56074a;

        /* renamed from: b  reason: collision with root package name */
        public String f56075b;

        /* renamed from: c  reason: collision with root package name */
        public String f56076c;

        /* renamed from: d  reason: collision with root package name */
        public String f56077d;

        /* renamed from: e  reason: collision with root package name */
        public String f56078e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f56079f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public x(e eVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2)};
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
            this.f56079f = eVar;
            this.f56074a = "";
            this.f56075b = "";
            this.f56076c = "";
            this.f56077d = "";
            this.f56078e = "";
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof JSONObject)) {
                JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
                if (TextUtils.equals(jSONObject.optString("roomInfo"), "roomInfo")) {
                    this.f56074a = jSONObject.optString(ILiveNPSPlugin.PARAMS_ROOM_ID, "");
                    this.f56075b = jSONObject.optString("tid", "");
                    this.f56076c = jSONObject.optString("fid", "");
                    this.f56077d = jSONObject.optString("liveId", "");
                    this.f56078e = jSONObject.optString("sid", "");
                } else if ((this.f56074a == null || !TextUtils.equals(jSONObject.optString(ILiveNPSPlugin.PARAMS_ROOM_ID), this.f56074a)) && ((this.f56077d == null || !TextUtils.equals(jSONObject.optString("liveId"), this.f56077d)) && (this.f56078e == null || !TextUtils.equals(jSONObject.optString("sid"), this.f56078e)))) {
                } else {
                    try {
                        jSONObject.put("tid", this.f56075b);
                        jSONObject.put("fid", this.f56076c);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    this.f56079f.b0(customResponsedMessage);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class y extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f56080a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public y(e eVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2)};
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
            this.f56080a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f56080a.f56026e == null || ListUtils.getCount(this.f56080a.f56026e.thread_list) == 0) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            e eVar = this.f56080a;
            eVar.Y(str, eVar.f56025d);
            this.f56080a.a1(str);
            if (this.f56080a.m != null) {
                this.f56080a.m.z(new ArrayList(this.f56080a.f56025d));
            }
            if (this.f56080a.v == null || !this.f56080a.z) {
                return;
            }
            this.f56080a.v.n(this.f56080a.w, this.f56080a.x, this.f56080a.u, true);
        }
    }

    /* loaded from: classes8.dex */
    public class z extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f56081a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public z(e eVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2)};
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
            this.f56081a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ThreadCardViewHolder d0;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() != 0 || keyEvent.getKeyCode() != 24 || (d0 = this.f56081a.d0()) == null || d0.b() == null) {
                    return;
                }
                d0.b().o(new a.C0620a(3));
            }
        }
    }

    public e(TbPageContext<?> tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, d.a.q0.e1.h.h.c0 c0Var, BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeRecyclerView, c0Var, bigdaySwipeRefreshLayout};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f56024c = null;
        this.f56025d = new LinkedList();
        this.f56027f = 1;
        this.f56028g = false;
        this.f56029h = false;
        this.f56030i = 0;
        this.n = 2000;
        this.r = null;
        this.u = false;
        this.w = 0;
        this.x = 0;
        this.y = false;
        this.z = true;
        this.A = false;
        this.D = false;
        this.H = true;
        this.M = 0;
        this.N = BdUniqueId.gen();
        this.O = new a.C0620a(2);
        this.P = null;
        this.Q = new v(this);
        this.R = new f0(this);
        this.S = new g0(this);
        this.T = new h0(this, 2001399);
        this.U = new i0(this, 2921461);
        this.V = new j0(this, 2921486);
        this.W = new k0(this, 2921562);
        this.X = new i(this, 2004004);
        this.Y = new j(this, 2921026);
        this.Z = new l(this, 2001115);
        this.a0 = new m(this, 0);
        this.b0 = "lastReadReadPositionKey";
        this.c0 = 0;
        this.e0 = new q(this);
        this.f0 = new t(this, 2016569);
        this.g0 = new u(this, 2016488);
        this.h0 = new w(this, 2016553);
        this.i0 = new x(this, 2921547);
        this.j0 = new y(this, 2016331);
        this.k0 = new z(this, 2921381);
        this.l0 = new a0(this, CmdConfigHttp.CMD_TOPIC_BLESS, 309085);
        this.m0 = new b0(this, 2921414);
        this.n0 = new c0(this, 2921453);
        this.o0 = new d0(this, CmdConfigHttp.CMD_GET_MY_POST, 303111);
        this.p0 = new e0(this, 2921482);
        this.j = tbPageContext;
        this.M = d.a.p0.s.d0.b.j().k("key_personalized_refresh_type", 0);
        this.l = bigdaySwipeRefreshLayout;
        this.k = bdTypeRecyclerView;
        bdTypeRecyclerView.setOnTouchListener(this.R);
        if (d.a.p0.e1.b.e.d()) {
            Y0(true);
        }
        d.a.q0.i0.a aVar = new d.a.q0.i0.a();
        this.t = aVar;
        aVar.d(this.S);
        this.m = c0Var;
        this.p = new d.a.q0.e1.h.k.a();
        this.f56022a = d.a.p0.s.d0.b.j().l("recommend_frs_cache_time", 1800L) * 1000;
        bdTypeRecyclerView.setOnScrollListener(this.Q);
        this.o = new c1();
        j0();
        d.a.q0.n2.i iVar = new d.a.q0.n2.i(this.j, this.k);
        this.v = iVar;
        iVar.p(1);
        this.v.u(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.f56023b = new d.a.q0.e1.h.b(this.f56025d, this.m);
        SmartBubbleAnimatedView smartBubbleAnimatedView = new SmartBubbleAnimatedView(tbPageContext.getContext());
        this.J = smartBubbleAnimatedView;
        smartBubbleAnimatedView.setLayoutParams(new FrameLayout.LayoutParams(-1, d.a.d.e.p.l.g(tbPageContext.getContext(), R.dimen.tbds83)));
        J0();
        this.m0.setTag(this.j.getUniqueId());
        MessageManager.getInstance().registerListener(this.m0);
        if (MessageManager.getInstance().findTask(CmdConfigHttp.CMD_GET_MY_POST) == null) {
            HomePageStatic.a();
        }
        this.o0.setTag(this.N);
        if (this.o0.getHttpMessageListener() != null) {
            this.o0.getHttpMessageListener().setSelfListener(true);
        }
        if (this.o0.getSocketMessageListener() != null) {
            this.o0.getSocketMessageListener().setSelfListener(true);
        }
        MessageManager.getInstance().registerListener(this.o0);
        MessageManager.getInstance().registerListener(this.n0);
        MessageManager.getInstance().registerListener(this.p0);
    }

    public void A0(int i2) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            d.a.q0.h3.h0.f fVar = this.q;
            if ((fVar != null ? fVar.b(i2) : -1) >= 0 && (bdTypeRecyclerView = this.k) != null && bdTypeRecyclerView.getData() != null && this.k.getData().size() > i2) {
                this.q.c(i2);
            }
        }
    }

    public void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            d.a.q0.e1.h.c.b(this.k);
            T(this.c0);
            d.a.p0.o0.c cVar = this.r;
            if (cVar != null) {
                cVar.c();
            }
        }
    }

    public void C0(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z2) == null) && z2) {
            this.m.m();
        }
    }

    public final void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (ListUtils.getCount(this.f56025d) < this.p.e() - 40) {
                return;
            }
            List<d.a.d.k.e.n> list = null;
            d.a.q0.e1.h.k.c c2 = this.p.c(true, this.f56026e, null, 1);
            int i2 = 0;
            if (c2 != null) {
                list = c2.f56198a;
                int i3 = c2.f56200c;
                c2.f56200c = 0;
                i2 = i3;
            }
            if (list != null) {
                this.f56025d.clear();
                this.f56025d.addAll(list);
                this.m.A(new LinkedList(this.f56025d), i2);
            }
        }
    }

    public final boolean E0(boolean z2, boolean z3, boolean z4, DataRes dataRes) {
        InterceptResult invokeCommon;
        List<d.a.d.k.e.n> list;
        int i2;
        BlockPopInfo blockPopInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), dataRes})) == null) {
            boolean z5 = false;
            if (dataRes == null) {
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (this.M == 1) {
                if (z3 && (dataRes.thread_list.size() >= 6 || k0())) {
                    L0();
                    this.f56026e = null;
                }
            } else if (z3 && k0()) {
                this.f56026e = null;
            }
            int size = z3 ? 0 : this.f56025d.size();
            DataRes.Builder builder = new DataRes.Builder(dataRes);
            this.f56025d.clear();
            d.a.q0.e1.h.k.c c2 = this.p.c(z2, this.f56026e, builder, !z3 ? 1 : 0);
            if (c2 != null) {
                list = c2.f56198a;
                this.f56030i = c2.f56199b;
                i2 = c2.f56200c;
                c2.f56200c = 0;
            } else {
                list = null;
                i2 = 0;
            }
            if (list != null) {
                this.f56025d.addAll(list);
                R(list, size);
                K0(!z3 ? 1 : 0, list, size);
                if (this.D) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
                }
            }
            if (this.f56026e == null) {
                this.f56026e = builder;
                this.f56023b.j(builder.thread_list);
            }
            if (this.f56025d.size() != 0) {
                if (z3) {
                    if (dataRes.live_answer != null) {
                        d.a.q0.e1.h.j.h hVar = new d.a.q0.e1.h.j.h();
                        this.G = hVar;
                        hVar.c(dataRes.live_answer);
                        this.f56026e.live_answer = dataRes.live_answer;
                    } else if (z2) {
                        this.G = null;
                        this.f56026e.live_answer = null;
                    }
                    this.f56026e.float_info = dataRes.float_info;
                }
                long l2 = d.a.p0.s.d0.b.j().l("key_maintab_banner_close_time", 0L);
                if (this.G != null && !StringHelper.isTaday(l2)) {
                    TbSingleton.getInstance().isAddBanner = true;
                    this.f56025d.add(0, this.G);
                }
                LinkedList linkedList = new LinkedList(this.f56025d);
                d.a.q0.e1.h.h.c0 c0Var = this.m;
                Integer num = dataRes.is_new_url;
                if (num != null && num.intValue() == 1) {
                    z5 = true;
                }
                c0Var.t(z5);
                this.m.A(linkedList, i2);
                d.a.q0.n2.i iVar = this.v;
                if (iVar != null && this.z) {
                    iVar.n(this.w, this.x, this.u, true);
                }
                z5 = true;
            }
            d.a.q0.e1.d.a.d().i(System.currentTimeMillis() - currentTimeMillis, 1);
            long e2 = d.a.q0.e1.d.a.d().e(1);
            int i3 = (e2 > 0L ? 1 : (e2 == 0L ? 0 : -1));
            if (i3 > 0) {
                d.a.q0.e1.d.a.d().k(System.currentTimeMillis() - e2, 1);
                d.a.q0.e1.d.a.d().j(0L, 1);
            }
            Anti anti = dataRes.anti;
            if (anti != null && (blockPopInfo = anti.block_pop_info) != null) {
                d.a.q0.p3.d.g(blockPopInfo);
            }
            m1 m1Var = new m1();
            m1Var.a(dataRes.recom_post_topic);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921333, m1Var));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921543, null));
            if (!z2 && i3 > 0) {
                d.a.p0.o0.l.b().H(System.currentTimeMillis() - e2);
            }
            return z5;
        }
        return invokeCommon.booleanValue;
    }

    public final void F0(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, builder) == null) {
            d.a.p0.b1.i0.b(new f(this, builder), null);
        }
    }

    public void G0(int i2, int i3) {
        b2 b2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048582, this, i2, i3) == null) || ListUtils.isEmpty(this.f56025d) || this.f56025d.size() <= i2) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        while (i2 < this.f56025d.size() && i2 <= i3) {
            if (this.f56025d.get(i2).getType().getId() == b2.s3.getId() && (b2Var = (b2) this.f56025d.get(i2)) != null && b2Var.h1() != null) {
                arrayList.add(Long.valueOf(b2Var.h1().live_id));
                arrayList2.add(b2Var);
            }
            i2++;
        }
        if (ListUtils.isEmpty(arrayList)) {
            return;
        }
        MessageManager.getInstance().sendMessage(new LiveRoomClosedQueryMessage(arrayList, arrayList2));
    }

    public void H0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            d.a.q0.n2.i iVar = this.v;
            if (iVar != null && !this.y && this.z) {
                iVar.n(this.w, this.x, this.u, true);
            }
            if (this.A) {
                BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.l;
                if (bigdaySwipeRefreshLayout != null && !bigdaySwipeRefreshLayout.u()) {
                    boolean z2 = this.B;
                    if (z2) {
                        d.a.q0.g3.c.g().h(this.I, false);
                        if (l0(false)) {
                            X0(3, this.f56030i);
                        } else if (this.C > 0) {
                            X0(2, this.f56030i);
                        }
                    } else if (!z2 && this.f56030i == 0) {
                        X0(2, 0);
                    }
                }
                this.A = false;
                this.B = false;
                this.C = 0;
                if (this.D) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
                }
                this.D = false;
            }
        }
    }

    public void I0(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bdUniqueId) == null) || bdUniqueId == null) {
            return;
        }
        this.I = bdUniqueId;
        CustomMessageListener customMessageListener = this.X;
        if (customMessageListener != null) {
            customMessageListener.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.X);
        }
        CustomMessageListener customMessageListener2 = this.T;
        if (customMessageListener2 != null) {
            customMessageListener2.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.T);
        }
        this.U.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.U);
        this.Z.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.Z);
        this.a0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(2001335, this.a0);
        MessageManager.getInstance().registerListener(2001336, this.a0);
        this.Y.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.Y);
        this.g0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.g0);
        this.h0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.h0);
        this.i0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.i0);
        this.j0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.j0);
        d.a.q0.n2.i iVar = this.v;
        if (iVar != null) {
            iVar.t(bdUniqueId);
        }
        this.f56023b.i(bdUniqueId);
        this.f0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f0);
        this.k0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.k0);
        this.l0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.l0);
        this.V.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.V);
        this.W.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.W);
    }

    public final void J0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2016323, new a(this));
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public void K0(int i2, List<d.a.d.k.e.n> list, int i3) {
        d.a.q0.h3.h0.f fVar;
        int i4;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i2), list, Integer.valueOf(i3)}) == null) || (fVar = this.q) == null) {
            return;
        }
        if (i2 == 0) {
            fVar.d();
        }
        if (list == null || list.isEmpty()) {
            return;
        }
        int[] iArr = d.a.q0.h3.h0.f.f58550e;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < list.size() && i5 < iArr.length && (i4 = iArr[i5]) >= 0; i7++) {
            if ((list.get(i7) instanceof d.a.q0.a0.e0.b) && (i6 = i6 + 1) == i4 - 1) {
                int i8 = i7 + 1;
                if (i3 < i8) {
                    this.q.a(i4, i8);
                }
                i5++;
            }
        }
    }

    public final void L0() {
        DataRes.Builder builder;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (builder = this.f56026e) == null) {
            return;
        }
        DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
        List<ThreadInfo> list = builder2.thread_list;
        if (list != null && list.size() > 50) {
            builder2.thread_list = builder2.thread_list.subList(0, 50);
        }
        List<ThreadInfo> list2 = builder2.thread_list;
        V(builder2, list2 != null ? list2.size() : 0);
        d.a.p0.b1.i0.b(new C1353e(this, builder2), null);
    }

    public void M0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            d.a.q0.e1.h.c.c(this.k);
        }
    }

    public void N0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z2) == null) {
            this.H = z2;
            c1 c1Var = this.o;
            if (c1Var == null || z2) {
                return;
            }
            c1Var.d();
        }
    }

    public final void O0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z2) == null) {
            this.f56028g = z2;
        }
    }

    public void P0(l0 l0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, l0Var) == null) {
            this.f56024c = l0Var;
        }
    }

    public void Q0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z2) == null) {
            this.z = z2;
        }
    }

    public final void R(List<d.a.d.k.e.n> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048593, this, list, i2) == null) {
            Set<d.a.d.k.e.n> a2 = d.a.q0.w2.a.a(list, this.f56027f, "NEWINDEX");
            if (a2.size() > 0) {
                d.a.q0.g3.c.g().c(this.I, d.a.q0.g3.a.h("a002", "common_fill", true, a2.size()));
            }
        }
    }

    public void R0(d.a.p0.b1.b0 b0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, b0Var) == null) || b0Var == null) {
            return;
        }
        this.E = b0Var.a();
        this.F = b0Var.b();
    }

    public final d.a.p0.b1.c S(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048595, this, z2)) == null) {
            String e2 = d.a.q0.w2.a.e(this.f56025d, z2);
            int U = U(z2);
            d.a.p0.b1.c cVar = new d.a.p0.b1.c();
            cVar.f52038b = e2;
            cVar.f52037a = U;
            return cVar;
        }
        return (d.a.p0.b1.c) invokeZ.objValue;
    }

    public void S0(ScrollFragmentTabHost scrollFragmentTabHost) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, scrollFragmentTabHost) == null) {
            this.s = scrollFragmentTabHost;
            if (scrollFragmentTabHost == null) {
                return;
            }
            scrollFragmentTabHost.setOnTabSelectedListener(new k(this));
        }
    }

    public void T(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            d.a.p0.b1.i0.b(new p(this, i2), null);
        }
    }

    public void T0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z2) == null) {
            this.y = z2;
        }
    }

    public int U(boolean z2) {
        InterceptResult invokeZ;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048599, this, z2)) == null) {
            List<d.a.d.k.e.n> list = this.f56025d;
            int i4 = 0;
            if (list == null || list.size() == 0) {
                return 0;
            }
            int i5 = -1;
            if (z2) {
                int i6 = 0;
                while (i4 < this.f56025d.size()) {
                    d.a.d.k.e.n nVar = this.f56025d.get(i4);
                    if ((nVar instanceof d.a.q0.a0.e0.b) && (i3 = ((d.a.q0.a0.e0.b) nVar).position) != i5) {
                        i6++;
                        i5 = i3;
                    }
                    if ((nVar instanceof d.a.q0.e1.h.j.a) && nVar.getType() != AdvertAppInfo.n4) {
                        return i6;
                    }
                    i4++;
                }
            } else {
                for (int size = this.f56025d.size() - 1; size >= 0; size--) {
                    d.a.d.k.e.n nVar2 = this.f56025d.get(size);
                    if ((nVar2 instanceof d.a.q0.a0.e0.b) && (i2 = ((d.a.q0.a0.e0.b) nVar2).position) != i5) {
                        i4++;
                        i5 = i2;
                    }
                    if ((nVar2 instanceof d.a.q0.e1.h.j.a) && nVar2.getType() != AdvertAppInfo.n4) {
                        return i4;
                    }
                }
            }
            return this.f56025d.size();
        }
        return invokeZ.intValue;
    }

    public void U0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            d.a.p0.t.c.b activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
            if (!activityPrizeData.g() || StringUtils.isNull(activityPrizeData.b())) {
                return;
            }
            String currentDay = UtilHelper.getCurrentDay();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (StringUtils.isNull(currentAccount)) {
                return;
            }
            String str = "";
            String p2 = d.a.p0.s.d0.b.j().p("activity_prize_feed_text_time", "");
            boolean z2 = true;
            if (!StringUtils.isNull(p2)) {
                String[] split = p2.split(TNCManager.TNC_PROBE_HEADER_SECEPTOR);
                if (split != null && split.length == 2) {
                    String str2 = split[0];
                    String[] split2 = split[1].split(",");
                    if (!StringUtils.isNull(str2) && split2.length != 0) {
                        if (str2.equals(currentDay)) {
                            List<String> asList = Arrays.asList(split2);
                            if (asList.contains(currentAccount)) {
                                z2 = false;
                            } else {
                                StringBuilder sb = new StringBuilder();
                                sb.append(currentDay);
                                sb.append(TNCManager.TNC_PROBE_HEADER_SECEPTOR);
                                for (String str3 : asList) {
                                    sb.append(str3);
                                    sb.append(",");
                                }
                                sb.append(currentAccount);
                                str = sb.toString();
                            }
                        } else {
                            str = currentDay + TNCManager.TNC_PROBE_HEADER_SECEPTOR + currentAccount;
                        }
                    } else {
                        str = currentDay + TNCManager.TNC_PROBE_HEADER_SECEPTOR + currentAccount;
                    }
                } else {
                    str = currentDay + TNCManager.TNC_PROBE_HEADER_SECEPTOR + currentAccount;
                }
            } else {
                str = currentDay + TNCManager.TNC_PROBE_HEADER_SECEPTOR + currentAccount;
            }
            if (z2) {
                X0(4, 0);
                d.a.p0.s.d0.b.j().x("activity_prize_feed_text_time", str);
            }
        }
    }

    public final void V(DataRes.Builder builder, int i2) {
        BannerList bannerList;
        BannerList.Builder builder2;
        List<App> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048601, this, builder, i2) == null) || builder == null || (bannerList = builder.banner_list) == null || bannerList.app == null || (list = (builder2 = new BannerList.Builder(bannerList)).app) == null) {
            return;
        }
        Iterator<App> it = list.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            App next = it.next();
            if (next != null) {
                int b2 = d.a.q0.w2.c.b(next);
                if (b2 < 0) {
                    it.remove();
                } else if (b2 < i2 + i3 + 1) {
                    i3++;
                } else {
                    it.remove();
                }
            } else {
                it.remove();
            }
        }
        builder.banner_list = builder2.build(false);
    }

    public final void V0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z2) == null) {
            if (z2) {
                if (this.L == null) {
                    HomePageBrowseModelTipView homePageBrowseModelTipView = new HomePageBrowseModelTipView(this.j.getPageActivity());
                    this.L = homePageBrowseModelTipView;
                    homePageBrowseModelTipView.setListener(new g(this));
                }
                BdTypeRecyclerView bdTypeRecyclerView = this.k;
                if (bdTypeRecyclerView != null) {
                    bdTypeRecyclerView.setHeaderView(this.L, false);
                    this.L.setVisibility(0);
                    this.k.scrollToPosition(0);
                    return;
                }
                return;
            }
            HomePageBrowseModelTipView homePageBrowseModelTipView2 = this.L;
            if (homePageBrowseModelTipView2 != null) {
                this.k.removeHeaderView(homePageBrowseModelTipView2);
                this.L.setVisibility(8);
                this.L = null;
            }
        }
    }

    public final void W(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, builder) == null) {
            builder.user_follow_live = null;
        }
    }

    public void W0() {
        d.a.p0.b1.a0 a0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || (a0Var = this.E) == null) {
            return;
        }
        a0Var.c(true);
    }

    public final void X(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, builder) == null) {
            builder.active_center = null;
        }
    }

    public final void X0(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048606, this, i2, i3) == null) || o0()) {
            return;
        }
        if (this.s != null) {
            this.o.f();
        }
        ScrollFragmentTabHost scrollFragmentTabHost = this.s;
        if (scrollFragmentTabHost != null && scrollFragmentTabHost.getCurrentTabType() != 1) {
            this.o.d();
        } else if (!this.H) {
            this.o.d();
        } else {
            String str = null;
            if (i2 == 2) {
                if (i3 > 0) {
                    str = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i3));
                } else {
                    str = TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_nodata);
                }
            } else if (i2 == 3) {
                str = TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_cache_invalid);
            } else if (i2 == 4) {
                str = TbadkCoreApplication.getInst().getActivityPrizeData().b();
            }
            if (TextUtils.isEmpty(str) || !d.a.d.e.p.j.z()) {
                return;
            }
            if (i2 == 4) {
                this.n = 3000;
            } else {
                this.n = 2000;
            }
            SmartBubbleAnimatedView smartBubbleAnimatedView = this.J;
            smartBubbleAnimatedView.f15498e = str;
            smartBubbleAnimatedView.f15499f = this.n;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 49;
            ScrollFragmentTabHost scrollFragmentTabHost2 = this.s;
            if (scrollFragmentTabHost2 != null) {
                FrameLayout frameLayout = scrollFragmentTabHost2.getFrameLayout();
                frameLayout.removeView(this.J);
                frameLayout.addView(this.J, layoutParams);
                this.J.g();
            }
        }
    }

    public final void Y(String str, List<d.a.d.k.e.n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048607, this, str, list) == null) || list == null || list.size() <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        Iterator<d.a.d.k.e.n> it = list.iterator();
        while (true) {
            AdvertAppInfo advertAppInfo = null;
            while (it.hasNext()) {
                d.a.d.k.e.n next = it.next();
                if (next instanceof d.a.q0.e1.h.j.a) {
                    advertAppInfo = ((d.a.q0.e1.h.j.a) next).c();
                } else if (next instanceof o0) {
                    o0 o0Var = (o0) next;
                    if (o0Var.c() instanceof AdvertAppInfo.ILegoAdvert) {
                        advertAppInfo = ((AdvertAppInfo.ILegoAdvert) o0Var.c()).getAdvertAppInfo();
                    }
                }
                if (advertAppInfo == null || !str.equals(advertAppInfo.R3)) {
                }
            }
            return;
            it.remove();
        }
    }

    public final void Y0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z2) == null) {
            boolean g2 = d.a.p0.s.d0.b.j().g("key_youngster_homgpage_top_view_closed", false);
            if (this.k == null || g2) {
                return;
            }
            if (z2) {
                if (this.K == null) {
                    HomePageYoungsterTopView homePageYoungsterTopView = new HomePageYoungsterTopView(this.j);
                    this.K = homePageYoungsterTopView;
                    homePageYoungsterTopView.setOnDeleteClick(new h(this));
                }
                this.k.setHeaderView(this.K, false);
                this.K.setVisibility(0);
                this.k.scrollToPosition(0);
                return;
            }
            HomePageYoungsterTopView homePageYoungsterTopView2 = this.K;
            if (homePageYoungsterTopView2 != null) {
                homePageYoungsterTopView2.setVisibility(8);
                this.k.removeHeaderView(this.K);
                this.K = null;
            }
        }
    }

    public void Z(Long l2) {
        DataRes.Builder builder;
        List<ThreadInfo> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048609, this, l2) == null) || (builder = this.f56026e) == null || (list = builder.thread_list) == null) {
            return;
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            ThreadInfo threadInfo = list.get(i2);
            if (threadInfo.tid.equals(l2) && threadInfo.top_agree_post != null) {
                ThreadInfo.Builder builder2 = new ThreadInfo.Builder(threadInfo);
                builder2.top_agree_post = null;
                list.set(i2, builder2.build(true));
                b1();
                E0(false, true, false, this.f56026e.build(true));
                return;
            }
        }
    }

    public void Z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            d.a.q0.e1.d.a.d().j(System.currentTimeMillis(), 1);
            this.f56027f = 1;
            this.D = true;
            if (this.f56025d.size() == 0 && !m0()) {
                if (this.f56029h) {
                    return;
                }
                q0();
                return;
            }
            r0();
        }
    }

    public final void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            Iterator<d.a.d.k.e.n> it = this.f56025d.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next() instanceof d.a.q0.e1.h.j.g) {
                    it.remove();
                    break;
                }
            }
            DataRes.Builder builder = this.f56026e;
            if (builder == null) {
                return;
            }
            builder.active_center = null;
            b1();
            BdTypeRecyclerView bdTypeRecyclerView = this.k;
            if (bdTypeRecyclerView != null) {
                List<Integer> f02 = f0(bdTypeRecyclerView);
                int intValue = f02.get(0).intValue();
                int intValue2 = f02.get(1).intValue();
                if (intValue == -1 || intValue2 == -1) {
                    return;
                }
                this.k.E(intValue, intValue2);
            }
        }
    }

    public final void a1(String str) {
        DataRes.Builder builder;
        BannerList bannerList;
        List<App> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048612, this, str) == null) || TextUtils.isEmpty(str) || (builder = this.f56026e) == null || (bannerList = builder.banner_list) == null || (list = bannerList.app) == null || list.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (App app : this.f56026e.banner_list.app) {
            if (app != null && str.equals(d.a.q0.w2.c.a(app))) {
                arrayList.add(app);
            }
        }
        BannerList.Builder builder2 = new BannerList.Builder(this.f56026e.banner_list);
        List<App> list2 = builder2.app;
        if (list2 != null) {
            list2.removeAll(arrayList);
        }
        this.f56026e.banner_list = builder2.build(false);
        DataRes.Builder builder3 = new DataRes.Builder(this.f56026e.build(true));
        builder3.banner_list = builder2.build(true);
        F0(builder3);
    }

    public final void b0(CustomResponsedMessage<?> customResponsedMessage) {
        DataRes.Builder builder;
        Long l2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048613, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof JSONObject) || (builder = this.f56026e) == null || ListUtils.getCount(builder.thread_list) == 0 || ListUtils.getCount(this.f56025d) == 0) {
            return;
        }
        JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
        String optString = jSONObject.optString("tid");
        if (StringUtils.isNull(optString)) {
            String optString2 = jSONObject.optString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID);
            if (this.k == null || TextUtils.isEmpty(optString2)) {
                return;
            }
            int i2 = 0;
            while (true) {
                if (i2 >= this.k.getCount()) {
                    break;
                }
                d.a.d.k.e.n B = this.k.B(i2);
                if (B instanceof d.a.q0.a0.e0.j) {
                    d.a.q0.a0.e0.j jVar = (d.a.q0.a0.e0.j) B;
                    if (jVar.getThreadData() != null && jVar.getThreadData().h1() != null && optString2.equals(String.valueOf(jVar.getThreadData().h1().live_id))) {
                        optString = jVar.getThreadData().o1();
                        break;
                    }
                }
                i2++;
            }
            if (StringUtils.isNull(optString)) {
                return;
            }
        }
        Iterator<d.a.d.k.e.n> it = this.f56025d.iterator();
        boolean z2 = false;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            d.a.d.k.e.n next = it.next();
            if (next instanceof d.a.q0.a0.e0.b) {
                d.a.q0.a0.e0.b bVar = (d.a.q0.a0.e0.b) next;
                if (bVar.getThreadData() != null && bVar.getThreadData().o1() != null) {
                    if (bVar.getThreadData().o1().equals(optString)) {
                        it.remove();
                        z2 = true;
                    } else if (z2) {
                        d.a.q0.e1.h.k.b.b(this.f56025d);
                        break;
                    }
                }
            }
        }
        DataRes.Builder builder2 = this.f56026e;
        if (builder2 == null || builder2.thread_list == null) {
            return;
        }
        long f2 = d.a.d.e.m.b.f(optString, 0L);
        int i3 = 0;
        while (true) {
            if (i3 < this.f56026e.thread_list.size()) {
                ThreadInfo threadInfo = this.f56026e.thread_list.get(i3);
                if (threadInfo != null && (l2 = threadInfo.tid) != null && l2.longValue() == f2) {
                    d.a.q0.e1.h.l.c.d(threadInfo.tid.longValue(), i3, this.f56026e.thread_list, this.f56025d);
                    this.f56026e.thread_list.remove(i3);
                    b1();
                    break;
                }
                i3++;
            } else {
                break;
            }
        }
        BdTypeRecyclerView bdTypeRecyclerView = this.k;
        if (bdTypeRecyclerView != null) {
            List<Integer> i02 = i0(optString, bdTypeRecyclerView);
            int intValue = i02.get(0).intValue();
            int intValue2 = i02.get(1).intValue();
            if (intValue == -1 || intValue2 == -1) {
                return;
            }
            this.k.E(intValue, intValue2);
        }
    }

    public final void b1() {
        DataRes.Builder builder;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048614, this) == null) || (builder = this.f56026e) == null) {
            return;
        }
        DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
        List<ThreadInfo> list = builder2.thread_list;
        if (list != null && list.size() > 30) {
            builder2.thread_list = builder2.thread_list.subList(0, 30);
        }
        List<ThreadInfo> list2 = builder2.thread_list;
        V(builder2, list2 != null ? list2.size() : 0);
        W(builder2);
        X(builder2);
        F0(builder2);
    }

    public void c0(d.a.q0.e1.h.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, dVar) == null) {
            d.a.p0.b1.i0.b(new r(this), new s(this, dVar));
        }
    }

    public final void c1(UpdateAttentionMessage updateAttentionMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048616, this, updateAttentionMessage) == null) || updateAttentionMessage.getData() == null || StringUtils.isNull(updateAttentionMessage.getData().f12868c)) {
            return;
        }
        d.a.p0.b1.i0.b(new n(this, updateAttentionMessage.getData().f12868c, updateAttentionMessage.getData().f12869d), new o(this));
    }

    public final ThreadCardViewHolder d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            d.a.q0.n2.i iVar = this.v;
            if (iVar == null || iVar.j() == null || !(this.v.j().getTag() instanceof ThreadCardViewHolder)) {
                return null;
            }
            return (ThreadCardViewHolder) this.v.j().getTag();
        }
        return (ThreadCardViewHolder) invokeV.objValue;
    }

    public final String e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return "key_rec_pfirst_load_" + TbadkCoreApplication.getCurrentAccount() + "_" + TbConfig.getVersion();
        }
        return (String) invokeV.objValue;
    }

    public final List<Integer> f0(BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048619, this, bdTypeRecyclerView)) == null) {
            ArrayList arrayList = new ArrayList(2);
            boolean z2 = false;
            int i2 = -1;
            int i3 = -1;
            for (int i4 = 0; i4 < bdTypeRecyclerView.getCount(); i4++) {
                d.a.d.k.e.n B = bdTypeRecyclerView.B(i4);
                if (B instanceof d.a.q0.e1.h.j.g) {
                    d.a.q0.e1.h.j.g gVar = (d.a.q0.e1.h.j.g) B;
                    if (!z2) {
                        i2 = i4;
                    }
                    z2 = true;
                    i3 = i4;
                }
            }
            arrayList.add(Integer.valueOf(i2));
            arrayList.add(Integer.valueOf(i3));
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final f.i g0() {
        InterceptResult invokeV;
        BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout;
        char c2;
        ScrollFragmentTabHost scrollFragmentTabHost;
        String b2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048620, this)) != null) {
            return (f.i) invokeV.objValue;
        }
        if (!this.A || (bigdaySwipeRefreshLayout = this.l) == null || !bigdaySwipeRefreshLayout.u() || o0()) {
            return null;
        }
        int i2 = this.f56030i;
        boolean z2 = this.B;
        if (z2) {
            d.a.q0.g3.c.g().h(this.I, false);
            if (l0(false)) {
                c2 = 3;
            } else if (this.C <= 0) {
                c2 = 0;
            }
            if (this.s != null) {
                this.o.f();
            }
            scrollFragmentTabHost = this.s;
            if (scrollFragmentTabHost == null && scrollFragmentTabHost.getCurrentTabType() != 1) {
                this.o.d();
                return null;
            } else if (this.H) {
                this.o.d();
                return null;
            } else {
                if (c2 == 2) {
                    if (i2 > 0) {
                        b2 = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i2));
                    } else {
                        b2 = TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_nodata);
                    }
                } else if (c2 == 3) {
                    b2 = TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_cache_invalid);
                } else {
                    b2 = c2 == 4 ? TbadkCoreApplication.getInst().getActivityPrizeData().b() : null;
                }
                if (TextUtils.isEmpty(b2) || !d.a.d.e.p.j.z()) {
                    return null;
                }
                if (c2 == 4) {
                    this.n = 1000;
                } else {
                    this.n = 0;
                }
                return new f.i(b2, this.n);
            }
        } else if (z2 || i2 != 0) {
            return null;
        } else {
            i2 = 0;
        }
        c2 = 2;
        if (this.s != null) {
        }
        scrollFragmentTabHost = this.s;
        if (scrollFragmentTabHost == null) {
        }
        if (this.H) {
        }
    }

    public d.a.q0.n2.i h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.v : (d.a.q0.n2.i) invokeV.objValue;
    }

    public final List<Integer> i0(String str, BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048622, this, str, bdTypeRecyclerView)) == null) {
            ArrayList arrayList = new ArrayList(2);
            boolean z2 = false;
            int i2 = -1;
            int i3 = -1;
            for (int i4 = 0; i4 < bdTypeRecyclerView.getCount(); i4++) {
                d.a.d.k.e.n B = bdTypeRecyclerView.B(i4);
                if (B instanceof d.a.q0.a0.e0.b) {
                    d.a.q0.a0.e0.b bVar = (d.a.q0.a0.e0.b) B;
                    if (bVar.getThreadData() != null && bVar.getThreadData().o1().equals(str)) {
                        if (!z2) {
                            i2 = i4;
                        }
                        z2 = true;
                        i3 = i4;
                    }
                }
            }
            arrayList.add(Integer.valueOf(i2));
            arrayList.add(Integer.valueOf(i3));
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            d.a.q0.h3.h0.f fVar = new d.a.q0.h3.h0.f("new_index", null);
            this.q = fVar;
            fVar.d();
        }
    }

    public final boolean k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? l0(true) : invokeV.booleanValue;
    }

    public final boolean l0(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048625, this, z2)) == null) {
            d.a.p0.s.d0.b j2 = d.a.p0.s.d0.b.j();
            long l2 = j2.l("recommend_frs_refresh_time" + TbadkCoreApplication.getCurrentAccount(), 0L);
            return l2 == 0 ? z2 : Math.abs(System.currentTimeMillis() - l2) > this.f56022a;
        }
        return invokeZ.booleanValue;
    }

    public final boolean m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? d.a.p0.s.d0.b.j().g(e0(), true) : invokeV.booleanValue;
    }

    public final boolean n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.f56028g : invokeV.booleanValue;
    }

    public final boolean o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            HomePageYoungsterTopView homePageYoungsterTopView = this.K;
            return homePageYoungsterTopView != null && homePageYoungsterTopView.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    public void p0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            c0(this.e0);
        }
    }

    public final void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            this.f56029h = true;
            d.a.p0.b1.i0.b(new c(this), new d(this));
        }
    }

    public final void r0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048631, this) == null) || this.f56024c == null) {
            return;
        }
        DataRes.Builder builder = this.f56026e;
        this.f56024c.a((builder == null || builder.thread_list == null || k0()) ? 0 : this.f56026e.thread_list.size(), S(true), 0);
    }

    public void s0() {
        List<ThreadInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            if (n0()) {
                d.a.q0.e1.d.a.d().j(0L, 1);
            } else if (this.f56024c != null) {
                D0();
                this.f56027f++;
                O0(true);
                DataRes.Builder builder = this.f56026e;
                this.f56024c.c(this.f56027f, (builder == null || (list = builder.thread_list) == null) ? 0 : list.size(), S(false), 0);
            }
        }
    }

    public void t0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
            d.a.p0.o0.l.b().q(System.currentTimeMillis() - d.a.p0.o0.l.b().c());
        }
    }

    public final void u0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            d.a.p0.s.d0.b.j().t(e0(), false);
        }
    }

    public void v0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048635, this, z2) == null) {
            this.y = z2;
            ScrollFragmentTabHost scrollFragmentTabHost = this.s;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.M(z2);
            }
            d.a.q0.n2.i iVar = this.v;
            if (iVar == null) {
                return;
            }
            iVar.q(!z2);
            ThreadCardViewHolder d02 = d0();
            boolean z3 = false;
            if (d02 != null && d02.b() != null) {
                z3 = d02.b().o(new a.C0620a(8, Boolean.valueOf(z2)));
            }
            if (z3) {
                return;
            }
            if (z2) {
                this.v.w();
            } else if (this.z) {
                this.v.n(this.w, this.x, this.u, true);
            }
        }
    }

    public final void w0(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, dataRes) == null) {
            this.f56029h = true;
            if (dataRes != null) {
                if (E0(false, true, true, dataRes) && !k0()) {
                    l0 l0Var = this.f56024c;
                    if (l0Var != null) {
                        l0Var.d(true);
                        Looper.myQueue().addIdleHandler(new b(this));
                    }
                    if (TbSingleton.getInstance().getForceRefreshHomeRecommend()) {
                        r0();
                        TbSingleton.getInstance().setForceRefreshHomeRecommend(false);
                        return;
                    }
                    return;
                }
                r0();
                return;
            }
            r0();
        }
    }

    public void x0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048637, this, i2) == null) {
            SmartBubbleAnimatedView smartBubbleAnimatedView = this.J;
            if (smartBubbleAnimatedView != null) {
                smartBubbleAnimatedView.e(i2);
            }
            HomePageYoungsterTopView homePageYoungsterTopView = this.K;
            if (homePageYoungsterTopView != null) {
                homePageYoungsterTopView.c();
            }
            HomePageBrowseModelTipView homePageBrowseModelTipView = this.L;
            if (homePageBrowseModelTipView != null) {
                homePageBrowseModelTipView.a();
            }
        }
    }

    public void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048638, this) == null) {
            d.a.q0.n2.i iVar = this.v;
            if (iVar != null) {
                iVar.h();
            }
            c1 c1Var = this.o;
            if (c1Var != null) {
                c1Var.e();
            }
            d.a.q0.e1.h.b bVar = this.f56023b;
            if (bVar != null) {
                bVar.h();
            }
            BdTypeRecyclerView bdTypeRecyclerView = this.k;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.removeCallbacks(this.d0);
            }
            MessageManager.getInstance().unRegisterTask(2016323);
            MessageManager.getInstance().unRegisterListener(this.m0);
            MessageManager.getInstance().unRegisterListener(this.n0);
            MessageManager.getInstance().unRegisterListener(this.o0);
            MessageManager.getInstance().unRegisterListener(this.p0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:103:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x013f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void z0(boolean z2, boolean z3, DataRes dataRes, int i2, String str) {
        boolean z4;
        int size;
        Long l2;
        List<ThreadInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(1048639, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3), dataRes, Integer.valueOf(i2), str}) != null) {
            return;
        }
        DataRes dataRes2 = dataRes;
        if (z2) {
            d.a.q0.e1.h.g.a();
        }
        d.a.q0.e1.h.k.a aVar = this.p;
        if (aVar != null && aVar.i() && !z2 && (dataRes2 == null || ListUtils.isEmpty(dataRes2.thread_list))) {
            if (dataRes2 == null) {
                DataRes.Builder builder = new DataRes.Builder();
                builder.thread_list = new ArrayList();
                dataRes2 = builder.build(false);
            }
            if (dataRes2.thread_list != null) {
                List<ThreadInfo> d2 = this.p.d();
                dataRes2.thread_list.addAll(d2);
                if (d2 != null) {
                    d2.clear();
                }
                z4 = true;
                DataRes.Builder builder2 = this.f56026e;
                size = (builder2 != null || (list = builder2.thread_list) == null) ? 0 : list.size();
                if (z2 && i2 == 0 && dataRes2 != null && ListUtils.isEmpty(dataRes2.thread_list)) {
                    l0 l0Var = this.f56024c;
                    if (l0Var != null) {
                        l0Var.b();
                    }
                    O0(false);
                    BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.l;
                    if (bigdaySwipeRefreshLayout != null) {
                        bigdaySwipeRefreshLayout.setRefreshing(false);
                        return;
                    }
                    return;
                }
                if (this.P != null) {
                    DataRes.Builder builder3 = new DataRes.Builder(dataRes2);
                    builder3.thread_list.add(0, this.P);
                    dataRes2 = builder3.build(false);
                    DataRes.Builder builder4 = this.f56026e;
                    if (builder4 != null && !ListUtils.isEmpty(builder4.thread_list)) {
                        Iterator<ThreadInfo> it = this.f56026e.thread_list.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            ThreadInfo next = it.next();
                            if (next != null && (l2 = next.tid) != null && this.P.tid != null && l2.longValue() == this.P.tid.longValue()) {
                                this.f56026e.thread_list.remove(next);
                                break;
                            }
                        }
                    }
                    this.P = null;
                }
                if ((!z4 || i2 == 0) && dataRes2 != null && E0(true, z2, z3, dataRes2)) {
                    u0();
                    if (this.f56024c != null) {
                        d.a.p0.s.d0.b j2 = d.a.p0.s.d0.b.j();
                        j2.w("recommend_frs_refresh_time" + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
                        this.f56024c.d(false);
                    }
                    this.A = true;
                    this.B = z2;
                    this.C = size;
                    b1();
                } else {
                    this.A = false;
                    if (this.f56025d.size() > 0) {
                        l0 l0Var2 = this.f56024c;
                        if (l0Var2 != null) {
                            l0Var2.onError(1, str);
                        }
                    } else {
                        l0 l0Var3 = this.f56024c;
                        if (l0Var3 != null) {
                            l0Var3.onError(2, str);
                        }
                    }
                }
                O0(false);
                if (this.l == null) {
                    f.i g02 = g0();
                    if (this.l.u() && g02 != null && !TbSingleton.getInstance().isBrowseMode()) {
                        this.l.z(g02);
                        return;
                    } else {
                        this.l.setRefreshing(false);
                        return;
                    }
                }
                return;
            }
        }
        z4 = false;
        DataRes.Builder builder22 = this.f56026e;
        if (builder22 != null) {
        }
        if (z2) {
        }
        if (this.P != null) {
        }
        if (!z4) {
        }
        u0();
        if (this.f56024c != null) {
        }
        this.A = true;
        this.B = z2;
        this.C = size;
        b1();
        O0(false);
        if (this.l == null) {
        }
    }
}
