package i.a.a.e.h.a;

import android.database.ContentObserver;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import java.util.HashMap;
import java.util.Map;
import tv.athena.revenue.payui.activity.immersion.BarHide;
/* loaded from: classes7.dex */
public class b implements Cloneable {
    public e C;
    public g D;
    public ContentObserver E;
    public View s;
    public View t;
    public View u;
    @ColorInt
    public int v;
    @ColorInt

    /* renamed from: e  reason: collision with root package name */
    public int f68076e = 0;
    @ColorInt

    /* renamed from: f  reason: collision with root package name */
    public int f68077f = -16777216;
    @FloatRange(from = 0.0d, to = 1.0d)

    /* renamed from: g  reason: collision with root package name */
    public float f68078g = 0.0f;
    @FloatRange(from = 0.0d, to = 1.0d)

    /* renamed from: h  reason: collision with root package name */
    public float f68079h = 0.0f;

    /* renamed from: i  reason: collision with root package name */
    public boolean f68080i = false;
    public boolean j = false;
    public BarHide k = BarHide.FLAG_SHOW_BAR;
    public boolean l = false;
    public boolean m = true;
    @ColorInt
    public int n = -16777216;
    @ColorInt
    public int o = -16777216;
    public Map<View, Map<Integer, Integer>> p = new HashMap();
    @FloatRange(from = 0.0d, to = 1.0d)
    public float q = 0.0f;
    public boolean r = false;
    public boolean w = false;
    public boolean x = false;
    public int y = 18;
    public boolean z = true;
    public boolean A = true;
    public boolean B = false;

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: b */
    public b clone() {
        try {
            return (b) super.clone();
        } catch (CloneNotSupportedException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
