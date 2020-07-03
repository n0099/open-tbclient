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
    private final ProgressHandler nCY;
    private final long nCZ;
    private final CancellationHandler nDa;

    public CountingRequestBody(RequestBody requestBody, ProgressHandler progressHandler, long j, CancellationHandler cancellationHandler) {
        this.body = requestBody;
        this.nCY = progressHandler;
        this.nCZ = j;
        this.nDa = cancellationHandler;
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
        private int nDb;

        public CountingSink(Sink sink) {
            super(sink);
            this.nDb = 0;
        }

        @Override // okio.ForwardingSink, okio.Sink
        public void write(Buffer buffer, long j) throws IOException {
            if (CountingRequestBody.this.nDa != null || CountingRequestBody.this.nCY != null) {
                if (CountingRequestBody.this.nDa != null && CountingRequestBody.this.nDa.isCancelled()) {
                    throw new CancellationHandler.CancellationException();
                }
                super.write(buffer, j);
                this.nDb = (int) (this.nDb + j);
                if (CountingRequestBody.this.nCY != null) {
                    AsyncRun.I(new Runnable() { // from class: com.qiniu.android.http.CountingRequestBody.CountingSink.1
                        @Override // java.lang.Runnable
                        public void run() {
                            CountingRequestBody.this.nCY.onProgress(CountingSink.this.nDb, CountingRequestBody.this.nCZ);
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
