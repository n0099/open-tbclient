package d.b.i0.p0;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import tbclient.BawuThrones;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public w f57357a;

    /* renamed from: b  reason: collision with root package name */
    public BawuThrones f57358b;

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static c f57359a = new c();
    }

    public static c c() {
        return b.f57359a;
    }

    public void a() {
        this.f57358b = null;
        w wVar = this.f57357a;
        if (wVar != null) {
            wVar.g();
        }
        this.f57357a = null;
    }

    public BawuThrones b() {
        return this.f57358b;
    }

    public void d(String str, String str2) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_RECOMMEND);
        httpMessage.addParam("forum_id", str);
        httpMessage.addParam("thread_id", str2);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void e(BawuThrones bawuThrones) {
        this.f57358b = bawuThrones;
    }

    public void f(TbPageContext tbPageContext, String str, String str2) {
        if (this.f57357a == null) {
            this.f57357a = new w();
        }
        this.f57357a.i(tbPageContext, str, str2);
    }

    public c() {
    }
}
