package d.b.j0.d3.j0;

import android.os.Build;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.fsg.face.liveness.activity.LivenessRecogActivity;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import d.b.c.e.p.k;
/* loaded from: classes5.dex */
public class a {

    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final String f55308a;

        /* renamed from: b  reason: collision with root package name */
        public final String f55309b;

        /* renamed from: c  reason: collision with root package name */
        public final String f55310c;

        /* renamed from: d  reason: collision with root package name */
        public final String f55311d;

        /* renamed from: e  reason: collision with root package name */
        public final String f55312e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f55313f;

        /* renamed from: g  reason: collision with root package name */
        public final StatisticItem f55314g;

        public final StatisticItem b() {
            StatisticItem statisticItem = new StatisticItem(this.f55308a);
            if (!StringUtils.isNull(this.f55309b)) {
                statisticItem = statisticItem.param("line", this.f55309b);
            }
            if (!StringUtils.isNull(this.f55310c)) {
                statisticItem = statisticItem.param("page", this.f55310c);
            }
            if (!StringUtils.isNull(this.f55311d)) {
                statisticItem = statisticItem.param("locate", this.f55311d);
            }
            return !StringUtils.isNull(this.f55312e) ? statisticItem.param("task", this.f55312e) : statisticItem;
        }

        public void c(String str) {
            this.f55314g.delete(str);
        }

        public final StatisticItem d(String str, String str2, String str3, String str4, String str5) {
            if (!StringUtils.isNull(str)) {
                this.f55314g.param(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, str);
            }
            if (!StringUtils.isNull(str2)) {
                this.f55314g.param("obj_id", str2);
            }
            if (!StringUtils.isNull(str3)) {
                this.f55314g.param("fid", str3);
            }
            if (!StringUtils.isNull(str4)) {
                this.f55314g.param("fname", str4);
            }
            if (!StringUtils.isNull(str5)) {
                this.f55314g.param("tid", str5);
            }
            this.f55314g.param("obj_cpid", 0).param("obj_good_id", 0).param("obj_throw_type", "BY_POST").param("client_type", "MOBILE_APP").param("user_timestamp", String.valueOf(System.currentTimeMillis())).param(IAdRequestParam.OS, "android").param("os_version", Build.VERSION.RELEASE).param("log_ver", "1.1");
            return this.f55314g;
        }

        public b e(String str, String str2) {
            if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                this.f55314g.param(str, str2);
            }
            return this;
        }

        public void f() {
            TiebaStatic.log(this.f55314g);
            if (this.f55313f) {
                return;
            }
            if (!TbadkCoreApplication.getInst().isDebugMode()) {
                BdLog.e("Invalid parameter.");
                return;
            }
            throw new IllegalArgumentException();
        }

        public b(String str, String str2, String str3, String str4, String str5) {
            this.f55308a = str;
            this.f55309b = str2;
            this.f55310c = str3;
            this.f55311d = str4;
            this.f55312e = str5;
            this.f55313f = !(StringUtils.isNull(str) || StringUtils.isNull(str2) || StringUtils.isNull(str3) || StringUtils.isNull(str4) || StringUtils.isNull(str5));
            this.f55314g = b();
        }
    }

    /* loaded from: classes5.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public String f55315a;

        /* renamed from: b  reason: collision with root package name */
        public String f55316b;

        /* renamed from: c  reason: collision with root package name */
        public int f55317c;
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
