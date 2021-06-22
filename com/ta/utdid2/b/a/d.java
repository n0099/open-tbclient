package com.ta.utdid2.b.a;

import androidx.appcompat.widget.ActivityChooserModel;
import com.ta.utdid2.b.a.b;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes7.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public static final Object f39924b = new Object();

    /* renamed from: a  reason: collision with root package name */
    public File f39925a;

    /* renamed from: a  reason: collision with other field name */
    public final Object f12a = new Object();

    /* renamed from: a  reason: collision with other field name */
    public HashMap<File, a> f13a = new HashMap<>();

    /* loaded from: classes7.dex */
    public static final class a implements b {

        /* renamed from: c  reason: collision with root package name */
        public static final Object f39926c = new Object();

        /* renamed from: a  reason: collision with root package name */
        public Map f39927a;

        /* renamed from: a  reason: collision with other field name */
        public WeakHashMap<b.InterfaceC0509b, Object> f14a;

        /* renamed from: b  reason: collision with root package name */
        public final int f39928b;

        /* renamed from: b  reason: collision with other field name */
        public final File f15b;

        /* renamed from: c  reason: collision with other field name */
        public final File f16c;

        /* renamed from: g  reason: collision with root package name */
        public boolean f39929g = false;

        public a(File file, int i2, Map map) {
            this.f15b = file;
            this.f16c = d.a(file);
            this.f39928b = i2;
            this.f39927a = map == null ? new HashMap() : map;
            this.f14a = new WeakHashMap<>();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean d() {
            if (this.f15b.exists()) {
                if (!this.f16c.exists()) {
                    if (!this.f15b.renameTo(this.f16c)) {
                        return false;
                    }
                } else {
                    this.f15b.delete();
                }
            }
            try {
                FileOutputStream a2 = a(this.f15b);
                if (a2 == null) {
                    return false;
                }
                e.a(this.f39927a, a2);
                a2.close();
                this.f16c.delete();
                return true;
            } catch (Exception unused) {
                if (this.f15b.exists()) {
                    this.f15b.delete();
                }
                return false;
            }
        }

        public boolean c() {
            boolean z;
            synchronized (this) {
                z = this.f39929g;
            }
            return z;
        }

        @Override // com.ta.utdid2.b.a.b
        public Map<String, ?> getAll() {
            HashMap hashMap;
            synchronized (this) {
                hashMap = new HashMap(this.f39927a);
            }
            return hashMap;
        }

        @Override // com.ta.utdid2.b.a.b
        public long getLong(String str, long j) {
            synchronized (this) {
                Long l = (Long) this.f39927a.get(str);
                if (l != null) {
                    j = l.longValue();
                }
            }
            return j;
        }

        @Override // com.ta.utdid2.b.a.b
        public String getString(String str, String str2) {
            synchronized (this) {
                String str3 = (String) this.f39927a.get(str);
                if (str3 != null) {
                    str2 = str3;
                }
            }
            return str2;
        }

        /* renamed from: com.ta.utdid2.b.a.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public final class C0510a implements b.a {

            /* renamed from: b  reason: collision with root package name */
            public final Map<String, Object> f39931b = new HashMap();

            /* renamed from: h  reason: collision with root package name */
            public boolean f39932h = false;

            public C0510a() {
            }

            @Override // com.ta.utdid2.b.a.b.a
            public b.a a(String str, String str2) {
                synchronized (this) {
                    this.f39931b.put(str, str2);
                }
                return this;
            }

            @Override // com.ta.utdid2.b.a.b.a
            public b.a b() {
                synchronized (this) {
                    this.f39932h = true;
                }
                return this;
            }

            @Override // com.ta.utdid2.b.a.b.a
            public boolean commit() {
                boolean z;
                ArrayList arrayList;
                HashSet<b.InterfaceC0509b> hashSet;
                boolean d2;
                synchronized (d.f39924b) {
                    z = a.this.f14a.size() > 0;
                    arrayList = null;
                    if (z) {
                        arrayList = new ArrayList();
                        hashSet = new HashSet(a.this.f14a.keySet());
                    } else {
                        hashSet = null;
                    }
                    synchronized (this) {
                        if (this.f39932h) {
                            a.this.f39927a.clear();
                            this.f39932h = false;
                        }
                        for (Map.Entry<String, Object> entry : this.f39931b.entrySet()) {
                            String key = entry.getKey();
                            Object value = entry.getValue();
                            if (value == this) {
                                a.this.f39927a.remove(key);
                            } else {
                                a.this.f39927a.put(key, value);
                            }
                            if (z) {
                                arrayList.add(key);
                            }
                        }
                        this.f39931b.clear();
                    }
                    d2 = a.this.d();
                    if (d2) {
                        a.this.a(true);
                    }
                }
                if (z) {
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        String str = (String) arrayList.get(size);
                        for (b.InterfaceC0509b interfaceC0509b : hashSet) {
                            if (interfaceC0509b != null) {
                                interfaceC0509b.a(a.this, str);
                            }
                        }
                    }
                }
                return d2;
            }

            @Override // com.ta.utdid2.b.a.b.a
            public b.a a(String str, int i2) {
                synchronized (this) {
                    this.f39931b.put(str, Integer.valueOf(i2));
                }
                return this;
            }

            @Override // com.ta.utdid2.b.a.b.a
            public b.a a(String str, long j) {
                synchronized (this) {
                    this.f39931b.put(str, Long.valueOf(j));
                }
                return this;
            }

            @Override // com.ta.utdid2.b.a.b.a
            public b.a a(String str, float f2) {
                synchronized (this) {
                    this.f39931b.put(str, Float.valueOf(f2));
                }
                return this;
            }

            @Override // com.ta.utdid2.b.a.b.a
            public b.a a(String str, boolean z) {
                synchronized (this) {
                    this.f39931b.put(str, Boolean.valueOf(z));
                }
                return this;
            }

            @Override // com.ta.utdid2.b.a.b.a
            public b.a a(String str) {
                synchronized (this) {
                    this.f39931b.put(str, this);
                }
                return this;
            }
        }

        @Override // com.ta.utdid2.b.a.b
        public boolean a() {
            return this.f15b != null && new File(this.f15b.getAbsolutePath()).exists();
        }

        public void a(boolean z) {
            synchronized (this) {
                this.f39929g = z;
            }
        }

        public void a(Map map) {
            if (map != null) {
                synchronized (this) {
                    this.f39927a = map;
                }
            }
        }

        @Override // com.ta.utdid2.b.a.b
        public b.a a() {
            return new C0510a();
        }

        private FileOutputStream a(File file) {
            FileOutputStream fileOutputStream;
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (FileNotFoundException unused) {
                if (!file.getParentFile().mkdir()) {
                    return null;
                }
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (FileNotFoundException unused2) {
                    return null;
                }
            }
            return fileOutputStream;
        }
    }

    public d(String str) {
        if (str != null && str.length() > 0) {
            this.f39925a = new File(str);
            return;
        }
        throw new RuntimeException("Directory can not be empty");
    }

    private File a(File file, String str) {
        if (str.indexOf(File.separatorChar) < 0) {
            return new File(file, str);
        }
        throw new IllegalArgumentException("File " + str + " contains a path separator");
    }

    private File b(String str) {
        File a2 = a();
        return a(a2, str + ActivityChooserModel.HISTORY_FILE_EXTENSION);
    }

    private File a() {
        File file;
        synchronized (this.f12a) {
            file = this.f39925a;
        }
        return file;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:71:0x005a */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:85:0x0035 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:53:0x008c A[Catch: all -> 0x005a, TRY_ENTER, TRY_LEAVE, TryCatch #15 {all -> 0x005a, blocks: (B:30:0x0057, B:53:0x008c), top: B:85:0x0035 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0093 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public b a(String str, int i2) {
        FileInputStream fileInputStream;
        File b2 = b(str);
        synchronized (f39924b) {
            a aVar = this.f13a.get(b2);
            if (aVar == null || aVar.c()) {
                File a2 = a(b2);
                if (a2.exists()) {
                    b2.delete();
                    a2.renameTo(b2);
                }
                HashMap hashMap = null;
                hashMap = null;
                hashMap = null;
                FileInputStream fileInputStream2 = null;
                FileInputStream fileInputStream3 = null;
                hashMap = null;
                FileInputStream fileInputStream4 = null;
                if (b2.exists()) {
                    HashMap canRead = b2.canRead();
                    try {
                        try {
                            if (canRead != 0) {
                                try {
                                    FileInputStream fileInputStream5 = new FileInputStream(b2);
                                    try {
                                        hashMap = e.a(fileInputStream5);
                                        fileInputStream5.close();
                                        try {
                                            fileInputStream5.close();
                                        } catch (Throwable unused) {
                                        }
                                    } catch (XmlPullParserException unused2) {
                                        HashMap hashMap2 = hashMap;
                                        fileInputStream2 = fileInputStream5;
                                        canRead = hashMap2;
                                        try {
                                            fileInputStream = new FileInputStream(b2);
                                            try {
                                                fileInputStream.read(new byte[fileInputStream.available()]);
                                                try {
                                                    fileInputStream.close();
                                                } catch (Throwable unused3) {
                                                }
                                            } catch (Exception unused4) {
                                                fileInputStream2 = fileInputStream;
                                                if (fileInputStream2 != null) {
                                                    try {
                                                        fileInputStream2.close();
                                                    } catch (Throwable unused5) {
                                                    }
                                                }
                                                fileInputStream = fileInputStream2;
                                                if (fileInputStream != null) {
                                                }
                                                hashMap = canRead;
                                                synchronized (f39924b) {
                                                }
                                            } catch (Throwable th) {
                                                th = th;
                                                fileInputStream2 = fileInputStream;
                                                if (fileInputStream2 != null) {
                                                    try {
                                                        fileInputStream2.close();
                                                    } catch (Throwable unused6) {
                                                    }
                                                }
                                                throw th;
                                            }
                                        } catch (Exception unused7) {
                                        } catch (Throwable th2) {
                                            th = th2;
                                        }
                                        if (fileInputStream != null) {
                                            fileInputStream.close();
                                            canRead = canRead;
                                        }
                                        hashMap = canRead;
                                        synchronized (f39924b) {
                                        }
                                    } catch (Exception unused8) {
                                        HashMap hashMap3 = hashMap;
                                        fileInputStream3 = fileInputStream5;
                                        canRead = hashMap3;
                                        if (fileInputStream3 != null) {
                                            fileInputStream3.close();
                                            canRead = canRead;
                                        }
                                        hashMap = canRead;
                                        synchronized (f39924b) {
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        fileInputStream4 = fileInputStream5;
                                        if (fileInputStream4 != null) {
                                            try {
                                                fileInputStream4.close();
                                            } catch (Throwable unused9) {
                                            }
                                        }
                                        throw th;
                                    }
                                } catch (XmlPullParserException unused10) {
                                    canRead = 0;
                                } catch (Exception unused11) {
                                    canRead = null;
                                }
                            }
                        } catch (Throwable th4) {
                            th = th4;
                        }
                    } catch (Throwable unused12) {
                    }
                }
                synchronized (f39924b) {
                    if (aVar != null) {
                        aVar.a(hashMap);
                    } else {
                        aVar = this.f13a.get(b2);
                        if (aVar == null) {
                            aVar = new a(b2, i2, hashMap);
                            this.f13a.put(b2, aVar);
                        }
                    }
                }
                return aVar;
            }
            return aVar;
        }
    }

    public static File a(File file) {
        return new File(file.getPath() + ".bak");
    }
}
