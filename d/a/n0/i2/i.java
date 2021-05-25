package d.a.n0.i2;

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
import d.a.m0.r.s.j;
import d.a.m0.r.s.l;
import java.util.ArrayList;
import java.util.List;
import tbclient.SmartApp;
/* loaded from: classes5.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f55753a;

    /* renamed from: b  reason: collision with root package name */
    public Context f55754b;

    /* renamed from: c  reason: collision with root package name */
    public j f55755c;

    /* renamed from: d  reason: collision with root package name */
    public l f55756d;

    /* renamed from: e  reason: collision with root package name */
    public List<d.a.m0.r.s.h> f55757e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.m0.r.s.h f55758f;

    /* renamed from: g  reason: collision with root package name */
    public b f55759g;

    /* renamed from: h  reason: collision with root package name */
    public SmartApp f55760h;

    /* renamed from: i  reason: collision with root package name */
    public l.d f55761i = new a();

    /* loaded from: classes5.dex */
    public class a implements l.d {
        public a() {
        }

        @Override // d.a.m0.r.s.l.d
        public void onClick() {
            if (i.this.f55760h == null) {
                return;
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY);
            httpMessage.addParam("swan_app_key", i.this.f55760h.id);
            MessageManager.getInstance().sendMessage(httpMessage);
            if (i.this.f55759g != null) {
                i.this.f55759g.a(i.this.f55760h.id);
            }
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SMART_APP_HISTORY_DELETE_CLICK);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_id", i.this.f55760h.swan_app_id.longValue());
            statisticItem.param("obj_name", i.this.f55760h.name);
            TiebaStatic.log(statisticItem);
            if (i.this.f55755c != null) {
                i.this.f55755c.dismiss();
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
        this.f55753a = tbPageContext;
        Activity pageActivity = tbPageContext.getPageActivity();
        this.f55754b = pageActivity;
        this.f55756d = new l(pageActivity);
        this.f55757e = new ArrayList();
    }

    public void d(SmartApp smartApp) {
        this.f55760h = smartApp;
    }

    public void e() {
        if (this.f55755c != null) {
            return;
        }
        d.a.m0.r.s.h hVar = new d.a.m0.r.s.h(this.f55754b.getString(R.string.delete), this.f55756d);
        this.f55758f = hVar;
        hVar.m(this.f55761i);
        this.f55757e.add(this.f55758f);
        this.f55756d.k(this.f55757e);
        this.f55755c = new j(this.f55753a, this.f55756d);
    }

    public void f(b bVar) {
        this.f55759g = bVar;
    }

    public void g() {
        j jVar = this.f55755c;
        if (jVar == null) {
            return;
        }
        jVar.l();
    }
}
