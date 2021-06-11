package d.a.n0.e2.k.f;

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
import d.a.m0.r.f0.c;
/* loaded from: classes5.dex */
public class a implements d.a.n0.m3.a {

    /* renamed from: a  reason: collision with root package name */
    public Context f57265a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f57266b;

    /* renamed from: d  reason: collision with root package name */
    public d.a.m0.r.f0.a f57268d;

    /* renamed from: e  reason: collision with root package name */
    public c f57269e;

    /* renamed from: f  reason: collision with root package name */
    public HttpMessageListener f57270f = new b(CmdConfigHttp.CMD_UEG_REPORT);

    /* renamed from: c  reason: collision with root package name */
    public d.a.n0.e2.k.f.b f57267c = new d.a.n0.e2.k.f.b();

    /* renamed from: d.a.n0.e2.k.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class DialogInterface$OnCancelListenerC1330a implements DialogInterface.OnCancelListener {
        public DialogInterface$OnCancelListenerC1330a() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            MessageManager.getInstance().removeMessage(a.this.f57266b);
        }
    }

    /* loaded from: classes5.dex */
    public class b extends HttpMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof UEGReportResponsedMessage) {
                if (a.this.f57268d != null) {
                    a.this.f57268d.h(false);
                }
                UEGReportResponsedMessage uEGReportResponsedMessage = (UEGReportResponsedMessage) httpResponsedMessage;
                String url = uEGReportResponsedMessage.getUrl();
                if (!StringUtils.isNull(url)) {
                    a.this.h(url);
                    return;
                }
                String errorString = uEGReportResponsedMessage.getErrorString();
                if (StringUtils.isNull(errorString)) {
                    errorString = a.this.f57265a.getString(R.string.neterror);
                }
                a.this.f57269e.b(errorString);
            }
        }
    }

    public a(Context context) {
        this.f57265a = context;
        c cVar = new c();
        this.f57269e = cVar;
        cVar.f53384a = 1000L;
    }

    @Override // d.a.n0.m3.a
    public void a(BdUniqueId bdUniqueId) {
        this.f57266b = bdUniqueId;
        this.f57267c.c(bdUniqueId);
        this.f57270f.setTag(bdUniqueId);
        this.f57270f.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.f57270f);
    }

    @Override // d.a.n0.m3.a
    public void b(String str) {
        j();
        this.f57267c.b(str);
    }

    public final void h(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.f57265a, this.f57265a.getString(R.string.pb_web_view_report_title), str, true)));
    }

    public void i(String str) {
        j();
        this.f57267c.a(str);
    }

    public final void j() {
        if (this.f57268d == null) {
            f<?> a2 = j.a(this.f57265a);
            TbPageContext tbPageContext = a2 instanceof TbPageContext ? (TbPageContext) a2 : null;
            if (tbPageContext == null) {
                return;
            }
            d.a.m0.r.f0.a aVar = new d.a.m0.r.f0.a(tbPageContext);
            this.f57268d = aVar;
            aVar.e(new DialogInterface$OnCancelListenerC1330a());
        }
        this.f57268d.h(true);
    }
}
