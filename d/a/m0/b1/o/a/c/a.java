package d.a.m0.b1.o.a.c;

import android.content.Context;
import android.graphics.Typeface;
import android.view.ViewGroup;
import com.baidu.spswitch.utils.BDEmotionPanelManager;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import com.baidu.tieba.R;
import d.a.m0.b1.o.a.d.d;
import d.a.m0.b1.o.a.d.e;
import java.util.Calendar;
/* loaded from: classes3.dex */
public class a {
    public Context A;
    public String B;
    public String C;
    public String D;
    public boolean R;
    public WheelView.DividerType U;

    /* renamed from: a  reason: collision with root package name */
    public e f52818a;

    /* renamed from: b  reason: collision with root package name */
    public d f52819b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.m0.b1.o.a.d.a f52820c;

    /* renamed from: e  reason: collision with root package name */
    public Calendar f52822e;

    /* renamed from: f  reason: collision with root package name */
    public Calendar f52823f;

    /* renamed from: g  reason: collision with root package name */
    public Calendar f52824g;

    /* renamed from: h  reason: collision with root package name */
    public int f52825h;

    /* renamed from: i  reason: collision with root package name */
    public int f52826i;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;
    public int w;
    public int x;
    public ViewGroup y;

    /* renamed from: d  reason: collision with root package name */
    public boolean[] f52821d = {true, true, true, false, false, false};
    public boolean j = false;
    public boolean k = false;
    public int z = 17;
    public int E = -16417281;
    public int F = -16417281;
    public int G = -16777216;
    public int H = -1;
    public int I = BDEmotionPanelManager.COLOR_EMOTION_TYPE_LAYOUT;
    public int J = 17;
    public int K = 18;
    public int L = 18;
    public int M = -5723992;
    public int N = -14013910;
    public int O = -2763307;
    public int P = -1;
    public float Q = 1.6f;
    public boolean S = true;
    public boolean T = false;

    public a(int i2) {
        Typeface typeface = Typeface.MONOSPACE;
        this.U = WheelView.DividerType.FILL;
        if (i2 == 1) {
            this.x = R.layout.pickerview_options;
        } else {
            this.x = R.layout.pickerview_time;
        }
    }
}
