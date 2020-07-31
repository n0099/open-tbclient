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
/* loaded from: classes6.dex */
public final class CountingRequestBody extends RequestBody {
    private final RequestBody body;
    private final ProgressHandler nLJ;
    private final long nLK;
    private final CancellationHandler nLL;

    public CountingRequestBody(RequestBody requestBody, ProgressHandler progressHandler, long j, CancellationHandler cancellationHandler) {
        this.body = requestBody;
        this.nLJ = progressHandler;
        this.nLK = j;
        this.nLL = cancellationHandler;
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

    /* loaded from: classes6.dex */
    protected final class CountingSink extends ForwardingSink {
        private int nLM;

        public CountingSink(Sink sink) {
            super(sink);
            this.nLM = 0;
        }

        @Override // okio.ForwardingSink, okio.Sink
        public void write(Buffer buffer, long j) throws IOException {
            if (CountingRequestBody.this.nLL != null || CountingRequestBody.this.nLJ != null) {
                if (CountingRequestBody.this.nLL != null && CountingRequestBody.this.nLL.isCancelled()) {
                    throw new CancellationHandler.CancellationException();
                }
                super.write(buffer, j);
                this.nLM = (int) (this.nLM + j);
                if (CountingRequestBody.this.nLJ != null) {
                    AsyncRun.H(new Runnable() { // from class: com.qiniu.android.http.CountingRequestBody.CountingSink.1
                        @Override // java.lang.Runnable
                        public void run() {
                            CountingRequestBody.this.nLJ.onProgress(CountingSink.this.nLM, CountingRequestBody.this.nLK);
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
