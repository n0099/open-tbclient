package d.a.s0.u0.o;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.frs.FrsHotTopic.FrsHotTopicListData;
import com.baidu.tieba.frs.FrsHotTopic.FrsLinkHashMap;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.d.l;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static a f66581b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FrsLinkHashMap<String, Long> f66582a;

    /* renamed from: d.a.s0.u0.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1744a extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f66583a;

        public C1744a(a aVar) {
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
            this.f66583a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            FrsHotTopicListData frsHotTopicListData;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                l<String> h2 = d.a.r0.r.r.a.f().h("tb.frs_hottopic", "");
                if (h2 != null) {
                    String str = h2.get("hot_topic_key");
                    if (!StringUtils.isNull(str) && (frsHotTopicListData = (FrsHotTopicListData) OrmObject.objectWithJsonStr(str, FrsHotTopicListData.class)) != null) {
                        this.f66583a.f66582a = frsHotTopicListData.mSceneMap;
                    }
                }
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class b extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f66584a;

        public b(a aVar) {
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
            this.f66584a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                l<String> h2 = d.a.r0.r.r.a.f().h("tb.frs_hottopic", "");
                if (h2 == null) {
                    return null;
                }
                FrsHotTopicListData frsHotTopicListData = new FrsHotTopicListData();
                frsHotTopicListData.mSceneMap = this.f66584a.f66582a;
                String jsonStrWithObject = OrmObject.jsonStrWithObject(frsHotTopicListData);
                if (!StringUtils.isNull(jsonStrWithObject)) {
                    h2.g("hot_topic_key", jsonStrWithObject);
                }
                return null;
            }
            return (Void) invokeL.objValue;
        }
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
            }
        }
    }

    public static a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f66581b == null) {
                synchronized (a.class) {
                    if (f66581b == null) {
                        f66581b = new a();
                    }
                }
            }
            return f66581b;
        }
        return (a) invokeV.objValue;
    }

    public boolean c(String str, long j) {
        InterceptResult invokeLJ;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048576, this, str, j)) == null) {
            if (this.f66582a == null) {
                this.f66582a = new FrsLinkHashMap<>();
                e(str, j);
            }
            if (StringUtils.isNull(str) || this.f66582a.isEmpty()) {
                return false;
            }
            Iterator<Map.Entry<String, Long>> it = this.f66582a.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                Map.Entry<String, Long> next = it.next();
                if (next != null && str.equals(next.getKey())) {
                    z = true;
                    break;
                }
            }
            if (z && this.f66582a.get(str).longValue() == j) {
                return false;
            }
            this.f66582a.put(str, Long.valueOf(j));
            f();
            return true;
        }
        return invokeLJ.booleanValue;
    }

    public final void e(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) == null) {
            C1744a c1744a = new C1744a(this);
            c1744a.setPriority(3);
            c1744a.execute(new Void[0]);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            b bVar = new b(this);
            bVar.setPriority(3);
            bVar.execute(new Void[0]);
        }
    }
}
