package d.b.i0.h2;

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
/* loaded from: classes3.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f56521a;

    /* renamed from: b  reason: collision with root package name */
    public Context f56522b;

    /* renamed from: c  reason: collision with root package name */
    public j f56523c;

    /* renamed from: d  reason: collision with root package name */
    public l f56524d;

    /* renamed from: e  reason: collision with root package name */
    public List<d.b.h0.r.s.h> f56525e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.h0.r.s.h f56526f;

    /* renamed from: g  reason: collision with root package name */
    public b f56527g;

    /* renamed from: h  reason: collision with root package name */
    public SmartApp f56528h;
    public l.d i = new a();

    /* loaded from: classes3.dex */
    public class a implements l.d {
        public a() {
        }

        @Override // d.b.h0.r.s.l.d
        public void onClick() {
            if (i.this.f56528h == null) {
                return;
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY);
            httpMessage.addParam("swan_app_key", i.this.f56528h.id);
            MessageManager.getInstance().sendMessage(httpMessage);
            if (i.this.f56527g != null) {
                i.this.f56527g.a(i.this.f56528h.id);
            }
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SMART_APP_HISTORY_DELETE_CLICK);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_id", i.this.f56528h.swan_app_id.longValue());
            statisticItem.param("obj_name", i.this.f56528h.name);
            TiebaStatic.log(statisticItem);
            if (i.this.f56523c != null) {
                i.this.f56523c.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(String str);
    }

    static {
        MessageManager.getInstance().registerTask(new TbHttpMessageTask(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY, TbConfig.SERVER_ADDRESS + TbConfig.URL_SMART_APP_DEL_BROWSE_HISTORY));
    }

    public i(TbPageContext tbPageContext) {
        this.f56521a = tbPageContext;
        Activity pageActivity = tbPageContext.getPageActivity();
        this.f56522b = pageActivity;
        this.f56524d = new l(pageActivity);
        this.f56525e = new ArrayList();
    }

    public void d(SmartApp smartApp) {
        this.f56528h = smartApp;
    }

    public void e() {
        if (this.f56523c != null) {
            return;
        }
        d.b.h0.r.s.h hVar = new d.b.h0.r.s.h(this.f56522b.getString(R.string.delete), this.f56524d);
        this.f56526f = hVar;
        hVar.m(this.i);
        this.f56525e.add(this.f56526f);
        this.f56524d.k(this.f56525e);
        this.f56523c = new j(this.f56521a, this.f56524d);
    }

    public void f(b bVar) {
        this.f56527g = bVar;
    }

    public void g() {
        j jVar = this.f56523c;
        if (jVar == null) {
            return;
        }
        jVar.l();
    }
}
