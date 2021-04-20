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
    public final ResponseBody f44911e;

    /* renamed from: f  reason: collision with root package name */
    public final e f44912f;

    /* renamed from: g  reason: collision with root package name */
    public BufferedSource f44913g;

    /* loaded from: classes2.dex */
    public class a extends ForwardingSource {

        /* renamed from: e  reason: collision with root package name */
        public long f44914e;

        public a(Source source) {
            super(source);
            this.f44914e = 0L;
        }

        @Override // okio.ForwardingSource, okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            long read = super.read(buffer, j);
            int i = (read > (-1L) ? 1 : (read == (-1L) ? 0 : -1));
            this.f44914e += i != 0 ? read : 0L;
            h.this.f44912f.a(this.f44914e, h.this.f44911e.contentLength(), i == 0);
            return read;
        }
    }

    public h(ResponseBody responseBody, e eVar) {
        this.f44911e = responseBody;
        this.f44912f = eVar;
    }

    @Override // okhttp3.ResponseBody
    public long contentLength() {
        return this.f44911e.contentLength();
    }

    @Override // okhttp3.ResponseBody
    public MediaType contentType() {
        return this.f44911e.contentType();
    }

    public final Source e(Source source) {
        return new a(source);
    }

    @Override // okhttp3.ResponseBody
    public BufferedSource source() {
        if (this.f44913g == null) {
            this.f44913g = Okio.buffer(e(this.f44911e.source()));
        }
        return this.f44913g;
    }
}
