package d.b.h0.e.a.r;

import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public a f48439a;
    @V8JavascriptField
    public int height;
    @V8JavascriptField
    public int left;
    @V8JavascriptField
    public int realHeight;
    @V8JavascriptField
    public int realWidth;
    @V8JavascriptField
    public int top;
    @V8JavascriptField
    public int width;

    /* loaded from: classes3.dex */
    public interface a {
        void v(String str);
    }

    public f(@NonNull d.b.h0.g.e.d.c cVar) {
        a(cVar);
    }

    public final void a(@NonNull d.b.h0.g.e.d.c cVar) {
        this.left = cVar.s(CustomDialogData.POS_LEFT, this.left);
        this.top = cVar.s("top", this.top);
        this.width = cVar.s("width", this.width);
        this.height = cVar.s("height", this.height);
    }

    public void b(a aVar) {
        this.f48439a = aVar;
    }

    @JavascriptInterface
    public void onFieldChangedCallback(String str) {
        if (d.b.h0.a.k.f45772a) {
            Log.d("BannerAdStyle", "onFieldChangedCallback fieldName=" + str);
        }
        a aVar = this.f48439a;
        if (aVar != null) {
            aVar.v(str);
        }
    }
}
