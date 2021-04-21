package d.b.i0.f;

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
import d.b.c.e.p.j;
import d.b.c.e.p.l;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static a f50908d;

    /* renamed from: a  reason: collision with root package name */
    public CustomMessageListener f50909a = new C1098a(2000994);

    /* renamed from: b  reason: collision with root package name */
    public boolean f50910b = false;

    /* renamed from: c  reason: collision with root package name */
    public HttpMessageListener f50911c = new b(CmdConfigHttp.CMD_CHECK_BAIDU_SIM);

    /* renamed from: d.b.i0.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1098a extends CustomMessageListener {
        public C1098a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && l.C() && j.x()) {
                a.this.c();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends HttpMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003392 && (httpResponsedMessage instanceof CheckBaiduSimResponseMessage)) {
                a.this.f50910b = false;
                CheckBaiduSimResponseMessage checkBaiduSimResponseMessage = (CheckBaiduSimResponseMessage) httpResponsedMessage;
                if (checkBaiduSimResponseMessage.isSuc) {
                    d.b.i0.r.d0.b.j().x("key_baidu_sim_card_writting_tip", checkBaiduSimResponseMessage.isBaiduSim ? TbadkCoreApplication.getInst().getResources().getString(R.string.baidu_sim_traffic_free) : "");
                    MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_CHECK_BAIDU_SIM);
                }
            }
        }
    }

    public static a d() {
        if (f50908d == null) {
            f50908d = new a();
        }
        return f50908d;
    }

    public final void c() {
        if (!TbadkCoreApplication.getInst().isMainProcess(false) || this.f50910b) {
            return;
        }
        this.f50910b = true;
        if (System.currentTimeMillis() >= d.b.i0.r.d0.b.j().l("key_next_check_baidu_sim_time", 0L)) {
            d.b.i0.r.d0.b.j().w("key_next_check_baidu_sim_time", System.currentTimeMillis() + 86400000);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CHECK_BAIDU_SIM, TbConfig.SERVER_ADDRESS + "c/s/holycard");
            tbHttpMessageTask.setResponsedClass(CheckBaiduSimResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            MessageManager.getInstance().registerListener(this.f50911c);
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_CHECK_BAIDU_SIM);
            httpMessage.addParam("localip", UtilHelper.getGprsIpv4Address());
            httpMessage.addParam("network", e());
            MessageManager.getInstance().sendMessage(httpMessage);
            return;
        }
        this.f50910b = false;
    }

    public final String e() {
        int f2 = j.f();
        return f2 != 1 ? f2 != 2 ? f2 != 3 ? RomUtils.UNKNOWN : "TELECOM" : "UNICOM" : "MOBILE";
    }

    public void f() {
        MessageManager.getInstance().registerListener(this.f50909a);
    }
}
