package d.b.i0.q1.h.e;

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
    public d.b.i0.q1.h.f.a<Void> f59581a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.i0.q1.h.f.a<Integer> f59582b;

    /* renamed from: d  reason: collision with root package name */
    public Boolean f59584d = Boolean.FALSE;

    /* renamed from: e  reason: collision with root package name */
    public boolean f59585e = false;

    /* renamed from: f  reason: collision with root package name */
    public d.b.b.c.g.a f59586f = new a(CmdConfigHttp.CMD_TAIL_GET, 305001);

    /* renamed from: g  reason: collision with root package name */
    public d.b.b.c.g.a f59587g = new b(CmdConfigHttp.CMD_TAIL_SET, 305104);

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f59588h = new c(2001340);

    /* renamed from: c  reason: collision with root package name */
    public List<TailData> f59583c = new ArrayList();

    /* loaded from: classes3.dex */
    public class a extends d.b.b.c.g.a {
        public a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.b.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            d.b.i0.q1.h.a.d resultData;
            if (g.this.f59581a != null) {
                if (responsedMessage instanceof GetTailsHttpResponseMessage) {
                    resultData = ((GetTailsHttpResponseMessage) responsedMessage).getResultData();
                } else {
                    resultData = responsedMessage instanceof GetTailsSocketResponseMessage ? ((GetTailsSocketResponseMessage) responsedMessage).getResultData() : null;
                }
                if (resultData == null) {
                    return;
                }
                g.this.f59583c = new ArrayList();
                if (resultData.b() != null) {
                    for (TailData tailData : resultData.b()) {
                        TailData tailData2 = new TailData();
                        tailData2.setId(tailData.getId());
                        tailData2.setContent(tailData.getContent());
                        tailData2.setFontColor(tailData.getFontColor());
                        tailData2.setFontType(tailData.getFontType());
                        tailData2.setSelected(tailData.isSelected());
                        g.this.f59583c.add(tailData2);
                    }
                }
                g.this.f59581a.a(responsedMessage.hasError(), responsedMessage.getErrorString(), null);
                g.this.q();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends d.b.b.c.g.a {
        public b(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.b.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            d.b.i0.q1.h.a.f resultData;
            if (g.this.f59581a != null) {
                if (responsedMessage instanceof SetTailHttpResponseMessage) {
                    resultData = ((SetTailHttpResponseMessage) responsedMessage).getResultData();
                } else {
                    resultData = responsedMessage instanceof SetTailSocketResponseMessage ? ((SetTailSocketResponseMessage) responsedMessage).getResultData() : null;
                }
                g.this.f59582b.a(responsedMessage.hasError(), responsedMessage.getErrorString(), resultData != null ? Integer.valueOf(resultData.a()) : null);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends CustomMessageListener {
        public c(int i) {
            super(i);
        }

        public final void a(d.b.i0.q1.h.a.e eVar) {
            boolean z = false;
            int i = 0;
            while (true) {
                if (i >= g.this.f59583c.size()) {
                    break;
                } else if (((TailData) g.this.f59583c.get(i)).getId() == eVar.f59487b.getId()) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
            if (z) {
                return;
            }
            g.this.f59583c.add(eVar.f59487b);
        }

        public final void b(d.b.i0.q1.h.a.e eVar) {
            boolean z = false;
            for (int i = 0; i < g.this.f59583c.size(); i++) {
                if (((TailData) g.this.f59583c.get(i)).getId() == eVar.f59487b.getId()) {
                    g.this.f59583c.remove(i);
                    if (g.this.f59583c.size() != 0) {
                        Iterator it = g.this.f59583c.iterator();
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

        public final void c(d.b.i0.q1.h.a.e eVar) {
            for (int i = 0; i < g.this.f59583c.size(); i++) {
                if (((TailData) g.this.f59583c.get(i)).getId() == eVar.f59487b.getId()) {
                    ((TailData) g.this.f59583c.get(i)).setContent(eVar.f59487b.getContent());
                    ((TailData) g.this.f59583c.get(i)).setFontColor(eVar.f59487b.getFontColor());
                    ((TailData) g.this.f59583c.get(i)).setSelected(eVar.f59487b.isSelected());
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof d.b.i0.q1.h.a.e)) {
                return;
            }
            d.b.i0.q1.h.a.e eVar = (d.b.i0.q1.h.a.e) customResponsedMessage.getData();
            if (eVar.f59487b == null || g.this.f59583c == null) {
                return;
            }
            int i = eVar.f59486a;
            if (i == 1) {
                a(eVar);
            } else if (i == 3) {
                b(eVar);
            } else if (i == 2) {
                c(eVar);
            }
            g.this.f59581a.a(customResponsedMessage.hasError(), customResponsedMessage.getErrorString(), null);
        }
    }

    public g(Context context) {
        f();
    }

    public final void f() {
        this.f59584d = Boolean.valueOf(TbadkCoreApplication.getCurrentMemberType() != 0);
    }

    public boolean g() {
        return this.f59584d.booleanValue();
    }

    public boolean h() {
        return this.f59585e;
    }

    public List<TailData> i() {
        return this.f59583c;
    }

    public void j() {
        MessageManager.getInstance().sendMessage(new GetTailsNetMessage("stat"));
    }

    public void k() {
        MessageManager.getInstance().registerListener(this.f59586f);
        MessageManager.getInstance().registerListener(this.f59587g);
        MessageManager.getInstance().registerListener(this.f59588h);
    }

    public void l() {
        MessageManager.getInstance().unRegisterListener(this.f59586f);
        MessageManager.getInstance().unRegisterListener(this.f59587g);
        MessageManager.getInstance().unRegisterListener(this.f59588h);
    }

    public void m(boolean z) {
        this.f59585e = z;
    }

    public void n(d.b.i0.q1.h.f.a<Integer> aVar) {
        this.f59582b = aVar;
    }

    public void o(int i, boolean z) {
        MessageManager.getInstance().sendMessage(new SetTailNetMessage(i, z ? 1 : 0));
    }

    public void p(d.b.i0.q1.h.f.a<Void> aVar) {
        this.f59581a = aVar;
    }

    public final void q() {
        boolean z;
        Iterator<TailData> it = this.f59583c.iterator();
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
