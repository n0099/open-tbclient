package d.b.i0.g2;

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
import d.b.h0.r.s.j;
import d.b.h0.r.s.l;
import java.util.ArrayList;
import java.util.List;
import tbclient.SmartApp;
/* loaded from: classes5.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f54985a;

    /* renamed from: b  reason: collision with root package name */
    public Context f54986b;

    /* renamed from: c  reason: collision with root package name */
    public j f54987c;

    /* renamed from: d  reason: collision with root package name */
    public l f54988d;

    /* renamed from: e  reason: collision with root package name */
    public List<d.b.h0.r.s.h> f54989e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.h0.r.s.h f54990f;

    /* renamed from: g  reason: collision with root package name */
    public b f54991g;

    /* renamed from: h  reason: collision with root package name */
    public SmartApp f54992h;
    public l.d i = new a();

    /* loaded from: classes5.dex */
    public class a implements l.d {
        public a() {
        }

        @Override // d.b.h0.r.s.l.d
        public void onClick() {
            if (i.this.f54992h == null) {
                return;
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY);
            httpMessage.addParam("swan_app_key", i.this.f54992h.id);
            MessageManager.getInstance().sendMessage(httpMessage);
            if (i.this.f54991g != null) {
                i.this.f54991g.a(i.this.f54992h.id);
            }
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SMART_APP_HISTORY_DELETE_CLICK);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_id", i.this.f54992h.swan_app_id.longValue());
            statisticItem.param("obj_name", i.this.f54992h.name);
            TiebaStatic.log(statisticItem);
            if (i.this.f54987c != null) {
                i.this.f54987c.dismiss();
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
        this.f54985a = tbPageContext;
        Activity pageActivity = tbPageContext.getPageActivity();
        this.f54986b = pageActivity;
        this.f54988d = new l(pageActivity);
        this.f54989e = new ArrayList();
    }

    public void d(SmartApp smartApp) {
        this.f54992h = smartApp;
    }

    public void e() {
        if (this.f54987c != null) {
            return;
        }
        d.b.h0.r.s.h hVar = new d.b.h0.r.s.h(this.f54986b.getString(R.string.delete), this.f54988d);
        this.f54990f = hVar;
        hVar.m(this.i);
        this.f54989e.add(this.f54990f);
        this.f54988d.k(this.f54989e);
        this.f54987c = new j(this.f54985a, this.f54988d);
    }

    public void f(b bVar) {
        this.f54991g = bVar;
    }

    public void g() {
        j jVar = this.f54987c;
        if (jVar == null) {
            return;
        }
        jVar.l();
    }
}
