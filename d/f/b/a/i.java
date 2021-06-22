package d.f.b.a;

import com.android.internal.http.multipart.Part;
import java.util.ArrayList;
import java.util.LinkedHashMap;
/* loaded from: classes6.dex */
public class i extends a {

    /* renamed from: f  reason: collision with root package name */
    public static final LinkedHashMap<Long, String> f70000f = new LinkedHashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public int f70001d;

    /* renamed from: e  reason: collision with root package name */
    public Thread f70002e;

    public i(Thread thread, long j) {
        this(thread, 100, j);
    }

    @Override // d.f.b.a.a
    public void b() {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : this.f70002e.getStackTrace()) {
            sb.append(stackTraceElement.toString());
            sb.append(Part.CRLF);
        }
        synchronized (f70000f) {
            if (f70000f.size() == this.f70001d && this.f70001d > 0) {
                f70000f.remove(f70000f.keySet().iterator().next());
            }
            f70000f.put(Long.valueOf(System.currentTimeMillis()), sb.toString());
        }
    }

    public ArrayList<String> e(long j, long j2) {
        ArrayList<String> arrayList = new ArrayList<>();
        synchronized (f70000f) {
            for (Long l : f70000f.keySet()) {
                if (j < l.longValue() && l.longValue() < j2) {
                    arrayList.add(d.f.b.a.j.a.x.format(l) + Part.CRLF + Part.CRLF + f70000f.get(l));
                }
            }
        }
        return arrayList;
    }

    public i(Thread thread, int i2, long j) {
        super(j);
        this.f70001d = 100;
        this.f70002e = thread;
        this.f70001d = i2;
    }
}
