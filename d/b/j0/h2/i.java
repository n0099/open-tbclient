package d.b.j0.h2;

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
import d.b.i0.r.s.j;
import d.b.i0.r.s.l;
import java.util.ArrayList;
import java.util.List;
import tbclient.SmartApp;
/* loaded from: classes3.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f56942a;

    /* renamed from: b  reason: collision with root package name */
    public Context f56943b;

    /* renamed from: c  reason: collision with root package name */
    public j f56944c;

    /* renamed from: d  reason: collision with root package name */
    public l f56945d;

    /* renamed from: e  reason: collision with root package name */
    public List<d.b.i0.r.s.h> f56946e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.i0.r.s.h f56947f;

    /* renamed from: g  reason: collision with root package name */
    public b f56948g;

    /* renamed from: h  reason: collision with root package name */
    public SmartApp f56949h;
    public l.d i = new a();

    /* loaded from: classes3.dex */
    public class a implements l.d {
        public a() {
        }

        @Override // d.b.i0.r.s.l.d
        public void onClick() {
            if (i.this.f56949h == null) {
                return;
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY);
            httpMessage.addParam("swan_app_key", i.this.f56949h.id);
            MessageManager.getInstance().sendMessage(httpMessage);
            if (i.this.f56948g != null) {
                i.this.f56948g.a(i.this.f56949h.id);
            }
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SMART_APP_HISTORY_DELETE_CLICK);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_id", i.this.f56949h.swan_app_id.longValue());
            statisticItem.param("obj_name", i.this.f56949h.name);
            TiebaStatic.log(statisticItem);
            if (i.this.f56944c != null) {
                i.this.f56944c.dismiss();
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
        this.f56942a = tbPageContext;
        Activity pageActivity = tbPageContext.getPageActivity();
        this.f56943b = pageActivity;
        this.f56945d = new l(pageActivity);
        this.f56946e = new ArrayList();
    }

    public void d(SmartApp smartApp) {
        this.f56949h = smartApp;
    }

    public void e() {
        if (this.f56944c != null) {
            return;
        }
        d.b.i0.r.s.h hVar = new d.b.i0.r.s.h(this.f56943b.getString(R.string.delete), this.f56945d);
        this.f56947f = hVar;
        hVar.m(this.i);
        this.f56946e.add(this.f56947f);
        this.f56945d.k(this.f56946e);
        this.f56944c = new j(this.f56942a, this.f56945d);
    }

    public void f(b bVar) {
        this.f56948g = bVar;
    }

    public void g() {
        j jVar = this.f56944c;
        if (jVar == null) {
            return;
        }
        jVar.l();
    }
}
