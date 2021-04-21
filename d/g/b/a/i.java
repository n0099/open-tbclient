package d.g.b.a;

import com.android.internal.http.multipart.Part;
import java.util.ArrayList;
import java.util.LinkedHashMap;
/* loaded from: classes6.dex */
public class i extends a {

    /* renamed from: f  reason: collision with root package name */
    public static final LinkedHashMap<Long, String> f67022f = new LinkedHashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public int f67023d;

    /* renamed from: e  reason: collision with root package name */
    public Thread f67024e;

    public i(Thread thread, long j) {
        this(thread, 100, j);
    }

    @Override // d.g.b.a.a
    public void b() {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : this.f67024e.getStackTrace()) {
            sb.append(stackTraceElement.toString());
            sb.append(Part.CRLF);
        }
        synchronized (f67022f) {
            if (f67022f.size() == this.f67023d && this.f67023d > 0) {
                f67022f.remove(f67022f.keySet().iterator().next());
            }
            f67022f.put(Long.valueOf(System.currentTimeMillis()), sb.toString());
        }
    }

    public ArrayList<String> e(long j, long j2) {
        ArrayList<String> arrayList = new ArrayList<>();
        synchronized (f67022f) {
            for (Long l : f67022f.keySet()) {
                if (j < l.longValue() && l.longValue() < j2) {
                    arrayList.add(d.g.b.a.j.a.x.format(l) + Part.CRLF + Part.CRLF + f67022f.get(l));
                }
            }
        }
        return arrayList;
    }

    public i(Thread thread, int i, long j) {
        super(j);
        this.f67023d = 100;
        this.f67024e = thread;
        this.f67023d = i;
    }
}
