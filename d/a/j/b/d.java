package d.a.j.b;

import android.content.ContentResolver;
import android.content.Context;
import android.content.UriMatcher;
import android.content.UriPermission;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Process;
import com.baidu.cesium.a.i;
import d.a.j.b.a;
import d.a.j.f;
import d.a.j.l;
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
public class d extends d.a.j.b.a {

    /* renamed from: f  reason: collision with root package name */
    public Context f40132f;

    /* renamed from: g  reason: collision with root package name */
    public g f40133g;

    /* loaded from: classes.dex */
    public static final class a implements Comparable<a> {

        /* renamed from: f  reason: collision with root package name */
        public static final String[] f40134f = {"read0", "read1", "read2", "read3", "access0", "access1", "access2", "access3", "sync0", "sync1", "sync2", "sync3", "open0", "open1", "open2", "open3"};

        /* renamed from: e  reason: collision with root package name */
        public final int f40135e;

        public a(int i2) {
            this.f40135e = i2;
        }

        public static a b(byte b2, boolean z) {
            int i2 = b2 & 255;
            return c(z ? i2 >> 4 : i2 & 15);
        }

        public static a c(int i2) {
            if (i2 < 0 || i2 >= 16) {
                throw new IllegalArgumentException("invalid idx " + i2);
            }
            return new a(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(a aVar) {
            return this.f40135e - aVar.f40135e;
        }

        public String d() {
            return f40134f[this.f40135e];
        }

        public byte e() {
            return (byte) this.f40135e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && a.class == obj.getClass() && this.f40135e == ((a) obj).f40135e;
        }

        public int hashCode() {
            return this.f40135e;
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public Map<a, Integer> f40136a = new HashMap();

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
            ArrayList arrayList = new ArrayList(this.f40136a.entrySet());
            Collections.sort(arrayList, new a(this));
            ArrayList arrayList2 = new ArrayList(6);
            int min = Math.min(6, arrayList.size());
            for (int i2 = 0; i2 < min; i2++) {
                Map.Entry entry = (Map.Entry) arrayList.get(i2);
                if (((Integer) entry.getValue()).intValue() > 1) {
                    arrayList2.add(entry.getKey());
                }
            }
            return arrayList2;
        }

        public void b(a aVar) {
            Integer num = this.f40136a.get(aVar);
            this.f40136a.put(aVar, num == null ? 1 : Integer.valueOf(num.intValue() + 1));
        }
    }

    /* loaded from: classes.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public int f40137a;

        /* renamed from: b  reason: collision with root package name */
        public a[] f40138b;

        /* renamed from: c  reason: collision with root package name */
        public int f40139c;

        public c(d dVar) {
            this.f40137a = 33;
            this.f40138b = new a[33];
        }

        public c(d dVar, byte[] bArr) {
            this.f40137a = 33;
            this.f40138b = new a[33];
            if (bArr == null || bArr.length <= 0) {
                return;
            }
            for (int i2 = 0; i2 < bArr.length; i2++) {
                a b2 = a.b(bArr[i2], false);
                a b3 = a.b(bArr[i2], true);
                c(b2);
                c(b3);
            }
        }

        public int a() {
            return this.f40139c;
        }

        public a b(int i2) {
            if (i2 < this.f40139c) {
                return this.f40138b[i2];
            }
            throw new IndexOutOfBoundsException("idx " + i2 + " size " + this.f40139c);
        }

        public void c(a aVar) {
            d(this.f40139c + 1);
            a[] aVarArr = this.f40138b;
            int i2 = this.f40139c;
            this.f40139c = i2 + 1;
            aVarArr[i2] = aVar;
        }

        public final void d(int i2) {
            a[] aVarArr = this.f40138b;
            if (i2 - aVarArr.length > 0) {
                int length = aVarArr.length;
                int i3 = length + (length >> 1);
                if (i3 - i2 >= 0) {
                    i2 = i3;
                }
                this.f40138b = (a[]) Arrays.copyOf(this.f40138b, i2);
            }
        }

        public byte[] e() {
            int i2;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int i3 = 0;
            while (true) {
                i2 = this.f40139c;
                if (i3 >= i2 / 2) {
                    break;
                }
                int i4 = i3 * 2;
                byteArrayOutputStream.write((byte) (((b(i4 + 1).e() & 255) << 4) | (b(i4).e() & 255)));
                i3++;
            }
            if (i2 % 2 != 0) {
                byteArrayOutputStream.write((byte) (b(i2 - 1).e() & 255));
            }
            return byteArrayOutputStream.toByteArray();
        }
    }

    /* renamed from: d.a.j.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0547d {

        /* renamed from: a  reason: collision with root package name */
        public List<b> f40140a = new ArrayList();

        /* renamed from: d.a.j.b.d$d$a */
        /* loaded from: classes.dex */
        public class a implements Comparator<b> {
            public a(C0547d c0547d) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(b bVar, b bVar2) {
                return bVar.f40141a - bVar2.f40141a;
            }
        }

        /* renamed from: d.a.j.b.d$d$b */
        /* loaded from: classes.dex */
        public static class b {

            /* renamed from: a  reason: collision with root package name */
            public int f40141a;

            /* renamed from: b  reason: collision with root package name */
            public a f40142b;

            public b(a aVar) {
                this.f40142b = aVar;
            }

            public void b() {
                this.f40141a++;
            }
        }

        public List<b> a() {
            ArrayList arrayList = new ArrayList(this.f40140a);
            Collections.sort(arrayList, new a(this));
            return arrayList;
        }

        public void b(a aVar) {
            this.f40140a.add(new b(aVar));
        }
    }

    /* loaded from: classes.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public byte[] f40143a;

        /* renamed from: b  reason: collision with root package name */
        public byte f40144b;

        /* renamed from: c  reason: collision with root package name */
        public byte[] f40145c;

        public e(byte[] bArr, byte b2, byte[] bArr2) {
            this.f40143a = bArr;
            this.f40144b = b2;
            this.f40145c = bArr2;
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
                return l.e(f.c.a(this.f40143a, "", true), new String(new byte[]{this.f40144b}, "UTF-8"), this.f40145c != null ? new String(this.f40145c, "UTF-8") : null);
            } catch (Exception unused) {
                return null;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class f {

        /* renamed from: a  reason: collision with root package name */
        public int f40146a;

        /* renamed from: b  reason: collision with root package name */
        public int f40147b;

        public String toString() {
            return "";
        }
    }

    /* loaded from: classes.dex */
    public static class g {

        /* renamed from: a  reason: collision with root package name */
        public Method f40148a;

        /* renamed from: b  reason: collision with root package name */
        public Method f40149b;

        /* renamed from: c  reason: collision with root package name */
        public Method f40150c;

        /* renamed from: d  reason: collision with root package name */
        public Method f40151d;

        /* renamed from: e  reason: collision with root package name */
        public Method f40152e;

        public int a(Context context, Uri uri, int i2, int i3, int i4) {
            try {
                return ((Integer) this.f40148a.invoke(context, uri, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4))).intValue();
            } catch (Exception e2) {
                throw new i.a(e2);
            }
        }

        public void b() {
            try {
                this.f40148a = i.b(Context.class, i.a(d.a.j.a.c.d()), new Class[]{Uri.class, Integer.TYPE, Integer.TYPE, Integer.TYPE});
                this.f40149b = i.b(Context.class, i.a(d.a.j.a.c.e()), new Class[]{String.class, Uri.class, Integer.TYPE});
                this.f40150c = i.b(ContentResolver.class, i.a(d.a.j.a.c.f()), new Class[]{Uri.class, Integer.TYPE});
                this.f40151d = i.b(Context.class, i.a(d.a.j.a.c.g()), new Class[]{Uri.class, Integer.TYPE});
                this.f40152e = i.b(ContentResolver.class, i.a(d.a.j.a.c.h()), new Class[]{Uri.class, Integer.TYPE});
            } catch (Exception unused) {
            }
        }

        public void c(ContentResolver contentResolver, Uri uri, int i2) {
            try {
                this.f40150c.invoke(contentResolver, uri, Integer.valueOf(i2));
            } catch (Exception e2) {
                throw new i.a(e2);
            }
        }

        public void d(Context context, Uri uri, int i2) {
            try {
                this.f40151d.invoke(context, uri, Integer.valueOf(i2));
            } catch (Exception e2) {
                throw new i.a(e2);
            }
        }

        public void e(Context context, String str, Uri uri, int i2) {
            try {
                this.f40149b.invoke(context, str, uri, Integer.valueOf(i2));
            } catch (Exception e2) {
                throw new i.a(e2);
            }
        }

        public void f(ContentResolver contentResolver, Uri uri, int i2) {
            try {
                this.f40152e.invoke(contentResolver, uri, Integer.valueOf(i2));
            } catch (Exception e2) {
                throw new i.a(e2);
            }
        }
    }

    public d() {
        super("upc", 9000000L);
        g gVar = new g();
        this.f40133g = gVar;
        gVar.b();
    }

    public static byte[] s(String str) {
        if (str.length() % 2 == 0) {
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                int digit = Character.digit(str.charAt(i3), 16);
                int digit2 = Character.digit(str.charAt(i3 + 1), 16);
                if (digit == -1 || digit2 == -1) {
                    throw new IllegalArgumentException("input is not hexadecimal");
                }
                bArr[i2] = (byte) ((digit * 16) + digit2);
            }
            return bArr;
        }
        throw new IllegalArgumentException("Expected a string of even length");
    }

    @Override // d.a.j.b.a
    public a.f a(a.e eVar, l.a aVar) {
        e a2;
        if (Build.VERSION.SDK_INT >= 26 && (a2 = e.a(aVar)) != null) {
            c cVar = new c(this, a2.f40143a);
            cVar.c(a.b(a2.f40144b, false));
            cVar.c(a.b(a2.f40144b, true));
            byte[] bArr = a2.f40145c;
            if (bArr != null) {
                for (byte b2 : bArr) {
                    cVar.c(a.b(b2, false));
                    cVar.c(a.b(b2, true));
                }
            }
            b bVar = new b();
            for (int i2 = 0; i2 < cVar.a(); i2++) {
                bVar.b(cVar.b(i2));
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

    @Override // d.a.j.b.a
    public a.h b(String str, a.g gVar) {
        int i2;
        byte[] bArr;
        boolean z;
        Byte b2;
        Byte b3;
        if (Build.VERSION.SDK_INT < 26) {
            return a.h.d();
        }
        try {
            i2 = this.f40132f.getPackageManager().getPackageUid(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            i2 = -1;
        }
        if (i2 < 0) {
            return a.h.d();
        }
        f fVar = new f();
        c cVar = new c(this);
        C0547d c0547d = new C0547d();
        C0547d c0547d2 = new C0547d();
        for (int i3 = 0; i3 < 16; i3++) {
            a c2 = a.c(i3);
            if (q(str, c2, i2)) {
                c0547d.b(c2);
            } else {
                c0547d2.b(c2);
            }
        }
        for (int i4 = 0; i4 < 32; i4++) {
            a g2 = g(str, i4, c0547d.a(), i2, fVar);
            if (g2 == null) {
                g2 = g(str, i4, c0547d2.a(), i2, fVar);
            }
            if (g2 == null) {
                return a.h.d();
            }
            cVar.c(g2);
        }
        byte[] e2 = cVar.e();
        int i5 = 3;
        byte[] bArr2 = {"0".getBytes()[0], "O".getBytes()[0], "V".getBytes()[0]};
        int i6 = 0;
        while (true) {
            bArr = null;
            if (i6 >= i5) {
                z = true;
                b2 = null;
                break;
            }
            byte b4 = bArr2[i6];
            a b5 = a.b(b4, false);
            int i7 = i6;
            z = true;
            byte[] bArr3 = bArr2;
            if (p(str, 32, b5, i2, fVar)) {
                a b6 = a.b(b4, true);
                if (p(str, 33, b6, i2, fVar)) {
                    c cVar2 = new c(this);
                    cVar2.c(b5);
                    cVar2.c(b6);
                    b2 = Byte.valueOf(cVar2.e()[0]);
                    break;
                }
            }
            i6 = i7 + 1;
            bArr2 = bArr3;
            i5 = 3;
        }
        if (b2 == null) {
            c cVar3 = new c(this);
            int i8 = 32;
            for (int i9 = 34; i8 < i9; i9 = 34) {
                int i10 = i8;
                c cVar4 = cVar3;
                a g3 = g(str, i8, c0547d.a(), i2, fVar);
                if (g3 == null) {
                    g3 = g(str, i10, c0547d2.a(), i2, fVar);
                }
                if (g3 == null) {
                    return a.h.d();
                }
                cVar4.c(g3);
                i8 = i10 + 1;
                cVar3 = cVar4;
            }
            b3 = Byte.valueOf(cVar3.e()[0]);
        } else {
            b3 = b2;
            z = false;
        }
        if (z) {
            c cVar5 = new c(this);
            for (int i11 = 34; i11 < 94; i11++) {
                a g4 = g(str, i11, c0547d.a(), i2, fVar);
                if (g4 == null) {
                    g4 = g(str, i11, c0547d2.a(), i2, fVar);
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

    @Override // d.a.j.b.a
    public void e(a.d dVar) {
        this.f40132f = this.f40106a.f40110a;
    }

    public final a g(String str, int i2, List<C0547d.b> list, int i3, f fVar) {
        for (C0547d.b bVar : list) {
            if (p(str, i2, bVar.f40142b, i3, fVar)) {
                bVar.b();
                return bVar.f40142b;
            }
        }
        return null;
    }

    public final String h(String str, int i2, a aVar) {
        return String.format("content://%s/dat/v1/i%d/%s", t(str), Integer.valueOf(i2), aVar.d());
    }

    public final String i(String str, a aVar) {
        return String.format("content://%s/dic/v1/%s", t(str), aVar.d());
    }

    public final void j(UriMatcher uriMatcher) {
        uriMatcher.addURI(t(this.f40132f.getPackageName()), "dat/v1/*/*", 1);
        uriMatcher.addURI(t(this.f40132f.getPackageName()), "dic/v1/*", 2);
    }

    public final boolean k(int i2, a aVar) {
        if (Build.VERSION.SDK_INT < 26) {
            return false;
        }
        return l(Uri.parse(h(this.f40132f.getPackageName(), i2, aVar)));
    }

    public final boolean l(Uri uri) {
        if (Build.VERSION.SDK_INT < 26) {
            return false;
        }
        Context context = this.f40132f;
        ContentResolver contentResolver = context.getContentResolver();
        try {
            this.f40133g.e(context, context.getPackageName(), uri, 65);
            this.f40133g.c(contentResolver, uri, 1);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public final boolean m(Uri uri, int i2) {
        if (Build.VERSION.SDK_INT < 26) {
            return false;
        }
        Context context = this.f40132f;
        ContentResolver contentResolver = context.getContentResolver();
        try {
            this.f40133g.d(context, uri, i2);
            this.f40133g.f(contentResolver, uri, i2);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public final boolean n(a aVar) {
        if (Build.VERSION.SDK_INT < 26) {
            return false;
        }
        return l(Uri.parse(i(this.f40132f.getPackageName(), aVar)));
    }

    public final boolean o(c cVar, List<a> list) {
        int i2;
        boolean z;
        if (Build.VERSION.SDK_INT < 26) {
            return false;
        }
        ContentResolver contentResolver = this.f40132f.getContentResolver();
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
                    i2 = Integer.valueOf(pathSegments.get(2).substring(1)).intValue();
                } catch (Exception unused) {
                    i2 = -1;
                }
                if (i2 >= 0 && i2 < cVar.a()) {
                    if (!cVar.b(i2).d().equals(pathSegments.get(3))) {
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
        for (int i3 = 0; i3 < a2; i3++) {
            if (!p(this.f40132f.getPackageName(), i3, cVar.b(i3), Process.myUid(), null)) {
                return true;
            }
        }
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            if (!q(this.f40132f.getPackageName(), list.get(i4), Process.myUid())) {
                return true;
            }
        }
        return false;
    }

    public final boolean p(String str, int i2, a aVar, int i3, f fVar) {
        int i4;
        Uri parse = Uri.parse(h(str, i2, aVar));
        int i5 = 0;
        while (true) {
            if (i5 >= 2) {
                i4 = -1;
                break;
            }
            if (fVar != null) {
                try {
                    fVar.f40146a++;
                } catch (Throwable unused) {
                    try {
                        Thread.sleep(5L);
                    } catch (Exception unused2) {
                    }
                    i5++;
                }
            }
            i4 = this.f40133g.a(this.f40132f, parse, 0, i3, 1);
            break;
        }
        if (i4 == 0) {
            return true;
        }
        if (fVar != null) {
            fVar.f40147b++;
        }
        return false;
    }

    public final boolean q(String str, a aVar, int i2) {
        int i3;
        Uri parse = Uri.parse(i(str, aVar));
        int i4 = 0;
        while (true) {
            if (i4 >= 2) {
                i3 = -1;
                break;
            }
            try {
                i3 = this.f40133g.a(this.f40132f, parse, 0, i2, 1);
                break;
            } catch (Throwable unused) {
                try {
                    Thread.sleep(5L);
                } catch (Exception unused2) {
                }
                i4++;
            }
        }
        return i3 == 0;
    }

    public final String t(String str) {
        return str + ".cesium";
    }
}
