package com.ss.android.downloadlib.addownload.compliance;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.socialbase.downloader.i.g;
import d.p.a.d.f.n;
import d.p.a.d.j;
import d.p.a.d.k;
import d.p.a.d.n.c;
import d.p.a.e.b.l.e;
import d.p.a.e.b.o.k;
import java.io.BufferedInputStream;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d extends g<Long, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    public final Map<Long, SoftReference<c>> f39047a;

    /* loaded from: classes6.dex */
    public class a implements c.a<Object, Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f39048a;

        public a(long j) {
            this.f39048a = j;
        }

        @Override // d.p.a.d.n.c.a
        public Object a(Object obj) {
            SoftReference softReference = (SoftReference) d.this.f39047a.remove(Long.valueOf(this.f39048a));
            if (softReference == null || softReference.get() == null) {
                return null;
            }
            ((c) softReference.get()).a(d.this.get(Long.valueOf(this.f39048a)));
            return null;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements c.a<Object, Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f39050a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f39051b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f39052c;

        public b(String str, long j, long j2) {
            this.f39050a = str;
            this.f39051b = j;
            this.f39052c = j2;
        }

        @Override // d.p.a.d.n.c.a
        public Object a(Object obj) {
            BufferedInputStream bufferedInputStream;
            Throwable th;
            k x;
            try {
                x = d.p.a.e.b.g.d.x(true, 0, this.f39050a, null);
            } catch (Exception e2) {
                e = e2;
                bufferedInputStream = null;
            } catch (Throwable th2) {
                bufferedInputStream = null;
                th = th2;
                e.C(bufferedInputStream);
                throw th;
            }
            if (x == null) {
                e.C(null);
                return null;
            }
            bufferedInputStream = new BufferedInputStream(x.a());
            try {
                try {
                    bufferedInputStream.mark(bufferedInputStream.available());
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeStream(bufferedInputStream, null, options);
                    int i = options.outWidth;
                    int i2 = options.outHeight;
                    int b2 = d.p.a.d.n.k.b(n.a(), 60.0f);
                    options.inSampleSize = d.b(b2, b2, options);
                    options.inJustDecodeBounds = false;
                    bufferedInputStream.reset();
                    Bitmap decodeStream = BitmapFactory.decodeStream(bufferedInputStream, null, options);
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt("ttdownloader_type", "load_bitmap");
                        jSONObject.putOpt("bm_original_w", Integer.valueOf(i));
                        jSONObject.putOpt("bm_original_h", Integer.valueOf(i2));
                        jSONObject.putOpt("bm_bytes", Integer.valueOf(decodeStream == null ? -1 : decodeStream.getByteCount()));
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    j.c.a().s("ttd_pref_monitor", jSONObject, this.f39051b);
                    d.this.put(Long.valueOf(this.f39052c), decodeStream);
                    e.C(bufferedInputStream);
                } catch (Exception e4) {
                    e = e4;
                    k.f.c(e);
                    e.C(bufferedInputStream);
                    return null;
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                e.C(bufferedInputStream);
                throw th;
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface c {
        void a(Bitmap bitmap);
    }

    /* renamed from: com.ss.android.downloadlib.addownload.compliance.d$d  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0494d {

        /* renamed from: a  reason: collision with root package name */
        public static d f39054a = new d(null);
    }

    public /* synthetic */ d(a aVar) {
        this();
    }

    public static int b(int i, int i2, BitmapFactory.Options options) {
        if (options.outWidth > i || options.outHeight > i2) {
            return Math.min(Math.round(options.outWidth / i), Math.round(options.outHeight / i2));
        }
        return 1;
    }

    public d() {
        super(8, 8);
        this.f39047a = new HashMap();
    }

    public static d a() {
        return C0494d.f39054a;
    }

    public void a(long j, @NonNull c cVar) {
        if (get(Long.valueOf(j)) != null) {
            cVar.a(get(Long.valueOf(j)));
        } else {
            this.f39047a.put(Long.valueOf(j), new SoftReference<>(cVar));
        }
    }

    public void a(long j, long j2, String str) {
        if (get(Long.valueOf(j)) != null) {
            SoftReference<c> remove = this.f39047a.remove(Long.valueOf(j));
            if (remove == null || remove.get() == null) {
                return;
            }
            remove.get().a(get(Long.valueOf(j)));
        } else if (TextUtils.isEmpty(str)) {
            d.p.a.d.f.f.c.a(12, j2);
        } else {
            d.p.a.d.n.c.c(new b(str, j2, j), null).b(new a(j)).d();
        }
    }
}
