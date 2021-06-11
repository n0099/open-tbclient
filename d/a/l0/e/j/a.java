package d.a.l0.e.j;

import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import d.a.l0.a.h0.o.h.f.d;
import java.util.Map;
/* loaded from: classes3.dex */
public final class a implements RequestListener {

    /* renamed from: a  reason: collision with root package name */
    public d f50212a;

    public a(d dVar) {
        this.f50212a = dVar;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public void onProducerEvent(String str, String str2, String str3) {
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public void onProducerFinishWithCancellation(String str, String str2, Map<String, String> map) {
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public void onProducerFinishWithFailure(String str, String str2, Throwable th, Map<String, String> map) {
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public void onProducerFinishWithSuccess(String str, String str2, Map<String, String> map) {
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public void onProducerStart(String str, String str2) {
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener
    public void onRequestCancellation(String str) {
        d dVar = this.f50212a;
        if (dVar != null) {
            dVar.onCancel(str);
        }
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener
    public void onRequestFailure(ImageRequest imageRequest, String str, Throwable th, boolean z) {
        d dVar = this.f50212a;
        if (dVar != null) {
            dVar.c(imageRequest, th);
        }
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener
    public void onRequestStart(ImageRequest imageRequest, Object obj, String str, boolean z) {
        d dVar = this.f50212a;
        if (dVar != null) {
            dVar.a(imageRequest);
        }
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener
    public void onRequestSuccess(ImageRequest imageRequest, String str, boolean z) {
        d dVar = this.f50212a;
        if (dVar != null) {
            dVar.b(imageRequest);
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public boolean requiresExtraMap(String str) {
        return false;
    }
}
