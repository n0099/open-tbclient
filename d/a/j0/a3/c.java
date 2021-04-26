package d.a.j0.a3;

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
    public final Context f51225a;

    /* renamed from: b  reason: collision with root package name */
    public final d.a.j0.a3.b f51226b;

    /* renamed from: c  reason: collision with root package name */
    public final d.a.j0.a3.a f51227c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.c.c.g.a f51228d = new a(CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011);

    /* renamed from: e  reason: collision with root package name */
    public final View.OnClickListener f51229e = new b();

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f51230f = new View$OnClickListenerC1132c();

    /* renamed from: g  reason: collision with root package name */
    public LeftAdapter.b f51231g = new d();

    /* renamed from: h  reason: collision with root package name */
    public RecyclerView.OnScrollListener f51232h = new e(this);

    /* renamed from: i  reason: collision with root package name */
    public BdListView.p f51233i = new f();

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
                    str = forumrecommendsocketresponsemessage.getHotSearchInfoData().s();
                }
            } else if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage = (forumRecommendHttpResponseMessage) responsedMessage;
                if (forumrecommendhttpresponsemessage.getHotSearchInfoData() != null) {
                    str = forumrecommendhttpresponsemessage.getHotSearchInfoData().s();
                }
            }
            if (TextUtils.isEmpty(str)) {
                str = c.this.f51225a.getResources().getString(R.string.enter_forum_search_tip);
            }
            if (c.this.f51226b != null) {
                c.this.f51226b.A(str);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.f51227c.h();
        }
    }

    /* renamed from: d.a.j0.a3.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1132c implements View.OnClickListener {
        public View$OnClickListenerC1132c() {
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
            c.this.f51227c.i(str);
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
            c.this.f51227c.g();
        }
    }

    public c(@NonNull Context context, d.a.j0.a3.a aVar, @NonNull d.a.j0.a3.b bVar) {
        this.f51225a = context;
        this.f51226b = bVar;
        this.f51227c = aVar;
        bVar.v(this.f51230f);
        this.f51226b.x(this.f51229e);
        this.f51226b.w(this.f51231g);
        this.f51226b.z(this.f51233i);
        this.f51226b.y(this.f51232h);
    }

    public void e() {
        String hotSearch = TbSingleton.getInstance().getHotSearch();
        if (!TextUtils.isEmpty(hotSearch)) {
            this.f51226b.A(hotSearch);
        } else if (TbadkCoreApplication.getInst().checkInterrupt()) {
        } else {
            MessageManager.getInstance().registerListener(this.f51228d);
            g();
        }
    }

    public final void f() {
        if (j.z()) {
            if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                TbadkCoreApplication.getInst().login(UtilHelper.getTbPageContext(this.f51225a), new CustomMessage<>(2002001, new LoginActivityConfig(this.f51225a, true, 11013)));
            } else {
                UrlManager.getInstance().dealOneLink(UtilHelper.getTbPageContext(this.f51225a), new String[]{"https://tieba.baidu.com/mo/q/priforum/create/info?nomenu=1"});
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
