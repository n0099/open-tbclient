package com.ss.android.downloadlib.addownload.compliance;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.socialbase.downloader.i.g;
import d.o.a.d.f.n;
import d.o.a.d.j;
import d.o.a.d.k;
import d.o.a.d.n.c;
import d.o.a.e.b.l.e;
import d.o.a.e.b.o.k;
import java.io.BufferedInputStream;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d extends g<Long, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    public final Map<Long, SoftReference<c>> f36632a;

    /* loaded from: classes6.dex */
    public class a implements c.a<Object, Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f36633a;

        public a(long j) {
            this.f36633a = j;
        }

        @Override // d.o.a.d.n.c.a
        public Object a(Object obj) {
            SoftReference softReference = (SoftReference) d.this.f36632a.remove(Long.valueOf(this.f36633a));
            if (softReference == null || softReference.get() == null) {
                return null;
            }
            ((c) softReference.get()).a(d.this.get(Long.valueOf(this.f36633a)));
            return null;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements c.a<Object, Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f36635a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f36636b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f36637c;

        public b(String str, long j, long j2) {
            this.f36635a = str;
            this.f36636b = j;
            this.f36637c = j2;
        }

        @Override // d.o.a.d.n.c.a
        public Object a(Object obj) {
            BufferedInputStream bufferedInputStream;
            Throwable th;
            k x;
            try {
                x = d.o.a.e.b.g.d.x(true, 0, this.f36635a, null);
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
                    int i2 = options.outWidth;
                    int i3 = options.outHeight;
                    int b2 = d.o.a.d.n.k.b(n.a(), 60.0f);
                    options.inSampleSize = d.b(b2, b2, options);
                    options.inJustDecodeBounds = false;
                    bufferedInputStream.reset();
                    Bitmap decodeStream = BitmapFactory.decodeStream(bufferedInputStream, null, options);
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt("ttdownloader_type", "load_bitmap");
                        jSONObject.putOpt("bm_original_w", Integer.valueOf(i2));
                        jSONObject.putOpt("bm_original_h", Integer.valueOf(i3));
                        jSONObject.putOpt("bm_bytes", Integer.valueOf(decodeStream == null ? -1 : decodeStream.getByteCount()));
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    j.c.a().s("ttd_pref_monitor", jSONObject, this.f36636b);
                    d.this.put(Long.valueOf(this.f36637c), decodeStream);
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
    public static class C0438d {

        /* renamed from: a  reason: collision with root package name */
        public static d f36639a = new d(null);
    }

    public /* synthetic */ d(a aVar) {
        this();
    }

    public static int b(int i2, int i3, BitmapFactory.Options options) {
        if (options.outWidth > i2 || options.outHeight > i3) {
            return Math.min(Math.round(options.outWidth / i2), Math.round(options.outHeight / i3));
        }
        return 1;
    }

    public d() {
        super(8, 8);
        this.f36632a = new HashMap();
    }

    public static d a() {
        return C0438d.f36639a;
    }

    public void a(long j, @NonNull c cVar) {
        if (get(Long.valueOf(j)) != null) {
            cVar.a(get(Long.valueOf(j)));
        } else {
            this.f36632a.put(Long.valueOf(j), new SoftReference<>(cVar));
        }
    }

    public void a(long j, long j2, String str) {
        if (get(Long.valueOf(j)) != null) {
            SoftReference<c> remove = this.f36632a.remove(Long.valueOf(j));
            if (remove == null || remove.get() == null) {
                return;
            }
            remove.get().a(get(Long.valueOf(j)));
        } else if (TextUtils.isEmpty(str)) {
            d.o.a.d.f.f.c.a(12, j2);
        } else {
            d.o.a.d.n.c.c(new b(str, j2, j), null).b(new a(j)).d();
        }
    }
}
