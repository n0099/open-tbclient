package d.f.b.a;

import com.android.internal.http.multipart.Part;
import java.util.ArrayList;
import java.util.LinkedHashMap;
/* loaded from: classes6.dex */
public class i extends a {

    /* renamed from: f  reason: collision with root package name */
    public static final LinkedHashMap<Long, String> f66030f = new LinkedHashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public int f66031d;

    /* renamed from: e  reason: collision with root package name */
    public Thread f66032e;

    public i(Thread thread, long j) {
        this(thread, 100, j);
    }

    @Override // d.f.b.a.a
    public void b() {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : this.f66032e.getStackTrace()) {
            sb.append(stackTraceElement.toString());
            sb.append(Part.CRLF);
        }
        synchronized (f66030f) {
            if (f66030f.size() == this.f66031d && this.f66031d > 0) {
                f66030f.remove(f66030f.keySet().iterator().next());
            }
            f66030f.put(Long.valueOf(System.currentTimeMillis()), sb.toString());
        }
    }

    public ArrayList<String> e(long j, long j2) {
        ArrayList<String> arrayList = new ArrayList<>();
        synchronized (f66030f) {
            for (Long l : f66030f.keySet()) {
                if (j < l.longValue() && l.longValue() < j2) {
                    arrayList.add(d.f.b.a.j.a.x.format(l) + Part.CRLF + Part.CRLF + f66030f.get(l));
                }
            }
        }
        return arrayList;
    }

    public i(Thread thread, int i, long j) {
        super(j);
        this.f66031d = 100;
        this.f66032e = thread;
        this.f66031d = i;
    }
}
