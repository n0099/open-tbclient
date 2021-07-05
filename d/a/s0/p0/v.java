package d.a.s0.p0;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.faceshop.CollectEmotionData;
import com.baidu.tieba.faceshop.EmotionGroupData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.w.p.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class v extends d.a.r0.w.p.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static v f64540g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public LinkedList<d.a.r0.w.p.c> f64541e;

    /* renamed from: f  reason: collision with root package name */
    public final CustomMessageListener f64542f;

    /* loaded from: classes9.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ v f64543a;

        /* renamed from: d.a.s0.p0.v$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class RunnableC1630a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f64544e;

            public RunnableC1630a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f64544e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f64544e.f64543a.g();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(v vVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vVar, Integer.valueOf(i2)};
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
            this.f64543a = vVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f64543a.d();
                new Thread(new RunnableC1630a(this)).start();
            }
        }
    }

    public v() {
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
        this.f64542f = new a(this, 2005016);
        MessageManager.getInstance().registerListener(this.f64542f);
    }

    public static v e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f64540g == null) {
                synchronized (v.class) {
                    if (f64540g == null) {
                        f64540g = new v();
                    }
                }
            }
            return f64540g;
        }
        return (v) invokeV.objValue;
    }

    @Override // d.a.r0.w.p.a
    public void b(a.InterfaceC1286a interfaceC1286a) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, interfaceC1286a) == null) && FileHelper.checkSD()) {
            LinkedList<d.a.r0.w.p.c> linkedList = this.f64541e;
            if (linkedList != null && !linkedList.isEmpty()) {
                Iterator<d.a.r0.w.p.c> it = this.f64541e.iterator();
                while (it.hasNext()) {
                    d.a.r0.w.p.c next = it.next();
                    if (interfaceC1286a != null) {
                        interfaceC1286a.a(next);
                    }
                }
                return;
            }
            this.f64541e = new LinkedList<>();
            t tVar = new t();
            this.f64541e.add(tVar);
            if (interfaceC1286a != null) {
                interfaceC1286a.a(tVar);
            }
        }
    }

    @Override // d.a.r0.w.p.a
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 3;
        }
        return invokeV.intValue;
    }

    @Override // d.a.r0.w.p.a
    public void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            return;
        }
        List<CollectEmotionData> n = g.k().n(TbadkCoreApplication.getCurrentAccount());
        if (n != null && n.size() != 0) {
            int size = (n == null || n.size() == 0) ? 0 : n.size() - 1;
            StatisticItem statisticItem = new StatisticItem("c12224");
            statisticItem.param("obj_param1", size);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
            return;
        }
        CollectEmotionData collectEmotionData = new CollectEmotionData();
        collectEmotionData.pid = "setting_icon";
        collectEmotionData.orderId = 301;
        collectEmotionData.sharpText = d.a.r0.a0.d.f54733d;
        collectEmotionData.uid = TbadkCoreApplication.getCurrentAccount();
        g.k().a(collectEmotionData);
        EmotionGroupData emotionGroupData = new EmotionGroupData();
        emotionGroupData.groupId = d.a.r0.a0.d.a();
        emotionGroupData.groupName = "用户收藏表情";
        emotionGroupData.groupDesc = "用户收藏表情";
        emotionGroupData.emotionsCount = 301;
        emotionGroupData.status = 1;
        emotionGroupData.downloadUrl = "";
        g.k().f(TbadkCoreApplication.getCurrentAccount(), emotionGroupData);
        g.k().e(emotionGroupData);
    }

    public boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            LinkedList<d.a.r0.w.p.c> linkedList = this.f64541e;
            if (linkedList == null) {
                return false;
            }
            Iterator<d.a.r0.w.p.c> it = linkedList.iterator();
            while (it.hasNext()) {
                d.a.r0.w.p.c next = it.next();
                if (next instanceof t) {
                    return ((t) next).u(str);
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public synchronized void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
                if (this.f64541e == null) {
                    return;
                }
                Iterator<d.a.r0.w.p.c> it = this.f64541e.iterator();
                while (it.hasNext()) {
                    d.a.r0.w.p.c next = it.next();
                    if (next instanceof t) {
                        ((t) next).w();
                    }
                }
            }
        }
    }
}
