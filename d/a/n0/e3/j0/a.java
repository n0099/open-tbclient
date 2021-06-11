package d.a.n0.e3.j0;

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
        public final String f57756a;

        /* renamed from: b  reason: collision with root package name */
        public final String f57757b;

        /* renamed from: c  reason: collision with root package name */
        public final String f57758c;

        /* renamed from: d  reason: collision with root package name */
        public final String f57759d;

        /* renamed from: e  reason: collision with root package name */
        public final String f57760e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f57761f;

        /* renamed from: g  reason: collision with root package name */
        public final StatisticItem f57762g;

        public final StatisticItem b() {
            StatisticItem statisticItem = new StatisticItem(this.f57756a);
            if (!StringUtils.isNull(this.f57757b)) {
                statisticItem = statisticItem.param("line", this.f57757b);
            }
            if (!StringUtils.isNull(this.f57758c)) {
                statisticItem = statisticItem.param("page", this.f57758c);
            }
            if (!StringUtils.isNull(this.f57759d)) {
                statisticItem = statisticItem.param("locate", this.f57759d);
            }
            return !StringUtils.isNull(this.f57760e) ? statisticItem.param("task", this.f57760e) : statisticItem;
        }

        public void c(String str) {
            this.f57762g.delete(str);
        }

        public final StatisticItem d(String str, String str2, String str3, String str4, String str5) {
            if (!StringUtils.isNull(str)) {
                this.f57762g.param(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, str);
            }
            if (!StringUtils.isNull(str2)) {
                this.f57762g.param("obj_id", str2);
            }
            if (!StringUtils.isNull(str3)) {
                this.f57762g.param("fid", str3);
            }
            if (!StringUtils.isNull(str4)) {
                this.f57762g.param("fname", str4);
            }
            if (!StringUtils.isNull(str5)) {
                this.f57762g.param("tid", str5);
            }
            this.f57762g.param("obj_cpid", 0).param("obj_good_id", 0).param("obj_throw_type", "BY_POST").param("client_type", "MOBILE_APP").param("user_timestamp", String.valueOf(System.currentTimeMillis())).param(IAdRequestParam.OS, "android").param("os_version", Build.VERSION.RELEASE).param("log_ver", "1.1");
            return this.f57762g;
        }

        public b e(String str, String str2) {
            if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                this.f57762g.param(str, str2);
            }
            return this;
        }

        public void f() {
            TiebaStatic.log(this.f57762g);
            if (this.f57761f) {
                return;
            }
            if (!TbadkCoreApplication.getInst().isDebugMode()) {
                BdLog.e("Invalid parameter.");
                return;
            }
            throw new IllegalArgumentException();
        }

        public b(String str, String str2, String str3, String str4, String str5) {
            this.f57756a = str;
            this.f57757b = str2;
            this.f57758c = str3;
            this.f57759d = str4;
            this.f57760e = str5;
            this.f57761f = !(StringUtils.isNull(str) || StringUtils.isNull(str2) || StringUtils.isNull(str3) || StringUtils.isNull(str4) || StringUtils.isNull(str5));
            this.f57762g = b();
        }
    }

    /* loaded from: classes5.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public String f57763a;

        /* renamed from: b  reason: collision with root package name */
        public String f57764b;

        /* renamed from: c  reason: collision with root package name */
        public int f57765c;
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
