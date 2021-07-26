package d.a.q0.l0.g;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tieba.enterForum.data.RecentlyVisitedForumData;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumHttpResponseMessage;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumRequestMessage;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumSocketResponseMessage;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.d.l;
import d.a.d.e.p.k;
import d.a.p0.b1.f0;
import d.a.p0.b1.i0;
import java.util.ArrayList;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public RecentlyVisitedForumData f60184a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f60185b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f60186c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f60187d;

    /* renamed from: e  reason: collision with root package name */
    public f f60188e;

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f60189f;

    /* renamed from: g  reason: collision with root package name */
    public CustomMessageListener f60190g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.d.c.g.a f60191h;

    /* renamed from: d.a.q0.l0.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1523a extends f0<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f60192a;

        public C1523a(a aVar) {
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
            this.f60192a = aVar;
        }

        @Override // d.a.p0.b1.f0
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                l<String> h2 = d.a.p0.s.r.a.f().h("tb.recently_visited_forum", TbadkCoreApplication.getCurrentAccount() == null ? "local" : TbadkCoreApplication.getCurrentAccount());
                if (h2 != null && this.f60192a.f60184a != null) {
                    h2.g("recently_visited_forum", OrmObject.jsonStrWithObject(this.f60192a.f60184a));
                }
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b extends BdAsyncTask<Void, Void, RecentlyVisitedForumData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f60193a;

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
            this.f60193a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public RecentlyVisitedForumData doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                l<String> h2 = d.a.p0.s.r.a.f().h("tb.recently_visited_forum", "local");
                RecentlyVisitedForumData recentlyVisitedForumData = null;
                RecentlyVisitedForumData recentlyVisitedForumData2 = (h2 == null || k.isEmpty(h2.get("recently_visited_forum"))) ? null : (RecentlyVisitedForumData) OrmObject.objectWithJsonStr(h2.get("recently_visited_forum"), RecentlyVisitedForumData.class);
                if (TbadkCoreApplication.getCurrentAccount() != null) {
                    if (h2 != null) {
                        h2.g("recently_visited_forum", "");
                    }
                    l<String> h3 = d.a.p0.s.r.a.f().h("tb.recently_visited_forum", TbadkCoreApplication.getCurrentAccount());
                    if (h3 == null || StringUtils.isNull(h3.get("recently_visited_forum"))) {
                        return recentlyVisitedForumData2;
                    }
                    try {
                        recentlyVisitedForumData = (RecentlyVisitedForumData) OrmObject.objectWithJsonStr(h3.get("recently_visited_forum"), RecentlyVisitedForumData.class);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    if (recentlyVisitedForumData2 != null) {
                        recentlyVisitedForumData2.A(recentlyVisitedForumData);
                        h3.g("recently_visited_forum", OrmObject.jsonStrWithObject(recentlyVisitedForumData2));
                        return recentlyVisitedForumData2;
                    }
                    return recentlyVisitedForumData;
                }
                return recentlyVisitedForumData2;
            }
            return (RecentlyVisitedForumData) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(RecentlyVisitedForumData recentlyVisitedForumData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recentlyVisitedForumData) == null) {
                this.f60193a.f60185b = false;
                if (recentlyVisitedForumData != null) {
                    this.f60193a.x(recentlyVisitedForumData.y(), true);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f60194a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(a aVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2)};
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
            this.f60194a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            this.f60194a.q((VisitedForumData) customResponsedMessage.getData());
        }
    }

    /* loaded from: classes8.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f60195a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(a aVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2)};
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
            this.f60195a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            this.f60195a.m();
        }
    }

    /* loaded from: classes8.dex */
    public class e extends d.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f60196a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(a aVar, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2), Integer.valueOf(i3)};
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
            this.f60196a = aVar;
        }

        @Override // d.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.f60196a.f60186c = false;
                if (responsedMessage == null) {
                    return;
                }
                if (responsedMessage instanceof RecentlyVisitedForumHttpResponseMessage) {
                    this.f60196a.s((RecentlyVisitedForumHttpResponseMessage) responsedMessage);
                } else if (responsedMessage instanceof RecentlyVisitedForumSocketResponseMessage) {
                    this.f60196a.t((RecentlyVisitedForumSocketResponseMessage) responsedMessage);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface f {
        void a(LinkedList<VisitedForumData> linkedList, boolean z);

        void b(int i2);

        void onNotify();
    }

    /* loaded from: classes8.dex */
    public static class g {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static a f60197a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2022557761, "Ld/a/q0/l0/g/a$g;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2022557761, "Ld/a/q0/l0/g/a$g;");
                    return;
                }
            }
            f60197a = new a(null);
        }
    }

    public /* synthetic */ a(C1523a c1523a) {
        this();
    }

    public static a l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? g.f60197a : (a) invokeV.objValue;
    }

    public void i(VisitedForumData visitedForumData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, visitedForumData) == null) {
            p(visitedForumData);
        }
    }

    public RecentlyVisitedForumData j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f60184a : (RecentlyVisitedForumData) invokeV.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            RecentlyVisitedForumData recentlyVisitedForumData = this.f60184a;
            if (recentlyVisitedForumData == null || recentlyVisitedForumData.y() == null || this.f60184a.y().size() < 1) {
                return "";
            }
            ArrayList<VisitedForumData> arrayList = new ArrayList(this.f60184a.y());
            JSONArray jSONArray = new JSONArray();
            for (VisitedForumData visitedForumData : arrayList) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("forum_id", d.a.d.e.m.b.f(visitedForumData.getForumId(), 0L));
                    jSONObject.put("visit_time", visitedForumData.E());
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                jSONArray.put(jSONObject);
            }
            return jSONArray.toString();
        }
        return (String) invokeV.objValue;
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f60185b = true;
            b bVar = new b(this);
            bVar.setPriority(3);
            bVar.execute(new Void[0]);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f60186c) {
            return;
        }
        RecentlyVisitedForumRequestMessage recentlyVisitedForumRequestMessage = new RecentlyVisitedForumRequestMessage();
        recentlyVisitedForumRequestMessage.setForumData(this.f60184a.y());
        this.f60186c = MessageManager.getInstance().sendMessage(recentlyVisitedForumRequestMessage);
    }

    public void o() {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (fVar = this.f60188e) == null) {
            return;
        }
        fVar.a(this.f60184a.y(), this.f60187d);
    }

    public final void p(VisitedForumData visitedForumData) {
        int x;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, visitedForumData) == null) || visitedForumData == null || (x = this.f60184a.x(visitedForumData)) < 0) {
            return;
        }
        f fVar = this.f60188e;
        if (fVar != null) {
            fVar.b(x);
        }
        v(visitedForumData);
        y();
    }

    public final void q(VisitedForumData visitedForumData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, visitedForumData) == null) || visitedForumData == null) {
            return;
        }
        this.f60184a.w(visitedForumData);
        this.f60184a.C(20);
        o();
        y();
        l().n();
    }

    public void r() {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (fVar = this.f60188e) == null) {
            return;
        }
        fVar.onNotify();
    }

    public final void s(RecentlyVisitedForumHttpResponseMessage recentlyVisitedForumHttpResponseMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, recentlyVisitedForumHttpResponseMessage) == null) || recentlyVisitedForumHttpResponseMessage == null || recentlyVisitedForumHttpResponseMessage.getForumData() == null) {
            return;
        }
        x(recentlyVisitedForumHttpResponseMessage.getForumData(), false);
    }

    public final void t(RecentlyVisitedForumSocketResponseMessage recentlyVisitedForumSocketResponseMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, recentlyVisitedForumSocketResponseMessage) == null) || recentlyVisitedForumSocketResponseMessage == null || recentlyVisitedForumSocketResponseMessage.getForumData() == null) {
            return;
        }
        x(recentlyVisitedForumSocketResponseMessage.getForumData(), false);
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            MessageManager.getInstance().registerListener(this.f60191h);
            MessageManager.getInstance().registerListener(this.f60189f);
            MessageManager.getInstance().registerListener(this.f60190g);
        }
    }

    public final void v(VisitedForumData visitedForumData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, visitedForumData) == null) && TbadkCoreApplication.isLogin()) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_DELETE_HISTORY_FORUM);
            httpMessage.addParam("forum_id", d.a.d.e.m.b.f(visitedForumData.getForumId(), 0L));
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void w(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, fVar) == null) {
            this.f60188e = fVar;
        }
    }

    public final void x(LinkedList<VisitedForumData> linkedList, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048590, this, linkedList, z) == null) || linkedList == null) {
            return;
        }
        this.f60184a.B(linkedList);
        this.f60184a.C(20);
        this.f60187d = z;
        o();
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || this.f60185b) {
            return;
        }
        i0.b(new C1523a(this), null);
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
                return;
            }
        }
        this.f60185b = false;
        this.f60186c = false;
        this.f60189f = new c(this, 2016564);
        this.f60190g = new d(this, 2005016);
        this.f60191h = new e(this, CmdConfigHttp.CMD_GET_HISTORY_FORUM, 309601);
        this.f60184a = new RecentlyVisitedForumData();
        u();
        m();
    }
}
