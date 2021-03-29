package d.b.g0.a.g1;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;
/* loaded from: classes2.dex */
public class h extends ResponseBody {

    /* renamed from: e  reason: collision with root package name */
    public final ResponseBody f44519e;

    /* renamed from: f  reason: collision with root package name */
    public final e f44520f;

    /* renamed from: g  reason: collision with root package name */
    public BufferedSource f44521g;

    /* loaded from: classes2.dex */
    public class a extends ForwardingSource {

        /* renamed from: e  reason: collision with root package name */
        public long f44522e;

        public a(Source source) {
            super(source);
            this.f44522e = 0L;
        }

        @Override // okio.ForwardingSource, okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            long read = super.read(buffer, j);
            int i = (read > (-1L) ? 1 : (read == (-1L) ? 0 : -1));
            this.f44522e += i != 0 ? read : 0L;
            h.this.f44520f.a(this.f44522e, h.this.f44519e.contentLength(), i == 0);
            return read;
        }
    }

    public h(ResponseBody responseBody, e eVar) {
        this.f44519e = responseBody;
        this.f44520f = eVar;
    }

    @Override // okhttp3.ResponseBody
    public long contentLength() {
        return this.f44519e.contentLength();
    }

    @Override // okhttp3.ResponseBody
    public MediaType contentType() {
        return this.f44519e.contentType();
    }

    public final Source e(Source source) {
        return new a(source);
    }

    @Override // okhttp3.ResponseBody
    public BufferedSource source() {
        if (this.f44521g == null) {
            this.f44521g = Okio.buffer(e(this.f44519e.source()));
        }
        return this.f44521g;
    }
}
