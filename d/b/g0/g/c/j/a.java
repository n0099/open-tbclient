package d.b.g0.g.c.j;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.v8engine.JsArrayBuffer;
import d.b.g0.a.k;
import d.b.g0.g.c.f;
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
    public static final boolean f48366e = k.f45443a;

    /* renamed from: f  reason: collision with root package name */
    public static volatile a f48367f;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, ArrayList<b>> f48368a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public final ExecutorService f48369b = Executors.newCachedThreadPool();

    /* renamed from: d  reason: collision with root package name */
    public Object f48371d = new Object();

    /* renamed from: c  reason: collision with root package name */
    public String f48370c = f.g() + f.f();

    /* renamed from: d.b.g0.g.c.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0966a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JsArrayBuffer f48372e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f48373f;

        public RunnableC0966a(JsArrayBuffer jsArrayBuffer, b bVar) {
            this.f48372e = jsArrayBuffer;
            this.f48373f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            String g2 = a.this.g(this.f48372e.buffer());
            File file = new File(g2);
            if (!file.exists()) {
                if (a.this.e(g2, this.f48373f)) {
                    return;
                }
                a.this.i(g2, this.f48372e.buffer());
            } else if (!file.isDirectory()) {
                this.f48373f.a(g2);
            } else {
                this.f48373f.b();
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(String str);

        void b();
    }

    public static a f() {
        if (f48367f == null) {
            synchronized (a.class) {
                if (f48367f == null) {
                    f48367f = new a();
                }
            }
        }
        return f48367f;
    }

    public final void d(String str) {
        synchronized (this.f48371d) {
            ArrayList<b> arrayList = this.f48368a.get(str);
            if (arrayList == null) {
                return;
            }
            boolean isEmpty = TextUtils.isEmpty(str);
            Iterator<b> it = arrayList.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (!isEmpty) {
                    if (f48366e) {
                        Log.e("AudioBufferManager", "save success path: " + str);
                    }
                    next.a(str);
                } else {
                    next.b();
                }
            }
            this.f48368a.remove(str);
        }
    }

    public final boolean e(String str, b bVar) {
        boolean z;
        synchronized (this.f48371d) {
            ArrayList<b> arrayList = this.f48368a.get(str);
            z = true;
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.f48368a.put(str, arrayList);
                z = false;
            }
            arrayList.add(bVar);
        }
        return z;
    }

    public final String g(byte[] bArr) {
        String h2 = f.h(bArr);
        StringBuilder sb = new StringBuilder();
        sb.append(this.f48370c);
        sb.append(bArr.length);
        if (TextUtils.isEmpty(h2)) {
            h2 = "";
        }
        sb.append(h2);
        return sb.toString();
    }

    public void h(JsArrayBuffer jsArrayBuffer, b bVar) {
        this.f48369b.execute(new RunnableC0966a(jsArrayBuffer, bVar));
    }

    public final void i(String str, byte[] bArr) {
        FileOutputStream fileOutputStream;
        File file = new File(this.f48370c);
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
                        if (f48366e) {
                            Log.e("AudioBufferManager", "buffer load rename success path = " + str);
                        }
                        d(str);
                    } else {
                        if (f48366e) {
                            Log.e("AudioBufferManager", "buffer load rename error path = " + str);
                        }
                        file2.delete();
                        d(null);
                    }
                } catch (Exception e2) {
                    e = e2;
                    if (f48366e) {
                        e.printStackTrace();
                    }
                    if (file2.exists()) {
                        file2.delete();
                    }
                    d(null);
                    d.b.g0.p.d.a(fileOutputStream);
                }
            } catch (Throwable th) {
                th = th;
                closeable = ".bdsave";
                d.b.g0.p.d.a(closeable);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            d.b.g0.p.d.a(closeable);
            throw th;
        }
        d.b.g0.p.d.a(fileOutputStream);
    }
}
