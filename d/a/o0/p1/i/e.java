package d.a.o0.p1.i;

import android.content.Intent;
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
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.browser.BaseWebViewActivity;
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
import d.a.n0.r.q.r0;
import d.a.n0.z0.e0;
import d.a.n0.z0.f0;
import d.a.n0.z0.h0;
import d.a.n0.z0.n0;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tbclient.SearchSug.ForumInfo;
/* loaded from: classes3.dex */
public class e implements d.a.o0.p1.i.b {

    /* renamed from: a  reason: collision with root package name */
    public BaseActivity f61938a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.o0.p1.i.d f61939b;

    /* renamed from: c  reason: collision with root package name */
    public View f61940c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f61941d;

    /* renamed from: e  reason: collision with root package name */
    public HotSearchInfoData f61942e;

    /* renamed from: g  reason: collision with root package name */
    public String f61944g;

    /* renamed from: i  reason: collision with root package name */
    public d.a.o0.p1.i.c f61946i;

    /* renamed from: f  reason: collision with root package name */
    public boolean f61943f = true;

    /* renamed from: h  reason: collision with root package name */
    public Stack<String> f61945h = new Stack<>();
    public CustomMessageListener j = new d(2921444);

    /* loaded from: classes3.dex */
    public class a implements BaseWebView.i {
        public a(e eVar) {
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.i
        public void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            if (sslError != null) {
                d.a.n0.r.z.a.a("search", -1L, 0, "ReceivedSslError", 0, "", "requesturl", sslError.getUrl(), "receiveerror", sslError.toString());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements BaseWebView.d {
        public b() {
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.d
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            d.a.n0.r.z.a.a("search", -1L, 0, "OverrideUrl", 0, "", "requesturl", str);
            if (!TbadkCoreApplication.isLogin() && str != null && e0.e(str) && e0.a()) {
                r0 r0Var = new r0(e.this.f61938a, "sousuo_dianji");
                r0Var.f(str);
                DialogLoginHelper.checkUpIsLogin(r0Var);
                return true;
            } else if (UrlManager.getInstance().dealOneLinkWithOutJumpWebView(e.this.f61938a.getPageContext(), new String[]{str}) != 3) {
                return true;
            } else {
                if (str == null || !str.contains(UrlSchemaHelper.JUMP_TO_NEW_PAGE)) {
                    Intent parseIntentFromUrl = BaseWebViewActivity.parseIntentFromUrl(e.this.f61938a.getApplicationContext(), str);
                    if (parseIntentFromUrl != null) {
                        try {
                            e.this.f61938a.startActivity(parseIntentFromUrl);
                        } catch (Throwable th) {
                            BdLog.detailException(th);
                        }
                        return true;
                    }
                    return false;
                }
                UrlManager.getInstance().dealOneLink(e.this.f61938a.getPageContext(), new String[]{str}, true);
                return true;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends f0<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f61948a;

        public c(e eVar, String str) {
            this.f61948a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // d.a.n0.z0.f0
        public Boolean doInBackground() {
            d.a.o0.e3.n0.a.o(this.f61948a);
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
            e.this.f61939b.L(!((Boolean) customResponsedMessage.getData()).booleanValue());
        }
    }

    /* renamed from: d.a.o0.p1.i.e$e  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnFocusChangeListenerC1529e implements View.OnFocusChangeListener {
        public View$OnFocusChangeListenerC1529e() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (!z) {
                d.a.c.e.p.l.x(e.this.f61938a.getPageContext().getPageActivity(), view);
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
                if (StringUtils.isNull(e.this.f61944g)) {
                    d.a.c.e.p.l.x(e.this.f61938a.getPageContext().getPageActivity(), textView);
                    e.this.x();
                } else {
                    e eVar = e.this;
                    eVar.a(eVar.f61944g, false, 1);
                    TiebaStatic.log(new StatisticItem(PostSearchActivity.FORUM_SEARCH_CLICK).param("obj_name", e.this.f61944g).param("obj_source", "1").param("obj_type", "1"));
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
            if (e.this.f61943f) {
                e.this.f61944g = editable.toString();
                e.this.D();
            }
            e.this.f61939b.r(!StringUtils.isNull(editable.toString()));
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
                e.this.f61938a.finish();
            }
        }

        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != e.this.f61939b.g() || e.this.f61939b.g().getText() == null) {
                if (view == e.this.f61939b.d()) {
                    d.a.c.e.p.l.x(e.this.f61938a.getPageContext().getPageActivity(), e.this.f61939b.g());
                    d.a.c.e.m.e.a().postDelayed(new a(), 1000L);
                    return;
                }
                return;
            }
            e eVar = e.this;
            eVar.f61944g = eVar.f61939b.g().getText().toString();
            if (StringUtils.isNull(e.this.f61944g)) {
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
                TiebaStatic.eventStat(e.this.f61938a.getPageContext().getPageActivity(), "search_bar_result_click", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                TiebaStatic.log(new StatisticItem(PostSearchActivity.FORUM_SEARCH_CLICK).param("obj_name", str).param("obj_source", "2").param("obj_type", "1").param("obj_locate", i2 + 1).param("obj_param1", e.this.f61944g));
            } else if (item instanceof ForumInfo) {
                ForumInfo forumInfo = (ForumInfo) item;
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(e.this.f61938a.getPageContext().getPageActivity()).createNormalCfg(forumInfo.forum_name, FrsActivityConfig.FRS_CALL_SEARCH)));
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
                d.a.c.e.p.l.x(e.this.f61938a.getPageContext().getPageActivity(), absListView);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k implements BaseWebView.e {
        public k(e eVar) {
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.e
        public void onPageFinished(WebView webView, String str) {
            d.a.n0.r.z.a.a("search", -1L, 0, "PageFinished", 0, "", "requesturl", str);
        }
    }

    /* loaded from: classes3.dex */
    public class l implements BaseWebView.h {
        public l(e eVar) {
        }

        @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.h
        public void a(WebView webView, int i2, String str, String str2) {
            d.a.n0.r.z.a.a("search", -1L, 0, "ReceivedError", 0, "", "requesturl", str2, "receiveerror", Integer.valueOf(i2), "description", str);
        }
    }

    public e(BaseActivity baseActivity, boolean z) {
        this.f61938a = baseActivity;
        this.f61941d = z;
        r();
    }

    public void A(List<String> list) {
        this.f61939b.E(list, this.f61944g);
    }

    public void B(List<ForumInfo> list) {
        this.f61939b.F(list, this.f61944g);
    }

    public final void C() {
        this.f61946i.q();
    }

    public final void D() {
        if (!StringUtils.isNull(this.f61944g)) {
            w();
        } else {
            C();
        }
    }

    @Override // d.a.o0.p1.i.b
    public void a(String str, boolean z, int i2) {
        if (!d.a.c.e.p.j.z()) {
            this.f61938a.showToast(R.string.neterror);
        } else if (StringUtils.isNull(str)) {
        } else {
            Matcher matcher = Pattern.compile("^@(.*)@给你分享了贴吧号#(\\d+)#\\s?整段复制后打开贴吧即可找到Ta$", 2).matcher(str);
            if (matcher != null && matcher.find() && !TextUtils.isEmpty(matcher.group(2))) {
                str = matcher.group(2);
            }
            if (z) {
                this.f61943f = false;
                this.f61939b.C(str);
                this.f61943f = true;
            }
            d.a.c.e.p.l.x(this.f61938a.getPageContext().getPageActivity(), this.f61939b.g());
            this.f61939b.y();
            String str2 = "https://tieba.baidu.com/mo/q/hybrid/search?keyword=" + str + "&sub_type=" + i2;
            try {
                str2 = "https://tieba.baidu.com/mo/q/hybrid/search?keyword=" + URLEncoder.encode(str, "utf-8");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.f61939b.f().loadUrl(str2);
            this.f61945h.push(str);
            h0.b(new c(this, str), null);
            this.f61946i.j(str);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921345, str));
        }
    }

    public final void k() {
        this.f61939b.f().h(new UegTbJsBridge(this.f61938a.getPageContext()));
        this.f61939b.f().h(new SearchJsBridge());
    }

    public final void l() {
        k kVar = new k(this);
        l lVar = new l(this);
        a aVar = new a(this);
        b bVar = new b();
        this.f61939b.I(kVar);
        this.f61939b.K(lVar);
        this.f61939b.J(aVar);
        this.f61939b.H(bVar);
    }

    public final void m() {
        i iVar = new i();
        j jVar = new j();
        this.f61939b.t(iVar);
        this.f61939b.u(jVar);
    }

    public void n() {
        View$OnFocusChangeListenerC1529e view$OnFocusChangeListenerC1529e = new View$OnFocusChangeListenerC1529e();
        f fVar = new f();
        g gVar = new g();
        h hVar = new h();
        this.f61939b.A(view$OnFocusChangeListenerC1529e);
        this.f61939b.z(fVar);
        this.f61939b.D(gVar);
        this.f61939b.x(hVar);
    }

    public final void o() {
        if (this.f61939b.n()) {
            return;
        }
        w();
    }

    public View p() {
        return this.f61939b.g();
    }

    public BaseWebView q() {
        return this.f61939b.f();
    }

    public final void r() {
        try {
            View inflate = LayoutInflater.from(this.f61938a).inflate(R.layout.new_home_dialog_search, (ViewGroup) null);
            this.f61940c = inflate;
            this.f61938a.setContentView(inflate);
        } catch (Exception e2) {
            e2.printStackTrace();
            Map<String, String> a2 = d.a.o0.p1.i.a.a();
            if (a2 != null) {
                int size = a2.size();
                int i2 = 0;
                for (String str : a2.keySet()) {
                    d.a.o0.p1.i.a.b(str);
                    try {
                        View inflate2 = LayoutInflater.from(this.f61938a).inflate(R.layout.new_home_dialog_search, (ViewGroup) null);
                        this.f61940c = inflate2;
                        this.f61938a.setContentView(inflate2);
                        break;
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        i2++;
                    }
                }
                if (i2 == size) {
                    this.f61938a.finish();
                    return;
                }
            } else {
                this.f61938a.finish();
                return;
            }
        }
        View view = this.f61940c;
        if (view == null) {
            this.f61938a.finish();
            return;
        }
        d.a.o0.p1.i.d dVar = new d.a.o0.p1.i.d(view, this.f61938a.getPageContext().getPageActivity());
        this.f61939b = dVar;
        this.f61946i = new d.a.o0.p1.i.c(this.f61938a, this, dVar);
        n();
        m();
        l();
        k();
        y();
        D();
        n0.g(this.f61939b.f(), this.f61938a.getUniqueId());
        n0.g(this.f61939b.e(), this.f61938a.getUniqueId());
        this.f61938a.registerListener(this.j);
    }

    public void s(int i2) {
        this.f61939b.o(this.f61938a.getPageContext(), i2);
    }

    public void t() {
        d.a.o0.p1.i.d dVar = this.f61939b;
        if (dVar != null) {
            dVar.p();
        }
        d.a.o0.p1.i.c cVar = this.f61946i;
        if (cVar != null) {
            cVar.r();
        }
    }

    public void u() {
        d.a.o0.p1.i.d dVar = this.f61939b;
        if (dVar != null) {
            dVar.q();
        }
    }

    public void v() {
        d.a.o0.p1.i.d dVar;
        if (this.f61945h.size() > 1) {
            this.f61945h.pop();
            String peek = this.f61945h.peek();
            if (TextUtils.isEmpty(peek) || (dVar = this.f61939b) == null) {
                return;
            }
            boolean z = this.f61943f;
            this.f61943f = false;
            dVar.C(peek);
            this.f61943f = z;
            this.f61939b.y();
            return;
        }
        this.f61945h.clear();
    }

    public final void w() {
        if (StringUtils.isNull(this.f61944g)) {
            C();
            return;
        }
        SearchListNetMessage searchListNetMessage = new SearchListNetMessage();
        searchListNetMessage.mKey = this.f61944g.trim();
        searchListNetMessage.isForum = Integer.valueOf(this.f61941d ? 1 : 0);
        this.f61938a.sendMessage(searchListNetMessage);
    }

    public final void x() {
        HotSearchInfoData hotSearchInfoData = this.f61942e;
        if (hotSearchInfoData == null) {
            BaseActivity baseActivity = this.f61938a;
            baseActivity.showToast(baseActivity.getResources().getString(R.string.write_keyword));
            return;
        }
        if (hotSearchInfoData.x() != 0 && this.f61942e.x() != 2) {
            if (this.f61942e.x() == 1 && !d.a.n0.p0.b.b(this.f61938a.getPageContext())) {
                this.f61938a.sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(this.f61938a.getPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.f61942e.getId()), this.f61942e.getName(), "4")));
            }
        } else {
            a(this.f61942e.getName(), true, 1);
        }
        TiebaStatic.log(new StatisticItem("c10355").param("obj_name", this.f61942e.getName()).param("obj_type", this.f61942e.x() == 0 ? 2 : 1));
    }

    public final void y() {
        d.a.o0.p1.i.d dVar = this.f61939b;
        if (dVar == null) {
            return;
        }
        HotSearchInfoData hotSearchInfoData = this.f61942e;
        if (hotSearchInfoData == null) {
            dVar.B(this.f61938a.getResources().getString(R.string.search_bar));
        } else {
            dVar.B(hotSearchInfoData.w());
        }
    }

    public void z(HotSearchInfoData hotSearchInfoData) {
        this.f61942e = hotSearchInfoData;
        y();
    }
}
