package d.a.h0.a.g1;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;
/* loaded from: classes3.dex */
public class h extends ResponseBody {

    /* renamed from: e  reason: collision with root package name */
    public final ResponseBody f42553e;

    /* renamed from: f  reason: collision with root package name */
    public final e f42554f;

    /* renamed from: g  reason: collision with root package name */
    public BufferedSource f42555g;

    /* loaded from: classes3.dex */
    public class a extends ForwardingSource {

        /* renamed from: e  reason: collision with root package name */
        public long f42556e;

        public a(Source source) {
            super(source);
            this.f42556e = 0L;
        }

        @Override // okio.ForwardingSource, okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            long read = super.read(buffer, j);
            int i2 = (read > (-1L) ? 1 : (read == (-1L) ? 0 : -1));
            this.f42556e += i2 != 0 ? read : 0L;
            h.this.f42554f.a(this.f42556e, h.this.f42553e.contentLength(), i2 == 0);
            return read;
        }
    }

    public h(ResponseBody responseBody, e eVar) {
        this.f42553e = responseBody;
        this.f42554f = eVar;
    }

    @Override // okhttp3.ResponseBody
    public long contentLength() {
        return this.f42553e.contentLength();
    }

    @Override // okhttp3.ResponseBody
    public MediaType contentType() {
        return this.f42553e.contentType();
    }

    public final Source e(Source source) {
        return new a(source);
    }

    @Override // okhttp3.ResponseBody
    public BufferedSource source() {
        if (this.f42555g == null) {
            this.f42555g = Okio.buffer(e(this.f42553e.source()));
        }
        return this.f42555g;
    }
}
