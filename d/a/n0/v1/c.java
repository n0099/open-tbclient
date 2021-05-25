package d.a.n0.v1;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import android.text.TextUtils;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f62290a;

    /* renamed from: b  reason: collision with root package name */
    public Context f62291b;

    /* renamed from: c  reason: collision with root package name */
    public HandlerThread f62292c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f62293d;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f62294e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f62295f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f62296g;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f62297h;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f62294e != null) {
                ((WindowManager) c.this.f62291b.getSystemService("window")).removeViewImmediate(c.this.f62294e);
                c.this.e();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar = c.this;
            cVar.k(cVar.f62291b.getString(R.string.data_init));
        }
    }

    /* renamed from: d.a.n0.v1.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1687c {
        c getSplash();
    }

    /* loaded from: classes3.dex */
    public class d extends TextView {

        /* renamed from: e  reason: collision with root package name */
        public LinearGradient f62300e;

        /* renamed from: f  reason: collision with root package name */
        public Matrix f62301f;

        /* renamed from: g  reason: collision with root package name */
        public Paint f62302g;

        /* renamed from: h  reason: collision with root package name */
        public int f62303h;

        /* renamed from: i  reason: collision with root package name */
        public int f62304i;
        public boolean j;

        public d(c cVar, Context context) {
            super(context);
            this.f62303h = 0;
            this.f62304i = 0;
            this.j = true;
        }

        @Override // android.widget.TextView, android.view.View
        public void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            if (!this.j || this.f62301f == null) {
                return;
            }
            int i2 = this.f62304i;
            int i3 = this.f62303h;
            int i4 = i2 + (i3 / 10);
            this.f62304i = i4;
            if (i4 > i3 * 2) {
                this.f62304i = -i3;
            }
            this.f62301f.setTranslate(this.f62304i, 0.0f);
            this.f62300e.setLocalMatrix(this.f62301f);
            postInvalidateDelayed(50L);
        }

        @Override // android.view.View
        public void onSizeChanged(int i2, int i3, int i4, int i5) {
            super.onSizeChanged(i2, i3, i4, i5);
            if (this.f62303h == 0) {
                int measuredWidth = getMeasuredWidth();
                this.f62303h = measuredWidth;
                if (measuredWidth > 0) {
                    this.f62302g = getPaint();
                    LinearGradient linearGradient = new LinearGradient(-this.f62303h, 0.0f, 0.0f, 0.0f, new int[]{1610612736, Integer.MAX_VALUE, 1610612736}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP);
                    this.f62300e = linearGradient;
                    this.f62302g.setShader(linearGradient);
                    this.f62301f = new Matrix();
                }
            }
        }
    }

    public c(Context context) {
        this.f62291b = context;
    }

    public final void e() {
        Handler handler = this.f62293d;
        if (handler != null) {
            handler.removeCallbacks(this.f62296g);
            this.f62293d.removeCallbacks(this.f62297h);
            this.f62297h = null;
            this.f62296g = null;
            this.f62293d = null;
        }
        HandlerThread handlerThread = this.f62292c;
        if (handlerThread != null) {
            handlerThread.quit();
        }
        if (this.f62295f != null) {
            this.f62295f = null;
        }
        if (this.f62294e != null) {
            this.f62294e = null;
        }
        this.f62290a = false;
    }

    public final List<String> f(Context context) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent("com.baidu.tieba.SPLASH_PIPELINE_ACTION");
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 64);
        ArrayList arrayList = new ArrayList();
        if (queryIntentActivities != null && queryIntentActivities.size() > 0) {
            String packageName = context.getPackageName();
            for (ResolveInfo resolveInfo : queryIntentActivities) {
                String str = resolveInfo.activityInfo.name;
                arrayList.add(StringUtil.ARRAY_START + packageName + "/" + str + "}");
            }
        }
        return arrayList;
    }

    public void g() {
        if (this.f62294e == null || this.f62295f == null) {
            return;
        }
        this.f62293d.removeCallbacks(this.f62296g);
        this.f62293d.post(this.f62296g);
    }

    public final boolean h() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        ActivityManager activityManager = (ActivityManager) this.f62291b.getSystemService("activity");
        if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
            return false;
        }
        String packageName = this.f62291b.getPackageName();
        int myPid = Process.myPid();
        for (int i2 = 0; i2 < runningAppProcesses.size(); i2++) {
            if (runningAppProcesses.get(i2).pid == myPid && TextUtils.equals(runningAppProcesses.get(i2).processName, packageName)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean i() {
        List<String> f2 = f(this.f62291b);
        if (f2 != null && f2.size() != 0) {
            ActivityManager.RunningTaskInfo runningTaskInfo = ((ActivityManager) this.f62291b.getSystemService("activity")).getRunningTasks(1).get(0);
            String shortString = runningTaskInfo.baseActivity.toShortString();
            String shortString2 = runningTaskInfo.topActivity.toShortString();
            for (String str : f2) {
                if (shortString.equals(str) || shortString2.equals(str)) {
                    return true;
                }
                while (r0.hasNext()) {
                }
            }
        }
        return false;
    }

    public void j() {
        if (!this.f62290a && h() && i()) {
            if (this.f62292c == null) {
                HandlerThread handlerThread = new HandlerThread("splash-thread");
                this.f62292c = handlerThread;
                handlerThread.start();
            }
            if (this.f62293d == null) {
                this.f62293d = new Handler(this.f62292c.getLooper());
            }
            if (this.f62296g == null) {
                this.f62296g = new a();
            }
            if (this.f62297h == null) {
                this.f62297h = new b();
            }
            this.f62293d.removeCallbacks(this.f62297h);
            this.f62293d.postAtFrontOfQueue(this.f62297h);
            this.f62290a = true;
            this.f62293d.postDelayed(this.f62296g, 20000L);
        }
    }

    public final void k(String str) {
        if (this.f62295f == null) {
            d dVar = new d(this, this.f62291b);
            this.f62295f = dVar;
            dVar.setTextSize(1, 18.0f);
        }
        this.f62295f.setText(str);
        RelativeLayout relativeLayout = new RelativeLayout(this.f62291b);
        this.f62294e = relativeLayout;
        relativeLayout.setBackgroundResource(R.drawable.pic_splash_logo);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(15);
        this.f62294e.addView(this.f62295f, layoutParams);
        WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams();
        layoutParams2.type = 2005;
        layoutParams2.format = 1;
        layoutParams2.gravity = 17;
        layoutParams2.x = 0;
        layoutParams2.y = 0;
        layoutParams2.width = -1;
        layoutParams2.height = -1;
        layoutParams2.flags = 1280;
        ((WindowManager) this.f62291b.getSystemService("window")).addView(this.f62294e, layoutParams2);
    }
}
