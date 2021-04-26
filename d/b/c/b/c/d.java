package d.b.c.b.c;

import java.util.Map;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public boolean f64986a = false;

    /* renamed from: b  reason: collision with root package name */
    public boolean f64987b = true;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, Integer> f64988c = null;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, String> f64989d = null;

    /* renamed from: e  reason: collision with root package name */
    public int f64990e = 10;

    /* renamed from: f  reason: collision with root package name */
    public int f64991f = 1;

    /* renamed from: g  reason: collision with root package name */
    public int f64992g = 1;

    /* renamed from: h  reason: collision with root package name */
    public int f64993h = 10;

    /* renamed from: i  reason: collision with root package name */
    public int f64994i = 1;
    public int j = 1;
    public int k = 900;
    public int l = 120;
    public String m = null;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" localEnable: ");
        sb.append(this.f64986a);
        sb.append(" probeEnable: ");
        sb.append(this.f64987b);
        sb.append(" hostFilter: ");
        Map<String, Integer> map = this.f64988c;
        sb.append(map != null ? map.size() : 0);
        sb.append(" hostMap: ");
        Map<String, String> map2 = this.f64989d;
        sb.append(map2 != null ? map2.size() : 0);
        sb.append(" reqTo: ");
        sb.append(this.f64990e);
        sb.append("#");
        sb.append(this.f64991f);
        sb.append("#");
        sb.append(this.f64992g);
        sb.append(" reqErr: ");
        sb.append(this.f64993h);
        sb.append("#");
        sb.append(this.f64994i);
        sb.append("#");
        sb.append(this.j);
        sb.append(" updateInterval: ");
        sb.append(this.k);
        sb.append(" updateRandom: ");
        sb.append(this.l);
        sb.append(" httpBlack: ");
        sb.append(this.m);
        return sb.toString();
    }
}
