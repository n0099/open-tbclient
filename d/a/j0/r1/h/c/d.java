package d.a.j0.r1.h.c;

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
    public TbPageContext<?> f59809a;

    /* renamed from: d  reason: collision with root package name */
    public d.a.j0.r1.h.f.a<Void> f59812d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.j0.r1.h.f.a<Integer> f59813e;

    /* renamed from: b  reason: collision with root package name */
    public boolean f59810b = false;

    /* renamed from: f  reason: collision with root package name */
    public d.a.c.c.g.a f59814f = new a(CmdConfigHttp.CMD_TAIL_GET, 305001);

    /* renamed from: g  reason: collision with root package name */
    public d.a.c.c.g.a f59815g = new b(CmdConfigHttp.CMD_TAIL_DELETE, 305103);

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f59816h = new c(2001340);

    /* renamed from: c  reason: collision with root package name */
    public List<TailData> f59811c = new ArrayList();

    /* loaded from: classes3.dex */
    public class a extends d.a.c.c.g.a {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            d.a.j0.r1.h.a.d resultData;
            if (d.this.f59812d != null) {
                if (responsedMessage instanceof GetTailsHttpResponseMessage) {
                    resultData = ((GetTailsHttpResponseMessage) responsedMessage).getResultData();
                } else {
                    resultData = responsedMessage instanceof GetTailsSocketResponseMessage ? ((GetTailsSocketResponseMessage) responsedMessage).getResultData() : null;
                }
                if (resultData != null) {
                    d.this.f59811c = resultData.b();
                }
                d.this.f59812d.a(responsedMessage.hasError(), responsedMessage.getErrorString(), null);
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
            d.a.j0.r1.h.a.c resultData;
            if (d.this.f59813e != null) {
                if (responsedMessage instanceof DeleteTailHttpResponseMessage) {
                    resultData = ((DeleteTailHttpResponseMessage) responsedMessage).getResultData();
                } else {
                    resultData = responsedMessage instanceof DeleteTailSocketResponseMessage ? ((DeleteTailSocketResponseMessage) responsedMessage).getResultData() : null;
                }
                d.this.f59813e.a(responsedMessage.hasError(), responsedMessage.getErrorString(), resultData != null ? Integer.valueOf(resultData.a()) : null);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends CustomMessageListener {
        public c(int i2) {
            super(i2);
        }

        public final void a(d.a.j0.r1.h.a.e eVar) {
            boolean z = false;
            int i2 = 0;
            while (true) {
                if (i2 >= d.this.f59811c.size()) {
                    break;
                } else if (((TailData) d.this.f59811c.get(i2)).getId() == eVar.f59756b.getId()) {
                    z = true;
                    break;
                } else {
                    i2++;
                }
            }
            if (z) {
                return;
            }
            d.this.f59811c.add(eVar.f59756b);
        }

        public final void b(d.a.j0.r1.h.a.e eVar) {
            boolean z = false;
            for (int i2 = 0; i2 < d.this.f59811c.size(); i2++) {
                if (((TailData) d.this.f59811c.get(i2)).getId() == eVar.f59756b.getId()) {
                    d.this.f59811c.remove(i2);
                    if (d.this.f59811c.size() != 0) {
                        Iterator it = d.this.f59811c.iterator();
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

        public final void c(d.a.j0.r1.h.a.e eVar) {
            for (int i2 = 0; i2 < d.this.f59811c.size(); i2++) {
                if (((TailData) d.this.f59811c.get(i2)).getId() == eVar.f59756b.getId()) {
                    ((TailData) d.this.f59811c.get(i2)).setContent(eVar.f59756b.getContent());
                    ((TailData) d.this.f59811c.get(i2)).setFontColor(eVar.f59756b.getFontColor());
                    ((TailData) d.this.f59811c.get(i2)).setSelected(eVar.f59756b.isSelected());
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof d.a.j0.r1.h.a.e) || d.this.f59812d == null) {
                return;
            }
            d.a.j0.r1.h.a.e eVar = (d.a.j0.r1.h.a.e) customResponsedMessage.getData();
            if (eVar.f59756b == null || d.this.f59811c == null) {
                return;
            }
            int i2 = eVar.f59755a;
            if (i2 == 1) {
                a(eVar);
            } else if (i2 == 3) {
                b(eVar);
            } else if (i2 == 2) {
                c(eVar);
            }
            d.this.f59812d.a(customResponsedMessage.hasError(), customResponsedMessage.getErrorString(), null);
        }
    }

    public d(TbPageContext<?> tbPageContext) {
        this.f59809a = tbPageContext;
        this.f59809a.registerListener(this.f59814f);
        this.f59809a.registerListener(this.f59815g);
        this.f59809a.registerListener(this.f59816h);
    }

    public void e(int i2) {
        this.f59809a.sendMessage(new DeleteTailNetMessage(i2));
    }

    public int f() {
        return 3 - this.f59811c.size();
    }

    public boolean g() {
        return this.f59810b;
    }

    public List<TailData> h() {
        return this.f59811c;
    }

    public boolean i(Serializable serializable) {
        if (serializable != null && (serializable instanceof TailDataList)) {
            this.f59811c = ((TailDataList) serializable).getTails();
            return true;
        }
        j();
        return false;
    }

    public void j() {
        this.f59809a.sendMessage(new GetTailsNetMessage("stat"));
    }

    public void k(d.a.j0.r1.h.f.a<Integer> aVar) {
        this.f59813e = aVar;
    }

    public void l(boolean z) {
        this.f59810b = z;
    }

    public void m(d.a.j0.r1.h.f.a<Void> aVar) {
        this.f59812d = aVar;
    }

    public void n(List<TailData> list) {
        if (list == null) {
            this.f59811c.clear();
        } else {
            this.f59811c = list;
        }
    }
}
