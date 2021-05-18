package d.a.k0.z1.d;

import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import d.a.j0.b.d;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final C1760a f63680a = new C1760a(null);

    /* renamed from: d.a.k0.z1.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C1760a {
        public C1760a() {
        }

        @JvmStatic
        public final void a(int i2, int i3, int i4) {
            int i5;
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_INTEREST_GUIDE_CLICK);
            statisticItem.param("obj_name", i2);
            if (d.k()) {
                i5 = 1;
            } else {
                i5 = d.l() ? 2 : 3;
            }
            statisticItem.param("obj_type", i5);
            statisticItem.param("obj_locate", i3);
            statisticItem.param("obj_source", i4);
            TiebaStatic.log(statisticItem);
        }

        @JvmStatic
        public final void b(int i2, int i3) {
            int i4;
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_INTEREST_GUIDE_SHOW);
            statisticItem.param("obj_name", i2);
            if (d.k()) {
                i4 = 1;
            } else {
                i4 = d.l() ? 2 : 3;
            }
            statisticItem.param("obj_type", i4);
            statisticItem.param("obj_source", i3);
            TiebaStatic.log(statisticItem);
        }

        public /* synthetic */ C1760a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @JvmStatic
    public static final void a(int i2, int i3, int i4) {
        f63680a.a(i2, i3, i4);
    }

    @JvmStatic
    public static final void b(int i2, int i3) {
        f63680a.b(i2, i3);
    }
}
