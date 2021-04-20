package d.b.g0.g.k0.f.a;

import android.graphics.Color;
import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import d.b.g0.a.k;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public InterfaceC0983a f48637a;
    @V8JavascriptField
    public String backgroundColor;
    @V8JavascriptField
    public String borderColor;
    @V8JavascriptField
    public double borderRadius;
    @V8JavascriptField
    public int borderWidth;
    @V8JavascriptField
    public String color;
    @V8JavascriptField
    public String fontWeight;
    @V8JavascriptField
    public int height;
    @V8JavascriptField
    public boolean hidden;
    @V8JavascriptField
    public int left;
    @V8JavascriptField
    public int lineHeight;
    @V8JavascriptField
    public String textAlign;
    @V8JavascriptField
    public int top;
    @V8JavascriptField
    public int width;
    @V8JavascriptField
    public double fontSize = 16.0d;
    @V8JavascriptField
    public double opacity = 1.0d;

    /* renamed from: d.b.g0.g.k0.f.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0983a {
        void l();
    }

    public a(@NonNull d.b.g0.g.e.d.c cVar) {
        a(cVar);
    }

    public static int c(@ColorInt int i) {
        float f2 = (((-16777216) & i) >>> 24) / 255.0f;
        return f2 > 0.0f ? Color.argb(255, (int) ((((16711680 & i) >> 16) * f2) + 0.5d), (int) ((((65280 & i) >> 8) * f2) + 0.5d), (int) (((i & 255) * f2) + 0.5d)) : i;
    }

    public final void a(@NonNull d.b.g0.g.e.d.c cVar) {
        this.left = cVar.s(CustomDialogData.POS_LEFT, this.left);
        this.top = cVar.s("top", this.top);
        this.width = cVar.s("width", this.width);
        this.height = cVar.s("height", this.height);
        this.backgroundColor = cVar.C("backgroundColor", this.backgroundColor);
        this.borderColor = cVar.C("borderColor", this.borderColor);
        this.borderRadius = cVar.o("borderRadius", this.borderRadius);
        this.borderWidth = cVar.s("borderWidth", this.borderWidth);
        this.fontSize = cVar.o("fontSize", this.fontSize);
        this.lineHeight = cVar.s("lineHeight", this.lineHeight);
        this.textAlign = cVar.C("textAlign", this.textAlign);
        this.fontWeight = cVar.C("fontWeight", this.fontWeight);
        this.hidden = cVar.n("hidden", this.hidden);
        this.opacity = cVar.o("opacity", this.opacity);
        this.color = cVar.C("color", this.color);
        if (k.f45443a) {
            Log.d("ApiButtonStyle", "parseApiButtonStyle = " + toString());
        }
    }

    public void b(InterfaceC0983a interfaceC0983a) {
        this.f48637a = interfaceC0983a;
    }

    @JavascriptInterface
    public void onFieldChangedCallback(String str) {
        if (k.f45443a) {
            Log.d("ApiButtonStyle", "onFieldChangedCallback fieldName=" + str);
        }
        InterfaceC0983a interfaceC0983a = this.f48637a;
        if (interfaceC0983a != null) {
            interfaceC0983a.l();
        }
    }

    public String toString() {
        return "left:" + this.left + ";top:" + this.top + ";width:" + this.width + ";height:" + this.height + ";backgroundColor:" + this.backgroundColor + ";borderColor:" + this.borderColor + ";borderWidth:" + this.borderWidth + ";borderRadius:" + this.borderRadius + ";textAlign:" + this.textAlign + ";fontSize:" + this.fontSize + ";lineHeight:" + this.lineHeight + ";fontWeight:" + this.fontWeight + ";hidden;" + this.hidden + ";opacity:" + this.opacity + ";color:" + this.color;
    }
}
