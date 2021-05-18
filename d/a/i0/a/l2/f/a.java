package d.a.i0.a.l2.f;

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
    public static final Pattern f43243a = Pattern.compile("([0-9]{1,2})[- ]([A-Za-z]{3,9})[- ]([0-9]{2,4})[ ]([0-9]{1,2}:[0-9][0-9]:[0-9][0-9])");

    /* renamed from: b  reason: collision with root package name */
    public static final Pattern f43244b = Pattern.compile("[ ]([A-Za-z]{3,9})[ ]+([0-9]{1,2})[ ]([0-9]{1,2}:[0-9][0-9]:[0-9][0-9])[ ]([0-9]{2,4})");

    /* renamed from: c  reason: collision with root package name */
    public static final SparseIntArray f43245c;

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f43246a;

        /* renamed from: b  reason: collision with root package name */
        public int f43247b;

        /* renamed from: c  reason: collision with root package name */
        public int f43248c;

        /* renamed from: d  reason: collision with root package name */
        public int f43249d;

        /* renamed from: e  reason: collision with root package name */
        public int f43250e;

        /* renamed from: f  reason: collision with root package name */
        public int f43251f;

        public b() {
            this.f43246a = -1;
            this.f43247b = -1;
            this.f43248c = -1;
            this.f43249d = -1;
            this.f43250e = -1;
            this.f43251f = -1;
        }

        public boolean a() {
            return this.f43246a == -1 || this.f43247b == -1 || this.f43248c == -1 || this.f43249d == -1 || this.f43250e == -1 || this.f43251f == -1;
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f43245c = sparseIntArray;
        sparseIntArray.put(d("jan"), 0);
        f43245c.put(d("feb"), 1);
        f43245c.put(d("mar"), 2);
        f43245c.put(d("apr"), 3);
        f43245c.put(d("may"), 4);
        f43245c.put(d("jun"), 5);
        f43245c.put(d("jul"), 6);
        f43245c.put(d("aug"), 7);
        f43245c.put(d("sep"), 8);
        f43245c.put(d("oct"), 9);
        f43245c.put(d("nov"), 10);
        f43245c.put(d("dec"), 11);
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
            return f43245c.get(d(matcher.group(i2)), -1);
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
        Matcher matcher = f43243a.matcher(str);
        if (matcher.find()) {
            bVar.f43248c = a(matcher, 1);
            bVar.f43247b = b(matcher, 2);
            bVar.f43246a = c(matcher, 3);
            f(bVar, matcher, 4);
        } else {
            Matcher matcher2 = f43244b.matcher(str);
            if (!matcher2.find()) {
                return -1L;
            }
            bVar.f43247b = b(matcher2, 1);
            bVar.f43248c = a(matcher2, 2);
            f(bVar, matcher2, 3);
            bVar.f43246a = c(matcher2, 4);
        }
        if (bVar.a()) {
            return -1L;
        }
        if (bVar.f43246a >= 2038) {
            bVar.f43246a = 2038;
            bVar.f43247b = 0;
            bVar.f43248c = 1;
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTimeZone(TimeZone.getTimeZone("UTC"));
        gregorianCalendar.set(bVar.f43246a, bVar.f43247b, bVar.f43248c, bVar.f43249d, bVar.f43250e, bVar.f43251f);
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
            bVar.f43249d = charAt;
            bVar.f43250e = ((group.charAt(i4) - '0') * 10) + (group.charAt(i5) - '0');
            int i6 = i3 + 1 + 1 + 1 + 1;
            bVar.f43251f = ((group.charAt(i6) - '0') * 10) + (group.charAt(i6 + 1) - '0');
        } catch (Exception unused) {
        }
    }
}
