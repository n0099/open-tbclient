package d.a.n0.b3;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
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
import d.a.c.e.p.j;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final Context f55780a;

    /* renamed from: b  reason: collision with root package name */
    public final d.a.n0.b3.b f55781b;

    /* renamed from: c  reason: collision with root package name */
    public final d.a.n0.b3.a f55782c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.c.c.g.a f55783d = new a(CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011);

    /* renamed from: e  reason: collision with root package name */
    public final View.OnClickListener f55784e = new b();

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f55785f = new View$OnClickListenerC1277c();

    /* renamed from: g  reason: collision with root package name */
    public LeftAdapter.b f55786g = new d();

    /* renamed from: h  reason: collision with root package name */
    public RecyclerView.OnScrollListener f55787h = new e(this);

    /* renamed from: i  reason: collision with root package name */
    public BdListView.p f55788i = new f();

    /* loaded from: classes5.dex */
    public class a extends d.a.c.c.g.a {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
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
                str = c.this.f55780a.getResources().getString(R.string.enter_forum_search_tip);
            }
            if (c.this.f55781b != null) {
                c.this.f55781b.A(str);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.f55782c.h();
        }
    }

    /* renamed from: d.a.n0.b3.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1277c implements View.OnClickListener {
        public View$OnClickListenerC1277c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new StatisticItem("c13654").param("uid", TbadkCoreApplication.getCurrentAccountId()));
            c.this.f();
        }
    }

    /* loaded from: classes5.dex */
    public class d implements LeftAdapter.b {
        public d() {
        }

        @Override // com.baidu.tieba.square.adapter.LeftAdapter.b
        public void a(View view, int i2, String str) {
            c.this.f55782c.i(str);
        }
    }

    /* loaded from: classes5.dex */
    public class e extends RecyclerView.OnScrollListener {
        public e(c cVar) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            super.onScrollStateChanged(recyclerView, i2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            super.onScrolled(recyclerView, i2, i3);
        }
    }

    /* loaded from: classes5.dex */
    public class f implements BdListView.p {
        public f() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            c.this.f55782c.g();
        }
    }

    public c(@NonNull Context context, d.a.n0.b3.a aVar, @NonNull d.a.n0.b3.b bVar) {
        this.f55780a = context;
        this.f55781b = bVar;
        this.f55782c = aVar;
        bVar.v(this.f55785f);
        this.f55781b.x(this.f55784e);
        this.f55781b.w(this.f55786g);
        this.f55781b.z(this.f55788i);
        this.f55781b.y(this.f55787h);
    }

    public void e() {
        String hotSearch = TbSingleton.getInstance().getHotSearch();
        if (!TextUtils.isEmpty(hotSearch)) {
            this.f55781b.A(hotSearch);
        } else if (TbadkCoreApplication.getInst().checkInterrupt()) {
        } else {
            MessageManager.getInstance().registerListener(this.f55783d);
            g();
        }
    }

    public final void f() {
        if (j.z()) {
            if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                TbadkCoreApplication.getInst().login(UtilHelper.getTbPageContext(this.f55780a), new CustomMessage<>(2002001, new LoginActivityConfig(this.f55780a, true, 11013)));
            } else {
                UrlManager.getInstance().dealOneLink(UtilHelper.getTbPageContext(this.f55780a), new String[]{"https://tieba.baidu.com/mo/q/priforum/create/info?nomenu=1"});
            }
        }
    }

    public final void g() {
        forumRecommendRequestMessage forumrecommendrequestmessage = new forumRecommendRequestMessage();
        forumrecommendrequestmessage.set_like_forum(Integer.valueOf(TbadkCoreApplication.isLogin() ? 1 : 0));
        forumrecommendrequestmessage.set_topic(0);
        forumrecommendrequestmessage.set_recommend(1);
        MessageManager.getInstance().sendMessage(forumrecommendrequestmessage);
    }
}
