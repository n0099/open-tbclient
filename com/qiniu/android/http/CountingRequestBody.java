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
    private final ProgressHandler opG;
    private final long opH;
    private final CancellationHandler opI;

    public CountingRequestBody(RequestBody requestBody, ProgressHandler progressHandler, long j, CancellationHandler cancellationHandler) {
        this.body = requestBody;
        this.opG = progressHandler;
        this.opH = j;
        this.opI = cancellationHandler;
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
        private int opJ;

        public CountingSink(Sink sink) {
            super(sink);
            this.opJ = 0;
        }

        @Override // okio.ForwardingSink, okio.Sink
        public void write(Buffer buffer, long j) throws IOException {
            if (CountingRequestBody.this.opI != null || CountingRequestBody.this.opG != null) {
                if (CountingRequestBody.this.opI != null && CountingRequestBody.this.opI.isCancelled()) {
                    throw new CancellationHandler.CancellationException();
                }
                super.write(buffer, j);
                this.opJ = (int) (this.opJ + j);
                if (CountingRequestBody.this.opG != null) {
                    AsyncRun.E(new Runnable() { // from class: com.qiniu.android.http.CountingRequestBody.CountingSink.1
                        @Override // java.lang.Runnable
                        public void run() {
                            CountingRequestBody.this.opG.onProgress(CountingSink.this.opJ, CountingRequestBody.this.opH);
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
