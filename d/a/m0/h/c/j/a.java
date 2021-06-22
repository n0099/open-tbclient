package d.a.m0.h.c.j;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.v8engine.JsArrayBuffer;
import d.a.m0.a.k;
import d.a.m0.h.c.f;
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
    public static final boolean f50997e = k.f46983a;

    /* renamed from: f  reason: collision with root package name */
    public static volatile a f50998f;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, ArrayList<b>> f50999a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public final ExecutorService f51000b = Executors.newCachedThreadPool();

    /* renamed from: d  reason: collision with root package name */
    public Object f51002d = new Object();

    /* renamed from: c  reason: collision with root package name */
    public String f51001c = f.g() + f.f();

    /* renamed from: d.a.m0.h.c.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1072a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JsArrayBuffer f51003e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f51004f;

        public RunnableC1072a(JsArrayBuffer jsArrayBuffer, b bVar) {
            this.f51003e = jsArrayBuffer;
            this.f51004f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            String g2 = a.this.g(this.f51003e.buffer());
            File file = new File(g2);
            if (!file.exists()) {
                if (a.this.e(g2, this.f51004f)) {
                    return;
                }
                a.this.i(g2, this.f51003e.buffer());
            } else if (!file.isDirectory()) {
                this.f51004f.a(g2);
            } else {
                this.f51004f.b();
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(String str);

        void b();
    }

    public static a f() {
        if (f50998f == null) {
            synchronized (a.class) {
                if (f50998f == null) {
                    f50998f = new a();
                }
            }
        }
        return f50998f;
    }

    public final void d(String str) {
        synchronized (this.f51002d) {
            ArrayList<b> arrayList = this.f50999a.get(str);
            if (arrayList == null) {
                return;
            }
            boolean isEmpty = TextUtils.isEmpty(str);
            Iterator<b> it = arrayList.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (!isEmpty) {
                    if (f50997e) {
                        Log.e("AudioBufferManager", "save success path: " + str);
                    }
                    next.a(str);
                } else {
                    next.b();
                }
            }
            this.f50999a.remove(str);
        }
    }

    public final boolean e(String str, b bVar) {
        boolean z;
        synchronized (this.f51002d) {
            ArrayList<b> arrayList = this.f50999a.get(str);
            z = true;
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.f50999a.put(str, arrayList);
                z = false;
            }
            arrayList.add(bVar);
        }
        return z;
    }

    public final String g(byte[] bArr) {
        String h2 = f.h(bArr);
        StringBuilder sb = new StringBuilder();
        sb.append(this.f51001c);
        sb.append(bArr.length);
        if (TextUtils.isEmpty(h2)) {
            h2 = "";
        }
        sb.append(h2);
        return sb.toString();
    }

    public void h(JsArrayBuffer jsArrayBuffer, b bVar) {
        this.f51000b.execute(new RunnableC1072a(jsArrayBuffer, bVar));
    }

    public final void i(String str, byte[] bArr) {
        FileOutputStream fileOutputStream;
        File file = new File(this.f51001c);
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
                        if (f50997e) {
                            Log.e("AudioBufferManager", "buffer load rename success path = " + str);
                        }
                        d(str);
                    } else {
                        if (f50997e) {
                            Log.e("AudioBufferManager", "buffer load rename error path = " + str);
                        }
                        file2.delete();
                        d(null);
                    }
                } catch (Exception e2) {
                    e = e2;
                    if (f50997e) {
                        e.printStackTrace();
                    }
                    if (file2.exists()) {
                        file2.delete();
                    }
                    d(null);
                    d.a.m0.t.d.d(fileOutputStream);
                }
            } catch (Throwable th) {
                th = th;
                closeable = ".bdsave";
                d.a.m0.t.d.d(closeable);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            d.a.m0.t.d.d(closeable);
            throw th;
        }
        d.a.m0.t.d.d(fileOutputStream);
    }
}
