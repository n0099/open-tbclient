package d.a.n0.s1.h.c;

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
    public TbPageContext<?> f60677a;

    /* renamed from: d  reason: collision with root package name */
    public d.a.n0.s1.h.f.a<Void> f60680d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.n0.s1.h.f.a<Integer> f60681e;

    /* renamed from: b  reason: collision with root package name */
    public boolean f60678b = false;

    /* renamed from: f  reason: collision with root package name */
    public d.a.c.c.g.a f60682f = new a(CmdConfigHttp.CMD_TAIL_GET, 305001);

    /* renamed from: g  reason: collision with root package name */
    public d.a.c.c.g.a f60683g = new b(CmdConfigHttp.CMD_TAIL_DELETE, 305103);

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f60684h = new c(2001340);

    /* renamed from: c  reason: collision with root package name */
    public List<TailData> f60679c = new ArrayList();

    /* loaded from: classes3.dex */
    public class a extends d.a.c.c.g.a {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            d.a.n0.s1.h.a.d resultData;
            if (d.this.f60680d != null) {
                if (responsedMessage instanceof GetTailsHttpResponseMessage) {
                    resultData = ((GetTailsHttpResponseMessage) responsedMessage).getResultData();
                } else {
                    resultData = responsedMessage instanceof GetTailsSocketResponseMessage ? ((GetTailsSocketResponseMessage) responsedMessage).getResultData() : null;
                }
                if (resultData != null) {
                    d.this.f60679c = resultData.b();
                }
                d.this.f60680d.a(responsedMessage.hasError(), responsedMessage.getErrorString(), null);
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
            d.a.n0.s1.h.a.c resultData;
            if (d.this.f60681e != null) {
                if (responsedMessage instanceof DeleteTailHttpResponseMessage) {
                    resultData = ((DeleteTailHttpResponseMessage) responsedMessage).getResultData();
                } else {
                    resultData = responsedMessage instanceof DeleteTailSocketResponseMessage ? ((DeleteTailSocketResponseMessage) responsedMessage).getResultData() : null;
                }
                d.this.f60681e.a(responsedMessage.hasError(), responsedMessage.getErrorString(), resultData != null ? Integer.valueOf(resultData.a()) : null);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends CustomMessageListener {
        public c(int i2) {
            super(i2);
        }

        public final void a(d.a.n0.s1.h.a.e eVar) {
            boolean z = false;
            int i2 = 0;
            while (true) {
                if (i2 >= d.this.f60679c.size()) {
                    break;
                } else if (((TailData) d.this.f60679c.get(i2)).getId() == eVar.f60624b.getId()) {
                    z = true;
                    break;
                } else {
                    i2++;
                }
            }
            if (z) {
                return;
            }
            d.this.f60679c.add(eVar.f60624b);
        }

        public final void b(d.a.n0.s1.h.a.e eVar) {
            boolean z = false;
            for (int i2 = 0; i2 < d.this.f60679c.size(); i2++) {
                if (((TailData) d.this.f60679c.get(i2)).getId() == eVar.f60624b.getId()) {
                    d.this.f60679c.remove(i2);
                    if (d.this.f60679c.size() != 0) {
                        Iterator it = d.this.f60679c.iterator();
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

        public final void c(d.a.n0.s1.h.a.e eVar) {
            for (int i2 = 0; i2 < d.this.f60679c.size(); i2++) {
                if (((TailData) d.this.f60679c.get(i2)).getId() == eVar.f60624b.getId()) {
                    ((TailData) d.this.f60679c.get(i2)).setContent(eVar.f60624b.getContent());
                    ((TailData) d.this.f60679c.get(i2)).setFontColor(eVar.f60624b.getFontColor());
                    ((TailData) d.this.f60679c.get(i2)).setSelected(eVar.f60624b.isSelected());
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof d.a.n0.s1.h.a.e) || d.this.f60680d == null) {
                return;
            }
            d.a.n0.s1.h.a.e eVar = (d.a.n0.s1.h.a.e) customResponsedMessage.getData();
            if (eVar.f60624b == null || d.this.f60679c == null) {
                return;
            }
            int i2 = eVar.f60623a;
            if (i2 == 1) {
                a(eVar);
            } else if (i2 == 3) {
                b(eVar);
            } else if (i2 == 2) {
                c(eVar);
            }
            d.this.f60680d.a(customResponsedMessage.hasError(), customResponsedMessage.getErrorString(), null);
        }
    }

    public d(TbPageContext<?> tbPageContext) {
        this.f60677a = tbPageContext;
        this.f60677a.registerListener(this.f60682f);
        this.f60677a.registerListener(this.f60683g);
        this.f60677a.registerListener(this.f60684h);
    }

    public void e(int i2) {
        this.f60677a.sendMessage(new DeleteTailNetMessage(i2));
    }

    public int f() {
        return 3 - this.f60679c.size();
    }

    public boolean g() {
        return this.f60678b;
    }

    public List<TailData> h() {
        return this.f60679c;
    }

    public boolean i(Serializable serializable) {
        if (serializable != null && (serializable instanceof TailDataList)) {
            this.f60679c = ((TailDataList) serializable).getTails();
            return true;
        }
        j();
        return false;
    }

    public void j() {
        this.f60677a.sendMessage(new GetTailsNetMessage("stat"));
    }

    public void k(d.a.n0.s1.h.f.a<Integer> aVar) {
        this.f60681e = aVar;
    }

    public void l(boolean z) {
        this.f60678b = z;
    }

    public void m(d.a.n0.s1.h.f.a<Void> aVar) {
        this.f60680d = aVar;
    }

    public void n(List<TailData> list) {
        if (list == null) {
            this.f60679c.clear();
        } else {
            this.f60679c = list;
        }
    }
}
