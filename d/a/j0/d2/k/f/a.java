package d.a.j0.d2.k.f;

import android.content.Context;
import android.content.DialogInterface;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.report.UEGReportResponsedMessage;
import d.a.c.a.f;
import d.a.c.a.j;
import d.a.i0.r.f0.c;
/* loaded from: classes3.dex */
public class a implements d.a.j0.l3.a {

    /* renamed from: a  reason: collision with root package name */
    public Context f52667a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f52668b;

    /* renamed from: d  reason: collision with root package name */
    public d.a.i0.r.f0.a f52670d;

    /* renamed from: e  reason: collision with root package name */
    public c f52671e;

    /* renamed from: f  reason: collision with root package name */
    public HttpMessageListener f52672f = new b(CmdConfigHttp.CMD_UEG_REPORT);

    /* renamed from: c  reason: collision with root package name */
    public d.a.j0.d2.k.f.b f52669c = new d.a.j0.d2.k.f.b();

    /* renamed from: d.a.j0.d2.k.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class DialogInterface$OnCancelListenerC1184a implements DialogInterface.OnCancelListener {
        public DialogInterface$OnCancelListenerC1184a() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            MessageManager.getInstance().removeMessage(a.this.f52668b);
        }
    }

    /* loaded from: classes3.dex */
    public class b extends HttpMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof UEGReportResponsedMessage) {
                if (a.this.f52670d != null) {
                    a.this.f52670d.h(false);
                }
                UEGReportResponsedMessage uEGReportResponsedMessage = (UEGReportResponsedMessage) httpResponsedMessage;
                String url = uEGReportResponsedMessage.getUrl();
                if (!StringUtils.isNull(url)) {
                    a.this.h(url);
                    return;
                }
                String errorString = uEGReportResponsedMessage.getErrorString();
                if (StringUtils.isNull(errorString)) {
                    errorString = a.this.f52667a.getString(R.string.neterror);
                }
                a.this.f52671e.b(errorString);
            }
        }
    }

    public a(Context context) {
        this.f52667a = context;
        c cVar = new c();
        this.f52671e = cVar;
        cVar.f48836a = 1000L;
    }

    @Override // d.a.j0.l3.a
    public void a(BdUniqueId bdUniqueId) {
        this.f52668b = bdUniqueId;
        this.f52669c.c(bdUniqueId);
        this.f52672f.setTag(bdUniqueId);
        this.f52672f.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.f52672f);
    }

    @Override // d.a.j0.l3.a
    public void b(String str) {
        j();
        this.f52669c.b(str);
    }

    public final void h(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.f52667a, this.f52667a.getString(R.string.pb_web_view_report_title), str, true)));
    }

    public void i(String str) {
        j();
        this.f52669c.a(str);
    }

    public final void j() {
        if (this.f52670d == null) {
            f<?> a2 = j.a(this.f52667a);
            TbPageContext tbPageContext = a2 instanceof TbPageContext ? (TbPageContext) a2 : null;
            if (tbPageContext == null) {
                return;
            }
            d.a.i0.r.f0.a aVar = new d.a.i0.r.f0.a(tbPageContext);
            this.f52670d = aVar;
            aVar.e(new DialogInterface$OnCancelListenerC1184a());
        }
        this.f52670d.h(true);
    }
}
