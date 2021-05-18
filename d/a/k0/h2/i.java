package d.a.k0.h2;

import android.app.Activity;
import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import d.a.j0.r.s.j;
import d.a.j0.r.s.l;
import java.util.ArrayList;
import java.util.List;
import tbclient.SmartApp;
/* loaded from: classes5.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f55565a;

    /* renamed from: b  reason: collision with root package name */
    public Context f55566b;

    /* renamed from: c  reason: collision with root package name */
    public j f55567c;

    /* renamed from: d  reason: collision with root package name */
    public l f55568d;

    /* renamed from: e  reason: collision with root package name */
    public List<d.a.j0.r.s.h> f55569e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.j0.r.s.h f55570f;

    /* renamed from: g  reason: collision with root package name */
    public b f55571g;

    /* renamed from: h  reason: collision with root package name */
    public SmartApp f55572h;

    /* renamed from: i  reason: collision with root package name */
    public l.d f55573i = new a();

    /* loaded from: classes5.dex */
    public class a implements l.d {
        public a() {
        }

        @Override // d.a.j0.r.s.l.d
        public void onClick() {
            if (i.this.f55572h == null) {
                return;
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY);
            httpMessage.addParam("swan_app_key", i.this.f55572h.id);
            MessageManager.getInstance().sendMessage(httpMessage);
            if (i.this.f55571g != null) {
                i.this.f55571g.a(i.this.f55572h.id);
            }
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SMART_APP_HISTORY_DELETE_CLICK);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_id", i.this.f55572h.swan_app_id.longValue());
            statisticItem.param("obj_name", i.this.f55572h.name);
            TiebaStatic.log(statisticItem);
            if (i.this.f55567c != null) {
                i.this.f55567c.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(String str);
    }

    static {
        MessageManager.getInstance().registerTask(new TbHttpMessageTask(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY, TbConfig.SERVER_ADDRESS + TbConfig.URL_SMART_APP_DEL_BROWSE_HISTORY));
    }

    public i(TbPageContext tbPageContext) {
        this.f55565a = tbPageContext;
        Activity pageActivity = tbPageContext.getPageActivity();
        this.f55566b = pageActivity;
        this.f55568d = new l(pageActivity);
        this.f55569e = new ArrayList();
    }

    public void d(SmartApp smartApp) {
        this.f55572h = smartApp;
    }

    public void e() {
        if (this.f55567c != null) {
            return;
        }
        d.a.j0.r.s.h hVar = new d.a.j0.r.s.h(this.f55566b.getString(R.string.delete), this.f55568d);
        this.f55570f = hVar;
        hVar.m(this.f55573i);
        this.f55569e.add(this.f55570f);
        this.f55568d.k(this.f55569e);
        this.f55567c = new j(this.f55565a, this.f55568d);
    }

    public void f(b bVar) {
        this.f55571g = bVar;
    }

    public void g() {
        j jVar = this.f55567c;
        if (jVar == null) {
            return;
        }
        jVar.l();
    }
}
