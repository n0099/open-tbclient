package d.a.i0.h.c.j;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.v8engine.JsArrayBuffer;
import d.a.i0.a.k;
import d.a.i0.h.c.f;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f47039e = k.f43025a;

    /* renamed from: f  reason: collision with root package name */
    public static volatile a f47040f;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, ArrayList<b>> f47041a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public final ExecutorService f47042b = Executors.newCachedThreadPool();

    /* renamed from: d  reason: collision with root package name */
    public Object f47044d = new Object();

    /* renamed from: c  reason: collision with root package name */
    public String f47043c = f.g() + f.f();

    /* renamed from: d.a.i0.h.c.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1002a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JsArrayBuffer f47045e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f47046f;

        public RunnableC1002a(JsArrayBuffer jsArrayBuffer, b bVar) {
            this.f47045e = jsArrayBuffer;
            this.f47046f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            String g2 = a.this.g(this.f47045e.buffer());
            File file = new File(g2);
            if (!file.exists()) {
                if (a.this.e(g2, this.f47046f)) {
                    return;
                }
                a.this.i(g2, this.f47045e.buffer());
            } else if (!file.isDirectory()) {
                this.f47046f.a(g2);
            } else {
                this.f47046f.b();
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(String str);

        void b();
    }

    public static a f() {
        if (f47040f == null) {
            synchronized (a.class) {
                if (f47040f == null) {
                    f47040f = new a();
                }
            }
        }
        return f47040f;
    }

    public final void d(String str) {
        synchronized (this.f47044d) {
            ArrayList<b> arrayList = this.f47041a.get(str);
            if (arrayList == null) {
                return;
            }
            boolean isEmpty = TextUtils.isEmpty(str);
            Iterator<b> it = arrayList.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (!isEmpty) {
                    if (f47039e) {
                        Log.e("AudioBufferManager", "save success path: " + str);
                    }
                    next.a(str);
                } else {
                    next.b();
                }
            }
            this.f47041a.remove(str);
        }
    }

    public final boolean e(String str, b bVar) {
        boolean z;
        synchronized (this.f47044d) {
            ArrayList<b> arrayList = this.f47041a.get(str);
            z = true;
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.f47041a.put(str, arrayList);
                z = false;
            }
            arrayList.add(bVar);
        }
        return z;
    }

    public final String g(byte[] bArr) {
        String h2 = f.h(bArr);
        StringBuilder sb = new StringBuilder();
        sb.append(this.f47043c);
        sb.append(bArr.length);
        if (TextUtils.isEmpty(h2)) {
            h2 = "";
        }
        sb.append(h2);
        return sb.toString();
    }

    public void h(JsArrayBuffer jsArrayBuffer, b bVar) {
        this.f47042b.execute(new RunnableC1002a(jsArrayBuffer, bVar));
    }

    public final void i(String str, byte[] bArr) {
        FileOutputStream fileOutputStream;
        File file = new File(this.f47043c);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(str + ".bdsave");
        Closeable closeable = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    fileOutputStream.write(bArr);
                    fileOutputStream.flush();
                    File file3 = new File(str);
                    if (file3.exists() && !file3.isDirectory()) {
                        file3.delete();
                    }
                    if (file2.renameTo(file3)) {
                        if (f47039e) {
                            Log.e("AudioBufferManager", "buffer load rename success path = " + str);
                        }
                        d(str);
                    } else {
                        if (f47039e) {
                            Log.e("AudioBufferManager", "buffer load rename error path = " + str);
                        }
                        file2.delete();
                        d(null);
                    }
                } catch (Exception e2) {
                    e = e2;
                    if (f47039e) {
                        e.printStackTrace();
                    }
                    if (file2.exists()) {
                        file2.delete();
                    }
                    d(null);
                    d.a.i0.t.d.d(fileOutputStream);
                }
            } catch (Throwable th) {
                th = th;
                closeable = ".bdsave";
                d.a.i0.t.d.d(closeable);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            d.a.i0.t.d.d(closeable);
            throw th;
        }
        d.a.i0.t.d.d(fileOutputStream);
    }
}
