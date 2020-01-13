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
/* loaded from: classes4.dex */
public final class CountingRequestBody extends RequestBody {
    private final RequestBody body;
    private final ProgressHandler nmA;
    private final long nmB;
    private final CancellationHandler nmC;

    public CountingRequestBody(RequestBody requestBody, ProgressHandler progressHandler, long j, CancellationHandler cancellationHandler) {
        this.body = requestBody;
        this.nmA = progressHandler;
        this.nmB = j;
        this.nmC = cancellationHandler;
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

    /* loaded from: classes4.dex */
    protected final class CountingSink extends ForwardingSink {
        private int nmD;

        public CountingSink(Sink sink) {
            super(sink);
            this.nmD = 0;
        }

        @Override // okio.ForwardingSink, okio.Sink
        public void write(Buffer buffer, long j) throws IOException {
            if (CountingRequestBody.this.nmC != null || CountingRequestBody.this.nmA != null) {
                if (CountingRequestBody.this.nmC != null && CountingRequestBody.this.nmC.isCancelled()) {
                    throw new CancellationHandler.CancellationException();
                }
                super.write(buffer, j);
                this.nmD = (int) (this.nmD + j);
                if (CountingRequestBody.this.nmA != null) {
                    AsyncRun.B(new Runnable() { // from class: com.qiniu.android.http.CountingRequestBody.CountingSink.1
                        @Override // java.lang.Runnable
                        public void run() {
                            CountingRequestBody.this.nmA.onProgress(CountingSink.this.nmD, CountingRequestBody.this.nmB);
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
