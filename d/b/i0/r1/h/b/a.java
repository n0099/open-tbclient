package d.b.i0.r1.h.b;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.tail.data.TailData;
import com.baidu.tieba.memberCenter.tail.message.AddTailHttpResponseMessage;
import com.baidu.tieba.memberCenter.tail.message.AddTailNetMessage;
import com.baidu.tieba.memberCenter.tail.message.AddTailSocketResponseMessage;
import com.baidu.tieba.memberCenter.tail.message.SetTailNetMessage;
import com.baidu.tieba.memberCenter.tail.message.UpdateTailHttpResponseMessage;
import com.baidu.tieba.memberCenter.tail.message.UpdateTailNetMessage;
import com.baidu.tieba.memberCenter.tail.message.UpdateTailSocketResponseMessage;
import d.b.i0.r1.h.a.g;
import d.b.i0.r1.h.f.d;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public TailData f61187c;

    /* renamed from: d  reason: collision with root package name */
    public TailData f61188d;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f61189e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.i0.r1.h.f.a<Integer> f61190f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.i0.r1.h.f.a<Integer> f61191g;

    /* renamed from: a  reason: collision with root package name */
    public boolean f61185a = false;

    /* renamed from: b  reason: collision with root package name */
    public boolean f61186b = false;

    /* renamed from: h  reason: collision with root package name */
    public d.b.c.c.g.a f61192h = new C1550a(CmdConfigHttp.CMD_TAIL_ADD, 305101);
    public d.b.c.c.g.a i = new b(CmdConfigHttp.CMD_TAIL_UPDATE, 305102);

    /* renamed from: d.b.i0.r1.h.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1550a extends d.b.c.c.g.a {
        public C1550a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            d.b.i0.r1.h.a.b resultData;
            a.this.f61185a = false;
            if (a.this.f61190f != null) {
                Integer num = null;
                if (responsedMessage instanceof AddTailHttpResponseMessage) {
                    resultData = ((AddTailHttpResponseMessage) responsedMessage).getResultData();
                } else {
                    resultData = responsedMessage instanceof AddTailSocketResponseMessage ? ((AddTailSocketResponseMessage) responsedMessage).getResultData() : null;
                }
                if (resultData != null) {
                    num = Integer.valueOf(resultData.a());
                    if (a.this.f61186b) {
                        a.this.p(num.intValue());
                    }
                }
                a.this.f61190f.a(responsedMessage.hasError(), responsedMessage.getErrorString(), num);
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
            g resultData;
            a.this.f61185a = false;
            if (a.this.f61191g != null) {
                if (responsedMessage instanceof UpdateTailHttpResponseMessage) {
                    resultData = ((UpdateTailHttpResponseMessage) responsedMessage).getResultData();
                } else {
                    resultData = responsedMessage instanceof UpdateTailSocketResponseMessage ? ((UpdateTailSocketResponseMessage) responsedMessage).getResultData() : null;
                }
                a.this.f61191g.a(responsedMessage.hasError(), responsedMessage.getErrorString(), resultData != null ? Integer.valueOf(resultData.a()) : null);
            }
        }
    }

    public a(TbPageContext<?> tbPageContext) {
        this.f61189e = tbPageContext;
        tbPageContext.registerListener(this.f61192h);
        this.f61189e.registerListener(this.i);
        this.f61188d = new TailData();
    }

    public int e(String str) {
        return Pattern.compile("#\\([^#\\)\\(]+\\)").matcher(str).replaceAll(" ").length();
    }

    public String f(String str) {
        return (str == null || str.length() <= 0) ? "" : str.substring(0, str.length() - 1);
    }

    public String g() {
        return this.f61188d.getFontColor();
    }

    public String h(String str) {
        while (e(str) > 50) {
            str = f(str);
        }
        return str;
    }

    public TailData i() {
        return this.f61188d;
    }

    public void j(int i, String str, String str2, boolean z) {
        TailData tailData = new TailData();
        this.f61188d = tailData;
        if (i != 0) {
            TailData tailData2 = new TailData();
            this.f61187c = tailData2;
            tailData2.setId(i);
            this.f61187c.setContent(str);
            this.f61187c.setFontColor(str2);
            this.f61188d.setId(i);
            this.f61188d.setContent(str);
            this.f61188d.setFontColor(str2);
            return;
        }
        tailData.setContent("");
        this.f61188d.setFontColor("7a7c80");
        this.f61186b = z;
    }

    public boolean k() {
        TailData tailData = this.f61188d;
        if (tailData != null && tailData.getFontColor() != null) {
            TailData tailData2 = this.f61187c;
            if (tailData2 == null) {
                if (!StringUtils.isNull(this.f61188d.getContent()) || !this.f61188d.getFontColor().equals("7a7c80")) {
                    return true;
                }
            } else if (tailData2.getContent() != null && this.f61187c.getFontColor() != null && (!this.f61187c.getContent().equals(this.f61188d.getContent()) || !this.f61187c.getFontColor().equals(this.f61188d.getFontColor()))) {
                return true;
            }
        }
        return false;
    }

    public boolean l(int i) {
        return i == 50;
    }

    public boolean m(int i) {
        return i > 50;
    }

    public void n(d.b.i0.r1.h.f.a<Integer> aVar) {
        this.f61190f = aVar;
    }

    public void o(String str) {
        this.f61188d.setFontColor(str);
    }

    public void p(int i) {
        MessageManager.getInstance().sendMessage(new SetTailNetMessage(i, 1));
    }

    public void q(d.b.i0.r1.h.f.a<Integer> aVar) {
        this.f61191g = aVar;
    }

    public void r(String str) {
        if (this.f61185a) {
            return;
        }
        String f2 = d.f(str);
        if (!StringUtils.isNull(f2)) {
            this.f61189e.showToast(f2);
            return;
        }
        String b2 = d.b(str);
        this.f61188d.setContent(b2);
        this.f61185a = true;
        TailData tailData = this.f61187c;
        if (tailData != null && tailData.getId() > 0) {
            this.f61189e.sendMessage(new UpdateTailNetMessage(this.f61187c.getId(), b2, this.f61188d.getFontColor(), this.f61189e.getString(R.string.tail_default_font)));
        } else {
            this.f61189e.sendMessage(new AddTailNetMessage(b2, this.f61188d.getFontColor(), this.f61189e.getString(R.string.tail_default_font)));
        }
    }

    public boolean s() {
        return !StringUtils.isNull(this.f61188d.getContent()) && k() && StringUtils.isNull(d.f(this.f61188d.getContent()));
    }
}
