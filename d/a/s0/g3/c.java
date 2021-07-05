package d.a.s0.g3;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import java.util.HashSet;
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static c f59826g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final d.a.s0.g3.b f59827a;

    /* renamed from: b  reason: collision with root package name */
    public int f59828b;

    /* renamed from: c  reason: collision with root package name */
    public SparseArray<HashSet<String>> f59829c;

    /* renamed from: d  reason: collision with root package name */
    public C1436c f59830d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f59831e;

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f59832f;

    /* loaded from: classes9.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(c cVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            C1436c c1436c;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                super.handleMessage(message);
                if (message.what != 5) {
                    return;
                }
                Object obj = message.obj;
                if (!(obj instanceof C1436c) || (c1436c = (C1436c) obj) == null) {
                    return;
                }
                c1436c.f59837d = false;
                c1436c.f59834a = false;
                c1436c.f59835b = 0;
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f59833a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(c cVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2)};
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
            this.f59833a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            if (this.f59833a.f59829c != null) {
                this.f59833a.f59829c.clear();
            }
            this.f59833a.f59827a.g();
        }
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
        this.f59831e = new a(this, Looper.getMainLooper());
        this.f59832f = new b(this, 2005016);
        this.f59828b = d.a.r0.r.d0.b.j().k("card_show_statistic_max_count", 200);
        this.f59827a = new d.a.s0.g3.b();
        MessageManager.getInstance().registerListener(this.f59832f);
    }

    public static c g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f59826g == null) {
                synchronized (c.class) {
                    if (f59826g == null) {
                        f59826g = new c();
                    }
                }
            }
            return f59826g;
        }
        return (c) invokeV.objValue;
    }

    public void c(BdUniqueId bdUniqueId, StatisticItem statisticItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, bdUniqueId, statisticItem) == null) {
            this.f59827a.d(bdUniqueId, true);
            TiebaStatic.log(statisticItem);
        }
    }

    public void d(BdUniqueId bdUniqueId, String str, StatisticItem statisticItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdUniqueId, str, statisticItem) == null) || bdUniqueId == null || statisticItem == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (!this.f59827a.c(bdUniqueId)) {
            BdLog.e("error, bdUniqueId not register");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            BdLog.e("id is null, statistic key is=" + statisticItem.getKey());
        }
        if (this.f59829c == null) {
            this.f59829c = new SparseArray<>();
        }
        HashSet<String> hashSet = this.f59829c.get(bdUniqueId.getId());
        if (hashSet == null) {
            hashSet = new HashSet<>();
            this.f59829c.put(bdUniqueId.getId(), hashSet);
        }
        String str2 = statisticItem.getKey() + "_" + str;
        if (hashSet.contains(str2) || e()) {
            return;
        }
        hashSet.add(str2);
        this.f59827a.a(bdUniqueId, statisticItem);
        if (BdLog.isDebugMode()) {
            BdLog.d("add show statistic log success" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f59830d == null) {
                this.f59830d = new C1436c(this, null);
            }
            if (this.f59830d.f59837d) {
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis();
            C1436c c1436c = this.f59830d;
            if (c1436c.f59834a) {
                int i2 = c1436c.f59835b + 1;
                c1436c.f59835b = i2;
                if (currentTimeMillis - c1436c.f59836c < AppConfig.TIMESTAMP_AVAILABLE_DURATION) {
                    if (i2 >= this.f59828b) {
                        c1436c.f59837d = true;
                        f(c1436c);
                        return true;
                    }
                } else {
                    c1436c.f59834a = false;
                    c1436c.f59835b = 0;
                }
            } else {
                c1436c.f59834a = true;
                c1436c.f59836c = currentTimeMillis;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void f(C1436c c1436c) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, c1436c) == null) {
            Message obtainMessage = this.f59831e.obtainMessage();
            obtainMessage.what = 5;
            obtainMessage.obj = c1436c;
            this.f59831e.removeMessages(5);
            this.f59831e.sendMessageDelayed(obtainMessage, 300000L);
        }
    }

    public void h(BdUniqueId bdUniqueId, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048580, this, bdUniqueId, z) == null) {
            if (BdLog.isDebugMode()) {
                BdLog.d("logStatisticByKey start write log ");
            }
            this.f59827a.d(bdUniqueId, z);
        }
    }

    public void i(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) {
            l.d();
            if (bdUniqueId == null) {
                return;
            }
            this.f59827a.f(bdUniqueId);
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        SparseArray<HashSet<String>> sparseArray;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, bdUniqueId) == null) || (sparseArray = this.f59829c) == null) {
            return;
        }
        sparseArray.remove(bdUniqueId.getId());
    }

    public void k(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            l.d();
            if (bdUniqueId == null) {
                return;
            }
            this.f59827a.h(bdUniqueId);
            j(bdUniqueId);
        }
    }

    /* renamed from: d.a.s0.g3.c$c  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1436c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f59834a;

        /* renamed from: b  reason: collision with root package name */
        public int f59835b;

        /* renamed from: c  reason: collision with root package name */
        public long f59836c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f59837d;

        public C1436c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59834a = false;
            this.f59835b = 0;
            this.f59836c = 0L;
            this.f59837d = false;
        }

        public /* synthetic */ C1436c(c cVar, a aVar) {
            this(cVar);
        }
    }
}
