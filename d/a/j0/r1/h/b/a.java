package d.a.j0.r1.h.b;

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
import d.a.j0.r1.h.a.g;
import d.a.j0.r1.h.f.d;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public TailData f59761c;

    /* renamed from: d  reason: collision with root package name */
    public TailData f59762d;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f59763e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.j0.r1.h.f.a<Integer> f59764f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.j0.r1.h.f.a<Integer> f59765g;

    /* renamed from: a  reason: collision with root package name */
    public boolean f59759a = false;

    /* renamed from: b  reason: collision with root package name */
    public boolean f59760b = false;

    /* renamed from: h  reason: collision with root package name */
    public d.a.c.c.g.a f59766h = new C1512a(CmdConfigHttp.CMD_TAIL_ADD, 305101);

    /* renamed from: i  reason: collision with root package name */
    public d.a.c.c.g.a f59767i = new b(CmdConfigHttp.CMD_TAIL_UPDATE, 305102);

    /* renamed from: d.a.j0.r1.h.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1512a extends d.a.c.c.g.a {
        public C1512a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            d.a.j0.r1.h.a.b resultData;
            a.this.f59759a = false;
            if (a.this.f59764f != null) {
                Integer num = null;
                if (responsedMessage instanceof AddTailHttpResponseMessage) {
                    resultData = ((AddTailHttpResponseMessage) responsedMessage).getResultData();
                } else {
                    resultData = responsedMessage instanceof AddTailSocketResponseMessage ? ((AddTailSocketResponseMessage) responsedMessage).getResultData() : null;
                }
                if (resultData != null) {
                    num = Integer.valueOf(resultData.a());
                    if (a.this.f59760b) {
                        a.this.p(num.intValue());
                    }
                }
                a.this.f59764f.a(responsedMessage.hasError(), responsedMessage.getErrorString(), num);
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
            g resultData;
            a.this.f59759a = false;
            if (a.this.f59765g != null) {
                if (responsedMessage instanceof UpdateTailHttpResponseMessage) {
                    resultData = ((UpdateTailHttpResponseMessage) responsedMessage).getResultData();
                } else {
                    resultData = responsedMessage instanceof UpdateTailSocketResponseMessage ? ((UpdateTailSocketResponseMessage) responsedMessage).getResultData() : null;
                }
                a.this.f59765g.a(responsedMessage.hasError(), responsedMessage.getErrorString(), resultData != null ? Integer.valueOf(resultData.a()) : null);
            }
        }
    }

    public a(TbPageContext<?> tbPageContext) {
        this.f59763e = tbPageContext;
        tbPageContext.registerListener(this.f59766h);
        this.f59763e.registerListener(this.f59767i);
        this.f59762d = new TailData();
    }

    public int e(String str) {
        return Pattern.compile("#\\([^#\\)\\(]+\\)").matcher(str).replaceAll(" ").length();
    }

    public String f(String str) {
        return (str == null || str.length() <= 0) ? "" : str.substring(0, str.length() - 1);
    }

    public String g() {
        return this.f59762d.getFontColor();
    }

    public String h(String str) {
        while (e(str) > 50) {
            str = f(str);
        }
        return str;
    }

    public TailData i() {
        return this.f59762d;
    }

    public void j(int i2, String str, String str2, boolean z) {
        TailData tailData = new TailData();
        this.f59762d = tailData;
        if (i2 != 0) {
            TailData tailData2 = new TailData();
            this.f59761c = tailData2;
            tailData2.setId(i2);
            this.f59761c.setContent(str);
            this.f59761c.setFontColor(str2);
            this.f59762d.setId(i2);
            this.f59762d.setContent(str);
            this.f59762d.setFontColor(str2);
            return;
        }
        tailData.setContent("");
        this.f59762d.setFontColor("7a7c80");
        this.f59760b = z;
    }

    public boolean k() {
        TailData tailData = this.f59762d;
        if (tailData != null && tailData.getFontColor() != null) {
            TailData tailData2 = this.f59761c;
            if (tailData2 == null) {
                if (!StringUtils.isNull(this.f59762d.getContent()) || !this.f59762d.getFontColor().equals("7a7c80")) {
                    return true;
                }
            } else if (tailData2.getContent() != null && this.f59761c.getFontColor() != null && (!this.f59761c.getContent().equals(this.f59762d.getContent()) || !this.f59761c.getFontColor().equals(this.f59762d.getFontColor()))) {
                return true;
            }
        }
        return false;
    }

    public boolean l(int i2) {
        return i2 == 50;
    }

    public boolean m(int i2) {
        return i2 > 50;
    }

    public void n(d.a.j0.r1.h.f.a<Integer> aVar) {
        this.f59764f = aVar;
    }

    public void o(String str) {
        this.f59762d.setFontColor(str);
    }

    public void p(int i2) {
        MessageManager.getInstance().sendMessage(new SetTailNetMessage(i2, 1));
    }

    public void q(d.a.j0.r1.h.f.a<Integer> aVar) {
        this.f59765g = aVar;
    }

    public void r(String str) {
        if (this.f59759a) {
            return;
        }
        String f2 = d.f(str);
        if (!StringUtils.isNull(f2)) {
            this.f59763e.showToast(f2);
            return;
        }
        String b2 = d.b(str);
        this.f59762d.setContent(b2);
        this.f59759a = true;
        TailData tailData = this.f59761c;
        if (tailData != null && tailData.getId() > 0) {
            this.f59763e.sendMessage(new UpdateTailNetMessage(this.f59761c.getId(), b2, this.f59762d.getFontColor(), this.f59763e.getString(R.string.tail_default_font)));
        } else {
            this.f59763e.sendMessage(new AddTailNetMessage(b2, this.f59762d.getFontColor(), this.f59763e.getString(R.string.tail_default_font)));
        }
    }

    public boolean s() {
        return !StringUtils.isNull(this.f59762d.getContent()) && k() && StringUtils.isNull(d.f(this.f59762d.getContent()));
    }
}
