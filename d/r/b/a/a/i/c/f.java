package d.r.b.a.a.i.c;

import java.util.Map;
/* loaded from: classes7.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public Map<Integer, a> f67078a;

    /* renamed from: b  reason: collision with root package name */
    public Map<Integer, b> f67079b;

    /* renamed from: c  reason: collision with root package name */
    public long f67080c;

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f67081a;

        /* renamed from: b  reason: collision with root package name */
        public long f67082b;

        /* renamed from: c  reason: collision with root package name */
        public long f67083c;

        /* renamed from: d  reason: collision with root package name */
        public int f67084d;

        /* renamed from: e  reason: collision with root package name */
        public long f67085e;

        /* renamed from: f  reason: collision with root package name */
        public String f67086f;

        public String toString() {
            return "Account{currencyType=" + this.f67081a + ", amount=" + this.f67082b + ", freezed=" + this.f67083c + ", accountFrozen=" + this.f67084d + ", expireAmount = " + this.f67085e + ", expireDate = " + this.f67086f + '}';
        }
    }

    /* loaded from: classes7.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f67087a;

        /* renamed from: b  reason: collision with root package name */
        public int f67088b;

        /* renamed from: c  reason: collision with root package name */
        public long f67089c;

        /* renamed from: d  reason: collision with root package name */
        public long f67090d;

        public String toString() {
            return "AccountPeriod{currencyType=" + this.f67087a + ", amount=" + this.f67088b + ", startTime=" + this.f67089c + ", endTime=" + this.f67090d + '}';
        }
    }

    public f(Map<Integer, a> map, Map<Integer, b> map2, long j) {
        this.f67078a = map;
        this.f67079b = map2;
        this.f67080c = j;
    }

    public b a(int i2) {
        Map<Integer, b> map = this.f67079b;
        if (map != null && map.containsKey(Integer.valueOf(i2))) {
            return this.f67079b.get(Integer.valueOf(i2));
        }
        return new b();
    }

    public a b(int i2) {
        Map<Integer, a> map = this.f67078a;
        if (map != null && map.containsKey(Integer.valueOf(i2))) {
            return this.f67078a.get(Integer.valueOf(i2));
        }
        return new a();
    }

    public String toString() {
        return "MyBalanceInfo{myBalanceMap=" + this.f67078a + "minAmountLimit=" + this.f67080c + '}';
    }
}
