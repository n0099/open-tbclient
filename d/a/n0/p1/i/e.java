package d.a.n0.p1.i;

import android.net.http.SslError;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tbadk.browser.UegTbJsBridge;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.R;
import com.baidu.tieba.mainentrance.HotSearchInfoData;
import com.baidu.tieba.mainentrance.searchSuggestList.SearchListNetMessage;
import com.baidu.tieba.postsearch.PostSearchActivity;
import d.a.m0.r.q.r0;
import d.a.m0.z0.e0;
import d.a.m0.z0.f0;
import d.a.m0.z0.h0;
import d.a.m0.z0.n0;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tbclient.SearchSug.ForumInfo;
/* loaded from: classes3.dex */
public class e implements d.a.n0.p1.i.b {

    /* renamed from: a  reason: collision with root package name */
    public BaseActivity f58122a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.n0.p1.i.d f58123b;

    /* renamed from: c  reason: collision with root package name */
    public View f58124c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f58125d;

    /* renamed from: e  reason: collision with root package name */
    public HotSearchInfoData f58126e;

    /* renamed from: g  reason: collision with root package name */
    public String f58128g;

    /* renamed from: i  reason: collision with root package name */
    public d.a.n0.p1.i.c f58130i;

    /* renamed from: f  reason: collision with root package name */
    public boolean f58127f = true;

    /* renamed from: h  reason: collision with root package name */
    public Stack<String> f58129h = new Stack<>();
    public CustomMessageListener j = new d(2921444);

    /* loaded from: classes3.dex */
    public class a implements BaseWebView.i {
        public a(e eVar) {
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.i
        public void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            if (sslError != null) {
                d.a.m0.r.z.a.a("search", -1L, 0, "ReceivedSslError", 0, "", "requesturl", sslError.getUrl(), "receiveerror", sslError.toString());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements BaseWebView.d {
        public b() {
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.d
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            d.a.m0.r.z.a.a("search", -1L, 0, "OverrideUrl", 0, "", "requesturl", str);
            if (!TbadkCoreApplication.isLogin() && str != null && e0.e(str) && e0.a()) {
                r0 r0Var = new r0(e.this.f58122a, "sousuo_dianji");
                r0Var.f(str);
                DialogLoginHelper.checkUpIsLogin(r0Var);
                return true;
            } else if (UrlManager.getInstance().dealOneLinkWithOutJumpWebView(e.this.f58122a.getPageContext(), new String[]{str}) != 3) {
                return true;
            } else {
                if (str == null || !str.contains(UrlSchemaHelper.JUMP_TO_NEW_PAGE)) {
                    return false;
                }
                UrlManager.getInstance().dealOneLink(e.this.f58122a.getPageContext(), new String[]{str}, true);
                return true;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends f0<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f58132a;

        public c(e eVar, String str) {
            this.f58132a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // d.a.m0.z0.f0
        public Boolean doInBackground() {
            d.a.n0.e3.n0.a.o(this.f58132a);
            return Boolean.TRUE;
        }
    }

    /* loaded from: classes3.dex */
    public class d extends CustomMessageListener {
        public d(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            e.this.f58123b.L(!((Boolean) customResponsedMessage.getData()).booleanValue());
        }
    }

    /* renamed from: d.a.n0.p1.i.e$e  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnFocusChangeListenerC1469e implements View.OnFocusChangeListener {
        public View$OnFocusChangeListenerC1469e() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (!z) {
                d.a.c.e.p.l.x(e.this.f58122a.getPageContext().getPageActivity(), view);
            } else {
                e.this.o();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements TextView.OnEditorActionListener {
        public f() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            if (i2 == 3) {
                if (StringUtils.isNull(e.this.f58128g)) {
                    d.a.c.e.p.l.x(e.this.f58122a.getPageContext().getPageActivity(), textView);
                    e.this.x();
                } else {
                    e eVar = e.this;
                    eVar.a(eVar.f58128g, false, 1);
                    TiebaStatic.log(new StatisticItem(PostSearchActivity.FORUM_SEARCH_CLICK).param("obj_name", e.this.f58128g).param("obj_source", "1").param("obj_type", "1"));
                }
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class g implements TextWatcher {
        public g() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable == null) {
                return;
            }
            if (e.this.f58127f) {
                e.this.f58128g = editable.toString();
                e.this.D();
            }
            e.this.f58123b.r(!StringUtils.isNull(editable.toString()));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    /* loaded from: classes3.dex */
    public class h implements View.OnClickListener {

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e.this.f58122a.finish();
            }
        }

        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != e.this.f58123b.g() || e.this.f58123b.g().getText() == null) {
                if (view == e.this.f58123b.d()) {
                    d.a.c.e.p.l.x(e.this.f58122a.getPageContext().getPageActivity(), e.this.f58123b.g());
                    d.a.c.e.m.e.a().postDelayed(new a(), 1000L);
                    return;
                }
                return;
            }
            e eVar = e.this;
            eVar.f58128g = eVar.f58123b.g().getText().toString();
            if (StringUtils.isNull(e.this.f58128g)) {
                e.this.C();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements AdapterView.OnItemClickListener {
        public i() {
        }

        /* JADX WARN: Type inference failed for: r6v1, types: [android.widget.Adapter] */
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            ?? adapter = adapterView.getAdapter();
            if (adapter == 0 || i2 >= adapter.getCount()) {
                return;
            }
            Object item = adapter.getItem(i2);
            if (item instanceof String) {
                String str = (String) item;
                e.this.a(str, true, 3);
                TiebaStatic.eventStat(e.this.f58122a.getPageContext().getPageActivity(), "search_bar_result_click", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                TiebaStatic.log(new StatisticItem(PostSearchActivity.FORUM_SEARCH_CLICK).param("obj_name", str).param("obj_source", "2").param("obj_type", "1").param("obj_locate", i2 + 1).param("obj_param1", e.this.f58128g));
            } else if (item instanceof ForumInfo) {
                ForumInfo forumInfo = (ForumInfo) item;
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(e.this.f58122a.getPageContext().getPageActivity()).createNormalCfg(forumInfo.forum_name, FrsActivityConfig.FRS_CALL_SEARCH)));
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_ENTER_FORUM_SUG_SHOW).param("obj_type", forumInfo.has_concerned.intValue() <= 0 ? "2" : "1").param("fid", forumInfo.forum_id.intValue()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j implements AbsListView.OnScrollListener {
        public j() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            if (i2 == 2 || i2 == 1) {
                d.a.c.e.p.l.x(e.this.f58122a.getPageContext().getPageActivity(), absListView);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k implements BaseWebView.e {
        public k(e eVar) {
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.e
        public void onPageFinished(WebView webView, String str) {
            d.a.m0.r.z.a.a("search", -1L, 0, "PageFinished", 0, "", "requesturl", str);
        }
    }

    /* loaded from: classes3.dex */
    public class l implements BaseWebView.h {
        public l(e eVar) {
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.h
        public void a(WebView webView, int i2, String str, String str2) {
            d.a.m0.r.z.a.a("search", -1L, 0, "ReceivedError", 0, "", "requesturl", str2, "receiveerror", Integer.valueOf(i2), "description", str);
        }
    }

    public e(BaseActivity baseActivity, boolean z) {
        this.f58122a = baseActivity;
        this.f58125d = z;
        r();
    }

    public void A(List<String> list) {
        this.f58123b.E(list, this.f58128g);
    }

    public void B(List<ForumInfo> list) {
        this.f58123b.F(list, this.f58128g);
    }

    public final void C() {
        this.f58130i.p();
    }

    public final void D() {
        if (!StringUtils.isNull(this.f58128g)) {
            w();
        } else {
            C();
        }
    }

    @Override // d.a.n0.p1.i.b
    public void a(String str, boolean z, int i2) {
        if (!d.a.c.e.p.j.z()) {
            this.f58122a.showToast(R.string.neterror);
        } else if (StringUtils.isNull(str)) {
        } else {
            Matcher matcher = Pattern.compile("^@(.*)@给你分享了贴吧号#(\\d+)#\\s?整段复制后打开贴吧即可找到Ta$", 2).matcher(str);
            if (matcher != null && matcher.find() && !TextUtils.isEmpty(matcher.group(2))) {
                str = matcher.group(2);
            }
            if (z) {
                this.f58127f = false;
                this.f58123b.C(str);
                this.f58127f = true;
            }
            d.a.c.e.p.l.x(this.f58122a.getPageContext().getPageActivity(), this.f58123b.g());
            this.f58123b.y();
            String str2 = "https://tieba.baidu.com/mo/q/hybrid/search?keyword=" + str + "&sub_type=" + i2;
            try {
                str2 = "https://tieba.baidu.com/mo/q/hybrid/search?keyword=" + URLEncoder.encode(str, "utf-8");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.f58123b.f().loadUrl(str2);
            this.f58129h.push(str);
            h0.b(new c(this, str), null);
            this.f58130i.i(str);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921345, str));
        }
    }

    public final void k() {
        this.f58123b.f().h(new UegTbJsBridge(this.f58122a.getPageContext()));
        this.f58123b.f().h(new SearchJsBridge());
    }

    public final void l() {
        k kVar = new k(this);
        l lVar = new l(this);
        a aVar = new a(this);
        b bVar = new b();
        this.f58123b.I(kVar);
        this.f58123b.K(lVar);
        this.f58123b.J(aVar);
        this.f58123b.H(bVar);
    }

    public final void m() {
        i iVar = new i();
        j jVar = new j();
        this.f58123b.t(iVar);
        this.f58123b.u(jVar);
    }

    public void n() {
        View$OnFocusChangeListenerC1469e view$OnFocusChangeListenerC1469e = new View$OnFocusChangeListenerC1469e();
        f fVar = new f();
        g gVar = new g();
        h hVar = new h();
        this.f58123b.A(view$OnFocusChangeListenerC1469e);
        this.f58123b.z(fVar);
        this.f58123b.D(gVar);
        this.f58123b.x(hVar);
    }

    public final void o() {
        if (this.f58123b.n()) {
            return;
        }
        w();
    }

    public View p() {
        return this.f58123b.g();
    }

    public BaseWebView q() {
        return this.f58123b.f();
    }

    public final void r() {
        try {
            View inflate = LayoutInflater.from(this.f58122a).inflate(R.layout.new_home_dialog_search, (ViewGroup) null);
            this.f58124c = inflate;
            this.f58122a.setContentView(inflate);
        } catch (Exception e2) {
            e2.printStackTrace();
            Map<String, String> a2 = d.a.n0.p1.i.a.a();
            if (a2 != null) {
                int size = a2.size();
                int i2 = 0;
                for (String str : a2.keySet()) {
                    d.a.n0.p1.i.a.b(str);
                    try {
                        View inflate2 = LayoutInflater.from(this.f58122a).inflate(R.layout.new_home_dialog_search, (ViewGroup) null);
                        this.f58124c = inflate2;
                        this.f58122a.setContentView(inflate2);
                        break;
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        i2++;
                    }
                }
                if (i2 == size) {
                    this.f58122a.finish();
                    return;
                }
            } else {
                this.f58122a.finish();
                return;
            }
        }
        View view = this.f58124c;
        if (view == null) {
            this.f58122a.finish();
            return;
        }
        d.a.n0.p1.i.d dVar = new d.a.n0.p1.i.d(view, this.f58122a.getPageContext().getPageActivity());
        this.f58123b = dVar;
        this.f58130i = new d.a.n0.p1.i.c(this.f58122a, this, dVar);
        n();
        m();
        l();
        k();
        y();
        D();
        n0.g(this.f58123b.f(), this.f58122a.getUniqueId());
        n0.g(this.f58123b.e(), this.f58122a.getUniqueId());
        this.f58122a.registerListener(this.j);
    }

    public void s(int i2) {
        this.f58123b.o(this.f58122a.getPageContext(), i2);
    }

    public void t() {
        d.a.n0.p1.i.d dVar = this.f58123b;
        if (dVar != null) {
            dVar.p();
        }
        d.a.n0.p1.i.c cVar = this.f58130i;
        if (cVar != null) {
            cVar.q();
        }
    }

    public void u() {
        d.a.n0.p1.i.d dVar = this.f58123b;
        if (dVar != null) {
            dVar.q();
        }
    }

    public void v() {
        d.a.n0.p1.i.d dVar;
        if (this.f58129h.size() > 1) {
            this.f58129h.pop();
            String peek = this.f58129h.peek();
            if (TextUtils.isEmpty(peek) || (dVar = this.f58123b) == null) {
                return;
            }
            boolean z = this.f58127f;
            this.f58127f = false;
            dVar.C(peek);
            this.f58127f = z;
            this.f58123b.y();
            return;
        }
        this.f58129h.clear();
    }

    public final void w() {
        if (StringUtils.isNull(this.f58128g)) {
            C();
            return;
        }
        SearchListNetMessage searchListNetMessage = new SearchListNetMessage();
        searchListNetMessage.mKey = this.f58128g.trim();
        searchListNetMessage.isForum = Integer.valueOf(this.f58125d ? 1 : 0);
        this.f58122a.sendMessage(searchListNetMessage);
    }

    public final void x() {
        HotSearchInfoData hotSearchInfoData = this.f58126e;
        if (hotSearchInfoData == null) {
            BaseActivity baseActivity = this.f58122a;
            baseActivity.showToast(baseActivity.getResources().getString(R.string.write_keyword));
            return;
        }
        if (hotSearchInfoData.t() != 0 && this.f58126e.t() != 2) {
            if (this.f58126e.t() == 1 && !d.a.m0.p0.b.b(this.f58122a.getPageContext())) {
                this.f58122a.sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(this.f58122a.getPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.f58126e.getId()), this.f58126e.getName(), "4")));
            }
        } else {
            a(this.f58126e.getName(), true, 1);
        }
        TiebaStatic.log(new StatisticItem("c10355").param("obj_name", this.f58126e.getName()).param("obj_type", this.f58126e.t() == 0 ? 2 : 1));
    }

    public final void y() {
        d.a.n0.p1.i.d dVar = this.f58123b;
        if (dVar == null) {
            return;
        }
        HotSearchInfoData hotSearchInfoData = this.f58126e;
        if (hotSearchInfoData == null) {
            dVar.B(this.f58122a.getResources().getString(R.string.search_bar));
        } else {
            dVar.B(hotSearchInfoData.s());
        }
    }

    public void z(HotSearchInfoData hotSearchInfoData) {
        this.f58126e = hotSearchInfoData;
        y();
    }
}
