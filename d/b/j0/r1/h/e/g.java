package d.b.j0.r1.h.e;

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
    public d.b.j0.r1.h.f.a<Void> f61697a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.j0.r1.h.f.a<Integer> f61698b;

    /* renamed from: d  reason: collision with root package name */
    public Boolean f61700d = Boolean.FALSE;

    /* renamed from: e  reason: collision with root package name */
    public boolean f61701e = false;

    /* renamed from: f  reason: collision with root package name */
    public d.b.c.c.g.a f61702f = new a(CmdConfigHttp.CMD_TAIL_GET, 305001);

    /* renamed from: g  reason: collision with root package name */
    public d.b.c.c.g.a f61703g = new b(CmdConfigHttp.CMD_TAIL_SET, 305104);

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f61704h = new c(2001340);

    /* renamed from: c  reason: collision with root package name */
    public List<TailData> f61699c = new ArrayList();

    /* loaded from: classes3.dex */
    public class a extends d.b.c.c.g.a {
        public a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            d.b.j0.r1.h.a.d resultData;
            if (g.this.f61697a != null) {
                if (responsedMessage instanceof GetTailsHttpResponseMessage) {
                    resultData = ((GetTailsHttpResponseMessage) responsedMessage).getResultData();
                } else {
                    resultData = responsedMessage instanceof GetTailsSocketResponseMessage ? ((GetTailsSocketResponseMessage) responsedMessage).getResultData() : null;
                }
                if (resultData == null) {
                    return;
                }
                g.this.f61699c = new ArrayList();
                if (resultData.b() != null) {
                    for (TailData tailData : resultData.b()) {
                        TailData tailData2 = new TailData();
                        tailData2.setId(tailData.getId());
                        tailData2.setContent(tailData.getContent());
                        tailData2.setFontColor(tailData.getFontColor());
                        tailData2.setFontType(tailData.getFontType());
                        tailData2.setSelected(tailData.isSelected());
                        g.this.f61699c.add(tailData2);
                    }
                }
                g.this.f61697a.a(responsedMessage.hasError(), responsedMessage.getErrorString(), null);
                g.this.q();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends d.b.c.c.g.a {
        public b(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            d.b.j0.r1.h.a.f resultData;
            if (g.this.f61697a != null) {
                if (responsedMessage instanceof SetTailHttpResponseMessage) {
                    resultData = ((SetTailHttpResponseMessage) responsedMessage).getResultData();
                } else {
                    resultData = responsedMessage instanceof SetTailSocketResponseMessage ? ((SetTailSocketResponseMessage) responsedMessage).getResultData() : null;
                }
                g.this.f61698b.a(responsedMessage.hasError(), responsedMessage.getErrorString(), resultData != null ? Integer.valueOf(resultData.a()) : null);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends CustomMessageListener {
        public c(int i) {
            super(i);
        }

        public final void a(d.b.j0.r1.h.a.e eVar) {
            boolean z = false;
            int i = 0;
            while (true) {
                if (i >= g.this.f61699c.size()) {
                    break;
                } else if (((TailData) g.this.f61699c.get(i)).getId() == eVar.f61603b.getId()) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
            if (z) {
                return;
            }
            g.this.f61699c.add(eVar.f61603b);
        }

        public final void b(d.b.j0.r1.h.a.e eVar) {
            boolean z = false;
            for (int i = 0; i < g.this.f61699c.size(); i++) {
                if (((TailData) g.this.f61699c.get(i)).getId() == eVar.f61603b.getId()) {
                    g.this.f61699c.remove(i);
                    if (g.this.f61699c.size() != 0) {
                        Iterator it = g.this.f61699c.iterator();
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

        public final void c(d.b.j0.r1.h.a.e eVar) {
            for (int i = 0; i < g.this.f61699c.size(); i++) {
                if (((TailData) g.this.f61699c.get(i)).getId() == eVar.f61603b.getId()) {
                    ((TailData) g.this.f61699c.get(i)).setContent(eVar.f61603b.getContent());
                    ((TailData) g.this.f61699c.get(i)).setFontColor(eVar.f61603b.getFontColor());
                    ((TailData) g.this.f61699c.get(i)).setSelected(eVar.f61603b.isSelected());
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof d.b.j0.r1.h.a.e)) {
                return;
            }
            d.b.j0.r1.h.a.e eVar = (d.b.j0.r1.h.a.e) customResponsedMessage.getData();
            if (eVar.f61603b == null || g.this.f61699c == null) {
                return;
            }
            int i = eVar.f61602a;
            if (i == 1) {
                a(eVar);
            } else if (i == 3) {
                b(eVar);
            } else if (i == 2) {
                c(eVar);
            }
            g.this.f61697a.a(customResponsedMessage.hasError(), customResponsedMessage.getErrorString(), null);
        }
    }

    public g(Context context) {
        f();
    }

    public final void f() {
        this.f61700d = Boolean.valueOf(TbadkCoreApplication.getCurrentMemberType() != 0);
    }

    public boolean g() {
        return this.f61700d.booleanValue();
    }

    public boolean h() {
        return this.f61701e;
    }

    public List<TailData> i() {
        return this.f61699c;
    }

    public void j() {
        MessageManager.getInstance().sendMessage(new GetTailsNetMessage("stat"));
    }

    public void k() {
        MessageManager.getInstance().registerListener(this.f61702f);
        MessageManager.getInstance().registerListener(this.f61703g);
        MessageManager.getInstance().registerListener(this.f61704h);
    }

    public void l() {
        MessageManager.getInstance().unRegisterListener(this.f61702f);
        MessageManager.getInstance().unRegisterListener(this.f61703g);
        MessageManager.getInstance().unRegisterListener(this.f61704h);
    }

    public void m(boolean z) {
        this.f61701e = z;
    }

    public void n(d.b.j0.r1.h.f.a<Integer> aVar) {
        this.f61698b = aVar;
    }

    public void o(int i, boolean z) {
        MessageManager.getInstance().sendMessage(new SetTailNetMessage(i, z ? 1 : 0));
    }

    public void p(d.b.j0.r1.h.f.a<Void> aVar) {
        this.f61697a = aVar;
    }

    public final void q() {
        boolean z;
        Iterator<TailData> it = this.f61699c.iterator();
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
