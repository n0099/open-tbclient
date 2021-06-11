package d.a.l0.a.b1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class c extends DataInputStream {

    /* renamed from: e  reason: collision with root package name */
    public static final d.a.l0.a.b1.b<String, byte[]> f44481e = new a();

    /* loaded from: classes3.dex */
    public static class a implements d.a.l0.a.b1.b<String, byte[]> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.b1.b
        @Nullable
        /* renamed from: a */
        public String call(@Nullable byte[] bArr) throws Exception {
            if (bArr == null) {
                return null;
            }
            return bArr.length == 0 ? "" : new String(bArr);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.l0.a.b1.b<Boolean, byte[]> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.b1.b
        @Nullable
        /* renamed from: a */
        public Boolean call(@Nullable byte[] bArr) throws Exception {
            return Boolean.valueOf(bArr != null);
        }
    }

    public c(InputStream inputStream) throws IOException {
        super(inputStream);
    }

    public Map<String, Boolean> n() throws IOException {
        return r(new b());
    }

    public byte[] o() throws IOException {
        int readInt = readInt();
        if (readInt >= 0) {
            byte[] bArr = new byte[readInt];
            if (readInt == read(bArr)) {
                return bArr;
            }
            return null;
        }
        return null;
    }

    public <T> T p(@NonNull d.a.l0.a.b1.b<T, byte[]> bVar) {
        try {
            return bVar.call(o());
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public <T> List<T> q(d.a.l0.a.b1.b<T, byte[]> bVar) throws IOException {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            try {
                arrayList.add(bVar.call(o()));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return arrayList;
    }

    public <T> Map<String, T> r(d.a.l0.a.b1.b<T, byte[]> bVar) throws IOException {
        List<String> t;
        List<T> q;
        if (readInt() >= 0 && (t = t()) != null && (q = q(bVar)) != null && t.size() == q.size()) {
            HashMap hashMap = new HashMap();
            for (int i2 = 0; i2 < t.size(); i2++) {
                hashMap.put(t.get(i2), q.get(i2));
            }
            return hashMap;
        }
        return null;
    }

    public String s() {
        try {
            return f44481e.call(o());
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public List<String> t() throws IOException {
        return q(f44481e);
    }

    public List<String> u(List<String> list) throws IOException {
        List<String> t = t();
        return t == null ? list : t;
    }

    public Map<String, String> v() throws IOException {
        return r(f44481e);
    }
}
