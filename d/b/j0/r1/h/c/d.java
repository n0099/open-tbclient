package d.b.j0.r1.h.c;

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
    public TbPageContext<?> f61653a;

    /* renamed from: d  reason: collision with root package name */
    public d.b.j0.r1.h.f.a<Void> f61656d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.j0.r1.h.f.a<Integer> f61657e;

    /* renamed from: b  reason: collision with root package name */
    public boolean f61654b = false;

    /* renamed from: f  reason: collision with root package name */
    public d.b.c.c.g.a f61658f = new a(CmdConfigHttp.CMD_TAIL_GET, 305001);

    /* renamed from: g  reason: collision with root package name */
    public d.b.c.c.g.a f61659g = new b(CmdConfigHttp.CMD_TAIL_DELETE, 305103);

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f61660h = new c(2001340);

    /* renamed from: c  reason: collision with root package name */
    public List<TailData> f61655c = new ArrayList();

    /* loaded from: classes3.dex */
    public class a extends d.b.c.c.g.a {
        public a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            d.b.j0.r1.h.a.d resultData;
            if (d.this.f61656d != null) {
                if (responsedMessage instanceof GetTailsHttpResponseMessage) {
                    resultData = ((GetTailsHttpResponseMessage) responsedMessage).getResultData();
                } else {
                    resultData = responsedMessage instanceof GetTailsSocketResponseMessage ? ((GetTailsSocketResponseMessage) responsedMessage).getResultData() : null;
                }
                if (resultData != null) {
                    d.this.f61655c = resultData.b();
                }
                d.this.f61656d.a(responsedMessage.hasError(), responsedMessage.getErrorString(), null);
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
            d.b.j0.r1.h.a.c resultData;
            if (d.this.f61657e != null) {
                if (responsedMessage instanceof DeleteTailHttpResponseMessage) {
                    resultData = ((DeleteTailHttpResponseMessage) responsedMessage).getResultData();
                } else {
                    resultData = responsedMessage instanceof DeleteTailSocketResponseMessage ? ((DeleteTailSocketResponseMessage) responsedMessage).getResultData() : null;
                }
                d.this.f61657e.a(responsedMessage.hasError(), responsedMessage.getErrorString(), resultData != null ? Integer.valueOf(resultData.a()) : null);
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
                if (i >= d.this.f61655c.size()) {
                    break;
                } else if (((TailData) d.this.f61655c.get(i)).getId() == eVar.f61603b.getId()) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
            if (z) {
                return;
            }
            d.this.f61655c.add(eVar.f61603b);
        }

        public final void b(d.b.j0.r1.h.a.e eVar) {
            boolean z = false;
            for (int i = 0; i < d.this.f61655c.size(); i++) {
                if (((TailData) d.this.f61655c.get(i)).getId() == eVar.f61603b.getId()) {
                    d.this.f61655c.remove(i);
                    if (d.this.f61655c.size() != 0) {
                        Iterator it = d.this.f61655c.iterator();
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
            for (int i = 0; i < d.this.f61655c.size(); i++) {
                if (((TailData) d.this.f61655c.get(i)).getId() == eVar.f61603b.getId()) {
                    ((TailData) d.this.f61655c.get(i)).setContent(eVar.f61603b.getContent());
                    ((TailData) d.this.f61655c.get(i)).setFontColor(eVar.f61603b.getFontColor());
                    ((TailData) d.this.f61655c.get(i)).setSelected(eVar.f61603b.isSelected());
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof d.b.j0.r1.h.a.e) || d.this.f61656d == null) {
                return;
            }
            d.b.j0.r1.h.a.e eVar = (d.b.j0.r1.h.a.e) customResponsedMessage.getData();
            if (eVar.f61603b == null || d.this.f61655c == null) {
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
            d.this.f61656d.a(customResponsedMessage.hasError(), customResponsedMessage.getErrorString(), null);
        }
    }

    public d(TbPageContext<?> tbPageContext) {
        this.f61653a = tbPageContext;
        this.f61653a.registerListener(this.f61658f);
        this.f61653a.registerListener(this.f61659g);
        this.f61653a.registerListener(this.f61660h);
    }

    public void e(int i) {
        this.f61653a.sendMessage(new DeleteTailNetMessage(i));
    }

    public int f() {
        return 3 - this.f61655c.size();
    }

    public boolean g() {
        return this.f61654b;
    }

    public List<TailData> h() {
        return this.f61655c;
    }

    public boolean i(Serializable serializable) {
        if (serializable != null && (serializable instanceof TailDataList)) {
            this.f61655c = ((TailDataList) serializable).getTails();
            return true;
        }
        j();
        return false;
    }

    public void j() {
        this.f61653a.sendMessage(new GetTailsNetMessage("stat"));
    }

    public void k(d.b.j0.r1.h.f.a<Integer> aVar) {
        this.f61657e = aVar;
    }

    public void l(boolean z) {
        this.f61654b = z;
    }

    public void m(d.b.j0.r1.h.f.a<Void> aVar) {
        this.f61656d = aVar;
    }

    public void n(List<TailData> list) {
        if (list == null) {
            this.f61655c.clear();
        } else {
            this.f61655c = list;
        }
    }
}
