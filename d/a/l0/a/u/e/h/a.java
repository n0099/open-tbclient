package d.a.l0.a.u.e.h;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.SwanAppActivity;
import d.a.l0.a.a2.e;
import d.a.l0.a.g1.f;
import d.a.l0.a.o0.d.b;
import d.a.l0.a.u.c.d;
import d.a.l0.a.v2.n0;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends d {

    /* renamed from: d  reason: collision with root package name */
    public View f48688d;

    /* renamed from: e  reason: collision with root package name */
    public int f48689e;

    /* renamed from: f  reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f48690f;

    /* renamed from: d.a.l0.a.u.e.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class ViewTreeObserver$OnGlobalLayoutListenerC0906a implements ViewTreeObserver.OnGlobalLayoutListener {
        public ViewTreeObserver$OnGlobalLayoutListenerC0906a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Rect rect = new Rect();
            a.this.f48688d.getWindowVisibleDisplayFrame(rect);
            int height = rect.height();
            if (a.this.f48689e == height) {
                return;
            }
            if (a.this.f48689e - height <= 180) {
                if (height - a.this.f48689e > 180) {
                    if (d.f48486c) {
                        Log.d("Api-GetKeyboardHeight", "onKeyBoardHide: mRootViewVisibleHeight " + a.this.f48689e + " visibleHeight " + height);
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
                    a.this.f48689e = height;
                    return;
                }
                return;
            }
            if (d.f48486c) {
                Log.d("Api-GetKeyboardHeight", "onKeyBoardShow: mRootViewVisibleHeight " + a.this.f48689e + " visibleHeight " + height);
            }
            HashMap hashMap2 = new HashMap();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("height", n0.K(a.this.f48689e - height));
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
            hashMap2.put("data", jSONObject2.toString());
            f.V().v(new b("keyboardHeightChange", hashMap2));
            a.this.f48689e = height;
        }
    }

    public a(@NonNull d.a.l0.a.u.c.b bVar) {
        super(bVar);
    }

    public final void u() {
        SwanAppActivity activity = f.V().getActivity();
        if (activity == null) {
            d.a.l0.a.e0.d.b("Api-GetKeyboardHeight", "activity is null");
            return;
        }
        this.f48688d = activity.getWindow().getDecorView();
        Rect rect = new Rect();
        this.f48688d.getWindowVisibleDisplayFrame(rect);
        this.f48689e = rect.height();
        if (this.f48690f == null) {
            this.f48690f = new ViewTreeObserver$OnGlobalLayoutListenerC0906a();
            this.f48688d.getViewTreeObserver().addOnGlobalLayoutListener(this.f48690f);
        }
    }

    public void v() {
        if (this.f48690f != null) {
            this.f48688d.getViewTreeObserver().removeOnGlobalLayoutListener(this.f48690f);
        }
        this.f48690f = null;
        this.f48689e = 0;
    }

    public d.a.l0.a.u.h.b w() {
        if (d.f48486c) {
            Log.d("Api-GetKeyboardHeight", "handle: ");
        }
        if (e.Q() == null) {
            return new d.a.l0.a.u.h.b(1001, "SwanApp is null");
        }
        u();
        return new d.a.l0.a.u.h.b(0);
    }

    public d.a.l0.a.u.h.b x() {
        if (d.f48486c) {
            Log.d("Api-GetKeyboardHeight", "handle");
        }
        if (e.Q() == null) {
            return new d.a.l0.a.u.h.b(1001, "SwanApp is null");
        }
        v();
        return new d.a.l0.a.u.h.b(0);
    }
}
