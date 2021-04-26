package d.a.h0.g.c.j;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.v8engine.JsArrayBuffer;
import d.a.h0.a.k;
import d.a.h0.g.c.f;
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
    public static final boolean f46161e = k.f43101a;

    /* renamed from: f  reason: collision with root package name */
    public static volatile a f46162f;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, ArrayList<b>> f46163a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public final ExecutorService f46164b = Executors.newCachedThreadPool();

    /* renamed from: d  reason: collision with root package name */
    public Object f46166d = new Object();

    /* renamed from: c  reason: collision with root package name */
    public String f46165c = f.g() + f.f();

    /* renamed from: d.a.h0.g.c.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0925a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JsArrayBuffer f46167e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f46168f;

        public RunnableC0925a(JsArrayBuffer jsArrayBuffer, b bVar) {
            this.f46167e = jsArrayBuffer;
            this.f46168f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            String g2 = a.this.g(this.f46167e.buffer());
            File file = new File(g2);
            if (!file.exists()) {
                if (a.this.e(g2, this.f46168f)) {
                    return;
                }
                a.this.i(g2, this.f46167e.buffer());
            } else if (!file.isDirectory()) {
                this.f46168f.a(g2);
            } else {
                this.f46168f.b();
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(String str);

        void b();
    }

    public static a f() {
        if (f46162f == null) {
            synchronized (a.class) {
                if (f46162f == null) {
                    f46162f = new a();
                }
            }
        }
        return f46162f;
    }

    public final void d(String str) {
        synchronized (this.f46166d) {
            ArrayList<b> arrayList = this.f46163a.get(str);
            if (arrayList == null) {
                return;
            }
            boolean isEmpty = TextUtils.isEmpty(str);
            Iterator<b> it = arrayList.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (!isEmpty) {
                    if (f46161e) {
                        Log.e("AudioBufferManager", "save success path: " + str);
                    }
                    next.a(str);
                } else {
                    next.b();
                }
            }
            this.f46163a.remove(str);
        }
    }

    public final boolean e(String str, b bVar) {
        boolean z;
        synchronized (this.f46166d) {
            ArrayList<b> arrayList = this.f46163a.get(str);
            z = true;
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.f46163a.put(str, arrayList);
                z = false;
            }
            arrayList.add(bVar);
        }
        return z;
    }

    public final String g(byte[] bArr) {
        String h2 = f.h(bArr);
        StringBuilder sb = new StringBuilder();
        sb.append(this.f46165c);
        sb.append(bArr.length);
        if (TextUtils.isEmpty(h2)) {
            h2 = "";
        }
        sb.append(h2);
        return sb.toString();
    }

    public void h(JsArrayBuffer jsArrayBuffer, b bVar) {
        this.f46164b.execute(new RunnableC0925a(jsArrayBuffer, bVar));
    }

    public final void i(String str, byte[] bArr) {
        FileOutputStream fileOutputStream;
        File file = new File(this.f46165c);
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
                        if (f46161e) {
                            Log.e("AudioBufferManager", "buffer load rename success path = " + str);
                        }
                        d(str);
                    } else {
                        if (f46161e) {
                            Log.e("AudioBufferManager", "buffer load rename error path = " + str);
                        }
                        file2.delete();
                        d(null);
                    }
                } catch (Exception e2) {
                    e = e2;
                    if (f46161e) {
                        e.printStackTrace();
                    }
                    if (file2.exists()) {
                        file2.delete();
                    }
                    d(null);
                    d.a.h0.p.d.a(fileOutputStream);
                }
            } catch (Throwable th) {
                th = th;
                closeable = ".bdsave";
                d.a.h0.p.d.a(closeable);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            d.a.h0.p.d.a(closeable);
            throw th;
        }
        d.a.h0.p.d.a(fileOutputStream);
    }
}
