package d.c.c.b.c;

import java.util.Map;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public boolean f65649a = false;

    /* renamed from: b  reason: collision with root package name */
    public boolean f65650b = true;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, Integer> f65651c = null;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, String> f65652d = null;

    /* renamed from: e  reason: collision with root package name */
    public int f65653e = 10;

    /* renamed from: f  reason: collision with root package name */
    public int f65654f = 1;

    /* renamed from: g  reason: collision with root package name */
    public int f65655g = 1;

    /* renamed from: h  reason: collision with root package name */
    public int f65656h = 10;
    public int i = 1;
    public int j = 1;
    public int k = 900;
    public int l = 120;
    public String m = null;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" localEnable: ");
        sb.append(this.f65649a);
        sb.append(" probeEnable: ");
        sb.append(this.f65650b);
        sb.append(" hostFilter: ");
        Map<String, Integer> map = this.f65651c;
        sb.append(map != null ? map.size() : 0);
        sb.append(" hostMap: ");
        Map<String, String> map2 = this.f65652d;
        sb.append(map2 != null ? map2.size() : 0);
        sb.append(" reqTo: ");
        sb.append(this.f65653e);
        sb.append("#");
        sb.append(this.f65654f);
        sb.append("#");
        sb.append(this.f65655g);
        sb.append(" reqErr: ");
        sb.append(this.f65656h);
        sb.append("#");
        sb.append(this.i);
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
