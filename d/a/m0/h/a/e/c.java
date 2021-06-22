package d.a.m0.h.a.e;

import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import d.a.m0.a.k;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public a f50888a;
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
        void i(String str);
    }

    public c(@NonNull d.a.m0.a.y.b.a aVar) {
        a(aVar);
    }

    public final void a(@NonNull d.a.m0.a.y.b.a aVar) {
        this.left = aVar.s(CustomDialogData.POS_LEFT, this.left);
        this.top = aVar.s("top", this.top);
        this.width = aVar.s("width", this.width);
        this.height = aVar.s("height", this.height);
    }

    public void b(a aVar) {
        this.f50888a = aVar;
    }

    @JavascriptInterface
    public void onFieldChangedCallback(String str) {
        if (k.f46983a) {
            Log.d("BannerAdStyle", "onFieldChangedCallback fieldName=" + str);
        }
        a aVar = this.f50888a;
        if (aVar != null) {
            aVar.i(str);
        }
    }
}
