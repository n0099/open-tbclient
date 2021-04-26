package d.o.a.c;

import com.baidu.mapsdkplatform.comapi.map.r;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes6.dex */
public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    public final RandomAccessFile f65930a;

    public a(File file) throws FileNotFoundException {
        this.f65930a = new RandomAccessFile(file, r.f7975a);
    }

    @Override // d.o.a.c.b
    public long a() throws IOException {
        return this.f65930a.length();
    }

    @Override // d.o.a.c.b
    public void b() throws IOException {
        this.f65930a.close();
    }

    @Override // d.o.a.c.b
    public int a(byte[] bArr, int i2, int i3) throws IOException {
        return this.f65930a.read(bArr, i2, i3);
    }

    @Override // d.o.a.c.b
    public void a(long j, long j2) throws IOException {
        this.f65930a.seek(j);
    }
}
