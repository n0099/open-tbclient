package d.a.l0.a.l2.f;

import android.text.TextUtils;
import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f47093a = Pattern.compile("([0-9]{1,2})[- ]([A-Za-z]{3,9})[- ]([0-9]{2,4})[ ]([0-9]{1,2}:[0-9][0-9]:[0-9][0-9])");

    /* renamed from: b  reason: collision with root package name */
    public static final Pattern f47094b = Pattern.compile("[ ]([A-Za-z]{3,9})[ ]+([0-9]{1,2})[ ]([0-9]{1,2}:[0-9][0-9]:[0-9][0-9])[ ]([0-9]{2,4})");

    /* renamed from: c  reason: collision with root package name */
    public static final SparseIntArray f47095c;

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f47096a;

        /* renamed from: b  reason: collision with root package name */
        public int f47097b;

        /* renamed from: c  reason: collision with root package name */
        public int f47098c;

        /* renamed from: d  reason: collision with root package name */
        public int f47099d;

        /* renamed from: e  reason: collision with root package name */
        public int f47100e;

        /* renamed from: f  reason: collision with root package name */
        public int f47101f;

        public b() {
            this.f47096a = -1;
            this.f47097b = -1;
            this.f47098c = -1;
            this.f47099d = -1;
            this.f47100e = -1;
            this.f47101f = -1;
        }

        public boolean a() {
            return this.f47096a == -1 || this.f47097b == -1 || this.f47098c == -1 || this.f47099d == -1 || this.f47100e == -1 || this.f47101f == -1;
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f47095c = sparseIntArray;
        sparseIntArray.put(d("jan"), 0);
        f47095c.put(d("feb"), 1);
        f47095c.put(d("mar"), 2);
        f47095c.put(d("apr"), 3);
        f47095c.put(d("may"), 4);
        f47095c.put(d("jun"), 5);
        f47095c.put(d("jul"), 6);
        f47095c.put(d("aug"), 7);
        f47095c.put(d("sep"), 8);
        f47095c.put(d("oct"), 9);
        f47095c.put(d("nov"), 10);
        f47095c.put(d("dec"), 11);
    }

    public static int a(@NonNull Matcher matcher, int i2) {
        try {
            String group = matcher.group(i2);
            if (TextUtils.isEmpty(group)) {
                return -1;
            }
            if (group.length() == 2) {
                return ((group.charAt(0) - '0') * 10) + (group.charAt(1) - '0');
            }
            return group.charAt(0) - '0';
        } catch (Exception unused) {
            return -1;
        }
    }

    public static int b(@NonNull Matcher matcher, int i2) {
        try {
            return f47095c.get(d(matcher.group(i2)), -1);
        } catch (Exception unused) {
            return -1;
        }
    }

    public static int c(@NonNull Matcher matcher, int i2) {
        try {
            String group = matcher.group(i2);
            if (TextUtils.isEmpty(group)) {
                return -1;
            }
            if (group.length() == 2) {
                int charAt = ((group.charAt(0) - '0') * 10) + (group.charAt(1) - '0');
                return charAt >= 70 ? charAt + 1900 : charAt + 2000;
            } else if (group.length() == 3) {
                return ((group.charAt(0) - '0') * 100) + ((group.charAt(1) - '0') * 10) + (group.charAt(2) - '0') + 1900;
            } else {
                if (group.length() == 4) {
                    return ((group.charAt(0) - '0') * 1000) + ((group.charAt(1) - '0') * 100) + ((group.charAt(2) - '0') * 10) + (group.charAt(3) - '0');
                }
                return 1970;
            }
        } catch (Exception unused) {
            return -1;
        }
    }

    public static int d(String str) {
        int i2 = -1;
        if (!TextUtils.isEmpty(str) && str.length() >= 3) {
            for (int i3 = 0; i3 < 3; i3++) {
                i2 += Character.toLowerCase(str.charAt(i3)) - 'a';
            }
        }
        return i2;
    }

    public static long e(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1L;
        }
        b bVar = new b();
        Matcher matcher = f47093a.matcher(str);
        if (matcher.find()) {
            bVar.f47098c = a(matcher, 1);
            bVar.f47097b = b(matcher, 2);
            bVar.f47096a = c(matcher, 3);
            f(bVar, matcher, 4);
        } else {
            Matcher matcher2 = f47094b.matcher(str);
            if (!matcher2.find()) {
                return -1L;
            }
            bVar.f47097b = b(matcher2, 1);
            bVar.f47098c = a(matcher2, 2);
            f(bVar, matcher2, 3);
            bVar.f47096a = c(matcher2, 4);
        }
        if (bVar.a()) {
            return -1L;
        }
        if (bVar.f47096a >= 2038) {
            bVar.f47096a = 2038;
            bVar.f47097b = 0;
            bVar.f47098c = 1;
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTimeZone(TimeZone.getTimeZone("UTC"));
        gregorianCalendar.set(bVar.f47096a, bVar.f47097b, bVar.f47098c, bVar.f47099d, bVar.f47100e, bVar.f47101f);
        return gregorianCalendar.getTimeInMillis();
    }

    public static void f(@NonNull b bVar, @NonNull Matcher matcher, int i2) {
        int i3;
        int i4;
        int i5;
        try {
            String group = matcher.group(i2);
            if (TextUtils.isEmpty(group)) {
                return;
            }
            int charAt = group.charAt(0) - '0';
            if (group.charAt(1) != ':') {
                i3 = 2;
                charAt = (charAt * 10) + (group.charAt(1) - '0');
            } else {
                i3 = 1;
            }
            bVar.f47099d = charAt;
            bVar.f47100e = ((group.charAt(i4) - '0') * 10) + (group.charAt(i5) - '0');
            int i6 = i3 + 1 + 1 + 1 + 1;
            bVar.f47101f = ((group.charAt(i6) - '0') * 10) + (group.charAt(i6 + 1) - '0');
        } catch (Exception unused) {
        }
    }
}
