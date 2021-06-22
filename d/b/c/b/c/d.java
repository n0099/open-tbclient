package d.b.c.b.c;

import java.util.Map;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public boolean f69550a = false;

    /* renamed from: b  reason: collision with root package name */
    public boolean f69551b = true;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, Integer> f69552c = null;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, String> f69553d = null;

    /* renamed from: e  reason: collision with root package name */
    public int f69554e = 10;

    /* renamed from: f  reason: collision with root package name */
    public int f69555f = 1;

    /* renamed from: g  reason: collision with root package name */
    public int f69556g = 1;

    /* renamed from: h  reason: collision with root package name */
    public int f69557h = 10;

    /* renamed from: i  reason: collision with root package name */
    public int f69558i = 1;
    public int j = 1;
    public int k = 900;
    public int l = 120;
    public String m = null;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" localEnable: ");
        sb.append(this.f69550a);
        sb.append(" probeEnable: ");
        sb.append(this.f69551b);
        sb.append(" hostFilter: ");
        Map<String, Integer> map = this.f69552c;
        sb.append(map != null ? map.size() : 0);
        sb.append(" hostMap: ");
        Map<String, String> map2 = this.f69553d;
        sb.append(map2 != null ? map2.size() : 0);
        sb.append(" reqTo: ");
        sb.append(this.f69554e);
        sb.append("#");
        sb.append(this.f69555f);
        sb.append("#");
        sb.append(this.f69556g);
        sb.append(" reqErr: ");
        sb.append(this.f69557h);
        sb.append("#");
        sb.append(this.f69558i);
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
