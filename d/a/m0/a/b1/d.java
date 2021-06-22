package d.a.m0.a.b1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Map;
/* loaded from: classes3.dex */
public class d extends DataOutputStream {

    /* renamed from: e  reason: collision with root package name */
    public static final d.a.m0.a.b1.b<byte[], String> f44591e = new a();

    /* loaded from: classes3.dex */
    public static class a implements d.a.m0.a.b1.b<byte[], String> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.b1.b
        @Nullable
        /* renamed from: a */
        public byte[] call(@Nullable String str) throws Exception {
            if (str == null) {
                return null;
            }
            return str.getBytes();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.m0.a.b1.b<byte[], Boolean> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.b1.b
        @Nullable
        /* renamed from: a */
        public byte[] call(@Nullable Boolean bool) throws Exception {
            if (bool == null || !bool.booleanValue()) {
                return null;
            }
            return new byte[0];
        }
    }

    public d(OutputStream outputStream) throws IOException {
        super(outputStream);
    }

    public void c(Map<String, Boolean> map) throws IOException {
        m(map, new b());
    }

    public void d(byte[] bArr) throws IOException {
        if (bArr == null) {
            writeInt(-1);
            return;
        }
        writeInt(bArr.length);
        if (bArr.length > 0) {
            write(bArr);
        }
    }

    public <T> void e(@Nullable T t, @NonNull d.a.m0.a.b1.b<byte[], T> bVar) {
        try {
            d(bVar.call(t));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public <T> void l(@Nullable Collection<T> collection, d.a.m0.a.b1.b<byte[], T> bVar) throws IOException {
        if (collection == null) {
            writeInt(-1);
            return;
        }
        writeInt(collection.size());
        for (T t : collection) {
            try {
                d(bVar.call(t));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public <T> void m(Map<String, T> map, d.a.m0.a.b1.b<byte[], T> bVar) throws IOException {
        if (map == null) {
            writeInt(-1);
            return;
        }
        writeInt(map.size());
        o(map.keySet());
        l(map.values(), bVar);
    }

    public void n(String str) throws IOException {
        try {
            d(f44591e.call(str));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void o(Collection<String> collection) throws IOException {
        l(collection, f44591e);
    }

    public void p(Map<String, String> map) throws IOException {
        m(map, f44591e);
    }
}
