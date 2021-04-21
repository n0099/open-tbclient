package d.b.j0.r1.h.b;

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
import d.b.j0.r1.h.a.g;
import d.b.j0.r1.h.f.d;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public TailData f61608c;

    /* renamed from: d  reason: collision with root package name */
    public TailData f61609d;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f61610e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.j0.r1.h.f.a<Integer> f61611f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.j0.r1.h.f.a<Integer> f61612g;

    /* renamed from: a  reason: collision with root package name */
    public boolean f61606a = false;

    /* renamed from: b  reason: collision with root package name */
    public boolean f61607b = false;

    /* renamed from: h  reason: collision with root package name */
    public d.b.c.c.g.a f61613h = new C1573a(CmdConfigHttp.CMD_TAIL_ADD, 305101);
    public d.b.c.c.g.a i = new b(CmdConfigHttp.CMD_TAIL_UPDATE, 305102);

    /* renamed from: d.b.j0.r1.h.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1573a extends d.b.c.c.g.a {
        public C1573a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            d.b.j0.r1.h.a.b resultData;
            a.this.f61606a = false;
            if (a.this.f61611f != null) {
                Integer num = null;
                if (responsedMessage instanceof AddTailHttpResponseMessage) {
                    resultData = ((AddTailHttpResponseMessage) responsedMessage).getResultData();
                } else {
                    resultData = responsedMessage instanceof AddTailSocketResponseMessage ? ((AddTailSocketResponseMessage) responsedMessage).getResultData() : null;
                }
                if (resultData != null) {
                    num = Integer.valueOf(resultData.a());
                    if (a.this.f61607b) {
                        a.this.p(num.intValue());
                    }
                }
                a.this.f61611f.a(responsedMessage.hasError(), responsedMessage.getErrorString(), num);
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
            a.this.f61606a = false;
            if (a.this.f61612g != null) {
                if (responsedMessage instanceof UpdateTailHttpResponseMessage) {
                    resultData = ((UpdateTailHttpResponseMessage) responsedMessage).getResultData();
                } else {
                    resultData = responsedMessage instanceof UpdateTailSocketResponseMessage ? ((UpdateTailSocketResponseMessage) responsedMessage).getResultData() : null;
                }
                a.this.f61612g.a(responsedMessage.hasError(), responsedMessage.getErrorString(), resultData != null ? Integer.valueOf(resultData.a()) : null);
            }
        }
    }

    public a(TbPageContext<?> tbPageContext) {
        this.f61610e = tbPageContext;
        tbPageContext.registerListener(this.f61613h);
        this.f61610e.registerListener(this.i);
        this.f61609d = new TailData();
    }

    public int e(String str) {
        return Pattern.compile("#\\([^#\\)\\(]+\\)").matcher(str).replaceAll(" ").length();
    }

    public String f(String str) {
        return (str == null || str.length() <= 0) ? "" : str.substring(0, str.length() - 1);
    }

    public String g() {
        return this.f61609d.getFontColor();
    }

    public String h(String str) {
        while (e(str) > 50) {
            str = f(str);
        }
        return str;
    }

    public TailData i() {
        return this.f61609d;
    }

    public void j(int i, String str, String str2, boolean z) {
        TailData tailData = new TailData();
        this.f61609d = tailData;
        if (i != 0) {
            TailData tailData2 = new TailData();
            this.f61608c = tailData2;
            tailData2.setId(i);
            this.f61608c.setContent(str);
            this.f61608c.setFontColor(str2);
            this.f61609d.setId(i);
            this.f61609d.setContent(str);
            this.f61609d.setFontColor(str2);
            return;
        }
        tailData.setContent("");
        this.f61609d.setFontColor("7a7c80");
        this.f61607b = z;
    }

    public boolean k() {
        TailData tailData = this.f61609d;
        if (tailData != null && tailData.getFontColor() != null) {
            TailData tailData2 = this.f61608c;
            if (tailData2 == null) {
                if (!StringUtils.isNull(this.f61609d.getContent()) || !this.f61609d.getFontColor().equals("7a7c80")) {
                    return true;
                }
            } else if (tailData2.getContent() != null && this.f61608c.getFontColor() != null && (!this.f61608c.getContent().equals(this.f61609d.getContent()) || !this.f61608c.getFontColor().equals(this.f61609d.getFontColor()))) {
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

    public void n(d.b.j0.r1.h.f.a<Integer> aVar) {
        this.f61611f = aVar;
    }

    public void o(String str) {
        this.f61609d.setFontColor(str);
    }

    public void p(int i) {
        MessageManager.getInstance().sendMessage(new SetTailNetMessage(i, 1));
    }

    public void q(d.b.j0.r1.h.f.a<Integer> aVar) {
        this.f61612g = aVar;
    }

    public void r(String str) {
        if (this.f61606a) {
            return;
        }
        String f2 = d.f(str);
        if (!StringUtils.isNull(f2)) {
            this.f61610e.showToast(f2);
            return;
        }
        String b2 = d.b(str);
        this.f61609d.setContent(b2);
        this.f61606a = true;
        TailData tailData = this.f61608c;
        if (tailData != null && tailData.getId() > 0) {
            this.f61610e.sendMessage(new UpdateTailNetMessage(this.f61608c.getId(), b2, this.f61609d.getFontColor(), this.f61610e.getString(R.string.tail_default_font)));
        } else {
            this.f61610e.sendMessage(new AddTailNetMessage(b2, this.f61609d.getFontColor(), this.f61610e.getString(R.string.tail_default_font)));
        }
    }

    public boolean s() {
        return !StringUtils.isNull(this.f61609d.getContent()) && k() && StringUtils.isNull(d.f(this.f61609d.getContent()));
    }
}
