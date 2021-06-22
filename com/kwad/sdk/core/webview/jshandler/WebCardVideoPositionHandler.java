package com.kwad.sdk.core.webview.jshandler;

import androidx.annotation.NonNull;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class WebCardVideoPositionHandler implements com.kwad.sdk.core.webview.a.a {

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.core.webview.a f35047a;

    /* renamed from: b  reason: collision with root package name */
    public VideoPosition f35048b = new VideoPosition();

    /* renamed from: c  reason: collision with root package name */
    public a f35049c;

    /* loaded from: classes7.dex */
    public static final class VideoPosition extends com.kwad.sdk.core.response.a.a implements Serializable {
        public static final long serialVersionUID = -3445790097441569428L;
        public double heightWidthRation;
        public double leftMarginRation;
        public double topMarginRation;
        public double widthRation;
    }

    /* loaded from: classes7.dex */
    public interface a {
        void a(VideoPosition videoPosition);
    }

    public WebCardVideoPositionHandler(com.kwad.sdk.core.webview.a aVar, a aVar2) {
        this.f35047a = aVar;
        this.f35049c = aVar2;
    }

    @Override // com.kwad.sdk.core.webview.a.a
    @NonNull
    public String a() {
        return "videoPosition";
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.a.c cVar) {
        try {
            this.f35048b.parseJson(new JSONObject(str));
            if (this.f35049c != null) {
                this.f35049c.a(this.f35048b);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        cVar.a(null);
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void b() {
    }
}
