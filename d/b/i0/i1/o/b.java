package d.b.i0.i1.o;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.lego.card.exception.CardParseException;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends e {

    /* renamed from: c  reason: collision with root package name */
    public final List<e> f55915c;

    /* renamed from: d.b.i0.i1.o.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1302b {

        /* renamed from: a  reason: collision with root package name */
        public static final b f55916a = new b();
    }

    public static b h() {
        return C1302b.f55916a;
    }

    public static ICardInfo i(String str) {
        try {
            ICardInfo j = j(new JSONObject(str));
            if (j != null) {
                if (j.isValid()) {
                    return j;
                }
            }
            return null;
        } catch (CardParseException e2) {
            BdLog.detailException("CardFactory.getPageCardInfo", e2);
            return null;
        } catch (JSONException e3) {
            BdLog.detailException("CardFactory.getPageCardInfo", e3);
            return null;
        }
    }

    public static ICardInfo j(JSONObject jSONObject) throws CardParseException {
        return h().b(jSONObject, jSONObject.optInt("card_type"));
    }

    public static ICardInfo k(String str) throws Exception {
        ICardInfo j = j(new JSONObject(str));
        if (j == null || !j.isValid()) {
            return null;
        }
        return j;
    }

    @Override // d.b.i0.i1.o.e
    public <T> d.b.i0.i1.o.l.e a(TbPageContext<T> tbPageContext, ICardInfo iCardInfo, int i) {
        d.b.i0.i1.o.l.e e2 = e(tbPageContext, iCardInfo, i);
        if (e2 != null) {
            e2.setBusinessType(i);
        }
        return e2;
    }

    @Override // d.b.i0.i1.o.e
    public ICardInfo b(JSONObject jSONObject, int i) throws CardParseException {
        return f(jSONObject, i);
    }

    @Override // d.b.i0.i1.o.e
    public void c() {
    }

    @Override // d.b.i0.i1.o.e
    public String d() {
        return "lego_main";
    }

    public final <T> d.b.i0.i1.o.l.e e(TbPageContext<T> tbPageContext, ICardInfo iCardInfo, int i) {
        d.b.i0.i1.o.l.e a2;
        for (e eVar : this.f55915c) {
            try {
                a2 = eVar.a(tbPageContext, iCardInfo, i);
            } catch (Throwable th) {
                BdLog.detailException("factory <" + eVar.d() + "> respond exception", th);
            }
            if (a2 != null) {
                return a2;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("No card factory for card type ");
        sb.append(iCardInfo == null ? -1 : iCardInfo.getCardType());
        BdLog.e(sb.toString());
        return null;
    }

    public final ICardInfo f(JSONObject jSONObject, int i) throws CardParseException {
        for (e eVar : this.f55915c) {
            try {
                ICardInfo b2 = eVar.b(jSONObject, i);
                if (b2 != null) {
                    return b2;
                }
            } catch (Throwable th) {
                throw new CardParseException("Card type " + i + ", factory <" + eVar.d() + "> respond exception", th);
            }
        }
        BdLog.e("No card factory for card type " + i);
        return null;
    }

    public synchronized void g(e eVar) {
        this.f55915c.add(eVar);
    }

    public b() {
        this.f55915c = new ArrayList(4);
    }
}
