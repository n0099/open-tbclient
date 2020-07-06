package com.qiniu.android.http;

import com.qiniu.android.http.CancellationHandler;
import com.qiniu.android.utils.AsyncRun;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingSink;
import okio.Okio;
import okio.Sink;
/* loaded from: classes5.dex */
public final class CountingRequestBody extends RequestBody {
    private final RequestBody body;
    private final ProgressHandler nDb;
    private final long nDc;
    private final CancellationHandler nDd;

    public CountingRequestBody(RequestBody requestBody, ProgressHandler progressHandler, long j, CancellationHandler cancellationHandler) {
        this.body = requestBody;
        this.nDb = progressHandler;
        this.nDc = j;
        this.nDd = cancellationHandler;
    }

    @Override // okhttp3.RequestBody
    public long contentLength() throws IOException {
        return this.body.contentLength();
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        return this.body.contentType();
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink bufferedSink) throws IOException {
        BufferedSink buffer = Okio.buffer(new CountingSink(bufferedSink));
        this.body.writeTo(buffer);
        buffer.flush();
    }

    /* loaded from: classes5.dex */
    protected final class CountingSink extends ForwardingSink {
        private int nDe;

        public CountingSink(Sink sink) {
            super(sink);
            this.nDe = 0;
        }

        @Override // okio.ForwardingSink, okio.Sink
        public void write(Buffer buffer, long j) throws IOException {
            if (CountingRequestBody.this.nDd != null || CountingRequestBody.this.nDb != null) {
                if (CountingRequestBody.this.nDd != null && CountingRequestBody.this.nDd.isCancelled()) {
                    throw new CancellationHandler.CancellationException();
                }
                super.write(buffer, j);
                this.nDe = (int) (this.nDe + j);
                if (CountingRequestBody.this.nDb != null) {
                    AsyncRun.I(new Runnable() { // from class: com.qiniu.android.http.CountingRequestBody.CountingSink.1
                        @Override // java.lang.Runnable
                        public void run() {
                            CountingRequestBody.this.nDb.onProgress(CountingSink.this.nDe, CountingRequestBody.this.nDc);
                        }
                    });
                    return;
                }
                return;
            }
            super.write(buffer, j);
        }
    }
}
