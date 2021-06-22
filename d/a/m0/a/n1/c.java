package d.a.m0.a.n1;

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
    public final File f47472a;

    /* renamed from: b  reason: collision with root package name */
    public final d.a.m0.a.n1.p.a f47473b;

    /* renamed from: c  reason: collision with root package name */
    public final String f47474c;

    public c(File file, String str, d.a.m0.a.n1.p.a aVar) {
        this.f47472a = file;
        this.f47474c = str;
        this.f47473b = aVar;
    }

    @Override // okhttp3.RequestBody
    public long contentLength() {
        return this.f47472a.length();
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        return MediaType.parse(this.f47474c);
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink bufferedSink) throws IOException {
        Source source = null;
        try {
            source = Okio.source(this.f47472a);
            long j = 0;
            while (true) {
                long read = source.read(bufferedSink.buffer(), 2048L);
                if (read == -1) {
                    return;
                }
                j += read;
                bufferedSink.flush();
                this.f47473b.a(j);
            }
        } finally {
            d.a.m0.t.d.d(source);
        }
    }
}
