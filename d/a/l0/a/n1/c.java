package d.a.l0.a.n1;

import java.io.File;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;
import okio.Okio;
import okio.Source;
/* loaded from: classes3.dex */
public class c extends RequestBody {

    /* renamed from: a  reason: collision with root package name */
    public final File f43688a;

    /* renamed from: b  reason: collision with root package name */
    public final d.a.l0.a.n1.p.a f43689b;

    /* renamed from: c  reason: collision with root package name */
    public final String f43690c;

    public c(File file, String str, d.a.l0.a.n1.p.a aVar) {
        this.f43688a = file;
        this.f43690c = str;
        this.f43689b = aVar;
    }

    @Override // okhttp3.RequestBody
    public long contentLength() {
        return this.f43688a.length();
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        return MediaType.parse(this.f43690c);
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink bufferedSink) throws IOException {
        Source source = null;
        try {
            source = Okio.source(this.f43688a);
            long j = 0;
            while (true) {
                long read = source.read(bufferedSink.buffer(), 2048L);
                if (read == -1) {
                    return;
                }
                j += read;
                bufferedSink.flush();
                this.f43689b.a(j);
            }
        } finally {
            d.a.l0.t.d.d(source);
        }
    }
}
