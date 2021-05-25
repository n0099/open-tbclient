package d.b.c.b.c;

import java.util.Map;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public boolean f65715a = false;

    /* renamed from: b  reason: collision with root package name */
    public boolean f65716b = true;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, Integer> f65717c = null;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, String> f65718d = null;

    /* renamed from: e  reason: collision with root package name */
    public int f65719e = 10;

    /* renamed from: f  reason: collision with root package name */
    public int f65720f = 1;

    /* renamed from: g  reason: collision with root package name */
    public int f65721g = 1;

    /* renamed from: h  reason: collision with root package name */
    public int f65722h = 10;

    /* renamed from: i  reason: collision with root package name */
    public int f65723i = 1;
    public int j = 1;
    public int k = 900;
    public int l = 120;
    public String m = null;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" localEnable: ");
        sb.append(this.f65715a);
        sb.append(" probeEnable: ");
        sb.append(this.f65716b);
        sb.append(" hostFilter: ");
        Map<String, Integer> map = this.f65717c;
        sb.append(map != null ? map.size() : 0);
        sb.append(" hostMap: ");
        Map<String, String> map2 = this.f65718d;
        sb.append(map2 != null ? map2.size() : 0);
        sb.append(" reqTo: ");
        sb.append(this.f65719e);
        sb.append("#");
        sb.append(this.f65720f);
        sb.append("#");
        sb.append(this.f65721g);
        sb.append(" reqErr: ");
        sb.append(this.f65722h);
        sb.append("#");
        sb.append(this.f65723i);
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
