package d.b.i0.a3;

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
import d.b.c.e.p.j;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final Context f53073a;

    /* renamed from: b  reason: collision with root package name */
    public final d.b.i0.a3.b f53074b;

    /* renamed from: c  reason: collision with root package name */
    public final d.b.i0.a3.a f53075c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.c.c.g.a f53076d = new a(CmdConfigHttp.FORUM_RECOMMEND_HTTP_CMD, 303011);

    /* renamed from: e  reason: collision with root package name */
    public final View.OnClickListener f53077e = new b();

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f53078f = new View$OnClickListenerC1170c();

    /* renamed from: g  reason: collision with root package name */
    public LeftAdapter.b f53079g = new d();

    /* renamed from: h  reason: collision with root package name */
    public RecyclerView.OnScrollListener f53080h = new e(this);
    public BdListView.p i = new f();

    /* loaded from: classes4.dex */
    public class a extends d.b.c.c.g.a {
        public a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.c.c.g.a
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
                str = c.this.f53073a.getResources().getString(R.string.enter_forum_search_tip);
            }
            if (c.this.f53074b != null) {
                c.this.f53074b.A(str);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.f53075c.h();
        }
    }

    /* renamed from: d.b.i0.a3.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1170c implements View.OnClickListener {
        public View$OnClickListenerC1170c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new StatisticItem("c13654").param("uid", TbadkCoreApplication.getCurrentAccountId()));
            c.this.f();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements LeftAdapter.b {
        public d() {
        }

        @Override // com.baidu.tieba.square.adapter.LeftAdapter.b
        public void a(View view, int i, String str) {
            c.this.f53075c.i(str);
        }
    }

    /* loaded from: classes4.dex */
    public class e extends RecyclerView.OnScrollListener {
        public e(c cVar) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
        }
    }

    /* loaded from: classes4.dex */
    public class f implements BdListView.p {
        public f() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            c.this.f53075c.g();
        }
    }

    public c(@NonNull Context context, d.b.i0.a3.a aVar, @NonNull d.b.i0.a3.b bVar) {
        this.f53073a = context;
        this.f53074b = bVar;
        this.f53075c = aVar;
        bVar.v(this.f53078f);
        this.f53074b.x(this.f53077e);
        this.f53074b.w(this.f53079g);
        this.f53074b.z(this.i);
        this.f53074b.y(this.f53080h);
    }

    public void e() {
        String hotSearch = TbSingleton.getInstance().getHotSearch();
        if (!TextUtils.isEmpty(hotSearch)) {
            this.f53074b.A(hotSearch);
        } else if (TbadkCoreApplication.getInst().checkInterrupt()) {
        } else {
            MessageManager.getInstance().registerListener(this.f53076d);
            g();
        }
    }

    public final void f() {
        if (j.z()) {
            if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                TbadkCoreApplication.getInst().login(UtilHelper.getTbPageContext(this.f53073a), new CustomMessage<>(2002001, new LoginActivityConfig(this.f53073a, true, 11013)));
            } else {
                UrlManager.getInstance().dealOneLink(UtilHelper.getTbPageContext(this.f53073a), new String[]{"https://tieba.baidu.com/mo/q/priforum/create/info?nomenu=1"});
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
