package d.a.k0.j2;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.tencent.connect.common.Constants;
/* loaded from: classes5.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public String f56718a;

    /* renamed from: b  reason: collision with root package name */
    public String f56719b;

    /* renamed from: c  reason: collision with root package name */
    public String f56720c;

    /* renamed from: d  reason: collision with root package name */
    public String f56721d;

    /* renamed from: e  reason: collision with root package name */
    public String f56722e;

    /* renamed from: f  reason: collision with root package name */
    public String f56723f;

    /* renamed from: g  reason: collision with root package name */
    public String f56724g;

    /* renamed from: h  reason: collision with root package name */
    public String f56725h;

    /* renamed from: i  reason: collision with root package name */
    public String f56726i;
    public int j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public String r;
    public String s;
    public String t;
    public String u;
    public String v;

    /* loaded from: classes5.dex */
    public static class a {
        public static String a(String str) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            char c2 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != 54) {
                if (hashCode != 1570) {
                    if (hashCode != 1576) {
                        if (hashCode != 56) {
                            if (hashCode != 57) {
                                if (hashCode != 1567) {
                                    if (hashCode != 1568) {
                                        switch (hashCode) {
                                            case 49:
                                                if (str.equals("1")) {
                                                    c2 = 0;
                                                    break;
                                                }
                                                break;
                                            case 50:
                                                if (str.equals("2")) {
                                                    c2 = 1;
                                                    break;
                                                }
                                                break;
                                            case 51:
                                                if (str.equals("3")) {
                                                    c2 = 3;
                                                    break;
                                                }
                                                break;
                                            case 52:
                                                if (str.equals("4")) {
                                                    c2 = 2;
                                                    break;
                                                }
                                                break;
                                        }
                                    } else if (str.equals(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE)) {
                                        c2 = 5;
                                    }
                                } else if (str.equals("10")) {
                                    c2 = 4;
                                }
                            } else if (str.equals(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE9)) {
                                c2 = '\b';
                            }
                        } else if (str.equals("8")) {
                            c2 = 7;
                        }
                    } else if (str.equals(Constants.VIA_ACT_TYPE_NINETEEN)) {
                        c2 = '\t';
                    }
                } else if (str.equals(Constants.VIA_REPORT_TYPE_JOININ_GROUP)) {
                    c2 = '\n';
                }
            } else if (str.equals("6")) {
                c2 = 6;
            }
            switch (c2) {
                case 0:
                    return "a002";
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    return "a006";
                case 6:
                    return "a005";
                case 7:
                case '\b':
                case '\t':
                    return "a020";
                case '\n':
                    return "a023";
                default:
                    return "";
            }
        }
    }

    public StatisticItem a(StatisticItem statisticItem) {
        if (statisticItem != null) {
            if (!StringUtils.isNull(this.f56718a)) {
                statisticItem.param("obj_locate", this.f56718a);
                statisticItem.param("page_type", a.a(this.f56718a));
            }
            if (!StringUtils.isNull(this.f56720c)) {
                statisticItem.param("tid", this.f56720c);
            }
            if (!StringUtils.isNull(this.f56721d)) {
                statisticItem.param("fid", this.f56721d);
            }
            if (!StringUtils.isNull(this.f56722e)) {
                statisticItem.param("uid", this.f56722e);
            }
            if (!StringUtils.isNull(this.f56723f)) {
                statisticItem.param("obj_source", this.f56723f);
            } else {
                statisticItem.param("obj_source", 0);
            }
            if (!StringUtils.isNull(this.f56724g)) {
                statisticItem.param("obj_param1", this.f56724g);
            } else {
                statisticItem.param("obj_param1", 0);
            }
            if (!StringUtils.isNull(this.f56725h)) {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, this.f56725h);
            }
            if (!StringUtils.isNull(this.f56726i)) {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, this.f56726i);
            }
            int i2 = this.j;
            if (i2 > 0) {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, i2);
            }
            if (!StringUtils.isNull(this.k)) {
                statisticItem.param("obj_id", this.k);
            }
            if (!StringUtils.isNull(this.l)) {
                statisticItem.param("ab_tag", this.l);
            } else {
                statisticItem.param("ab_tag", 0);
            }
            if (!StringUtils.isNull(this.n)) {
                statisticItem.param("topic_type", this.n);
            }
            if (!StringUtils.isNull(this.o)) {
                statisticItem.param("extra", this.o);
            } else {
                statisticItem.param("extra", 0);
            }
            if (!StringUtils.isNull(this.p)) {
                statisticItem.param(TiebaStatic.Params.IS_VERTICAL, this.p);
            }
            if (!StringUtils.isNull(this.q)) {
                statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, this.q);
            }
            if (!StringUtils.isNull(this.r)) {
                statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.r);
            }
            if (!StringUtils.isNull(this.s)) {
                statisticItem.param("group_id", this.s);
            }
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, StringUtils.isNull(this.t) ? "" : this.t);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM6, StringUtils.isNull(this.u) ? "" : this.u);
            statisticItem.param("nid", StringUtils.isNull(this.v) ? "" : this.v);
        }
        return statisticItem;
    }

    public o b() {
        o oVar = new o();
        oVar.f56718a = this.f56718a;
        oVar.f56719b = this.f56719b;
        oVar.f56720c = this.f56720c;
        oVar.f56721d = this.f56721d;
        oVar.f56722e = this.f56722e;
        oVar.f56723f = this.f56723f;
        oVar.f56724g = this.f56724g;
        oVar.f56725h = this.f56725h;
        oVar.f56726i = this.f56726i;
        oVar.k = this.k;
        oVar.l = this.l;
        oVar.m = this.m;
        oVar.n = this.n;
        oVar.q = this.q;
        oVar.r = this.r;
        oVar.s = this.s;
        oVar.t = this.t;
        oVar.u = this.u;
        oVar.v = this.v;
        return oVar;
    }
}
