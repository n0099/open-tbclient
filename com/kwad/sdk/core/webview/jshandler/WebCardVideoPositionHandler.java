package com.kwad.sdk.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class WebCardVideoPositionHandler implements com.kwad.sdk.core.webview.a.a {

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.core.webview.a f33643a;

    /* renamed from: c  reason: collision with root package name */
    public a f33645c;

    /* renamed from: b  reason: collision with root package name */
    public VideoPosition f33644b = new VideoPosition();

    /* renamed from: d  reason: collision with root package name */
    public Handler f33646d = new Handler(Looper.getMainLooper());

    /* loaded from: classes6.dex */
    public static final class VideoPosition extends com.kwad.sdk.core.response.a.a implements Serializable {
        public static final long serialVersionUID = -3445790097441569428L;
        public double heightWidthRation;
        public double leftMarginRation;
        public double topMarginRation;
        public double widthRation;
    }

    /* loaded from: classes6.dex */
    public interface a {
        void a(VideoPosition videoPosition);
    }

    public WebCardVideoPositionHandler(com.kwad.sdk.core.webview.a aVar, a aVar2) {
        this.f33643a = aVar;
        this.f33645c = aVar2;
    }

    @Override // com.kwad.sdk.core.webview.a.a
    @NonNull
    public String a() {
        return "videoPosition";
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.a.c cVar) {
        try {
            this.f33644b.parseJson(new JSONObject(str));
            if (this.f33645c != null) {
                this.f33646d.post(new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.WebCardVideoPositionHandler.1
                    @Override // java.lang.Runnable
                    public void run() {
                        WebCardVideoPositionHandler.this.f33645c.a(WebCardVideoPositionHandler.this.f33644b);
                    }
                });
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        cVar.a(null);
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void b() {
        this.f33646d.removeCallbacksAndMessages(null);
    }
}
