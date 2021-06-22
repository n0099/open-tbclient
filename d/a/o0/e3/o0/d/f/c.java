package d.a.o0.e3.o0.d.f;

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
    public boolean f58010g;

    public c(String str, int i2, int i3, long j, String str2) {
        super(str, i2, i3, j, str2);
    }

    @Override // d.a.o0.e3.o0.d.f.a
    public void a() {
        this.f58010g = true;
    }

    @Override // d.a.o0.e3.o0.d.f.a
    public boolean c() {
        return this.f58010g;
    }

    @Override // d.a.o0.e3.o0.d.f.a
    public d g(ArrayList<Integer> arrayList, String str, int i2) {
        d dVar = new d();
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.f57996b), r.f7715a);
            int i3 = 0;
            int size = arrayList.size();
            Iterator<Integer> it = arrayList.iterator();
            while (it.hasNext()) {
                int i4 = i3 + 1;
                d h2 = h(randomAccessFile, it.next().intValue(), i2, str);
                if (h2 == null) {
                    return null;
                }
                d((int) (((i4 * 50.0f) / size) + 30.0f));
                if (!StringUtils.isNull(h2.f58011a) || h2.f58012b != 0) {
                    return h2;
                }
                i3 = i4;
                dVar = h2;
            }
        } catch (FileNotFoundException unused) {
        }
        return dVar;
    }
}
