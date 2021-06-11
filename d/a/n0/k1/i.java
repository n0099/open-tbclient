package d.a.n0.k1;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.lego.card.model.BaseLegoCardInfo;
import com.baidu.tieba.lego.card.model.ICardInfo;
import d.a.n0.z.m;
import java.util.List;
/* loaded from: classes4.dex */
public class i implements e {

    /* renamed from: a  reason: collision with root package name */
    public final StatisticItem f60291a;

    /* loaded from: classes4.dex */
    public static class b implements e {
        public b() {
        }

        @Override // d.a.n0.k1.e
        public void a(ICardInfo iCardInfo) {
        }

        @Override // d.a.n0.k1.e
        public e b(String str, int i2) {
            return this;
        }

        @Override // d.a.n0.k1.e
        public e c(String str, long j) {
            return this;
        }

        @Override // d.a.n0.k1.e
        public e d(String str, String str2) {
            return this;
        }
    }

    public i(BaseLegoCardInfo baseLegoCardInfo) {
        this(baseLegoCardInfo.getStatistics(), baseLegoCardInfo.getStatTab(), baseLegoCardInfo.getCardType(), baseLegoCardInfo.getItemId());
    }

    public static e e(BaseLegoCardInfo baseLegoCardInfo) {
        return baseLegoCardInfo != null && !TextUtils.isEmpty(baseLegoCardInfo.getStatistics()) ? new i(baseLegoCardInfo) : new b();
    }

    public static e f(String str, int i2, int i3, String str2) {
        return !TextUtils.isEmpty(str) ? new i(str, i2, i3, str2) : new b();
    }

    @Override // d.a.n0.k1.e
    public void a(ICardInfo iCardInfo) {
        g(iCardInfo);
        TiebaStatic.log(this.f60291a);
    }

    @Override // d.a.n0.k1.e
    public e b(String str, int i2) {
        if (!TextUtils.isEmpty(str)) {
            this.f60291a.param(str, i2);
        }
        return this;
    }

    @Override // d.a.n0.k1.e
    public e c(String str, long j) {
        if (!TextUtils.isEmpty(str)) {
            this.f60291a.param(str, String.valueOf(j));
        }
        return this;
    }

    @Override // d.a.n0.k1.e
    public e d(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.f60291a.param(str, str2);
        }
        return this;
    }

    public final void g(ICardInfo iCardInfo) {
        BaseLegoCardInfo baseLegoCardInfo = (BaseLegoCardInfo) iCardInfo;
        if (TextUtils.isEmpty(baseLegoCardInfo.getStatistics()) || TextUtils.isEmpty(baseLegoCardInfo.getsExtras())) {
            return;
        }
        List<Object> params = this.f60291a.getParams();
        for (String str : baseLegoCardInfo.getsExtras().split("&")) {
            String[] split = str.split("=");
            if (split.length == 2) {
                String str2 = split[0];
                String str3 = split[1];
                boolean z = false;
                for (int i2 = 0; i2 < params.size() && !z; i2 += 2) {
                    if (TextUtils.equals(str2, params.get(i2).toString())) {
                        int i3 = i2 + 1;
                        if (i3 < params.size()) {
                            params.set(i3, str3);
                        }
                        z = true;
                    }
                }
                if (!z) {
                    this.f60291a.param(str2, str3);
                }
            }
        }
        d(TiebaStatic.Params.OBJ_PARAM3, m.e());
    }

    public i(String str, int i2, int i3, String str2) {
        StatisticItem statisticItem = new StatisticItem(str);
        this.f60291a = statisticItem;
        statisticItem.param("obj_source", i2);
        this.f60291a.param("obj_type", i3);
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f60291a.param("obj_card", str2);
    }
}
