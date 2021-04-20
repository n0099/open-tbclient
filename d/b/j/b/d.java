package d.b.j.b;

import android.content.ContentResolver;
import android.content.Context;
import android.content.UriMatcher;
import android.content.UriPermission;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Process;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.cesium.a.i;
import d.b.j.b.a;
import d.b.j.f;
import d.b.j.l;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class d extends d.b.j.b.a {

    /* renamed from: f  reason: collision with root package name */
    public Context f64370f;

    /* renamed from: g  reason: collision with root package name */
    public g f64371g;

    /* loaded from: classes.dex */
    public static final class a implements Comparable<a> {

        /* renamed from: f  reason: collision with root package name */
        public static final String[] f64372f = {"read0", "read1", "read2", "read3", "access0", "access1", "access2", "access3", "sync0", "sync1", "sync2", "sync3", "open0", "open1", "open2", "open3"};

        /* renamed from: e  reason: collision with root package name */
        public final int f64373e;

        public a(int i) {
            this.f64373e = i;
        }

        public static a b(byte b2, boolean z) {
            int i = b2 & 255;
            return c(z ? i >> 4 : i & 15);
        }

        public static a c(int i) {
            if (i < 0 || i >= 16) {
                throw new IllegalArgumentException("invalid idx " + i);
            }
            return new a(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(a aVar) {
            return this.f64373e - aVar.f64373e;
        }

        public String d() {
            return f64372f[this.f64373e];
        }

        public byte e() {
            return (byte) this.f64373e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && a.class == obj.getClass() && this.f64373e == ((a) obj).f64373e;
        }

        public int hashCode() {
            return this.f64373e;
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public Map<a, Integer> f64374a = new HashMap();

        /* loaded from: classes.dex */
        public class a implements Comparator<Map.Entry<a, Integer>> {
            public a(b bVar) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(Map.Entry<a, Integer> entry, Map.Entry<a, Integer> entry2) {
                int intValue = entry2.getValue().intValue() - entry.getValue().intValue();
                return intValue != 0 ? intValue : entry.getKey().compareTo(entry2.getKey());
            }
        }

        public List<a> a() {
            ArrayList arrayList = new ArrayList(this.f64374a.entrySet());
            Collections.sort(arrayList, new a(this));
            ArrayList arrayList2 = new ArrayList(6);
            int min = Math.min(6, arrayList.size());
            for (int i = 0; i < min; i++) {
                Map.Entry entry = (Map.Entry) arrayList.get(i);
                if (((Integer) entry.getValue()).intValue() > 1) {
                    arrayList2.add(entry.getKey());
                }
            }
            return arrayList2;
        }

        public void b(a aVar) {
            Integer num = this.f64374a.get(aVar);
            this.f64374a.put(aVar, num == null ? 1 : Integer.valueOf(num.intValue() + 1));
        }
    }

    /* loaded from: classes.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public int f64375a;

        /* renamed from: b  reason: collision with root package name */
        public a[] f64376b;

        /* renamed from: c  reason: collision with root package name */
        public int f64377c;

        public c(d dVar) {
            this.f64375a = 33;
            this.f64376b = new a[33];
        }

        public c(d dVar, byte[] bArr) {
            this.f64375a = 33;
            this.f64376b = new a[33];
            if (bArr == null || bArr.length <= 0) {
                return;
            }
            for (int i = 0; i < bArr.length; i++) {
                a b2 = a.b(bArr[i], false);
                a b3 = a.b(bArr[i], true);
                c(b2);
                c(b3);
            }
        }

        public int a() {
            return this.f64377c;
        }

        public a b(int i) {
            if (i < this.f64377c) {
                return this.f64376b[i];
            }
            throw new IndexOutOfBoundsException("idx " + i + " size " + this.f64377c);
        }

        public void c(a aVar) {
            d(this.f64377c + 1);
            a[] aVarArr = this.f64376b;
            int i = this.f64377c;
            this.f64377c = i + 1;
            aVarArr[i] = aVar;
        }

        public final void d(int i) {
            a[] aVarArr = this.f64376b;
            if (i - aVarArr.length > 0) {
                int length = aVarArr.length;
                int i2 = length + (length >> 1);
                if (i2 - i >= 0) {
                    i = i2;
                }
                this.f64376b = (a[]) Arrays.copyOf(this.f64376b, i);
            }
        }

        public byte[] e() {
            int i;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int i2 = 0;
            while (true) {
                i = this.f64377c;
                if (i2 >= i / 2) {
                    break;
                }
                int i3 = i2 * 2;
                byteArrayOutputStream.write((byte) (((b(i3 + 1).e() & 255) << 4) | (b(i3).e() & 255)));
                i2++;
            }
            if (i % 2 != 0) {
                byteArrayOutputStream.write((byte) (b(i - 1).e() & 255));
            }
            return byteArrayOutputStream.toByteArray();
        }
    }

    /* renamed from: d.b.j.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C1739d {

        /* renamed from: a  reason: collision with root package name */
        public List<b> f64378a = new ArrayList();

        /* renamed from: d.b.j.b.d$d$a */
        /* loaded from: classes.dex */
        public class a implements Comparator<b> {
            public a(C1739d c1739d) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(b bVar, b bVar2) {
                return bVar.f64379a - bVar2.f64379a;
            }
        }

        /* renamed from: d.b.j.b.d$d$b */
        /* loaded from: classes.dex */
        public static class b {

            /* renamed from: a  reason: collision with root package name */
            public int f64379a;

            /* renamed from: b  reason: collision with root package name */
            public a f64380b;

            public b(a aVar) {
                this.f64380b = aVar;
            }

            public void b() {
                this.f64379a++;
            }
        }

        public List<b> a() {
            ArrayList arrayList = new ArrayList(this.f64378a);
            Collections.sort(arrayList, new a(this));
            return arrayList;
        }

        public void b(a aVar) {
            this.f64378a.add(new b(aVar));
        }
    }

    /* loaded from: classes.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public byte[] f64381a;

        /* renamed from: b  reason: collision with root package name */
        public byte f64382b;

        /* renamed from: c  reason: collision with root package name */
        public byte[] f64383c;

        public e(byte[] bArr, byte b2, byte[] bArr2) {
            this.f64381a = bArr;
            this.f64382b = b2;
            this.f64383c = bArr2;
        }

        public static e a(l.a aVar) {
            try {
                byte[] s = d.s(aVar.e());
                if (s.length > 16) {
                    return null;
                }
                return new e(s, aVar.j().getBytes("UTF-8")[0], aVar.h() != null ? aVar.h().getBytes("UTF-8") : null);
            } catch (Exception unused) {
                return null;
            }
        }

        public l.a b() {
            try {
                return l.e(f.c.a(this.f64381a, "", true), new String(new byte[]{this.f64382b}, "UTF-8"), this.f64383c != null ? new String(this.f64383c, "UTF-8") : null);
            } catch (Exception unused) {
                return null;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class f {

        /* renamed from: a  reason: collision with root package name */
        public int f64384a;

        /* renamed from: b  reason: collision with root package name */
        public int f64385b;

        public String toString() {
            return "";
        }
    }

    /* loaded from: classes.dex */
    public static class g {

        /* renamed from: a  reason: collision with root package name */
        public Method f64386a;

        /* renamed from: b  reason: collision with root package name */
        public Method f64387b;

        /* renamed from: c  reason: collision with root package name */
        public Method f64388c;

        /* renamed from: d  reason: collision with root package name */
        public Method f64389d;

        /* renamed from: e  reason: collision with root package name */
        public Method f64390e;

        public int a(Context context, Uri uri, int i, int i2, int i3) {
            try {
                return ((Integer) this.f64386a.invoke(context, uri, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3))).intValue();
            } catch (Exception e2) {
                throw new i.a(e2);
            }
        }

        public void b() {
            try {
                this.f64386a = i.b(Context.class, i.a(d.b.j.a.c.d()), new Class[]{Uri.class, Integer.TYPE, Integer.TYPE, Integer.TYPE});
                this.f64387b = i.b(Context.class, i.a(d.b.j.a.c.e()), new Class[]{String.class, Uri.class, Integer.TYPE});
                this.f64388c = i.b(ContentResolver.class, i.a(d.b.j.a.c.f()), new Class[]{Uri.class, Integer.TYPE});
                this.f64389d = i.b(Context.class, i.a(d.b.j.a.c.g()), new Class[]{Uri.class, Integer.TYPE});
                this.f64390e = i.b(ContentResolver.class, i.a(d.b.j.a.c.h()), new Class[]{Uri.class, Integer.TYPE});
            } catch (Exception unused) {
            }
        }

        public void c(ContentResolver contentResolver, Uri uri, int i) {
            try {
                this.f64388c.invoke(contentResolver, uri, Integer.valueOf(i));
            } catch (Exception e2) {
                throw new i.a(e2);
            }
        }

        public void d(Context context, Uri uri, int i) {
            try {
                this.f64389d.invoke(context, uri, Integer.valueOf(i));
            } catch (Exception e2) {
                throw new i.a(e2);
            }
        }

        public void e(Context context, String str, Uri uri, int i) {
            try {
                this.f64387b.invoke(context, str, uri, Integer.valueOf(i));
            } catch (Exception e2) {
                throw new i.a(e2);
            }
        }

        public void f(ContentResolver contentResolver, Uri uri, int i) {
            try {
                this.f64390e.invoke(contentResolver, uri, Integer.valueOf(i));
            } catch (Exception e2) {
                throw new i.a(e2);
            }
        }
    }

    public d() {
        super("upc", 9000000L);
        g gVar = new g();
        this.f64371g = gVar;
        gVar.b();
    }

    public static byte[] s(String str) {
        if (str.length() % 2 == 0) {
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i = 0; i < length; i++) {
                int i2 = i * 2;
                int digit = Character.digit(str.charAt(i2), 16);
                int digit2 = Character.digit(str.charAt(i2 + 1), 16);
                if (digit == -1 || digit2 == -1) {
                    throw new IllegalArgumentException("input is not hexadecimal");
                }
                bArr[i] = (byte) ((digit * 16) + digit2);
            }
            return bArr;
        }
        throw new IllegalArgumentException("Expected a string of even length");
    }

    @Override // d.b.j.b.a
    public a.f a(a.e eVar, l.a aVar) {
        e a2;
        if (Build.VERSION.SDK_INT >= 26 && (a2 = e.a(aVar)) != null) {
            c cVar = new c(this, a2.f64381a);
            cVar.c(a.b(a2.f64382b, false));
            cVar.c(a.b(a2.f64382b, true));
            byte[] bArr = a2.f64383c;
            if (bArr != null) {
                for (byte b2 : bArr) {
                    cVar.c(a.b(b2, false));
                    cVar.c(a.b(b2, true));
                }
            }
            b bVar = new b();
            for (int i = 0; i < cVar.a(); i++) {
                bVar.b(cVar.b(i));
            }
            List<a> a3 = bVar.a();
            if (o(cVar, a3)) {
                for (int a4 = cVar.a() - 1; a4 >= 0; a4--) {
                    k(a4, cVar.b(a4));
                }
                for (a aVar2 : a3) {
                    n(aVar2);
                }
                return a.f.b();
            }
            return a.f.b();
        }
        return a.f.c();
    }

    @Override // d.b.j.b.a
    public a.h b(String str, a.g gVar) {
        int i;
        byte[] bArr;
        boolean z;
        Byte b2;
        Byte b3;
        if (Build.VERSION.SDK_INT < 26) {
            return a.h.d();
        }
        try {
            i = this.f64370f.getPackageManager().getPackageUid(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            i = -1;
        }
        if (i < 0) {
            return a.h.d();
        }
        f fVar = new f();
        c cVar = new c(this);
        C1739d c1739d = new C1739d();
        C1739d c1739d2 = new C1739d();
        for (int i2 = 0; i2 < 16; i2++) {
            a c2 = a.c(i2);
            if (q(str, c2, i)) {
                c1739d.b(c2);
            } else {
                c1739d2.b(c2);
            }
        }
        for (int i3 = 0; i3 < 32; i3++) {
            a g2 = g(str, i3, c1739d.a(), i, fVar);
            if (g2 == null) {
                g2 = g(str, i3, c1739d2.a(), i, fVar);
            }
            if (g2 == null) {
                return a.h.d();
            }
            cVar.c(g2);
        }
        byte[] e2 = cVar.e();
        int i4 = 3;
        byte[] bArr2 = {"0".getBytes()[0], "O".getBytes()[0], ExifInterface.GPS_MEASUREMENT_INTERRUPTED.getBytes()[0]};
        int i5 = 0;
        while (true) {
            bArr = null;
            if (i5 >= i4) {
                z = true;
                b2 = null;
                break;
            }
            byte b4 = bArr2[i5];
            a b5 = a.b(b4, false);
            int i6 = i5;
            z = true;
            byte[] bArr3 = bArr2;
            if (p(str, 32, b5, i, fVar)) {
                a b6 = a.b(b4, true);
                if (p(str, 33, b6, i, fVar)) {
                    c cVar2 = new c(this);
                    cVar2.c(b5);
                    cVar2.c(b6);
                    b2 = Byte.valueOf(cVar2.e()[0]);
                    break;
                }
            }
            i5 = i6 + 1;
            bArr2 = bArr3;
            i4 = 3;
        }
        if (b2 == null) {
            c cVar3 = new c(this);
            int i7 = 32;
            for (int i8 = 34; i7 < i8; i8 = 34) {
                int i9 = i7;
                c cVar4 = cVar3;
                a g3 = g(str, i7, c1739d.a(), i, fVar);
                if (g3 == null) {
                    g3 = g(str, i9, c1739d2.a(), i, fVar);
                }
                if (g3 == null) {
                    return a.h.d();
                }
                cVar4.c(g3);
                i7 = i9 + 1;
                cVar3 = cVar4;
            }
            b3 = Byte.valueOf(cVar3.e()[0]);
        } else {
            b3 = b2;
            z = false;
        }
        if (z) {
            c cVar5 = new c(this);
            for (int i10 = 34; i10 < 94; i10++) {
                a g4 = g(str, i10, c1739d.a(), i, fVar);
                if (g4 == null) {
                    g4 = g(str, i10, c1739d2.a(), i, fVar);
                }
                if (g4 == null) {
                    break;
                }
                cVar5.c(g4);
            }
            if (cVar5.a() > 0) {
                bArr = cVar5.e();
            }
        }
        return a.h.b(new e(e2, b3.byteValue(), bArr).b());
    }

    @Override // d.b.j.b.a
    public void e(a.d dVar) {
        this.f64370f = this.f64344a.f64348a;
    }

    public final a g(String str, int i, List<C1739d.b> list, int i2, f fVar) {
        for (C1739d.b bVar : list) {
            if (p(str, i, bVar.f64380b, i2, fVar)) {
                bVar.b();
                return bVar.f64380b;
            }
        }
        return null;
    }

    public final String h(String str, int i, a aVar) {
        return String.format("content://%s/dat/v1/i%d/%s", t(str), Integer.valueOf(i), aVar.d());
    }

    public final String i(String str, a aVar) {
        return String.format("content://%s/dic/v1/%s", t(str), aVar.d());
    }

    public final void j(UriMatcher uriMatcher) {
        uriMatcher.addURI(t(this.f64370f.getPackageName()), "dat/v1/*/*", 1);
        uriMatcher.addURI(t(this.f64370f.getPackageName()), "dic/v1/*", 2);
    }

    public final boolean k(int i, a aVar) {
        if (Build.VERSION.SDK_INT < 26) {
            return false;
        }
        return l(Uri.parse(h(this.f64370f.getPackageName(), i, aVar)));
    }

    public final boolean l(Uri uri) {
        if (Build.VERSION.SDK_INT < 26) {
            return false;
        }
        Context context = this.f64370f;
        ContentResolver contentResolver = context.getContentResolver();
        try {
            this.f64371g.e(context, context.getPackageName(), uri, 65);
            this.f64371g.c(contentResolver, uri, 1);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public final boolean m(Uri uri, int i) {
        if (Build.VERSION.SDK_INT < 26) {
            return false;
        }
        Context context = this.f64370f;
        ContentResolver contentResolver = context.getContentResolver();
        try {
            this.f64371g.d(context, uri, i);
            this.f64371g.f(contentResolver, uri, i);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public final boolean n(a aVar) {
        if (Build.VERSION.SDK_INT < 26) {
            return false;
        }
        return l(Uri.parse(i(this.f64370f.getPackageName(), aVar)));
    }

    public final boolean o(c cVar, List<a> list) {
        int i;
        boolean z;
        if (Build.VERSION.SDK_INT < 26) {
            return false;
        }
        ContentResolver contentResolver = this.f64370f.getContentResolver();
        UriMatcher uriMatcher = new UriMatcher(-1);
        j(uriMatcher);
        List<UriPermission> persistedUriPermissions = contentResolver.getPersistedUriPermissions();
        if (persistedUriPermissions == null || persistedUriPermissions.size() == 0) {
            persistedUriPermissions = contentResolver.getOutgoingPersistedUriPermissions();
        }
        if (persistedUriPermissions == null || persistedUriPermissions.size() == 0) {
            return true;
        }
        for (UriPermission uriPermission : persistedUriPermissions) {
            Uri uri = uriPermission.getUri();
            int match = uriMatcher.match(uri);
            List<String> pathSegments = uri.getPathSegments();
            if ((match == 1 || match == 2) && uriPermission.isWritePermission()) {
                m(uri, uriPermission.isReadPermission() ? 3 : 2);
            } else if (match == 1) {
                try {
                    i = Integer.valueOf(pathSegments.get(2).substring(1)).intValue();
                } catch (Exception unused) {
                    i = -1;
                }
                if (i >= 0 && i < cVar.a()) {
                    if (!cVar.b(i).d().equals(pathSegments.get(3))) {
                    }
                }
                m(uri, 1);
            } else if (match == 2) {
                String str = pathSegments.get(2);
                Iterator<a> it = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it.next().d().equals(str)) {
                            z = true;
                            break;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
                if (!z) {
                    m(uri, 1);
                }
            }
        }
        int a2 = cVar.a();
        for (int i2 = 0; i2 < a2; i2++) {
            if (!p(this.f64370f.getPackageName(), i2, cVar.b(i2), Process.myUid(), null)) {
                return true;
            }
        }
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (!q(this.f64370f.getPackageName(), list.get(i3), Process.myUid())) {
                return true;
            }
        }
        return false;
    }

    public final boolean p(String str, int i, a aVar, int i2, f fVar) {
        int i3;
        Uri parse = Uri.parse(h(str, i, aVar));
        int i4 = 0;
        while (true) {
            if (i4 >= 2) {
                i3 = -1;
                break;
            }
            if (fVar != null) {
                try {
                    fVar.f64384a++;
                } catch (Throwable unused) {
                    try {
                        Thread.sleep(5L);
                    } catch (Exception unused2) {
                    }
                    i4++;
                }
            }
            i3 = this.f64371g.a(this.f64370f, parse, 0, i2, 1);
            break;
        }
        if (i3 == 0) {
            return true;
        }
        if (fVar != null) {
            fVar.f64385b++;
        }
        return false;
    }

    public final boolean q(String str, a aVar, int i) {
        int i2;
        Uri parse = Uri.parse(i(str, aVar));
        int i3 = 0;
        while (true) {
            if (i3 >= 2) {
                i2 = -1;
                break;
            }
            try {
                i2 = this.f64371g.a(this.f64370f, parse, 0, i, 1);
                break;
            } catch (Throwable unused) {
                try {
                    Thread.sleep(5L);
                } catch (Exception unused2) {
                }
                i3++;
            }
        }
        return i2 == 0;
    }

    public final String t(String str) {
        return str + ".cesium";
    }
}
