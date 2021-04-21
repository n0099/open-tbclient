package d.b.j0.j2;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.tencent.connect.common.Constants;
/* loaded from: classes3.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public String f58032a;

    /* renamed from: b  reason: collision with root package name */
    public String f58033b;

    /* renamed from: c  reason: collision with root package name */
    public String f58034c;

    /* renamed from: d  reason: collision with root package name */
    public String f58035d;

    /* renamed from: e  reason: collision with root package name */
    public String f58036e;

    /* renamed from: f  reason: collision with root package name */
    public String f58037f;

    /* renamed from: g  reason: collision with root package name */
    public String f58038g;

    /* renamed from: h  reason: collision with root package name */
    public String f58039h;
    public String i;
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

    /* loaded from: classes3.dex */
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
            if (!StringUtils.isNull(this.f58032a)) {
                statisticItem.param("obj_locate", this.f58032a);
                statisticItem.param("page_type", a.a(this.f58032a));
            }
            if (!StringUtils.isNull(this.f58034c)) {
                statisticItem.param("tid", this.f58034c);
            }
            if (!StringUtils.isNull(this.f58035d)) {
                statisticItem.param("fid", this.f58035d);
            }
            if (!StringUtils.isNull(this.f58036e)) {
                statisticItem.param("uid", this.f58036e);
            }
            if (!StringUtils.isNull(this.f58037f)) {
                statisticItem.param("obj_source", this.f58037f);
            } else {
                statisticItem.param("obj_source", 0);
            }
            if (!StringUtils.isNull(this.f58038g)) {
                statisticItem.param("obj_param1", this.f58038g);
            } else {
                statisticItem.param("obj_param1", 0);
            }
            if (!StringUtils.isNull(this.f58039h)) {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, this.f58039h);
            }
            if (!StringUtils.isNull(this.i)) {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, this.i);
            }
            int i = this.j;
            if (i > 0) {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, i);
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
        oVar.f58032a = this.f58032a;
        oVar.f58033b = this.f58033b;
        oVar.f58034c = this.f58034c;
        oVar.f58035d = this.f58035d;
        oVar.f58036e = this.f58036e;
        oVar.f58037f = this.f58037f;
        oVar.f58038g = this.f58038g;
        oVar.f58039h = this.f58039h;
        oVar.i = this.i;
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
