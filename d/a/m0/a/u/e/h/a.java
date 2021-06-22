package d.a.m0.a.u.e.h;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.SwanAppActivity;
import d.a.m0.a.a2.e;
import d.a.m0.a.g1.f;
import d.a.m0.a.o0.d.b;
import d.a.m0.a.u.c.d;
import d.a.m0.a.v2.n0;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends d {

    /* renamed from: d  reason: collision with root package name */
    public View f48796d;

    /* renamed from: e  reason: collision with root package name */
    public int f48797e;

    /* renamed from: f  reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f48798f;

    /* renamed from: d.a.m0.a.u.e.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class ViewTreeObserver$OnGlobalLayoutListenerC0909a implements ViewTreeObserver.OnGlobalLayoutListener {
        public ViewTreeObserver$OnGlobalLayoutListenerC0909a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Rect rect = new Rect();
            a.this.f48796d.getWindowVisibleDisplayFrame(rect);
            int height = rect.height();
            if (a.this.f48797e == height) {
                return;
            }
            if (a.this.f48797e - height <= 180) {
                if (height - a.this.f48797e > 180) {
                    if (d.f48594c) {
                        Log.d("Api-GetKeyboardHeight", "onKeyBoardHide: mRootViewVisibleHeight " + a.this.f48797e + " visibleHeight " + height);
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
                    a.this.f48797e = height;
                    return;
                }
                return;
            }
            if (d.f48594c) {
                Log.d("Api-GetKeyboardHeight", "onKeyBoardShow: mRootViewVisibleHeight " + a.this.f48797e + " visibleHeight " + height);
            }
            HashMap hashMap2 = new HashMap();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("height", n0.K(a.this.f48797e - height));
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
            hashMap2.put("data", jSONObject2.toString());
            f.V().v(new b("keyboardHeightChange", hashMap2));
            a.this.f48797e = height;
        }
    }

    public a(@NonNull d.a.m0.a.u.c.b bVar) {
        super(bVar);
    }

    public final void u() {
        SwanAppActivity activity = f.V().getActivity();
        if (activity == null) {
            d.a.m0.a.e0.d.b("Api-GetKeyboardHeight", "activity is null");
            return;
        }
        this.f48796d = activity.getWindow().getDecorView();
        Rect rect = new Rect();
        this.f48796d.getWindowVisibleDisplayFrame(rect);
        this.f48797e = rect.height();
        if (this.f48798f == null) {
            this.f48798f = new ViewTreeObserver$OnGlobalLayoutListenerC0909a();
            this.f48796d.getViewTreeObserver().addOnGlobalLayoutListener(this.f48798f);
        }
    }

    public void v() {
        if (this.f48798f != null) {
            this.f48796d.getViewTreeObserver().removeOnGlobalLayoutListener(this.f48798f);
        }
        this.f48798f = null;
        this.f48797e = 0;
    }

    public d.a.m0.a.u.h.b w() {
        if (d.f48594c) {
            Log.d("Api-GetKeyboardHeight", "handle: ");
        }
        if (e.Q() == null) {
            return new d.a.m0.a.u.h.b(1001, "SwanApp is null");
        }
        u();
        return new d.a.m0.a.u.h.b(0);
    }

    public d.a.m0.a.u.h.b x() {
        if (d.f48594c) {
            Log.d("Api-GetKeyboardHeight", "handle");
        }
        if (e.Q() == null) {
            return new d.a.m0.a.u.h.b(1001, "SwanApp is null");
        }
        v();
        return new d.a.m0.a.u.h.b(0);
    }
}
