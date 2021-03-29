package d.b.h0.r.y;

import android.util.Log;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static final c f51078a = new b();

    /* renamed from: b  reason: collision with root package name */
    public static final c f51079b = new d();

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f51080c;

    /* loaded from: classes3.dex */
    public static final class b implements c {
        public b() {
        }

        @Override // d.b.h0.r.y.e.c
        public void a(String str, String str2, String str3) {
            if (str2 != null) {
                str3 = "code:" + str2 + " message:" + str3;
            }
            Log.e("BridgeLogger", str3);
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(String str, String str2, String str3);
    }

    /* loaded from: classes3.dex */
    public static final class d implements c {
        public d() {
        }

        @Override // d.b.h0.r.y.e.c
        public void a(String str, String str2, String str3) {
            StatisticItem statisticItem = new StatisticItem("c10729");
            statisticItem.param("obj_param1", str);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, str2);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, str3);
            if (BdBaseApplication.getInst() != null) {
                TiebaStatic.log(statisticItem);
            }
        }
    }

    static {
        f51080c = BdBaseApplication.getInst() == null || BdBaseApplication.getInst().isDebugMode();
    }

    public static void a(String str) {
        if (f51080c) {
            f51078a.a(null, null, str);
        }
    }

    public static void b(String str, String str2, String str3) {
        a(str3);
    }

    public static void c(String str, String str2, String str3) {
        if (f51080c) {
            f51078a.a(str, str2, str3);
        }
        f51079b.a(str, str2, str3);
    }
}
