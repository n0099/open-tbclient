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
    public TbPageContext<?> f59537a;

    /* renamed from: d  reason: collision with root package name */
    public d.b.i0.q1.h.f.a<Void> f59540d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.q1.h.f.a<Integer> f59541e;

    /* renamed from: b  reason: collision with root package name */
    public boolean f59538b = false;

    /* renamed from: f  reason: collision with root package name */
    public d.b.b.c.g.a f59542f = new a(CmdConfigHttp.CMD_TAIL_GET, 305001);

    /* renamed from: g  reason: collision with root package name */
    public d.b.b.c.g.a f59543g = new b(CmdConfigHttp.CMD_TAIL_DELETE, 305103);

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f59544h = new c(2001340);

    /* renamed from: c  reason: collision with root package name */
    public List<TailData> f59539c = new ArrayList();

    /* loaded from: classes3.dex */
    public class a extends d.b.b.c.g.a {
        public a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.b.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            d.b.i0.q1.h.a.d resultData;
            if (d.this.f59540d != null) {
                if (responsedMessage instanceof GetTailsHttpResponseMessage) {
                    resultData = ((GetTailsHttpResponseMessage) responsedMessage).getResultData();
                } else {
                    resultData = responsedMessage instanceof GetTailsSocketResponseMessage ? ((GetTailsSocketResponseMessage) responsedMessage).getResultData() : null;
                }
                if (resultData != null) {
                    d.this.f59539c = resultData.b();
                }
                d.this.f59540d.a(responsedMessage.hasError(), responsedMessage.getErrorString(), null);
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
            if (d.this.f59541e != null) {
                if (responsedMessage instanceof DeleteTailHttpResponseMessage) {
                    resultData = ((DeleteTailHttpResponseMessage) responsedMessage).getResultData();
                } else {
                    resultData = responsedMessage instanceof DeleteTailSocketResponseMessage ? ((DeleteTailSocketResponseMessage) responsedMessage).getResultData() : null;
                }
                d.this.f59541e.a(responsedMessage.hasError(), responsedMessage.getErrorString(), resultData != null ? Integer.valueOf(resultData.a()) : null);
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
                if (i >= d.this.f59539c.size()) {
                    break;
                } else if (((TailData) d.this.f59539c.get(i)).getId() == eVar.f59487b.getId()) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
            if (z) {
                return;
            }
            d.this.f59539c.add(eVar.f59487b);
        }

        public final void b(d.b.i0.q1.h.a.e eVar) {
            boolean z = false;
            for (int i = 0; i < d.this.f59539c.size(); i++) {
                if (((TailData) d.this.f59539c.get(i)).getId() == eVar.f59487b.getId()) {
                    d.this.f59539c.remove(i);
                    if (d.this.f59539c.size() != 0) {
                        Iterator it = d.this.f59539c.iterator();
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
            for (int i = 0; i < d.this.f59539c.size(); i++) {
                if (((TailData) d.this.f59539c.get(i)).getId() == eVar.f59487b.getId()) {
                    ((TailData) d.this.f59539c.get(i)).setContent(eVar.f59487b.getContent());
                    ((TailData) d.this.f59539c.get(i)).setFontColor(eVar.f59487b.getFontColor());
                    ((TailData) d.this.f59539c.get(i)).setSelected(eVar.f59487b.isSelected());
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof d.b.i0.q1.h.a.e) || d.this.f59540d == null) {
                return;
            }
            d.b.i0.q1.h.a.e eVar = (d.b.i0.q1.h.a.e) customResponsedMessage.getData();
            if (eVar.f59487b == null || d.this.f59539c == null) {
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
            d.this.f59540d.a(customResponsedMessage.hasError(), customResponsedMessage.getErrorString(), null);
        }
    }

    public d(TbPageContext<?> tbPageContext) {
        this.f59537a = tbPageContext;
        this.f59537a.registerListener(this.f59542f);
        this.f59537a.registerListener(this.f59543g);
        this.f59537a.registerListener(this.f59544h);
    }

    public void e(int i) {
        this.f59537a.sendMessage(new DeleteTailNetMessage(i));
    }

    public int f() {
        return 3 - this.f59539c.size();
    }

    public boolean g() {
        return this.f59538b;
    }

    public List<TailData> h() {
        return this.f59539c;
    }

    public boolean i(Serializable serializable) {
        if (serializable != null && (serializable instanceof TailDataList)) {
            this.f59539c = ((TailDataList) serializable).getTails();
            return true;
        }
        j();
        return false;
    }

    public void j() {
        this.f59537a.sendMessage(new GetTailsNetMessage("stat"));
    }

    public void k(d.b.i0.q1.h.f.a<Integer> aVar) {
        this.f59541e = aVar;
    }

    public void l(boolean z) {
        this.f59538b = z;
    }

    public void m(d.b.i0.q1.h.f.a<Void> aVar) {
        this.f59540d = aVar;
    }

    public void n(List<TailData> list) {
        if (list == null) {
            this.f59539c.clear();
        } else {
            this.f59539c = list;
        }
    }
}
