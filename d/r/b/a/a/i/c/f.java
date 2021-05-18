package d.r.b.a.a.i.c;

import java.util.Map;
/* loaded from: classes7.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public Map<Integer, a> f67764a;

    /* renamed from: b  reason: collision with root package name */
    public Map<Integer, b> f67765b;

    /* renamed from: c  reason: collision with root package name */
    public long f67766c;

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f67767a;

        /* renamed from: b  reason: collision with root package name */
        public long f67768b;

        /* renamed from: c  reason: collision with root package name */
        public long f67769c;

        /* renamed from: d  reason: collision with root package name */
        public int f67770d;

        /* renamed from: e  reason: collision with root package name */
        public long f67771e;

        /* renamed from: f  reason: collision with root package name */
        public String f67772f;

        public String toString() {
            return "Account{currencyType=" + this.f67767a + ", amount=" + this.f67768b + ", freezed=" + this.f67769c + ", accountFrozen=" + this.f67770d + ", expireAmount = " + this.f67771e + ", expireDate = " + this.f67772f + '}';
        }
    }

    /* loaded from: classes7.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f67773a;

        /* renamed from: b  reason: collision with root package name */
        public int f67774b;

        /* renamed from: c  reason: collision with root package name */
        public long f67775c;

        /* renamed from: d  reason: collision with root package name */
        public long f67776d;

        public String toString() {
            return "AccountPeriod{currencyType=" + this.f67773a + ", amount=" + this.f67774b + ", startTime=" + this.f67775c + ", endTime=" + this.f67776d + '}';
        }
    }

    public f(Map<Integer, a> map, Map<Integer, b> map2, long j) {
        this.f67764a = map;
        this.f67765b = map2;
        this.f67766c = j;
    }

    public b a(int i2) {
        Map<Integer, b> map = this.f67765b;
        if (map != null && map.containsKey(Integer.valueOf(i2))) {
            return this.f67765b.get(Integer.valueOf(i2));
        }
        return new b();
    }

    public a b(int i2) {
        Map<Integer, a> map = this.f67764a;
        if (map != null && map.containsKey(Integer.valueOf(i2))) {
            return this.f67764a.get(Integer.valueOf(i2));
        }
        return new a();
    }

    public String toString() {
        return "MyBalanceInfo{myBalanceMap=" + this.f67764a + "minAmountLimit=" + this.f67766c + '}';
    }
}
