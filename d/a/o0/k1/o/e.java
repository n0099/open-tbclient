package d.a.o0.k1.o;

import android.util.SparseArray;
import android.util.SparseIntArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.lego.card.exception.CardParseException;
import com.baidu.tieba.lego.card.model.ICardInfo;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public abstract class e {

    /* renamed from: a  reason: collision with root package name */
    public static final SparseIntArray f60452a = new SparseIntArray();

    /* renamed from: b  reason: collision with root package name */
    public static final SparseArray<BdUniqueId> f60453b = new SparseArray<>();

    public e() {
        c();
    }

    public abstract <T> d.a.o0.k1.o.l.e a(TbPageContext<T> tbPageContext, ICardInfo iCardInfo, int i2);

    public abstract ICardInfo b(JSONObject jSONObject, int i2) throws CardParseException;

    public abstract void c();

    public abstract String d();
}
