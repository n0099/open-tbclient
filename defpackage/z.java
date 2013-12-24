package defpackage;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.cloudsdk.social.share.ui.ShareDialog;
/* renamed from: z  reason: default package */
/* loaded from: classes.dex */
public class z implements View.OnTouchListener {
    final /* synthetic */ GestureDetector a;
    final /* synthetic */ ShareDialog b;

    public z(ShareDialog shareDialog, GestureDetector gestureDetector) {
        this.b = shareDialog;
        this.a = gestureDetector;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return this.a.onTouchEvent(motionEvent);
    }
}
