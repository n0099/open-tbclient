package d.b.g0.a.y0.e.f;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import d.b.g0.a.z1.c;
import java.util.ConcurrentModificationException;
/* loaded from: classes2.dex */
public interface a {

    /* renamed from: a  reason: collision with root package name */
    public static final d.b.g0.a.y0.e.f.b<Boolean> f47092a = new d(Boolean.FALSE);

    /* renamed from: b  reason: collision with root package name */
    public static final d.b.g0.a.y0.e.f.b<Integer> f47093b = new e(0);

    /* renamed from: c  reason: collision with root package name */
    public static final d.b.g0.a.y0.e.f.b<Long> f47094c = new f(0L);

    /* renamed from: d  reason: collision with root package name */
    public static final d.b.g0.a.y0.e.f.b<Float> f47095d = new g(Float.valueOf(0.0f));

    /* renamed from: e  reason: collision with root package name */
    public static final d.b.g0.a.y0.e.f.b<String> f47096e = new h();

    /* renamed from: f  reason: collision with root package name */
    public static final d.b.g0.a.y0.e.f.b<String[]> f47097f = new C0884a();

    /* renamed from: g  reason: collision with root package name */
    public static final d.b.g0.a.y0.e.f.b<Bundle> f47098g = new b();

    /* renamed from: h  reason: collision with root package name */
    public static final d.b.g0.a.y0.e.f.b<Parcelable> f47099h = new c();

    /* renamed from: d.b.g0.a.y0.e.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0884a extends d.b.g0.a.y0.e.f.b<String[]> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.y0.e.f.b
        /* renamed from: f */
        public String[] c(Bundle bundle, String str, String[] strArr) {
            return bundle.getStringArray(str);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.y0.e.f.b
        /* renamed from: g */
        public void e(Bundle bundle, String str, String[] strArr) {
            bundle.putStringArray(str, strArr);
        }
    }

    /* loaded from: classes2.dex */
    public static class b extends d.b.g0.a.y0.e.f.b<Bundle> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.y0.e.f.b
        /* renamed from: f */
        public Bundle c(Bundle bundle, String str, Bundle bundle2) {
            return bundle.getBundle(str);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.y0.e.f.b
        /* renamed from: g */
        public void e(Bundle bundle, String str, Bundle bundle2) {
            bundle.putBundle(str, bundle2);
        }
    }

    /* loaded from: classes2.dex */
    public static class c extends d.b.g0.a.y0.e.f.b<Parcelable> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.y0.e.f.b
        /* renamed from: f */
        public Parcelable c(Bundle bundle, String str, Parcelable parcelable) {
            return bundle.getParcelable(str);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.y0.e.f.b
        /* renamed from: g */
        public void e(Bundle bundle, String str, Parcelable parcelable) {
            bundle.putParcelable(str, parcelable);
        }
    }

    /* loaded from: classes2.dex */
    public static class d extends d.b.g0.a.y0.e.f.b<Boolean> {
        public d(Boolean bool) {
            super(bool);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.y0.e.f.b
        /* renamed from: f */
        public Boolean c(Bundle bundle, String str, Boolean bool) {
            return Boolean.valueOf(bundle.getBoolean(str, bool.booleanValue()));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.y0.e.f.b
        /* renamed from: g */
        public void e(Bundle bundle, String str, Boolean bool) {
            bundle.putBoolean(str, bool.booleanValue());
        }
    }

    /* loaded from: classes2.dex */
    public static class e extends d.b.g0.a.y0.e.f.b<Integer> {
        public e(Integer num) {
            super(num);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.y0.e.f.b
        /* renamed from: f */
        public Integer c(Bundle bundle, String str, Integer num) {
            return Integer.valueOf(bundle.getInt(str, num.intValue()));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.y0.e.f.b
        /* renamed from: g */
        public void e(Bundle bundle, String str, Integer num) {
            try {
                bundle.putInt(str, num.intValue());
            } catch (ConcurrentModificationException e2) {
                c.b bVar = new c.b(CyberPlayerManager.MEDIA_INFO_FIRST_FRAME_DECODE_FAIL_CHANGE_MODE);
                bVar.h(d.b.g0.a.r1.e.y() == null ? "null appKey" : d.b.g0.a.r1.e.y().B());
                bVar.k(str);
                bVar.i(Log.getStackTraceString(e2));
                bVar.l();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class f extends d.b.g0.a.y0.e.f.b<Long> {
        public f(Long l) {
            super(l);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.y0.e.f.b
        /* renamed from: f */
        public Long c(Bundle bundle, String str, Long l) {
            return Long.valueOf(bundle.getLong(str, l.longValue()));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.y0.e.f.b
        /* renamed from: g */
        public void e(Bundle bundle, String str, Long l) {
            bundle.putLong(str, l.longValue());
        }
    }

    /* loaded from: classes2.dex */
    public static class g extends d.b.g0.a.y0.e.f.b<Float> {
        public g(Float f2) {
            super(f2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.y0.e.f.b
        /* renamed from: f */
        public Float c(Bundle bundle, String str, Float f2) {
            return Float.valueOf(bundle.getFloat(str, f2.floatValue()));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.y0.e.f.b
        /* renamed from: g */
        public void e(Bundle bundle, String str, Float f2) {
            bundle.putFloat(str, f2.floatValue());
        }
    }

    /* loaded from: classes2.dex */
    public static class h extends d.b.g0.a.y0.e.f.b<String> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.y0.e.f.b
        /* renamed from: f */
        public String c(Bundle bundle, String str, String str2) {
            return bundle.getString(str, str2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.y0.e.f.b
        /* renamed from: g */
        public void e(Bundle bundle, String str, String str2) {
            bundle.putString(str, str2);
        }
    }
}
