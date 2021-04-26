package d.a.h0.a.g1;

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
    public final File f42547a;

    /* renamed from: b  reason: collision with root package name */
    public final d.a.h0.a.g1.n.a f42548b;

    /* renamed from: c  reason: collision with root package name */
    public final String f42549c;

    public c(File file, String str, d.a.h0.a.g1.n.a aVar) {
        this.f42547a = file;
        this.f42549c = str;
        this.f42548b = aVar;
    }

    @Override // okhttp3.RequestBody
    public long contentLength() {
        return this.f42547a.length();
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        return MediaType.parse(this.f42549c);
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink bufferedSink) throws IOException {
        Source source = null;
        try {
            source = Okio.source(this.f42547a);
            long j = 0;
            while (true) {
                long read = source.read(bufferedSink.buffer(), 2048L);
                if (read == -1) {
                    return;
                }
                j += read;
                bufferedSink.flush();
                this.f42548b.a(j);
            }
        } finally {
            d.a.h0.p.d.a(source);
        }
    }
}
