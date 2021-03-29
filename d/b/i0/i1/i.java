package d.b.i0.i1;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.lego.card.model.BaseLegoCardInfo;
import com.baidu.tieba.lego.card.model.ICardInfo;
import d.b.i0.x.m;
import java.util.List;
/* loaded from: classes3.dex */
public class i implements e {

    /* renamed from: a  reason: collision with root package name */
    public final StatisticItem f55883a;

    /* loaded from: classes3.dex */
    public static class b implements e {
        public b() {
        }

        @Override // d.b.i0.i1.e
        public e a(String str, String str2) {
            return this;
        }

        @Override // d.b.i0.i1.e
        public void b(ICardInfo iCardInfo) {
        }

        @Override // d.b.i0.i1.e
        public e c(String str, int i) {
            return this;
        }

        @Override // d.b.i0.i1.e
        public e d(String str, long j) {
            return this;
        }
    }

    public i(BaseLegoCardInfo baseLegoCardInfo) {
        this(baseLegoCardInfo.getStatistics(), baseLegoCardInfo.getStatTab(), baseLegoCardInfo.getCardType(), baseLegoCardInfo.getItemId());
    }

    public static e e(BaseLegoCardInfo baseLegoCardInfo) {
        return baseLegoCardInfo != null && !TextUtils.isEmpty(baseLegoCardInfo.getStatistics()) ? new i(baseLegoCardInfo) : new b();
    }

    public static e f(String str, int i, int i2, String str2) {
        return !TextUtils.isEmpty(str) ? new i(str, i, i2, str2) : new b();
    }

    @Override // d.b.i0.i1.e
    public e a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.f55883a.param(str, str2);
        }
        return this;
    }

    @Override // d.b.i0.i1.e
    public void b(ICardInfo iCardInfo) {
        g(iCardInfo);
        TiebaStatic.log(this.f55883a);
    }

    @Override // d.b.i0.i1.e
    public e c(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            this.f55883a.param(str, i);
        }
        return this;
    }

    @Override // d.b.i0.i1.e
    public e d(String str, long j) {
        if (!TextUtils.isEmpty(str)) {
            this.f55883a.param(str, String.valueOf(j));
        }
        return this;
    }

    public final void g(ICardInfo iCardInfo) {
        BaseLegoCardInfo baseLegoCardInfo = (BaseLegoCardInfo) iCardInfo;
        if (TextUtils.isEmpty(baseLegoCardInfo.getStatistics()) || TextUtils.isEmpty(baseLegoCardInfo.getsExtras())) {
            return;
        }
        List<Object> params = this.f55883a.getParams();
        for (String str : baseLegoCardInfo.getsExtras().split("&")) {
            String[] split = str.split("=");
            if (split.length == 2) {
                String str2 = split[0];
                String str3 = split[1];
                boolean z = false;
                for (int i = 0; i < params.size() && !z; i += 2) {
                    if (TextUtils.equals(str2, params.get(i).toString())) {
                        int i2 = i + 1;
                        if (i2 < params.size()) {
                            params.set(i2, str3);
                        }
                        z = true;
                    }
                }
                if (!z) {
                    this.f55883a.param(str2, str3);
                }
            }
        }
        a(TiebaStatic.Params.OBJ_PARAM3, m.e());
    }

    public i(String str, int i, int i2, String str2) {
        StatisticItem statisticItem = new StatisticItem(str);
        this.f55883a = statisticItem;
        statisticItem.param("obj_source", i);
        this.f55883a.param("obj_type", i2);
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f55883a.param("obj_card", str2);
    }
}
