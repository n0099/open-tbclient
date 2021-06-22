package com.kwad.sdk.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import android.os.Build;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
@RequiresApi(19)
/* loaded from: classes7.dex */
public class n implements l {

    /* renamed from: a  reason: collision with root package name */
    public static final Bitmap.Config[] f36287a;

    /* renamed from: b  reason: collision with root package name */
    public static final Bitmap.Config[] f36288b;

    /* renamed from: c  reason: collision with root package name */
    public static final Bitmap.Config[] f36289c;

    /* renamed from: d  reason: collision with root package name */
    public static final Bitmap.Config[] f36290d;

    /* renamed from: e  reason: collision with root package name */
    public static final Bitmap.Config[] f36291e;

    /* renamed from: f  reason: collision with root package name */
    public final b f36292f = new b();

    /* renamed from: g  reason: collision with root package name */
    public final h<a, Bitmap> f36293g = new h<>();

    /* renamed from: h  reason: collision with root package name */
    public final Map<Bitmap.Config, NavigableMap<Integer, Integer>> f36294h = new HashMap();

    /* renamed from: com.kwad.sdk.glide.load.engine.bitmap_recycle.n$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f36295a;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            f36295a = iArr;
            try {
                iArr[Bitmap.Config.ARGB_8888.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f36295a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f36295a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f36295a[Bitmap.Config.ALPHA_8.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @VisibleForTesting
    /* loaded from: classes7.dex */
    public static final class a implements m {

        /* renamed from: a  reason: collision with root package name */
        public int f36296a;

        /* renamed from: b  reason: collision with root package name */
        public final b f36297b;

        /* renamed from: c  reason: collision with root package name */
        public Bitmap.Config f36298c;

        public a(b bVar) {
            this.f36297b = bVar;
        }

        @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.m
        public void a() {
            this.f36297b.a(this);
        }

        public void a(int i2, Bitmap.Config config) {
            this.f36296a = i2;
            this.f36298c = config;
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                return this.f36296a == aVar.f36296a && com.kwad.sdk.glide.g.k.a(this.f36298c, aVar.f36298c);
            }
            return false;
        }

        public int hashCode() {
            int i2 = this.f36296a * 31;
            Bitmap.Config config = this.f36298c;
            return i2 + (config != null ? config.hashCode() : 0);
        }

        public String toString() {
            return n.a(this.f36296a, this.f36298c);
        }
    }

    @VisibleForTesting
    /* loaded from: classes7.dex */
    public static class b extends d<a> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.d
        /* renamed from: a */
        public a b() {
            return new a(this);
        }

        public a a(int i2, Bitmap.Config config) {
            a c2 = c();
            c2.a(i2, config);
            return c2;
        }
    }

    static {
        Bitmap.Config[] configArr = {Bitmap.Config.ARGB_8888, null};
        if (Build.VERSION.SDK_INT >= 26) {
            configArr = (Bitmap.Config[]) Arrays.copyOf(configArr, 3);
            configArr[configArr.length - 1] = Bitmap.Config.RGBA_F16;
        }
        f36287a = configArr;
        f36288b = configArr;
        f36289c = new Bitmap.Config[]{Bitmap.Config.RGB_565};
        f36290d = new Bitmap.Config[]{Bitmap.Config.ARGB_4444};
        f36291e = new Bitmap.Config[]{Bitmap.Config.ALPHA_8};
    }

    public static String a(int i2, Bitmap.Config config) {
        return PreferencesUtil.LEFT_MOUNT + i2 + "](" + config + SmallTailInfo.EMOTION_SUFFIX;
    }

    private NavigableMap<Integer, Integer> a(Bitmap.Config config) {
        NavigableMap<Integer, Integer> navigableMap = this.f36294h.get(config);
        if (navigableMap == null) {
            TreeMap treeMap = new TreeMap();
            this.f36294h.put(config, treeMap);
            return treeMap;
        }
        return navigableMap;
    }

    private void a(Integer num, Bitmap bitmap) {
        NavigableMap<Integer, Integer> a2 = a(bitmap.getConfig());
        Integer num2 = (Integer) a2.get(num);
        if (num2 != null) {
            if (num2.intValue() == 1) {
                a2.remove(num);
                return;
            } else {
                a2.put(num, Integer.valueOf(num2.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + num + ", removed: " + b(bitmap) + ", this: " + this);
    }

    private a b(int i2, Bitmap.Config config) {
        Bitmap.Config[] b2;
        a a2 = this.f36292f.a(i2, config);
        for (Bitmap.Config config2 : b(config)) {
            Integer ceilingKey = a(config2).ceilingKey(Integer.valueOf(i2));
            if (ceilingKey != null && ceilingKey.intValue() <= i2 * 8) {
                if (ceilingKey.intValue() == i2) {
                    if (config2 == null) {
                        if (config == null) {
                            return a2;
                        }
                    } else if (config2.equals(config)) {
                        return a2;
                    }
                }
                this.f36292f.a(a2);
                return this.f36292f.a(ceilingKey.intValue(), config2);
            }
        }
        return a2;
    }

    public static Bitmap.Config[] b(Bitmap.Config config) {
        if (Build.VERSION.SDK_INT < 26 || !Bitmap.Config.RGBA_F16.equals(config)) {
            int i2 = AnonymousClass1.f36295a[config.ordinal()];
            return i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? new Bitmap.Config[]{config} : f36291e : f36290d : f36289c : f36287a;
        }
        return f36288b;
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.l
    @Nullable
    public Bitmap a() {
        Bitmap a2 = this.f36293g.a();
        if (a2 != null) {
            a(Integer.valueOf(com.kwad.sdk.glide.g.k.a(a2)), a2);
        }
        return a2;
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.l
    @Nullable
    public Bitmap a(int i2, int i3, Bitmap.Config config) {
        a b2 = b(com.kwad.sdk.glide.g.k.a(i2, i3, config), config);
        Bitmap a2 = this.f36293g.a((h<a, Bitmap>) b2);
        if (a2 != null) {
            a(Integer.valueOf(b2.f36296a), a2);
            a2.reconfigure(i2, i3, config);
        }
        return a2;
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.l
    public void a(Bitmap bitmap) {
        a a2 = this.f36292f.a(com.kwad.sdk.glide.g.k.a(bitmap), bitmap.getConfig());
        this.f36293g.a(a2, bitmap);
        NavigableMap<Integer, Integer> a3 = a(bitmap.getConfig());
        Integer num = (Integer) a3.get(Integer.valueOf(a2.f36296a));
        a3.put(Integer.valueOf(a2.f36296a), Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.l
    public String b(int i2, int i3, Bitmap.Config config) {
        return a(com.kwad.sdk.glide.g.k.a(i2, i3, config), config);
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.l
    public String b(Bitmap bitmap) {
        return a(com.kwad.sdk.glide.g.k.a(bitmap), bitmap.getConfig());
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.l
    public int c(Bitmap bitmap) {
        return com.kwad.sdk.glide.g.k.a(bitmap);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SizeConfigStrategy{groupedMap=");
        sb.append(this.f36293g);
        sb.append(", sortedSizes=(");
        for (Map.Entry<Bitmap.Config, NavigableMap<Integer, Integer>> entry : this.f36294h.entrySet()) {
            sb.append(entry.getKey());
            sb.append('[');
            sb.append(entry.getValue());
            sb.append("], ");
        }
        if (!this.f36294h.isEmpty()) {
            sb.replace(sb.length() - 2, sb.length(), "");
        }
        sb.append(")}");
        return sb.toString();
    }
}
