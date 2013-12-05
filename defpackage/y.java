package defpackage;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.cloudsdk.social.share.ui.ShareDialog;
/* renamed from: y  reason: default package */
/* loaded from: classes.dex */
public class y extends GestureDetector.SimpleOnGestureListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f3157a;
    final /* synthetic */ EditText b;
    final /* synthetic */ ShareDialog c;

    public y(ShareDialog shareDialog, Context context, EditText editText) {
        this.c = shareDialog;
        this.f3157a = context;
        this.b = editText;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (motionEvent2.getY() - motionEvent.getY() <= 100.0f || Math.abs(f2) <= 200.0f) {
            return true;
        }
        ((InputMethodManager) this.f3157a.getSystemService("input_method")).hideSoftInputFromWindow(this.b.getApplicationWindowToken(), 0);
        return true;
    }
}
