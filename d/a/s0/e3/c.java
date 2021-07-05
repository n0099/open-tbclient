package d.a.s0.e3;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.home.forumRecommendHttpResponseMessage;
import com.baidu.tieba.enterForum.home.forumRecommendRequestMessage;
import com.baidu.tieba.enterForum.home.forumRecommendSocketResponseMessage;
import com.baidu.tieba.square.adapter.LeftAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.j;
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Context f59173a;

    /* renamed from: b  reason: collision with root package name */
    public final d.a.s0.e3.b f59174b;

    /* renamed from: c  reason: collision with root package name */
    public final d.a.s0.e3.a f59175c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.c.c.g.a f59176d;

    /* renamed from: e  reason: collision with root package name */
    public final View.OnClickListener f59177e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f59178f;

    /* renamed from: g  reason: collision with root package name */
    public LeftAdapter.b f59179g;

    /* renamed from: h  reason: collision with root package name */
    public RecyclerView.OnScrollListener f59180h;

    /* renamed from: i  reason: collision with root package name */
    public BdListView.p f59181i;

    /* loaded from: classes9.dex */
    public class a extends d.a.c.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f59182a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(c cVar, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2), Integer.valueOf(i3)};
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
            this.f59182a = cVar;
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                String str = "";
                if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                    forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage = (forumRecommendSocketResponseMessage) responsedMessage;
                    if (forumrecommendsocketresponsemessage.getHotSearchInfoData() != null) {
                        str = forumrecommendsocketresponsemessage.getHotSearchInfoData().w();
                    }
                } else if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                    forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage = (forumRecommendHttpResponseMessage) responsedMessage;
                    if (forumrecommendhttpresponsemessage.getHotSearchInfoData() != null) {
                        str = forumrecommendhttpresponsemessage.getHotSearchInfoData().w();
                    }
                }
                if (TextUtils.isEmpty(str)) {
                    str = this.f59182a.f59173a.getResources().getString(R.string.enter_forum_search_tip);
                }
                if (this.f59182a.f59174b != null) {
                    this.f59182a.f59174b.A(str);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f59183e;

        public b(c cVar) {
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
            this.f59183e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f59183e.f59175c.j();
            }
        }
    }

    /* renamed from: d.a.s0.e3.c$c  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class View$OnClickListenerC1408c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f59184e;

        public View$OnClickListenerC1408c(c cVar) {
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
            this.f59184e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.log(new StatisticItem("c13654").param("uid", TbadkCoreApplication.getCurrentAccountId()));
                this.f59184e.f();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements LeftAdapter.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f59185a;

        public d(c cVar) {
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
            this.f59185a = cVar;
        }

        @Override // com.baidu.tieba.square.adapter.LeftAdapter.b
        public void a(View view, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, view, i2, str) == null) {
                this.f59185a.f59175c.k(str);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e(c cVar) {
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
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) {
                super.onScrollStateChanged(recyclerView, i2);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i2, i3) == null) {
                super.onScrolled(recyclerView, i2, i3);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f59186e;

        public f(c cVar) {
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
            this.f59186e = cVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f59186e.f59175c.i();
            }
        }
    }

    public c(@NonNull Context context, d.a.s0.e3.a aVar, @NonNull d.a.s0.e3.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, aVar, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f59176d = new a(this, CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011);
        this.f59177e = new b(this);
        this.f59178f = new View$OnClickListenerC1408c(this);
        this.f59179g = new d(this);
        this.f59180h = new e(this);
        this.f59181i = new f(this);
        this.f59173a = context;
        this.f59174b = bVar;
        this.f59175c = aVar;
        bVar.v(this.f59178f);
        this.f59174b.x(this.f59177e);
        this.f59174b.w(this.f59179g);
        this.f59174b.z(this.f59181i);
        this.f59174b.y(this.f59180h);
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            String hotSearch = TbSingleton.getInstance().getHotSearch();
            if (!TextUtils.isEmpty(hotSearch)) {
                this.f59174b.A(hotSearch);
            } else if (TbadkCoreApplication.getInst().checkInterrupt()) {
            } else {
                MessageManager.getInstance().registerListener(this.f59176d);
                g();
            }
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && j.z()) {
            if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                TbadkCoreApplication.getInst().login(UtilHelper.getTbPageContext(this.f59173a), new CustomMessage<>(2002001, new LoginActivityConfig(this.f59173a, true, 11013)));
            } else {
                UrlManager.getInstance().dealOneLink(UtilHelper.getTbPageContext(this.f59173a), new String[]{"https://tieba.baidu.com/mo/q/priforum/create/info?nomenu=1"});
            }
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            forumRecommendRequestMessage forumrecommendrequestmessage = new forumRecommendRequestMessage();
            forumrecommendrequestmessage.set_like_forum(Integer.valueOf(TbadkCoreApplication.isLogin() ? 1 : 0));
            forumrecommendrequestmessage.set_topic(0);
            forumrecommendrequestmessage.set_recommend(1);
            MessageManager.getInstance().sendMessage(forumrecommendrequestmessage);
        }
    }
}
