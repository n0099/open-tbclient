package d.p.a.c;

import com.baidu.mapsdkplatform.comapi.map.r;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes6.dex */
public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    public final RandomAccessFile f67587a;

    public a(File file) throws FileNotFoundException {
        this.f67587a = new RandomAccessFile(file, r.f7699a);
    }

    @Override // d.p.a.c.b
    public long a() throws IOException {
        return this.f67587a.length();
    }

    @Override // d.p.a.c.b
    public void b() throws IOException {
        this.f67587a.close();
    }

    @Override // d.p.a.c.b
    public int a(byte[] bArr, int i, int i2) throws IOException {
        return this.f67587a.read(bArr, i, i2);
    }

    @Override // d.p.a.c.b
    public void a(long j, long j2) throws IOException {
        this.f67587a.seek(j);
    }
}
