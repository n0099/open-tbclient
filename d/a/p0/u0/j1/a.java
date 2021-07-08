package d.a.p0.u0.j1;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ForumBroadcastHelper;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.broadcast.ForumManagerRightsResMsg;
import com.baidu.tieba.view.ScreenTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.r.s.a;
import d.a.p0.h3.h0.m;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f62944a;

    /* renamed from: b  reason: collision with root package name */
    public int f62945b;

    /* renamed from: c  reason: collision with root package name */
    public String f62946c;

    /* renamed from: d  reason: collision with root package name */
    public String f62947d;

    /* renamed from: e  reason: collision with root package name */
    public String f62948e;

    /* renamed from: f  reason: collision with root package name */
    public HttpMessageListener f62949f;

    /* renamed from: d.a.p0.u0.j1.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1678a implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.r.s.a f62950e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f62951f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f62952g;

        /* renamed from: d.a.p0.u0.j1.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class View$OnClickListenerC1679a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C1678a f62953e;

            public View$OnClickListenerC1679a(C1678a c1678a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1678a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f62953e = c1678a;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("_forumId", this.f62953e.f62952g.f62946c);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(this.f62953e.f62952g.f62944a.getPageActivity(), "ForumGradePage", hashMap)));
                }
            }
        }

        public C1678a(a aVar, d.a.o0.r.s.a aVar2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, aVar2, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62952g = aVar;
            this.f62950e = aVar2;
            this.f62951f = i2;
        }

        @Override // d.a.o0.r.s.a.e
        public void onClick(d.a.o0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                d.a.o0.r.d0.b.j().t("key_forum_broadcast_no_tip_again", this.f62950e.isNoTipAgainChecked());
                this.f62950e.dismiss();
                if (this.f62951f == 0) {
                    ScreenTopToast screenTopToast = new ScreenTopToast(this.f62952g.f62944a.getPageActivity());
                    screenTopToast.m(this.f62952g.f62944a.getPageActivity().getString(R.string.frs_forum_bawu_send_broadcast_none_tip));
                    screenTopToast.k(this.f62952g.f62944a.getString(R.string.frs_recommend_fail_tip_btn));
                    screenTopToast.j(new View$OnClickListenerC1679a(this));
                    screenTopToast.n((ViewGroup) this.f62952g.f62944a.getPageActivity().findViewById(R.id.frs));
                    return;
                }
                ForumBroadcastHelper forumBroadcastHelper = new ForumBroadcastHelper(this.f62952g.f62944a.getPageActivity());
                if (this.f62952g.f62945b == 1) {
                    forumBroadcastHelper.jumpFlutterEditGenear(this.f62952g.f62946c, this.f62952g.f62947d, "3");
                } else if (this.f62952g.f62945b == 2) {
                    forumBroadcastHelper.jumpFlutterEditGenear(this.f62952g.f62946c, this.f62952g.f62947d, "4");
                } else {
                    forumBroadcastHelper.jumpFlutterEditGenear(this.f62952g.f62946c, this.f62952g.f62947d, "0");
                }
                forumBroadcastHelper.clipCopy(this.f62952g.f62948e);
                forumBroadcastHelper.start();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.r.s.a f62954e;

        public b(a aVar, d.a.o0.r.s.a aVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, aVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62954e = aVar2;
        }

        @Override // d.a.o0.r.s.a.e
        public void onClick(d.a.o0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                d.a.o0.r.d0.b.j().t("key_call_fans_no_tip_again", false);
                this.f62954e.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f62955a;

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
            this.f62955a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && (httpResponsedMessage instanceof ForumManagerRightsResMsg)) {
                ForumManagerRightsResMsg forumManagerRightsResMsg = (ForumManagerRightsResMsg) httpResponsedMessage;
                boolean g2 = d.a.o0.r.d0.b.j().g("key_forum_broadcast_no_tip_again", false);
                int i2 = forumManagerRightsResMsg.broadcastTotalCount - forumManagerRightsResMsg.broadcastUsedCount;
                if (!g2) {
                    this.f62955a.j(i2);
                } else if (this.f62955a.f62945b == 1) {
                    this.f62955a.f62944a.showToast(R.string.top_success);
                } else if (this.f62955a.f62945b == 2) {
                    this.f62955a.f62944a.showToast(R.string.set_good_success);
                }
            }
        }
    }

    public a(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f62949f = new c(this, CmdConfigHttp.CMD_GET_FORUM_MANAGER_RIGHTS);
        this.f62944a = tbPageContext;
        i();
        tbPageContext.registerListener(this.f62949f);
    }

    public void g(int i2, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, str2, str3}) == null) {
            this.f62945b = i2;
            this.f62946c = str;
            this.f62947d = str2;
            this.f62948e = str3;
            h(str);
        }
    }

    public final void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_FORUM_MANAGER_RIGHTS);
            httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccount());
            httpMessage.addParam("forum_id", str);
            this.f62944a.sendMessage(httpMessage);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            MessageManager messageManager = MessageManager.getInstance();
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_FORUM_MANAGER_RIGHTS, TbConfig.SERVER_ADDRESS + "c/f/forum/getForumMangerRights");
            tbHttpMessageTask.setResponsedClass(ForumManagerRightsResMsg.class);
            tbHttpMessageTask.setIsNeedTbs(true);
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            messageManager.registerTask(tbHttpMessageTask);
        }
    }

    public final void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            d.a.o0.r.s.a aVar = new d.a.o0.r.s.a(this.f62944a.getPageActivity());
            aVar.setUseNoTipAgainStyle(true);
            aVar.setNegativeTextColor(R.color.CAM_X0105);
            int i3 = this.f62945b;
            if (i3 == 1) {
                aVar.setTitle(R.string.top_success);
            } else if (i3 == 2) {
                aVar.setTitle(R.string.set_good_success);
            }
            aVar.setMessage(String.format(this.f62944a.getString(R.string.forum_broadcast_intro), Integer.valueOf(i2)));
            aVar.setContentViewSize(1);
            aVar.setPositiveButton(this.f62944a.getString(R.string.send_forum_broadcast), new C1678a(this, aVar, i2));
            aVar.setNegativeButton(this.f62944a.getString(R.string.next_time), new b(this, aVar));
            aVar.create(this.f62944a).show();
        }
    }
}
