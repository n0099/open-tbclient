package d.a.n0.s1.h.b;

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
import d.a.n0.s1.h.a.g;
import d.a.n0.s1.h.f.d;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public TailData f60629c;

    /* renamed from: d  reason: collision with root package name */
    public TailData f60630d;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f60631e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.n0.s1.h.f.a<Integer> f60632f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.n0.s1.h.f.a<Integer> f60633g;

    /* renamed from: a  reason: collision with root package name */
    public boolean f60627a = false;

    /* renamed from: b  reason: collision with root package name */
    public boolean f60628b = false;

    /* renamed from: h  reason: collision with root package name */
    public d.a.c.c.g.a f60634h = new C1598a(CmdConfigHttp.CMD_TAIL_ADD, 305101);

    /* renamed from: i  reason: collision with root package name */
    public d.a.c.c.g.a f60635i = new b(CmdConfigHttp.CMD_TAIL_UPDATE, 305102);

    /* renamed from: d.a.n0.s1.h.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1598a extends d.a.c.c.g.a {
        public C1598a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            d.a.n0.s1.h.a.b resultData;
            a.this.f60627a = false;
            if (a.this.f60632f != null) {
                Integer num = null;
                if (responsedMessage instanceof AddTailHttpResponseMessage) {
                    resultData = ((AddTailHttpResponseMessage) responsedMessage).getResultData();
                } else {
                    resultData = responsedMessage instanceof AddTailSocketResponseMessage ? ((AddTailSocketResponseMessage) responsedMessage).getResultData() : null;
                }
                if (resultData != null) {
                    num = Integer.valueOf(resultData.a());
                    if (a.this.f60628b) {
                        a.this.p(num.intValue());
                    }
                }
                a.this.f60632f.a(responsedMessage.hasError(), responsedMessage.getErrorString(), num);
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
            a.this.f60627a = false;
            if (a.this.f60633g != null) {
                if (responsedMessage instanceof UpdateTailHttpResponseMessage) {
                    resultData = ((UpdateTailHttpResponseMessage) responsedMessage).getResultData();
                } else {
                    resultData = responsedMessage instanceof UpdateTailSocketResponseMessage ? ((UpdateTailSocketResponseMessage) responsedMessage).getResultData() : null;
                }
                a.this.f60633g.a(responsedMessage.hasError(), responsedMessage.getErrorString(), resultData != null ? Integer.valueOf(resultData.a()) : null);
            }
        }
    }

    public a(TbPageContext<?> tbPageContext) {
        this.f60631e = tbPageContext;
        tbPageContext.registerListener(this.f60634h);
        this.f60631e.registerListener(this.f60635i);
        this.f60630d = new TailData();
    }

    public int e(String str) {
        return Pattern.compile("#\\([^#\\)\\(]+\\)").matcher(str).replaceAll(" ").length();
    }

    public String f(String str) {
        return (str == null || str.length() <= 0) ? "" : str.substring(0, str.length() - 1);
    }

    public String g() {
        return this.f60630d.getFontColor();
    }

    public String h(String str) {
        while (e(str) > 50) {
            str = f(str);
        }
        return str;
    }

    public TailData i() {
        return this.f60630d;
    }

    public void j(int i2, String str, String str2, boolean z) {
        TailData tailData = new TailData();
        this.f60630d = tailData;
        if (i2 != 0) {
            TailData tailData2 = new TailData();
            this.f60629c = tailData2;
            tailData2.setId(i2);
            this.f60629c.setContent(str);
            this.f60629c.setFontColor(str2);
            this.f60630d.setId(i2);
            this.f60630d.setContent(str);
            this.f60630d.setFontColor(str2);
            return;
        }
        tailData.setContent("");
        this.f60630d.setFontColor("7a7c80");
        this.f60628b = z;
    }

    public boolean k() {
        TailData tailData = this.f60630d;
        if (tailData != null && tailData.getFontColor() != null) {
            TailData tailData2 = this.f60629c;
            if (tailData2 == null) {
                if (!StringUtils.isNull(this.f60630d.getContent()) || !this.f60630d.getFontColor().equals("7a7c80")) {
                    return true;
                }
            } else if (tailData2.getContent() != null && this.f60629c.getFontColor() != null && (!this.f60629c.getContent().equals(this.f60630d.getContent()) || !this.f60629c.getFontColor().equals(this.f60630d.getFontColor()))) {
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

    public void n(d.a.n0.s1.h.f.a<Integer> aVar) {
        this.f60632f = aVar;
    }

    public void o(String str) {
        this.f60630d.setFontColor(str);
    }

    public void p(int i2) {
        MessageManager.getInstance().sendMessage(new SetTailNetMessage(i2, 1));
    }

    public void q(d.a.n0.s1.h.f.a<Integer> aVar) {
        this.f60633g = aVar;
    }

    public void r(String str) {
        if (this.f60627a) {
            return;
        }
        String f2 = d.f(str);
        if (!StringUtils.isNull(f2)) {
            this.f60631e.showToast(f2);
            return;
        }
        String b2 = d.b(str);
        this.f60630d.setContent(b2);
        this.f60627a = true;
        TailData tailData = this.f60629c;
        if (tailData != null && tailData.getId() > 0) {
            this.f60631e.sendMessage(new UpdateTailNetMessage(this.f60629c.getId(), b2, this.f60630d.getFontColor(), this.f60631e.getString(R.string.tail_default_font)));
        } else {
            this.f60631e.sendMessage(new AddTailNetMessage(b2, this.f60630d.getFontColor(), this.f60631e.getString(R.string.tail_default_font)));
        }
    }

    public boolean s() {
        return !StringUtils.isNull(this.f60630d.getContent()) && k() && StringUtils.isNull(d.f(this.f60630d.getContent()));
    }
}
