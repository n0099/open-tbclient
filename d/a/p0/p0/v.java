package d.a.p0.p0;

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
import d.a.o0.w.p.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes8.dex */
public class v extends d.a.o0.w.p.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static v f61306g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public LinkedList<d.a.o0.w.p.c> f61307e;

    /* renamed from: f  reason: collision with root package name */
    public final CustomMessageListener f61308f;

    /* loaded from: classes8.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ v f61309a;

        /* renamed from: d.a.p0.p0.v$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC1586a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f61310e;

            public RunnableC1586a(a aVar) {
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
                this.f61310e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f61310e.f61309a.g();
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
            this.f61309a = vVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f61309a.d();
                new Thread(new RunnableC1586a(this)).start();
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
        this.f61308f = new a(this, 2005016);
        MessageManager.getInstance().registerListener(this.f61308f);
    }

    public static v e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f61306g == null) {
                synchronized (v.class) {
                    if (f61306g == null) {
                        f61306g = new v();
                    }
                }
            }
            return f61306g;
        }
        return (v) invokeV.objValue;
    }

    @Override // d.a.o0.w.p.a
    public void b(a.InterfaceC1238a interfaceC1238a) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, interfaceC1238a) == null) && FileHelper.checkSD()) {
            LinkedList<d.a.o0.w.p.c> linkedList = this.f61307e;
            if (linkedList != null && !linkedList.isEmpty()) {
                Iterator<d.a.o0.w.p.c> it = this.f61307e.iterator();
                while (it.hasNext()) {
                    d.a.o0.w.p.c next = it.next();
                    if (interfaceC1238a != null) {
                        interfaceC1238a.a(next);
                    }
                }
                return;
            }
            this.f61307e = new LinkedList<>();
            t tVar = new t();
            this.f61307e.add(tVar);
            if (interfaceC1238a != null) {
                interfaceC1238a.a(tVar);
            }
        }
    }

    @Override // d.a.o0.w.p.a
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 3;
        }
        return invokeV.intValue;
    }

    @Override // d.a.o0.w.p.a
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
        collectEmotionData.sharpText = d.a.o0.a0.d.f51435d;
        collectEmotionData.uid = TbadkCoreApplication.getCurrentAccount();
        g.k().a(collectEmotionData);
        EmotionGroupData emotionGroupData = new EmotionGroupData();
        emotionGroupData.groupId = d.a.o0.a0.d.a();
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
            LinkedList<d.a.o0.w.p.c> linkedList = this.f61307e;
            if (linkedList == null) {
                return false;
            }
            Iterator<d.a.o0.w.p.c> it = linkedList.iterator();
            while (it.hasNext()) {
                d.a.o0.w.p.c next = it.next();
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
                if (this.f61307e == null) {
                    return;
                }
                Iterator<d.a.o0.w.p.c> it = this.f61307e.iterator();
                while (it.hasNext()) {
                    d.a.o0.w.p.c next = it.next();
                    if (next instanceof t) {
                        ((t) next).w();
                    }
                }
            }
        }
    }
}
