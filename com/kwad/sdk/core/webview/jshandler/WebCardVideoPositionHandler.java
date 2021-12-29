package com.kwad.sdk.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class WebCardVideoPositionHandler implements com.kwad.sdk.core.webview.kwai.a {

    /* renamed from: b  reason: collision with root package name */
    public a f58550b;
    public VideoPosition a = new VideoPosition();

    /* renamed from: c  reason: collision with root package name */
    public Handler f58551c = new Handler(Looper.getMainLooper());

    /* loaded from: classes3.dex */
    public static final class VideoPosition extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public static final long serialVersionUID = -3445790097441569428L;
        public int borderRadius;
        public int height;
        public double heightWidthRation;
        public int leftMargin;
        public double leftMarginRation;
        public int topMargin;
        public double topMarginRation;
        public int width;
        public double widthRation;
    }

    /* loaded from: classes3.dex */
    public interface a {
        void a(VideoPosition videoPosition);
    }

    public WebCardVideoPositionHandler(a aVar) {
        this.f58550b = aVar;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public String a() {
        return "videoPosition";
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        try {
            this.a.parseJson(new JSONObject(str));
            if (this.f58550b != null) {
                this.f58551c.post(new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.WebCardVideoPositionHandler.1
                    @Override // java.lang.Runnable
                    public void run() {
                        WebCardVideoPositionHandler.this.f58550b.a(WebCardVideoPositionHandler.this.a);
                    }
                });
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        cVar.a(null);
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void b() {
        this.f58551c.removeCallbacksAndMessages(null);
    }
}
