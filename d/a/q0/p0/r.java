package d.a.q0.p0;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tieba.face.data.SingleBarEmotionRecommendData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.x.p.a;
import d.a.q0.p0.q;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes8.dex */
public class r extends d.a.p0.x.p.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static r f61873f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public LinkedList<d.a.p0.x.p.c> f61874e;

    /* loaded from: classes8.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ r f61875a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(r rVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rVar, Integer.valueOf(i2)};
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
            this.f61875a = rVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2001444) {
                Object data = customResponsedMessage.getData();
                if (data == null || !(data instanceof SingleBarEmotionRecommendData)) {
                    this.f61875a.g(null);
                    return;
                }
                SingleBarEmotionRecommendData singleBarEmotionRecommendData = (SingleBarEmotionRecommendData) data;
                LinkedList linkedList = new LinkedList();
                if (singleBarEmotionRecommendData == null || TextUtils.isEmpty(singleBarEmotionRecommendData.pkg_id) || TextUtils.isEmpty(singleBarEmotionRecommendData.cover)) {
                    this.f61875a.g(null);
                    return;
                }
                linkedList.add(singleBarEmotionRecommendData);
                this.f61875a.g(linkedList);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements q.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(r rVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // d.a.q0.p0.q.b
        public void a(q qVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, qVar) == null) {
                MessageManager.getInstance().runTask(2004603, (Class) null);
            }
        }
    }

    public r() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static r f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f61873f == null) {
                synchronized (r.class) {
                    if (f61873f == null) {
                        f61873f = new r();
                    }
                }
            }
            return f61873f;
        }
        return (r) invokeV.objValue;
    }

    @Override // d.a.p0.x.p.a
    public void b(a.InterfaceC1248a interfaceC1248a) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, interfaceC1248a) == null) && FileHelper.checkSD() && this.f61874e != null) {
            for (int i2 = 0; i2 < this.f61874e.size(); i2++) {
                q qVar = (q) this.f61874e.get(i2);
                if (qVar.t() && d.a.q0.c2.c.i().g(qVar.f()) == null && interfaceC1248a != null) {
                    interfaceC1248a.a(qVar);
                }
            }
        }
    }

    @Override // d.a.p0.x.p.a
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    @Override // d.a.p0.x.p.a
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            MessageManager.getInstance().registerListener(new a(this, 2001444));
        }
    }

    public final synchronized void g(List<d.a.q0.o0.c.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            synchronized (this) {
                if (list != null) {
                    if (!list.isEmpty()) {
                        if (this.f61874e != null) {
                            this.f61874e = null;
                        }
                        LinkedList<d.a.p0.x.p.c> linkedList = new LinkedList<>();
                        boolean z = false;
                        for (d.a.q0.o0.c.b bVar : list) {
                            if (bVar != null && !StringUtils.isNull(bVar.getGroupId()) && bVar.IsValid()) {
                                q qVar = new q(bVar);
                                linkedList.add(qVar);
                                z = qVar.u(bVar, new b(this));
                            }
                        }
                        this.f61874e = linkedList;
                        if (z) {
                            MessageManager.getInstance().runTask(2004603, (Class) null);
                        }
                    }
                }
                if (this.f61874e != null) {
                    this.f61874e = null;
                    MessageManager.getInstance().runTask(2004603, (Class) null);
                }
            }
        }
    }
}
