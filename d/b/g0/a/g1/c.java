package d.b.g0.a.g1;

import java.io.File;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;
import okio.Okio;
import okio.Source;
/* loaded from: classes2.dex */
public class c extends RequestBody {

    /* renamed from: a  reason: collision with root package name */
    public final File f44513a;

    /* renamed from: b  reason: collision with root package name */
    public final d.b.g0.a.g1.n.a f44514b;

    /* renamed from: c  reason: collision with root package name */
    public final String f44515c;

    public c(File file, String str, d.b.g0.a.g1.n.a aVar) {
        this.f44513a = file;
        this.f44515c = str;
        this.f44514b = aVar;
    }

    @Override // okhttp3.RequestBody
    public long contentLength() {
        return this.f44513a.length();
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        return MediaType.parse(this.f44515c);
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink bufferedSink) throws IOException {
        Source source = null;
        try {
            source = Okio.source(this.f44513a);
            long j = 0;
            while (true) {
                long read = source.read(bufferedSink.buffer(), 2048L);
                if (read == -1) {
                    return;
                }
                j += read;
                bufferedSink.flush();
                this.f44514b.a(j);
            }
        } finally {
            d.b.g0.p.d.a(source);
        }
    }
}
