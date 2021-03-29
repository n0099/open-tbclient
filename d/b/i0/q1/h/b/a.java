package d.b.i0.q1.h.b;

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
import d.b.i0.q1.h.a.g;
import d.b.i0.q1.h.f.d;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public TailData f59493c;

    /* renamed from: d  reason: collision with root package name */
    public TailData f59494d;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f59495e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.i0.q1.h.f.a<Integer> f59496f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.i0.q1.h.f.a<Integer> f59497g;

    /* renamed from: a  reason: collision with root package name */
    public boolean f59491a = false;

    /* renamed from: b  reason: collision with root package name */
    public boolean f59492b = false;

    /* renamed from: h  reason: collision with root package name */
    public d.b.b.c.g.a f59498h = new C1486a(CmdConfigHttp.CMD_TAIL_ADD, 305101);
    public d.b.b.c.g.a i = new b(CmdConfigHttp.CMD_TAIL_UPDATE, 305102);

    /* renamed from: d.b.i0.q1.h.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1486a extends d.b.b.c.g.a {
        public C1486a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.b.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            d.b.i0.q1.h.a.b resultData;
            a.this.f59491a = false;
            if (a.this.f59496f != null) {
                Integer num = null;
                if (responsedMessage instanceof AddTailHttpResponseMessage) {
                    resultData = ((AddTailHttpResponseMessage) responsedMessage).getResultData();
                } else {
                    resultData = responsedMessage instanceof AddTailSocketResponseMessage ? ((AddTailSocketResponseMessage) responsedMessage).getResultData() : null;
                }
                if (resultData != null) {
                    num = Integer.valueOf(resultData.a());
                    if (a.this.f59492b) {
                        a.this.p(num.intValue());
                    }
                }
                a.this.f59496f.a(responsedMessage.hasError(), responsedMessage.getErrorString(), num);
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
            g resultData;
            a.this.f59491a = false;
            if (a.this.f59497g != null) {
                if (responsedMessage instanceof UpdateTailHttpResponseMessage) {
                    resultData = ((UpdateTailHttpResponseMessage) responsedMessage).getResultData();
                } else {
                    resultData = responsedMessage instanceof UpdateTailSocketResponseMessage ? ((UpdateTailSocketResponseMessage) responsedMessage).getResultData() : null;
                }
                a.this.f59497g.a(responsedMessage.hasError(), responsedMessage.getErrorString(), resultData != null ? Integer.valueOf(resultData.a()) : null);
            }
        }
    }

    public a(TbPageContext<?> tbPageContext) {
        this.f59495e = tbPageContext;
        tbPageContext.registerListener(this.f59498h);
        this.f59495e.registerListener(this.i);
        this.f59494d = new TailData();
    }

    public int e(String str) {
        return Pattern.compile("#\\([^#\\)\\(]+\\)").matcher(str).replaceAll(" ").length();
    }

    public String f(String str) {
        return (str == null || str.length() <= 0) ? "" : str.substring(0, str.length() - 1);
    }

    public String g() {
        return this.f59494d.getFontColor();
    }

    public String h(String str) {
        while (e(str) > 50) {
            str = f(str);
        }
        return str;
    }

    public TailData i() {
        return this.f59494d;
    }

    public void j(int i, String str, String str2, boolean z) {
        TailData tailData = new TailData();
        this.f59494d = tailData;
        if (i != 0) {
            TailData tailData2 = new TailData();
            this.f59493c = tailData2;
            tailData2.setId(i);
            this.f59493c.setContent(str);
            this.f59493c.setFontColor(str2);
            this.f59494d.setId(i);
            this.f59494d.setContent(str);
            this.f59494d.setFontColor(str2);
            return;
        }
        tailData.setContent("");
        this.f59494d.setFontColor("7a7c80");
        this.f59492b = z;
    }

    public boolean k() {
        TailData tailData = this.f59494d;
        if (tailData != null && tailData.getFontColor() != null) {
            TailData tailData2 = this.f59493c;
            if (tailData2 == null) {
                if (!StringUtils.isNull(this.f59494d.getContent()) || !this.f59494d.getFontColor().equals("7a7c80")) {
                    return true;
                }
            } else if (tailData2.getContent() != null && this.f59493c.getFontColor() != null && (!this.f59493c.getContent().equals(this.f59494d.getContent()) || !this.f59493c.getFontColor().equals(this.f59494d.getFontColor()))) {
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

    public void n(d.b.i0.q1.h.f.a<Integer> aVar) {
        this.f59496f = aVar;
    }

    public void o(String str) {
        this.f59494d.setFontColor(str);
    }

    public void p(int i) {
        MessageManager.getInstance().sendMessage(new SetTailNetMessage(i, 1));
    }

    public void q(d.b.i0.q1.h.f.a<Integer> aVar) {
        this.f59497g = aVar;
    }

    public void r(String str) {
        if (this.f59491a) {
            return;
        }
        String f2 = d.f(str);
        if (!StringUtils.isNull(f2)) {
            this.f59495e.showToast(f2);
            return;
        }
        String b2 = d.b(str);
        this.f59494d.setContent(b2);
        this.f59491a = true;
        TailData tailData = this.f59493c;
        if (tailData != null && tailData.getId() > 0) {
            this.f59495e.sendMessage(new UpdateTailNetMessage(this.f59493c.getId(), b2, this.f59494d.getFontColor(), this.f59495e.getString(R.string.tail_default_font)));
        } else {
            this.f59495e.sendMessage(new AddTailNetMessage(b2, this.f59494d.getFontColor(), this.f59495e.getString(R.string.tail_default_font)));
        }
    }

    public boolean s() {
        return !StringUtils.isNull(this.f59494d.getContent()) && k() && StringUtils.isNull(d.f(this.f59494d.getContent()));
    }
}
