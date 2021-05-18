package d.a.i0.a.u.e.h;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.SwanAppActivity;
import d.a.i0.a.a2.e;
import d.a.i0.a.g1.f;
import d.a.i0.a.o0.d.b;
import d.a.i0.a.u.c.d;
import d.a.i0.a.v2.n0;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends d {

    /* renamed from: d  reason: collision with root package name */
    public View f44838d;

    /* renamed from: e  reason: collision with root package name */
    public int f44839e;

    /* renamed from: f  reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f44840f;

    /* renamed from: d.a.i0.a.u.e.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class ViewTreeObserver$OnGlobalLayoutListenerC0839a implements ViewTreeObserver.OnGlobalLayoutListener {
        public ViewTreeObserver$OnGlobalLayoutListenerC0839a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Rect rect = new Rect();
            a.this.f44838d.getWindowVisibleDisplayFrame(rect);
            int height = rect.height();
            if (a.this.f44839e == height) {
                return;
            }
            if (a.this.f44839e - height <= 180) {
                if (height - a.this.f44839e > 180) {
                    if (d.f44636c) {
                        Log.d("Api-GetKeyboardHeight", "onKeyBoardHide: mRootViewVisibleHeight " + a.this.f44839e + " visibleHeight " + height);
                    }
                    HashMap hashMap = new HashMap();
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("height", 0);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    hashMap.put("data", jSONObject.toString());
                    f.V().v(new b("keyboardHeightChange", hashMap));
                    a.this.f44839e = height;
                    return;
                }
                return;
            }
            if (d.f44636c) {
                Log.d("Api-GetKeyboardHeight", "onKeyBoardShow: mRootViewVisibleHeight " + a.this.f44839e + " visibleHeight " + height);
            }
            HashMap hashMap2 = new HashMap();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("height", n0.K(a.this.f44839e - height));
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
            hashMap2.put("data", jSONObject2.toString());
            f.V().v(new b("keyboardHeightChange", hashMap2));
            a.this.f44839e = height;
        }
    }

    public a(@NonNull d.a.i0.a.u.c.b bVar) {
        super(bVar);
    }

    public final void u() {
        SwanAppActivity activity = f.V().getActivity();
        if (activity == null) {
            d.a.i0.a.e0.d.b("Api-GetKeyboardHeight", "activity is null");
            return;
        }
        this.f44838d = activity.getWindow().getDecorView();
        Rect rect = new Rect();
        this.f44838d.getWindowVisibleDisplayFrame(rect);
        this.f44839e = rect.height();
        if (this.f44840f == null) {
            this.f44840f = new ViewTreeObserver$OnGlobalLayoutListenerC0839a();
            this.f44838d.getViewTreeObserver().addOnGlobalLayoutListener(this.f44840f);
        }
    }

    public void v() {
        if (this.f44840f != null) {
            this.f44838d.getViewTreeObserver().removeOnGlobalLayoutListener(this.f44840f);
        }
        this.f44840f = null;
        this.f44839e = 0;
    }

    public d.a.i0.a.u.h.b w() {
        if (d.f44636c) {
            Log.d("Api-GetKeyboardHeight", "handle: ");
        }
        if (e.Q() == null) {
            return new d.a.i0.a.u.h.b(1001, "SwanApp is null");
        }
        u();
        return new d.a.i0.a.u.h.b(0);
    }

    public d.a.i0.a.u.h.b x() {
        if (d.f44636c) {
            Log.d("Api-GetKeyboardHeight", "handle");
        }
        if (e.Q() == null) {
            return new d.a.i0.a.u.h.b(1001, "SwanApp is null");
        }
        v();
        return new d.a.i0.a.u.h.b(0);
    }
}
