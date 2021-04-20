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
    public final File f44905a;

    /* renamed from: b  reason: collision with root package name */
    public final d.b.g0.a.g1.n.a f44906b;

    /* renamed from: c  reason: collision with root package name */
    public final String f44907c;

    public c(File file, String str, d.b.g0.a.g1.n.a aVar) {
        this.f44905a = file;
        this.f44907c = str;
        this.f44906b = aVar;
    }

    @Override // okhttp3.RequestBody
    public long contentLength() {
        return this.f44905a.length();
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        return MediaType.parse(this.f44907c);
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink bufferedSink) throws IOException {
        Source source = null;
        try {
            source = Okio.source(this.f44905a);
            long j = 0;
            while (true) {
                long read = source.read(bufferedSink.buffer(), 2048L);
                if (read == -1) {
                    return;
                }
                j += read;
                bufferedSink.flush();
                this.f44906b.a(j);
            }
        } finally {
            d.b.g0.p.d.a(source);
        }
    }
}
