package d.a.j0.e2.c;

import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.pass.ecommerce.bean.SuggestAddrField;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.pbextra.praise.PraiseListResponsedMessage;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f53949a;

    /* renamed from: b  reason: collision with root package name */
    public String f53950b;

    /* renamed from: c  reason: collision with root package name */
    public String f53951c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f53952d;

    /* renamed from: e  reason: collision with root package name */
    public int f53953e;

    /* renamed from: f  reason: collision with root package name */
    public int f53954f;

    /* renamed from: g  reason: collision with root package name */
    public int f53955g;

    /* renamed from: h  reason: collision with root package name */
    public final List<d.a.j0.e2.c.a> f53956h;

    /* renamed from: i  reason: collision with root package name */
    public b f53957i;
    public final HttpMessageListener j;

    /* loaded from: classes3.dex */
    public class a extends HttpMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001400) {
                if (d.this.f53957i != null) {
                    d.this.f53957i.onLoadFailed(null);
                }
            } else if (httpResponsedMessage.getError() != 0 || !(httpResponsedMessage instanceof PraiseListResponsedMessage)) {
                if (d.this.f53957i != null) {
                    d.this.f53957i.onLoadFailed(null);
                }
            } else {
                PraiseListResponsedMessage praiseListResponsedMessage = (PraiseListResponsedMessage) httpResponsedMessage;
                if (praiseListResponsedMessage.getError() != 0) {
                    if (d.this.f53957i != null) {
                        d.this.f53957i.onLoadFailed(praiseListResponsedMessage.getErrMsg());
                        return;
                    }
                    return;
                }
                List<d.a.j0.e2.c.a> list = praiseListResponsedMessage.getmZanItemDataList();
                if (list != null) {
                    for (d.a.j0.e2.c.a aVar : list) {
                        d.this.f53956h.add(aVar);
                    }
                }
                d dVar = d.this;
                dVar.f53955g = dVar.f53956h.size();
                d.this.f53954f = praiseListResponsedMessage.getTotalNum();
                d.h(d.this);
                int i2 = d.this.f53953e > 5 ? 1003 : 1001;
                if (d.this.f53955g >= d.this.f53954f) {
                    i2 = 1002;
                }
                if (d.this.f53957i != null) {
                    d.this.f53957i.onLoadSuccessed(d.this.f53954f, d.this.f53956h, i2, d.this.f53954f - d.this.f53955g);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void onLoadFailed(String str);

        void onLoadSuccessed(int i2, List<d.a.j0.e2.c.a> list, int i3, int i4);
    }

    public d() {
        this.f53949a = "";
        this.f53950b = "";
        this.f53951c = "";
        this.f53952d = true;
        this.f53953e = 1;
        this.f53954f = 0;
        this.f53955g = 0;
        this.f53956h = new ArrayList(100);
        this.f53957i = null;
        this.j = new a(CmdConfigHttp.PRAISE_LIST_HTTP_CMD);
        this.f53949a = "";
        this.f53950b = "";
    }

    public static /* synthetic */ int h(d dVar) {
        int i2 = dVar.f53953e;
        dVar.f53953e = i2 + 1;
        return i2;
    }

    public String i() {
        return this.f53951c;
    }

    public d.a.j0.e2.c.a j(int i2) {
        if (i2 <= -1 || i2 >= this.f53956h.size()) {
            return null;
        }
        return this.f53956h.get(i2);
    }

    public String k() {
        return this.f53949a;
    }

    public boolean l() {
        return this.f53952d;
    }

    public void m(int i2) {
        n();
    }

    public final void n() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PRAISE_LIST_HTTP_CMD);
        httpMessage.addParam("post_id", this.f53950b + "");
        httpMessage.addParam(SuggestAddrField.KEY_PAGE_NUM, this.f53953e + "");
        httpMessage.addParam("res_num", "20");
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void o(Bundle bundle, String str) {
        bundle.putBoolean(str, this.f53952d);
    }

    public void p(Bundle bundle, String str) {
        bundle.putString(str, this.f53951c);
    }

    public void q(Bundle bundle, String str) {
        bundle.putString(str, this.f53950b);
    }

    public void r(Bundle bundle, String str) {
        bundle.putInt(str, this.f53954f);
    }

    public void s(Bundle bundle, String str) {
        bundle.putString(str, this.f53949a);
    }

    public void t(boolean z) {
    }

    public void u(int i2) {
        this.f53954f = i2;
    }

    public void v() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.unRegisterListener(this.j);
        messageManager.unRegisterTask(CmdConfigHttp.CMD_GRAFFITI_LIST);
        messageManager.unRegisterTask(309326);
    }

    public d(String str, String str2, String str3, boolean z, b bVar) {
        this.f53949a = "";
        this.f53950b = "";
        this.f53951c = "";
        this.f53952d = true;
        this.f53953e = 1;
        this.f53954f = 0;
        this.f53955g = 0;
        this.f53956h = new ArrayList(100);
        this.f53957i = null;
        this.j = new a(CmdConfigHttp.PRAISE_LIST_HTTP_CMD);
        this.f53949a = str;
        this.f53950b = str2;
        this.f53951c = str3;
        this.f53957i = bVar;
        this.f53952d = z;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PRAISE_LIST_HTTP_CMD, TbConfig.SERVER_ADDRESS + "c/u/zan/getuserlist");
        tbHttpMessageTask.setResponsedClass(PraiseListResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.j);
    }
}
