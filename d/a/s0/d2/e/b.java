package d.a.s0.d2.e;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.newinterest.data.InterestCommitHttpResMsg;
import com.baidu.tieba.newinterest.data.InterestedForumHttpResMsg;
import com.baidu.tieba.newinterest.data.InterestedForumReqMsg;
import com.baidu.tieba.newinterest.data.InterestedForumSocketResMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.Gson;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tbclient.RecommendForumInfo;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f58175a;

    /* renamed from: b  reason: collision with root package name */
    public final BdUniqueId f58176b;

    /* renamed from: c  reason: collision with root package name */
    public Gson f58177c;

    /* renamed from: d  reason: collision with root package name */
    public d f58178d;

    /* renamed from: e  reason: collision with root package name */
    public c f58179e;

    /* renamed from: f  reason: collision with root package name */
    public List<d.a.s0.d2.c.b> f58180f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.c.c.g.a f58181g;

    /* renamed from: h  reason: collision with root package name */
    public HttpMessageListener f58182h;

    /* loaded from: classes9.dex */
    public class a extends d.a.c.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f58183a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b bVar, int i2, int i3) {
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
            this.f58183a = bVar;
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            if (responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() == this.f58183a.f58176b) {
                d.a.s0.d2.c.c cVar = null;
                if (responsedMessage instanceof InterestedForumHttpResMsg) {
                    cVar = ((InterestedForumHttpResMsg) responsedMessage).getPageData();
                } else if (responsedMessage instanceof InterestedForumSocketResMsg) {
                    cVar = ((InterestedForumSocketResMsg) responsedMessage).getPageData();
                }
                if (responsedMessage.getError() != 0) {
                    if (this.f58183a.f58178d != null) {
                        this.f58183a.f58178d.onError(responsedMessage.getError(), responsedMessage.getErrorString());
                    }
                } else if (cVar == null || ListUtils.isEmpty(cVar.f58170a)) {
                    if (this.f58183a.f58178d != null) {
                        this.f58183a.f58178d.onError(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                    }
                } else if (cVar == null || this.f58183a.f58178d == null) {
                } else {
                    b.c(this.f58183a);
                    this.f58183a.f58178d.b(cVar);
                }
            }
        }
    }

    /* renamed from: d.a.s0.d2.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1366b extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f58184a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1366b(b bVar, int i2) {
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
            this.f58184a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) || httpResponsedMessage == null) {
                return;
            }
            if ((httpResponsedMessage.getOrginalMessage() == null || httpResponsedMessage.getOrginalMessage().getTag() == this.f58184a.f58176b) && (httpResponsedMessage instanceof InterestCommitHttpResMsg)) {
                InterestCommitHttpResMsg interestCommitHttpResMsg = (InterestCommitHttpResMsg) httpResponsedMessage;
                if (interestCommitHttpResMsg.hasError() || interestCommitHttpResMsg.getErrno() != 0) {
                    if (this.f58184a.f58178d != null) {
                        this.f58184a.f58178d.onError(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                    }
                } else if (this.f58184a.f58179e != null) {
                    this.f58184a.f58179e.a();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface c {
        void a();
    }

    /* loaded from: classes9.dex */
    public interface d {
        void b(d.a.s0.d2.c.c cVar);

        void onError(int i2, String str);
    }

    public b(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f58177c = new Gson();
        this.f58181g = new a(this, CmdConfigHttp.CMD_GUIDE_INTERESTED_FORUM, 309654);
        this.f58182h = new C1366b(this, CmdConfigHttp.CMD_GUIDE_INTEREST_COMMIT);
        this.f58176b = bdUniqueId;
        this.f58181g.setTag(bdUniqueId);
        this.f58182h.setTag(this.f58176b);
        MessageManager.getInstance().registerListener(this.f58181g);
        MessageManager.getInstance().registerListener(this.f58182h);
        m();
        l();
    }

    public static /* synthetic */ int c(b bVar) {
        int i2 = bVar.f58175a;
        bVar.f58175a = i2 + 1;
        return i2;
    }

    public static void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GUIDE_INTEREST_COMMIT, TbConfig.SERVER_ADDRESS + TbConfig.GUIDE_INTEREST_COMMIT_URL);
            tbHttpMessageTask.setIsNeedAddCommenParam(false);
            tbHttpMessageTask.setResponsedClass(InterestCommitHttpResMsg.class);
            tbHttpMessageTask.setPriority(4);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public void e() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GUIDE_INTEREST_COMMIT);
            try {
                str = URLEncoder.encode(g(), "utf-8");
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
                str = null;
            }
            httpMessage.addParam("interestList", str);
            httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccount());
            httpMessage.setTag(this.f58176b);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void f(List<d.a.s0.d2.c.a> list) throws UnsupportedEncodingException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GUIDE_INTEREST_COMMIT);
            String encode = URLEncoder.encode(i(list), "utf-8");
            if (d.a.r0.b.d.l() && !TbadkCoreApplication.isLogin()) {
                d.a.r0.r.d0.b.j().x("user_interest_info", encode);
            }
            httpMessage.addParam("interestList", encode);
            httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccount());
            httpMessage.setTag(this.f58176b);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public final String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            HashMap hashMap = new HashMap();
            if (!ListUtils.isEmpty(this.f58180f)) {
                for (d.a.s0.d2.c.b bVar : this.f58180f) {
                    if (bVar != null) {
                        hashMap.put(bVar.c(), new HashMap());
                    }
                }
            }
            return this.f58177c.toJson(hashMap);
        }
        return (String) invokeV.objValue;
    }

    public final List<Integer> h(List<d.a.s0.d2.c.b> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, list)) == null) {
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                for (d.a.s0.d2.c.b bVar : list) {
                    arrayList.add(Integer.valueOf(bVar.b()));
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final String i(List<d.a.s0.d2.c.a> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, list)) == null) {
            HashMap hashMap = new HashMap();
            for (d.a.s0.d2.c.a aVar : list) {
                HashMap hashMap2 = new HashMap();
                for (d.a.s0.d2.c.d dVar : aVar.f58162a) {
                    if (dVar.f58172b) {
                        RecommendForumInfo recommendForumInfo = dVar.f58171a;
                        hashMap2.put(recommendForumInfo.forum_id, recommendForumInfo.forum_name);
                    }
                }
                hashMap.put(aVar.f58164c, hashMap2);
            }
            if (!ListUtils.isEmpty(this.f58180f)) {
                for (d.a.s0.d2.c.b bVar : this.f58180f) {
                    if (bVar != null && !hashMap.containsKey(bVar.c())) {
                        hashMap.put(bVar.c(), new HashMap());
                    }
                }
            }
            return this.f58177c.toJson(hashMap);
        }
        return (String) invokeL.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            InterestedForumReqMsg interestedForumReqMsg = new InterestedForumReqMsg();
            List<d.a.s0.d2.c.b> list = this.f58180f;
            if (list == null) {
                interestedForumReqMsg.classidList = h(null);
            } else {
                interestedForumReqMsg.classidList = h(list.subList((this.f58175a - 1) * 3, Math.min(list.size(), this.f58175a * 3)));
            }
            interestedForumReqMsg.setTag(this.f58176b);
            MessageManager.getInstance().sendMessage(interestedForumReqMsg);
        }
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? (this.f58175a - 1) * 3 < this.f58180f.size() : invokeV.booleanValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GUIDE_INTERESTED_FORUM, d.a.s0.h3.d0.a.a(TbConfig.GUIDE_INTERESTED_FORUM_URL, 309654));
            tbHttpMessageTask.setIsNeedAddCommenParam(false);
            tbHttpMessageTask.setResponsedClass(InterestedForumHttpResMsg.class);
            tbHttpMessageTask.setPriority(4);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            d.a.r0.v0.b bVar = new d.a.r0.v0.b(309654);
            bVar.setResponsedClass(InterestedForumSocketResMsg.class);
            bVar.g(true);
            bVar.setPriority(4);
            MessageManager.getInstance().registerTask(bVar);
        }
    }

    public void o(List<d.a.s0.d2.c.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            this.f58180f = list;
            this.f58175a = 1;
        }
    }

    public void p(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, cVar) == null) {
            this.f58179e = cVar;
        }
    }

    public void q(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, dVar) == null) {
            this.f58178d = dVar;
        }
    }
}
