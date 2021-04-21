package d.b.j0.q0;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import tbclient.BawuThrones;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public w f59478a;

    /* renamed from: b  reason: collision with root package name */
    public BawuThrones f59479b;

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static c f59480a = new c();
    }

    public static c c() {
        return b.f59480a;
    }

    public void a() {
        this.f59479b = null;
        w wVar = this.f59478a;
        if (wVar != null) {
            wVar.g();
        }
        this.f59478a = null;
    }

    public BawuThrones b() {
        return this.f59479b;
    }

    public void d(String str, String str2) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_RECOMMEND);
        httpMessage.addParam("forum_id", str);
        httpMessage.addParam("thread_id", str2);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void e(BawuThrones bawuThrones) {
        this.f59479b = bawuThrones;
    }

    public void f(TbPageContext tbPageContext, String str, String str2) {
        if (this.f59478a == null) {
            this.f59478a = new w();
        }
        this.f59478a.i(tbPageContext, str, str2);
    }

    public c() {
    }
}
