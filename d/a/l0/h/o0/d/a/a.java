package d.a.l0.h.o0.d.a;

import android.graphics.Color;
import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import d.a.l0.a.k;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public InterfaceC1094a f51221a;
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

    /* renamed from: d.a.l0.h.o0.d.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1094a {
        void s();
    }

    public a(@NonNull d.a.l0.a.y.b.a aVar) {
        a(aVar);
    }

    public static int c(@ColorInt int i2) {
        float f2 = (((-16777216) & i2) >>> 24) / 255.0f;
        return f2 > 0.0f ? Color.argb(255, (int) ((((16711680 & i2) >> 16) * f2) + 0.5d), (int) ((((65280 & i2) >> 8) * f2) + 0.5d), (int) (((i2 & 255) * f2) + 0.5d)) : i2;
    }

    public final void a(@NonNull d.a.l0.a.y.b.a aVar) {
        this.left = aVar.s(CustomDialogData.POS_LEFT, this.left);
        this.top = aVar.s("top", this.top);
        this.width = aVar.s("width", this.width);
        this.height = aVar.s("height", this.height);
        this.backgroundColor = aVar.D("backgroundColor", this.backgroundColor);
        this.borderColor = aVar.D("borderColor", this.borderColor);
        this.borderRadius = aVar.o("borderRadius", this.borderRadius);
        this.borderWidth = aVar.s("borderWidth", this.borderWidth);
        this.fontSize = aVar.o("fontSize", this.fontSize);
        this.lineHeight = aVar.s("lineHeight", this.lineHeight);
        this.textAlign = aVar.D("textAlign", this.textAlign);
        this.fontWeight = aVar.D("fontWeight", this.fontWeight);
        this.hidden = aVar.n("hidden", this.hidden);
        this.opacity = aVar.o("opacity", this.opacity);
        this.color = aVar.D("color", this.color);
        if (k.f46875a) {
            Log.d("ApiButtonStyle", "parseApiButtonStyle = " + toString());
        }
    }

    public void b(InterfaceC1094a interfaceC1094a) {
        this.f51221a = interfaceC1094a;
    }

    @JavascriptInterface
    public void onFieldChangedCallback(String str) {
        if (k.f46875a) {
            Log.d("ApiButtonStyle", "onFieldChangedCallback fieldName=" + str);
        }
        InterfaceC1094a interfaceC1094a = this.f51221a;
        if (interfaceC1094a != null) {
            interfaceC1094a.s();
        }
    }

    public String toString() {
        return "left:" + this.left + ";top:" + this.top + ";width:" + this.width + ";height:" + this.height + ";backgroundColor:" + this.backgroundColor + ";borderColor:" + this.borderColor + ";borderWidth:" + this.borderWidth + ";borderRadius:" + this.borderRadius + ";textAlign:" + this.textAlign + ";fontSize:" + this.fontSize + ";lineHeight:" + this.lineHeight + ";fontWeight:" + this.fontWeight + ";hidden;" + this.hidden + ";opacity:" + this.opacity + ";color:" + this.color;
    }
}
