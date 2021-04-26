package d.f.b.a;

import com.android.internal.http.multipart.Part;
import java.util.ArrayList;
import java.util.LinkedHashMap;
/* loaded from: classes6.dex */
public class i extends a {

    /* renamed from: f  reason: collision with root package name */
    public static final LinkedHashMap<Long, String> f65436f = new LinkedHashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public int f65437d;

    /* renamed from: e  reason: collision with root package name */
    public Thread f65438e;

    public i(Thread thread, long j) {
        this(thread, 100, j);
    }

    @Override // d.f.b.a.a
    public void b() {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : this.f65438e.getStackTrace()) {
            sb.append(stackTraceElement.toString());
            sb.append(Part.CRLF);
        }
        synchronized (f65436f) {
            if (f65436f.size() == this.f65437d && this.f65437d > 0) {
                f65436f.remove(f65436f.keySet().iterator().next());
            }
            f65436f.put(Long.valueOf(System.currentTimeMillis()), sb.toString());
        }
    }

    public ArrayList<String> e(long j, long j2) {
        ArrayList<String> arrayList = new ArrayList<>();
        synchronized (f65436f) {
            for (Long l : f65436f.keySet()) {
                if (j < l.longValue() && l.longValue() < j2) {
                    arrayList.add(d.f.b.a.j.a.x.format(l) + Part.CRLF + Part.CRLF + f65436f.get(l));
                }
            }
        }
        return arrayList;
    }

    public i(Thread thread, int i2, long j) {
        super(j);
        this.f65437d = 100;
        this.f65438e = thread;
        this.f65437d = i2;
    }
}
