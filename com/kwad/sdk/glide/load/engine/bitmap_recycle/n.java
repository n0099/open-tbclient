package com.kwad.sdk.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import android.os.Build;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
@RequiresApi(19)
/* loaded from: classes6.dex */
public class n implements l {

    /* renamed from: a  reason: collision with root package name */
    public static final Bitmap.Config[] f35501a;

    /* renamed from: b  reason: collision with root package name */
    public static final Bitmap.Config[] f35502b;

    /* renamed from: c  reason: collision with root package name */
    public static final Bitmap.Config[] f35503c;

    /* renamed from: d  reason: collision with root package name */
    public static final Bitmap.Config[] f35504d;

    /* renamed from: e  reason: collision with root package name */
    public static final Bitmap.Config[] f35505e;

    /* renamed from: f  reason: collision with root package name */
    public final b f35506f = new b();

    /* renamed from: g  reason: collision with root package name */
    public final h<a, Bitmap> f35507g = new h<>();

    /* renamed from: h  reason: collision with root package name */
    public final Map<Bitmap.Config, NavigableMap<Integer, Integer>> f35508h = new HashMap();

    /* renamed from: com.kwad.sdk.glide.load.engine.bitmap_recycle.n$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f35509a;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            f35509a = iArr;
            try {
                iArr[Bitmap.Config.ARGB_8888.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f35509a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f35509a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f35509a[Bitmap.Config.ALPHA_8.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @VisibleForTesting
    /* loaded from: classes6.dex */
    public static final class a implements m {

        /* renamed from: a  reason: collision with root package name */
        public int f35510a;

        /* renamed from: b  reason: collision with root package name */
        public final b f35511b;

        /* renamed from: c  reason: collision with root package name */
        public Bitmap.Config f35512c;

        public a(b bVar) {
            this.f35511b = bVar;
        }

        @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.m
        public void a() {
            this.f35511b.a(this);
        }

        public void a(int i, Bitmap.Config config) {
            this.f35510a = i;
            this.f35512c = config;
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                return this.f35510a == aVar.f35510a && com.kwad.sdk.glide.g.k.a(this.f35512c, aVar.f35512c);
            }
            return false;
        }

        public int hashCode() {
            int i = this.f35510a * 31;
            Bitmap.Config config = this.f35512c;
            return i + (config != null ? config.hashCode() : 0);
        }

        public String toString() {
            return n.a(this.f35510a, this.f35512c);
        }
    }

    @VisibleForTesting
    /* loaded from: classes6.dex */
    public static class b extends d<a> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.d
        /* renamed from: a */
        public a b() {
            return new a(this);
        }

        public a a(int i, Bitmap.Config config) {
            a c2 = c();
            c2.a(i, config);
            return c2;
        }
    }

    static {
        Bitmap.Config[] configArr = {Bitmap.Config.ARGB_8888, null};
        if (Build.VERSION.SDK_INT >= 26) {
            configArr = (Bitmap.Config[]) Arrays.copyOf(configArr, 3);
            configArr[configArr.length - 1] = Bitmap.Config.RGBA_F16;
        }
        f35501a = configArr;
        f35502b = configArr;
        f35503c = new Bitmap.Config[]{Bitmap.Config.RGB_565};
        f35504d = new Bitmap.Config[]{Bitmap.Config.ARGB_4444};
        f35505e = new Bitmap.Config[]{Bitmap.Config.ALPHA_8};
    }

    public static String a(int i, Bitmap.Config config) {
        return "[" + i + "](" + config + SmallTailInfo.EMOTION_SUFFIX;
    }

    private NavigableMap<Integer, Integer> a(Bitmap.Config config) {
        NavigableMap<Integer, Integer> navigableMap = this.f35508h.get(config);
        if (navigableMap == null) {
            TreeMap treeMap = new TreeMap();
            this.f35508h.put(config, treeMap);
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

    private a b(int i, Bitmap.Config config) {
        Bitmap.Config[] b2;
        a a2 = this.f35506f.a(i, config);
        for (Bitmap.Config config2 : b(config)) {
            Integer ceilingKey = a(config2).ceilingKey(Integer.valueOf(i));
            if (ceilingKey != null && ceilingKey.intValue() <= i * 8) {
                if (ceilingKey.intValue() == i) {
                    if (config2 == null) {
                        if (config == null) {
                            return a2;
                        }
                    } else if (config2.equals(config)) {
                        return a2;
                    }
                }
                this.f35506f.a(a2);
                return this.f35506f.a(ceilingKey.intValue(), config2);
            }
        }
        return a2;
    }

    public static Bitmap.Config[] b(Bitmap.Config config) {
        if (Build.VERSION.SDK_INT < 26 || !Bitmap.Config.RGBA_F16.equals(config)) {
            int i = AnonymousClass1.f35509a[config.ordinal()];
            return i != 1 ? i != 2 ? i != 3 ? i != 4 ? new Bitmap.Config[]{config} : f35505e : f35504d : f35503c : f35501a;
        }
        return f35502b;
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.l
    @Nullable
    public Bitmap a() {
        Bitmap a2 = this.f35507g.a();
        if (a2 != null) {
            a(Integer.valueOf(com.kwad.sdk.glide.g.k.a(a2)), a2);
        }
        return a2;
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.l
    @Nullable
    public Bitmap a(int i, int i2, Bitmap.Config config) {
        a b2 = b(com.kwad.sdk.glide.g.k.a(i, i2, config), config);
        Bitmap a2 = this.f35507g.a((h<a, Bitmap>) b2);
        if (a2 != null) {
            a(Integer.valueOf(b2.f35510a), a2);
            a2.reconfigure(i, i2, config);
        }
        return a2;
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.l
    public void a(Bitmap bitmap) {
        a a2 = this.f35506f.a(com.kwad.sdk.glide.g.k.a(bitmap), bitmap.getConfig());
        this.f35507g.a(a2, bitmap);
        NavigableMap<Integer, Integer> a3 = a(bitmap.getConfig());
        Integer num = (Integer) a3.get(Integer.valueOf(a2.f35510a));
        a3.put(Integer.valueOf(a2.f35510a), Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.l
    public String b(int i, int i2, Bitmap.Config config) {
        return a(com.kwad.sdk.glide.g.k.a(i, i2, config), config);
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
        sb.append(this.f35507g);
        sb.append(", sortedSizes=(");
        for (Map.Entry<Bitmap.Config, NavigableMap<Integer, Integer>> entry : this.f35508h.entrySet()) {
            sb.append(entry.getKey());
            sb.append('[');
            sb.append(entry.getValue());
            sb.append("], ");
        }
        if (!this.f35508h.isEmpty()) {
            sb.replace(sb.length() - 2, sb.length(), "");
        }
        sb.append(")}");
        return sb.toString();
    }
}
