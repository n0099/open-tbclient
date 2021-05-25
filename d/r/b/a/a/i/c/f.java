package d.r.b.a.a.i.c;

import java.util.Map;
/* loaded from: classes7.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public Map<Integer, a> f67807a;

    /* renamed from: b  reason: collision with root package name */
    public Map<Integer, b> f67808b;

    /* renamed from: c  reason: collision with root package name */
    public long f67809c;

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f67810a;

        /* renamed from: b  reason: collision with root package name */
        public long f67811b;

        /* renamed from: c  reason: collision with root package name */
        public long f67812c;

        /* renamed from: d  reason: collision with root package name */
        public int f67813d;

        /* renamed from: e  reason: collision with root package name */
        public long f67814e;

        /* renamed from: f  reason: collision with root package name */
        public String f67815f;

        public String toString() {
            return "Account{currencyType=" + this.f67810a + ", amount=" + this.f67811b + ", freezed=" + this.f67812c + ", accountFrozen=" + this.f67813d + ", expireAmount = " + this.f67814e + ", expireDate = " + this.f67815f + '}';
        }
    }

    /* loaded from: classes7.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f67816a;

        /* renamed from: b  reason: collision with root package name */
        public int f67817b;

        /* renamed from: c  reason: collision with root package name */
        public long f67818c;

        /* renamed from: d  reason: collision with root package name */
        public long f67819d;

        public String toString() {
            return "AccountPeriod{currencyType=" + this.f67816a + ", amount=" + this.f67817b + ", startTime=" + this.f67818c + ", endTime=" + this.f67819d + '}';
        }
    }

    public f(Map<Integer, a> map, Map<Integer, b> map2, long j) {
        this.f67807a = map;
        this.f67808b = map2;
        this.f67809c = j;
    }

    public b a(int i2) {
        Map<Integer, b> map = this.f67808b;
        if (map != null && map.containsKey(Integer.valueOf(i2))) {
            return this.f67808b.get(Integer.valueOf(i2));
        }
        return new b();
    }

    public a b(int i2) {
        Map<Integer, a> map = this.f67807a;
        if (map != null && map.containsKey(Integer.valueOf(i2))) {
            return this.f67807a.get(Integer.valueOf(i2));
        }
        return new a();
    }

    public String toString() {
        return "MyBalanceInfo{myBalanceMap=" + this.f67807a + "minAmountLimit=" + this.f67809c + '}';
    }
}
