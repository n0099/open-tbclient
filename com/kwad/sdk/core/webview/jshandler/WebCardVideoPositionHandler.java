package com.kwad.sdk.core.webview.jshandler;

import androidx.annotation.NonNull;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class WebCardVideoPositionHandler implements com.kwad.sdk.core.webview.a.a {

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.core.webview.a f34306a;

    /* renamed from: b  reason: collision with root package name */
    public VideoPosition f34307b = new VideoPosition();

    /* renamed from: c  reason: collision with root package name */
    public a f34308c;

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
        this.f34306a = aVar;
        this.f34308c = aVar2;
    }

    @Override // com.kwad.sdk.core.webview.a.a
    @NonNull
    public String a() {
        return "videoPosition";
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.a.c cVar) {
        try {
            this.f34307b.parseJson(new JSONObject(str));
            if (this.f34308c != null) {
                this.f34308c.a(this.f34307b);
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
