package d.a.o0.k2;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.tencent.connect.common.Constants;
/* loaded from: classes5.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public String f60712a;

    /* renamed from: b  reason: collision with root package name */
    public String f60713b;

    /* renamed from: c  reason: collision with root package name */
    public String f60714c;

    /* renamed from: d  reason: collision with root package name */
    public String f60715d;

    /* renamed from: e  reason: collision with root package name */
    public String f60716e;

    /* renamed from: f  reason: collision with root package name */
    public String f60717f;

    /* renamed from: g  reason: collision with root package name */
    public String f60718g;

    /* renamed from: h  reason: collision with root package name */
    public String f60719h;

    /* renamed from: i  reason: collision with root package name */
    public String f60720i;
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
                        if (hashCode != 1599) {
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
                                        } else if (str.equals("11")) {
                                            c2 = 5;
                                        }
                                    } else if (str.equals("10")) {
                                        c2 = 4;
                                    }
                                } else if (str.equals("9")) {
                                    c2 = '\b';
                                }
                            } else if (str.equals("8")) {
                                c2 = 7;
                            }
                        } else if (str.equals(Constants.VIA_REPORT_TYPE_QQFAVORITES)) {
                            c2 = 11;
                        }
                    } else if (str.equals(Constants.VIA_ACT_TYPE_NINETEEN)) {
                        c2 = '\t';
                    }
                } else if (str.equals("13")) {
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
                case 11:
                    return "a088";
                default:
                    return "";
            }
        }
    }

    public StatisticItem a(StatisticItem statisticItem) {
        if (statisticItem != null) {
            if (!StringUtils.isNull(this.f60712a)) {
                statisticItem.param("obj_locate", this.f60712a);
                statisticItem.param("page_type", a.a(this.f60712a));
            }
            if (!StringUtils.isNull(this.f60714c)) {
                statisticItem.param("tid", this.f60714c);
            }
            if (!StringUtils.isNull(this.f60715d)) {
                statisticItem.param("fid", this.f60715d);
            }
            if (!StringUtils.isNull(this.f60716e)) {
                statisticItem.param("uid", this.f60716e);
            }
            if (!StringUtils.isNull(this.f60717f)) {
                statisticItem.param("obj_source", this.f60717f);
            } else {
                statisticItem.param("obj_source", 0);
            }
            if (!StringUtils.isNull(this.f60718g)) {
                statisticItem.param("obj_param1", this.f60718g);
            } else {
                statisticItem.param("obj_param1", 0);
            }
            if (!StringUtils.isNull(this.f60719h)) {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, this.f60719h);
            }
            if (!StringUtils.isNull(this.f60720i)) {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, this.f60720i);
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
        oVar.f60712a = this.f60712a;
        oVar.f60713b = this.f60713b;
        oVar.f60714c = this.f60714c;
        oVar.f60715d = this.f60715d;
        oVar.f60716e = this.f60716e;
        oVar.f60717f = this.f60717f;
        oVar.f60718g = this.f60718g;
        oVar.f60719h = this.f60719h;
        oVar.f60720i = this.f60720i;
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
