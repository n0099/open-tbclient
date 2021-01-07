package com.qq.e.comm.plugin.j.b;

import android.text.TextUtils;
import android.util.Pair;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.qq.e.comm.plugin.j.b.l;
import com.qq.e.comm.plugin.util.ai;
import com.qq.e.comm.util.FileUtil;
import com.qq.e.comm.util.GDTLogger;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes4.dex */
public class f implements com.qq.e.comm.plugin.j.e, com.qq.e.comm.plugin.j.f {
    private static final com.qq.e.comm.plugin.j.a s = new com.qq.e.comm.plugin.j.a() { // from class: com.qq.e.comm.plugin.j.b.f.1
        @Override // com.qq.e.comm.plugin.j.a
        public void a() {
        }

        @Override // com.qq.e.comm.plugin.j.a
        public void a(long j, long j2, int i) {
        }

        @Override // com.qq.e.comm.plugin.j.a
        public void a(long j, boolean z) {
        }

        @Override // com.qq.e.comm.plugin.j.a
        public void a(com.qq.e.comm.plugin.j.c cVar) {
        }

        @Override // com.qq.e.comm.plugin.j.a
        public void a(File file, long j) {
        }

        @Override // com.qq.e.comm.plugin.j.a
        public void b() {
        }

        @Override // com.qq.e.comm.plugin.j.a
        public void c() {
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final String f12465a;

    /* renamed from: b  reason: collision with root package name */
    private final File f12466b;
    private final int c;
    private final com.qq.e.comm.plugin.j.b.a.b d;
    private final ExecutorService f;
    private com.qq.e.comm.plugin.j.b.a.a g;
    private int i;
    private String j;
    private com.qq.e.comm.plugin.j.f k;
    private g l;
    private int n;
    private long o;
    private long p;
    private com.qq.e.comm.plugin.j.a r;
    private AtomicBoolean h = new AtomicBoolean(false);
    private long m = -1;
    private final List<h> q = new ArrayList();
    private final l e = new b();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a implements Callable<Pair<Integer, String>> {

        /* renamed from: a  reason: collision with root package name */
        private final h f12467a;

        /* renamed from: b  reason: collision with root package name */
        private final c f12468b;

        public a(h hVar, c cVar) {
            this.f12467a = hVar;
            this.f12468b = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Pair<Integer, String> call() throws Exception {
            this.f12467a.a(this.f12468b);
            return new Pair<>(Integer.valueOf(this.f12467a.b()), this.f12467a.a());
        }
    }

    public f(String str, File file, int i, com.qq.e.comm.plugin.j.b bVar) {
        this.f12465a = str;
        this.f12466b = file;
        this.c = i;
        this.d = new com.qq.e.comm.plugin.j.b.a.b(bVar.a(), bVar.b(), bVar.c());
        this.f = bVar.d();
    }

    private File a(int i) {
        return new File(this.f12466b.getParentFile(), this.f12466b.getName() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + i);
    }

    private Future<Pair<Integer, String>> a(a aVar) {
        return this.f == null ? new n(aVar) : this.f.submit(aVar);
    }

    private void a(long j, l.a[] aVarArr) {
        int length = aVarArr.length;
        long[] jArr = new long[length];
        long[] jArr2 = new long[length];
        for (int i = 0; i < length; i++) {
            jArr[i] = aVarArr[i].b();
            File a2 = a(i);
            jArr2[i] = a2 != null ? a2.length() : 0L;
        }
        this.l = new g(j, jArr, jArr2);
        this.l.a(this);
    }

    private void a(List<File> list) {
        if (this.f12466b.exists()) {
            this.f12466b.delete();
        }
        if (list.isEmpty()) {
            return;
        }
        for (File file : list) {
            if (file.exists()) {
                file.delete();
            }
        }
    }

    private boolean a(List<File> list, List<l.a> list2) {
        boolean z;
        boolean z2;
        if (list2.size() == list.size()) {
            z = true;
            int i = 0;
            while (i < list2.size()) {
                long b2 = list2.get(i).b();
                if (b2 <= 0) {
                    break;
                }
                if (b2 != list.get(i).length()) {
                    this.i |= 1;
                    this.j = "PartitionFileSize!=RangeSize";
                    z2 = false;
                } else {
                    z2 = z;
                }
                i++;
                z = z2;
            }
        } else {
            this.i |= 1;
            this.j = "RangeCount!=PartitionFileCount";
            z = false;
        }
        if (!z) {
            for (File file : list) {
                file.delete();
            }
        }
        return z;
    }

    private boolean b(List<File> list) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            try {
                if (list.size() != 1) {
                    FileOutputStream fileOutputStream = new FileOutputStream(this.f12466b, false);
                    byte[] bArr = new byte[8192];
                    for (File file : list) {
                        FileInputStream fileInputStream = new FileInputStream(file);
                        while (true) {
                            int read = fileInputStream.read(bArr);
                            if (read > 0) {
                                fileOutputStream.write(bArr, 0, read);
                            }
                        }
                        fileInputStream.close();
                    }
                    fileOutputStream.close();
                    for (File file2 : list) {
                        file2.delete();
                    }
                } else if (!FileUtil.renameTo(list.get(0), this.f12466b)) {
                    this.i |= 16384;
                    this.j = "ExceptionWhileRenameTmpFileToTargetFile";
                    return false;
                }
                if (this.f12466b.exists()) {
                    return true;
                }
                this.i |= 32768;
                this.j = "DownloadFileNotExist";
                return false;
            } catch (IOException e) {
                this.i |= 2;
                this.j = "UnknownIOExceptionWhileMerge:" + e.getMessage();
                return false;
            }
        } finally {
            this.m = System.currentTimeMillis() - currentTimeMillis;
        }
    }

    private boolean b(List<File> list, List<l.a> list2) {
        long d;
        l.a[] aVarArr;
        File a2 = a(0);
        if (this.h.get()) {
            GDTLogger.d("download paused, quit");
            return false;
        }
        try {
            this.g = this.d.a(this.f12465a, a2.length(), -1L);
            if (!this.g.h()) {
                this.i |= this.g.b();
                this.j = this.g.g();
                this.g.f();
                ai.a("main fail, code = %d, msg = %s", Integer.valueOf(this.g.b()), this.g.g());
                return false;
            }
            ArrayList<Future> arrayList = new ArrayList();
            if (this.g.c()) {
                d = a2.length() + this.g.d();
                aVarArr = this.e.a(d, this.c);
                i().a(d, true);
            } else if (a2.exists() && !a2.delete()) {
                this.i |= 8192;
                this.j = "FailToDeleteMainPartitionFile";
                return false;
            } else {
                d = this.g.d();
                aVarArr = new l.a[]{new l.a(0L, d)};
                i().a(d, false);
            }
            a(d, aVarArr);
            list2.add(aVarArr[0]);
            e eVar = new e(this.g, a2, aVarArr[0].b());
            arrayList.add(a(new a(eVar, this.l.a(0))));
            list.add(a2);
            this.q.add(eVar);
            for (int i = 1; i < aVarArr.length && !this.h.get(); i++) {
                list2.add(aVarArr[i]);
                File a3 = a(i);
                list.add(a3);
                m mVar = new m(this.f12465a, a3, aVarArr[i].a(), aVarArr[i].b(), this.d);
                this.q.add(mVar);
                arrayList.add(a(new a(mVar, this.l.a(i))));
            }
            for (Future future : arrayList) {
                try {
                    Pair pair = (Pair) future.get();
                    if (((Integer) pair.first).intValue() != 0) {
                        this.i = ((Integer) pair.first).intValue() | this.i;
                        this.j += ((String) pair.second) + ";\t";
                    }
                } catch (Throwable th) {
                    this.i |= 1;
                    this.j += "ExceptionWhileExecutePartitionWorks:" + th.getMessage() + "\t";
                }
            }
            this.g.f();
            return this.i == 0;
        } catch (IOException e) {
            ai.a("main exception: %s", e.toString());
            this.i |= 2;
            this.j = "IOExceptionWhileCreateConnection " + e.getMessage();
            return false;
        }
    }

    private boolean f() {
        boolean z = false;
        long currentTimeMillis = System.currentTimeMillis();
        this.i = 0;
        this.j = "";
        i().a();
        if (g()) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (b(arrayList, arrayList2) && a(arrayList, arrayList2) && b(arrayList) && this.i == 0) {
                z = true;
            }
            this.p = System.currentTimeMillis() - currentTimeMillis;
            this.n = arrayList.size();
            if (z) {
                this.o = this.f12466b.length();
            } else {
                this.o = -1L;
            }
            if (z) {
                i().a(this.f12466b, this.p);
            } else if (com.qq.e.comm.plugin.j.d.c(this.i)) {
                this.i = 512;
                this.j = "DownloaderIsPausedManual";
                i().b();
            } else if (com.qq.e.comm.plugin.j.d.d(this.i)) {
                this.i = 256;
                this.j = "DownloaderIsCanceledManual";
                i().c();
                a(arrayList);
            } else {
                i().a(new com.qq.e.comm.plugin.j.c(this.i, this.j));
            }
        }
        return z;
    }

    private boolean g() {
        if (TextUtils.isEmpty(this.f12465a)) {
            this.i |= 134217728;
            this.j = "UrlEmptyError";
            i().a(new com.qq.e.comm.plugin.j.c(this.i, this.j));
            return false;
        }
        File parentFile = this.f12466b == null ? null : this.f12466b.getParentFile();
        if (parentFile == null || !(parentFile.exists() || parentFile.mkdirs())) {
            this.i |= 2048;
            this.j = "FailToCreateDirectory";
            i().a(new com.qq.e.comm.plugin.j.c(this.i, this.j));
            return false;
        }
        return true;
    }

    private void h() {
        if (this.h.compareAndSet(false, true)) {
            if (this.g != null) {
                this.g.f();
            }
            for (h hVar : this.q) {
                hVar.c();
            }
        }
    }

    private com.qq.e.comm.plugin.j.a i() {
        return this.r == null ? s : this.r;
    }

    @Override // com.qq.e.comm.plugin.j.e
    public int a() {
        return this.i;
    }

    @Override // com.qq.e.comm.plugin.j.f
    public void a(long j, long j2) {
        if (this.r != null) {
            this.r.a(j, j2, j2 <= 0 ? 0 : (int) ((100 * j) / j2));
        }
        if (this.k != null) {
            this.k.a(j, j2);
        }
    }

    public void a(com.qq.e.comm.plugin.j.a aVar) {
        this.r = aVar;
    }

    @Override // com.qq.e.comm.plugin.j.e
    public void a(com.qq.e.comm.plugin.j.f fVar) {
        this.k = fVar;
    }

    @Override // com.qq.e.comm.plugin.j.e
    public String b() {
        return this.j;
    }

    @Override // com.qq.e.comm.plugin.j.e
    public boolean c() {
        try {
            return f();
        } catch (Exception e) {
            i().a(new com.qq.e.comm.plugin.j.c(1, e.getMessage(), e));
            return false;
        }
    }

    public void d() {
        h();
        this.i |= 512;
    }

    public void e() {
        h();
        this.i |= 256;
    }
}
