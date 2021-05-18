package d.a.k0.d3.j0;

import android.os.Build;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.fsg.face.liveness.activity.LivenessRecogActivity;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import d.a.c.e.p.k;
/* loaded from: classes5.dex */
public class a {

    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final String f53854a;

        /* renamed from: b  reason: collision with root package name */
        public final String f53855b;

        /* renamed from: c  reason: collision with root package name */
        public final String f53856c;

        /* renamed from: d  reason: collision with root package name */
        public final String f53857d;

        /* renamed from: e  reason: collision with root package name */
        public final String f53858e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f53859f;

        /* renamed from: g  reason: collision with root package name */
        public final StatisticItem f53860g;

        public final StatisticItem b() {
            StatisticItem statisticItem = new StatisticItem(this.f53854a);
            if (!StringUtils.isNull(this.f53855b)) {
                statisticItem = statisticItem.param("line", this.f53855b);
            }
            if (!StringUtils.isNull(this.f53856c)) {
                statisticItem = statisticItem.param("page", this.f53856c);
            }
            if (!StringUtils.isNull(this.f53857d)) {
                statisticItem = statisticItem.param("locate", this.f53857d);
            }
            return !StringUtils.isNull(this.f53858e) ? statisticItem.param("task", this.f53858e) : statisticItem;
        }

        public void c(String str) {
            this.f53860g.delete(str);
        }

        public final StatisticItem d(String str, String str2, String str3, String str4, String str5) {
            if (!StringUtils.isNull(str)) {
                this.f53860g.param(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, str);
            }
            if (!StringUtils.isNull(str2)) {
                this.f53860g.param("obj_id", str2);
            }
            if (!StringUtils.isNull(str3)) {
                this.f53860g.param("fid", str3);
            }
            if (!StringUtils.isNull(str4)) {
                this.f53860g.param("fname", str4);
            }
            if (!StringUtils.isNull(str5)) {
                this.f53860g.param("tid", str5);
            }
            this.f53860g.param("obj_cpid", 0).param("obj_good_id", 0).param("obj_throw_type", "BY_POST").param("client_type", "MOBILE_APP").param("user_timestamp", String.valueOf(System.currentTimeMillis())).param(IAdRequestParam.OS, "android").param("os_version", Build.VERSION.RELEASE).param("log_ver", "1.1");
            return this.f53860g;
        }

        public b e(String str, String str2) {
            if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                this.f53860g.param(str, str2);
            }
            return this;
        }

        public void f() {
            TiebaStatic.log(this.f53860g);
            if (this.f53859f) {
                return;
            }
            if (!TbadkCoreApplication.getInst().isDebugMode()) {
                BdLog.e("Invalid parameter.");
                return;
            }
            throw new IllegalArgumentException();
        }

        public b(String str, String str2, String str3, String str4, String str5) {
            this.f53854a = str;
            this.f53855b = str2;
            this.f53856c = str3;
            this.f53857d = str4;
            this.f53858e = str5;
            this.f53859f = !(StringUtils.isNull(str) || StringUtils.isNull(str2) || StringUtils.isNull(str3) || StringUtils.isNull(str4) || StringUtils.isNull(str5));
            this.f53860g = b();
        }
    }

    /* loaded from: classes5.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public String f53861a;

        /* renamed from: b  reason: collision with root package name */
        public String f53862b;

        /* renamed from: c  reason: collision with root package name */
        public int f53863c;
    }

    public static b a(String str, String str2, String str3, String str4, String str5, String str6) {
        b bVar = new b("ad_tpoint", "PT", str, str2, "tpoint");
        bVar.d(null, null, str3, str4, str5);
        if (!k.isEmpty(str6)) {
            bVar.e("obj_ref", str6);
        }
        return bVar;
    }

    public static b b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        b bVar = new b(str, str2, str3, str4, str5);
        bVar.d(str6, str7, str8, str9, str10);
        return bVar;
    }

    @Deprecated
    public static void c(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        b bVar = new b("ad_tpoint", "PT", str, "c0122", "ad_plat");
        bVar.d(str2, str7, str3, str4, str5);
        bVar.e(TiebaStatic.Params.OBJ_URL, str6);
        bVar.f();
    }

    @Deprecated
    public static void d(String str, String str2) {
        if (k.isEmpty(str)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(str);
        if (str2 != null) {
            statisticItem = statisticItem.param("obj_type", str2);
        }
        TiebaStatic.log(statisticItem);
    }
}
