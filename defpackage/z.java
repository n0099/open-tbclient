package defpackage;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.cloudsdk.social.share.ui.ShareDialog;
/* renamed from: z  reason: default package */
/* loaded from: classes.dex */
public class z implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ GestureDetector f2945a;
    final /* synthetic */ ShareDialog b;

    public z(ShareDialog shareDialog, GestureDetector gestureDetector) {
        this.b = shareDialog;
        this.f2945a = gestureDetector;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f2945a.onTouchEvent(motionEvent);
    }
}
