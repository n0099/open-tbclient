package d.b.i0.y1.d;

import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import d.b.h0.b.d;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final C1677a f62590a = new C1677a(null);

    /* renamed from: d.b.i0.y1.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C1677a {
        public C1677a() {
        }

        @JvmStatic
        public final void a(int i, int i2, int i3) {
            int i4;
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_INTEREST_GUIDE_CLICK);
            statisticItem.param("obj_name", i);
            if (d.j()) {
                i4 = 1;
            } else {
                i4 = d.k() ? 2 : 3;
            }
            statisticItem.param("obj_type", i4);
            statisticItem.param("obj_locate", i2);
            statisticItem.param("obj_source", i3);
            TiebaStatic.log(statisticItem);
        }

        @JvmStatic
        public final void b(int i, int i2) {
            int i3;
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_INTEREST_GUIDE_SHOW);
            statisticItem.param("obj_name", i);
            if (d.j()) {
                i3 = 1;
            } else {
                i3 = d.k() ? 2 : 3;
            }
            statisticItem.param("obj_type", i3);
            statisticItem.param("obj_source", i2);
            TiebaStatic.log(statisticItem);
        }

        public /* synthetic */ C1677a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @JvmStatic
    public static final void a(int i, int i2, int i3) {
        f62590a.a(i, i2, i3);
    }

    @JvmStatic
    public static final void b(int i, int i2) {
        f62590a.b(i, i2);
    }
}
