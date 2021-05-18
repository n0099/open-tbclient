package d.f.b.a;

import com.android.internal.http.multipart.Part;
import java.util.ArrayList;
import java.util.LinkedHashMap;
/* loaded from: classes6.dex */
public class i extends a {

    /* renamed from: f  reason: collision with root package name */
    public static final LinkedHashMap<Long, String> f66122f = new LinkedHashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public int f66123d;

    /* renamed from: e  reason: collision with root package name */
    public Thread f66124e;

    public i(Thread thread, long j) {
        this(thread, 100, j);
    }

    @Override // d.f.b.a.a
    public void b() {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : this.f66124e.getStackTrace()) {
            sb.append(stackTraceElement.toString());
            sb.append(Part.CRLF);
        }
        synchronized (f66122f) {
            if (f66122f.size() == this.f66123d && this.f66123d > 0) {
                f66122f.remove(f66122f.keySet().iterator().next());
            }
            f66122f.put(Long.valueOf(System.currentTimeMillis()), sb.toString());
        }
    }

    public ArrayList<String> e(long j, long j2) {
        ArrayList<String> arrayList = new ArrayList<>();
        synchronized (f66122f) {
            for (Long l : f66122f.keySet()) {
                if (j < l.longValue() && l.longValue() < j2) {
                    arrayList.add(d.f.b.a.j.a.x.format(l) + Part.CRLF + Part.CRLF + f66122f.get(l));
                }
            }
        }
        return arrayList;
    }

    public i(Thread thread, int i2, long j) {
        super(j);
        this.f66123d = 100;
        this.f66124e = thread;
        this.f66123d = i2;
    }
}
