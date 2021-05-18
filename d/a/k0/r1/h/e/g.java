package d.a.k0.r1.h.e;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.memberCenter.tail.data.TailData;
import com.baidu.tieba.memberCenter.tail.message.GetTailsHttpResponseMessage;
import com.baidu.tieba.memberCenter.tail.message.GetTailsNetMessage;
import com.baidu.tieba.memberCenter.tail.message.GetTailsSocketResponseMessage;
import com.baidu.tieba.memberCenter.tail.message.SetTailHttpResponseMessage;
import com.baidu.tieba.memberCenter.tail.message.SetTailNetMessage;
import com.baidu.tieba.memberCenter.tail.message.SetTailSocketResponseMessage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public d.a.k0.r1.h.f.a<Void> f60599a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.k0.r1.h.f.a<Integer> f60600b;

    /* renamed from: d  reason: collision with root package name */
    public Boolean f60602d = Boolean.FALSE;

    /* renamed from: e  reason: collision with root package name */
    public boolean f60603e = false;

    /* renamed from: f  reason: collision with root package name */
    public d.a.c.c.g.a f60604f = new a(CmdConfigHttp.CMD_TAIL_GET, 305001);

    /* renamed from: g  reason: collision with root package name */
    public d.a.c.c.g.a f60605g = new b(CmdConfigHttp.CMD_TAIL_SET, 305104);

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f60606h = new c(2001340);

    /* renamed from: c  reason: collision with root package name */
    public List<TailData> f60601c = new ArrayList();

    /* loaded from: classes3.dex */
    public class a extends d.a.c.c.g.a {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            d.a.k0.r1.h.a.d resultData;
            if (g.this.f60599a != null) {
                if (responsedMessage instanceof GetTailsHttpResponseMessage) {
                    resultData = ((GetTailsHttpResponseMessage) responsedMessage).getResultData();
                } else {
                    resultData = responsedMessage instanceof GetTailsSocketResponseMessage ? ((GetTailsSocketResponseMessage) responsedMessage).getResultData() : null;
                }
                if (resultData == null) {
                    return;
                }
                g.this.f60601c = new ArrayList();
                if (resultData.b() != null) {
                    for (TailData tailData : resultData.b()) {
                        TailData tailData2 = new TailData();
                        tailData2.setId(tailData.getId());
                        tailData2.setContent(tailData.getContent());
                        tailData2.setFontColor(tailData.getFontColor());
                        tailData2.setFontType(tailData.getFontType());
                        tailData2.setSelected(tailData.isSelected());
                        g.this.f60601c.add(tailData2);
                    }
                }
                g.this.f60599a.a(responsedMessage.hasError(), responsedMessage.getErrorString(), null);
                g.this.q();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends d.a.c.c.g.a {
        public b(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            d.a.k0.r1.h.a.f resultData;
            if (g.this.f60599a != null) {
                if (responsedMessage instanceof SetTailHttpResponseMessage) {
                    resultData = ((SetTailHttpResponseMessage) responsedMessage).getResultData();
                } else {
                    resultData = responsedMessage instanceof SetTailSocketResponseMessage ? ((SetTailSocketResponseMessage) responsedMessage).getResultData() : null;
                }
                g.this.f60600b.a(responsedMessage.hasError(), responsedMessage.getErrorString(), resultData != null ? Integer.valueOf(resultData.a()) : null);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends CustomMessageListener {
        public c(int i2) {
            super(i2);
        }

        public final void a(d.a.k0.r1.h.a.e eVar) {
            boolean z = false;
            int i2 = 0;
            while (true) {
                if (i2 >= g.this.f60601c.size()) {
                    break;
                } else if (((TailData) g.this.f60601c.get(i2)).getId() == eVar.f60501b.getId()) {
                    z = true;
                    break;
                } else {
                    i2++;
                }
            }
            if (z) {
                return;
            }
            g.this.f60601c.add(eVar.f60501b);
        }

        public final void b(d.a.k0.r1.h.a.e eVar) {
            boolean z = false;
            for (int i2 = 0; i2 < g.this.f60601c.size(); i2++) {
                if (((TailData) g.this.f60601c.get(i2)).getId() == eVar.f60501b.getId()) {
                    g.this.f60601c.remove(i2);
                    if (g.this.f60601c.size() != 0) {
                        Iterator it = g.this.f60601c.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (((TailData) it.next()).isSelected()) {
                                    z = true;
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001344, Boolean.valueOf(z)));
                    return;
                }
            }
        }

        public final void c(d.a.k0.r1.h.a.e eVar) {
            for (int i2 = 0; i2 < g.this.f60601c.size(); i2++) {
                if (((TailData) g.this.f60601c.get(i2)).getId() == eVar.f60501b.getId()) {
                    ((TailData) g.this.f60601c.get(i2)).setContent(eVar.f60501b.getContent());
                    ((TailData) g.this.f60601c.get(i2)).setFontColor(eVar.f60501b.getFontColor());
                    ((TailData) g.this.f60601c.get(i2)).setSelected(eVar.f60501b.isSelected());
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof d.a.k0.r1.h.a.e)) {
                return;
            }
            d.a.k0.r1.h.a.e eVar = (d.a.k0.r1.h.a.e) customResponsedMessage.getData();
            if (eVar.f60501b == null || g.this.f60601c == null) {
                return;
            }
            int i2 = eVar.f60500a;
            if (i2 == 1) {
                a(eVar);
            } else if (i2 == 3) {
                b(eVar);
            } else if (i2 == 2) {
                c(eVar);
            }
            g.this.f60599a.a(customResponsedMessage.hasError(), customResponsedMessage.getErrorString(), null);
        }
    }

    public g(Context context) {
        f();
    }

    public final void f() {
        this.f60602d = Boolean.valueOf(TbadkCoreApplication.getCurrentMemberType() != 0);
    }

    public boolean g() {
        return this.f60602d.booleanValue();
    }

    public boolean h() {
        return this.f60603e;
    }

    public List<TailData> i() {
        return this.f60601c;
    }

    public void j() {
        MessageManager.getInstance().sendMessage(new GetTailsNetMessage("stat"));
    }

    public void k() {
        MessageManager.getInstance().registerListener(this.f60604f);
        MessageManager.getInstance().registerListener(this.f60605g);
        MessageManager.getInstance().registerListener(this.f60606h);
    }

    public void l() {
        MessageManager.getInstance().unRegisterListener(this.f60604f);
        MessageManager.getInstance().unRegisterListener(this.f60605g);
        MessageManager.getInstance().unRegisterListener(this.f60606h);
    }

    public void m(boolean z) {
        this.f60603e = z;
    }

    public void n(d.a.k0.r1.h.f.a<Integer> aVar) {
        this.f60600b = aVar;
    }

    public void o(int i2, boolean z) {
        MessageManager.getInstance().sendMessage(new SetTailNetMessage(i2, z ? 1 : 0));
    }

    public void p(d.a.k0.r1.h.f.a<Void> aVar) {
        this.f60599a = aVar;
    }

    public final void q() {
        boolean z;
        Iterator<TailData> it = this.f60601c.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            } else if (it.next().isSelected()) {
                z = true;
                break;
            }
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001344, Boolean.valueOf(z)));
    }
}
