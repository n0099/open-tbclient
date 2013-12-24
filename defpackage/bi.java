package defpackage;

import com.baidu.cloudsdk.common.http.BinaryHttpResponseHandler;
import com.baidu.cloudsdk.common.http.HttpResponseHandler;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.protocol.HttpContext;
/* renamed from: bi  reason: default package */
/* loaded from: classes.dex */
public class bi implements Runnable {
    private AbstractHttpClient a;
    private HttpContext b;
    private HttpUriRequest c;
    private HttpResponseHandler d;
    private boolean e;

    public bi(AbstractHttpClient abstractHttpClient, HttpContext httpContext, HttpUriRequest httpUriRequest, HttpResponseHandler httpResponseHandler) {
        this.a = abstractHttpClient;
        this.b = httpContext;
        this.c = httpUriRequest;
        this.d = httpResponseHandler;
        if (httpResponseHandler instanceof BinaryHttpResponseHandler) {
            this.e = true;
        } else {
            this.e = false;
        }
    }

    private void a() {
        if (Thread.currentThread().isInterrupted()) {
            return;
        }
        HttpResponse execute = this.a.execute(this.c, this.b);
        if (Thread.currentThread().isInterrupted()) {
            throw new InterruptedException("the request has been cancelled");
        }
        if (this.d != null) {
            this.d.sendResponseMessage(execute);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.d != null) {
                this.d.sendStartMessage();
            }
            a();
            if (this.d != null) {
                this.d.sendFinishMessage();
            }
        } catch (InterruptedException e) {
        } catch (Exception e2) {
            if (this.d != null) {
                this.d.sendFinishMessage();
                if (this.e) {
                    this.d.sendFailureMessage(e2, (byte[]) null);
                } else {
                    this.d.sendFailureMessage(e2, (String) null);
                }
            }
        }
    }
}
