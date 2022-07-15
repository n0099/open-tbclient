package com.repackage;

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
import com.baidu.sofire.core.ForHostApp;
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
import java.util.ArrayList;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class k56 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RecentlyVisitedForumData a;
    public boolean b;
    public boolean c;
    public boolean d;
    public f e;
    public CustomMessageListener f;
    public CustomMessageListener g;
    public za h;

    /* loaded from: classes6.dex */
    public class a extends de5<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k56 a;

        public a(k56 k56Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k56Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k56Var;
        }

        @Override // com.repackage.de5
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                br4.f();
                te<String> h = br4.h("tb.recently_visited_forum", TbadkCoreApplication.getCurrentAccount() == null ? ForHostApp.KEY_NAME_LOCAL : TbadkCoreApplication.getCurrentAccount());
                if (h != null && this.a.a != null) {
                    h.g("recently_visited_forum", OrmObject.jsonStrWithObject(this.a.a));
                }
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b extends BdAsyncTask<Void, Void, RecentlyVisitedForumData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k56 a;

        public b(k56 k56Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k56Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k56Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public RecentlyVisitedForumData doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                br4.f();
                te<String> h = br4.h("tb.recently_visited_forum", ForHostApp.KEY_NAME_LOCAL);
                RecentlyVisitedForumData recentlyVisitedForumData = null;
                RecentlyVisitedForumData recentlyVisitedForumData2 = (h == null || oi.isEmpty(h.get("recently_visited_forum"))) ? null : (RecentlyVisitedForumData) OrmObject.objectWithJsonStr(h.get("recently_visited_forum"), RecentlyVisitedForumData.class);
                if (TbadkCoreApplication.getCurrentAccount() != null) {
                    if (h != null) {
                        h.g("recently_visited_forum", "");
                    }
                    br4.f();
                    te<String> h2 = br4.h("tb.recently_visited_forum", TbadkCoreApplication.getCurrentAccount());
                    if (h2 == null || StringUtils.isNull(h2.get("recently_visited_forum"))) {
                        return recentlyVisitedForumData2;
                    }
                    try {
                        recentlyVisitedForumData = (RecentlyVisitedForumData) OrmObject.objectWithJsonStr(h2.get("recently_visited_forum"), RecentlyVisitedForumData.class);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (recentlyVisitedForumData2 != null) {
                        recentlyVisitedForumData2.mergeForumData(recentlyVisitedForumData);
                        h2.g("recently_visited_forum", OrmObject.jsonStrWithObject(recentlyVisitedForumData2));
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
                this.a.b = false;
                if (recentlyVisitedForumData != null) {
                    this.a.x(recentlyVisitedForumData.getForumData(), true);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k56 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(k56 k56Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k56Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k56Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            this.a.q((VisitedForumData) customResponsedMessage.getData());
        }
    }

    /* loaded from: classes6.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k56 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(k56 k56Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k56Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k56Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            this.a.m();
        }
    }

    /* loaded from: classes6.dex */
    public class e extends za {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k56 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(k56 k56Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k56Var, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = k56Var;
        }

        @Override // com.repackage.za
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.a.c = false;
                if (responsedMessage == null) {
                    return;
                }
                if (responsedMessage instanceof RecentlyVisitedForumHttpResponseMessage) {
                    this.a.s((RecentlyVisitedForumHttpResponseMessage) responsedMessage);
                } else if (responsedMessage instanceof RecentlyVisitedForumSocketResponseMessage) {
                    this.a.t((RecentlyVisitedForumSocketResponseMessage) responsedMessage);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface f {
        void a(LinkedList<VisitedForumData> linkedList, boolean z);

        void b(int i);

        void onNotify();
    }

    /* loaded from: classes6.dex */
    public static class g {
        public static /* synthetic */ Interceptable $ic;
        public static k56 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-289675262, "Lcom/repackage/k56$g;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-289675262, "Lcom/repackage/k56$g;");
                    return;
                }
            }
            a = new k56(null);
        }
    }

    public /* synthetic */ k56(a aVar) {
        this();
    }

    public static k56 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? g.a : (k56) invokeV.objValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (RecentlyVisitedForumData) invokeV.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            RecentlyVisitedForumData recentlyVisitedForumData = this.a;
            if (recentlyVisitedForumData == null || recentlyVisitedForumData.getForumData() == null || this.a.getForumData().size() < 1) {
                return "";
            }
            ArrayList<VisitedForumData> arrayList = new ArrayList(this.a.getForumData());
            JSONArray jSONArray = new JSONArray();
            for (VisitedForumData visitedForumData : arrayList) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("forum_id", ng.g(visitedForumData.getForumId(), 0L));
                    jSONObject.put("visit_time", visitedForumData.getVisitedTime());
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
            this.b = true;
            b bVar = new b(this);
            bVar.setPriority(3);
            bVar.execute(new Void[0]);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.c) {
            return;
        }
        RecentlyVisitedForumRequestMessage recentlyVisitedForumRequestMessage = new RecentlyVisitedForumRequestMessage();
        recentlyVisitedForumRequestMessage.setForumData(this.a.getForumData());
        this.c = MessageManager.getInstance().sendMessage(recentlyVisitedForumRequestMessage);
    }

    public void o() {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (fVar = this.e) == null) {
            return;
        }
        fVar.a(this.a.getForumData(), this.d);
    }

    public final void p(VisitedForumData visitedForumData) {
        int deleteForumItem;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, visitedForumData) == null) || visitedForumData == null || (deleteForumItem = this.a.deleteForumItem(visitedForumData)) < 0) {
            return;
        }
        f fVar = this.e;
        if (fVar != null) {
            fVar.b(deleteForumItem);
        }
        v(visitedForumData);
        y();
    }

    public final void q(VisitedForumData visitedForumData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, visitedForumData) == null) || visitedForumData == null) {
            return;
        }
        this.a.addForumItem(visitedForumData);
        this.a.trimSize(20);
        o();
        y();
        l().n();
    }

    public void r() {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (fVar = this.e) == null) {
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
            MessageManager.getInstance().registerListener(this.h);
            MessageManager.getInstance().registerListener(this.f);
            MessageManager.getInstance().registerListener(this.g);
        }
    }

    public final void v(VisitedForumData visitedForumData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, visitedForumData) == null) && TbadkCoreApplication.isLogin()) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_DELETE_HISTORY_FORUM);
            httpMessage.addParam("forum_id", ng.g(visitedForumData.getForumId(), 0L));
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void w(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, fVar) == null) {
            this.e = fVar;
        }
    }

    public final void x(LinkedList<VisitedForumData> linkedList, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048590, this, linkedList, z) == null) || linkedList == null) {
            return;
        }
        this.a.setForumData(linkedList);
        this.a.trimSize(20);
        this.d = z;
        o();
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || this.b) {
            return;
        }
        he5.b(new a(this), null);
    }

    public k56() {
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
        this.b = false;
        this.c = false;
        this.f = new c(this, 2016564);
        this.g = new d(this, 2005016);
        this.h = new e(this, CmdConfigHttp.CMD_GET_HISTORY_FORUM, 309601);
        this.a = new RecentlyVisitedForumData();
        u();
        m();
    }
}
