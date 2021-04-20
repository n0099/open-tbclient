package d.f.b.a;

import com.android.internal.http.multipart.Part;
import java.util.ArrayList;
import java.util.LinkedHashMap;
/* loaded from: classes6.dex */
public class i extends a {

    /* renamed from: f  reason: collision with root package name */
    public static final LinkedHashMap<Long, String> f66875f = new LinkedHashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public int f66876d;

    /* renamed from: e  reason: collision with root package name */
    public Thread f66877e;

    public i(Thread thread, long j) {
        this(thread, 100, j);
    }

    @Override // d.f.b.a.a
    public void b() {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : this.f66877e.getStackTrace()) {
            sb.append(stackTraceElement.toString());
            sb.append(Part.CRLF);
        }
        synchronized (f66875f) {
            if (f66875f.size() == this.f66876d && this.f66876d > 0) {
                f66875f.remove(f66875f.keySet().iterator().next());
            }
            f66875f.put(Long.valueOf(System.currentTimeMillis()), sb.toString());
        }
    }

    public ArrayList<String> e(long j, long j2) {
        ArrayList<String> arrayList = new ArrayList<>();
        synchronized (f66875f) {
            for (Long l : f66875f.keySet()) {
                if (j < l.longValue() && l.longValue() < j2) {
                    arrayList.add(d.f.b.a.j.a.x.format(l) + Part.CRLF + Part.CRLF + f66875f.get(l));
                }
            }
        }
        return arrayList;
    }

    public i(Thread thread, int i, long j) {
        super(j);
        this.f66876d = 100;
        this.f66877e = thread;
        this.f66876d = i;
    }
}
