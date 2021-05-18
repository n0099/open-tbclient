package d.a.k0.r1.h.b;

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
import d.a.k0.r1.h.a.g;
import d.a.k0.r1.h.f.d;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public TailData f60506c;

    /* renamed from: d  reason: collision with root package name */
    public TailData f60507d;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f60508e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.k0.r1.h.f.a<Integer> f60509f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.k0.r1.h.f.a<Integer> f60510g;

    /* renamed from: a  reason: collision with root package name */
    public boolean f60504a = false;

    /* renamed from: b  reason: collision with root package name */
    public boolean f60505b = false;

    /* renamed from: h  reason: collision with root package name */
    public d.a.c.c.g.a f60511h = new C1586a(CmdConfigHttp.CMD_TAIL_ADD, 305101);

    /* renamed from: i  reason: collision with root package name */
    public d.a.c.c.g.a f60512i = new b(CmdConfigHttp.CMD_TAIL_UPDATE, 305102);

    /* renamed from: d.a.k0.r1.h.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1586a extends d.a.c.c.g.a {
        public C1586a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            d.a.k0.r1.h.a.b resultData;
            a.this.f60504a = false;
            if (a.this.f60509f != null) {
                Integer num = null;
                if (responsedMessage instanceof AddTailHttpResponseMessage) {
                    resultData = ((AddTailHttpResponseMessage) responsedMessage).getResultData();
                } else {
                    resultData = responsedMessage instanceof AddTailSocketResponseMessage ? ((AddTailSocketResponseMessage) responsedMessage).getResultData() : null;
                }
                if (resultData != null) {
                    num = Integer.valueOf(resultData.a());
                    if (a.this.f60505b) {
                        a.this.p(num.intValue());
                    }
                }
                a.this.f60509f.a(responsedMessage.hasError(), responsedMessage.getErrorString(), num);
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
            a.this.f60504a = false;
            if (a.this.f60510g != null) {
                if (responsedMessage instanceof UpdateTailHttpResponseMessage) {
                    resultData = ((UpdateTailHttpResponseMessage) responsedMessage).getResultData();
                } else {
                    resultData = responsedMessage instanceof UpdateTailSocketResponseMessage ? ((UpdateTailSocketResponseMessage) responsedMessage).getResultData() : null;
                }
                a.this.f60510g.a(responsedMessage.hasError(), responsedMessage.getErrorString(), resultData != null ? Integer.valueOf(resultData.a()) : null);
            }
        }
    }

    public a(TbPageContext<?> tbPageContext) {
        this.f60508e = tbPageContext;
        tbPageContext.registerListener(this.f60511h);
        this.f60508e.registerListener(this.f60512i);
        this.f60507d = new TailData();
    }

    public int e(String str) {
        return Pattern.compile("#\\([^#\\)\\(]+\\)").matcher(str).replaceAll(" ").length();
    }

    public String f(String str) {
        return (str == null || str.length() <= 0) ? "" : str.substring(0, str.length() - 1);
    }

    public String g() {
        return this.f60507d.getFontColor();
    }

    public String h(String str) {
        while (e(str) > 50) {
            str = f(str);
        }
        return str;
    }

    public TailData i() {
        return this.f60507d;
    }

    public void j(int i2, String str, String str2, boolean z) {
        TailData tailData = new TailData();
        this.f60507d = tailData;
        if (i2 != 0) {
            TailData tailData2 = new TailData();
            this.f60506c = tailData2;
            tailData2.setId(i2);
            this.f60506c.setContent(str);
            this.f60506c.setFontColor(str2);
            this.f60507d.setId(i2);
            this.f60507d.setContent(str);
            this.f60507d.setFontColor(str2);
            return;
        }
        tailData.setContent("");
        this.f60507d.setFontColor("7a7c80");
        this.f60505b = z;
    }

    public boolean k() {
        TailData tailData = this.f60507d;
        if (tailData != null && tailData.getFontColor() != null) {
            TailData tailData2 = this.f60506c;
            if (tailData2 == null) {
                if (!StringUtils.isNull(this.f60507d.getContent()) || !this.f60507d.getFontColor().equals("7a7c80")) {
                    return true;
                }
            } else if (tailData2.getContent() != null && this.f60506c.getFontColor() != null && (!this.f60506c.getContent().equals(this.f60507d.getContent()) || !this.f60506c.getFontColor().equals(this.f60507d.getFontColor()))) {
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

    public void n(d.a.k0.r1.h.f.a<Integer> aVar) {
        this.f60509f = aVar;
    }

    public void o(String str) {
        this.f60507d.setFontColor(str);
    }

    public void p(int i2) {
        MessageManager.getInstance().sendMessage(new SetTailNetMessage(i2, 1));
    }

    public void q(d.a.k0.r1.h.f.a<Integer> aVar) {
        this.f60510g = aVar;
    }

    public void r(String str) {
        if (this.f60504a) {
            return;
        }
        String f2 = d.f(str);
        if (!StringUtils.isNull(f2)) {
            this.f60508e.showToast(f2);
            return;
        }
        String b2 = d.b(str);
        this.f60507d.setContent(b2);
        this.f60504a = true;
        TailData tailData = this.f60506c;
        if (tailData != null && tailData.getId() > 0) {
            this.f60508e.sendMessage(new UpdateTailNetMessage(this.f60506c.getId(), b2, this.f60507d.getFontColor(), this.f60508e.getString(R.string.tail_default_font)));
        } else {
            this.f60508e.sendMessage(new AddTailNetMessage(b2, this.f60507d.getFontColor(), this.f60508e.getString(R.string.tail_default_font)));
        }
    }

    public boolean s() {
        return !StringUtils.isNull(this.f60507d.getContent()) && k() && StringUtils.isNull(d.f(this.f60507d.getContent()));
    }
}
