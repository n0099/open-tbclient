package d.f.b.a;

import com.android.internal.http.multipart.Part;
import java.util.ArrayList;
import java.util.LinkedHashMap;
/* loaded from: classes6.dex */
public class i extends a {

    /* renamed from: f  reason: collision with root package name */
    public static final LinkedHashMap<Long, String> f66165f = new LinkedHashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public int f66166d;

    /* renamed from: e  reason: collision with root package name */
    public Thread f66167e;

    public i(Thread thread, long j) {
        this(thread, 100, j);
    }

    @Override // d.f.b.a.a
    public void b() {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : this.f66167e.getStackTrace()) {
            sb.append(stackTraceElement.toString());
            sb.append(Part.CRLF);
        }
        synchronized (f66165f) {
            if (f66165f.size() == this.f66166d && this.f66166d > 0) {
                f66165f.remove(f66165f.keySet().iterator().next());
            }
            f66165f.put(Long.valueOf(System.currentTimeMillis()), sb.toString());
        }
    }

    public ArrayList<String> e(long j, long j2) {
        ArrayList<String> arrayList = new ArrayList<>();
        synchronized (f66165f) {
            for (Long l : f66165f.keySet()) {
                if (j < l.longValue() && l.longValue() < j2) {
                    arrayList.add(d.f.b.a.j.a.x.format(l) + Part.CRLF + Part.CRLF + f66165f.get(l));
                }
            }
        }
        return arrayList;
    }

    public i(Thread thread, int i2, long j) {
        super(j);
        this.f66166d = 100;
        this.f66167e = thread;
        this.f66166d = i2;
    }
}
