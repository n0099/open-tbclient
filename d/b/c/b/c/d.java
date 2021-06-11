package d.b.c.b.c;

import java.util.Map;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public boolean f69446a = false;

    /* renamed from: b  reason: collision with root package name */
    public boolean f69447b = true;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, Integer> f69448c = null;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, String> f69449d = null;

    /* renamed from: e  reason: collision with root package name */
    public int f69450e = 10;

    /* renamed from: f  reason: collision with root package name */
    public int f69451f = 1;

    /* renamed from: g  reason: collision with root package name */
    public int f69452g = 1;

    /* renamed from: h  reason: collision with root package name */
    public int f69453h = 10;

    /* renamed from: i  reason: collision with root package name */
    public int f69454i = 1;
    public int j = 1;
    public int k = 900;
    public int l = 120;
    public String m = null;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" localEnable: ");
        sb.append(this.f69446a);
        sb.append(" probeEnable: ");
        sb.append(this.f69447b);
        sb.append(" hostFilter: ");
        Map<String, Integer> map = this.f69448c;
        sb.append(map != null ? map.size() : 0);
        sb.append(" hostMap: ");
        Map<String, String> map2 = this.f69449d;
        sb.append(map2 != null ? map2.size() : 0);
        sb.append(" reqTo: ");
        sb.append(this.f69450e);
        sb.append("#");
        sb.append(this.f69451f);
        sb.append("#");
        sb.append(this.f69452g);
        sb.append(" reqErr: ");
        sb.append(this.f69453h);
        sb.append("#");
        sb.append(this.f69454i);
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
