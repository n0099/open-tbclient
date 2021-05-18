package d.a.k0.r1.h.c;

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
    public TbPageContext<?> f60554a;

    /* renamed from: d  reason: collision with root package name */
    public d.a.k0.r1.h.f.a<Void> f60557d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.k0.r1.h.f.a<Integer> f60558e;

    /* renamed from: b  reason: collision with root package name */
    public boolean f60555b = false;

    /* renamed from: f  reason: collision with root package name */
    public d.a.c.c.g.a f60559f = new a(CmdConfigHttp.CMD_TAIL_GET, 305001);

    /* renamed from: g  reason: collision with root package name */
    public d.a.c.c.g.a f60560g = new b(CmdConfigHttp.CMD_TAIL_DELETE, 305103);

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f60561h = new c(2001340);

    /* renamed from: c  reason: collision with root package name */
    public List<TailData> f60556c = new ArrayList();

    /* loaded from: classes3.dex */
    public class a extends d.a.c.c.g.a {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            d.a.k0.r1.h.a.d resultData;
            if (d.this.f60557d != null) {
                if (responsedMessage instanceof GetTailsHttpResponseMessage) {
                    resultData = ((GetTailsHttpResponseMessage) responsedMessage).getResultData();
                } else {
                    resultData = responsedMessage instanceof GetTailsSocketResponseMessage ? ((GetTailsSocketResponseMessage) responsedMessage).getResultData() : null;
                }
                if (resultData != null) {
                    d.this.f60556c = resultData.b();
                }
                d.this.f60557d.a(responsedMessage.hasError(), responsedMessage.getErrorString(), null);
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
            d.a.k0.r1.h.a.c resultData;
            if (d.this.f60558e != null) {
                if (responsedMessage instanceof DeleteTailHttpResponseMessage) {
                    resultData = ((DeleteTailHttpResponseMessage) responsedMessage).getResultData();
                } else {
                    resultData = responsedMessage instanceof DeleteTailSocketResponseMessage ? ((DeleteTailSocketResponseMessage) responsedMessage).getResultData() : null;
                }
                d.this.f60558e.a(responsedMessage.hasError(), responsedMessage.getErrorString(), resultData != null ? Integer.valueOf(resultData.a()) : null);
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
                if (i2 >= d.this.f60556c.size()) {
                    break;
                } else if (((TailData) d.this.f60556c.get(i2)).getId() == eVar.f60501b.getId()) {
                    z = true;
                    break;
                } else {
                    i2++;
                }
            }
            if (z) {
                return;
            }
            d.this.f60556c.add(eVar.f60501b);
        }

        public final void b(d.a.k0.r1.h.a.e eVar) {
            boolean z = false;
            for (int i2 = 0; i2 < d.this.f60556c.size(); i2++) {
                if (((TailData) d.this.f60556c.get(i2)).getId() == eVar.f60501b.getId()) {
                    d.this.f60556c.remove(i2);
                    if (d.this.f60556c.size() != 0) {
                        Iterator it = d.this.f60556c.iterator();
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
            for (int i2 = 0; i2 < d.this.f60556c.size(); i2++) {
                if (((TailData) d.this.f60556c.get(i2)).getId() == eVar.f60501b.getId()) {
                    ((TailData) d.this.f60556c.get(i2)).setContent(eVar.f60501b.getContent());
                    ((TailData) d.this.f60556c.get(i2)).setFontColor(eVar.f60501b.getFontColor());
                    ((TailData) d.this.f60556c.get(i2)).setSelected(eVar.f60501b.isSelected());
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof d.a.k0.r1.h.a.e) || d.this.f60557d == null) {
                return;
            }
            d.a.k0.r1.h.a.e eVar = (d.a.k0.r1.h.a.e) customResponsedMessage.getData();
            if (eVar.f60501b == null || d.this.f60556c == null) {
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
            d.this.f60557d.a(customResponsedMessage.hasError(), customResponsedMessage.getErrorString(), null);
        }
    }

    public d(TbPageContext<?> tbPageContext) {
        this.f60554a = tbPageContext;
        this.f60554a.registerListener(this.f60559f);
        this.f60554a.registerListener(this.f60560g);
        this.f60554a.registerListener(this.f60561h);
    }

    public void e(int i2) {
        this.f60554a.sendMessage(new DeleteTailNetMessage(i2));
    }

    public int f() {
        return 3 - this.f60556c.size();
    }

    public boolean g() {
        return this.f60555b;
    }

    public List<TailData> h() {
        return this.f60556c;
    }

    public boolean i(Serializable serializable) {
        if (serializable != null && (serializable instanceof TailDataList)) {
            this.f60556c = ((TailDataList) serializable).getTails();
            return true;
        }
        j();
        return false;
    }

    public void j() {
        this.f60554a.sendMessage(new GetTailsNetMessage("stat"));
    }

    public void k(d.a.k0.r1.h.f.a<Integer> aVar) {
        this.f60558e = aVar;
    }

    public void l(boolean z) {
        this.f60555b = z;
    }

    public void m(d.a.k0.r1.h.f.a<Void> aVar) {
        this.f60557d = aVar;
    }

    public void n(List<TailData> list) {
        if (list == null) {
            this.f60556c.clear();
        } else {
            this.f60556c = list;
        }
    }
}
