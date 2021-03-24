package d.o.a.c;

import com.baidu.mapsdkplatform.comapi.map.r;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes4.dex */
public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    public final RandomAccessFile f66446a;

    public a(File file) throws FileNotFoundException {
        this.f66446a = new RandomAccessFile(file, r.f7663a);
    }

    @Override // d.o.a.c.b
    public long a() throws IOException {
        return this.f66446a.length();
    }

    @Override // d.o.a.c.b
    public void b() throws IOException {
        this.f66446a.close();
    }

    @Override // d.o.a.c.b
    public int a(byte[] bArr, int i, int i2) throws IOException {
        return this.f66446a.read(bArr, i, i2);
    }

    @Override // d.o.a.c.b
    public void a(long j, long j2) throws IOException {
        this.f66446a.seek(j);
    }
}
