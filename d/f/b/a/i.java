package d.f.b.a;

import com.android.internal.http.multipart.Part;
import java.util.ArrayList;
import java.util.LinkedHashMap;
/* loaded from: classes6.dex */
public class i extends a {

    /* renamed from: f  reason: collision with root package name */
    public static final LinkedHashMap<Long, String> f69896f = new LinkedHashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public int f69897d;

    /* renamed from: e  reason: collision with root package name */
    public Thread f69898e;

    public i(Thread thread, long j) {
        this(thread, 100, j);
    }

    @Override // d.f.b.a.a
    public void b() {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : this.f69898e.getStackTrace()) {
            sb.append(stackTraceElement.toString());
            sb.append(Part.CRLF);
        }
        synchronized (f69896f) {
            if (f69896f.size() == this.f69897d && this.f69897d > 0) {
                f69896f.remove(f69896f.keySet().iterator().next());
            }
            f69896f.put(Long.valueOf(System.currentTimeMillis()), sb.toString());
        }
    }

    public ArrayList<String> e(long j, long j2) {
        ArrayList<String> arrayList = new ArrayList<>();
        synchronized (f69896f) {
            for (Long l : f69896f.keySet()) {
                if (j < l.longValue() && l.longValue() < j2) {
                    arrayList.add(d.f.b.a.j.a.x.format(l) + Part.CRLF + Part.CRLF + f69896f.get(l));
                }
            }
        }
        return arrayList;
    }

    public i(Thread thread, int i2, long j) {
        super(j);
        this.f69897d = 100;
        this.f69898e = thread;
        this.f69897d = i2;
    }
}
