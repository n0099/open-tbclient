package d.b.i0.d3.o0.d.f;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.mapsdkplatform.comapi.map.r;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class c extends a {

    /* renamed from: g  reason: collision with root package name */
    public boolean f55011g;

    public c(String str, int i, int i2, long j, String str2) {
        super(str, i, i2, j, str2);
    }

    @Override // d.b.i0.d3.o0.d.f.a
    public void a() {
        this.f55011g = true;
    }

    @Override // d.b.i0.d3.o0.d.f.a
    public boolean c() {
        return this.f55011g;
    }

    @Override // d.b.i0.d3.o0.d.f.a
    public d g(ArrayList<Integer> arrayList, String str, int i) {
        d dVar = new d();
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.f54999b), r.f7699a);
            int i2 = 0;
            int size = arrayList.size();
            Iterator<Integer> it = arrayList.iterator();
            while (it.hasNext()) {
                int i3 = i2 + 1;
                d h2 = h(randomAccessFile, it.next().intValue(), i, str);
                if (h2 == null) {
                    return null;
                }
                d((int) (((i3 * 50.0f) / size) + 30.0f));
                if (!StringUtils.isNull(h2.f55012a) || h2.f55013b != 0) {
                    return h2;
                }
                i2 = i3;
                dVar = h2;
            }
        } catch (FileNotFoundException unused) {
        }
        return dVar;
    }
}
