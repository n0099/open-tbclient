package d.a.m0.f;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.CheckBaiduSimResponseMessage;
import com.baidu.tieba.R;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static a f53033d;

    /* renamed from: a  reason: collision with root package name */
    public CustomMessageListener f53034a = new C1178a(2000994);

    /* renamed from: b  reason: collision with root package name */
    public boolean f53035b = false;

    /* renamed from: c  reason: collision with root package name */
    public HttpMessageListener f53036c = new b(CmdConfigHttp.CMD_CHECK_BAIDU_SIM);

    /* renamed from: d.a.m0.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1178a extends CustomMessageListener {
        public C1178a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && l.D() && j.x()) {
                a.this.c();
            }
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
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003392 && (httpResponsedMessage instanceof CheckBaiduSimResponseMessage)) {
                a.this.f53035b = false;
                CheckBaiduSimResponseMessage checkBaiduSimResponseMessage = (CheckBaiduSimResponseMessage) httpResponsedMessage;
                if (checkBaiduSimResponseMessage.isSuc) {
                    d.a.m0.r.d0.b.j().x("key_baidu_sim_card_writting_tip", checkBaiduSimResponseMessage.isBaiduSim ? TbadkCoreApplication.getInst().getResources().getString(R.string.baidu_sim_traffic_free) : "");
                    MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_CHECK_BAIDU_SIM);
                }
            }
        }
    }

    public static a d() {
        if (f53033d == null) {
            f53033d = new a();
        }
        return f53033d;
    }

    public final void c() {
        if (!TbadkCoreApplication.getInst().isMainProcess(false) || this.f53035b) {
            return;
        }
        this.f53035b = true;
        if (System.currentTimeMillis() >= d.a.m0.r.d0.b.j().l("key_next_check_baidu_sim_time", 0L)) {
            d.a.m0.r.d0.b.j().w("key_next_check_baidu_sim_time", System.currentTimeMillis() + 86400000);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CHECK_BAIDU_SIM, TbConfig.SERVER_ADDRESS + "c/s/holycard");
            tbHttpMessageTask.setResponsedClass(CheckBaiduSimResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            MessageManager.getInstance().registerListener(this.f53036c);
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_CHECK_BAIDU_SIM);
            httpMessage.addParam("localip", UtilHelper.getGprsIpv4Address());
            httpMessage.addParam("network", e());
            MessageManager.getInstance().sendMessage(httpMessage);
            return;
        }
        this.f53035b = false;
    }

    public final String e() {
        int f2 = j.f();
        return f2 != 1 ? f2 != 2 ? f2 != 3 ? RomUtils.UNKNOWN : "TELECOM" : "UNICOM" : "MOBILE";
    }

    public void f() {
        MessageManager.getInstance().registerListener(this.f53034a);
    }
}
