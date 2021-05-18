package d.a.k0.o1.i;

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
import d.a.j0.r.q.r0;
import d.a.j0.z0.e0;
import d.a.j0.z0.f0;
import d.a.j0.z0.h0;
import d.a.j0.z0.n0;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tbclient.SearchSug.ForumInfo;
/* loaded from: classes3.dex */
public class e implements d.a.k0.o1.i.b {

    /* renamed from: a  reason: collision with root package name */
    public BaseActivity f58013a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.k0.o1.i.d f58014b;

    /* renamed from: c  reason: collision with root package name */
    public View f58015c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f58016d;

    /* renamed from: e  reason: collision with root package name */
    public HotSearchInfoData f58017e;

    /* renamed from: g  reason: collision with root package name */
    public String f58019g;

    /* renamed from: i  reason: collision with root package name */
    public d.a.k0.o1.i.c f58021i;

    /* renamed from: f  reason: collision with root package name */
    public boolean f58018f = true;

    /* renamed from: h  reason: collision with root package name */
    public Stack<String> f58020h = new Stack<>();
    public CustomMessageListener j = new d(2921444);

    /* loaded from: classes3.dex */
    public class a implements BaseWebView.i {
        public a(e eVar) {
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.i
        public void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            if (sslError != null) {
                d.a.j0.r.z.a.a("search", -1L, 0, "ReceivedSslError", 0, "", "requesturl", sslError.getUrl(), "receiveerror", sslError.toString());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements BaseWebView.d {
        public b() {
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.d
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            d.a.j0.r.z.a.a("search", -1L, 0, "OverrideUrl", 0, "", "requesturl", str);
            if (!TbadkCoreApplication.isLogin() && str != null && e0.e(str) && e0.a()) {
                r0 r0Var = new r0(e.this.f58013a, "sousuo_dianji");
                r0Var.f(str);
                DialogLoginHelper.checkUpIsLogin(r0Var);
                return true;
            } else if (UrlManager.getInstance().dealOneLinkWithOutJumpWebView(e.this.f58013a.getPageContext(), new String[]{str}) != 3) {
                return true;
            } else {
                if (str == null || !str.contains(UrlSchemaHelper.JUMP_TO_NEW_PAGE)) {
                    return false;
                }
                UrlManager.getInstance().dealOneLink(e.this.f58013a.getPageContext(), new String[]{str}, true);
                return true;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends f0<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f58023a;

        public c(e eVar, String str) {
            this.f58023a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // d.a.j0.z0.f0
        public Boolean doInBackground() {
            d.a.k0.d3.n0.a.o(this.f58023a);
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
            e.this.f58014b.L(!((Boolean) customResponsedMessage.getData()).booleanValue());
        }
    }

    /* renamed from: d.a.k0.o1.i.e$e  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnFocusChangeListenerC1459e implements View.OnFocusChangeListener {
        public View$OnFocusChangeListenerC1459e() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (!z) {
                d.a.c.e.p.l.x(e.this.f58013a.getPageContext().getPageActivity(), view);
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
                if (StringUtils.isNull(e.this.f58019g)) {
                    d.a.c.e.p.l.x(e.this.f58013a.getPageContext().getPageActivity(), textView);
                    e.this.x();
                } else {
                    e eVar = e.this;
                    eVar.a(eVar.f58019g, false, 1);
                    TiebaStatic.log(new StatisticItem(PostSearchActivity.FORUM_SEARCH_CLICK).param("obj_name", e.this.f58019g).param("obj_source", "1").param("obj_type", "1"));
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
            if (e.this.f58018f) {
                e.this.f58019g = editable.toString();
                e.this.D();
            }
            e.this.f58014b.r(!StringUtils.isNull(editable.toString()));
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
                e.this.f58013a.finish();
            }
        }

        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != e.this.f58014b.g() || e.this.f58014b.g().getText() == null) {
                if (view == e.this.f58014b.d()) {
                    d.a.c.e.p.l.x(e.this.f58013a.getPageContext().getPageActivity(), e.this.f58014b.g());
                    d.a.c.e.m.e.a().postDelayed(new a(), 1000L);
                    return;
                }
                return;
            }
            e eVar = e.this;
            eVar.f58019g = eVar.f58014b.g().getText().toString();
            if (StringUtils.isNull(e.this.f58019g)) {
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
                TiebaStatic.eventStat(e.this.f58013a.getPageContext().getPageActivity(), "search_bar_result_click", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                TiebaStatic.log(new StatisticItem(PostSearchActivity.FORUM_SEARCH_CLICK).param("obj_name", str).param("obj_source", "2").param("obj_type", "1").param("obj_locate", i2 + 1).param("obj_param1", e.this.f58019g));
            } else if (item instanceof ForumInfo) {
                ForumInfo forumInfo = (ForumInfo) item;
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(e.this.f58013a.getPageContext().getPageActivity()).createNormalCfg(forumInfo.forum_name, FrsActivityConfig.FRS_CALL_SEARCH)));
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
                d.a.c.e.p.l.x(e.this.f58013a.getPageContext().getPageActivity(), absListView);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k implements BaseWebView.e {
        public k(e eVar) {
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.e
        public void onPageFinished(WebView webView, String str) {
            d.a.j0.r.z.a.a("search", -1L, 0, "PageFinished", 0, "", "requesturl", str);
        }
    }

    /* loaded from: classes3.dex */
    public class l implements BaseWebView.h {
        public l(e eVar) {
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.h
        public void a(WebView webView, int i2, String str, String str2) {
            d.a.j0.r.z.a.a("search", -1L, 0, "ReceivedError", 0, "", "requesturl", str2, "receiveerror", Integer.valueOf(i2), "description", str);
        }
    }

    public e(BaseActivity baseActivity, boolean z) {
        this.f58013a = baseActivity;
        this.f58016d = z;
        r();
    }

    public void A(List<String> list) {
        this.f58014b.E(list, this.f58019g);
    }

    public void B(List<ForumInfo> list) {
        this.f58014b.F(list, this.f58019g);
    }

    public final void C() {
        this.f58021i.p();
    }

    public final void D() {
        if (!StringUtils.isNull(this.f58019g)) {
            w();
        } else {
            C();
        }
    }

    @Override // d.a.k0.o1.i.b
    public void a(String str, boolean z, int i2) {
        if (!d.a.c.e.p.j.z()) {
            this.f58013a.showToast(R.string.neterror);
        } else if (StringUtils.isNull(str)) {
        } else {
            Matcher matcher = Pattern.compile("^@(.*)@给你分享了贴吧号#(\\d+)#\\s?整段复制后打开贴吧即可找到Ta$", 2).matcher(str);
            if (matcher != null && matcher.find() && !TextUtils.isEmpty(matcher.group(2))) {
                str = matcher.group(2);
            }
            if (z) {
                this.f58018f = false;
                this.f58014b.C(str);
                this.f58018f = true;
            }
            d.a.c.e.p.l.x(this.f58013a.getPageContext().getPageActivity(), this.f58014b.g());
            this.f58014b.y();
            String str2 = "https://tieba.baidu.com/mo/q/hybrid/search?keyword=" + str + "&sub_type=" + i2;
            try {
                str2 = "https://tieba.baidu.com/mo/q/hybrid/search?keyword=" + URLEncoder.encode(str, "utf-8");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.f58014b.f().loadUrl(str2);
            this.f58020h.push(str);
            h0.b(new c(this, str), null);
            this.f58021i.i(str);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921345, str));
        }
    }

    public final void k() {
        this.f58014b.f().h(new UegTbJsBridge(this.f58013a.getPageContext()));
        this.f58014b.f().h(new SearchJsBridge());
    }

    public final void l() {
        k kVar = new k(this);
        l lVar = new l(this);
        a aVar = new a(this);
        b bVar = new b();
        this.f58014b.I(kVar);
        this.f58014b.K(lVar);
        this.f58014b.J(aVar);
        this.f58014b.H(bVar);
    }

    public final void m() {
        i iVar = new i();
        j jVar = new j();
        this.f58014b.t(iVar);
        this.f58014b.u(jVar);
    }

    public void n() {
        View$OnFocusChangeListenerC1459e view$OnFocusChangeListenerC1459e = new View$OnFocusChangeListenerC1459e();
        f fVar = new f();
        g gVar = new g();
        h hVar = new h();
        this.f58014b.A(view$OnFocusChangeListenerC1459e);
        this.f58014b.z(fVar);
        this.f58014b.D(gVar);
        this.f58014b.x(hVar);
    }

    public final void o() {
        if (this.f58014b.n()) {
            return;
        }
        w();
    }

    public View p() {
        return this.f58014b.g();
    }

    public BaseWebView q() {
        return this.f58014b.f();
    }

    public final void r() {
        try {
            View inflate = LayoutInflater.from(this.f58013a).inflate(R.layout.new_home_dialog_search, (ViewGroup) null);
            this.f58015c = inflate;
            this.f58013a.setContentView(inflate);
        } catch (Exception e2) {
            e2.printStackTrace();
            Map<String, String> a2 = d.a.k0.o1.i.a.a();
            if (a2 != null) {
                int size = a2.size();
                int i2 = 0;
                for (String str : a2.keySet()) {
                    d.a.k0.o1.i.a.b(str);
                    try {
                        View inflate2 = LayoutInflater.from(this.f58013a).inflate(R.layout.new_home_dialog_search, (ViewGroup) null);
                        this.f58015c = inflate2;
                        this.f58013a.setContentView(inflate2);
                        break;
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        i2++;
                    }
                }
                if (i2 == size) {
                    this.f58013a.finish();
                    return;
                }
            } else {
                this.f58013a.finish();
                return;
            }
        }
        View view = this.f58015c;
        if (view == null) {
            this.f58013a.finish();
            return;
        }
        d.a.k0.o1.i.d dVar = new d.a.k0.o1.i.d(view, this.f58013a.getPageContext().getPageActivity());
        this.f58014b = dVar;
        this.f58021i = new d.a.k0.o1.i.c(this.f58013a, this, dVar);
        n();
        m();
        l();
        k();
        y();
        D();
        n0.g(this.f58014b.f(), this.f58013a.getUniqueId());
        n0.g(this.f58014b.e(), this.f58013a.getUniqueId());
        this.f58013a.registerListener(this.j);
    }

    public void s(int i2) {
        this.f58014b.o(this.f58013a.getPageContext(), i2);
    }

    public void t() {
        d.a.k0.o1.i.d dVar = this.f58014b;
        if (dVar != null) {
            dVar.p();
        }
        d.a.k0.o1.i.c cVar = this.f58021i;
        if (cVar != null) {
            cVar.q();
        }
    }

    public void u() {
        d.a.k0.o1.i.d dVar = this.f58014b;
        if (dVar != null) {
            dVar.q();
        }
    }

    public void v() {
        d.a.k0.o1.i.d dVar;
        if (this.f58020h.size() > 1) {
            this.f58020h.pop();
            String peek = this.f58020h.peek();
            if (TextUtils.isEmpty(peek) || (dVar = this.f58014b) == null) {
                return;
            }
            boolean z = this.f58018f;
            this.f58018f = false;
            dVar.C(peek);
            this.f58018f = z;
            this.f58014b.y();
            return;
        }
        this.f58020h.clear();
    }

    public final void w() {
        if (StringUtils.isNull(this.f58019g)) {
            C();
            return;
        }
        SearchListNetMessage searchListNetMessage = new SearchListNetMessage();
        searchListNetMessage.mKey = this.f58019g.trim();
        searchListNetMessage.isForum = Integer.valueOf(this.f58016d ? 1 : 0);
        this.f58013a.sendMessage(searchListNetMessage);
    }

    public final void x() {
        HotSearchInfoData hotSearchInfoData = this.f58017e;
        if (hotSearchInfoData == null) {
            BaseActivity baseActivity = this.f58013a;
            baseActivity.showToast(baseActivity.getResources().getString(R.string.write_keyword));
            return;
        }
        if (hotSearchInfoData.t() != 0 && this.f58017e.t() != 2) {
            if (this.f58017e.t() == 1 && !d.a.j0.p0.b.b(this.f58013a.getPageContext())) {
                this.f58013a.sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(this.f58013a.getPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.f58017e.getId()), this.f58017e.getName(), "4")));
            }
        } else {
            a(this.f58017e.getName(), true, 1);
        }
        TiebaStatic.log(new StatisticItem("c10355").param("obj_name", this.f58017e.getName()).param("obj_type", this.f58017e.t() == 0 ? 2 : 1));
    }

    public final void y() {
        d.a.k0.o1.i.d dVar = this.f58014b;
        if (dVar == null) {
            return;
        }
        HotSearchInfoData hotSearchInfoData = this.f58017e;
        if (hotSearchInfoData == null) {
            dVar.B(this.f58013a.getResources().getString(R.string.search_bar));
        } else {
            dVar.B(hotSearchInfoData.s());
        }
    }

    public void z(HotSearchInfoData hotSearchInfoData) {
        this.f58017e = hotSearchInfoData;
        y();
    }
}
