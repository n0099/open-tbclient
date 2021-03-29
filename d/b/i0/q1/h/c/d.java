package d.b.i0.q1.h.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.memberCenter.tail.data.TailData;
import com.baidu.tieba.memberCenter.tail.data.TailDataList;
import com.baidu.tieba.memberCenter.tail.message.DeleteTailHttpResponseMessage;
import com.baidu.tieba.memberCenter.tail.message.DeleteTailNetMessage;
import com.baidu.tieba.memberCenter.tail.message.DeleteTailSocketResponseMessage;
import com.baidu.tieba.memberCenter.tail.message.GetTailsHttpResponseMessage;
import com.baidu.tieba.memberCenter.tail.message.GetTailsNetMessage;
import com.baidu.tieba.memberCenter.tail.message.GetTailsSocketResponseMessage;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f59538a;

    /* renamed from: d  reason: collision with root package name */
    public d.b.i0.q1.h.f.a<Void> f59541d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.q1.h.f.a<Integer> f59542e;

    /* renamed from: b  reason: collision with root package name */
    public boolean f59539b = false;

    /* renamed from: f  reason: collision with root package name */
    public d.b.b.c.g.a f59543f = new a(CmdConfigHttp.CMD_TAIL_GET, 305001);

    /* renamed from: g  reason: collision with root package name */
    public d.b.b.c.g.a f59544g = new b(CmdConfigHttp.CMD_TAIL_DELETE, 305103);

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f59545h = new c(2001340);

    /* renamed from: c  reason: collision with root package name */
    public List<TailData> f59540c = new ArrayList();

    /* loaded from: classes3.dex */
    public class a extends d.b.b.c.g.a {
        public a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.b.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            d.b.i0.q1.h.a.d resultData;
            if (d.this.f59541d != null) {
                if (responsedMessage instanceof GetTailsHttpResponseMessage) {
                    resultData = ((GetTailsHttpResponseMessage) responsedMessage).getResultData();
                } else {
                    resultData = responsedMessage instanceof GetTailsSocketResponseMessage ? ((GetTailsSocketResponseMessage) responsedMessage).getResultData() : null;
                }
                if (resultData != null) {
                    d.this.f59540c = resultData.b();
                }
                d.this.f59541d.a(responsedMessage.hasError(), responsedMessage.getErrorString(), null);
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
            d.b.i0.q1.h.a.c resultData;
            if (d.this.f59542e != null) {
                if (responsedMessage instanceof DeleteTailHttpResponseMessage) {
                    resultData = ((DeleteTailHttpResponseMessage) responsedMessage).getResultData();
                } else {
                    resultData = responsedMessage instanceof DeleteTailSocketResponseMessage ? ((DeleteTailSocketResponseMessage) responsedMessage).getResultData() : null;
                }
                d.this.f59542e.a(responsedMessage.hasError(), responsedMessage.getErrorString(), resultData != null ? Integer.valueOf(resultData.a()) : null);
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
                if (i >= d.this.f59540c.size()) {
                    break;
                } else if (((TailData) d.this.f59540c.get(i)).getId() == eVar.f59488b.getId()) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
            if (z) {
                return;
            }
            d.this.f59540c.add(eVar.f59488b);
        }

        public final void b(d.b.i0.q1.h.a.e eVar) {
            boolean z = false;
            for (int i = 0; i < d.this.f59540c.size(); i++) {
                if (((TailData) d.this.f59540c.get(i)).getId() == eVar.f59488b.getId()) {
                    d.this.f59540c.remove(i);
                    if (d.this.f59540c.size() != 0) {
                        Iterator it = d.this.f59540c.iterator();
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
            for (int i = 0; i < d.this.f59540c.size(); i++) {
                if (((TailData) d.this.f59540c.get(i)).getId() == eVar.f59488b.getId()) {
                    ((TailData) d.this.f59540c.get(i)).setContent(eVar.f59488b.getContent());
                    ((TailData) d.this.f59540c.get(i)).setFontColor(eVar.f59488b.getFontColor());
                    ((TailData) d.this.f59540c.get(i)).setSelected(eVar.f59488b.isSelected());
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof d.b.i0.q1.h.a.e) || d.this.f59541d == null) {
                return;
            }
            d.b.i0.q1.h.a.e eVar = (d.b.i0.q1.h.a.e) customResponsedMessage.getData();
            if (eVar.f59488b == null || d.this.f59540c == null) {
                return;
            }
            int i = eVar.f59487a;
            if (i == 1) {
                a(eVar);
            } else if (i == 3) {
                b(eVar);
            } else if (i == 2) {
                c(eVar);
            }
            d.this.f59541d.a(customResponsedMessage.hasError(), customResponsedMessage.getErrorString(), null);
        }
    }

    public d(TbPageContext<?> tbPageContext) {
        this.f59538a = tbPageContext;
        this.f59538a.registerListener(this.f59543f);
        this.f59538a.registerListener(this.f59544g);
        this.f59538a.registerListener(this.f59545h);
    }

    public void e(int i) {
        this.f59538a.sendMessage(new DeleteTailNetMessage(i));
    }

    public int f() {
        return 3 - this.f59540c.size();
    }

    public boolean g() {
        return this.f59539b;
    }

    public List<TailData> h() {
        return this.f59540c;
    }

    public boolean i(Serializable serializable) {
        if (serializable != null && (serializable instanceof TailDataList)) {
            this.f59540c = ((TailDataList) serializable).getTails();
            return true;
        }
        j();
        return false;
    }

    public void j() {
        this.f59538a.sendMessage(new GetTailsNetMessage("stat"));
    }

    public void k(d.b.i0.q1.h.f.a<Integer> aVar) {
        this.f59542e = aVar;
    }

    public void l(boolean z) {
        this.f59539b = z;
    }

    public void m(d.b.i0.q1.h.f.a<Void> aVar) {
        this.f59541d = aVar;
    }

    public void n(List<TailData> list) {
        if (list == null) {
            this.f59540c.clear();
        } else {
            this.f59540c = list;
        }
    }
}
