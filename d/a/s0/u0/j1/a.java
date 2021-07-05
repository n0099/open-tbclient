package d.a.s0.u0.j1;

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
import d.a.r0.r.s.a;
import d.a.s0.h3.h0.m;
import java.util.HashMap;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f66163a;

    /* renamed from: b  reason: collision with root package name */
    public int f66164b;

    /* renamed from: c  reason: collision with root package name */
    public String f66165c;

    /* renamed from: d  reason: collision with root package name */
    public String f66166d;

    /* renamed from: e  reason: collision with root package name */
    public String f66167e;

    /* renamed from: f  reason: collision with root package name */
    public HttpMessageListener f66168f;

    /* renamed from: d.a.s0.u0.j1.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1719a implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.r0.r.s.a f66169e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f66170f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f66171g;

        /* renamed from: d.a.s0.u0.j1.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class View$OnClickListenerC1720a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C1719a f66172e;

            public View$OnClickListenerC1720a(C1719a c1719a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1719a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f66172e = c1719a;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("_forumId", this.f66172e.f66171g.f66165c);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(this.f66172e.f66171g.f66163a.getPageActivity(), "ForumGradePage", hashMap)));
                }
            }
        }

        public C1719a(a aVar, d.a.r0.r.s.a aVar2, int i2) {
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
            this.f66171g = aVar;
            this.f66169e = aVar2;
            this.f66170f = i2;
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                d.a.r0.r.d0.b.j().t("key_forum_broadcast_no_tip_again", this.f66169e.isNoTipAgainChecked());
                this.f66169e.dismiss();
                if (this.f66170f == 0) {
                    ScreenTopToast screenTopToast = new ScreenTopToast(this.f66171g.f66163a.getPageActivity());
                    screenTopToast.m(this.f66171g.f66163a.getPageActivity().getString(R.string.frs_forum_bawu_send_broadcast_none_tip));
                    screenTopToast.k(this.f66171g.f66163a.getString(R.string.frs_recommend_fail_tip_btn));
                    screenTopToast.j(new View$OnClickListenerC1720a(this));
                    screenTopToast.n((ViewGroup) this.f66171g.f66163a.getPageActivity().findViewById(R.id.frs));
                    return;
                }
                ForumBroadcastHelper forumBroadcastHelper = new ForumBroadcastHelper(this.f66171g.f66163a.getPageActivity());
                if (this.f66171g.f66164b == 1) {
                    forumBroadcastHelper.jumpFlutterEditGenear(this.f66171g.f66165c, this.f66171g.f66166d, "3");
                } else if (this.f66171g.f66164b == 2) {
                    forumBroadcastHelper.jumpFlutterEditGenear(this.f66171g.f66165c, this.f66171g.f66166d, "4");
                } else {
                    forumBroadcastHelper.jumpFlutterEditGenear(this.f66171g.f66165c, this.f66171g.f66166d, "0");
                }
                forumBroadcastHelper.clipCopy(this.f66171g.f66167e);
                forumBroadcastHelper.start();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.r0.r.s.a f66173e;

        public b(a aVar, d.a.r0.r.s.a aVar2) {
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
            this.f66173e = aVar2;
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                d.a.r0.r.d0.b.j().t("key_call_fans_no_tip_again", false);
                this.f66173e.dismiss();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f66174a;

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
            this.f66174a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && (httpResponsedMessage instanceof ForumManagerRightsResMsg)) {
                ForumManagerRightsResMsg forumManagerRightsResMsg = (ForumManagerRightsResMsg) httpResponsedMessage;
                boolean g2 = d.a.r0.r.d0.b.j().g("key_forum_broadcast_no_tip_again", false);
                int i2 = forumManagerRightsResMsg.broadcastTotalCount - forumManagerRightsResMsg.broadcastUsedCount;
                if (!g2) {
                    this.f66174a.j(i2);
                } else if (this.f66174a.f66164b == 1) {
                    this.f66174a.f66163a.showToast(R.string.top_success);
                } else if (this.f66174a.f66164b == 2) {
                    this.f66174a.f66163a.showToast(R.string.set_good_success);
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
        this.f66168f = new c(this, CmdConfigHttp.CMD_GET_FORUM_MANAGER_RIGHTS);
        this.f66163a = tbPageContext;
        i();
        tbPageContext.registerListener(this.f66168f);
    }

    public void g(int i2, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, str2, str3}) == null) {
            this.f66164b = i2;
            this.f66165c = str;
            this.f66166d = str2;
            this.f66167e = str3;
            h(str);
        }
    }

    public final void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_FORUM_MANAGER_RIGHTS);
            httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccount());
            httpMessage.addParam("forum_id", str);
            this.f66163a.sendMessage(httpMessage);
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
            d.a.r0.r.s.a aVar = new d.a.r0.r.s.a(this.f66163a.getPageActivity());
            aVar.setUseNoTipAgainStyle(true);
            aVar.setNegativeTextColor(R.color.CAM_X0105);
            int i3 = this.f66164b;
            if (i3 == 1) {
                aVar.setTitle(R.string.top_success);
            } else if (i3 == 2) {
                aVar.setTitle(R.string.set_good_success);
            }
            aVar.setMessage(String.format(this.f66163a.getString(R.string.forum_broadcast_intro), Integer.valueOf(i2)));
            aVar.setContentViewSize(1);
            aVar.setPositiveButton(this.f66163a.getString(R.string.send_forum_broadcast), new C1719a(this, aVar, i2));
            aVar.setNegativeButton(this.f66163a.getString(R.string.next_time), new b(this, aVar));
            aVar.create(this.f66163a).show();
        }
    }
}
