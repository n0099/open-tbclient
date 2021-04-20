package d.b.i0.r1.h.c;

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
    public TbPageContext<?> f61232a;

    /* renamed from: d  reason: collision with root package name */
    public d.b.i0.r1.h.f.a<Void> f61235d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.r1.h.f.a<Integer> f61236e;

    /* renamed from: b  reason: collision with root package name */
    public boolean f61233b = false;

    /* renamed from: f  reason: collision with root package name */
    public d.b.c.c.g.a f61237f = new a(CmdConfigHttp.CMD_TAIL_GET, 305001);

    /* renamed from: g  reason: collision with root package name */
    public d.b.c.c.g.a f61238g = new b(CmdConfigHttp.CMD_TAIL_DELETE, 305103);

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f61239h = new c(2001340);

    /* renamed from: c  reason: collision with root package name */
    public List<TailData> f61234c = new ArrayList();

    /* loaded from: classes3.dex */
    public class a extends d.b.c.c.g.a {
        public a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            d.b.i0.r1.h.a.d resultData;
            if (d.this.f61235d != null) {
                if (responsedMessage instanceof GetTailsHttpResponseMessage) {
                    resultData = ((GetTailsHttpResponseMessage) responsedMessage).getResultData();
                } else {
                    resultData = responsedMessage instanceof GetTailsSocketResponseMessage ? ((GetTailsSocketResponseMessage) responsedMessage).getResultData() : null;
                }
                if (resultData != null) {
                    d.this.f61234c = resultData.b();
                }
                d.this.f61235d.a(responsedMessage.hasError(), responsedMessage.getErrorString(), null);
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
            d.b.i0.r1.h.a.c resultData;
            if (d.this.f61236e != null) {
                if (responsedMessage instanceof DeleteTailHttpResponseMessage) {
                    resultData = ((DeleteTailHttpResponseMessage) responsedMessage).getResultData();
                } else {
                    resultData = responsedMessage instanceof DeleteTailSocketResponseMessage ? ((DeleteTailSocketResponseMessage) responsedMessage).getResultData() : null;
                }
                d.this.f61236e.a(responsedMessage.hasError(), responsedMessage.getErrorString(), resultData != null ? Integer.valueOf(resultData.a()) : null);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends CustomMessageListener {
        public c(int i) {
            super(i);
        }

        public final void a(d.b.i0.r1.h.a.e eVar) {
            boolean z = false;
            int i = 0;
            while (true) {
                if (i >= d.this.f61234c.size()) {
                    break;
                } else if (((TailData) d.this.f61234c.get(i)).getId() == eVar.f61182b.getId()) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
            if (z) {
                return;
            }
            d.this.f61234c.add(eVar.f61182b);
        }

        public final void b(d.b.i0.r1.h.a.e eVar) {
            boolean z = false;
            for (int i = 0; i < d.this.f61234c.size(); i++) {
                if (((TailData) d.this.f61234c.get(i)).getId() == eVar.f61182b.getId()) {
                    d.this.f61234c.remove(i);
                    if (d.this.f61234c.size() != 0) {
                        Iterator it = d.this.f61234c.iterator();
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

        public final void c(d.b.i0.r1.h.a.e eVar) {
            for (int i = 0; i < d.this.f61234c.size(); i++) {
                if (((TailData) d.this.f61234c.get(i)).getId() == eVar.f61182b.getId()) {
                    ((TailData) d.this.f61234c.get(i)).setContent(eVar.f61182b.getContent());
                    ((TailData) d.this.f61234c.get(i)).setFontColor(eVar.f61182b.getFontColor());
                    ((TailData) d.this.f61234c.get(i)).setSelected(eVar.f61182b.isSelected());
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof d.b.i0.r1.h.a.e) || d.this.f61235d == null) {
                return;
            }
            d.b.i0.r1.h.a.e eVar = (d.b.i0.r1.h.a.e) customResponsedMessage.getData();
            if (eVar.f61182b == null || d.this.f61234c == null) {
                return;
            }
            int i = eVar.f61181a;
            if (i == 1) {
                a(eVar);
            } else if (i == 3) {
                b(eVar);
            } else if (i == 2) {
                c(eVar);
            }
            d.this.f61235d.a(customResponsedMessage.hasError(), customResponsedMessage.getErrorString(), null);
        }
    }

    public d(TbPageContext<?> tbPageContext) {
        this.f61232a = tbPageContext;
        this.f61232a.registerListener(this.f61237f);
        this.f61232a.registerListener(this.f61238g);
        this.f61232a.registerListener(this.f61239h);
    }

    public void e(int i) {
        this.f61232a.sendMessage(new DeleteTailNetMessage(i));
    }

    public int f() {
        return 3 - this.f61234c.size();
    }

    public boolean g() {
        return this.f61233b;
    }

    public List<TailData> h() {
        return this.f61234c;
    }

    public boolean i(Serializable serializable) {
        if (serializable != null && (serializable instanceof TailDataList)) {
            this.f61234c = ((TailDataList) serializable).getTails();
            return true;
        }
        j();
        return false;
    }

    public void j() {
        this.f61232a.sendMessage(new GetTailsNetMessage("stat"));
    }

    public void k(d.b.i0.r1.h.f.a<Integer> aVar) {
        this.f61236e = aVar;
    }

    public void l(boolean z) {
        this.f61233b = z;
    }

    public void m(d.b.i0.r1.h.f.a<Void> aVar) {
        this.f61235d = aVar;
    }

    public void n(List<TailData> list) {
        if (list == null) {
            this.f61234c.clear();
        } else {
            this.f61234c = list;
        }
    }
}
